<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>字典管理</title>
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
	<script src="${ctxStatic}/common/jquery.validate.custom.js" type="text/javascript"></script>
</head>
<body class="hideScroll">
	<form:form id="inputForm" modelAttribute="cInsBusinessContact" action="${ctx}/xmjbxx/sub/cInsBusinessContact/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
			<tbody>
			<tr>
				<td class="width-15 active"><label class="pull-right">姓名:</label></td>
				<td class="width-35"><form:input path="name" htmlEscape="false" maxlength="50" class="form-control required"/></td>
			</tr>
			<tr>
				<td class="width-15 active"><label class="pull-right">工作单位:</label></td>
				<td class="width-35"><form:input path="office" htmlEscape="false" maxlength="50" class="form-control required"/></td>
			</tr>
			<tr>
				<td class="width-15 active"><label class="pull-right">职务:</label></td>
				<td class="width-35"><form:input path="job" htmlEscape="false" maxlength="50" class="form-control required"/></td>
			</tr>
			<tr>
				<td class="width-15 active"><label class="pull-right">手机:</label></td>
				<td class="width-35"><form:input path="mobile"  maxlength="11" class="form-control required isMobile"/></td>
			</tr>
			<tr>
				<td class="width-15 active"><label class="pull-right">座机:</label></td>
				<td class="width-35"><form:input path="telephone"  maxlength="50" class="form-control required isCall"/></td>
			</tr>
			<tr>
				<td class="width-15 active"><label class="pull-right">电子邮箱:</label></td>
				<td class="width-35"><form:input path="email" htmlEscape="false" maxlength="50" class="form-control email"/></td>
			</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>