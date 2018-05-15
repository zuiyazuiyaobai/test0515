<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>重点项目初审菜单管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
		});
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox">
	<div class="ibox-title">
		<h5>重点项目办件菜单列表 </h5>
		<!-- <div class="ibox-tools">
			<a class="collapse-link">
				<i class="fa fa-chevron-up"></i>
			</a>
			<a class="dropdown-toggle" data-toggle="dropdown" href="#">
				<i class="fa fa-wrench"></i>
			</a>
			<ul class="dropdown-menu dropdown-user">
				<li><a href="#">选项1</a>
				</li>
				<li><a href="#">选项2</a>
				</li>
			</ul>
			<a class="close-link">
				<i class="fa fa-times"></i>
			</a>
		</div> -->
	</div>
    
    <div class="ibox-content">
	<sys:message content="${message}"/>
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="cInsBusinessZdgcxm" action="${ctx}/zdxmbj/bj/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<span>项目名称：</span>
		<input id="projectname" class="form-control m-b" name="projectname"/>&nbsp;&nbsp;
		<!-- 1,基础设施等领域重点项目,2产业转型重点项目,3传统产业升级 -->
		<span>项目类型：</span>
				<select id="zdxmlx" name="zdxmlx" class="form-control m-b">
				<option value=""></option>
				<option value="1">基础设施等领域重点项目</option>
				<option value="2">产业转型重点项目</option>
				<option value="3">传统产业升级</option>
				<select>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		 </div>	
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
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
				<th  class="sort-column readstatus">项目名称</th>
				<th  class="sort-column readstatus">申报单位</th>
				<th  class="sort-column readstatus">项目类型</th>
				<th  class="sort-column readstatus">产业类型</th>
				<th  class="sort-column readstatus">申报时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="cInsBusinessZdgcxm">
			<tr>
				 <td class="">
                          ${cInsBusinessZdgcxm.info.projectname}
				</td>
				 <td class="">
                          ${cInsBusinessZdgcxm.info.incname}
				</td>
				<td class="">
                          ${cInsBusinessZdgcxm.zdxmlx}
				</td>
				<td class="">
                          ${cInsBusinessZdgcxm.cylx}
				</td>
				<td class="">
				<fmt:formatDate value="${cInsBusinessZdgcxm.info.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<shiro:hasPermission name="zdxmbj:bj:view">
						<a href="#" onclick="openDialogView('查看重点项目初审菜单', '${ctx}/zdxmbj/bj/edit?id=${cInsBusinessZdgcxm.id}','1000px', '750px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="zdxmbj:bj:edit">
    				<a href="#" onclick="openDialog('审核重点项目初审菜单', '${ctx}/zdxmbj/bj/auditing?id=${cInsBusinessZdgcxm.id}','1200px', '900px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i>审核</a>
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