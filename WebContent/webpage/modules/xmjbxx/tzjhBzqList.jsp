<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
<title>项目基本信息管理</title>
<meta name="decorator" content="default" />
<script src="${ctxStatic}/module/xmjbxx/xmjbxxOperate.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				laydate
						.render({
							elem : '#updateDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
							range : '~',
							change : function(value, date, endDate) {
								$("#updateDateStart").val(
										date.year + '-' + date.month + '-'
												+ date.date);
								$("#updateDateEnd").val(
										endDate.year + '-' + endDate.month
												+ '-' + endDate.date);
							},
							done : function(value) {
								//点击清空时，清除隐藏域的值
								if (null == value || '' == value) {
									$("#updateDate").val("");
									$("#updateDateStart").val("");
									$("#updateDateEnd").val("");
								}
							}
						});
				laydate
						.render({
							elem : '#jhbzDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
							range : '~',
							change : function(value, date, endDate) {
								$("#jhbzDateStart").val(
										date.year + '-' + date.month + '-'
												+ date.date);
								$("#jhbzDateEnd").val(
										endDate.year + '-' + endDate.month
												+ '-' + endDate.date);
							},
							done : function(value) {
								//点击清空时，清除隐藏域的值
								if (null == value || '' == value) {
									$("#jhbzDate").val("");
									$("#jhbzDateStart").val("");
									$("#jhbzDateEnd").val("");
								}
							}
						});
			});
	function txxm() {
<%--openDialog("从储备库挑选项目", "${ctx}/xmjbxx/xmjbxx/tzjhBzqForm", "${width==null?'800px':width}", "${height==null?'500px':height}", "${target}");--%>
	top.layer.open({
			type : 2,
			area : [ '800px', '500px' ],
			title : '从储备库挑选项目',
			maxmin : true, //开启最大化最小化按钮
			content : '${ctx}/xmjbxx/xmjbxx/tzjhBzqForm',
			btn : [ '确定', '关闭' ],
			yes : function(index, layero) {
				var body = top.layer.getChildFrame('body', index);
				var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
				var inputForm = body.find('#inputForm');
				var top_iframe;
				top_iframe = top.getActiveTab().attr("name");//获取当前active的tab的iframe
				inputForm.attr("target", top_iframe);//表单提交成功后，从服务器返回的url在当前tab中展示

				iframeWin.contentWindow.doSubmit(function() {
					top.layer.close(index);
					sortOrRefresh();
				});
			},
			cancel : function(index) {
			}
		});
	}
	function daKunXm(){
		var str = "";
		var ids = "";
		var ztz = "";
		var isNew=true;
		var dkxmmcFlag=0;//所选项目是否已经打过困
		$("#contentTable tbody tr td input.i-checks:checkbox").each(function() {
			if (true == $(this).is(':checked')) {
				str += $(this).attr("id") + ",";
				ztz += $(this).attr("myZtz") + ",";
				dkxmmcFlag=$(this).attr("myDkxmmc");
				if(dkxmmcFlag!=""){
					isNew=false;
				}
			}
		});
		if(!isNew){
			top.layer.alert('所选项目中纯在已经打过困的项目，请核实后再操作!', {
				icon : 0,
				title : '警告'
			});
			return;
		}
		if (str.substr(str.length - 1) == ',') {
			ids = str.substr(0, str.length - 1);
		}
		var idArr = ids.split(",");
		if (ids == ""||idArr.length < 2 ) {
			top.layer.alert('请至少选择2条数据!', {
				icon : 0,
				title : '警告'
			});
			return;
		}
		top.layer.open({
			type : 1,
			area : [ '700px', '400px' ],
			title : '项目打捆',
			maxmin : true, //开启最大化最小化按钮
			content : $("#daxmDiv").html(),
			btn : [ '确定', '关闭' ],
			yes : function(index, layero) {
				var dkxmmc=layero.context.getElementById("dkxmmc").value;
				var dkxmjsnr=layero.context.getElementById("dkxmjsnr").value;
				$.post('${ctx}/dkxmxx/dkxmxx/daKunXm',{ids:ids,dkxmmc:dkxmmc,dkxmjsnr:dkxmjsnr,ztz:ztz},function(data){
					if(data==0){
						alert("打捆项目成功！");
					}else{
						alert("打捆项目失败！");
					}
					top.layer.closeAll();
					sortOrRefresh();
				});
				
			},
			cancel : function(index) {
			}
		});
	}
	function shqr() {
		var str = "";
		var ids = "";
		var sfsjjFlag = "0";
		$("#contentTable tbody tr td input.i-checks:checkbox").each(function() {
			if (true == $(this).is(':checked')) {
				str += $(this).attr("id") + ",";
				var remarke = $(this).parent().next().val().replace(/(^\s*)|(\s*$)/g, "");;
				if (remarke == "2017年省基建项目" || remarke == "2018年省基建项目"||remarke == "2018年交通基础设施省补助资金项目") {
					sfsjjFlag = "1";
				}
			}
		});
		if (str.substr(str.length - 1) == ',') {
			ids = str.substr(0, str.length - 1);
		}
		if (ids == "") {
			top.layer.alert('请至少选择一条数据!', {
				icon : 0,
				title : '警告'
			});
			return;
		}
		var idArr = ids.split(",");
		//如果为省基建项目则只能选择一条
		if (idArr.length == 2 && sfsjjFlag == "1") {
			top.layer.alert('省基建项目只能选中一个进行报送!', {
				icon : 0,
				title : '警告'
			});
			return;
		}
		top.layer.open({
			type : 2,
			area : [ '800px', '500px' ],
			title : '调度任务',
			maxmin : true, //开启最大化最小化按钮
			content : '${ctx}/task/schedulerTask/form?origin=' + ids
					+ '&sfsjjFlag=' + sfsjjFlag,
			btn : [ '确定', '关闭' ],
			yes : function(index, layero) {
				var body = top.layer.getChildFrame('body', index);
				var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
				var inputForm = body.find('#inputForm');
				var top_iframe;
				top_iframe = top.getActiveTab().attr("name");//获取当前active的tab的iframe
				inputForm.attr("target", top_iframe);//表单提交成功后，从服务器返回的url在当前tab中展示

				iframeWin.contentWindow.doSubmit(function() {
					top.layer.closeAll();
					sortOrRefresh();
				});

			},
			cancel : function(index) {
			}
		});
	}
