/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.zdxmwthf.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.zdxmwthf.entity.CInsBusinessZdxmwthf;
import com.jeeplus.modules.zdxmwthf.dao.CInsBusinessZdxmwthfDao;

/**
 * 重点项目问题回复Service
 * @author gl
 * @version 2017-06-06
 */
@Service
@Transactional(readOnly = true)
public class CInsBusinessZdxmwthfService extends CrudService<CInsBusinessZdxmwthfDao, CInsBusinessZdxmwthf> {

	public CInsBusinessZdxmwthf get(String id) {
		return super.get(id);
	}
	
	public List<CInsBusinessZdxmwthf> findList(CInsBusinessZdxmwthf cInsBusinessZdxmwthf) {
		return super.findList(cInsBusinessZdxmwthf);
	}
	
	public Page<CInsBusinessZdxmwthf> findPage(Page<CInsBusinessZdxmwthf> page, CInsBusinessZdxmwthf cInsBusinessZdxmwthf) {
		return super.findPage(page, cInsBusinessZdxmwthf);
	}
	
	@Transactional(readOnly = false)
	public void save(CInsBusinessZdxmwthf cInsBusinessZdxmwthf) {
		super.save(cInsBusinessZdxmwthf);
	}
	
	@Transactional(readOnly = false)
	public void delete(CInsBusinessZdxmwthf cInsBusinessZdxmwthf) {
		super.delete(cInsBusinessZdxmwthf);
	}
	
	
	
	
}