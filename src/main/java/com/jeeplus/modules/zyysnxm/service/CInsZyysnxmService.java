/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.zyysnxm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.zyysnxm.entity.CInsZyysnxm;
import com.jeeplus.modules.zyysnxm.dao.CInsZyysnxmDao;

/**
 * 中央预算内Service
 * @author zgl
 * @version 2017-12-01
 */
@Service
@Transactional(readOnly = true)
public class CInsZyysnxmService extends CrudService<CInsZyysnxmDao, CInsZyysnxm> {

	public CInsZyysnxm get(String id) {
		return super.get(id);
	}
	
	public List<CInsZyysnxm> findList(CInsZyysnxm cInsZyysnxm) {
		return super.findList(cInsZyysnxm);
	}
	
	public Page<CInsZyysnxm> findPage(Page<CInsZyysnxm> page, CInsZyysnxm cInsZyysnxm) {
		return super.findPage(page, cInsZyysnxm);
	}
	
	@Transactional(readOnly = false)
	public void save(CInsZyysnxm cInsZyysnxm) {
		super.save(cInsZyysnxm);
	}
	
	@Transactional(readOnly = false)
	public void delete(CInsZyysnxm cInsZyysnxm) {
		super.delete(cInsZyysnxm);
	}
	
	
	
	
}