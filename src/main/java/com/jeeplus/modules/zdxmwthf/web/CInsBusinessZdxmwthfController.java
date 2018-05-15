/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.zdxmwthf.web;

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
import com.jeeplus.modules.zdxmwthf.service.CInsBusinessZdxmwthfService;

/**
 * 重点项目问题回复Controller
 * @author gl
 * @version 2017-06-06
 */
@Controller
@RequestMapping(value = "${adminPath}/zdxmwthf/wthf")
public class CInsBusinessZdxmwthfController extends BaseController {

	@Autowired
	private CInsBusinessZdxmwthfService cInsBusinessZdxmwthfService;
	
	@Autowired
	private CInsBusinessZdxmwtService cInsBusinessZdxmwtService;
	
	@ModelAttribute
	public CInsBusinessZdxmwthf get(@RequestParam(required=false) String id) {
		CInsBusinessZdxmwthf entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cInsBusinessZdxmwthfService.get(id);
		}
		if (entity == null){
			entity = new CInsBusinessZdxmwthf();
		}
		return entity;
	}
	
	/**
	 * 重点项目问题回复列表页面
	 */
	@RequiresPermissions("zdxmwthf:wthf:list")
	@RequestMapping(value = {"list", ""})
	public String list(CInsBusinessZdxmwt cInsBusinessZdxmwt, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<CInsBusinessZdxmwt> list=new ArrayList<CInsBusinessZdxmwt>();
		User user=UserUtils.getUser();
		if(user.getOffice()!=null&&user.getOffice().getArea()!=null){
		cInsBusinessZdxmwt.setDeptid(user.getOffice().getArea().getId());
		}else{
			cInsBusinessZdxmwt.setDeptid("");
		}
		Page<CInsBusinessZdxmwt> page = cInsBusinessZdxmwtService.findWtList(new Page<CInsBusinessZdxmwt>(request, response), cInsBusinessZdxmwt); 
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
		return "modules/zdxmwthf/wthfList";
	}

	/**
	 * 重点项目问题回复表单页面
	 */
	@RequiresPermissions(value={"zdxmwthf:wthf:view","zdxmwthf:wthf:add","zdxmwthf:wthf:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(CInsBusinessZdxmwthf cInsBusinessZdxmwthf, Model model) {
		CInsBusinessZdxmwthf wthf=cInsBusinessZdxmwthfService.get(cInsBusinessZdxmwthf.getId());
		CInsBusinessZdxmwt cInsBusinessZdxmw=cInsBusinessZdxmwtService.get(wthf.getWtid());
		if (cInsBusinessZdxmw!=null) {
			cInsBusinessZdxmw.setWttype(SwitchColumn.switchWttype(cInsBusinessZdxmw.getWttype()));
			cInsBusinessZdxmw.setStagetype(SwitchColumn.switchStagetype(cInsBusinessZdxmw.getStagetype()));
			cInsBusinessZdxmw.setWtlevel(SwitchColumn.switchWtlevel(cInsBusinessZdxmw.getWtlevel()));
		}
		wthf.setcInsBusinessZdxmwt(cInsBusinessZdxmw);
		model.addAttribute("cInsBusinessZdxmwthf", wthf);
		return "modules/zdxmwthf/wthfForm";
	}
	
	/**
	 * 重点项目问题查看表单页面
	 */
	@RequiresPermissions(value={"zdxmwthf:wthf:view","zdxmwthf:wthf:add","zdxmwthf:wthf:edit"},logical=Logical.OR)
	@RequestMapping(value = "view")
	public String view(CInsBusinessZdxmwt cInsBusinessZdxmwt, Model model) {
		CInsBusinessZdxmwt wt=cInsBusinessZdxmwtService.get(cInsBusinessZdxmwt.getId());
		if (wt!=null) {
			wt.setWttype(SwitchColumn.switchWttype(wt.getWttype()));
			wt.setStagetype(SwitchColumn.switchStagetype(wt.getStagetype()));
			wt.setWtlevel(SwitchColumn.switchWtlevel(wt.getWtlevel()));
		}
		model.addAttribute("cInsBusinessZdxmwt", wt);
		return "modules/zdxmwthf/wthfView";
	}
	
	/**
	 * 保存重点项目问题回复
	 */
	@RequiresPermissions(value={"zdxmwthf:wthf:add","zdxmwthf:wthf:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(CInsBusinessZdxmwthf cInsBusinessZdxmwthf, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, cInsBusinessZdxmwthf)){
			return form(cInsBusinessZdxmwthf, model);
		}
		if(!cInsBusinessZdxmwthf.getIsNewRecord()){//编辑表单保存
			User user=UserUtils.getUser();
			cInsBusinessZdxmwthf.setUserid(user.getId());
			cInsBusinessZdxmwthf.setHftime(new Date());
			cInsBusinessZdxmwthf.setSfhf("1");
			CInsBusinessZdxmwthf t = cInsBusinessZdxmwthfService.get(cInsBusinessZdxmwthf.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(cInsBusinessZdxmwthf, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			cInsBusinessZdxmwthfService.save(t);//保存
			//查找问题基本信息，更新状态为处理中“2”
			CInsBusinessZdxmwt cInsBusinessZdxmwt=cInsBusinessZdxmwtService.get(t.getWtid());
			cInsBusinessZdxmwt.setIsNewRecord(false);
			cInsBusinessZdxmwt.setStatus("2");
			cInsBusinessZdxmwtService.save(cInsBusinessZdxmwt);
		}else{//新增表单保存
			cInsBusinessZdxmwthfService.save(cInsBusinessZdxmwthf);//保存
		}
		addMessage(redirectAttributes, "重点项目问题回复成功");
		return "redirect:"+Global.getAdminPath()+"/zdxmwthf/wthf/?repage";
	}

}