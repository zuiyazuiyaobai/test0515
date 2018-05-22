<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>反馈信息管理</title>
	<meta name="decorator" content="default"/>
		<link rel="stylesheet" href="${ctxStatic}/module/xmjbxx/css/xmjbxxForm.css" type="text/css">
		<script type="text/javascript" src="${ctxStatic}/module/account/js/account_feedback/feedbackForm.js"></script>
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


		<form:form id="inputForm" modelAttribute="tYwFeedback" action="${ctx}/accountfeedback/tYwFeedback/save" method="post" class="form-horizontal">
		<%-- <form:hidden path="id"/> --%>
		<form:hidden path="taskId" value="${tYwTask.id}"/>
		<form:hidden path="parentId" value="${tYwTask.parentId}"/>
		<sys:message content="${message}"/>	
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
		<c:if test="${operation == 'edit' }">
			<shiro:hasPermission name="accountfeedback:tYwFeedback:add">
				<input type="button" class="btn btn-danger btn-xs" onclick="window.history.go(-1)" style="width:50px" value="返 回"/> &nbsp;&nbsp;&nbsp;
				<input type="submit" class="btn btn-info btn-xs" style="width:50px" value="提 交"/>
			</shiro:hasPermission>
		</c:if>
		</div>
	</form:form>
</body>
</html>