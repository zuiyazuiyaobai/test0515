<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>反馈信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
		$("#add").click(function(){
			  if($("#add").val() == "新 增"){
			  	 $("#add").val("关 闭");
			  }else{
			  	 $("#add").val("新 增");
			  }
			  $("#add_feed").toggle();
			});
		});
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox">
	<div class="ibox-title">
		<h5>历史进度列表
			<shiro:hasPermission name="accountfeedback:tYwFeedback:add">
				<input type="submit" class="btn btn-info btn-xs" id="add" style="width:50px" value="新 增"/>
			</shiro:hasPermission>
		 </h5>
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
	
	
	
	
	<div id="add_feed" style="display:none;border-style: outset;margin-bottom: 20px;width: 95%;margin-left: 2%;">
		<div>任务基本信息：
			<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
			   <tbody>
					<tr>
						<td class="width-15 active"><label class="pull-right">任务名称：</label></td>
						<td class="width-35">
							${tYwTask.taskTitle}
						</td>
						<td class="width-15 active"><label class="pull-right">任务内容：</label></td>
						<td class="width-35">
							${tYwTask.taskContent}
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">时间节点：</label></td>
						<td class="width-35">
							${tYwTask.timeNode}
						</td>
						<td class="width-15 active"><label class="pull-right">责任单位：</label></td>
						<td class="width-35">
							${tYwTask.responseUnit}
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">责任人：</label></td>
						<td class="width-35">
							${tYwTask.responsePerson}
						</td>
						<td class="width-15 active"><label class="pull-right">是否为牵头单位：</label></td>
						<td class="width-35">
							${fns:getDictLabel(tYwTask.taskStatus, 'account_task_ismain', '')}
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">反馈频率：</label></td>
						<td class="width-35">
							
							${fns:getDictLabel(tYwTask.taskStatus, 'account_task_frequency', '')}
						</td>
						<td class="width-15 active"><label class="pull-right">开始时间：</label></td>
						<td class="width-35">
							<fmt:formatDate value="${tYwTask.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">完成时间：</label></td>
						<td class="width-35">
							<fmt:formatDate value="${tYwTask.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td class="width-15 active"><label class="pull-right">任务状态：</label></td>
						<td class="width-35">
							${fns:getDictLabel(tYwTask.taskStatus, 'account_task_taskstatus', '')}
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">备注：</label></td>
						<td class="width-35">
							${tYwTask.remark}
						</td>
						<td class="width-15 active"><label class="pull-right">任务编号：</label></td>
			   			<td class="width-35" >${tYwTask.id}</td>
			  		</tr>
			 	</tbody>
			</table>
		</div>

	<div>
		进度录入：
		<form:form id="inputForm" modelAttribute="tYwFeedback" action="${ctx}/accountfeedback/tYwFeedback/save" method="post" class="form-horizontal">
		<%-- <form:hidden path="id"/> --%>
		<form:hidden path="taskId" value="${tYwTask.id}"/>
		<form:hidden path="parentId" value="${tYwTask.parentId}"/>
		<%-- <sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td class="width-15 active"><label class="pull-right"><font color="red">*</font>反馈内容：</label></td>
					<td class="width-35">
						<form:input path="feedContent" htmlEscape="false"    class="form-control required"/>
					</td>
					<td class="width-15 active"><label class="pull-right"><font color="red">*</font>反馈附件：</label></td>
					<td class="width-35">
						<form:input path="feedFile" htmlEscape="false"    class="form-control required"/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right"><font color="red">*</font>反馈进度：</label></td>
					<td class="width-35">
						<form:input path="schedule" htmlEscape="false"    class="form-control required"/>
					</td>
					<td class="width-15 active"><label class="pull-right"><font color="red">*</font>反馈状态：</label></td>
					<td class="width-35">
						<%-- <form:input path="feedStatus" htmlEscape="false"    class="form-control required"/> --%>
						<form:select path="feedStatus"  class="form-control m-b">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('account_feedback_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">反馈备注：</label></td>
					<td class="width-35">
						<form:input path="feedRemark" htmlEscape="false"    class="form-control "/>
					</td>
					<shiro:hasPermission name="accountfeedback:tYwFeedback:add">
					<td class="width-15 active"><label class="pull-right"><font color="red">*</font>审核认定：</label></td>
					<td class="width-35">
						${fns:getDictLabel(tYwFeedback.feedStatus, 'account_feedback_auditresult', '')}
					</td>
					</shiro:hasPermission>
					<shiro:hasPermission name="accountfeedback:tYwFeedback:audit">
					<td class="width-15 active"><label class="pull-right"><font color="red">*</font>审核认定：</label></td>
					<td class="width-35">
						<%-- <form:input path="auditResult" htmlEscape="false"    class="form-control "/> --%>
						<form:select path="auditResult"  class="form-control  required">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('account_feedback_auditresult')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td>
					</shiro:hasPermission>
				</tr>
				<shiro:hasPermission name="accountfeedback:tYwFeedback:add">
				<tr>
					<td class="width-15 active"><label class="pull-right"><font color="red">*</font>是否按照节点完成：</label></td>
					<td class="width-35">
						${fns:getDictLabel(tYwFeedback.feedStatus, 'account_feedback_isFinish', '')}
					</td>
					<td class="width-15 active"><label class="pull-right">审核备注：</label></td>
					<td class="width-35">
						${tYwFeedback.auditRemark}
						<%-- <form:input path="auditRemark" htmlEscape="false"    class="form-control "/> --%>
					</td>
				</tr>
				</shiro:hasPermission>
				<shiro:hasPermission name="accountfeedback:tYwFeedback:audit">
				<tr>
					<td class="width-15 active"><label class="pull-right"><font color="red">*</font>是否按照节点完成：</label></td>
					<td class="width-35">
						<%-- <form:input path="isFinish" htmlEscape="false"    class="form-control "/> --%>
						<form:select path="isFinish"  class="form-control  required">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('account_feedback_isFinish')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td>
					<td class="width-15 active"><label class="pull-right"><font color="red">*</font>审核备注：</label></td>
					<td class="width-35">
						<form:input path="auditRemark" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				</shiro:hasPermission>
		 	</tbody>
		</table>
		<div style="text-align:center;margin-bottom: 5px;">
		
		<shiro:hasPermission name="accountfeedback:tYwFeedback:add">
			<input type="submit" class="btn btn-info btn-xs" style="width:50px" value="新 增"/>
		</shiro:hasPermission>
		</div>
	</form:form>
		</div>
	
	</div>
	
	
	
	<!--查询条件-->
	<%-- <div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="tYwFeedback" action="${ctx}/accountfeedback/tYwFeedback/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
			<span>反馈人：</span>
				<form:input path="feedPerson" htmlEscape="false" maxlength="100"  class=" form-control input-sm"/>
			<span>反馈进度：</span>
				<form:input path="schedule" htmlEscape="false" maxlength="2000"  class=" form-control input-sm"/>
			<span>反馈状态：</span>
				<form:input path="feedStatus" htmlEscape="false" maxlength="20"  class=" form-control input-sm"/>
				<form:select path="feedStatus" class="form-control ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('account_feedback_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
		 </div>	
	</form:form>
	<br/>
	</div>
	</div> --%>
	
	<!-- 工具栏 -->
	<%-- <div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			<shiro:hasPermission name="accountfeedback:tYwFeedback:add">
				<table:addRow url="${ctx}/accountfeedback/tYwFeedback/form" title="反馈信息"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="accountfeedback:tYwFeedback:edit">
			    <table:editRow url="${ctx}/accountfeedback/tYwFeedback/form" title="反馈信息" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="accountfeedback:tYwFeedback:del">
				<table:delRow url="${ctx}/accountfeedback/tYwFeedback/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="accountfeedback:tYwFeedback:import">
				<table:importExcel url="${ctx}/accountfeedback/tYwFeedback/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="accountfeedback:tYwFeedback:export">
	       		<table:exportExcel url="${ctx}/accountfeedback/tYwFeedback/export"></table:exportExcel><!-- 导出按钮 -->
	       	</shiro:hasPermission>
	       <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button>
		
			</div>
		<div class="pull-right">
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()" ><i class="fa fa-search"></i> 查询</button>
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()" ><i class="fa fa-refresh"></i> 重置</button>
		</div>
	</div>
	</div> --%>
	
	<!-- 表格 -->
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
			<tr>
				<th> <input type="checkbox" class="i-checks"></th>
				<th  class="sort-column feedPerson">反馈人</th>
				<th  class="sort-column feedTime">反馈时间</th>
				<th  class="sort-column schedule">反馈进度</th>
				<th  class="sort-column feedStatus">反馈状态</th>
				<th  class="sort-column feedStatus">审核认定</th>
				<th  class="sort-column feedStatus">审核时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tYwFeedback">
			<tr>
				<td> <input type="checkbox" id="${tYwFeedback.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看反馈信息', '${ctx}/accountfeedback/tYwFeedback/form?id=${tYwFeedback.id}','800px', '500px')">
					${tYwFeedback.feedPerson}
				</a></td>
				<td>
					<fmt:formatDate value="${tYwFeedback.feedTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tYwFeedback.schedule}
				</td>
				<td>
					${fns:getDictLabel(tYwFeedback.feedStatus, 'account_feedback_status', '')}
				</td>
				<td>
					${fns:getDictLabel(tYwFeedback.isFinish, 'account_feedback_isFinish', '')}
				</td>
				<td>
					<fmt:formatDate value="${tYwFeedback.auditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<shiro:hasPermission name="accountfeedback:tYwFeedback:view">
						<a href="#" onclick="openDialogView('查看反馈信息', '${ctx}/accountfeedback/tYwFeedback/form?id=${tYwFeedback.id}&operation=view','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="accountfeedback:tYwFeedback:edit">
						<a href="${ctx}/accountfeedback/tYwFeedback/form?id=${tYwFeedback.id}&operation=edit"  class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    					<%-- <a href="#" onclick="openDialogView('修改反馈信息', '${ctx}/accountfeedback/tYwFeedback/form?id=${tYwFeedback.id}&operation=edit','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a> --%>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="accountfeedback:tYwFeedback:del">
						<a href="${ctx}/accountfeedback/tYwFeedback/delete?id=${tYwFeedback.id}" onclick="return confirmx('确认要删除该反馈信息吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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