<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>

<div class="tz_sub" id="fen5" name="inputForm">
    <div><span style="color:#477cb3;font-size:15px;">| 本期调度填报人</span>
        <span id="selectContact" style="margin-left:12px;font-size:14px;color:#EC000A" onclick="openXzlxrDialog()">
                <u>选择联系人</u></span></div>
    <table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
        <tbody>
        <tr>
            <td class="width-20 active"><label class="pull-right">姓名：</label>
            </td>
            <td class="width-20">
                <form:input path="name" htmlEscape="false" class="form-control " />
            </td>
            <td class="width-20 active"><label class="pull-right">工作单位：</label>
            </td>
            <td class="width-40">
                <form:input path="office" htmlEscape="false" class="form-control " />
            </td>
            <td class="width-20 active"><label class="pull-right ">手机：</label>
            </td>
            <td class="width-20">
                <form:input path="mobile" htmlEscape="false" class="form-control isMobile" />
            </td>
        </tr>
        </tbody>
    </table>
    <span style="color:#477cb3;font-size:15px;">| 实施信息</span>
    <table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
        <tbody>
        <tr>
            <td class="width-20 active"><label class="pull-right">实际开工时间：</label></td>
            <td class="width-30">
                <input id="sjkgsj" name="sjkgsj" value='<fmt:formatDate value="${curSsqk.sjkgsj}" pattern="yyyy-MM-dd"/>'
                       class="laydate-icon form-control layer-date"/>
            </td>
            <td class="width-20 active"><label class="pull-right">实际竣工时间：</label>
            </td>
            <td class="width-30">
                <input id="sjjgsj" name="sjjgsj" value='<fmt:formatDate value="${curSsqk.sjjgsj}" pattern="yyyy-MM-dd"/>'
                       class="laydate-icon form-control layer-date"/>
            </td>
        </tr>
        <tr>
            <td class="width-20 active"><label class="pull-right"><font
                    color="red">*</font>招投标形式：</label>
            </td>
            <td class="width-30">
                <form:select path="ztbxs" class="form-control required">
                    <form:option value="${curSsqk.ztbxs}" label="" />
                    <form:options items="${fns:getDictList('ztbxs')}" itemLabel="label" itemValue="value" htmlEscape="false" />
                </form:select></td>
            <td class="width-20 active"><label class="pull-right">建设单位：</label>
            </td>
            <td class="width-30"><form:input path="ssqkjsdw" htmlEscape="false" class="form-control"/></td>
        </tr>
        </tbody>
    </table>
    <span style="color:#477cb3;font-size:15px;">| 进度详细信息</span>
    <table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
        <tbody>
        <tr>
            <%--<td class="width-15 active"><label class="pull-right">报告期：</label>
            </td>
            <td class="width-35"><form:input path="" htmlEscape="false"
                    class="form-control " /></td>--%>
            <td class="width-20 active"><label class="pull-right">形象进度：</label></td>
            <td class="width-30">
                <form:select path="ssqkxxjd" class="form-control" cssStyle="width:245px;">
                    <form:option value="" label="" />
                    <form:options items="${fns:getDictList('ssqkxxjd')}" itemLabel="label" itemValue="value" htmlEscape="false" />
                </form:select></td>
            <td class="width-20 active"><label class="pull-right">是否开工：</label></td>
            <td class="width-30">
            
         <form:select path="sfkg" class="form-control ">
							<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
        </tr>
        <tr>
            <td class="width-20 active"><label class="pull-right">年度建设内容：</label></td>
            <td class="width-30"><form:textarea path="ssqkndjsnr" htmlEscape="false" rows="4" class="form-control"/></td>
            <td class="width-20 active"><label class="pull-right">问题及建议<br>进展情况及下一步工作安排：</label></td>
            <td colspan="3" class="width-30"><form:textarea path="ssqkwtjjy" htmlEscape="false" rows="4" class="form-control" /></td>
        </tr>
        <tr>
            <td class="width-20 active"><label class="pull-right">日常监管直接责任单位：</label></td>
            <td class="width-30"><form:input path="ssqkrcjgzjzrdw" htmlEscape="false" class="form-control"/></td>
            <td class="width-20 active"><label class="pull-right">投资计划调整情况：</label></td>
            <td class="width-30"><form:input path="ssqktzjhtzqk" htmlEscape="false" class="form-control"/></td>
        </tr>
        <tr>
            <td class="width-20 active"><label class="pull-right">政府督查机构联系人：</label></td>
            <td class="width-30"><form:input path="ssqkzfjcjglxr" htmlEscape="false" class="form-control"/></td>
            <td class="width-20 active"><label class="pull-right">联系方式（手机）：</label></td>
            <td class="width-30"><form:input path="ssqkdcjglxfs" htmlEscape="false" class="form-control isMobile"/></td>
        </tr>
        <tr>
            <td class="width-20 active"><label class="pull-right">发改部门联系人：</label></td>
            <td class="width-30"><form:input path="ssqkfgbmlxr" htmlEscape="false" class="form-control"/></td>
            <td class="width-20 active"><label class="pull-right">联系方式（手机）：</label></td>
            <td class="width-30"><form:input path="ssqlfgbmlxfs" htmlEscape="false" class="form-control isMobile"/></td>
        </tr>
        </tbody>
    </table>
    <span style="color:#477cb3;font-size:15px;">| 资金到位和完成情况</span>
    <div style="width:1000px; border:1px solid #ebcbbe; padding: 10px;">
    	<p style="width:1000px;">
    		<font color="red">
    			*1.项目开工：无论生产性或非生产性的项目，开工日期一般指永久性工程正式破土（包括正式打桩）的日期；在此之前的各项施工准备，
    		  <br/>&nbsp;&nbsp;如地质勘察、拆除旧建筑物、三通一平及辅助工程施工都不算正式开工。没有土建工程的项目，开工日期指安装工程开始的日期；
    	      <br/>&nbsp;&nbsp;开工日期有具体规定的项目，按相关规定认定。
    		</font>
    	</p>
    	<p style="width:1000px;">
    		<font color="red">
				*2.累计完成投资：完成投资金额以监理的验工计价为准，有具体规定的项目，按相关规定认定。
			</font>
		</p>
		<p style="width:1000px;">
    		<font color="red">
				*3.资金到位：资金到位分两种情况：对于资金采用非报账制项目，指的是已到项目单位账户上资金金额；对于资金采用报账制项目，指的是到
		     <br/>&nbsp;&nbsp;县（区）财政账户上的资金金额，须有财政部门预算文件证明。配套资金通过银行贷款落实的，以跟银行签订的贷款合同界定到位配套资金金额。
		    </font>
		</p>       
		<p style="width:1000px;">
    		<font color="red">
				*4.资金支付：指的是项目单位支付给施工单位的资金金额。
			</font>
		</p>
		<p style="width:1000px;">
    		<font color="red">
				*5.开工率：开工率=已开工项目个数/项目总个数*100%。
			</font>
		</p>
		<p style="width:1000px;">
    		<font color="red">
				*6.投资完成率：投资完成率=累计完成投资/总投资*100%。
			</font>
		</p>
		<p style="width:1000px;">
    		<font color="red">
				*7.资金到位率：资金到位率=累计到位资金/累计下达投资*100%。
			</font>
		</p>
		<p style="width:1000px;">
    		<font color="red">
				*8.资金支付率：资金支付率=累计支付资金/累计完成投资*100%。
			</font>
		</p>
    </div>
    
    <table
            class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
        <tbody>
        <tr>
            <td width="20%">资金类别</td>
            <td width="10%">截止上一报告期累计到位资金</td>
            <td width="10%">截止本报告期累计到位资金</td>
            <!-- 
            <td width="20%">资金类别</td>
             -->
            <td width="10%">截止上一报告期累计完成资金</td>
            <td width="10%">截至本报告期累计完成资金</td>
            <td width="10%">截止上一报告期累计支付情况</td>
            <td width="10%">截至本报告期累计支付情况</td>
        </tr>
        <tr>
            <td>合计</td>
            <td><input class="form-control text-right sum_1" disabled/></td>
            <td><input class="form-control text-right sum_2" disabled/></td>
            <!-- 
            <td>合计</td>
             -->
            <td><input class="form-control text-right sum_3" disabled/></td>
            <td><input class="form-control text-right sum_4" disabled/></td>
            <td><input class="form-control text-right sum_5" disabled/></td>
            <td><input class="form-control text-right sum_6" disabled/></td>
        </tr>
        <tr>
            <td>中央预算内投资</td>
            <td><input name="" value="${lastSsqk.zyysntzLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="zyysntzljdwzjtwo" value="${curSsqk.zyysntzljdwzjtwo}" type="number" class="form-control text-right number row_2" /></td>
            <!-- 
            <td>中央预算内投资</td>
             -->
            <td><input name="" value="${lastSsqk.zyysntzljwczj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="zyysntzjzbbgljwcjj" value="${curSsqk.zyysntzjzbbgljwcjj}" type="number" class="form-control text-right number row_4" /></td>
            <td><input name="" value="${lastSsqk.zyysntzljzfqk}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id="zyysntzljzfzj" value="${curSsqk.zyysntzljzfzj}" type="number" class="form-control text-right number row_6" /></td>
        </tr>
        <tr>
            <td>其他中央财政性建设资金</td>
            <td><input name="" value="${lastSsqk.qtzyczxjszjLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="qtzyczxjszjljdwzjtwo" value="${curSsqk.qtzyczxjszjljdwzjtwo}" type="number" class="form-control text-right number row_2 " /></td>
            <!--
            <td>专项债券募集的专项建设资金</td>
            -->
            <td><input name="" value="${lastSsqk.zxzqmjdzxjszjljwczj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="qtzyczxjszjjzbbgljwcjj" value="${curSsqk.qtzyczxjszjjzbbgljwcjj}" type="number" class="form-control text-right number row_4 " /></td>
            <td><input name="" value="${lastSsqk.zxzqmjdzxjszjljzfqk}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id="qtzyczxjszjljzfzj" value="${curSsqk.qtzyczxjszjljzfzj}" type="number" class="form-control text-right number row_6 " /></td>
        </tr>
        <tr>
        	<td>专项债券募集的专项建设资金</td>
           <td ><input value="${lastSsqk.zxzqmjdzxjszjljdwzjtwo}" class="form-control text-right number row_1" type="number" disabled/></td>
           <td ><input value="${curSsqk.zxzqmjdzxjszjljdwzjtwo}" id="zxzqmjdzxjszjljdwzjtwo" class="form-control text-right number row_2" id="zxzqmjdzxjszj_ljdwzjtwo" type="number" /></td>
           <td ><input value="${lastSsqk.zxzqmjjszjjzbbgljwcjj}" class="form-control text-right number row_3" type="number" disabled/></td>
           <td ><input value="${curSsqk.zxzqmjjszjjzbbgljwcjj}" id="zxzqmjjszjjzbbgljwcjj" class="form-control text-right number row_4" id="zxzqmj_jzbbgwc" type="number" /></td>
           <td ><input value="${lastSsqk.zxzqmjdzxjszjljzfzj}" class="form-control text-right number row_5" type="number" disabled/></td>
           <td ><input value="${curSsqk.zxzqmjdzxjszjljzfzj}" id="zxzqmjdzxjszjljzfzj" class="form-control text-right number row_6" id="zxzqmjdzxjszj_ljzfzj" type="number" /></td>
        </tr>
        <tr>
            <td>中央专项建设基金</td>
            <td><input class="form-control text-right subSum1_1" disabled/></td>
            <td><input class="form-control text-right subSum1_2" disabled/></td>
            <td><input name="" value="" type="number" class="form-control text-right number subSum1_3" disabled/></td>
            <td><input name="" value="" type="number" class="form-control text-right number subSum1_4" disabled/></td>
            <td><input name="" value="" type="number" class="form-control text-right number subSum1_5" disabled/></td>
            <td><input name="" value="" type="number" class="form-control text-right number subSum1_6" disabled/></td>
        </tr>
        <tr>
            <td><div class="subCol">中央水利建设基金</div></td>
            <td><input name="" value="${lastSsqk.zysljsjjLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="zysljsjjljdwzjtwo" value="${curSsqk.zysljsjjljdwzjtwo}" type="number" class="form-control text-right number row_2 " /></td>
            <td><input name="" value="${lastSsqk.zysljszjjzbbgljwcjj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="zysljszjjzbbgljwcjj" value="${curSsqk.zysljszjjzbbgljwcjj}" type="number" class="form-control text-right number row_4 " /></td>
            <td><input name="" value="${lastSsqk.zysljsjjljzfzj}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id="zysljsjjljzfzj" value="${curSsqk.zysljsjjljzfzj}" type="number" class="form-control text-right number row_6 " /></td>
        </tr>
        <tr>
            <td><div class="subCol">南水北调工程基金</div></td>
            <td><input name="" id="" value="${lastSsqk.nsbdgcjjLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="nsbdgcjjljdwzjtwo" value="${curSsqk.nsbdgcjjljdwzjtwo}" type="number" class="form-control text-right number row_2" /></td>
            <td><input name="" value="${lastSsqk.nsbdgczjjzbbgljwcjj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="nsbdgczjjzbbgljwcjj" value="${curSsqk.nsbdgczjjzbbgljwcjj}" type="number" class="form-control text-right number row_4 " /></td>
            <td><input name="" value="${lastSsqk.nsbdgcjjljzfzj}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id="nsbdgcjjljzfzj" value="${curSsqk.nsbdgcjjljzfzj}" type="number" class="form-control text-right number row_6 " /></td>
        </tr>
        <tr>
            <td><div class="subCol">铁路建设专项基金</div></td>
            <td><input name="" value="${lastSsqk.tljszxjjLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="tljszxjjljdwzjtwo" value="${curSsqk.tljszxjjljdwzjtwo}" type="number" class="form-control text-right number row_2" /></td>
            <td><input name="" value="${lastSsqk.tljszxzjjzbbgljwcjj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="tljszxzjjzbbgljwcjj" value="${curSsqk.tljszxzjjzbbgljwcjj}" type="number" class="form-control text-right number row_4 " /></td>
            <td><input name="" value="${lastSsqk.tljszxjjljzfzj}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id="tljszxjjljzfzj" value="${curSsqk.tljszxjjljzfzj}" type="number" class="form-control text-right number row_6 " /></td>
        </tr>
        <tr>
            <td><div class="subCol">民航发展基金</div></td>
            <td><input name="" value="${lastSsqk.mhfzjjLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="mhfzjjljdwzjtwo" value="${curSsqk.mhfzjjljdwzjtwo}" type="number" class="form-control text-right number row_2" /></td>
            <td><input name="" value="${lastSsqk.mhfzzjjzbbgljwcjj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="mhfzzjjzbbgljwcjj" value="${curSsqk.mhfzzjjzbbgljwcjj}" type="number" class="form-control text-right number row_4 " /></td>
            <td><input name="" value="${lastSsqk.mhfzjjljzfzj}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id="mhfzjjljzfzj" value="${curSsqk.mhfzjjljzfzj}" type="number" class="form-control text-right number row_6 " /></td>
        </tr>
        <tr>
            <td><div class="subCol">国际重大水利工程建设基金</div></td>
            <td><input name="" value="${lastSsqk.gjzdslgcjsjjLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="gjzdslgcjsjjljdwzjtwo" value="${curSsqk.gjzdslgcjsjjljdwzjtwo}" type="number" class="form-control text-right number row_2" /></td>
            <td><input name="" value="${lastSsqk.gjzdslgcjszjjzbbgljwcjj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="gjzdslgcjszjjzbbgljwcjj" value="${curSsqk.gjzdslgcjszjjzbbgljwcjj}" type="number" class="form-control text-right number row_4 " /></td>
            <td><input name="" value="${lastSsqk.gjzdslgcjsjjljzfzj}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id=gjzdslgcjsjjljzfzj value="${curSsqk.gjzdslgcjsjjljzfzj}" type="number" class="form-control text-right number row_6 " /></td>
        </tr>
        <tr>
            <td><div class="subCol">大中型水库移民后期扶持基金</div></td>
            <td><input name="" value="${lastSsqk.dzxskymhqfcjjLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="dzxskymhqfcjjljdwzjtwo" value="${curSsqk.dzxskymhqfcjjljdwzjtwo}" type="number" class="form-control text-right number row_2" /></td>
            <td><input name="" value="${lastSsqk.dzxskymhqfczjjzbbgljwcjj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="dzxskymhqfczjjzbbgljwcjj" value="${curSsqk.dzxskymhqfczjjzbbgljwcjj}" type="number" class="form-control text-right number row_4 " /></td>
            <td><input name="" value="${lastSsqk.dzxskymhqfcjjljzfzj}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id="dzxskymhqfcjjljzfzj" value="${curSsqk.dzxskymhqfcjjljzfzj}" type="number" class="form-control text-right number row_6 " /></td>
        </tr>
        <tr>
            <td><div class="subCol">大中型水库移民后期扶持结余基金</div></td>
            <td><input name="" value="${lastSsqk.dzxskymhqfcjyjjLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="dzxskymhqfcjyjjljdwzjtwo" value="${curSsqk.dzxskymhqfcjyjjljdwzjtwo}" type="number" class="form-control text-right number row_2" /></td>
            <td><input name="" value="${lastSsqk.dzxskymhqfcjyzjjzbbgljwcjj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="dzxskymhqfcjyzjjzbbgljwcjj" value="${curSsqk.dzxskymhqfcjyzjjzbbgljwcjj}" type="number" class="form-control text-right number row_4 " /></td>
            <td><input name="" value="${lastSsqk.dzxskymhqfcjyjjljzfzj}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id="dzxskymhqfcjyjjljzfzj" value="${curSsqk.dzxskymhqfcjyjjljzfzj}" type="number" class="form-control text-right number row_6 " /></td>
        </tr>
        <tr>
            <td><div class="subCol">公路港口建设专项基金</div></td>
            <td><input name="" value="${lastSsqk.glgkjszxjjLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="glgkjszxjjljdwzjtwo" value="${curSsqk.glgkjszxjjljdwzjtwo}" type="number" class="form-control text-right number row_2" /></td>
            <td><input name="" value="${lastSsqk.glgkjszjjzbbgljwcjj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="glgkjszjjzbbgljwcjj" value="${curSsqk.glgkjszjjzbbgljwcjj}" type="number" class="form-control text-right number row_4 " /></td>
            <td><input name="" value="${lastSsqk.glgkjszxjjljzfzj}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id="glgkjszxjjljzfzj" value="${curSsqk.glgkjszxjjljzfzj}" type="number" class="form-control text-right number row_6 " /></td>
        </tr>
        <tr>
            <td>地方预算内投资</td>
            <td><input class="form-control text-right subSum2_1" disabled/></td>
            <td><input class="form-control text-right subSum2_2" disabled/></td>
            <td><input name="" value="" type="number" class="form-control text-right number subSum2_3" disabled/></td>
            <td><input name="" value="" type="number" class="form-control text-right number subSum2_4" disabled /></td>
            <td><input name="" value="" type="number" class="form-control text-right number subSum2_5" disabled/></td>
            <td><input name="" value="" type="number" class="form-control text-right number subSum2_6" disabled /></td>
        </tr>
        <tr>
            <td><div class="subCol">省级预算内投资</div></td>
            <td><input name="" value="${lastSsqk.shengjiysntzLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="shengjiysntzljdwzjtwo" value="${curSsqk.shengjiysntzljdwzjtwo}" type="number" class="form-control text-right number row_2" /></td>
            <td><input name="" value="${lastSsqk.sjysntzjzbbgljwcjj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="sjysntzjzbbgljwcjj" value="${curSsqk.sjysntzjzbbgljwcjj}" type="number" class="form-control text-right number row_4 " /></td>
            <td><input name="" value="${lastSsqk.sjysntzjzbbgljwcjj}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id="shengjiysntzljzfzj" value="${curSsqk.shengjiysntzljzfzj}" type="number" class="form-control text-right number row_6 " /></td>
        </tr>
        <tr>
            <td><div class="subCol">市级预算内投资</div></td>
            <td><input name="" value="${lastSsqk.shijiysntzLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="shijiysntzljdwzjtwo" value="${curSsqk.shijiysntzljdwzjtwo}" type="number" class="form-control text-right number row_2" /></td>
            <td><input name="" value="${lastSsqk.cityjysntzjzbbgljwcjj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="cityjysntzjzbbgljwcjj" value="${curSsqk.cityjysntzjzbbgljwcjj}" type="number" class="form-control text-right number row_4 " /></td>
            <td><input name="" value="${lastSsqk.shijiysntzljzfzj}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id="shijiysntzljzfzj" value="${curSsqk.shijiysntzljzfzj}" type="number" class="form-control text-right number row_6 " /></td>
        </tr>
        <tr>
            <td><div class="subCol">县级预算内投资</div></td>
            <td><input name="" value="${lastSsqk.xianjiysntzLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="xianjiysntzljdwzjtwo" value="${curSsqk.xianjiysntzljdwzjtwo}" type="number" class="form-control text-right number row_2" /></td>
            <td><input name="" value="${lastSsqk.xjysntzjzbbgljwcjj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="xjysntzjzbbgljwcjj" value="${curSsqk.xjysntzjzbbgljwcjj}" type="number" class="form-control text-right number row_4 " /></td>
            <td><input name="" value="${lastSsqk.xianjiysntzljzfzj}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id="xianjiysntzljzfzj" value="${curSsqk.xianjiysntzljzfzj}" type="number" class="form-control text-right number row_6 " /></td>
        </tr>

        <tr>
            <td>地方财政性建设资金</td>
            <td><input class="form-control text-right subSum3_1" disabled/></td>
            <td><input class="form-control text-right subSum3_2" disabled/></td>
            <td><input name="" value="" type="number" class="form-control text-right number subSum3_3" disabled/></td>
            <td><input name="" value="" type="number" class="form-control text-right number subSum3_4" disabled/></td>
            <td><input name="" value="" type="number" class="form-control text-right number subSum3_5" disabled/></td>
            <td><input name="" value="" type="number" class="form-control text-right number subSum3_6" disabled/></td>
        </tr>
        <tr>
            <td><div class="subCol">省级财政资金</div></td>
            <td><input name="" value="${lastSsqk.shengjiczzjLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="shengjiczzjljdwzjtwo" value="${curSsqk.shengjiczzjljdwzjtwo}" type="number" class="form-control text-right number row_2" /></td>
            <td><input name="" value="${lastSsqk.sjczzjjzbbgljwcjj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="sjczzjjzbbgljwcjj" value="${curSsqk.sjczzjjzbbgljwcjj}" type="number" class="form-control text-right number row_4 " /></td>
            <td><input name="" value="${lastSsqk.shengjiczzjljzfzj}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id="shengjiczzjljzfzj" value="${curSsqk.shengjiczzjljzfzj}" type="number" class="form-control text-right number row_6 " /></td>
        </tr>

        <tr>
            <td><div class="subCol">市级财政资金</div></td>
            <td><input name="" value="${lastSsqk.shijiczzjLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="shijiczzjljdwzjtwo" value="${curSsqk.shijiczzjljdwzjtwo}" type="number" class="form-control text-right number row_2" /></td>
            <td><input name="" value="${lastSsqk.cityjczzjjzbbgljwcjj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="cityjczzjjzbbgljwcjj" value="${curSsqk.cityjczzjjzbbgljwcjj}" type="number" class="form-control text-right number row_4 " /></td>
            <td><input name="" value="${lastSsqk.shijiczzjljzfzj}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id="shijiczzjljzfzj" value="${curSsqk.shijiczzjljzfzj}" type="number" class="form-control text-right number row_6 " /></td>
        </tr>
        <tr>
            <td><div class="subCol">县级财政资金</div></td>
            <td><input name="" value="${lastSsqk.xianjiczzjLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="xianjiczzjljdwzjtwo" value="${curSsqk.xianjiczzjljdwzjtwo}" type="number" class="form-control text-right number row_2" /></td>
            <td><input name="" value="${lastSsqk.xjczzjjzbbgljwcjj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="xjczzjjzbbgljwcjj" value="${curSsqk.xjczzjjzbbgljwcjj}" type="number" class="form-control text-right number row_4 " /></td>
            <td><input name="" value="${lastSsqk.xianjiczzjljzfzj}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id="xianjiczzjljzfzj" value="${curSsqk.xianjiczzjljzfzj}" type="number" class="form-control text-right number row_6 " /></td>
        </tr>
        <tr>
            <td>地方专项建设基金</td>
            <td><input name="" value="${lastSsqk.dfzxjsjjLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="dfzxjsjjljdwzjtwo" value="${curSsqk.dfzxjsjjljdwzjtwo}" type="number" class="form-control text-right number row_2" /></td>
            <td><input name="" value="${lastSsqk.dfzxjszjjzbbgljwcjj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="dfzxjszjjzbbgljwcjj" value="${curSsqk.dfzxjszjjzbbgljwcjj}" type="number" class="form-control text-right number row_4 " /></td>
            <td><input name="" value="${lastSsqk.dfzxjsjjljzfzj}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id="dfzxjsjjljzfzj" value="${curSsqk.dfzxjsjjljzfzj}" type="number" class="form-control text-right number row_6 " /></td>
        </tr>
        <tr>
            <td>企业自由投资</td>
            <td><input name="" value="${lastSsqk.qyzytzLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="qyzytzljdwzjtwo" value="${curSsqk.qyzytzljdwzjtwo}" type="number" class="form-control text-right number row_2" /></td>
            <td><input name="" value="${lastSsqk.qyzytzjzbbgljwcjj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="qyzytzjzbbgljwcjj" value="${curSsqk.qyzytzjzbbgljwcjj}" type="number" class="form-control text-right number row_4 " /></td>
            <td><input name="" value="${lastSsqk.qyzytzljzfzj}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id="qyzytzljzfzj" value="${curSsqk.qyzytzljzfzj}" type="number" class="form-control text-right number row_6 " /></td>
        </tr>
        <tr>
            <td>银行贷款</td>
            <td><input name="" value="${lastSsqk.yhdkLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="yhdkljdwzjtwo" value="${curSsqk.yhdkljdwzjtwo}" type="number" class="form-control text-right number row_2" /></td>
            <td><input name="" value="${lastSsqk.yhdkjzbbgljwcjj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="yhdkjzbbgljwcjj" value="${curSsqk.yhdkjzbbgljwcjj}" type="number" class="form-control text-right number row_4 " /></td>
            <td><input name="" value="${lastSsqk.yhdkljzfzj}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id="yhdkljzfzj" value="${curSsqk.yhdkljzfzj}" type="number" class="form-control text-right number row_6 " /></td>
        </tr>

        <tr>
            <td>利用外资</td>
            <td><input name="" value="${lastSsqk.lywzLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="lywzljdwzjtwo" value="${curSsqk.lywzljdwzjtwo}" type="number" class="form-control text-right number row_2" /></td>
            <td><input name="" value="${lastSsqk.lywzjzbbgljwcjj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="lywzjzbbgljwcjj" value="${curSsqk.lywzjzbbgljwcjj}" type="number" class="form-control text-right number row_4 " /></td>
            <td><input name="" value="${lastSsqk.lywzljzfzj}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id="lywzljzfzj" value="${curSsqk.lywzljzfzj}" type="number" class="form-control text-right number row_6 " /></td>
        </tr>
        <tr>
            <td>资金渠道待定</td>
            <td><input name="" value="${lastSsqk.zjqdddLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="zjqdddljdwzjtwo" value="${curSsqk.zjqdddljdwzjtwo}" type="number" class="form-control text-right number row_2" /></td>
            <td><input name="" value="${lastSsqk.zjqdddjzbbgljwcjj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="zjqdddjzbbgljwcjj" value="${curSsqk.zjqdddjzbbgljwcjj}" type="number" class="form-control text-right number row_4 " /></td>
            <td><input name="" value="${lastSsqk.zjqdddljzfzj}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id="zjqdddljzfzj" value="${curSsqk.zjqdddljzfzj}" type="number" class="form-control text-right number row_6 " /></td>
        </tr>
        <tr>
            <td>其他资金</td>
            <td><input name="" value="${lastSsqk.qtzjLjdwzj}" type="number" class="form-control text-right number row_1" disabled/></td>
            <td><input name="" id="qtzjljdwzjtwo" value="${curSsqk.qtzjljdwzjtwo}" type="number" class="form-control text-right number row_2" /></td>
            <td><input name="" value="${lastSsqk.qtzjjzbbgljwcjj}" type="number" class="form-control text-right number row_3" disabled/></td>
            <td><input name="" id="qtzjjzbbgljwcjj" value="${curSsqk.qtzjjzbbgljwcjj}" type="number" class="form-control text-right number row_4 " /></td>
            <td><input name="" value="${lastSsqk.qtzjljzfzj}" type="number" class="form-control text-right number row_5" disabled/></td>
            <td><input name="" id="qtzjljzfzj" value="${curSsqk.qtzjljzfzj}" type="number" class="form-control text-right number row_6 " /></td>
        </tr>

        </tbody>
    </table>
</div>