<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>通知管理</title>
	<meta name="decorator" content="default"/>
	<link href="${ctxStatic}/editor/themes/default/default.css" rel="stylesheet">
	<link href="${ctxStatic}/editor/plugins/code/prettify.css" rel="stylesheet">
	<script charset="utf-8" src="${ctxStatic}/editor/kindeditor.js"></script>
	<script charset="utf-8" src="${ctxStatic}/editor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="${ctxStatic}/editor/plugins/code/prettify.js"></script>
	
	<script type="text/javascript">
		
		var editor1 ;
		KindEditor.ready(function(K) {
				editor1 = K.create('textarea[name="content"]', {
				cssPath : '../plugins/code/prettify.css',
				uploadJson : '../jsp/upload_json.jsp',
				fileManagerJson : '../jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
		
		var validateForm;
		function doSubmit(){//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
		  if(validateForm.form()){
			  $("#inputForm").submit();
			  return true;
		  }
	
		  return false;
		}
		//每秒同步一次富文本信息
		function sync(){
			editor1.sync();
		}
		$(document).ready(function() {
			var t1 = window.setInterval(sync,1000); 
			//$("#name").focus();
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
	<form:form id="inputForm" modelAttribute="notify" action="${ctx}/notice/notify/save?noticeType=1" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		      <tr>
		         <td  class="width-15 active" style="width:10%">	<label class="pull-right"><font color="red">*</font>发布分类：</label></td>
		         <td class="width-35" style="width:90%"><form:select path="type" class="form-control required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('oa_notify_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select>
				</td>
			  </tr>
		       <tr>	
		         <td  class="width-15 active">	<label class="pull-right"><font color="red">*</font>标题：</label></td>
		         <td class="width-35" ><form:input path="title" htmlEscape="false" maxlength="200" class="form-control required"/></td>
		      </tr>
		       <tr>
		         <td  class="width-15 active">	<label class="pull-right"><font color="red">*</font>内容：</label></td>
		         <td class="width-35" >
			         <form:textarea path="content" id="content" htmlEscape="false" rows="6"  class="form-control required" style="width:100%"/>
		         </td>
		       
		      </tr>
		       <tr>
		        
		         <td  class="width-15 active">	<label class="pull-right">附件：</label></td>
		         <td class="width-35" >
		         <c:if test="${notify.status ne '1'}">
					<form:hidden id="files" path="files" htmlEscape="false" maxlength="255" class="form-control"/>
					<sys:ckfinder input="files" type="files" uploadPath="/notice/notify" selectMultiple="true"/>
				</c:if>
		         <c:if test="${notify.status eq '1'}">
					<form:hidden id="files" path="files" htmlEscape="false" maxlength="255" class="form-control"/>
					<sys:ckfinder input="files" type="files" uploadPath="/notice/notify" selectMultiple="true" readonly="true" />
		         </c:if>
		         
		         
		         </td>
		      </tr>
		      
		      <c:if test="${notify.status ne '1'}">
		      	 <tr>
			         <td  class="width-15 active">	<label class="pull-right"><font color="red">*</font>状态：</label></td>
			         <td class="width-35" ><form:radiobuttons path="status" items="${fns:getDictList('oa_notify_status')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks required"/></td>
			     </tr>
		       <tr>    
			         <td  class="width-15 active">	<label class="pull-right"><font color="red">*</font>接受人：</label></td>
			         <td class="width-35" ><sys:treeselect id="notifyRecord" name="notifyRecordIds" value="${notify.notifyRecordIds}" labelName="notifyRecordNames" labelValue="${notify.notifyRecordNames}"
							title="用户" url="/sys/office/treeData?type=3" cssClass="form-control required" notAllowSelectParent="true" checked="true"/></td>
		      	</tr>
			</c:if>
			
					<c:if test="${notify.status eq '1'}">
					  <tr>
				         <td  class="width-15 active">	<label class="pull-right">接受人：</label></td>
				         <td class="width-35" colspan="3"><table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
								<thead>
									<tr>
										<th>接受人</th>
										<th>接受部门</th>
										<th>阅读状态</th>
										<th>阅读时间</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${notify.notifyRecordList}" var="notifyRecord">
									<tr>
										<td>
											${notifyRecord.user.name}
										</td>
										<td>
											${notifyRecord.user.office.name}
										</td>
										<td>
											${fns:getDictLabel(notifyRecord.readFlag, 'oa_notify_read', '')}
										</td>
										<td>
											<fmt:formatDate value="${notifyRecord.readDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
							已查阅：${notify.readNum} &nbsp; 未查阅：${notify.unReadNum} &nbsp; 总共：${notify.readNum + notify.unReadNum}</td>
				      </tr>
		</c:if>
		</tbody>
		</table>
		     
		

	</form:form>
</body>
</html>