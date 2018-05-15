/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sys.service;

import java.util.List;

import com.jeeplus.common.service.TreeService;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.modules.sys.entity.TreeDict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.modules.sys.dao.TreeDictDao;

/**
 * 符合规划Service
 * @author yw
 * @version 2017-09-28
 */
@Service
@Transactional(readOnly = true)
public class TreeDictService extends TreeService<TreeDictDao, TreeDict> {

	public TreeDict get(String id) {
		return super.get(id);
	}

	public List<TreeDict> findList(TreeDict treeDict) {
		if (StringUtils.isNotBlank(treeDict.getParentIds())){
			treeDict.setParentIds(","+ treeDict.getParentIds()+",");
		}
		return super.findList(treeDict);
	}
	
	public Page<TreeDict> findPage(Page<TreeDict> page, TreeDict treeDict) {
		return super.findPage(page, treeDict);
	}
	
	@Transactional(readOnly = false)
	public void save(TreeDict treeDict) {
		super.save(treeDict);
	}
	
	@Transactional(readOnly = false)
	public void delete(TreeDict treeDict) {
		super.delete(treeDict);
	}
}