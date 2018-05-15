<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>工程进度 分市汇总管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
		});
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox">
	<!-- <div class="ibox-title">
		<h5>重点项目初审菜单列表 </h5>
		<div class="ibox-tools">
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
		</div> 
	</div> -->
    
    <div class="ibox-content">
	<sys:message content="${message}"/>
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="cInsBusinessZdgcxm" action="${ctx}/zdgcxm/gcjz/form?areaname=${page.list[0].areaname }&year=${page.list[0].year }&month=${page.list[0].month }&jdpj=${page.list[0].jdpj }" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<span>项目名称：</span>
		<input id="projectname" class="form-control m-b" name="projectname"/>&nbsp;&nbsp;
		<!-- 1,基础设施等领域重点项目,2产业转型重点项目,3传统产业升级 -->
		<span>重点工程项目编号：</span>
		<input id="xmid" class="form-control m-b" name="xmid"/>&nbsp;&nbsp;
		<span>申报单位：</span>
		<input id="incname" class="form-control m-b" name="incname"/>&nbsp;&nbsp;
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
				<th  class="sort-column readstatus">重点工程项目编号</th>
				<th  class="sort-column readstatus">项目名称</th>
				<th  class="sort-column readstatus">申报单位</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="gcjd">
			<tr>
				<td class="">
                          ${gcjd.xmid}
				</td>
				 <td class="">
                          ${gcjd.projectname}
				</td>
				 <td class="">
                          ${gcjd.incname}
				</td>
				<td>
					<shiro:hasPermission name="zdgcxm:gcjz:list">
						<a href="#" onclick="openDialogView('项目办理情况', '${ctx}/zdgcxm/gcjz/edit?areaname=${gcjd.areaname }&year=${gcjd.year }&month=${gcjd.month }&jdpj=${gcjd.jdpj }&xmid=${gcjd.xmid }&id=${gcjd.id}','1000px', '750px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
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