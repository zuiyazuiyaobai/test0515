<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>台账信息管理</title>
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
			
					laydate({
			            elem: '#startTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
			        });
					laydate({
			            elem: '#endTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
			        });
		});
	</script>
</head>
<body class="hideScroll">
		<form:form id="inputForm" modelAttribute="tYwProject" action="${ctx}/account/tYwProject/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td class="width-15 active"><label class="pull-right">台账类别：</label></td>
					<td class="width-35">
						<form:select path="category" class="form-control  required">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('account_project_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td>
					<td class="width-15 active"><label class="pull-right">工作名称：</label></td>
					<td class="width-35">
						<form:input path="title" htmlEscape="false"    class="form-control  required"/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">工作内容：</label></td>
					<td class="width-35">
						<form:textarea path="content" htmlEscape="false" rows="4"    class="form-control  required"/>
					</td>
					<td class="width-15 active"><label class="pull-right">时间节点：</label></td>
					<td class="width-35">
						<form:textarea path="timeNode" htmlEscape="false" rows="4"    class="form-control  required"/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">序号：</label></td>
					<td class="width-35">
						<form:input path="sort" htmlEscape="false" maxlength="50" class="required digits form-control "/>
						<span class="help-inline">排列顺序，升序。</span></td>
					</td>
					
					<td class="width-15 active"><label class="pull-right">分管领导：</label></td>
					<td class="width-35">
						<sys:treeselect id="mainLeaderId" name="mainLeaderId" value="${tYwProject.mainLeaderId}" labelName="mainLeader" labelValue="${tYwProject.mainLeader}"
							title="用户" url="/sys/office/treeData?type=3" cssClass="form-control " allowClear="true" notAllowSelectParent="true"/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">启动时间：</label></td>
					<td class="width-35">
						<%-- <input id="startTime" name="startTime" type="text" maxlength="20" class="laydate-icon form-control layer-date "
							value="<fmt:formatDate value="${tYwProject.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
							<fmt:formatDate value="${tYwProject.startTime}" pattern="yyyy-MM-dd"/> --%>
							<input name="startTime" value="<fmt:formatDate value='${tYwProject.startTime}' pattern='yyyy-MM-dd' />" 
							type="date" htmlEscape="false" maxlength="50" class="form-control required"/>
					</td>
					<td class="width-15 active"><label class="pull-right">计划完成时间：</label></td>
					<td class="width-35">
						<%-- <input id="endTime" name="endTime" type="text" maxlength="20" class="laydate-icon form-control layer-date "
							value="<fmt:formatDate value="${tYwProject.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/> --%>
							<input name="endTime" value="<fmt:formatDate value='${tYwProject.endTime}' pattern='yyyy-MM-dd' />" 
							type="date" htmlEscape="false" maxlength="50" class="form-control required"/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">台账状态：</label></td>
					<td class="width-35">
						<form:select path="status" class="form-control  required">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('account_project_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td>
					<td class="width-15 active"><label class="pull-right">联络人：</label></td>
					<td class="width-35">
						<form:input path="contacts" htmlEscape="false"    class="form-control  required"/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">联络人电话：</label></td>
					<td class="width-35">
						<form:input path="contactstel" htmlEscape="false"    class="form-control  required"/>
					</td>
					<td class="width-15 active"><label class="pull-right">备注：</label></td>
					<td class="width-35">
						<form:input path="remark" htmlEscape="false"    class="form-control "/>
					</td>
					<%-- <td class="width-15 active"><label class="pull-right">创建时间：</label></td>
					<td class="width-35">
						<form:input path="createTime" htmlEscape="false"    class="form-control "/>
					</td> --%>
					
				</tr>
				<%-- <tr>
					<td class="width-15 active"><label class="pull-right">备注：</label></td>
					<td class="width-35">
						<form:input path="remark" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"></td>
		   			<td class="width-35" ></td>
		  		</tr> --%>
		 	</tbody>
		</table>
	</form:form>
</body>
</html>