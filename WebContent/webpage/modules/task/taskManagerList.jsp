<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp" %>
<html>
<head>
    <title>项目基本信息管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/module/task/taskManagerList.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="ibox ibox-custom">
        <div class="ibox-title">
            <h5>调度任务管理</h5>
            <div class="ibox-tools">
            </div>
        </div>

        <div class="ibox-content">
            <sys:message content="${message}"/>

            <!--查询条件-->
            <div class="row">
                <div class="col-sm-12">
                    <form:form id="searchForm" modelAttribute="schedulerTaskSearchParameter" action="${ctx}/task/schedulerTask/taskManagerList"
                               method="post" class="form-inline">
                    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
                    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
                    <table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
                    <input id="moreSearch" name="moreSearch" type="hidden" value="${schedulerTaskSearchParameter.moreSearch}"/><!-- 是否展开更多查询 -->
                    <div class="form-group">
                        <div class="form-group right10">
                            <span>任务名称：</span>
                            <form:input path="name" htmlEscape="false" maxlength="128" class=" form-control input-sm"/>
                        </div>
                        <div class="form-group right10">
                            <span>任务类型：</span>
                            <form:select path="type" class="form-control m-b">
                                <form:option value="" label=""/>
                                <form:options items="${fns:getDictList('task_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                            </form:select>
                        </div>
                        <div class="form-group right10">
                            <span>调度开始时间：</span>
                            <input type="hidden" name="startDateStart" id="startDateStart"
                                   value="<fmt:formatDate value='${schedulerTaskSearchParameter.startDateStart}' pattern='yyyy-MM-dd'/>">
                            <input type="hidden" name="startDateEnd" id="startDateEnd"
                                   value="<fmt:formatDate value='${schedulerTaskSearchParameter.startDateEnd}' pattern='yyyy-MM-dd'/>">
                            <input id="startDate" name="startDate" value="${schedulerTaskSearchParameter.startDateStr}" htmlEscape="false"
                                   class=" form-control input-sm"/>
                        </div>
                        <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                            <span>调度结束时间：</span>
                            <input type="hidden" name="endDateStart" id="endDateStart"
                                   value="<fmt:formatDate value='${schedulerTaskSearchParameter.endDateStart}' pattern='yyyy-MM-dd'/>">
                            <input type="hidden" name="endDateEnd" id="endDateEnd"
                                   value="<fmt:formatDate value='${schedulerTaskSearchParameter.endDateEnd}' pattern='yyyy-MM-dd'/>">
                            <input id="endDate" name="endDate" value="${schedulerTaskSearchParameter.endDateStr}" htmlEscape="false"
                                   class=" form-control input-sm"/>
                        </div>
                        </form:form>
                        <br/>
                        <br/>
                    </div>
                </div>
            </div>

            <!-- 工具栏 -->
            <div class="row">
                <div class="col-sm-12">
                    <div class="pull-left">
                        <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="left" onclick="openAddSchedulerTaskView()"
                                title="新增"><i class="fa fa-plus"></i> 新增</button>
                        <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="left" onclick="openEditSchedulerTaskView()"
                                title="新增"><i class="fa fa-pencil-square-o"></i> 修改</button>
                        <table:operateRow url="${ctx}/task/schedulerTask/issueTasks" id="contentTable" imgStyle="fa-angle-double-down" operateIndex="1" label="下发"></table:operateRow>
                        <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i
                                class="glyphicon glyphicon-repeat"></i> 刷新</button>
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
            <table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
                <thead>
                <tr>
                    <th><input type="checkbox" class="i-checks"></th>
                    <th>任务名称</th>
                    <th>任务类型</th>
                    <th class="sort-column start_date">调度开始时间</th>
                    <th class="sort-column end_date">调度结束时间</th>
                    <th>调度包含项目数</th>
                    <th>状态</th>
                    <th>调度要求</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${taskVoList}" var="taskVo">
                    <tr>
                        <td><input type="checkbox" id="${taskVo.id}" class="i-checks"></td>
                        <td><a href="#" onclick="openSchedulerTaskView('${taskVo.id}')">
                            ${fns:ellipsisText(taskVo.name, 35)}
                        </a></td>
                        <td>
                            ${fns:getDictLabel(taskVo.type, "task_type", "")}
                        </td>
                        <td>
                            <fmt:formatDate value="${taskVo.startDate}" pattern="yyyy-MM-dd"/>
                        </td>
                        <td>
                            <fmt:formatDate value="${taskVo.endDate}" pattern="yyyy-MM-dd"/>
                        </td>
                        <td>
                            ${fn:length(taskVo.relations)}
                        </td>
                        <td>
                            ${taskVo.statusStr}
                        </td>
                        <td>
                            ${taskVo.requirement}
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
</body>
</html>