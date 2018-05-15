/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.task.service;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.common.utils.SpringContextHolder;
import com.jeeplus.modules.log.entity.CInsBusinessLog;
import com.jeeplus.modules.log.utils.BusinessLogUtils;
import com.jeeplus.modules.task.dao.CInsBusinessXmjbxxTaskRelationDao;
import com.jeeplus.modules.task.entity.CInsBusinessSchedulerTask;
import com.jeeplus.modules.task.entity.CInsBusinessXmjbxxTaskRelation;
import com.jeeplus.modules.task.vo.XmjbxxTaskRelationSearchParameter;
import com.jeeplus.modules.xmjbxx.service.CInsBusinessSsqkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 项目基本信息和调度任务关联表Service
 * @author zcl
 * @version 2017-10-31
 */
@Service
@Transactional(readOnly = true)
public class CInsBusinessXmjbxxTaskRelationService extends CrudService<CInsBusinessXmjbxxTaskRelationDao, CInsBusinessXmjbxxTaskRelation> {

	@Autowired
	CInsBusinessSsqkService ssqkService;
	
	public CInsBusinessXmjbxxTaskRelation get(String id) {
		return super.get(id);
	}

	public List<CInsBusinessXmjbxxTaskRelation> findList(CInsBusinessXmjbxxTaskRelation cInsBusinessXmjbxxTaskRelation) {
		return super.findList(cInsBusinessXmjbxxTaskRelation);
	}

	public Page<CInsBusinessXmjbxxTaskRelation> findPage(Page<CInsBusinessXmjbxxTaskRelation> page, CInsBusinessXmjbxxTaskRelation cInsBusinessXmjbxxTaskRelation) {
		return super.findPage(page, cInsBusinessXmjbxxTaskRelation);
	}


	public Page<CInsBusinessXmjbxxTaskRelation> findFullPageByParameter(Page<CInsBusinessXmjbxxTaskRelation> page, XmjbxxTaskRelationSearchParameter parameter) {
		parameter.setPage(page);
		page.setList(dao.findFullListByParameter(parameter));
		return page;
	}
	
	public Page<CInsBusinessXmjbxxTaskRelation> findFullPageByParameterTwo(Page<CInsBusinessXmjbxxTaskRelation> page, XmjbxxTaskRelationSearchParameter parameter) {
		parameter.setPage(page);
		page.setList(dao.findFullListByParameterTwo(parameter));
		return page;
	}
	
	public List<CInsBusinessXmjbxxTaskRelation> findWddListByParameter(XmjbxxTaskRelationSearchParameter parameter) {
		List<CInsBusinessXmjbxxTaskRelation> listwdd = dao.findFullListByParameterTwo(parameter);
		return listwdd;
	}

	@Transactional(readOnly = false)
	public void save(CInsBusinessXmjbxxTaskRelation cInsBusinessXmjbxxTaskRelation) {
		super.save(cInsBusinessXmjbxxTaskRelation);
	}

	@Transactional(readOnly = false)
	public void delete(CInsBusinessXmjbxxTaskRelation cInsBusinessXmjbxxTaskRelation) {
		super.delete(cInsBusinessXmjbxxTaskRelation);
	}

	public List<CInsBusinessXmjbxxTaskRelation> findFullListByParameter(XmjbxxTaskRelationSearchParameter parameter){
		return dao.findFullListByParameter(parameter);
	}

	@Transactional(readOnly = false)
	public void finishTask(String id, String feedback) throws Exception {
		CInsBusinessXmjbxxTaskRelation relation = get(id);

		// 保存当次的项目调度情况
		relation.setStatus(CInsBusinessXmjbxxTaskRelation.STATUS_YWC);
		relation.setFinishDate(new Date());
		relation.setFeedback(feedback);
		save(relation);

		// 覆盖 项目申报 的实施情况
		ssqkService.updateSsqkByFinishTask(relation);

		// 添加业务日志
		BusinessLogUtils.saveLog(relation.getXmjbxx(), CInsBusinessLog.OPERATE_XMJBXX_TASK_FINISH, CInsBusinessLog.TYPE_XMJBXX_TASK);

		//如果任务内项目已经全部完成，则修改任务的状态为已经完成
		CInsBusinessSchedulerTask task = relation.getTask();
		XmjbxxTaskRelationSearchParameter parameter = new XmjbxxTaskRelationSearchParameter();
		parameter.setTask(task);
		parameter.setStatus(CInsBusinessXmjbxxTaskRelation.STATUS_WWC);
		List<CInsBusinessXmjbxxTaskRelation> cinsList = findFullListByParameter(parameter);
		if (cinsList.isEmpty()) {
			CInsBusinessSchedulerTaskService taskService = SpringContextHolder.getBean(CInsBusinessSchedulerTaskService.class);
			task = taskService.get(task.getId());
			task.setStatus(CInsBusinessSchedulerTask.STATUS_YWC);
			taskService.save(task);

			// 添加业务日志
			BusinessLogUtils.saveLog(task, CInsBusinessLog.OPERATE_TASK_FINISH, CInsBusinessLog.TYPE_TASK);
		} 

	}
	
	//修改调出调度任务 中调度关联表的update_date 值，为了排序，不用save()方法  是因为实体类中时date类型 ，数据库中时varchar.
	@Transactional(readOnly = false)
	public void updadate(String id,String day){
		 dao.updadate(id,day);
	}
	
	public Page<CInsBusinessXmjbxxTaskRelation> findFullPageByParameterOne(Page<CInsBusinessXmjbxxTaskRelation> page, XmjbxxTaskRelationSearchParameter parameter) {
		parameter.setPage(page);
		page.setList(dao.findFullListByParameterOne(parameter));
		return page;
	}
	//项目调度-项目调度管理-我的调度任务-未填报项目列表页面
	public Page<CInsBusinessXmjbxxTaskRelation> findFullPageByParameterfive(Page<CInsBusinessXmjbxxTaskRelation> page, XmjbxxTaskRelationSearchParameter parameter) {
		parameter.setPage(page);
		page.setList(dao.findFullPageByParameterfive(parameter));
		return page;
	}
	//项目调度-项目调度管理-我的调度任务-未填报项目-三天未填报-列表页面
		public Page<CInsBusinessXmjbxxTaskRelation> findFullPageByParametersix(Page<CInsBusinessXmjbxxTaskRelation> page, XmjbxxTaskRelationSearchParameter parameter) {
			parameter.setPage(page);
			page.setList(dao.findFullPageByParametersix(parameter));
			return page;
		}
	

}