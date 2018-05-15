/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.task.web;

import com.google.common.collect.Lists;
import com.jeeplus.common.config.Global;
import com.jeeplus.common.json.AjaxJson;
import com.jeeplus.common.mapper.JsonMapper;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.modules.log.entity.CInsBusinessLog;
import com.jeeplus.modules.log.utils.BusinessLogUtils;
import com.jeeplus.modules.sys.utils.UserUtils;
import com.jeeplus.modules.task.entity.CInsBusinessSchedulerTask;
import com.jeeplus.modules.task.entity.CInsBusinessXmjbxxTaskRelation;
import com.jeeplus.modules.task.entity.FeedBackXx;
import com.jeeplus.modules.task.service.CInsBusinessSchedulerTaskService;
import com.jeeplus.modules.task.service.CInsBusinessXmjbxxTaskRelationService;
import com.jeeplus.modules.task.service.FeedBackXxService;
import com.jeeplus.modules.task.vo.SchedulerTaskSearchParameter;
import com.jeeplus.modules.task.vo.XmjbxxTaskRelationSearchParameter;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessSsqk;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessTzqk;
import com.jeeplus.modules.xmjbxx.entity.Xmjbxx;
import com.jeeplus.modules.xmjbxx.entity.sub.CInsBusinessXmjbxxDeptRelation;
import com.jeeplus.modules.xmjbxx.service.CInsBusinessSsqkService;
import com.jeeplus.modules.xmjbxx.service.XmjbxxService;

import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.json.Json;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 调度任务Controller
 * @author zcl
 * @version 2017-10-31
 */
@Controller
@RequestMapping(value = "${adminPath}/task/schedulerTask")
public class CInsBusinessSchedulerTaskController extends BaseController {

	@Autowired
	private CInsBusinessSchedulerTaskService cInsBusinessSchedulerTaskService;

	@Autowired
	private CInsBusinessXmjbxxTaskRelationService taskRelationService;
	
	@Autowired
	private XmjbxxService xmjbxxService;
	
	@Autowired
	private CInsBusinessSsqkService cinsbusinessssqkservice;
	
	@Autowired
	private FeedBackXxService feedbackxxService;
	
