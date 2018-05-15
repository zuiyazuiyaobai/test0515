/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.notice.dao;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.notice.entity.Notify;

/**
 * 通知通告DAO接口
 * @author jeeplus
 * @version 2014-05-16
 */
@MyBatisDao
public interface NotifyDao extends CrudDao<Notify> {
	
	/**
	 * 获取通知数目
	 * @param notify
	 * @return
	 */
	public Long findCount(Notify notify);
	
}