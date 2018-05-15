<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<link rel="stylesheet" href="${ctxStatic}/module/xmjbxx/css/xmjbxxForm.css" type="text/css">
<script src="${ctxStatic}/common/jquery.validate.custom.js" type="text/javascript"></script>
<div class="tz_sub" id="fen6" name="inputForm">
		
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		
		<%--是否省基建项目--%>
		<div>
			<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
				<tr>
					<td class="width-15 active"><label class="pull-right"><font
							color="red">*</font>是否申报为省基建项目：</label>
					</td>
					<td class="width-35">
						<form:select path="sfsjjxm" class="form-control required">
							<form:options items="${fns:getDictList('yes_no')}"
									itemLabel="label" itemValue="value" htmlEscape="false" disabled="true"/>
						</form:select>
					</td>
				</tr>
			</table>
		</div>
		
		<%--是否申报5818项目--%>
		<div>
			<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
				<tr>
					<td class="width-15 active"><label class="pull-right"><font
							color="red">*</font>是否申报为5818项目：</label>
					</td>
					<td class="width-35">
						<form:select path="sfsbsbib" class="form-control required">
							<form:options items="${fns:getDictList('yes_no')}"
									itemLabel="label" itemValue="value" htmlEscape="false" disabled="true"/>
						</form:select>
					</td>
				</tr>
			</table>
			<div id="sfsbsbib_div">
				<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
					<tr >
						<td class="width-30 active"><label class="pull-right"><font
								color="red">*</font>2017年年度计划投资金额：</label>
						</td>
						<td class="width-20"><form:input path="ndjhtzje"
								htmlEscape="false" class="form-control required" /></td>
						<td class="width-30 active"><label class="pull-right"><font
								color="red">*</font>2018年年度计划投资金额：</label>
						</td>
						<td class="width-20"><form:input path="ndjhtzjet"
								htmlEscape="false" class="form-control required" /></td>
					</tr>
					<tr>	
						<td class="width-30 active"><label class="pull-right"><font
								color="red">*</font>所属领域：</label>
						</td>
						<td class="width-20">
							<%-- <form:input path="ssly" htmlEscape="false" class="form-control required" /> --%>
							<sys:treeselect id="ssly" name="ssly"
								value="${cInsBusinessZdxmk.ssly}" labelName="sslyStr"
								labelValue="${fns:getTreeDictValue(cInsBusinessZdxmk.ssly)}" title="菜单" notAllowSelectParent="true"
								url="/sys/treeDict/treeData?type=5818" extId=""
								cssClass="form-control required" />
						</td>
					</tr>
				</table>
			</div>
		</div>
		<%--是否省服务业重大项目--%>
		<div>
			<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
				<tr>
					<td class="width-15 active"><label class="pull-right"><font
							color="red">*</font>是否申报为省服务业重大项目：</label>
					</td>
					<td class="width-35">
						<form:select path="sfsfwyzdxm" class="form-control required">
							<form:options items="${fns:getDictList('yes_no')}"
									itemLabel="label" itemValue="value" htmlEscape="false" disabled="true"/>
						</form:select>
					</td>
				</tr>
			</table>
			<div id="fwyssly_div">
				<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
					<tr>	
						<td class="width-30 active"><label class="pull-right"><font
								color="red">*</font>省服务业所属领域：</label>
						</td>
						<td class="width-20">
							<sys:treeselect id="fwyssly" name="fwyssly"
								value="${cInsBusinessZdxmk.fwyssly}" labelName="fwysslyStr"
								labelValue="${fns:getTreeDictValue(cInsBusinessZdxmk.fwyssly)}" title="菜单" notAllowSelectParent="true"
								url="/sys/treeDict/treeData?type=fwyssly" extId=""
								cssClass="form-control required" />
						</td>
					</tr>
				</table>
			</div>
		</div>
		
		<%--是否是重点攻坚产业--%>
		<div>
			<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
				<tr id="sfzdgjcylx">
					<td class="width-15 active"><label class="pull-right"><font
							color="red">*</font>是否是重点攻坚产业：</label>
					</td>
					<td class="width-35">
                		<select name="sfzdgjcy" id="sfzdgjcy" value="${cInsBusinessZdxmk.sfzdgjcy}" style="box-shadow 0.15s ease-in-out 0s;width: 100%; font-size: 14px;background-color: #FFFFFF; border: 1px solid #e5e6e7;
                									border-radius: 1px;color: inherit;padding: 6px 12px;transition: border-color 0.15s ease-in-out 0s;">
	                        <option value="0">否</option>
	                        <option value="1">是</option>
               			</select>
				 	</td>
				</tr>
				<tr >
					<td class="width-15 active"><label class="pull-right"><font
							color="red">*</font>是否技术改造项目:</label>
					</td>
	                <td class="width-35">
	                	<form:select path="sfjsgzcy" class="form-control ">
							<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
	                </td>
              	</tr> 
				<tr id="sfszdgjcy">
					<td class="width-15 active"><label class="pull-right"><font
							color="red">*</font>省重点攻坚产业：</label>
					</td>
	                <td class="width-35">
	                	 <select name="szdgjcy" value="${cInsBusinessZdxmk.sfszdgjcy}" id="szdgjcy" style="box-shadow 0.15s ease-in-out 0s;width: 100%; font-size: 14px;background-color: #FFFFFF; border: 1px solid #e5e6e7;
	                	 							border-radius: 1px;color: inherit;padding: 6px 12px;transition: border-color 0.15s ease-in-out 0s;">
	                        <option value="0">是</option>
	                        <option value="1">否</option>
               			</select>       
	                </td>
              	</tr> 
              	
              	<tr id="sfxszdgjcy">
	           		<td class="width-15 active"><label class="pull-right"><font
							color="red">*</font>县市省重点攻坚产业：</label>
					</td>
	                <td class="width-35">
	                	 <select name="xszdgjcy" id="xszdgjcy" value="${cInsBusinessZdxmk.sfxszdgjcy}" style="box-shadow 0.15s ease-in-out 0s;width: 100%; font-size: 14px;background-color: #FFFFFF; border: 1px solid #e5e6e7;
	                	 							border-radius: 1px;color: inherit;padding: 6px 12px;transition: border-color 0.15s ease-in-out 0s;">
	                        <option value="0">否</option>
	                        <option value="1">是</option>
               			</select>       
	                </td>
              	</tr>
              	<tr id="tr_sgj">
	              	 <td class="width-15 active"><label class="pull-right"><font
							color="red">*</font>省重点攻坚产业类型：</label>
					</td>
		             <td class="width-35">
                		<select name="szdgjcylx" id="szdgjcylx" value="${cInsBusinessZdxmk.szdgjcylx}" style="box-shadow 0.15s ease-in-out 0s;width: 100%; font-size: 14px;background-color: #FFFFFF; border: 1px solid #e5e6e7;
                									border-radius: 1px;color: inherit;padding: 6px 12px;transition: border-color 0.15s ease-in-out 0s;">
	                    	<option value="" selected="selected"></option>
	                        <option value="1">能源业</option>
	                        <option value="2">健康养老业</option>
	                        <option value="3">装备制造业</option>
	                        <option value="4">新型材料业</option>
	                        <option value="5">电子信息业</option>
	                        <option value="6">酒业</option>
	                        <option value="7">建筑业</option>
	                        <option value="8">绿色食品业</option>
	                        <option value="9">高效种养业</option>
	                        <option value="10">物流业</option>
	                        <option value="11">旅游业</option>
	                        <option value="12">烟草业</option>
               			</select>
					 </td>
              	</tr>
              	<tr id="tr_xsgj">
              	   <td class="width-15 active"><label class="pull-right"><font
							color="red">*</font>市县重点攻坚产业类型：</label>
				   </td>
	               <td style="text-indent:0px;text-align: left;">
                		 <input type="text" id="sxzdgjcy" value="${cInsBusinessZdxmk.xszdgjcylx}" style="box-shadow 0.15s ease-in-out 0s;width: 100%; font-size: 14px;background-color: #FFFFFF; border: 1px solid #e5e6e7;
                		 							border-radius: 1px;color: inherit;padding: 6px 12px;transition: border-color 0.15s ease-in-out 0s,"  />
				   </td>
              	</tr>   
				
			</table>
		</div>
		
		<%--是否健康养老示范项目--%>
		<div>
			<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
				<tr id="">
					<td class="width-15 active"><label class="pull-right"><font
							color="red">*</font>是否是健康养老示范项目：</label>
					</td>
					<td class="width-35">
						<input type="hidden" id="xmjbxxid" value="${xmjbxx.id}"/>
						<input type="hidden" id="sfjkylxm_inp" value="${xmjbxx.sfjkylxm}"/>
                		<select name="sfjkylxm" id="sfjkylxm" value="" style="box-shadow 0.15s ease-in-out 0s;width: 100%; font-size: 14px;background-color: #FFFFFF; border: 1px solid #e5e6e7;
                									border-radius: 1px;color: inherit;padding: 6px 12px;transition: border-color 0.15s ease-in-out 0s;">
	                        <option value="0">否</option>
	                        <option value="1">是</option>
               			</select>
				 	</td>
				</tr>
				
				<tr id="jkyl_dwxz">
					<td class="width-15 active"><label class="pull-right"><font
							color="red">*</font>健康养老示范项目单位性质：</label>
					</td>
	                <td class="width-35">
	                	 <input type="hidden" id="jkyl_dwxz_sel_inp" value="${xmjbxx.jkyldwxz}"/>
	                	 <select name="jkyl_dwxz_sel" value="" id="jkyl_dwxz_sel" style="box-shadow 0.15s ease-in-out 0s;width: 100%; font-size: 14px;background-color: #FFFFFF; border: 1px solid #e5e6e7;
	                	 							border-radius: 1px;color: inherit;padding: 6px 12px;transition: border-color 0.15s ease-in-out 0s;">
	                        <option value="" selected="selected"></option>
							<option value="1">国有</option>
							<option value="2">民营</option>
							<option value="3">民办非</option>
							<option value="4">其他</option>
               			</select>       
	                </td>
              	</tr> 

              	<tr id="jkyl_xmfj">
	           		<td class="width-15 active"><label class="pull-right"><font
							color="red">*</font>健康养老示范项目项目分级：</label>
					</td>
	                <td class="width-35">
	                	 <input type="hidden" id="jkyl_xmfj_sel_inp" value="${xmjbxx.jkylxmfj}"/>
	                	 <select name="jkyl_xmfj_sel" id="jkyl_xmfj_sel" value="" style="box-shadow 0.15s ease-in-out 0s;width: 100%; font-size: 14px;background-color: #FFFFFF; border: 1px solid #e5e6e7;
	                	 							border-radius: 1px;color: inherit;padding: 6px 12px;transition: border-color 0.15s ease-in-out 0s;">
	                        <option value="" selected="selected"></option>
							<option value="1">省级</option>
							<option value="2">市级</option>
							<option value="3">县级</option>
               			</select>       
	                </td>
              	</tr>
              	<tr id="jkyl_xmlx">
	              	 <td class="width-15 active"><label class="pull-right"><font
							color="red">*</font>健康养老项目项目类型：</label>
					</td>
		             <td class="width-35">
		             	<input type="hidden" id="jkyl_xmlx_sel_inp" value="${xmjbxx.jkylxmlx}"/>
                		<select name="jkyl_xmlx_sel" id="jkyl_xmlx_sel" value="" style="box-shadow 0.15s ease-in-out 0s;width: 100%; font-size: 14px;background-color: #FFFFFF; border: 1px solid #e5e6e7;
                									border-radius: 1px;color: inherit;padding: 6px 12px;transition: border-color 0.15s ease-in-out 0s;">
	                    	<option value="" selected="selected"></option>
							<option value="1">居家社区</option>
							<option value="2">机构养老</option>
							<option value="3">基地养老</option>
							<option value="4">医疗融合</option>
							<option value="5">智慧养老</option>
							<option value="6">老年用品</option>
               			</select>
					 </td>
              	</tr>
			</table>
		</div>		
		
		<%--是否重点项目--%>
		<div>
			<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
				<tr>	
					<td class="width-15 active"><label class="pull-right">是否申报为2018年省重点项目：</label></td>
					<td class="width-35">
						<form:select path="sfszdold" class="form-control ">
							<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td>
				</tr>
			</table>
		</div>
		
		<%--不是重点项目显示--%>
		<div id="sfszdold_div">	
				<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
					<tr>
						<td class="width-15 active"><label class="pull-right">项目推荐单位：</label></td>
						<td class="width-35">
							<form:input path="xmtjdw" htmlEscape="false"    class="form-control "/>
						</td>
						<td class="width-15 active"><label class="pull-right">所属专题：</label></td>
						<td class="width-35">
							<form:select path="sszt" class="form-control ">
								<form:option value="" label=""/>
								<form:options items="${fns:getDictList('sszt')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
							</form:select>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">进度类别：</label></td>
						<td class="width-35">
							<form:select path="jdlb" class="form-control ">
								<form:option value="" label=""/>
								<form:options items="${fns:getDictList('jdlb')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
							</form:select>
						</td>
						<td class="width-15 active"><label class="pull-right">行业类别：</label></td>
						<td class="width-35">
							<form:select path="zdkhylb" class="form-control ">
								<form:option value="" label=""/>
								<form:options items="${fns:getDictList('zdkhylb')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
							</form:select>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">工业项目是否在省定产业集聚区或专业园区内：</label></td>
						<td class="width-35">
							<form:select path="sfzsdcyjjq" class="form-control ">
								<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
							</form:select>
						</td>
						<td class="width-15 active"><label class="pull-right">所在省定产业集聚区或专业园区名称：</label></td>
						<td class="width-35">
							<form:input path="sdcyjjqmc" htmlEscape="false"    class="form-control "/>
						</td>
	
					</tr>
					<tr style="display: none;">
						<td class="width-15 active"><label class="pull-right">是否是国家重大战略区项目：</label></td>
						<td class="width-35">
							<form:select path="sfgjzdzl" class="form-control ">
								<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
							</form:select>
						</td>
						<td class="width-15 active"><label class="pull-right">所在国家重大战略区名称：</label></td>
						<td class="width-35">
							<form:input path="gjzdzlqmc" htmlEscape="false"    class="form-control "/>
						</td>
	
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">项目建设重要意义及效益：</label></td>
						<td class="width-35" colspan="3">
							<form:textarea path="zyyy" htmlEscape="false" rows="4"    class="form-control "/>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">开工至2017年9月底累计投资完成额（万元）：</label></td>
						<td class="width-35">
							<form:input path="tzwce" htmlEscape="false"    class="form-control "/>
						</td>
						<td class="width-15 active"><label class="pull-right">预计2017年底累计完成（万元）：</label></td>
						<td class="width-35">
							<form:input path="ndljwc" htmlEscape="false"    class="form-control "/>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">截至2017年9月底工程形象进度或前期工作进度：</label></td>
						<td class="width-35" colspan="3">
							<form:textarea path="gcxxjd" htmlEscape="false" rows="4"    class="form-control "/>
						</td>
					</tr>
				</table>
				<span style="color:#477cb3;font-size:15px;">规划手续办理情况:已完成的填写批准文号</span>
				<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
					<tr>
						<td class="width-15 active"><label class="pull-right">建设项目选址许可：</label></td>
						<td class="width-35">
							<form:input path="gyxmxzxk" htmlEscape="false"    class="form-control "/>
						</td>
						<td class="width-15 active"><label class="pull-right">建设用地规划许可：</label></td>
						<td class="width-35">
							<form:input path="gyydghxk" htmlEscape="false"    class="form-control "/>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">建设工程规划许可：</label></td>
						<td class="width-35">
							<form:input path="gygcghxk" htmlEscape="false"    class="form-control "/>
						</td>
					</tr>
				</table>
				<span style="color:#477cb3;font-size:15px;">规划手续办理情况:未完成办理的报批进展情况</span>
				<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
					<tr>
						<td class="width-15 active"><label class="pull-right">建设项目选址许可：</label></td>
						<td class="width-35">
							<form:input path="gwxmxzxk" htmlEscape="false"    class="form-control "/>
						</td>
						<td class="width-15 active"><label class="pull-right">建设用地规划许可：</label></td>
						<td class="width-35">
							<form:input path="gwydghxk" htmlEscape="false"    class="form-control "/>
						</td>
					</tr>
					<!-- 
					<tr>
						<td class="width-15 active"><label class="pull-right">建设工程规划许可：</label></td>
						<td class="width-35">
							<form:input path="gwgcghxk" htmlEscape="false"    class="form-control "/>
						</td> 
					</tr>
					-->
				</table>
				<span style="color:#477cb3;font-size:15px;">环评手续办理情况</span>
				<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
					<tr>
						<td class="width-15 active"><label class="pull-right">已完成的填写批准文号：</label></td>
						<td class="width-35">
							<form:input path="hytxpzh" htmlEscape="false"    class="form-control "/>
						</td>
						<td class="width-15 active"><label class="pull-right">最终批复机关：</label></td>
						<td class="width-35">
							<form:select path="hwzzpfjg" class="form-control ">
								<form:option value="" label=""/>
								<form:options items="${fns:getDictList('hwzzpfjg')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
							</form:select>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">未完成办理的报批进展情况：</label></td>
						<td class="width-35" colspan="3">
							<form:textarea path="hwblbpjd" htmlEscape="false" rows="4"    class="form-control "/>
						</td>
					</tr>
				</table>
				<span style="color:#477cb3;font-size:15px;">审批（核准、备案）手续办理情况</span>
				<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
					<tr>
						<td class="width-15 active"><label class="pull-right">已完成的填写批准文号：</label></td>
						<td class="width-35">
							<form:input path="sytxpzwh" htmlEscape="false"    class="form-control "/>
						</td>
						<td class="width-15 active"><label class="pull-right">最终批复机关：</label></td>
						<td class="width-35">
							<form:select path="swzzpfjg" class="form-control ">
								<form:option value="" label=""/>
								<form:options items="${fns:getDictList('swzzpfjg')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
							</form:select>
						</td>
						
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">未完成办理的报批进展情况：</label></td>
						<td class="width-35" colspan="3">
							<form:textarea path="swpzjzqk" htmlEscape="false" rows="4"    class="form-control "/>
						</td>
					</tr>
				</table>
				<span style="color:#477cb3;font-size:15px;">用地手续办理情况</span>
				<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
					<tr>
						<td class="width-15 active"><label class="pull-right">共需用地（亩）：</label></td>
						<td class="width-35">
							<form:input path="gxyd" htmlEscape="false"    class="form-control "/>
						</td>
						<td class="width-15 active"><label class="pull-right">已取得土地证土地（亩）：</label></td>
						<td class="width-35">
							<form:input path="yzdtdz" htmlEscape="false"    class="form-control "/>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">其中当年计划征地(亩)：</label></td>
						<td class="width-35">
							<form:input path="dnjhzd" htmlEscape="false"    class="form-control "/>
						</td>
						<td class="width-15 active"><label class="pull-right">土地证号：</label></td>
						<td class="width-35">
							<form:input path="tdzh" htmlEscape="false"    class="form-control "/>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">是否占用基本农田：</label></td>
						<td class="width-35">
							<form:select path="sfjbnt" class="form-control ">
								<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
							</form:select>
						</td>
						<td class="width-15 active"><label class="pull-right">批复文号：</label></td>
						<td class="width-35">
							<form:input path="pfwh" htmlEscape="false"    class="form-control "/>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">当年计划征地报批情况：</label></td>
						<td class="width-35">
							<form:select path="dnzdbpqk" class="form-control ">
								<form:option value="" label=""/>
								<form:options items="${fns:getDictList('dnzdbpqk')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
							</form:select>
						</td>
					</tr>
				</table>
				<span style="color:#477cb3;font-size:15px;">2018年度主要建设目标:主要形象进度或前期工作进度目标（累计进度，100字以内）</span>
				<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
					<tr>
						<td class="width-15 active"><label class="pull-right">2018年度主要建设目标第一季度末主要形象进度或前期工作进度目标（累计进度，100字以内）：</label></td>
						<td class="width-35">
							<form:textarea path="zyxxjda" htmlEscape="false" rows="4"    class="form-control "/>
						</td>

					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">2018年度主要建设目标第二季度末主要形象进度或前期工作进度目标（累计进度，100字以内）：</label></td>
						<td class="width-35">
							<form:textarea path="zyxxjdb" htmlEscape="false" rows="4"    class="form-control "/>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">2018年度主要建设目标第三季度末主要形象进度或前期工作进度目标（累计进度，100字以内）：</label></td>
						<td class="width-35">
							<form:textarea path="zyxxjdc" htmlEscape="false" rows="4"    class="form-control "/>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">2018年度主要建设目标年底前主要形象进度或前期工作进度目标（累计进度，100字以内）：</label></td>
						<td class="width-35">
							<form:textarea path="zyxxjdd" htmlEscape="false" rows="4"    class="form-control "/>
						</td>
					</tr>
				</table>
				<span style="color:#477cb3;font-size:15px;">2018年度主要建设目标:投资进度节点目标（累计进度）（万元）</span>
				<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
					<tr>
						<td class="width-15 active"><label class="pull-right">第一季度末：</label></td>
						<td class="width-35">
							<form:input path="tzjdjdmba" htmlEscape="false"    class="form-control "/>
						</td>
						<td class="width-15 active"><label class="pull-right">第二季度末：</label></td>
						<td class="width-35">
							<form:input path="tzjdjdmbb" htmlEscape="false"    class="form-control "/>
						</td>
					</tr>
					<tr>
						<td class="width-15 active"><label class="pull-right">第三季度末：</label></td>
						<td class="width-35">
							<form:input path="tzjdjdmbc" htmlEscape="false"    class="form-control "/>
						</td>
						<td class="width-15 active"><label class="pull-right">年底前：</label></td>
						<td class="width-35">
							<form:input path="tzjdjdmbd" htmlEscape="false"    class="form-control "/>
						</td>
					</tr>
				</table>
				<span style="color:#477cb3;font-size:15px;">2018年度主要建设目标:开工竣工项目日期</span>
				<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
					<tr>
						<td class="width-15 active"><label class="pull-right">当年开工项目计划开工日期(保存后生成)：</label></td>
						<td class="width-35">
							<input id="jhkgrq" name="jhkgrq" maxlength="20" class="laydate-icon form-control layer-date "
								value="${cInsBusinessZdxmk.jhkgrq}"/>
						</td>
						<td class="width-15 active"><label class="pull-right">当年竣工项目计划竣工日期(保存后生成)：</label></td>
						<td class="width-35">
							<input id="jhjgrq" name="jhjgrq" maxlength="20" class="laydate-icon form-control layer-date "
								value="${cInsBusinessZdxmk.jhjgrq}"/>
						</td>
					</tr>
				</table>
				<div style="display: none">
					<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">					
						<tr>
							<td class="width-15 active"><label class="pull-right">项目id：</label></td>
							<td class="width-35">
								<form:input path="projectid" htmlEscape="false"    class="form-control "/>
							</td>
							<td class="width-15 active"><label class="pull-right">项目基本信息id：</label></td>
							<td class="width-35">
								<form:input path="xmjbxxId" htmlEscape="false"    class="form-control "/>
							</td>
						</tr>
				 	</table>
			 	</div>
		</div>		
