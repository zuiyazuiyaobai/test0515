<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>从储备库挑选项目</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#contentTable thead tr th input.i-checks').on('ifChecked', function (event) { //ifCreated 事件应该在插件初始化之前绑定
				$('#contentTable tbody tr td input.i-checks').iCheck('check');
			});

			$('#contentTable thead tr th input.i-checks').on('ifUnchecked', function (event) { //ifCreated 事件应该在插件初始化之前绑定
				$('#contentTable tbody tr td input.i-checks').iCheck('uncheck');
			});
		});

		function doSubmit(func){//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
			var str = "";
			var ids = "";
			$("#contentTable tbody tr td input.i-checks:checkbox").each(function () {
				if (true == $(this).is(':checked')) {
					str += $(this).attr("id") + ",";
				}
			});
			if (str.substr(str.length - 1) == ',') {
				ids = str.substr(0, str.length - 1);
			}
			if (ids == "") {
				top.layer.alert('请至少选择一条数据!', {icon: 0, title: '警告'});
				return false;
			}
			top.layer.confirm('确认要挑选该项目吗?', {icon: 3, title: '系统提示'}, function (index) {
                $.post('${ctx}/xmjbxx/xmjbxx/tzjhBzqBzq', {ids: ids}, function (result) {
                    if (result.success) {
                        showTipTop(result.msg);
                        func();
                    } else if (!result.success) {
                        top.layer.alert(result.msg);
                    } else {
                        top.layer.alert("请求失败！");
                    }
                });
                top.layer.close(index);
			});
		}
	</script>
</head>
<body class="gray-bg">
<div class="ibox-content">
	<sys:message content="${message}"/>

	<!--查询条件-->
	<div class="row">
		<div class="col-sm-12">
			<form:form id="searchForm" modelAttribute="xmjbxx" action="${ctx}/xmjbxx/xmjbxx/tzjhBzqForm" method="post" class="form-inline">
				<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
				<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
				<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
				<input id="moreSearch" name="moreSearch" type="hidden" value="${xmjbxx.moreSearch}"/><!-- 是否展开更多查询 -->
				<div class="form-group">
					<span>项目名称：</span>
					<form:input path="xmmc" htmlEscape="false" maxlength="200" class=" form-control input-sm"/>
				</div>
			</form:form>
			<br/>
		</div>
	</div>

	<!-- 工具栏 -->
	<div class="row">
		<div class="col-sm-12">
			<div class="pull-right">
				<button class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()"><i class="fa fa-search"></i> 查询</button>
				<button class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()"><i class="fa fa-refresh"></i> 重置</button>
			</div>
		</div>
	</div>

	<!-- 表格 -->
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
		<tr>
			<th><input type="checkbox" class="i-checks"></th>
			<th class="sort-column zdkbmgj">重大库编码</th>
			<th class="sort-column xmmc">项目名称</th>
			<th class="sort-column create_Date">创建时间</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="xmjbxx">
			<tr>
				<td><input type="checkbox" id="${xmjbxx.id}" class="i-checks"></td>
				<!-- <td></td> -->
				<td><a href="#" onclick="openDialogView('查看项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${xmjbxx.id}','800px', '500px')">
						${xmjbxx.zdkbmgj}</a></td>
				<td>${xmjbxx.xmmc}</td>
				<td><fmt:formatDate value="${xmjbxx.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<!-- 分页代码 -->
	<table:page page="${page}"></table:page>
	<br/>
	<br/>
</div>
</body>
</html>