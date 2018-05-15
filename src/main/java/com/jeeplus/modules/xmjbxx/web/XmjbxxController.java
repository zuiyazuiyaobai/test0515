/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.web;

import com.google.common.collect.Lists;

import com.jeeplus.common.config.Global;
import com.jeeplus.common.config.GlobalParameter;
import com.jeeplus.common.json.AjaxJson;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.servlet.FtpUtilNew;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.modules.dkxmxx.entity.Dkxmxx;
import com.jeeplus.modules.sys.entity.Office;
import com.jeeplus.modules.sys.entity.User;
import com.jeeplus.modules.sys.service.OfficeService;
import com.jeeplus.modules.sys.utils.UserUtils;
import com.jeeplus.modules.task.entity.CInsBusinessSchedulerTask;
import com.jeeplus.modules.task.entity.CInsBusinessXmjbxxTaskRelation;
import com.jeeplus.modules.task.entity.FeedBackXx;
import com.jeeplus.modules.task.service.CInsBusinessSchedulerTaskService;
import com.jeeplus.modules.task.service.CInsBusinessXmjbxxTaskRelationService;
import com.jeeplus.modules.task.vo.SchedulerTaskSearchParameter;
import com.jeeplus.modules.task.vo.XmjbxxTaskRelationSearchParameter;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessQqgz;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessSsqk;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessTzqk;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessZdxmk;
import com.jeeplus.modules.xmjbxx.entity.Xmjbxx;
import com.jeeplus.modules.xmjbxx.service.CInsBusinessSsqkService;
import com.jeeplus.modules.xmjbxx.service.CInsBusinessTzqkService;
import com.jeeplus.modules.xmjbxx.service.CInsBusinessZdxmkService;
import com.jeeplus.modules.xmjbxx.service.CompanyJbxxService;
import com.jeeplus.modules.xmjbxx.service.CompanyYljlService;
import com.jeeplus.modules.xmjbxx.service.sub.CInsBusinessXmjbxxDeptRelationService;
import com.jeeplus.modules.xmjbxx.entity.sub.CInsBusinessXmjbxxDeptRelation;
import com.jeeplus.modules.xmjbxx.service.CInsBusinessQqgzService;
import com.jeeplus.modules.xmjbxx.service.XmjbxxService;
import com.jeeplus.modules.xmjbxx.vo.CInsBusinessXmjbxxDeptRelationSearchParameter;
import com.jeeplus.modules.xmjbxx.vo.XmjbxxSearchParameter;

import net.sf.json.JSONObject;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
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
import javax.xml.namespace.QName;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 项目基本信息Controller
 *
 * @author yanwen
 * @version 2017-09-12
 */
@Controller
@RequestMapping(value = "${adminPath}/xmjbxx/xmjbxx")
public class XmjbxxController extends BaseController {

	@Autowired
	private XmjbxxService xmjbxxService; 
	
	@Autowired
	private CompanyJbxxService companyJbxxService;
	
	@Autowired
	private CompanyYljlService companyYljlService;
	
	@Autowired
	private OfficeService officeService;

	@Autowired
	private CInsBusinessQqgzService cInsBusinessQqgzService;

	@Autowired
	private CInsBusinessSsqkService ssqkService;

	@Autowired
	private CInsBusinessTzqkService tzqkService;

	@Autowired
	private CInsBusinessXmjbxxDeptRelationService deptRelationService;

	@Autowired
	private CInsBusinessZdxmkService zdxmkService;
	
	@Autowired
	private CInsBusinessSchedulerTaskService cInsBusinessSchedulerTaskService;
	
	@Autowired
	private CInsBusinessXmjbxxTaskRelationService cInsBusinessXmjbxxTaskRelationService;
	
