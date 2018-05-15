/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.zdxmwtqk.web;

import java.util.ArrayList;
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
import com.jeeplus.modules.zdxmwt.entity.CInsBusinessZdxmwt;
import com.jeeplus.modules.zdxmwt.service.CInsBusinessZdxmwtService;
import com.jeeplus.modules.zdxmwthf.entity.CInsBusinessZdxmwthf;
import com.jeeplus.modules.zdxmwtqk.service.CInsBusinessZdxmwtqkService;

/**
 * 重点项目问题决绝情况Controller
 * @author gl
 * @version 2017-06-07
 */
@Controller
@RequestMapping(value = "${adminPath}/zdxmwtqk/wtqk")
public class CInsBusinessZdxmwtqkController extends BaseController {

	@Autowired
	private CInsBusinessZdxmwtqkService cInsBusinessZdxmwtqkService;
	
	@Autowired
	private CInsBusinessZdxmwtService cInsBusinessZdxmwtService;
	
	@ModelAttribute
	public CInsBusinessZdxmwthf get(@RequestParam(required=false) String id) {
		CInsBusinessZdxmwthf entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cInsBusinessZdxmwtqkService.get(id);
		}
		if (entity == null){
			entity = new CInsBusinessZdxmwthf();
		}
		return entity;
	}
	
	/**
	 * 重点项目问题决绝情况列表页面
	 */
	@RequiresPermissions("zdxmwtqk:wtqk:list")
	@RequestMapping(value = {"list", ""})
	public String list(CInsBusinessZdxmwt cInsBusinessZdxmwt, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<CInsBusinessZdxmwt> list=new ArrayList<CInsBusinessZdxmwt>();
		User user=UserUtils.getUser();
		if(user.getOffice()!=null&&user.getOffice().getArea()!=null){
		cInsBusinessZdxmwt.setDeptid(user.getOffice().getArea().getId());
		}
		Page<CInsBusinessZdxmwt> page = cInsBusinessZdxmwtService.findWtqkList(new Page<CInsBusinessZdxmwt>(request, response), cInsBusinessZdxmwt); 
		list=page.getList();
		if (list!=null) {
			for(int i=0;i<list.size();i++){
				list.get(i).setWttype(SwitchColumn.switchWttype(list.get(i).getWttype()));
				list.get(i).setStagetype(SwitchColumn.switchStagetype(list.get(i).getStagetype()));
				list.get(i).setWtlevel(SwitchColumn.switchWtlevel(list.get(i).getWtlevel()));
			}
			page.setList(list);
		}
		model.addAttribute("page", page);
		return "modules/zdxmwtqk/wtqkList";
	}

	/**
	 * 查看重点项目问题决绝情况表单页面
	 */
	@RequiresPermissions(value={"zdxmwtqk:wtqk:view","zdxmwtqk:wtqk:add","zdxmwtqk:wtqk:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(CInsBusinessZdxmwthf cInsBusinessZdxmwthf, Model model) {
		List<CInsBusinessZdxmwthf> list=cInsBusinessZdxmwtqkService.findWthqkById(cInsBusinessZdxmwthf.getId());
		model.addAttribute("cInsBusinessZdxmwthf", list);
		return "modules/zdxmwtqk/wtqkForm";
	}
	/**
	 * 办结重点项目问题页面
	 */
	@RequiresPermissions(value={"zdxmwtqk:wtqk:view","zdxmwtqk:wtqk:add","zdxmwtqk:wtqk:edit"},logical=Logical.OR)
	@RequestMapping(value = "edit")
	public String finish(CInsBusinessZdxmwthf cInsBusinessZdxmwthf, Model model) {
		boolean flag=false;
		List<CInsBusinessZdxmwthf> list=cInsBusinessZdxmwtqkService.findWthqkById(cInsBusinessZdxmwthf.getId());
		if (list!=null) {
			for (int i = 0; i < list.size(); i++) {
				if ("0".equals(list.get(i).getSfhf())) {
					flag=true;
					break;
				}
			}
		}
		model.addAttribute("cInsBusinessZdxmwthf", list);
		if (flag) {
			return "modules/zdxmwtqk/wtbjError";
		}
		return "modules/zdxmwtqk/wtbjList";
	}
	
	/**
	 * 保存重点项目问题决绝情况
	 */
	@RequiresPermissions(value={"zdxmwtqk:wtqk:add","zdxmwtqk:wtqk:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(CInsBusinessZdxmwthf cInsBusinessZdxmwthf, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, cInsBusinessZdxmwthf)){
			return form(cInsBusinessZdxmwthf, model);
		}
			//办结修改问题状态和办结时间
			CInsBusinessZdxmwt cInsBusinessZdxmwt=cInsBusinessZdxmwtService.get(cInsBusinessZdxmwthf.getWtid());
			cInsBusinessZdxmwt.setWtclyj(cInsBusinessZdxmwthf.getHfnr());
			cInsBusinessZdxmwt.setStatus("3");
			cInsBusinessZdxmwt.setBjtime(new Date());
			cInsBusinessZdxmwt.setIsNewRecord(false);
			cInsBusinessZdxmwtService.save(cInsBusinessZdxmwt);
		addMessage(redirectAttributes, "重点项目问题办结成功");
		return "redirect:"+Global.getAdminPath()+"/zdxmwtqk/wtqk/?repage";
	}
	
	/**
	 * 删除重点项目问题决绝情况
	 */
	@RequiresPermissions("zdxmwtqk:cInsBusinessZdxmwthf:del")
	@RequestMapping(value = "delete")
	public String delete(CInsBusinessZdxmwthf cInsBusinessZdxmwthf, RedirectAttributes redirectAttributes) {
		cInsBusinessZdxmwtqkService.delete(cInsBusinessZdxmwthf);
		addMessage(redirectAttributes, "删除重点项目问题决绝情况成功");
		return "redirect:"+Global.getAdminPath()+"/zdxmwtqk/cInsBusinessZdxmwthf/?repage";
	}
	
	/**
	 * 批量删除重点项目问题决绝情况
	 */
	@RequiresPermissions("zdxmwtqk:cInsBusinessZdxmwthf:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			cInsBusinessZdxmwtqkService.delete(cInsBusinessZdxmwtqkService.get(id));
		}
		addMessage(redirectAttributes, "删除重点项目问题决绝情况成功");
		return "redirect:"+Global.getAdminPath()+"/zdxmwtqk/cInsBusinessZdxmwthf/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("zdxmwtqk:cInsBusinessZdxmwthf:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(CInsBusinessZdxmwthf cInsBusinessZdxmwthf, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "重点项目问题决绝情况"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<CInsBusinessZdxmwthf> page = cInsBusinessZdxmwtqkService.findPage(new Page<CInsBusinessZdxmwthf>(request, response, -1), cInsBusinessZdxmwthf);
    		new ExportExcel("重点项目问题决绝情况", CInsBusinessZdxmwthf.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出重点项目问题决绝情况记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/zdxmwtqk/cInsBusinessZdxmwthf/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("zdxmwtqk:cInsBusinessZdxmwthf:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<CInsBusinessZdxmwthf> list = ei.getDataList(CInsBusinessZdxmwthf.class);
			for (CInsBusinessZdxmwthf cInsBusinessZdxmwthf : list){
				try{
					cInsBusinessZdxmwtqkService.save(cInsBusinessZdxmwthf);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条重点项目问题决绝情况记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条重点项目问题决绝情况记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入重点项目问题决绝情况失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/zdxmwtqk/cInsBusinessZdxmwthf/?repage";
    }
	
	/**
	 * 下载导入重点项目问题决绝情况数据模板
	 */
	@RequiresPermissions("zdxmwtqk:cInsBusinessZdxmwthf:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "重点项目问题决绝情况数据导入模板.xlsx";
    		List<CInsBusinessZdxmwthf> list = Lists.newArrayList(); 
    		new ExportExcel("重点项目问题决绝情况数据", CInsBusinessZdxmwthf.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/zdxmwtqk/cInsBusinessZdxmwthf/?repage";
    }
	
	
	

}