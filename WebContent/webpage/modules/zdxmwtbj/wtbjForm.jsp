<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>重点项目已办结问题管理</title>
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
	<form:form id="inputForm" modelAttribute="cInsBusinessZdxmwt" action="${ctx}/zdxmwtbj/wtbj/save" method="post" class="form-horizontal">
		<%-- <form:hidden path="id"/> --%>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
			<thead>
				<tr>
					<th>处理部门</th>
					<th>处理人</th>
					<th>处理时间</th>
					<th>处理意见</th>
					<th>操作</th>
				</tr>
			</thead>
		   <tbody>
		   	<c:forEach items="${cInsBusinessZdxmwthf }" var="wthf">
			<tr>
				<td>${wthf.deptid}</td>
				<td>${wthf.userid}</td>
				<td><fmt:formatDate value="${wthf.hftime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${wthf.hfnr}</td>
				<c:if test="${wthf.sfhf=='0'}">
				<td>未回复</td>
				</c:if>
				<c:if test="${wthf.sfhf=='1'}">
				<td>已回复</td>
				</c:if>
			</tr>
		</c:forEach>
			<tr>
				<td class="width-15 active"><label class="pull-right">办结回复</label></td>
				<td colspan="4">${cInsBusinessZdxmwthf[0].wtclyj}</td>
			</tr>
		   </tbody>
		</table>
		
		<div class="tabs-container">
            <ul class="nav nav-tabs">
            </ul>
            <div class="tab-content">
		</div>
		</div>
	</form:form>
</body>
</html>