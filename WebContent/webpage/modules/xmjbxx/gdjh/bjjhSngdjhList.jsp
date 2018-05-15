<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp" %>
<html>
<head>
    <title>项目基本信息管理</title>
    <meta name="decorator" content="default"/>
    <script src="${ctxStatic}/module/xmjbxx/xmjbxxOperate.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            laydate.render({
                elem: '#startTimeN', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
                type: 'year',
                range: '~',
                done: function (value, date, endDate) {
                    //点击清空时，清除隐藏域的值
                    if (null == value || '' == value) {
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
                done: function (value, date, endDate) {
                    //点击清空时，清除隐藏域的值
                    if (null == value || '' == value) {
                        $("#endTime").val("");
                        $("#endTimeStart").val("");
                        $("#endTimeEnd").val("");
                    } else {
                        $("#endTimeStart").val(date.year);
                        $("#endTimeEnd").val(endDate.year);
                    }
                }
            });
            laydate.render({
                elem: '#updateDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
                range: '~',
                change: function (value, date, endDate) {
                    $("#updateDateStart").val(date.year + '-' + date.month + '-' + date.date);
                    $("#updateDateEnd").val(endDate.year + '-' + endDate.month + '-' + endDate.date);
                },
                done: function (value) {
                    //点击清空时，清除隐藏域的值
                    if (null == value || '' == value) {
                        $("#updateDate").val("");
                        $("#updateDateStart").val("");
                        $("#updateDateEnd").val("");
                    }
                }
            });
            laydate.render({
                elem: '#jhbzDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
                range: '~',
                change: function (value, date, endDate) {
                    $("#jhbzDateStart").val(date.year + '-' + date.month + '-' + date.date);
                    $("#jhbzDateEnd").val(endDate.year + '-' + endDate.month + '-' + endDate.date);
                },
                done: function (value) {
                    //点击清空时，清除隐藏域的值
                    if (null == value || '' == value) {
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
            <h5>三年滚动计划</h5>
        </div>

        <div class="ibox-content">
            <sys:message content="${message}"/>

            <!--查询条件-->
            <div class="row">
                <div class="col-sm-12">
                    <form:form id="searchForm" modelAttribute="deptRelationSearchParameter" action="${ctx}/xmjbxx/xmjbxx/bjjhSngdjhList" method="post"
                               class="form-inline">
                        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
                        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
                        <table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
                        <input id="moreSearch" name="moreSearch" type="hidden" value="${deptRelationSearchParameter.moreSearch}"/><!-- 是否展开更多查询 -->
                        <div class="form-group right10">
                            <span>项目名称：</span>
                            <form:input path="xmjbxx.xmmc" htmlEscape="false" maxlength="200" class=" form-control input-sm"/>
                        </div>
                        <div class="form-group right10">
                            <span>项目类型：</span>
                            <form:select path="xmjbxx.xmlx" class="form-control">
                                <form:option value="" label="全部"/>
                                <form:options items="${fns:getDictList('xmlx')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                            </form:select>
                        </div>
                        <div class="form-group right10">
                            <span>所属行业：</span>
                            <sys:treeselect id="sshy" name="xmjbxx.sshy" value="${deptRelationSearchParameter.xmjbxx.sshy}" labelName="sshyStr"
                                            notAllowSelectParent="true"
                                            labelValue="${fns:getTreeDictValue(deptRelationSearchParameter.xmjbxx.sshy)}" title="所属行业"
                                            url="/sys/treeDict/treeData?type=sshy"
                                            cssClass="form-control"/>
                        </div>
                        <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                            <span>建设地点：</span>
                            <sys:treeselect id="jsdd" name="xmjbxx.jsdd" value="${deptRelationSearchParameter.xmjbxx.jsdd}" labelName="jsddStr"
                                            labelValue="${fns:getTreeName(deptRelationSearchParameter.xmjbxx.jsdd,'area')}"
                                            title="建设地点" url="/sys/area/treeData" cssClass="form-control m-s" allowClear="true"/>
                        </div>
                        <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                            <span>总投资（万元）：</span>
                            <input id="ztzMin" name="ztzMin" onchange="compareExchange('ztzMin','ztzMax')" type="number" class="number form-control"
                                   value="${deptRelationSearchParameter.ztzMin}" style="width:120px;"/> -
                            <input id="ztzMax" name="ztzMax" onchange="compareExchange('ztzMin','ztzMax')" type="number" class="form-control number"
                                   value="${deptRelationSearchParameter.ztzMax}" style="width:120px;"/>
                        </div>
                        <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                            <span>锁定状态：</span>
                            <form:select path="xmjbxx.szt" class="form-control" cssStyle="width:100px;">
                                <form:option value="" label=""/>
                                <form:option value="0" label="未锁定" />
                                <form:option value="1" label="已锁定" />
                                <%--<form:options items="${fns:getDictList('szt')}" itemLabel="label" itemValue="value" htmlEscape="false"/>--%>
                            </form:select>
                        </div>
                        <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                            <span>政府投资方向：</span>
                            <sys:treeselect id="fhzftzfx" name="xmjbxx.fhzftzfx" value="${deptRelationSearchParameter.xmjbxx.fhzftzfx}"
                                            labelName="fhzftzfxStr"
                                            labelValue="${fns:getTreeDictValue(deptRelationSearchParameter.xmjbxx.fhzftzfx)}" title="菜单"
                                            notAllowSelectParent="true"
                                            url="/sys/treeDict/treeData?type=fhzftzfx" cssClass="form-control"/>
                        </div>
                        <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                            <span>报送状态：</span>
                            <form:select path="zt" class="form-control" cssStyle="width:100px;">
                                <form:option value="" label=""/>
                                <form:option value="1" label="已报送"/>
                                <form:option value="2" label="未报送"/>
                                <form:option value="3" label="被上级退回"/>
                            </form:select>
                        </div>
                        <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                            <span>拟开工年份：</span>
                            <input type="hidden" name="xmjbxxSearchParameter.startTimeNStart" id="startTimeNStart"
                                   value="${deptRelationSearchParameter.xmjbxxSearchParameter.startTimeNStart}">
                            <input type="hidden" name="xmjbxxSearchParameter.startTimeNEnd" id="startTimeNEnd"
                                   value="${deptRelationSearchParameter.xmjbxxSearchParameter.startTimeNEnd}">
                            <input id="startTimeN" name="deptRelationSearchParameter.startTimeN" type="text"
                                   class="laydate-icon-img form-control layer-date input-sm"
                                   value="${deptRelationSearchParameter.xmjbxxSearchParameter.startTimeNBT}" style="width:220px;"/>
                        </div>
                        <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                            <span>拟建成年份：</span>
                            <input type="hidden" name="xmjbxxSearchParameter.endTimeStart" id="endTimeStart"
                                   value="${deptRelationSearchParameter.xmjbxxSearchParameter.endTimeStart}">
                            <input type="hidden" name="xmjbxxSearchParameter.endTimeEnd" id="endTimeEnd"
                                   value="${deptRelationSearchParameter.xmjbxxSearchParameter.endTimeEnd}">
                            <input id="endTime" name="endTime" type="text" class="laydate-icon-img form-control layer-date input-sm"
                                   value="${deptRelationSearchParameter.xmjbxxSearchParameter.endTimeBT}" style="width:220px;"/>
                        </div>
                        <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                            <span>是否专项债：</span>
                            <form:select path="xmjbxx.sfsqzxjsjj" class="form-control" cssStyle="width:100px;">
                                <form:option value="" label=""/>
                                <form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
                            <sys:treeselect id="zxlb" name="xmjbxx.zxlb" value="${deptRelationSearchParameter.xmjbxx.zxlb}" labelName="zxlbStr"
                                            notAllowSelectParent="true"
                                            labelValue="${fns:getTreeDictValue(deptRelationSearchParameter.xmjbxx.zxlb)}" title="专项类别"
                                            url="/sys/treeDict/treeData?type=zxlb" extId=""
                                            cssClass="form-control"/>
                        </div>
                        <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                            <span>是否PPP：</span>
                            <form:select path="xmjbxx.sfppp" class="form-control">
                                <form:option value="" label=""/>
                                <form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                            </form:select>
                        </div>
                        <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                            <span>审核辅助标志01：</span>
                            <form:input path="xmjbxx.shfzbsone" htmlEscape="false" maxlength="200" class=" form-control input-sm"/>

                            <span>审核辅助标志02：</span>
                            <form:input path="xmjbxx.shfzbstwo" htmlEscape="false" maxlength="200" class=" form-control input-sm"/>
                        </div>
                        <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                            <span>审核辅助标志03：</span>
                            <form:input path="xmjbxx.shfzbsthree" htmlEscape="false" maxlength="200" class=" form-control input-sm"/>
                        </div>
                        <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                            <span>是否申请中央预算内资金：</span>
                            <form:select path="xmjbxx.sfsqzyysnzj" class="form-control required">
                                <form:option value="" label=""/>
                                <form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                            </form:select>
                        </div>
                        <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                            <span>计划编制时间：</span>
                            <input type="hidden" name="jhbzDateStart" id="jhbzDateStart"
                                   value="<fmt:formatDate value='${xmjbxxSearchParameter.jhbzDateStart}' pattern='yyyy-MM-dd'/>">
                            <input type="hidden" name="jhbzDateEnd" id="jhbzDateEnd"
                                   value="<fmt:formatDate value='${xmjbxxSearchParameter.jhbzDateEnd}' pattern='yyyy-MM-dd'/>">
                            <input id="jhbzDate" name="jhbzDate" type="text" class="laydate-icon-img form-control layer-date input-sm"
                                   value="${xmjbxxSearchParameter.jhbzDateBT}" style="width:220px;"/>
                        </div>
                        <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                            <span>最后操作时间：</span>
                            <input type="hidden" name="xmjbxxSearchParameter.updateDateStart" id="updateDateStart"
                                   value="<fmt:formatDate value='${deptRelationSearchParameter.xmjbxxSearchParameter.updateDateStart}' pattern='yyyy-MM-dd'/>">
                            <input type="hidden" name="xmjbxxSearchParameter.updateDateEnd" id="updateDateEnd"
                                   value="<fmt:formatDate value='${deptRelationSearchParameter.xmjbxxSearchParameter.updateDateEnd}' pattern='yyyy-MM-dd'/>">
                            <input id="updateDate" name="xmjbxxSearchParameter.updateDate" type="text"
                                   class="laydate-icon-img form-control layer-date input-sm"
                                   value="${deptRelationSearchParameter.xmjbxxSearchParameter.updateDateBT}" style="width:220px;"/>
                        </div>
                    </form:form>
                    <br/>
                </div>
            </div>

            <!-- 工具栏 -->
            <div class="row">
                <div class="col-sm-12">
                    <div class="pull-left">
                        <table:viewRowWithCallback url="${ctx}/xmjbxx/xmjbxx/form" title="项目基本信息" width="1000px" height="700px" id="contentTable"
                                                   label="查看"></table:viewRowWithCallback>
                        <table:operateRow url="${ctx}/xmjbxx/xmjbxx/sngdjhThdbq" id="contentTable" operateIndex="2" label="退回待报区"></table:operateRow>
                        <table:selectSameGradeOfficePanel url="${ctx}/xmjbxx/xmjbxx/sngdjhZb" id="contentTable" operateIndex="1"
                                                          label="转办"></table:selectSameGradeOfficePanel>
                        <%--<table:selectPanel url="${ctx}/xmjbxx/xmjbxx/sngdjhCh" id="contentTable" operateIndex="1" type="chyy" selectName="chyy"
                                           contentLabel="请选择撤回原因：" label="撤回"></table:selectPanel>--%>
                        <table:operateRow url="${ctx}/xmjbxx/xmjbxx/sngdjhJiasuo" id="contentTable" operateIndex="5" label="加锁" checkFunc="checkJiasuo"></table:operateRow>
                        <table:operateRow url="${ctx}/xmjbxx/xmjbxx/sngdjhJiesuo" id="contentTable" operateIndex="6" label="解锁" checkFunc="checkJiesuo"></table:operateRow>
                        <shiro:hasPermission name="xmjbxx:xmjbxx:edit">
                            <table:editRowWithCallback url="${ctx}/xmjbxx/xmjbxx/form" title="项目基本信息" width="1000px" height="700px"
                                                       id="contentTable" checkFunc="checkEdit"></table:editRowWithCallback><!-- 编辑按钮 -->
                        </shiro:hasPermission>
                        <table:operateRow url="${ctx}/xmjbxx/xmjbxx/sngdjhTbcbxm" id="contentTable" operateIndex="1"
                                          label="使用滚动计划同步储备项目"></table:operateRow>
                        <table:operateRow url="${ctx}/xmjbxx/xmjbxx/sngdjhTszndjhbbq" id="contentTable" operateIndex="10"
                                          label="推送至年度计划编报区"></table:operateRow>
                        <table:viewRowWithCallback url="${ctx}/log/cInsBusinessLog/xmjbxxBusinessLogList" title="项目履历" id="contentTable" width="1000px" label="查看项目编报履历"></table:viewRowWithCallback>
                        <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i
                                class="glyphicon glyphicon-repeat"></i> 刷新
                        </button>
                    </div>
                    <div class="pull-right">
                        <button class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()"><i class="fa fa-search"></i> 查询</button>
                        <button class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()"><i class="fa fa-refresh"></i> 重置</button>
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
                        <th><input type="checkbox" class="i-checks"></th>
                        <th class="sort-column zdkbmgj">重大库编码</th>
                        <th>项目名称</th>
                        <th>所属行业</th>
                        <th>建设地点</th>
                        <th>项目类型</th>
                        <th class="sort-column ztz" align="right">总投资</th>
                        <th>符合政府投资方向</th>
                        <th>是否专项债</th>
                        <th>报送状态</th>
                        <th>是否PPP</th>
                        <th>专项类别</th>
                        <th>建议银行</th>
                        <th>拟开工年份</th>
                        <th>拟成建年份</th>
                        <th>审核辅助标志01</th>
                        <th>审核辅助标志02</th>
                        <th>审核辅助标志03</th>
                        <th>是否申请中央预算内资金</th>
                        <th>计划编制时间</th>
                        <th>最后操作时间</th>
                        <th>锁定状态</th>
                        <th>纳入状态</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.list}" var="deptRelation">
                        <c:set var="xmjbxx" value="${deptRelation.xmjbxx}"/>
                        <tr>
                            <td><input type="checkbox" id="${xmjbxx.id}" sztAttr="${xmjbxx.szt}" userGradeAttr="${fns:getUserOffice().grade}"
                                       xmmcAttr="${xmjbxx.xmmc}" class="i-checks"></td>
                            <td><a href="#" onclick="openXmjbxxView('查看项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${xmjbxx.id}','1000px', '700px')">
                                    ${xmjbxx.zdkbmgj}
                            </a></td>
                            <td>${fns:ellipsisText(xmjbxx.xmmc, 35)}</td>
                            <td>${fns:getTreeDictValue(xmjbxx.sshy)}</td>
                            <td>${fns:getTreeName(xmjbxx.jsdd, 'area')}</td>
                            <td>${fns:getDictLabel(xmjbxx.xmlx, 'xmlx', '')}</td>
                            <td align="right">${xmjbxx.ztz}</td>
                            <td>${fns:getTreeDictValue(xmjbxx.fhzftzfx)}</td>
                            <td>${fns:getDictLabel(xmjbxx.sfsqzxjsjj, 'yes_no', '否')}</td>
                            <td>${deptRelation.bsztStr}</td>
                            <td>${fns:getDictLabel(xmjbxx.sfppp, 'yes_no', '')}</td>
                            <td>${fns:getTreeDictValue(xmjbxx.zxlb)}</td>
                            <td>${fns:getDictLabel(xmjbxx.jyyh, 'jyyh', '')}</td>
                            <td>${xmjbxx.starttimen}</td>
                            <td>${xmjbxx.endtime}</td>
                            <td>${xmjbxx.shfzbsone}</td>
                            <td>${xmjbxx.shfzbstwo}</td>
                            <td>${xmjbxx.shfzbsthree}</td>
                            <td>${fns:getDictLabel(xmjbxx.sfsqzyysnzj, 'yes_no', '')}</td>
                            <td><fmt:formatDate value="${xmjbxx.jhbzDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td><fmt:formatDate value="${xmjbxx.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td>${xmjbxx.sztStr}</td>
                            <td>${deptRelation.nrztStr}</td>
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