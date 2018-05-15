/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.zdxmcs.web;

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
import com.jeeplus.modules.sys.entity.User;
import com.jeeplus.modules.sys.utils.UserUtils;
import com.jeeplus.modules.tools.utils.SwitchColumn;
import com.jeeplus.modules.zdxmcs.entity.CInsBusinessInfo;
import com.jeeplus.modules.zdxmcs.entity.CInsBusinessZdgcxm;
import com.jeeplus.modules.zdxmcs.service.CInsBusinessInfoService;
import com.jeeplus.modules.zdxmcs.service.CInsBusinessZdgcxmService;

/**
 * 重点项目初审菜单Controller
 * @author tys
 * @version 2017-05-11
 */
@Controller
@RequestMapping(value = "${adminPath}/zdxmcs/cs")
public class CInsBusinessZdgcxmController extends BaseController {

	@Autowired
	private CInsBusinessZdgcxmService cInsBusinessZdgcxmService;
	
	@Autowired
	private CInsBusinessInfoService  cInsBusinessInfoService;

	/**
	 * 重点项目初审菜单列表页面
	 */
	@RequiresPermissions("zdxmcs:cs:list")
	@RequestMapping(value = {"list", ""})
	public String list(CInsBusinessZdgcxm cInsBusinessZdgcxm, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<CInsBusinessZdgcxm> list=new ArrayList<CInsBusinessZdgcxm>();
		Page<CInsBusinessZdgcxm> page = cInsBusinessZdgcxmService.findPage(new Page<CInsBusinessZdgcxm>(request, response), cInsBusinessZdgcxm); 
		list=page.getList();
		if(list!=null){
			for(int i=0;i<list.size();i++){
				list.get(i).setZdxmlx(SwitchColumn.switchZdxmlx(list.get(i).getZdxmlx()));
				list.get(i).setCylx(SwitchColumn.switchCylx(list.get(i).getCylx()));
			}
			page.setList(list);
		}
		model.addAttribute("page", page);
		return "modules/zdxmcs/csList";
	}

	/**
	 * 查看重点项目初审菜单表单页面
	 */
	@RequiresPermissions(value={"zdxmcs:cs:view","zdxmcs:cs:edit"},logical=Logical.OR)
	@RequestMapping(value = "edit")
	public String form(CInsBusinessZdgcxm cInsBusinessZdgcxm, Model model) {
		CInsBusinessZdgcxm zdgcxm  = cInsBusinessZdgcxmService.get(cInsBusinessZdgcxm.getId());
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
		return "modules/zdxmcs/csEdit";
	}
	/**
	 * 审核重点项目初审菜单表单页面
	 */
	@RequiresPermissions(value={"zdxmcs:cs:view","zdxmcs:cs:edit"},logical=Logical.OR)
	@RequestMapping(value = "auditing")
	public String submitForm(CInsBusinessZdgcxm cInsBusinessZdgcxm, Model model) {
		CInsBusinessZdgcxm zdgcxm  = cInsBusinessZdgcxmService.get(cInsBusinessZdgcxm.getId());
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
		return "modules/zdxmcs/csAuditing";
	}
	

	/**
	 * 保存重点项目初审菜单
	 */
	@RequiresPermissions(value={"zdxmcs:cs:add","zdxmcs:cs:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(CInsBusinessZdgcxm cInsBusinessZdgcxm, Model model, RedirectAttributes redirectAttributes) throws Exception{
		String type=cInsBusinessZdgcxm.getCstype();
		if (!beanValidator(model, cInsBusinessZdgcxm)){
			return form(cInsBusinessZdgcxm, model);
		}
		if(!cInsBusinessZdgcxm.getIsNewRecord()){//编辑表单保存
			//获取当前用户id
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				cInsBusinessZdgcxm.setCsuserid(user.getId());
			}
			CInsBusinessZdgcxm t = cInsBusinessZdgcxmService.get(cInsBusinessZdgcxm.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(cInsBusinessZdgcxm, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			//修改状态，保存初审审核意见
			if ("1".equals(type)) {
				t.setStatus("1");
			}else {
				t.setStatus("3");
			}
			t.setCsmsg(cInsBusinessZdgcxm.getCsmsg());
			cInsBusinessZdgcxmService.save(t);//保存
		}else{//新增表单保存
			cInsBusinessZdgcxmService.save(cInsBusinessZdgcxm);//保存
		}
		addMessage(redirectAttributes, "审核重点项目初审菜单成功");
		return "redirect:"+Global.getAdminPath()+"/zdxmcs/cs/?repage";
		//return "modules/zdxmcs/csAuditing";
	}
	
	/**
	 * 删除重点项目初审菜单
	 */
	@RequiresPermissions("zdxmcs:cs:del")
	@RequestMapping(value = "delete")
	public String delete(CInsBusinessZdgcxm cInsBusinessZdgcxm, RedirectAttributes redirectAttributes) {
		cInsBusinessZdgcxmService.delete(cInsBusinessZdgcxm);
		addMessage(redirectAttributes, "删除重点项目初审菜单成功");
		return "redirect:"+Global.getAdminPath()+"/zdxmcs/cs/?repage";
	}
	
	/**
	 * 批量删除重点项目初审菜单
	 */
	@RequiresPermissions("zdxmcs:cs:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			cInsBusinessZdgcxmService.delete(cInsBusinessZdgcxmService.get(id));
		}
		addMessage(redirectAttributes, "删除重点项目初审菜单成功");
		return "redirect:"+Global.getAdminPath()+"/zdxmcs/cs/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("zdxmcs:cs:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(CInsBusinessZdgcxm cInsBusinessZdgcxm, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "重点项目初审菜单"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<CInsBusinessZdgcxm> page = cInsBusinessZdgcxmService.findPage(new Page<CInsBusinessZdgcxm>(request, response, -1), cInsBusinessZdgcxm);
    		new ExportExcel("重点项目初审菜单", CInsBusinessZdgcxm.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出重点项目初审菜单记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/zdxmcs/cs/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("zdxmcs:cs:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<CInsBusinessZdgcxm> list = ei.getDataList(CInsBusinessZdgcxm.class);
			for (CInsBusinessZdgcxm cInsBusinessZdgcxm : list){
				try{
					cInsBusinessZdgcxmService.save(cInsBusinessZdgcxm);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条重点项目初审菜单记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条重点项目初审菜单记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入重点项目初审菜单失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/zdxmcs/cs/?repage";
    }
	
	/**
	 * 下载导入重点项目初审菜单数据模板
	 */
	@RequiresPermissions("zdxmcs:cs:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "重点项目初审菜单数据导入模板.xlsx";
    		List<CInsBusinessZdgcxm> list = Lists.newArrayList(); 
    		new ExportExcel("重点项目初审菜单数据", CInsBusinessZdgcxm.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/zdxmcs/cs/?repage";
    }
	
	
	

}