/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.szdxm.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.config.Global;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.modules.szdxm.entity.CInsSzdxm;
import com.jeeplus.modules.szdxm.service.CInsSzdxmService;
import com.jeeplus.modules.zyysnxm.entity.CInsZyysnxm;

/**
 * 重点项目Controller
 * @author zgl
 * @version 2017-12-01
 */
@Controller
@RequestMapping(value = "${adminPath}/szdxm/cInsSzdxm")
public class CInsSzdxmController extends BaseController {

	@Autowired
	private CInsSzdxmService cInsSzdxmService;
	
	private List<String> xAxisData;
	private Map<String,List<Double>> yAxisData;
	private List<String> xAxisData2;
	private Map<String,List<Double>> yAxisData2;
	private Map<String,Integer> yAxisIndex;
	
	@RequestMapping(value = {"index", ""})
	public String index(CInsSzdxm cInsSzdxm, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		//x轴数据
		request.setAttribute("xAxisData", getxAxisData());
		//y轴数据
		request.setAttribute("yAxisData", getyAxisData());
		//x轴数据
		request.setAttribute("xAxisData2", getxAxisData2());
		//y轴数据
		request.setAttribute("yAxisData2", getyAxisData2());
		//Y轴双轴情况下的位置定位
		request.setAttribute("yAxisIndex", getyAxisIndex());
		
		//重点项目
		//装备制造业项目
		String zbzzhylb = "101010101";
		List<Map<String,Object>> zbzzylist = cInsSzdxmService.findPageByhylb(zbzzhylb);
		List<Map<String,Object>> zbzzylistOne = cInsSzdxmService.findListByhylb(zbzzhylb);
		List<Map<String,Object>> zbzzylisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("zbzzylisttwo", zbzzylisttwo.get(0));
		model.addAttribute("zbzzylistOne", zbzzylistOne.get(0));
		model.addAttribute("zbzzsize", zbzzylist.size());
		//新型材料业项目
		String xxclyhylb = "101010102";
		List<Map<String,Object>> xxclylist = cInsSzdxmService.findPageByhylb(xxclyhylb);
		model.addAttribute("xxclysize", xxclylist.size());
		List<Map<String,Object>> xxclylistOne = cInsSzdxmService.findListByhylb(xxclyhylb);
		model.addAttribute("xxclylistOne", xxclylistOne.get(0));
		List<Map<String,Object>> xxclylisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("xxclylisttwo", xxclylisttwo.get(0));
		//电子信息业项目
		String dzxxyhylb = "101010103";
		List<Map<String,Object>> dzxxylist = cInsSzdxmService.findPageByhylb(dzxxyhylb);
		model.addAttribute("dzxxysize", dzxxylist.size());
		List<Map<String,Object>> dzxxylistOne = cInsSzdxmService.findListByhylb(dzxxyhylb);
		model.addAttribute("dzxxylistOne", dzxxylistOne.get(0));
		List<Map<String,Object>> dzxxylisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("dzxxylisttwo", dzxxylisttwo.get(0));
		//建筑业项目
		String jzyhylb = "101010104";
		List<Map<String,Object>> jzylist = cInsSzdxmService.findPageByhylb(jzyhylb);
		model.addAttribute("jzysize", jzylist.size());
		List<Map<String,Object>>jzylistOne = cInsSzdxmService.findListByhylb(jzyhylb);
		model.addAttribute("jzylistOne", jzylistOne.get(0));
		List<Map<String,Object>> jzylisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("jzylisttwo", jzylisttwo.get(0));
		//绿色食品业项目
		String lsspyhylb = "101010105";
		List<Map<String,Object>> lsspylist = cInsSzdxmService.findPageByhylb(lsspyhylb);
		model.addAttribute("lsspysize", lsspylist.size());
		List<Map<String,Object>> lsspylistOne = cInsSzdxmService.findListByhylb(lsspyhylb);
		model.addAttribute("lsspylistOne", lsspylistOne.get(0));
		List<Map<String,Object>> lsspylisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("lsspylisttwo", lsspylisttwo.get(0));
		//汽车制造项目
		String qczzyhylb = "101010106";
		List<Map<String,Object>> qczzylist = cInsSzdxmService.findPageByhylb(qczzyhylb);
		model.addAttribute("qczzysize", qczzylist.size());
		List<Map<String,Object>> qczzylistOne = cInsSzdxmService.findListByhylb(qczzyhylb);
		model.addAttribute("qczzylistOne", qczzylistOne.get(0));
		List<Map<String,Object>> qczzylisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("qczzylisttwo", qczzylisttwo.get(0));
		//生物医药项目
		String swzyhylb = "101010107";
		List<Map<String,Object>> swzylist = cInsSzdxmService.findPageByhylb(swzyhylb);
		model.addAttribute("swzysize", swzylist.size());
		List<Map<String,Object>> swzylistOne = cInsSzdxmService.findListByhylb(swzyhylb);
		model.addAttribute("swzylistOne", swzylistOne.get(0));
		List<Map<String,Object>> swzylisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("swzylisttwo", swzylisttwo.get(0));
		//传统工业升级项目
		String ctgysjhylb = "101010201";
		List<Map<String,Object>> ctgysjlist = cInsSzdxmService.findPageByhylb(ctgysjhylb);
		model.addAttribute("ctgysjsize", ctgysjlist.size());
		List<Map<String,Object>> ctgysjlistOne = cInsSzdxmService.findListByhylb(ctgysjhylb);
		model.addAttribute("ctgysjlistOne", ctgysjlistOne.get(0));
		List<Map<String,Object>> ctgysjlisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("ctgysjlisttwo", ctgysjlisttwo.get(0));
		//物流项目
		String wlxmhylb = "101020101";
		List<Map<String,Object>> wlxmlist = cInsSzdxmService.findPageByhylb(wlxmhylb);
		model.addAttribute("wlxmsize", wlxmlist.size());
		List<Map<String,Object>> wlxmlistOne = cInsSzdxmService.findListByhylb(wlxmhylb);
		model.addAttribute("wlxmlistOne", wlxmlistOne.get(0));
		List<Map<String,Object>> wlxmlisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("wlxmlisttwo", wlxmlisttwo.get(0));
		//金融项目
		String jrxmhylb = "101020201";
		List<Map<String,Object>> jrxmlist = cInsSzdxmService.findPageByhylb(jrxmhylb);
		model.addAttribute("jrxmsize", jrxmlist.size());
		List<Map<String,Object>> jrxmlistOne = cInsSzdxmService.findListByhylb(jrxmhylb);
		model.addAttribute("jrxmlistOne", jrxmlistOne.get(0));
		List<Map<String,Object>> jrxmlisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("jrxmlisttwo", jrxmlisttwo.get(0));
		//科技服务项目
		String kjfwhylb = "101020301";
		List<Map<String,Object>> kjfwlist = cInsSzdxmService.findPageByhylb(kjfwhylb);
		model.addAttribute("kjfwsize", kjfwlist.size());
		List<Map<String,Object>> kjfwlistOne = cInsSzdxmService.findListByhylb(kjfwhylb);
		model.addAttribute("kjfwlistOne", kjfwlistOne.get(0));
		List<Map<String,Object>> kjfwlisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("kjfwlisttwo", kjfwlisttwo.get(0));
		//信息服务项目
		String xxfwhylb = "101020401";
		List<Map<String,Object>> xxfwlist = cInsSzdxmService.findPageByhylb(xxfwhylb);
		model.addAttribute("xxfwsize", xxfwlist.size());
		List<Map<String,Object>> xxfwlistOne = cInsSzdxmService.findListByhylb(xxfwhylb);
		model.addAttribute("xxfwlistOne", xxfwlistOne.get(0));
		List<Map<String,Object>> xxfwlisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("xxfwlisttwo", xxfwlisttwo.get(0));
		//商贸商务项目
		String smswhylb = "101020501";
		List<Map<String,Object>> smswlist = cInsSzdxmService.findPageByhylb(smswhylb);
		model.addAttribute("smswsize", smswlist.size());
		List<Map<String,Object>> smswlistOne = cInsSzdxmService.findListByhylb(smswhylb);
		model.addAttribute("smswlistOne", smswlistOne.get(0));
		List<Map<String,Object>> smswlisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("smswlisttwo", smswlisttwo.get(0));
		//文化旅游项目
		String whlyhylb = "101020601";
		List<Map<String,Object>> whlylist = cInsSzdxmService.findPageByhylb(whlyhylb);
		model.addAttribute("whlysize", whlylist.size());
		List<Map<String,Object>> whlylistOne = cInsSzdxmService.findListByhylb(whlyhylb);
		model.addAttribute("whlylistOne", whlylistOne.get(0));
		List<Map<String,Object>> whlylisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("whlylisttwo", whlylisttwo.get(0));
		//健康养老项目
		String jkylhylb = "101020701";
		List<Map<String,Object>> jkyllist = cInsSzdxmService.findPageByhylb(jkylhylb);
		model.addAttribute("jkylsize", jkyllist.size());
		List<Map<String,Object>> jkyllistOne = cInsSzdxmService.findListByhylb(jkylhylb);
		model.addAttribute("jkyllistOne", jkyllistOne.get(0));
		List<Map<String,Object>> jkyllisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("jkyllisttwo", jkyllisttwo.get(0));
		//双创平台项目
		String scpthylb = null;
		List<Map<String,Object>> scptlist = cInsSzdxmService.findPageByhylb(scpthylb);
		model.addAttribute("scptsize", scptlist.size());
		List<Map<String,Object>> scptlistOne = cInsSzdxmService.findListByhylb(scpthylb);
		model.addAttribute("scptlistOne", scptlistOne.get(0));
		List<Map<String,Object>> scptlisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("scptlisttwo", scptlisttwo.get(0));
		//研发平台项目
		String yfpthylb = null;
		List<Map<String,Object>> yfptlist = cInsSzdxmService.findPageByhylb(yfpthylb);
		model.addAttribute("yfptsize", yfptlist.size());
		List<Map<String,Object>> yfptlistOne = cInsSzdxmService.findListByhylb(yfpthylb);
		model.addAttribute("yfptlistOne", yfptlistOne.get(0));
		List<Map<String,Object>> yfptlisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("yfptlisttwo", yfptlisttwo.get(0));
		//铁路项目
		String tlxmhylb = null;
		List<Map<String,Object>> tlxmlist = cInsSzdxmService.findPageByhylb(tlxmhylb);
		model.addAttribute("tlxmsize", tlxmlist.size());
		List<Map<String,Object>> tlxmlistOne = cInsSzdxmService.findListByhylb(tlxmhylb);
		model.addAttribute("tlxmlistOne", tlxmlistOne.get(0));
		List<Map<String,Object>> tlxmlisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("tlxmlisttwo", tlxmlisttwo.get(0));
		//高速公路项目
		String gsglhylb = null;
		List<Map<String,Object>> gsgllist = cInsSzdxmService.findPageByhylb(gsglhylb);
		model.addAttribute("gsglsize", gsgllist.size());
		List<Map<String,Object>> gsgllistOne = cInsSzdxmService.findListByhylb(gsglhylb);
		model.addAttribute("gsgllistOne", gsgllistOne.get(0));
		List<Map<String,Object>> gsgllisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("gsgllisttwo", gsgllisttwo.get(0));
		//普通公路项目
		String ptglhylb = null;
		List<Map<String,Object>> ptgllist = cInsSzdxmService.findPageByhylb(ptglhylb);
		model.addAttribute("ptglsize", ptgllist.size());
		List<Map<String,Object>> ptgllistOne = cInsSzdxmService.findListByhylb(ptglhylb);
		model.addAttribute("ptgllistOne", ptgllistOne.get(0));
		List<Map<String,Object>> ptgllisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("ptgllisttwo", ptgllisttwo.get(0));
		//机场项目
		String jcxmhylb = null;
		List<Map<String,Object>> jcxmlist = cInsSzdxmService.findPageByhylb(jcxmhylb);
		model.addAttribute("jcxmsize", jcxmlist.size());
		List<Map<String,Object>> jcxmlistOne = cInsSzdxmService.findListByhylb(jcxmhylb);
		model.addAttribute("jcxmlistOne", jcxmlistOne.get(0));
		List<Map<String,Object>> jcxmlisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("jcxmlisttwo", jcxmlisttwo.get(0));
		//港口航道项目
		String gkhdhylb = null;
		List<Map<String,Object>> gkhdlist = cInsSzdxmService.findPageByhylb(gkhdhylb);
		model.addAttribute("gkhdsize", gkhdlist.size());
		List<Map<String,Object>> gkhdlistOne = cInsSzdxmService.findListByhylb(gkhdhylb);
		model.addAttribute("gkhdlistOne", gkhdlistOne.get(0));
		List<Map<String,Object>> gkhdlisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("gkhdlisttwo", gkhdlisttwo.get(0));
		//交通枢纽项目
		String jtsnhylb = null;
		List<Map<String,Object>> jtsnlist = cInsSzdxmService.findPageByhylb(jtsnhylb);
		model.addAttribute("jtsnsize", jtsnlist.size());
		List<Map<String,Object>> jtsnlistOne = cInsSzdxmService.findListByhylb(jtsnhylb);
		model.addAttribute("jtsnlistOne", jtsnlistOne.get(0));
		List<Map<String,Object>> jtsnlisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("jtsnlisttwo", jtsnlisttwo.get(0));
		//电源项目
		String dyxmhylb = null;
		List<Map<String,Object>> dyxmlist = cInsSzdxmService.findPageByhylb(dyxmhylb);
		model.addAttribute("dyxmsize", dyxmlist.size());
		List<Map<String,Object>> dyxmlistOne = cInsSzdxmService.findListByhylb(dyxmhylb);
		model.addAttribute("dyxmlistOne", dyxmlistOne.get(0));
		List<Map<String,Object>> dyxmlisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("dyxmlisttwo", dyxmlisttwo.get(0));
		//电网项目
		String dwxmhylb = null;
		List<Map<String,Object>> dwxmlist = cInsSzdxmService.findPageByhylb(dwxmhylb);
		model.addAttribute("dwxmsize", dwxmlist.size());
		List<Map<String,Object>> dwxmlistOne = cInsSzdxmService.findListByhylb(dwxmhylb);
		model.addAttribute("dwxmlistOne", dwxmlistOne.get(0));
		List<Map<String,Object>> dwxmlisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("dwxmlisttwo", dwxmlisttwo.get(0));
		//新能源项目
		String xnyhylb = null;
		List<Map<String,Object>> xnylist = cInsSzdxmService.findPageByhylb(xnyhylb);
		model.addAttribute("xnysize", xnylist.size());
		List<Map<String,Object>> xnylistOne = cInsSzdxmService.findListByhylb(xnyhylb);
		model.addAttribute("xnylistOne", xnylistOne.get(0));
		List<Map<String,Object>> xnylisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("xnylisttwo", xnylisttwo.get(0));
		//油气管道项目
		String yqgdhylb = null;
		List<Map<String,Object>> yqgdlist = cInsSzdxmService.findPageByhylb(yqgdhylb);
		model.addAttribute("yqgdsize", yqgdlist.size());
		List<Map<String,Object>> yqgdlistOne = cInsSzdxmService.findListByhylb(yqgdhylb);
		model.addAttribute("yqgdlistOne", yqgdlistOne.get(0));
		List<Map<String,Object>> yqgdlisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("yqgdlisttwo", yqgdlisttwo.get(0));
		//炼油设施项目
		String lysshylb = null;
		List<Map<String,Object>> lysslist = cInsSzdxmService.findPageByhylb(lysshylb);
		model.addAttribute("lysssize", lysslist.size());
		List<Map<String,Object>> lysslistOne = cInsSzdxmService.findListByhylb(lysshylb);
		model.addAttribute("lysslistOne", lysslistOne.get(0));
		List<Map<String,Object>> lysslisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("lysslisttwo", lysslisttwo.get(0));
		//煤炭储配园区项目
		String mtcbhylb = null;
		List<Map<String,Object>> mtcblist = cInsSzdxmService.findPageByhylb(mtcbhylb);
		model.addAttribute("mtcbsize", mtcblist.size());
		List<Map<String,Object>> mtcblistOne = cInsSzdxmService.findListByhylb(mtcbhylb);
		model.addAttribute("mtcblistOne", mtcblistOne.get(0));
		List<Map<String,Object>> mtcblisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("mtcblisttwo", mtcblisttwo.get(0));
		//信息通信项目
		String xxtxhylb = null;
		List<Map<String,Object>> xxtxlist = cInsSzdxmService.findPageByhylb(xxtxhylb);
		model.addAttribute("xxtxsize", xxtxlist.size());
		List<Map<String,Object>> xxtxlistOne = cInsSzdxmService.findListByhylb(xxtxhylb);
		model.addAttribute("xxtxlistOne", xxtxlistOne.get(0));
		List<Map<String,Object>> xxtxlisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("xxtxlisttwo", xxtxlisttwo.get(0));
		//水利项目
		String slxmhylb = null;
		List<Map<String,Object>> slxmlist = cInsSzdxmService.findPageByhylb(slxmhylb);
		model.addAttribute("slxmsize", slxmlist.size());
		List<Map<String,Object>> slxmlistOne = cInsSzdxmService.findListByhylb(slxmhylb);
		model.addAttribute("slxmlistOne", slxmlistOne.get(0));
		List<Map<String,Object>> slxmlisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("slxmlisttwo", slxmlisttwo.get(0));
		//百城提质项目
		String bctzhylb = null;
		List<Map<String,Object>> bctzlist = cInsSzdxmService.findPageByhylb(bctzhylb);
		model.addAttribute("bctzsize", bctzlist.size());
		List<Map<String,Object>> bctzlistOne = cInsSzdxmService.findListByhylb(bctzhylb);
		model.addAttribute("bctzlistOne", bctzlistOne.get(0));
		List<Map<String,Object>> bctzlisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("bctzlisttwo", bctzlisttwo.get(0));
		//城市基础能力提升项目
		String csjchylb = null;
		List<Map<String,Object>> csjclist = cInsSzdxmService.findPageByhylb(csjchylb);
		model.addAttribute("csjcsize", csjclist.size());
		List<Map<String,Object>> csjclistOne = cInsSzdxmService.findListByhylb(csjchylb);
		model.addAttribute("csjclistOne", csjclistOne.get(0));
		List<Map<String,Object>> csjclisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("csjclisttwo", csjclisttwo.get(0));
		//生态环保项目
		String sthbhylb = null;
		List<Map<String,Object>> sthblist = cInsSzdxmService.findPageByhylb(sthbhylb);
		model.addAttribute("sthbsize", sthblist.size());
		List<Map<String,Object>> sthblistOne = cInsSzdxmService.findListByhylb(sthbhylb);
		model.addAttribute("sthblistOne", sthblistOne.get(0));
		List<Map<String,Object>> sthblisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("sthblisttwo", sthblisttwo.get(0));
		//扶贫搬迁和滩区迁建项目
		String fpbqhylb = null;
		List<Map<String,Object>> fpbqlist = cInsSzdxmService.findPageByhylb(fpbqhylb);
		model.addAttribute("fpbqsize", fpbqlist.size());
		List<Map<String,Object>> fpbqlistOne = cInsSzdxmService.findListByhylb(fpbqhylb);
		model.addAttribute("fpbqlistOne", fpbqlistOne.get(0));
		List<Map<String,Object>> fpbqlisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("fpbqlisttwo", fpbqlisttwo.get(0));
		//教育能力提升项目
		String jytshylb = null;
		List<Map<String,Object>> jytslist = cInsSzdxmService.findPageByhylb(jytshylb);
		model.addAttribute("jytssize", jytslist.size());
		List<Map<String,Object>> jytslistOne = cInsSzdxmService.findListByhylb(jytshylb);
		model.addAttribute("jytslistOne", jytslistOne.get(0));
		List<Map<String,Object>> jytslisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("jytslisttwo", jytslisttwo.get(0));
		//医疗能力提升项目
		String yltshylb = null;
		List<Map<String,Object>> yltslist = cInsSzdxmService.findPageByhylb(yltshylb);
		model.addAttribute("yltssize", yltslist.size());
		List<Map<String,Object>> yltslistOne = cInsSzdxmService.findListByhylb(yltshylb);
		model.addAttribute("yltslistOne", yltslistOne.get(0));
		List<Map<String,Object>> yltslisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("yltslisttwo", yltslisttwo.get(0));
		//公共服务能力提升项目
		String ggfwhylb = null;
		List<Map<String,Object>> ggfwlist = cInsSzdxmService.findPageByhylb(ggfwhylb);
		model.addAttribute("ggfwsize", ggfwlist.size());
		List<Map<String,Object>> ggfwlistOne = cInsSzdxmService.findListByhylb(ggfwhylb);
		model.addAttribute("ggfwlistOne", ggfwlistOne.get(0));
		List<Map<String,Object>> ggfwlisttwo = cInsSzdxmService.findListByhylb2(zbzzhylb);
		model.addAttribute("ggfwlisttwo", ggfwlisttwo.get(0));
		
		
		Page<CInsSzdxm> page = cInsSzdxmService.findPage(new Page<CInsSzdxm>(request, response), cInsSzdxm);
		System.out.println(page.getCount());
		model.addAttribute("page", page);
		
		/*//折线图列表数据
		//X轴的数据
		List<String> xAxisData= new ArrayList<String>();
		//Y轴的数据
		Map<String,List<Double>> yAxisData = new HashMap<String,List<Double>>();
		//Y轴双轴情况下的位置定位
		Map<String,Integer> yAxisIndex = new HashMap<String,Integer>();*/
		
		List<CInsSzdxm> CInsSzdxmList= cInsSzdxmService.findList(cInsSzdxm);
		
		List<String> hyname = new ArrayList<String>();
		List<String> xmgs = new ArrayList<String>();
		List<String> ztz = new ArrayList<String>();
		List<String> ndjhtz = new ArrayList<String>();
		List<String> ywctz = new ArrayList<String>();
		List<String> bndywctz = new ArrayList<String>();
		List<String> ykgxmgs = new ArrayList<String>();
		List<String> ywgxmgs = new ArrayList<String>();
		List<String> tzwcl = new ArrayList<String>();
		List<String> ndtzwcl = new ArrayList<String>();
		List<String> ykgzykgbl = new ArrayList<String>();
		List<String> ywgzywgbl = new ArrayList<String>();
		
		for(CInsSzdxm CInsSzdxmTemp:CInsSzdxmList){
			
			
			hyname.add(CInsSzdxmTemp.getHyname());
			xmgs.add(CInsSzdxmTemp.getXmgs());
			ztz.add(CInsSzdxmTemp.getZtz());
			ndjhtz.add(CInsSzdxmTemp.getNdjhtz());
			ywctz.add(CInsSzdxmTemp.getYwctz());
			bndywctz.add(CInsSzdxmTemp.getBndywctz());
			ykgxmgs.add(CInsSzdxmTemp.getYkgxmgs());
			ywgxmgs.add(CInsSzdxmTemp.getYwgxmgs());
			tzwcl.add(CInsSzdxmTemp.getTzwcl());
			ndtzwcl.add(CInsSzdxmTemp.getNdtzwcl());
			ykgzykgbl.add(CInsSzdxmTemp.getYkgzykgbl());
			ywgzywgbl.add(CInsSzdxmTemp.getYwgzywgbl());
			
		}
		
		return "modules/szdxm/cInsSzdxmList";
	}
	
	
	public List<String> getxAxisData(){
		xAxisData = new ArrayList<String>();
		
		xAxisData.add("郑州市");
		xAxisData.add("开封市");
		xAxisData.add("洛阳市");
		xAxisData.add("平顶山市");
		xAxisData.add("安阳市");
		xAxisData.add("鹤壁市");
		xAxisData.add("新乡市");
		xAxisData.add("焦作市");
		xAxisData.add("濮阳市");
		xAxisData.add("许昌市");
		xAxisData.add("漯河市");
		xAxisData.add("三门峡市");
		xAxisData.add("南阳市");
		xAxisData.add("商丘市");
		xAxisData.add("信阳市");
		xAxisData.add("周口市");
		xAxisData.add("驻马店市");
		xAxisData.add("济源市");
		xAxisData.add("巩义市");
		xAxisData.add("兰考县");
		xAxisData.add("汝州市");
		xAxisData.add("滑县");
		xAxisData.add("长垣县");
		xAxisData.add("邓州市");
		xAxisData.add("永城市");
		xAxisData.add("固始县");
		xAxisData.add("鹿邑县");
		xAxisData.add("新蔡县");
		return xAxisData;
	}
	
