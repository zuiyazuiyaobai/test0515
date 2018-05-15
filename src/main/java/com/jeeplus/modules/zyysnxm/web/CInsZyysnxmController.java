/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.zyysnxm.web;

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
import com.jeeplus.modules.echarts.entity.ChinaWeatherDataBean;
import com.jeeplus.modules.zyysnxm.entity.CInsZyysnxm;
import com.jeeplus.modules.zyysnxm.service.CInsZyysnxmService;

/**
 * 中央预算内Controller
 * @author zgl
 * @version 2017-12-01
 */
@Controller
@RequestMapping(value = "${adminPath}/zyysnxm/cInsZyysnxm")
public class CInsZyysnxmController extends BaseController {

	@Autowired
	private CInsZyysnxmService cInsZyysnxmService;
	
	private List<String> xAxisData;
	private Map<String,List<Double>> yAxisData;
	private List<String> xAxisData2;
	private Map<String,List<Double>> yAxisData2;
	private Map<String,Integer> yAxisIndex;
	
	
	
	@RequestMapping(value = {"index", ""})
	public String index( CInsZyysnxm cInsZyysnxm,HttpServletRequest request, HttpServletResponse response, Model model) {
		
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
		
		Page<CInsZyysnxm> page = cInsZyysnxmService.findPage(new Page<CInsZyysnxm>(request, response), cInsZyysnxm); 
		model.addAttribute("page", page);
		
		/*//折线图列表数据
		//X轴的数据
		List<String> xAxisData= new ArrayList<String>();
		//Y轴的数据
		Map<String,List<Double>> yAxisData = new HashMap<String,List<Double>>();
		//Y轴双轴情况下的位置定位
		Map<String,Integer> yAxisIndex = new HashMap<String,Integer>();*/
		
		List<CInsZyysnxm> CInsZyysnxmList= cInsZyysnxmService.findList(cInsZyysnxm);
		
		List<String> zftzfxTemp = new ArrayList<String>();
		List<String> xmgsTemp = new ArrayList<String>();
		List<String> ztzTemp = new ArrayList<String>();
		List<String> xdtzzeTemp = new ArrayList<String>();
		List<String> xdtyysTemp = new ArrayList<String>();
		List<String> ykgxmgsTemp = new ArrayList<String>();
		List<String> ywgxmgsTemp = new ArrayList<String>();
		List<String> ztzwcqkTemp = new ArrayList<String>();
		List<String> zyyswcqkTemp = new ArrayList<String>();
		List<String> tzwclTemp = new ArrayList<String>();
		List<String> zyyswclTemp = new ArrayList<String>();
		List<String> ztzdwqkTemp = new ArrayList<String>();
		List<String> zyysndwqkTemp = new ArrayList<String>();
		List<String> zjdwqkTemp = new ArrayList<String>();
		List<String> zyysndwlTemp = new ArrayList<String>();
		List<String> ztzzfqkTemp = new ArrayList<String>();
		List<String> zyyszfqkTemp = new ArrayList<String>();
		List<String> zjzflTemp = new ArrayList<String>();
		List<String> zyyszflTemp = new ArrayList<String>();
		List<String> kglTemp = new ArrayList<String>();
		List<String> wglTemp = new ArrayList<String>();
	
	
		
		for(CInsZyysnxm CInsZyysnxmTemp:CInsZyysnxmList){
			
			
			zftzfxTemp.add(CInsZyysnxmTemp.getZftzfx());
			xmgsTemp.add(CInsZyysnxmTemp.getXmgs());
			ztzTemp.add(CInsZyysnxmTemp.getZtz());
			xdtzzeTemp.add(CInsZyysnxmTemp.getXdtzze());
			xdtyysTemp.add(CInsZyysnxmTemp.getXdtyys());
			ykgxmgsTemp.add(CInsZyysnxmTemp.getYkgxmgs());
			ywgxmgsTemp.add(CInsZyysnxmTemp.getYwgxmgs());
			ztzwcqkTemp.add(CInsZyysnxmTemp.getZtzwcqk());
			zyyswcqkTemp.add(CInsZyysnxmTemp.getZyyswcqk());
			tzwclTemp.add(CInsZyysnxmTemp.getTzwcl());
			zyyswclTemp.add(CInsZyysnxmTemp.getZyyswcl());
			ztzdwqkTemp.add(CInsZyysnxmTemp.getZtzdwqk());
			zyysndwqkTemp.add(CInsZyysnxmTemp.getZyysndwqk());
			zjdwqkTemp.add(CInsZyysnxmTemp.getZyysndwl());
			zyysndwlTemp.add(CInsZyysnxmTemp.getZyysndwl());
			ztzzfqkTemp.add(CInsZyysnxmTemp.getZtzzfqk());
			zyyszfqkTemp.add(CInsZyysnxmTemp.getZyyszfqk());
			zjzflTemp.add(CInsZyysnxmTemp.getZjzfl());
			zyyszflTemp.add(CInsZyysnxmTemp.getZyyszfl());
			kglTemp.add(CInsZyysnxmTemp.getKgl());
			wglTemp.add(CInsZyysnxmTemp.getWgl());
			
		}
		
		return "modules/zyysnxm/cInsZyysnxmList";
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
		
		yAxisData.put("中央预算内项目", data1);
		
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
		xAxisData2.add("先进制造业");
		xAxisData2.add("现代服务业");
		xAxisData2.add("现代农业");
		xAxisData2.add("网络经济");
		xAxisData2.add("现代综合交通");
		xAxisData2.add("现代能源");
		xAxisData2.add("水利");
		xAxisData2.add("生态环保");
		xAxisData2.add("城镇基础设施");
		xAxisData2.add("城镇基础设施");
		xAxisData2.add("郑州航空港经济综合实验区");
		xAxisData2.add("大众创业万众创新");
		xAxisData2.add("脱贫攻坚");
		xAxisData2.add("社会事业和民生改善");
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
		
		yAxisData2.put("中央预算内项目", data1);
		
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
		yAxisIndex.put("中央预算内项目数量", 0);
		/*yAxisIndex.put("柱状二", 1);*/
		return yAxisIndex;
	}
	
	
	@ModelAttribute
	public CInsZyysnxm get(@RequestParam(required=false) String id) {
		CInsZyysnxm entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cInsZyysnxmService.get(id);
		}
		if (entity == null){
			entity = new CInsZyysnxm();
		}
		return entity;
	}
	
	



	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("zyysnxm:cInsZyysnxm:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<CInsZyysnxm> list = ei.getDataList(CInsZyysnxm.class);
			for (CInsZyysnxm cInsZyysnxm : list){
				try{
					cInsZyysnxmService.save(cInsZyysnxm);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条中央预算内记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条中央预算内记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入中央预算内失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/zyysnxm/cInsZyysnxm/?repage";
    }
	
	/**
	 * 下载导入中央预算内数据模板
	 */
	@RequiresPermissions("zyysnxm:cInsZyysnxm:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "中央预算内数据导入模板.xlsx";
    		List<CInsZyysnxm> list = Lists.newArrayList(); 
    		new ExportExcel("中央预算内数据", CInsZyysnxm.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/zyysnxm/cInsZyysnxm/?repage";
    }
	
	
	

}