<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp" %>
<html>
<head>
    <title>项目基本信息管理</title>
    <meta name="decorator" content="default"/>
   
<script src=" ${ctxStatic}/module/jdt/progressBar.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
        
        });
        
     
    </script>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="ibox ibox-custom">
        <div class="ibox-title">
            <h5>所有项目列表</h5>
            <div class="ibox-tools">
            </div>
        </div>
        <div style="width:100%; border:1px solid #ebcbbe; padding: 10px;">
          		<p s>
        		<font color="red">*1.项目开工：无论生产性或非生产性的项目，开工日期一般指永久性工程正式破土（包括正式打桩）的日期；在此之前的各项施工准备，如地质勘察、拆除旧建筑物、三通一平及辅助工程施工都不算正式开工。没有土建工程的项目，开工日期指安装工程开始的日期；开工日期有具体规定的项目，按相关规定认定。
				</font>
    	  		</p>
    	  	<p >
        	<font color="red">*2.累计下达投资：累计下达投资指历年投资计划下达该项目的投资金额，累计下达中央预算内投资指历年投资计划下达该项目的中央预算内资金金额。
			</font>
			</p>
			<p >
        	<font color="red">*3.累计完成投资：完成投资金额以监理的验工计价为准，有具体规定的项目，按相关规定认定。</font>
			</p>
			<p >
        	<font color="red">*4.资金到位：资金到位分两种情况：对于资金采用非报账制项目，指的是已到项目单位账户上资金金额；对于资金采用报账制项目，指的是到县（区）财政账户上的资金金额，须有财政部门预算文件证明。配套资金通过银行贷款落实的，以跟银行签订的贷款合同界定到位配套资金金额。
			</font>
			</p>
			<p >
        	<font color="red">*5.资金支付：指的是项目单位支付给施工单位的资金金额。
			</font>
			</p>
			<p >
        	<font color="red">*6.开工率：开工率=已开工项目个数/项目总个数*100%。
			</font>
			</p>
			<p >
        	<font color="red">*7.投资完成率：投资完成率=累计完成投资/总投资*100%。年度投资完成率=年初至今已完成投资/年度计划投资*100
			</font>
			</p>
			<p >
        		<font color="red">*8.中央预算内资金投资完成率=累计完成中央预算内资金/累计下达中央预算内资金*100%</font>
    	  	</p>
    	  	<p >
        		<font color="red">*9.资金到位率：资金到位率=累计到位资金/累计下达投资*100%。
        		</font>
    	  	</p>
    	  	<p >
        		<font color="red">*10.中央预算内资金到位率：中央预算内资金到位率=累计到位中央预算内资金/累计下达中央预算内资金*100%</font>
    	  	</p>
    	  		<p >
        		<font color="red">*11.配套资金落实率：配套资金落实率=累计到位配套资金/累计下达配套资金*100%</font>
    	  	</p>
    	  		<p >
        		<font color="red">*12.资金支付率：资金支付率=累计支付资金/累计完成投资*100%。</font>
    	  	</p>
    	  		<p >
        		<font color="red">*13.中央预算内资金支付率=累计支付中央预算内资金/累计完成中央预算内投资*100%</font>
    	  	</p>
          	</div>
        

        <div class="ibox-content">
            <sys:message content="${message}"/>

            <!--查询条件-->
            <div class="row">
                <div class="col-sm-12">
                    <form:form id="searchForm" modelAttribute="xmjbxxSearchParameter" action="${ctx}/xmjbxx/xmjbxx/allList" method="post"
                               class="form-inline">
                        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
                        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
                        <table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
                        <input id="moreSearch" name="moreSearch" type="hidden" value="${xmjbxxSearchParameter.moreSearch}"/><!-- 是否展开更多查询 -->
                        <div class="form-group right10">
                            <span>项目名称：</span>
                            <form:input path="xmmc" htmlEscape="false" maxlength="200" class=" form-control input-sm"/>
                        </div>
                     
                        <div class="form-group right10">
                            <span>重大库编码：</span>
                            <form:input path="zdkbmgj" htmlEscape="false" maxlength="200" class=" form-control input-sm"/>
                        </div>
                        <div class="form-group right10 ibox-custom-content ibox-custom-content-hide">
						<span>是否开工：</span>
						<form:select path="sfkg" class="form-control required">
							<form:option value="" label=""/>
							<form:option value="1" label="未开工"/>
							<form:option value="2" label="开工"/>
						
						</form:select>
					</div> 
					
					<div class="form-group right10 ibox-custom-content ibox-custom-content-hide">
						<span>报送类别：</span>
						<form:select path="bslb" class="form-control required">
							<form:option value="" label=""/>
							<form:option value="1" label="2017省重点项目"/>
							<form:option value="2" label="2018省重点项目"/>
							<form:option value="3" label="2017省基建项目"/>
							<form:option value="4" label="2018省基建项目"/>
							<form:option value="5" label="5818项目"/>
							<form:option value="6" label="其他项目"/>
						</form:select>
					</div> 
                    <div class="form-group right10 ibox-custom-content ibox-custom-content-hide">
                            <span>开工情况：开工日期晚于计划开工日期</span>
                            <form:select path="wyjhyf" class="form-control required">
                                <form:option value="" label=""/>
                                <form:option value="0" label="0"/>
                                <form:option value="1"label="1" />
                                <form:option value="2" label="2"/>
                                <form:option value="3" label="3"/>
                                <form:option value="4" label="4" />
                                <form:option value="5" label="5"/>
                                 <form:option value="6" label="6"/>
                                 <form:option value="7" label="7" />
                                <form:option value="8" label="8"/>
                                <form:option value="9" label="9"/>
                                <form:option value="10" label="10"/>
                                <form:option value="11" label="11"/>
                                <form:option value="12" label="12"/>
                                 <form:option value="13" label="13"/>
                                 <form:option value="14" label="14"/>
                                <form:option value="15" label="15"/>
                                <form:option value="16" label="16"/>
                                <form:option value="17" label="17"/>
                                <form:option value="18" label="18"/>
                                <form:option value="19" label="19"/>
                                 <form:option value="20" label="20"/>
                                 <form:option value="21" label="21"/>
                                <form:option value="22" label="22"/>
                                <form:option value="23" label="23"/>
                                <form:option value="24" label="24"/>
                                <form:option value="25" label="25"/>
                                <form:option value="26" label="26"/>
                                 <form:option value="27" label="27"/>
                                 <form:option value="28" label="28"/>
                                <form:option value="29" label="29"/>
                                <form:option value="30" label="30"/>
                                <form:option value="31" label="31"/>
                                <form:option value="32" label="32"/>
                                <form:option value="33" label="33"/>
                                 <form:option value="34" label="34"/>
                                 <form:option value="35" label="35"/>
                                <form:option value="36" label="36"/>
                               
                            </form:select><span>个月</span>
                        </div>
                         <div class="form-group right10 ibox-custom-content ibox-custom-content-hide">
                            <span>投资完成情况：</span>
                            <form:select path="tzwcqklb" class="form-control required">
                                <form:option value="" label=""/>
                                <form:option value="1" label="投资完成率"/>
                                <form:option value="2" label="年度投资完成率"/>
                                <form:option value="3" label="中央预算投资完成率"/>
                                
                            </form:select>——
                            <form:select path="tzwcqkbj" class="form-control required">
                                <form:option value="" label=""/>
                                <form:option value="1" label="低于"/>
                                <form:option value="2" label="高于"/>
                                <form:option value="3" label="不低于"/>
                                <form:option value="4" label="不高于"/>
                                <form:option value="5" label="等于"/>
                                
                            </form:select>——
                           <form:input path="tzwcqkbl" htmlEscape="false" maxlength="30" class=" form-control input-sm"/>&nbsp;%
                        </div>
                         <div class="form-group right10 ibox-custom-content ibox-custom-content-hide">
                            <span>资金支付情况：</span>
                            <form:select path="zjzfqklb" class="form-control required">
                                <form:option value="" label=""/>
                                <form:option value="1" label="资金支付率"/>
                                <form:option value="2" label="年度资金支付"/>
                                <form:option value="3" label="中央预算资金支付"/>
                                
                            </form:select>——
                            <form:select path="zjzfqkbj" class="form-control required">
                                <form:option value="" label=""/>
                                <form:option value="1" label="低于"/>
                                <form:option value="2" label="高于"/>
                                <form:option value="3" label="不低于"/>
                                <form:option value="4" label="不高于"/>
                                <form:option value="5" label="等于"/>
                                
                            </form:select>——
                           <form:input path="zjzfqkbl" htmlEscape="false" maxlength="30" class=" form-control input-sm"/>&nbsp;%
                        </div>
                        <div class="form-group right10 ibox-custom-content ibox-custom-content-hide">
                            <span>资金到位情况：</span>
                            <form:select path="zjdwqklb" class="form-control required">
                                <form:option value="" label=""/>
                                <form:option value="1" label="资金到位率"/>
                                <form:option value="2" label="年度资金到位率"/>
                                <form:option value="3" label="中央预算资金到位率"/>
                                
                            </form:select>——
                            <form:select path="zjdwqkbj" class="form-control required">
                                <form:option value="" label=""/>
                                <form:option value="1" label="低于"/>
                                <form:option value="2" label="高于"/>
                                <form:option value="3" label="不低于"/>
                                <form:option value="4" label="不高于"/>
                                <form:option value="5" label="等于"/>
                                
                            </form:select>——
                           <form:input path="zjdwqkbl" htmlEscape="false" maxlength="30" class=" form-control input-sm"/>&nbsp;%
                        </div>
                    </form:form>
                    <br/>
                </div>
            </div>

            <!-- 工具栏 -->
            <div class="row">
                <div class="col-sm-12">
                    <div class="pull-left">
                      <%--   <module:businessLogView url="${ctx}/log/cInsBusinessLog/xmjbxxBusinessLogList" title="项目履历" id="conten7tTable" width="1000px" label="查看项目编报履历"></module:businessLogView> --%>
                       
                      
                        <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i
                                class="glyphicon glyphicon-repeat"></i> 刷新
                        </button>
                       <shiro:hasPermission name="xmjbxx:xmjbxx:xmyjFsxx">
				             <table:operateRow url="${ctx}/xmjbxx/xmjbxx/xmyjFsxx" id="contentTable" operateIndex="8" label="预警" ></table:operateRow>
			          </shiro:hasPermission>
                        
                        
                    </div>
                    <div class="pull-right">
                        <button class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()"><i class="fa fa-search"></i> 查询</button>
                        <button class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()"><i class="fa fa-refresh"></i> 重置</button>
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
                        <th><input type="checkbox" class="i-checks"></th>
                        <td>重大库编码</td>
                        <td>平台编码</td>
                        <td>项目名称</td>
                        <td>项目建设地</td>
                        <td>总金额</td>
                        <td>项目类型</td>
                        <td>完成率</td>
                        <td>视频监控</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.list}" var="xmjbxx">
                        <tr>
                            <td><input type="checkbox" id="${xmjbxx.id}" sztAttr="${xmjbxx.szt}" userGradeAttr="${fns:getUserOffice().grade}"
                                       xmmcAttr="${xmjbxx.xmmc}" class="i-checks"></td>
                            <td><a href="#" onclick="openXmjbxxView('查看项目基本信息', '${ctx}/xmjbxx/xmjbxx/form?id=${xmjbxx.id}','1000px', '700px')">
                     ${xmjbxx.zdkbmgj}
                </a> </td>
                             <td>${xmjbxx.spjgptdm}</td>
                            <td>${xmjbxx.xmmc}</td>
                            <td>${fns:getTreeName(xmjbxx.jsdd, 'area')}</td>
                            <td>${xmjbxx.ztz}</td>
                            <td>${fns:getDictLabel(xmjbxx.xmlx, 'xmlx', '')}</td>
                            <td id="bfbid" class="div" w="${xmjbxx.hbl}" style="width:100px;"></td>
                            <td style="text-align:center"> 
                            <c:if test="${empty xmjbxx.JKSPURL}">
								<a href="${xmjbxx.JKSPURL}"  href ="javascript:return false;" onclick="return false;" style="cursor: default;" ><i  style="opacity: 0.2"></i> 查看视频</a>
								</c:if>
								<c:if test="${not empty xmjbxx.JKSPURL}">
								<a href="${xmjbxx.JKSPURL}" target="_blank" class="btn btn-info btn-xs" ><i   class="fa fa-search-plus"></i> 查看视频</a>
								</c:if>
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
</body>
</html>