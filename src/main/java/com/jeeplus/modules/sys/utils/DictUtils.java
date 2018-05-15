/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sys.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import com.jeeplus.common.config.Global;
import com.jeeplus.modules.sys.entity.Area;
import com.jeeplus.modules.sys.entity.Office;
import com.jeeplus.modules.sys.service.AreaService;
import com.jeeplus.modules.sys.service.OfficeService;
import com.jeeplus.modules.sys.dao.TreeDictDao;
import com.jeeplus.modules.sys.entity.TreeDict;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jeeplus.common.utils.CacheUtils;
import com.jeeplus.common.utils.SpringContextHolder;
import com.jeeplus.modules.sys.dao.DictDao;
import com.jeeplus.modules.sys.entity.Dict;

/**
 * 字典工具类
 * @author jeeplus
 * @version 2013-5-29
 */
public class DictUtils {
	
	private static DictDao dictDao = SpringContextHolder.getBean(DictDao.class);

	private static TreeDictDao treeDictDao = SpringContextHolder.getBean(TreeDictDao.class);

	private static OfficeService officeService = SpringContextHolder.getBean(OfficeService.class);

	private static AreaService areaService = SpringContextHolder.getBean(AreaService.class);

	public static final String CACHE_DICT_MAP = "dictMap";
	
	public static String getDictLabel(String value, String type, String defaultValue){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)){
			for (Dict dict : getDictList(type)){
				if (type.equals(dict.getType()) && value.equals(dict.getValue())){
					return dict.getLabel();
				}
			}
		}
		return defaultValue;
	}

	public static String getDictLabels(String values, String type, String defaultValue){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(values)){
			List<String> valueList = Lists.newArrayList();
			for (String value : StringUtils.split(values, ",")){
				valueList.add(getDictLabel(value, type, defaultValue));
			}
			return StringUtils.join(valueList, ",");
		}
		return defaultValue;
	}

	public static String getDictValue(String label, String type, String defaultLabel){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)){
			for (Dict dict : getDictList(type)){
				if (type.equals(dict.getType()) && label.equals(dict.getLabel())){
					return dict.getValue();
				}
			}
		}
		return defaultLabel;
	}

	public static List<Dict> getDictList(String type){
		@SuppressWarnings("unchecked")
		Map<String, List<Dict>> dictMap = (Map<String, List<Dict>>)CacheUtils.get(CACHE_DICT_MAP);
		if (dictMap==null){
			dictMap = Maps.newHashMap();
			for (Dict dict : dictDao.findAllList(new Dict())){
				List<Dict> dictList = dictMap.get(dict.getType());
				if (dictList != null){
					dictList.add(dict);
				}else{
					dictMap.put(dict.getType(), Lists.newArrayList(dict));
				}
			}
			CacheUtils.put(CACHE_DICT_MAP, dictMap);
		}
		List<Dict> dictList = dictMap.get(type);
		if (dictList == null){
			dictList = Lists.newArrayList();
		}
		return dictList;
	}

	/*
	 * 反射根据对象和属性名获取属性值
	 */
	public static Object getValue(Object obj, String filed) {
		try {
			Class clazz = obj.getClass();
			PropertyDescriptor pd = new PropertyDescriptor(filed, clazz);
			Method getMethod = pd.getReadMethod();//获得get方法

			if (pd != null) {

				Object o = getMethod.invoke(obj);//执行get方法返回一个Object
				return o;

			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	//根据树型字典的id获取对应的名称
	public static String getTreeDictValue(String id){
		if (StringUtils.isNotBlank(id)){
			TreeDict tree = treeDictDao.get(id);
			if (null != tree) {
				return tree.getName();
			}
		}
		return "";
	}

	/**
	 * 根据树 code 和 type 获取对应的树型字典 ID
	 * 如果找到多个则返回第一个的 ID ，否则返回空字符串
 	 */
	public static String getTreeDictIdByTypeAndCode(String code, String type){
		TreeDict parameter = new TreeDict();
		parameter.setCode(code);
		parameter.setType(type);
		List<TreeDict> treeDictList = treeDictDao.findList(parameter);
		if (treeDictList.isEmpty()) {
			return "";
		}else {
			return treeDictList.get(0).getId();
		}
	}

	//根据树id和树的类型获取对应的名称
	public static String getTreeName(String id, String treeType){
		if (StringUtils.isNotBlank(id)){
			if ("area".equals(treeType)) {
				Area tree = areaService.get(id);
				if (null != tree) {
					return tree.getName();
				}
			}
		}
		return "";
	}

	//获取
	public static List<Office> getOfficeListByParam(String showIds, String extId){
		List<Office> result = Lists.newArrayList();
		List<Office> list = officeService.findAll();
		for (int i=0; i<list.size(); i++){
			Office e = list.get(i);
			if ((com.jeeplus.common.utils.StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1))
					&& (com.jeeplus.common.utils.StringUtils.isBlank(showIds) || (showIds!=null && (showIds.equals(e.getId()) || includeParents(showIds,e.getId()) || includeParents(showIds, e.getParentIds()))))
					&& Global.YES.equals(e.getUseable())){
				result.add(e);
			}
		}
		return result;
	}

	private static boolean includeParents(String showIds, String parentIds){
		String[] showIdsArr = showIds.split(",");
		for (String id : showIdsArr) {
			if (parentIds.indexOf(id) > -1) {
				return true;
			}
		}
		return false;
	}
}
