/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.dao.sub;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.xmjbxx.entity.sub.CInsBusinessXmjbxxDeptRelation;
import com.jeeplus.modules.xmjbxx.vo.CInsBusinessXmjbxxDeptRelationSearchParameter;

import java.util.List;

/**
 * 项目部门关系DAO接口
 * @author zcl
 * @version 2017-10-16
 */
@MyBatisDao
public interface CInsBusinessXmjbxxDeptRelationDao extends CrudDao<CInsBusinessXmjbxxDeptRelation> {

    List<CInsBusinessXmjbxxDeptRelation> findFullListByParameter(CInsBusinessXmjbxxDeptRelationSearchParameter parameter);
    List<CInsBusinessXmjbxxDeptRelation> findFullListByParametercbk(CInsBusinessXmjbxxDeptRelationSearchParameter parameter);

}