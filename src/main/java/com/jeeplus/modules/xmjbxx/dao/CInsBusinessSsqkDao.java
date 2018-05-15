/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.task.entity.CInsBusinessSchedulerTask;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessSsqk;

/**
 * 实施情况DAO接口
 * @author zcl
 * @version 2017-11-03
 */
@MyBatisDao
public interface CInsBusinessSsqkDao extends CrudDao<CInsBusinessSsqk> {
	 //根据项目基本信息获取反馈情况
	 List<CInsBusinessSsqk> getSsqkByXmjbxxid(@Param("xmjbxxid") String xmjbxxid);
	 
	 //根据ssqkid获取反馈情况实施情况信息
	 List<CInsBusinessSsqk> findfkqkssxxbyssqkid(@Param("ssqkid") String ssqkid);
	
}