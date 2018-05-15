/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.task.service;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.log.entity.CInsBusinessLog;
import com.jeeplus.modules.log.utils.BusinessLogUtils;
import com.jeeplus.modules.sys.entity.Office;
import com.jeeplus.modules.sys.utils.UserUtils;
import com.jeeplus.modules.task.dao.CInsBusinessSchedulerTaskDao;
import com.jeeplus.modules.task.entity.CInsBusinessSchedulerTask;
import com.jeeplus.modules.task.entity.CInsBusinessXmjbxxTaskRelation;
import com.jeeplus.modules.task.vo.SchedulerTaskSearchParameter;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessSsqk;
import com.jeeplus.modules.xmjbxx.entity.Xmjbxx;
import com.jeeplus.modules.xmjbxx.entity.sub.CInsBusinessXmjbxxDeptRelation;
import com.jeeplus.modules.xmjbxx.service.CInsBusinessSsqkService;
import com.jeeplus.modules.xmjbxx.service.XmjbxxService;
import com.jeeplus.modules.xmjbxx.service.sub.CInsBusinessXmjbxxDeptRelationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 调度任务Service
 *
 * @author zcl
 * @version 2017-10-31
 */
@Service
@Transactional(readOnly = true)
public class CInsBusinessSchedulerTaskService extends CrudService<CInsBusinessSchedulerTaskDao, CInsBusinessSchedulerTask> {
    @Autowired
    CInsBusinessXmjbxxTaskRelationService taskRelationService;

    @Autowired
    XmjbxxService xmjbxxService;

    @Autowired
    CInsBusinessSsqkService ssqkService;
    
    @Autowired
	private CInsBusinessXmjbxxDeptRelationService relationService;

    public CInsBusinessSchedulerTask get(String id) {
        return super.get(id);
    }

    public List<CInsBusinessSchedulerTask> findList(CInsBusinessSchedulerTask cInsBusinessSchedulerTask) {
        return super.findList(cInsBusinessSchedulerTask);
    }

    public Page<CInsBusinessSchedulerTask> findPage(Page<CInsBusinessSchedulerTask> page, CInsBusinessSchedulerTask cInsBusinessSchedulerTask) {
        return super.findPage(page, cInsBusinessSchedulerTask);
    }
    
    public Page<CInsBusinessSchedulerTask> findFullPageByParameter(Page<CInsBusinessSchedulerTask> page, SchedulerTaskSearchParameter parameter) {
        parameter.setPage(page);
        page.setList(dao.findFullListByParameter(parameter));
        return page;
    }
    public Page<CInsBusinessSchedulerTask> findYxfListByParameter(Page<CInsBusinessSchedulerTask> page, SchedulerTaskSearchParameter parameter) {
        parameter.setPage(page);
        page.setList(dao.findFullListByParameter(parameter));
        return page;
    }

    public List<CInsBusinessSchedulerTask> getTaskVoList(List<CInsBusinessSchedulerTask> schedulerTaskList) {
        List<CInsBusinessSchedulerTask> schedulerTaskVoList = new ArrayList<CInsBusinessSchedulerTask>();
        for (CInsBusinessSchedulerTask task : schedulerTaskList) {
            CInsBusinessXmjbxxTaskRelation relation = new CInsBusinessXmjbxxTaskRelation();
            relation.setTask(task);
            List<CInsBusinessXmjbxxTaskRelation> list = taskRelationService.findList(relation);
            task.setRelations(list);
            schedulerTaskVoList.add(task);
        }
        return schedulerTaskVoList;
    }

    @Transactional(readOnly = false)
    public void save(CInsBusinessSchedulerTask cInsBusinessSchedulerTask) {
        super.save(cInsBusinessSchedulerTask);
    }

    @Transactional(readOnly = false)
    public void delete(CInsBusinessSchedulerTask cInsBusinessSchedulerTask) {
        super.delete(cInsBusinessSchedulerTask);
    }

    /**
     * 添加项目到调度任务
     */
    @Transactional(readOnly = false)
    public void selectToSchedulerTask(String taskId, String originType, String ids) {
        CInsBusinessSchedulerTask task = new CInsBusinessSchedulerTask(taskId);
        String[] idsArr = ids.split(",");
        for (String id : idsArr) {
            Xmjbxx xmjbxx = new Xmjbxx(id);
            //校验当前项目是否存在关联表中了
            CInsBusinessXmjbxxTaskRelation relation = new CInsBusinessXmjbxxTaskRelation();
            relation.setXmjbxx(xmjbxx);
            relation.setTask(task);
            List<CInsBusinessXmjbxxTaskRelation> existRelationList = taskRelationService.findList(relation);
            if (existRelationList.isEmpty()) {
                CInsBusinessXmjbxxTaskRelation newRelation = new CInsBusinessXmjbxxTaskRelation();
                newRelation.setXmjbxx(xmjbxx);
                newRelation.setTask(task);
                newRelation.setStatus(CInsBusinessXmjbxxTaskRelation.STATUS_WWC);
                System.out.println("shbm:"+xmjbxx.getShbm());
                System.out.println(UserUtils.getUser().getOffice().getId());
                newRelation.setDestDeptId(UserUtils.getUser().getOffice().getId());
                taskRelationService.save(newRelation);
            }
         // 添加到已上报
            xmjbxx = xmjbxxService.get(id);
    		CInsBusinessXmjbxxDeptRelation relations = new CInsBusinessXmjbxxDeptRelation();
    		relations.setType(CInsBusinessXmjbxxDeptRelation.TYPE_YSB);
    		relations.setNrzt(CInsBusinessXmjbxxDeptRelation.TYPE_SNGDJH);
    		relations.setDept(UserUtils.getUser().getOffice());
    		relations.setXmjbxx(xmjbxx);
    		xmjbxx.setZt(xmjbxx.ZT_TZJH_SHQ);
    		xmjbxxService.save(xmjbxx);
    		if(null!=task.getRemarks()){
    			relations.setBswh(String.valueOf(task.getRemarks()));
    		}
    		if(null!=originType){
    			relations.setRemarks(originType);
    		}
    		relationService.addOrUpdateRelation(relations);
        }
    }

