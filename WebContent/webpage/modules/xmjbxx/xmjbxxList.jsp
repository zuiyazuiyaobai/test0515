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
                elem: '#createDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
                range: '~',
                change: function (value, date, endDate) {
                    $("#createDateStart").val(date.year + '-' + date.month + '-' + date.date);
                    $("#createDateEnd").val(endDate.year + '-' + endDate.month + '-' + endDate.date);
                },
                done: function (value) {
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

        //打开添加页面
        function openAddXmjbxxView() {
            var target = null;
            var height = document.documentElement.clientHeight;
            if (height > 700) {
                height = 700;
            }

            top.layer.open({
                type: 2,
                area: ['1000px', height + 'px'],
                title: '项目基本信息',
                maxmin: true, //开启最大化最小化按钮
                content: '${ctx}/xmjbxx/xmjbxx/form',
                btn: ['导出项目信息', '保存并下一步', '保存', '关闭'],
                yes: function (index, layero) {
                    var iframeWin = layero.find('iframe')[0];
                    iframeWin.contentWindow.doExport();
                    return false;
                },
                btn2: function (index, layero) {//保存并下一步,保存当前 tab 并切换到下一 tab
                    var iframeWin = layero.find('iframe')[0];
                    iframeWin.contentWindow.saveAndNext(function () {
                        showTipCur("保存成功！");
                        setTimeout(function () {
                            top.layer.close(index)
                        }, 100);
                        setTimeout(function () {
                            sortOrRefresh();
                        }, 500);
                    });
                    return false;
                },
                btn3: function (index, layero) {//保存当前 tab 并关闭弹窗
                    console.log('btn3，保存并关闭...');

                    var body = top.layer.getChildFrame('body', index);
                    var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
                    var inputForm = body.find('#inputForm');
                    var top_iframe;
                    if (target) {
                        top_iframe = target;//如果指定了iframe，则在改frame中跳转
                    } else {
                        top_iframe = top.getActiveTab().attr("name");//获取当前active的tab的iframe
                    }
                    inputForm.attr("target", top_iframe);//表单提交成功后，从服务器返回的url在当前tab中展示

                    iframeWin.contentWindow.doSubmit(function () {
                        showTipCur("保存成功！");
                        setTimeout(function () {
                            top.layer.close(index)
                        }, 100);
                        setTimeout(function () {
                            sortOrRefresh();
                        }, 500);
                    });
                    return false;
                },
                btn4: function (index) {//这个可不写
                    sortOrRefresh();
                },
                cancel: function (index) {
                    //右上角关闭按钮
                },
                success: function (layero, index) {
                    var iframeWin = layero.find('iframe')[0];
                    iframeWin.contentWindow.setOperateType("add");
                }
            });
        }

        function checkBaosong(ids){
            var idArr = ids.split(",");
            for(var i = 0; i < idArr.length; i++) {
                var id = idArr[i];
                var zt = $("#" + id).attr("ztAttr");
                var xmmc = $("#" + id).attr("xmmcAttr");

                if("1" != zt) {// zt为1表示项目处于待报区；不处于待报区，不能上报
                    top.layer.alert("项目（" + xmmc + "）已报送");
                    return false;
                }
            }
            return true;
        }
    </script>
    <script src="/static/echarts-2.2.7/doc/asset/js/bootstrap-collapse.js" type="text/javascript"></script>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="ibox ibox-custom">
        <div class="ibox-title">
            <h5>填报区-项目基本信息列表 </h5>
            <div class="ibox-tools">
            </div>
        </div>

        <div class="ibox-content">
            <sys:message content="${message}"/>

            <!--查询条件-->
            <div class="row">
                <div class="col-sm-12">
                    <form:form id="searchForm" modelAttribute="xmjbxxDeptRelationSearchParameter" action="${ctx}/xmjbxx/xmjbxx/list" method="post"
                               class="form-inline">
                        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
                        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
                        <table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
                        <input id="moreSearch" name="moreSearch" type="hidden" value="${xmjbxxDeptRelationSearchParameter.moreSearch}"/><!-- 是否展开更多查询 -->
                        <div class="form-group right10">
                            <span>项目名称：</span>
                            <form:input path="xmjbxx.xmmc" htmlEscape="false" maxlength="200" class=" form-control input-sm"/>
                        </div>
                        <div class="form-group right10">
                            <span>填报状态：</span>
                            <form:select path="tbzt" class="form-control">
                                <form:option value="" label="全部"/>
                                <form:option value="1" label="待上报"/>
                                <form:option value="2" label="退回"/>
                            </form:select>
                        </div>
                        <div class="form-group right10">
                            <span>创建时间：</span>
                            <input type="hidden" name="createDateStart" id="createDateStart"
                                   value="<fmt:formatDate value='${xmjbxxDeptRelationSearchParameter.createDateStart}' pattern='yyyy-MM-dd'/>">
                            <input type="hidden" name="createDateEnd" id="createDateEnd"
                                   value="<fmt:formatDate value='${xmjbxxDeptRelationSearchParameter.createDateEnd}' pattern='yyyy-MM-dd'/>">
                            <input id="createDate" name="createDate" type="text" class="laydate-icon-img form-control input-sm"
                                   value="${xmjbxxDeptRelationSearchParameter.createDateBT}" style="width:220px;"/>
                        </div>
                        <div class="form-group right10 ibox-custom-content ibox-custom-content-hide">
                            <span>所属行业：</span>
                            <sys:treeselect id="sshy" name="xmjbxx.sshy" value="${xmjbxxDeptRelationSearchParameter.xmjbxx.sshy}" labelName="sshyStr"
                                            notAllowSelectParent="true"
                                            labelValue="${fns:getTreeDictValue(xmjbxxDeptRelationSearchParameter.xmjbxx.sshy)}" title="所属行业"
                                            url="/sys/treeDict/treeData?type=sshy"
                                            cssClass="form-control"/>
                        </div>
                        <div class="form-group right10 ibox-custom-content ibox-custom-content-hide">
                            <span>建设地点：</span>
                            <sys:treeselect id="jsdd" name="xmjbxx.jsdd" value="${xmjbxxDeptRelationSearchParameter.xmjbxx.jsdd}" labelName="jsddStr"
                                            labelValue="${fns:getTreeName(xmjbxxDeptRelationSearchParameter.xmjbxx.jsdd,'area')}"
                                            title="建设地点" url="/sys/area/treeData" cssClass="form-control m-s" allowClear="true"/>
                        </div>
                        <div class="form-group right10 ibox-custom-content ibox-custom-content-hide">
                            <span>项目类型：</span>
                            <form:select path="xmjbxx.xmlx" class="form-control">
                                <form:option value="" label="全部"/>
                                <form:options items="${fns:getDictList('xmlx')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                            </form:select>
                        </div>
                        <div class="ibox-custom-content form-group right10 ibox-custom-content-hide">
                            <span>总投资（万元）：</span>
                            <input id="ztzMin" name="ztzMin" type="number" onchange="compareExchange('ztzMin','ztzMax')" class="number form-control"
                                   value="${xmjbxxDeptRelationSearchParameter.ztzMin}" style="width:120px;"/> -
                            <input id="ztzMax" name="ztzMax" type="number" onchange="compareExchange('ztzMin','ztzMax')" class="form-control number"
                                   value="${xmjbxxDeptRelationSearchParameter.ztzMax}" style="width:120px;"/>
                        </div>
                    </form:form>
                    <br/>
                </div>
            </div>

            <!-- 工具栏 -->
            <div class="row">
                <div class="col-sm-12">
                    <div class="pull-left">
                        <shiro:hasPermission name="xmjbxx:xmjbxx:add">
                            <button class="btn btn-success btn-sm" data-toggle="tooltip" data-placement="left" onclick="openAddXmjbxxView()" title="新增">
                                <i class="fa fa-plus"></i> 新增
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="xmjbxx:xmjbxx:list:baosong">
                            <table:operateRow url="${ctx}/xmjbxx/xmjbxx/cbxmBsqBs" id="contentTable" operateIndex="1" label="报送" checkFunc="checkBaosong"
                                              imgStyle="fa-level-up"></table:operateRow>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="xmjbxx:xmjbxx:edit">
                            <table:editRowWithCallback url="${ctx}/xmjbxx/xmjbxx/form" title="项目基本信息" width="1000px" height="700px"
                                               id="contentTable" checkFunc="checkEdit"></table:editRowWithCallback><!-- 编辑按钮 -->
                        </shiro:hasPermission>
                        <%--<shiro:hasPermission name="xmjbxx:xmjbxx:del">--%>
                        <%--<table:delRow url="${ctx}/xmjbxx/xmjbxx/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->--%>
                        <%--</shiro:hasPermission>--%>
                        <shiro:hasPermission name="xmjbxx:xmjbxx:view">
                            <table:viewRowWithCallback url="${ctx}/xmjbxx/xmjbxx/form" title="项目基本信息" width="1000px" height="700px"
                                                       id="contentTable" label="查看"></table:viewRowWithCallback>
                        </shiro:hasPermission>

                        <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i
                                class="glyphicon glyphicon-repeat"></i> 刷新
                        </button>
                    </div>
                    <div class="pull-right">
                        <button class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()"><i class="fa fa-search"></i> 查询</button>
                        <button class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()"><i class="fa fa-refresh"></i> 重置</button>
                        <a class="btn btn-primary btn-rounded btn-outline btn-sm collapse-custom-link"><i class="fa fa-chevron-down"></i><span name="button-text">更多</span></a>
                    </div>
                </div>
            </div>

            <!-- 表格 -->
            <table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
                <thead>
                <tr>
                    <th><input type="checkbox" class="i-checks"></th>
                    <th>重大库编码</th>
                    <th>项目名称</th>
                    <th>填报状态</th>
                    <th>锁状态</th>
                    <th>所属行业</th>
                    <th>建设地点</th>
                    <th>项目类型</th>
                    <th class="sort-column b.ztz">总投资</th>
                    <th class="sort-column b.update_date">创建时间</th>
                    <%--<th>操作</th>--%>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.list}" var="relation">
                    <c:set var="xmjbxx" value="${relation.xmjbxx}"/>
                    <tr>
                        <td><input type="checkbox" id="${xmjbxx.id}" sztAttr="${xmjbxx.szt}" ztAttr="${xmjbxx.zt}" xmmcAttr="${xmjbxx.xmmc}" class="i-checks"></td>
                        <td><a href="#" onclick="openXmjbxxView('查看项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${xmjbxx.id}','1000px', '700px')">
                                ${xmjbxx.zdkbmgj}</a>
                        </td>
                        <td>
                                ${fns:ellipsisText(xmjbxx.xmmc, 35)}
                        </td>
                        <td>
                                ${xmjbxx.tbzt}
                        </td>
                        <td>
                                ${xmjbxx.sztStr}
                        </td>
                        <td>
                                ${fns:getTreeDictValue(xmjbxx.sshy)}
                        </td>
                        <td>
                                ${fns:getTreeName(xmjbxx.jsdd, 'area')}
                        </td>
                        <td>
                                ${fns:getDictLabel(xmjbxx.xmlx, 'xmlx', '')}
                        </td>
                        <td>
                                ${xmjbxx.ztz}
                        </td>
                        <td>
                            <fmt:formatDate value="${xmjbxx.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <%--<td>--%>
                            <%--<shiro:hasPermission name="xmjbxx:xmjbxx:view">--%>
                                <%--<a href="#" onclick="openXmjbxxView('查看项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${xmjbxx.id}','1000px', '700px')"--%>
                                   <%--class="btn btn-info btn-xs"><i class="fa fa-search-plus"></i> 查看</a>--%>
                            <%--</shiro:hasPermission>--%>
                            <%--<shiro:hasPermission name="xmjbxx:xmjbxx:edit">
                                <a href="#"
                                   onclick="openDialogWithCallback('修改项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${xmjbxx.id}','1000px', '700px')"
                                   class="btn btn-success btn-xs"><i class="fa fa-edit"></i> 修改</a>
                            </shiro:hasPermission>--%>
                                <%--<shiro:hasPermission name="xmjbxx:xmjbxx:del">
                                    <a href="${ctx}/xmjbxx/xmjbxx/delete?id=${xmjbxx.id}" onclick="return confirmx('确认要删除该项目基本信息吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
                                </shiro:hasPermission>--%>
                        <%--</td>--%>
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