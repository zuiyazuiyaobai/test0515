/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.zdxmwtqk.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.zdxmwthf.entity.CInsBusinessZdxmwthf;

/**
 * 重点项目问题决绝情况DAO接口
 * @author gl
 * @version 2017-06-07
 */
@MyBatisDao
public interface CInsBusinessZdxmwtqkDao extends CrudDao<CInsBusinessZdxmwthf> {
	//查看问题解决情况
	public List<CInsBusinessZdxmwthf> findWthqkById(String id);
	
}