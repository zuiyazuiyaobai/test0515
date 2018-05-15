<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>重点项目已办结问题管理</title>
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
		<h5>重点项目已办结问题列表 </h5>
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
	<form:form id="searchForm" modelAttribute="cInsBusinessZdxmwt" action="${ctx}/zdxmwtbj/wtbj/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<span>项目编码：</span><input id="projectid" name="projectid" class="form-control m-b"/>&nbsp;&nbsp;
		<span>重大工程项目编号：</span><input id="zdgcxmbh" name="zdgcxmbh" class="form-control m-b"/>&nbsp;&nbsp;
		<!-- 问题类型（1审批手续，2建设环境，3资金问题，4其他问题） -->
		<span>问题类型：</span>
				<select id="wttype" name="wttype" class="form-control m-b">
				<option value=""></option>
				<option value="1">审批手续</option>
				<option value="2">建设环境</option>
				<option value="3">资金问题</option>
				<option value="4">其他问题</option>
				<select>   
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
		<div class="pull-left">
			<shiro:hasPermission name="zdxmwtbj:wtbj:add">
				<table:addRow url="${ctx}/zdxmwtbj/wtbj/form" title="重点项目已办结问题"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="zdxmwtbj:wtbj:edit">
			    <table:editRow url="${ctx}/zdxmwtbj/wtbj/form" title="重点项目已办结问题" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="zdxmwtbj:wtbj:del">
				<table:delRow url="${ctx}/zdxmwtbj/wtbj/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="zdxmwtbj:wtbj:import">
				<table:importExcel url="${ctx}/zdxmwtbj/wtbj/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="zdxmwtbj:wtbj:export">
	       		<table:exportExcel url="${ctx}/zdxmwtbj/wtbj/export"></table:exportExcel><!-- 导出按钮 -->
	       	</shiro:hasPermission>
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
				<tr>
				<th>问题类型</th>
				<th>类型选择</th>
				<th>重点工程项目编号</th>
				<th>问题层级</th>
				<th>问题描述</th>
				<th>操作</th>
			</tr>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="cInsBusinessZdxmwt">
			<tr>
				<td>${cInsBusinessZdxmwt.wttype}</td>
				<td>${cInsBusinessZdxmwt.stagetype}</td>
				<td>${cInsBusinessZdxmwt.zdgcxmbh}</td>
				<td>${cInsBusinessZdxmwt.wtlevel}</td>
				<td>${cInsBusinessZdxmwt.wtdescribe}</td>
				<td>
					<shiro:hasPermission name="zdxmwtbj:wtbj:view">
						<a href="#" onclick="openDialogView('查看重点项目已办结问题', '${ctx}/zdxmwtbj/wtbj/form?id=${cInsBusinessZdxmwt.id}','1000px', '750px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="zdxmwtbj:wtbj:edit">
    					<a href="#" onclick="openDialog('修改重点项目已办结问题', '${ctx}/zdxmwtbj/wtbj/form?id=${cInsBusinessZdxmwt.id}','1200px', '900px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="zdxmwtbj:wtbj:del">
						<a href="${ctx}/zdxmwtbj/cInsBusinessZdxmwt/delete?id=${cInsBusinessZdxmwt.id}" onclick="return confirmx('确认要删除该重点项目已办结问题吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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