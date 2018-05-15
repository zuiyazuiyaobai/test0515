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
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessZdxmk;
import com.jeeplus.modules.xmjbxx.service.CInsBusinessZdxmkService;

/**
 * 其他（省基建5818重点项目）Controller
 * @author @zhu
 * @version 2017-12-02
 */
@Controller
@RequestMapping(value = "${adminPath}/xmjbxx/cInsBusinessZdxmk")
public class CInsBusinessZdxmkController extends BaseController {

	@Autowired
	private CInsBusinessZdxmkService cInsBusinessZdxmkService;
	
	@ModelAttribute
	public CInsBusinessZdxmk get(@RequestParam(required=false) String id) {
		CInsBusinessZdxmk entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cInsBusinessZdxmkService.get(id);
		}
		if (entity == null){
			entity = new CInsBusinessZdxmk();
		}
		return entity;
	}
	
	/**
	 * 保存其他信息成功列表页面
	 */
	@RequiresPermissions("xmjbxx:cInsBusinessZdxmk:list")
	@RequestMapping(value = {"list", ""})
	public String list(CInsBusinessZdxmk cInsBusinessZdxmk, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CInsBusinessZdxmk> page = cInsBusinessZdxmkService.findPage(new Page<CInsBusinessZdxmk>(request, response), cInsBusinessZdxmk); 
		model.addAttribute("page", page);
		return "entity/xmjbxx/cInsBusinessZdxmkList";
	}

	/**
	 * 查看，增加，编辑保存其他信息成功表单页面
	 */
	@RequiresPermissions(value={"xmjbxx:cInsBusinessZdxmk:view","xmjbxx:cInsBusinessZdxmk:add","xmjbxx:cInsBusinessZdxmk:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(CInsBusinessZdxmk cInsBusinessZdxmk, Model model) {
		model.addAttribute("cInsBusinessZdxmk", cInsBusinessZdxmk);
		return "entity/xmjbxx/cInsBusinessZdxmkForm";
	}

	/**
	 * 保存保存其他信息成功
	 */
	@RequiresPermissions(value={"xmjbxx:cInsBusinessZdxmk:add","xmjbxx:cInsBusinessZdxmk:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(CInsBusinessZdxmk cInsBusinessZdxmk, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, cInsBusinessZdxmk)){
			return form(cInsBusinessZdxmk, model);
		}
		if(!cInsBusinessZdxmk.getIsNewRecord()){//编辑表单保存
			CInsBusinessZdxmk t = cInsBusinessZdxmkService.get(cInsBusinessZdxmk.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(cInsBusinessZdxmk, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			cInsBusinessZdxmkService.save(t);//保存
		}else{//新增表单保存
			cInsBusinessZdxmkService.save(cInsBusinessZdxmk);//保存
		}
		addMessage(redirectAttributes, "保存保存其他信息成功成功");
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessZdxmk/?repage";
	}
	
	/**
	 * 删除保存其他信息成功
	 */
	@RequiresPermissions("xmjbxx:cInsBusinessZdxmk:del")
	@RequestMapping(value = "delete")
	public String delete(CInsBusinessZdxmk cInsBusinessZdxmk, RedirectAttributes redirectAttributes) {
		cInsBusinessZdxmkService.delete(cInsBusinessZdxmk);
		addMessage(redirectAttributes, "删除保存其他信息成功成功");
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessZdxmk/?repage";
	}
	
	/**
	 * 批量删除保存其他信息成功
	 */
	@RequiresPermissions("xmjbxx:cInsBusinessZdxmk:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			cInsBusinessZdxmkService.delete(cInsBusinessZdxmkService.get(id));
		}
		addMessage(redirectAttributes, "删除保存其他信息成功成功");
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessZdxmk/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("xmjbxx:cInsBusinessZdxmk:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(CInsBusinessZdxmk cInsBusinessZdxmk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "保存其他信息成功"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<CInsBusinessZdxmk> page = cInsBusinessZdxmkService.findPage(new Page<CInsBusinessZdxmk>(request, response, -1), cInsBusinessZdxmk);
    		new ExportExcel("保存其他信息成功", CInsBusinessZdxmk.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出保存其他信息成功记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessZdxmk/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("xmjbxx:cInsBusinessZdxmk:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<CInsBusinessZdxmk> list = ei.getDataList(CInsBusinessZdxmk.class);
			for (CInsBusinessZdxmk cInsBusinessZdxmk : list){
				try{
					cInsBusinessZdxmkService.save(cInsBusinessZdxmk);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条保存其他信息成功记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条保存其他信息成功记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入保存其他信息成功失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessZdxmk/?repage";
    }
	
	/**
	 * 下载导入保存其他信息成功数据模板
	 */
	@RequiresPermissions("xmjbxx:cInsBusinessZdxmk:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "保存其他信息成功数据导入模板.xlsx";
    		List<CInsBusinessZdxmk> list = Lists.newArrayList(); 
    		new ExportExcel("保存其他信息成功数据", CInsBusinessZdxmk.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessZdxmk/?repage";
    }
	
	
	

}