</script>


</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
		<div class="ibox ibox-custom">
			<div class="ibox-title">
				<h5>编制区-项目基本信息列表</h5>
				<div class="ibox-tools"></div>
			</div>

			<div class="ibox-content">
				<sys:message content="${message}" />

				<!--查询条件-->
				<div class="row">
					<div class="col-sm-12">
						<form:form id="searchForm" modelAttribute="xmjbxxSearchParameter"
							action="${ctx}/xmjbxx/xmjbxx/tzjhBzqList" method="post"
							class="form-inline">
							<input id="pageNo" name="pageNo" type="hidden"
								value="${page.pageNo}" />
							<input id="pageSize" name="pageSize" type="hidden"
								value="${page.pageSize}" />
							<table:sortColumn id="orderBy" name="orderBy"
								value="${page.orderBy}" callback="sortOrRefresh();" />
							<!-- 支持排序 -->
							<input id="moreSearch" name="moreSearch" type="hidden"
								value="${xmjbxxSearchParameter.moreSearch}" />
							<!-- 是否展开更多查询 -->
							<div class="form-group">
								<div class="form-group right10">
									<span>项目名称：</span>
									<form:input path="xmmc" htmlEscape="false" maxlength="200"
										class=" form-control input-sm" />
								</div>
								<div class="form-group right10">
									<span class="left10">项目类型：</span>
									<form:select path="xmlx" class="form-control">
										<form:option value="" label="全部" />
										<form:options items="${fns:getDictList('xmlx')}"
											itemLabel="label" itemValue="value" htmlEscape="false" />
									</form:select>
								</div>
								<div class="form-group right10">
									<span class="left10">所属行业：</span>
									<sys:treeselect id="sshy" name="sshy"
										value="${xmjbxxSearchParameter.sshy}" labelName="sshyStr"
										notAllowSelectParent="true"
										labelValue="${fns:getTreeDictValue(xmjbxxSearchParameter.sshy)}"
										title="所属行业" url="/sys/treeDict/treeData?type=sshy"
										cssClass="form-control" />
								</div>
								<div
									class="form-group ibox-custom-content ibox-custom-content-hide right10">
									<span>政府投资方向：</span>
									<sys:treeselect id="fhzftzfx" name="fhzftzfx"
										value="${xmjbxxSearchParameter.fhzftzfx}"
										labelName="fhzftzfxStr"
										labelValue="${fns:getTreeDictValue(xmjbxxSearchParameter.fhzftzfx)}"
										title="菜单" notAllowSelectParent="true"
										url="/sys/treeDict/treeData?type=fhzftzfx"
										cssClass="form-control" />
								</div>
								<div
									class="form-group ibox-custom-content ibox-custom-content-hide right10">
									<span class="left10">建设地点：</span>
									<sys:treeselect id="jsdd" name="jsdd"
										value="${xmjbxxSearchParameter.jsdd}" labelName="jsddStr"
										labelValue="${fns:getTreeName(xmjbxxSearchParameter.jsdd,'area')}"
										title="建设地点" url="/sys/area/treeData"
										cssClass="form-control m-s" allowClear="true" />
								</div>
								<div
									class="form-group ibox-custom-content ibox-custom-content-hide right10">
									<span class="left10">总投资（万元）：</span> <input id="ztzMin"
										name="ztzMin" onchange="compareExchange('ztzMin','ztzMax')"
										type="number" class="number form-control"
										value="${xmjbxxSearchParameter.ztzMin}" style="width:120px;" />
									- <input id="ztzMax" name="ztzMax"
										onchange="compareExchange('ztzMin','ztzMax')" type="number"
										class="form-control number"
										value="${xmjbxxSearchParameter.ztzMax}" style="width:120px;" />
								</div>
								<div
									class="form-group ibox-custom-content ibox-custom-content-hide right10">
									<span>符合重大战略：</span>
									<form:select path="fhzdzn" class="form-control">
										<form:option value="" label="" />
										<form:options items="${fns:getDictList('fhzdzl')}"
											itemLabel="label" itemValue="value" htmlEscape="false" />
									</form:select>
								</div>
								<div
									class="form-group ibox-custom-content ibox-custom-content-hide right10">
									<span class="left10">计划编制时间：</span> <input type="hidden"
										name="jhbzDateStart" id="jhbzDateStart"
										value="<fmt:formatDate value='${xmjbxxSearchParameter.jhbzDateStart}' pattern='yyyy-MM-dd'/>">
									<input type="hidden" name="jhbzDateEnd" id="jhbzDateEnd"
										value="<fmt:formatDate value='${xmjbxxSearchParameter.jhbzDateEnd}' pattern='yyyy-MM-dd'/>">
									<input id="jhbzDate" name="jhbzDate" type="text"
										class="laydate-icon-img form-control layer-date input-sm"
										value="${xmjbxxSearchParameter.jhbzDateBT}"
										style="width:220px;" />
								</div>
								<div
									class="form-group ibox-custom-content ibox-custom-content-hide right10">
									<span class="left10">最后操作时间：</span> <input type="hidden"
										name="updateDateStart" id="updateDateStart"
										value="<fmt:formatDate value='${xmjbxxSearchParameter.updateDateStart}' pattern='yyyy-MM-dd'/>">
									<input type="hidden" name="updateDateEnd" id="updateDateEnd"
										value="<fmt:formatDate value='${xmjbxxSearchParameter.updateDateEnd}' pattern='yyyy-MM-dd'/>">
									<input id="updateDate" name="updateDate" type="text"
										class="laydate-icon-img form-control layer-date input-sm"
										value="${xmjbxxSearchParameter.updateDateBT}"
										style="width:220px;" />
								</div>
								<%--<span class="left10">创建时间：</span>
			<input type="hidden" name="createDateStart" id="createDateStart"
				   value="<fmt:formatDate value='${xmjbxxSearchParameter.createDateStart}' pattern='yyyy-MM-dd'/>">
			<input type="hidden" name="createDateEnd" id="createDateEnd"
				   value="<fmt:formatDate value='${xmjbxxSearchParameter.createDateEnd}' pattern='yyyy-MM-dd'/>">
			<input id="createDate" name="createDate" type="text" class="laydate-icon-img form-control layer-date input-sm"
				   value="${xmjbxxSearchParameter.createDateBT}" style="width:220px;"/>--%>

								<div
									class="form-group ibox-custom-content ibox-custom-content-hide right10">
									<span>审核辅助标志01：</span>
									<form:input path="shfzbsone" htmlEscape="false" maxlength="200"
										class=" form-control input-sm" />
								</div>
								<div
									class="form-group ibox-custom-content ibox-custom-content-hide right10">
									<span>审核辅助标志02：</span>
									<form:input path="shfzbstwo" htmlEscape="false" maxlength="200"
										class=" form-control input-sm" />
								</div>
								<div
									class="form-group ibox-custom-content ibox-custom-content-hide right10">
									<span>审核辅助标志03：</span>
									<form:input path="shfzbsthree" htmlEscape="false"
										maxlength="200" class=" form-control input-sm" />
								</div>
								<div
									class="form-group ibox-custom-content ibox-custom-content-hide right10">
									<span>报送文号：</span>
									<form:input path="bswh" htmlEscape="false"
										maxlength="200" class=" form-control input-sm" />
								</div>
							</div>
						</form:form>
						<br />
					</div>
				</div>

				<!-- 工具栏 -->
				<div class="row">
					<div class="col-sm-12">
						<div class="pull-left">
							<shiro:hasPermission name="xmjbxx:xmjbxx:tzjhBzqList_txxm">
								<button class="btn btn-white btn-sm" data-toggle="tooltip"
									data-placement="left" onclick="txxm()" title="从储备库挑选项目">
									<i class="fa fa-plus"></i>从储备库挑选项目
								</button>
							</shiro:hasPermission>
							<shiro:hasPermission name="xmjbxx:xmjbxx:tzjhShqList_edit">
								<table:editRowWithCallback url="${ctx}/xmjbxx/xmjbxx/form"
									title="项目基本信息" id="contentTable" checkFunc="checkEdit"></table:editRowWithCallback>
								<!-- 编辑按钮 -->
							</shiro:hasPermission>
							<shiro:hasPermission name="xmjbxx:xmjbxx:tzjhDbqList_sb">
								<table:operatePanel url="${ctx}/xmjbxx/xmjbxx/tzjhDbqSb"
									id="contentTable" nextOffices="${nextOffices}"
									nextOfficesName="${nextOfficesName}" checkFunc="checkSb"
									panelName="bswh" operateIndex="1" label="上报"></table:operatePanel>
							</shiro:hasPermission>
							<table:operateRow url="${ctx}/xmjbxx/xmjbxx/sngdjhThdbq2"
								id="contentTable" operateIndex="2" label="退回储备库"></table:operateRow>
							<shiro:hasPermission name="xmjbxx:xmjbxx:tzjhShqList_thxjdw">
								<table:operateRow url="${ctx}/xmjbxx/xmjbxx/tzjhShqThxjdw"
									id="contentTable" operateIndex="3" label="退回下级单位"></table:operateRow>
							</shiro:hasPermission>
							<shiro:hasPermission name="xmjbxx:xmjbxx:cbxmShqList_shtg">
								<button class="btn btn-white btn-sm" data-toggle="tooltip"
									data-placement="left" onclick="shqr()" title="审核确认">
									<i class="fa fa-pencil-square-o"></i> 审核确认
								</button>
							</shiro:hasPermission>
							<button class="btn btn-white btn-sm " data-toggle="tooltip"
								data-placement="left" onclick="daKunXm()" title="打捆">
								<i class="glyphicon glyphicon-repeat"></i> 打捆
							</button>
							<button class="btn btn-white btn-sm " data-toggle="tooltip"
								data-placement="left" onclick="sortOrRefresh()" title="刷新">
								<i class="glyphicon glyphicon-repeat"></i> 刷新
							</button>
						</div>
						<div class="pull-right">
							<button class="btn btn-primary btn-rounded btn-outline btn-sm "
								onclick="search()">
								<i class="fa fa-search"></i> 查询
							</button>
							<button class="btn btn-primary btn-rounded btn-outline btn-sm "
								onclick="reset()">
								<i class="fa fa-refresh"></i> 重置
							</button>
							<a
								class="btn btn-primary btn-rounded btn-outline btn-sm collapse-custom-link"><i
								class="fa fa-chevron-down"></i><span name="button-text">更多</span>
							</a>
						</div>
					</div>
				</div>
				<div class="table-flow-contain">
					<!-- 表格 -->
					<table id="contentTable"
						class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
						<thead>
							<tr>
								<th><input type="checkbox" class="i-checks">
								</th>
								<th class="sort-column zdkbmgj">重大库编码</th>
								<th class="sort-column xmmc">项目名称</th>
								<th>打捆项目名称</th>
								<th>项目类型</th>
								<th>所属行业</th>
								<th>审核部门</th>
								<th>上报部门</th>
								<th>建设地点</th>
								<th>总投资</th>
								<th>报送文号</th>
								<th>报送类别</th>
								<th>计划编制时间</th>
								<th>最后操作时间</th>
								<th>是否申请省重点项目</th>
								<th>是否省基建项目</th>
								<th>是否588项目</th>
								<th>审核辅助标志03</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.list}" var="xmjbxx">
								<tr>
									<td><input type="checkbox" id="${xmjbxx.id}"
										sztAttr="${xmjbxx.szt}" myZtz="${xmjbxx.ztz}" myDkxmmc="${xmjbxx.dkxmmc}" class="i-checks"> <input
										type="hidden" value="<c:if test="${xmjbxx.remarks != '12'}">${xmjbxx.remarks}
									   </c:if>
									   <c:if test="${xmjbxx.remarks == '12'}">2018年交通基础设施省补助资金项目
									   </c:if>" /></td>
									<td><a href="#"
										onclick="openXmjbxxView('查看项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${xmjbxx.id}','1000px', '700px')">
											${xmjbxx.zdkbmgj} </a></td>
									<td>${fns:ellipsisText(xmjbxx.xmmc, 35)}</td>
									<td>${xmjbxx.dkxmmc}</td>
									<td>${fns:getDictLabel(xmjbxx.xmlx, 'xmlx', '')}</td>
									<td>${fns:getTreeDictValue(xmjbxx.sshy)}</td>
									<td>${xmjbxx.shbm}</td>
									<td>${xmjbxx.zrwxzh}</td>
									<td>${fns:getTreeName(xmjbxx.jsdd, 'area')}</td>
									<td>${xmjbxx.ztz}</td>
							<%-- 		<td>${fns:getDictLabel(xmjbxx.fhzdzn, 'fhzdzl', '')}</td> --%>
									<td>${xmjbxx.bswh}</td>
									<td>
									   <c:if test="${xmjbxx.remarks != '12' && xmjbxx.remarks != '13'}">${xmjbxx.remarks}
									   </c:if>
									   <c:if test="${xmjbxx.remarks == '12'}">2018年交通基础设施省补助资金项目
									   </c:if>
									   <c:if test="${xmjbxx.remarks == '13'}">健康养老示范项目
									   </c:if>
									</td>
									<td><fmt:formatDate value="${xmjbxx.jhbzDate}"
											pattern="yyyy-MM-dd HH:mm:ss" />
									</td>
									<td><fmt:formatDate value="${xmjbxx.updateDate}"
											pattern="yyyy-MM-dd HH:mm:ss" />
									</td>
									<td>${fns:getDictLabel(xmjbxx.sfsqzyysnzj, 'yes_no', '')}
									</td>
									<td>${xmjbxx.shfzbsone}</td>
									<td>${xmjbxx.shfzbstwo}</td>
									<td>${xmjbxx.shfzbsthree}</td>
									<td><c:if test="${empty xmjbxx.JKSPURL}">
											<a href="${xmjbxx.JKSPURL}" href="javascript:return false;"
												onclick="return false;" style="cursor: default;"><i
												style="opacity: 0.2"></i> 查看视频</a>
										</c:if> <c:if test="${not empty xmjbxx.JKSPURL}">
											<a href="${xmjbxx.JKSPURL}" target="_blank"
												class="btn btn-info btn-xs"><i
												class="fa fa-search-plus"></i> 查看视频</a>
										</c:if></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- 分页代码 -->
				<table:page page="${page}"></table:page>
				<br /> <br />
			</div>
		</div>
	</div>
	</div>
</div>
<div class="tz_sub" style="display: none"  id="daxmDiv" name="inputForm">
	<table >
		<tr>
				<td>
					<label style="height: auto;width:150px;height: auto; margin-left:25px;"><font color="red">*</font>打捆项目名称：</label>
				</td>
				<td style="width:450px;">
					<input id="dkxmmc"  name="dkxmmc" width="450px;" maxlength="200" type="text"  value=""/>
				</td>
		</tr>
		<tr >
				<td>
					<label style="height: auto;width:150px;height: auto; margin-left:25px;"><font color="red">*</font>打捆项目建设内容：</label>
				</td>
				<td style="width:450px;">
					<textarea name="dkxmjsnr" id='dkxmjsnr' rows="4" cols="80"></textarea>
				</td>
		</tr>
	</table>
</div>
</body>
</html>