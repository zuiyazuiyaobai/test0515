/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.syssms.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.syssms.entity.SysSms;
import com.jeeplus.modules.xmjbxx.entity.Xmjbxx;
import com.jeeplus.modules.xmjbxx.vo.XmjbxxSearchParameter;

/**
 * 短信发送DAO接口
 * @author zgl
 * @version 2017-12-12
 */
@MyBatisDao
public interface SysSmsDao extends CrudDao<SysSms> {
	List<SysSms> findFullListByParameter(SysSms sysSms);
	
}