<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>请假表单管理</title>
	<meta name="decorator" content="default"/>
	<style type="text/css">  
            #content {  
                width: 950px;  
                height: 750px;  
            }  
              
            #tab_bar {  
                width: 950px;  
                height: 30px;  
                float: left;  
            }  
            #tab_bar ul {  
                padding: 0px;  
                margin: 0px;  
                height: 30px;  
                text-align: center;  
            }  
              
            #tab_bar li {  
                list-style-type: none;  
                float: left;  
                width: 133.3px;  
                height: 30px;  
                background-color: #EEE;  
            }  
              
            .tab_css {  
                width: 950px;  
                height: 750px;  
               /* background-color: orange;  */
                display: none;  
                float: left;  
            }  
              
        </style>  
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
		var myclick = function(v) {  
                var llis = document.getElementsByTagName("li");  
                for(var i = 0; i < llis.length; i++) {  
                    var lli = llis[i];  
                    if(lli == document.getElementById("tab" + v)) {  
                        lli.style.backgroundColor = "orange";  
                    } else {  
                        lli.style.backgroundColor = "#EEE";  
                    }  
                }  
  
                var divs = document.getElementsByClassName("tab_css");  
                for(var i = 0; i < divs.length; i++) {  
  
                    var divv = divs[i];  
  
                    if(divv == document.getElementById("tab" + v + "_content")) {  
                        divv.style.display = "block";  
                    } else {  
                        divv.style.display = "none";  
                    }  
                }  
  
            }  
	</script>
</head>
<body class="hideScroll">
	<div id="content"> 
		<div id="tab_bar">  
                <ul style="font-size:16px;font-weight:bold;font-family:微软雅黑;padding:0px 10px;">  
                    <li id="tab1" onclick="myclick(1)" style="background-color: orange;">  
                        基本信息表  
                    </li>  
                    <li id="tab2" onclick="myclick(2)">  
                        工程进展情况  
                    </li>  
                </ul>  
            </div>
      <div class="tab_css" id="tab1_content" style="display: block">
      	<div>
		<form:form id="inputForm" modelAttribute="zdgcxm" action="${ctx}/zdxmfs/cInsBusinessZdgcxm/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
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
					<td class="width-15 active" rowspan="5"><label class="pull-right">联系方式</label></td>
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
	</div>
	</div>
	<div class="tab_css" id="tab2_content">  
    	<div>
    		<div class="ibox-content">
	<sys:message content="${message}"/>
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="cInsBusinessZdgcxm" action="${ctx}/zdgcxm/gcjz/form?areaname=${page.list[0].areaname }&year=${page.list[0].year }&month=${page.list[0].month }&jdpj=${page.list[0].jdpj }" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		统计年份：<select id="year" name="year" class="form-control required">
				 	<c:forEach items="${years }" var="year">
				 		<option value="${year }">${year }</option>
				 	</c:forEach>
				 </select>&nbsp;&nbsp;
		统计月份：<select id="month" name="month" class="form-control required">
			     	<option value="01">01</option>
			     	<option value="02">02</option>
			     	<option value="03">03</option>
			     	<option value="04">04</option>
			     	<option value="05">05</option>
			     	<option value="06">06</option>
			     	<option value="07">07</option>
			     	<option value="08">08</option>
			     	<option value="09">09</option>
			     	<option value="10">10</option>
			     	<option value="11">11</option>
			     	<option value="12">12</option>
		         </select>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		 </div>	
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-right">
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()" ><i class="fa fa-search"></i> 查询</button>
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()" ><i class="fa fa-refresh"></i> 重置</button>
		</div>
	</div>
	</div>
	
	<!-- 表格 -->
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
			<tr>
				<th  class="sort-column readstatus">项目名称</th>
				<th  class="sort-column readstatus">项目编码</th>
				<th  class="sort-column readstatus">重点工程项目编号</th>
				<th  class="sort-column readstatus">年度</th>
				<th  class="sort-column readstatus">月度</th>
				<th  class="sort-column readstatus">进度评价</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="gcjzqk">
			<tr>
				 <td class="">
                          ${gcjzqk.projectname}
				</td>
				 <td class="">
                          ${gcjzqk.projectid}
				</td>
				<td class="">
                          ${gcjzqk.xmid}
				</td>
				<td class="">
                          ${gcjzqk.year}
				</td>
				<td class="">
                          ${gcjzqk.month}
				</td>
				<td class="">
                          ${gcjzqk.jdpj}
				</td>
				<td>
					<shiro:hasPermission name="zdgcxm:gcjz:list">
						<a href="#" onclick="openDialogView('工程进展情况', '${ctx}/zdgcxm/gcjz/edit?id=${gcjd.id}','1000px', '750px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
		<!-- 分页代码 -->
	<table:page page="${page}"></table:page>
	<br/>
	<br/>
	</div>
    	</div>  
    </div>
	</div>
</body>
</html>