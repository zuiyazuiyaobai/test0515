<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>验证密码</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#yzpassword").focus();
		});
	</script>
</head>
<body>
	<form:form id="inputForm" modelAttribute="user" action="${ctx}/sys/user/yzmm2"  method="post" class="form-horizontal form-group">
		<form:hidden path="id"/>
		<sys:message hideType="1" content="${message}"/>
		<div class="control-group">
		</div>
		
		<div class="control-group">
			<label class="col-sm-3 control-label"><font color="red">*</font>请输入密码:</label>
			<div class="controls">
				<input id="yzpassword" name="yzpassword" type="text" value="" maxlength="50" minlength="3"  class="form-control  max-width-250 required"/>
			</div>
		</div>
		
		
	</form:form>
</body>
</html>