/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.web.sub;

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
import com.jeeplus.modules.xmjbxx.entity.sub.CInsBusinessContact;
import com.jeeplus.modules.xmjbxx.service.sub.CInsBusinessContactService;

/**
 * 联系人信息Controller
 * @author zcl
 * @version 2017-10-25
 */
@Controller
@RequestMapping(value = "${adminPath}/xmjbxx/sub/cInsBusinessContact")
public class CInsBusinessContactController extends BaseController {

	@Autowired
	private CInsBusinessContactService cInsBusinessContactService;
	
	@ModelAttribute
	public CInsBusinessContact get(@RequestParam(required=false) String id) {
		CInsBusinessContact entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cInsBusinessContactService.get(id);
		}
		if (entity == null){
			entity = new CInsBusinessContact();
		}
		return entity;
	}
	
	/**
	 * 联系人信息列表页面
	 */
	// @RequiresPermissions("xmjbxx:sub:cInsBusinessContact:list")
	@RequestMapping(value = {"list", ""})
	public String list(CInsBusinessContact cInsBusinessContact, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CInsBusinessContact> page = cInsBusinessContactService.findPage(new Page<CInsBusinessContact>(request, response), cInsBusinessContact); 
		model.addAttribute("page", page);
		return "modules/xmjbxx/sub/contactList";
	}

	/**
	 * 查看，增加，编辑联系人信息表单页面
	 */
	// @RequiresPermissions(value={"xmjbxx:sub:cInsBusinessContact:view","xmjbxx:sub:cInsBusinessContact:add","xmjbxx:sub:cInsBusinessContact:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(CInsBusinessContact cInsBusinessContact, Model model) {
		model.addAttribute("cInsBusinessContact", cInsBusinessContact);
		return "modules/xmjbxx/sub/contactForm";
	}

	/**
	 * 保存联系人信息
	 */
	// @RequiresPermissions(value={"xmjbxx:sub:cInsBusinessContact:add","xmjbxx:sub:cInsBusinessContact:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(CInsBusinessContact cInsBusinessContact, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, cInsBusinessContact)){
			return form(cInsBusinessContact, model);
		}
		if(!cInsBusinessContact.getIsNewRecord()){//编辑表单保存
			CInsBusinessContact t = cInsBusinessContactService.get(cInsBusinessContact.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(cInsBusinessContact, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			cInsBusinessContactService.save(t);//保存
		}else{//新增表单保存
			cInsBusinessContactService.save(cInsBusinessContact);//保存
		}
		addMessage(redirectAttributes, "保存联系人信息成功");
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/sub/cInsBusinessContact/?repage";
	}
	
	/**
	 * 删除联系人信息
	 */
	// @RequiresPermissions("xmjbxx:sub:cInsBusinessContact:del")
	@RequestMapping(value = "delete")
	public String delete(CInsBusinessContact cInsBusinessContact, RedirectAttributes redirectAttributes) {
		cInsBusinessContactService.delete(cInsBusinessContact);
		addMessage(redirectAttributes, "删除联系人信息成功");
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/sub/cInsBusinessContact/?repage";
	}
	
	/**
	 * 批量删除联系人信息
	 */
	// @RequiresPermissions("xmjbxx:sub:cInsBusinessContact:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			cInsBusinessContactService.delete(cInsBusinessContactService.get(id));
		}
		addMessage(redirectAttributes, "删除联系人信息成功");
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/sub/cInsBusinessContact/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("xmjbxx:sub:cInsBusinessContact:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(CInsBusinessContact cInsBusinessContact, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "联系人信息"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<CInsBusinessContact> page = cInsBusinessContactService.findPage(new Page<CInsBusinessContact>(request, response, -1), cInsBusinessContact);
    		new ExportExcel("联系人信息", CInsBusinessContact.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出联系人信息记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/sub/cInsBusinessContact/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("xmjbxx:sub:cInsBusinessContact:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<CInsBusinessContact> list = ei.getDataList(CInsBusinessContact.class);
			for (CInsBusinessContact cInsBusinessContact : list){
				try{
					cInsBusinessContactService.save(cInsBusinessContact);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条联系人信息记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条联系人信息记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入联系人信息失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/sub/cInsBusinessContact/?repage";
    }
	
	/**
	 * 下载导入联系人信息数据模板
	 */
	@RequiresPermissions("xmjbxx:sub:cInsBusinessContact:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "联系人信息数据导入模板.xlsx";
    		List<CInsBusinessContact> list = Lists.newArrayList(); 
    		new ExportExcel("联系人信息数据", CInsBusinessContact.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/sub/cInsBusinessContact/?repage";
    }
	
	
	

}