/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.modules.notice.entity.Notify;
import com.jeeplus.modules.notice.service.NotifyService;

/**
 * 通知通告Controller
 * @author jeeplus
 * @version 2014-05-16
 */
@Controller
@RequestMapping(value = "${adminPath}/notice/notify")
public class NotifyController extends BaseController {

	@Autowired
	private NotifyService notifyService;
	
	@ModelAttribute
	public Notify get(@RequestParam(required=false) String id) {
		Notify entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = notifyService.get(id);
		}
		if (entity == null){
			entity = new Notify();
		}
		return entity;
	}
	
	@RequiresPermissions("notice:notify:list")
	@RequestMapping(value = {"list", ""})
	public String list(Notify notify, HttpServletRequest request, HttpServletResponse response, Model model) {
//		noticeType==1 表示  公文管理 ； noticeType == 2 表示 通知督查
		String noticeType = request.getParameter("noticeType");
		notify.setNoticeType(noticeType);
		Page<Notify> page = notifyService.find(new Page<Notify>(request, response), notify);
		model.addAttribute("page", page);
		if("1".equals(noticeType)){
			return "modules/notice/NotifyList";
		}else {
			return "modules/notice/NotifySuperviseList";
		}
	}

	/**
	 * 查看，增加，编辑报告表单页面
	 */
	@RequiresPermissions(value={"notice:notify:view","notice:notify:add","notice:notify:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Notify notify, Model model,HttpServletRequest request) {
//		noticeType==1 表示  公文管理 ； noticeType == 2 表示 通知督查
		String noticeType = request.getParameter("noticeType");
		if (StringUtils.isNotBlank(notify.getId())){
			notify = notifyService.getRecordList(notify);
		}
		model.addAttribute("notify", notify);
		if("1".equals(noticeType)){
			return "modules/notice/NotifyForm";
		}else {
			return "modules/notice/NotifySuperviseForm";
		}
	}

	@RequiresPermissions(value={"notice:notify:add","notice:notify:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Notify notify, Model model, RedirectAttributes redirectAttributes,HttpServletRequest request) {
//		noticeType==1 表示  公文管理 ； noticeType == 2 表示 通知督查
		String noticeType = request.getParameter("noticeType");
		if (!beanValidator(model, notify)){
			return form(notify, model,request);
		}
		// 如果是修改，则状态为已发布，则不能再进行操作
		if (StringUtils.isNotBlank(notify.getId())){
			Notify e = notifyService.get(notify.getId());
			if ("1".equals(e.getStatus())){
				addMessage(redirectAttributes, "已发布，不能操作！");
				if("1".equals(noticeType)){
					return "redirect:" + adminPath + "/notice/notify/list?noticeType=1&repage";
				}else {
					return "redirect:" + adminPath + "/notice/notify/list?noticeType=2&repage";
				}
//				return "redirect:" + adminPath + "/notice/notify/?repage";
			}
		}
		notifyService.save(notify);
		addMessage(redirectAttributes, "保存'" + notify.getTitle() + "'成功");
		if("1".equals(noticeType)){
			return "redirect:" + adminPath + "/notice/notify/list?noticeType=1&repage";
		}else {
			return "redirect:" + adminPath + "/notice/notify/list?noticeType=2&repage";
		}
//		return "redirect:" + adminPath + "/notice/notify/?repage";
	}
	
	@RequiresPermissions("notice:notify:del")
	@RequestMapping(value = "delete")
	public String delete(Notify notify, RedirectAttributes redirectAttributes,HttpServletRequest request) {
//		noticeType==1 表示  公文管理 ； noticeType == 2 表示 通知督查
		String noticeType = request.getParameter("noticeType");
		notifyService.delete(notify);
		addMessage(redirectAttributes, "删除通知成功");
		if("1".equals(noticeType)){
			return "redirect:" + adminPath + "/notice/notify/list?noticeType=1&repage";
		}else {
			return "redirect:" + adminPath + "/notice/notify/list?noticeType=2&repage";
		}
//		return "redirect:" + adminPath + "/notice/notify/?repage";
	}
	
	@RequiresPermissions("notice:notify:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			notifyService.delete(notifyService.get(id));
		}
		addMessage(redirectAttributes, "删除通知成功");
		return "redirect:" + adminPath + "/notice/notify/?repage";
	}
	
	/**
	 * 我的通知列表
	 */
	@RequestMapping(value = "self")
	public String selfList(Notify notify, HttpServletRequest request, HttpServletResponse response, Model model) {
//		noticeType==1 表示  公文管理 ； noticeType == 2 表示 通知督查
		String noticeType = request.getParameter("noticeType");
		notify.setSelf(true);
		Page<Notify> page = notifyService.find(new Page<Notify>(request, response), notify); 
		model.addAttribute("page", page);
		if("1".equals(noticeType)){
			return "modules/notice/NotifyList";
		}else {
			return "modules/notice/NotifySuperviseList";
		}
//		return "modules/notice/NotifyList";
	}

	/**
	 * 我的通知列表-数据
	 */
	@RequiresPermissions("notice:notify:view")
	@RequestMapping(value = "selfData")
	@ResponseBody
	public Page<Notify> listData(Notify notify, HttpServletRequest request, HttpServletResponse response, Model model) {
		notify.setSelf(true);
		Page<Notify> page = notifyService.find(new Page<Notify>(request, response), notify);
		return page;
	}
	
	/**
	 * 查看我的通知,重定向在当前页面打开
	 */
	@RequestMapping(value = "view")
	public String view(Notify notify, Model model) {
		if (StringUtils.isNotBlank(notify.getId())){
			notifyService.updateReadFlag(notify);
			notify = notifyService.getRecordList(notify);
			model.addAttribute("notify", notify);
			return "modules/notice/NotifyForm";
		}
		return "redirect:" + adminPath + "/notice/notify/self?repage";
	}

	/**
	 * 查看我的通知-数据
	 */
	@RequestMapping(value = "viewData")
	@ResponseBody
	public Notify viewData(Notify notify, Model model) {
		if (StringUtils.isNotBlank(notify.getId())){
			notifyService.updateReadFlag(notify);
			return notify;
		}
		return null;
	}
	
	/**
	 * 查看我的通知-发送记录
	 */
	@RequestMapping(value = "viewRecordData")
	@ResponseBody
	public Notify viewRecordData(Notify notify, Model model) {
		if (StringUtils.isNotBlank(notify.getId())){
			notify = notifyService.getRecordList(notify);
			return notify;
		}
		return null;
	}
	
	/**
	 * 获取我的通知数目
	 */
	@RequestMapping(value = "self/count")
	@ResponseBody
	public String selfCount(Notify notify, Model model) {
		notify.setSelf(true);
		notify.setReadFlag("0");
		return String.valueOf(notifyService.findCount(notify));
	}
}