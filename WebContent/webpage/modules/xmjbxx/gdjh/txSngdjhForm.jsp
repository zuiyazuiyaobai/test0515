<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp" %>
<html>
<head>
    <title>从储备库挑选项目</title>
    <meta name="decorator" content="default"/>
    <script src="${ctxStatic}/module/alert/jquery.alerts.js"></script>
    <link href="${ctxStatic}/module/alert/jquery.alerts.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#contentTable thead tr th input.i-checks').on('ifChecked', function (event) { //ifCreated 事件应该在插件初始化之前绑定
                $('#contentTable tbody tr td input.i-checks').iCheck('check');
            });

            $('#contentTable thead tr th input.i-checks').on('ifUnchecked', function (event) { //ifCreated 事件应该在插件初始化之前绑定
                $('#contentTable tbody tr td input.i-checks').iCheck('uncheck');
            });
             
        });
        function doSubmit(func) {//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
            var str = "";
            var ids = "";
            $("#contentTable tbody tr td input.i-checks:checkbox").each(function () {
                if (true == $(this).is(':checked')) {
                    str += $(this).attr("id") + ",";
                }
            });
            if (str.substr(str.length - 1) == ',') {
                ids = str.substr(0, str.length - 1);
            }
            if (ids == "") {
                top.layer.alert('请至少选择一条数据!', {icon: 0, title: '警告'});
                return false;
            }
            debugger;
        	xzrwlx(ids,func);        
        }
        function xzrwlx(ids,func){debugger;
            var infoBaHtml="";
            var yhcj=$("#yhcj")[0].value;
            if(yhcj=="3"){
            	infoBaHtml += "<div style='padding-top:25px;padding-left:15px;padding-bottom:15px;padding-right:15px;'><table border='1' cellpadding='0' cellspacing='0' width='98%' border='1' style='margin:15 5 0 5;table-layout:fixed;border-collapse:collapse;border:1px solid #dee4e8;'>";
				infoBaHtml += "<tr><td style='width:70px;height:40px;'>任务类型:</td>";
            	infoBaHtml += "<td><select id='rwlx' style='width:280px;height:30px;'>";
                infoBaHtml += "<option value='2'>2018年省重点项目调度</option>";
                infoBaHtml += "<option value='4'>2018年省基建项目调度</option>";
                infoBaHtml += "<option value='5'>5818项目调度</option>";
                infoBaHtml += "<option value='7'>省节能减排专项资金调度</option>";
                infoBaHtml += "<option value='8'>京豫南北水调对口协作调度</option>";
                infoBaHtml += "<option value='9'>服务业重点项目调度</option>";
                infoBaHtml += "<option value='10'>省转型发展攻坚项目</option>";
                infoBaHtml += "<option value='11'>省先进制造重大项目</option>";
                infoBaHtml += "<option value='12'>2018年交通基础设施省补助资金项目</option>";
                infoBaHtml += "<option value='6'>其他项目调度</option></select>";
				infoBaHtml += "</td></tr></table></div>";
            	layer.open({
					type: 1,
					title: ['请选择报送类别', 'font-size:17px;color:#09F;'],
					shadeClose: false,
					closeBtn: 1,
					scrollbar: false,
					btn: ['确定', '关闭'],
					area : ['400px','180px'],
					content: infoBaHtml,
					yes: function(index, layero){
						var rwlx = $("#rwlx")[0].value;
						 $.post('${ctx}/xmjbxx/xmjbxx/saverwlx', {ids: ids,rwlx:rwlx}, function (result) {
		                    if (result) {
                				$.post('${ctx}${saveUrl}', {ids: ids}, function (result) {
					                if (result.success) {
					                	if(result.msg =="挑选成功！"){
					                		top.layer.alert("请求成功！");
					                        showTipTop(result.msg);
											func();
					                	}    
					                } else if (!result.success) {
					                    top.layer.alert(result.msg);
					                } else {
					                    top.layer.alert("请求失败！");
					                }
					            }); 
		                     } else if (!result.success) {
		                        top.layer.alert(result.msg);
		                    } else {
		                        top.layer.alert("请求失败！");
		                    }
		                });
					}
			    });
            }else{
	        	$.post('${ctx}${saveUrl}', {ids: ids}, function (result) {
	                if (result.success) {
	                	if(result.msg =="挑选成功！"){
	                		top.layer.alert("请求成功！");
	                        showTipTop(result.msg);
							func();
	                	}    
	                } else if (!result.success) {
	                    top.layer.alert(result.msg);
	                } else {
	                    top.layer.alert("请求失败！");
	                }
	            });
	        }
        }
    </script>
