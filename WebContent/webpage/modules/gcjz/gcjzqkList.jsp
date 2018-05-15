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
	<div class="ibox-title">
		<h5>工程进度 分市汇总列表 </h5>
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
	<form:form id="searchForm" modelAttribute="cInsBusinessGcjzqk" action="${ctx}/zdgcxm/gcjz/list" method="post" class="form-inline">
		统计年份：<select id="year" name="year" class="form-control required">
				 	<c:forEach items="${years }" var="year">
				 		<option value="${year }">${year }</option>
				 	</c:forEach>
				 </select>&nbsp;&nbsp;
		统计月份：<select id="month" name="month" class="form-control required">
			     	<option value="01">01</option>
			     	<option value="02">02</option>
			     	<option value="03">03</option>
			     	<option value="04">04</option>
			     	<option value="05">05</option>
			     	<option value="06">06</option>
			     	<option value="07">07</option>
			     	<option value="08">08</option>
			     	<option value="09">09</option>
			     	<option value="10">10</option>
			     	<option value="11">11</option>
			     	<option value="12">12</option>
		         </select>
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
			<%-- <shiro:hasPermission name="gcjz:cInsBusinessGcjzqk:add">
				<table:addRow url="${ctx}/gcjz/cInsBusinessGcjzqk/form" title="工程进度 分市汇总"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="gcjz:cInsBusinessGcjzqk:edit">
			    <table:editRow url="${ctx}/gcjz/cInsBusinessGcjzqk/form" title="工程进度 分市汇总" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="gcjz:cInsBusinessGcjzqk:del">
				<table:delRow url="${ctx}/gcjz/cInsBusinessGcjzqk/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="gcjz:cInsBusinessGcjzqk:import">
				<table:importExcel url="${ctx}/gcjz/cInsBusinessGcjzqk/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="gcjz:cInsBusinessGcjzqk:export">
	       		<table:exportExcel url="${ctx}/gcjz/cInsBusinessGcjzqk/export"></table:exportExcel><!-- 导出按钮 -->
	       	</shiro:hasPermission>
	       <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button>
		
			</div> --%>
		<div class="pull-right">
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()" ><i class="fa fa-search"></i> 查询</button>
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()" ><i class="fa fa-refresh"></i> 重置</button>
		</div>
	</div>
	</div>
	
	<!-- 表格 -->
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
			<tr style="font-size:16px;font-weight:bold;font-family:微软雅黑;padding:0px 10px;"><td colspan="7" align="center">${gcjzqk[0].year }年${gcjzqk[0].month }月省重点工程进度分市统计表</td></tr>
				<tr align="center">
					<td class="width-15 active" rowspan="2"><label>市别</label></td>
					<td class="width-15 active" rowspan="2"><label>项目数量</label></td>
					<td class="width-15 active" colspan="5"><label>工程进度情况</label></td>
				</tr>
				<tr align="center">
					<td class="width-15 active"><label>超前</label></td>
					<td class="width-15 active"><label>顺利</label></td>
					<td class="width-15 active"><label>缓慢</label></td>
					<td class="width-15 active"><label>滞后</label></td>
					<td class="width-15 active"><label>停工</label></td>
				</tr>
				<tr align="center">
					<td><label>总计</label></td>
					<td><label>${xmzj.xmTotal }</label></td>
					<td><label>${xmzj.cqNum }</label></td>
					<td><label>${xmzj.slNum }</label></td>
					<td><label>${xmzj.hmNum }</label></td>
					<td><label>${xmzj.zhNum }</label></td>
					<td><label>${xmzj.tgNum }</label></td>
				</tr>
		<c:forEach items="${gcjzqk}" var="gcjzqk">
			<tr align="center">
				<td>${gcjzqk.areaname }</td>
				<td>
				<c:choose>
			    <c:when test="${gcjzqk.xmTotal=='0' }">  
			    	<a href="#">${gcjzqk.xmTotal }</a>      
			    </c:when>
			    <c:otherwise> 
					<a href="#" onclick="openDialogView('${gcjzqk.areaname }重点工程进度分市完成情况', '${ctx}/zdgcxm/gcjz/form?areaname=${gcjzqk.areaname }&year=${gcjzqk.year }&month=${gcjzqk.month }','1200px', '900px')">${gcjzqk.xmTotal }</a></td>
			    </c:otherwise>
			    </c:choose>
				<td>
				<c:choose>
			    <c:when test="${gcjzqk.cqNum=='0' }">  
			    	<span>${gcjzqk.cqNum }</span>      
			    </c:when>
			    <c:otherwise> 
					<a href="#" onclick="openDialogView('${gcjzqk.areaname }重点工程进度分市完成情况', '${ctx}/zdgcxm/gcjz/form?areaname=${gcjzqk.areaname }&year=${gcjzqk.year }&month=${gcjzqk.month }&jdpj=1','1200px', '900px')">${gcjzqk.cqNum }</a>
			    </c:otherwise>
			    </c:choose>
				</td>
				<td>
				<c:choose>
			    <c:when test="${gcjzqk.slNum=='0' }">  
			    	<span>${gcjzqk.slNum }</span>      
			    </c:when>
			    <c:otherwise> 
					<a href="#" onclick="openDialogView('${gcjzqk.areaname }重点工程进度分市完成情况', '${ctx}/zdgcxm/gcjz/form?areaname=${gcjzqk.areaname }&year=${gcjzqk.year }&month=${gcjzqk.month }&jdpj=2','1200px', '900px')">${gcjzqk.slNum }</a>
			    </c:otherwise>
			    </c:choose>
				</td>
				<td>
				<c:choose>
			    <c:when test="${gcjzqk.hmNum=='0' }">  
			    	<span>${gcjzqk.hmNum }</span>      
			    </c:when>
			    <c:otherwise> 
					<a href="#" onclick="openDialogView('${gcjzqk.areaname }重点工程进度分市完成情况', '${ctx}/zdgcxm/gcjz/form?areaname=${gcjzqk.areaname }&year=${gcjzqk.year }&month=${gcjzqk.month }&jdpj=3','1200px', '900px')">${gcjzqk.hmNum }</a>
			    </c:otherwise>
			    </c:choose>
				</td>
				<td>
				<c:choose>
			    <c:when test="${gcjzqk.zhNum=='0' }">  
			    	<span>${gcjzqk.zhNum }</span>      
			    </c:when>
			    <c:otherwise> 
					<a href="#" onclick="openDialogView('${gcjzqk.areaname }重点工程进度分市完成情况', '${ctx}/zdgcxm/gcjz/form?areaname=${gcjzqk.areaname }&year=${gcjzqk.year }&month=${gcjzqk.month }&jdpj=4','1200px', '900px')">${gcjzqk.zhNum }</a>
			    </c:otherwise>
			    </c:choose>
				</td>
				<td>
				<c:choose>
			    <c:when test="${gcjzqk.tgNum=='0' }">  
			    	<span>${gcjzqk.tgNum }</span>      
			    </c:when>
			    <c:otherwise> 
					<a href="#" onclick="openDialogView('${gcjzqk.areaname }重点工程进度分市完成情况', '${ctx}/zdgcxm/gcjz/form?areaname=${gcjzqk.areaname }&year=${gcjzqk.year }&month=${gcjzqk.month }&jdpj=5','1200px', '900px')">${gcjzqk.tgNum }</a>
			    </c:otherwise>
			    </c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
	
		<!-- 分页代码 -->
	<%-- <table:page page="${page}"></table:page>
	<br/>
	<br/> --%>
	</div>
	</div>
</div>
</body>
</html>