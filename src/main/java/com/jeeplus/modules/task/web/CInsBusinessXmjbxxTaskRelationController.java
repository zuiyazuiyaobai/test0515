/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.task.web;

import com.google.common.collect.Lists;
import com.jeeplus.common.config.Global;
import com.jeeplus.common.json.AjaxJson;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.modules.sys.utils.UserUtils;
import com.jeeplus.modules.task.entity.CInsBusinessSchedulerTask;
import com.jeeplus.modules.task.entity.CInsBusinessXmjbxxTaskRelation;
import com.jeeplus.modules.task.service.CInsBusinessSchedulerTaskService;
import com.jeeplus.modules.task.service.CInsBusinessXmjbxxTaskRelationService;
import com.jeeplus.modules.task.vo.XmjbxxTaskRelationSearchParameter;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessSsqk;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessTzqk;
import com.jeeplus.modules.xmjbxx.entity.Xmjbxx;
import com.jeeplus.modules.xmjbxx.service.CInsBusinessSsqkService;
import com.jeeplus.modules.xmjbxx.service.XmjbxxService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 项目基本信息和调度任务关联表Controller
 * @author zcl
 * @version 2017-10-31
 */
@Controller
@RequestMapping(value = "${adminPath}/task/cInsBusinessXmjbxxTaskRelation")
public class CInsBusinessXmjbxxTaskRelationController extends BaseController {
	@Autowired
	private CInsBusinessSchedulerTaskService cInsBusinessSchedulerTaskService;
	
	@Autowired
	private CInsBusinessXmjbxxTaskRelationService cInsBusinessXmjbxxTaskRelationService;

	@Autowired
	private XmjbxxService xmjbxxService;

	@Autowired
	private CInsBusinessSsqkService ssqkService;

