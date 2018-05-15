/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.wbybxm.web;

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
import com.jeeplus.modules.wbybxm.entity.CInsWbybxm;
import com.jeeplus.modules.wbybxm.service.CInsWbybxmService;
import com.jeeplus.modules.xmjbxx.service.XmjbxxService;
import com.jeeplus.modules.xmjbxx.vo.XmjbxxSearchParameter;
import com.jeeplus.modules.zyysnxm.entity.CInsZyysnxm;

/**
 * 5818项目Controller
 * @author zgl
 * @version 2017-12-02
 */
@Controller
@RequestMapping(value = "${adminPath}/wbybxm/cInsWbybxm")
public class CInsWbybxmController extends BaseController {

	@Autowired
	private CInsWbybxmService cInsWbybxmService;
	@Autowired
	private XmjbxxService xmjbxxService;

	private List<String> xAxisData;
	private Map<String,List<Double>> yAxisData;
	private List<String> xAxisData2;
	private Map<String,List<Double>> yAxisData2;
	private Map<String,Integer> yAxisIndex;
	
	@RequestMapping(value = {"index", ""})
	public String index(CInsWbybxm cInsWbybxm, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		//x轴数据
		request.setAttribute("xAxisData", getxAxisData()[0]);
		//y轴数据
		request.setAttribute("yAxisData", getxAxisData()[1]);
		//x轴数据
		request.setAttribute("xAxisData2", getxAxisData2()[0]);
		//y轴数据
		request.setAttribute("yAxisData2", getxAxisData2()[1]);
		//Y轴双轴情况下的位置定位
		request.setAttribute("yAxisIndex", getyAxisIndex());
		
		
		Page<CInsWbybxm> page = cInsWbybxmService.findPage(new Page<CInsWbybxm>(request, response), cInsWbybxm); 
		model.addAttribute("page", page);
		
		/*//折线图列表数据
		//X轴的数据
		List<String> xAxisData= new ArrayList<String>();
		//Y轴的数据
		Map<String,List<Double>> yAxisData = new HashMap<String,List<Double>>();
		//Y轴双轴情况下的位置定位
		Map<String,Integer> yAxisIndex = new HashMap<String,Integer>();*/
		
		List<CInsWbybxm> CInsWbybxmList= cInsWbybxmService.findList(cInsWbybxm);
		
		List<String> qhtypeTemp = new ArrayList<String>();
		List<String> qhnameTemp = new ArrayList<String>();
		List<String> xmgsTemp = new ArrayList<String>();
		List<String> ztzTemp = new ArrayList<String>();
		List<String> bndjhtzTemp = new ArrayList<String>();
		List<String> bndywctzTemp = new ArrayList<String>();
		List<String> ykgxmgsTemp = new ArrayList<String>();
		List<String> ywgxmgsTemp = new ArrayList<String>();
		List<String> ndtzwclTemp = new ArrayList<String>();
		List<String> kglTemp = new ArrayList<String>();
		List<String> wglTemp = new ArrayList<String>();
		
		for(CInsWbybxm CInsWbybxmTemp:CInsWbybxmList){
			
			
			qhtypeTemp.add(CInsWbybxmTemp.getQhtype());
			qhnameTemp.add(CInsWbybxmTemp.getQhname());
			ztzTemp.add(CInsWbybxmTemp.getZtz());
			xmgsTemp.add(CInsWbybxmTemp.getXmgs());
			ztzTemp.add(CInsWbybxmTemp.getZtz());
			bndjhtzTemp.add(CInsWbybxmTemp.getBndjhtz());
			ykgxmgsTemp.add(CInsWbybxmTemp.getYkgxmgs());
			ywgxmgsTemp.add(CInsWbybxmTemp.getYwgxmgs());
			ndtzwclTemp.add(CInsWbybxmTemp.getNdtzwcl());
			kglTemp.add(CInsWbybxmTemp.getKgl());
			wglTemp.add(CInsWbybxmTemp.getWgl());
			
		}
		
		
		return "modules/wbybxm/cInsWbybxmList";
	}
	
	
	public Object[] getxAxisData(){
		XmjbxxSearchParameter xmjbxxSearchParameter=new XmjbxxSearchParameter();
		xmjbxxSearchParameter.setCj("0");//借用的层级字段，其实只是传递一个参数
		List<Map<String, String>> list= xmjbxxService.findNumber(xmjbxxSearchParameter);
		
		xAxisData = new ArrayList<String>();
		yAxisData = new HashMap<String,List<Double>>();
		List<Double> data1 = new ArrayList<Double>();
		for(Map l:list){
			String name =(String) l.get("NAME");
			xAxisData.add(name);
			data1.add(Double.parseDouble(l.get("NUM").toString()));
		}
		yAxisData.put("5818项目数量", data1);
		Object[] objs=new Object[2];
		objs[0]=xAxisData;
		objs[1]=yAxisData;
		return objs;
	}
	public Object[] getxAxisData2(){
		XmjbxxSearchParameter xmjbxxSearchParameter=new XmjbxxSearchParameter();
		List<Map<String, String>> list=xmjbxxService.findNumberBySshy(xmjbxxSearchParameter);
		xAxisData2 = new ArrayList<String>();
		yAxisData2 = new HashMap<String,List<Double>>();
		List<Double> data1 = new ArrayList<Double>();
		for(Map l:list){
			String name =(String) l.get("NAME");
			xAxisData2.add(name);
			data1.add(Double.parseDouble(l.get("NUM").toString()));
		}
		yAxisData2.put("5818项目", data1);
		Object[] objs=new Object[2];
		objs[0]=xAxisData2;
		objs[1]=yAxisData2;
		return objs;
	}
	
/*	public Map<String,List<Double>> getyAxisData2(){
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
		
		yAxisData2.put("5818项目", data1);
		
		List<Double> data2 = new ArrayList<Double>();
		data2.add(random.nextDouble());
		data2.add(random.nextDouble());
		data2.add(random.nextDouble());
		data2.add(random.nextDouble());
		data2.add(random.nextDouble());
		yAxisData.put("柱状二", data2);
		
		return yAxisData2;
	}*/
	
	
	public Map<String,Integer> getyAxisIndex(){
		yAxisIndex = new HashMap<String,Integer>();
		yAxisIndex.put("5818项目项目数量", 0);
		/*yAxisIndex.put("柱状二", 1);*/
		return yAxisIndex;
	}

	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("wbybxm:cInsWbybxm:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(CInsWbybxm cInsWbybxm, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5818项目"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<CInsWbybxm> page = cInsWbybxmService.findPage(new Page<CInsWbybxm>(request, response, -1), cInsWbybxm);
    		new ExportExcel("5818项目", CInsWbybxm.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5818项目记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/wbybxm/cInsWbybxm/?repage";
    }

	
}