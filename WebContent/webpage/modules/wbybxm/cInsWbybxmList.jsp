<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<%@ include file="/webpage/include/echarts.jsp"%>
<meta name="decorator" content="default"/>
 <div class="tabs-container">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">统计图表</a>
                        </li>
                        <li class=""><a data-toggle="tab" href="#tab-2" aria-expanded="false">数据列表</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div id="tab-1" class="tab-pane active">
                            <div class="panel-body">
							                
								<div id="line_normal"  class="main000"></div>
							    <echarts:bar 
							        id="line_normal"
									title="2017年5818项目-按地区统计" 
									subtitle=""
									xAxisData="${xAxisData}" 
									yAxisData="${yAxisData}" 
									xAxisName="地区"
									yAxisName="项目数" />							
							
								<div id="line_yAxisIndex"  class="main0002"></div>
								<echarts:bar 
								    id="line_yAxisIndex"
									title="2017年5818项目-按领域统计" 
									subtitle=""
									xAxisData="${xAxisData2}" 
									yAxisData="${yAxisData2}" 
									xAxisName="领域"
									yAxisName="项目数" />

                            </div>
                        </div>
                        <div id="tab-2" class="tab-pane">
                            <div class="panel-body">
							   <div class="wrapper wrapper-content">
								<div class="ibox">
								<div class="ibox-title">
									<h5>5818项目进展情况汇总表 </h5>
									<div class="ibox-tools">
										<a class="collapse-link">
											<i class="fa fa-chevron-up"></i>
										</a>
										<a class="dropdown-toggle" data-toggle="dropdown" href="#">
											<i class="fa fa-wrench"></i>
										</a>
										<ul class="dropdown-menu dropdown-user">
											<li><a href="#">选项1</a>
											</li>
											<li><a href="#">选项2</a>
											</li>
										</ul>
										<a class="close-link">
											<i class="fa fa-times"></i>
										</a>
									</div>
								</div> 
							    
							    <div class="ibox-content">
								<sys:message content="${message}"/>
								
								<!--查询条件-->
								<div class="row">
								<div class="col-sm-12">
								<form:form id="searchForm" modelAttribute="chinaWeatherDataBean" action="${ctx}/zyysnxm/cInsZyysnxm/" method="post" class="form-inline">
									<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
									<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
									<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
									<div class="form-group">
									 </div>	
								</form:form>
								<br/>
								</div>
								</div>
								
								<!-- 工具栏 -->
								<div class="row">
								<div class="col-sm-12">
									<div class="pull-left">
					
										<shiro:hasPermission name="zyysnxm:cInsZyysnxm:export">
								       		<table:exportExcel url="${ctx}/zyysnxm/cInsZyysnxm/export"></table:exportExcel><!-- 导出按钮 -->
								       	</shiro:hasPermission>
								       <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button>
									
										</div>
									<div class="pull-right">
										<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()" ><i class="fa fa-search"></i> 查询</button>
										<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()" ><i class="fa fa-refresh"></i> 重置</button>
										<a class="btn btn-primary btn-rounded btn-outline btn-sm collapse-custom-link"><i class="fa fa-chevron-down"></i><span
                                name="button-text">更多</span></a>
									</div>
								</div>
								</div>
								
								<!-- 表格 -->
								<div class="table-flow-contain">
								<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
									<thead>
										<tr>
											<th> <input type="checkbox" class="i-checks"></th>
											<th  class="sort-column xh">序号</th>
											<th  class="sort-column cj">层级</th>
											<th  class="sort-column sxmc">市县名称</th>
											<th  class="sort-column xmgs">项目个数</th>
											<th  class="sort-column ztz">总投资</th>
											<th  class="sort-column ndjhtz">2017年年度计划投资</th>
											<th  class="sort-column ljwctz">2017年年初以来已累计完成投资</th>
											<th  class="sort-column ykgxms">已开工项目个数</th>
											<th  class="sort-column ywgxms">已完工项目个数</th>
											<th  class="sort-column ndtzwcl">年度投资完成率</th>
											<th  class="sort-column kgl">开工率</th>
											<th  class="sort-column wgl">完工率</th>
											
										</tr>
									</thead>
									</div>
									<tbody>
									<c:forEach items="${page.list}" begin="0" step="1"  varStatus="status" var="cInsWbybxm">
										<tr>
											<td> <input type="checkbox" id="${cInsWbybxm.id}" class="i-checks"></td>
											<td><c:out value="${(status.index)+1}"/></td>
											<td>
												${cInsWbybxm.qhtype}
											</td>
											<td>
												${cInsWbybxm.qhname}
											</td>
											<td>
												${cInsWbybxm.xmgs}
											</td>
											<td>
												${cInsWbybxm.ztz}
											</td>
											<td>
												${cInsWbybxm.bndjhtz}
											</td>
											<td>
												${cInsWbybxm.bndywctz}
											</td>
											<td>
												${cInsWbybxm.ykgxmgs}
											</td>
											<td>
												${cInsWbybxm.ywgxmgs}
											</td>
											<td>
												${cInsWbybxm.ndtzwcl}
											</td>
											<td>
												${cInsWbybxm.kgl}
											</td>
											<td>
												${cInsWbybxm.wgl}
											</td>
											<td>
												<shiro:hasPermission name="wbybxm:cInsWbybxm:view">
													<a href="#" onclick="openDialogView('查看城市气温', '${ctx}/wbybxm/cInsWbybxm/form?id=${chinaWeatherDataBean.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
												</shiro:hasPermission>
												<shiro:hasPermission name="wbybxm:cInsWbybxm:edit">
							    					<a href="#" onclick="openDialog('修改城市气温', '${ctx}/wbybxm/cInsWbybxm/form?id=${chinaWeatherDataBean.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
							    				</shiro:hasPermission>
							    				<shiro:hasPermission name="wbybxm:cInsWbybxm:del">
													<a href="${ctx}//wbybxm/cInsWbybxm/delete?id=${chinaWeatherDataBean.id}" onclick="return confirmx('确认要删除该城市气温吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
												</shiro:hasPermission>
											</td>
										</tr>
									</c:forEach>
									</tbody>
								</table>
								</div>
									<!-- 分页代码 -->
								<table:page page="${page}"></table:page>
								<br/>
								<br/>
								
							</div>
                            </div>
                        </div>
                    </div>
                </div>
