/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.qtxm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.qtxm.entity.CInsJbxm;
import com.jeeplus.modules.qtxm.dao.CInsJbxmDao;

/**
 * 其他项目Service
 * @author zgl
 * @version 2017-12-02
 */
@Service
@Transactional(readOnly = true)
public class CInsJbxmService extends CrudService<CInsJbxmDao, CInsJbxm> {

	public CInsJbxm get(String id) {
		return super.get(id);
	}
	
	public List<CInsJbxm> findList(CInsJbxm cInsJbxm) {
		return super.findList(cInsJbxm);
	}
	
	public Page<CInsJbxm> findPage(Page<CInsJbxm> page, CInsJbxm cInsJbxm) {
		return super.findPage(page, cInsJbxm);
	}
	
	@Transactional(readOnly = false)
	public void save(CInsJbxm cInsJbxm) {
		super.save(cInsJbxm);
	}
	
	@Transactional(readOnly = false)
	public void delete(CInsJbxm cInsJbxm) {
		super.delete(cInsJbxm);
	}
	
	
	
	
}