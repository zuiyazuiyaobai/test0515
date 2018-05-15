/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.web;

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
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessSsqk;
import com.jeeplus.modules.xmjbxx.service.CInsBusinessSsqkService;

/**
 * 实施情况Controller
 * @author zcl
 * @version 2017-11-03
 */
@Controller
@RequestMapping(value = "${adminPath}/xmjbxx/cInsBusinessSsqk")
public class CInsBusinessSsqkController extends BaseController {

	@Autowired
	private CInsBusinessSsqkService cInsBusinessSsqkService;
	
	@ModelAttribute
	public CInsBusinessSsqk get(@RequestParam(required=false) String id) {
		CInsBusinessSsqk entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cInsBusinessSsqkService.get(id);
		}
		if (entity == null){
			entity = new CInsBusinessSsqk();
		}
		return entity;
	}
	
	/**
	 * 实施情况列表页面
	 */
	@RequiresPermissions("xmjbxx:cInsBusinessSsqk:list")
	@RequestMapping(value = {"list", ""})
	public String list(CInsBusinessSsqk cInsBusinessSsqk, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CInsBusinessSsqk> page = cInsBusinessSsqkService.findPage(new Page<CInsBusinessSsqk>(request, response), cInsBusinessSsqk); 
		model.addAttribute("page", page);
		return "modules/xmjbxx/cInsBusinessSsqkList";
	}

	/**
	 * 查看，增加，编辑实施情况表单页面
	 */
	@RequiresPermissions(value={"xmjbxx:cInsBusinessSsqk:view","xmjbxx:cInsBusinessSsqk:add","xmjbxx:cInsBusinessSsqk:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(CInsBusinessSsqk cInsBusinessSsqk, Model model) {
		model.addAttribute("cInsBusinessSsqk", cInsBusinessSsqk);
		return "modules/xmjbxx/cInsBusinessSsqkForm";
	}

	/**
	 * 保存实施情况
	 */
	@RequiresPermissions(value={"xmjbxx:cInsBusinessSsqk:add","xmjbxx:cInsBusinessSsqk:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(CInsBusinessSsqk cInsBusinessSsqk, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, cInsBusinessSsqk)){
			return form(cInsBusinessSsqk, model);
		}
		if(!cInsBusinessSsqk.getIsNewRecord()){//编辑表单保存
			CInsBusinessSsqk t = cInsBusinessSsqkService.get(cInsBusinessSsqk.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(cInsBusinessSsqk, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			cInsBusinessSsqkService.save(t);//保存
		}else{//新增表单保存
			cInsBusinessSsqkService.save(cInsBusinessSsqk);//保存
		}
		addMessage(redirectAttributes, "保存实施情况成功");
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessSsqk/?repage";
	}
	
	/**
	 * 删除实施情况
	 */
	@RequiresPermissions("xmjbxx:cInsBusinessSsqk:del")
	@RequestMapping(value = "delete")
	public String delete(CInsBusinessSsqk cInsBusinessSsqk, RedirectAttributes redirectAttributes) {
		cInsBusinessSsqkService.delete(cInsBusinessSsqk);
		addMessage(redirectAttributes, "删除实施情况成功");
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessSsqk/?repage";
	}
	
	/**
	 * 批量删除实施情况
	 */
	@RequiresPermissions("xmjbxx:cInsBusinessSsqk:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			cInsBusinessSsqkService.delete(cInsBusinessSsqkService.get(id));
		}
		addMessage(redirectAttributes, "删除实施情况成功");
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessSsqk/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("xmjbxx:cInsBusinessSsqk:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(CInsBusinessSsqk cInsBusinessSsqk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "实施情况"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<CInsBusinessSsqk> page = cInsBusinessSsqkService.findPage(new Page<CInsBusinessSsqk>(request, response, -1), cInsBusinessSsqk);
    		new ExportExcel("实施情况", CInsBusinessSsqk.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出实施情况记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessSsqk/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("xmjbxx:cInsBusinessSsqk:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<CInsBusinessSsqk> list = ei.getDataList(CInsBusinessSsqk.class);
			for (CInsBusinessSsqk cInsBusinessSsqk : list){
				try{
					cInsBusinessSsqkService.save(cInsBusinessSsqk);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条实施情况记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条实施情况记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入实施情况失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessSsqk/?repage";
    }
	
	/**
	 * 下载导入实施情况数据模板
	 */
	@RequiresPermissions("xmjbxx:cInsBusinessSsqk:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "实施情况数据导入模板.xlsx";
    		List<CInsBusinessSsqk> list = Lists.newArrayList(); 
    		new ExportExcel("实施情况数据", CInsBusinessSsqk.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessSsqk/?repage";
    }
	
	
	

}