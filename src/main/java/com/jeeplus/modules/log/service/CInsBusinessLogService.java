/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.log.service;

import java.util.List;

import com.jeeplus.modules.log.vo.CInsBusinessXmjbxxLogVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.log.entity.CInsBusinessLog;
import com.jeeplus.modules.log.dao.CInsBusinessLogDao;

/**
 * 业务日志Service
 * @author zcl
 * @version 2017-11-14
 */
@Service
@Transactional(readOnly = true)
public class CInsBusinessLogService extends CrudService<CInsBusinessLogDao, CInsBusinessLog> {

	public CInsBusinessLog get(String id) {
		return super.get(id);
	}
	
	public List<CInsBusinessLog> findList(CInsBusinessLog cInsBusinessLog) {
		return super.findList(cInsBusinessLog);
	}
	
	public Page<CInsBusinessLog> findPage(Page<CInsBusinessLog> page, CInsBusinessLog cInsBusinessLog) {
		return super.findPage(page, cInsBusinessLog);
	}
	
	@Transactional(readOnly = false)
	public void save(CInsBusinessLog cInsBusinessLog) {
		super.save(cInsBusinessLog);
	}
	
	@Transactional(readOnly = false)
	public void delete(CInsBusinessLog cInsBusinessLog) {
		super.delete(cInsBusinessLog);
	}

	public Page<CInsBusinessXmjbxxLogVo> findPageByXmjbxxId(Page<CInsBusinessXmjbxxLogVo> page, CInsBusinessXmjbxxLogVo xmjbxxLogVo) {
		xmjbxxLogVo.setPage(page);
		page.setList(dao.findPageByXmjbxxId(xmjbxxLogVo));
		return page;
	}

	public Page<CInsBusinessLog> findXmjbxxBusinessLogPage(Page<CInsBusinessLog> page, CInsBusinessLog cInsBusinessLog) {
		cInsBusinessLog.setPage(page);
		page.setList(dao.findXmjbxxBusinessLogList(cInsBusinessLog));
		return page;
	}

	public List<CInsBusinessLog> findXmjbxxBusinessLogList(CInsBusinessLog log) {
		return dao.findXmjbxxBusinessLogList(log);
	}
}
