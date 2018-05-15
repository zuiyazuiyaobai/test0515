<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp" %>
<html>
<head>
    <title>调度任务管理</title>
    <meta name="decorator" content="default"/>
    <script src="${ctxStatic}/module/task/schedulerTaskForm.js"></script>
    <script src="${ctxStatic}/module/alert/jquery.alerts.js"></script>
    <link href="${ctxStatic}/module/alert/jquery.alerts.css" rel="stylesheet" type="text/css"/>
    <script>
        var tab = '1';
    </script>
    <style>
        .tab:hover {
            cursor: pointer;
        }

        .tab {
            float: left;
            width: 10%;
            height: 30px;
            text-align: center;
            line-height: 30px;
            padding-bottom: 0;
            list-style-type: none;
        }

        .tab_cur {
            float: left;
            width: 10%;
            height: 30px;
            text-align: center;
            line-height: 30px;
            padding-bottom: 0;
            list-style-type: none;
            background: linear-gradient(#477cb3, #FFFFFF);
        }
    </style>
    <script type="text/javascript">
    
		$(document).ready(function () {
			
			var sfsjjFlag = $("#sfsjjFlag").val();
		
			if(sfsjjFlag==1){
				$("#fen2").css('display', 'block');
			}
			else{
				$("#fen2").css('display', 'none');
			}
			
			var year = 2017;
			var month = 12;
			var day = 20;
			$("#startDate").val("2017-12-20");
			var month =  getFirstDayOfMonth(new Date(year, month, day));
			//alert(month);
			$("#endDate").val(month);
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
		
		    $('#contentTable thead tr th input.i-checks').on('ifChecked', function(event){ //ifCreated 事件应该在插件初始化之前绑定
		        $('#contentTable tbody tr td input.i-checks').iCheck('check');
		    });
		
		    $('#contentTable thead tr th input.i-checks').on('ifUnchecked', function(event){ //ifCreated 事件应该在插件初始化之前绑定
		        $('#contentTable tbody tr td input.i-checks').iCheck('uncheck');
		    });
		
		
		    bindTabSwitchEven();
		
		    if (null != tab && '' != tab && tab != '1') {
		        $("li[name='tab_" + tab + "']").each(function () {
		            $(this).click()
		        });
		    }
		    jsq();
		    var rwll = "${type}";
		    var obj = document.getElementById("typerwlx");
		    if(rwll=="2018年省重点项目"){
		    	$("#typerwlx ").get(0).selectedIndex=0; 
		    }else if(rwll=="2018年省基建项目"){
		    	$("#typerwlx ").get(0).selectedIndex=1; 
		    }else if(rwll=="5818项目"){
		    	$("#typerwlx ").get(0).selectedIndex=2; 
		    }else if(rwll=="省节能减排专项资金项目"){
		    	$("#typerwlx ").get(0).selectedIndex=3; 
		    }else if(rwll=="京豫南北水调对口协作项目"){
		    	$("#typerwlx ").get(0).selectedIndex=4; 
		    }else if(rwll=="现代服务业重点项目"){
		    	$("#typerwlx ").get(0).selectedIndex=5; 
		    }else if(rwll=="省转型发展攻坚项目"){
		    	$("#typerwlx ").get(0).selectedIndex=6; 
		    }else if(rwll=="省先进制造重大项目"){
		    	$("#typerwlx ").get(0).selectedIndex=7; 
		    }else if(rwll=="12"){
		    	$("#typerwlx ").get(0).selectedIndex=8; 
		    }else if(rwll=="13"){
		    	$("#typerwlx ").get(0).selectedIndex=9; 
		    }else if(rwll=="其他项目"){
		    	$("#typerwlx ").get(0).selectedIndex=10; 
		    }else{}
		    
		});
    
    	function doSubmit(func) {//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
		    if (validateForm.form()) {//校验输入
		           saveSchedulerTask(function(){
		                if (typeof func === 'function') {
		                    func();
		                }
		            });
		        }
		}
		 function saveSchedulerTask(func){
		    var data = getFormValue("inputForm");
		    baocun();
		    $.post(ctx + "/task/schedulerTask/saveSchedulerTask", data, function(result){
		        if(result.success){
		            $("#id").val(result.body.id);
		            showTipCur(result.msg);
		           	if(typeof func === 'function'){
		                func();
		            }
		            return false;
		        }else if(!result.success){
		            showTipCur(result.msg);
		            return false;
		        }else{
		            showTipCur("调度任务保存失败！");
		            return false;
		        }
		    });
		}
		
		//获取当月第一天
 		function getFirstDayOfMonth (date) {
     		date.setDate(10);
     		return timeFormat(date);
		 }
		
		//日期格式化，返回值形式为yy-mm-dd
		function timeFormat(date) {
	 	   if (!date || typeof(date) === "string") {
	 	       this.error("参数异常，请检查...");
		   }
	       var y = date.getFullYear(); //年
	       var m = date.getMonth() + 1; //月
	       var d = date.getDate(); //日
	       return y+"-"+(m<10?"0"+m:m)+"-"+(d<10?"0"+d:d);
		 }  
		 //计算器
		function jsq(){
			for(var i = 1; i < 7; i++) {
		        $(".row_" + i).each(function(){
		            $(this).bind("change", function () {
		                if($(this).hasClass("row_1")){
		                    calcuSum(1);
		                }else{
		                }
		            });
		        });
		        //加载完先调用一次
		        calcuSum(i);
		    }
		}
		function calcuSum(index){
		    var rows = $(".row_" + index);
		    var result = 0;
		    var subSum1 = 0;
		    var subSum2 = 0;
		    var subSum3 = 0;
		    for(var i = 0; i < rows.length; i++){
		        var value = $(rows[i]).val();
		        if(value != null && value != ''){
		            result += value / 1;
		
		            // 统计分类小项
		            if(i >= 2 && i <= 9 ){
		                subSum1 += value / 1;
		            }else if(i >= 10 && i <= 12){
		                subSum2 += value / 1;
		            }else if(i >= 13 && i <= 15){
		                subSum3 += value / 1;
		            }
		        }
		    }
		    $(".sum_" + index).val(result);
		    $(".sum1_" + index).val(subSum1);
		    $(".sum2_" + index).val(subSum2);
		    $(".sum3_" + index).val(subSum3);
		}
		function baocun(){
			var tzxdwh = $("#tzxdwh").val();
			if(tzxdwh == ""){
				jAlert("投资计划下达文号不可为空！","投资项目在线管理系统");
				return;
			}
			var tzjgwjmc = $("#tzjgwjmc").val();
			if(tzjgwjmc == ""){
				jAlert("投资计划文件名称不可为空！","投资项目在线管理系统");
				return;
			}
			var requirement = $("#requirement").val();
			if(requirement == ""){
				jAlert("调度需求不可为空！","投资项目在线管理系统");
				return;
			}
			var param1 = new Object();
			var objss=get_ssqkOjbect();
			param1.ssqkInfo = JSON.stringify(objss);
			param1.xmjbxxid=$("#xmjbxx_id").val();
        	$.ajax({
				url : "${ctx}/task/schedulerTask/savaSsqkInfo",
				type : "post",
				async: false,
				data : param1
			});
		}
		function chaelec(){
			var vatt = $("#typerwlx").val();
			if(vatt ==3 || vatt ==4||vatt==12){
				$("#fen2").show();
			}else{
				$("#fen2").hide();
			}
		}
		function bcbg(){
			 
		}
		function get_ssqkOjbect(){
			var objess={
				zyysntzLjdwzj:$("#zyysntz_ljdwzj").val(),
				qtzyczxjszjljdwzj:$("#qtzyczxjszj_ljdwzj").val(),
				//zxzqmjdzxjszjljdwzj:$("#").val(),
				zysljsjjljdwzj:$("#zysljsjj_ljdwzj").val(),
				nsbdgcjjljdwzj:$("#nsbdgcjj_ljdwzj").val(),
				tljszxjjljdwzj:$("#tljszxjj_ljdwzj").val(),
				mhfzjjljdwzj:$("#mhfzjj_ljdwzj").val(),
				gjzdslgcjsjjljdwzj:$("#gjzdslgcjsjj_ljdwzj").val(),
				dzxskymhqfcjjljdwzj:$("#dzxskymhqfcjj_ljdwzj").val(),
				dzxskymhqfcjyjjljdwzj:$("#dzxskymhqfcjyjj_ljdwzj").val(),
				glgkjszxjjljdwzj:$("#glgkjszxjj_ljdwzj").val(),
				shengjiysntzljdwzj:$("#shengjiysntz_ljdwzj").val(),
				shijiysntzljdwzj:$("#shijiysntz_ljdwzj").val(),
				xianjiysntzljdwzj:$("#xianjiysntz_ljdwzj").val(),
				
				shengjiczzjljdwzj:$("#shengjiczzj_ljdwzj").val(),
				shijiczzjljdwzj:$("#shijiczzj_ljdwzj").val(),
				xianjiczzjljdwzj:$("#xianjiczzj_ljdwzj").val(),
				dfzxjsjjljdwzj:$("#dfzxjsjj_ljdwzj").val(),
				qyzytzljdwzj:$("#qyzytz_ljdwzj").val(),
				yhdkljdwzj:$("#yhdk_ljdwzj").val(),
				lywzljdwzj:$("#lywz_ljdwzj").val(),
				zjqdddljdwzj:$("#zjqddd_ljdwzj").val(),
				qtzjljdwzj:$("#qtzj_ljdwzj").val()
			};	
			return objess;
		}
    </script>
</head>
<body class="hideScroll">

<input id="sfsjjFlag" type="hidden" value="${sfsjjFlag}"/>

<%-- 页首tab --%>
<div id="test" style="height:30px; border-bottom:1px solid #477cb3;margin-bottom:15px;">
    <ul>
        <li name="tab_1" class="tab tab_cur">基本信息</li>
        <!--  <a class="" style="cursor:pointer;width:45px;height:25px;background: #146be2;display: block;color: #fff;border-radius: 7px;
          	font-size: 16px;font-weight: bold;text-align:center; margin-left:700px;margin-top:0px;margin-bottom:20px;" 
          	onclick="baocun()">保存</a> -->
        <%--<li name="tab_2" class="tab">调度项目</li>

        <span id="taskOriginSpan" style="float: right; height: 30px; text-align: center; line-height: 30px; padding: 0 10px 0 0; display:none">
            项目来源：
            <select id="type" name="type" style="width: 150px; border: 1px solid #e5e6e7; border-radius: 1px;font-size: 14px;">
                <c:forEach items="${fns:getDictList('task_origin')}" var="dict">
                    <option value="${dict.value}" <c:if test="${cInsBusinessSchedulerTask.origin == dict.value}">selected</c:if>>${dict.label}</option>
                </c:forEach>
            </select>
        </span>--%>
    </ul>
</div>

<fieldset id="schedulerTask">
<%-- 任务调度基本信息 --%>
<div id="tab_1">
<form:form id="inputForm" modelAttribute="cInsBusinessSchedulerTask" action="${ctx}/task/cInsBusinessSchedulerTask/save" method="post"
           class="form-horizontal">
    <form:hidden path="origin"/>
    <table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
        <tbody>
        <tr>
            <td class="width-15 active"><label class="pull-right"><font color="red">*</font>投资计划下达文号：</label></td>
            <td class="width-35">
                <form:input path="remarks"  htmlEscape="false" maxlength="128" id="tzxdwh"  class="form-control required"/>
            </td>
            <td class="width-15 active"><label class="pull-right"><font color="red">*</font>投资计划文件名称：</label></td>
            <td class="width-35">
                <form:input path="name"  htmlEscape="false" maxlength="128" id="tzjgwjmc" class="form-control required"/>
            </td>
        </tr>
        <tr>
            <td class="width-15 active"><label class="pull-right"><font color="red">*</font>调度开始时间：</label></td>
            <td class="width-35">
                <input id="startDate" name="startDate" value=""
                       htmlEscape="false" class="form-control required"/>
            </td>
            <td class="width-15 active"><label class="pull-right"><font color="red">*</font>调度结束时间：</label></td>
            <td class="width-35">
                <input id="endDate" name="endDate" value=""
                       htmlEscape="false" class="form-control required"/>
            </td>
        </tr>
        <tr>
        	<td class="width-15 active"><label class="pull-right"><font color="red">*</font>任务类型：</label></td>
            <td class="width-35">
                <form:select path="type" id="typerwlx" onchange="chaelec()" class="form-control required">
                    <form:option value="2" label="2018年省重点项目调度"/>
                    <form:option value="4" label="2018年省基建项目调度"/>
                    <form:option value="5" label="5818项目调度"/>
                    <form:option value="7" label="省节能减排专项资金调度"/>
                    <form:option value="8" label="京豫南北水调对口协作调度"/>
                    <form:option value="9" label="服务业重点项目调度"/>
                    <form:option value="10" label="省转型发展攻坚项目"/>
                    <form:option value="11" label="省先进制造重大项目"/>
                    <form:option value="12" label="2018年交通基础设施省补助资金项目"/>
                    <form:option value="13" label="健康养老示范项目"/>
                     <form:option value="6" label="其他项目调度"/>
                </form:select>
            </td>
            <td class="width-15 active"><label class="pull-right">调度需求：</label></td>
            <td  class="width-35">
            	<form:input path="requirement" name="requirement" htmlEscape="false" id="requirement" maxlength="128" class="form-control required"/>
            </td>
        </tr>
		
        </tbody>
    </table>
</form:form>
<div id="fen2">
<%-- 投资情况 start --%>
<form:form id="inputForm2" modelAttribute="xmjbxx" action="#" method="post" class="form-horizontal">
	<jsp:include page="tzqkForm.jsp"></jsp:include>
</form:form>
<%-- 投资情况 end --%>
</div>
</div>
</fieldset>
</body>
</html>