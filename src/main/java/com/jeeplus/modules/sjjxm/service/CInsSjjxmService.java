/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sjjxm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.sjjxm.entity.CInsSjjxm;
import com.jeeplus.modules.sjjxm.dao.CInsSjjxmDao;

/**
 * 省基建项目Service
 * @author zgl
 * @version 2017-12-02
 */
@Service
@Transactional(readOnly = true)
public class CInsSjjxmService extends CrudService<CInsSjjxmDao, CInsSjjxm> {

	public CInsSjjxm get(String id) {
		return super.get(id);
	}
	
	public List<CInsSjjxm> findList(CInsSjjxm cInsSjjxm) {
		return super.findList(cInsSjjxm);
	}
	
	public Page<CInsSjjxm> findPage(Page<CInsSjjxm> page, CInsSjjxm cInsSjjxm) {
		return super.findPage(page, cInsSjjxm);
	}
	
	@Transactional(readOnly = false)
	public void save(CInsSjjxm cInsSjjxm) {
		super.save(cInsSjjxm);
	}
	
	@Transactional(readOnly = false)
	public void delete(CInsSjjxm cInsSjjxm) {
		super.delete(cInsSjjxm);
	}
	
	
	
	
}