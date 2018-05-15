<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>请假表单管理</title>
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
			//根据复审状况判断意见和重点项目编码编辑状态；
		$('#fsType').change(function(){
			var type=$('#fsType').val();
			if(type=='1'){
				$('#fsmsg').removeClass();
				$('#fsmsg').addClass('form-control');
				$('#fsmsg-error').remove();
				$('#zdgcxmbm').attr("disabled",false);
			}else{
				$('#fsmsg').removeClass();
				$('#fsmsg').addClass('form-control required');
				$('#zdgcxmbm').attr("disabled","disabled");
			}
		});
		});
	</script>
</head>
<body class="hideScroll">
		<form:form id="inputForm" modelAttribute="zdgcxm" action="${ctx}/zdxmbj/bj/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		  	    <tr style="font-size:16px;font-weight:bold;font-family:微软雅黑;padding:0px 10px;"><td colspan="5" align="center">审核意见</td></tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">复审状况</label></td>
					<td colspan="4">
						<select id="fsType" name="fstype" class="form-control m-b" style="width:150px;" disabled="disabled">
						　　 <option value="1" selected = "selected">同意</option>
						　　 <option value="2">不同意</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">复审意见</label></td>
					<td colspan="4"><textarea id="fsmsg" name="fsmsg" maxlength="200" class="form-control" rows="3" disabled="disabled">${zdgcxm.fsmsg }</textarea></td>
				</tr>
		   		<tr style="font-size:16px;font-weight:bold;font-family:微软雅黑;padding:0px 10px;"><td colspan="5" align="center">项目单位基本信息</td></tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">重点工程项目编码</label></td>
					<td colspan="4">${zdgcxm.zdgcxmbh}</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">单位名称</label></td>
					<td colspan="4">${zdgcxm.info.incname}</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">证照代码</label></td>
					<td colspan="4">${zdgcxm.info.incid}</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">单位性质</label></td>
					<td colspan="4">${zdgcxm.info.inctype}</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">单位分类</label></td>
					<td colspan="4">${zdgcxm.info.increlation}</td>
				</tr>
				
				<tr style="font-size:16px;font-weight:bold;font-family:微软雅黑;padding:0px 10px;"><td colspan="5" align="center">申报项目基本信息</td></tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">项目名称</label></td>
					<td colspan="4">${zdgcxm.info.projectname}</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">项目所属行业</label></td>
					<td colspan="4">${zdgcxm.info.psortparentname}
					${zdgcxm.info.psortname}
					${zdgcxm.info.psortonename}
					${zdgcxm.info.psorttwoname}</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">项目建设地</label></td>
					<td colspan="4">${zdgcxm.info.areaname}${zdgcxm.info.areaidtwoname}</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">项目建设性质</label></td>
					<td colspan="4">${zdgcxm.info.projectnature}</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">重点项目类型</label></td>
					<td colspan="4">${zdgcxm.zdxmlx}</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">产业类型大类</label></td>
					<td colspan="4">${zdgcxm.cylxone}</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">产业类型</label></td>
					<td colspan="4">${zdgcxm.cylx}</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">项目建设规模及内容</label></td>
					<td colspan="4">${zdgcxm.info.constructionscale}</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">计划开工年限</label></td>
					<td colspan="4">
					<fmt:formatDate value="${zdgcxm.info.starttime}" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">计划完工年限</label></td>
					<td colspan="4">
					<fmt:formatDate value="${zdgcxm.info.endtime}" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">项目估算总投资</label></td>
					<td colspan="4">${zdgcxm.info.grossinvestment} 万元</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">项目建设资金来源</label></td>
					<td colspan="4">
						自有资金${zdgcxm.info.zyzj}万元
						&nbsp;&nbsp;申请政府投资${zdgcxm.info.sqzftz}万元
						&nbsp;&nbsp;银行贷款${zdgcxm.info.yhdk}万元
						&nbsp;&nbsp;其他${zdgcxm.info.qt}万元
					</td>
				</tr>
				
			<tr style="font-size:16px;font-weight:bold;font-family:微软雅黑;padding:0px 10px;"><td colspan="5" align="center">项目单位联系方式</td></tr>
				<tr>
					<td class="width-15 active" rowspan="4"><label class="pull-right">联系方式</label></td>
					<td class="width-15 active"><label class="pull-right">法人代表姓名</label></td>
					<td>${zdgcxm.info.pagename}</td>
					<td class="width-15 active"><label class="pull-right">固定电话(含区号)</label></td>
					<td>${zdgcxm.info.pagephone}</td>
				</tr>	
				<tr>
					<td class="width-15 active"><label class="pull-right">经办人姓名</label></td>
					<td>${zdgcxm.info.agename}</td>
					<td class="width-15 active"><label class="pull-right">固定电话(含区号)</label></td>
					<td>${zdgcxm.info.agephone}</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">负责人姓名</label></td>
					<td>${zdgcxm.fzrname}</td>
					<td class="width-15 active"><label class="pull-right">负责人手机号</label></td>
					<td>${zdgcxm.fzrtel}</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">经办人移动电话</label></td>
					<td>${zdgcxm.info.agemobile}</td>
					<td class="width-15 active"><label class="pull-right">电子邮箱</label></td>
					<td>${zdgcxm.info.ageemail}</td>
				</tr>	
							
		 	</tbody>
		</table>
	</form:form>
</body>
</html>