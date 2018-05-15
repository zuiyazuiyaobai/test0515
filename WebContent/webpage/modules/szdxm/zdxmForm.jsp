<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<style type="text/css">
    .thcenter{
    	text-align:center
    }
    .thwidth{
    	width:20%
    }
    .tdwidthone{
    	padding-left:0px
    }
    .tdwidthtwo{
    	padding-left:20px
    }
    .tdwidththree{
    	padding-left:40px
    }		
</style>
<!-- 表格 -->
		<div class="table-flow-contain">
		<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
			<thead>
				<tr>
					<th  class="sort-column" ></th>
					<th  class="sort-column thcenter thwidth" >行业类别</th>
					<th  class="sort-column thcenter" >责任单位</th>
					<th  class="sort-column thcenter" >总投资</th>
					<th  class="sort-column thcenter" >止上年底完成投资</th>
					<th  class="sort-column thcenter" >当月完成投资</th>
					<th  class="sort-column thcenter" >年度投资目标</th>
					<th  class="sort-column thcenter" >1-当月累计完成投资</th>
					<th  class="sort-column thcenter" >累计完成投资占年度目标比例</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td class="thcenter thwidth">合计</td>
					<td class="thcenter">1</td>
					<td class="thcenter sum_1">2</td>
					<td class="thcenter sum_2">3</td>
					<td class="thcenter sum_3">4</td>
					<td class="thcenter sum_4">5</td>
					<td class="thcenter sum_5">6</td>
					<td class="thcenter">7</td>
				</tr>
				<tr>
					<td></td>
					<td class="tdwidthone  one">一.&nbsp;&nbsp;产业转型发展项目</td>
					<td class="thcenter ">1</td>
					<td class="thcenter">2</td>
					<td class="thcenter">3</td>
					<td class="thcenter">4</td>
					<td class="thcenter">5</td>
					<td class="thcenter">6</td>
					<td class="thcenter">7</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 30px;" class="two">(一).&nbsp;&nbsp; 工业项目</td>
					<td class="thcenter">1</td>
					<td class="thcenter">2</td>
					<td class="thcenter">3</td>
					<td class="thcenter">4</td>
					<td class="thcenter">5</td>
					<td class="thcenter">6</td>
					<td class="thcenter">7</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 60px;" class="three">1.&nbsp;&nbsp;先进制造业项目</td>
					<td class="thcenter">1</td>
					<td class="thcenter sum1"></td>
					<td class="thcenter sum2"></td>
					<td class="thcenter sum3"></td>
					<td class="thcenter sum4"></td>
					<td class="thcenter sum5"></td>
					<td class="thcenter">7</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 90px;" class="four">①&nbsp;&nbsp;装备制造业项目(${zbzzsize})</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${zbzzylistOne.ztz}</td>
					<td class="thcenter row_2">${zbzzylistOne.ttndljwc}</td>
					<td class="thcenter row_3">${zbzzylistOne.yddyljwntz - zbzzylisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${zbzzylistOne.zjxq}</td>
					<td class="thcenter row_5">${zbzzylistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${zbzzylistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${zbzzylistOne.yddyljwntz != 0}">				
							${zbzzylistOne.zjxq/zbzzylistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 90px;" class="four">②&nbsp;&nbsp;新型材料业项目(${xxclysize})</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${xxclylistOne.ztz}</td>
					<td class="thcenter row_2">${xxclylistOne.ttndljwc}</td>
					<td class="thcenter row_3">${xxclylistOne.yddyljwntz - xxclylisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${xxclylistOne.zjxq}</td>
					<td class="thcenter row_5">${xxclylistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${xxclylistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${xxclylistOne.yddyljwntz != 0}">				
							${xxclylistOne.zjxq/xxclylistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 90px;" class="four">③&nbsp;&nbsp;电子信息业项目(${dzxxysize})</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${dzxxylistOne.ztz}</td>
					<td class="thcenter row_2">${dzxxylistOne.ttndljwc}</td>
					<td class="thcenter row_3">${dzxxylistOne.yddyljwntz - dzxxylisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${dzxxylistOne.zjxq}</td>
					<td class="thcenter row_5">${dzxxylistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${dzxxylistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${dzxxylistOne.yddyljwntz != 0}">				
							${dzxxylistOne.zjxq/dzxxylistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 90px;" class="four">④&nbsp;&nbsp;建筑业项目(${jzysize})</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${jzylistOne.ztz}</td>
					<td class="thcenter row_2">${jzylistOne.ttndljwc}</td>
					<td class="thcenter row_3">${jzylistOne.yddyljwntz - jzylisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${jzylistOne.zjxq}</td>
					<td class="thcenter row_5">${jzylistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${jzylistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${jzylistOne.yddyljwntz != 0}">				
							${jzylistOne.zjxq/jzylistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 90px;" class="four">⑤&nbsp;&nbsp;绿色食品业项目(${lsspysize})</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${lsspylistOne.ztz}</td>
					<td class="thcenter row_2">${lsspylistOne.ttndljwc}</td>
					<td class="thcenter row_3">${lsspylistOne.yddyljwntz - lsspylisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${lsspylistOne.zjxq}</td>
					<td class="thcenter row_5">${lsspylistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${lsspylistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${lsspylistOne.yddyljwntz != 0}">				
							${lsspylistOne.zjxq/lsspylistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 90px;" class="four">⑥&nbsp;&nbsp;汽车制造项目(${qczzysize})</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${qczzylistOne.ztz}</td>
					<td class="thcenter row_2">${qczzylistOne.ttndljwc}</td>
					<td class="thcenter row_3">${qczzylistOne.yddyljwntz - qczzylisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${qczzylistOne.zjxq}</td>
					<td class="thcenter row_5">${qczzylistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${qczzylistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${qczzylistOne.yddyljwntz != 0}">				
							${qczzylistOne.zjxq/qczzylistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 90px;" class="four">⑦&nbsp;&nbsp;生物医药项目(${swzysize})</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${swzylistOne.ztz}</td>
					<td class="thcenter row_2">${swzylistOne.ttndljwc}</td>
					<td class="thcenter row_3">${swzylistOne.yddyljwntz - swzylisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${swzylistOne.zjxq}</td>
					<td class="thcenter row_5">${swzylistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${swzylistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${swzylistOne.yddyljwntz != 0}">				
							${swzylistOne.zjxq/swzylistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 60px;" class="three">2.&nbsp;&nbsp;传统工业升级项目(${ctgysjsize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${ctgysjlistOne.ztz }</td>
					<td class="thcenter row_2">${ctgysjlistOne.ttndljwc}</td>
					<td class="thcenter row_3">${ctgysjlistOne.yddyljwntz - ctgysjlisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${ctgysjlistOne.zjxq}</td>
					<td class="thcenter row_5">${ctgysjlistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${ctgysjlistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${ctgysjlistOne.yddyljwntz != 0}">				
							${ctgysjlistOne.zjxq/ctgysjlistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 30px;" class="two">（二）.&nbsp;&nbsp;现代服务业项目</td>
					<td class="thcenter">1</td>
					<td class="thcenter">2</td>
					<td class="thcenter">3</td>
					<td class="thcenter">4</td>
					<td class="thcenter">5</td>
					<td class="thcenter">6</td>
					<td class="thcenter">7</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 60px;" class="three">1.&nbsp;&nbsp;物流项目(${wlxmsize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${wlxmlistOne.ztz }</td>
					<td class="thcenter row_2">${wlxmlistOne.ttndljwc}</td>
					<td class="thcenter row_3">${wlxmlistOne.yddyljwntz - wlxmlisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${wlxmlistOne.zjxq}</td>
					<td class="thcenter row_5">${wlxmlistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${wlxmlistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${wlxmlistOne.yddyljwntz != 0}">				
							${wlxmlistOne.zjxq/wlxmlistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 60px;" class="three">2.&nbsp;&nbsp;金融项目(${jrxmsize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${jrxmlistOne.ztz }</td>
					<td class="thcenter row_2">${jrxmlistOne.ttndljwc}</td>
					<td class="thcenter row_3">${jrxmlistOne.yddyljwntz - jrxmlisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${jrxmlistOne.zjxq}</td>
					<td class="thcenter row_5">${jrxmlistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${jrxmlistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${jrxmlistOne.yddyljwntz != 0}">				
							${jrxmlistOne.zjxq/jrxmlistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 60px;" class="three">3.&nbsp;&nbsp;科技服务项目(${kjfwsize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${kjfwlistOne.ztz }</td>
					<td class="thcenter row_2">${kjfwlistOne.ttndljwc}</td>
					<td class="thcenter row_3">${kjfwlistOne.yddyljwntz - kjfwlisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${kjfwlistOne.zjxq}</td>
					<td class="thcenter row_5">${kjfwlistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${kjfwlistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${kjfwlistOne.yddyljwntz != 0}">				
							${kjfwlistOne.zjxq/kjfwlistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 60px;" class="three">4.&nbsp;&nbsp;信息服务项目(${xxfwsize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${xxfwlistOne.ztz }</td>
					<td class="thcenter row_2">${xxfwlistOne.ttndljwc}</td>
					<td class="thcenter row_3">${xxfwlistOne.yddyljwntz - xxfwlisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${xxfwlistOne.zjxq}</td>
					<td class="thcenter row_5">${xxfwlistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${xxfwlistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${xxfwlistOne.yddyljwntz != 0}">				
							${xxfwlistOne.zjxq/xxfwlistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 60px;" class="three">5.&nbsp;&nbsp;商贸商务项目(${smswsize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${smswlistOne.ztz }</td>
					<td class="thcenter row_2">${smswlistOne.ttndljwc}</td>
					<td class="thcenter row_3">${smswlistOne.yddyljwntz - smswlisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${smswlistOne.zjxq}</td>
					<td class="thcenter row_5">${smswlistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${smswlistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${smswlistOne.yddyljwntz != 0}">				
							${smswlistOne.zjxq/smswlistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 60px;" class="three">6.&nbsp;&nbsp;文化旅游项目(${whlysize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${whlylistOne.ztz }</td>
					<td class="thcenter row_2">${whlylistOne.ttndljwc}</td>
					<td class="thcenter row_3">${whlylistOne.yddyljwntz - whlylisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${whlylistOne.zjxq}</td>
					<td class="thcenter row_5">${whlylistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${whlylistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${whlylistOne.yddyljwntz != 0}">				
							${whlylistOne.zjxq/whlylistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 60px;" class="three">7.&nbsp;&nbsp;健康养老项目(${jkylsize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${jkyllistOne.ztz }</td>
					<td class="thcenter row_2">${jkyllistOne.ttndljwc}</td>
					<td class="thcenter row_3">${jkyllistOne.yddyljwntz - jkyllisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${jkyllistOne.zjxq}</td>
					<td class="thcenter row_5">${jkyllistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${jkyllistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${jkyllistOne.yddyljwntz != 0}">				
							${jkyllistOne.zjxq/jkyllistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 30px;" class="two">（三）.&nbsp;&nbsp;现代农业项目</td>
					<td class="thcenter">1</td>
					<td class="thcenter">2</td>
					<td class="thcenter">3</td>
					<td class="thcenter">4</td>
					<td class="thcenter">5</td>
					<td class="thcenter">6</td>
					<td class="thcenter">7</td>
				</tr>
				<tr>
					<td></td>
					<td class="tdwidthone" class="one">二.&nbsp;&nbsp;创新驱动项目</td>
					<td class="thcenter">1</td>
					<td class="thcenter">2</td>
					<td class="thcenter">3</td>
					<td class="thcenter">4</td>
					<td class="thcenter">5</td>
					<td class="thcenter">6</td>
					<td class="thcenter">7</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 30px;" class="two">（一）.&nbsp;&nbsp;双创平台项目(${scptsize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${scptlistOne.ztz }</td>
					<td class="thcenter row_2">${scptlistOne.ttndljwc}</td>
					<td class="thcenter row_3">${scptlistOne.yddyljwntz - scptlisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${scptlistOne.zjxq}</td>
					<td class="thcenter row_5">${scptlistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${scptlistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${scptlistOne.yddyljwntz != 0}">				
							${scptlistOne.zjxq/scptlistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 30px;" class="two">（二）.&nbsp;&nbsp;研发平台项目(${yfptsize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${yfptlistOne.ztz }</td>
					<td class="thcenter row_2">${yfptlistOne.ttndljwc}</td>
					<td class="thcenter row_3">${yfptlistOne.yddyljwntz - yfptlisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${yfptlistOne.zjxq}</td>
					<td class="thcenter row_5">${yfptlistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${yfptlistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${yfptlistOne.yddyljwntz != 0}">				
							${yfptlistOne.zjxq/yfptlistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td class="tdwidthone" class="one">三.&nbsp;&nbsp;基础设施项目</td>
					<td class="thcenter">1</td>
					<td class="thcenter">2</td>
					<td class="thcenter">3</td>
					<td class="thcenter">4</td>
					<td class="thcenter">5</td>
					<td class="thcenter">6</td>
					<td class="thcenter">7</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 30px;" class="two">（一）.&nbsp;&nbsp;交通项目</td>
					<td class="thcenter">1</td>
					<td class="thcenter">2</td>
					<td class="thcenter">3</td>
					<td class="thcenter">4</td>
					<td class="thcenter">5</td>
					<td class="thcenter">6</td>
					<td class="thcenter">7</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 60px;" class="three">1.&nbsp;&nbsp;铁路项目(${tlxmsize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${tlxmlistOne.ztz }</td>
					<td class="thcenter row_2">${tlxmlistOne.ttndljwc}</td>
					<td class="thcenter row_3">${tlxmlistOne.yddyljwntz - tlxmlisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${tlxmlistOne.zjxq}</td>
					<td class="thcenter row_5">${tlxmlistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${tlxmlistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${tlxmlistOne.yddyljwntz != 0}">				
							${tlxmlistOne.zjxq/tlxmlistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 60px;" class="three">2.&nbsp;&nbsp;高速公路项目(${gsglsize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${gsgllistOne.ztz }</td>
					<td class="thcenter row_2">${gsgllistOne.ttndljwc}</td>
					<td class="thcenter row_3">${gsgllistOne.yddyljwntz - gsgllisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${gsgllistOne.zjxq}</td>
					<td class="thcenter row_5">${gsgllistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${gsgllistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${gsgllistOne.yddyljwntz != 0}">				
							${gsgllistOne.zjxq/gsgllistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 60px;" class="three">3.&nbsp;&nbsp;普通公路项目(${ptglsize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${ptgllistOne.ztz }</td>
					<td class="thcenter row_2">${ptgllistOne.ttndljwc}</td>
					<td class="thcenter row_3">${ptgllistOne.yddyljwntz - ptgllisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${ptgllistOne.zjxq}</td>
					<td class="thcenter row_5">${ptgllistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${ptgllistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${ptgllistOne.yddyljwntz != 0}">				
							${ptgllistOne.zjxq/ptgllistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 60px;" class="three">4.&nbsp;&nbsp;机场项目(${jcxmsize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${jcxmlistOne.ztz }</td>
					<td class="thcenter row_2">${jcxmlistOne.ttndljwc }</td>
					<td class="thcenter row_3">${jcxmlistOne.yddyljwntz - jcxmlisttwo.yddyljwntz }</td>
					<td class="thcenter row_4">${jcxmlistOne.zjxq }</td>
					<td class="thcenter row_5">${jcxmlistOne.yddyljwntz }</td>
					<td class="thcenter">
						<c:if test="${jcxmlistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${jcxmlistOne.yddyljwntz != 0}">				
							${jcxmlistOne.zjxq/jcxmlistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 60px;" class="three">5.&nbsp;&nbsp;港口航道项目(${gkhdsize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${gkhdlistOne.ztz }</td>
					<td class="thcenter row_2">${gkhdlistOne.ttndljwc}</td>
					<td class="thcenter row_3">${gkhdlistOne.yddyljwntz - gkhdlisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${gkhdlistOne.zjxq}</td>
					<td class="thcenter row_5">${gkhdlistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${gkhdlistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${gkhdlistOne.yddyljwntz != 0}">				
							${gkhdlistOne.zjxq/gkhdlistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 60px;" class="three">6.&nbsp;&nbsp;交通枢纽项目(${jtsnsize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${jtsnlistOne.ztz }</td>
					<td class="thcenter row_2">${jtsnlistOne.ttndljwc}</td>
					<td class="thcenter row_3">${jtsnlistOne.yddyljwntz - jtsnlisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${jtsnlistOne.zjxq}</td>
					<td class="thcenter row_5">${jtsnlistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${jtsnlistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${jtsnlistOne.yddyljwntz != 0}">				
							${jtsnlistOne.zjxq/jtsnlistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 30px;" class="two">（一）.&nbsp;&nbsp;能源项目</td>
					<td class="thcenter">1</td>
					<td class="thcenter">2</td>
					<td class="thcenter">3</td>
					<td class="thcenter">4</td>
					<td class="thcenter">5</td>
					<td class="thcenter">6</td>
					<td class="thcenter">7</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 60px;" class="three">1.&nbsp;&nbsp;电源项目(${dyxmsize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${dyxmlistOne.ztz }</td>
					<td class="thcenter row_2">${dyxmlistOne.ttndljwc}</td>
					<td class="thcenter row_3">${dyxmlistOne.yddyljwntz - dyxmlisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${dyxmlistOne.zjxq}</td>
					<td class="thcenter row_5">${dyxmlistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${dyxmlistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${dyxmlistOne.yddyljwntz != 0}">				
							${dyxmlistOne.zjxq/dyxmlistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 60px;" class="three">2.&nbsp;&nbsp;电网项目(${dwxmsize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${dwxmlistOne.ztz }</td>
					<td class="thcenter row_2">${dwxmlistOne.ttndljwc}</td>
					<td class="thcenter row_3">${dwxmlistOne.yddyljwntz - dwxmlisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${dwxmlistOne.zjxq}</td>
					<td class="thcenter row_5">${dwxmlistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${dwxmlistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${dwxmlistOne.yddyljwntz != 0}">				
							${dwxmlistOne.zjxq/dwxmlistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 60px;" class="three">3.&nbsp;&nbsp;新能源项目(${xnysize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${xnylistOne.ztz }</td>
					<td class="thcenter row_2">${xnylistOne.ttndljwc}</td>
					<td class="thcenter row_3">${xnylistOne.yddyljwntz - xnylisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${xnylistOne.zjxq}</td>
					<td class="thcenter row_5">${xnylistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${xnylistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${xnylistOne.yddyljwntz != 0}">				
							${xnylistOne.zjxq/xnylistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 60px;" class="three">4.&nbsp;&nbsp;油气管道项目(${yqgdsize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${yqgdlistOne.ztz }</td>
					<td class="thcenter row_2">${yqgdlistOne.ttndljwc}</td>
					<td class="thcenter row_3">${yqgdlistOne.yddyljwntz - yqgdlisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${yqgdlistOne.zjxq}</td>
					<td class="thcenter row_5">${yqgdlistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${yqgdlistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${yqgdlistOne.yddyljwntz != 0}">				
							${yqgdlistOne.zjxq/yqgdlistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 60px;" class="three">5.&nbsp;&nbsp;炼油设施项目(${lysssize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${lysslistOne.ztz }</td>
					<td class="thcenter row_2">${lysslistOne.ttndljwc}</td>
					<td class="thcenter row_3">${lysslistOne.yddyljwntz - lysslisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${lysslistOne.zjxq}</td>
					<td class="thcenter row_5">${lysslistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${lysslistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${lysslistOne.yddyljwntz != 0}">				
							${lysslistOne.zjxq/lysslistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 60px;" class="three">6.&nbsp;&nbsp;煤炭储配园区项目(${mtcbsize })</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${mtcblistOne.ztz }</td>
					<td class="thcenter row_2">${mtcblistOne.ttndljwc}</td>
					<td class="thcenter row_3">${mtcblistOne.yddyljwntz - mtcblisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${mtcblistOne.zjxq}</td>
					<td class="thcenter row_5">${mtcblistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${mtcblistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${mtcblistOne.yddyljwntz != 0}">				
							${mtcblistOne.zjxq/mtcblistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 30px;" class="two">（三）.&nbsp;&nbsp;信息通信项目(${xxtxsize})</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${xxtxlistOne.ztz }</td>
					<td class="thcenter row_2">${xxtxlistOne.ttndljwc}</td>
					<td class="thcenter row_3">${xxtxlistOne.yddyljwntz - xxtxlisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${xxtxlistOne.zjxq}</td>
					<td class="thcenter row_5">${xxtxlistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${xxtxlistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${xxtxlistOne.yddyljwntz != 0}">				
							${xxtxlistOne.zjxq/xxtxlistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 30px;" class="two">（四）.&nbsp;&nbsp;水利项目(${slxmsize})</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${slxmlistOne.ztz }</td>
					<td class="thcenter row_2">${slxmlistOne.ttndljwc}</td>
					<td class="thcenter row_3">${slxmlistOne.yddyljwntz - slxmlisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${slxmlistOne.zjxq}</td>
					<td class="thcenter row_5">${slxmlistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${slxmlistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${slxmlistOne.yddyljwntz != 0}">				
							${slxmlistOne.zjxq/slxmlistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td class="tdwidthone" class="one">四.&nbsp;&nbsp;新型城镇化项目</td>
					<td class="thcenter">1</td>
					<td class="thcenter">2</td>
					<td class="thcenter">3</td>
					<td class="thcenter">4</td>
					<td class="thcenter">5</td>
					<td class="thcenter">6</td>
					<td class="thcenter">7</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 30px;" class="two">（一）.&nbsp;&nbsp;百城提质项目(${bctzsize})</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${bctzlistOne.ztz }</td>
					<td class="thcenter row_2">${bctzlistOne.ttndljwc}</td>
					<td class="thcenter row_3">${bctzlistOne.yddyljwntz - bctzlisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${bctzlistOne.zjxq}</td>
					<td class="thcenter row_5">${bctzlistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${bctzlistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${bctzlistOne.yddyljwntz != 0}">				
							${bctzlistOne.zjxq/bctzlistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 30px;" class="two">（一）.&nbsp;&nbsp;城市基础能力提升项目(${csjcsize})</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${csjclistOne.ztz }</td>
					<td class="thcenter row_2">${csjclistOne.ttndljwc}</td>
					<td class="thcenter row_3">${csjclistOne.yddyljwntz - csjclisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${csjclistOne.zjxq}</td>
					<td class="thcenter row_5">${csjclistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${csjclistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${csjclistOne.yddyljwntz != 0}">				
							${csjclistOne.zjxq/csjclistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td class="tdwidthone" class="one">五.&nbsp;&nbsp;生态环保项目(${sthbsize})</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${sthblistOne.ztz }</td>
					<td class="thcenter row_2">${sthblistOne.ttndljwc}</td>
					<td class="thcenter row_3">${sthblistOne.yddyljwntz - sthblisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${sthblistOne.zjxq}</td>
					<td class="thcenter row_5">${sthblistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${sthblistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${sthblistOne.yddyljwntz != 0}">				
							${sthblistOne.zjxq/sthblistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				
				<%-- <tr>
					<td></td>
					<td class="tdwidthone" class="one">六.&nbsp;&nbsp;扶贫搬迁和滩区迁建项目(${fpbqsize})</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${fpbqlistOne.ztz }</td>
					<td class="thcenter row_2">${fpbqlistOne.ttndljwc}</td>
					<td class="thcenter row_3">${fpbqlistOne.yddyljwntz - fpbqlisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${fpbqlistOne.zjxq}</td>
					<td class="thcenter row_5">${fpbqlistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${fpbqlistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${fpbqlistOne.yddyljwntz != 0}">				
							${fpbqlistOne.zjxq/fpbqlistOne.yddyljwntz}
						</c:if>
					</td>
				</tr> --%>
				<tr>
					<td></td>
					<td class="tdwidthone" class="one">六.&nbsp;&nbsp;扶贫搬迁和滩区迁建项目</td>
					<td class="thcenter">1</td>
					<td class="thcenter">2</td>
					<td class="thcenter">3</td>
					<td class="thcenter">4</td>
					<td class="thcenter">5</td>
					<td class="thcenter">6</td>
					<td class="thcenter">7</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 30px;" class="two">（一）.&nbsp;&nbsp;教育能力提升项目(${jytssize})</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${jytslistOne.ztz }</td>
					<td class="thcenter row_2">${jytslistOne.ttndljwc}</td>
					<td class="thcenter row_3">${jytslistOne.yddyljwntz - jytslisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${jytslistOne.zjxq}</td>
					<td class="thcenter row_5">${jytslistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${jytslistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${jytslistOne.yddyljwntz != 0}">				
							${jytslistOne.zjxq/jytslistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 30px;" class="two">（二）.&nbsp;&nbsp;医疗能力提升项目(${yltssize})</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${yltslistOne.ztz }</td>
					<td class="thcenter row_2">${yltslistOne.ttndljwc}</td>
					<td class="thcenter row_3">${yltslistOne.yddyljwntz - yltslisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${yltslistOne.zjxq}</td>
					<td class="thcenter row_5">${yltslistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${yltslistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${yltslistOne.yddyljwntz != 0}">				
							${yltslistOne.zjxq/yltslistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="padding-left: 30px;" class="two">（三）.&nbsp;&nbsp;公共服务能力提升项目(${ggfwsize})</td>
					<td class="thcenter">1</td>
					<td class="thcenter row_1">${ggfwlistOne.ztz }</td>
					<td class="thcenter row_2">${ggfwlistOne.ttndljwc}</td>
					<td class="thcenter row_3">${ggfwlistOne.yddyljwntz - ggfwlisttwo.yddyljwntz}</td>
					<td class="thcenter row_4">${ggfwlistOne.zjxq}</td>
					<td class="thcenter row_5">${ggfwlistOne.yddyljwntz}</td>
					<td class="thcenter">
						<c:if test="${ggfwlistOne.yddyljwntz == 0}">
							0
						</c:if>	
						<c:if test="${ggfwlistOne.yddyljwntz != 0}">				
							${ggfwlistOne.zjxq/ggfwlistOne.yddyljwntz}
						</c:if>
					</td>
				</tr>
			</tbody>
		</table>
		</div>
		<!-- 分页代码 -->
		<table:page page="${page}"></table:page>
		<br/>
		<br/>
<script>
$(function(){
	jsq();
})
function jsq(){
	
	for(var i = 1; i < 6; i++) {
        $(".row_" + i).each(function(){
            $(this).bind("change", function () {
                if($(this).hasClass("row_1")){
                    calcuSum(1);
                }else if($(this).hasClass("row_2")){
                    calcuSum(2);
                }else if($(this).hasClass("row_3")){
                    calcuSum(3);
                }else if($(this).hasClass("row_4")){
                    calcuSum(4);
                }else if($(this).hasClass("row_5")){
                    calcuSum(5);
                }else {}
            });
        });

        //加载完先调用一次
        calcuSum(i);
    }
}
function calcuSum(index){
    var rows = $(".row_" + index);
    var result = 0;
    var subSum1 = 0;
    var subSum1_1 = 0;
    var subSum1_1_1 = 0;
    var subSum1_1_2 = 0;
    var subSum1_2 = 0;
    var subSum1_3 = 0;
    var subSum2 = 0;
    var subSum3 = 0;
    var subSum3_1 = 0;
    var subSum3_2 = 0;
    var subSum3_3 = 0;
    var subSum3_4 = 0;
    var subSum4 = 0;
    var subSum4_1 = 0;
    var subSum5 = 0;
    var subSum6 = 0;
    debugger;
    for(var i = 0; i < rows.length; i++){
        var value = $(rows[i]).text();
        if(value != null && value != ''){
            result += value / 1;
            // 统计分类小项
            if(i >= 0 && i <= 6 ){
                subSum1_1_1 += value / 1;
            }else if(i==7){
            	subSum1_1_2= value / 1;
            }else if(i >= 8 && i <= 14){
                subSum1_2 += value / 1;
            }else if(i ==15){
                subSum1_3 += value / 1;
            }else if(i >=16 && i<=17){
                subSum2 += value / 1;
            }else if(i >=18 && i<=23){
                subSum3_1 += value / 1;
            }else if(i >=24 && i<=29){
                subSum3_2 += value / 1;
            }else if(i == 30){
                subSum3_3 += value / 1;
            }else if(i ==31){
                subSum3_4 += value / 1;
            }else if(i >=32 && i<=33){
                subSum4_1 += value / 1;
            }else if(i == 34){
                subSum5 += value / 1;
            }else if(i >=35 && i<=37){
                subSum6 += value / 1;
            }
        }
    }
    debugger;
    $(".sum" + index).html(subSum1_1_1);
    
}
</script>