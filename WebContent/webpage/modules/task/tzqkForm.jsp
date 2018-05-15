<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<input id="xmjbxx_id" name = "xmjbxx_id" type="hidden" value="${xmjbxx.id }"/>

<div class="tz_sub" id="fen2" name="inputForm" style="padding: 30px;">
    <table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
        <tbody>       
        <tr>
            <td align="center" onclick="fillInTzqk()" style="min-width: 80px;">资金类别</td>
            <td align="center">已经下达（安排）投资（万元）</td>

        </tr>
        <tr>
            <td>合计</td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input id="sumCol_4" name="false" class="form-control text-right sum_1" disabled/>
            </td>          
        </tr>
        <tr>
            <td>中央预算内投资<input type="hidden" name="tzqks[0].zjlb"
                              value="中央预算内投资" />
            </td>           
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[0].ntz[1].je" htmlEscape="false" type="number" id="zyysntz_ljdwzj" 
                  class="form-control number text-right countCol_4 row_1" countParent="sumCol_4"  value="${tzqks[0].ntz[1].je}" />
            </td>           
        </tr>
        <tr>
            <td>其他中央财政性建设资金<input type="hidden" name="tzqks[1].zjlb"
                                  value="其他中央财政性建设资金" />
            </td>            
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[1].ntz[1].je" htmlEscape="false" type="number" id="qtzyczxjszj_ljdwzj"
                     class="form-control number text-right countCol_4 row_1" countParent="sumCol_4" value="${tzqks[1].ntz[1].je}" />
            </td>           
        </tr>
        <tr>
            <td>中央专项建设基金<input type="hidden" name="tzqks[3].zjlb"
                               value="中央专项建设基金" />
            </td>           
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
                <input htmlEscape="false" type="number" disabled
                       class="form-control number text-right sum1_1" subSum="zyzxjsjj_4"/>
            </td>           
        </tr>
        <tr>
            <td><div class="subCol">中央水利建设基金</div><input type="hidden" name="tzqks[4].zjlb"
                                                         value="中央水利建设基金" />
            </td>            
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[4].ntz[1].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_4" id="zysljsjj_ljdwzj"
                   class="form-control number text-right countCol_4 row_1" countParent="sumCol_4"  value="${tzqks[4].ntz[1].je}" />
            </td>           
        </tr>
        <tr>
            <td><div class="subCol">南水北调工程基金</div><input type="hidden" name="tzqks[5].zjlb"
                                                         value="南水北调工程基金" />
            </td>           
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[5].ntz[1].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_4" id="nsbdgcjj_ljdwzj"
                   class="form-control number text-right countCol_4 row_1" countParent="sumCol_4" value="${tzqks[5].ntz[1].je}" />
            </td>            
        </tr>
        <tr>
            <td><div class="subCol">铁路建设专项基金</div><input type="hidden" name="tzqks[6].zjlb"
                                                         value="铁路建设专项基金" />
            </td>           
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[6].ntz[1].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_4" id="tljszxjj_ljdwzj"
                   class="form-control number text-right countCol_4 row_1" countParent="sumCol_4" value="${tzqks[6].ntz[1].je}" />
            </td>           
        </tr>
        <tr>
            <td><div class="subCol">民航发展基金</div><input type="hidden" name="tzqks[7].zjlb"
                                                       value="民航发展基金" />
            </td>            
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[7].ntz[1].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_4" id="mhfzjj_ljdwzj"
                     class="form-control number text-right countCol_4 row_1" countParent="sumCol_4" value="${tzqks[7].ntz[1].je}" />
            </td>           
        </tr>
        <tr>
            <td><div class="subCol">国家重大水利工程建设基金</div><input type="hidden" name="tzqks[8].zjlb"
                                                             value="国家重大水利工程建设基金" />
            </td>           
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[8].ntz[1].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_4" id="gjzdslgcjsjj_ljdwzj"
                    class="form-control number text-right countCol_4 row_1" countParent="sumCol_4" value="${tzqks[8].ntz[1].je}" />
            </td>           
        </tr>
        <tr>
            <td><div class="subCol">大中型水库移民后期扶持基金</div><input type="hidden" name="tzqks[9].zjlb"
                                                              value="大中型水库移民后期扶持基金" />
            </td>           
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[9].ntz[1].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_4" id="dzxskymhqfcjj_ljdwzj"
                    class="form-control number text-right countCol_4 row_1" countParent="sumCol_4" value="${tzqks[9].ntz[1].je}" />
            </td>           
        </tr>
        <tr>
            <td><div class="subCol">大中型水库移民后期扶持结余资金</div><input type="hidden" name="tzqks[10].zjlb"
                                                                value="大中型水库移民后期扶持结余资金" />
            </td>            
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[10].ntz[1].je" htmlEscape="false" type="number"  subCountParent="zyzxjsjj_4" id="dzxskymhqfcjyjj_ljdwzj"
                     class="form-control number text-right countCol_4 row_1" countParent="sumCol_4" value="${tzqks[10].ntz[1].je}" />
            </td>           
        </tr>
        <tr>
            <td><div class="subCol">公路港口建设专项基金</div><input type="hidden" name="tzqks[11].zjlb"
                                                           value="公路港口建设专项基金" />
            </td>            
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[11].ntz[1].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_4" id="glgkjszxjj_ljdwzj"
                     class="form-control number text-right countCol_4 row_1" countParent="sumCol_4" value="${tzqks[11].ntz[1].je}" />
            </td>            
        </tr>
        <tr>
            <td>地方预算内投资<input type="hidden" name="tzqks[12].zjlb" value="地方预算内投资" /></td>
            
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input htmlEscape="false" disabled class="form-control text-right sum2_1" subSum="dfysntz_4"/>
            </td>            
        </tr>
        <tr>
            <td><div class="subCol">省级预算内投资</div><input type="hidden" name="tzqks[13].zjlb"
                                                        value="省级预算内投资" />
            </td>            
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[13].ntz[1].je" htmlEscape="false" type="number" subCountParent="dfysntz_4" id="shengjiysntz_ljdwzj"
                    class="form-control number text-right countCol_4 row_1" countParent="sumCol_4" value="${tzqks[13].ntz[1].je}" />
            </td>            
        </tr>
        <tr>
            <td><div class="subCol">市级预算内投资</div><input type="hidden" name="tzqks[14].zjlb"
                                                        value="市级预算内投资" />
            </td>            
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[14].ntz[1].je" htmlEscape="false" type="number" subCountParent="dfysntz_4" id="shijiysntz_ljdwzj"
                    class="form-control number text-right countCol_4 row_1" countParent="sumCol_4" value="${tzqks[14].ntz[1].je}" />
            </td>            
        </tr>
        <tr>
            <td><div class="subCol">县级预算内投资</div><input type="hidden" name="tzqks[15].zjlb"
                                                        value="县级预算内投资" />
            </td>            
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[15].ntz[1].je" htmlEscape="false" type="number" subCountParent="dfysntz_4" id="xianjiysntz_ljdwzj"
                     class="form-control number text-right countCol_4  row_1" countParent="sumCol_4" value="${tzqks[15].ntz[1].je}" />
            </td>            
        </tr>
        <tr>
            <td>地方财政性建设资金<input type="hidden" name="tzqks[16].zjlb" value="地方财政性建设资金" /></td>
            
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input htmlEscape="false" disabled class="form-control text-right sum3_1" subSum="dfczxjszj_4"/></td>
            
        </tr>
        <tr>
            <td><div class="subCol">省级财政资金</div><input type="hidden" name="tzqks[17].zjlb"
                                                       value="省级财政资金" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[17].ntz[1].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_4" id="shengjiczzj_ljdwzj"
                    class="form-control number text-right countCol_4 row_1" countParent="sumCol_4" value="${tzqks[17].ntz[1].je}" />
            </td>            
        </tr>
        <tr>
            <td><div class="subCol">市级财政资金</div><input type="hidden" name="tzqks[18].zjlb"
                                                       value="市级财政资金" />
            </td>            
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[18].ntz[1].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_4" id="shijiczzj_ljdwzj"
                       class="form-control number text-right countCol_4 row_1" countParent="sumCol_4" value="${tzqks[18].ntz[1].je}" />
            </td>            
        </tr>
        <tr>
            <td><div class="subCol">县级财政资金</div><input type="hidden" name="tzqks[19].zjlb"
                                                       value="县级财政资金" />
            </td>            
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[19].ntz[1].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_4" id="xianjiczzj_ljdwzj"
                      class="form-control number text-right countCol_4 row_1" countParent="sumCol_4" value="${tzqks[19].ntz[1].je}" />
            </td>           
        </tr>
        <tr>
            <td>地方专项建设基金<input type="hidden" name="tzqks[20].zjlb"
                               value="地方专项建设基金" />
            </td>            
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[20].ntz[1].je" htmlEscape="false" type="number" id="dfzxjsjj_ljdwzj"
                      class="form-control number text-right countCol_4 row_1" countParent="sumCol_4" value="${tzqks[20].ntz[1].je}" />
            </td>            
        </tr>
        <tr>
            <td>企业自有投资<input type="hidden" name="tzqks[21].zjlb"
                             value="企业自有投资" />
            </td>            
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[21].ntz[1].je" htmlEscape="false" type="number" id="qyzytz_ljdwzj"
                    class="form-control number text-right countCol_4 row_1" countParent="sumCol_4" value="${tzqks[21].ntz[1].je}" />
            </td>           
        </tr>
        <tr>
            <td>银行贷款<input type="hidden" name="tzqks[22].zjlb"
                           value="银行贷款" />
            </td>            
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[22].ntz[1].je" htmlEscape="false" type="number" id="yhdk_ljdwzj"
                     class="form-control number text-right countCol_4 row_1" countParent="sumCol_4" value="${tzqks[22].ntz[1].je}" />
            </td>           
        </tr>
        <tr>
            <td>利用外资<input type="hidden" name="tzqks[23].zjlb"
                           value="利用外资" />
            </td>           
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[23].ntz[1].je" htmlEscape="false" type="number" id="lywz_ljdwzj"
                      class="form-control number text-right countCol_4 row_1" countParent="sumCol_4" value="${tzqks[23].ntz[1].je}" />
            </td>           
        </tr>
        <tr>
            <td>资金渠道待定<input type="hidden" name="tzqks[24].zjlb"
                             value="资金渠道待定" />
            </td>           
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[24].ntz[1].je" htmlEscape="false" type="number" id="zjqddd_ljdwzj"
                     class="form-control number text-right countCol_4 row_1" countParent="sumCol_4" value="${tzqks[24].ntz[1].je}" />
            </td>           
        </tr>
        <tr>
            <td>其他资金<input type="hidden" name="tzqks[25].zjlb"
                           value="其他资金" />
            </td>
            
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            	<input name="tzqks[25].ntz[1].je" htmlEscape="false" type="number" id="qtzj_ljdwzj"
                      class="form-control number text-right countCol_4 row_1" countParent="sumCol_4" value="${tzqks[25].ntz[1].je}" />
            </td>
        </tr>

			
        </tbody>
    </table>

    <p style="width:500px;">
        <font color="red">*温馨提示：投资金额如果为0，请勿填写</font>
    </p>
	<p>
    	<form:select path="sfsqzxjsjj" style="height:0px;">
        	<option value="0">否</option>
   		 </form:select>
	</p>
</div>