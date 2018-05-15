/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.task.dao;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.task.entity.FeedBackXx;

import java.util.List;

/**
 * 项目基本信息和调度任务关联表DAO接口
 * @author zcl
 * @version 2017-10-31
 */
@MyBatisDao
public interface FeedBackXxDao extends CrudDao<FeedBackXx> {
}