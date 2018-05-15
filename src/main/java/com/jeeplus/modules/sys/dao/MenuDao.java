/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.sys.entity.Menu;

/**
 * 菜单DAO接口
 * @author jeeplus
 * @version 2014-05-16
 */
@MyBatisDao
public interface MenuDao extends CrudDao<Menu> {

	public List<Menu> findByParentIdsLike(Menu menu);

	public List<Menu> findByUserId(Menu menu);
	
	public int updateParentIds(Menu menu);
	
	public int updateSort(Menu menu);
	
    public List<Menu> getMainMenu();//获取一级菜单
	
	public List<Menu> getChildrenMenu(String parentId);//获取二级菜单
	//获取父级菜单
	public List<Menu> findByUserIdAndParentId(@Param("userId")String userId,@Param("parentId")String parentId );
	
	public List<Menu> findByAdmin(@Param("parentId")String parentId );
	
}
