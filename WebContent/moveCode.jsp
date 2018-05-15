<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test page</title>
    <script src="/static/jquery/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script>
        $(function () {
            $.post("/a/xmjbxx/xmjbxx/moveCode", {}, function (result) {
                console.log("post result: " + result);
                $("#id").text(result.msg);
            }).error(function (XMLHttpRequest, textStatus, errorThrown) {
                console.log("textStatus: " + textStatus);
                console.log("errorThrown: " + errorThrown);
                console.log(XMLHttpRequest.responseText);
                $("#id").text(XMLHttpRequest.responseText);
            });
        })

    </script>
</head>
<body>
<div id="id"></div>
</body>
</html>
