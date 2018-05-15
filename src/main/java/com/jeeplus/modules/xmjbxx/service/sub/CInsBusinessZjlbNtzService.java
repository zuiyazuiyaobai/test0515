/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.service.sub;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.xmjbxx.entity.sub.CInsBusinessZjlbNtz;
import com.jeeplus.modules.xmjbxx.dao.sub.CInsBusinessZjlbNtzDao;

/**
 * 资金需求Service
 * @author yw
 * @version 2017-09-25
 */
@Service
@Transactional(readOnly = true)
public class CInsBusinessZjlbNtzService extends CrudService<CInsBusinessZjlbNtzDao, CInsBusinessZjlbNtz> {

	public CInsBusinessZjlbNtz get(String id) {
		return super.get(id);
	}
	
	public List<CInsBusinessZjlbNtz> findList(CInsBusinessZjlbNtz cInsBusinessZjlbNtz) {
		return super.findList(cInsBusinessZjlbNtz);
	}
	
	public Page<CInsBusinessZjlbNtz> findPage(Page<CInsBusinessZjlbNtz> page, CInsBusinessZjlbNtz cInsBusinessZjlbNtz) {
		return super.findPage(page, cInsBusinessZjlbNtz);
	}
	
	@Transactional(readOnly = false)
	public void save(CInsBusinessZjlbNtz cInsBusinessZjlbNtz) {
		super.save(cInsBusinessZjlbNtz);
	}
	
	@Transactional(readOnly = false)
	public void delete(CInsBusinessZjlbNtz cInsBusinessZjlbNtz) {
		super.delete(cInsBusinessZjlbNtz);
	}
	
	
	
	
}