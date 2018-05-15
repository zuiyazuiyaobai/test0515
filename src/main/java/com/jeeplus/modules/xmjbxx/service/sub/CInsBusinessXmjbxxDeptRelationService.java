/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.service.sub;

import java.util.List;

import com.jeeplus.modules.sys.entity.Office;
import com.jeeplus.modules.xmjbxx.entity.Xmjbxx;
import com.jeeplus.modules.xmjbxx.vo.CInsBusinessXmjbxxDeptRelationSearchParameter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.xmjbxx.entity.sub.CInsBusinessXmjbxxDeptRelation;
import com.jeeplus.modules.xmjbxx.dao.sub.CInsBusinessXmjbxxDeptRelationDao;

/**
 * 项目部门关系Service
 * @author zcl
 * @version 2017-10-16
 */
@Service
@Transactional(readOnly = true)
public class CInsBusinessXmjbxxDeptRelationService extends CrudService<CInsBusinessXmjbxxDeptRelationDao, CInsBusinessXmjbxxDeptRelation> {

	public CInsBusinessXmjbxxDeptRelation get(String id) {
		return super.get(id);
	}

	public List<CInsBusinessXmjbxxDeptRelation> findList(CInsBusinessXmjbxxDeptRelation cInsBusinessXmjbxxDeptRelation) {
		return super.findList(cInsBusinessXmjbxxDeptRelation);
	}

	public Page<CInsBusinessXmjbxxDeptRelation> findPage(Page<CInsBusinessXmjbxxDeptRelation> page, CInsBusinessXmjbxxDeptRelation cInsBusinessXmjbxxDeptRelation) {
		return super.findPage(page, cInsBusinessXmjbxxDeptRelation);
	}

	public Page<CInsBusinessXmjbxxDeptRelation> findFullPageByParameter(Page<CInsBusinessXmjbxxDeptRelation> page, CInsBusinessXmjbxxDeptRelationSearchParameter parameter) {
		parameter.setPage(page);
		page.setList(dao.findFullListByParameter(parameter));
		return page;
	}

	public List<CInsBusinessXmjbxxDeptRelation> findFullListByParameter(CInsBusinessXmjbxxDeptRelationSearchParameter parameter) {
		return dao.findFullListByParameter(parameter);
	}
	public Page<CInsBusinessXmjbxxDeptRelation> findFullListByParametercbk(Page<CInsBusinessXmjbxxDeptRelation> page,CInsBusinessXmjbxxDeptRelationSearchParameter parameter) {
		parameter.setPage(page);
		page.setList(dao.findFullListByParametercbk(parameter));
		return page;
	}
	@Transactional(readOnly = false)
	public void save(CInsBusinessXmjbxxDeptRelation cInsBusinessXmjbxxDeptRelation) {
		super.save(cInsBusinessXmjbxxDeptRelation);
	}

	@Transactional(readOnly = false)
	public void delete(CInsBusinessXmjbxxDeptRelation cInsBusinessXmjbxxDeptRelation) {
		super.delete(cInsBusinessXmjbxxDeptRelation);
	}

	@Transactional(readOnly = false)
	public void addOrUpdateRelation(CInsBusinessXmjbxxDeptRelation relation) {
		CInsBusinessXmjbxxDeptRelation param = new CInsBusinessXmjbxxDeptRelation();
		param.setXmjbxx(relation.getXmjbxx());
		param.setDept(relation.getDept());
		param.setType(relation.getType());

		List<CInsBusinessXmjbxxDeptRelation> list = findList(param);
		if (list.isEmpty()) {
			save(relation);
		} else {
			CInsBusinessXmjbxxDeptRelation old = list.get(0);
			relation.setIsNewRecord(false);
			relation.setId(old.getId());
			save(relation);
		}
	}

	@Transactional(readOnly = false)
	public void deleteRelation(String xmid, String deptId, String type) {
		CInsBusinessXmjbxxDeptRelation param = new CInsBusinessXmjbxxDeptRelation();
		param.setXmjbxx(new Xmjbxx(xmid));
		param.setType(type);
		param.setDept(new Office(deptId));
		List<CInsBusinessXmjbxxDeptRelation> relations = findList(param);
		if (!relations.isEmpty()) {
			delete(relations.get(0));
		}
	}
}