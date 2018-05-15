/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.web.sub;

import com.google.common.collect.Lists;
import com.jeeplus.common.config.Global;
import com.jeeplus.common.json.AjaxJson;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.modules.xmjbxx.entity.Xmjbxx;
import com.jeeplus.modules.xmjbxx.entity.sub.CInsBusinessXmgs;
import com.jeeplus.modules.xmjbxx.service.sub.CInsBusinessXmgsService;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * 项目公司Controller
 *
 * @author zcl
 * @version 2017-10-25
 */
@Controller
@RequestMapping(value = "${adminPath}/xmjbxx/sub/cInsBusinessXmgs")
public class CInsBusinessXmgsController extends BaseController {

    @Autowired
    private CInsBusinessXmgsService cInsBusinessXmgsService;

    @ModelAttribute
    public CInsBusinessXmgs get(@RequestParam(required = false) String id) {
        CInsBusinessXmgs entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = cInsBusinessXmgsService.get(id);
        }
        if (entity == null) {
            entity = new CInsBusinessXmgs();
        }
        return entity;
    }

    /**
     * 项目公司列表页面
     */
    @RequiresPermissions("xmjbxx:sub:cInsBusinessXmgs:list")
    @RequestMapping(value = {"list", ""})
    public String list(CInsBusinessXmgs cInsBusinessXmgs, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<CInsBusinessXmgs> page = cInsBusinessXmgsService.findPage(new Page<CInsBusinessXmgs>(request, response), cInsBusinessXmgs);
        model.addAttribute("page", page);
        return "modules/xmjbxx/sub/cInsBusinessXmgsList";
    }

    /**
     * 项目公司查看编辑弹框
     */
    @RequestMapping("xmgsgc")
    public String xmgsgc(String xmid, Model model) {
        CInsBusinessXmgs xmgs = new CInsBusinessXmgs();
        xmgs.setXmjbxx(new Xmjbxx(xmid));
        List<CInsBusinessXmgs> xmgsList = cInsBusinessXmgsService.findList(xmgs);
        model.addAttribute("xmid", xmid);
        model.addAttribute("xmgsList", xmgsList);
        return "modules/xmjbxx/form/xmgsgcForm";
    }

    /**
     * 查看，增加，编辑项目公司表单页面
     */
    @RequiresPermissions(value = {"xmjbxx:sub:cInsBusinessXmgs:view", "xmjbxx:sub:cInsBusinessXmgs:add", "xmjbxx:sub:cInsBusinessXmgs:edit"}, logical = Logical.OR)
    @RequestMapping(value = "form")
    public String form(CInsBusinessXmgs cInsBusinessXmgs, Model model) {
        model.addAttribute("cInsBusinessXmgs", cInsBusinessXmgs);
        return "modules/xmjbxx/sub/cInsBusinessXmgsForm";
    }

    /**
     * 保存项目公司
     */
    @RequiresPermissions(value = {"xmjbxx:sub:cInsBusinessXmgs:add", "xmjbxx:sub:cInsBusinessXmgs:edit"}, logical = Logical.OR)
    @RequestMapping(value = "save")
    public String save(CInsBusinessXmgs cInsBusinessXmgs, Model model, RedirectAttributes redirectAttributes) throws Exception {
        if (!beanValidator(model, cInsBusinessXmgs)) {
            return form(cInsBusinessXmgs, model);
        }
        if (!cInsBusinessXmgs.getIsNewRecord()) {//编辑表单保存
            CInsBusinessXmgs t = cInsBusinessXmgsService.get(cInsBusinessXmgs.getId());//从数据库取出记录的值
            MyBeanUtils.copyBeanNotNull2Bean(cInsBusinessXmgs, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
            cInsBusinessXmgsService.save(t);//保存
        } else {//新增表单保存
            cInsBusinessXmgsService.save(cInsBusinessXmgs);//保存
        }
        addMessage(redirectAttributes, "保存项目公司成功");
        return "redirect:" + Global.getAdminPath() + "/xmjbxx/sub/cInsBusinessXmgs/?repage";
    }

    /**
     * 保存项目公司相关信息
     */
    @RequestMapping(value = "saveXmgs")
    @ResponseBody
    public AjaxJson saveXmgs(Xmjbxx data, Model model) throws Exception {
        AjaxJson aj = new AjaxJson();
        if (null == data || null == data.getXmgss() || data.getXmgss().isEmpty()) {
            aj.setSuccess(false);
            aj.setMsg("数据为空！");
            return aj;
        }
        try {
            cInsBusinessXmgsService.saveXmgs(data);
        } catch (Exception e) {
            e.printStackTrace();
            aj.setSuccess(false);
            aj.setMsg("保存数据异常！");
        }
        return aj;
    }

    /**
     * 删除项目公司
     */
    @RequiresPermissions("xmjbxx:sub:cInsBusinessXmgs:del")
    @RequestMapping(value = "delete")
    public String delete(CInsBusinessXmgs cInsBusinessXmgs, RedirectAttributes redirectAttributes) {
        cInsBusinessXmgsService.delete(cInsBusinessXmgs);
        addMessage(redirectAttributes, "删除项目公司成功");
        return "redirect:" + Global.getAdminPath() + "/xmjbxx/sub/cInsBusinessXmgs/?repage";
    }

    /**
     * 批量删除项目公司
     */
    @RequiresPermissions("xmjbxx:sub:cInsBusinessXmgs:del")
    @RequestMapping(value = "deleteAll")
    public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
        String idArray[] = ids.split(",");
        for (String id : idArray) {
            cInsBusinessXmgsService.delete(cInsBusinessXmgsService.get(id));
        }
        addMessage(redirectAttributes, "删除项目公司成功");
        return "redirect:" + Global.getAdminPath() + "/xmjbxx/sub/cInsBusinessXmgs/?repage";
    }

    /**
     * 导出excel文件
     */
    @RequiresPermissions("xmjbxx:sub:cInsBusinessXmgs:export")
    @RequestMapping(value = "export", method = RequestMethod.POST)
    public String exportFile(CInsBusinessXmgs cInsBusinessXmgs, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        try {
            String fileName = "项目公司" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
            Page<CInsBusinessXmgs> page = cInsBusinessXmgsService.findPage(new Page<CInsBusinessXmgs>(request, response, -1), cInsBusinessXmgs);
            new ExportExcel("项目公司", CInsBusinessXmgs.class).setDataList(page.getList()).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            addMessage(redirectAttributes, "导出项目公司记录失败！失败信息：" + e.getMessage());
        }
        return "redirect:" + Global.getAdminPath() + "/xmjbxx/sub/cInsBusinessXmgs/?repage";
    }

    /**
     * 导入Excel数据
     */
    @RequiresPermissions("xmjbxx:sub:cInsBusinessXmgs:import")
    @RequestMapping(value = "import", method = RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            int successNum = 0;
            int failureNum = 0;
            StringBuilder failureMsg = new StringBuilder();
            ImportExcel ei = new ImportExcel(file, 1, 0);
            List<CInsBusinessXmgs> list = ei.getDataList(CInsBusinessXmgs.class);
            for (CInsBusinessXmgs cInsBusinessXmgs : list) {
                try {
                    cInsBusinessXmgsService.save(cInsBusinessXmgs);
                    successNum++;
                } catch (ConstraintViolationException ex) {
                    failureNum++;
                } catch (Exception ex) {
                    failureNum++;
                }
            }
            if (failureNum > 0) {
                failureMsg.insert(0, "，失败 " + failureNum + " 条项目公司记录。");
            }
            addMessage(redirectAttributes, "已成功导入 " + successNum + " 条项目公司记录" + failureMsg);
        } catch (Exception e) {
            addMessage(redirectAttributes, "导入项目公司失败！失败信息：" + e.getMessage());
        }
        return "redirect:" + Global.getAdminPath() + "/xmjbxx/sub/cInsBusinessXmgs/?repage";
    }

    /**
     * 下载导入项目公司数据模板
     */
    @RequiresPermissions("xmjbxx:sub:cInsBusinessXmgs:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
        try {
            String fileName = "项目公司数据导入模板.xlsx";
            List<CInsBusinessXmgs> list = Lists.newArrayList();
            new ExportExcel("项目公司数据", CInsBusinessXmgs.class, 1).setDataList(list).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            addMessage(redirectAttributes, "导入模板下载失败！失败信息：" + e.getMessage());
        }
        return "redirect:" + Global.getAdminPath() + "/xmjbxx/sub/cInsBusinessXmgs/?repage";
    }


}