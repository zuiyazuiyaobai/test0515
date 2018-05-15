<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>项目基本信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
		});
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox ibox-custom">
	<div class="ibox-title">
		<h5>年度计划编报</h5>
		<div class="ibox-tools">
		</div>
	</div>
    
    <div class="ibox-content">
	<sys:message content="${message}"/>
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="c_ins_business_scheduler_task" action="${ctx}/xmjbxx/xmjbxx/ndjhNdjhxdjsList" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		 <div class="form-group right10">
			<span>文件标题：</span>
				<form:input path="name" htmlEscape="false" maxlength="200"  class=" form-control input-sm"/>
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
	       <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button>
		</div>
		<div class="pull-right">
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()" ><i class="fa fa-search"></i> 查询</button>
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()" ><i class="fa fa-refresh"></i> 重置</button>
		</div>
	</div>
	</div>

	<!-- 表格 -->
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
		<tr>
			<th> <input type="checkbox" class="i-checks"></th>
			<th  class="sort-column id" style="display: none;">主键</th>
			<th  class="sort-column xmmc">文件标题</th>
			<th  class="sort-column create_Date">项目个数</th>
			<th  class="sort-column zdkbmgj">总投资(万元)</th>
			<th  class="sort-column zdkbmgj">本次下达金额</th>
			<th  class="sort-column zdkbmgj">操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="CInsBusinessSchedulerTask">
			<tr>
				<td> <input type="checkbox" id="${CInsBusinessSchedulerTask.id}" class="i-checks"></td>
				<td>
						${CInsBusinessSchedulerTask.name}
				</td>
				<td>
					<a href="#" onclick="openXmjbxxView('调度任务关联列表信息', '${ctx}/task/cInsBusinessXmjbxxTaskRelation/findCInsBusinessXmjbxxTaskRelationList?task_id=${CInsBusinessSchedulerTask.id}','1000px', '700px')">
						${CInsBusinessSchedulerTask.remarks}
					</a>					
				</td>
				<td>
						${CInsBusinessSchedulerTask.type}
				</td>
				<td>
					${CInsBusinessSchedulerTask.requirement}
				</td>
				<td>
					<shiro:hasPermission name="xmjbxx:xmjbxx:view">
						<a href="#" onclick="openSchedulerTaskView('${CInsBusinessSchedulerTask.id}')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
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
</div>
</body>
</html>