/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.dkxmxx.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.dkxmxx.entity.Dkxmxx;
import com.jeeplus.modules.dkxmxx.dao.DkxmxxDao;

/**
 * 打捆项目Service
 * @author gyf
 * @version 2018-03-22
 */
@Service
@Transactional(readOnly = true)
public class DkxmxxService extends CrudService<DkxmxxDao, Dkxmxx> {

	public Dkxmxx get(String id) {
		return super.get(id);
	}
	
	public List<Dkxmxx> findList(Dkxmxx dkxmxx) {
		return super.findList(dkxmxx);
	}
	
	public Page<Dkxmxx> findPage(Page<Dkxmxx> page, Dkxmxx dkxmxx) {
		return super.findPage(page, dkxmxx);
	}
	
	@Transactional(readOnly = false)
	public void save(Dkxmxx dkxmxx) {
		super.save(dkxmxx);
	}
	
	@Transactional(readOnly = false)
	public void delete(Dkxmxx dkxmxx) {
		super.delete(dkxmxx);
	}
	
	
	
	
}