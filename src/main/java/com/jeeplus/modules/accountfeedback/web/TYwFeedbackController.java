/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.accountfeedback.web;

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
import com.jeeplus.modules.accountfeedback.entity.TYwFeedback;
import com.jeeplus.modules.accountfeedback.service.TYwFeedbackService;
import com.jeeplus.modules.accounttask.entity.TYwTask;
import com.jeeplus.modules.accounttask.service.TYwTaskService;
import com.jeeplus.modules.sys.entity.User;
import com.jeeplus.modules.sys.utils.UserUtils;

/**
 * 反馈信息Controller
 * @author aaa
 * @version 2018-05-21
 */
@Controller
@RequestMapping(value = "${adminPath}/accountfeedback/tYwFeedback")
public class TYwFeedbackController extends BaseController {

	@Autowired
	private TYwFeedbackService tYwFeedbackService;
	@Autowired
	private TYwTaskService tYwTaskService;
	
	@ModelAttribute
	public TYwFeedback get(@RequestParam(required=false) String id) {
		TYwFeedback entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tYwFeedbackService.get(id);
		}
		if (entity == null){
			entity = new TYwFeedback();
		}
		return entity;
	}
	
	/**
	 * 反馈信息列表页面
	 */
	@RequiresPermissions("accountfeedback:tYwFeedback:list")
	@RequestMapping(value = {"list", ""})
	public String list(TYwFeedback tYwFeedback, HttpServletRequest request, HttpServletResponse response, Model model) {
		TYwTask tYwTask = tYwTaskService.get(tYwFeedback.getId());//查询task信息
		model.addAttribute("tYwTask", tYwTask);
		model.addAttribute("tYwFeedback", tYwFeedback);
		
		tYwFeedback.setTaskId(tYwFeedback.getId());
		Page<TYwFeedback> page = tYwFeedbackService.findPage(new Page<TYwFeedback>(request, response), tYwFeedback); 
		model.addAttribute("page", page);
		model.addAttribute("tYwFeedback", tYwFeedback);
		return "modules/accountfeedback/tYwFeedbackList";
	}

	/**
	 * 查看，增加，编辑反馈信息表单页面
	 */
	@RequiresPermissions(value={"accountfeedback:tYwFeedback:view","accountfeedback:tYwFeedback:add","accountfeedback:tYwFeedback:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(TYwFeedback tYwFeedback, Model model, HttpServletRequest request) {
//		判断是更新操作还是 查看操作
		model.addAttribute("operation", request.getParameter("operation"));
		model.addAttribute("tYwFeedback", tYwFeedback);
		return "modules/accountfeedback/tYwFeedbackForm";
	}

	/**
	 * 保存反馈信息
	 */
	@RequiresPermissions(value={"accountfeedback:tYwFeedback:add","accountfeedback:tYwFeedback:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(TYwFeedback tYwFeedback, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request) throws Exception{
		User user = UserUtils.getUser();
		tYwFeedback.setFeedTime(new Date());
		if (!beanValidator(model, tYwFeedback)){
			return form(tYwFeedback, model, request);
		}
		if(!tYwFeedback.getIsNewRecord()){//编辑表单保存
			TYwFeedback t = tYwFeedbackService.get(tYwFeedback.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(tYwFeedback, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			tYwFeedbackService.save(t);//保存
		}else{//新增表单保存
			tYwFeedback.setFeedTime(new Date());
			tYwFeedback.setFeedPersonId(user.getId());
			tYwFeedback.setFeedPerson(user.getName());
			tYwFeedbackService.save(tYwFeedback);//保存
		}
		addMessage(redirectAttributes, "保存反馈信息成功");
//		return "redirect:"+Global.getAdminPath()+"/accountfeedback/tYwFeedback/?repage";
//		return "redirect:"+Global.getAdminPath()+"/accountfeedback/tYwFeedback/form?id="+tYwFeedback.getTaskId();
		return "redirect:"+Global.getAdminPath()+"/accountfeedback/tYwFeedback/?id="+tYwFeedback.getTaskId();
	}
	
	/**
	 * 删除反馈信息
	 */
	@RequiresPermissions("accountfeedback:tYwFeedback:del")
	@RequestMapping(value = "delete")
	public String delete(TYwFeedback tYwFeedback, RedirectAttributes redirectAttributes) {
		tYwFeedbackService.delete(tYwFeedback);
		addMessage(redirectAttributes, "删除反馈信息成功");
		return "redirect:"+Global.getAdminPath()+"/accountfeedback/tYwFeedback/?id="+tYwFeedback.getTaskId();
	}
	
	/**
	 * 批量删除反馈信息
	 */
	@RequiresPermissions("accountfeedback:tYwFeedback:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			tYwFeedbackService.delete(tYwFeedbackService.get(id));
		}
		addMessage(redirectAttributes, "删除反馈信息成功");
		return "redirect:"+Global.getAdminPath()+"/accountfeedback/tYwFeedback/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("accountfeedback:tYwFeedback:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(TYwFeedback tYwFeedback, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "反馈信息"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<TYwFeedback> page = tYwFeedbackService.findPage(new Page<TYwFeedback>(request, response, -1), tYwFeedback);
    		new ExportExcel("反馈信息", TYwFeedback.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出反馈信息记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/accountfeedback/tYwFeedback/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("accountfeedback:tYwFeedback:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<TYwFeedback> list = ei.getDataList(TYwFeedback.class);
			for (TYwFeedback tYwFeedback : list){
				try{
					tYwFeedbackService.save(tYwFeedback);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条反馈信息记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条反馈信息记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入反馈信息失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/accountfeedback/tYwFeedback/?repage";
    }
	
	/**
	 * 下载导入反馈信息数据模板
	 */
	@RequiresPermissions("accountfeedback:tYwFeedback:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "反馈信息数据导入模板.xlsx";
    		List<TYwFeedback> list = Lists.newArrayList(); 
    		new ExportExcel("反馈信息数据", TYwFeedback.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/accountfeedback/tYwFeedback/?repage";
    }
	
	
	

}