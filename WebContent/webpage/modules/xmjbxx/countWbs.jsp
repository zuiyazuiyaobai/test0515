<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
<title>项目基本信息管理</title>
<meta name="decorator" content="default" />

<style type="text/css">	
</style>
</head>
<body class="hideScroll" style="padding-top: 20px;">
	<div style="height:244px;width:300px;padding-top:20px;">
		<!-- <p style="word-wrap: break-word;word-break:break-all;overflow:hidden;padding-left:30px;">111</p> -->
		<div onclick="towsh()" style="cursor:pointer;padding-left:30px;color:#FF0000" >需要审核的项目个数：(${countwsh})</div>
		<br>
		<div onclick="towdd()" style="cursor:pointer;padding-left:30px;color:#FF0000">需要督办的调度任务个数：(${countwdd})</div>
	</div>
  	<script type="text/javascript">
  	function towsh(){
  		window.location.href="${ctx}/xmjbxx/xmjbxx/cbxmShqList";
  	}
  	function towdd(){
  		window.location.href="${ctx}/task/cInsBusinessXmjbxxTaskRelation/myTaskList";
  	}
  	
  	</script>
</body>

</html>
