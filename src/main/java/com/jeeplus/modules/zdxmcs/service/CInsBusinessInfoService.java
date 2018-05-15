/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.zdxmcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.modules.zdxmcs.entity.CInsBusinessInfo;
import com.jeeplus.modules.zdxmcs.dao.CInsBusinessInfoDao;



/**
 * 重点工程基本信息表Service
 * @author tys
 * @version 2017-05-11
 */
@Service
@Transactional(readOnly = true)
public class CInsBusinessInfoService extends CrudService<CInsBusinessInfoDao, CInsBusinessInfo> {

	
	public CInsBusinessInfo get(String id) {
		CInsBusinessInfo cInsBusinessInfo = super.get(id);
		return cInsBusinessInfo;
	}
	
	public List<CInsBusinessInfo> findList(CInsBusinessInfo cInsBusinessInfo) {
		return super.findList(cInsBusinessInfo);
	}
	
	public Page<CInsBusinessInfo> findPage(Page<CInsBusinessInfo> page, CInsBusinessInfo cInsBusinessInfo) {
		return super.findPage(page, cInsBusinessInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(CInsBusinessInfo cInsBusinessInfo) {
		super.save(cInsBusinessInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(CInsBusinessInfo cInsBusinessInfo) {
		super.delete(cInsBusinessInfo);
	}
	
	
}