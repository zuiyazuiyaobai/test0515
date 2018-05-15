<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
<title>项目基本信息管理</title>
<meta name="decorator" content="default" />
<script src="${ctxStatic}/common/jquery.validate.custom.js" type="text/javascript"></script>
<script src="${ctxStatic}/module/alert/jquery.alerts.js"></script>
<link href="${ctxStatic}/module/alert/jquery.alerts.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
 #ylclbm {
    		background:rgba(255, 0, 94, 0.18);
    		color:#ff0000;
    		width: 100%;
		    height: 30px;
		    line-height:30px;
		    top:10px
		    padding-left:10px;
		    font-weight:bold; 
		    margin-bottom:2px;
    		}
     #ylclyj {
    		width: 960px;
		    height: 25px;
		    line-height:25px;
		    margin-bottom:0px;
    		}
     #fmclbm {
    		background:rgba(204, 204, 204, 0.48);
    		width: 100%;
		    height: 30px;
		    line-height:30px;
		    padding-left:10px;
		    font-weight:bold; 
		    margin-bottom:2px;
    		}
     #fmclyj {
     		padding-left:10px;
    		
    		width: 960px;
		    height: 25px;
		    line-height:25px;
		    margin-bottom:0px;
    		}
    		.one0{
    			background-color: #3dc1ff;
    			height: 35px;
    		}
    		.one1{
    			background-color: #d00000;
    			height: 35px;
    		}
    		.one2{
    			background-color: #666666;
    			height: 35px;
    		}
    		.one3{
    			background-color: #f88600;
    			height: 35px;
    		}
    		#test1 > ul{
    			display: block;
			    overflow: hidden;
			    white-space:nowrap;
			    text-align:center;
    		}
    		#test1 > ul > li{
    			list-style: none;
			    display: inline-block;
			    width: 130px;
    			color: #fff;
    			line-height:36px;
    		}
    		#test1 >ul >.two{height: 37px;}
    		
</style>
<c:set var="sfsqzxjsjjDisplayValue" value="${xmjbxx.sfsqzxjsjj == '1' ? '' : 'display:none;'}"/>
</head>
<body class="hideScroll" style="padding-top: 20px;">
	<div id="test1" style="height:37px; border-bottom:1px solid #477cb3;  background-color: #fff; z-index: 9999">
		<ul>
			<c:if test="${not empty qyxyList}">
				<li  name="fen10" class="one one0 two" style="width:20%">基本信息</li>
				<li onclick="loadQyxy(1)" name="fen11" class="one one1" style="width:20%">优良信息(<span >${qyxyList.hongmdsl}</span>)</li>
				<li name="loadQyxy(2)" class="one one2" style="width:20%">负面信息(<span >${qyxyList.heimdsl}</span>)</li>
			</c:if>
			<c:if test="${empty qyxyList}">
				<li name="fen10" class="one one0" style="width:20%">基本信息</li>
				<li name="fen11" class="one one1" style="width:20%" >优良信息</li>
				<li name="fen12" class="one one2" style="width:20%" >负面信息</li>
			</c:if>	
			<c:if test="${empty qyxybg}">
				<li name="fen12" class="one one3" style="width:20%" onclick="alert('该企业暂无信用报告！')">信用报告</li>
			</c:if>
			<c:if test="${not empty qyxybg}">
				<li id="qyxybg" qyxybg="${qyxybg}" style="width:20%" onclick="qyxybg()" name="fen12" class="one one3" onclick="alert('该企业暂无信用报告！')">信用报告</li>
			</c:if>		
		</ul>
	</div>
	
	<script type="text/javascript">
					function loadQyxy(pram){
						if(pram==1){
							
						}else if(pram==2){
							
						}
					}
					function qyxybg(){
						var qyxybg=$("#qyxybg").attr("qyxybg");
						window.open(qyxybg);
					}
				</script>
		<div class="tz_sub" id="fen10" name="inputForm1">
		
			<table
				class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
				<tbody>
					<c:if test="${not empty qyxyList}">
					<tr>
						<td class="width-15 active"><label class="pull-right">名称：</label>
						</td>
						<td class="width-35"><input maxlength="200" value="${qyxyList.qymc}" class="form-control " disabled="true"/>
						</td>
						<td class="width-15 active"><label class="pull-right">类型：</label>
						</td>
						<td class="width-35"><input maxlength="200" value="${qyxyList.lx}" class="form-control " disabled="true"/>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">营业执照注册号：</label>
						</td>
						<td class="width-35"><input maxlength="200" value="${qyxyList.yyzzzch}" class="form-control " disabled="true"/>
						</td>
						<td class="width-15 active"><label class="pull-right">组织机构代码：</label>
						</td>
						<td class="width-35"><input maxlength="200" value="${qyxyList.zzjgdm}" class="form-control " disabled="true"/>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">统一社会信用代码：</label>
						</td>
						<td class="width-35"><input maxlength="200" value="${qyxyList.tyshxydm}" class="form-control " disabled="true"/>
						</td>
						<td class="width-15 active"><label class="pull-right">税务登记号：</label>
						</td>
						<td class="width-35"><input maxlength="200" value="${qyxyList.swdjh}" class="form-control " disabled="true"/>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">法定代表人：</label>
						</td>
						<td class="width-35"><input maxlength="200" value="${qyxyList.fddbr}" class="form-control " disabled="true"/>
						</td>
						<td class="width-15 active"><label class="pull-right">注册资本（万）：</label>
						</td>
						<td class="width-35"><input maxlength="200" value="${qyxyList.zczb}" class="form-control " disabled="true"/>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">成立日期：</label>
						</td>
						<td class="width-35"><input maxlength="200" value="${qyxyList.clrq}" class="form-control " disabled="true"/>
						</td>
						<td class="width-15 active"><label class="pull-right">登记状态：</label>
						</td>
						<td class="width-35"><input maxlength="200" value="${qyxyList.djzt}" class="form-control " disabled="true"/>
						</td>
					</tr>
					<tr>

						<td class="width-15 active"><label class="pull-right">住所：</label>
						</td>
						<td class="width-35" colspan="3"><input maxlength="200" value="${qyxyList.zs}" class="form-control " disabled="true"/>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">经营范围：</label>
						</td>
						<td class="width-35" colspan="3"><textarea rows="4"  maxlength="2000" class="form-control ">${qyxyList.jyfw}</textarea>
						</td>
					</tr>
					</c:if>
					<c:if test="${empty qyxyList}">
					<tr>
					暂无该企业信用信息
					</tr>
					</c:if>
				</tbody>
			</table>
			</div>
			<div  id="fen11" name="inputForm1" style="margin-top: 10px;">
			
			</div>
			<div  id="fen12" name="inputForm1" style="margin-top: 10px;">
			
			</div>