	@ModelAttribute("task")
	public CInsBusinessSchedulerTask get(@RequestParam(required = false) String id) {
		CInsBusinessSchedulerTask entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = cInsBusinessSchedulerTaskService.get(id);
		}
		if (entity == null) {
			entity = new CInsBusinessSchedulerTask();
		}
		return entity;
	}

	/**
	 * 调度任务列表页面
	 */
	// @RequiresPermissions("task:cInsBusinessSchedulerTask:list")
	@RequestMapping(value = {"list", ""})
	public String list(@ModelAttribute("task") CInsBusinessSchedulerTask task, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CInsBusinessSchedulerTask> page = cInsBusinessSchedulerTaskService.findPage(new Page<CInsBusinessSchedulerTask>(request, response), task);
		model.addAttribute("page", page);
		return "modules/task/cInsBusinessSchedulerTaskList";
	}


	/**
	 * 项目调度-调度任务管理-调度任务管理 列表页面
	 */
	@RequestMapping("taskManagerList")
	public String taskManagerList(SchedulerTaskSearchParameter schedulerTaskSearchParameter, HttpServletRequest request, HttpServletResponse response, Model model) {
		// 设置查询参数
		schedulerTaskSearchParameter.setStatus(CInsBusinessSchedulerTask.STATUS_WXF);
		Page<CInsBusinessSchedulerTask> page = cInsBusinessSchedulerTaskService.findFullPageByParameter(new Page<CInsBusinessSchedulerTask>(request, response), schedulerTaskSearchParameter);
		model.addAttribute("page", page);

		List<CInsBusinessSchedulerTask> schedulerTaskVoList = cInsBusinessSchedulerTaskService.getTaskVoList(page.getList());
		model.addAttribute("taskVoList", schedulerTaskVoList);

		return "modules/task/taskManagerList";
	}

	/**
	 * 项目调度-调度任务管理-已下发任务 列表页面
	 */
	@RequestMapping("issuedTaskList")
	public String issuedTaskList(SchedulerTaskSearchParameter schedulerTaskSearchParameter, HttpServletRequest request, HttpServletResponse response, Model model) {
		// 设置查询参数
		Page<CInsBusinessSchedulerTask> page = cInsBusinessSchedulerTaskService.findYxfListByParameter(new Page<CInsBusinessSchedulerTask>(request, response), schedulerTaskSearchParameter);
		model.addAttribute("page", page);

		List<CInsBusinessSchedulerTask> schedulerTaskVoList = cInsBusinessSchedulerTaskService.getTaskVoList(page.getList());
		model.addAttribute("taskVoList", schedulerTaskVoList);
		return "modules/task/issuedTaskList";
	}

	/**
	 * 查看，增加，编辑调度任务表单页面
	 * @throws ParseException 
	 */
	@RequestMapping("form")
	// @RequiresPermissions(value={"task:cInsBusinessSchedulerTask:view","task:cInsBusinessSchedulerTask:add","task:cInsBusinessSchedulerTask:edit"},logical=Logical.OR)
	public String form(@ModelAttribute("task") CInsBusinessSchedulerTask cInsBusinessSchedulerTask, Xmjbxx xmjbxx,HttpServletRequest request, HttpServletResponse response,  Model model) throws ParseException {
		System.out.println("======");
		xmjbxx.setId(cInsBusinessSchedulerTask.getOrigin());
		model.addAttribute("xmjbxx", xmjbxx);
		if (xmjbxx.getId() != null) {
			// 投资情况
			List<CInsBusinessTzqk> tzqks = xmjbxxService.huixianTzqk(xmjbxx);
			model.addAttribute("tzqks", tzqks);
		}
		List<CInsBusinessXmjbxxTaskRelation> schedulerRelationVoList = new ArrayList<CInsBusinessXmjbxxTaskRelation>();
		
		if(StringUtils.isNotBlank(cInsBusinessSchedulerTask.getId())){
			XmjbxxTaskRelationSearchParameter parameter = new XmjbxxTaskRelationSearchParameter();
			parameter.setTask(cInsBusinessSchedulerTask);
			schedulerRelationVoList = taskRelationService.findFullListByParameter(parameter);
		}
		model.addAttribute("schedulerRelationVoList", schedulerRelationVoList);
		model.addAttribute("cInsBusinessSchedulerTask", cInsBusinessSchedulerTask);
		System.out.println("sfsjjFlag:"+ xmjbxx.getSfsjjFlag());
		model.addAttribute("sfsjjFlag", xmjbxx.getSfsjjFlag());
		
		String xmjbxxid=xmjbxx.getId();
		Xmjbxx xmjb = cInsBusinessSchedulerTaskService.findListByXmjbxxid(xmjbxxid);	
		
		System.out.println(xmjb.getRemarks());
		if(xmjb.getRemarks() ==null){
			model.addAttribute("type",0);
		}else{
			model.addAttribute("type",xmjb.getRemarks());
		}
		//企业信用反馈信息
		/*FeedBackXx feedbackxx= new  FeedBackXx();
		feedbackxx.setObjname(xmjb.getXmfrdw());
		feedbackxx.setObjtype("1");
		feedbackxx.setCreditcode(xmjb.getIncid());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String strdate=sdf.format(new Date());
		feedbackxx.setExecutedt(sdf.parse(strdate));
		feedbackxx.setExecuteunit("河南省发展和改革委员会投资处");
		feedbackxx.setAccordingto("省发改革委行政许可");
		feedbackxx.setContent(xmjb.getRemarks());
		feedbackxx.setMoney("0");
		feedbackxx.setBacktype("1");
		feedbackxx.setFlag("0");
		feedbackxxService.save(feedbackxx);*/
		return "modules/task/schedulerTaskForm";
	}

	/**
	 * 保存调度任务
	 */
	// @RequiresPermissions(value={"task:cInsBusinessSchedulerTask:add","task:cInsBusinessSchedulerTask:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(CInsBusinessSchedulerTask cInsBusinessSchedulerTask, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, cInsBusinessSchedulerTask)){
			Xmjbxx xmjbxx = new Xmjbxx();
			return form(cInsBusinessSchedulerTask, xmjbxx, null, null, model);
		}
		if(!cInsBusinessSchedulerTask.getIsNewRecord()){//编辑表单保存
			CInsBusinessSchedulerTask t = cInsBusinessSchedulerTaskService.get(cInsBusinessSchedulerTask.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(cInsBusinessSchedulerTask, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			cInsBusinessSchedulerTaskService.save(t);//保存
		}else{//新增表单保存
			cInsBusinessSchedulerTaskService.save(cInsBusinessSchedulerTask);//保存
		}
		addMessage(redirectAttributes, "保存调度任务成功");
		return "redirect:"+Global.getAdminPath()+"/task/cInsBusinessSchedulerTask/?repage";
	}

	/**
	 * 保存调度任务
	 */
	@RequestMapping(value = "saveSchedulerTask")
	@ResponseBody
	public AjaxJson saveSchedulerTask(CInsBusinessSchedulerTask cInsBusinessSchedulerTask, CInsBusinessTzqk tzqk, Model model,String ids, String xmjbxx_id) throws Exception{
		AjaxJson aj = new AjaxJson();
		if (!beanValidator(model, cInsBusinessSchedulerTask)){
			aj.setSuccess(false);
			aj.setMsg("请将数据填写完整！");
			return aj;
		}
		if(!cInsBusinessSchedulerTask.getIsNewRecord()){//编辑表单保存
			CInsBusinessSchedulerTask t = cInsBusinessSchedulerTaskService.get(cInsBusinessSchedulerTask.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(cInsBusinessSchedulerTask, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			cInsBusinessSchedulerTaskService.save(t);//保存

			// 添加业务日志
			BusinessLogUtils.saveLog(t, CInsBusinessLog.OPERATE_TASK_ADD, CInsBusinessLog.TYPE_TASK);
		}else{//新增表单保存
			cInsBusinessSchedulerTask.setStatus(CInsBusinessSchedulerTask.STATUS_WXF);
			cInsBusinessSchedulerTaskService.save(cInsBusinessSchedulerTask);//保存

			// 添加业务日志
			BusinessLogUtils.saveLog(cInsBusinessSchedulerTask, CInsBusinessLog.OPERATE_TASK_EDIT, CInsBusinessLog.TYPE_TASK);
		}
		if(!(xmjbxx_id==null)){
//			tzqk
		}
		aj.setMsg("调度任务保存成功！");
		aj.put("id", cInsBusinessSchedulerTask.getId());
		System.out.println(cInsBusinessSchedulerTask.getOrigin());
		System.out.println(cInsBusinessSchedulerTask.getId());
		/**
		 * 任务和项目信息绑定
		 */
		cInsBusinessSchedulerTaskService.selectToSchedulerTask(cInsBusinessSchedulerTask.getId(), cInsBusinessSchedulerTask.getType(), cInsBusinessSchedulerTask.getOrigin());
		/**
		 * 任务下发
		 */
		cInsBusinessSchedulerTaskService.issueTasks(cInsBusinessSchedulerTask.getId());
		
		
		return aj;
	}

	/**
	 * 删除调度任务
	 */
	// @RequiresPermissions("task:cInsBusinessSchedulerTask:del")
	@RequestMapping(value = "delete")
	public String delete(CInsBusinessSchedulerTask cInsBusinessSchedulerTask, RedirectAttributes redirectAttributes) {
		cInsBusinessSchedulerTaskService.delete(cInsBusinessSchedulerTask);
		addMessage(redirectAttributes, "删除调度任务成功");
		return "redirect:"+Global.getAdminPath()+"/task/cInsBusinessSchedulerTask/?repage";
	}
	
	/**
	 * 批量删除调度任务
	 */
	// @RequiresPermissions("task:cInsBusinessSchedulerTask:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			cInsBusinessSchedulerTaskService.delete(cInsBusinessSchedulerTaskService.get(id));
		}
		addMessage(redirectAttributes, "删除调度任务成功");
		return "redirect:"+Global.getAdminPath()+"/task/cInsBusinessSchedulerTask/?repage";
	}

	// 投资计划-编制区-筛选储备库项目-确定
	@RequestMapping("selectToSchedulerTask")
	@ResponseBody
	public AjaxJson selectToSchedulerTask(String ids, String originType, String taskId) {
		AjaxJson aj = new AjaxJson();
		aj.setMsg("挑选成功！");
		try {
			cInsBusinessSchedulerTaskService.selectToSchedulerTask(taskId, originType, ids);
		} catch (Exception e) {
			e.printStackTrace();
			aj.setSuccess(false);
			aj.setMsg("挑选失败！");
		}
		return aj;
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("task:cInsBusinessSchedulerTask:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(CInsBusinessSchedulerTask cInsBusinessSchedulerTask, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "调度任务"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<CInsBusinessSchedulerTask> page = cInsBusinessSchedulerTaskService.findPage(new Page<CInsBusinessSchedulerTask>(request, response, -1), cInsBusinessSchedulerTask);
    		new ExportExcel("调度任务", CInsBusinessSchedulerTask.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出调度任务记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/task/cInsBusinessSchedulerTask/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("task:cInsBusinessSchedulerTask:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<CInsBusinessSchedulerTask> list = ei.getDataList(CInsBusinessSchedulerTask.class);
			for (CInsBusinessSchedulerTask cInsBusinessSchedulerTask : list){
				try{
					cInsBusinessSchedulerTaskService.save(cInsBusinessSchedulerTask);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条调度任务记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条调度任务记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入调度任务失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/task/cInsBusinessSchedulerTask/?repage";
    }
	
	/**
	 * 下载导入调度任务数据模板
	 */
	@RequiresPermissions("task:cInsBusinessSchedulerTask:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "调度任务数据导入模板.xlsx";
    		List<CInsBusinessSchedulerTask> list = Lists.newArrayList(); 
    		new ExportExcel("调度任务数据", CInsBusinessSchedulerTask.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/task/cInsBusinessSchedulerTask/?repage";
    }

	/**
	 * 下发调度任务
	 */
    @RequestMapping("issueTasks")
	public String issueTasks(String ids, RedirectAttributes redirectAttributes) {
		addMessage(redirectAttributes, "下发调度任务成功");
		try {
			cInsBusinessSchedulerTaskService.issueTasks(ids);
		} catch (Exception e) {
			e.printStackTrace();
			addMessage(redirectAttributes, "下发调度任务失败！错误信息：" + e.getMessage());
		}
		return "redirect:" + Global.getAdminPath() + "/task/schedulerTask/taskManagerList";
	}
    /**
	 *  滚动计划 编制区	审核确认 基本信息
	 */
	
	@RequestMapping(value = "savaSsqkInfo")
	public void savaSsqkInfo(CInsBusinessSsqk cinsbusinessssqk,HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) throws Exception{
	
		String xmjbxxid=request.getParameter("xmjbxxid");
		String ssqkInfo=request.getParameter("ssqkInfo");
		JSONObject  jsonobject =JSONObject.fromObject(ssqkInfo);
		String zyysntzLjdwzj= (String)jsonobject.get("zyysntzLjdwzj")+"";
		String qtzyczxjszjljdwzj=(String)jsonobject.get("qtzyczxjszjljdwzj")+"";
		String zxzqmjdzxjszjljdwzj=(String)jsonobject.get("zxzqmjdzxjszjljdwzj")+"";
		String zysljsjjljdwzj=(String)jsonobject.get("zysljsjjljdwzj")+"";
		String nsbdgcjjljdwzj=(String)jsonobject.get("nsbdgcjjljdwzj")+"";
		String tljszxjjljdwzj= (String)jsonobject.get("tljszxjjljdwzj")+"";
		String mhfzjjljdwzj= (String)jsonobject.get("mhfzjjljdwzj")+"";
		String gjzdslgcjsjjljdwzj= (String)jsonobject.get("gjzdslgcjsjjljdwzj")+"";
		String dzxskymhqfcjjljdwzj= (String)jsonobject.get("dzxskymhqfcjjljdwzj");
		String dzxskymhqfcjyjjljdwzj= (String)jsonobject.get("dzxskymhqfcjyjjljdwzj")+"";
		String glgkjszxjjljdwzj= (String)jsonobject.get("glgkjszxjjljdwzj")+"";
		String shengjiysntzljdwzj= (String)jsonobject.get("shengjiysntzljdwzj")+"";
		String shijiysntzljdwzj= (String)jsonobject.get("shijiysntzljdwzj")+"";
		String xianjiysntzljdwzj= (String)jsonobject.get("xianjiysntzljdwzj")+"";
		String shengjiczzjljdwzj= (String)jsonobject.get("shengjiczzjljdwzj")+"";
		String shijiczzjljdwzj= (String)jsonobject.get("shijiczzjljdwzj")+"";
		String xianjiczzjljdwzj= (String)jsonobject.get("xianjiczzjljdwzj")+"";
		String dfzxjsjjljdwzj= (String)jsonobject.get("dfzxjsjjljdwzj")+"";
		String qyzytzljdwzj= (String)jsonobject.get("qyzytzljdwzj")+"";
		String yhdkljdwzj=(String)jsonobject.get("yhdkljdwzj")+"";
		String lywzljdwzj= (String)jsonobject.get("lywzljdwzj")+"";
		String zjqdddljdwzj=(String)jsonobject.get("zjqdddljdwzj")+"";
		String qtzjljdwzj=(String)jsonobject.get("qtzjljdwzj")+"";
		CInsBusinessSsqk cInfozssqk = null;
		//根据xmjbxxid获取实施情况 信息
		cInfozssqk =cInsBusinessSchedulerTaskService.getSsqkByXmjbxxid(xmjbxxid);
		cInfozssqk.setZyysntzLjdwzj(Double.valueOf("".equals(zyysntzLjdwzj)?"0":zyysntzLjdwzj));
		cInfozssqk.setQtzyczxjszjLjdwzj(Double.valueOf("".equals(qtzyczxjszjljdwzj)?"0":qtzyczxjszjljdwzj));
		cInfozssqk.setZysljsjjLjdwzj(Double.valueOf("".equals(zysljsjjljdwzj)?"0":zysljsjjljdwzj));
		cInfozssqk.setNsbdgcjjLjdwzj(Double.valueOf("".equals(nsbdgcjjljdwzj)?"0":nsbdgcjjljdwzj));
		cInfozssqk.setTljszxjjLjdwzj(Double.valueOf("".equals(tljszxjjljdwzj)?"0":tljszxjjljdwzj));
		cInfozssqk.setMhfzjjLjdwzj(Double.valueOf("".equals(mhfzjjljdwzj)?"0":mhfzjjljdwzj));
		cInfozssqk.setGjzdslgcjsjjLjdwzj(Double.valueOf("".equals(gjzdslgcjsjjljdwzj)?"0":gjzdslgcjsjjljdwzj));
		cInfozssqk.setDzxskymhqfcjjLjdwzj(Double.valueOf("".equals(dzxskymhqfcjjljdwzj)?"0":dzxskymhqfcjjljdwzj));
		cInfozssqk.setDzxskymhqfcjyjjLjdwzj(Double.valueOf("".equals(dzxskymhqfcjyjjljdwzj)?"0":dzxskymhqfcjyjjljdwzj));
		cInfozssqk.setGlgkjszxjjLjdwzj(Double.valueOf("".equals(glgkjszxjjljdwzj)?"0":glgkjszxjjljdwzj));
		cInfozssqk.setShengjiysntzLjdwzj(Double.valueOf("".equals(shengjiysntzljdwzj)?"0":shengjiysntzljdwzj));
		cInfozssqk.setShijiysntzLjdwzj(Double.valueOf("".equals(shijiysntzljdwzj)?"0":shijiysntzljdwzj));
		cInfozssqk.setXianjiysntzLjdwzj(Double.valueOf("".equals(xianjiysntzljdwzj)?"0":xianjiysntzljdwzj));
		cInfozssqk.setShengjiczzjLjdwzj(Double.valueOf("".equals(shengjiczzjljdwzj)?"0":shengjiczzjljdwzj));
		cInfozssqk.setShijiczzjLjdwzj(Double.valueOf("".equals(shijiczzjljdwzj)?"0":shijiczzjljdwzj));
		cInfozssqk.setXianjiczzjLjdwzj(Double.valueOf("".equals(xianjiczzjljdwzj)?"0":xianjiczzjljdwzj));                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
		cInfozssqk.setDfzxjsjjLjdwzj(Double.valueOf("".equals(dfzxjsjjljdwzj)?"0":dfzxjsjjljdwzj));
		cInfozssqk.setQyzytzLjdwzj(Double.valueOf("".equals(qyzytzljdwzj)?"0":qyzytzljdwzj));
		cInfozssqk.setYhdkLjdwzj(Double.valueOf("".equals(yhdkljdwzj)?"0":yhdkljdwzj));
		cInfozssqk.setLywzLjdwzj(Double.valueOf("".equals(lywzljdwzj)?"0":lywzljdwzj));
		cInfozssqk.setZjqdddLjdwzj(Double.valueOf("".equals(zjqdddljdwzj)?"0":zjqdddljdwzj));
		cInfozssqk.setQtzjLjdwzj(Double.valueOf("".equals(qtzjljdwzj)?"0":qtzjljdwzj));
		cInfozssqk.setXmjbxx(xmjbxxService.get(xmjbxxid));
		cInfozssqk.setType("1");
		PrintWriter out=null;
		try {
			out=response.getWriter();
			String newid = UUID.randomUUID().toString().replaceAll("-", "");
			cInfozssqk.setId(newid);
			cInfozssqk.setIsNewRecord(true);
			cinsbusinessssqkservice.save(cInfozssqk);
		} catch (Exception e) {
			e.printStackTrace();
			out.println("1");
		}
		out.println("0");
	}

}