    @Transactional(readOnly = false)
    public void issueTasks(String ids) throws Exception {
        String idArray[] = ids.split(",");
        for (String id : idArray) {
            CInsBusinessSchedulerTask task = get(id);
            CInsBusinessXmjbxxTaskRelation parameter = new CInsBusinessXmjbxxTaskRelation();
            parameter.setTask(task);
            List<CInsBusinessXmjbxxTaskRelation> relationList = taskRelationService.findList(parameter);
            for (CInsBusinessXmjbxxTaskRelation relation : relationList) {
                String xmjbxxId = relation.getXmjbxx().getId();
                Xmjbxx xmjbxx = xmjbxxService.get(xmjbxxId);

                if (null == xmjbxx.getCreateBy() || xmjbxx.getCreateBy().getId() == null) {
                    logger.error("项目[" + xmjbxx.getId() + "]无法获取创建人信息...");
                    throw new RuntimeException("项目（" + xmjbxx.getXmmc() + "）重大库编码：[" + xmjbxx.getZdkbmgj() + "]无法获取创建人信息，请联系系统管理员！");
                }

                //String userId = xmjbxx.getCreateBy().getId();
                String userId = UserUtils.getUser().getOffice().getId();
                String deptId = UserUtils.getOfficeIdByUserId(userId);
                String xf_deptid = UserUtils.getUser().getOffice().getId();
                relation.setDestDeptId(xf_deptid);
                taskRelationService.save(relation);

                // 初始化调度任务反馈
                ssqkService.initTaskFeedBack(relation);

                // 添加业务日志
                BusinessLogUtils.saveLog(xmjbxx, CInsBusinessLog.OPERATE_XMJBXX_TASK_ISSUE, CInsBusinessLog.TYPE_XMJBXX_TASK, xmjbxx.getCreateBy(), xmjbxx.getCreateByName(), new Office(deptId));
            }

            task.setStatus(CInsBusinessSchedulerTask.STATUS_YXF);
            task.setIssueDate(new Date());
            task.setDept(UserUtils.getUser().getOffice());
            save(task);

            // 添加业务日志
            BusinessLogUtils.saveLog(task, CInsBusinessLog.OPERATE_TASK_ISSUE, CInsBusinessLog.TYPE_TASK);
        }
    }

	 @Transactional(readOnly = false)
	public void getCountByXmjbxxid(String xmjbxxid) {
		List<Map<String, String>> ssqkList = dao.getCountByXmjbxxid(xmjbxxid);
		if(ssqkList.size()==0){
			String ssqkid =UUID.randomUUID().toString().replaceAll("-","");
			try {
				 dao.insertSsqkJl(ssqkid,xmjbxxid);
			} catch (Exception e1) {
				e1.printStackTrace();
			}	
		}
		
	}

	public CInsBusinessSsqk getSsqkByXmjbxxid(String xmjbxxid) {
		List<CInsBusinessSsqk> cinsbusinessssqk=dao.getSsqkByXmjbxxid(xmjbxxid);
		CInsBusinessSsqk cinsbusinessssqkS ;
		if(null==cinsbusinessssqk){
			 cinsbusinessssqkS =  new  CInsBusinessSsqk();
		}else if(cinsbusinessssqk.size()==0){
			cinsbusinessssqkS =  new  CInsBusinessSsqk();
		}else{
			cinsbusinessssqkS = cinsbusinessssqk.get(0);
		}
		return cinsbusinessssqkS;
	}
	@Transactional(readOnly = false)
	public void saveRwlxByXmjbxxid(String xmjbxx_id,String rwlx) {
		try {
			dao.saveRwlxByXmjbxxid(xmjbxx_id,rwlx);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Xmjbxx findListByXmjbxxid(String xmjbxxid){
		List<Xmjbxx> list =  dao.findListByXmjbxxid(xmjbxxid);
		Xmjbxx xmjbxx;
		if(list.size() ==0){
			xmjbxx = new Xmjbxx();
		}else{
			xmjbxx = list.get(0);
		}
		return xmjbxx;
	}
	public List<CInsBusinessSchedulerTask> findLsxdListByXmjbxxid(String xmjbxxid){
		List<CInsBusinessSchedulerTask> list = dao.findLsxdListByXmjbxxid(xmjbxxid);
		return list;
	}
	
	@Transactional(readOnly = false)
	public void setdcrw(String taskid) {
		dao.setdcrw(taskid);
	}
}
