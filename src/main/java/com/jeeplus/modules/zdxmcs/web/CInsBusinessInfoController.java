/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.zdxmcs.web;

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
import com.jeeplus.modules.zdxmcs.entity.CInsBusinessInfo;
import com.jeeplus.modules.zdxmcs.service.CInsBusinessInfoService;

/**
 * 重点工程基本信息表Controller
 * @author tys
 * @version 2017-05-11
 */
@Controller
@RequestMapping(value = "${adminPath}/zdxmcs/cInsBusinessInfo")
public class CInsBusinessInfoController extends BaseController {

	@Autowired
	private CInsBusinessInfoService cInsBusinessInfoService;
	
	@ModelAttribute
	public CInsBusinessInfo get(@RequestParam(required=false) String id) {
		CInsBusinessInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cInsBusinessInfoService.get(id);
		}
		if (entity == null){
			entity = new CInsBusinessInfo();
		}
		return entity;
	}
	
	/**
	 * 重点工程基本信息表列表页面
	 */
	@RequiresPermissions("zdxmcs:cInsBusinessInfo:list")
	@RequestMapping(value = {"list", ""})
	public String list(CInsBusinessInfo cInsBusinessInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CInsBusinessInfo> page = cInsBusinessInfoService.findPage(new Page<CInsBusinessInfo>(request, response), cInsBusinessInfo); 
		model.addAttribute("page", page);
		return "modules/zdxmcs/cInsBusinessInfoList";
	}

	/**
	 * 查看，增加，编辑重点工程基本信息表表单页面
	 */
	@RequiresPermissions(value={"zdxmcs:cInsBusinessInfo:view","zdxmcs:cInsBusinessInfo:add","zdxmcs:cInsBusinessInfo:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(CInsBusinessInfo cInsBusinessInfo, Model model) {
		model.addAttribute("cInsBusinessInfo", cInsBusinessInfo);
		return "modules/zdxmcs/cInsBusinessInfoForm";
	}

	/**
	 * 保存重点工程基本信息表
	 */
	@RequiresPermissions(value={"zdxmcs:cInsBusinessInfo:add","zdxmcs:cInsBusinessInfo:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(CInsBusinessInfo cInsBusinessInfo, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, cInsBusinessInfo)){
			return form(cInsBusinessInfo, model);
		}
		if(!cInsBusinessInfo.getIsNewRecord()){//编辑表单保存
			CInsBusinessInfo t = cInsBusinessInfoService.get(cInsBusinessInfo.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(cInsBusinessInfo, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			cInsBusinessInfoService.save(t);//保存
		}else{//新增表单保存
			cInsBusinessInfoService.save(cInsBusinessInfo);//保存
		}
		addMessage(redirectAttributes, "保存重点工程基本信息表成功");
		return "redirect:"+Global.getAdminPath()+"/zdxmcs/cInsBusinessInfo/?repage";
	}
	
	/**
	 * 删除重点工程基本信息表
	 */
	@RequiresPermissions("zdxmcs:cInsBusinessInfo:del")
	@RequestMapping(value = "delete")
	public String delete(CInsBusinessInfo cInsBusinessInfo, RedirectAttributes redirectAttributes) {
		cInsBusinessInfoService.delete(cInsBusinessInfo);
		addMessage(redirectAttributes, "删除重点工程基本信息表成功");
		return "redirect:"+Global.getAdminPath()+"/zdxmcs/cInsBusinessInfo/?repage";
	}
	
	/**
	 * 批量删除重点工程基本信息表
	 */
	@RequiresPermissions("zdxmcs:cInsBusinessInfo:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			cInsBusinessInfoService.delete(cInsBusinessInfoService.get(id));
		}
		addMessage(redirectAttributes, "删除重点工程基本信息表成功");
		return "redirect:"+Global.getAdminPath()+"/zdxmcs/cInsBusinessInfo/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("zdxmcs:cInsBusinessInfo:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(CInsBusinessInfo cInsBusinessInfo, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "重点工程基本信息表"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<CInsBusinessInfo> page = cInsBusinessInfoService.findPage(new Page<CInsBusinessInfo>(request, response, -1), cInsBusinessInfo);
    		new ExportExcel("重点工程基本信息表", CInsBusinessInfo.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出重点工程基本信息表记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/zdxmcs/cInsBusinessInfo/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("zdxmcs:cInsBusinessInfo:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<CInsBusinessInfo> list = ei.getDataList(CInsBusinessInfo.class);
			for (CInsBusinessInfo cInsBusinessInfo : list){
				try{
					cInsBusinessInfoService.save(cInsBusinessInfo);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条重点工程基本信息表记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条重点工程基本信息表记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入重点工程基本信息表失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/zdxmcs/cInsBusinessInfo/?repage";
    }
	
	/**
	 * 下载导入重点工程基本信息表数据模板
	 */
	@RequiresPermissions("zdxmcs:cInsBusinessInfo:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "重点工程基本信息表数据导入模板.xlsx";
    		List<CInsBusinessInfo> list = Lists.newArrayList(); 
    		new ExportExcel("重点工程基本信息表数据", CInsBusinessInfo.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/zdxmcs/cInsBusinessInfo/?repage";
    }
	
	
	

}