/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.zdxmwt.dao;

import java.util.List;
import java.util.Map;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.zdxmwt.entity.CInsBusinessZdxmwt;

/**
 * 重点项目存在问题DAO接口
 * @author gl
 * @version 2017-06-06
 */
@MyBatisDao
public interface CInsBusinessZdxmwtDao extends CrudDao<CInsBusinessZdxmwt> {
	
	public List<Map<String,Object>> findAreaList(String id);
}