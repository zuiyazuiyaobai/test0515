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
                elem: '#createDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
                range: '~',
                change: function(value, date, endDate) {
                    $("#createDateStart").val(date.year + '-' + date.month + '-' + date.date);
                    $("#createDateEnd").val(endDate.year + '-' + endDate.month + '-' + endDate.date);
                },
                done:function(value){
                    //点击清空时，清除隐藏域的值
                    if(null == value || '' == value){
                        $("#createDate").val("");
                        $("#createDateStart").val("");
                        $("#createDateEnd").val("");
                    }
                }
            });
		});

        function checkQxcb(ids){
            console.log(ids);
            var idsArr = ids.split(",");
            for (var i = 0; i < idsArr.length; i++) {
                var id = idsArr[i];
                if (null == id) {
                    continue;
                }

                var $curSelect = $("#" + id);
                var nrzt = $curSelect.attr("nrztAttr");
                var xmmc = $curSelect.attr("xmmcAttr");

                // deptRelation.nrzt 为2表示当前层级已被挑选滚动计划编制
                if ('2' === nrzt) {
                    top.layer.alert("项目（" + xmmc + "）已经被挑入滚动计划编制区的项目，不能取消储备！", {icon: 0});
                    return false;
                }
            }
            return true;
		}
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox ibox-custom">
	<div class="ibox-title">
		<h5>总储备库-项目基本信息列表 </h5>
		<div class="ibox-tools">
		</div>
	</div>
    
    <div class="ibox-content">
	<sys:message content="${message}"/>
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="deptRelationSearchParameter" action="${ctx}/xmjbxx/xmjbxx/cbxmZcbkList" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<input id="moreSearch" name="moreSearch" type="hidden" value="${deptRelationSearchParameter.moreSearch}"/><!-- 是否展开更多查询 -->
		<div class="form-group">
		<div class="form-group right10">
			<span>处理部门：</span>
			<form:input path="xmjbxx.shbm.name" htmlEscape="false" maxlength="200"  class="form-control input-sm"/>
  		</div>
		<div class="form-group right10">
			<span>项目名称：</span>
			<form:input path="xmjbxx.xmmc" htmlEscape="false" maxlength="200"  class="form-control input-sm"/>
  		</div>
  		<div class="form-group right10">
			<span>项目编码：</span>
			<form:input path="xmjbxx.spjgptdm" htmlEscape="false" maxlength="200"  class="form-control input-sm"/>
  		</div>
  		<div class="form-group right10">
			<span class="left10">项目类型：</span>
			<form:select path="xmjbxx.xmlx" class="form-control">
				<form:option value="" label="" />
				<form:options items="${fns:getDictList('xmlx')}" itemLabel="label" itemValue="value" htmlEscape="false" />
			</form:select>
		</div>
		<div class="form-group right10">
			<span class="left10">所属行业：</span>
			<sys:treeselect id="sshy" name="xmjbxx.sshy" value="${deptRelationSearchParameter.xmjbxx.sshy}" labelName="sshyStr"  notAllowSelectParent="true"
							labelValue="${fns:getTreeDictValue(deptRelationSearchParameter.xmjbxx.sshy)}" title="所属行业" url="/sys/treeDict/treeData?type=sshy"
							cssClass="form-control" />
		</div>
		<div></div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span class="left10">总投资（万元）：</span>
			<input id="ztzMin" name="ztzMin" onchange="compareExchange('ztzMin','ztzMax')" type="number" class="number form-control" value="${deptRelationSearchParameter.ztzMin}" style="width:120px;"/> -
			<input id="ztzMax" name="ztzMax" onchange="compareExchange('ztzMin','ztzMax')" type="number" class="form-control number" value="${deptRelationSearchParameter.ztzMax}" style="width:120px;"/>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>符合政府投资方向：</span>
			<sys:treeselect id="fhzftzfx" name="xmjbxx.fhzftzfx" value="${deptRelationSearchParameter.xmjbxx.fhzftzfx}" labelName="fhzftzfxStr"
							labelValue="${fns:getTreeDictValue(deptRelationSearchParameter.xmjbxx.fhzftzfx)}" title="菜单" notAllowSelectParent="true"
							url="/sys/treeDict/treeData?type=fhzftzfx" extId="" cssClass="form-control" />
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>符合重大战略：</span>
			<form:select path="xmjbxx.fhzdzn" class="form-control">
				<form:option value="" label="" />
				<form:options items="${fns:getDictList('fhzdzl')}" itemLabel="label" itemValue="value" htmlEscape="false" />
			</form:select>
		</div>
		<%-- <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span class="left10">储备时间：</span>
			<input type="hidden" name="createDateStart" id="createDateStart"
				   value="<fmt:formatDate value='${deptRelationSearchParameter.createDateStart}' pattern='yyyy-MM-dd'/>">
			<input type="hidden" name="createDateEnd" id="createDateEnd"
				   value="<fmt:formatDate value='${deptRelationSearchParameter.createDateEnd}' pattern='yyyy-MM-dd'/>">
			<input id="createDate" name="createDate" type="text" class="laydate-icon-img form-control layer-date input-sm"
				   value="${deptRelationSearchParameter.createDateBT}" style="width:220px;"/>
		</div> --%>
			<%-- 该项目是否上报到上一级 --%>
		<%-- <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>储备状态：</span>
			<form:select path="zt" class="form-control">
				<form:option value="" label="" />
				<form:option value="1" label="已上报" />
				<form:option value="2" label="未上报" />
			</form:select>
		</div> --%>
		<%-- <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>储备级别：</span>
			<form:select path="zgcj" class="form-control" cssStyle="width:100px;">
				<form:option value="" label="" />
				<form:options items="${fns:getDictList('sys_office_grade')}" itemLabel="label" itemValue="value" htmlEscape="false" />
			</form:select>
		</div> --%>
		<%-- <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>锁定状态：</span>
			<form:select path="xmjbxx.szt" class="form-control" cssStyle="width:100px;">
				<form:option value="" label="" />
				<form:option value="0" label="未锁定" />
				<form:option value="1" label="已锁定" />
				<form:options items="${fns:getDictList('szt')}" itemLabel="label" itemValue="value" htmlEscape="false" />
			</form:select>
		</div> --%>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>审核辅助标志：</span>
			<form:input path="xmjbxx.shfzbsone" htmlEscape="false" maxlength="200" class="form-control input-sm"/>
		</div>
		<%-- 该计划是否被挑选为投资计划项目 --%>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>是否编制滚动计划：</span>
			<form:select path="nrzt" class="form-control">
				<form:option value="" label="" />
				<form:option value="2" label="是" />
				<form:option value="1" label="否" />
			</form:select>
		</div>
		<br/>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>项目阶段：</span>
			<form:select path="xmjbxxSearchParameter.xmscjd" class="form-control">
			    <form:option value="" label="" />
				<form:option value="1" label="开工阶段" />
				<form:option value="2" label="储备阶段" />
				<form:option value="3" label="谋划阶段" />
			</form:select>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span class="left10">建设地点：</span>
			<sys:treeselect id="jsdd" name="xmjbxx.jsdd" value="${deptRelationSearchParameter.xmjbxx.jsdd}" labelName="jsddStr" labelValue="${fns:getTreeName(deptRelationSearchParameter.xmjbxx.jsdd,'area')}"
							title="建设地点" url="/sys/area/treeData" cssClass="form-control m-s" allowClear="true"/>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>来源单位：</span>
			<form:input path="xmjbxx.xmfrdw" htmlEscape="false" maxlength="200"  class="form-control input-sm"/>
		</div>
		<%-- <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>是否专项债：</span>
			<form:select path="xmjbxx.sfsqzxjsjj" class="form-control" cssStyle="width:100px;">
				<form:option value="" label="" />
				<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false" />
			</form:select>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>建议银行：</span>
			<form:select path="xmjbxx.jyyh" class="form-control">
				<form:option value="" label=""/>
				<form:options items="${fns:getDictList('jyyh')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</form:select>
		</div>
		<div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>专项类别：</span>
			<sys:treeselect id="zxlb" name="xmjbxx.zxlb" value="${deptRelationSearchParameter.xmjbxx.zxlb}" labelName="zxlbStr"  notAllowSelectParent="true"
							labelValue="${fns:getTreeDictValue(deptRelationSearchParameter.xmjbxx.zxlb)}" title="专项类别" url="/sys/treeDict/treeData?type=zxlb" extId=""
							cssClass="form-control" />
		</div> --%>
		
		<%-- <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
			<span>是否PPP：</span>
			<form:select path="xmjbxx.sfppp" class="form-control">
				<form:option value="" label="" />
				<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false" />
			</form:select>
		</div> --%>
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
		
	<!-- 表格 -->
	<div class="table-flow-contain">
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
			<tr>
				<th> <input type="checkbox" class="i-checks"></th>
				<th  class="sort-column zdkbmgj">重大库编码</th>
				<th  class="sort-column spjgptdm">平台代码</th>
				<th  class="sort-column xmmc">项目名称</th>
				<th >项目类型</th>
				<th>来源单位</th>
				<th>处理部门</th> 
				<th>项目阶段</th>
				<!-- <th>储备时间</th> -->
				<th>所属行业</th>
				<th>建设地点</th>
				<!-- <th>储备状态</th> -->
				<th>是否编制滚动计划</th>
				<th>总投资</th>
				<!-- <th>储备级别</th> -->
				<th>审核辅助标志</th>
				<th>符合政府投资方向</th>
				<!-- <th>是否专项债</th>
				<th>建议银行</th>
				<th>专项类别</th> -->
			    <th  class="sort-column a.create_date">创建时间</th>
			    <th  class="sort-column a.update_date">审核时间</th>
				<th>符合重大战略</th>
				<!-- <th>是否PPP</th>
				<th>锁状态</th> -->
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="deptRelation">
			<c:set var="xmjbxx" value="${deptRelation.xmjbxx}"/>
			<tr>
				<td><input type="checkbox" id="${xmjbxx.id}" xmmcAttr="${xmjbxx.xmmc}" sztAttr="${xmjbxx.szt}" nrztAttr="${deptRelation.nrzt}"
						   userGradeAttr="${fns:getUserOffice().grade}" class="i-checks"></td>
				<td><a href="#" onclick="openXmjbxxView('查看项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${xmjbxx.id}','1000px', '700px')">
						${xmjbxx.zdkbmgj}
				</a>
				</td>
				<td>
						${xmjbxx.spjgptdm}
				</td>
				<td>
						${fns:ellipsisText(xmjbxx.xmmc, 35)}
				</td>
				<td>
						${fns:getDictLabel(xmjbxx.xmlx, 'xmlx', '')}
				</td>
				<td>
						${xmjbxx.xmfrdw}
				</td>
				<td>
						${deptRelation.dept.name}
				</td> 
				<td>
						${xmjbxx.xmscjdStr}
				</td> 
				<td>
						${fns:getTreeDictValue(xmjbxx.sshy)}
				</td>
				<td>
						${fns:getTreeName(xmjbxx.jsdd, 'area')}
				</td>
				<%-- <td>${deptRelation.cbztStr}</td> --%>
				<td>${deptRelation.sfbzgdjhStr}</td>
				<td>${xmjbxx.ztz}</td>
				<%-- <td>${fns:getDictLabel(deptRelation.zgcj, "sys_office_grade", "")}</td> --%>
				<td>${xmjbxx.shfzbsone}</td>
				<td>${fns:getTreeDictValue(xmjbxx.fhzftzfx)}</td>
				<td>
					<fmt:formatDate value="${xmjbxx.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${xmjbxx.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<%-- <td>${fns:getDictLabel(xmjbxx.sfsqzxjsjj, 'yes_no', '')}</td>
				<td> ${fns:getDictLabel(xmjbxx.jyyh, 'jyyh', '')}</td>
				<td> ${fns:getTreeDictValue(xmjbxx.zxlb)}</td> --%>
				<td> ${fns:getDictLabel(xmjbxx.fhzdzn, 'fhzdzl', '')}</td>
				<%-- <td>
						${fns:getDictLabel(xmjbxx.sfppp, 'yes_no', '')}
				</td>
				<td>
						${xmjbxx.sztStr}
				</td> --%>
					<%-- <td>
                        <fmt:formatDate value="${xmjbxx.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                    </td> --%>
				<td>
					<c:if test="${empty xmjbxx.JKSPURL}">
						<a href="${xmjbxx.JKSPURL}"  href ="javascript:return false;" onclick="return false;" style="cursor: default;" ><i  style="opacity: 0.2"></i> 查看视频</a>
						</c:if>
						<c:if test="${not empty xmjbxx.JKSPURL}">
						<a href="${xmjbxx.JKSPURL}" target="_blank" class="btn btn-info btn-xs" ><i   class="fa fa-search-plus"></i> 查看视频</a>
						</c:if>
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