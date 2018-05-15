<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>tj_sszdgjxmxx管理</title>
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
		<h5>省市重点攻坚项目基本信息列表 </h5>
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
	</div>
    
    <div class="ibox-content">
	<sys:message content="${message}"/>
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="tj_sszdgjxmxx" action="${ctx}/tj_sszdgjxmxx/tj_sszdgjxmxx/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
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
		<div class="pull-left">
			<shiro:hasPermission name="tj_sszdgjxmxx:tj_sszdgjxmxx:add">
				<table:addRow url="${ctx}/tj_sszdgjxmxx/tj_sszdgjxmxx/form" title="tj_sszdgjxmxx"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="tj_sszdgjxmxx:tj_sszdgjxmxx:edit">
			    <table:editRow url="${ctx}/tj_sszdgjxmxx/tj_sszdgjxmxx/form" title="tj_sszdgjxmxx" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="tj_sszdgjxmxx:tj_sszdgjxmxx:del">
				<table:delRow url="${ctx}/tj_sszdgjxmxx/tj_sszdgjxmxx/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="tj_sszdgjxmxx:tj_sszdgjxmxx:import">
				<table:importExcel url="${ctx}/tj_sszdgjxmxx/tj_sszdgjxmxx/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="tj_sszdgjxmxx:tj_sszdgjxmxx:export">
	       		<table:exportExcel url="${ctx}/tj_sszdgjxmxx/tj_sszdgjxmxx/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th> <input type="checkbox" class="i-checks"></th>
				<th  class="sort-column xh">序号</th>
				<th  class="sort-column sszdgjxmsl">分类</th>
				<th  class="sort-column jhztz">计划总投资</th>
				<th  class="sort-column ndjhtz">年度计划投资</th>
				<th  class="sort-column ndywctz">年度已完成投资</th>
				<th  class="sort-column tzwcl">投资完成率</th>
				<th  class="sort-column dywctz">当月完成投资</th>
				<th  class="sort-column ykgxmsl">已开工项目数量</th>
				<th  class="sort-column ytcxmsl">已投产项目数量</th>
				<th  class="sort-column xtcxmsl">新投产项目数量</th>
				<th  class="sort-column xdrxmsl">新调入项目数量</th>
				<th  class="sort-column xdcxmsl">新调出项目数量</th>
				<!-- 分类标记（1.入库项目数量 2.省（市）重点攻坚产业项目数量 3.各产业项目数量 4.技术改造项目数量 5.本年度计划新开工项目数量 6.年度计划新投产项目数量 7.本年度计划续建项目数量8.当月新开工项目数量 9.新调出项目数量） -->
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tj_sszdgjxmxx">
			<tr>
				<td> <input type="checkbox" id="${tj_sszdgjxmxx.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看tj_sszdgjxmxx', '${ctx}/tj_sszdgjxmxx/tj_sszdgjxmxx/form?id=${tj_sszdgjxmxx.id}','800px', '500px')">
					${tj_sszdgjxmxx.remarks}
				</a></td>
				<td>
					${tj_sszdgjxmxx.sszdgjxmsl}
				</td>
				<td>
					${tj_sszdgjxmxx.sxszgx}
				</td>
				<td>
					${tj_sszdgjxmxx.jhztz}
				</td>
				<td>
					${tj_sszdgjxmxx.ndjhtz}
				</td>
				<td>
					${tj_sszdgjxmxx.ndywctz}
				</td>
				<td>
					${tj_sszdgjxmxx.tzwcl}
				</td>
				<td>
					${tj_sszdgjxmxx.dywctz}
				</td>
				<td>
					${tj_sszdgjxmxx.ykgxmsl}
				</td>
				<td>
					${tj_sszdgjxmxx.ytcxmsl}
				</td>
				<td>
					${tj_sszdgjxmxx.xtcxmsl}
				</td>
				<td>
					${tj_sszdgjxmxx.xdrxmsl}
				</td>
				<td>
					${tj_sszdgjxmxx.xdcxmsl}
				</td>
				<td>
					${tj_sszdgjxmxx.sign}
				</td>
				<td>
					<shiro:hasPermission name="tj_sszdgjxmxx:tj_sszdgjxmxx:view">
						<a href="#" onclick="openDialogView('查看tj_sszdgjxmxx', '${ctx}/tj_sszdgjxmxx/tj_sszdgjxmxx/form?id=${tj_sszdgjxmxx.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="tj_sszdgjxmxx:tj_sszdgjxmxx:edit">
    					<a href="#" onclick="openDialog('修改tj_sszdgjxmxx', '${ctx}/tj_sszdgjxmxx/tj_sszdgjxmxx/form?id=${tj_sszdgjxmxx.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="tj_sszdgjxmxx:tj_sszdgjxmxx:del">
						<a href="${ctx}/tj_sszdgjxmxx/tj_sszdgjxmxx/delete?id=${tj_sszdgjxmxx.id}" onclick="return confirmx('确认要删除该tj_sszdgjxmxx吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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