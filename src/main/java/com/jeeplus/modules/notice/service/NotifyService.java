/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.notice.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.notice.dao.NotifyDao;
import com.jeeplus.modules.notice.dao.NotifyRecordDao;
import com.jeeplus.modules.notice.entity.Notify;
import com.jeeplus.modules.notice.entity.NotifyRecord;

/**
 * 通知通告Service
 * @author jeeplus
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class NotifyService extends CrudService<NotifyDao, Notify> {

	@Autowired
	private NotifyRecordDao notifyRecordDao;

	public Notify get(String id) {
		Notify entity = dao.get(id);
		return entity;
	}
	
	/**
	 * 获取通知发送记录
	 * @param notify
	 * @return
	 */
	public Notify getRecordList(Notify notify) {
		notify.setNotifyRecordList(notifyRecordDao.findList(new NotifyRecord(notify)));
		return notify;
	}
	
	public Page<Notify> find(Page<Notify> page, Notify notify) {
		notify.setPage(page);
		page.setList(dao.findList(notify));
		return page;
	}
	
	/**
	 * 获取通知数目
	 * @param notify
	 * @return
	 */
	public Long findCount(Notify notify) {
		return dao.findCount(notify);
	}
	
	@Transactional(readOnly = false)
	public void save(Notify notify) {
		super.save(notify);
		
		// 更新发送接受人记录
		notifyRecordDao.deleteByNotifyId(notify.getId());
		if (notify.getNotifyRecordList().size() > 0){
			notifyRecordDao.insertAll(notify.getNotifyRecordList());
		}
	}
	
	/**
	 * 更新阅读状态
	 */
	@Transactional(readOnly = false)
	public void updateReadFlag(Notify notify) {
		NotifyRecord notifyRecord = new NotifyRecord(notify);
		notifyRecord.setUser(notifyRecord.getCurrentUser());
		notifyRecord.setReadDate(new Date());
		notifyRecord.setReadFlag("1");
		notifyRecordDao.update(notifyRecord);
	}
}