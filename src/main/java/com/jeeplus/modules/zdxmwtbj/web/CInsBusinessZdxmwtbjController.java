/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.zdxmwtbj.web;

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
import com.jeeplus.modules.tools.utils.SwitchColumn;
import com.jeeplus.modules.zdxmwt.entity.CInsBusinessZdxmwt;
import com.jeeplus.modules.zdxmwtbj.service.CInsBusinessZdxmwtbjService;
import com.jeeplus.modules.zdxmwthf.entity.CInsBusinessZdxmwthf;
import com.jeeplus.modules.zdxmwtqk.service.CInsBusinessZdxmwtqkService;

/**
 * 重点项目已办结问题Controller
 * @author gl
 * @version 2017-06-09
 */
@Controller
@RequestMapping(value = "${adminPath}/zdxmwtbj/wtbj")
public class CInsBusinessZdxmwtbjController extends BaseController {

	@Autowired
	private CInsBusinessZdxmwtbjService cInsBusinessZdxmwtbjService;
	
	@Autowired
	private CInsBusinessZdxmwtqkService cInsBusinessZdxmwtqkService;
	
	@ModelAttribute
	public CInsBusinessZdxmwt get(@RequestParam(required=false) String id) {
		CInsBusinessZdxmwt entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cInsBusinessZdxmwtbjService.get(id);
		}
		if (entity == null){
			entity = new CInsBusinessZdxmwt();
		}
		return entity;
	}
	
	/**
	 * 重点项目已办结问题列表页面
	 */
	@RequiresPermissions("zdxmwtbj:wtbj:list")
	@RequestMapping(value = {"list", ""})
	public String list(CInsBusinessZdxmwt cInsBusinessZdxmwt, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CInsBusinessZdxmwt> page = cInsBusinessZdxmwtbjService.findPage(new Page<CInsBusinessZdxmwt>(request, response), cInsBusinessZdxmwt); 
		List<CInsBusinessZdxmwt> list=page.getList();
		if (list!=null) {
			for(int i=0;i<list.size();i++){
				list.get(i).setWttype(SwitchColumn.switchWttype(list.get(i).getWttype()));
				list.get(i).setStagetype(SwitchColumn.switchStagetype(list.get(i).getStagetype()));
				list.get(i).setWtlevel(SwitchColumn.switchWtlevel(list.get(i).getWtlevel()));
			}
			page.setList(list);
		}
		model.addAttribute("page", page);
		return "modules/zdxmwtbj/wtbjList";
	}

	/**
	 * 查看，增加，编辑重点项目已办结问题表单页面
	 */
	@RequiresPermissions(value={"zdxmwtbj:wtbj:view","zdxmwtbj:wtbj:add","zdxmwtbj:wtbj:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(CInsBusinessZdxmwt cInsBusinessZdxmwt, Model model) {
		List<CInsBusinessZdxmwthf> list=cInsBusinessZdxmwtqkService.findWthqkById(cInsBusinessZdxmwt.getId());
		model.addAttribute("cInsBusinessZdxmwthf", list);
		return "modules/zdxmwtbj/wtbjForm";
	}

	

}