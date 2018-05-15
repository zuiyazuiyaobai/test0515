/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.gcjz.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.gcjz.entity.CInsBusinessGcjzqk;

/**
 * 工程进度 分市汇总DAO接口
 * @author gl
 * @version 2017-06-12
 */
@MyBatisDao
public interface CInsBusinessGcjzqkDao extends CrudDao<CInsBusinessGcjzqk> {
	/**
	 * 查找统计年份下拉框数据
	 * @return
	 */
	public List<String> findYears();
	/**
	 * 查找工程进展统计数量；
	 * @return
	 */
	public List<CInsBusinessGcjzqk> findGcjzqk(CInsBusinessGcjzqk cInsBusinessGcjzqk);
	/**
	 * 查找工程进展统计数量总计；
	 * @return
	 */
	public CInsBusinessGcjzqk findTotal(CInsBusinessGcjzqk cInsBusinessGcjzqk);
	/**
	 * 点击数据量查询项目信息
	 * @param cInsBusinessGcjzqk
	 * @return
	 */
//	public List<CInsBusinessGcjzqk> findXmInfo(CInsBusinessGcjzqk cInsBusinessGcjzqk);
	/**
	 * 查看进展情况分页
	 * @param page
	 * @param cInsBusinessGcjzqk
	 * @return
	 */
	public List<CInsBusinessGcjzqk> findJzqkList(CInsBusinessGcjzqk cInsBusinessGcjzqk);
	public Page<CInsBusinessGcjzqk> findJzqkPage(Page<CInsBusinessGcjzqk> page, CInsBusinessGcjzqk cInsBusinessGcjzqk);
	
}