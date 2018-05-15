/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sys.service;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.service.CrudService;
import com.jeeplus.common.utils.CacheUtils;
import com.jeeplus.modules.sys.dao.DictDao;
import com.jeeplus.modules.sys.entity.Dict;
import com.jeeplus.modules.sys.utils.DictUtils;

/**
 * 字典Service
 * @author jeeplus
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class DictService extends CrudService<DictDao, Dict> {
	
	/**
	 * 查询字段类型列表
	 * @return
	 */
	public List<String> findTypeList(){
		return dao.findTypeList(new Dict());
	}

	/**
	 * 查询字段类型列表
	 * @return
	 */
	public List<Dict> findDictList(){
		List<Dict> dictList = dao.findList(new Dict());
		List<Dict> result = new ArrayList<Dict>();
		Map<String, Dict> resultMap = new HashMap<String, Dict>();
		for (Dict dict : dictList) {
			resultMap.put(dict.getType(), dict);
		}
		for (String name : resultMap.keySet()) {
			result.add(resultMap.get(name));
		}
		//排个序
		Collections.sort(result, new Comparator<Dict>() {
			@Override
			public int compare(Dict o1, Dict o2) {
				return o1.getType().compareTo(o2.getType());
			}
		});
		return result;
	}

	@Transactional(readOnly = false)
	public void save(Dict dict) {
		super.save(dict);
		CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}

	@Transactional(readOnly = false)
	public void delete(Dict dict) {
		super.delete(dict);
		CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}

}
