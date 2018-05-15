/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.modules.log.entity.CInsBusinessLog;
import com.jeeplus.modules.log.utils.BusinessLogUtils;
import com.jeeplus.modules.task.entity.CInsBusinessSchedulerTask;
import com.jeeplus.modules.task.entity.CInsBusinessXmjbxxTaskRelation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessSsqk;
import com.jeeplus.modules.xmjbxx.dao.CInsBusinessSsqkDao;

/**
 * 实施情况Service
 * @author zcl
 * @version 2017-11-03
 */
@Service
@Transactional(readOnly = true)
public class CInsBusinessSsqkService extends CrudService<CInsBusinessSsqkDao, CInsBusinessSsqk> {

	public CInsBusinessSsqk get(String id) {
		return super.get(id);
	}
	
	public List<CInsBusinessSsqk> findList(CInsBusinessSsqk cInsBusinessSsqk) {
		return super.findList(cInsBusinessSsqk);
	}
	
	public Page<CInsBusinessSsqk> findPage(Page<CInsBusinessSsqk> page, CInsBusinessSsqk cInsBusinessSsqk) {
		return super.findPage(page, cInsBusinessSsqk);
	}
	
	@Transactional(readOnly = false)
	public void save(CInsBusinessSsqk cInsBusinessSsqk) {
		super.save(cInsBusinessSsqk);
	}
	
	@Transactional(readOnly = false)
	public void delete(CInsBusinessSsqk cInsBusinessSsqk) {
		super.delete(cInsBusinessSsqk);
	}

	/**
	 * 项目申报和项目修改，保存实施情况
	 */
	@Transactional(readOnly = false)
	public void saveXmjbxxSsqk(CInsBusinessSsqk ssqk) throws Exception {
		CInsBusinessSsqk ssqkParam = new CInsBusinessSsqk();
		ssqkParam.setXmjbxx(ssqk.getXmjbxx());
		ssqkParam.setType(CInsBusinessSsqk.TYPE_XMTB);
		List<CInsBusinessSsqk> ssqkList = findList(ssqkParam);
		if (ssqkList.isEmpty()) {
			ssqk.setType(CInsBusinessSsqk.TYPE_XMTB);
			save(ssqk);
		}else{
			CInsBusinessSsqk oldSsqk = ssqkList.get(0);
			MyBeanUtils.copyBeanNotNull2Bean(ssqk, oldSsqk);
			//因为copyBeanNotNull2Bean会将新对象的isNewRecord属性值复制过来，所以在这里需要将isNewRecord的值设为false，否则会报错
			//oldSsqk.setIsNewRecord(true);
			String newid = UUID.randomUUID().toString().replaceAll("-", "");
			oldSsqk.setId(newid);
			save(oldSsqk);
		}
	}

	/**
	 * 保存调度反馈
 	 */
	@Transactional(readOnly = false)
	public void saveTaskFeedback(CInsBusinessSsqk ssqk) throws Exception {
		CInsBusinessSsqk ssqkParam = new CInsBusinessSsqk();
		ssqkParam.setTaskRelation(ssqk.getTaskRelation());
		ssqkParam.setType(CInsBusinessSsqk.TYPE_DDFK);
		List<CInsBusinessSsqk> ssqkList = findList(ssqkParam);
		if (ssqkList.isEmpty()) {
			ssqk.setType(CInsBusinessSsqk.TYPE_DDFK);
			save(ssqk);
		}else{
			CInsBusinessSsqk oldSsqk = ssqkList.get(0);
			MyBeanUtils.copyBeanNotNull2Bean(ssqk, oldSsqk);
			//因为copyBeanNotNull2Bean会将新对象的isNewRecord属性值复制过来，所以在这里需要将isNewRecord的值设为false，否则会报错
			oldSsqk.setIsNewRecord(false);
			save(oldSsqk);
		}

		// 保存业务日志
		BusinessLogUtils.saveLog(ssqk.getXmjbxx(), CInsBusinessLog.OPERATE_XMJBXX_TASK_FEEDBACK, CInsBusinessLog.TYPE_XMJBXX_TASK);
	}

