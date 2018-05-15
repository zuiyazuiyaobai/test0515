<%@ page import="com.jeeplus.common.utils.IdGen" %>
<%@ page import="com.jeeplus.common.utils.SpringContextHolder" %>
<%@ page import="com.jeeplus.modules.xmjbxx.entity.sub.CInsBusinessXmjbxxDeptRelation" %>
<%@ page import="com.jeeplus.modules.xmjbxx.service.sub.CInsBusinessXmjbxxDeptRelationService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jeeplus.modules.xmjbxx.service.XmjbxxService" %>
<%@ page import="com.jeeplus.modules.xmjbxx.entity.Xmjbxx" %>
<%@ page import="com.jeeplus.modules.sys.entity.Office" %>
<%@ page import="com.jeeplus.modules.sys.service.OfficeService" %>
<%@ page import="com.jeeplus.modules.xmjbxx.vo.CInsBusinessXmjbxxDeptRelationSearchParameter" %>
<%@ page import="com.jeeplus.modules.xmjbxx.aop.XmjbxxDeptRelationAop" %>
<%@ page import="com.jeeplus.common.config.Global" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="com.jeeplus.modules.test.entity.validation.TestValidation" %>
<%@ page import="org.apache.commons.lang3.Validate" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/30
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test page</title>
    <script src="/static/jquery/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script>
        /*var makeData = $.post("/a/xmjbxx/xmjbxx/makeData", {}, function (result) {
            console.log("post function ...");
            console.log("post result: " + result);
            if (result.success) {
                $("#id").text(result.success);
            } else {
                $("#id").text(result.msg);
            }
        }).success(function (data, textStatus) {
            console.log("success function ...");
            console.log("data: " + data);
            console.log("textStatus: " + textStatus);
        }).error(function (XMLHttpRequest, textStatus, errorThrown) {
            console.log("error function ...");
            console.log("XMLHttpRequest: " + XMLHttpRequest);
            console.log("textStatus: " + textStatus);
            console.log("errorThrown: " + errorThrown);
            console.log("" + XMLHttpRequest.status + XMLHttpRequest.statusText + XMLHttpRequest.responseText);
        });

        makeData.complete(function(XMLHttpRequest, textStatus){
            console.log("complete function ...");
            console.log("XMLHttpRequest: " + XMLHttpRequest);
            console.log("textStatus: " + textStatus);
        })*/
    </script>
  <%--  <%
        TestValidation validation = new TestValidation();
        Validate.set
    %>--%>
</head>
<body>
<div id="id">
    haha
</div>
</body>
</html>
