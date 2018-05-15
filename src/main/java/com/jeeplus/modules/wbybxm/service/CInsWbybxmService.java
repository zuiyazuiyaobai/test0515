/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.wbybxm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.wbybxm.entity.CInsWbybxm;
import com.jeeplus.modules.wbybxm.dao.CInsWbybxmDao;
import com.jeeplus.modules.zyysnxm.entity.CInsZyysnxm;

/**
 * 5818项目Service
 * @author zgl
 * @version 2017-12-02
 */
@Service
@Transactional(readOnly = true)
public class CInsWbybxmService extends CrudService<CInsWbybxmDao, CInsWbybxm> {

	public CInsWbybxm get(String id) {
		return super.get(id);
	}
	
	public List<CInsWbybxm> findList(CInsWbybxm cInsWbybxm) {
		return super.findList(cInsWbybxm);
	}
	
	public Page<CInsWbybxm> findPage(Page<CInsWbybxm> page, CInsWbybxm cInsWbybxm) {
		return super.findPage(page, cInsWbybxm);
	}
	
	@Transactional(readOnly = false)
	public void save(CInsWbybxm cInsWbybxm) {
		super.save(cInsWbybxm);
	}
	
	@Transactional(readOnly = false)
	public void delete(CInsWbybxm cInsWbybxm) {
		super.delete(cInsWbybxm);
	}
	
	
	
	
}