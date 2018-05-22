/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.accountfeedback.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.accountfeedback.entity.TYwFeedback;
import com.jeeplus.modules.accountfeedback.dao.TYwFeedbackDao;

/**
 * 反馈信息Service
 * @author aaa
 * @version 2018-05-21
 */
@Service
@Transactional(readOnly = true)
public class TYwFeedbackService extends CrudService<TYwFeedbackDao, TYwFeedback> {

	public TYwFeedback get(String id) {
		return super.get(id);
	}
	
	public List<TYwFeedback> findList(TYwFeedback tYwFeedback) {
		return super.findList(tYwFeedback);
	}
	
	public Page<TYwFeedback> findPage(Page<TYwFeedback> page, TYwFeedback tYwFeedback) {
		return super.findPage(page, tYwFeedback);
	}
	
	@Transactional(readOnly = false)
	public void save(TYwFeedback tYwFeedback) {
		super.save(tYwFeedback);
	}
	
	@Transactional(readOnly = false)
	public void delete(TYwFeedback tYwFeedback) {
		super.delete(tYwFeedback);
	}
	
	
	
	
}