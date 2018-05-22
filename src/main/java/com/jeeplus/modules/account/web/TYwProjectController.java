/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.account.web;

import java.util.Date;
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
import com.jeeplus.common.config.Global;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.modules.account.entity.TYwProject;
import com.jeeplus.modules.account.service.TYwProjectService;
import com.jeeplus.modules.sys.entity.User;
import com.jeeplus.modules.sys.utils.UserUtils;

/**
 * 台账主业务信息Controller
 * @author aaa
 * @version 2018-05-21
 */
@Controller
@RequestMapping(value = "${adminPath}/account/tYwProject")
public class TYwProjectController extends BaseController {

	@Autowired
	private TYwProjectService tYwProjectService;
	
	@ModelAttribute
	public TYwProject get(@RequestParam(required=false) String id) {
		TYwProject entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tYwProjectService.get(id);
		}
		if (entity == null){
			entity = new TYwProject();
		}
		return entity;
	}
	
	/**
	 * 台账信息列表页面
	 */
	@RequiresPermissions("account:tYwProject:list")
	@RequestMapping(value = {"list", ""})
	public String list(TYwProject tYwProject, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TYwProject> page = tYwProjectService.findPage(new Page<TYwProject>(request, response), tYwProject); 
		model.addAttribute("tYwProject", tYwProject);
		model.addAttribute("page", page);
		return "modules/account/tYwProjectList";
	}

	/**
	 * 查看，增加，编辑台账信息表单页面
	 */
	@RequiresPermissions(value={"account:tYwProject:view","account:tYwProject:add","account:tYwProject:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(TYwProject tYwProject, Model model) {
		model.addAttribute("tYwProject", tYwProject);
		return "modules/account/tYwProjectForm";
	}

	/**
	 * 保存台账信息
	 */
	@RequiresPermissions(value={"account:tYwProject:add","account:tYwProject:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(TYwProject tYwProject, Model model, RedirectAttributes redirectAttributes) throws Exception{
		User user = UserUtils.getUser();
		if (!beanValidator(model, tYwProject)){
			return form(tYwProject, model);
		}
		if(!tYwProject.getIsNewRecord()){//编辑表单保存
			TYwProject t = tYwProjectService.get(tYwProject.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(tYwProject, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			tYwProjectService.save(t);//保存
		}else{//新增表单保存
			tYwProject.setCreateTime(new Date());
			tYwProject.setCreater(user.getId());
			tYwProjectService.save(tYwProject);//保存
		}
		addMessage(redirectAttributes, "保存台账信息成功");
		return "redirect:"+Global.getAdminPath()+"/account/tYwProject/?repage";
	}
	
	/**
	 * 删除台账信息
	 */
	@RequiresPermissions("account:tYwProject:del")
	@RequestMapping(value = "delete")
	public String delete(TYwProject tYwProject, RedirectAttributes redirectAttributes) {
		tYwProjectService.delete(tYwProject);
		addMessage(redirectAttributes, "删除台账信息成功");
		return "redirect:"+Global.getAdminPath()+"/account/tYwProject/?repage";
	}
	
	/**
	 * 批量删除台账信息
	 */
	@RequiresPermissions("account:tYwProject:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			tYwProjectService.delete(tYwProjectService.get(id));
		}
		addMessage(redirectAttributes, "删除台账信息成功");
		return "redirect:"+Global.getAdminPath()+"/account/tYwProject/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("account:tYwProject:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(TYwProject tYwProject, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "台账信息"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<TYwProject> page = tYwProjectService.findPage(new Page<TYwProject>(request, response, -1), tYwProject);
    		new ExportExcel("台账信息", TYwProject.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出台账信息记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/account/tYwProject/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("account:tYwProject:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<TYwProject> list = ei.getDataList(TYwProject.class);
			for (TYwProject tYwProject : list){
				try{
					tYwProjectService.save(tYwProject);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条台账信息记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条台账信息记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入台账信息失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/account/tYwProject/?repage";
    }
	
	/**
	 * 下载导入台账信息数据模板
	 */
	@RequiresPermissions("account:tYwProject:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "台账信息数据导入模板.xlsx";
    		List<TYwProject> list = Lists.newArrayList(); 
    		new ExportExcel("台账信息数据", TYwProject.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/account/tYwProject/?repage";
    }
	
	
	

}