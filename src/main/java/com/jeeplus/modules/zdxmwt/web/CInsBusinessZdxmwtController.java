/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.zdxmwt.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
 * 重点项目存在问题Controller
 * @author gl
 * @version 2017-06-06
 */
@Controller
@RequestMapping(value = "${adminPath}/zdxmwt/wt")
public class CInsBusinessZdxmwtController extends BaseController {

	@Autowired
	private CInsBusinessZdxmwtService cInsBusinessZdxmwtService;
	
	@Autowired
	private CInsBusinessZdxmwthfService cInsBusinessZdxmwthfService;
	
	@ModelAttribute
	public CInsBusinessZdxmwt get(@RequestParam(required=false) String id) {
		CInsBusinessZdxmwt entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cInsBusinessZdxmwtService.get(id);
		}
		if (entity == null){
			entity = new CInsBusinessZdxmwt();
		}
		return entity;
	}
	
	/**
	 * 重点项目问题列表页面
	 */
	@RequiresPermissions("zdxmwt:wt:list")
	@RequestMapping(value = {"list", ""})
	public String list(CInsBusinessZdxmwt cInsBusinessZdxmwt, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<CInsBusinessZdxmwt> list=new ArrayList<CInsBusinessZdxmwt>();
		Page<CInsBusinessZdxmwt> page = cInsBusinessZdxmwtService.findPage(new Page<CInsBusinessZdxmwt>(request, response), cInsBusinessZdxmwt); 
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
		return "modules/zdxmwt/wtList";
	}

	/**
	 * 分拣重点项目问题表单页面
	 */
	@RequiresPermissions(value={"zdxmwt:wt:view","zdxmwt:wt:add","zdxmwt:wt:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(CInsBusinessZdxmwt cInsBusinessZdxmwt, Model model) {
		List<Map<String,Object>> list=cInsBusinessZdxmwtService.findAreaList(cInsBusinessZdxmwt.getId());
		model.addAttribute("areas", list);
		return "modules/zdxmwt/wtForm";
	}
	/**
	 *查看重点项目问题表单页面
	 */
	@RequiresPermissions(value={"zdxmwt:wt:view","zdxmwt:wt:add","zdxmwt:wt:edit"},logical=Logical.OR)
	@RequestMapping(value = "view")
	public String view(CInsBusinessZdxmwt cInsBusinessZdxmwt, Model model) {
		CInsBusinessZdxmwt wt=cInsBusinessZdxmwtService.get(cInsBusinessZdxmwt.getId());
		if (wt!=null) {
			wt.setWttype(SwitchColumn.switchWttype(wt.getWttype()));
			wt.setStagetype(SwitchColumn.switchStagetype(wt.getStagetype()));
			wt.setWtlevel(SwitchColumn.switchWtlevel(wt.getWtlevel()));
		}
		model.addAttribute("cInsBusinessZdxmwt", wt);
		return "modules/zdxmwt/wtView";
	}

	/**
	 * 保存重点项目问题回复列表
	 */
	@RequiresPermissions(value={"zdxmwt:wt:add","zdxmwt:wt:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(CInsBusinessZdxmwthf cInsBusinessZdxmwthf, Model model, RedirectAttributes redirectAttributes) throws Exception{
		User user = UserUtils.getUser();
		//分拣问题插入回复列表
		String[] deptids=cInsBusinessZdxmwthf.getDeptid().split(",");
		String wtid=cInsBusinessZdxmwthf.getWtid().split(",")[0];
		cInsBusinessZdxmwthf.setSfhf("0");
		cInsBusinessZdxmwthf.setWtid(wtid);
		if(deptids.length!=0){
			for (int i = 0; i < deptids.length; i++) {
				cInsBusinessZdxmwthf.setDeptid(deptids[i]);
				cInsBusinessZdxmwthf.setIsNewRecord(true);
				cInsBusinessZdxmwthf.setId(StringUtils.remove(UUID.randomUUID().toString(), '-'));
				cInsBusinessZdxmwthfService.save(cInsBusinessZdxmwthf);
			}
		}
		//修改问题状态为已分发状态
		CInsBusinessZdxmwt cInsBusinessZdxmwt=cInsBusinessZdxmwtService.get(wtid);
		cInsBusinessZdxmwt.setIsNewRecord(false);
		cInsBusinessZdxmwt.setStatus("1");
		cInsBusinessZdxmwtService.save(cInsBusinessZdxmwt);
		addMessage(redirectAttributes, "分拣重点项目问题成功");
		return "redirect:"+Global.getAdminPath()+"/zdxmwt/wt/?repage";
	}

}