/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.tj_sszdgjxmxx.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.tj_sszdgjxmxx.entity.Tj_sszdgjxmxx;
import com.jeeplus.modules.tj_sszdgjxmxx.dao.Tj_sszdgjxmxxDao;

/**
 * tj_sszdgjxmxxService
 * @author zgl
 * @version 2018-03-17
 */
@Service
@Transactional(readOnly = true)
public class Tj_sszdgjxmxxService extends CrudService<Tj_sszdgjxmxxDao, Tj_sszdgjxmxx> {

	public Tj_sszdgjxmxx get(String id) {
		return super.get(id);
	}
	
	public List<Tj_sszdgjxmxx> findList(Tj_sszdgjxmxx tj_sszdgjxmxx) {
		return super.findList(tj_sszdgjxmxx);
	}
	
	public Page<Tj_sszdgjxmxx> findPage(Page<Tj_sszdgjxmxx> page, Tj_sszdgjxmxx tj_sszdgjxmxx) {
		return super.findPage(page, tj_sszdgjxmxx);
	}
	
	@Transactional(readOnly = false)
	public void save(Tj_sszdgjxmxx tj_sszdgjxmxx) {
		super.save(tj_sszdgjxmxx);
	}
	
	@Transactional(readOnly = false)
	public void delete(Tj_sszdgjxmxx tj_sszdgjxmxx) {
		super.delete(tj_sszdgjxmxx);
	}
	
	
	
	
}