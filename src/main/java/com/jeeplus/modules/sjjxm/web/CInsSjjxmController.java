/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sjjxm.web;

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
import com.jeeplus.modules.sjjxm.entity.CInsSjjxm;
import com.jeeplus.modules.sjjxm.service.CInsSjjxmService;
import com.jeeplus.modules.zyysnxm.entity.CInsZyysnxm;

/**
 * 省基建项目Controller
 * @author zgl
 * @version 2017-12-02
 */
@Controller
@RequestMapping(value = "${adminPath}/sjjxm/cInsSjjxm")
public class CInsSjjxmController extends BaseController {

	@Autowired
	private CInsSjjxmService cInsSjjxmService;
	
	private List<String> xAxisData;
	private Map<String,List<Double>> yAxisData;
	private List<String> xAxisData2;
	private Map<String,List<Double>> yAxisData2;
	private Map<String,Integer> yAxisIndex;
	
	@RequestMapping(value = {"index", ""})
	public String index(CInsSjjxm cInsSjjxm, HttpServletRequest request, HttpServletResponse response, Model model) {
		/*
		//x轴数据
		request.setAttribute("xAxisData", getxAxisData());
		//y轴数据
		request.setAttribute("yAxisData", getyAxisData());*/
		//x轴数据
		request.setAttribute("xAxisData2", getxAxisData2());
		//y轴数据
		request.setAttribute("yAxisData2", getyAxisData2());
		//Y轴双轴情况下的位置定位
		request.setAttribute("yAxisIndex", getyAxisIndex());
		Page<CInsSjjxm> page = cInsSjjxmService.findPage(new Page<CInsSjjxm>(request, response), cInsSjjxm); 
		model.addAttribute("page", page);
		
		/*//折线图列表数据
		//X轴的数据
		List<String> xAxisData= new ArrayList<String>();
		//Y轴的数据
		Map<String,List<Double>> yAxisData = new HashMap<String,List<Double>>();
		//Y轴双轴情况下的位置定位
		Map<String,Integer> yAxisIndex = new HashMap<String,Integer>();*/
		
		List<CInsSjjxm> CInsSjjxmList= cInsSjjxmService.findList(cInsSjjxm);
		
		List<String> hnnameTemp = new ArrayList<String>();
		List<String> xmgsTemp = new ArrayList<String>();
		List<String> ztzTemp = new ArrayList<String>();
		List<String> xdtzzeTemp = new ArrayList<String>();
		List<String> xdtzSjjtzTemp = new ArrayList<String>();
		List<String> ykgxmgsTemp = new ArrayList<String>();
		List<String> ywgxmgsTemp = new ArrayList<String>();
		List<String> ztzwcqkTemp = new ArrayList<String>();
		List<String> sjjtzwcqkTemp = new ArrayList<String>();
		List<String> tzwclTemp = new ArrayList<String>();
		List<String> sjjtzwclTemp = new ArrayList<String>();
		List<String> ztzdwqkTemp = new ArrayList<String>();
		List<String> sjjtzdwqkTemp = new ArrayList<String>();
		List<String> zjdwlTemp = new ArrayList<String>();
		List<String> sjjtzdwlTemp = new ArrayList<String>();
		List<String> ztzzfqkTemp = new ArrayList<String>();
		List<String> sjjtzzfqkTemp = new ArrayList<String>();
		List<String> zjzflTemp = new ArrayList<String>();
		List<String> sjjtzzflTemp = new ArrayList<String>();
		List<String> kglTemp = new ArrayList<String>();
		List<String> wglTemp = new ArrayList<String>();
	
	
		
		for(CInsSjjxm CInsSjjxmTemp:CInsSjjxmList){
			
			
			hnnameTemp.add(CInsSjjxmTemp.getHnname());
			xmgsTemp.add(CInsSjjxmTemp.getXmgs());
			ztzTemp.add(CInsSjjxmTemp.getZtz());
			xdtzzeTemp.add(CInsSjjxmTemp.getXdtzze());
			xdtzSjjtzTemp.add(CInsSjjxmTemp.getXdtzSjjtz());
			ykgxmgsTemp.add(CInsSjjxmTemp.getYkgxmgs());
			ywgxmgsTemp.add(CInsSjjxmTemp.getYwgxmgs());
			ztzwcqkTemp.add(CInsSjjxmTemp.getZtzwcqk());
			sjjtzwcqkTemp.add(CInsSjjxmTemp.getSjjtzwcqk());
			tzwclTemp.add(CInsSjjxmTemp.getTzwcl());
			sjjtzwclTemp.add(CInsSjjxmTemp.getSjjtzwcl());
			ztzdwqkTemp.add(CInsSjjxmTemp.getZtzdwqk());
			sjjtzdwqkTemp.add(CInsSjjxmTemp.getSjjtzdwqk());
			zjdwlTemp.add(CInsSjjxmTemp.getZjdwl());
			sjjtzdwlTemp.add(CInsSjjxmTemp.getSjjtzdwl());
			ztzzfqkTemp.add(CInsSjjxmTemp.getZtzzfqk());
			sjjtzzfqkTemp.add(CInsSjjxmTemp.getSjjtzzfqk());
			zjzflTemp.add(CInsSjjxmTemp.getZjzfl());
			sjjtzzflTemp.add(CInsSjjxmTemp.getSjjtzzfl());
			kglTemp.add(CInsSjjxmTemp.getKgl());
			wglTemp.add(CInsSjjxmTemp.getWgl());
			
		}
		
		
		
		
		
		return "modules/sjjxm/cInsSjjxmList";
	}
	
	
	/*public List<String> getxAxisData(){
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
		
		yAxisData.put("省基建项目", data1);*/
		
	/*	List<Double> data2 = new ArrayList<Double>();
		data2.add(random.nextDouble());
		data2.add(random.nextDouble());
		data2.add(random.nextDouble());
		data2.add(random.nextDouble());
		data2.add(random.nextDouble());
		yAxisData.put("柱状二", data2);
		
		return yAxisData;
	}*/

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
		
		yAxisData2.put("省基建项目数量", data1);
		
		
		return yAxisData2;
	}
	
	
	public Map<String,Integer> getyAxisIndex(){
		yAxisIndex = new HashMap<String,Integer>();
		yAxisIndex.put("省基建项目", 0);
		/*yAxisIndex.put("柱状二", 1);*/
		return yAxisIndex;
	}
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("sjjxm:cInsSjjxm:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(CInsSjjxm cInsSjjxm, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "省基建项目"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<CInsSjjxm> page = cInsSjjxmService.findPage(new Page<CInsSjjxm>(request, response, -1), cInsSjjxm);
    		new ExportExcel("省基建项目", CInsSjjxm.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出省基建项目记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/sjjxm/cInsSjjxm/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("sjjxm:cInsSjjxm:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<CInsSjjxm> list = ei.getDataList(CInsSjjxm.class);
			for (CInsSjjxm cInsSjjxm : list){
				try{
					cInsSjjxmService.save(cInsSjjxm);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条省基建项目记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条省基建项目记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入省基建项目失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/sjjxm/cInsSjjxm/?repage";
    }
	
	/**
	 * 下载导入省基建项目数据模板
	 */
	@RequiresPermissions("sjjxm:cInsSjjxm:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "省基建项目数据导入模板.xlsx";
    		List<CInsSjjxm> list = Lists.newArrayList(); 
    		new ExportExcel("省基建项目数据", CInsSjjxm.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/sjjxm/cInsSjjxm/?repage";
    }
	
	
	

}