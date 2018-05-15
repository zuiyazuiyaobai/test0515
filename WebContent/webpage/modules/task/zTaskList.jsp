<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp" %>
<html>
<head>
    <title>总调度任务</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#contentTable thead tr th input.i-checks').on('ifChecked', function (event) { //ifCreated 事件应该在插件初始化之前绑定
                $('#contentTable tbody tr td input.i-checks').iCheck('check');
            });

            $('#contentTable thead tr th input.i-checks').on('ifUnchecked', function (event) { //ifCreated 事件应该在插件初始化之前绑定
                $('#contentTable tbody tr td input.i-checks').iCheck('uncheck');
            });

            laydate.render({
                elem: '#startDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
                range: true,
                change: function (value, date, endDate) {
                    $("#startDateStart").val(date.year + '-' + date.month + '-' + date.date);
                    $("#startDateEnd").val(endDate.year + '-' + endDate.month + '-' + endDate.date);
                },
                done: function (value) {
                    //点击清空时，清除隐藏域的值
                    if (null == value || '' == value) {
                        $("#startDate").val("");
                        $("#startDateStart").val("");
                        $("#startDateEnd").val("");
                    }
                }
            });
            laydate.render({
                elem: '#endDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
                range: true,
                change: function (value, date, endDate) {
                    $("#endDateStart").val(date.year + '-' + date.month + '-' + date.date);
                    $("#endDateEnd").val(endDate.year + '-' + endDate.month + '-' + endDate.date);
                },
                done: function (value) {
                    //点击清空时，清除隐藏域的值
                    if (null == value || '' == value) {
                        $("#endDate").val("");
                        $("#endDateStart").val("");
                        $("#endDateEnd").val("");
                    }
                }
            });
        });

        // 完成项目调度
        function finishTask() {
            var size = $("#contentTable tbody tr td input.i-checks:checked").size();
            if (size == 0) {
                top.layer.alert('请至少选择一条数据!', {icon: 0, title: '警告'});
                return;
            }

            if (size > 1) {
                top.layer.alert('只能选择一条数据!', {icon: 0, title: '警告'});
                return;
            }
            var id = $("#contentTable tbody tr td input.i-checks:checkbox:checked").attr("id");

            top.layer.confirm('确认要完成该调度项目吗？', {icon: 3, title: '系统提示'}, function (index) {
                top.layer.close(index);

                top.layer.open({
                    type: 1,
                    area: ["500px", "400px"],
                    title: "调度反馈",
                    content: $("#finishTaskFormDiv").html(),
                    btn: ['确定', '关闭'],
                    btn1: function (index) {
                        top.$("#taskId").val(id);
                        var value = top.$("#feedback").val();
                        if (null == value || '' == value) {
                            top.layer.alert("请填写调度反馈！");
                            return false;
                        }

                        //设定controller返回页面的目标iframe
                        var target = top.getActiveTab().attr("name");
                        top.$("#finishTaskForm").attr("target", target);

                        top.$("#finishTaskForm").submit();
                        top.layer.close(index);
                    },

                    btn2: function (index) {
                        top.layer.close(index);
                    }
                });
            });

        }

        // 修改项目调度
        function editTaskFeedback() {
            var size = $("#contentTable tbody tr td input.i-checks:checked").size();
            if (size == 0) {
                top.layer.alert('请至少选择一条数据!', {icon: 0, title: '警告'});
                return;
            }

            if (size > 1) {
                top.layer.alert('只能选择一条数据!', {icon: 0, title: '警告'});
                return;
            }
            var id = $("#contentTable tbody tr td input.i-checks:checkbox:checked").attr("id");

        }
    </script>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="ibox ibox-custom">
        <div class="ibox-title">
            <h5>我的调度任务</h5>
            <div class="ibox-tools">
            </div>
        </div>

        <div class="ibox-content">
            <sys:message content="${message}"/>

            <!--查询条件-->
            <div class="row">
                <div class="col-sm-12">
                    <form:form id="searchForm" modelAttribute="xmjbxxTaskRelationSearchParameter"
                               action="${ctx}/task/cInsBusinessXmjbxxTaskRelation/zTaskList" method="post" class="form-inline">
                        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
                        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
                        <table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
                        <input id="moreSearch" name="moreSearch" type="hidden"
                               value="${xmjbxxTaskRelationSearchParameter.moreSearch}"/><!-- 是否展开更多查询 -->
                        <div class="form-group">
                            <div class="form-group right10">
                                <span>任务名称：</span>
                                <form:input path="task.name" htmlEscape="false" maxlength="128" class=" form-control input-sm"/>
                            </div>
                            <div class="form-group right10">
                                <span>项目名称：</span>
                                <form:input path="xmjbxx.xmmc" htmlEscape="false" maxlength="200" class=" form-control input-sm"/>
                            </div>
                            <div class="form-group right10">
                                <span class="left10">所属行业：</span>
                                <sys:treeselect id="sshy" name="xmjbxx.sshy" value="${xmjbxxTaskRelationSearchParameter.xmjbxx.sshy}"
                                                labelName="sshyStr"
                                                labelValue="${fns:getTreeDictValue(xmjbxxTaskRelationSearchParameter.xmjbxx.sshy)}"
                                                notAllowSelectParent="true"
                                                title="所属行业" url="/sys/treeDict/treeData?type=sshy" cssClass="form-control"/>
                            </div>
                            <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                                <span class="left10">建设地点：</span>
                                <sys:treeselect id="jsdd" name="xmjbxx.jsdd" value="${xmjbxxTaskRelationSearchParameter.xmjbxx.jsdd}"
                                                labelName="jsddStr"
                                                labelValue="${fns:getTreeName(xmjbxxTaskRelationSearchParameter.xmjbxx.jsdd,'area')}"
                                                title="建设地点" url="/sys/area/treeData" cssClass="form-control m-s" allowClear="true"/>
                            </div>
                            <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                                <span>任务类型：</span>
                                <form:select path="task.type" class="form-control m-b">
                                    <form:option value="" label=""/>
                                    <form:options items="${fns:getDictList('task_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                                </form:select>
                            </div>
                            <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                                <span>调度开始时间：</span>
                                <input type="hidden" name="startDateStart" id="startDateStart"
                                       value="<fmt:formatDate value='${xmjbxxTaskRelationSearchParameter.startDateStart}' pattern='yyyy-MM-dd'/>">
                                <input type="hidden" name="startDateEnd" id="startDateEnd"
                                       value="<fmt:formatDate value='${xmjbxxTaskRelationSearchParameter.startDateEnd}' pattern='yyyy-MM-dd'/>">
                                <input id="startDate" name="startDate" value="${xmjbxxTaskRelationSearchParameter.startDateStr}" htmlEscape="false"
                                       class=" form-control input-sm"/>
                            </div>
                            <div class="form-group ibox-custom-content ibox-custom-content-hide right10">
                                <span>调度结束时间：</span>
                                <input type="hidden" name="endDateStart" id="endDateStart"
                                       value="<fmt:formatDate value='${xmjbxxTaskRelationSearchParameter.endDateStart}' pattern='yyyy-MM-dd'/>">
                                <input type="hidden" name="endDateEnd" id="endDateEnd"
                                       value="<fmt:formatDate value='${xmjbxxTaskRelationSearchParameter.endDateEnd}' pattern='yyyy-MM-dd'/>">
                                <input id="endDate" name="endDate" value="${xmjbxxTaskRelationSearchParameter.endDateStr}" htmlEscape="false"
                                       class=" form-control input-sm"/>
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
                       <!--  <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="left" onclick="finishTask()"
                                title="完成"><i class="fa fa-check-square-o"></i> 完成
                        </button> -->
                        <%-- <shiro:hasPermission name="task:cInsBusinessXmjbxxTaskZjtask">
							<button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="left" onclick="finishTask()"
                                title="完成"><i class="fa fa-check-square-o"></i> 完成
                        	</button>
						</shiro:hasPermission>
                        <table:editRowWithCallback url="${ctx}/task/cInsBusinessXmjbxxTaskRelation/taskFeedback" title="调度反馈" width="800px" height="600px" id="contentTable"></table:editRowWithCallback><!-- 编辑按钮 --> --%>
                        <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()"
                                title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新
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
            <table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
                <thead>
                <tr>
                    <th><input type="checkbox" class="i-checks"></th>
                    <th>序号</th>
                    <th>项目名称</th>
                    <th>项目类型</th>
                    <th>建设地点</th>
                    <th>所属行业</th>
                    <th>总投资(万元)</th>
                    <th>任务名称</th>
                    <th>任务类型</th>
                    <th class="sort-column start_date">调度开始时间</th>
				    <th class="sort-column end_date">调度结束时间</th>
                    <th>状态</th>
                    <th>调度下发部门</th>
                    <th>调度要求</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.list}" var="relation">
                    <c:set var="xmjbxx" value="${relation.xmjbxx}"/>
                    <c:set var="task" value="${relation.task}"/>
                    <tr>
                        <td><input type="checkbox" id="${relation.id}" class="i-checks"></td>
                        <td>
                                ${status.index + 1}
                        </td>
                        <td><a href="#" onclick="openDialogViewWithCallBack('查看调度反馈', '${ctx}/task/cInsBusinessXmjbxxTaskRelation/taskFeedback?id=${relation.id}','800px', '600px')">
                                ${fns:ellipsisText(xmjbxx.xmmc, 35)}
                        </a></td>
                        <td>
                                ${fns:getDictLabel(xmjbxx.xmlx, 'xmlx', '')}
                        </td>
                        <td>
                                ${fns:getTreeName(xmjbxx.jsdd, 'area')}
                        </td>
                        <td>
                                ${fns:getTreeDictValue(xmjbxx.sshy)}
                        </td>
                        <td>
                            <span class="pull-right">${xmjbxx.ztz}</span>
                        </td>
                        <td><a href="#" onclick="openSchedulerTaskView('${task.id}')">
                                ${task.name}
                        </a></td>
                        <td>
                                ${fns:getDictLabel(task.type, 'task_type', '')}
                        </td>
                        <td>
						<fmt:formatDate value="${task.startDate}" pattern="yyyy-MM-dd"/>
					    </td>
					    <td>
						<fmt:formatDate value="${task.endDate}" pattern="yyyy-MM-dd"/>
					    </td>
                        <td>
                                ${relation.statusStr}
                        </td>
                        <td>
                              ${fns:ellipsisText(task.dept.name, 20)}  
                        </td>
                        <td>${task.requirement}</td>
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

<%--推送至待报区弹框--%>
<div id="finishTaskFormDiv" style="display:none;">
    <form id="finishTaskForm" action="${ctx}/task/cInsBusinessXmjbxxTaskRelation/finishTask" method="post">
        <input type="hidden" id="taskId" name="id" value=""/>

        <div style="margin: 20px 30px 0 30px;">
            <span style="font-size: 14px;margin-bottom: 10px;">调度回馈：</span>
            <br>
            <br>
            <textarea id="feedback" name="feedback" maxlength="500" class="form-control" rows="3"></textarea>
        </div>
    </form>
</div>
</body>
</html>