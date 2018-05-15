/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.web;

import java.util.ArrayList;
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
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessTzqk;
import com.jeeplus.modules.xmjbxx.service.CInsBusinessTzqkService;

/**
 * 基本信息中的投资情况Controller
 * @author yw
 * @version 2017-09-25
 */
@Controller
@RequestMapping(value = "${adminPath}/xmjbxx/cInsBusinessTzqk")
public class CInsBusinessTzqkController extends BaseController {

	@Autowired
	private CInsBusinessTzqkService cInsBusinessTzqkService;
	
	@ModelAttribute
	public List<CInsBusinessTzqk> get(@RequestParam(required=false) String xmid) {
		List<CInsBusinessTzqk> cInsBusinessTzqks = null;
		if (StringUtils.isNotBlank(xmid)){
			 cInsBusinessTzqks= cInsBusinessTzqkService.getall(xmid);
		}
		if (cInsBusinessTzqks == null){
			cInsBusinessTzqks = new ArrayList<CInsBusinessTzqk>();
		}
		return cInsBusinessTzqks;
	}
	
	/**
	 * tzqk列表页面
	 */
	@RequiresPermissions("xmjbxx:cInsBusinessTzqk:list")
	@RequestMapping(value = {"list", ""})
	public String list(CInsBusinessTzqk cInsBusinessTzqk, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CInsBusinessTzqk> page = cInsBusinessTzqkService.findPage(new Page<CInsBusinessTzqk>(request, response), cInsBusinessTzqk); 
		model.addAttribute("page", page);
		return "modules/xmjbxx/cInsBusinessTzqkList";
	}

	/**
	 * 查看，增加，编辑tzqk表单页面
	 */
	@RequiresPermissions(value={"xmjbxx:cInsBusinessTzqk:view","xmjbxx:cInsBusinessTzqk:add","xmjbxx:cInsBusinessTzqk:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(CInsBusinessTzqk cInsBusinessTzqk, Model model) {
		model.addAttribute("cInsBusinessTzqk", cInsBusinessTzqk);
		return "modules/xmjbxx/cInsBusinessTzqkForm";
	}

	/**
	 * 保存tzqk
	 */
	@RequiresPermissions(value={"xmjbxx:cInsBusinessTzqk:add","xmjbxx:cInsBusinessTzqk:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(CInsBusinessTzqk cInsBusinessTzqk, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, cInsBusinessTzqk)){
			return form(cInsBusinessTzqk, model);
		}
		if(!cInsBusinessTzqk.getIsNewRecord()){//编辑表单保存
			CInsBusinessTzqk t = cInsBusinessTzqkService.get(cInsBusinessTzqk.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(cInsBusinessTzqk, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			cInsBusinessTzqkService.save(t);//保存
		}else{//新增表单保存
			cInsBusinessTzqkService.save(cInsBusinessTzqk);//保存
		}
		addMessage(redirectAttributes, "保存tzqk成功");
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessTzqk/?repage";
	}
	
	/**
	 * 删除tzqk
	 */
	@RequiresPermissions("xmjbxx:cInsBusinessTzqk:del")
	@RequestMapping(value = "delete")
	public String delete(CInsBusinessTzqk cInsBusinessTzqk, RedirectAttributes redirectAttributes) {
		cInsBusinessTzqkService.delete(cInsBusinessTzqk);
		addMessage(redirectAttributes, "删除tzqk成功");
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessTzqk/?repage";
	}
	
	/**
	 * 批量删除tzqk
	 */
	@RequiresPermissions("xmjbxx:cInsBusinessTzqk:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			cInsBusinessTzqkService.delete(cInsBusinessTzqkService.get(id));
		}
		addMessage(redirectAttributes, "删除tzqk成功");
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessTzqk/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("xmjbxx:cInsBusinessTzqk:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(CInsBusinessTzqk cInsBusinessTzqk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "tzqk"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<CInsBusinessTzqk> page = cInsBusinessTzqkService.findPage(new Page<CInsBusinessTzqk>(request, response, -1), cInsBusinessTzqk);
    		new ExportExcel("tzqk", CInsBusinessTzqk.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出tzqk记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessTzqk/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("xmjbxx:cInsBusinessTzqk:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<CInsBusinessTzqk> list = ei.getDataList(CInsBusinessTzqk.class);
			for (CInsBusinessTzqk cInsBusinessTzqk : list){
				try{
					cInsBusinessTzqkService.save(cInsBusinessTzqk);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条tzqk记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条tzqk记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入tzqk失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessTzqk/?repage";
    }
	
	/**
	 * 下载导入tzqk数据模板
	 */
	@RequiresPermissions("xmjbxx:cInsBusinessTzqk:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "tzqk数据导入模板.xlsx";
    		List<CInsBusinessTzqk> list = Lists.newArrayList(); 
    		new ExportExcel("tzqk数据", CInsBusinessTzqk.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessTzqk/?repage";
    }
	
	
	

}