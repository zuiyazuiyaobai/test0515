/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessQqgz;
import com.jeeplus.modules.xmjbxx.dao.CInsBusinessQqgzDao;

/**
 * qqgzService
 * @author yw
 * @version 2017-09-26
 */
@Service
@Transactional(readOnly = true)
public class CInsBusinessQqgzService extends CrudService<CInsBusinessQqgzDao, CInsBusinessQqgz> {

	public CInsBusinessQqgz get(String id) {
		return super.get(id);
	}
	public CInsBusinessQqgz findCInsBusinessQqgz(CInsBusinessQqgz cInsBusinessQqgz) {
		return super.findCInsBusinessQqgz(cInsBusinessQqgz);
	}
	public List<CInsBusinessQqgz> findList(CInsBusinessQqgz cInsBusinessQqgz) {
		return super.findList(cInsBusinessQqgz);
	}
	
	public Page<CInsBusinessQqgz> findPage(Page<CInsBusinessQqgz> page, CInsBusinessQqgz cInsBusinessQqgz) {
		return super.findPage(page, cInsBusinessQqgz);
	}
	
	@Transactional(readOnly = false)
	public void save(CInsBusinessQqgz cInsBusinessQqgz) {
		super.save(cInsBusinessQqgz);
	}
	
	@Transactional(readOnly = false)
	public void delete(CInsBusinessQqgz cInsBusinessQqgz) {
		super.delete(cInsBusinessQqgz);
	}
	
	
	
	
}