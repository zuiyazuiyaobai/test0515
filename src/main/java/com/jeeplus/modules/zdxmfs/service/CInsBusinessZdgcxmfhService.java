/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.zdxmfs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.modules.zdxmcs.entity.CInsBusinessZdgcxm;
import com.jeeplus.modules.zdxmfs.dao.CInsBusinessZdgcxmfhDao;



/**
 * 重点项目复审菜单Service
 * @author gl
 * @version 2017-06-05
 */
@Service
@Transactional(readOnly = true)
public class CInsBusinessZdgcxmfhService extends CrudService<CInsBusinessZdgcxmfhDao, CInsBusinessZdgcxm> {

	
	public CInsBusinessZdgcxm get(String id) {
		CInsBusinessZdgcxm cInsBusinessZdgcxm = super.get(id);
		return cInsBusinessZdgcxm;
	}
	
	public List<CInsBusinessZdgcxm> findList(CInsBusinessZdgcxm cInsBusinessZdgcxm) {
		return super.findList(cInsBusinessZdgcxm);
	}
	
	public Page<CInsBusinessZdgcxm> findPage(Page<CInsBusinessZdgcxm> page, CInsBusinessZdgcxm cInsBusinessZdgcxm) {
		return super.findPage(page, cInsBusinessZdgcxm);
	}
	
	@Transactional(readOnly = false)
	public void save(CInsBusinessZdgcxm cInsBusinessZdgcxm) {
		super.save(cInsBusinessZdgcxm);
	}
	
	@Transactional(readOnly = false)
	public void delete(CInsBusinessZdgcxm cInsBusinessZdgcxm) {
		super.delete(cInsBusinessZdgcxm);
	}
	
	
}