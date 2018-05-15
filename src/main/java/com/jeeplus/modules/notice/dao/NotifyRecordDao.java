/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.notice.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.notice.entity.NotifyRecord;

/**
 * 通知通告记录DAO接口
 * @author jeeplus
 * @version 2014-05-16
 */
@MyBatisDao
public interface NotifyRecordDao extends CrudDao<NotifyRecord> {

	/**
	 * 插入通知记录
	 * @param NotifyRecordList
	 * @return
	 */
	public int insertAll(List<NotifyRecord> NotifyRecordList);
	
	/**
	 * 根据通知ID删除通知记录
	 * @param oaNotifyId 通知ID
	 * @return
	 */
	public int deleteByNotifyId(String notifyId);
	
}