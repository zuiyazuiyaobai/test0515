/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessZdxmk;
import com.jeeplus.modules.xmjbxx.dao.CInsBusinessZdxmkDao;

/**
 * 其他（省基建5818重点项目）Service
 * @author @zhu
 * @version 2017-12-02
 */
@Service
@Transactional(readOnly = true)
public class CInsBusinessZdxmkService extends CrudService<CInsBusinessZdxmkDao, CInsBusinessZdxmk> {

	public CInsBusinessZdxmk get(String id) {
		return super.get(id);
	}
	
	public List<CInsBusinessZdxmk> findList(CInsBusinessZdxmk cInsBusinessZdxmk) {
		return super.findList(cInsBusinessZdxmk);
	}
	
	public Page<CInsBusinessZdxmk> findPage(Page<CInsBusinessZdxmk> page, CInsBusinessZdxmk cInsBusinessZdxmk) {
		return super.findPage(page, cInsBusinessZdxmk);
	}
	
	@Transactional(readOnly = false)
	public void save(CInsBusinessZdxmk cInsBusinessZdxmk) {
		super.save(cInsBusinessZdxmk);
	}
	
	@Transactional(readOnly = false)
	public void delete(CInsBusinessZdxmk cInsBusinessZdxmk) {
		super.delete(cInsBusinessZdxmk);
	}
	
	
	
	
}