/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.qtxm.web;

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
import com.jeeplus.modules.qtxm.entity.CInsJbxm;
import com.jeeplus.modules.qtxm.service.CInsJbxmService;
import com.jeeplus.modules.zyysnxm.entity.CInsZyysnxm;

/**
 * 其他项目Controller
 * @author zgl
 * @version 2017-12-02
 */
@Controller
@RequestMapping(value = "${adminPath}/qtxm/cInsJbxm")
public class CInsJbxmController extends BaseController {

	@Autowired
	private CInsJbxmService cInsJbxmService;
	
	
	private List<String> xAxisData;
	private Map<String,List<Double>> yAxisData;
	private List<String> xAxisData2;
	private Map<String,List<Double>> yAxisData2;
	private Map<String,Integer> yAxisIndex;
	
	@RequestMapping(value = {"index", ""})
	public String index(CInsJbxm cInsJbxm, HttpServletRequest request, HttpServletResponse response, Model model) {
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
		
		Page<CInsJbxm> page = cInsJbxmService.findPage(new Page<CInsJbxm>(request, response), cInsJbxm); 
		model.addAttribute("page", page);
		
		/*//折线图列表数据
		//X轴的数据
		List<String> xAxisData= new ArrayList<String>();
		//Y轴的数据
		Map<String,List<Double>> yAxisData = new HashMap<String,List<Double>>();
		//Y轴双轴情况下的位置定位
		Map<String,Integer> yAxisIndex = new HashMap<String,Integer>();*/
		
		List<CInsJbxm> CInsJbxmList= cInsJbxmService.findList(cInsJbxm);
		
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
		
		for(CInsJbxm CInsJbxmTemp:CInsJbxmList){
			
			
			hyname.add(CInsJbxmTemp.getHyname());
			xmgs.add(CInsJbxmTemp.getXmgs());
			ztz.add(CInsJbxmTemp.getZtz());
			ndjhtz.add(CInsJbxmTemp.getNdjhtz());
			ywctz.add(CInsJbxmTemp.getYwctz());
			bndywctz.add(CInsJbxmTemp.getBndywctz());
			ykgxmgs.add(CInsJbxmTemp.getYwgxmgs());
			ywgxmgs.add(CInsJbxmTemp.getYwgxmgs());
			tzwcl.add(CInsJbxmTemp.getTzwcl());
			ndtzwcl.add(CInsJbxmTemp.getNdtzwcl());
			ykgzykgbl.add(CInsJbxmTemp.getYkgzykgbl());
			ywgzywgbl.add(CInsJbxmTemp.getYwgzywgbl());
			
		}
		
		return "modules/qtxm/cInsJbxmList";
	}
	
/*	
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
		
		yAxisData.put("其他项目数量", data1);
		
		List<Double> data2 = new ArrayList<Double>();
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
		
		yAxisData2.put("其他项目", data1);
		
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
		yAxisIndex.put("其他项目数量", 0);
		/*yAxisIndex.put("柱状二", 1);*/
		return yAxisIndex;
	}
	
	
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("qtxm:cInsJbxm:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(CInsJbxm cInsJbxm, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "其他项目"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<CInsJbxm> page = cInsJbxmService.findPage(new Page<CInsJbxm>(request, response, -1), cInsJbxm);
    		new ExportExcel("其他项目", CInsJbxm.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出其他项目记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/qtxm/cInsJbxm/?repage";
    }

	

}