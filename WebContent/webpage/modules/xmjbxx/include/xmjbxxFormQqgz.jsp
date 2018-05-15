<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<div class="tz_sub" id="fen3"  name="inputForm">
    <table
            class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
        <tbody>
        <tr>
            <td>审批事项（要件）</td>
            <td>批复单位</td>
            <td style="width:120px;">批复时间</td>
            <td>批复文件标题</td>
            <td>批复文号</td>
            <td>批复状态</td>
            <%--<td>批复文件</td>--%>
             <td>查看</td>
        </tr>
        <tr>
            <td>建设项目用地预审<input type="hidden" name="qqgzs[0].spsx"
                               value="建设项目用地预审" />
            </td>
            <td><input name="qqgzs[0].pfdw" htmlEscape="false"
                       class="form-control " value="${qqgzs[0].pfdw}" />
            </td>
            <td><input id="qqgzs_0_pfsj" name="qqgzs[0].pfsj"
                       type="text" maxlength="20"
                       class="laydate-icon form-control layer-date "
                       value='<fmt:formatDate value="${qqgzs[0].pfsj}" pattern="yyyy-MM-dd"/>' />
            </td>
            <td><input name="qqgzs[0].pfwjbt" htmlEscape="false"
                       class="form-control " value="${qqgzs[0].pfwjbt}" />
            </td>
            <td><input name="qqgzs[0].pfwh" htmlEscape="false"
                       class="form-control " value="${qqgzs[0].pfwh}" />
            </td>
            <td><select name="qqgzs[0].pfzt" class="form-control required" value="${qqgzs[0].pfzt}">
                <option value="0" <c:if test="${qqgzs[0].pfzt == '0'}">selected</c:if>/>办理中
                <option value="1" <c:if test="${qqgzs[0].pfzt == '1'}">selected</c:if>/>已办结
            </select></td>
            <%--<td><input name="qqgzs[0].pfwj" htmlEscape="false"
                class="form-control " value="${qqgzs[0].pfwj}" />
            </td>--%>
            <td>
             	<c:choose>
	            	<c:when test="${qqgzs[0].fileId != null&&qqgzs[0].fileId != '-1'}">
	            	<a onclick="yuLan('${qqgzs[0].fileId}','${qqgzs[0].xmjbxx.id}');" >查看</a>
	            	</c:when>
	            	<c:otherwise>
	            	<a style="cursor: not-allowed;opacity: 0.5">查看</a>
	            	</c:otherwise>
	   			</c:choose>
             </td>
        </tr>
        <tr>
            <td>用海预审<input type="hidden" name="qqgzs[1].spsx" value="2" />
            </td>
            <td><input name="qqgzs[1].pfdw" htmlEscape="false"
                       class="form-control " value="${qqgzs[1].pfdw}" />
            </td>
            <td><input id="qqgzs_1_pfsj" name="qqgzs[1].pfsj"
                       type="text" maxlength="20"
                       class="laydate-icon form-control layer-date "
                       value='<fmt:formatDate value="${qqgzs[1].pfsj}" pattern="yyyy-MM-dd"/>' />
            </td>
            <td><input name="qqgzs[1].pfwjbt" htmlEscape="false"
                       class="form-control " value="${qqgzs[1].pfwjbt}" />
            </td>
            <td><input name="qqgzs[1].pfwh" htmlEscape="false"
                       class="form-control " value="${qqgzs[1].pfwh}" />
            </td>
            <td><select name="qqgzs[1].pfzt"
                        class="form-control required" value="${qqgzs[1].pfzt}">
                <option value="0" <c:if test="${qqgzs[1].pfzt == '0'}">selected</c:if>/>办理中
                <option value="1" <c:if test="${qqgzs[1].pfzt == '1'}">selected</c:if>/>已办结
            </select></td>
            <%--<td><input name="qqgzs[1].pfwj" htmlEscape="false"
                class="form-control " value="${qqgzs[1].pfwj}" />
            </td>--%>
            <td>
            	<c:choose>
	            	<c:when test="${qqgzs[1].fileId != null&&qqgzs[1].fileId != '-1'}">
	            	<a onclick="yuLan('${qqgzs[1].fileId}','${qqgzs[1].xmjbxx.id}');" >查看</a>
	            	</c:when>
	            	<c:otherwise>
	            	<a style="cursor: not-allowed;opacity: 0.5">查看</a>
	            	</c:otherwise>
	   			</c:choose>
            </td>
        </tr>
        <tr>
            <td>选址意见地<input type="hidden" name="qqgzs[2].spsx" value="3" />
            </td>
            <td><input name="qqgzs[2].pfdw" htmlEscape="false"
                       class="form-control " value="${qqgzs[2].pfdw}" />
            </td>
            <td><input id="qqgzs_2_pfsj" name="qqgzs[2].pfsj"
                       type="text" maxlength="20"
                       class="laydate-icon form-control layer-date "
                       value='<fmt:formatDate value="${qqgzs[2].pfsj}" pattern="yyyy-MM-dd"/>' />
            </td>
            <td><input name="qqgzs[2].pfwjbt" htmlEscape="false"
                       class="form-control " value="${qqgzs[2].pfwjbt}" />
            </td>
            <td><input name="qqgzs[2].pfwh" htmlEscape="false"
                       class="form-control " value="${qqgzs[2].pfwh}" />
            </td>
            <td><select name="qqgzs[2].pfzt"
                        class="form-control required" value="${qqgzs[2].pfzt}">
                <option value="0" <c:if test="${qqgzs[2].pfzt == '0'}">selected</c:if>/>办理中
                <option value="1" <c:if test="${qqgzs[2].pfzt == '1'}">selected</c:if>/>已办结
            </select></td>
            <%--<td><input name="qqgzs[2].pfwj" htmlEscape="false"--%>
            <%--class="form-control " value="${qqgzs[2].pfwj}" />--%>
            <%--</td>--%>
            <td>
            	<c:choose>
	            	<c:when test="${qqgzs[2].fileId != null&&qqgzs[2].fileId != '-1'}">
	            	<a onclick="yuLan('${qqgzs[2].fileId}','${qqgzs[2].xmjbxx.id}');" >查看</a>
	            	</c:when>
	            	<c:otherwise>
	            	<a style="cursor: not-allowed;opacity: 0.5">查看</a>
	            	</c:otherwise>
	   			</c:choose>
            </td>
        </tr>
        <tr>
            <td>环境影响评价批复<input type="hidden" name="qqgzs[3].spsx"
                               value="4" />
            </td>
            <td><input name="qqgzs[3].pfdw" htmlEscape="false"
                       class="form-control " value="${qqgzs[3].pfdw}" />
            </td>
            <td><input id="qqgzs_3_pfsj" name="qqgzs[3].pfsj"
                       type="text" maxlength="20"
                       class="laydate-icon form-control layer-date "
                       value='<fmt:formatDate value="${qqgzs[3].pfsj}" pattern="yyyy-MM-dd"/>' />
            </td>
            <td><input name="qqgzs[3].pfwjbt" htmlEscape="false"
                       class="form-control " value="${qqgzs[3].pfwjbt}" />
            </td>
            <td><input name="qqgzs[3].pfwh" htmlEscape="false"
                       class="form-control " value="${qqgzs[3].pfwh}" />
            </td>
            <td><select name="qqgzs[3].pfzt"
                        class="form-control required" value="${qqgzs[3].pfzt}">
               <option value="0" <c:if test="${qqgzs[3].pfzt == '0'}">selected</c:if>/>办理中
               <option value="1" <c:if test="${qqgzs[3].pfzt == '1'}">selected</c:if>/>已办结
            </select></td>
            <%--<td><input name="qqgzs[3].pfwj" htmlEscape="false"--%>
            <%--class="form-control " value="${qqgzs[3].pfwj}" />--%>
            <%--</td>--%>
            <td>
            	<c:choose>
	            	<c:when test="${qqgzs[3].fileId != null&&qqgzs[3].fileId != '-1'}">
	            	<a onclick="yuLan('${qqgzs[3].fileId}','${qqgzs[3].xmjbxx.id}');" >查看</a>
	            	</c:when>
	            	<c:otherwise>
	            	<a style="cursor: not-allowed;opacity: 0.5">查看</a>
	            	</c:otherwise>
	   			</c:choose>
            </td>
        </tr>
        <tr>
            <td>节能评估和审查<input type="hidden" name="qqgzs[4].spsx"
                              value="5" />
            </td>
            <td><input name="qqgzs[4].pfdw" htmlEscape="false"
                       class="form-control " value="${qqgzs[4].pfdw}" />
            </td>
            <td><input id="qqgzs_4_pfsj" name="qqgzs[4].pfsj"
                       type="text" maxlength="20"
                       class="laydate-icon form-control layer-date "
                       value='<fmt:formatDate value="${qqgzs[4].pfsj}" pattern="yyyy-MM-dd"/>' />
            </td>
            <td><input name="qqgzs[4].pfwjbt" htmlEscape="false"
                       class="form-control " value="${qqgzs[4].pfwjbt}" />
            </td>
            <td><input name="qqgzs[4].pfwh" htmlEscape="false"
                       class="form-control " value="${qqgzs[4].pfwh}" />
            </td>
            <td><select name="qqgzs[4].pfzt"
                        class="form-control required" value="${qqgzs[4].pfzt}">
                <option value="0" <c:if test="${qqgzs[4].pfzt == '0'}">selected</c:if>/>办理中
                <option value="1" <c:if test="${qqgzs[4].pfzt == '1'}">selected</c:if>/>已办结
            </select></td>
            <%--<td><input name="qqgzs[4].pfwj" htmlEscape="false"
                class="form-control " value="${qqgzs[4].pfwj}" />
            </td>--%>
            <td>
            	<c:choose>
	            	<c:when test="${qqgzs[4].fileId != null&&qqgzs[4].fileId != '-1'}">
	            	<a onclick="yuLan('${qqgzs[4].fileId}','${qqgzs[4].xmjbxx.id}');" >查看</a>
	            	</c:when>
	            	<c:otherwise>
	            	<a style="cursor: not-allowed;opacity: 0.5">查看</a>
	            	</c:otherwise>
	   			</c:choose>
            </td>
        </tr>
        <tr>
            <td>社会稳定风险评估<input type="hidden" name="qqgzs[5].spsx"
                               value="6" />
            </td>
            <td><input name="qqgzs[5].pfdw" htmlEscape="false"
                       class="form-control " value="${qqgzs[5].pfdw}" />
            </td>
            <td><input id="qqgzs_5_pfsj" name="qqgzs[5].pfsj"
                       type="text" maxlength="20"
                       class="laydate-icon form-control layer-date "
                       value='<fmt:formatDate value="${qqgzs[5].pfsj}" pattern="yyyy-MM-dd"/>' />
            </td>
            <td><input name="qqgzs[5].pfwjbt" htmlEscape="false"
                       class="form-control " value="${qqgzs[5].pfwjbt}" />
            </td>
            <td><input name="qqgzs[5].pfwh" htmlEscape="false"
                       class="form-control " value="${qqgzs[5].pfwh}" />
            </td>
            <td><select name="qqgzs[5].pfzt"
                        class="form-control required" value="${qqgzs[5].pfzt}">
               <option value="0" <c:if test="${qqgzs[5].pfzt == '0'}">selected</c:if>/>办理中
               <option value="1" <c:if test="${qqgzs[5].pfzt == '1'}">selected</c:if>/>已办结
            </select></td>
            <%--<td><input name="qqgzs[5].pfwj" htmlEscape="false"
                class="form-control " value="${qqgzs[5].pfwj}" />
            </td>--%>
            <td>
            	<c:choose>
	            	<c:when test="${qqgzs[5].fileId != null&&qqgzs[5].fileId != '-1'}">
	            	<a onclick="yuLan('${qqgzs[5].fileId}','${qqgzs[5].xmjbxx.id}');" >查看</a>
	            	</c:when>
	            	<c:otherwise>
	            	<a style="cursor: not-allowed;opacity: 0.5">查看</a>
	            	</c:otherwise>
	   			</c:choose>
            </td>
        </tr>
        <tr>
            <td>项目建议书批复
	   			<input type="hidden"  name="qqgzs[6].spsx" value="7" />
            </td>
            <td><input name="qqgzs[6].pfdw" htmlEscape="false"
                       class="form-control " value="${qqgzs[6].pfdw}" />
            </td>
            <td><input id="qqgzs_6_pfsj" name="qqgzs[6].pfsj"
                       type="text" maxlength="20"
                       class="laydate-icon form-control layer-date "
                       value='<fmt:formatDate value="${qqgzs[6].pfsj}" pattern="yyyy-MM-dd"/>' />
            </td>
            <td><input name="qqgzs[6].pfwjbt" htmlEscape="false"
                       class="form-control " value="${qqgzs[6].pfwjbt}" />
            </td>
            <td><input name="qqgzs[6].pfwh" htmlEscape="false"
                       class="form-control " value="${qqgzs[6].pfwh}" />
            </td>
            <td>
	            <select name="qqgzs[6].pfzt"
	                        class="form-control required" value="${qqgzs[6].pfzt}">
	                <option value="0" <c:if test="${qqgzs[6].pfzt == '0'}">selected</c:if>/>办理中
	                <option value="1" <c:if test="${qqgzs[6].pfzt == '1'}">selected</c:if>/>已办结
	            </select></td>
	            <%--<td><input name="qqgzs[6].pfwj" htmlEscape="false"
	                class="form-control " value="${qqgzs[6].pfwj}" />
	            </td>--%>
	            <td>
	            	<c:choose>
		            	<c:when test="${qqgzs[6].fileId != null&&qqgzs[6].fileId != '-1'}">
		            	<a onclick="yuLan('${qqgzs[6].fileId}','${qqgzs[6].xmjbxx.id}');" >查看</a>
		            	</c:when>
		            	<c:otherwise>
		            	<a style="cursor: not-allowed;opacity: 0.5">查看</a>
		            	</c:otherwise>
		   			</c:choose>
            	</td>
        </tr>
        <tr>
            <td>可行性研究报告<input type="hidden"
                                                        name="qqgzs[7].spsx" value="8" />
            </td>
            <td><input name="qqgzs[7].pfdw" htmlEscape="false"
                       class="form-control " value="${qqgzs[7].pfdw}" />
            </td>
            <td><input id="qqgzs_7_pfsj" name="qqgzs[7].pfsj"
                       type="text" maxlength="20"
                       class="laydate-icon form-control layer-date "
                       value='<fmt:formatDate value="${qqgzs[7].pfsj}" pattern="yyyy-MM-dd"/>' />
            </td>
            <td><input name="qqgzs[7].pfwjbt" htmlEscape="false"
                       class="form-control " value="${qqgzs[7].pfwjbt}" />
            </td>
            <td><input name="qqgzs[7].pfwh" htmlEscape="false"
                       class="form-control " value="${qqgzs[7].pfwh}" />
            </td>
            <td><select name="qqgzs[7].pfzt"
                        class="form-control required" value="${qqgzs[7].pfzt}">
                 <option value="0" <c:if test="${qqgzs[7].pfzt == '0'}">selected</c:if>/>办理中
                 <option value="1" <c:if test="${qqgzs[7].pfzt == '1'}">selected</c:if>/>已办结
            </select></td>
            <%--<td><input name="qqgzs[7].pfwj" htmlEscape="false"
                class="form-control " value="${qqgzs[7].pfwj}" />
            </td>--%>
            <td>
            	<c:choose>
	            	<c:when test="${qqgzs[7].fileId != null&&qqgzs[7].fileId != '-1'}">
	            	<a onclick="yuLan('${qqgzs[7].fileId}','${qqgzs[7].xmjbxx.id}');" >查看</a>
	            	</c:when>
	            	<c:otherwise>
	            	<a style="cursor: not-allowed;opacity: 0.5">查看</a>
	            	</c:otherwise>
	   			</c:choose>
           	</td>
        </tr>
        <tr>
            <td>初步设计及概算<input type="hidden"
                                                        name="qqgzs[8].spsx" value="9" />
            </td>
            <td><input name="qqgzs[8].pfdw" htmlEscape="false"
                       class="form-control " value="${qqgzs[8].pfdw}" />
            </td>
            <td><input id="qqgzs_8_pfsj" name="qqgzs[8].pfsj"
                       type="text" maxlength="20"
                       class="laydate-icon form-control layer-date "
                       value='<fmt:formatDate value="${qqgzs[8].pfsj}" pattern="yyyy-MM-dd"/>' />
            </td>
            <td><input name="qqgzs[8].pfwjbt" htmlEscape="false"
                       class="form-control " value="${qqgzs[8].pfwjbt}" />
            </td>
            <td><input name="qqgzs[8].pfwh" htmlEscape="false"
                       class="form-control " value="${qqgzs[8].pfwh}" />
            </td>
            <td><select name="qqgzs[8].pfzt"
                        class="form-control required" value="${qqgzs[8].pfzt}">
                 <option value="0" <c:if test="${qqgzs[8].pfzt == '0'}">selected</c:if>/>办理中
                 <option value="1" <c:if test="${qqgzs[8].pfzt == '1'}">selected</c:if>/>已办结
            </select></td>
            <%--<td><input name="qqgzs[8].pfwj" htmlEscape="false"
                class="form-control " value="${qqgzs[8].pfwj}" />
            </td>--%>
 			<td>
            	<c:choose>
	            	<c:when test="${qqgzs[8].fileId != null&&qqgzs[8].fileId != '-1'}">
	            	<a onclick="yuLan('${qqgzs[8].fileId}','${qqgzs[8].xmjbxx.id}');" >查看</a>
	            	</c:when>
	            	<c:otherwise>
	            	<a style="cursor: not-allowed;opacity: 0.5">查看</a>
	            	</c:otherwise>
	   			</c:choose>
           	</td>
        </tr>
        <tr>
            <td>项目核准<input type="hidden"
                                                     name="qqgzs[9].spsx" value="10" />
            </td>
            <td><input name="qqgzs[9].pfdw" htmlEscape="false"
                       class="form-control " value="${qqgzs[9].pfdw}" />
            </td>
            <td><input id="qqgzs_9_pfsj" name="qqgzs[9].pfsj"
                       type="text" maxlength="20"
                       class="laydate-icon form-control layer-date "
                       value='<fmt:formatDate value="${qqgzs[9].pfsj}" pattern="yyyy-MM-dd"/>' />
            </td>
            <td><input name="qqgzs[9].pfwjbt" htmlEscape="false"
                       class="form-control " value="${qqgzs[9].pfwjbt}" />
            </td>
            <td><input name="qqgzs[9].pfwh" htmlEscape="false"
                       class="form-control " value="${qqgzs[9].pfwh}" />
            </td>
            <td><select name="qqgzs[9].pfzt"
                        class="form-control required" value="${qqgzs[9].pfzt}">
                 <option value="0" <c:if test="${qqgzs[9].pfzt == '0'}">selected</c:if>/>办理中
                 <option value="1" <c:if test="${qqgzs[9].pfzt == '1'}">selected</c:if>/>已办结
            </select></td>
            <%--<td><input name="qqgzs[9].pfwj" htmlEscape="false"
                class="form-control " value="${qqgzs[9].pfwj}" />
            </td>--%>
            <td>
            	<c:choose>
	            	<c:when test="${qqgzs[9].fileId != null&&qqgzs[9].fileId != '-1'}">
	            	<a onclick="yuLan('${qqgzs[9].fileId}','${qqgzs[9].xmjbxx.id}');" >查看</a>
	            	</c:when>
	            	<c:otherwise>
	            	<a style="cursor: not-allowed;opacity: 0.5">查看</a>
	            	</c:otherwise>
	   			</c:choose>
           	</td>
        </tr>
        <tr>
            <td>项目备案<input type="hidden"
                                                     name="qqgzs[10].spsx" value="11" />
            </td>
            <td><input name="qqgzs[10].pfdw" htmlEscape="false"
                       class="form-control " value="${qqgzs[10].pfdw}" />
            </td>
            <td><input id="qqgzs_10_pfsj" name="qqgzs[10].pfsj"
                       type="text" maxlength="20"
                       class="laydate-icon form-control layer-date "
                       value='<fmt:formatDate value="${qqgzs[10].pfsj}" pattern="yyyy-MM-dd"/>' />
            </td>
            <td><input name="qqgzs[10].pfwjbt" htmlEscape="false"
                       class="form-control " value="${qqgzs[10].pfwjbt}" />
            </td>
            <td><input name="qqgzs[10].pfwh" htmlEscape="false"
                       class="form-control " value="${qqgzs[10].pfwh}" />
            </td>
            <td><select name="qqgzs[10].pfzt"
                        class="form-control required" value="${qqgzs[10].pfzt}">
                 <option value="0" <c:if test="${qqgzs[10].pfzt == '0'}">selected</c:if>/>办理中
                 <option value="1" <c:if test="${qqgzs[10].pfzt == '1'}">selected</c:if>/>已办结
            </select></td>
            <%--<td><input name="qqgzs[10].pfwj" htmlEscape="false"
                class="form-control " value="${qqgzs[10].pfwj}" />
            </td>--%>
            <td>
            	<c:choose>
	            	<c:when test="${qqgzs[10].fileId != null&&qqgzs[10].fileId != '-1'}">
	            	<a onclick="yuLan('${qqgzs[10].fileId}','${qqgzs[10].xmjbxx.id}');" >查看</a>
	            	</c:when>
	            	<c:otherwise>
	            	<a style="cursor: not-allowed;opacity: 0.5">查看</a>
	            	</c:otherwise>
	   			</c:choose>
           	</td>
        </tr>
        <tr>
            <td>资金申请报告<input type="hidden" name="qqgzs[11].spsx"
                             value="12" />
            </td>
            <td><input name="qqgzs[11].pfdw" htmlEscape="false"
                       class="form-control " value="${qqgzs[11].pfdw}" />
            </td>
            <td><input id="qqgzs_11_pfsj" name="qqgzs[11].pfsj"
                       type="text" maxlength="20"
                       class="laydate-icon form-control layer-date "
                       value='<fmt:formatDate value="${qqgzs[11].pfsj}" pattern="yyyy-MM-dd"/>' />
            </td>
            <td><input name="qqgzs[11].pfwjbt" htmlEscape="false"
                       class="form-control " value="${qqgzs[11].pfwjbt}" />
            </td>
            <td><input name="qqgzs[11].pfwh" htmlEscape="false"
                       class="form-control " value="${qqgzs[11].pfwh}" />
            </td>
            <td><select name="qqgzs[11].pfzt"
                        class="form-control required" value="${qqgzs[11].pfzt}">
               <option value="0" <c:if test="${qqgzs[11].pfzt == '0'}">selected</c:if>/>办理中
               <option value="1" <c:if test="${qqgzs[11].pfzt == '1'}">selected</c:if>/>已办结
            </select></td>
            <%--<td><input name="qqgzs[11].pfwj" htmlEscape="false"
                class="form-control " value="${qqgzs[11].pfwj}" />
            </td>--%>
             <td>
            	<c:choose>
	            	<c:when test="${qqgzs[11].fileId != null&&qqgzs[11].fileId != '-1'}">
	            	<a onclick="yuLan('${qqgzs[11].fileId}','${qqgzs[11].xmjbxx.id}');" >查看</a>
	            	</c:when>
	            	<c:otherwise>
	            	<a style="cursor: not-allowed;opacity: 0.5">查看</a>
	            	</c:otherwise>
	   			</c:choose>
           	</td>
        </tr>
        <tr>
            <td>开工许可证<input type="hidden" name="qqgzs[12].spsx"
                            value="13" />
            </td>
            <td><input name="qqgzs[12].pfdw" htmlEscape="false"
                       class="form-control " value="${qqgzs[12].pfdw}" />
            </td>
            <td><input id="qqgzs_12_pfsj" name="qqgzs[12].pfsj"
                       type="text" maxlength="20"
                       class="laydate-icon form-control layer-date "
                       value='<fmt:formatDate value="${qqgzs[12].pfsj}" pattern="yyyy-MM-dd"/>' />
            </td>
            <td><input name="qqgzs[12].pfwjbt" htmlEscape="false"
                       class="form-control " value="${qqgzs[12].pfwjbt}" />
            </td>
            <td><input name="qqgzs[12].pfwh" htmlEscape="false"
                       class="form-control " value="${qqgzs[12].pfwh}" />
            </td>
            <td><select name="qqgzs[12].pfzt"
                        class="form-control required" value="${qqgzs[12].pfzt}">
                 <option value="0" <c:if test="${qqgzs[12].pfzt == '0'}">selected</c:if>/>办理中
                 <option value="1" <c:if test="${qqgzs[12].pfzt == '1'}">selected</c:if>/>已办结
            </select></td>
            <%--<td><input name="qqgzs[12].pfwj" htmlEscape="false"
                class="form-control " value="${qqgzs[12].pfwj}" />
            </td>--%>
            <td>
            	<c:choose>
	            	<c:when test="${qqgzs[12].fileId != null&&qqgzs[12].fileId != '-1'}">
	            	<a onclick="yuLan('${qqgzs[12].fileId}','${qqgzs[12].xmjbxx.id}');" >查看</a>
	            	</c:when>
	            	<c:otherwise>
	            	<a style="cursor: not-allowed;opacity: 0.5">查看</a>
	            	</c:otherwise>
	   			</c:choose>
           	</td>
        </tr>
        <tr>
            <td>施工许可证<input type="hidden" name="qqgzs[13].spsx"
                            value="14" />
            </td>
            <td><input name="qqgzs[13].pfdw" htmlEscape="false"
                       class="form-control " value="${qqgzs[13].pfdw}" />
            </td>
            <td><input id="qqgzs_13_pfsj" name="qqgzs[13].pfsj"
                       type="text" maxlength="20"
                       class="laydate-icon form-control layer-date "
                       value='<fmt:formatDate value="${qqgzs[13].pfsj}" pattern="yyyy-MM-dd"/>' />
            </td>
            <td><input name="qqgzs[13].pfwjbt" htmlEscape="false"
                       class="form-control " value="${qqgzs[13].pfwjbt}" />
            </td>
            <td><input name="qqgzs[13].pfwh" htmlEscape="false"
                       class="form-control " value="${qqgzs[13].pfwh}" />
            </td>
            <td><select name="qqgzs[13].pfzt"
                        class="form-control required" value="${qqgzs[13].pfzt}">
               <option value="0" <c:if test="${qqgzs[13].pfzt == '0'}">selected</c:if>/>办理中
               <option value="1" <c:if test="${qqgzs[13].pfzt == '1'}">selected</c:if>/>已办结
            </select></td>
            <%--<td><input name="qqgzs[13].pfwj" htmlEscape="false"
                class="form-control " value="${qqgzs[13].pfwj}" />
            </td>--%>
            <td>
            	<c:choose>
	            	<c:when test="${qqgzs[13].fileId != null&&qqgzs[13].fileId != '-1'}">
	            	<a onclick="yuLan('${qqgzs[13].fileId}','${qqgzs[13].xmjbxx.id}');" >查看</a>
	            	</c:when>
	            	<c:otherwise>
	            	<a style="cursor: not-allowed;opacity: 0.5">查看</a>
	            	</c:otherwise>
	   			</c:choose>
           	</td>
        </tr>
        <tr>
            <td>施工图审查<input type="hidden" name="qqgzs[14].spsx"
                            value="15" />
            </td>
            <td><input name="qqgzs[14].pfdw" htmlEscape="false"
                       class="form-control " value="${qqgzs[14].pfdw}" />
            </td>
            <td><input id="qqgzs_14_pfsj" name="qqgzs[14].pfsj"
                       type="text" maxlength="20"
                       class="laydate-icon form-control layer-date "
                       value='<fmt:formatDate value="${qqgzs[14].pfsj}" pattern="yyyy-MM-dd"/>' />
            </td>
            <td><input name="qqgzs[14].pfwjbt" htmlEscape="false"
                       class="form-control " value="${qqgzs[14].pfwjbt}" />
            </td>
            <td><input name="qqgzs[14].pfwh" htmlEscape="false"
                       class="form-control " value="${qqgzs[14].pfwh}" />
            </td>
            <td><select name="qqgzs[14].pfzt"
                        class="form-control required" value="${qqgzs[14].pfzt}">
                 <option value="0" <c:if test="${qqgzs[14].pfzt == '0'}">selected</c:if>/>办理中
                 <option value="1" <c:if test="${qqgzs[14].pfzt == '1'}">selected</c:if>/>已办结
            </select></td>
            <%--<td><input name="qqgzs[14].pfwj" htmlEscape="false"
                class="form-control " value="${qqgzs[14].pfwj}" />
            </td>--%>
            <td>
            	<c:choose>
	            	<c:when test="${qqgzs[14].fileId != null&&qqgzs[14].fileId != '-1'}">
	            	<a onclick="yuLan('${qqgzs[14].fileId}','${qqgzs[14].xmjbxx.id}');" >查看</a>
	            	</c:when>
	            	<c:otherwise>
	            	<a style="cursor: not-allowed;opacity: 0.5">查看</a>
	            	</c:otherwise>
	   			</c:choose>
           	</td>
        </tr>
        <tr>
            <td>消防设计审查<input type="hidden" name="qqgzs[15].spsx"
                             value="16" />
            </td>
            <td><input name="qqgzs[15].pfdw" htmlEscape="false"
                       class="form-control " value="${qqgzs[15].pfdw}" />
            </td>
            <td><input id="qqgzs_15_pfsj" name="qqgzs[15].pfsj"
                       type="text" maxlength="20"
                       class="laydate-icon form-control layer-date "
                       value='<fmt:formatDate value="${qqgzs[15].pfsj}" pattern="yyyy-MM-dd"/>' />
            </td>
            <td><input name="qqgzs[15].pfwjbt" htmlEscape="false"
                       class="form-control " value="${qqgzs[15].pfwjbt}" />
            </td>
            <td><input name="qqgzs[15].pfwh" htmlEscape="false"
                       class="form-control " value="${qqgzs[15].pfwh}" />
            </td>
            <td style="width:90px"><select name="qqgzs[15].pfzt"
                        class="form-control required" value="${qqgzs[15].pfzt}">
                 <option value="0" <c:if test="${qqgzs[15].pfzt == '0'}">selected</c:if>/>办理中
                 <option value="1" <c:if test="${qqgzs[15].pfzt == '1'}">selected</c:if>/>已办结
            </select></td>
            <%--<td><input name="qqgzs[15].pfwj" htmlEscape="false"
                class="form-control " value="${qqgzs[15].pfwj}" />
            </td>--%>
             <td style="width:30px">
            	<c:choose>
	            	<c:when test="${qqgzs[15].fileId != null&&qqgzs[15].fileId != '-1'}">
	            	<a onclick="yuLan('${qqgzs[15].fileId}','${qqgzs[15].xmjbxx.id}');" >查看</a>
	            	</c:when>
	            	<c:otherwise>
	            	<a style="cursor: not-allowed;opacity: 0.5">查看</a>
	            	</c:otherwise>
	   			</c:choose>
           	</td>
        </tr>

        </tbody>
    </table>
    <p style="width:500px;">
        <font color="red">*项目建议书批复、可研报告批复、初步设计、项目核准、项目备案这五列信息，请您尽量根据实际情况进行填写，否则可能影响后面投资</font>
    </p>
</div>
<script type="text/javascript">
function yuLan(fileId,xmjbxx_id){
  debugger;
		//fileType=1是在本地，3是在ftp服务器
        $.post("/a/xmjbxx/xmjbxx/yuLan",{"fileNo":fileId,"xmjbxx_id":xmjbxx_id},function(data) {
    	  //window.location.href="/批复文件预览.jsp?filepath="+data;
    	  if(data==0){
    		  alert("该文件不纯在，请联系管理员");
    	  }else{
    		  window.open("/a/xmjbxx/xmjbxx/yuLan2?filepath="+data);
    	  }
    	  
      }); 
}
</script>