<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
<title>项目基本信息管理</title>
<meta name="decorator" content="default" />
<link rel="stylesheet" href="${ctxStatic}/module/xmjbxx/css/xmjbxxForm.css" type="text/css">
<script src="${ctxStatic}/common/jquery.validate.custom.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctxStatic}/module/xmjbxx/xmjbxxForm.js"></script>
<script type="text/javascript" src="${ctxStatic}/module/xmjbxx/xmjbxxFormSsqk.js"></script>
<script type="text/javascript" src="${ctxStatic}/module/xmjbxx/xmjbxxFormZdxmk.js"></script>
<script src="${ctxStatic}/module/alert/jquery.alerts.js"></script>
<link href="${ctxStatic}/module/alert/jquery.alerts.css" rel="stylesheet" type="text/css"/>
<c:set var="sfsqzxjsjjDisplayValue" value="${xmjbxx.sfsqzxjsjj == '1' ? '' : 'display:none;'}"/>
<style type="text/css">
	.one {
    float: left;
    width: 10%;
    height: 30px;
    text-align: center;
    line-height: 30px;
    padding-bottom: 0;
    list-style-type: none;
}
	.ck{
		font-size: 12px;
		color: #fff;
		background: #0071ce;
		display:inline-block;
	    height: 30px; 
	    line-height: 20px;
	    text-align: center;
	    width: 30px;
    	border: none;
    	border-radius: 6px;
   		cursor: pointer;
    	font-family: 'Microsoft YaHei';
	}
