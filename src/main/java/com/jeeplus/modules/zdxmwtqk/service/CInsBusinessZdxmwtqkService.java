/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.zdxmwtqk.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.zdxmwthf.entity.CInsBusinessZdxmwthf;
import com.jeeplus.modules.zdxmwtqk.dao.CInsBusinessZdxmwtqkDao;

/**
 * 重点项目问题决绝情况Service
 * @author gl
 * @version 2017-06-07
 */
@Service
@Transactional(readOnly = true)
public class CInsBusinessZdxmwtqkService extends CrudService<CInsBusinessZdxmwtqkDao, CInsBusinessZdxmwthf> {

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
	public List<CInsBusinessZdxmwthf> findWthqkById(String id){
		return dao.findWthqkById(id);
	}
	
	
	
}