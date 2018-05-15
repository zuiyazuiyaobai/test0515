/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.dao;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.xmjbxx.entity.Xmjbxx;
import com.jeeplus.modules.xmjbxx.vo.XmjbxxSearchParameter;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 项目基本信息DAO接口
 * @author yanwen
 * @version 2017-09-12
 */
@MyBatisDao
public interface XmjbxxDao extends CrudDao<Xmjbxx> {

	List<Xmjbxx> findFullListByParameter(XmjbxxSearchParameter xmjbxxSearchParameter);
	List<Xmjbxx> findFullListByParameterjh(XmjbxxSearchParameter xmjbxxSearchParameter);
	List<Xmjbxx> findFullListByParameteryj(XmjbxxSearchParameter xmjbxxSearchParameter);
	List<Xmjbxx> findFullListByParameterdxfs(Xmjbxx xmjbxx);
	List<Xmjbxx> findFullListByParameterdxtj(Map map);
	List<Map<String, String>> findNumber(XmjbxxSearchParameter xmjbxxSearchParameter);
	List<Map<String, String>> findNumberBySshy(XmjbxxSearchParameter xmjbxxSearchParameter);
	/**
	 * 根据监管平台代码返回唯一一条记录，非模糊查询
	 */
	Xmjbxx getCInsBusinessInfo(@Param("spjgptdm") String spjgptdm, @Param("lxphoneone") String lxphoneone);

	/**
	 * 通过视图获取投资平台的国别行业列表
	 */
	List<Map<String, String>> findTzptGbhyList();

	/**
	 * 通过 sortCode 获取国别行业
	 * @return
	 */
	Map<String, String> getTzptGbhy(@Param("sortCode") String sortCode);

	/**
	 * 通过视图获取投资平台的国别行业列表
	 */
	List<Map<String, String>> findTzptSshyList();

	/**
	 * 通过 sortCode 获取国别行业
	 * @return
	 */
	Map<String, String> getTzptSshy(@Param("sortCode") String sortCode);
	
	/**
	 * 通过 sortCode 获取获取上报部门
	 * @return
	 */
	List getSbbmByXmjbxx(@Param("xmjbxxid") String xmjbxxid);
	/**
	 * 通过 sortCode 通过userid查找name
	 * @return
	 */
	List getnamebyuserid(@Param("userid") String userid);
}