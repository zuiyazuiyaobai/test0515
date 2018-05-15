<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp" %>
<html>
<head>
    <title>调度任务</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#contentTable thead tr th input.i-checks').on('ifChecked', function (event) { //ifCreated 事件应该在插件初始化之前绑定
                $('#contentTable tbody tr td input.i-checks').iCheck('check');
            });

            $('#contentTable thead tr th input.i-checks').on('ifUnchecked', function (event) { //ifCreated 事件应该在插件初始化之前绑定
                $('#contentTable tbody tr td input.i-checks').iCheck('uncheck');
            });

        });

    </script>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="ibox ibox-custom">
        <div class="ibox-title">
            <h5>调度任务关联</h5>
            <div class="ibox-tools">
            </div>
        </div>

        <div class="ibox-content">
            <!-- 工具栏 -->
            <div class="row">
                <div class="col-sm-12">
                    <div class="pull-left">
                        <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()"
                                title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新
                        </button>
                    </div>
                </div>
            </div>

            <!-- 表格 -->
            <table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
                <thead>
                <tr>
                    <th><input type="checkbox" class="i-checks"></th>
                    <th>项目名称</th>
                    <th>项目类型</th>
                    <th>建设地点</th>
                    <th>总投资(万元)</th>
                    <th>任务名称</th>
                    <th>任务类型</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.list}" var="relation">
                    <c:set var="xmjbxx" value="${relation.xmjbxx}"/>
                    <c:set var="task" value="${relation.task}"/>
                    <tr>
                        <td><input type="checkbox" id="${relation.id}" class="i-checks"></td>
                        <td>
                            <a href="#" onclick="openXmjbxxView('项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${xmjbxx.id}','1000px', '700px')">
								${xmjbxx.xmmc }
							</a>
                        </td>
                        <td>
                                ${fns:getDictLabel(xmjbxx.xmlx, 'xmlx', '')}
                        </td>
                        <td>
                                ${fns:getTreeName(xmjbxx.jsdd, 'area')}
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
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <!-- 分页代码 -->
            <table:page page="${page}"></table:page>
            <br/>
        </div>
    </div>
</div>


</body>
</html>