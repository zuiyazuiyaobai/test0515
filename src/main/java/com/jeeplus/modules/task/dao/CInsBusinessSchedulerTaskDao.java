/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.task.dao;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.task.entity.CInsBusinessSchedulerTask;
import com.jeeplus.modules.task.entity.CInsBusinessXmjbxxTaskRelation;
import com.jeeplus.modules.task.vo.SchedulerTaskSearchParameter;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessSsqk;
import com.jeeplus.modules.xmjbxx.entity.Xmjbxx;
import com.jeeplus.modules.xmjbxx.entity.sub.CInsBusinessXmjbxxDeptRelation;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 调度任务DAO接口
 * @author zcl
 * @version 2017-10-31
 */
@MyBatisDao
public interface CInsBusinessSchedulerTaskDao extends CrudDao<CInsBusinessSchedulerTask> {

    List<CInsBusinessSchedulerTask> findFullListByParameter(SchedulerTaskSearchParameter parameter);

	/**
	 * 通过 根据xmjbxxid在实施情况表中查询是否有记录
	 * @param xmjbxxid 
	 * @return
	 */
	
	List<Map<String, String>> getCountByXmjbxxid(@Param("xmjbxxid") String xmjbxxid);
	/**
	 * 向实施情况表中添加记录 id xmjbxx_id
	 * @param xmjbxxid 
	 * @return
	 */
	void insertSsqkJl(@Param("ssqkid") String ssqkid,@Param("xmjbxxid") String xmjbxxid);
	/**
	 * 根据xmjbxx_id在实施情况表中查询
	 * @param xmjbxxid 
	 * @return
	 */
	List<CInsBusinessSsqk> getSsqkByXmjbxxid(@Param("xmjbxxid") String xmjbxxid);
	
	/**
	 * 根据xmjbxx_id在实施情况表中更新任务类型
	 * @param xmjbxxid 
	 * @return 
	 * @return
	 */
	 void saveRwlxByXmjbxxid(@Param("xmjbxx_id") String xmjbxx_id,@Param("rwlx") String rwlx);
	 
	 /**
		 * 根据xmjbxx_id查询任务类型
		 * @param xmjbxxid 
		 * @return 
		 * @return
		 */
	 List<Xmjbxx> findListByXmjbxxid(@Param("xmjbxxid") String xmjbxxid);
	 //根据项目基本信息获取历史下达情况
	 List<CInsBusinessSchedulerTask> findLsxdListByXmjbxxid(@Param("xmjbxxid") String xmjbxxid);
	 
	 /**
		 * 根据调度任务表的id，来设置wdddrwdc字段的值.
		 * @param xmjbxxid 
		 * @return 
		 * @return
		 */
	 void setdcrw(@Param("taskid") String taskid);
	 
	 
}