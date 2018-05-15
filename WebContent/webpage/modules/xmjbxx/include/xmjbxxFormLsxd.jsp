<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<div class="tz_sub" id="fen6" name="inputForm">
    <table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
		<tr>
			<th class="sort-column ">序号</th>
			<th  class="sort-column xmmc">文件标题</th>
			<th  class="sort-column create_Date">项目个数</th>
			<th  class="sort-column zdkbmgj">总投资(万元)</th>
			<th  class="sort-column zdkbmgj">本次下达金额</th>
			<th  class="sort-column zdkbmgj">操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${lsxdlist}" var="CInsBusinessSchedulerTask">
			<tr>
				<td>${status.index + 1}</td>
				<td>
					${CInsBusinessSchedulerTask.name}
				</td>
				<td>
					${CInsBusinessSchedulerTask.remarks}					
				</td>
				<td>
					${CInsBusinessSchedulerTask.type}
				</td>
				<td>
					${CInsBusinessSchedulerTask.requirement}
				</td>
				<td >
					<shiro:hasPermission name="xmjbxx:xmjbxx:view">
						<a href="javascript:void(0);" onclick="openSchedulerTaskView('${CInsBusinessSchedulerTask.id}')" style=" font-size:16px;cursor:pointer;background-color:#23c6c8;border-color:#23c6c8;color:#FFFFFF;border-radius:3px;" >查看</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>