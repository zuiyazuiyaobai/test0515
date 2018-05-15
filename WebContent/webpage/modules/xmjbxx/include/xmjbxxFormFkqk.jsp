<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<div class="tz_sub" id="fen7" name="inputForm">
    <table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
		<tr>
			<th class="sort-column ">序号</th>
			<th  class="sort-column ">姓名</th>
			<th  class="sort-column ">工作单位</th>
			<th  class="sort-column ">手机</th>
			<th  class="sort-column ">实际开工时间</th>
			<th  class="sort-column ">实际竣工时间</th>
			<th  class="sort-column ">操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${fkqklist}" var="CInsBusinessSsqk">
			<tr>
				
				<td>${status.index + 1}</td>
				<td>${CInsBusinessSsqk.name}</td>
				<td>${CInsBusinessSsqk.office}</td>
				<td>${CInsBusinessSsqk.mobile}</td>
				<td><fmt:formatDate value="${CInsBusinessSsqk.sjkgsj}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${CInsBusinessSsqk.sjjgsj}" pattern="yyyy-MM-dd"/></td>
				<td>
					<shiro:hasPermission name="xmjbxx:xmjbxx:view">
						<a href="javascript:void(0);" onclick="openfkqk('${CInsBusinessSsqk.id}')" style="font-size:16px;cursor:pointer;background-color:#23c6c8;border-color:#23c6c8;color:#FFFFFF;border-radius:3px;" >查看</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>