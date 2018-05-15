/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.dkxmxx.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import com.jeeplus.modules.dkxmxx.entity.Dkxmxx;
import com.jeeplus.modules.dkxmxx.service.DkxmxxService;
import com.jeeplus.modules.sys.entity.User;
import com.jeeplus.modules.sys.utils.UserUtils;
import com.jeeplus.modules.xmjbxx.entity.Xmjbxx;
import com.jeeplus.modules.xmjbxx.service.XmjbxxService;

/**
 * 打捆项目Controller
 * @author gyf
 * @version 2018-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/dkxmxx/dkxmxx")
public class DkxmxxController extends BaseController {

	@Autowired
	private DkxmxxService dkxmxxService;
	@Autowired
	private XmjbxxService xmjbxxService; 
	@ModelAttribute
	public Dkxmxx get(@RequestParam(required=false) String id) {
		Dkxmxx entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dkxmxxService.get(id);
		}
		if (entity == null){
			entity = new Dkxmxx();
		}
		return entity;
	}
	
	/**
	 * 打捆项目列表页面
	 */
	@RequiresPermissions("dkxmxx:dkxmxx:list")
	@RequestMapping(value = {"list", ""})
	public String list(Dkxmxx dkxmxx, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Dkxmxx> page = dkxmxxService.findPage(new Page<Dkxmxx>(request, response), dkxmxx); 
		model.addAttribute("page", page);
		return "modules/dkxmxx/dkxmxxList";
	}

	/**
	 * 查看，增加，编辑打捆项目表单页面
	 */
	@RequiresPermissions(value={"dkxmxx:dkxmxx:view","dkxmxx:dkxmxx:add","dkxmxx:dkxmxx:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Dkxmxx dkxmxx, Model model) {
		model.addAttribute("dkxmxx", dkxmxx);
		return "modules/dkxmxx/dkxmxxForm";
	}

	/**
	 * 保存打捆项目
	 */
	@RequiresPermissions(value={"dkxmxx:dkxmxx:add","dkxmxx:dkxmxx:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Dkxmxx dkxmxx, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, dkxmxx)){
			return form(dkxmxx, model);
		}
		if(!dkxmxx.getIsNewRecord()){//编辑表单保存
			Dkxmxx t = dkxmxxService.get(dkxmxx.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(dkxmxx, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			dkxmxxService.save(t);//保存
		}else{//新增表单保存
			dkxmxxService.save(dkxmxx);//保存
		}
		addMessage(redirectAttributes, "保存打捆项目成功");
		return "redirect:"+Global.getAdminPath()+"/dkxmxx/dkxmxx/?repage";
	}
	
	/**
	 * 删除打捆项目
	 */
	@RequiresPermissions("dkxmxx:dkxmxx:del")
	@RequestMapping(value = "delete")
	public String delete(Dkxmxx dkxmxx, RedirectAttributes redirectAttributes) {
		dkxmxxService.delete(dkxmxx);
		addMessage(redirectAttributes, "删除打捆项目成功");
		return "redirect:"+Global.getAdminPath()+"/dkxmxx/dkxmxx/?repage";
	}
	
	/**
	 * 批量删除打捆项目
	 */
	@RequiresPermissions("dkxmxx:dkxmxx:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			dkxmxxService.delete(dkxmxxService.get(id));
		}
		addMessage(redirectAttributes, "删除打捆项目成功");
		return "redirect:"+Global.getAdminPath()+"/dkxmxx/dkxmxx/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("dkxmxx:dkxmxx:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Dkxmxx dkxmxx, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "打捆项目"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Dkxmxx> page = dkxmxxService.findPage(new Page<Dkxmxx>(request, response, -1), dkxmxx);
    		new ExportExcel("打捆项目", Dkxmxx.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出打捆项目记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/dkxmxx/dkxmxx/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("dkxmxx:dkxmxx:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Dkxmxx> list = ei.getDataList(Dkxmxx.class);
			for (Dkxmxx dkxmxx : list){
				try{
					dkxmxxService.save(dkxmxx);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条打捆项目记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条打捆项目记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入打捆项目失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/dkxmxx/dkxmxx/?repage";
    }
	
	/**
	 * 下载导入打捆项目数据模板
	 */
	@RequiresPermissions("dkxmxx:dkxmxx:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "打捆项目数据导入模板.xlsx";
    		List<Dkxmxx> list = Lists.newArrayList(); 
    		new ExportExcel("打捆项目数据", Dkxmxx.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/dkxmxx/dkxmxx/?repage";
    }
	// 投资计划编报—编制区-打捆项目
		@RequestMapping("daKunXm")
		public void daKunXm(RedirectAttributes redirectAttributes,HttpServletRequest request, HttpServletResponse response){
			//User user = UserUtils.getUser();
			String ids=request.getParameter("ids");
			String dkxmmc=request.getParameter("dkxmmc");
			String dkxmjsnr=request.getParameter("dkxmjsnr");
			String ztz=request.getParameter("ztz");
			String[] idsArr = ids.split(",");
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			Double dkzje=0.0;
			PrintWriter out=null;
			try {
					out=response.getWriter();
					for(String ztzje:ztz.split(",")){
						dkzje=dkzje+Double.parseDouble(ztzje);
					}
					for (String id : idsArr) {
						Xmjbxx xmjbxx=xmjbxxService.get(id);
						Dkxmxx dkxmxx=new Dkxmxx();
						dkxmxx.setProject_id(id);
						dkxmxx.setDkxmmc(dkxmmc);
						dkxmxx.setDkxmjsnr(dkxmjsnr);
						dkxmxx.setDkxmh("DK-"+uuid);
						dkxmxx.setProject_name(xmjbxx.getXmmc());
						dkxmxx.setDkzje(dkzje.toString());
						dkxmxx.setProject_je(xmjbxx.getZtz());
						dkxmxxService.save(dkxmxx);
					}
					
					out.println("0");
			} catch (Exception e) {
				e.printStackTrace();
				out.println("1");
			}finally{
				out.close();
			}
		}
	
	

}