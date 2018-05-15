/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.web.sub;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import com.jeeplus.modules.xmjbxx.vo.CInsBusinessXmjbxxDeptRelationSearchParameter;
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
import com.jeeplus.modules.xmjbxx.entity.sub.CInsBusinessXmjbxxDeptRelation;
import com.jeeplus.modules.xmjbxx.service.sub.CInsBusinessXmjbxxDeptRelationService;

/**
 * 项目部门关系Controller
 * @author zcl
 * @version 2017-10-16
 */
@Controller
@RequestMapping(value = "${adminPath}/xmjbxx/sub/cInsBusinessXmjbxxDeptRelation")
public class CInsBusinessXmjbxxDeptRelationController extends BaseController {

	@Autowired
	private CInsBusinessXmjbxxDeptRelationService cInsBusinessXmjbxxDeptRelationService;
	
	@ModelAttribute
	public CInsBusinessXmjbxxDeptRelation get(@RequestParam(required=false) String id) {
		CInsBusinessXmjbxxDeptRelation entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cInsBusinessXmjbxxDeptRelationService.get(id);
		}
		if (entity == null){
			entity = new CInsBusinessXmjbxxDeptRelation();
		}
		return entity;
	}
	
	/**
	 * 项目部门关系列表页面
	 */
	@RequiresPermissions("xmjbxx:sub:cInsBusinessXmjbxxDeptRelation:list")
	@RequestMapping(value = {"list", ""})
	public String list(CInsBusinessXmjbxxDeptRelation cInsBusinessXmjbxxDeptRelation, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CInsBusinessXmjbxxDeptRelation> page = cInsBusinessXmjbxxDeptRelationService.findPage(new Page<CInsBusinessXmjbxxDeptRelation>(request, response), cInsBusinessXmjbxxDeptRelation); 
		model.addAttribute("page", page);
		return "modules/xmjbxx/sub/cInsBusinessXmjbxxDeptRelationList";
	}

	/**
	 * 查看，增加，编辑项目部门关系表单页面
	 */
	@RequiresPermissions(value={"xmjbxx:sub:cInsBusinessXmjbxxDeptRelation:view","xmjbxx:sub:cInsBusinessXmjbxxDeptRelation:add","xmjbxx:sub:cInsBusinessXmjbxxDeptRelation:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(CInsBusinessXmjbxxDeptRelation cInsBusinessXmjbxxDeptRelation, Model model) {
		model.addAttribute("cInsBusinessXmjbxxDeptRelation", cInsBusinessXmjbxxDeptRelation);
		return "modules/xmjbxx/sub/cInsBusinessXmjbxxDeptRelationForm";
	}

	/**
	 * 保存项目部门关系
	 */
	@RequiresPermissions(value={"xmjbxx:sub:cInsBusinessXmjbxxDeptRelation:add","xmjbxx:sub:cInsBusinessXmjbxxDeptRelation:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(CInsBusinessXmjbxxDeptRelation cInsBusinessXmjbxxDeptRelation, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, cInsBusinessXmjbxxDeptRelation)){
			return form(cInsBusinessXmjbxxDeptRelation, model);
		}
		if(!cInsBusinessXmjbxxDeptRelation.getIsNewRecord()){//编辑表单保存
			CInsBusinessXmjbxxDeptRelation t = cInsBusinessXmjbxxDeptRelationService.get(cInsBusinessXmjbxxDeptRelation.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(cInsBusinessXmjbxxDeptRelation, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			cInsBusinessXmjbxxDeptRelationService.save(t);//保存
		}else{//新增表单保存
			cInsBusinessXmjbxxDeptRelationService.save(cInsBusinessXmjbxxDeptRelation);//保存
		}
		addMessage(redirectAttributes, "保存项目部门关系成功");
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/sub/cInsBusinessXmjbxxDeptRelation/?repage";
	}
	
	/**
	 * 删除项目部门关系
	 */
	@RequiresPermissions("xmjbxx:sub:cInsBusinessXmjbxxDeptRelation:del")
	@RequestMapping(value = "delete")
	public String delete(CInsBusinessXmjbxxDeptRelation cInsBusinessXmjbxxDeptRelation, RedirectAttributes redirectAttributes) {
		cInsBusinessXmjbxxDeptRelationService.delete(cInsBusinessXmjbxxDeptRelation);
		addMessage(redirectAttributes, "删除项目部门关系成功");
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/sub/cInsBusinessXmjbxxDeptRelation/?repage";
	}
	
	/**
	 * 批量删除项目部门关系
	 */
	@RequiresPermissions("xmjbxx:sub:cInsBusinessXmjbxxDeptRelation:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			cInsBusinessXmjbxxDeptRelationService.delete(cInsBusinessXmjbxxDeptRelationService.get(id));
		}
		addMessage(redirectAttributes, "删除项目部门关系成功");
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/sub/cInsBusinessXmjbxxDeptRelation/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("xmjbxx:sub:cInsBusinessXmjbxxDeptRelation:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(CInsBusinessXmjbxxDeptRelation cInsBusinessXmjbxxDeptRelation, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "项目部门关系"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<CInsBusinessXmjbxxDeptRelation> page = cInsBusinessXmjbxxDeptRelationService.findPage(new Page<CInsBusinessXmjbxxDeptRelation>(request, response, -1), cInsBusinessXmjbxxDeptRelation);
    		new ExportExcel("项目部门关系", CInsBusinessXmjbxxDeptRelation.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出项目部门关系记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/sub/cInsBusinessXmjbxxDeptRelation/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("xmjbxx:sub:cInsBusinessXmjbxxDeptRelation:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<CInsBusinessXmjbxxDeptRelation> list = ei.getDataList(CInsBusinessXmjbxxDeptRelation.class);
			for (CInsBusinessXmjbxxDeptRelation cInsBusinessXmjbxxDeptRelation : list){
				try{
					cInsBusinessXmjbxxDeptRelationService.save(cInsBusinessXmjbxxDeptRelation);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条项目部门关系记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条项目部门关系记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入项目部门关系失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/sub/cInsBusinessXmjbxxDeptRelation/?repage";
    }
	
	/**
	 * 下载导入项目部门关系数据模板
	 */
	@RequiresPermissions("xmjbxx:sub:cInsBusinessXmjbxxDeptRelation:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "项目部门关系数据导入模板.xlsx";
    		List<CInsBusinessXmjbxxDeptRelation> list = Lists.newArrayList(); 
    		new ExportExcel("项目部门关系数据", CInsBusinessXmjbxxDeptRelation.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/sub/cInsBusinessXmjbxxDeptRelation/?repage";
    }
	
	
	

}