	@ModelAttribute
	public Xmjbxx get(@RequestParam(required = false) String id) {
		Xmjbxx entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = xmjbxxService.get(id);
		}
		if (entity == null) {
			entity = new Xmjbxx();
		}
		return entity;
	}

	// 储备项目-报送区-报送
	@RequestMapping("cbxmBsqBs")
	public String cbxmBsqBs(String ids, RedirectAttributes redirectAttributes) {
		xmjbxxService.baoSong(ids);
		addMessage(redirectAttributes, "项目报送成功！");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/?repage";
	}

	// 储备项目-审核区-入本级库
	@RequestMapping("cbxmShqRbjk")
	public String cbxmShqRbjk(String ids, RedirectAttributes redirectAttributes) {
		xmjbxxService.rbjk(ids);
		addMessage(redirectAttributes, "项目入本级库成功！");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/cbxmShqList?repage";
	}

	// 储备项目-审核区-退回到-报送区
	@RequestMapping("cbxmShqThBsq")
	public String cbxmShqThBsq(String ids) {
		xmjbxxService.xmth(ids);
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/cbxmShqList?repage";
	}

	// 储备项目-审核区-删除
	@RequestMapping("cbxmShqDelete")
	public String cbxmShqDelete(RedirectAttributes redirectAttributes, String ids) {
		xmjbxxService.cbxmShqDelete(ids);
		addMessage(redirectAttributes, "删除成功！");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/cbxmShqList?repage";
	}

	// 储备项目-储备库-退回到-审核区
	@RequestMapping("cbxmCbkThShq")
	public String cbxmCbkThShq(String ids) {
		xmjbxxService.xmth(ids);
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/cbxmCbkList?repage";
	}

	// 储备项目-储备库-撤销储备
	@RequestMapping("cbxmCbkQxcb")
	public String cbxmCbkQxcb(String ids, RedirectAttributes redirectAttributes) {
		//判断是否在编制中
		if(xmjbxxService.qxcbCheck(ids)){
			xmjbxxService.qxcb(ids);
			addMessage(redirectAttributes, "项目取消储备成功！");
		}else{
			addMessage(redirectAttributes, "所选项目在编制中，不能取消储备！可以现在编制区中退回储备库后，再试！");
		}
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/cbxmCbkList?repage";
	}
	
	// 项目预警-预警信息发送
	    @RequiresPermissions("xmjbxx:xmjbxx:xmyjFsxx")
		@RequestMapping("xmyjFsxx")
		public String xmyjFsxx(String ids, RedirectAttributes redirectAttributes) {
			xmjbxxService.fsyjxx(ids);
			addMessage(redirectAttributes, "发送短信成功！");
			return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/allList?repage";
		}
	 // 未填报区-项目预警-预警信息发送
	@RequestMapping("xmyjFsxxOne")
	public void xmyjFsxxOne(String ids, RedirectAttributes redirectAttributes, HttpServletResponse response) {
    	PrintWriter out=null;
		try {
			out=response.getWriter();
			xmjbxxService.fsyjxx(ids);
			addMessage(redirectAttributes, "发送短信成功！");
			out.println("0");
		} catch (Exception e) {
			out.println("1");
			e.printStackTrace();
		}
	}

	// 储备项目-储备库-使用滚动计划同步储备项目
	@RequestMapping("cbxmCbkTbcbxm")
	public String cbxmCbkTbcbxm(String ids) {
		xmjbxxService.nrsngdjh(ids,"1","1");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/cbxmCbkList?repage";
	}

	// 储备项目-储备库-推送至投资计划编制区
	@RequestMapping("tsztzjhbzq")
	@ResponseBody
	public String tsztzjhbzq(String ids) {
		//xmjbxxService.addToBzq(ids);
		System.out.println("redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/cbxmCbkList?repage");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/cbxmCbkList?repage";
	}
	// 储备项目-储备库-删除
	/*@RequestMapping("cbxmCbkDelete")
	public String cbxmCbkDelete(String ids) {
		xmjbxxService.cbxmCbkDelete(ids);
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/cbxmCbkList?repage";
	}*/

	// 储备项目-储备库-使用滚动计划同步储备项目
	@RequestMapping("zhuanban")
	public String zhuanban(HttpServletRequest request, String ids, String officeId) {
		String toPage = request.getParameter("To");
		xmjbxxService.zhuanban(ids, officeId);
		System.out.println("/xmjbxx/xmjbxx/" + toPage + "?repage");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/" + toPage + "?repage";
	}

	// 三年滚动计划-使用滚动计划同步储备项目
	@RequestMapping("sngdjhTbcbxm")
	public String sngdjhTbcbxm(String ids) {
		xmjbxxService.sngdjhToCbk(ids);
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/bjjhSngdjhList?repage";
	}

	// 三年滚动计划-推送至年度计划编报区
	@RequestMapping("sngdjhTszndjhbbq")
	public String sngdjhTszndjhbbq(String ids) {
		xmjbxxService.selectToNdjhbs(ids);
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/bjjhSngdjhList?repage";
	}
	
	// 投资计划编报—编制区-退回储备库
		@RequestMapping("sngdjhThdbq2")
		public void sngdjhThdbq2(String ids,Model model, HttpServletResponse response) {
			String[] idsArr = ids.split(",");
			for (String id : idsArr) {
				Xmjbxx xmjbxx = get(id);
				Office name  = xmjbxx.getShbm();
				//xmjbxx.getZrwxzh();
				String struser = String.valueOf(name);
				String sbbm = xmjbxxService.getSbbmByXmjbxx(id);
				PrintWriter out=null;
				try {
					out=response.getWriter();
					if(struser.equals(sbbm)){
						out.println("1");	
					}else{
						out.println("2");	
					}
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					out.close();
				}
				
			}
			
		}
	// 投资计划编报—编制区-退回储备库
	@RequestMapping("sngdjhThdbq")
	public String sngdjhThdbq(String ids) {
				xmjbxxService.sngdjhThdbq(ids);
				return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/tzjhBzqList?repage";
	}

	// 三年滚动计划-转办
	@RequestMapping("sngdjhZb")
	public String sngdjhZb(String ids, String officeId) {
		xmjbxxService.sngdjhZb(ids, officeId);
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/bjjhSngdjhList?repage";
	}

	// 三年滚动计划-撤回
	@RequestMapping("sngdjhCh")
	public String sngdjhCh(String ids, String chyy) {
		xmjbxxService.sngdjhCh(ids, chyy);
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/bjjhSngdjhList?repage";
	}

	// 储备项目-储备库-项目加锁
	@RequestMapping("sngdjhJiasuo")
	public String sngdjhJiasuo(RedirectAttributes redirectAttributes, String ids) {
		xmjbxxService.jiaSuo(ids);
		addMessage(redirectAttributes, "项目加锁成功");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/bjjhSngdjhList?repage";
	}

	// 储备项目-审核区-项目解锁
	@RequestMapping("sngdjhJiesuo")
	public String sngdjhJiesuo(RedirectAttributes redirectAttributes, String ids) {
		xmjbxxService.jieSuo(ids);
		addMessage(redirectAttributes, "项目解锁成功");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/bjjhSngdjhList?repage";
	}

	// 投资计划-编制区-退回下级单位
	@RequestMapping("tzjhShqThxjdw")
	public String tzjhShqThxjdw(RedirectAttributes redirectAttributes, String ids) {
		addMessage(redirectAttributes, "退回下级单位成功！");
		try {
			xmjbxxService.tzjhShqThxjdw(ids);
		} catch (RuntimeException e) {
			e.printStackTrace();
			addMessage(redirectAttributes, "退回下级单位失败！原因：" + e.getMessage());
		}
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/tzjhShqList?repage";
	}

	// 投资计划-编制区-筛选储备库项目
	@RequiresPermissions("xmjbxx:xmjbxx:tzjhBzqList_txxm")
	@RequestMapping("tzjhBzqForm")
	public String tzjhBzqForm(HttpServletRequest request, HttpServletResponse response, Model model,
								   @ModelAttribute("deptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter deptRelationSearchParameter) {
		System.out.println(UserUtils.getUserGrade());
		model.addAttribute("yhcj", UserUtils.getUserGrade());
		deptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());
		deptRelationSearchParameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
		deptRelationSearchParameter.setZt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_TXW_NDJHBS);
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullPageByParameter(
				new Page<CInsBusinessXmjbxxDeptRelation>(request, response),deptRelationSearchParameter);
		model.addAttribute("page", page);
		model.addAttribute("saveUrl", "/xmjbxx/xmjbxx/tzjhBzqBzq");//挑选三年滚动计划后提交的地址
		model.addAttribute("searchUrl", "/xmjbxx/xmjbxx/tzjhBzqForm");//列表搜索地址
		return "modules/xmjbxx/gdjh/txSngdjhForm";
	}

	// 年度专项建设基金项目-编制区-推送到报送区
	@RequestMapping("zxjsjjxmBzqDelete")
	public String zxjsjjxmBzqDelete(RedirectAttributes redirectAttributes, String ids) {
		xmjbxxService.zxjsjjxmBzqDelete(ids);
		addMessage(redirectAttributes, "删除成功！");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/zxjsjjxmBzqList?repage";
	}

	// 年度专项建设基金项目-编制区-推送到报送区
	@RequestMapping("ndjhbsBzqDelete")
	public String ndjhbsBzqDelete(RedirectAttributes redirectAttributes, String ids) {
		xmjbxxService.ndjhbsBzqDelete(ids);
		addMessage(redirectAttributes, "删除成功！");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/ndjhBzqList?repage";
	}

	// 年度专项建设基金项目-报送区-变更文号
	@RequestMapping("zxjsjjxmBgwh")
	public String zxjsjjxmBgwh(RedirectAttributes redirectAttributes, String id, String bswh, String wjbt) {
		xmjbxxService.zxjsjjxmBgwh(id, bswh);
		addMessage(redirectAttributes, "变更文号成功！");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/zxjsjjxmBsqList?repage";
	}

	// 年度计划报送-报送区-变更文号
	@RequestMapping("ndjhbsBgwh")
	public String ndjhbsBgwh(RedirectAttributes redirectAttributes, String id, String bswh, String wjbt) {
		xmjbxxService.zxjsjjxmBgwh(id, bswh);
		addMessage(redirectAttributes, "变更文号成功！");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/ndjhBsqList?repage";
	}

	// 年度专项建设基金项目-编制区-推送到报送区
	@RequestMapping("pushToZxjsjjBsq")
	public String pushToZxjsjjBsq(HttpServletRequest request, HttpServletResponse response, String id, String wjbt, Model model) {
		xmjbxxService.pushToZxjsjjBsq(id, wjbt);
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/zxjsjjxmBzqList?repage";
	}

	// 年度计划报送-编制区-推送到报送区
	@RequestMapping("pushToNdjhBsq")
	public String pushToNdjhBsq(HttpServletRequest request, HttpServletResponse response, String id, String wjbt, Model model) {
		if (StringUtils.isBlank(wjbt)) {
			throw new RuntimeException("文件标题为空！");
		}
		xmjbxxService.pushToNdjhBsq(id, wjbt);
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/ndjhBzqList?repage";
	}

	// 年度专项建设基金项目-报送区-退回
	@RequestMapping("ndzxjsjjBsqTh")
	public String ndzxjsjjBsqTh(HttpServletRequest request, HttpServletResponse response, String ids, Model model) {
		xmjbxxService.ndzxjsjjBsqTh(ids);
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/zxjsjjxmBsqList?repage";
	}

	// 年度专项建设基金项目-报送区-退回
	@RequestMapping("ndjhBsqTh")
	public String ndjhBsqTh(HttpServletRequest request, HttpServletResponse response, String ids, Model model) {
		xmjbxxService.ndjhBsqTh(ids);
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/ndjhBsqList?repage";
	}

	// 投资计划-编制区-筛选储备库项目-确定
	@RequiresPermissions("xmjbxx:xmjbxx:tzjhBzqList_qd")
	@RequestMapping("tzjhBzqBzq")
	@ResponseBody
	public AjaxJson sxcbkxm(String ids) {
		AjaxJson aj = new AjaxJson();
		aj.setMsg("挑选成功！");
		try {
			xmjbxxService.addToBzq(ids);
		} catch (Exception e) {
			e.printStackTrace();
			aj.setSuccess(false);
			aj.setMsg("挑选失败！");
		}
		return aj;
	}

	// 投资计划-编制区-筛选储备库项目-确定
	@RequestMapping("selectToNdjhbs")
	@ResponseBody
	public AjaxJson selectToNdjhbs(String ids) {
		AjaxJson aj = new AjaxJson();
		aj.setMsg("挑选成功！");
		try {
			xmjbxxService.selectToNdjhbs(ids);
		} catch (Exception e) {
			e.printStackTrace();
			aj.setSuccess(false);
			aj.setMsg("挑选失败！");
		}
		return aj;
	}

	// 投资计划-编制区-筛选储备库项目-确定
	@RequestMapping("selectToNdzxjsjj")
	@ResponseBody
	public AjaxJson selectToNdzxjsjj(String ids) {
		AjaxJson aj = new AjaxJson();
		aj.setMsg("挑选成功！");
		try {
			xmjbxxService.selectToNdzxjsjj(ids);
		} catch (Exception e) {
			e.printStackTrace();
			aj.setSuccess(false);
			aj.setMsg("挑选失败！");
		}
		return aj;
	}

	// 投资计划-编制区-报送
	@RequestMapping("tzjhBzqBs")
	public String tzjhBzqBs(String ids) {
		xmjbxxService.baoSong(ids);
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/tzjhBzqList?repage";
	}

	// 投资计划-审核区-入本级库
	@RequestMapping("tzjhShqTszdbq")
	public String tzjhShqTszdbq(RedirectAttributes redirectAttributes, String ids) {
		xmjbxxService.baoSong(ids);
		addMessage(redirectAttributes, "推送成功！");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/tzjhShqList?repage";
	}
	//判断报送类别
	public String getBslb(String bslb,CInsBusinessZdxmk cInsBusinessZdxmk){
		String resultStr="0";
		if(StringUtils.isNotBlank(bslb)){
			int inte=Integer.parseInt(bslb);
			switch (inte) {
			case 1:
				resultStr=cInsBusinessZdxmk.getSfszdold();
				break;
			case 2:
				resultStr=cInsBusinessZdxmk.getSfszdold();
				break;
			case 3:
				resultStr=cInsBusinessZdxmk.getSfsjjxm();
				break;
			case 4:
				resultStr=cInsBusinessZdxmk.getSfsjjxm();
				break;
			case 5:
				resultStr=cInsBusinessZdxmk.getSfsbsbib();
				break;
			case 6:
				resultStr="1";
				break;
			case 7:
				resultStr="1";
				break;
			case 8:
				resultStr="1";
				break;
			case 10:
				resultStr="1";
				break;
			case 11:
				resultStr="1";
				break;
			case 12:
				resultStr="1";
				break;
			case 13:
				resultStr="1";
				break;
			default:
				resultStr=cInsBusinessZdxmk.getSfsfwyzdxm();
				break;
			}
		}else{
			return resultStr;
		}
		return resultStr;
	}
	// 投资计划-编制区-上报
	@RequestMapping("tzjhDbqSb")
	public String tzjhDbqSb(RedirectAttributes redirectAttributes, String ids, String officeId, String bswh,String bslb) {
		System.out.println(ids+","+officeId+","+bswh+","+bslb);
		String tempFlag="0";
		String[] idsArr = ids.split(",");
		if (StringUtils.isNotBlank(ids)) {
			Office office = officeService.get(officeId);
			String[] idsArra = ids.split(",");
			for (String id : idsArra) {
				Xmjbxx xmjbxx = get(id);
				CInsBusinessZdxmk cInsBusinessZdxmk=new CInsBusinessZdxmk();
				cInsBusinessZdxmk.setXmjbxx(xmjbxx);
				List<CInsBusinessZdxmk> zdxmkList = zdxmkService.findList(cInsBusinessZdxmk);
				if (!zdxmkList.isEmpty()) {
					cInsBusinessZdxmk = zdxmkList.get(0);
				}
				tempFlag=getBslb(bslb, cInsBusinessZdxmk);
			}
		}
		if(tempFlag!=null&&tempFlag.equals("1")){
			xmjbxxService.shangBao(ids, officeId, bswh,bslb);
			addMessage(redirectAttributes, "上报成功！");
		}else{
			String str=getSbReturnStr(bslb);
			addMessage(redirectAttributes,str);
		}
//		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/tzjhDbqList?repage";
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/tzjhBzqList?repage";
	}
	public String getSbReturnStr(String bslb){
		String str="上报失败！上报类别跟项目基本信息中的上报类别不一致";
		if(bslb.equals("1")){
			str="项目信息中是否2017年省重点项目类别为否，不能上报2017年省重点项目，请修改完善后提交";
		}else if(bslb.equals("2")){
			str="项目信息中是否2018年省重点项目类别为否，不能上报2018年省重点项目，请修改完善后提交";
		}else if(bslb.equals("3")){
			str="项目信息中是否2017年省基建项目类别为否，不能上报2017年省基建项目，请修改完善后提交";
		}else if(bslb.equals("4")){
			str="项目信息中是否2018年省基建项目类别为否，不能上报2018年省基建项目，请修改完善后提交";
		}else if(bslb.equals("5")){	
			str="项目信息中是否5818项目类别为否，不能上报5818项目，请修改完善后提交";
		}else if(bslb.equals("9")){
			str="项目信息中是否省服务业重大项目类别为否，不能上报现代服务业重点项目，请修改完善后提交";
		}
		return str;
	}
	// 投资计划-待报区-退回
	@RequestMapping("tzjhDbqTh")
	public String tzjhDbqTh(RedirectAttributes redirectAttributes, String ids) {
		xmjbxxService.xmth(ids);

		//投资计划-审核区-退回自动解锁
		xmjbxxService.jieSuo(ids);
		addMessage(redirectAttributes, "退回成功！");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/tzjhDbqList?repage";
	}

	// 投资计划-待报区-纳为本级滚动计划
	@RequestMapping("tzjhDbqNwbjgdjh")
	public String tzjhDbqNwbjgdjh(RedirectAttributes redirectAttributes, String ids) {
		xmjbxxService.nrsngdjh(ids,"1","1");
		addMessage(redirectAttributes, "成功纳为本级滚动计划");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/tzjhDbqList?repage";
	}

	// 投资计划-审核-退回到编制区
	@RequestMapping("tzjhShqThBzq")
	public String tzjhShqThBzq(String ids) {
		xmjbxxService.xmth(ids);
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/tzjhShqList?repage";
	}

	// 储备项目-审核区-项目解锁
	@RequestMapping("cbxmShq_jiasuo")
	public String cbxmShq_jiaSuo(RedirectAttributes redirectAttributes, String ids) {
		xmjbxxService.jiaSuo(ids);
		addMessage(redirectAttributes, "项目加锁成功");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/cbxmShqList?repage";
	}

	// 储备项目-审核区-项目加锁
	@RequestMapping("cbxmShq_jiesuo")
	public String cbxmShq_jiesuo(RedirectAttributes redirectAttributes, String ids) {
		xmjbxxService.jieSuo(ids);
		addMessage(redirectAttributes, "项目解锁成功");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/cbxmCbkList?repage";
	}

	// 储备项目-储备库-项目加锁
	@RequestMapping("cbxmCbk_jiasuo")
	public String cbxmCbk_jiasuo(RedirectAttributes redirectAttributes, String ids) {
		xmjbxxService.jiaSuo(ids);
		addMessage(redirectAttributes, "项目加锁成功");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/cbxmCbkList?repage";
	}

	// 储备项目-储备库-项目解锁
	@RequestMapping("cbxmCbk_jiesuo")
	public String cbxmCbk_jieSuo(RedirectAttributes redirectAttributes, String ids) {
		xmjbxxService.jieSuo(ids);
		addMessage(redirectAttributes, "项目解锁成功");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/cbxmCbkList?repage";
	}

	// 投资项目-审核区-项目解锁
	@RequestMapping("tzjhShq_jiesuo")
	public String tzjhShq_jiesuo(RedirectAttributes redirectAttributes, String ids) {
		xmjbxxService.jieSuo(ids);
		addMessage(redirectAttributes, "项目解锁成功");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/tzjhShqList?repage";
	}

	// 投资项目-审核区-项目加锁
	@RequestMapping("tzjhShq_jiasuo")
	public String tzjhShq_jiasuo(RedirectAttributes redirectAttributes, String ids) {
		xmjbxxService.jiaSuo(ids);
		addMessage(redirectAttributes, "项目加锁成功");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/tzjhShqList?repage";
	}

	/************** 返回列表开始 ****************/
	/**
	 * 储备项目-审核区列表页面
	 */
	@RequestMapping("cbxmShqList")
	public String cbxmShqList(XmjbxxSearchParameter xmjbxxSearchParameter, HttpServletRequest request, HttpServletResponse response, Model model) {
		// 设置查询参数

        xmjbxxSearchParameter.setListParam(Xmjbxx.STAGE_XMCB, UserUtils.getUserGrade(), Xmjbxx.ZT_XMCB_SHQ);
        xmjbxxSearchParameter.setShbm(UserUtils.getUser().getOffice());

		Page<Xmjbxx> page = xmjbxxService.findFullPageByParameterjh(new Page<Xmjbxx>(request, response), xmjbxxSearchParameter);
		model.addAttribute("page", page);

		//转办 要显示的部门和不要显示的部门（或者其子节点）
		String extId = UserUtils.getUser().getOffice().getId();
		Office office = new Office();
		office.setGrade(UserUtils.getUserGrade());
		office.setType(Office.TYPE_DEPARTMENT);
		List<Office> offices = officeService.findListByParam(office);

		for (int i = offices.size() - 1; i >= 0; i--) {
			if (extId.equals(offices.get(i).getId())) {
				offices.remove(offices.get(i));
			}
		}
		if (offices.isEmpty()) {
			offices = Lists.newArrayList();
		}
		model.addAttribute("sameGradeOffice", offices);
		return "modules/xmjbxx/cbxmShqList";
	}

	/**
	 * 项目监控列表
	 */
	@RequiresPermissions("xmjbxx:xmjbxx:allList")
	@RequestMapping("allList")
	public String allList(Xmjbxx xmjbxx, HttpServletRequest request, HttpServletResponse response, Model model,
							  @ModelAttribute("xmjbxxSearchParameter") XmjbxxSearchParameter xmjbxxSearchParameter) {
		String bmid = UserUtils.getUser().getOffice().getId();
		xmjbxxSearchParameter.setBmid(bmid);
		Page<Xmjbxx> page = xmjbxxService.findFullPageByParameteryj(new Page<Xmjbxx>(request, response), xmjbxxSearchParameter);
		model.addAttribute("page", page);
		
	
		return "modules/xmjbxx/allList";
	}

	/**
	 * 投资计划-编制区 列表页面
	 */
	@RequestMapping("tzjhBzqList")
	public String tzjhBzqList(XmjbxxSearchParameter xmjbxxSearchParameter, HttpServletRequest request, HttpServletResponse response, Model model) {
		// 设置查询参数
		xmjbxxSearchParameter.setListParam(Xmjbxx.STAGE_JHBZ, UserUtils.getUserGrade(), Xmjbxx.ZT_TZJH_BZQ);
		xmjbxxSearchParameter.setShbm(UserUtils.getUser().getOffice());
		Page<Xmjbxx> page = xmjbxxService.findFullPageByParameterjh(new Page<Xmjbxx>(request, response), xmjbxxSearchParameter);
		model.addAttribute("page", page);
		String nextOffices ="";
		String nextOfficesName = "";
		String grade = UserUtils.getUserGrade();
		String pGrade = UserUtils.getUserParentGrade();
		if (Office.GRADE_SHIJI.equals(grade)) {
			if(!"8b40dc78017c4cbd856cf5ad0b01a1f0".equals(pGrade)){
				nextOffices = pGrade;
				nextOfficesName = UserUtils.getUserParentDeptName();
			}else{
				nextOffices = "a5c1ad14e61e4395ac05bc092ceab247";
			}
		}
		System.out.println("nextOffices:" + nextOffices);
		System.out.println("uParentDeptName:" + nextOfficesName);
		model.addAttribute("nextOffices", nextOffices);
		model.addAttribute("nextOfficesName", nextOfficesName);
		return "modules/xmjbxx/tzjhBzqList";
	}

	/**
	 * 投资计划-总编制库 列表页面
	 */
	@RequestMapping("tzjhZbzkList")
	public String tzjhZbzkList(XmjbxxSearchParameter xmjbxxSearchParameter, HttpServletRequest request, HttpServletResponse response, Model model) {
		// 设置查询参数
		xmjbxxSearchParameter.setListParam(Xmjbxx.STAGE_JHBZ, null, Xmjbxx.ZT_TZJH_BZQ);
		//System.out.println(UserUtils.getUser().getOffice());
		//xmjbxxSearchParameter.setShbm(UserUtils.getUser().getOffice());
		Page<Xmjbxx> page = xmjbxxService.findFullPageByParameterjh(new Page<Xmjbxx>(request, response), xmjbxxSearchParameter);
		model.addAttribute("page", page);
		String nextOffices ="";
		String nextOfficesName = "";
		String grade = UserUtils.getUserGrade();
		String pGrade = UserUtils.getUserParentGrade();
		if (Office.GRADE_SHIJI.equals(grade)) {
			if(!"8b40dc78017c4cbd856cf5ad0b01a1f0".equals(pGrade)){
				nextOffices = pGrade;
				nextOfficesName = UserUtils.getUserParentDeptName();
			}else{
				nextOffices = "a5c1ad14e61e4395ac05bc092ceab247";
			}
		}
		model.addAttribute("nextOffices", nextOffices);
		model.addAttribute("nextOfficesName", nextOfficesName);
		return "modules/xmjbxx/tzjhZbzkList";
	}

	/**
	 * 投资计划-审核区 列表页面
	 */
	@RequestMapping("tzjhShqList")
	public String tzjhShqList(XmjbxxSearchParameter xmjbxxSearchParameter, HttpServletRequest request, HttpServletResponse response, Model model) {
		// 设置查询参数
		xmjbxxSearchParameter.setListParam(Xmjbxx.STAGE_JHBZ, UserUtils.getUserGrade(), Xmjbxx.ZT_TZJH_SHQ);
		xmjbxxSearchParameter.setShbm(UserUtils.getUser().getOffice());
		Page<Xmjbxx> page = xmjbxxService.findFullPageByParameter(new Page<Xmjbxx>(request, response), xmjbxxSearchParameter);
		model.addAttribute("page", page);
		return "modules/xmjbxx/tzjhShqList";
	}

	/**
	 * 投资计划-待报区 列表页面
	 */
	@RequestMapping("tzjhDbqList")
	public String tzjhDbqList(XmjbxxSearchParameter xmjbxxSearchParameter, HttpServletRequest request, HttpServletResponse response, Model model) {
		// 设置查询参数
		xmjbxxSearchParameter.setListParam(Xmjbxx.STAGE_JHBZ, UserUtils.getUserGrade(), Xmjbxx.ZT_TZJH_DBQ);
		xmjbxxSearchParameter.setShbm(UserUtils.getUser().getOffice());
		Page<Xmjbxx> page = xmjbxxService.findFullPageByParameter(new Page<Xmjbxx>(request, response), xmjbxxSearchParameter);
		model.addAttribute("page", page);

		String nextOffices = "bfe2d57177aa4c4c8dd889cdeecab3dd,a5c1ad14e61e4395ac05bc092ceab247,8b40dc78017c4cbd856cf5ad0b01a1f0";
		/*String grade = UserUtils.getUserGrade();
		if (Office.GRADE_SHIJI.equals(grade)) {
			nextOffices = "bfe2d57177aa4c4c8dd889cdeecab3dd,a5c1ad14e61e4395ac05bc092ceab247";
		} else if (Office.GRADE_SHENGJICS.equals(grade)) {
			nextOffices = "a5c1ad14e61e4395ac05bc092ceab247";
		} else if (Office.GRADE_SHENGJIFGW.equals(grade)) {
			nextOffices = "43317348362b44e6bc26a80861564ddc";
		}*/
		model.addAttribute("nextOffices", nextOffices);
		return "modules/xmjbxx/tzjhDbqList";
	}

	/**
	 * 滚动计划-年度计划报送-年度计划下达接收 列表页面
	 */
	@RequestMapping("ndjhNdjhxdjsList")
	public String ndjhNdjhxdjsList(HttpServletRequest request, HttpServletResponse response, Model model,
							  @ModelAttribute("c_ins_business_scheduler_task") SchedulerTaskSearchParameter schedulerTaskSearchParameter) {
		// 设置查询参数
		schedulerTaskSearchParameter.setDept(UserUtils.getUser().getOffice());
		Page<CInsBusinessSchedulerTask> page = cInsBusinessSchedulerTaskService.findFullPageByParameter(new Page<CInsBusinessSchedulerTask>(request, response), schedulerTaskSearchParameter);
		model.addAttribute("page", page);
		return "modules/xmjbxx/gdjh/ndjhNdjhxdjsList";
	}	

	/**
	 * 投资计划-专项基金建设项目-投放库 列表页面
	 */
	@RequestMapping("zxjsjjxmTfkList")
	public String zxjsjjxmTfkList(Xmjbxx xmjbxx, HttpServletRequest request, HttpServletResponse response, Model model) {
		// 设置查询参数
		Page<Xmjbxx> page = new Page<Xmjbxx>();
		model.addAttribute("page", page);
		model.addAttribute("message", "待开发...");
		return "modules/xmjbxx/gdjh/zxjsjjxmTfkList";
	}
	/************** 返回列表 end ****************/

	/************** 请求 CInsBusinessXmjbxxDeptRelation 为主表 start ****************/
	/**
	 *  后面有添加类似的请求应添加到 CInsBusinessXmjbxxDeptRelationController
	 */

	// 年度专项建设基金项目-编制区-筛选三年滚动计划项目
	@RequestMapping("selectNdzxjsjjForm")
	public String selectNdzxjsjjForm(HttpServletRequest request, HttpServletResponse response, Model model,
									 @ModelAttribute("deptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter deptRelationSearchParameter) {
		deptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());
		deptRelationSearchParameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_SNGDJH);
		deptRelationSearchParameter.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_WTX);
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullPageByParameter(
				new Page<CInsBusinessXmjbxxDeptRelation>(request, response),deptRelationSearchParameter);
		model.addAttribute("page", page);
		model.addAttribute("searchUrl", "/xmjbxx/xmjbxx/selectNdzxjsjjForm");//列表搜索地址
		model.addAttribute("saveUrl", "/xmjbxx/xmjbxx/selectToNdzxjsjj");//挑选三年滚动计划后提交的地址
		return "modules/xmjbxx/gdjh/txSngdjhForm";
	}

	// 项目调度管理-调度任务管理-调度任务管理-新增调度任务-添加项目
	@RequestMapping("selectSchedulerTaskXmjbxxForm")
	public String selectSchedulerTaskXmjbxxForm(HttpServletRequest request, HttpServletResponse response, String taskId, Model model,
												@ModelAttribute("deptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter deptRelationSearchParameter) {
		deptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());
		deptRelationSearchParameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_SNGDJH);
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullPageByParameter(new Page<CInsBusinessXmjbxxDeptRelation>(request, response),deptRelationSearchParameter);

		// 传 HashMap 标志到页面，页面刷新的时候将原有的值传回来
		Map signMap = new HashMap<String, String>();
		// signMap.put("originType", originType);
		signMap.put("taskId", taskId);
		model.addAttribute("signMap", signMap);

		model.addAttribute("page", page);
		model.addAttribute("searchUrl", "/xmjbxx/xmjbxx/selectSchedulerTaskXmjbxxForm");//列表搜索地址
		model.addAttribute("saveUrl", "/task/schedulerTask/selectToSchedulerTask?taskId=" + taskId);//挑选三年滚动计划后提交的地址
		return "modules/xmjbxx/gdjh/txSngdjhForm";
	}

	/**
	 * 投资计划-已报送 列表页面
	 */
	@RequestMapping("tzjhYbsList")
	public String tzjhYbsList(HttpServletRequest request, HttpServletResponse response, Model model,
							  @ModelAttribute("deptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter deptRelationSearchParameter) {
		// 设置查询参数
		deptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());
		deptRelationSearchParameter.setZt(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
		deptRelationSearchParameter.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_WTX);
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullPageByParameter(new Page<CInsBusinessXmjbxxDeptRelation>(request, response),deptRelationSearchParameter);
		model.addAttribute("page", page);
		return "modules/xmjbxx/tzjhYbsList";
	}

	/**
	 * 投资计划-专项基金建设项目-编制区 列表页面
	 */
	@RequestMapping("zxjsjjxmBzqList")
	public String zxjsjjxmBzqList(HttpServletRequest request, HttpServletResponse response, Model model,
								  @ModelAttribute("deptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter deptRelationSearchParameter) {
		// 设置查询参数
		deptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());
		deptRelationSearchParameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_ZXJSJJ);
		deptRelationSearchParameter.setStatus(CInsBusinessXmjbxxDeptRelation.STATUS_ZXJSJJ_BZ);
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullPageByParameter(
				new Page<CInsBusinessXmjbxxDeptRelation>(request, response),deptRelationSearchParameter);
		model.addAttribute("page", page);
		return "modules/xmjbxx/gdjh/zxjsjjxmBzqList";
	}

	/**
	 * 储备项目-报送区 列表页面
	 */
	@RequiresPermissions("xmjbxx:xmjbxx:list")
	@RequestMapping(value = {"list", ""})
	public String list(@ModelAttribute("xmjbxxDeptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter xmjbxxDeptRelationSearchParameter, HttpServletRequest request, HttpServletResponse response, Model model) {
		// 设置查询参数
		xmjbxxDeptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());
		xmjbxxDeptRelationSearchParameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_TB);
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullPageByParameter(new Page<CInsBusinessXmjbxxDeptRelation>(request, response), xmjbxxDeptRelationSearchParameter);
		model.addAttribute("page", page);
		return "modules/xmjbxx/xmjbxxList";
	}

	/**
	 * 投资计划-专项基金建设项目-报送区 列表页面
	 */
	@RequestMapping("zxjsjjxmBsqList")
	public String zxjsjjxmBsqList(HttpServletRequest request, HttpServletResponse response, Model model,
								  @ModelAttribute("deptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter deptRelationSearchParameter) {
		// 设置查询参数
		deptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());
		deptRelationSearchParameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_ZXJSJJ);
		deptRelationSearchParameter.setStatus(CInsBusinessXmjbxxDeptRelation.STATUS_ZXJSJJ_BS);
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullPageByParameter(
				new Page<CInsBusinessXmjbxxDeptRelation>(request, response),deptRelationSearchParameter);
		model.addAttribute("page", page);
		return "modules/xmjbxx/gdjh/zxjsjjxmBsqList";
	}

	/**
	 * 滚动计划-年度计划报送-报送区 列表页面
	 */
	@RequestMapping("ndjhBsqList")
	public String ndjhBsqList(HttpServletRequest request, HttpServletResponse response, Model model,
							  @ModelAttribute("deptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter deptRelationSearchParameter) {
		// 设置查询参数
		deptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());
		deptRelationSearchParameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_NDJHBS);
		deptRelationSearchParameter.setStatus(CInsBusinessXmjbxxDeptRelation.STATUS_NDJHBS_BS);
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullPageByParameter(
				new Page<CInsBusinessXmjbxxDeptRelation>(request, response),deptRelationSearchParameter);
		model.addAttribute("page", page);
		return "modules/xmjbxx/gdjh/ndjhBsqList";
	}

	/**
	 * 滚动计划-年度计划报送-编制区 列表页面
	 */
	@RequestMapping("ndjhBzqList")
	public String ndjhBzqList(HttpServletRequest request, HttpServletResponse response, Model model,
							  @ModelAttribute("deptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter deptRelationSearchParameter) {
		// 设置查询参数
		deptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());
		deptRelationSearchParameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_NDJHBS);
		deptRelationSearchParameter.setStatus(CInsBusinessXmjbxxDeptRelation.STATUS_NDJHBS_BZ);
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullPageByParameter(
				new Page<CInsBusinessXmjbxxDeptRelation>(request, response),deptRelationSearchParameter);
		model.addAttribute("page", page);
		return "modules/xmjbxx/gdjh/ndjhBzqList";
	}

	// 年度计划报送-编制区-筛选三年滚动计划项目
	@RequestMapping("selectNdjhbsForm")
	public String selectNdjhbsForm(HttpServletRequest request, HttpServletResponse response, Model model,
								   @ModelAttribute("deptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter deptRelationSearchParameter) {
		deptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());
		deptRelationSearchParameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_SNGDJH);
		deptRelationSearchParameter.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_WTX);
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullPageByParameter(
				new Page<CInsBusinessXmjbxxDeptRelation>(request, response),deptRelationSearchParameter);
		model.addAttribute("page", page);
		model.addAttribute("saveUrl", "/xmjbxx/xmjbxx/selectToNdjhbs");//挑选三年滚动计划后提交的地址
		model.addAttribute("searchUrl", "/xmjbxx/xmjbxx/selectNdjhbsForm");//列表搜索地址
		return "modules/xmjbxx/gdjh/txSngdjhForm";
	}

	/**
	 * 滚动计划-本级计划管理-三年滚动计划 列表页面
	 */
	@RequestMapping("bjjhSngdjhList")
	public String bjjhSngdjhList(HttpServletRequest request, HttpServletResponse response, Model model,
								 @ModelAttribute("deptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter deptRelationSearchParameter) {
		// 设置查询参数
		deptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());
		deptRelationSearchParameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_SNGDJH);
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullPageByParameter(
				new Page<CInsBusinessXmjbxxDeptRelation>(request, response),deptRelationSearchParameter);
		model.addAttribute("page", page);
		return "modules/xmjbxx/gdjh/bjjhSngdjhList";
	}

	/**
	 * 储备项目-储备库列表页面
	 */
	@RequestMapping("cbxmCbkList")
	public String cbxmCbkList(HttpServletRequest request, HttpServletResponse response, Model model,
							  @ModelAttribute("deptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter deptRelationSearchParameter) {
		deptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());
		deptRelationSearchParameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullListByParametercbk(
				new Page<CInsBusinessXmjbxxDeptRelation>(request, response),deptRelationSearchParameter);
		model.addAttribute("page", page);
		return "modules/xmjbxx/cbxmCbkList";
	}
	/**
	 * 储备项目-总储备库
	 */
	@RequestMapping("cbxmZcbkList")
	public String cbxmZcbkList(HttpServletRequest request, HttpServletResponse response, Model model,
							  @ModelAttribute("deptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter deptRelationSearchParameter) {
		/*deptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());*/
		deptRelationSearchParameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullListByParametercbk(
				new Page<CInsBusinessXmjbxxDeptRelation>(request, response),deptRelationSearchParameter);
		model.addAttribute("page", page);
		return "modules/xmjbxx/cbxmZcbkList";
	}
	@RequestMapping(value="yuLan2")
	public String  yuLan2(HttpServletRequest request,HttpServletResponse response, Model model){
		String str=request.getParameter("filepath");
		return "modules/xmjbxx/include/yuLan";
	}
	@RequestMapping(value="yuLan")
	public void  yuLan(HttpServletRequest request,HttpServletResponse response, Model model){
		String fileId=request.getParameter("fileNo");
		String xmjbxx_id = request.getParameter("xmjbxx_id");
		CInsBusinessQqgz cInsBusinessQqgz=new CInsBusinessQqgz();
		cInsBusinessQqgz.setFileId(fileId);
		Xmjbxx xmjbxx=new Xmjbxx();
		xmjbxx.setId(xmjbxx_id);
		cInsBusinessQqgz.setXmjbxx(xmjbxx);
		CInsBusinessQqgz qqgz=cInsBusinessQqgzService.findCInsBusinessQqgz(cInsBusinessQqgz);
		//String filePath="E:\\FILEDOWNLOAD"+qqgz.getFilePath();
		String filePath=Global.getConfig("FILE_UPLOAD_PATH")+qqgz.getFilePath();
		File file=new File(filePath);
		try {
			if(file.exists()){
				response.getWriter().println(filePath);
			}else{
				/*String ftpIp = PropertiesUtil.getSystemProperty("ftp.ip").trim();
				int ftpPort = Integer.parseInt(PropertiesUtil.getSystemProperty("ftp.port").trim());
				String ftpUser = PropertiesUtil.getSystemProperty("ftp.user").trim();
				String ftpPwd = PropertiesUtil.getSystemProperty("ftp.password").trim();*/
				String ftpIp = Global.getConfig("ftp.ip").trim();
				int ftpPort = Integer.parseInt(Global.getConfig("ftp.port").trim());
				String ftpUser = Global.getConfig("ftp.user").trim();
				String ftpPwd = Global.getConfig("ftp.password").trim();
	        	FtpUtilNew ftp = new FtpUtilNew(ftpIp, ftpPort, ftpUser, ftpPwd);
				ftp.connectServer();
				ftp.downloadFile(qqgz.getFilePath(),file.getPath());
				ftp.closeServer();
				response.getWriter().println(file.getPath());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/************** 请求 CInsBusinessXmjbxxDeptRelation 为主表 end ****************/
	
	@RequestMapping(value = "ckQyxy")
	public String ckQyxy( Model model,HttpServletRequest request,Xmjbxx xmjbxx) {
		xmjbxx.setId(request.getParameter("id"));
		Xmjbxx xmjbxx2=xmjbxxService.get(xmjbxx);
		String incidtype=xmjbxx2.getIncidtype();
		String incid=xmjbxx2.getIncid();
		String qymc=xmjbxx2.getXmfrdw();
		List<Map<String,Object>> qyyljlList= new ArrayList<Map<String,Object>>();
			Map<String, Object> resultMap=companyJbxxService.getqyxyList(incidtype,incid,qymc);
			if(resultMap==null){
				model.addAttribute("qyxyList",null);//企业信用企业信息
				model.addAttribute("qyyljlList",null);//企业信用优良记录和负面记录
				model.addAttribute("qyxybg",null);//企业信用优良记录和负面记录
			}else{
				Map<String, Object> qyxyList=(Map<String, Object>)resultMap.get("companyJbxx");
				qyyljlList=(List<Map<String,Object>>)resultMap.get("companyYljls");
				model.addAttribute("qyxyList",qyxyList);//企业信用企业信息
				model.addAttribute("qyxybg",resultMap.get("qyxybg"));
				xmjbxx2.setHeimd(qyxyList.get("heimdsl").toString());
				xmjbxx2.setHongmd(qyxyList.get("hongmdsl").toString());
				xmjbxxService.save(xmjbxx2);
			}
		JSONObject json = new JSONObject();
		json.put("qyyljlList", qyyljlList);
		json.toString();
		System.out.println(json);
		model.addAttribute("qyyljlList",json);//企业信用优良记录和负面记录
		return "modules/xmjbxx/include/xmjbxxFormQyxy";
	}
	/**
	 * 查看，增加，编辑项目基本信息表单页面
	 */
	@RequiresPermissions(value = {"xmjbxx:xmjbxx:view", "xmjbxx:xmjbxx:add", "xmjbxx:xmjbxx:edit"}, logical = Logical.OR)
	@RequestMapping(value = "form")
	public String form(Xmjbxx xmjbxx, Model model,HttpServletRequest request) {
		try {
			System.out.println("======");
			/*String xyflag=request.getParameter("xyflag");
			if(xyflag!=null&&xyflag.equals("1")){
				model.addAttribute("xyflag", "1");
			}else{
				model.addAttribute("xyflag", "0");
			}*/
			model.addAttribute("xmjbxx", xmjbxx);
			CInsBusinessSsqk curSsqk = new CInsBusinessSsqk();
			CInsBusinessZdxmk cInsBusinessZdxmk = new CInsBusinessZdxmk();
			Xmjbxx xmjbxx2=null;
			if (xmjbxx.getId() != null) {
				// 前期工作
				CInsBusinessQqgz qqgz = new CInsBusinessQqgz();
				qqgz.setXmjbxx(xmjbxx);
				List<CInsBusinessQqgz> qqgzs = cInsBusinessQqgzService.findList(qqgz);
				model.addAttribute("qqgzs", qqgzs);
				// 投资情况
				List<CInsBusinessTzqk> tzqks = xmjbxxService.huixianTzqk(xmjbxx);
				System.out.println("======"+tzqks.size());
				model.addAttribute("tzqks", tzqks);
				
				//根据xmjbxxid获取实施情况 信息
				CInsBusinessSsqk  cinsbusinessssqk =null;
				cinsbusinessssqk =cInsBusinessSchedulerTaskService.getSsqkByXmjbxxid(xmjbxx.getId());
				List<Map<String,Object>> proList = new ArrayList<Map<String,Object>>();
				Map m=new HashMap();
				m.put("zyysntzljdwzj",cinsbusinessssqk.getZyysntzLjdwzj());
				m.put("qtzyczxjszjljdwzj",cinsbusinessssqk.getQtzyczxjszjLjdwzj());
				m.put("zysljsjjljdwzj",cinsbusinessssqk.getZysljsjjLjdwzj());
				m.put("nsbdgcjjljdwzj",cinsbusinessssqk.getNsbdgcjjLjdwzj());
				m.put("tljszxjjljdwzj",cinsbusinessssqk.getTljszxjjLjdwzj());
				m.put("mhfzjjljdwzj",cinsbusinessssqk.getMhfzjjLjdwzj());
				m.put("gjzdslgcjsjjljdwzj",cinsbusinessssqk.getGjzdslgcjsjjLjdwzj());
				m.put("dzxskymhqfcjjljdwzj",cinsbusinessssqk.getDzxskymhqfcjjLjdwzj());
				m.put("dzxskymhqfcjyjjljdwzj",cinsbusinessssqk.getDzxskymhqfcjyjjLjdwzj());
				m.put("glgkjszxjjljdwzj",cinsbusinessssqk.getGlgkjszxjjLjdwzj());
				m.put("shengjiysntzljdwzj",cinsbusinessssqk.getShengjiysntzLjdwzj());
				m.put("shijiysntzljdwzj",cinsbusinessssqk.getShijiysntzLjdwzj());
				m.put("xianjiysntzljdwzj",cinsbusinessssqk.getXianjiysntzLjdwzj());
				m.put("shengjiczzjljdwzj",cinsbusinessssqk.getShengjiczzjLjdwzj());
				m.put("shijiczzjljdwzj",cinsbusinessssqk.getShijiczzjLjdwzj());
				m.put("xianjiczzjljdwzj",cinsbusinessssqk.getXianjiczzjLjdwzj());
				m.put("dfzxjsjjljdwzj",cinsbusinessssqk.getDfzxjsjjLjdwzj());
				m.put("qyzytzljdwzj",cinsbusinessssqk.getQyzytzLjdwzj());
				m.put("yhdkljdwzj",cinsbusinessssqk.getYhdkLjdwzj());
				m.put("lywzljdwzj",cinsbusinessssqk.getLywzLjdwzj());
				m.put("zjqdddljdwzj",cinsbusinessssqk.getZjqdddLjdwzj());
				m.put("qtzjljdwzj",cinsbusinessssqk.getQtzjLjdwzj());
				
				m.put("zyysntz_jzbbgljwcjj",cinsbusinessssqk.getZyysntzjzbbgljwcjj());
				m.put("qtzyczxjszj_jzbbgljwcjj",cinsbusinessssqk.getQtzyczxjszjjzbbgljwcjj());
				m.put("zxzqmjjszj_jzbbgljwcjj",cinsbusinessssqk.getZxzqmjjszjjzbbgljwcjj());
				m.put("zyzxjszj_jzbbgljwcjj",cinsbusinessssqk.getZyzxjszjjzbbgljwcjj());
				m.put("zysljszj_jzbbgljwcjj",cinsbusinessssqk.getZysljszjjzbbgljwcjj());
				m.put("nsbdgczj_jzbbgljwcjj",cinsbusinessssqk.getNsbdgczjjzbbgljwcjj());
				m.put("tljszxzj_jzbbgljwcjj",cinsbusinessssqk.getTljszxzjjzbbgljwcjj());
				m.put("mhfzzj_jzbbgljwcjj",cinsbusinessssqk.getMhfzzjjzbbgljwcjj());
				m.put("gjzdslgcjszj_jzbbgljwcjj",cinsbusinessssqk.getGjzdslgcjszjjzbbgljwcjj());
				m.put("dzxskymhqfczj_jzbbgljwcjj",cinsbusinessssqk.getDzxskymhqfczjjzbbgljwcjj());
				m.put("dzxskymhqfcjyzj_jzbbgljwcjj",cinsbusinessssqk.getDzxskymhqfcjyzjjzbbgljwcjj());
				m.put("glgkjszj_jzbbgljwcjj",cinsbusinessssqk.getGlgkjszjjzbbgljwcjj());
				m.put("dfysntz_jzbbgljwcjj",cinsbusinessssqk.getDfysntzjzbbgljwcjj());
				m.put("sjysntz_jzbbgljwcjj",cinsbusinessssqk.getSjysntzjzbbgljwcjj());
				m.put("cityjysntz_jzbbgljwcjj",cinsbusinessssqk.getCityjysntzjzbbgljwcjj());
				m.put("xjysntz_jzbbgljwcjj",cinsbusinessssqk.getXjysntzjzbbgljwcjj());
				m.put("dfczxjszj_jzbbgljwcjj",cinsbusinessssqk.getDfczxjszjjzbbgljwcjj());
				m.put("sjczzj_jzbbgljwcjj",cinsbusinessssqk.getSjczzjjzbbgljwcjj());
				m.put("cityjczzj_jzbbgljwcjj",cinsbusinessssqk.getCityjczzjjzbbgljwcjj());
				m.put("xjczzj_jzbbgljwcjj",cinsbusinessssqk.getXjczzjjzbbgljwcjj());
				m.put("dfzxjszj_jzbbgljwcjj",cinsbusinessssqk.getDfzxjszjjzbbgljwcjj());
				m.put("qyzytz_jzbbgljwcjj",cinsbusinessssqk.getQyzytzjzbbgljwcjj());
				m.put("yhdk_jzbbgljwcjj",cinsbusinessssqk.getYhdkjzbbgljwcjj());
				m.put("lywz_jzbbgljwcjj",cinsbusinessssqk.getLywzjzbbgljwcjj());
				m.put("zjqddd_jzbbgljwcjj",cinsbusinessssqk.getZjqdddjzbbgljwcjj());
				m.put("qtzj_jzbbgljwcjj",cinsbusinessssqk.getQtzjjzbbgljwcjj());
				
				m.put("zyysntz_ljzfzj",cinsbusinessssqk.getZyysntzljzfzj());
				m.put("qtzyczxjszj_ljzfzj",cinsbusinessssqk.getQtzyczxjszjljzfzj());
				m.put("zxzqmjdzxjszj_ljzfzj",cinsbusinessssqk.getZxzqmjdzxjszjljzfzj());
				m.put("zysljsjj_ljzfzj",cinsbusinessssqk.getZysljsjjljzfzj());
				m.put("nsbdgcjj_ljzfzj",cinsbusinessssqk.getNsbdgcjjljzfzj());
				m.put("tljszxjj_ljzfzj",cinsbusinessssqk.getTljszxjjljzfzj());
				m.put("mhfzjj_ljzfzj",cinsbusinessssqk.getMhfzjjljzfzj());
				m.put("gjzdslgcjsjj_ljzfzj",cinsbusinessssqk.getGjzdslgcjsjjljzfzj());
				m.put("dzxskymhqfcjj_ljzfzj",cinsbusinessssqk.getDzxskymhqfcjjljzfzj());
				m.put("dzxskymhqfcjyjj_ljzfzj",cinsbusinessssqk.getDzxskymhqfcjyjjljzfzj());
				m.put("glgkjszxjj_ljzfzj",cinsbusinessssqk.getGlgkjszxjjljzfzj());
				m.put("shengjiysntz_ljzfzj",cinsbusinessssqk.getShengjiczzjljzfzj());
				m.put("shijiysntz_ljzfzj",cinsbusinessssqk.getShijiysntzljzfzj());
				m.put("xianjiysntz_ljzfzj",cinsbusinessssqk.getXianjiysntzljzfzj());
				m.put("shengjiczzj_ljzfzj",cinsbusinessssqk.getShengjiczzjljzfzj());
				m.put("shijiczzj_ljzfzj",cinsbusinessssqk.getShijiczzjljzfzj());
				m.put("xianjiczzj_ljzfzj",cinsbusinessssqk.getXianjiczzjljzfzj());
				m.put("dfzxjsjj_ljzfzj",cinsbusinessssqk.getDfzxjsjjljzfzj());
				m.put("qyzytz_ljzfzj",cinsbusinessssqk.getQyzytzljzfzj());
				m.put("yhdk_ljzfzj",cinsbusinessssqk.getYhdkljzfzj());
				m.put("lywz_ljzfzj",cinsbusinessssqk.getLywzljzfzj());
				m.put("zjqddd_ljzfzj",cinsbusinessssqk.getZjqdddljzfzj());
				m.put("qtzj_ljzfzj",cinsbusinessssqk.getQtzjljzfzj());
									
				m.put("zyysntz_ljdwzjtwo",cinsbusinessssqk.getZyysntzljdwzjtwo());
				m.put("qtzyczxjszj_ljdwzjtwo",cinsbusinessssqk.getQtzyczxjszjljdwzjtwo());
				m.put("zxzqmjdzxjszj_ljdwzjtwo",cinsbusinessssqk.getZxzqmjdzxjszjljdwzjtwo());
				m.put("zysljsjj_ljdwzjtwo",cinsbusinessssqk.getZysljsjjljdwzjtwo());
				m.put("nsbdgcjj_ljdwzjtwo",cinsbusinessssqk.getNsbdgcjjljdwzjtwo());
				m.put("tljszxjj_ljdwzjtwo",cinsbusinessssqk.getTljszxjjljdwzjtwo());
				m.put("mhfzjj_ljdwzjtwo",cinsbusinessssqk.getMhfzjjljdwzjtwo());
				m.put("gjzdslgcjsjj_ljdwzjtwo",cinsbusinessssqk.getGjzdslgcjsjjljdwzjtwo());
				m.put("dzxskymhqfcjj_ljdwzjtwo",cinsbusinessssqk.getDzxskymhqfcjjljdwzjtwo());
				m.put("dzxskymhqfcjyjj_ljdwzjtwo",cinsbusinessssqk.getDzxskymhqfcjyjjljdwzjtwo());
				m.put("glgkjszxjj_ljdwzjtwo",cinsbusinessssqk.getGlgkjszxjjljdwzjtwo());
				m.put("shengjiysntz_ljdwzjtwo",cinsbusinessssqk.getShengjiysntzljdwzjtwo());
				m.put("shijiysntz_ljdwzjtwo",cinsbusinessssqk.getShijiysntzljdwzjtwo());
				m.put("xianjiysntz_ljdwzjtwo",cinsbusinessssqk.getXianjiysntzljdwzjtwo());
				m.put("shengjiczzj_ljdwzjtwo",cinsbusinessssqk.getShengjiczzjljdwzjtwo());
				m.put("shijiczzj_ljdwzjtwo",cinsbusinessssqk.getShijiczzjljdwzjtwo());
				m.put("xianjiczzj_ljdwzjtwo",cinsbusinessssqk.getXianjiczzjljdwzjtwo());
				m.put("dfzxjsjj_ljdwzjtwo",cinsbusinessssqk.getDfzxjsjjljdwzjtwo());
				m.put("qyzytz_ljdwzjtwo",cinsbusinessssqk.getQyzytzljdwzjtwo());
				m.put("yhdk_ljdwzjtwo",cinsbusinessssqk.getYhdkljdwzjtwo());
				m.put("lywz_ljdwzjtwo",cinsbusinessssqk.getLywzljdwzjtwo());
				m.put("zjqddd_ljdwzjtwo",cinsbusinessssqk.getZjqdddljdwzjtwo());
				m.put("qtzj_ljdwzjtwo",cinsbusinessssqk.getQtzjljdwzjtwo());
				m.put("sfkg",cinsbusinessssqk.getSfkg());

				proList.add(m);
				model.addAttribute("proList", proList);		
				
				// 实施情况
				CInsBusinessSsqk ssqk = new CInsBusinessSsqk();
				ssqk.setXmjbxx(xmjbxx);
				ssqk.setType(CInsBusinessSsqk.TYPE_XMTB);
				List<CInsBusinessSsqk> ssqkList = ssqkService.findList(ssqk);
				if (!ssqkList.isEmpty()) {
					curSsqk = ssqkList.get(0);
				}
				
				//其他情况（省基建项目 5818项目 省重点项目）				
				cInsBusinessZdxmk.setXmjbxx(xmjbxx);
				List<CInsBusinessZdxmk> zdxmkList = zdxmkService.findList(cInsBusinessZdxmk);
				if (!zdxmkList.isEmpty()) {
					cInsBusinessZdxmk = zdxmkList.get(0);
				}
				//model.addAttribute("cInsBusinessZdxmk", cInsBusinessZdxmk);
				//获取健康养老项目信息
				xmjbxx2=xmjbxxService.get(xmjbxx);
				
				//企业信用

				String incidtype=xmjbxx2.getIncidtype();	

				/*Xmjbxx xmjbxx2=xmjbxxService.get(xmjbxx);
				String incidtype=xmjbxx2.getIncidtype();

				String incid=xmjbxx2.getIncid();
				String qymc=xmjbxx2.getXmfrdw();
				List<Map<String,Object>> qyyljlList= new ArrayList<Map<String,Object>>();
				Map<String, Object> resultMap=companyJbxxService.getqyxyList(incidtype,incid,qymc);
				System.out.println("tiaoshi===222==");
				if(resultMap==null){
					model.addAttribute("qyxyList",null);//企业信用企业信息
					model.addAttribute("qyyljlList",null);//企业信用优良记录和负面记录
					model.addAttribute("qyxybg",null);//企业信用优良记录和负面记录
				}else{
					Map<String, Object> qyxyList=(Map<String, Object>)resultMap.get("companyJbxx");
					qyyljlList=(List<Map<String,Object>>)resultMap.get("companyYljls");
					model.addAttribute("qyxyList",qyxyList);//企业信用企业信息
					model.addAttribute("qyxybg",resultMap.get("qyxybg"));
					xmjbxx2.setHeimd(qyxyList.get("heimdsl").toString());
					xmjbxx2.setHongmd(qyxyList.get("hongmdsl").toString());
					xmjbxxService.save(xmjbxx2);
				}
				JSONObject json = new JSONObject();
				json.put("qyyljlList", qyyljlList);
				json.toString();
				System.out.println(json);
				
				model.addAttribute("qyyljlList",json);//企业信用优良记录和负面记录
*/			}
			model.addAttribute("xmjbxx", xmjbxx2);
			model.addAttribute("cInsBusinessZdxmk", cInsBusinessZdxmk);
			model.addAttribute("curSsqk", curSsqk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "modules/xmjbxx/xmjbxxForm";
	}

	/**
	 * 保存项目基本信息(Ajax异步)
	 */
	@RequiresPermissions("xmjbxx:xmjbxx:add")
	@RequestMapping(value = "saveXmjbxx")
	@ResponseBody
	public AjaxJson saveXmjbxx(Xmjbxx xmjbxx, Model model) throws Exception {
		AjaxJson aj = new AjaxJson();
		if (!beanValidator(model, xmjbxx)) {
			aj.setSuccess(false);
			aj.setMsg("数据验证失败");
			return aj;
		}
        try {
            xmjbxxService.addXmjbxx(xmjbxx);
        } catch (Exception e) {
            e.printStackTrace();
            aj.setSuccess(false);
            aj.setMsg(e.getMessage());
            return aj;
        }
        aj.setMsg("保存项目基本信息成功");
		aj.put("id", xmjbxx.getId());
		return aj;
	}

	/**
	 * 保存项目投资情况(Ajax异步)
	 */
	@RequestMapping(value = "saveXmjbxxTzqk")
	@ResponseBody
	public AjaxJson saveXmjbxxTzqk(Xmjbxx xmjbxx) {
		AjaxJson aj = new AjaxJson();
		if (StringUtils.isBlank(xmjbxx.getId())) {
			aj.setSuccess(false);
			aj.setMsg("请先保存项目基本信息");
			return aj;
        } else if (!xmjbxxService.isEditable(xmjbxx.getId())) {
            aj.setSuccess(false);
            aj.setMsg(GlobalParameter.SZT_NOT_EDITABLE);
            return aj;
        }
        try {
			xmjbxxService.saveXmjbxxTzqk(xmjbxx);
		} catch (Exception e) {
			aj.setSuccess(false);
			aj.setMsg("保存出错！" + (e.getMessage() == null ? "" : e.getMessage()));
			return aj;
		}
		aj.setMsg("保存成功");
		return aj;
	}

	/**
	 * 保存前期工作(Ajax异步)
	 */
	@RequestMapping(value = "saveXmjbxxQqgz")
	@ResponseBody
	public AjaxJson saveXmjbxxQqgz(Xmjbxx xmjbxx) {
		AjaxJson aj = new AjaxJson();
		if (StringUtils.isBlank(xmjbxx.getId())) {
			aj.setSuccess(false);
			aj.setMsg("请先保存项目基本信息");
			return aj;
		} else if (!xmjbxxService.isEditable(xmjbxx.getId())) {
            aj.setSuccess(false);
            aj.setMsg(GlobalParameter.SZT_NOT_EDITABLE);
            return aj;
        }
		try {
			xmjbxxService.saveXmjbxxQqgz(xmjbxx);
		} catch (Exception e) {
			aj.setSuccess(false);
			aj.setMsg("保存出错！" + (e.getMessage() == null ? "" : e.getMessage()));
			return aj;
		}
		aj.setMsg("保存成功");
		return aj;
	}

	/**
	 * 保存前期工作(Ajax异步)
	 */
	@RequestMapping(value = "saveSfPPP")
	@ResponseBody
	public AjaxJson saveSfPPP(Xmjbxx xmjbxx) {
		AjaxJson aj = new AjaxJson();
		if (StringUtils.isBlank(xmjbxx.getId())) {
			aj.setSuccess(false);
			aj.setMsg("请先保存项目基本信息");
			return aj;
		} else if (!xmjbxxService.isEditable(xmjbxx.getId())) {
            aj.setSuccess(false);
            aj.setMsg(GlobalParameter.SZT_NOT_EDITABLE);
            return aj;
        }

		try {
			xmjbxxService.saveSfPPP(xmjbxx);
		} catch (Exception e) {
			aj.setSuccess(false);
			aj.setMsg("保存出错！" + (e.getMessage() == null ? "" : e.getMessage()));
			return aj;
		}

		aj.setMsg("保存成功");
		return aj;
	}

	/**
	 * 保存前期工作(Ajax异步)
	 */
	@RequestMapping(value = "saveXmjbxxQtxx")
	@ResponseBody
	public AjaxJson saveXmjbxxQtxx(Xmjbxx xmjbxx) {
		AjaxJson aj = new AjaxJson();
		if (StringUtils.isBlank(xmjbxx.getId())) {
			aj.setSuccess(false);
			aj.setMsg("请先保存项目基本信息");
			return aj;
		} else if (!xmjbxxService.isEditable(xmjbxx.getId())) {
            aj.setSuccess(false);
            aj.setMsg(GlobalParameter.SZT_NOT_EDITABLE);
            return aj;
        }

		try {
			xmjbxxService.saveXmjbxxQtxx(xmjbxx);
		} catch (Exception e) {
			aj.setSuccess(false);
			aj.setMsg("保存出错！" + (e.getMessage() == null ? "" : e.getMessage()));
			return aj;
		}

		aj.setMsg("保存成功");
		return aj;
	}

	/**
	 * 保存实施情况(Ajax异步)
	 */
	@RequestMapping(value = "saveXmjbxxSsqk")
	@ResponseBody
	public AjaxJson saveXmjbxxSsqk(CInsBusinessSsqk ssqk) {
		AjaxJson aj = new AjaxJson();
		if (StringUtils.isBlank(ssqk.getXmjbxx().getId())) {
			aj.setSuccess(false);
			aj.setMsg("请先保存项目基本信息");
			return aj;
		} else if (!xmjbxxService.isEditable(ssqk.getXmjbxx().getId())) {
            aj.setSuccess(false);
            aj.setMsg(GlobalParameter.SZT_NOT_EDITABLE);
            return aj;
        }
		try {
			ssqk.setDelflag("0");
			ssqk.setType("1");
			ssqkService.saveXmjbxxSsqk(ssqk);
		} catch (Exception e) {
			e.printStackTrace();
			aj.setSuccess(false);
			aj.setMsg("保存出错！" + (e.getMessage() == null ? "" : e.getMessage()));
			return aj;
		}
		aj.setMsg("保存成功");
		return aj;
	}

	/**
	 * 保存前期工作(Ajax异步)
	 */
	@RequestMapping(value = "saveXmjbxxDfzb")
	@ResponseBody
	public AjaxJson saveXmjbxxDfzb(Xmjbxx xmjbxx) {
		AjaxJson aj = new AjaxJson();
		if (StringUtils.isBlank(xmjbxx.getId())) {
			aj.setSuccess(false);
			aj.setMsg("请先保存项目基本信息");
			return aj;
		}
		try {
			xmjbxxService.saveXmjbxxDfzb(xmjbxx);
		} catch (Exception e) {
			aj.setSuccess(false);
			aj.setMsg("保存出错！" + (e.getMessage() == null ? "" : e.getMessage()));
			return aj;
		}
		aj.setMsg("保存成功");
		return aj;
	}
	
	
	/**
	 * 保存其他信息省基建5818重点项目(Ajax异步)
	 */
	@RequestMapping(value = "saveXmjbxxZdxmk")
	@ResponseBody
	public AjaxJson saveXmjbxxZdxmk(CInsBusinessZdxmk cInsBusinessZdxmk) {
		AjaxJson aj = new AjaxJson();
		if (StringUtils.isBlank(cInsBusinessZdxmk.getXmjbxx().getId())) {
			aj.setSuccess(false);
			aj.setMsg("请先保存项目基本信息");
			return aj;
		} else if (!xmjbxxService.isEditable(cInsBusinessZdxmk.getXmjbxx().getId())) {
            aj.setSuccess(false);
            aj.setMsg(GlobalParameter.SZT_NOT_EDITABLE);
            return aj;
        }

		try {
			String xmjbxxid=cInsBusinessZdxmk.getXmjbxx().getId();
			String	sfjkylxm=cInsBusinessZdxmk.getSfjkylxm();
			String	jkyldwxz=cInsBusinessZdxmk.getJkyldwxz();
			String	jkylxmfj=cInsBusinessZdxmk.getJkylxmfj();
			String	jkylxmlx=cInsBusinessZdxmk.getJkylxmlx();
			Xmjbxx xmjbxx=xmjbxxService.get(xmjbxxid);
			if(sfjkylxm == "0" || "0".equals(sfjkylxm)){
				xmjbxx.setSfjkylxm("0");
				xmjbxx.setJkyldwxz("0");
				xmjbxx.setJkylxmfj("0");
				xmjbxx.setJkylxmlx("0");
			}else{
				xmjbxx.setSfjkylxm(sfjkylxm);
				System.out.println(sfjkylxm);
				xmjbxx.setJkyldwxz(jkyldwxz);
				xmjbxx.setJkylxmfj(jkylxmfj);
				xmjbxx.setJkylxmlx(jkylxmlx);			
			}
			xmjbxxService.save(xmjbxx);
			zdxmkService.save(cInsBusinessZdxmk);
		} catch (Exception e) {
			e.printStackTrace();
			aj.setSuccess(false);
			aj.setMsg("保存出错！" + (e.getMessage() == null ? "" : e.getMessage()));
			return aj;
		}
		aj.setMsg("保存成功");
		return aj;
	}
	

	/**
	 * 删除项目基本信息
	 */
	@RequiresPermissions("xmjbxx:xmjbxx:del")
	@RequestMapping(value = "delete")
	public String delete(Xmjbxx xmjbxx, RedirectAttributes redirectAttributes) {
		xmjbxxService.delete(xmjbxx);
		addMessage(redirectAttributes, "删除项目基本信息成功");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/?repage";
	}

	/**
	 * 批量删除项目基本信息
	 */
	@RequiresPermissions("xmjbxx:xmjbxx:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] = ids.split(",");
		for (String id : idArray) {
			xmjbxxService.delete(xmjbxxService.get(id));
		}
		addMessage(redirectAttributes, "删除项目基本信息成功");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/?repage";
	}

	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("xmjbxx:xmjbxx:export")
	@RequestMapping(value = "export", method = RequestMethod.POST)
	public String exportFile(Xmjbxx xmjbxx, HttpServletRequest request,
							 HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
			String fileName = "项目基本信息" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
			Page<Xmjbxx> page = xmjbxxService.findPage(new Page<Xmjbxx>(request, response, -1), xmjbxx);
			new ExportExcel("项目基本信息", Xmjbxx.class).setDataList(page.getList())
					.write(response, fileName).dispose();
			return null;
		} catch (Exception e) {
			addMessage(redirectAttributes,
					"导出项目基本信息记录失败！失败信息：" + e.getMessage());
		}
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/?repage";
	}

	/**
	 * 导入Excel数据
	 */
	@RequiresPermissions("xmjbxx:xmjbxx:import")
	@RequestMapping(value = "import", method = RequestMethod.POST)
	public String importFile(MultipartFile file,
							 RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Xmjbxx> list = ei.getDataList(Xmjbxx.class);
			for (Xmjbxx xmjbxx : list) {
				try {
					xmjbxxService.save(xmjbxx);
					successNum++;
				} catch (ConstraintViolationException ex) {
					failureNum++;
				} catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum > 0) {
				failureMsg.insert(0, "，失败 " + failureNum + " 条项目基本信息记录。");
			}
			addMessage(redirectAttributes, "已成功导入 " + successNum + " 条项目基本信息记录"
					+ failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入项目基本信息失败！失败信息：" + e.getMessage());
		}
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/?repage";
	}

	/**
	 * 下载导入项目基本信息数据模板
	 */
	@RequiresPermissions("xmjbxx:xmjbxx:import")
	@RequestMapping(value = "import/template")
	public String importFileTemplate(HttpServletResponse response,
									 RedirectAttributes redirectAttributes) {
		try {
			String fileName = "项目基本信息数据导入模板.xlsx";
			List<Xmjbxx> list = Lists.newArrayList();
			new ExportExcel("项目基本信息数据", Xmjbxx.class, 1).setDataList(list).write(response, fileName).dispose();
			return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息：" + e.getMessage());
		}
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/?repage";
	}

	@ResponseBody
	@RequestMapping(value = "makeData")
	public AjaxJson makeData() {
		AjaxJson ajaxJson = new AjaxJson();

		try {
            // 更新新增字段 20171114
            xmjbxxService.updateDate();
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.setSuccess(false);
			ajaxJson.setMsg(e.getStackTrace().toString());
		}

		return ajaxJson;
	}

	@RequestMapping("operate")
	public String operate(Xmjbxx xmjbxx, RedirectAttributes redirectAttributes) {
		addMessage(redirectAttributes, "请补充该操作的详情...");
		return "redirect:" + Global.getAdminPath() + "/xmjbxx/xmjbxx/?repage";
	}

	@RequestMapping("getCInsBusinessInfo")
	@ResponseBody
	public AjaxJson getCInsBusinessInfo(Xmjbxx xmjbxx){
		AjaxJson aj = new AjaxJson();
		try {
			Xmjbxx info = xmjbxxService.getCInsBusinessInfo(xmjbxx.getSpjgptdm(), xmjbxx.getLxphoneone());
			aj.put("info", info);
			if(info == null || StringUtils.isBlank(info.getSpjgptdm())){
				aj.setSuccess(false);
				aj.setMsg("审批监管平台代码[" + xmjbxx.getSpjgptdm() + "]无匹配项目！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		return aj;
	}

	@RequestMapping("moveCode")
	@ResponseBody
	@RequiresRoles("system")
	public AjaxJson moveGbhyCode(){
		AjaxJson aj = new AjaxJson();
		aj.setMsg("操作成功！");
		try {
			xmjbxxService.moveTzptGbhyCode();
			xmjbxxService.moveTzptSshyCode();
		} catch (Exception e) {
			e.printStackTrace();
			aj.setSuccess(false);
			aj.setMsg("操作失败！" + e.getMessage());
		}
		return aj;
	}
	/**
	 * 年度计划编报-省重点项目投资计划 列表页面
	 */
	@RequestMapping("ndjhbbSzdList")
	public String ndjhbbSzdList(HttpServletRequest request, HttpServletResponse response, Model model,
							  @ModelAttribute("deptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter deptRelationSearchParameter) {
		// 设置查询参数
		String remarks = "";
		remarks = deptRelationSearchParameter.getRemarks();
		deptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());
		deptRelationSearchParameter.setZt(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
		deptRelationSearchParameter.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_WTX);
		if(remarks==null || "".equals(remarks)){
			deptRelationSearchParameter.setRemarks("88");
		}
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullPageByParameter(new Page<CInsBusinessXmjbxxDeptRelation>(request, response),deptRelationSearchParameter);
		model.addAttribute("page", page);
		return "modules/xmjbxx/ndjhbbSzdList";
	}
	
	/**
	 * 年度计划编报-省基建项目投资计划 列表页面
	 */
	@RequestMapping("ndjhbbSjjList")
	public String ndjhbbSjjList(HttpServletRequest request, HttpServletResponse response, Model model,
							  @ModelAttribute("deptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter deptRelationSearchParameter) {
		// 设置查询参数
		String remarks = "";
		remarks = deptRelationSearchParameter.getRemarks();
		deptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());
		deptRelationSearchParameter.setZt(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
		deptRelationSearchParameter.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_WTX);
		if(remarks==null || "".equals(remarks)){
			deptRelationSearchParameter.setRemarks("99");
		}
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullPageByParameter(new Page<CInsBusinessXmjbxxDeptRelation>(request, response),deptRelationSearchParameter);
		model.addAttribute("page", page);
		return "modules/xmjbxx/ndjhbbSjjList";
	}
	
	/**
	 * 年度计划编报-5818项目投资计划 列表页面
	 */
	@RequestMapping("ndjhbbwbybList")
	public String ndjhbbwbybList(HttpServletRequest request, HttpServletResponse response, Model model,
							  @ModelAttribute("deptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter deptRelationSearchParameter) {
		// 设置查询参数
		deptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());
		deptRelationSearchParameter.setZt(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
		deptRelationSearchParameter.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_WTX);
		deptRelationSearchParameter.setRemarks("5");
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullPageByParameter(new Page<CInsBusinessXmjbxxDeptRelation>(request, response),deptRelationSearchParameter);
		model.addAttribute("page", page);
		return "modules/xmjbxx/ndjhbbwbybList";
	}
	
	/**
	 * 年度计划编报-其他项目投资计划 列表页面
	 */
	@RequestMapping("ndjhbbqtList")
	public String ndjhbbqtList(HttpServletRequest request, HttpServletResponse response, Model model,
							  @ModelAttribute("deptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter deptRelationSearchParameter) {
		// 设置查询参数
		deptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());
		deptRelationSearchParameter.setZt(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
		deptRelationSearchParameter.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_WTX);
		deptRelationSearchParameter.setRemarks("6");
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullPageByParameter(new Page<CInsBusinessXmjbxxDeptRelation>(request, response),deptRelationSearchParameter);
		model.addAttribute("page", page);
		return "modules/xmjbxx/ndjhbbqtList";
	}
	/**
	 * 年度计划编报-省节能减排专项资金项目列表页面
	 */
	@RequestMapping("ndjhbbsjnjpList")
	public String ndjhbbsjnjpList(HttpServletRequest request, HttpServletResponse response, Model model,
							  @ModelAttribute("deptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter deptRelationSearchParameter) {
		// 设置查询参数
		deptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());
		deptRelationSearchParameter.setZt(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
		deptRelationSearchParameter.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_WTX);
		deptRelationSearchParameter.setRemarks("7");
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullPageByParameter(new Page<CInsBusinessXmjbxxDeptRelation>(request, response),deptRelationSearchParameter);
		model.addAttribute("page", page);
		return "modules/xmjbxx/ndjhbbsjnjpList";
	}
	/**
	 * 年度计划编报-京豫南北水调对口协作项目列表页面
	 */
	@RequestMapping("ndjhbbnsbdList")
	public String ndjhbbnsbdList(HttpServletRequest request, HttpServletResponse response, Model model,
							  @ModelAttribute("deptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter deptRelationSearchParameter) {
		// 设置查询参数
		deptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());
		deptRelationSearchParameter.setZt(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
		deptRelationSearchParameter.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_WTX);
		deptRelationSearchParameter.setRemarks("8");
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullPageByParameter(new Page<CInsBusinessXmjbxxDeptRelation>(request, response),deptRelationSearchParameter);
		model.addAttribute("page", page);
		return "modules/xmjbxx/ndjhbbnsbdList";
	}
	/**
	 * 年度计划编报-现代服务业重点项目列表页面
	 */
	@RequestMapping("ndjhbbfwyzdxmList")
	public String ndjhbbfwyzdxmList(HttpServletRequest request, HttpServletResponse response, Model model,
							  @ModelAttribute("deptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter deptRelationSearchParameter) {
		// 设置查询参数
		deptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());
		deptRelationSearchParameter.setZt(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
		deptRelationSearchParameter.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_WTX);
		deptRelationSearchParameter.setRemarks("9");
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullPageByParameter(new Page<CInsBusinessXmjbxxDeptRelation>(request, response),deptRelationSearchParameter);
		model.addAttribute("page", page);
		return "modules/xmjbxx/ndjhbbfwyzdxmList";
	}
/*	*//**
	 * 年度计划编报-省转型发展攻坚项目列表页面
	 */
	@RequestMapping("ndjhbbSzxfzgjList")
	public String ndjhbbSzxfzgjList(HttpServletRequest request, HttpServletResponse response, Model model,
							  @ModelAttribute("deptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter deptRelationSearchParameter) {
		// 设置查询参数
		deptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());
		deptRelationSearchParameter.setZt(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
		deptRelationSearchParameter.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_WTX);
		deptRelationSearchParameter.setRemarks("10");
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullPageByParameter(new Page<CInsBusinessXmjbxxDeptRelation>(request, response),deptRelationSearchParameter);
		model.addAttribute("page", page);
		return "modules/xmjbxx/ndjhbbSzxfzgjList";
	}
	/**
	 * 年度计划编报-省先进制造重大项目列表页面
	 */
	@RequestMapping("ndjhbbSxjzzzdList")
	public String ndjhbbSxjzzzdList(HttpServletRequest request, HttpServletResponse response, Model model,
							  @ModelAttribute("deptRelationSearchParameter") CInsBusinessXmjbxxDeptRelationSearchParameter deptRelationSearchParameter) {
		// 设置查询参数
		deptRelationSearchParameter.setDept(UserUtils.getUser().getOffice());
		deptRelationSearchParameter.setZt(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
		deptRelationSearchParameter.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_WTX);
		deptRelationSearchParameter.setRemarks("11");
		Page<CInsBusinessXmjbxxDeptRelation> page = deptRelationService.findFullPageByParameter(new Page<CInsBusinessXmjbxxDeptRelation>(request, response),deptRelationSearchParameter);
		model.addAttribute("page", page);
		return "modules/xmjbxx/ndjhbbSxjzzzdList";
	}
	/**
	 * 查看未报送和未调度
	 *//*
	@RequestMapping("getCountTsxx")
	public String countWbs(XmjbxxSearchParameter xmjbxxSearchParameter,XmjbxxTaskRelationSearchParameter xmjbxxTaskRelationSearchParameter, HttpServletRequest request, HttpServletResponse response, Model model) {
			// 设置查询参数
			xmjbxxSearchParameter.setListParam(Xmjbxx.STAGE_XMCB, UserUtils.getUserGrade(), Xmjbxx.ZT_XMCB_SHQ);
	        xmjbxxSearchParameter.setShbm(UserUtils.getUser().getOffice());	
			List<Xmjbxx>  listwsh = xmjbxxService.findWshListByParameter(xmjbxxSearchParameter);
			Integer countwsh = listwsh.size();
			model.addAttribute("countwsh", countwsh);
			
			// 设置查询参数
			xmjbxxTaskRelationSearchParameter.setStatus(CInsBusinessXmjbxxTaskRelation.STATUS_WWC);
			xmjbxxTaskRelationSearchParameter.setDestDeptId(UserUtils.getUser().getOffice().getId());
			List<CInsBusinessXmjbxxTaskRelation> listwdd = cInsBusinessXmjbxxTaskRelationService.findWddListByParameter(xmjbxxTaskRelationSearchParameter);
			Integer countwdd = listwdd.size();
			model.addAttribute("countwdd", countwdd);
		return "modules/sys/sysIndex-ace";
	}
	/**
	 * 滚动计划 编制区   从储备库中挑选  任务类型保存
	 */
	@ResponseBody
	@RequestMapping("saverwlx")
	public String saveRwlx(HttpServletRequest request, HttpServletResponse response, Model model,String ids,String rwlx) {
			AjaxJson aj = new AjaxJson();
			String[] idsArr = ids.split(",");
			
			try {
				for (String xmjbxx_id : idsArr) {				
					cInsBusinessSchedulerTaskService.saveRwlxByXmjbxxid(xmjbxx_id,rwlx);
				}
			} catch (Exception e) {
				e.printStackTrace();
				aj.setSuccess(false);
				aj.setMsg("保存失败！");
				return "0";
			}
			aj.setMsg("保存成功！");
		return "1";
	}
	
	/**
	 * 审核区-open信用反馈页面
	 */
	@RequiresPermissions(value = {"xmjbxx:xmjbxx:view", "xmjbxx:xmjbxx:add", "xmjbxx:xmjbxx:edit"}, logical = Logical.OR)
	@RequestMapping("qyxyfk")
	public String qyxyfk(HttpServletRequest request, HttpServletResponse response, Model model,Xmjbxx xmjbxx) {
		String ids = request.getParameter("id");
		FeedBackXx feedbackxx = new FeedBackXx();
		model.addAttribute("id",ids);
		model.addAttribute("feedbackxx",feedbackxx);
		return "modules/xmjbxx/xmfkForm";//xmfkForm.jsp
	}
	/**
	 * 审核区-进行信用反馈
	 */
	@RequestMapping("tofk")
	public void tofk(HttpServletRequest request, HttpServletResponse response, Model model) {
		Client clientSubject=null;
		QName nameSubject = null;
		Object[] result = null;
		Document doc=null;
		PrintWriter out=null;
		
		JaxWsDynamicClientFactory clientFactory=JaxWsDynamicClientFactory.newInstance();
		clientSubject= clientFactory.createClient("http://222.143.254.175:8080/subjectCenter/ws/shareDataInterfaceService?wsdl");
		nameSubject = new  QName("http://subjectcenter.service.hncredit.hnrj.com/", "setFeedback");
		
		String xmibxxid = request.getParameter("xmibxxid");
		String accordingto1 = request.getParameter("accordingto");
		String backtype1 = request.getParameter("backtype");
		String content1 = request.getParameter("content");
		
		Xmjbxx xmjbxx2=xmjbxxService.get(xmibxxid);
		String incidtype=xmjbxx2.getIncidtype();
		String incid=xmjbxx2.getIncid();
		String qymc=xmjbxx2.getXmfrdw();
		Map<String, Object> resultMap=companyJbxxService.getqyxyList(incidtype,incid,qymc);
		String qyid =(String) resultMap.get("id");
		
		Map<String, Object> qyxyList=(Map<String, Object>)resultMap.get("companyJbxx");
		String objname1 =(String) qyxyList.get("qymc");//企业名称
		String objtype1 ="1";//都是法人
		String creditcode1 =(String) qyxyList.get("tyshxydm"); //统一社会信用代码
		
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String dateexecut=simpleDateFormat.format(new Date());		
		String executedt1= dateexecut;//executedt 执行奖惩时间  
		User user = UserUtils.getUser();
		String userid =user.getId();
		String executeunit1 = xmjbxxService.getnamebyuserid(userid);//executeunit  奖惩执行单位
		
		//accordingto	奖惩依据
		//measurename  奖惩措施名称   选填项
		//matter  业务事项  选填项
		//content 奖惩内容
		String money1 =xmjbxx2.getZtz();//money   涉及金额
		//backtype  奖惩类型   取值1-惩戒 2-奖励
		//result  成效   选填项
		//remark
		String qyxyfkXml=qyxyfkXml(objname1,objtype1,creditcode1,executedt1,executeunit1,accordingto1,backtype1,content1,money1);
		
		try {
			result = clientSubject.invoke(nameSubject, "113818E78E8A4A6DA6E8C6A63F9CF49C",qyid,qyxyfkXml);
			String xmlStr=result[0].toString();
			System.out.println(xmlStr);
			doc = DocumentHelper.parseText(xmlStr);
			Document ddc = doc.getDocument();
			Element rootElt = doc.getRootElement();
			
			out=response.getWriter();
			Integer sdf = xmlStr.indexOf("true");
			if(xmlStr.indexOf("true")!=-1){
				out.print("1");
			}else{
				out.print("0");
			}
		} catch (Exception e) {
			out.print("0");
			e.printStackTrace();
		}
	}
	public String qyxyfkXml(String objname1,String objtype1,String creditcode1,String executedt1,
				String executeunit1,String accordingto1,String backtype1,String content1,String money1){
		Element root=DocumentHelper.createElement("feedback");
		Document document=DocumentHelper.createDocument(root);
		Element objname=root.addElement("objname");
		objname.addText(objname1);
		Element objtype=root.addElement("objtype");
		objtype.addText(objtype1);
		Element creditcode=root.addElement("creditcode");
		creditcode.addText(creditcode1);
		
		Element executedt=root.addElement("executedt");
		executedt.addText(executedt1);
	
		Element executeunit=root.addElement("executeunit");
		executeunit.addText(executeunit1);
		Element accordingto=root.addElement("accordingto");
		accordingto.addText(accordingto1);
		Element measurename=root.addElement("measurename");
		measurename.addText("");
		Element matter=root.addElement("matter");
		matter.addText("");
		Element content=root.addElement("content");
		content.addText(content1);
		Element money=root.addElement("money");
		money.addText(money1);
		Element backtype=root.addElement("backtype");
		backtype.addText(backtype1);
		Element result=root.addElement("result");
		result.addText("");
		Element remark=root.addElement("remark");
		remark.addText("");
		System.out.println(document.asXML());
		return document.asXML();
	}
}