</div>
<script>
	function cshgjcy(){
		$("#sfzdgjcy").bind("change", function () {
			var options=$("#sfzdgjcy option:selected"); //获取选中的项
			var selected_val = options.val();
			var selected_val2=$("#szdgjcy option:selected").val();
			var selec3ted_val3=$("#xszdgjcy option:selected").val();
	        if(0 == selected_val){
	          $("#sfzdgjcy").get(0).selectedIndex=0;      
		      $("#sfszdgjcy").hide();
			  $("#sfxszdgjcy").hide();
			  $("#tr_sgj").hide();
		      $("#tr_xsgj").hide();
	        }else{
	          $("#sfzdgjcy").get(0).selectedIndex=1;
	          $("#sfszdgjcy").show();
	          $("#sfxszdgjcy").show();
	          if(selected_val2==0){
	          	$("#tr_xsgj").hide();
	          	$("#tr_sgj").show();
	          }else{
	          	$("#tr_xsgj").show();
	          	$("#tr_sgj").hide();
	          }            
	        }
	    });
	    $("#sfzdgjcy").change();
	    
	    $("#szdgjcy").bind("change", function () {
			var options=$("#szdgjcy option:selected"); //获取选中的项
			var selected_val = options.val();
			 $("#sfszdgjcy").show();
	         $("#sfxszdgjcy").show();
	        if(0 == selected_val){
	          $("#szdgjcy").get(0).selectedIndex=0;
	          $("#xszdgjcy").get(0).selectedIndex=0;
			  $("#tr_sgj").show();
		      $("#tr_xsgj").hide();
	        }else{
	          $("#sfzdgjcy").get(0).selectedIndex=1;
	          $("#xszdgjcy").get(0).selectedIndex=1;
			  $("#tr_sgj").hide();
		      $("#tr_xsgj").show();
		       
	        }
	    });
	    $("#szdgjcy").change();
	    
	    $("#xszdgjcy").bind("change", function () {
			var options=$("#xszdgjcy option:selected"); //获取选中的项
			var selected_val = options.val();
			$("#sfszdgjcy").show();
	        $("#sfxszdgjcy").show();
	        if(0 == selected_val){
	          $("#xszdgjcy").get(0).selectedIndex=0;
	          $("#szdgjcy").get(0).selectedIndex=0;
			  $("#tr_sgj").show();
		      $("#tr_xsgj").hide();
	        }else{
	          $("#xszdgjcy").get(0).selectedIndex=1;
	          $("#szdgjcy").get(0).selectedIndex=1;
			  $("#tr_sgj").hide();
		      $("#tr_xsgj").show();
		       
	        }
	    });
	    $("#szdgjcy").change();
	
	    //是否是重点攻坚产业
	    var sfzdgjcy ="${cInsBusinessZdxmk.sfzdgjcy}";
	    var sfszdgjcy ="${cInsBusinessZdxmk.sfszdgjcy}";
	    var sfxszdgjcy ="${cInsBusinessZdxmk.sfxszdgjcy}";
	    var szdgjcylx ="${cInsBusinessZdxmk.szdgjcylx}";
	    var xszdgjcylx ="${cInsBusinessZdxmk.xszdgjcylx}";  
	    if(sfzdgjcy==0){
	  	  $("#sfzdgjcy").get(0).selectedIndex=0;      
		  $("#sfszdgjcy").hide();
		  $("#sfxszdgjcy").hide();
		  $("#tr_sgj").hide();
	      $("#tr_xsgj").hide();
	    }else{
	      $("#sfzdgjcy").get(0).selectedIndex=1;
	      if(sfszdgjcy==0){
	      	$("#xszdgjcy").get(0).selectedIndex=0;
	      	$("#szdgjcy").get(0).selectedIndex=0;
		  	$("#tr_xsgj").hide();
		  	$("#tr_sgj").show();
		  	if(szdgjcylx==1){
	      		$("#szdgjcylx").get(0).selectedIndex=1;
	      	}else if(szdgjcylx==2){
	      		$("#szdgjcylx").get(0).selectedIndex=2;
	      	}else if(szdgjcylx==3){
	      		$("#szdgjcylx").get(0).selectedIndex=3;
	      	}else if(szdgjcylx==4){
	      		$("#szdgjcylx").get(0).selectedIndex=4;
	      	}else if(szdgjcylx==5){
	      		$("#szdgjcylx").get(0).selectedIndex=5;
	      	}else if(szdgjcylx==6){
	      		$("#szdgjcylx").get(0).selectedIndex=6;
	      	}else if(szdgjcylx==7){
	      		$("#szdgjcylx").get(0).selectedIndex=7;
	      	}else if(szdgjcylx==8){
	      		$("#szdgjcylx").get(0).selectedIndex=8;
	      	}else if(szdgjcylx==9){
	      		$("#szdgjcylx").get(0).selectedIndex=9;
	      	}else if(szdgjcylx==10){
	      		$("#szdgjcylx").get(0).selectedIndex=10;
	      	}else if(szdgjcylx==11){
	      		$("#szdgjcylx").get(0).selectedIndex=11;
	      	}else if(szdgjcylx==12){
	      		$("#szdgjcylx").get(0).selectedIndex=12;
	      	}else{}
	      }
		  if(sfxszdgjcy==1){
	      	$("#xszdgjcy").get(0).selectedIndex=1;
	      	$("#szdgjcy").get(0).selectedIndex=1;
		  	$("#tr_xsgj").show();
		  	$("#tr_sgj").hide();
		  	$("#sxzdgjcy").val(xszdgjcylx);
	      }
	     
	    }
	   
	}
