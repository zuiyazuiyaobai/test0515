<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>项目基本信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            laydate.render({
                elem: '#updateDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
                range: '~',
                change: function(value, date, endDate) {
                    $("#updateDateStart").val(date.year + '-' + date.month + '-' + date.date);
                    $("#updateDateEnd").val(endDate.year + '-' + endDate.month + '-' + endDate.date);
                },
                done:function(value){
                    //点击清空时，清除隐藏域的值
                    if(null == value || '' == value){
                        $("#updateDate").val("");
                        $("#updateDateStart").val("");
                        $("#updateDateEnd").val("");
                    }
                }
            });
            laydate.render({
                elem: '#jhbzDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
                range: '~',
                change: function(value, date, endDate) {
                    $("#jhbzDateStart").val(date.year + '-' + date.month + '-' + date.date);
                    $("#jhbzDateEnd").val(endDate.year + '-' + endDate.month + '-' + endDate.date);
                },
                done:function(value){
                    //点击清空时，清除隐藏域的值
                    if(null == value || '' == value){
                        $("#jhbzDate").val("");
                        $("#jhbzDateStart").val("");
                        $("#jhbzDateEnd").val("");
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
		<h5>其他项目投资计划-项目基本信息列表 </h5>
		<div class="ibox-tools">
		</div>
	</div>
    
    <div class="ibox-content">
	<sys:message content="${message}"/>
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="deptRelationSearchParameter" action="${ctx}/xmjbxx/xmjbxx/ndjhbbsjnjpList" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<input id="moreSearch" name="moreSearch" type="hidden" value="${deptRelationSearchParameter.moreSearch}"/><!-- 是否展开更多查询 -->
		<div class="form-group">
		 <div class="form-group right10">
			<span>项目名称：</span>
			<form:input path="xmjbxx.xmmc" htmlEscape="false" maxlength="200"  class=" form-control input-sm"/>
		 </div>
		 <div class="form-group right10">
			<span class="left10">项目类型：</span>
			<form:select path="xmjbxx.xmlx" class="form-control">
				<form:option value="" label="全部" />
				<form:options items="${fns:getDictList('xmlx')}" itemLabel="label" itemValue="value" htmlEscape="false" />
			</form:select>
		</div>
		 <div class="form-group right10">
			<span class="left10">所属行业：</span>
			<sys:treeselect id="sshy" name="xmjbxx.sshy" value="${deptRelationSearchParameter.xmjbxx.sshy}" labelName="sshyStr"  notAllowSelectParent="true"
							labelValue="${fns:getTreeDictValue(deptRelationSearchParameter.xmjbxx.sshy)}" title="所属行业" url="/sys/treeDict/treeData?type=sshy"
							cssClass="form-control" />
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>政府投资方向：</span>
			<sys:treeselect id="fhzftzfx" name="xmjbxx.fhzftzfx" value="${deptRelationSearchParameter.xmjbxx.fhzftzfx}" labelName="fhzftzfxStr"
							labelValue="${fns:getTreeDictValue(deptRelationSearchParameter.xmjbxx.fhzftzfx)}" title="菜单" notAllowSelectParent="true"
							url="/sys/treeDict/treeData?type=fhzftzfx" cssClass="form-control" />
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span class="left10">建设地点：</span>
			<sys:treeselect id="jsdd" name="xmjbxx.jsdd" value="${deptRelationSearchParameter.xmjbxx.jsdd}" labelName="jsddStr"
							labelValue="${fns:getTreeName(deptRelationSearchParameter.xmjbxx.jsdd,'area')}"
							title="建设地点" url="/sys/area/treeData" cssClass="form-control m-s" allowClear="true"/>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span class="left10">总投资（万元）：</span>
			<input id="ztzMin" name="ztzMin" onchange="compareExchange('ztzMin','ztzMax')" type="number" class="number form-control" value="${deptRelationSearchParameter.ztzMin}" style="width:120px;"/> -
			<input id="ztzMax" name="ztzMax" onchange="compareExchange('ztzMin','ztzMax')" type="number" class="form-control number" value="${deptRelationSearchParameter.ztzMax}" style="width:120px;"/>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>符合重大战略：</span>
			<form:select path="xmjbxx.fhzdzn" class="form-control">
				<form:option value="" label="" />
				<form:options items="${fns:getDictList('fhzdzl')}" itemLabel="label" itemValue="value" htmlEscape="false" />
			</form:select>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span class="left10">计划编制时间：</span>
			<input type="hidden" name="jhbzDateStart" id="jhbzDateStart" value="<fmt:formatDate value='${xmjbxxSearchParameter.jhbzDateStart}' pattern='yyyy-MM-dd'/>">
			<input type="hidden" name="jhbzDateEnd" id="jhbzDateEnd" value="<fmt:formatDate value='${xmjbxxSearchParameter.jhbzDateEnd}' pattern='yyyy-MM-dd'/>">
			<input id="jhbzDate" name="jhbzDate" type="text" class="laydate-icon-img form-control layer-date input-sm" value="${xmjbxxSearchParameter.jhbzDateBT}" style="width:220px;"/>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span class="left10">最后操作时间：</span>
			<input type="hidden" name="xmjbxxSearchParameter.updateDateStart" id="updateDateStart" value="<fmt:formatDate value='${deptRelationSearchParameter.xmjbxxSearchParameter.updateDateStart}' pattern='yyyy-MM-dd'/>">
			<input type="hidden" name="xmjbxxSearchParameter.updateDateEnd" id="updateDateEnd" value="<fmt:formatDate value='${deptRelationSearchParameter.xmjbxxSearchParameter.updateDateEnd}' pattern='yyyy-MM-dd'/>">
			<input id="updateDate" name="xmjbxxSearchParameter.updateDate" type="text" class="laydate-icon-img form-control layer-date input-sm" value="${deptRelationSearchParameter.xmjbxxSearchParameter.updateDateBT}" style="width:220px;"/>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span class="left10">是否申请中央预算内资金：</span>
			<form:select path="xmjbxx.sfsqzyysnzj" class="form-control required">
				<form:option value="" label="" />
				<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false" />
			</form:select>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>审核辅助标志01：</span>
			<form:input path="xmjbxx.shfzbsone" htmlEscape="false" maxlength="200" class=" form-control input-sm"/>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>审核辅助标志02：</span>
			<form:input path="xmjbxx.shfzbstwo" htmlEscape="false" maxlength="200" class=" form-control input-sm"/>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>审核辅助标志03：</span>
			<form:input path="xmjbxx.shfzbsthree" htmlEscape="false" maxlength="200" class=" form-control input-sm"/>
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
	       <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button>
		</div>
		<div class="pull-right">
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()" ><i class="fa fa-search"></i> 查询</button>
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()" ><i class="fa fa-refresh"></i> 重置</button>
			<a class="btn btn-primary btn-rounded btn-outline btn-sm collapse-custom-link"><i class="fa fa-chevron-down"></i><span
                                name="button-text">更多</span></a>
		</div>
	</div>
	</div>
    <div class="table-flow-contain">
	<!-- 表格 -->
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
		<tr>
			<th> <input type="checkbox" class="i-checks"></th>
			<!-- <th  class="sort-column id">主键</th> -->
			<th  class="sort-column zdkbmgj">重大库编码</th>
            <th  class="sort-column xmmc">项目名称</th>
			<th>项目类型</th>
			<th>所属行业</th>
			<th>符合政府投资方向</th>
			<th>建设地点</th>
			<th>总投资</th>
			<th>符合重大战略</th>
			<th>报送文号</th>
			<th>计划编制时间</th>
			<th>最后操作时间</th>
			<th>审核辅助标志01</th>
			<th>审核辅助标志02</th>
			<th>审核辅助标志03</th>
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="deptRelation">
			<c:set var="xmjbxx" value="${deptRelation.xmjbxx}"></c:set>
			<tr>
				<td> <input type="checkbox" id="${xmjbxx.id}" class="i-checks"></td>
				<!-- <td></td> -->
				<td><a href="#" onclick="openXmjbxxView('查看项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${xmjbxx.id}','1000px', '700px')">
                     ${xmjbxx.zdkbmgj}
                </a>
                        
                </td>
                <td>
                     ${fns:ellipsisText(xmjbxx.xmmc, 35)}
                </td>
                <td> ${fns:getDictLabel(xmjbxx.xmlx, 'xmlx', '')}</td>
                <td>${fns:getTreeDictValue(xmjbxx.sshy)} </td>
                <td>${fns:getTreeDictValue(xmjbxx.fhzftzfx)}</td>
                <td> ${fns:getTreeName(xmjbxx.jsdd, 'area')}</td>
               
                <td>${xmjbxx.ztz}</td>
                <td>${fns:getDictLabel(xmjbxx.fhzdzn, 'fhzdzl', '')}</td>
				<td>${xmjbxx.bswh}</td>
				<td><fmt:formatDate value="${xmjbxx.jhbzDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td><fmt:formatDate value="${xmjbxx.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                
                <td>${xmjbxx.shfzbsone}</td>
                <td>${xmjbxx.shfzbstwo}</td>
                <td>${xmjbxx.shfzbsthree}</td>                
				<td>
					<shiro:hasPermission name="xmjbxx:xmjbxx:view">
						<a href="#" onclick="openXmjbxxView('查看项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${xmjbxx.id}','1000px', '700px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<%--<shiro:hasPermission name="xmjbxx:xmjbxx:edit">
						<a href="#" onclick="openDialog('修改项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${xmjbxx.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="xmjbxx:xmjbxx:del">
						<a href="${ctx}/xmjbxx/xmjbxx/delete?id=${xmjbxx.id}" onclick="return confirmx('确认要删除该项目基本信息吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
					</shiro:hasPermission>--%>
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