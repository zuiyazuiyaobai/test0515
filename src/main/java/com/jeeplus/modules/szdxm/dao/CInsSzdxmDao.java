/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.szdxm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.szdxm.entity.CInsSzdxm;

/**
 * 重点项目DAO接口
 * @author zgl
 * @version 2017-12-01
 */
@MyBatisDao
public interface CInsSzdxmDao extends CrudDao<CInsSzdxm> {
	
	public List<Map<String,Object>>  findPageByhylb(@Param("hylb") String hylb);
	
	public List<Map<String,Object>>  findPageByhylb2(@Param("hylb") String hylb);
	
}