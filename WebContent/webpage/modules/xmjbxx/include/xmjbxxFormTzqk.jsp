<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<div class="tz_sub" id="fen2" name="inputForm">
    <table
            class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
        <tbody>
        
        <tr>
            <td rowspan="2" align="center" onclick="fillInTzqk()" style="min-width: 80px;">资金类别</td>
            <td rowspan="2" align="center">总投资（万元）</td>
            <td rowspan="2" align="center" style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">资本金（万元）</td>
            <td colspan="3" align="center" style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">专项建设资金 资本金缺口（万元）</td>
            <td rowspan="2" align="center" style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">本次申请专项建设基金（万元）</td>
            <td rowspan="2" align="center">已经下达（安排）投资（万元）</td>
            <td rowspan="2" align="center">已经完成投资（万元）</td>
            <td colspan="5" align="center">资金需求（万元）</td>
            <td rowspan="2" align="center">备注</td>
        </tr>
        <tr>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">2017年</td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">2018年</td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">2019年</td>
            <td>合计</td>
            <td>2017年</td>
            <td>2018年</td>
            <td>2019年</td>
            <td>2020年</td>
        </tr>
        <tr>
            <td>合计</td>
            <td><input id="sumCol_1" name="false" class="form-control text-right"  disabled/>
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input id="sumCol_2" name="false" class="form-control text-right" disabled/>
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input id="sumCol_3" name="false" class="form-control text-right" disabled/>
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input id="sumCol_4" name="false" class="form-control text-right" disabled/>
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input id="sumCol_5" name="false" class="form-control text-right" disabled/>
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input id="sumCol_8" name="false" class="form-control text-right" disabled/>
            </td>
            <td><input id="sumCol_6" name="false" class="form-control text-right" disabled />
            </td>
            <td><input id="sumCol_7" name="false" class="form-control text-right" disabled/>
            </td>
            <td><input id="sumCol_9" name="false" class="form-control text-right" disabled/>
            </td>
            <td><input id="sumCol_10" name="false" class="form-control text-right" disabled/>
            </td>
            <td><input id="sumCol_11" name="false" class="form-control text-right" disabled/>
            </td>
            <td><input id="sumCol_12" name="false" class="form-control text-right" disabled/>
            </td>
            <td><input id="sumCol_13" name="false" class="form-control text-right" disabled/>
            </td>
            <td><input id="sumCol_14" name="false" class="form-control text-right" disabled/>
            </td>
        </tr>

        <tr>
            <td>中央预算内投资<input type="hidden" name="tzqks[0].zjlb"
                              value="中央预算内投资" />
            </td>
            <td><input name="tzqks[0].ztz" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_1" countParent="sumCol_1" value="${tzqks[0].ztz}"  />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[0].zbj" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[0].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[0].ntz[0].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[0].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[0].ntz[1].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4"  value="${tzqks[0].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[0].ntz[2].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[0].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[0].bcsqzxjszj" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[0].bcsqzxjszj}" />
            </td>
            <td><input name="tzqks[0].ljxdtz" htmlEscape="false" type="number" id="ljxdtz1"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[0].ljxdtz}" />
                 <input type="hidden" id="ycljxdtz1" value="${proList[0].zyysntzljdwzj}" />
                 <input type="hidden" id="zxljxdtz1" value="${tzqks[0].ljxdtz}" />
            </td>
            <td><input name="tzqks[0].ljwctz" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[0].ljwctz}" />
            </td>
            <td><input name="tzqks[0].ljZjxqs" htmlEscape="false" type="number" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[0].zjxqs[0].je" htmlEscape="false"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[0].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[0].zjxqs[1].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[0].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[0].zjxqs[2].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[0].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[0].zjxqs[3].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[0].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[0].qt" htmlEscape="false" class="form-control text-right" value="${tzqks[0].qt}" />
            </td>
        </tr>

        <tr>
            <td>其他中央财政性建设资金<input type="hidden" name="tzqks[1].zjlb"
                                  value="其他中央财政性建设资金" />
            </td>
            <td><input name="tzqks[1].ztz" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_1" countParent="sumCol_1" value="${tzqks[1].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[1].zbj" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[1].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[1].ntz[0].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[1].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[1].ntz[1].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4" value="${tzqks[1].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[1].ntz[2].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[1].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[1].bcsqzxjszj" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[1].bcsqzxjszj}" />
            </td>
            <td><input name="tzqks[1].ljxdtz" htmlEscape="false" type="number" id="ljxdtz2"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[1].ljxdtz}" />
                 <input type="hidden" id="ycljxdtz2" value="${proList[0].qtzyczxjszjljdwzj}" />
                 <input type="hidden" id="zxljxdtz2" value="${tzqks[1].ljxdtz}" />
            </td>
            <td><input name="tzqks[1].ljwctz" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[1].ljwctz}" />
            </td>
            <td><input name="tzqks[1].ljZjxqs" htmlEscape="false" type="number" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[1].zjxqs[0].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[1].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[1].zjxqs[1].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[1].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[1].zjxqs[2].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[1].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[1].zjxqs[3].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[1].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[1].qt" htmlEscape="false" class="form-control text-right" value="${tzqks[1].qt}" />
            </td>
        </tr>
        </tr>
        <tr style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
            <td>专项债券募集的专项建设基金<input type="hidden" name="tzqks[2].zjlb"
                                    value="专项债券募集的专项建设基金" />
            </td>
            <td><input name="tzqks[2].ztz" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_1"  countParent="sumCol_1" value="${tzqks[2].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[2].zbj" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_2"  countParent="sumCol_2" value="${tzqks[2].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[2].ntz[0].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[2].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[2].ntz[1].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4" value="${tzqks[2].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[2].ntz[2].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[2].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[2].bcsqzxjszj" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[2].bcsqzxjszj}" />
            </td>
            <td><input name="tzqks[2].ljxdtz" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[2].ljxdtz}" />
            </td>
            <td><input name="tzqks[2].ljwctz" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[2].ljwctz}" />
            </td>
            <td><input name="tzqks[2].ljZjxqs" htmlEscape="false" type="number" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[2].zjxqs[0].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[2].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[2].zjxqs[1].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[2].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[2].zjxqs[2].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[2].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[2].zjxqs[3].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[2].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[2].qt" htmlEscape="false" class="form-control text-right" value="${tzqks[2].qt}" />
            </td>
        </tr>
        <tr>
            <td>中央专项建设基金<input type="hidden" name="tzqks[3].zjlb"
                               value="中央专项建设基金" />
            </td>
            <td><input htmlEscape="false" type="number" disabled
                       class="form-control number text-right" subSum="zyzxjsjj_1"/>
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input htmlEscape="false" type="number" disabled
                                                                               class="form-control number text-right" subSum="zyzxjsjj_2"/>
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
                <input htmlEscape="false" type="number" disabled
                       class="form-control number text-right" subSum="zyzxjsjj_3"/>
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
                <input htmlEscape="false" type="number" disabled
                       class="form-control number text-right" subSum="zyzxjsjj_4"/>
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
                <input htmlEscape="false" type="number" disabled
                       class="form-control number text-right" subSum="zyzxjsjj_5"/>
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine">
                <input htmlEscape="false" type="number" disabled
                       class="form-control number text-right" subSum="zyzxjsjj_8"/>
            </td>
            <td><input htmlEscape="false" type="number" disabled
                       class="form-control number text-right" subSum="zyzxjsjj_6"/>
            </td>
            <td><input htmlEscape="false" type="number" disabled
                       class="form-control number text-right" subSum="zyzxjsjj_7"/>
            </td>
            <td><input htmlEscape="false" type="number" disabled
                       class="form-control number text-right" subSum="zyzxjsjj_9"/>
            </td>
            <td><input htmlEscape="false" type="number" disabled
                       class="form-control number text-right" subSum="zyzxjsjj_10"/>
            </td>
            <td><input htmlEscape="false" type="number" disabled
                       class="form-control number text-right" subSum="zyzxjsjj_11"/>
            </td>
            <td><input htmlEscape="false" type="number" disabled
                       class="form-control number text-right" subSum="zyzxjsjj_12"/>
            </td>
            <td><input htmlEscape="false" type="number" disabled
                       class="form-control number text-right" subSum="zyzxjsjj_13"/>
            </td>
            <td><input name="tzqks[3].qt" htmlEscape="false"
                       class="form-control text-right" value="${tzqks[3].qt}" />
            </td>
        </tr>
        <tr>
            <td><div class="subCol">中央水利建设基金</div><input type="hidden" name="tzqks[4].zjlb"
                                                         value="中央水利建设基金" />
            </td>
            <td><input name="tzqks[4].ztz" htmlEscape="false" type="number" subCountParent="zyzxjsjj_1"
                       class="form-control number text-right countCol_1" countParent="sumCol_1" value="${tzqks[4].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[4].zbj" htmlEscape="false" type="number" subCountParent="zyzxjsjj_2"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[4].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[4].ntz[0].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_3"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[4].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[4].ntz[1].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_4"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4"  value="${tzqks[4].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[4].ntz[2].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_5"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[4].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[4].bcsqzxjszj" htmlEscape="false" type="number" subCountParent="zyzxjsjj_8"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[4].bcsqzxjszj}" />
            </td>
            <td><input name="tzqks[4].ljxdtz" htmlEscape="false" type="number" subCountParent="zyzxjsjj_6" id="ljxdtz3"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[4].ljxdtz}" />
                 <input type="hidden" id="ycljxdtz3" value="${proList[0].zysljsjjljdwzj}" />
                 <input type="hidden" id="zxljxdtz3" value="${tzqks[4].ljxdtz}" />
            </td>
            <td><input name="tzqks[4].ljwctz" htmlEscape="false" type="number" subCountParent="zyzxjsjj_7"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[4].ljwctz}" />
            </td>
            <td><input name="tzqks[4].ljZjxqs" htmlEscape="false" type="number" subCountParent="zyzxjsjj_9"  disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[4].zjxqs[0].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_10"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[4].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[4].zjxqs[1].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_11"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[4].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[4].zjxqs[2].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_12"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[4].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[4].zjxqs[3].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_13"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[4].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[4].qt" htmlEscape="false"
                       class="form-control text-right" value="${tzqks[4].qt}" />
            </td>
        </tr>
        <tr>
            <td><div class="subCol">南水北调工程基金</div><input type="hidden" name="tzqks[5].zjlb"
                                                         value="南水北调工程基金" />
            </td>
            <td><input name="tzqks[5].ztz" htmlEscape="false" type="number" subCountParent="zyzxjsjj_1"
                       class="form-control number text-right countCol_1" countParent="sumCol_1" value="${tzqks[5].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[5].zbj" htmlEscape="false" type="number" subCountParent="zyzxjsjj_2"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[5].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[5].ntz[0].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_3"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[5].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[5].ntz[1].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_4"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4" value="${tzqks[5].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[5].ntz[2].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_5"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[5].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[5].bcsqzxjszj" htmlEscape="false" type="number" subCountParent="zyzxjsjj_8"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[5].bcsqzxjszj}" />
            </td>
            <td><input name="tzqks[5].ljxdtz" htmlEscape="false" type="number" subCountParent="zyzxjsjj_6" id="ljxdtz4"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[5].ljxdtz}" />
                 <input type="hidden" id="ycljxdtz4" value="${proList[0].nsbdgcjjljdwzj}" />
                  <input type="hidden" id="zxljxdtz4" value="${tzqks[5].ljxdtz}" />
            </td>
            <td><input name="tzqks[5].ljwctz" htmlEscape="false" type="number" subCountParent="zyzxjsjj_7"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[5].ljwctz}" />
            </td>
            <td><input name="tzqks[5].ljZjxqs" htmlEscape="false" type="number" subCountParent="zyzxjsjj_9" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[5].zjxqs[0].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_10"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[5].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[5].zjxqs[1].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_11"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[5].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[5].zjxqs[2].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_12"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[5].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[5].zjxqs[3].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_13"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[5].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[5].qt" htmlEscape="false"
                       class="form-control text-right " value="${tzqks[5].qt}" />
            </td>
        </tr>
        <tr>
            <td><div class="subCol">铁路建设专项基金</div><input type="hidden" name="tzqks[6].zjlb"
                                                         value="铁路建设专项基金" />
            </td>
            <td><input name="tzqks[6].ztz" htmlEscape="false" type="number" subCountParent="zyzxjsjj_1"
                       class="form-control number text-right countCol_1" countParent="sumCol_1" value="${tzqks[6].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[6].zbj" htmlEscape="false" type="number" subCountParent="zyzxjsjj_2"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[6].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[6].ntz[0].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_3"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[6].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[6].ntz[1].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_4"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4" value="${tzqks[6].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[6].ntz[2].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_5"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[6].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[6].bcsqzxjszj" htmlEscape="false" type="number" subCountParent="zyzxjsjj_8"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[6].bcsqzxjszj}" />
            </td>
            <td><input name="tzqks[6].ljxdtz" htmlEscape="false" type="number" subCountParent="zyzxjsjj_6" id="ljxdtz5"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[6].ljxdtz}" />
                 <input type="hidden" id="ycljxdtz5" value="${proList[0].tljszxjjljdwzj}"/>
                  <input type="hidden" id="zxljxdtz5" value="${tzqks[6].ljxdtz}" />
            </td>
            <td><input name="tzqks[6].ljwctz" htmlEscape="false" type="number" subCountParent="zyzxjsjj_7"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[6].ljwctz}" />
            </td>
            <td><input name="tzqks[6].ljZjxqs" htmlEscape="false" type="number" subCountParent="zyzxjsjj_9" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[6].zjxqs[0].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_10"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[6].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[6].zjxqs[1].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_11"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[6].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[6].zjxqs[2].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_12"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[6].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[6].zjxqs[3].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_13"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[6].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[6].qt" htmlEscape="false"
                       class="form-control text-right " value="${tzqks[6].qt}" />
            </td>
        </tr>
        <tr>
            <td><div class="subCol">民航发展基金</div><input type="hidden" name="tzqks[7].zjlb"
                                                       value="民航发展基金" />
            </td>
            <td><input name="tzqks[7].ztz" htmlEscape="false" type="number" subCountParent="zyzxjsjj_1"
                       class="form-control number text-right countCol_1" countParent="sumCol_1" value="${tzqks[7].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[7].zbj" htmlEscape="false" type="number" subCountParent="zyzxjsjj_2"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[7].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[7].ntz[0].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_3"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[7].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[7].ntz[1].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_4"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4" value="${tzqks[7].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[7].ntz[2].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_5"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[7].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[7].bcsqzxjszj" htmlEscape="false" type="number" subCountParent="zyzxjsjj_8"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[7].bcsqzxjszj}" />
            </td>
            <td><input name="tzqks[7].ljxdtz" htmlEscape="false" type="number" subCountParent="zyzxjsjj_6" id="ljxdtz6"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[7].ljxdtz}" />
                 <input type="hidden" id="ycljxdtz6" value="${proList[0].mhfzjjljdwzj}" />
                  <input type="hidden" id="zxljxdtz6" value="${tzqks[7].ljxdtz}" />
            </td>
            <td><input name="tzqks[7].ljwctz" htmlEscape="false" type="number" subCountParent="zyzxjsjj_7"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[7].ljwctz}" />
            </td>
            <td><input name="tzqks[7].ljZjxqs" htmlEscape="false" type="number" subCountParent="zyzxjsjj_9" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[7].zjxqs[0].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_10"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[7].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[7].zjxqs[1].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_11"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[7].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[7].zjxqs[2].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_12"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[7].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[7].zjxqs[3].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_13"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[7].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[7].qt" htmlEscape="false"
                       class="form-control text-right" value="${tzqks[7].qt}" />
            </td>
        </tr>
        <tr>
            <td><div class="subCol">国家重大水利工程建设基金</div><input type="hidden" name="tzqks[8].zjlb"
                                                             value="国家重大水利工程建设基金" />
            </td>
            <td><input name="tzqks[8].ztz" htmlEscape="false" type="number" subCountParent="zyzxjsjj_1"
                       class="form-control number text-right countCol_1" countParent="sumCol_1" value="${tzqks[8].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[8].zbj" htmlEscape="false" type="number" subCountParent="zyzxjsjj_2"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[8].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[8].ntz[0].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_3"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[8].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[8].ntz[1].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_4"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4" value="${tzqks[8].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[8].ntz[2].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_5"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[8].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[8].bcsqzxjszj" htmlEscape="false" type="number" subCountParent="zyzxjsjj_8"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[8].bcsqzxjszj}" />
            </td>
            <td><input name="tzqks[8].ljxdtz" htmlEscape="false" type="number" subCountParent="zyzxjsjj_6" id="ljxdtz7"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[8].ljxdtz}" />
                <input type="hidden" id="ycljxdtz7" value="${proList[0].gjzdslgcjsjjljdwzj}" />
                 <input type="hidden" id="zxljxdtz7" value="${tzqks[8].ljxdtz}" />
            </td>
            <td><input name="tzqks[8].ljwctz" htmlEscape="false" type="number" subCountParent="zyzxjsjj_7"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[8].ljwctz}" />
            </td>
            <td><input name="tzqks[8].ljZjxqs" htmlEscape="false" type="number" subCountParent="zyzxjsjj_9" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[8].zjxqs[0].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_10"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[8].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[8].zjxqs[1].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_11"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[8].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[8].zjxqs[2].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_12"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[8].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[8].zjxqs[3].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_13"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[8].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[8].qt" htmlEscape="false"
                       class="form-control text-right" value="${tzqks[8].qt}" />
            </td>
        </tr>
        <tr>
            <td><div class="subCol">大中型水库移民后期扶持基金</div><input type="hidden" name="tzqks[9].zjlb"
                                                              value="大中型水库移民后期扶持基金" />
            </td>
            <td><input name="tzqks[9].ztz" htmlEscape="false" type="number" subCountParent="zyzxjsjj_1"
                       class="form-control number text-right countCol_1" countParent="sumCol_1" value="${tzqks[9].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[9].zbj" htmlEscape="false" type="number" subCountParent="zyzxjsjj_2"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[9].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[9].ntz[0].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_3"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[9].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[9].ntz[1].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_4"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4" value="${tzqks[9].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[9].ntz[2].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_5"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[9].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[9].bcsqzxjszj" htmlEscape="false" type="number" subCountParent="zyzxjsjj_8"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[9].bcsqzxjszj}" />
            </td>
            <td><input name="tzqks[9].ljxdtz" htmlEscape="false" type="number" subCountParent="zyzxjsjj_6" id="ljxdtz8"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[9].ljxdtz}" />
                 <input type="hidden" id="ycljxdtz8" value="${proList[0].dzxskymhqfcjjljdwzj}" />
                  <input type="hidden" id="zxljxdtz8" value="${tzqks[9].ljxdtz}" />
            </td>
            <td><input name="tzqks[9].ljwctz" htmlEscape="false" type="number" subCountParent="zyzxjsjj_7"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[9].ljwctz}" />
            </td>
            <td><input name="tzqks[9].ljZjxqs" htmlEscape="false" type="number" subCountParent="zyzxjsjj_9" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[9].zjxqs[0].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_10"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[9].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[9].zjxqs[1].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_11"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[9].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[9].zjxqs[2].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_12"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[9].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[9].zjxqs[3].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_13"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[9].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[9].qt" htmlEscape="false"
                       class="form-control text-right" value="${tzqks[9].qt}" />
            </td>
        </tr>
        <tr>
            <td><div class="subCol">大中型水库移民后期扶持结余资金</div><input type="hidden" name="tzqks[10].zjlb"
                                                                value="大中型水库移民后期扶持结余资金" />
            </td>
            <td><input name="tzqks[10].ztz" htmlEscape="false" type="number"  subCountParent="zyzxjsjj_1"
                       class="form-control number text-right countCol_1" countParent="sumCol_1" value="${tzqks[10].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[10].zbj" htmlEscape="false" type="number"  subCountParent="zyzxjsjj_2"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[10].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[10].ntz[0].je" htmlEscape="false" type="number"  subCountParent="zyzxjsjj_3"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[10].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[10].ntz[1].je" htmlEscape="false" type="number"  subCountParent="zyzxjsjj_4"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4" value="${tzqks[10].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[10].ntz[2].je" htmlEscape="false" type="number"  subCountParent="zyzxjsjj_5"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[10].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[10].bcsqzxjszj" htmlEscape="false" type="number"  subCountParent="zyzxjsjj_8"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[10].bcsqzxjszj}" />
            </td>
            <td><input name="tzqks[10].ljxdtz" htmlEscape="false" type="number"  subCountParent="zyzxjsjj_6" id="ljxdtz9"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[10].ljxdtz}" />
                 <input type="hidden" id="ycljxdtz9" value="${proList[0].dzxskymhqfcjyjjljdwzj}" />
                  <input type="hidden" id="zxljxdtz9" value="${tzqks[10].ljxdtz}" />
            </td>
            <td><input name="tzqks[10].ljwctz" htmlEscape="false" type="number"  subCountParent="zyzxjsjj_7"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[10].ljwctz}" />
            </td>
            <td><input name="tzqks[10].ljZjxqs" htmlEscape="false" type="number"  subCountParent="zyzxjsjj_9" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[10].zjxqs[0].je" htmlEscape="false" type="number"  subCountParent="zyzxjsjj_10"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[10].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[10].zjxqs[1].je" htmlEscape="false" type="number"  subCountParent="zyzxjsjj_11"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[10].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[10].zjxqs[2].je" htmlEscape="false" type="number"  subCountParent="zyzxjsjj_12"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[10].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[10].zjxqs[3].je" htmlEscape="false" type="number"  subCountParent="zyzxjsjj_13"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[10].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[10].qt" htmlEscape="false"
                       class="form-control text-right" value="${tzqks[10].qt}" />
            </td>
        </tr>
        <tr>
            <td><div class="subCol">公路港口建设专项基金</div><input type="hidden" name="tzqks[11].zjlb"
                                                           value="公路港口建设专项基金" />
            </td>
            <td><input name="tzqks[11].ztz" htmlEscape="false" type="number" subCountParent="zyzxjsjj_1"
                       class="form-control number text-right countCol_1" countParent="sumCol_1" value="${tzqks[11].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[11].zbj" htmlEscape="false" type="number" subCountParent="zyzxjsjj_2"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[11].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[11].ntz[0].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_3"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[11].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[11].ntz[1].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_4"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4" value="${tzqks[11].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[11].ntz[2].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_5"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[11].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[11].bcsqzxjszj" htmlEscape="false" type="number" subCountParent="zyzxjsjj_8"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[11].bcsqzxjszj}" />
            </td>
            <td><input name="tzqks[11].ljxdtz" htmlEscape="false" type="number" subCountParent="zyzxjsjj_6" id="ljxdtz10"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[11].ljxdtz}" />
                  <input type="hidden" id="ycljxdtz10" value="${proList[0].glgkjszxjjljdwzj}"/>
                   <input type="hidden" id="zxljxdtz10" value="${tzqks[11].ljxdtz}" />
            </td>
            <td><input name="tzqks[11].ljwctz" htmlEscape="false" type="number" subCountParent="zyzxjsjj_7"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[11].ljwctz}" />
            </td>
            <td><input name="tzqks[11].ljZjxqs" htmlEscape="false" type="number" subCountParent="zyzxjsjj_9" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[11].zjxqs[0].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_10"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[11].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[11].zjxqs[1].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_11"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[11].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[11].zjxqs[2].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_12"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[11].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[11].zjxqs[3].je" htmlEscape="false" type="number" subCountParent="zyzxjsjj_13"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[11].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[11].qt" htmlEscape="false"
                       class="form-control text-right" value="${tzqks[11].qt}" />
            </td>
        </tr>
        <tr>
            <td>地方预算内投资<input type="hidden" name="tzqks[12].zjlb" value="地方预算内投资" /></td>
            <td><input htmlEscape="false" disabled class="form-control text-right" subSum="dfysntz_1"/></td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input htmlEscape="false" disabled class="form-control text-right" subSum="dfysntz_2"/></td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input htmlEscape="false" disabled class="form-control text-right" subSum="dfysntz_3"/></td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input htmlEscape="false" disabled class="form-control text-right" subSum="dfysntz_4"/></td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input htmlEscape="false" disabled class="form-control text-right" subSum="dfysntz_5"/></td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input htmlEscape="false" disabled class="form-control text-right" subSum="dfysntz_8"/></td>
            <td><input htmlEscape="false" disabled class="form-control text-right" subSum="dfysntz_6"/></td>
            <td><input htmlEscape="false" disabled class="form-control text-right" subSum="dfysntz_7"/></td>
            <td><input htmlEscape="false" disabled class="form-control text-right" subSum="dfysntz_9"/></td>
            <td><input htmlEscape="false" disabled class="form-control text-right" subSum="dfysntz_10"/></td>
            <td><input htmlEscape="false" disabled class="form-control text-right" subSum="dfysntz_11"/></td>
            <td><input htmlEscape="false" disabled class="form-control text-right" subSum="dfysntz_12"/></td>
            <td><input htmlEscape="false" disabled class="form-control text-right" subSum="dfysntz_13"/></td>
            <td><input name="tzqks[12].qt" htmlEscape="false" class="form-control text-right" value="${tzqks[12].qt}" />
            </td>
        </tr>
        <tr>
            <td><div class="subCol">省级预算内投资</div><input type="hidden" name="tzqks[13].zjlb"
                                                        value="省级预算内投资" />
            </td>
            <td><input name="tzqks[13].ztz" htmlEscape="false" type="number" subCountParent="dfysntz_1"
                       class="form-control number text-right countCol_1" countParent="sumCol_1" value="${tzqks[13].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[13].zbj" htmlEscape="false" type="number" subCountParent="dfysntz_2"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[13].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[13].ntz[0].je" htmlEscape="false" type="number" subCountParent="dfysntz_3"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[13].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[13].ntz[1].je" htmlEscape="false" type="number" subCountParent="dfysntz_4"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4" value="${tzqks[13].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[13].ntz[2].je" htmlEscape="false" type="number" subCountParent="dfysntz_5"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[13].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[13].bcsqzxjszj" htmlEscape="false" type="number" subCountParent="dfysntz_8"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[13].bcsqzxjszj}" />
            </td>
            <td><input name="tzqks[13].ljxdtz" htmlEscape="false" type="number" subCountParent="dfysntz_6" id="ljxdtz11"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[13].ljxdtz}" />
                 <input type="hidden" id="ycljxdtz11" value="${proList[0].shengjiysntzljdwzj}"/> 
                  <input type="hidden" id="zxljxdtz11" value="${tzqks[13].ljxdtz}" />
            </td>
            <td><input name="tzqks[13].ljwctz" htmlEscape="false" type="number" subCountParent="dfysntz_7"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[13].ljwctz}" />
            </td>
            <td><input name="tzqks[13].ljZjxqs" htmlEscape="false" type="number" subCountParent="dfysntz_9" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[13].zjxqs[0].je" htmlEscape="false" type="number" subCountParent="dfysntz_10"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[13].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[13].zjxqs[1].je" htmlEscape="false" type="number" subCountParent="dfysntz_11"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[13].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[13].zjxqs[2].je" htmlEscape="false" type="number" subCountParent="dfysntz_12"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[13].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[13].zjxqs[3].je" htmlEscape="false" type="number" subCountParent="dfysntz_13"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[13].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[13].qt" htmlEscape="false"
                       class="form-control text-right" value="${tzqks[13].qt}" />
            </td>
        </tr>
        <tr>
            <td><div class="subCol">市级预算内投资</div><input type="hidden" name="tzqks[14].zjlb"
                                                        value="市级预算内投资" />
            </td>
            <td><input name="tzqks[14].ztz" htmlEscape="false" type="number" subCountParent="dfysntz_1"
                       class="form-control number text-right countCol_1" countParent="sumCol_1" value="${tzqks[14].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[14].zbj" htmlEscape="false" type="number" subCountParent="dfysntz_2"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[14].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[14].ntz[0].je" htmlEscape="false" type="number" subCountParent="dfysntz_3"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[14].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[14].ntz[1].je" htmlEscape="false" type="number" subCountParent="dfysntz_4"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4" value="${tzqks[14].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[14].ntz[2].je" htmlEscape="false" type="number" subCountParent="dfysntz_5"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[14].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[14].bcsqzxjszj" htmlEscape="false" type="number" subCountParent="dfysntz_8"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[14].bcsqzxjszj}" />
            </td> 
            <td><input name="tzqks[14].ljxdtz" htmlEscape="false" type="number" subCountParent="dfysntz_6" id="ljxdtz12"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[14].ljxdtz}" />
                 <input type="hidden" id="ycljxdtz12" value="${proList[0].shijiysntzljdwzj}"/>      
                  <input type="hidden" id="zxljxdtz12" value="${tzqks[14].ljxdtz}" /> 
            </td>
            <td><input name="tzqks[14].ljwctz" htmlEscape="false" type="number" subCountParent="dfysntz_7"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[14].ljwctz}" />
            </td>
            <td><input name="tzqks[14].ljZjxqs" htmlEscape="false" type="number" subCountParent="dfysntz_9" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[14].zjxqs[0].je" htmlEscape="false" type="number" subCountParent="dfysntz_10"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[14].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[14].zjxqs[1].je" htmlEscape="false" type="number" subCountParent="dfysntz_11"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[14].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[14].zjxqs[2].je" htmlEscape="false" type="number" subCountParent="dfysntz_12"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[14].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[14].zjxqs[3].je" htmlEscape="false" type="number" subCountParent="dfysntz_13"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[14].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[14].qt" htmlEscape="false"
                       class="form-control text-right" value="${tzqks[14].qt}" />
            </td>
        </tr>
        <tr>
            <td><div class="subCol">县级预算内投资</div><input type="hidden" name="tzqks[15].zjlb"
                                                        value="县级预算内投资" />
            </td>
            <td><input name="tzqks[15].ztz" htmlEscape="false" type="number" subCountParent="dfysntz_1"
                       class="form-control number text-right countCol_1" countParent="sumCol_1"  value="${tzqks[15].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[15].zbj" htmlEscape="false" type="number" subCountParent="dfysntz_2"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[15].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[15].ntz[0].je" htmlEscape="false" type="number" subCountParent="dfysntz_3"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[15].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[15].ntz[1].je" htmlEscape="false" type="number" subCountParent="dfysntz_4"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4" value="${tzqks[15].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[15].ntz[2].je" htmlEscape="false" type="number" subCountParent="dfysntz_5"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[15].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[15].bcsqzxjszj" htmlEscape="false" type="number" subCountParent="dfysntz_8"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[15].bcsqzxjszj}" />
            </td>
            <td><input name="tzqks[15].ljxdtz" htmlEscape="false" type="number" subCountParent="dfysntz_6" id="ljxdtz13"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[15].ljxdtz}" />
                 <input type="hidden" id="ycljxdtz13" value="${proList[0].xianjiysntzljdwzj}"/>     
                  <input type="hidden" id="zxljxdtz13" value="${tzqks[15].ljxdtz}" />    
            </td>
            <td><input name="tzqks[15].ljwctz" htmlEscape="false" type="number" subCountParent="dfysntz_7"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[15].ljwctz}" />
            </td>
            <td><input name="tzqks[15].ljZjxqs" htmlEscape="false" type="number" subCountParent="dfysntz_9" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[15].zjxqs[0].je" htmlEscape="false" type="number" subCountParent="dfysntz_10"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[15].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[15].zjxqs[1].je" htmlEscape="false" type="number" subCountParent="dfysntz_11"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[15].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[15].zjxqs[2].je" htmlEscape="false" type="number" subCountParent="dfysntz_12"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[15].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[15].zjxqs[3].je" htmlEscape="false" type="number" subCountParent="dfysntz_13"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[15].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[15].qt" htmlEscape="false"
                       class="form-control text-right" value="${tzqks[15].qt}" />
            </td>
        </tr>
        <tr>
            <td>地方财政性建设资金<input type="hidden" name="tzqks[16].zjlb" value="地方财政性建设资金" /></td>
            <td><input htmlEscape="false"  disabled class="form-control text-right" subSum="dfczxjszj_1"/></td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input htmlEscape="false" disabled class="form-control text-right" subSum="dfczxjszj_2"/></td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input htmlEscape="false" disabled class="form-control text-right" subSum="dfczxjszj_3"/></td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input htmlEscape="false" disabled class="form-control text-right" subSum="dfczxjszj_4"/></td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input htmlEscape="false" disabled class="form-control text-right" subSum="dfczxjszj_5"/></td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input htmlEscape="false" disabled class="form-control text-right" subSum="dfczxjszj_8"/></td>
            <td><input htmlEscape="false" disabled class="form-control text-right" subSum="dfczxjszj_6"/></td>
            <td><input htmlEscape="false" disabled class="form-control text-right" subSum="dfczxjszj_7"/></td>
            <td><input htmlEscape="false" disabled class="form-control text-right" subSum="dfczxjszj_9"/></td>
            <td><input htmlEscape="false" disabled class="form-control text-right" subSum="dfczxjszj_10"/></td>
            <td><input htmlEscape="false" disabled class="form-control text-right" subSum="dfczxjszj_11"/></td>
            <td><input htmlEscape="false" disabled class="form-control text-right" subSum="dfczxjszj_12"/></td>
            <td><input htmlEscape="false" disabled class="form-control text-right" subSum="dfczxjszj_13"/></td>
            <td><input name="tzqks[16].qt" htmlEscape="false" class="form-control text-right" value="${tzqks[16].qt}" /></td>
        </tr>
        <tr>
            <td><div class="subCol">省级财政资金</div><input type="hidden" name="tzqks[17].zjlb"
                                                       value="省级财政资金" />
            </td>
            <td><input name="tzqks[17].ztz" htmlEscape="false" type="number" subCountParent="dfczxjszj_1"
                       class="form-control number text-right countCol_1" countParent="sumCol_1" value="${tzqks[17].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[17].zbj" htmlEscape="false" type="number" subCountParent="dfczxjszj_2"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[17].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[17].ntz[0].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_3"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[17].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[17].ntz[1].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_4"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4" value="${tzqks[17].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[17].ntz[2].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_5"
                                                                               class="form-control number text-right countCol_5"countParent="sumCol_5"  value="${tzqks[17].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[17].bcsqzxjszj" htmlEscape="false" type="number" subCountParent="dfczxjszj_8"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[17].bcsqzxjszj}" />
            </td>
            <td><input name="tzqks[17].ljxdtz" htmlEscape="false" type="number" subCountParent="dfczxjszj_6"  id="ljxdtz14"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[17].ljxdtz}" />
                   <input type="hidden" id="ycljxdtz14" value="${proList[0].shengjiczzjljdwzj}"/>
                    <input type="hidden" id="zxljxdtz14" value="${tzqks[17].ljxdtz}" />
            </td>
            <td><input name="tzqks[17].ljwctz" htmlEscape="false" type="number" subCountParent="dfczxjszj_7"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[17].ljwctz}" />
            </td>
            <td><input name="tzqks[17].ljZjxqs" htmlEscape="false" type="number" subCountParent="dfczxjszj_9" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[17].zjxqs[0].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_10"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[17].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[17].zjxqs[1].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_11"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[17].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[17].zjxqs[2].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_12"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[17].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[17].zjxqs[3].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_13"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[17].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[17].qt" htmlEscape="false"
                       class="form-control text-right" value="${tzqks[17].qt}" />
            </td>
        </tr>
        <tr>
            <td><div class="subCol">市级财政资金</div><input type="hidden" name="tzqks[18].zjlb"
                                                       value="市级财政资金" />
            </td>
            <td><input name="tzqks[18].ztz" htmlEscape="false" type="number" subCountParent="dfczxjszj_1"
                       class="form-control number text-right countCol_1" countParent="sumCol_1" value="${tzqks[18].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[18].zbj" htmlEscape="false" type="number" subCountParent="dfczxjszj_2"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[18].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[18].ntz[0].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_3"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[18].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[18].ntz[1].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_4"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4" value="${tzqks[18].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[18].ntz[2].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_5"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[18].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[18].bcsqzxjszj" htmlEscape="false" type="number" subCountParent="dfczxjszj_8"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[18].bcsqzxjszj}" />
            </td>
            <td><input name="tzqks[18].ljxdtz" htmlEscape="false" type="number" subCountParent="dfczxjszj_6" id="ljxdtz15"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[18].ljxdtz}" />
                <input type="hidden" id="ycljxdtz15" value="${proList[0].shijiczzjljdwzj}"/> 
                 <input type="hidden" id="zxljxdtz15" value="${tzqks[18].ljxdtz}" />      
            </td>
            <td><input name="tzqks[18].ljwctz" htmlEscape="false" type="number" subCountParent="dfczxjszj_7"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[18].ljwctz}" />
            </td>
            <td><input name="tzqks[18].ljZjxqs" htmlEscape="false" type="number" subCountParent="dfczxjszj_9" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[18].zjxqs[0].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_10"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[18].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[18].zjxqs[1].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_11"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[18].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[18].zjxqs[2].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_12"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[18].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[18].zjxqs[3].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_13"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[18].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[18].qt" htmlEscape="false"
                       class="form-control text-right" value="${tzqks[18].qt}" />
            </td>
        </tr>
        <tr>
            <td><div class="subCol">县级财政资金</div><input type="hidden" name="tzqks[19].zjlb"
                                                       value="县级财政资金" />
            </td>
            <td><input name="tzqks[19].ztz" htmlEscape="false" type="number" subCountParent="dfczxjszj_1"
                       class="form-control number text-right countCol_1" countParent="sumCol_1" value="${tzqks[19].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[19].zbj" htmlEscape="false" type="number" subCountParent="dfczxjszj_2"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[19].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[19].ntz[0].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_3"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[19].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[19].ntz[1].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_4"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4" value="${tzqks[19].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[19].ntz[2].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_5"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[19].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[19].bcsqzxjszj" htmlEscape="false" type="number" subCountParent="dfczxjszj_8"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[19].bcsqzxjszj}" />
            </td>
            <td>${tzqks[19].ljxdtz}
            <input name="tzqks[19].ljxdtz" htmlEscape="false" type="number" subCountParent="dfczxjszj_6" id="ljxdtz16"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[19].ljxdtz}" />
                 <input type="hidden" id="ycljxdtz16" value="${proList[0].xianjiczzjljdwzj}"/> 
                  <input type="hidden" id="zxljxdtz16" value="${tzqks[19].ljxdtz}" />
            </td>
            <td><input name="tzqks[19].ljwctz" htmlEscape="false" type="number" subCountParent="dfczxjszj_7"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[19].ljwctz}" />
            </td>
            <td><input name="tzqks[19].ljZjxqs" htmlEscape="false" type="number" subCountParent="dfczxjszj_9" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[19].zjxqs[0].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_10"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[19].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[19].zjxqs[1].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_11"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[19].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[19].zjxqs[2].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_12"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[19].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[19].zjxqs[3].je" htmlEscape="false" type="number" subCountParent="dfczxjszj_13"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[19].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[19].qt" htmlEscape="false"
                       class="form-control text-right" value="${tzqks[19].qt}" />
            </td>
        </tr>
        <tr>
            <td>地方专项建设基金<input type="hidden" name="tzqks[20].zjlb"
                               value="地方专项建设基金" />
            </td>
            <td><input name="tzqks[20].ztz" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_1" countParent="sumCol_1" value="${tzqks[20].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[20].zbj" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[20].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[20].ntz[0].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[20].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[20].ntz[1].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4" value="${tzqks[20].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[20].ntz[2].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[20].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[20].bcsqzxjszj" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[20].bcsqzxjszj}" />
            </td>
            <td><input name="tzqks[20].ljxdtz" htmlEscape="false" type="number" id="ljxdtz17"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[20].ljxdtz}" />
                 <input type="hidden" id="ycljxdtz17" value="${proList[0].dfzxjsjjljdwzj}"/>  
                  <input type="hidden" id="zxljxdtz17" value="${tzqks[20].ljxdtz}" />     
            </td>
            <td><input name="tzqks[20].ljwctz" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[20].ljwctz}" />
            </td>
            <td><input name="tzqks[20].ljZjxqs" htmlEscape="false" type="number" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[20].zjxqs[0].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[20].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[20].zjxqs[1].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[20].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[20].zjxqs[2].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[20].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[20].zjxqs[3].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[20].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[20].qt" htmlEscape="false"
                       class="form-control text-right" value="${tzqks[20].qt}" />
            </td>
        </tr>
        <tr>
            <td>企业自有投资<input type="hidden" name="tzqks[21].zjlb"
                             value="企业自有投资" />
            </td>
            <td><input name="tzqks[21].ztz" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_1" countParent="sumCol_1" value="${tzqks[21].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[21].zbj" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[21].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[21].ntz[0].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[21].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[21].ntz[1].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4" value="${tzqks[21].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[21].ntz[2].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[21].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[21].bcsqzxjszj" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[21].bcsqzxjszj}" />
            </td>
            <td><input name="tzqks[21].ljxdtz" htmlEscape="false" type="number" id="ljxdtz18"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[21].ljxdtz}" />
                 <input type="hidden" id="ycljxdtz18" value="${proList[0].qyzytzljdwzj}"/>  
                  <input type="hidden" id="zxljxdtz18" value="${tzqks[21].ljxdtz}" />    
            </td>
            <td><input name="tzqks[21].ljwctz" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[21].ljwctz}" />
            </td>
            <td><input name="tzqks[21].ljZjxqs" htmlEscape="false" type="number" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[21].zjxqs[0].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[21].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[21].zjxqs[1].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[21].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[21].zjxqs[2].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[21].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[21].zjxqs[3].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[21].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[21].qt" htmlEscape="false"
                       class="form-control text-right" value="${tzqks[21].qt}" />
            </td>
        </tr>
        <tr>
            <td>银行贷款<input type="hidden" name="tzqks[22].zjlb"
                           value="银行贷款" />
            </td>
            <td><input name="tzqks[22].ztz" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_1" countParent="sumCol_1" value="${tzqks[22].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[22].zbj" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[22].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[22].ntz[0].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[22].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[22].ntz[1].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4" value="${tzqks[22].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[22].ntz[2].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[22].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[22].bcsqzxjszj" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[22].bcsqzxjszj}" />
            </td>
            <td><input name="tzqks[22].ljxdtz" htmlEscape="false" type="number" id="ljxdtz19"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[22].ljxdtz}" />
                  <input type="hidden" id="ycljxdtz19" value="${proList[0].yhdkljdwzj}"/> 
                   <input type="hidden" id="zxljxdtz19" value="${tzqks[22].ljxdtz}" />
            </td>
            <td><input name="tzqks[22].ljwctz" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[22].ljwctz}" />
            </td>
            <td><input name="tzqks[22].ljZjxqs" htmlEscape="false" type="number" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[22].zjxqs[0].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[22].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[22].zjxqs[1].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[22].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[22].zjxqs[2].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[22].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[22].zjxqs[3].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[22].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[22].qt" htmlEscape="false"
                       class="form-control text-right" value="${tzqks[22].qt}" />
            </td>
        </tr>
        <tr>
            <td>利用外资<input type="hidden" name="tzqks[23].zjlb"
                           value="利用外资" />
            </td>
            <td><input name="tzqks[23].ztz" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_1" countParent="sumCol_1" value="${tzqks[23].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[23].zbj" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[23].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[23].ntz[0].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[23].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[23].ntz[1].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4" value="${tzqks[23].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[23].ntz[2].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[23].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[23].bcsqzxjszj" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[23].bcsqzxjszj}" />
            </td> 
            <td><input name="tzqks[23].ljxdtz" htmlEscape="false" type="number" id="ljxdtz20"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[23].ljxdtz}" />
                 <input type="hidden" id="ycljxdtz20" value="${proList[0].lywzljdwzj}"/> 
                  <input type="hidden" id="zxljxdtz20" value="${tzqks[23].ljxdtz}" />      
            </td>
            <td><input name="tzqks[23].ljwctz" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[23].ljwctz}" />
            </td>
            <td><input name="tzqks[23].ljZjxqs" htmlEscape="false" type="number" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[23].zjxqs[0].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[23].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[23].zjxqs[1].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[23].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[23].zjxqs[2].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[23].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[23].zjxqs[3].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[23].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[23].qt" htmlEscape="false"
                       class="form-control text-right" value="${tzqks[23].qt}" />
            </td>
        </tr>
        <tr>
            <td>资金渠道待定<input type="hidden" name="tzqks[24].zjlb"
                             value="资金渠道待定" />
            </td>
            <td><input name="tzqks[24].ztz" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_1" countParent="sumCol_1" value="${tzqks[24].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[24].zbj" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[24].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[24].ntz[0].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[24].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[24].ntz[1].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4" value="${tzqks[24].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[24].ntz[2].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[24].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[24].bcsqzxjszj" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[24].bcsqzxjszj}" />
            </td> 
            <td><input name="tzqks[24].ljxdtz" htmlEscape="false" type="number" id="ljxdtz21"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[24].ljxdtz}" />
                 <input type="hidden" id="ycljxdtz21" value="${proList[0].zjqdddljdwzj}"/>     
                  <input type="hidden" id="zxljxdtz21" value="${tzqks[24].ljxdtz}" /> 
            </td>
            <td><input name="tzqks[24].ljwctz" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[24].ljwctz}" />
            </td>
            <td><input name="tzqks[24].ljZjxqs" htmlEscape="false" type="number" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[24].zjxqs[0].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[24].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[24].zjxqs[1].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[24].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[24].zjxqs[2].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[24].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[24].zjxqs[3].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[24].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[24].qt" htmlEscape="false"
                       class="form-control text-right" value="${tzqks[24].qt}" />
            </td>
        </tr>
        <tr>
            <td>其他资金<input type="hidden" name="tzqks[25].zjlb"
                           value="其他资金" />
            </td>
            <td><input name="tzqks[25].ztz" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_1" countParent="sumCol_1" value="${tzqks[25].ztz}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[25].zbj" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_2" countParent="sumCol_2" value="${tzqks[25].zbj}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[25].ntz[0].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_3" countParent="sumCol_3" value="${tzqks[25].ntz[0].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[25].ntz[1].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_4" countParent="sumCol_4" value="${tzqks[25].ntz[1].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[25].ntz[2].je" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_5" countParent="sumCol_5" value="${tzqks[25].ntz[2].je}" />
            </td>
            <td style="${sfsqzxjsjjDisplayValue}" name="sfsqzxjsjjLine"><input name="tzqks[25].bcsqzxjszj" htmlEscape="false" type="number"
                                                                               class="form-control number text-right countCol_8" countParent="sumCol_8" value="${tzqks[25].bcsqzxjszj}" />
            </td>
            <td><input name="tzqks[25].ljxdtz" htmlEscape="false" type="number" id="ljxdtz22"
                       class="form-control number text-right countCol_6" countParent="sumCol_6" value="${tzqks[25].ljxdtz}" />
                 <input type="hidden" id="ycljxdtz22" value="${proList[0].qtzjljdwzj}"/>     
                  <input type="hidden" id="zxljxdtz22" value="${tzqks[25].ljxdtz}" />  
            </td>
            <td><input name="tzqks[25].ljwctz" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_7" countParent="sumCol_7" value="${tzqks[25].ljwctz}" />
            </td>
            <td><input name="tzqks[25].ljZjxqs" htmlEscape="false" type="number" disabled
                       class="form-control number text-right countCol_9" countParent="sumCol_9" value="" />
            </td>
            <td><input name="tzqks[25].zjxqs[0].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_10" countParent="sumCol_10" value="${tzqks[25].zjxqs[3].je}" />
            </td>
            <td><input name="tzqks[25].zjxqs[1].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_11" countParent="sumCol_11"  value="${tzqks[25].zjxqs[2].je}" />
            </td>
            <td><input name="tzqks[25].zjxqs[2].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_12" countParent="sumCol_12" value="${tzqks[25].zjxqs[1].je}" />
            </td>
            <td><input name="tzqks[25].zjxqs[3].je" htmlEscape="false" type="number"
                       class="form-control number text-right countCol_13" countParent="sumCol_13" value="${tzqks[25].zjxqs[0].je}" />
            </td>
            <td><input name="tzqks[25].qt" htmlEscape="false"
                       class="form-control text-right" value="${tzqks[25].qt}" />
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