<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp" %>
<html>
<head>
    <title>项目履历</title>
    <meta name="decorator" content="default"/>
    <script>
    </script>
    <style>
        .tab:hover {
            cursor: pointer;
        }

        .tab {
            float: left;
            width: 10%;
            height: 30px;
            text-align: center;
            line-height: 30px;
            padding-bottom: 0;
            list-style-type: none;
        }

        /*六个字的tab*/
        .tab_6w {
            min-width: 15%;
        }

        .tab_cur {
            float: left;
            width: 10%;
            height: 30px;
            text-align: center;
            line-height: 30px;
            padding-bottom: 0;
            list-style-type: none;
            background: linear-gradient(#477cb3, #FFFFFF);
        }
    </style>

    <script>
        $(function () {
            $(".tab").each(function () {
                $(this).bind("click", function () {
                    // 样式调整
                    if (!$(this).hasClass("tab_cur")) {
                        $(this).addClass("tab_cur");
                    }
                    $(this).siblings("li.tab").each(function () {
                        if ($(this).hasClass("tab_cur")) {
                            $(this).removeClass("tab_cur");
                        }
                    });

                    // 内容切换
                    var liName = $(this).attr("name");
                    if ("tab_1" == liName) {
                        $("#tab_1").show();
                        $("#tab_2").hide();
                        $("#tab_3").hide();
                        $("#tab_4").hide();
                    } else if ("tab_2" == liName) {
                        $("#tab_1").hide();
                        $("#tab_2").show();
                        $("#tab_3").hide();
                        $("#tab_4").hide();
                    } else if ("tab_3" == liName) {
                        $("#tab_1").hide();
                        $("#tab_2").hide();
                        $("#tab_3").show();
                        $("#tab_4").hide();
                    } else if ("tab_4" == liName) {
                        $("#tab_1").hide();
                        $("#tab_2").hide();
                        $("#tab_3").hide();
                        $("#tab_4").show();
                    }

                });

                // 双击刷新本页面
                $(this).bind("dblclick", function () {
                    reloadPage();
                })
            });

            var tab = "${tab == null ? "tab_1" : tab}";
            $("li[name='" + tab + "']").click();
            $("#" + tab).show();
        });

        function reloadPage(){
            location.href = self.frameElement.getAttribute("src") + "&tab=" + $(".tab_cur").attr("name");
        }
    </script>
</head>
<body class="hideScroll">

<%-- 页首tab --%>
<div id="test" style="height:30px; border-bottom:1px solid #477cb3;margin-bottom:15px;">
    <ul>
        <li name="tab_1" class="tab tab_6w">储备编报履历</li>
        <li name="tab_2" class="tab tab_6w">计划编报履历</li>
        <li name="tab_3" class="tab">转办履历</li>
        <li name="tab_4" class="tab">调度履历</li>
    </ul>
</div>

<%-- 储备编报履历 --%>
<div id="tab_1" style="display:none;padding: 0 15px;">
    <table class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
        <thead>
        <tr>
            <th>序号</th>
            <th>项目名称</th>
            <th>操作单位</th>
            <%--<th>操作人</th>--%>
            <th>操作</th>
            <th>接收单位</th>
            <th>接收人</th>
            <th>操作时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cbbbList}" var="businessLog" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td title="${businessLog.objectName}">${fns:ellipsisText(businessLog.objectName,20)}</td>
                <td title="${businessLog.operateDeptName}">${fns:ellipsisText(businessLog.operateDeptName,20)}</td>
                    <%--<td title="${businessLog.operateUserName}">${fns:ellipsisText(businessLog.operateUserName,20)}</td>--%>
                <td title="${businessLog.operate}">${businessLog.operate}</td>
                <td title="${businessLog.receiveDeptName}">${fns:ellipsisText(businessLog.receiveDeptName,20)}</td>
                <td title="${businessLog.receiveUserName}">${fns:ellipsisText(businessLog.receiveUserName,20)}</td>
                <td>${fns:formatDateTime(businessLog.createDate)}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%-- 储备编报履历 --%>
<div id="tab_2" style="display:none;padding: 0 15px;">
    <table class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
        <thead>
        <tr>
            <th>序号</th>
            <th>项目名称</th>
            <th>操作单位</th>
            <%--<th>操作人</th>--%>
            <th>操作</th>
            <th>接收单位</th>
            <th>接收人</th>
            <th>操作时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${jhbbList}" var="businessLog" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td title="${businessLog.objectName}">${fns:ellipsisText(businessLog.objectName,20)}</td>
                <td title="${businessLog.operateDeptName}">${fns:ellipsisText(businessLog.operateDeptName,20)}</td>
                    <%--<td title="${businessLog.operateUserName}">${fns:ellipsisText(businessLog.operateUserName,20)}</td>--%>
                <td title="${businessLog.operate}">${businessLog.operate}</td>
                <td title="${businessLog.receiveDeptName}">${fns:ellipsisText(businessLog.receiveDeptName,20)}</td>
                <td title="${businessLog.receiveUserName}">${fns:ellipsisText(businessLog.receiveUserName,20)}</td>
                <td>${fns:formatDateTime(businessLog.createDate)}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%-- 储备编报履历 --%>
<div id="tab_3" style="display:none;padding: 0 15px;">
    <table class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
        <thead>
        <tr>
            <th>序号</th>
            <th>项目名称</th>
            <th>操作单位</th>
            <%--<th>操作人</th>--%>
            <th>操作</th>
            <th>接收单位</th>
            <th>接收人</th>
            <th>操作时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${zbList}" var="businessLog" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td title="${businessLog.objectName}">${fns:ellipsisText(businessLog.objectName,20)}</td>
                <td title="${businessLog.operateDeptName}">${fns:ellipsisText(businessLog.operateDeptName,20)}</td>
                    <%--<td title="${businessLog.operateUserName}">${fns:ellipsisText(businessLog.operateUserName,20)}</td>--%>
                <td title="${businessLog.operate}">${businessLog.operate}</td>
                <td title="${businessLog.receiveDeptName}">${fns:ellipsisText(businessLog.receiveDeptName,20)}</td>
                <td title="${businessLog.receiveUserName}">${fns:ellipsisText(businessLog.receiveUserName,20)}</td>
                <td>${fns:formatDateTime(businessLog.createDate)}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%-- 储备编报履历 --%>
<div id="tab_4" style="display:none;padding: 0 15px;">
    <table class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
        <thead>
        <tr>
            <th>序号</th>
            <th>项目名称</th>
            <th>操作单位</th>
            <%--<th>操作人</th>--%>
            <th>操作</th>
            <th>接收单位</th>
            <th>接收人</th>
            <th>操作时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ddList}" var="businessLog" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td title="${businessLog.objectName}">${fns:ellipsisText(businessLog.objectName,20)}</td>
                <td title="${businessLog.operateDeptName}">${fns:ellipsisText(businessLog.operateDeptName,20)}</td>
                    <%--<td title="${businessLog.operateUserName}">${fns:ellipsisText(businessLog.operateUserName,20)}</td>--%>
                <td title="${businessLog.operate}">${businessLog.operate}</td>
                <td title="${businessLog.receiveDeptName}">${fns:ellipsisText(businessLog.receiveDeptName,20)}</td>
                <td title="${businessLog.receiveUserName}">${fns:ellipsisText(businessLog.receiveUserName,20)}</td>
                <td>${fns:formatDateTime(businessLog.createDate)}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>