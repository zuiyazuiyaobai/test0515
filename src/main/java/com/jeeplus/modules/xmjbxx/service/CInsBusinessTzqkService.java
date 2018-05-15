/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessTzqk;
import com.jeeplus.modules.xmjbxx.dao.CInsBusinessTzqkDao;

/**
 * 基本信息中的投资情况Service
 * @author yw
 * @version 2017-09-25
 */
@Service
@Transactional(readOnly = true)
public class CInsBusinessTzqkService extends CrudService<CInsBusinessTzqkDao, CInsBusinessTzqk> {

	public List<CInsBusinessTzqk> getall(String xmid) {
		return dao.getall(xmid);
	}
	
	public List<CInsBusinessTzqk> findList(CInsBusinessTzqk cInsBusinessTzqk) {
		return super.findList(cInsBusinessTzqk);
	}
	
	public Page<CInsBusinessTzqk> findPage(Page<CInsBusinessTzqk> page, CInsBusinessTzqk cInsBusinessTzqk) {
		return super.findPage(page, cInsBusinessTzqk);
	}
	
	@Transactional(readOnly = false)
	public void save(CInsBusinessTzqk cInsBusinessTzqk) {
		super.save(cInsBusinessTzqk);
	}
	
	@Transactional(readOnly = false)
	public void delete(CInsBusinessTzqk cInsBusinessTzqk) {
		super.delete(cInsBusinessTzqk);
	}
	
	
	
	
}