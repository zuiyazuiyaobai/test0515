<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>项目基本信息管理</title>
	<meta name="decorator" content="default"/>
	<script src="${ctxStatic}/module/xmjbxx/xmjbxxOperate.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
            laydate.render({
                elem: '#startTimeN', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
				type: 'year',
                range: '~',
                done:function(value, date, endDate){
                    //点击清空时，清除隐藏域的值
                    if(null == value || '' == value){
                        $("#startTimeN").val("");
                        $("#startTimeNStart").val("");
                        $("#startTimeNEnd").val("");
                    } else {
                        $("#startTimeNStart").val(date.year);
                        $("#startTimeNEnd").val(endDate.year);
					}
                }
            });

            laydate.render({
                elem: '#endTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
                type: 'year',
                range: '~',
                done:function(value, date, endDate){
                    //点击清空时，清除隐藏域的值
                    if(null == value || '' == value){
                        $("#endTime").val("");
                        $("#endTimeStart").val("");
                        $("#endTimeEnd").val("");
                    } else {
                        $("#endTimeStart").val(date.year);
                        $("#endTimeEnd").val(endDate.year);
                    }
                }
            });
		});
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox ibox-custom">
	<div class="ibox-title">
		<h5>审核区-项目基本信息列表 </h5>
		<div class="ibox-tools">
		</div>
	</div>
    
    <div class="ibox-content">
	<sys:message content="${message}"/>
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="xmjbxxSearchParameter" action="${ctx}/xmjbxx/xmjbxx/tzjhShqList" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<input id="moreSearch" name="moreSearch" type="hidden" value="${xmjbxxSearchParameter.moreSearch}"/><!-- 是否展开更多查询 -->
		<div class="form-group">
		<div class="form-group right10">
			<span>项目名称：</span>
			<form:input path="xmmc" htmlEscape="false" maxlength="200"  class=" form-control input-sm"/>
		</div>
		 <div class="form-group right10">
			<span class="left10">项目类型：</span>
			<form:select path="xmlx" class="form-control">
				<form:option value="" label="全部" />
				<form:options items="${fns:getDictList('xmlx')}" itemLabel="label" itemValue="value" htmlEscape="false" />
			</form:select>
		</div>
		 <div class="form-group right10">
			<span class="left10">所属行业：</span>
			<sys:treeselect id="sshy" name="sshy" value="${xmjbxxSearchParameter.sshy}" labelName="sshyStr"  notAllowSelectParent="true"
							labelValue="${fns:getTreeDictValue(xmjbxxSearchParameter.sshy)}" title="所属行业" url="/sys/treeDict/treeData?type=sshy"
							cssClass="form-control" />
		</div>
			<%--<span>政府投资方向：</span>
			<sys:treeselect id="fhzftzfx" name="fhzftzfx" value="${xmjbxxSearchParameter.fhzftzfx}" labelName="fhzftzfxStr"
							labelValue="${fns:getTreeDictValue(xmjbxxSearchParameter.fhzftzfx)}" title="菜单" notAllowSelectParent="true"
							url="/sys/treeDict/treeData?type=fhzftzfx" cssClass="form-control" />--%>
		 <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span class="left10">建设地点：</span>
			<sys:treeselect id="jsdd" name="jsdd" value="${xmjbxxSearchParameter.jsdd}" labelName="jsddStr"
							labelValue="${fns:getTreeName(xmjbxxSearchParameter.jsdd,'area')}"
							title="建设地点" url="/sys/area/treeData" cssClass="form-control m-s" allowClear="true"/>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>锁定状态：</span>
			<form:select path="szt" class="form-control" cssStyle="width:100px;">
				<form:option value="" label="" />
				<form:option value="0" label="未锁定" />
				<form:option value="1" label="已锁定" />
				<%--<form:options items="${fns:getDictList('szt')}" itemLabel="label" itemValue="value" htmlEscape="false" />--%>
			</form:select>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span class="left10">数据来源：</span>
			<form:select path="sjly" class="form-control" cssStyle="width:140px;">
				<form:option value="" label="" />
				<form:option value="1" label="本级单位编制" />
				<form:option value="2" label="下级单位报送" />
			</form:select>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span class="left10">总投资（万元）：</span>
			<input id="ztzMin" name="ztzMin" type="number" onchange="compareExchange('ztzMin','ztzMax')" class="number form-control" value="${xmjbxxSearchParameter.ztzMin}" style="width:120px;"/> -
			<input id="ztzMax" name="ztzMax" type="number" onchange="compareExchange('ztzMin','ztzMax')" class="form-control number" value="${xmjbxxSearchParameter.ztzMax}" style="width:120px;"/>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span class="left10">拟开工年份：</span>
			<input type="hidden" name="startTimeNStart" id="startTimeNStart" value="${xmjbxxSearchParameter.startTimeNStart}">
			<input type="hidden" name="startTimeNEnd" id="startTimeNEnd" value="${xmjbxxSearchParameter.startTimeNEnd}">
			<input id="startTimeN" name="startTimeN" type="text" class="laydate-icon-img form-control layer-date input-sm"
				   value="${xmjbxxSearchParameter.startTimeNBT}" style="width:220px;"/>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span class="left10">拟建成年份：</span>
			<input type="hidden" name="endTimeStart" id="endTimeStart" value="${xmjbxxSearchParameter.endTimeStart}">
			<input type="hidden" name="endTimeEnd" id="endTimeEnd" value="${xmjbxxSearchParameter.endTimeEnd}">
			<input id="endTime" name="endTime" type="text" class="laydate-icon-img form-control layer-date input-sm"
				   value="${xmjbxxSearchParameter.endTimeBT}" style="width:220px;"/>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>来源单位：</span>
			<form:input path="xmfrdw" htmlEscape="false" maxlength="200"  class=" form-control input-sm"/>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>报送文号：</span>
			<form:input path="bswh" htmlEscape="false" maxlength="200"  class=" form-control input-sm"/>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>符合政府投资方向：</span>
			<sys:treeselect id="fhzftzfx" name="fhzftzfx" value="${xmjbxxSearchParameter.fhzftzfx}" labelName="fhzftzfxStr"
							labelValue="${fns:getTreeDictValue(xmjbxxSearchParameter.fhzftzfx)}" title="菜单" notAllowSelectParent="true"
							url="/sys/treeDict/treeData?type=fhzftzfx" extId="" cssClass="form-control" />
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>是否专项债：</span>
			<form:select path="sfsqzxjsjj" class="form-control" cssStyle="width:100px;">
				<form:option value="" label=""/>
				<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false" />
			</form:select>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>建议银行：</span>
			<form:select path="jyyh" class="form-control">
				<form:option value="" label=""/>
				<form:options items="${fns:getDictList('jyyh')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</form:select>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>专项类别：</span>
			<sys:treeselect id="zxlb" name="zxlb" value="${xmjbxxSearchParameter.zxlb}" labelName="zxlbStr"  notAllowSelectParent="true"
							labelValue="${fns:getTreeDictValue(xmjbxxSearchParameter.zxlb)}" title="专项类别" url="/sys/treeDict/treeData?type=zxlb" extId=""
							cssClass="form-control" />
		 </div>
		 </div>	
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			<%--<shiro:hasPermission name="xmjbxx:xmjbxx:tzjhShqList_th">
				<table:operateRow url="${ctx}/xmjbxx/xmjbxx/tzjhShqThBzq" id="contentTable" operateIndex="1" label="退回"></table:operateRow>
			</shiro:hasPermission>--%>
			<shiro:hasPermission name="xmjbxx:xmjbxx:tzjhShqList_rbjk">
				<table:operateRow url="${ctx}/xmjbxx/xmjbxx/tzjhShqTszdbq" id="contentTable" operateIndex="2" label="推送至待报区"></table:operateRow>
			</shiro:hasPermission>
			<shiro:hasPermission name="xmjbxx:xmjbxx:tzjhShqList_zb">
				<table:selectSameGradeOfficePanel url="${ctx}/xmjbxx/xmjbxx/zhuanban?To=tzjhShqList" id="contentTable" operateIndex="1" label="转办"></table:selectSameGradeOfficePanel>
			</shiro:hasPermission> 
			<shiro:hasPermission name="xmjbxx:xmjbxx:tzjhShqList_thxjdw">
				<table:operateRow url="${ctx}/xmjbxx/xmjbxx/tzjhShqThxjdw" id="contentTable" operateIndex="3" label="退回下级单位"></table:operateRow>
			</shiro:hasPermission>
			<shiro:hasPermission name="xmjbxx:xmjbxx:tzjhShqList_edit">
				<table:editRowWithCallback url="${ctx}/xmjbxx/xmjbxx/form" title="项目基本信息" id="contentTable" checkFunc="checkEdit"></table:editRowWithCallback><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="xmjbxx:xmjbxx:tzjhShqList_jiasuo">
				<table:operateRow url="${ctx}/xmjbxx/xmjbxx/tzjhShq_jiasuo" id="contentTable" operateIndex="4" label="加锁"></table:operateRow><!-- 加锁按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="xmjbxx:xmjbxx:tzjhShqList_jiesuo">
				<table:operateRow url="${ctx}/xmjbxx/xmjbxx/tzjhShq_jiesuo" id="contentTable" operateIndex="5" label="解锁"></table:operateRow><!-- 解锁按钮 -->
			</shiro:hasPermission>
	       <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button>
		</div>
		<div class="pull-right">
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()" ><i class="fa fa-search"></i> 查询</button>
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()" ><i class="fa fa-refresh"></i> 重置</button>
		    <a class="btn btn-primary btn-rounded btn-outline btn-sm collapse-custom-link"><i class="fa fa-chevron-down"></i><span name="button-text">更多</span></a>
		</div>
	</div>
	</div>
    <div class="table-flow-contain">
	<!-- 表格 -->
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
		<tr>
		<th> <input type="checkbox" class="i-checks"></th>
			<th>重大库编码</th>
				<th>项目名称</th>
				<%--<th>填报状态</th>--%>
				<th>项目类型</th>
				<th>所属行业</th>
				<th>建设地点</th>
				<th>锁定状态</th>
				<th>数据来源</th>
				<th class="sort-column ztz" align="right">总投资</th>
				<th>拟开工年份</th>
				<th>拟成建年份</th>
				<th>来源单位</th>
				<th>报送文号</th>
				<th>符合政府投资方向</th>
				<th>是否专项债</th>
				<th>建议银行</th>
				<th>专项类别</th>
				<th>锁状态</th>
				<th>操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="xmjbxx">
			<tr>
				<td> <input type="checkbox" id="${xmjbxx.id}" sztAttr="${xmjbxx.szt}" class="i-checks"></td>
				<td><a href="#" onclick="openXmjbxxView('查看项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${xmjbxx.id}','1000px', '700px')">
						${xmjbxx.zdkbmgj}
				</a></td>
				<td> ${fns:ellipsisText(xmjbxx.xmmc, 35)}</td>
				<%--<td>${xmjbxx.tbzt}</td>--%>
				<td>${fns:getDictLabel(xmjbxx.xmlx, 'xmlx', '')}</td>
				<td>${fns:getTreeDictValue(xmjbxx.sshy)}</td>
				<td>${fns:getTreeName(xmjbxx.jsdd, 'area')}</td>
				<td>${xmjbxx.sztStr}</td>
				<td>${xmjbxx.sjlyStr}</td>
				<td align="right">${xmjbxx.ztz}</td>
				<td>${xmjbxx.starttimen}</td>
				<td>${xmjbxx.endtime}</td>
				<td>${xmjbxx.xmfrdw}</td>
				<td>${xmjbxx.bswh}</td>
				<td>${fns:getTreeDictValue(xmjbxx.fhzftzfx)}</td>
				<td>${fns:getDictLabel(xmjbxx.sfsqzxjsjj, 'yes_no', '否')}</td>
				<td>${fns:getDictLabel(xmjbxx.jyyh, 'jyyh', '')}</td>
				<td>${fns:getTreeDictValue(xmjbxx.zxlb)}</td>
				<td>${xmjbxx.sztStr}</td>
				<td>
					<shiro:hasPermission name="xmjbxx:xmjbxx:view">
						<a href="#" onclick="openXmjbxxView('查看项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${xmjbxx.id}','1000px', '700px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<%--<shiro:hasPermission name="xmjbxx:xmjbxx:edit">--%>
						<%--<a href="#" onclick="openDialog('修改项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${xmjbxx.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>--%>
					<%--</shiro:hasPermission>--%>
					<%--<shiro:hasPermission name="xmjbxx:xmjbxx:del">--%>
						<%--<a href="${ctx}/xmjbxx/xmjbxx/delete?id=${xmjbxx.id}" onclick="return confirmx('确认要删除该项目基本信息吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>--%>
					<%--</shiro:hasPermission>--%>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
		<!-- 分页代码 -->
	<table:page page="${page}"></table:page>
	<br/>
	<br/>
	</div>
	</div>
</div>
</body>
</html>