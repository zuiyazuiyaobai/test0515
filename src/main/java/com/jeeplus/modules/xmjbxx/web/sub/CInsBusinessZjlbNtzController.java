/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.web.sub;

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
import com.jeeplus.modules.xmjbxx.entity.sub.CInsBusinessZjlbNtz;
import com.jeeplus.modules.xmjbxx.service.sub.CInsBusinessZjlbNtzService;

/**
 * 资金需求Controller
 * @author yw
 * @version 2017-09-25
 */
@Controller
@RequestMapping(value = "${adminPath}/xmjbxx/sub/cInsBusinessZjlbNtz")
public class CInsBusinessZjlbNtzController extends BaseController {

	@Autowired
	private CInsBusinessZjlbNtzService cInsBusinessZjlbNtzService;
	
	@ModelAttribute
	public CInsBusinessZjlbNtz get(@RequestParam(required=false) String id) {
		CInsBusinessZjlbNtz entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cInsBusinessZjlbNtzService.get(id);
		}
		if (entity == null){
			entity = new CInsBusinessZjlbNtz();
		}
		return entity;
	}
	
	/**
	 * zjxq列表页面
	 */
	@RequiresPermissions("xmjbxx:sub:cInsBusinessZjlbNtz:list")
	@RequestMapping(value = {"list", ""})
	public String list(CInsBusinessZjlbNtz cInsBusinessZjlbNtz, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CInsBusinessZjlbNtz> page = cInsBusinessZjlbNtzService.findPage(new Page<CInsBusinessZjlbNtz>(request, response), cInsBusinessZjlbNtz); 
		model.addAttribute("page", page);
		return "modules/xmjbxx/sub/cInsBusinessZjlbNtzList";
	}

	/**
	 * 查看，增加，编辑zjxq表单页面
	 */
	@RequiresPermissions(value={"xmjbxx:sub:cInsBusinessZjlbNtz:view","xmjbxx:sub:cInsBusinessZjlbNtz:add","xmjbxx:sub:cInsBusinessZjlbNtz:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(CInsBusinessZjlbNtz cInsBusinessZjlbNtz, Model model) {
		model.addAttribute("cInsBusinessZjlbNtz", cInsBusinessZjlbNtz);
		return "modules/xmjbxx/sub/cInsBusinessZjlbNtzForm";
	}

	/**
	 * 保存zjxq
	 */
	@RequiresPermissions(value={"xmjbxx:sub:cInsBusinessZjlbNtz:add","xmjbxx:sub:cInsBusinessZjlbNtz:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(CInsBusinessZjlbNtz cInsBusinessZjlbNtz, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, cInsBusinessZjlbNtz)){
			return form(cInsBusinessZjlbNtz, model);
		}
		if(!cInsBusinessZjlbNtz.getIsNewRecord()){//编辑表单保存
			CInsBusinessZjlbNtz t = cInsBusinessZjlbNtzService.get(cInsBusinessZjlbNtz.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(cInsBusinessZjlbNtz, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			cInsBusinessZjlbNtzService.save(t);//保存
		}else{//新增表单保存
			cInsBusinessZjlbNtzService.save(cInsBusinessZjlbNtz);//保存
		}
		addMessage(redirectAttributes, "保存zjxq成功");
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/sub/cInsBusinessZjlbNtz/?repage";
	}
	
	/**
	 * 删除zjxq
	 */
	@RequiresPermissions("xmjbxx:sub:cInsBusinessZjlbNtz:del")
	@RequestMapping(value = "delete")
	public String delete(CInsBusinessZjlbNtz cInsBusinessZjlbNtz, RedirectAttributes redirectAttributes) {
		cInsBusinessZjlbNtzService.delete(cInsBusinessZjlbNtz);
		addMessage(redirectAttributes, "删除zjxq成功");
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/sub/cInsBusinessZjlbNtz/?repage";
	}
	
	/**
	 * 批量删除zjxq
	 */
	@RequiresPermissions("xmjbxx:sub:cInsBusinessZjlbNtz:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			cInsBusinessZjlbNtzService.delete(cInsBusinessZjlbNtzService.get(id));
		}
		addMessage(redirectAttributes, "删除zjxq成功");
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/sub/cInsBusinessZjlbNtz/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("xmjbxx:sub:cInsBusinessZjlbNtz:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(CInsBusinessZjlbNtz cInsBusinessZjlbNtz, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "zjxq"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<CInsBusinessZjlbNtz> page = cInsBusinessZjlbNtzService.findPage(new Page<CInsBusinessZjlbNtz>(request, response, -1), cInsBusinessZjlbNtz);
    		new ExportExcel("zjxq", CInsBusinessZjlbNtz.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出zjxq记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/sub/cInsBusinessZjlbNtz/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("xmjbxx:sub:cInsBusinessZjlbNtz:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<CInsBusinessZjlbNtz> list = ei.getDataList(CInsBusinessZjlbNtz.class);
			for (CInsBusinessZjlbNtz cInsBusinessZjlbNtz : list){
				try{
					cInsBusinessZjlbNtzService.save(cInsBusinessZjlbNtz);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条zjxq记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条zjxq记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入zjxq失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/sub/cInsBusinessZjlbNtz/?repage";
    }
	
	/**
	 * 下载导入zjxq数据模板
	 */
	@RequiresPermissions("xmjbxx:sub:cInsBusinessZjlbNtz:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "zjxq数据导入模板.xlsx";
    		List<CInsBusinessZjlbNtz> list = Lists.newArrayList(); 
    		new ExportExcel("zjxq数据", CInsBusinessZjlbNtz.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/xmjbxx/sub/cInsBusinessZjlbNtz/?repage";
    }
	
	
	

}