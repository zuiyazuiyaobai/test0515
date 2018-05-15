/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.gcjz.web;

import java.util.List;

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
import com.jeeplus.modules.gcjz.entity.CInsBusinessGcjzqk;
import com.jeeplus.modules.gcjz.service.CInsBusinessGcjzqkService;
import com.jeeplus.modules.tools.utils.SwitchColumn;
import com.jeeplus.modules.zdxmcs.entity.CInsBusinessInfo;
import com.jeeplus.modules.zdxmcs.entity.CInsBusinessZdgcxm;
import com.jeeplus.modules.zdxmcs.service.CInsBusinessInfoService;
import com.jeeplus.modules.zdxmcs.service.CInsBusinessZdgcxmService;

/**
 * 工程进度 分市汇总Controller
 * @author gl
 * @version 2017-06-12
 */
@Controller
@RequestMapping(value = "${adminPath}/zdgcxm/gcjz")
public class CInsBusinessGcjzqkController extends BaseController {

	@Autowired
	private CInsBusinessGcjzqkService cInsBusinessGcjzqkService;
	
	@Autowired
	private CInsBusinessZdgcxmService cInsBusinessZdgcxmService;
	
	@Autowired
	private CInsBusinessInfoService cInsBusinessInfoService;
	
	@ModelAttribute
	public CInsBusinessGcjzqk get(@RequestParam(required=false) String id) {
		CInsBusinessGcjzqk entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cInsBusinessGcjzqkService.get(id);
		}
		if (entity == null){
			entity = new CInsBusinessGcjzqk();
		}
		return entity;
	}
	
	/**
	 * 工程进度 分市汇总列表页面
	 */
	@RequiresPermissions("zdgcxm:gcjz:list")
	@RequestMapping(value = {"list"})
	public String list(CInsBusinessGcjzqk cInsBusinessGcjzqk, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<CInsBusinessGcjzqk> list = cInsBusinessGcjzqkService.findGcjzqk(cInsBusinessGcjzqk); 
		CInsBusinessGcjzqk total=cInsBusinessGcjzqkService.findTotal(cInsBusinessGcjzqk);
		List<String> years=cInsBusinessGcjzqkService.findYears();
		model.addAttribute("years",years);
		model.addAttribute("gcjzqk", list);
		model.addAttribute("xmzj", total);
		return "modules/gcjz/gcjzqkList";
	}
	/**
	 * 工程进度 分市汇总列表首次进入页面
	 */
	@RequiresPermissions("zdgcxm:gcjz:list")
	@RequestMapping(value = {""})
	public String firstList(CInsBusinessGcjzqk cInsBusinessGcjzqk, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<String> years=cInsBusinessGcjzqkService.findYears();
		model.addAttribute("years",years);
		return "modules/gcjz/gcjzqkList";
	}

	/**
	 * 查看，增加，编辑工程进度 分市汇总表单页面
	 */
	@RequiresPermissions(value={"zdgcxm:gcjz:view","zdgcxm:gcjz:list","zdgcxm:gcjz:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(CInsBusinessGcjzqk cInsBusinessGcjzqk, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CInsBusinessGcjzqk> page=cInsBusinessGcjzqkService.findPage(new Page<CInsBusinessGcjzqk>(request, response),cInsBusinessGcjzqk);
		model.addAttribute("page", page);
		return "modules/gcjz/gcjzqkForm";
	}
	@RequiresPermissions(value={"zdgcxm:gcjz:view","zdgcxm:gcjz:list","zdgcxm:gcjz:edit"},logical=Logical.OR)
	@RequestMapping(value = "edit")
	public String xmInfo(CInsBusinessGcjzqk cInsBusinessGcjzqk, HttpServletRequest request, HttpServletResponse response, Model model) {
		//项目基本信息
		CInsBusinessZdgcxm zdgcxm  = cInsBusinessZdgcxmService.get(cInsBusinessGcjzqk.getId());
		CInsBusinessInfo  info = cInsBusinessInfoService.get(zdgcxm.getCbsnum());
		//字段转换
		if (zdgcxm!=null) {
			zdgcxm.setZdxmlx(SwitchColumn.switchZdxmlx(zdgcxm.getZdxmlx()));
			zdgcxm.setCylxone(SwitchColumn.switchCylxone(zdgcxm.getCylxone()));
			zdgcxm.setCylx(SwitchColumn.switchCylx(zdgcxm.getCylx()));
		}
		if(info!=null){
			info.setInctype(SwitchColumn.switchIncType(info.getInctype()));
			info.setIncrelation(SwitchColumn.switchIncrelation(info.getIncrelation()));
			info.setProjectnature(SwitchColumn.switchProjectnature(info.getProjectnature()));
		}
		zdgcxm.setInfo(info);
		model.addAttribute("zdgcxm", zdgcxm);
		//年份下拉数据
		List<String> years=cInsBusinessGcjzqkService.findYears();
		model.addAttribute("years",years);
		//进展情况分页
		Page<CInsBusinessGcjzqk> page=cInsBusinessGcjzqkService.findJzqkPage(new Page<CInsBusinessGcjzqk>(request, response), cInsBusinessGcjzqk);
		model.addAttribute("page",page);
		return "modules/gcjz/gcjzInfo";
	}
	/**
	 * 保存工程进度 分市汇总
	 */
	@RequiresPermissions(value={"zdgcxm:gcjz:add","zdgcxm:gcjz:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(CInsBusinessGcjzqk cInsBusinessGcjzqk, Model model, RedirectAttributes redirectAttributes) throws Exception{
		
		if(!cInsBusinessGcjzqk.getIsNewRecord()){//编辑表单保存
			CInsBusinessGcjzqk t = cInsBusinessGcjzqkService.get(cInsBusinessGcjzqk.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(cInsBusinessGcjzqk, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			cInsBusinessGcjzqkService.save(t);//保存
		}else{//新增表单保存
			cInsBusinessGcjzqkService.save(cInsBusinessGcjzqk);//保存
		}
		addMessage(redirectAttributes, "保存工程进度 分市汇总成功");
		return "redirect:"+Global.getAdminPath()+"/gcjz/cInsBusinessGcjzqk/?repage";
	}
	
	/**
	 * 删除工程进度 分市汇总
	 */
	@RequiresPermissions("zdgcxm:gcjz:del")
	@RequestMapping(value = "delete")
	public String delete(CInsBusinessGcjzqk cInsBusinessGcjzqk, RedirectAttributes redirectAttributes) {
		cInsBusinessGcjzqkService.delete(cInsBusinessGcjzqk);
		addMessage(redirectAttributes, "删除工程进度 分市汇总成功");
		return "redirect:"+Global.getAdminPath()+"/gcjz/cInsBusinessGcjzqk/?repage";
	}
	
	/**
	 * 批量删除工程进度 分市汇总
	 */
	@RequiresPermissions("zdgcxm:gcjz:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			cInsBusinessGcjzqkService.delete(cInsBusinessGcjzqkService.get(id));
		}
		addMessage(redirectAttributes, "删除工程进度 分市汇总成功");
		return "redirect:"+Global.getAdminPath()+"/gcjz/cInsBusinessGcjzqk/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("zdgcxm:gcjz:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(CInsBusinessGcjzqk cInsBusinessGcjzqk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "工程进度 分市汇总"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<CInsBusinessGcjzqk> page = cInsBusinessGcjzqkService.findPage(new Page<CInsBusinessGcjzqk>(request, response, -1), cInsBusinessGcjzqk);
    		new ExportExcel("工程进度 分市汇总", CInsBusinessGcjzqk.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出工程进度 分市汇总记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/gcjz/cInsBusinessGcjzqk/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("zdgcxm:gcjz:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<CInsBusinessGcjzqk> list = ei.getDataList(CInsBusinessGcjzqk.class);
			for (CInsBusinessGcjzqk cInsBusinessGcjzqk : list){
				try{
					cInsBusinessGcjzqkService.save(cInsBusinessGcjzqk);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条工程进度 分市汇总记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条工程进度 分市汇总记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入工程进度 分市汇总失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/gcjz/cInsBusinessGcjzqk/?repage";
    }
	
	/**
	 * 下载导入工程进度 分市汇总数据模板
	 */
	@RequiresPermissions("zdgcxm:gcjz:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "工程进度 分市汇总数据导入模板.xlsx";
    		List<CInsBusinessGcjzqk> list = Lists.newArrayList(); 
    		new ExportExcel("工程进度 分市汇总数据", CInsBusinessGcjzqk.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/gcjz/cInsBusinessGcjzqk/?repage";
    }
	
	
	

}