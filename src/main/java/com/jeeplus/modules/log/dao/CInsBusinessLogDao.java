/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.log.dao;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.log.entity.CInsBusinessLog;
import com.jeeplus.modules.log.vo.CInsBusinessXmjbxxLogVo;

import java.util.List;

/**
 * 业务日志DAO接口
 * @author zcl
 * @version 2017-11-14
 */
@MyBatisDao
public interface CInsBusinessLogDao extends CrudDao<CInsBusinessLog> {

	List<CInsBusinessXmjbxxLogVo> findPageByXmjbxxId(CInsBusinessXmjbxxLogVo xmjbxxLogVo);

	List<CInsBusinessLog> findXmjbxxBusinessLogList(CInsBusinessLog cInsBusinessLog);

}