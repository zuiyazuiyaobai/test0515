/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.account.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.account.entity.TYwProject;
import com.jeeplus.modules.account.dao.TYwProjectDao;

/**
 * 台账主业务信息Service
 * @author aaa
 * @version 2018-05-21
 */
@Service
@Transactional(readOnly = true)
public class TYwProjectService extends CrudService<TYwProjectDao, TYwProject> {

	public TYwProject get(String id) {
		return super.get(id);
	}
	
	public List<TYwProject> findList(TYwProject tYwProject) {
		return super.findList(tYwProject);
	}
	
	public Page<TYwProject> findPage(Page<TYwProject> page, TYwProject tYwProject) {
		return super.findPage(page, tYwProject);
	}
	
	@Transactional(readOnly = false)
	public void save(TYwProject tYwProject) {
		super.save(tYwProject);
	}
	
	@Transactional(readOnly = false)
	public void delete(TYwProject tYwProject) {
		super.delete(tYwProject);
	}
	
	
	
	
}