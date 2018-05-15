<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>项目基本信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            laydate.render({
                elem: '#bsDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
                range: '~',
                change: function(value, date, endDate) {
                    $("#bsDateStart").val(date.year + '-' + date.month + '-' + date.date);
                    $("#bsDateEnd").val(endDate.year + '-' + endDate.month + '-' + endDate.date);
                },
                done:function(value){
                    //点击清空时，清除隐藏域的值
                    if(null == value || '' == value){
                        $("#bsDate").val("");
                        $("#bsDateStart").val("");
                        $("#bsDateEnd").val("");
                    }
                }
            });
		});

        function bgwh() {
            var size = $("#contentTable tbody tr td input.i-checks:checked").size();
            if(size == 0 ){
                top.layer.alert('请至少选择一条数据!', {icon: 0, title:'警告'});
                return;
            }

            if(size > 1 ){
                top.layer.alert('只能选择一条数据!', {icon: 0, title:'警告'});
                return;
            }
			var item = $("#contentTable tbody tr td input.i-checks:checked")[0];
			$("#bgwh_id").attr("value",$(item).attr("id"));
			$("#wjbt").attr("value",$(item).attr("attrWjbt"));

            top.layer.confirm('确认要变更文号吗?', {icon: 3, title: '系统提示'}, function (index) {
                top.layer.close(index);
                top.layer.open({
                    type: 1,
                    area: ["500px", "400px"],
                    title:"变更文号",
                    content:$("#bgwhFormDiv").html() ,
                    btn: ['确定', '关闭'],
                    btn1: function(index){

                        var value = top.$("#bswh").val();
                        if (null == value || '' == value) {
                            top.layer.alert("请填写报送文号！");
                            return false;
                        }

                        top.$("#bgwhForm").attr("target",top.getActiveTab().attr("name"));
                        top.$("#bgwhForm").submit();
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
		<h5>报送区</h5>
		<div class="ibox-tools">
		</div>
	</div>
    
    <div class="ibox-content">
	<sys:message content="${message}"/>
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="deptRelationSearchParameter" action="${ctx}/xmjbxx/xmjbxx/zxjsjjxmBsqList" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<input id="moreSearch" name="moreSearch" type="hidden" value="${deptRelationSearchParameter.moreSearch}"/><!-- 是否展开更多查询 -->
		<div class="form-group">
		<div class="form-group right10">
			<span class="left10">文号：</span>
			<form:input path="xmjbxx.bswh" htmlEscape="false" maxlength="200"  class=" form-control input-sm"/>
		</div>
		<div class="form-group right10">
			<span class="left10">文件标题：</span>
			<form:input path="xmjbxx.wjbt" htmlEscape="false" maxlength="200"  class=" form-control input-sm"/>
		</div>
		<div class="form-group right10">
			<span class="left10">报送状态：</span>
			<form:select path="nrzt" class="form-control" cssStyle="width:100px;">
				<form:option value="" label="" />
			</form:select>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span class="left10">报送时间：</span>
            <input type="hidden" name="bsDateStart" id="bsDateStart" value="<fmt:formatDate value='${deptRelationSearchParameter.bsDateStart}' pattern='yyyy-MM-dd'/>">
            <input type="hidden" name="bsDateEnd" id="bsDateEnd" value="<fmt:formatDate value='${deptRelationSearchParameter.bsDateEnd}' pattern='yyyy-MM-dd'/>">
            <input id="bsDate" name="bsDate" type="text" class="laydate-icon-img form-control layer-date input-sm" value="${deptRelationSearchParameter.bsDateBT}" style="width:220px;"/>
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
			<button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" onclick="bgwh()" title="变更文号"><i class="fa fa-pencil-square-o"> 变更文号</i></button>
			<table:operateRow url="${ctx}/xmjbxx/xmjbxx/ndzxjsjjBsqTh" id="contentTable" operateIndex="1" label="退回"></table:operateRow>
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
    <div class="table-flow-contain">
	<!-- 表格 -->
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
		<tr>
			<th> <input type="checkbox" class="i-checks"></th>
			<th  class="sort-column zdkbmgj">重大库编码</th>
			<th  class="sort-column xmmc">项目名称</th>
			<th>文号</th>
			<th>文件标题</th>
			<th  class="sort-column bs_date">报送时间</th>
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="deptRelation">
			<c:set var="xmjbxx" value="${deptRelation.xmjbxx}"/>
			<tr>
				<td> <input type="checkbox" id="${xmjbxx.id}" attrWjbt="${xmjbxx.wjbt}" class="i-checks"></td>
				<td><a href="#" onclick="openXmjbxxView('查看项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${xmjbxx.id}','1000px', '700px')">
						${xmjbxx.zdkbmgj}
				</a></td>
				<td>
						${fns:ellipsisText(xmjbxx.xmmc, 35)}
				</td>
				<td>
						${xmjbxx.bswh}
				</td>
				<td>
						${xmjbxx.wjbt}
				</td>
				<td>
					<fmt:formatDate value="${deptRelation.bsDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
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
	</div>
		<!-- 分页代码 -->
	<table:page page="${page}"></table:page>
	<br/>
	<br/>
	</div>
	</div>

		<%--变更文号弹框--%>
		<div id="bgwhFormDiv" style="display:none;">
			<form id="bgwhForm" action="${ctx}/xmjbxx/xmjbxx/zxjsjjxmBgwh" method="post">
				<div style="margin: 50px 80px;">
					<input type="hidden" id="bgwh_id" name="id" value=""/>

					<div class="form-inline" style="margin: 10px 30px 0 30px;">
						<span style="font-size: 14px;">&nbsp;报送文号：</span>
						<input id="bswh" name="bswh" class="form-control required">
					</div>

					<br/>
					<div class="form-inline" style="margin: 10px 30px 0 30px;">
						<span style="font-size: 14px;">&nbsp;文件标题：</span>
						<input id="wjbt" name="wjbt" class="form-control">
					</div>
				</div>
			</form>
		</div>
</div>
</body>
</html>