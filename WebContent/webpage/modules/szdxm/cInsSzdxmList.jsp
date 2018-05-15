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
									title="2017年省重点项目-按地区统计" 
									subtitle=""
									xAxisData="${xAxisData}" 
									yAxisData="${yAxisData}" 
									xAxisName="地区"
									yAxisName="项目数" />							
							
								<div id="line_yAxisIndex"  class="main0002"></div>
								<echarts:bar 
								    id="line_yAxisIndex"
									title="2017年省重点项目-按行业统计" 
									subtitle=""
									xAxisData="${xAxisData2}" 
									yAxisData="${yAxisData2}" 
									xAxisName="行业"
									yAxisName="项目数" />

                            </div>
                        </div>
<div id="tab-2" class="tab-pane">
   	<div class="panel-body">
	   	<div class="wrapper wrapper-content">
		<div class="ibox">
		<div class="ibox-title">
			<h5>省重点项目进展情况汇总表 </h5>
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
            <form id="searchForm" modelAttribute="xmjbxxSearchParameter" action="${ctx}/szdxm/cInsSzdxm" method="post"
                       class="form-inline">
                <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
                <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
                <sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
                <input id="moreSearch" name="moreSearch" type="hidden" value="${xmjbxxSearchParameter.moreSearch}"/><!-- 是否展开更多查询 -->
                <div class="form-group right10">
                    <span>项目名称：</span>
                    <input path="xmmc" htmlEscape="false" maxlength="200" class=" form-control input-sm"/>
                </div>
             
                <div class="form-group right10">
                    <span>重大库编码：</span>
                    <input path="zdkbmgj" htmlEscape="false" maxlength="200" class=" form-control input-sm"/>
                </div>
                <div class="form-group right10 ibox-custom-content ibox-custom-content-hide">
					<span>是否开工：</span>
					<select path="sfkg" class="form-control required">
						<option value="" label=""/>
						<option value="1" label="未开工"/>
						<option value="2" label="开工"/>
					
					</select>
				</div> 

				<div class="form-group right10 ibox-custom-content ibox-custom-content-hide">
					<span>报送类别：</span>
					<select path="bslb" class="form-control required">
						<option value="" label=""/>
						<option value="1" label="2017省重点项目"/>
						<option value="2" label="2018省重点项目"/>
						<option value="3" label="2017省基建项目"/>
						<option value="4" label="2018省基建项目"/>
						<option value="5" label="5818项目"/>
						<option value="6" label="其他项目"/>
					</select>
				</div> 
               	<div class="form-group right10 ibox-custom-content ibox-custom-content-hide">
                       <span>开工情况：开工日期晚于计划开工日期</span>
                       <select path="wyjhyf" class="form-control required">
                           <option value="" label=""/>
                           <option value="0" label="0"/>
                           <option value="1"label="1" />
                           <option value="2" label="2"/>
                           <option value="3" label="3"/>
                           <option value="4" label="4" />
                           <option value="5" label="5"/>
                           <option value="6" label="6"/>
                           <option value="7" label="7" />
                           <option value="8" label="8"/>
                           <option value="9" label="9"/>
                           <option value="10" label="10"/>
                           <option value="11" label="11"/>
                           <option value="12" label="12"/>
                           <option value="13" label="13"/>
                           <option value="14" label="14"/>
                           <option value="15" label="15"/>
                           <option value="16" label="16"/>
                           <option value="17" label="17"/>
                           <option value="18" label="18"/>
                           <option value="19" label="19"/>
                           <option value="20" label="20"/>
                           <option value="21" label="21"/>
                           <option value="22" label="22"/>
                           <option value="23" label="23"/>
                           <option value="24" label="24"/>
                           <option value="25" label="25"/>
                           <option value="26" label="26"/>
                           <option value="27" label="27"/>
                           <option value="28" label="28"/>
                           <option value="29" label="29"/>
                           <option value="30" label="30"/>
                           <option value="31" label="31"/>
                           <option value="32" label="32"/>
                           <option value="33" label="33"/>
                           <option value="34" label="34"/>
                           <option value="35" label="35"/>
                           <option value="36" label="36"/>
                          
                       </select><span>个月</span>
                </div>
                <div class="form-group right10 ibox-custom-content ibox-custom-content-hide">
                    <span>投资完成情况：</span>
                    <elect path="tzwcqklb" class="form-control required">
                        <option value="" label=""/>
                        <option value="1" label="投资完成率"/>
                        <option value="2" label="年度投资完成率"/>
                        <option value="3" label="中央预算投资完成率"/>
                        
                    </select>——
                    <select path="tzwcqkbj" class="form-control required">
                        <option value="" label=""/>
                        <option value="1" label="低于"/>
                        <option value="2" label="高于"/>
                        <option value="3" label="不低于"/>
                        <option value="4" label="不高于"/>
                        <option value="5" label="等于"/>
                        
                    </select>——
                   	<input path="tzwcqkbl" htmlEscape="false" maxlength="30" class=" form-control input-sm"/>&nbsp;%
                </div>
                <div class="form-group right10 ibox-custom-content ibox-custom-content-hide">
                   <span>资金支付情况：</span>
                   <select path="zjzfqklb" class="form-control required">
                       <option value="" label=""/>
                       <option value="1" label="资金支付率"/>
                       <option value="2" label="年度资金支付"/>
                       <option value="3" label="中央预算资金支付"/>
                       
                   </select>——
                   <select path="zjzfqkbj" class="form-control required">
                       <option value="" label=""/>
                       <option value="1" label="低于"/>
                       <option value="2" label="高于"/>
                       <option value="3" label="不低于"/>
                       <option value="4" label="不高于"/>
                       <option value="5" label="等于"/>
                       
                   </select>——
                  <input path="zjzfqkbl" htmlEscape="false" maxlength="30" class=" form-control input-sm"/>&nbsp;%
                </div>
                <div class="form-group right10 ibox-custom-content ibox-custom-content-hide">
                    <span>资金到位情况：</span>
                    <select path="zjdwqklb" class="form-control required">
                        <option value="" label=""/>
                        <option value="1" label="资金到位率"/>
                        <option value="2" label="年度资金到位率"/>
                        <option value="3" label="中央预算资金到位率"/>
                        
                    </select>——
                    <select path="zjdwqkbj" class="form-control required">
                        <option value="" label=""/>
                        <option value="1" label="低于"/>
                        <option value="2" label="高于"/>
                        <option value="3" label="不低于"/>
                        <option value="4" label="不高于"/>
                        <option value="5" label="等于"/>
                        
                    </select>——
                   <input path="zjdwqkbl" htmlEscape="false" maxlength="30" class=" form-control input-sm"/>&nbsp;%
                </div>
           </form>
           <br/>
           </div>
       </div>

       <!-- 工具栏 -->
	   <div class="row">
	       <div class="col-sm-12">
	           <div class="pull-left">
	               
	               <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i
	                       class="glyphicon glyphicon-repeat"></i> 刷新
	               </button>
	           </div>
	           <div class="pull-right">
	               <button class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()"><i class="fa fa-search"></i> 查询</button>
	               <button class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()"><i class="fa fa-refresh"></i> 重置</button>
	               <a class="btn btn-primary btn-rounded btn-outline btn-sm collapse-custom-link"><i class="fa fa-chevron-down"></i><span
	                       name="button-text">更多</span></a>
	           </div>
	       </div>
	   </div>

		<jsp:include page="zdxmForm.jsp"></jsp:include>
	
		</div>
	    </div>
	    </div>
    </div>
</div>
