/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.zdxmwtbj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.modules.zdxmwt.entity.CInsBusinessZdxmwt;
import com.jeeplus.modules.zdxmwtbj.dao.CInsBusinessZdxmwtbjDao;



/**
 * 重点项目已办结问题Service
 * @author gl
 * @version 2017-06-09
 */
@Service
@Transactional(readOnly = true)
public class CInsBusinessZdxmwtbjService extends CrudService<CInsBusinessZdxmwtbjDao, CInsBusinessZdxmwt> {

	
	public CInsBusinessZdxmwt get(String id) {
		CInsBusinessZdxmwt cInsBusinessZdxmwt = super.get(id);
		return cInsBusinessZdxmwt;
	}
	
	public List<CInsBusinessZdxmwt> findList(CInsBusinessZdxmwt cInsBusinessZdxmwt) {
		return super.findList(cInsBusinessZdxmwt);
	}
	
	public Page<CInsBusinessZdxmwt> findPage(Page<CInsBusinessZdxmwt> page, CInsBusinessZdxmwt cInsBusinessZdxmwt) {
		return super.findPage(page, cInsBusinessZdxmwt);
	}
	
	@Transactional(readOnly = false)
	public void save(CInsBusinessZdxmwt cInsBusinessZdxmwt) {
		super.save(cInsBusinessZdxmwt);
	}
	
	@Transactional(readOnly = false)
	public void delete(CInsBusinessZdxmwt cInsBusinessZdxmwt) {
		super.delete(cInsBusinessZdxmwt);
	}
	
	
}