</head>
<body class="gray-bg">
<div class="ibox ibox-custom">
    <div class="ibox-content">
        <sys:message content="${message}"/>

        <!--查询条件-->
        <div class="row">
            <div class="col-sm-12">
                <form:form id="searchForm" modelAttribute="deptRelationSearchParameter" action="${ctx}${searchUrl}" method="post" class="form-inline">
                    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
                    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>

                    <%-- 接收 Controller 传过来的值，页面刷新时传回 Controller --%>
                    <c:forEach items="${signMap}" var="sign">
                        <input name="${sign.key}" value="${sign.value}" type="hidden"/>
                    </c:forEach>

                    <table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
                    <input id="moreSearch" name="moreSearch" type="hidden" value="${deptRelationSearchParameter.moreSearch}"/><!-- 是否展开更多查询 -->

                    <div class="form-group">
                        <div class="form-group right10">
                            <span class="left10">项目名称：</span>
                            <form:input path="xmjbxx.xmmc" htmlEscape="false" maxlength="200" class=" form-control input-sm"/>
                        </div>
                        <div class="form-group right10">
                            <span class="left10">来源单位：</span>
                            <form:input path="xmjbxx.xmfrdw" htmlEscape="false" maxlength="200" class=" form-control input-sm"/>
                        </div>
                        <div class="form-group right10 ibox-custom-content ibox-custom-content-hide">
                            <span class="left10">所属行业：</span>
                            <sys:treeselect id="sshy" name="xmjbxx.sshy" value="${deptRelationSearchParameter.xmjbxx.sshy}" labelName="sshyStr"
                                            notAllowSelectParent="true"
                                            labelValue="${fns:getTreeDictValue(deptRelationSearchParameter.xmjbxx.sshy)}" title="所属行业"
                                            url="/sys/treeDict/treeData?type=sshy"
                                            cssClass="form-control"/>
                        </div>
                        <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                            <span class="left10">建设地点：</span>
                            <sys:treeselect id="jsdd" name="xmjbxx.jsdd" value="${deptRelationSearchParameter.xmjbxx.jsdd}" labelName="jsddStr"
                                            labelValue="${fns:getTreeName(deptRelationSearchParameter.xmjbxx.jsdd,'area')}"
                                            title="建设地点" url="/sys/area/treeData" cssClass="form-control m-s" allowClear="true"/>
                        </div>
                        <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                            <span class="left10">审核辅助标志01：</span>
                            <form:input path="xmjbxx.shfzbsone" htmlEscape="false" maxlength="200" class=" form-control input-sm"/>
                        </div>
                        <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                            <span class="left10">审核辅助标志02：</span>
                            <form:input path="xmjbxx.shfzbstwo" htmlEscape="false" maxlength="200" class=" form-control input-sm"/>
                        </div>
                        <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                            <span class="left10">审核辅助标志03：</span>
                            <form:input path="xmjbxx.shfzbsthree" htmlEscape="false" maxlength="200" class=" form-control input-sm"/>
                        </div>
                        <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                            <span class="left10">专项类别：</span>
                            <sys:treeselect id="zxlb" name="xmjbxx.zxlb" value="${deptRelationSearchParameter.xmjbxx.zxlb}" labelName="zxlbStr"
                                            notAllowSelectParent="true"
                                            labelValue="${fns:getTreeDictValue(deptRelationSearchParameter.xmjbxx.zxlb)}" title="专项类别"
                                            url="/sys/treeDict/treeData?type=zxlb" extId=""
                                            cssClass="form-control"/>
                        </div>
                    </div>
                </form:form>
                <br/>
            </div>
        </div>


        <!-- 工具栏 -->
        <div class="row">
            <div class="col-sm-12">
                <div class="pull-right">
                    <button class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()"><i class="fa fa-search"></i> 查询</button>
                    <button class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()"><i class="fa fa-refresh"></i> 重置</button>
                    <a class="btn btn-primary btn-rounded btn-outline btn-sm collapse-custom-link"><i class="fa fa-chevron-down"></i><span
                            name="button-text">更多</span></a>
                </div>
            </div>
        </div>
        <!-- 表格 -->
        <table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
            <thead>
            <tr>
                <th><input type="checkbox" class="i-checks"></th>
                <th class="sort-column zdkbmgj">重大库编码</th>
                <th class="sort-column xmmc">项目名称</th>
                <th class="sort-column create_Date">创建时间</th>
            </tr>
            </thead>
            <tbody>
              <input id="yhcj" type="hidden" value="${yhcj}" />
            <c:forEach items="${page.list}" var="xmjbxxDeptRelation">
                <c:set var="xmjbxx" value="${xmjbxxDeptRelation.xmjbxx}"/>
                <tr>
                    <td><input type="checkbox"  id="${xmjbxx.id}" xmjbxxDeptRelationId="${xmjbxxDeptRelation.id}" name="rwlx" value="${xmjbxx.cj}" class="i-checks">
                      </td>
                    <!-- <td></td> -->
                    <td><a href="#" onclick="openDialogView('查看项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${xmjbxx.id}','800px', '500px')">
                            ${xmjbxx.zdkbmgj}</a></td>
                    <td title="${xmjbxx.xmmc}">${fns:ellipsisText(xmjbxx.xmmc,45)}</td>
                    <td><fmt:formatDate value="${xmjbxx.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <!-- 分页代码 -->
        <table:page page="${page}"></table:page>
        <br/>
        <br/>
    </div>
</div>
</body>
</html>