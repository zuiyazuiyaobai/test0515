/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.zdxmwt.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.zdxmwt.entity.CInsBusinessZdxmwt;
import com.jeeplus.modules.zdxmwt.dao.CInsBusinessZdxmwtDao;

/**
 * 重点项目存在问题Service
 * @author gl
 * @version 2017-06-06
 */
@Service
@Transactional(readOnly = true)
public class CInsBusinessZdxmwtService extends CrudService<CInsBusinessZdxmwtDao, CInsBusinessZdxmwt> {

	public CInsBusinessZdxmwt get(String id) {
		return super.get(id);
	}
	
	public List<CInsBusinessZdxmwt> findList(CInsBusinessZdxmwt cInsBusinessZdxmwt) {
		return super.findList(cInsBusinessZdxmwt);
	}
	
	public Page<CInsBusinessZdxmwt> findPage(Page<CInsBusinessZdxmwt> page, CInsBusinessZdxmwt cInsBusinessZdxmwt) {
		return super.findPage(page, cInsBusinessZdxmwt);
	}
	public Page<CInsBusinessZdxmwt> findWtList(Page<CInsBusinessZdxmwt> page, CInsBusinessZdxmwt cInsBusinessZdxmwt) {
		return super.findWtList(page, cInsBusinessZdxmwt);
	}
	public Page<CInsBusinessZdxmwt> findWtqkList(Page<CInsBusinessZdxmwt> page, CInsBusinessZdxmwt cInsBusinessZdxmwt) {
		return super.findWtqkList(page, cInsBusinessZdxmwt);
	}
	
	@Transactional(readOnly = false)
	public void save(CInsBusinessZdxmwt cInsBusinessZdxmwt) {
		super.save(cInsBusinessZdxmwt);
	}
	
	@Transactional(readOnly = false)
	public void delete(CInsBusinessZdxmwt cInsBusinessZdxmwt) {
		super.delete(cInsBusinessZdxmwt);
	}
	public List<Map<String,Object>> findAreaList(String id){
		return dao.findAreaList(id);
	}
	
	
	
}