/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.gcjz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.modules.gcjz.entity.CInsBusinessGcjzqk;
import com.jeeplus.modules.gcjz.dao.CInsBusinessGcjzqkDao;



/**
 * 工程进度 分市汇总Service
 * @author gl
 * @version 2017-06-12
 */
@Service
@Transactional(readOnly = true)
public class CInsBusinessGcjzqkService extends CrudService<CInsBusinessGcjzqkDao, CInsBusinessGcjzqk> {

	
	public CInsBusinessGcjzqk get(String id) {
		CInsBusinessGcjzqk cInsBusinessGcjzqk = super.get(id);
		return cInsBusinessGcjzqk;
	}
	
	public List<CInsBusinessGcjzqk> findList(CInsBusinessGcjzqk cInsBusinessGcjzqk) {
		return super.findList(cInsBusinessGcjzqk);
	}
	
	public Page<CInsBusinessGcjzqk> findPage(Page<CInsBusinessGcjzqk> page, CInsBusinessGcjzqk cInsBusinessGcjzqk) {
		return super.findPage(page, cInsBusinessGcjzqk);
	}
	
	@Transactional(readOnly = false)
	public void save(CInsBusinessGcjzqk cInsBusinessGcjzqk) {
		super.save(cInsBusinessGcjzqk);
	}
	
	@Transactional(readOnly = false)
	public void delete(CInsBusinessGcjzqk cInsBusinessGcjzqk) {
		super.delete(cInsBusinessGcjzqk);
	}
	/**
	 * 查找工程进展统计数量；
	 * @return
	 */
	public List<CInsBusinessGcjzqk> findGcjzqk(CInsBusinessGcjzqk cInsBusinessGcjzqk){
		return dao.findGcjzqk(cInsBusinessGcjzqk);
	}
	/**
	 * 查找工程进展统计数量总计；
	 * @return
	 */
	public CInsBusinessGcjzqk findTotal(CInsBusinessGcjzqk cInsBusinessGcjzqk){
		return dao.findTotal(cInsBusinessGcjzqk);
	}
	/**
	 * 查找统计年份下拉框数据
	 * @return
	 */
	public List<String> findYears(){
		return dao.findYears();
	}
	/**
	 * 查看进展情况分页
	 * @param page
	 * @param cInsBusinessGcjzqk
	 * @return
	 */
	public Page<CInsBusinessGcjzqk> findJzqkPage(Page<CInsBusinessGcjzqk> page, CInsBusinessGcjzqk cInsBusinessGcjzqk){
		cInsBusinessGcjzqk.setPage(page);
		page.setList(dao.findJzqkList(cInsBusinessGcjzqk));
		return page;
	}
}