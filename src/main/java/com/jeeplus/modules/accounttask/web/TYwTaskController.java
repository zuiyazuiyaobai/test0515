/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.accounttask.web;

import java.util.Arrays;
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
import com.jeeplus.modules.accounttask.entity.TYwTask;
import com.jeeplus.modules.accounttask.service.TYwTaskService;
import com.jeeplus.modules.sys.entity.User;
import com.jeeplus.modules.sys.utils.UserUtils;

/**
 * 任务信息Controller
 * @author aaa
 * @version 2018-05-21
 */
@Controller
@RequestMapping(value = "${adminPath}/accounttask/tYwTask")
public class TYwTaskController extends BaseController {

	@Autowired
	private TYwTaskService tYwTaskService;
	
	@ModelAttribute
	public TYwTask get(@RequestParam(required=false) String id) {
		TYwTask entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tYwTaskService.get(id);
		}
		if (entity == null){
			entity = new TYwTask();
		}
		return entity;
	}
	
	/**
	 * 任务信息列表页面
	 */
	@RequiresPermissions("accounttask:tYwTask:list")
	@RequestMapping(value = {"list", ""})
	public String list(TYwTask tYwTask, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		//如果当前用户权限是 台账录入审核权限 则查看所有任务信息， 否则 加入 责任单位 关联 部门编号查询 当前部门的 任务信息
		if(Arrays.asList(user.getRoleNames().split(",")).contains("台账录入审核权限")){
		}else{
			tYwTask.setResponseUnitId(user.getOffice().getId());
		}
		String accountId = request.getParameter("id");
		tYwTask.setParentId(accountId);
		Page<TYwTask> page = tYwTaskService.findPage(new Page<TYwTask>(request, response), tYwTask); 
		model.addAttribute("accountId", accountId);
		model.addAttribute("tYwTask", tYwTask);
		model.addAttribute("page", page);
		return "modules/accounttask/tYwTaskList";
	}

	/**
	 * 查看，增加，编辑任务信息表单页面
	 */
	@RequiresPermissions(value={"accounttask:tYwTask:view","accounttask:tYwTask:add","accounttask:tYwTask:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(TYwTask tYwTask, Model model, HttpServletRequest request) {
//		判断是更新操作还是 查看操作
		model.addAttribute("operation", request.getParameter("operation"));
		model.addAttribute("tYwTask", tYwTask);
		return "modules/accounttask/tYwTaskForm";
//		return "modules/accounttask/tYwTaskList";
		
	}

	/**
	 * 保存任务信息
	 */
	@RequiresPermissions(value={"accounttask:tYwTask:add","accounttask:tYwTask:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(TYwTask tYwTask, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request) throws Exception{
		User user = UserUtils.getUser();
		if (!beanValidator(model, tYwTask)){
			return form(tYwTask, model,request);
		}
		if(!tYwTask.getIsNewRecord()){//编辑表单保存
			TYwTask t = tYwTaskService.get(tYwTask.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(tYwTask, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			tYwTaskService.save(t);//保存
		}else{//新增表单保存
			tYwTask.setCreateTime(new Date());
			tYwTask.setCreater(user.getId());
			tYwTaskService.save(tYwTask);//保存
		}
		addMessage(redirectAttributes, "保存任务信息成功");
		System.out.println("redirect:"+Global.getAdminPath()+"/accounttask/tYwTask/?repage");
		return "redirect:"+Global.getAdminPath()+"/accounttask/tYwTask/?id="+tYwTask.getParentId();
	}
	
	/**
	 * 删除任务信息
	 */
	@RequiresPermissions("accounttask:tYwTask:del")
	@RequestMapping(value = "delete")
	public String delete(TYwTask tYwTask, RedirectAttributes redirectAttributes) {
		tYwTaskService.delete(tYwTask);
		addMessage(redirectAttributes, "删除任务信息成功");
		return "redirect:"+Global.getAdminPath()+"/accounttask/tYwTask/?id="+tYwTask.getParentId();
	}
	
	/**
	 * 批量删除任务信息
	 */
	@RequiresPermissions("accounttask:tYwTask:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			tYwTaskService.delete(tYwTaskService.get(id));
		}
		addMessage(redirectAttributes, "删除任务信息成功");
		return "redirect:"+Global.getAdminPath()+"/accounttask/tYwTask/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("accounttask:tYwTask:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(TYwTask tYwTask, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "任务信息"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<TYwTask> page = tYwTaskService.findPage(new Page<TYwTask>(request, response, -1), tYwTask);
    		new ExportExcel("任务信息", TYwTask.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出任务信息记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/accounttask/tYwTask/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("accounttask:tYwTask:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<TYwTask> list = ei.getDataList(TYwTask.class);
			for (TYwTask tYwTask : list){
				try{
					tYwTaskService.save(tYwTask);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条任务信息记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条任务信息记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入任务信息失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/accounttask/tYwTask/?repage";
    }
	
	/**
	 * 下载导入任务信息数据模板
	 */
	@RequiresPermissions("accounttask:tYwTask:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "任务信息数据导入模板.xlsx";
    		List<TYwTask> list = Lists.newArrayList(); 
    		new ExportExcel("任务信息数据", TYwTask.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/accounttask/tYwTask/?repage";
    }
	
	
	

}