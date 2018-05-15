/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.dao;

import java.util.List;
import java.util.Map;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessTzqk;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessZdxmk;
import com.jeeplus.modules.xmjbxx.entity.CompanyJbxx;

/**
 * 其他（省基建5818重点项目）DAO接口
 * @author @zhu
 * @version 2017-12-02
 */
@MyBatisDao
public interface CompanyJbxxDao extends CrudDao<CompanyJbxx> {
	List<Map<String,Object>> getCompanyJbxx(Map<String, String> map);
	
}