<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>任务信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
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
<body class="hideScroll">
		<form:form id="inputForm" modelAttribute="tYwTask" action="${ctx}/accounttask/tYwTask/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
			<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
			   <tbody>
					<tr>
						<td class="width-15 active"><label class="pull-right">任务名称：</label></td>
						<td class="width-35">
							<form:input path="taskTitle" htmlEscape="false"    class="form-control required"/>
						</td>
						<td class="width-15 active"><label class="pull-right">任务内容：</label></td>
						<td class="width-35">
							<form:input path="taskContent" htmlEscape="false"    class="form-control required"/>
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
								title="部门" url="/sys/office/treeData?type=2" cssClass="form-control required" allowClear="true" notAllowSelectParent="true"/>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">责任人：</label></td>
						<td class="width-35">
							<sys:treeselect id="responsePersonId" name="responsePersonId" value="${tYwTask.responsePersonId}" labelName="responsePerson" labelValue="${tYwTask.responsePerson}"
								title="用户" url="/sys/office/treeData?type=3" cssClass="form-control required" allowClear="true" notAllowSelectParent="true"/>
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
							<form:select path="frequency" class="form-control ">
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
							<form:select path="taskStatus" class="form-control required">
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
			<c:if test="${operation == 'edit' }">
				<input type="button" class="btn btn-danger btn-xs" onclick="window.history.go(-1)" style="width:50px" value="返 回"/> &nbsp;&nbsp;&nbsp;
				<input type="submit" class="btn btn-info btn-xs" style="width:50px" value="提 交"/>
			</c:if>
			</div>
	</form:form>
</body>
</html>