<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>项目公司构成</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		var xzList = ${fns:toJson(fns:getDictList('xz'))};//性质 下拉框选项
		var xmid = "${xmid}";//项目ID
        var validateForm;
        var rowNum = ${null == xmgsList ? 0 : fn:length(xmgsList)};//表格行数
		$(document).ready(function() {
            validateForm = $("#inputForm").validate({
                submitHandler: function (form) {
                    loading('正在提交，请稍等...');
                    form.submit();
                },
                errorContainer: "#messageBox",
                errorPlacement: function (error, element) {
                    $("#messageBox").text("输入有误，请先更正。");
                    if (element.is(":checkbox") || element.is(":radio") || element.parent().is(".input-append")) {
                        error.appendTo(element.parent().parent());
                    } else {
                        error.insertAfter(element);
                    }
                }
            });

            calcuCz();
            calcuBfb();
		});

		function doSubmit(func){
            if(!validateForm.form()){
                console.log("some input not valid!");
                return;
			}

            var data = getFormValue("inputForm");
            console.log(data);

            $.post('${ctx}/xmjbxx/sub/cInsBusinessXmgs/saveXmgs',data,function(result){
                console.log(result);
                if(result.success){
                    if(typeof(func) == 'function'){
                        func();
                    }
                }else if (!result.success){
                    showTipCur(result.msg);
                }else{
                    showTipCur("保存失败！");
				}
            });
		}

		function addNewRow(){
            var template = "";
            template += "<tr> ";
            template += "<td width='33%'><input id='gdmc_" + rowNum + "' name='xmgss[" + rowNum + "].gdmc' class='form-control required'/>" +
				"<input type='hidden' name='xmgss[" + rowNum + "].xmid' value='" + xmid + "'/></td> ";
			template += "<td width='15%'> ";
			template += "<select id='xz_" + rowNum + "' name='xmgss[" + rowNum + "].xz' class='form-control required'> ";
			template += "<option value=''></option> ";
			for(var i = 0; i < xzList.length; i++){
				template += "<option value='" + xzList[i].value + "'>" + xzList[i].label + "</option> ";
            }
			template += "</select> ";
			template += "</td> ";
			template += "<td width='20%'><input id='cz_" + rowNum + "' name='xmgss[" + rowNum + "].cz' type='number' sumName='cz' onchange='calcuCz()' class='form-control number required'/></td> ";
			template += "<td width='20%'><input id='bfb_" + rowNum + "' name='xmgss[" + rowNum + "].bfb' type='number' max='100'  sumName='bfb' onchange='calcuBfb()' class='form-control number required'/></td> ";
			template += "<td width='12%'><button type='button' class='btn btn-danger' onclick='minusRow(this)'><i class='fa fa-minus'></i> 删除</button></td> ";
			template += "</tr>";

            $("#tBody").append(template);
            rowNum++;
		}

		function minusRow(ag){
            $(ag).parent().parent().remove();
            reCalculate();
		}

		function calcuCz(){
			var $czs = $("input[sumName='cz']");
			var cz = 0;
			for(var i = 0; i < $czs.length; i ++) {
				var value = $($czs[i]).val();
				if(null != value && '' != value){
					cz += value / 1;
				}
			}
            $("#cz").text(cz);
		}

		function calcuBfb(){
			var $bfbs = $("input[sumName='bfb']");
			var bfb = 0;
			for(var i = 0; i < $bfbs.length; i ++) {
				var value = $($bfbs[i]).val();
				if(null != value && '' != value){
                    bfb += value / 1;
				}
			}
            $("#bfb").text(bfb);
		}

		function reCalculate(){
            calcuCz();
            calcuBfb();
		}
	</script>
</head>
<body class="gray-bg">
<div class="ibox-content">
	<sys:message content="${message}"/>

	<!-- 表格 -->
	<form id="inputForm" action="${ctx}/xmjbxx/xmjbxx/saveSmgsgc">
		<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
			<thead>
			<tr>
				<th>股东名称</th>
				<th>性质</th>
				<th>出资（万元）</th>
				<th>百分比（%）</th>
				<th>操作</th>
			</tr>
			</thead>
			<tbody id="tBody">
			<c:forEach items="${xmgsList}" var="xmgs" varStatus="stats">
				<tr>
					<td width='33%'>
						<input id='gdmc_${stats.index}' name='xmgss[${stats.index}].gdmc' value="${xmgs.gdmc}" class='form-control required'/>
						<input type='hidden' name='xmgss[${stats.index}].id' value='${xmgs.id}'/>
						<input type='hidden' name='xmgss[${stats.index}].xmid' value='${xmgs.xmid}'/>
					</td>
					<td width='15%'>
						<select id='xz_${stats.index}' name='xmgss[${stats.index}].xz' value="${xmgs.xz}" class='form-control required'>
							<option value=''></option>
							<c:forEach items="${fns:getDictList('xz')}" var="xz">
								<option value="${xz.value}" <c:if test="${xz.value == xmgs.xz}">selected</c:if>>${xz.label}</option>
							</c:forEach>
						</select>
					</td>
					<td width='20%'><input id='cz_${stats.index}' name='xmgss[${stats.index}].cz' value="${xmgs.cz}" sumName="cz" onchange="calcuCz()" type='number' class='form-control number required'/></td>
					<td width='20%'><input id='bfb_${stats.index}' name='xmgss[${stats.index}].bfb' value="${xmgs.bfb}" sumName="bfb" onchange="calcuBfb()" type='number' max="100" class='form-control number required'/></td>
					<td width='12%'><button type='button' class='btn btn-danger' onclick='minusRow(this)'><i class='fa fa-minus'></i> 删除</button></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div style="float: right">合计出资：<span id="cz"></span>&nbsp;万元；合计占比：<span id="bfb"></span>&nbsp;%</div>
	</form>
	<br/>
	<div style="text-align: center">
		<button type="button" class="btn btn-primary" onclick="addNewRow()"><i class="fa fa-plus"></i> 新添加</button>
	</div>
	<br/>
</div>
</body>
</html>