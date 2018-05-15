/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessZjlb;
import com.jeeplus.modules.xmjbxx.dao.CInsBusinessZjlbDao;

/**
 * 基本信息中的投资情况资金类别关联表Service
 * @author yw
 * @version 2017-09-25
 */
@Service
@Transactional(readOnly = true)
public class CInsBusinessZjlbService extends CrudService<CInsBusinessZjlbDao, CInsBusinessZjlb> {

	public CInsBusinessZjlb get(String id) {
		return super.get(id);
	}
	
	public List<CInsBusinessZjlb> findList(CInsBusinessZjlb cInsBusinessZjlb) {
		return super.findList(cInsBusinessZjlb);
	}
	
	public Page<CInsBusinessZjlb> findPage(Page<CInsBusinessZjlb> page, CInsBusinessZjlb cInsBusinessZjlb) {
		return super.findPage(page, cInsBusinessZjlb);
	}
	
	@Transactional(readOnly = false)
	public void save(CInsBusinessZjlb cInsBusinessZjlb) {
		super.save(cInsBusinessZjlb);
	}
	
	@Transactional(readOnly = false)
	public void delete(CInsBusinessZjlb cInsBusinessZjlb) {
		super.delete(cInsBusinessZjlb);
	}
	
	
	
	
}