	public Map<String,List<Double>> getyAxisData(){
		Random random = new Random();
		yAxisData = new HashMap<String,List<Double>>();
		
		List<Double> data1 = new ArrayList<Double>();
		data1.add(2945.0);
		data1.add(1645.0);
		data1.add(1545.0);
		data1.add(1045.0);
		data1.add(2045.0);
		data1.add(1245.0);
		data1.add(945.0);
		data1.add(745.0);
		data1.add(1035.0);
		data1.add(945.0);
		data1.add(565.0);
		data1.add(1745.0);
		data1.add(745.0);
		data1.add(1900.0);
		data1.add(1267.0);
		data1.add(1869.0);
		data1.add(667.0);
		data1.add(845.0);
		data1.add(1299.0);
		data1.add(774.0);
		data1.add(334.0);
		data1.add(854.0);
		data1.add(734.0);
		data1.add(945.0);
		data1.add(565.0);
		data1.add(1045.0);
		data1.add(745.0);
		data1.add(1945.0);
		
		yAxisData.put("省重点项目", data1);
		
	/*	List<Double> data2 = new ArrayList<Double>();
		data2.add(random.nextDouble());
		data2.add(random.nextDouble());
		data2.add(random.nextDouble());
		data2.add(random.nextDouble());
		data2.add(random.nextDouble());
		yAxisData.put("柱状二", data2);*/
		
		return yAxisData;
	}

