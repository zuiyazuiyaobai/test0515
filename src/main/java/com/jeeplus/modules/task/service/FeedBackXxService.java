/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.task.service;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.task.dao.FeedBackXxDao;
import com.jeeplus.modules.task.entity.FeedBackXx;
/**
 * 其他（省基建5818重点项目）Service
 * @author @zhu
 * @version 2017-12-02
 */
@Service
@Transactional(readOnly = true)
public class FeedBackXxService extends CrudService<FeedBackXxDao, FeedBackXx> {
	
	
}