function cshjkly(){debugger;
	 //健康养老示范项目	              	jkyl_dwxz_sel	jkyl_xmfj_sel	jkyl_xmlx_sel	sfjkylxm
	    
	    var sfjkylxm= $("#sfjkylxm_inp").val();
   		var jkyldwxz= $("#jkyl_dwxz_sel_inp").val();
   		var jkylxmfj= $("#jkyl_xmfj_sel_inp").val();
   		var jkylxmlx= $("#jkyl_xmlx_sel_inp").val();
		var options1 = document.getElementById("jkyl_dwxz_sel").children;
		var options2 = document.getElementById("jkyl_xmfj_sel").children;
		var options3 = document.getElementById("jkyl_xmlx_sel").children;
   		var options0 = document.getElementById("sfjkylxm").children;
   		if(sfjkylxm==0 || sfjkylxm==null){
   			options0[0].selected=true; 
   			$("#jkyl_dwxz").hide();
			$("#jkyl_xmfj").hide();
			$("#jkyl_xmlx").hide();
   		}else if(sfjkylxm==1){
   			options0[1].selected=true; 
   			$("#jkyl_dwxz").hide();
			$("#jkyl_xmfj").show();
			$("#jkyl_xmlx").show();
   			if(jkyldwxz==0){
   				options1[0].selected=true; 
   			}else if(jkyldwxz==1){
		        options1[1].selected=true; 
   			}else if(jkyldwxz==2){
   				options1[2].selected=true; 
   			}else if(jkyldwxz==3){
   				options1[3].selected=true; 
   			}else if(jkyldwxz==4){
   				options1[4].selected=true;  
   			}else{}
   			if(jkylxmfj==0){
   				options2[0].selected=true;
   			}else if(jkylxmfj==1){
   				options2[1].selected=true;
   			}else if(jkylxmfj==2){
   				options2[2].selected=true;
   			}else if(jkylxmfj==3){
   				options2[3].selected=true;
   			}else{}
   			if(jkylxmlx==0){
   				options3[0].selected=true;
   			}else if(jkylxmlx==1){
   				options3[1].selected=true;
   			}else if(jkylxmlx==2){
   				options3[2].selected=true;
   			}else if(jkylxmlx==3){
   				options3[3].selected=true;
   			}else if(jkylxmlx==4){
   				options3[4].selected=true;
   			}else if(jkylxmlx==5){
   				options3[5].selected=true;
   			}else if(jkylxmlx==6){
   				options3[6].selected=true;
   			}else{}
   		}else{}
  	debugger;
  	$("#sfjkylxm").change();
    $("#sfjkylxm").bind("change", function () {
		var options=$("#sfjkylxm option:selected"); //获取选中的项			
		var selected_val = options.val();
        if(0 == selected_val){
	      $("#jkyl_xmfj").hide();
	      $("#jkyl_dwxz").hide();
	      $("#jkyl_xmlx").hide();
        }else{
	      $("#jkyl_xmfj").show();
	      $("#jkyl_dwxz").hide();
	      $("#jkyl_xmlx").show();
        }
    });

}
</script> 
