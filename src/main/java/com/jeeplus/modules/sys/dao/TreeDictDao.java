/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sys.dao;

import com.jeeplus.common.persistence.TreeDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.sys.entity.TreeDict;

import java.util.List;

/**
 * 符合规划DAO接口
 * @author yw
 * @version 2017-09-28
 */
@MyBatisDao
public interface TreeDictDao extends TreeDao<TreeDict> {

    List<TreeDict> findListByNameAndParentName(TreeDict treeDict);
}