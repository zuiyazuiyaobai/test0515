/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.service.sub;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.xmjbxx.entity.sub.CInsBusinessContact;
import com.jeeplus.modules.xmjbxx.dao.sub.CInsBusinessContactDao;

/**
 * 联系人信息Service
 * @author zcl
 * @version 2017-10-25
 */
@Service
@Transactional(readOnly = true)
public class CInsBusinessContactService extends CrudService<CInsBusinessContactDao, CInsBusinessContact> {

	public CInsBusinessContact get(String id) {
		return super.get(id);
	}
	
	public List<CInsBusinessContact> findList(CInsBusinessContact cInsBusinessContact) {
		return super.findList(cInsBusinessContact);
	}
	
	public Page<CInsBusinessContact> findPage(Page<CInsBusinessContact> page, CInsBusinessContact cInsBusinessContact) {
		return super.findPage(page, cInsBusinessContact);
	}
	
	@Transactional(readOnly = false)
	public void save(CInsBusinessContact cInsBusinessContact) {
		super.save(cInsBusinessContact);
	}
	
	@Transactional(readOnly = false)
	public void delete(CInsBusinessContact cInsBusinessContact) {
		super.delete(cInsBusinessContact);
	}
	
	
	
	
}