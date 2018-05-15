/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.task.dao;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.task.entity.CInsBusinessXmjbxxTaskRelation;
import com.jeeplus.modules.task.vo.XmjbxxTaskRelationSearchParameter;

import java.util.List;

import org.apache.ibatis.annotations.Param;
/**
 * 项目基本信息和调度任务关联表DAO接口
 * @author zcl
 * @version 2017-10-31
 */
@MyBatisDao
public interface CInsBusinessXmjbxxTaskRelationDao extends CrudDao<CInsBusinessXmjbxxTaskRelation> {

    List<CInsBusinessXmjbxxTaskRelation> findFullListByParameter(XmjbxxTaskRelationSearchParameter vo);
    
    List<CInsBusinessXmjbxxTaskRelation> findFullListByParameterTwo(XmjbxxTaskRelationSearchParameter vo);
    
    List<CInsBusinessXmjbxxTaskRelation> findFullListByParameterOne(XmjbxxTaskRelationSearchParameter vo);
    
    List<CInsBusinessXmjbxxTaskRelation> findFullPageByParameterfive(XmjbxxTaskRelationSearchParameter vo);
    
    List<CInsBusinessXmjbxxTaskRelation> findFullPageByParametersix(XmjbxxTaskRelationSearchParameter vo);
    
    //修改调出调度任务 中调度关联表的update_date 值，为了排序，不用save()方法  是因为实体类中时date类型 ，数据库中时varchar.
  	void updadate(@Param("id") String id,@Param("day") String day);
}