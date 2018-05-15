/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.tj_sszdgjxmxx.web;

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
import com.jeeplus.modules.tj_sszdgjxmxx.entity.Tj_sszdgjxmxx;
import com.jeeplus.modules.tj_sszdgjxmxx.service.Tj_sszdgjxmxxService;

/**
 * tj_sszdgjxmxxController
 * @author zgl
 * @version 2018-03-17
 */
@Controller
@RequestMapping(value = "${adminPath}/tj_sszdgjxmxx/tj_sszdgjxmxx")
public class Tj_sszdgjxmxxController extends BaseController {

	@Autowired
	private Tj_sszdgjxmxxService tj_sszdgjxmxxService;
	
	@ModelAttribute
	public Tj_sszdgjxmxx get(@RequestParam(required=false) String id) {
		Tj_sszdgjxmxx entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tj_sszdgjxmxxService.get(id);
		}
		if (entity == null){
			entity = new Tj_sszdgjxmxx();
		}
		return entity;
	}
	
	/**
	 * tj_sszdgjxmxx列表页面
	 */
	@RequiresPermissions("tj_sszdgjxmxx:tj_sszdgjxmxx:list")
	@RequestMapping(value = {"list", ""})
	public String list(Tj_sszdgjxmxx tj_sszdgjxmxx, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Tj_sszdgjxmxx> page = tj_sszdgjxmxxService.findPage(new Page<Tj_sszdgjxmxx>(request, response), tj_sszdgjxmxx); 
		model.addAttribute("page", page);
		return "modules/tj_sszdgjxmxx/tj_sszdgjxmxxList";
	}
	/**
	 * 入库项目数量列表页面
	 */
	@RequiresPermissions("tj_sszdgjxmxx:tj_sszdgjxmxx:rkxmsl")
	@RequestMapping(value = "rkxmsl")
	public String rkxmsl(Tj_sszdgjxmxx tj_sszdgjxmxx, HttpServletRequest request, HttpServletResponse response, Model model) {
		tj_sszdgjxmxx.setSign("1");
		Page<Tj_sszdgjxmxx> page = tj_sszdgjxmxxService.findPage(new Page<Tj_sszdgjxmxx>(request, response), tj_sszdgjxmxx); 
		tj_sszdgjxmxx.setSszdgjxmsl("1");//分类，不写是按照第地市分类，1是按照产业集聚区分类。
		Page<Tj_sszdgjxmxx> page2 = tj_sszdgjxmxxService.findPage(new Page<Tj_sszdgjxmxx>(request, response), tj_sszdgjxmxx);
		model.addAttribute("page", page);
		model.addAttribute("page2", page2);
		return "modules/tj_sszdgjxmxx/rkxmsl";
	}
	/**
	 * 省（市）重点攻坚产业项目数量列表页面
	 */
	@RequiresPermissions("tj_sszdgjxmxx:tj_sszdgjxmxx:sszdgjxmsl")
	@RequestMapping(value = "sszdgjxmsl")
	public String sszdgjcyxmsl(Tj_sszdgjxmxx tj_sszdgjxmxx, HttpServletRequest request, HttpServletResponse response, Model model) {
		tj_sszdgjxmxx.setSign("2");
		Page<Tj_sszdgjxmxx> page = tj_sszdgjxmxxService.findPage(new Page<Tj_sszdgjxmxx>(request, response), tj_sszdgjxmxx); 
		model.addAttribute("page", page);
		return "modules/tj_sszdgjxmxx/sszdgjxmsl";
	}
	/**
	 * 各产业项目数量列表页面
	 */
	@RequiresPermissions("tj_sszdgjxmxx:tj_sszdgjxmxx:gcysl")
	@RequestMapping(value = "gcysl")
	public String gcysl(Tj_sszdgjxmxx tj_sszdgjxmxx, HttpServletRequest request, HttpServletResponse response, Model model) {
		tj_sszdgjxmxx.setSign("3");
		Page<Tj_sszdgjxmxx> page = tj_sszdgjxmxxService.findPage(new Page<Tj_sszdgjxmxx>(request, response), tj_sszdgjxmxx); 
		model.addAttribute("page", page);
		return "modules/tj_sszdgjxmxx/gcysl";
	}
	/**
	 * 技术改造项目数量列表页面
	 */
	@RequiresPermissions("tj_sszdgjxmxx:tj_sszdgjxmxx:jsgzxmsl")
	@RequestMapping(value = "jsgzxmsl")
	public String jsgzxmsl(Tj_sszdgjxmxx tj_sszdgjxmxx, HttpServletRequest request, HttpServletResponse response, Model model) {
		tj_sszdgjxmxx.setSign("4");
		Page<Tj_sszdgjxmxx> page = tj_sszdgjxmxxService.findPage(new Page<Tj_sszdgjxmxx>(request, response), tj_sszdgjxmxx); 
		model.addAttribute("page", page);
		return "modules/tj_sszdgjxmxx/jsgzxmsl";
	}
	/**
	 * 本年度计划新开工项目数量列表页面
	 */
	@RequiresPermissions("tj_sszdgjxmxx:tj_sszdgjxmxx:bndjhxkgxmsl")
	@RequestMapping(value = "bndjhxkgxmsl")
	public String bndjhxkgxmsl(Tj_sszdgjxmxx tj_sszdgjxmxx, HttpServletRequest request, HttpServletResponse response, Model model) {
		tj_sszdgjxmxx.setSign("5");
		Page<Tj_sszdgjxmxx> page = tj_sszdgjxmxxService.findPage(new Page<Tj_sszdgjxmxx>(request, response), tj_sszdgjxmxx); 
		model.addAttribute("page", page);
		return "modules/tj_sszdgjxmxx/bndjhxkgxmsl";
	}
	/**
	 * 年度计划新投产项目数量列表页面
	 */
	@RequiresPermissions("tj_sszdgjxmxx:tj_sszdgjxmxx:ndjhxtcxmsl")
	@RequestMapping(value = "ndjhxtcxmsl")
	public String ndjhxtcxmsl(Tj_sszdgjxmxx tj_sszdgjxmxx, HttpServletRequest request, HttpServletResponse response, Model model) {
		tj_sszdgjxmxx.setSign("6");
		Page<Tj_sszdgjxmxx> page = tj_sszdgjxmxxService.findPage(new Page<Tj_sszdgjxmxx>(request, response), tj_sszdgjxmxx); 
		model.addAttribute("page", page);
		return "modules/tj_sszdgjxmxx/ndjhxtcxmsl";
	}
	/**
	 * 本年度计划续建项目数量列表页面
	 */
	@RequiresPermissions("tj_sszdgjxmxx:tj_sszdgjxmxx:bndjhxjxmsl")
	@RequestMapping(value = "bndjhxjxmsl")
	public String bndjhxjxmsl(Tj_sszdgjxmxx tj_sszdgjxmxx, HttpServletRequest request, HttpServletResponse response, Model model) {
		tj_sszdgjxmxx.setSign("7");
		Page<Tj_sszdgjxmxx> page = tj_sszdgjxmxxService.findPage(new Page<Tj_sszdgjxmxx>(request, response), tj_sszdgjxmxx); 
		model.addAttribute("page", page);
		return "modules/tj_sszdgjxmxx/bndjhxjxmsl";
	}
	
	/**
	 * 当月新开工项目数量列表页面
	 */
	@RequiresPermissions("tj_sszdgjxmxx:tj_sszdgjxmxx:dyxkgxmsl")
	@RequestMapping(value = "dyxkgxmsl")
	public String dyxkgxmsl(Tj_sszdgjxmxx tj_sszdgjxmxx, HttpServletRequest request, HttpServletResponse response, Model model) {
		tj_sszdgjxmxx.setSign("8");
		Page<Tj_sszdgjxmxx> page = tj_sszdgjxmxxService.findPage(new Page<Tj_sszdgjxmxx>(request, response), tj_sszdgjxmxx); 
		model.addAttribute("page", page);
		return "modules/tj_sszdgjxmxx/dyxkgxmsl";
	}
	/**
	 * 新调出项目数量列表页面
	 */
	@RequiresPermissions("tj_sszdgjxmxx:tj_sszdgjxmxx:xdcxmsl")
	@RequestMapping(value = "xdcxmsl")
	public String xdcxmsl(Tj_sszdgjxmxx tj_sszdgjxmxx, HttpServletRequest request, HttpServletResponse response, Model model) {
		tj_sszdgjxmxx.setSign("9");
		Page<Tj_sszdgjxmxx> page = tj_sszdgjxmxxService.findPage(new Page<Tj_sszdgjxmxx>(request, response), tj_sszdgjxmxx); 
		model.addAttribute("page", page);
		return "modules/tj_sszdgjxmxx/xdcxmsl";
	}
	/**
	 * 查看，增加，编辑tj_sszdgjxmxx表单页面
	 */
	@RequiresPermissions(value={"tj_sszdgjxmxx:tj_sszdgjxmxx:view","tj_sszdgjxmxx:tj_sszdgjxmxx:add","tj_sszdgjxmxx:tj_sszdgjxmxx:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Tj_sszdgjxmxx tj_sszdgjxmxx, Model model) {
		model.addAttribute("tj_sszdgjxmxx", tj_sszdgjxmxx);
		return "modules/tj_sszdgjxmxx/tj_sszdgjxmxxForm";
	}

	/**
	 * 保存tj_sszdgjxmxx
	 */
	@RequiresPermissions(value={"tj_sszdgjxmxx:tj_sszdgjxmxx:add","tj_sszdgjxmxx:tj_sszdgjxmxx:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Tj_sszdgjxmxx tj_sszdgjxmxx, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, tj_sszdgjxmxx)){
			return form(tj_sszdgjxmxx, model);
		}
		if(!tj_sszdgjxmxx.getIsNewRecord()){//编辑表单保存
			Tj_sszdgjxmxx t = tj_sszdgjxmxxService.get(tj_sszdgjxmxx.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(tj_sszdgjxmxx, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			tj_sszdgjxmxxService.save(t);//保存
		}else{//新增表单保存
			tj_sszdgjxmxxService.save(tj_sszdgjxmxx);//保存
		}
		addMessage(redirectAttributes, "保存tj_sszdgjxmxx成功");
		return "redirect:"+Global.getAdminPath()+"/tj_sszdgjxmxx/tj_sszdgjxmxx/?repage";
	}
	
	/**
	 * 删除tj_sszdgjxmxx
	 */
	@RequiresPermissions("tj_sszdgjxmxx:tj_sszdgjxmxx:del")
	@RequestMapping(value = "delete")
	public String delete(Tj_sszdgjxmxx tj_sszdgjxmxx, RedirectAttributes redirectAttributes) {
		tj_sszdgjxmxxService.delete(tj_sszdgjxmxx);
		addMessage(redirectAttributes, "删除tj_sszdgjxmxx成功");
		return "redirect:"+Global.getAdminPath()+"/tj_sszdgjxmxx/tj_sszdgjxmxx/?repage";
	}
	
	/**
	 * 批量删除tj_sszdgjxmxx
	 */
	@RequiresPermissions("tj_sszdgjxmxx:tj_sszdgjxmxx:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			tj_sszdgjxmxxService.delete(tj_sszdgjxmxxService.get(id));
		}
		addMessage(redirectAttributes, "删除tj_sszdgjxmxx成功");
		return "redirect:"+Global.getAdminPath()+"/tj_sszdgjxmxx/tj_sszdgjxmxx/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("tj_sszdgjxmxx:tj_sszdgjxmxx:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Tj_sszdgjxmxx tj_sszdgjxmxx, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "tj_sszdgjxmxx"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Tj_sszdgjxmxx> page = tj_sszdgjxmxxService.findPage(new Page<Tj_sszdgjxmxx>(request, response, -1), tj_sszdgjxmxx);
    		new ExportExcel("tj_sszdgjxmxx", Tj_sszdgjxmxx.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出tj_sszdgjxmxx记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/tj_sszdgjxmxx/tj_sszdgjxmxx/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("tj_sszdgjxmxx:tj_sszdgjxmxx:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Tj_sszdgjxmxx> list = ei.getDataList(Tj_sszdgjxmxx.class);
			for (Tj_sszdgjxmxx tj_sszdgjxmxx : list){
				try{
					tj_sszdgjxmxxService.save(tj_sszdgjxmxx);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条tj_sszdgjxmxx记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条tj_sszdgjxmxx记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入tj_sszdgjxmxx失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/tj_sszdgjxmxx/tj_sszdgjxmxx/?repage";
    }
	
	/**
	 * 下载导入tj_sszdgjxmxx数据模板
	 */
	@RequiresPermissions("tj_sszdgjxmxx:tj_sszdgjxmxx:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "tj_sszdgjxmxx数据导入模板.xlsx";
    		List<Tj_sszdgjxmxx> list = Lists.newArrayList(); 
    		new ExportExcel("tj_sszdgjxmxx数据", Tj_sszdgjxmxx.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/tj_sszdgjxmxx/tj_sszdgjxmxx/?repage";
    }
	
	
	

}