/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.syssms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.syssms.entity.SysSms;
import com.jeeplus.modules.syssms.dao.SysSmsDao;

/**
 * 短信发送Service
 * @author zgl
 * @version 2017-12-12
 */
@Service
@Transactional(readOnly = true)
public class SysSmsService extends CrudService<SysSmsDao, SysSms> {

	public SysSms get(String id) {
		return super.get(id);
	}
	
	public List<SysSms> findList(SysSms sysSms) {
		return super.findList(sysSms);
	}
	
	public Page<SysSms> findPage(Page<SysSms> page, SysSms sysSms) {
		return super.findPage(page, sysSms);
	}
	
	@Transactional(readOnly = false)
	public void save(SysSms sysSms) {
		super.save(sysSms);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysSms sysSms) {
		super.delete(sysSms);
	}
	
	
	
	
}