	public List<String> getxAxisData2(){
		xAxisData2 = new ArrayList<String>();
		xAxisData2.add("农林水利");
		xAxisData2.add("能源");
		xAxisData2.add("城市基础设施");
		xAxisData2.add("社会事业");
		xAxisData2.add("高技术");
		xAxisData2.add("信息化");
		xAxisData2.add("环保");
		xAxisData2.add("工业");
		xAxisData2.add("仓储物流");
		xAxisData2.add("交通运输");
		xAxisData2.add("公检司法");
		xAxisData2.add("科学");
		xAxisData2.add("其他");
		xAxisData2.add("境外投资");
		xAxisData2.add("医药");
		xAxisData2.add("地质");
		
		return xAxisData2;
	}
	
	public Map<String,List<Double>> getyAxisData2(){
		Random random = new Random();
		yAxisData2 = new HashMap<String,List<Double>>();
		
		List<Double> data1 = new ArrayList<Double>();
		data1.add(1345.0);
		data1.add(1645.0);
		data1.add(745.0);
		data1.add(845.0);
		data1.add(2745.0);
		data1.add(1245.0);
		data1.add(2045.0);
		data1.add(745.0);
		data1.add(1035.0);
		data1.add(945.0);
		data1.add(565.0);
		data1.add(1045.0);
		data1.add(745.0);
		data1.add(1945.0);
		data1.add(945.0);
		data1.add(2445.0);
		
		yAxisData2.put("省重点项目", data1);
		
	/*	List<Double> data2 = new ArrayList<Double>();
		data2.add(random.nextDouble());
		data2.add(random.nextDouble());
		data2.add(random.nextDouble());
		data2.add(random.nextDouble());
		data2.add(random.nextDouble());
		yAxisData.put("柱状二", data2);*/
		
		return yAxisData2;
	}
	
	
	public Map<String,Integer> getyAxisIndex(){
		yAxisIndex = new HashMap<String,Integer>();
		yAxisIndex.put("省重点项目", 0);
		/*yAxisIndex.put("柱状二", 1);*/
		return yAxisIndex;
	}
	
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("szdxm:cInsSzdxm:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(CInsSzdxm cInsSzdxm, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "重点项目"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<CInsSzdxm> page = cInsSzdxmService.findPage(new Page<CInsSzdxm>(request, response, -1), cInsSzdxm);
    		new ExportExcel("重点项目", CInsSzdxm.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出重点项目记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/szdxm/cInsSzdxm/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("szdxm:cInsSzdxm:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<CInsSzdxm> list = ei.getDataList(CInsSzdxm.class);
			for (CInsSzdxm cInsSzdxm : list){
				try{
					cInsSzdxmService.save(cInsSzdxm);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条重点项目记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条重点项目记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入重点项目失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/szdxm/cInsSzdxm/?repage";
    }
	
	/**
	 * 下载导入重点项目数据模板
	 */
	@RequiresPermissions("szdxm:cInsSzdxm:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "重点项目数据导入模板.xlsx";
    		List<CInsSzdxm> list = Lists.newArrayList(); 
    		new ExportExcel("重点项目数据", CInsSzdxm.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/szdxm/cInsSzdxm/?repage";
    }
	
	
	

}