<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
<title>项目基本信息管理</title>
<meta name="decorator" content="default" />
<link rel="stylesheet" href="${ctxStatic}/module/task/css/taskFeedbackForm.css" type="text/css">
<script type="text/javascript" src="${ctxStatic}/module/task/taskFeedbackForm.js"></script>
<script type="text/javascript" src="${ctxStatic}/module/xmjbxx/xmjbxxFormSsqk.js"></script>
<script type="text/javascript" src="${ctxStatic}/common/jquery.validate.custom.js"></script>
</head>
<body class="hideScroll">
	<%--调度指标填报要求--%>
	<div class="top_tip">
		项目名称：
		<a href="#" onclick="openXmjbxxView('修改项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${taskRelationVo.xmjbxx.id}','1000px', '700px')">
			${taskRelationVo.xmjbxx.xmmc}</a>
		<br/>
		<span style="color:red">点击可查看下达计划的详细信息，如基本信息，前期工作内容等。</span>
		<br/>
		<span style="color:red;float: right">【调度指标填报要求】</span>
	</div>

	<%--导航--%>
	<div id="test" style="height:30px; border-bottom:1px solid #477cb3">
		<ul>
			<li name="tab_1" class="tab tab_cur">实施情况</li>
			<li name="tab_2" class="tab tab_6w">历史下达情况</li>
			<li name="tab_3" class="tab">反馈情况</li>
		</ul>
	</div>
	<br />
	<sys:message content="${message}" />
<fieldset id="taskFeedbackForm">
	<%-- 实施情况 start --%>
	<div id="tab_1">
		<form:form id="inputForm" modelAttribute="curSsqk" action="#" method="post" class="form-horizontal">
			<form:hidden path="id" />
			<input type="hidden" name="taskRelation.id" value="${taskRelationVo.id}"/>
			<input type="hidden" name="xmjbxx.id" value="${taskRelationVo.xmjbxx.id}"/>
			<jsp:include page="/webpage/modules/xmjbxx/include/xmjbxxFormSsqk.jsp"></jsp:include>
		</form:form>
	</div>
	<%-- 项目基本信息 end --%>

	<div id="tab_2">
		<div style="margin:20px;">
			<jsp:include page="/webpage/modules/xmjbxx/include/xmjbxxFormLsxd.jsp"></jsp:include>
		</div>
	</div>

	<div id="tab_3">
		<div style="margin:20px;">
			<%-- <span>
			${taskRelationVo.feedback}
			<c:if test="taskRelationVo.feedback == null or taskRelationVo.feedback == ''">
				暂无反馈情况数据！
			</c:if>
			</span> --%>
			<jsp:include page="/webpage/modules/xmjbxx/include/xmjbxxFormFkqk.jsp"></jsp:include>
		</div>
	</div>
</fieldset>

</body>
</html>