<script type="text/javascript">
$(function(){
	qyxycsh();
});
	function qyxycsh() {
		var qyyljlList_list = ${qyyljlList};
		 var ylxxTable ="";
		var fmxxTable="";
		  $.each(qyyljlList_list.qyyljlList,function(n,value){
		  	if(value.xxlx=="0"){
		  	ylxxTable+="<p id='ylclbm'>"+value.zlbm+"</p>";
		    ylxxTable+="<p id='ylclyj'>"+value.zlyj+"</p>";
		    var contentTable = "<table class='table table-bordered  table-condensed dataTables-example dataTable no-footer'>";
		     var contentTr="<tr>";
		     var contentTd="<td class='width-15 active'>";
		     var contentTd2="</td>";
		     var contentTdd="<td  class='width-35'>";
		     var contentTr2="</tr>";
		     var contentTable2 = "</table>";
		     var appendHtml = "<tr>";
		     var zlnr=value.zlnr;
			 $(zlnr).find('item').each(function(i, index){
			      var label = $(this).attr("label");
			      var label_content = $(this).text();
			      if(label){
			    	  appendHtml+= contentTd+label;
				      appendHtml+=contentTd2;
				      appendHtml+=contentTdd;
				      appendHtml+=label_content;
				      appendHtml+=contentTd2;
				      if(i%2==1){
				       appendHtml+=contentTr2+contentTr;
				      }
			      }
			 });
			 
		 	appendHtml=appendHtml.substr(0, appendHtml.length-4); //去除多余一个<tr>
		    contentTable=contentTable+appendHtml+contentTable2;
		    ylxxTable+=contentTable;
		  	}else{
		  	fmxxTable+="<p id='fmclbm'>"+value.zlbm+"</p>";
		    fmxxTable+="<p id='fmclyj'>"+value.zlyj+"</p>";
		    var contentTable = "<table class='table table-bordered  table-condensed dataTables-example dataTable no-footer'>";
		     var contentTr="<tr>";
		     var contentTd="<td class='width-15 active'>";
		     var contentTd2="</td>";
		     var contentTdd="<td  class='width-35'>";
		     var contentTr2="</tr>";
		     var contentTable2 = "</table>";
		     var appendHtml = "<tr>";
		     var zlnr=value.zlnr;
			 $(zlnr).find('item').each(function(i, index){
			      var aa = $(zlnr).find('item')[i];
			      var label = $(this).attr("label");
			      var label_content = $(this).text();
				  if(label){
					  appendHtml+= contentTd+label;
				      appendHtml+=contentTd2;
				      appendHtml+=contentTdd;
				      appendHtml+=label_content;
				      appendHtml+=contentTd2;
				      if(i%2==1){
				       appendHtml+=contentTr2+contentTr;
				      }
			      }
			 });
			 
		 	appendHtml=appendHtml.substr(0, appendHtml.length-4); //去除多余一个<tr>
		    contentTable=contentTable+appendHtml+contentTable2;
		    fmxxTable+=contentTable;
		  	
		  	}
		  })
		  debugger;
		  $("#fen11").html(ylxxTable);
		  $("#fen12").html(fmxxTable);
	}
 	$("#test1").bind("click", function (e) {
        switchTab1(e);//切换到目标tab
    });
    function switchTab1(e){
    e = e || window.event;
    var tar = e.srcElement || e.target;
    if (tar.nodeName.toLowerCase() == "li" && !$(tar).hasClass('two')) {
        $(tar).addClass("two");
        $(tar).siblings().removeClass("two");
        $("div[name='inputForm1']").each(function(){
            if($(this).attr("id") == $(tar).attr("name")){
                $(this).show();
            }else{
                $(this).hide();
            }
        })
    }
    }
</script>
</body>
</html>
