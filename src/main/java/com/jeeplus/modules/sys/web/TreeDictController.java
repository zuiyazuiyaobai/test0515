/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sys.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import com.google.common.collect.Maps;
import com.jeeplus.modules.sys.entity.TreeDict;
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

import com.google.common.collect.Lists;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.config.Global;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.modules.sys.service.TreeDictService;

/**
 * 符合规划Controller
 * 
 * @author yw
 * @version 2017-09-28
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/treeDict")
public class TreeDictController extends BaseController {

	@Autowired
	private TreeDictService treeDictService;

	@ModelAttribute
	public TreeDict get(@RequestParam(required = false) String id) {
		TreeDict entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = treeDictService.get(id);
		}
		if (entity == null) {
			entity = new TreeDict();
		}
		return entity;
	}

	/**
	 * 符合规划列表页面
	 */
	@RequiresPermissions("sys:treeDict:list")
	@RequestMapping(value = { "list", "" })
	public String list(TreeDict treeDict, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<TreeDict> list = treeDictService.findList(treeDict);
		model.addAttribute("list", list);
		return "modules/sys/treeDictList";
	}

	/**
	 * 查看，增加，编辑符合规划表单页面
	 */
	@RequiresPermissions(value = { "sys:treeDict:view",
			"sys:treeDict:add", "sys:treeDict:edit" }, logical = Logical.OR)
	@RequestMapping(value = "form")
	public String form(TreeDict treeDict, Model model) {
		if (treeDict.getParent()!=null && StringUtils.isNotBlank(treeDict.getParent().getId())){
			treeDict.setParent(treeDictService.get(treeDict.getParent().getId()));
			// 获取排序号，最末节点排序号+30
			if (StringUtils.isBlank(treeDict.getId())){
				TreeDict testTreeChild = new TreeDict();
				testTreeChild.setParent(new TreeDict(treeDict.getParent().getId()));
				List<TreeDict> list = treeDictService.findList(treeDict);
				if (list.size() > 0){
					treeDict.setSort(list.get(list.size()-1).getSort());
					if (treeDict.getSort() != null){
						treeDict.setSort(treeDict.getSort() + 30);
					}
				}
			}
		}
		if (treeDict.getSort() == null){
			treeDict.setSort(30);
		}
		model.addAttribute("treeDict", treeDict);
		return "modules/sys/treeDictForm";
	}

	/**
	 * 添加子节点
	 */
	@RequiresPermissions("sys:treeDict:add")
	@RequestMapping(value = "addSubNode")
	public String addSubNode(TreeDict treeDict, Model model) {
		if (StringUtils.isNotBlank(treeDict.getParent().getId())) {
			TreeDict parent = treeDictService.get(treeDict.getParent().getId());
			List<TreeDict> list = treeDictService.findList(treeDict);
			treeDict = (list.isEmpty() ? new TreeDict() : list.get(0));
			treeDict.setId(null);
			treeDict.setCode(null);
			treeDict.setName(null);
			treeDict.setRemarks(parent.getRemarks());
			treeDict.setType(parent.getType());
			treeDict.setSort(list.isEmpty() ? 10 : (list.get(list.size() - 1).getSort() + 10));
			treeDict.setParent(parent);
		}
		model.addAttribute("treeDict", treeDict);
		return "modules/sys/treeDictForm";
	}

	/**
	 * 保存符合规划
	 */
	@RequiresPermissions(value = { "sys:treeDict:add",
			"sys:treeDict:edit" }, logical = Logical.OR)
	@RequestMapping(value = "save")
	public String save(TreeDict treeDict, Model model,
                       RedirectAttributes redirectAttributes) throws Exception {
		if (!beanValidator(model, treeDict)) {
			return form(treeDict, model);
		}
		if (!treeDict.getIsNewRecord()) {// 编辑表单保存
			TreeDict t = treeDictService.get(treeDict.getId());// 从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(treeDict, t);// 将编辑表单中的非NULL值覆盖数据库记录中的值
			treeDictService.save(t);// 保存
		} else {// 新增表单保存
			treeDictService.save(treeDict);// 保存
		}
		addMessage(redirectAttributes, "保存符合规划成功");
		return "redirect:" + Global.getAdminPath()
				+ "/sys/treeDict/?repage";
	}

	/**
	 * 删除符合规划
	 */
	@RequiresPermissions("sys:treeDict:del")
	@RequestMapping(value = "delete")
	public String delete(TreeDict treeDict,
			RedirectAttributes redirectAttributes) {
		treeDictService.delete(treeDict);
		addMessage(redirectAttributes, "删除符合规划成功");
		return "redirect:" + Global.getAdminPath()
				+ "/sys/treeDict/?repage";
	}

	/**
	 * 批量删除符合规划
	 */
	@RequiresPermissions("sys:treeDict:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] = ids.split(",");
		for (String id : idArray) {
			treeDictService.delete(treeDictService.get(id));
		}
		addMessage(redirectAttributes, "删除符合规划成功");
		return "redirect:" + Global.getAdminPath()
				+ "/sys/treeDict/?repage";
	}

	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("sys:treeDict:export")
	@RequestMapping(value = "export", method = RequestMethod.POST)
	public String exportFile(TreeDict treeDict, HttpServletRequest request,
                             HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
			String fileName = "符合规划" + DateUtils.getDate("yyyyMMddHHmmss")
					+ ".xlsx";
			Page<TreeDict> page = treeDictService.findPage(
					new Page<TreeDict>(request, response, -1), treeDict);
			new ExportExcel("符合规划", TreeDict.class)
					.setDataList(page.getList()).write(response, fileName)
					.dispose();
			return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出符合规划记录失败！失败信息：" + e.getMessage());
		}
		return "redirect:" + Global.getAdminPath()
				+ "/sys/treeDict/?repage";
	}

	/**
	 * 导入Excel数据
	 */
	@RequiresPermissions("sys:treeDict:import")
	@RequestMapping(value = "import", method = RequestMethod.POST)
	public String importFile(MultipartFile file,
			RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<TreeDict> list = ei.getDataList(TreeDict.class);
			for (TreeDict treeDict : list) {
				try {
					treeDictService.save(treeDict);
					successNum++;
				} catch (ConstraintViolationException ex) {
					failureNum++;
				} catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum > 0) {
				failureMsg.insert(0, "，失败 " + failureNum + " 条符合规划记录。");
			}
			addMessage(redirectAttributes, "已成功导入 " + successNum + " 条符合规划记录"
					+ failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入符合规划失败！失败信息：" + e.getMessage());
		}
		return "redirect:" + Global.getAdminPath()
				+ "/sys/treeDict/?repage";
	}

	/**
	 * 下载导入符合规划数据模板
	 */
	@RequiresPermissions("sys:treeDict:import")
	@RequestMapping(value = "import/template")
	public String importFileTemplate(HttpServletResponse response,
			RedirectAttributes redirectAttributes) {
		try {
			String fileName = "符合规划数据导入模板.xlsx";
			List<TreeDict> list = Lists.newArrayList();
			new ExportExcel("符合规划数据", TreeDict.class, 1).setDataList(list)
					.write(response, fileName).dispose();
			return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息：" + e.getMessage());
		}
		return "redirect:" + Global.getAdminPath()
				+ "/sys/treeDict/?repage";
	}

	
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required = false) String extId,@RequestParam(required = false) Boolean isAll,@RequestParam(required=false) String type,HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		TreeDict treeDict=new TreeDict();
		treeDict.setType(type);
		List<TreeDict> list = treeDictService.findList(treeDict);
		for (int i = 0; i < list.size(); i++) {
			TreeDict e = list.get(i);
			if ((StringUtils.isBlank(extId) || (extId != null && !extId.equals(e.getId()) && e.getParentIds().indexOf( "," + extId + ",") == -1))) {
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParent() == null ? "0" : e.getParent().getId());
				map.put("pIds", e.getParentIds());
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}

}