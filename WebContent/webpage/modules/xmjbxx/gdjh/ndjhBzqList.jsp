<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>项目基本信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            laydate.render({
                elem: '#startTimeN', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
                type: 'year',
                range: '~',
                done:function(value, date, endDate){
                    //点击清空时，清除隐藏域的值
                    if(null == value || '' == value){
                        $("#startTimeN").val("");
                        $("#startTimeNStart").val("");
                        $("#startTimeNEnd").val("");
                    } else {
                        $("#startTimeNStart").val(date.year);
                        $("#startTimeNEnd").val(endDate.year);
                    }
                }
            });

            laydate.render({
                elem: '#endTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
                type: 'year',
                range: '~',
                done:function(value, date, endDate){
                    //点击清空时，清除隐藏域的值
                    if(null == value || '' == value){
                        $("#endTime").val("");
                        $("#endTimeStart").val("");
                        $("#endTimeEnd").val("");
                    } else {
                        $("#endTimeStart").val(date.year);
                        $("#endTimeEnd").val(endDate.year);
                    }
                }
            });
		});

        function txxm() {
            top.layer.open({
                type: 2,
                area: ['800px', '500px'],
                title: '从本级滚动计划库挑选项目',
                maxmin: true, //开启最大化最小化按钮
                content: '${ctx}/xmjbxx/xmjbxx/selectNdjhbsForm' ,
                btn: ['确定', '关闭'],
                yes: function(index, layero){
                    var body = top.layer.getChildFrame('body', index);
                    var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
                    var inputForm = body.find('#inputForm');
                    var top_iframe;
                    top_iframe = top.getActiveTab().attr("name");//获取当前active的tab的iframe
                    inputForm.attr("target",top_iframe);//表单提交成功后，从服务器返回的url在当前tab中展示

                    iframeWin.contentWindow.doSubmit(function(){
                        top.layer.close(index);
                        sortOrRefresh();
                    });
                },
                cancel: function(index){
                }
            });
        }

        function pushToBaoSong() {
            var size = $("#contentTable tbody tr td input.i-checks:checked").size();
            if(size == 0 ){
                top.layer.alert('请至少选择一条数据!', {icon: 0, title:'警告'});
                return;
            }

            if(size > 1 ){
                top.layer.alert('只能选择一条数据!', {icon: 0, title:'警告'});
                return;
            }

            top.layer.confirm('确认要推送至待报区吗?', {icon: 3, title: '系统提示'}, function (index) {
                top.layer.close(index);
                var item = $("#contentTable tbody tr td input.i-checks:checked")[0];
                var attrShfzbsOne = $(item).attr("attrShfzbsOne");
                var attrShfzbsTwo = $(item).attr("attrShfzbsTwo");
                var attrShfzbsThree = $(item).attr("attrShfzbsThree");
                $("#shfzbsOne").val(attrShfzbsOne).text(attrShfzbsOne);
                $("#shfzbsTwo").val(attrShfzbsTwo).text(attrShfzbsTwo);
                $("#shfzbsThree").val(attrShfzbsThree).text(attrShfzbsThree);

                top.layer.open({
                    type: 1,
                    area: ["500px", "400px"],
                    title:"推送至报送区",
                    content:$("#selectFormDiv").html() ,
                    btn: ['确定', '关闭'],
                    btn1: function(index){
                        top.$("#wjbt_id").val($(item).attr("id"));

						var value = "";
                        var type = top.$("input:radio[name='type']:checked").val()
                        if ("old" == type) {
                            value = top.$("#wjbt_select").val();
                            if (null == value || '' == value) {
                                top.layer.alert("请选择文件标题！");
                                return false;
                            }
                        } else if ("new" == type) {
                            value = top.$("#wjbt_input").val();
                            if (null == value || '' == value) {
                                top.layer.alert("请输入文件标题！");
                                return false;
                            }
                        } else {
                            top.layer.alert("请选择文件标题类型！");
                            return false;
                        }
                        top.$("#wjbt").val(value);

                        top.$("#selectForm").attr("target",top.getActiveTab().attr("name"));
                        top.$("#selectForm").submit();
                        top.layer.close(index);
                    },

                    btn2: function(index){
                        top.layer.close(index);
                    }
                });

            });
        }
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox ibox-custom">
	<div class="ibox-title">
		<h5>编制区</h5>
		<div class="ibox-tools">
		</div>
	</div>
    
    <div class="ibox-content">
	<sys:message content="${message}"/>
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="deptRelationSearchParameter" action="${ctx}/xmjbxx/xmjbxx/ndjhBzqList" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<input id="moreSearch" name="moreSearch" type="hidden" value="${deptRelationSearchParameter.moreSearch}"/><!-- 是否展开更多查询 -->
		<div class="form-group">
		<div class="form-group right10">
			<span class="left10">项目名称：</span>
			<form:input path="xmjbxx.xmmc" htmlEscape="false" maxlength="200"  class=" form-control input-sm"/>
		</div>
		<div class="form-group right10">
			<span class="left10">项目类型：</span>
			<form:select path="xmjbxx.xmlx" class="form-control">
				<form:option value="" label="全部" />
				<form:options items="${fns:getDictList('xmlx')}" itemLabel="label" itemValue="value" htmlEscape="false" />
			</form:select>
		</div>
		<div class="form-group right10">
			<span class="left10">所属行业：</span>
			<sys:treeselect id="sshy" name="xmjbxx.sshy" value="${deptRelationSearchParameter.xmjbxx.sshy}" labelName="sshyStr"  notAllowSelectParent="true"
							labelValue="${fns:getTreeDictValue(deptRelationSearchParameter.xmjbxx.sshy)}" title="所属行业" url="/sys/treeDict/treeData?type=sshy"
							cssClass="form-control" />
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span class="left10">建设地点：</span>
			<sys:treeselect id="jsdd" name="xmjbxx.jsdd" value="${deptRelationSearchParameter.xmjbxx.jsdd}" labelName="jsddStr"
							labelValue="${fns:getTreeName(deptRelationSearchParameter.xmjbxx.jsdd,'area')}"
							title="建设地点" url="/sys/area/treeData" cssClass="form-control m-s" allowClear="true"/>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span class="left10">专项类别：</span>
			<sys:treeselect id="zxlb" name="xmjbxx.zxlb" value="${deptRelationSearchParameter.xmjbxx.zxlb}" labelName="zxlbStr"  notAllowSelectParent="true"
							labelValue="${fns:getTreeDictValue(deptRelationSearchParameter.xmjbxx.zxlb)}" title="专项类别" url="/sys/treeDict/treeData?type=zxlb" extId=""
							cssClass="form-control" />
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span class="left10">总投资（万元）：</span>
			<input id="ztzMin" name="ztzMin" onchange="compareExchange('ztzMin','ztzMax')" type="number" class="number form-control" value="${deptRelationSearchParameter.ztzMin}" style="width:120px;"/> -
			<input id="ztzMax" name="ztzMax" onchange="compareExchange('ztzMin','ztzMax')" type="number" class="form-control number" value="${deptRelationSearchParameter.ztzMax}" style="width:120px;"/>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span class="left10">拟开工年份：</span>
			<input type="hidden" name="xmjbxxSearchParameter.startTimeNStart" id="startTimeNStart" value="${deptRelationSearchParameter.xmjbxxSearchParameter.startTimeNStart}">
			<input type="hidden" name="xmjbxxSearchParameter.startTimeNEnd" id="startTimeNEnd" value="${deptRelationSearchParameter.xmjbxxSearchParameter.startTimeNEnd}">
			<input id="startTimeN" name="deptRelationSearchParameter.startTimeN" type="text" class="laydate-icon-img form-control layer-date input-sm"
				   value="${deptRelationSearchParameter.xmjbxxSearchParameter.startTimeNBT}" style="width:220px;"/>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span class="left10">拟建成年份：</span>
			<input type="hidden" name="xmjbxxSearchParameter.endTimeStart" id="endTimeStart" value="${deptRelationSearchParameter.xmjbxxSearchParameter.endTimeStart}">
			<input type="hidden" name="xmjbxxSearchParameter.endTimeEnd" id="endTimeEnd" value="${deptRelationSearchParameter.xmjbxxSearchParameter.endTimeEnd}">
			<input id="endTime" name="endTime" type="text" class="laydate-icon-img form-control layer-date input-sm"
				   value="${deptRelationSearchParameter.xmjbxxSearchParameter.endTimeBT}" style="width:220px;"/>
		</div>
		</div>
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			<button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="left" onclick="txxm()" title="从本级滚动计划库挑选项目"><i class="fa fa-plus"></i>从本级滚动计划库挑选项目</button>
			<button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" onclick="pushToBaoSong()" title="推送至报送区"><i class="fa fa-pencil-square-o"> 推送至报送区</i></button>
			<table:delRowWithCheckFunc url="${ctx}/xmjbxx/xmjbxx/ndjhbsBzqDelete" func="checkDelete" id="contentTable"></table:delRowWithCheckFunc>
			<button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button>
		</div>
		<div class="pull-right">
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()" ><i class="fa fa-search"></i> 查询</button>
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()" ><i class="fa fa-refresh"></i> 重置</button>
		<a class="btn btn-primary btn-rounded btn-outline btn-sm collapse-custom-link"><i class="fa fa-chevron-down"></i><span
                                name="button-text">更多</span></a>
		</div>
	</div>
	</div>

	<!-- 表格 -->
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
		<tr>
			<th> <input type="checkbox" class="i-checks"></th>
			<th  class="sort-column zdkbmgj">重大库编码</th>
			<th  class="sort-column xmmc">项目名称</th>
			<th >项目类型</th>
			<th >所属行业</th>
			<th >建设地点</th>
			<th >总投资</th>
			<th >拟开工年份</th>
			<th >拟成建年份</th>
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="deptRelation">
			<c:set var="xmjbxx" value="${deptRelation.xmjbxx}"/>
			<tr>
				<td> <input type="checkbox" id="${xmjbxx.id}" attrShfzbsOne="${xmjbxx.shfzbsone}" attrShfzbsTwo="${xmjbxx.shfzbstwo}"
							attrShfzbsThree="${xmjbxx.shfzbsthree}" class="i-checks"></td>
				<td>
				    <a href="#" onclick="openXmjbxxView('查看项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${xmjbxx.id}','1000px', '700px')">
						${xmjbxx.zdkbmgj}
					 </a>
				</td>
				<td>
						${fns:ellipsisText(xmjbxx.xmmc, 35)}
				</td>
				<td> 
				        ${fns:getDictLabel(xmjbxx.xmlx, 'xmlx', '')}
				</td>
				<td>
						${fns:getTreeDictValue(xmjbxx.sshy)}
				</td>
				<td>
						${fns:getTreeName(xmjbxx.jsdd, 'area')}
				</td>
				<td align="right">
						${xmjbxx.ztz}
				</td>
				<td>${xmjbxx.starttimen}</td>
				<td>${xmjbxx.endtime}</td>
				<td>
					<shiro:hasPermission name="xmjbxx:xmjbxx:view">
						<a href="#" onclick="openXmjbxxView('查看项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${xmjbxx.id}','1000px', '700px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<%--<shiro:hasPermission name="xmjbxx:xmjbxx:edit">--%>
						<%--<a href="#" onclick="openDialog('修改项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${xmjbxx.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>--%>
					<%--</shiro:hasPermission>--%>
					<%--<shiro:hasPermission name="xmjbxx:xmjbxx:del">--%>
						<%--<a href="${ctx}/xmjbxx/xmjbxx/delete?id=${xmjbxx.id}" onclick="return confirmx('确认要删除该项目基本信息吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>--%>
					<%--</shiro:hasPermission>--%>
				</td>
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


		<%--推送至待报区弹框--%>
		<div id="selectFormDiv" style="display:none;">
			<form id="selectForm" action="${ctx}/xmjbxx/xmjbxx/pushToNdjhBsq" method="post">
				<input type="hidden" id="wjbt_id" name="id" value=""/>
				<input type="hidden" id="wjbt" name="wjbt" value="">
			</form>

			<div class="form-inline" style="margin: 10px 30px 0 30px;">
				<span style="font-size: 14px;"><input name="type" value="old" type="radio" checked>&nbsp;使用已有文件标题：</span>
				<select id="wjbt_select" name="wjbt" class="form-control">
					<option id="shfzbsOne" value=""></option>
					<option id="shfzbsTwo" value=""></option>
					<option id="shfzbsThree" value=""></option>
				</select>
			</div>
			<br/>
			<div class="form-inline" style="margin: 10px 30px 0 30px;">
				<span style="font-size: 14px;"><input name="type" value="new" type="radio">&nbsp;添加新标题：</span>
				<input id="wjbt_input" name="wjbt" class="form-control">
			</div>
		</div>

</div>
</body>
</html>