<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>重点项目问题回复管理</title>
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
		<form:form id="inputForm" modelAttribute="cInsBusinessZdxmwthf" action="${ctx}/zdxmwthf/wthf/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		   	<tr style="font-size:16px;font-weight:bold;font-family:微软雅黑;padding:0px 10px;"><td colspan="5" align="center">问题基本信息</td></tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">问题类型</label></td>
					<td colspan="4">${cInsBusinessZdxmwthf.cInsBusinessZdxmwt.wttype}</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">类型选择</label></td>
					<td colspan="4">${cInsBusinessZdxmwthf.cInsBusinessZdxmwt.stagetype}</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">重点工程项目编号</label></td>
					<td colspan="4">${cInsBusinessZdxmwthf.cInsBusinessZdxmwt.zdgcxmbh}</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">问题层级</label></td>
					<td colspan="4">${cInsBusinessZdxmwthf.cInsBusinessZdxmwt.wtlevel}</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">问题描述</label></td>
					<td colspan="4">${cInsBusinessZdxmwthf.cInsBusinessZdxmwt.wtdescribe}</td>
				</tr>
			<tr style="font-size:16px;font-weight:bold;font-family:微软雅黑;padding:0px 10px;"><td colspan="5" align="center">问题回复</td></tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">回复内容</label></td>
					<td colspan="4"><textarea id="hfnr" name="hfnr" maxlength="1000" class="form-control required" rows="5"></textarea></td>
				</tr>
		   </tbody>
		</table>
	</form:form>
</body>
</html>