	/**
	 * 当改项目的调度任务完成时，将最新完成的调度任务的实施情况覆盖 项目申报 的实施情况
	 */
	@Transactional(readOnly = false)
	public void updateSsqkByFinishTask(CInsBusinessXmjbxxTaskRelation relation) throws Exception {
		CInsBusinessSsqk param = new CInsBusinessSsqk();
		param.setXmjbxx(relation.getXmjbxx());
		param.setType(CInsBusinessSsqk.TYPE_XMTB);
		List<CInsBusinessSsqk> xmtbSsqkList = findList(param);
		CInsBusinessSsqk xmtbSsqk = new CInsBusinessSsqk();
		if (!xmtbSsqkList.isEmpty()) {
			xmtbSsqk = xmtbSsqkList.get(0);
		}

		param.setType(CInsBusinessSsqk.TYPE_DDFK);
		param.setTaskRelation(relation);
		List<CInsBusinessSsqk> ddfkSsqkList = findList(param);
		if (!ddfkSsqkList.isEmpty()) {
			CInsBusinessSsqk ddfkSsqk = ddfkSsqkList.get(0);
			CInsBusinessSsqk resultSsqk = new CInsBusinessSsqk();
			MyBeanUtils.copyBeanNotNull2Bean(ddfkSsqk, resultSsqk);
			resultSsqk.setType(CInsBusinessSsqk.TYPE_XMTB);
			resultSsqk.setTaskRelation(xmtbSsqk.getTaskRelation());
			resultSsqk.setIsNewRecord(false);
			resultSsqk.setId(xmtbSsqk.getId());
			save(resultSsqk);
		} else {
			throw new RuntimeException("请先填写该调度反馈的详细反馈信息！");
		}
	}

	/**
	 * 初始化调度任务反馈的实施情况
	 * 当调度任务下发时，使用“项目填报”的实施情况的数据来初始化改调度反馈的实施情况
	 */
	@Transactional(readOnly = false)
	public void initTaskFeedBack(CInsBusinessXmjbxxTaskRelation relation) throws Exception {
		CInsBusinessSsqk param = new CInsBusinessSsqk();
		param.setXmjbxx(relation.getXmjbxx());
		param.setType(CInsBusinessSsqk.TYPE_XMTB);
		List<CInsBusinessSsqk> xmtbSsqkList = findList(param);
		CInsBusinessSsqk xmtbSsqk = new CInsBusinessSsqk();
		if (!xmtbSsqkList.isEmpty()) {
			xmtbSsqk = xmtbSsqkList.get(0);
		}

		param.setType(CInsBusinessSsqk.TYPE_DDFK);
		param.setTaskRelation(relation);
		List<CInsBusinessSsqk> ddfkSsqkList = findList(param);
		if (ddfkSsqkList.isEmpty()) {
			CInsBusinessSsqk ddfkSsqk = new CInsBusinessSsqk();
			MyBeanUtils.copyBeanNotNull2Bean(xmtbSsqk, ddfkSsqk);
			ddfkSsqk.setType(CInsBusinessSsqk.TYPE_DDFK);
			ddfkSsqk.setTaskRelation(relation);
			ddfkSsqk.setXmjbxx(relation.getXmjbxx());
			ddfkSsqk.setId(xmtbSsqk.getId());
			ddfkSsqk.setIsNewRecord(false);
			save(ddfkSsqk);
		}
	}
	
	/**
	 * 初始化调度任务反馈的实施情况
	 * 当调度任务下发时，使用“项目填报”的实施情况的数据来初始化改调度反馈的实施情况
	 */
	@Transactional(readOnly = false)
	public List<CInsBusinessSsqk> findfkqkbyxmjbxxid(String xmjbxxid) throws Exception {
		List<CInsBusinessSsqk> list = dao.getSsqkByXmjbxxid(xmjbxxid);
		return list;
	}
	/**
	 * 初始化调度任务反馈的实施情况
	 */
	@Transactional(readOnly = false)
	public List<CInsBusinessSsqk> findfkqkssxxbyssqkid(String ssqkid) throws Exception {
		List<CInsBusinessSsqk> list = dao.findfkqkssxxbyssqkid(ssqkid);
		return list;
	}
}