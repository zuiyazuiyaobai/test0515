<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>项目公司构成</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            $('#contentTable thead tr th input.i-checks').on('ifChecked', function(event){ //ifCreated 事件应该在插件初始化之前绑定
                $('#contentTable tbody tr td input.i-checks').iCheck('check');
            });

            $('#contentTable thead tr th input.i-checks').on('ifUnchecked', function(event){ //ifCreated 事件应该在插件初始化之前绑定
                $('#contentTable tbody tr td input.i-checks').iCheck('uncheck');
            });
		});

		function doSubmit(func){
            var size = $("#contentTable tbody tr td input.i-checks:checked").size();
            if (size == 0) {
                top.layer.alert('请至少选择一条数据!', {icon: 0, title: '警告'});
                return;
            }
            if (size > 1) {
                top.layer.alert('只能选择一条数据!', {icon: 0, title: '警告'});
                return;
            }
            var name = $("#contentTable tbody tr td input.i-checks:checkbox:checked").attr("attrName");
            var office = $("#contentTable tbody tr td input.i-checks:checkbox:checked").attr("attrOffice");
            var mobile = $("#contentTable tbody tr td input.i-checks:checkbox:checked").attr("attrMobile");
            if(typeof func === 'function'){
                func(name, office, mobile);
			}
		}

        function add(){
            top.layer.open({
                type: 2,
                area: ['500px', '500px'],
                title: '新增',
                maxmin: true, //开启最大化最小化按钮
                content: '${ctx}/xmjbxx/sub/cInsBusinessContact/form' ,
                btn: ['确定', '关闭'],
                yes: function(index, layero){
                    var body = top.layer.getChildFrame('body', index);
                    var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
                    var inputForm = body.find('#inputForm');
                    var target = self.frameElement.getAttribute('name');//获取当前frame作为跳转目标
                    inputForm.attr("target",target);//表单提交成功后，从服务器返回的url在当前tab中展示

                    if(iframeWin.contentWindow.doSubmit() ){
                        setTimeout(function(){top.layer.close(index)}, 100);//延时0.1秒，对应360 7.1版本bug
                    }
                },
                cancel: function(index){
                }
            });
        }

        function edit() {
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
            top.layer.open({
                type: 2,
                area: ['500px', '500px'],
                title: '修改联系人信息',
                maxmin: true, //开启最大化最小化按钮
                content: '${ctx}/xmjbxx/sub/cInsBusinessContact/form?id=' + id,
                btn: ['确定', '关闭'],
                yes: function(index, layero){
                    var body = top.layer.getChildFrame('body', index);
                    var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
                    var inputForm = body.find('#inputForm');
                    var target = self.frameElement.getAttribute('name');//获取当前frame作为跳转目标
                    inputForm.attr("target",target);//表单提交成功后，从服务器返回的url在当前tab中展示

                    if(iframeWin.contentWindow.doSubmit() ){
                        setTimeout(function(){top.layer.close(index)}, 100);//延时0.1秒，对应360 7.1版本bug
                    }
                },
                cancel: function(index){
                }
            });
        }
	</script>
</head>
<body class="gray-bg">
<div class="ibox-content">
	<sys:message content="${message}"/>

	<!-- 搜索 -->
	<form:form id="searchForm" modelAttribute="contact" action="${ctx}/xmjbxx/sub/cInsBusinessContact/list" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	</form:form>

	<!-- 工具栏 -->
	<div class="row">
		<div class="col-sm-12">
			<div class="pull-left">
				<button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="left" onclick="add()" title="新增"><i class="fa fa-plus"></i> 新增</button>
				<button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="left" onclick="edit()" title="修改"><i class="fa fa-file-text-o"></i> 修改</button>
				<table:delRow url="${ctx}/xmjbxx/sub/cInsBusinessContact/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
				<button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button>
			</div>
		</div>
	</div>

	<table id="contentTable" class="table table-striped table-bordered  table-hover table-condensed  dataTables-example dataTable no-footer">
		<thead>
		<tr>
			<th><input type="checkbox" class="i-checks"></th>
			<th>姓名</th>
			<th>工作单位</th>
			<th>职务</th>
			<th>手机</th>
			<th>座机</th>
			<th>电子邮箱</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="contact">
			<tr>
				<td><input type="checkbox" id="${contact.id}" attrName="${contact.name}" attrOffice="${contact.office}" attrMobile="${contact.mobile}" class="i-checks"></td>
				<td>${contact.name}</td>
				<td>${contact.office}</td>
				<td>${contact.job}</td>
				<td>${contact.mobile}</td>
				<td>${contact.telephone}</td>
				<td>${contact.email}</td>
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