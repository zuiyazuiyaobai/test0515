/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.accounttask.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.accounttask.entity.TYwTask;
import com.jeeplus.modules.accounttask.dao.TYwTaskDao;

/**
 * 任务信息Service
 * @author aaa
 * @version 2018-05-21
 */
@Service
@Transactional(readOnly = true)
public class TYwTaskService extends CrudService<TYwTaskDao, TYwTask> {

	public TYwTask get(String id) {
		return super.get(id);
	}
	
	public List<TYwTask> findList(TYwTask tYwTask) {
		return super.findList(tYwTask);
	}
	
	public Page<TYwTask> findPage(Page<TYwTask> page, TYwTask tYwTask) {
		return super.findPage(page, tYwTask);
	}
	
	@Transactional(readOnly = false)
	public void save(TYwTask tYwTask) {
		super.save(tYwTask);
	}
	
	@Transactional(readOnly = false)
	public void delete(TYwTask tYwTask) {
		super.delete(tYwTask);
	}
	
	
	
	
}