	@ModelAttribute
	public CInsBusinessXmjbxxTaskRelation get(@RequestParam(required=false) String id) {
		CInsBusinessXmjbxxTaskRelation entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cInsBusinessXmjbxxTaskRelationService.get(id);
		}
		if (entity == null){
			entity = new CInsBusinessXmjbxxTaskRelation();
		}
		return entity;
	}
	
	/**
	 * 调度任务关联列表页面
	 */
	@RequiresPermissions("task:cInsBusinessXmjbxxTaskRelation:list")
	@RequestMapping(value = {"list", ""})
	public String list(CInsBusinessXmjbxxTaskRelation cInsBusinessXmjbxxTaskRelation, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CInsBusinessXmjbxxTaskRelation> page = cInsBusinessXmjbxxTaskRelationService.findPage(new Page<CInsBusinessXmjbxxTaskRelation>(request, response), cInsBusinessXmjbxxTaskRelation); 
		model.addAttribute("page", page);
		return "modules/task/cInsBusinessXmjbxxTaskRelationList";
	}


	/**
	 * 项目调度-项目调度管理-我的调度任务 列表页面
	 */
	@RequestMapping("myTaskList")
	public String myTaskList(XmjbxxTaskRelationSearchParameter xmjbxxTaskRelationSearchParameter,
							 HttpServletRequest request, HttpServletResponse response, Model model) {
		// 设置查询参数
		xmjbxxTaskRelationSearchParameter.setStatus(CInsBusinessXmjbxxTaskRelation.STATUS_WWC);
		xmjbxxTaskRelationSearchParameter.setDestDeptId(UserUtils.getUser().getOffice().getId());

		Page<CInsBusinessXmjbxxTaskRelation> page = cInsBusinessXmjbxxTaskRelationService.findFullPageByParameter(
				new Page<CInsBusinessXmjbxxTaskRelation>(request, response), xmjbxxTaskRelationSearchParameter);
		model.addAttribute("page", page);

		return "modules/task/myTaskList";
	}
	/**
	 * 项目调度-项目调度管理-我的调出任务 列表页面
	 */
	@RequestMapping("myDcrwList")
	public String myDcrwList(XmjbxxTaskRelationSearchParameter xmjbxxTaskRelationSearchParameter,
							 HttpServletRequest request, HttpServletResponse response, Model model) {
		// 设置查询参数
		xmjbxxTaskRelationSearchParameter.setStatus(CInsBusinessXmjbxxTaskRelation.STATUS_WWC);
		xmjbxxTaskRelationSearchParameter.setDestDeptId(UserUtils.getUser().getOffice().getId());

		Page<CInsBusinessXmjbxxTaskRelation> page = cInsBusinessXmjbxxTaskRelationService.findFullPageByParameterOne(
				new Page<CInsBusinessXmjbxxTaskRelation>(request, response), xmjbxxTaskRelationSearchParameter);
		model.addAttribute("page", page);

		return "modules/task/myDcrwList";
	} 
	/**
	 * 项目调度-项目调度管理-总调度任务 列表页面
	 */
	@RequestMapping("zTaskList")
	public String zTaskList(XmjbxxTaskRelationSearchParameter xmjbxxTaskRelationSearchParameter,
							 HttpServletRequest request, HttpServletResponse response, Model model) {
		// 设置查询参数
		xmjbxxTaskRelationSearchParameter.setStatus(CInsBusinessXmjbxxTaskRelation.STATUS_WWC);
		//xmjbxxTaskRelationSearchParameter.setDestDeptId(UserUtils.getUser().getOffice().getId());

		Page<CInsBusinessXmjbxxTaskRelation> page = cInsBusinessXmjbxxTaskRelationService.findFullPageByParameter(
				new Page<CInsBusinessXmjbxxTaskRelation>(request, response), xmjbxxTaskRelationSearchParameter);
		model.addAttribute("page", page);

		return "modules/task/zTaskList";
	}
	/**
	 * 项目调度-项目调度管理-已完成任务 列表页面
	 */
	@RequestMapping("finishedTaskList")
	public String finishedTaskList(XmjbxxTaskRelationSearchParameter xmjbxxTaskRelationSearchParameter,
							 HttpServletRequest request, HttpServletResponse response, Model model) {
		// 设置查询参数
		xmjbxxTaskRelationSearchParameter.setStatus(CInsBusinessXmjbxxTaskRelation.STATUS_YWC);
		xmjbxxTaskRelationSearchParameter.setDestDeptId(UserUtils.getUser().getOffice().getId());

		Page<CInsBusinessXmjbxxTaskRelation> page = cInsBusinessXmjbxxTaskRelationService.findFullPageByParameter(
				new Page<CInsBusinessXmjbxxTaskRelation>(request, response), xmjbxxTaskRelationSearchParameter);
		model.addAttribute("page", page);

		return "modules/task/finishedTaskList";
	}

	/**
	 * 查看，增加，编辑调度任务关联表单页面
	 */
	@RequiresPermissions(value={"task:cInsBusinessXmjbxxTaskRelation:view","task:cInsBusinessXmjbxxTaskRelation:add","task:cInsBusinessXmjbxxTaskRelation:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(CInsBusinessXmjbxxTaskRelation cInsBusinessXmjbxxTaskRelation, Model model) {
		model.addAttribute("cInsBusinessXmjbxxTaskRelation", cInsBusinessXmjbxxTaskRelation);
		return "modules/task/cInsBusinessXmjbxxTaskRelationForm";
	}

	@RequestMapping("taskFeedback")
	public String taskFeedback(CInsBusinessXmjbxxTaskRelation taskRelation,HttpServletRequest request, HttpServletResponse response,Model model) throws Exception {
		// 前期工作
		CInsBusinessSsqk curSsqk = new CInsBusinessSsqk();
		if (StringUtils.isNotBlank(taskRelation.getId())) {
			// 获取当前的调度内容
			taskRelation = cInsBusinessXmjbxxTaskRelationService.get(taskRelation.getId());
			Xmjbxx xmjbxx = xmjbxxService.get(taskRelation.getXmjbxx().getId());
			taskRelation.setXmjbxx(xmjbxx);
			model.addAttribute("taskRelationVo", taskRelation);

			//截止上期实施情况
			CInsBusinessSsqk ssqk = new CInsBusinessSsqk();
			ssqk.setXmjbxx(xmjbxx);
			ssqk.setType(CInsBusinessSsqk.TYPE_XMTB);
			List<CInsBusinessSsqk> lastSsqkList = ssqkService.findList(ssqk);
			CInsBusinessSsqk lastSsqk = new CInsBusinessSsqk();
			if (!lastSsqkList.isEmpty()) {
				lastSsqk = lastSsqkList.get(0);
			}
			model.addAttribute("lastSsqk", lastSsqk);

			//本期实施情况
			ssqk.setTaskRelation(taskRelation);
			ssqk.setType(CInsBusinessSsqk.TYPE_DDFK);
			List<CInsBusinessSsqk> curSsqkList = ssqkService.findList(ssqk);
			if (!curSsqkList.isEmpty()) {
				curSsqk = curSsqkList.get(0);
			}else {
				MyBeanUtils.copyBeanNotNull2Bean(lastSsqk, curSsqk);
				curSsqk.setIsNewRecord(true);
				curSsqk.setId(null);
			}
		}
		//xmjbxxid 存在  根据xmjbxxid查询历史下达情况
		String xmjbxxid =taskRelation.getXmjbxx().getId();
		Page<CInsBusinessSchedulerTask> page =null;
		List<CInsBusinessSchedulerTask> lsxdlist = null;
		List<CInsBusinessSsqk> fkqklist = null;
		if(StringUtils.isNotBlank(xmjbxxid)){
			//ssqklist = ssqkService.findSsqkListByXmjbxxid(xmjbxxid);
			lsxdlist=cInsBusinessSchedulerTaskService.findLsxdListByXmjbxxid(xmjbxxid);
			fkqklist=ssqkService.findfkqkbyxmjbxxid(xmjbxxid);
		}
		model.addAttribute("fkqklist", fkqklist);
		model.addAttribute("lsxdlist", lsxdlist);
		model.addAttribute("curSsqk", curSsqk);
		return "modules/task/taskFeedbackForm";
	}

	/**
	 * 保存调度任务关联
	 */
	@RequiresPermissions(value={"task:cInsBusinessXmjbxxTaskRelation:add","task:cInsBusinessXmjbxxTaskRelation:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(CInsBusinessXmjbxxTaskRelation cInsBusinessXmjbxxTaskRelation, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, cInsBusinessXmjbxxTaskRelation)){
			return form(cInsBusinessXmjbxxTaskRelation, model);
		}
		if(!cInsBusinessXmjbxxTaskRelation.getIsNewRecord()){//编辑表单保存
			CInsBusinessXmjbxxTaskRelation t = cInsBusinessXmjbxxTaskRelationService.get(cInsBusinessXmjbxxTaskRelation.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(cInsBusinessXmjbxxTaskRelation, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			cInsBusinessXmjbxxTaskRelationService.save(t);//保存
		}else{//新增表单保存
			cInsBusinessXmjbxxTaskRelationService.save(cInsBusinessXmjbxxTaskRelation);//保存
		}
		addMessage(redirectAttributes, "保存调度任务关联成功");
		return "redirect:"+Global.getAdminPath()+"/task/cInsBusinessXmjbxxTaskRelation/?repage";
	}

	/**
	 * 完成调度项目
	 */
	@RequestMapping("finishTask")
	public String finishTask(String id, String feedback, RedirectAttributes redirectAttributes) {
		addMessage(redirectAttributes, "完成调度项目成功");
		try {
			cInsBusinessXmjbxxTaskRelationService.finishTask(id, feedback);
		} catch (Exception e) {
			e.printStackTrace();
			addMessage(redirectAttributes, "完成调度任务失败！错误信息：" + e.getStackTrace().toString());
		}
		return "redirect:"+Global.getAdminPath()+"/task/cInsBusinessXmjbxxTaskRelation/myTaskList?repage";
	}

	/**
	 * 保存调度反馈
	 */
	@RequestMapping("saveTaskFeedback")
	@ResponseBody
	public AjaxJson saveTaskFeedback(CInsBusinessSsqk ssqk, RedirectAttributes redirectAttributes) throws Exception{
		AjaxJson aj = new AjaxJson();
		try {
			ssqkService.saveTaskFeedback(ssqk);
			addMessage(redirectAttributes, "调度反馈保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			aj.setSuccess(false);
			aj.setMsg("调度反馈保存失败！\n" + e.getStackTrace().toString());
		}
		return aj;
	}

	/**
	 * 删除调度任务关联
	 */
	@RequiresPermissions("task:cInsBusinessXmjbxxTaskRelation:del")
	@RequestMapping(value = "delete")
	public String delete(CInsBusinessXmjbxxTaskRelation cInsBusinessXmjbxxTaskRelation, RedirectAttributes redirectAttributes) {
		cInsBusinessXmjbxxTaskRelationService.delete(cInsBusinessXmjbxxTaskRelation);
		addMessage(redirectAttributes, "删除调度任务关联成功");
		return "redirect:"+Global.getAdminPath()+"/task/cInsBusinessXmjbxxTaskRelation/?repage";
	}
	
	/**
	 * 批量删除调度任务关联
	 */
	@RequiresPermissions("task:cInsBusinessXmjbxxTaskRelation:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			cInsBusinessXmjbxxTaskRelationService.delete(cInsBusinessXmjbxxTaskRelationService.get(id));
		}
		addMessage(redirectAttributes, "删除调度任务关联成功");
		return "redirect:"+Global.getAdminPath()+"/task/cInsBusinessXmjbxxTaskRelation/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("task:cInsBusinessXmjbxxTaskRelation:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(CInsBusinessXmjbxxTaskRelation cInsBusinessXmjbxxTaskRelation, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "调度任务关联"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<CInsBusinessXmjbxxTaskRelation> page = cInsBusinessXmjbxxTaskRelationService.findPage(new Page<CInsBusinessXmjbxxTaskRelation>(request, response, -1), cInsBusinessXmjbxxTaskRelation);
    		new ExportExcel("调度任务关联", CInsBusinessXmjbxxTaskRelation.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出调度任务关联记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/task/cInsBusinessXmjbxxTaskRelation/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("task:cInsBusinessXmjbxxTaskRelation:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<CInsBusinessXmjbxxTaskRelation> list = ei.getDataList(CInsBusinessXmjbxxTaskRelation.class);
			for (CInsBusinessXmjbxxTaskRelation cInsBusinessXmjbxxTaskRelation : list){
				try{
					cInsBusinessXmjbxxTaskRelationService.save(cInsBusinessXmjbxxTaskRelation);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条调度任务关联记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条调度任务关联记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入调度任务关联失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/task/cInsBusinessXmjbxxTaskRelation/?repage";
    }
	
	/**
	 * 下载导入调度任务关联数据模板
	 */
	@RequiresPermissions("task:cInsBusinessXmjbxxTaskRelation:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "调度任务关联数据导入模板.xlsx";
    		List<CInsBusinessXmjbxxTaskRelation> list = Lists.newArrayList(); 
    		new ExportExcel("调度任务关联数据", CInsBusinessXmjbxxTaskRelation.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/task/cInsBusinessXmjbxxTaskRelation/?repage";
    }
	
	@RequestMapping("deleteSelect")
	@ResponseBody
	public AjaxJson deleteSelect(String ids){
		AjaxJson aj = new AjaxJson();
		String idArray[] =ids.split(",");
		for(String id : idArray){
			cInsBusinessXmjbxxTaskRelationService.delete(cInsBusinessXmjbxxTaskRelationService.get(id));
		}
		aj.setMsg("调度任务项目删除成功！");
		return aj;
	}
	
	/**
	 * 根据task_id查询调度任务关联列表页面
	 */
	@RequestMapping(value = {"findCInsBusinessXmjbxxTaskRelationList"})
	public String findCInsBusinessXmjbxxTaskRelationList(CInsBusinessXmjbxxTaskRelation cInsBusinessXmjbxxTaskRelation, HttpServletRequest request, HttpServletResponse response, Model model) {
		String task_id = request.getParameter("task_id");
		System.out.println("task_id====" + task_id);
		cInsBusinessXmjbxxTaskRelation.setTask_id(task_id);
		Page<CInsBusinessXmjbxxTaskRelation> page = cInsBusinessXmjbxxTaskRelationService.findPage(new Page<CInsBusinessXmjbxxTaskRelation>(request, response), cInsBusinessXmjbxxTaskRelation); 
		model.addAttribute("page", page);
		return "modules/task/cInsBusinessXmjbxxTaskRelationList";
	}
	/**
	 * 根据ssqkid查询实施情况在反馈情况中的展示
	 */
	@RequestMapping(value = {"fkqkssqk"})
	public String fkqkssqk(String ssqkid, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<CInsBusinessSsqk> fkqkssqklist = null;
		CInsBusinessSsqk ssqk = null;
		if(StringUtils.isNotBlank(ssqkid)){
			try {
				fkqkssqklist=ssqkService.findfkqkssxxbyssqkid(ssqkid);
				ssqk = fkqkssqklist.get(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("cinsbusinessssqk", ssqk);
		return "modules/xmjbxx/include/fkqkSsqkInfo";
	}
	
	@RequestMapping("dcddrw")
	public void dcddrw(String ids,HttpServletRequest request, HttpServletResponse response,Model model) throws Exception {
		PrintWriter out=response.getWriter();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		try {
			String[] idsArr = ids.split(",");
			for (String id : idsArr) {
				CInsBusinessSchedulerTask entity = null;
				CInsBusinessXmjbxxTaskRelation taskRelation=null;
				if(StringUtils.isNotBlank(id)){
					// 获取当前的调度内容
					taskRelation = cInsBusinessXmjbxxTaskRelationService.get(id);
					entity = taskRelation.getTask();
					String taskid = entity.getId();
					//改变调度状态，表示调出
					//entity.setType("10");
					cInsBusinessSchedulerTaskService.setdcrw(taskid);//保存
					String day=df.format(new Date()); 
					cInsBusinessXmjbxxTaskRelationService.updadate(id,day);
					
					out.println("1");
				}
			}
		} catch (Exception e) {
			out.println("0");
			e.printStackTrace();
		}
	}
	
	/**
	 * 项目调度-项目调度管理-我的调度任务-未填报项目列表页面
	 */
	@RequestMapping("myWtbxmList")
	public String myWtbxmList(XmjbxxTaskRelationSearchParameter xmjbxxTaskRelationSearchParameter,
							 HttpServletRequest request, HttpServletResponse response, Model model) {
		// 设置查询参数
		xmjbxxTaskRelationSearchParameter.setStatus(CInsBusinessXmjbxxTaskRelation.STATUS_WWC);
		xmjbxxTaskRelationSearchParameter.setDestDeptId(UserUtils.getUser().getOffice().getId());
		
		String ttpat = request.getParameter("para")==null?"0":request.getParameter("para");
		System.out.println(ttpat);
		System.out.println(ttpat.equals("1"));
		Page<CInsBusinessXmjbxxTaskRelation> page=null;
		if(ttpat.equals("1")){
			page = cInsBusinessXmjbxxTaskRelationService.findFullPageByParametersix(
					new Page<CInsBusinessXmjbxxTaskRelation>(request, response), xmjbxxTaskRelationSearchParameter);
		}else{
			page = cInsBusinessXmjbxxTaskRelationService.findFullPageByParameterfive(
					new Page<CInsBusinessXmjbxxTaskRelation>(request, response), xmjbxxTaskRelationSearchParameter);
		}
		
		model.addAttribute("page", page);

		return "modules/task/myWtbxmList";
	}
}