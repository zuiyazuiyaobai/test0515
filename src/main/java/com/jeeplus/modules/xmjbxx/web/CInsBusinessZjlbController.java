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
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessZjlb;
import com.jeeplus.modules.xmjbxx.service.CInsBusinessZjlbService;

/**
 * 基本信息中的投资情况资金类别关联表Controller
 * @author yw
 * @version 2017-09-25
 */
@Controller
@RequestMapping(value = "${adminPath}/xmjbxx/cInsBusinessZjlb")
public class CInsBusinessZjlbController extends BaseController {

	@Autowired
	private CInsBusinessZjlbService cInsBusinessZjlbService;
	
	@ModelAttribute
	public CInsBusinessZjlb get(@RequestParam(required=false) String id) {
		CInsBusinessZjlb entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cInsBusinessZjlbService.get(id);
		}
		if (entity == null){
			entity = new CInsBusinessZjlb();
		}
		return entity;
	}
	
	/**
	 * zjlb列表页面
	 */
	@RequiresPermissions("xmjbxx:cInsBusinessZjlb:list")
	@RequestMapping(value = {"list", ""})
	public String list(CInsBusinessZjlb cInsBusinessZjlb, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CInsBusinessZjlb> page = cInsBusinessZjlbService.findPage(new Page<CInsBusinessZjlb>(request, response), cInsBusinessZjlb); 
		model.addAttribute("page", page);
		return "modules/xmjbxx/cInsBusinessZjlbList";
	}

	/**
	 * 查看，增加，编辑zjlb表单页面
	 */
	@RequiresPermissions(value={"xmjbxx:cInsBusinessZjlb:view","xmjbxx:cInsBusinessZjlb:add","xmjbxx:cInsBusinessZjlb:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(CInsBusinessZjlb cInsBusinessZjlb, Model model) {
		model.addAttribute("cInsBusinessZjlb", cInsBusinessZjlb);
		return "modules/xmjbxx/cInsBusinessZjlbForm";
	}

	/**
	 * 保存zjlb
	 */
	@RequiresPermissions(value={"xmjbxx:cInsBusinessZjlb:add","xmjbxx:cInsBusinessZjlb:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(CInsBusinessZjlb cInsBusinessZjlb, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, cInsBusinessZjlb)){
			return form(cInsBusinessZjlb, model);
		}
		if(!cInsBusinessZjlb.getIsNewRecord()){//编辑表单保存
			CInsBusinessZjlb t = cInsBusinessZjlbService.get(cInsBusinessZjlb.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(cInsBusinessZjlb, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			cInsBusinessZjlbService.save(t);//保存
		}else{//新增表单保存
			cInsBusinessZjlbService.save(cInsBusinessZjlb);//保存
		}
		addMessage(redirectAttributes, "保存zjlb成功");
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessZjlb/?repage";
	}
	
	/**
	 * 删除zjlb
	 */
	@RequiresPermissions("xmjbxx:cInsBusinessZjlb:del")
	@RequestMapping(value = "delete")
	public String delete(CInsBusinessZjlb cInsBusinessZjlb, RedirectAttributes redirectAttributes) {
		cInsBusinessZjlbService.delete(cInsBusinessZjlb);
		addMessage(redirectAttributes, "删除zjlb成功");
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessZjlb/?repage";
	}
	
	/**
	 * 批量删除zjlb
	 */
	@RequiresPermissions("xmjbxx:cInsBusinessZjlb:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			cInsBusinessZjlbService.delete(cInsBusinessZjlbService.get(id));
		}
		addMessage(redirectAttributes, "删除zjlb成功");
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessZjlb/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("xmjbxx:cInsBusinessZjlb:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(CInsBusinessZjlb cInsBusinessZjlb, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "zjlb"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<CInsBusinessZjlb> page = cInsBusinessZjlbService.findPage(new Page<CInsBusinessZjlb>(request, response, -1), cInsBusinessZjlb);
    		new ExportExcel("zjlb", CInsBusinessZjlb.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出zjlb记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessZjlb/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("xmjbxx:cInsBusinessZjlb:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<CInsBusinessZjlb> list = ei.getDataList(CInsBusinessZjlb.class);
			for (CInsBusinessZjlb cInsBusinessZjlb : list){
				try{
					cInsBusinessZjlbService.save(cInsBusinessZjlb);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条zjlb记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条zjlb记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入zjlb失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessZjlb/?repage";
    }
	
	/**
	 * 下载导入zjlb数据模板
	 */
	@RequiresPermissions("xmjbxx:cInsBusinessZjlb:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "zjlb数据导入模板.xlsx";
    		List<CInsBusinessZjlb> list = Lists.newArrayList(); 
    		new ExportExcel("zjlb数据", CInsBusinessZjlb.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/cInsBusinessZjlb/?repage";
    }
	
	
	

}