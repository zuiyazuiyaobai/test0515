<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>tj_sszdgjxmxx管理</title>
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
		<form:form id="inputForm" modelAttribute="tj_sszdgjxmxx" action="${ctx}/tj_sszdgjxmxx/tj_sszdgjxmxx/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td class="width-15 active"><label class="pull-right">备注信息：</label></td>
					<td class="width-35">
						<form:textarea path="remarks" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">分类：</label></td>
					<td class="width-35">
						<form:input path="sszdgjxmsl" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">省辖市直管县：</label></td>
					<td class="width-35">
						<form:input path="sxszgx" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">计划总投资：</label></td>
					<td class="width-35">
						<form:input path="jhztz" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">年度计划投资：</label></td>
					<td class="width-35">
						<form:input path="ndjhtz" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">年度已完成投资：</label></td>
					<td class="width-35">
						<form:input path="ndywctz" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">投资完成率：</label></td>
					<td class="width-35">
						<form:input path="tzwcl" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">当月完成投资：</label></td>
					<td class="width-35">
						<form:input path="dywctz" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">已开工项目数量：</label></td>
					<td class="width-35">
						<form:input path="ykgxmsl" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">已投产项目数量：</label></td>
					<td class="width-35">
						<form:input path="ytcxmsl" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">新投产项目数量：</label></td>
					<td class="width-35">
						<form:input path="xtcxmsl" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">新调入项目数量：</label></td>
					<td class="width-35">
						<form:input path="xdrxmsl" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">新调出项目数量：</label></td>
					<td class="width-35">
						<form:input path="xdcxmsl" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">分类标记（1.入库项目数量 2.省（市）重点攻坚产业项目数量 3.各产业项目数量 4.技术改造项目数量 5.本年度计划新开工项目数量 6.年度计划新投产项目数量 7.本年度计划续建项目数量8.当月新开工项目数量 9.新调出项目数量）：</label></td>
					<td class="width-35">
						<form:input path="sign" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
		 	</tbody>
		</table>
	</form:form>
</body>
</html>