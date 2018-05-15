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
							elem : '#createDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
							range : true,
							change : function(value, date, endDate) {
								$("#createDateStart").val(
										date.year + '-' + date.month + '-'
												+ date.date);
								$("#createDateEnd").val(
										endDate.year + '-' + endDate.month
												+ '-' + endDate.date);
							},
							done : function(value) {
								//点击清空时，清除隐藏域的值
								if (null == value || '' == value) {
									$("#createDate").val("");
									$("#createDateStart").val("");
									$("#createDateEnd").val("");
								}
							}
						});

						
				$("#searchForm").validate();
	           
			});
	             
</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
		<div class="ibox ibox-custom">
			<div class="ibox-title">
				<h5>审核区-项目基本信息列表</h5>
				<div class="ibox-tools"></div>
			</div>

			<div class="ibox-content">
				<sys:message content="${message}" />

				<!--查询条件-->
				<div class="row">
					<div class="col-sm-12">
						<form:form id="searchForm" modelAttribute="xmjbxxSearchParameter"
							action="${ctx}/xmjbxx/xmjbxx/cbxmShqList" method="post"
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
									<span>来源单位：</span>
									<form:input path="xmfrdw" htmlEscape="false" maxlength="200"
										class=" form-control input-sm" />
								</div>


								<%--  <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>状态：</span>
			<form:select path="sfth" class="form-control">
				<form:option value="" label="" />
				<form:option value="0" label="待审核" />
				<form:option value="1" label="被退回" />
			</form:select>
        </div> --%>
								<div
									class="form-group ibox-custom-content ibox-custom-content-hide right10">
									<span class="left10">创建时间：</span> <input type="hidden"
										name="createDateStart" id="createDateStart"
										value="<fmt:formatDate value='${xmjbxxSearchParameter.createDateStart}' pattern='yyyy-MM-dd'/>">
									<input type="hidden" name="createDateEnd" id="createDateEnd"
										value="<fmt:formatDate value='${xmjbxxSearchParameter.createDateEnd}' pattern='yyyy-MM-dd'/>">
									<input id="createDate" name="createDate" type="text"
										class="laydate-icon-img form-control layer-date input-sm"
										value="${xmjbxxSearchParameter.createDateBT}"
										style="width:220px;" />
								</div>
								<%-- <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>是否专项建设基金：</span>
			<form:select path="sfsqzxjsjj" class="form-control" cssStyle="width:100px;">
				<form:option value="" label=""/>
				<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false" />
			</form:select>
         </div>
         <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>是否PPP：</span>
			<form:select path="sfppp" class="form-control">
				<form:option value="" label="" />
				<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false" />
			</form:select>
     	</div> --%>
							</div>
						</form:form>
						<br />
					</div>
				</div>

				<!-- 工具栏 -->
				<div class="row">
					<div class="col-sm-12">
						<div class="pull-left">
							<shiro:hasPermission name="xmjbxx:xmjbxx:cbxmShqList_rbjk">
								<table:operateRow url="${ctx}/xmjbxx/xmjbxx/cbxmShqRbjk"
									id="contentTable" operateIndex="5" label="入本级库"></table:operateRow>
								<!-- 入本级库按钮 -->
							</shiro:hasPermission>
							<shiro:hasPermission name="xmjbxx:xmjbxx:cbxmShqList_th">
								<table:operateRow url="${ctx}/xmjbxx/xmjbxx/cbxmShqThBsq"
									id="contentTable" operateIndex="1" label="退回"></table:operateRow>
								<!-- 退回按钮 -->
							</shiro:hasPermission>
							<shiro:hasPermission name="xmjbxx:xmjbxx:cbxmShqList_edit">
								<table:editRowWithCallback url="${ctx}/xmjbxx/xmjbxx/form"
									title="项目基本信息" id="contentTable" checkFunc="checkEdit"></table:editRowWithCallback>
								<!-- 编辑按钮 -->
							</shiro:hasPermission>
							<%--<shiro:hasPermission name="xmjbxx:xmjbxx:cbxmShqList_zb">
				<table:selectSameGradeOfficePanel url="${ctx}/xmjbxx/xmjbxx/zhuanban?To=cbxmShqList" id="contentTable" operateIndex="1" label="转办"></table:selectSameGradeOfficePanel>
			</shiro:hasPermission>
			<table:delRowWithCheckFunc url="${ctx}/xmjbxx/xmjbxx/cbxmShqDelete" func="checkDelete" id="contentTable"></table:delRowWithCheckFunc><!-- 删除按钮 -->
			<shiro:hasPermission name="xmjbxx:xmjbxx:cbxmShqList_jiasuo">
				<table:operateRow url="${ctx}/xmjbxx/xmjbxx/cbxmShq_jiasuo" id="contentTable" operateIndex="4" label="加锁"></table:operateRow><!-- 加锁按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="xmjbxx:xmjbxx:cbxmShqList_jiesuo">
				<table:operateRow url="${ctx}/xmjbxx/xmjbxx/cbxmShq_jiesuo" id="contentTable" operateIndex="5" label="解锁"></table:operateRow><!-- 解锁按钮 -->
			</shiro:hasPermission>--%>
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

				<!-- 表格 -->
				<div class="table-flow-contain">
				<table id="contentTable"
					class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
					<thead>
						<tr>
							<th><input type="checkbox" class="i-checks">
							</th>
							<th>重大库编码</th>
							<th>平台代码</th>
							<th>项目名称</th>
							<th>项目类型</th>
							<th>所属行业</th>
							<th>来源单位</th>
							<th>建设地点</th>
							<!-- <th>状态</th> -->
							<th class="sort-column ztz" align="right">总投资</th>
							<th class="sort-column a.create_date">创建时间</th>
							<!-- <th class="sort-column a.update_date">更新时间</th> -->
							<th>符合重大战略</th>
							<!-- <th>是否专项建设基金</th>
				<th>是否PPP</th> -->
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.list}" var="xmjbxx">
							<tr>
								<td><input type="checkbox" id="${xmjbxx.id}"
									isCreator="${xmjbxx.isCreator}" attrXmmc="${xmjbxx.xmmc}"
									sztAttr="${xmjbxx.szt}" class="i-checks">
									<input class="pdhmdclass" name="pdhmdclass" type="hidden" value="${xmjbxx.heimd}" />
								</td>
								<td><a href="#"
									onclick="openXmjbxxView('查看项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${xmjbxx.id}','1000px', '700px')">
										${xmjbxx.zdkbmgj} </a>
								</td>
								<td>${xmjbxx.spjgptdm}</td>
								<td>${fns:ellipsisText(xmjbxx.xmmc, 35)}
									<c:if test="${not empty xmjbxx.heimd && xmjbxx.heimd != 0}">
										<span style="background-color: #000000;color: #ffffff;padding:2px 5px;" >黑名单(${xmjbxx.heimd})</span>
									</c:if>
									<c:if test="${not empty xmjbxx.hongmd && xmjbxx.hongmd != 0}">
										<span style="background-color: #ff0000;color: #ffffff;padding:2px 5px;">红名单(${xmjbxx.hongmd})</span>
									</c:if>
								</td>
								<td>${fns:getDictLabel(xmjbxx.xmlx, 'xmlx', '')}</td>
								<td>${fns:getTreeDictValue(xmjbxx.sshy)}</td>
								<td>${xmjbxx.xmfrdw}</td>
								<td>${fns:getTreeName(xmjbxx.jsdd, 'area')}</td>
								<%-- <td>${fns:getDictLabel(xmjbxx.sfth, 'sfth', '')}</td> --%>
								<td align="right">${xmjbxx.ztz}</td>
								<td><fmt:formatDate value="${xmjbxx.createDate}"
										pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
								<%-- <td><fmt:formatDate value="${xmjbxx.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
								<td>${fns:getDictLabel(xmjbxx.fhzdzn, 'fhzdzl', '')}</td>
								<%-- 	<td>${fns:getDictLabel(xmjbxx.sfsqzxjsjj, 'yes_no', '')}</td>
					<td>${fns:getDictLabel(xmjbxx.sfppp, 'yes_no', '')}</td> --%>
								<td><c:if test="${empty xmjbxx.JKSPURL}">
										<a href="${xmjbxx.JKSPURL}" href="javascript:return false;"
											onclick="return false;" style="cursor: default;"><i
											style="opacity: 0.2"></i> 查看视频</a>
									</c:if> 
									<c:if test="${not empty xmjbxx.JKSPURL}">
										<a href="${xmjbxx.JKSPURL}" target="_blank"
											class="btn btn-info btn-xs"><i class="fa fa-search-plus"></i>
											查看视频</a>
									</c:if>  &nbsp;&nbsp;&nbsp;
									<a href="#" onclick="openxmxyfk('查看企业信用', '${ctx}/xmjbxx/xmjbxx/ckQyxy?id=${xmjbxx.id}','1000px', '700px')" 
									class="btn btn-info btn-xs"><i class="fa fa-search-plus"></i>
									查看信用</a>
									<a href="#" onclick="openxmxyfk('企业信用反馈', '${ctx}/xmjbxx/xmjbxx/qyxyfk?id=${xmjbxx.id}&xyflag=1','1000px', '700px')" 
									class="btn btn-info btn-xs"><i class="fa fa-search-plus"></i>
									信用反馈</a>
								</td>
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
</body>
</html>