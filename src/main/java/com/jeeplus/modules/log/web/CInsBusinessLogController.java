/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.log.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import com.jeeplus.modules.log.vo.CInsBusinessXmjbxxLogVo;
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
import com.jeeplus.modules.log.entity.CInsBusinessLog;
import com.jeeplus.modules.log.service.CInsBusinessLogService;

/**
 * 业务日志Controller
 * @author zcl
 * @version 2017-11-14
 */
@Controller
@RequestMapping(value = "${adminPath}/log/cInsBusinessLog")
public class CInsBusinessLogController extends BaseController {

	@Autowired
	private CInsBusinessLogService cInsBusinessLogService;
	
	@ModelAttribute
	public CInsBusinessLog get(@RequestParam(required=false) String id) {
		CInsBusinessLog entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cInsBusinessLogService.get(id);
		}
		if (entity == null){
			entity = new CInsBusinessLog();
		}
		return entity;
	}
	
	/**
	 * 业务日志列表页面
	 */
	@RequiresPermissions("log:cInsBusinessLog:list")
	@RequestMapping(value = {"list", ""})
	public String list(CInsBusinessLog cInsBusinessLog, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CInsBusinessLog> page = cInsBusinessLogService.findPage(new Page<CInsBusinessLog>(request, response), cInsBusinessLog); 
		model.addAttribute("page", page);
		return "modules/log/cInsBusinessLogList";
	}

	/**
	 * 查看，增加，编辑业务日志表单页面
	 */
	@RequiresPermissions(value={"log:cInsBusinessLog:view","log:cInsBusinessLog:add","log:cInsBusinessLog:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(CInsBusinessLog cInsBusinessLog, Model model) {
		model.addAttribute("cInsBusinessLog", cInsBusinessLog);
		return "modules/log/cInsBusinessLogForm";
	}

	/**
	 * 保存业务日志
	 */
	@RequiresPermissions(value={"log:cInsBusinessLog:add","log:cInsBusinessLog:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(CInsBusinessLog cInsBusinessLog, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, cInsBusinessLog)){
			return form(cInsBusinessLog, model);
		}
		if(!cInsBusinessLog.getIsNewRecord()){//编辑表单保存
			CInsBusinessLog t = cInsBusinessLogService.get(cInsBusinessLog.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(cInsBusinessLog, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			cInsBusinessLogService.save(t);//保存
		}else{//新增表单保存
			cInsBusinessLogService.save(cInsBusinessLog);//保存
		}
		addMessage(redirectAttributes, "保存业务日志成功");
		return "redirect:"+Global.getAdminPath()+"/log/cInsBusinessLog/?repage";
	}
	
	/**
	 * 删除业务日志
	 */
	@RequiresPermissions("log:cInsBusinessLog:del")
	@RequestMapping(value = "delete")
	public String delete(CInsBusinessLog cInsBusinessLog, RedirectAttributes redirectAttributes) {
		cInsBusinessLogService.delete(cInsBusinessLog);
		addMessage(redirectAttributes, "删除业务日志成功");
		return "redirect:"+Global.getAdminPath()+"/log/cInsBusinessLog/?repage";
	}
	
	/**
	 * 批量删除业务日志
	 */
	@RequiresPermissions("log:cInsBusinessLog:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			cInsBusinessLogService.delete(cInsBusinessLogService.get(id));
		}
		addMessage(redirectAttributes, "删除业务日志成功");
		return "redirect:"+Global.getAdminPath()+"/log/cInsBusinessLog/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("log:cInsBusinessLog:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(CInsBusinessLog cInsBusinessLog, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "业务日志"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<CInsBusinessLog> page = cInsBusinessLogService.findPage(new Page<CInsBusinessLog>(request, response, -1), cInsBusinessLog);
    		new ExportExcel("业务日志", CInsBusinessLog.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出业务日志记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/log/cInsBusinessLog/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("log:cInsBusinessLog:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<CInsBusinessLog> list = ei.getDataList(CInsBusinessLog.class);
			for (CInsBusinessLog cInsBusinessLog : list){
				try{
					cInsBusinessLogService.save(cInsBusinessLog);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条业务日志记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条业务日志记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入业务日志失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/log/cInsBusinessLog/?repage";
    }
	
	/**
	 * 下载导入业务日志数据模板
	 */
	@RequiresPermissions("log:cInsBusinessLog:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "业务日志数据导入模板.xlsx";
    		List<CInsBusinessLog> list = Lists.newArrayList(); 
    		new ExportExcel("业务日志数据", CInsBusinessLog.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/log/cInsBusinessLog/?repage";
    }


	/**
	 * 选择对象ID（该对象所在表的ID）
	 */
	@RequestMapping(value = "selectByXmjbxxId")
	public String selectByXmjbxxId(@ModelAttribute("xmjbxxLogVo") CInsBusinessXmjbxxLogVo xmjbxxLogVo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CInsBusinessXmjbxxLogVo> page = cInsBusinessLogService.findPageByXmjbxxId(new Page<CInsBusinessXmjbxxLogVo>(request, response),  xmjbxxLogVo);
		model.addAttribute("page", page);
		return "modules/sys/gridselect";
	}

	/**
	 * 项目编报履历
	 */
	@RequestMapping(value = "xmjbxxBusinessLogList")
	public String findXmjbxxBusinessLogPage(@ModelAttribute("id") String id, String tab, HttpServletRequest request, HttpServletResponse response, Model model) {
		CInsBusinessLog parameter = new CInsBusinessLog();
		parameter.setObjectId(id);
		parameter.setType(CInsBusinessLog.TYPE_CBBB);
		List<CInsBusinessLog> cbbbList = cInsBusinessLogService.findXmjbxxBusinessLogList(parameter);
		model.addAttribute("cbbbList", cbbbList);
		parameter.setType(CInsBusinessLog.TYPE_JHBB);
		List<CInsBusinessLog> jhbbList = cInsBusinessLogService.findXmjbxxBusinessLogList(parameter);
		model.addAttribute("jhbbList", jhbbList);
		parameter.setType(CInsBusinessLog.TYPE_ZB);
		List<CInsBusinessLog> zbList = cInsBusinessLogService.findXmjbxxBusinessLogList(parameter);
		model.addAttribute("zbList", zbList);
		parameter.setType(CInsBusinessLog.TYPE_XMJBXX_TASK);
		List<CInsBusinessLog> ddlv = cInsBusinessLogService.findXmjbxxBusinessLogList(parameter);
		model.addAttribute("ddList", zbList);
		model.addAttribute("tab", tab);
		return "modules/xmjbxx/sub/businessLogList";
	}


}