</style>
<script type="text/javascript">
</script>
</head>
<body class="hideScroll" style="padding-top: 20px;">
	<%-- <input id="xyflag" type="text" value="${xyflag}" hidden="hidden"> --%>
	<div id="test" style="height:30px; position: fixed;top:0px; width: 90%; background-color: #fff; z-index: 9999">
		<ul>
			<li name="fen1" class=" one two">基本信息</li>
			<li name="fen2" class=" one">投资情况</li>
			<li name="fen3" class=" one">前期工作</li>
			<li name="fen6" class=" one">其他信息</li>			
			<li name="fen5" class=" one">实施情况</li>
			<li name="fen7" class=" one" style="display: none">省基建项目</li>
			<li name="fen4" class=" one" style="display: none">5818项目信息</li>
			<!-- <li name="fen9" id="qqxy" class=" one" >企业信用</li> -->
		</ul>
	</div>
	<br />
	<sys:message content="${message}" />
	<fieldset id="xmjbxxForm" style=" width: 90%;margin:auto;top:20px">
		<%-- 项目基本信息 start --%>
		<form:form id="inputForm" modelAttribute="xmjbxx" action="#"
			method="post" class="form-horizontal">
			<form:hidden path="id" />
			<div class="tz_sub" id="fen1" name="inputForm">
				<table
					class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
					<tbody>
						<tr>
							<td class="width-15 active" onclick="ceshi()"><label
								class="pull-right">重大库编码：</label></td>
							<td class="width-35"><form:input path="zdkbmgj"
									htmlEscape="false" maxlength="32" class="form-control "
									disabled="true" />
							</td>
							<td class="width-15 active"><label class="pull-right">审批监管平台代码：</label>
							</td>
							<td class="width-15">
								<div class="form-inline">
									<form:input path="spjgptdm" htmlEscape="false" maxlength="32"
										class="form-control " cssStyle="width:230px;" disabled="true" />
									<input type="button" class="btn btn-primary "
										style="width:60px;" value="验证" onclick="checkSpjgptdm()">
									<%--<input type="button" value="测试" onclick="ceshi()">--%>
								</div></td>
						</tr>
						<tr>
							<td class="width-15 active"><label class="pull-right"><font
									color="red">*</font>项目名称：</label></td>
							<td class="width-35"><form:input path="xmmc"
									htmlEscape="false" maxlength="200"
									class="form-control required" disabled="true" /></td>
							<td class="width-15 active"><label class="pull-right"><font
									color="red">*</font>项目类型：</label></td>
							<td class="width-35"><form:select path="xmlx"
									class="form-control required" disabled="true">
									<form:option value="" label="" />
									<form:options items="${fns:getDictList('xmlx')}"
										itemLabel="label" itemValue="value" htmlEscape="false"
										disabled="true" />
								</form:select>
							</td>
						</tr>
						<tr>
							<td class="width-15 active"><label class="pull-right"><font
									color="red">*</font>建设性质：</label></td>
							<td class="width-35"><form:select path="jsxz"
									class="form-control required" disabled="true">
									<form:option value="" label="" />
									<form:options items="${fns:getDictList('jsxz')}"
										itemLabel="label" itemValue="value" htmlEscape="false"
										disabled="true" />
								</form:select>
							</td>
							<td class="width-15 active"><label class="pull-right">
									<font color="red">*</font>国别：</label></td>
							<td class="width-35"><form:select path="gb"
									class="form-control required" disabled="true">
									<form:option value="1" label="中国" />
									<form:options items="${fns:getDictList('gb')}"
										itemLabel="label" itemValue="value" htmlEscape="false" />
								</form:select></td>
						</tr>

						<tr>
							<td class="width-15 active"><label class="pull-right"><font
									color="red">*</font>建设地点：</label>
							</td>
							<td class="width-35"><sys:treeselect id="jsdd" name="jsdd"
									value="${xmjbxx.jsdd}" labelName="jsddStr"
									labelValue="${fns:getTreeName(xmjbxx.jsdd,'area')}"
									title="建设地点" url="/sys/area/treeData"
									cssClass="form-control required m-s" allowClear="true"
									disabled="disabled" /></td>
							<!-- 
						<td class="width-15 active"><label class="pull-right">建设地点详情：</label></td>
						<td class="width-35">
                            <form:select path="jsddxq" class="form-control" disabled="true">
								<form:option value="" label="" />
								<form:options items="${fns:getDictList('jsddxq')}" itemLabel="label" itemValue="value" htmlEscape="false" />
							</form:select>
                        </td>
                         -->
						</tr>
						<tr>
							<td class="width-15 active"><label class="pull-right"><font
									color="red">*</font>建设详细地址：</label></td>
							<td class="width-35" colspan="3"><form:textarea
									path="jsxxdz" htmlEscape="false" rows="4" maxlength="1024"
									class="form-control required" disabled="true" />
							</td>
						</tr>
						<tr>
							<td class="width-15 active"><label class="pull-right"><font
									color="red">*</font>国标行业：</label></td>
							<td class="width-35"><sys:treeselect id="gbhy" name="gbhy"
									value="${xmjbxx.gbhy}" labelName="fhghStr"
									notAllowSelectParent="true"
									labelValue="${fns:getTreeDictValue(xmjbxx.gbhy)}" title="国标行业"
									url="/sys/treeDict/treeData?type=gbhy" extId=""
									cssClass="form-control required" /></td>

						</tr>
						<tr>
							<td class="width-15 active"><label class="pull-right"><font
									color="red">*</font>所属行业：</label></td>
							<td class="width-35"><sys:treeselect id="sshy" name="sshy"
									value="${xmjbxx.sshy}" labelName="sshyStr"
									notAllowSelectParent="true"
									labelValue="${fns:getTreeDictValue(xmjbxx.sshy)}" title="所属行业"
									url="/sys/treeDict/treeData?type=sshy"
									cssClass="form-control required" /></td>
							<td class="width-15 active"><label class="pull-right"><font
									color="red">*</font>总投资(万元)：</label></td>
							<td class="width-35"><form:input path="ztz" id="jbxxztz"
									htmlEscape="false" class="form-control required"
									disabled="true" />
							</td>

						</tr>
						<tr>
							<td class="width-15 active"><label class="pull-right"><font
									color="red">*</font>拟开工年份：</label></td>
							<td class="width-35"><input id="starttimen"
								name="starttimen" type="text"
								class="laydate-icon form-control layer-date required"
								value="${xmjbxx.starttimen}" disabled="true" /></td>
							<td class="width-15 active"><label class="pull-right"><font
									color="red">*</font>拟开工月份：</label></td>
							<td><form:select path="starttimey"
									class="form-control required" disabled="true">
									<form:option value="01" label="1 月" />
									<form:option value="02" label="2 月" />
									<form:option value="03" label="3 月" />
									<form:option value="04" label="4 月" />
									<form:option value="05" label="5 月" />
									<form:option value="06" label="6 月" />
									<form:option value="07" label="7 月" />
									<form:option value="08" label="8 月" />
									<form:option value="09" label="9 月" />
									<form:option value="10" label="10 月" />
									<form:option value="11" label="11 月" />
									<form:option value="12" label="12 月" />
								</form:select>
							</td>
						</tr>
						<tr>
							<td class="width-15 active"><label class="pull-right"><font
									color="red">*</font>拟建成年份：</label>
							</td>
							<td class="width-35"><input id="endtime" name="endtime"
								type="text"
								class="laydate-icon form-control layer-date required"
								value="${xmjbxx.endtime}" disabled="true" /></td>
							<td class="width-15 active"><label class="pull-right">项目所处阶段：</label>
							</td>
							<td class="width-35"><input id="xmscjd" name="xmscjd"
								type="text" class="laydate-icon form-control layer-date "
								disabled value="${xmjbxx.xmscjdStr}"
								placeholder="选择“拟开工年份”，自动计算所处阶段" /></td>
						</tr>
						<tr>

							<td class="width-15 active"><label class="pull-right"><font
									color="red">*</font>主要建设规模：</label></td>
							<td class="width-35" colspan="3"><form:textarea
									path="zyjsgm" htmlEscape="false" rows="4"
									class="form-control required" disabled="true" />
							</td>

						</tr>
						<tr>
							<td class="width-15 active"><label class="pull-right">量化建设规模：</label>
							</td>
							<td id="lhjsgmTd" class="width-35" colspan="3"><c:choose>
									<c:when test="${null != xmjbxx.lhjsgm}">
										<c:forEach items="${xmjbxx.lhjsgmMapList}" var="lhjsgmMap"
											varStatus="status">
											<div style="margin-top:6px;">
												<span style="margin-left:5px;">类别：</span> <select
													name="lhjsgm" style="width:350px;"
													value="${lhjsgmMap.type}" class="form-control"
													disabled="true">
													<option value=""></option>
													<c:forEach items="${fns:getDictList('lhjsgm')}"
														var="lhjsgmDict">
														<option value="${lhjsgmDict.value}"
															<c:if test="${lhjsgmDict.value == lhjsgmMap.type}">selected</c:if>>${lhjsgmDict.label}</option>
													</c:forEach>
												</select> <span style="margin-left:15px;">数值：</span> <span><input
													name="lhjsgmValue" maxlength="32" class="form-control"
													style="width:100px" value="${lhjsgmMap.value}"
													disabled="true" />
												</span> </span>
												<c:if test="${status.first}">
													<button type="button" class="btn btn-primary"
														onclick="addLhjsgm()" disabled="disabled">
														<i class="fa fa-plus"></i> 新增
													</button>
												</c:if>
												<c:if test="${!status.first}">
													<button type="button" class="btn btn-danger"
														onclick="minusLhjsgm(this)" disabled="disabled">
														<i class="fa fa-minus"></i> 删除
													</button>
												</c:if>
											</div>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<span> <span style="margin-left:5px;">类别：</span> <select
											name="lhjsgm" style="width:350px;" value=""
											class="form-control">
												<option value=""></option>
												<c:forEach items="${fns:getDictList('lhjsgm')}"
													var="lhjsgmDict">
													<option value="${lhjsgmDict.value}">${lhjsgmDict.label}</option>
												</c:forEach>
										</select> <span style="margin-left:15px;">数值：</span> <span><input
												name="lhjsgmValue" maxlength="32" class="form-control"
												style="width:100px" value="" />
										</span> </span>
										<button type="button" class="btn btn-primary"
											onclick="addLhjsgm()">
											<i class="fa fa-plus"></i> 新增
										</button>
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td class="width-15 active"><label class="pull-right"><font
									color="red">*</font>年度主要建设内容：</label></td>
							<td class="width-35" colspan="3"><form:textarea
									path="ndzhjsnr" htmlEscape="false" rows="4" maxlength="2000"
									class="form-control required"
									onkeyup="javascript:checkWord(this);"
									onmousedown="javascript:checkWord(this);"
									placeholder="请输入...(1000字以内)" /> <font color="red">*还可以输入<span
									style="font-family: Georgia; font-color:red;font-size: 13px;"
									id="wordCheck">1000</span>个字 </font>
							</td>
						</tr>
						<tr>
							<td class="width-15 active"><label class="pull-right">备注：</label>
							</td>
							<td class="width-35" colspan="3"><form:textarea path="bz"
									htmlEscape="false" rows="4" maxlength="500"
									class="form-control " />
							</td>

						</tr>

						<tr>
							<td colspan="3"><font color="#477cb3">|入库依据</font>
							<td>
						</tr>
						<!-- 
					<tr>
						<td class="width-15 active"><label class="pull-right"><font
								color="red">*</font>是否申请中央预算内资金：</label></td>
						<td class="width-35">
							<form:select path="sfsqzyysnzj" class="form-control required">
								<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false" />
							</form:select>
						</td>
						<td class="width-15 active"><label class="pull-right"><font
								color="red">*</font>项目隶属关系：</label></td>
						<td class="width-35">
							<form:select path="xmlsgx" class="form-control required">
								<form:options items="${fns:getDictList('xmlsgx')}" itemLabel="label" itemValue="value" htmlEscape="false" />
							</form:select>
						</td>
					</tr>
					 -->
						<!-- 
					<tr>
						<td class="width-15 active"><label class="pull-right">日常监管直接责任单位：</label>
						</td>
						<td class="width-35"><form:input path="rcjgzjzrdw"
								htmlEscape="false" maxlength="256" class="form-control " /></td>
						<td class="width-15 active"><label class="pull-right">日常监管直接责任单位责任人：</label>
						</td>
						<td class="width-35"><form:input path="rcjgzrdwjgzrr"
								htmlEscape="false" maxlength="64" class="form-control " /></td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">日常监管直接责任单位联系电话：</label>
						</td>
						<td class="width-35"><form:input path="rcjgzjzrdwlxdh"
								htmlEscape="false" maxlength="64" class="form-control isMobile" /></td>
					</tr>
					 -->

						<tr>

							<td class="width-15 active"><label class="pull-right">符合产业政策：</label>
							</td>
							<td class="width-35"><form:input path="fhcyzc"
									htmlEscape="false" maxlength="64" class="form-control " />
							</td>
							<td class="width-15 active"><label class="pull-right">符合规划：</label>
							</td>
							<td class="width-35"><sys:treeselect id="fhgh" name="fhgh"
									value="${xmjbxx.fhgh}" labelName="fhghStr"
									notAllowSelectParent="true"
									labelValue="${fns:getTreeDictValue(xmjbxx.fhgh)}" title="菜单"
									url="/sys/treeDict/treeData?type=fhgh" extId=""
									cssClass="form-control required" />
							</td>
						</tr>
						<tr>
							<td class="width-15 active"><label class="pull-right">符合重大战略：</label>
							</td>
							<td class="width-35"><form:select path="fhzdzn"
									class="form-control ">
									<form:option value="" label="" />
									<form:options items="${fns:getDictList('fhzdzl')}"
										itemLabel="label" itemValue="value" htmlEscape="false" />
								</form:select>
							</td>
							<td class="width-15 active"><label class="pull-right">符合政府投资方向：</label>
							</td>
							<td class="width-35"><sys:treeselect id="fhzftzfx"
									name="fhzftzfx" value="${xmjbxx.fhzftzfx}"
									labelName="fhzftzfxStr"
									labelValue="${fns:getTreeDictValue(xmjbxx.fhzftzfx)}"
									title="菜单" notAllowSelectParent="true"
									url="/sys/treeDict/treeData?type=fhzftzfx" extId=""
									cssClass="form-control " />
							</td>
						</tr>
						<tr>
							<td class="width-15 active"><label class="pull-right"><font
									color="red">*</font>项目法人单位：</label></td>
							<td class="width-35"><form:input path="xmfrdw"
									htmlEscape="false" maxlength="256"
									class="form-control required" /></td>
						</tr>
						<tr>
							<td><font color="#477cb3">|项目责任人</font></td>
						</tr>
						<tr>

							<td class="width-15 active"><label class="pull-right"><font
									color="red">*</font>项目责任人姓名：</label></td>
							<td class="width-35"><form:input path="zrname"
									htmlEscape="false" maxlength="64" class="form-control required"
									cssClass="form-control required" /></td>
							<td class="width-15 active"><label class="pull-right">项目责任人手机：</label>
							</td>
							<td class="width-35"><form:input path="zrphone"
									htmlEscape="false" maxlength="64"
									class="form-control required isMobile" cssClass="form-control " />
							</td>
						</tr>
						<tr>
							<td class="width-15 active"><label class="pull-right">项目责任人电话：</label>
							</td>
							<td class="width-35"><form:input path="zrcall"
									htmlEscape="false" maxlength="64" class="form-control isCall" />
							</td>
							<td class="width-15 active"><label class="pull-right">项目责任人邮箱：</label>
							</td>
							<td class="width-35"><form:input path="zremail"
									htmlEscape="false" maxlength="64" class="form-control  email" />
							</td>
						</tr>

						<tr>
							<td><font color="#477cb3">|项目联系人一</font></td>
						</tr>
						<tr>
							<td class="width-15 active"><label class="pull-right"><font
									color="red">*</font>项目联系人姓名：</label></td>
							<td class="width-35"><form:input path="lxnameone"
									htmlEscape="false" maxlength="64" class="form-control required"
									cssClass="form-control required" /></td>
							<td class="width-15 active"><label class="pull-right"><font
									color="red">*</font>项目联系人手机：</label></td>
							<td class="width-35"><form:input path="lxphoneone"
									htmlEscape="false" maxlength="64"
									class="form-control required isMobile"
									cssClass="form-control required" /></td>
						</tr>
						<tr>
							<td class="width-15 active"><label class="pull-right">项目联系人电话：</label>
							</td>
							<td class="width-35"><form:input path="lxcallone"
									htmlEscape="false" maxlength="64" class="form-control isCall" />
							</td>
							<td class="width-15 active"><label class="pull-right">项目联系人邮箱：</label>
							</td>
							<td class="width-35"><form:input path="lxemailone"
									htmlEscape="false" maxlength="64" class="form-control  email" />
							</td>
						</tr>

						<tr>
							<td><font color="#477cb3">|项目联系人二</font></td>
						</tr>
						<tr>

							<td class="width-15 active"><label class="pull-right">项目联系人姓名：</label>
							</td>
							<td class="width-35"><form:input path="lxnametwo"
									htmlEscape="false" maxlength="64" class="form-control " />
							</td>
							<td class="width-15 active"><label class="pull-right">项目联系人手机：</label>
							</td>
							<td class="width-35"><form:input path="lxphonetwo"
									htmlEscape="false" maxlength="64" class="form-control isMobile" />
							</td>
						</tr>
						<tr>

							<td class="width-15 active"><label class="pull-right">项目联系人电话：</label>
							</td>
							<td class="width-35"><form:input path="lxcalltwo"
									htmlEscape="false" maxlength="64" class="form-control isCall" />
							</td>
							<td class="width-15 active"><label class="pull-right">项目联系人邮箱：</label>
							</td>
							<td class="width-35"><form:input path="lxemailtwo"
									htmlEscape="false" maxlength="64" class="form-control  email" />
							</td>
						</tr>
						<tr>
							<td><font color="#477cb3">|审核辅助标识</font></td>
						</tr>
						<tr>
							<td class="width-15 active"><label class="pull-right">审核辅助标识01：</label>
							</td>
							<td class="width-35"><form:input path="shfzbsone"
									htmlEscape="false" maxlength="64" class="form-control " />
							</td>
							<td class="width-15 active"><label class="pull-right">审核辅助标识02：</label>
							</td>
							<td class="width-35"><form:input path="shfzbstwo"
									htmlEscape="false" maxlength="64" class="form-control " />
							</td>
						</tr>
						<tr>
							<td class="width-15 active"><label class="pull-right">审核辅助标识03：</label>
							</td>
							<td class="width-35"><form:input path="shfzbsthree"
									htmlEscape="false" maxlength="64" class="form-control " />
							</td>

						</tr>
						<%--<tr>
						<td class="width-15 active"><label class="pull-right">项目排序：</label>
						</td>
						<td class="width-35"><form:input path="xmpx"
								htmlEscape="false" maxlength="64" class="form-control " /></td>
					</tr>--%>

					</tbody>
				</table>
			</div>
		</form:form>
		<%-- 项目基本信息 end --%>

		<%-- 投资情况 start --%>
		<form:form id="inputForm2" modelAttribute="xmjbxx" action="#"
			method="post" class="form-horizontal">
			<jsp:include page="include/xmjbxxFormTzqk.jsp"></jsp:include>
		</form:form>
		<%-- 投资情况 end --%>

		<%-- 前期工作 start --%>
		<form:form id="inputForm3" modelAttribute="xmjbxx" action="#"
			method="post" class="form-horizontal">
			<jsp:include page="include/xmjbxxFormQqgz.jsp"></jsp:include>
		</form:form>
		<%-- 前期工作 end --%>

		<%-- 省基建信息 start --%>
		<form:form id="inputForm7" modelAttribute="xmjbxx" action="#"
			method="post" class="form-horizontal">
			<div class="tz_sub" id="fen7" name="inputForm">
				<div>
					<font color="#477cb3">| 省基建信息</font>
				</div>
			</div>
		</form:form>
		<%-- 省基建信息 end --%>

		<%-- 5818项目 start --%>
		<form:form id="inputForm4" modelAttribute="xmjbxx" action="#"
			method="post" class="form-horizontal">
			<div class="tz_sub" id="fen4" name="inputForm"></div>
		</form:form>
		<%-- 其他信息 end --%>

		<%-- 实施情况 start --%>
		<form:form id="inputForm5" modelAttribute="curSsqk" action="#"
			method="post" class="form-horizontal">
			<jsp:include page="include/xmjbxxFormSsqk.jsp"></jsp:include>
		</form:form>
		<%-- 实施情况 end --%>

		<%-- 其他信息重点项目信息 start --%>
		<form:form id="inputForm6" modelAttribute="cInsBusinessZdxmk"
			action="#" method="post" class="form-horizontal">
			<jsp:include page="include/cInsBusinessZdxmkForm.jsp"></jsp:include>
		</form:form>
		<%-- 其他信息重点项目信息 end --%>
		<%-- 企业信用 start --%>
		<%-- <form:form id="inputForm9" class="form-horizontal">
			<jsp:include page="include/xmjbxxFormQyxy.jsp"></jsp:include>
		</form:form> --%>
		<%-- 企业信用 end --%>
	</fieldset>

	<div id="phoneInputFormDiv" style="display:none;padding:20px">
		<form id="phoneInputForm" action="#" method="post">
			<div style="margin: 30px 30px 0 30px;max-width:400px;">
				<div style="font-size: 14px;margin-bottom: 30px;"><span>请输入自治区在线审批监管平台经办人手机号码进行验证：</span></div>
				<div><input id="lxphoneoneInput" name="lxphoneoneInput" value="" class="form-control required isMobile" style="width:250px;" placeholder="经办人手机号码"></div>
			</div>
		</form>
	</div>
</body>

</html>
