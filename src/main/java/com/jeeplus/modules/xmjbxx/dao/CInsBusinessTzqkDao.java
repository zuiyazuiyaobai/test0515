/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessTzqk;

/**
 * 基本信息中的投资情况DAO接口
 * @author yw
 * @version 2017-09-25
 */
@MyBatisDao
public interface CInsBusinessTzqkDao extends CrudDao<CInsBusinessTzqk> {
	
	List<CInsBusinessTzqk> getall(String xmid);
}