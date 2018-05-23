<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>任务信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#add").click(function(){
			  if($("#add").val() == "新 增"){
			  	 $("#add").val("关 闭");
			  }else{
			  	 $("#add").val("新 增");
			  }
			  $("#add_task").toggle();
			});
		});
		
		function sub_task(){
			$("#inputForm").submit(function(e){
				console.log(e);
			    alert(e);
			});
		}	
		
		var validateForm;
		function doSubmit(){//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
		  if(validateForm.form()){
			  $("#inputForm").submit();
			  return true;
		  }
	
		  return false;
		}
		$(document).ready(function() {
			validateForm = $("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
			
		});
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox">
	<div class="ibox-title">
		<h5>任务信息列表 
			<!-- <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="left" id="add" title="新增">新增</button>  -->
			<shiro:hasPermission name="accounttask:tYwTask:add">
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
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	
	<div id="add_task" style="display:none;border-style: outset;margin-bottom: 20px;">
		<form:form id="inputForm" modelAttribute="tYwTask" action="${ctx}/accounttask/tYwTask/save" method="post" class="form-horizontal">
			<%-- <form:hidden path="id"/> --%>
			<form:hidden path="parentId" value="${accountId}"/>
			<%-- <sys:message content="${message}"/>	 --%>
			<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
			   <tbody>
					<tr>
						<td class="width-15 active"><label class="pull-right">任务名称：</label></td>
						<td class="width-35">
							<form:input path="taskTitle" htmlEscape="false"    class="form-control  required"/>
						</td>
						<td class="width-15 active"><label class="pull-right">任务内容：</label></td>
						<td class="width-35">
							<form:input path="taskContent" htmlEscape="false"    class="form-control  required"/>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">时间节点：</label></td>
						<td class="width-35">
							<form:input path="timeNode" htmlEscape="false"    class="form-control "/>
						</td>
						<td class="width-15 active"><label class="pull-right">责任单位：</label></td>
						<td class="width-35">
							<sys:treeselect id="responseUnitId" name="responseUnitId" value="${tYwTask.responseUnitId}" labelName="responseUnit" labelValue="${tYwTask.responseUnit}"
								title="部门" url="/sys/office/treeData?type=2" cssClass="form-control  required" allowClear="true" notAllowSelectParent="true"/>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">责任人：</label></td>
						<td class="width-35">
							<sys:treeselect id="responsePersonId" name="responsePersonId" value="${tYwTask.responsePersonId}" labelName="responsePerson" labelValue="${tYwTask.responsePerson}"
								title="用户" url="/sys/office/treeData?type=3" cssClass="form-control  required" allowClear="true" notAllowSelectParent="true"/>
						</td>
						<td class="width-15 active"><label class="pull-right">是否为牵头单位：</label></td>
						<td class="width-35">
							<%-- <form:input path="isMain" htmlEscape="false"    class="form-control "/> --%>
							<form:select path="frequency" class="form-control ">
								<form:option value="" label=""/>
								<form:options items="${fns:getDictList('account_task_ismain')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
							</form:select>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">反馈频率：</label></td>
						<td class="width-35">
							<%-- <form:input path="frequency" htmlEscape="false"    class="form-control "/> --%>
							<form:select path="frequency" class="form-control  required">
								<form:option value="" label=""/>
								<form:options items="${fns:getDictList('account_task_frequency')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
							</form:select>
						</td>
						<td class="width-15 active"><label class="pull-right">开始时间：</label></td>
						<td class="width-35">
							<%-- <form:input path="startTime" htmlEscape="false"    class="form-control "/> --%>
							<input name="startTime" value="<fmt:formatDate value='${tYwTask.startTime}' pattern='yyyy-MM-dd' />" 
							type="date" htmlEscape="false" maxlength="50" class="form-control required"/>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">完成时间：</label></td>
						<td class="width-35">
							<%-- <form:input path="endTime" htmlEscape="false"    class="form-control "/> --%>
							<input name="endTime" value="<fmt:formatDate value='${tYwTask.endTime}' pattern='yyyy-MM-dd' />" 
							type="date" htmlEscape="false" maxlength="50" class="form-control required"/>
						</td>
						<td class="width-15 active"><label class="pull-right">任务状态：</label></td>
						<td class="width-35">
							<%-- <form:input path="taskStatus" htmlEscape="false"    class="form-control "/> --%>
							<form:select path="taskStatus" class="form-control ">
								<form:option value="" label=""/>
								<form:options items="${fns:getDictList('account_task_taskstatus')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
							</form:select>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">备注：</label></td>
						<td class="width-35">
							<form:input path="remark" htmlEscape="false"    class="form-control "/>
						</td>
						<td class="width-15 active"></td>
			   			<td class="width-35" ></td>
			  		</tr>
			 	</tbody>
			</table>
			<div style="text-align:center;margin-bottom: 5px;">
			<input type="submit" class="btn btn-info btn-xs" style="width:50px" value="新 增"/>
			</div>
			
		</form:form>
	</div>
	
	<form:form id="searchForm" modelAttribute="tYwTask" action="${ctx}/accounttask/tYwTask/" method="post" class="form-inline">
	<form:hidden path="id" value="${accountId}"/>
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
			<span>任务名称：</span>
				<form:input path="taskTitle" htmlEscape="false" maxlength="100"  class=" form-control input-sm"/>
			<span>责任单位：</span>
				<sys:treeselect id="responseUnitId" name="responseUnitId" value="${tYwTask.responseUnitId}" labelName="responseUnit" labelValue="${tYwTask.responseUnit}"
								title="部门" url="/sys/office/treeData?type=2" cssClass="form-control " allowClear="true" notAllowSelectParent="true"/>
			<span>责任人：</span>
				<sys:treeselect id="responsePersonId" name="responsePersonId" value="${tYwTask.responsePersonId}" labelName="responsePerson" labelValue="${tYwTask.responsePerson}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="form-control " allowClear="true" notAllowSelectParent="true"/>
			<%-- <br>
			<span>是否为牵头单位：</span>
				<form:input path="isMain" htmlEscape="false" maxlength="20"  class=" form-control input-sm"/> --%>
		 </div>	
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			<%-- <shiro:hasPermission name="accounttask:tYwTask:add">
				<table:addRow url="${ctx}/accounttask/tYwTask/form" title="任务信息"></table:addRow><!-- 增加按钮 -->
				
			</shiro:hasPermission>
			<shiro:hasPermission name="accounttask:tYwTask:edit">
			    <table:editRow url="${ctx}/accounttask/tYwTask/form" title="任务信息" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="accounttask:tYwTask:del">
				<table:delRow url="${ctx}/accounttask/tYwTask/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="accounttask:tYwTask:import">
				<table:importExcel url="${ctx}/accounttask/tYwTask/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="accounttask:tYwTask:export">
	       		<table:exportExcel url="${ctx}/accounttask/tYwTask/export"></table:exportExcel><!-- 导出按钮 -->
	       	</shiro:hasPermission>
	       <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button>
		 --%>
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
				<th >任务名称</th>
				<th >责任单位</th>
				<th >责任人</th>
				<th  class="sort-column start_Time">开始时间</th>
				<th  class="sort-column end_Time">完成时间</th>
				<th>任务状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tYwTask">
			<tr>
				<td> <input type="checkbox" id="${tYwTask.id}" class="i-checks"></td>
				<td><a href="#" onclick="openDialogView('查看任务信息', '${ctx}/accounttask/tYwTask/form?id=${tYwTask.id}&role=view','800px', '500px')">
					${tYwTask.taskTitle}
				</a></td>
				<td>
					${tYwTask.responseUnit}
				</td>
				<td>
					${tYwTask.responsePerson}
				</td>
				<td>
					<fmt:formatDate value="${tYwTask.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${tYwTask.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fns:getDictLabel(tYwTask.taskStatus, 'account_task_taskstatus', '')}
				</td>
				<td>
					<shiro:hasPermission name="accounttask:tYwTask:view">
						<a href="#" onclick="openDialogView('查看任务信息', '${ctx}/accounttask/tYwTask/form?id=${tYwTask.id}&operation=view','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="accounttask:tYwTask:edit">
    					<a href="${ctx}/accounttask/tYwTask/form?id=${tYwTask.id}&operation=edit"  class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
<%--     					<a href="#" onclick="openDialog('修改任务信息', '${ctx}/accounttask/tYwTask/form?id=${tYwTask.id}','800px', '500px');" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a> --%>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="accounttask:tYwTask:del">
						<a href="${ctx}/accounttask/tYwTask/delete?id=${tYwTask.id}" onclick="return confirmx('确认要删除该任务信息吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
					</shiro:hasPermission>
    				<shiro:hasPermission name="accountfeedback:tYwFeedback:add">
						<a href="#" onclick="openDialogView('进度录入', '${ctx}/accountfeedback/tYwFeedback/list?id=${tYwTask.id}','80%', '90%');" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 进度录入</a>
					</shiro:hasPermission>
    				<shiro:hasPermission name="accountfeedback:tYwFeedback:audit">
						<a href="#" onclick="openDialogView('进度审核', '${ctx}/accountfeedback/tYwFeedback/list?id=${tYwTask.id}','80%', '90%');" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 进度审核</a>
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