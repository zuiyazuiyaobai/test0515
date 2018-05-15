/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.szdxm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.szdxm.entity.CInsSzdxm;
import com.jeeplus.modules.szdxm.dao.CInsSzdxmDao;

/**
 * 重点项目Service
 * @author zgl
 * @version 2017-12-01
 */
@Service
@Transactional(readOnly = true)
public class CInsSzdxmService extends CrudService<CInsSzdxmDao, CInsSzdxm> {

	public CInsSzdxm get(String id) {
		return super.get(id);
	}
	
	public List<CInsSzdxm> findList(CInsSzdxm cInsSzdxm) {
		return super.findList(cInsSzdxm);
	}
	
	public Page<CInsSzdxm> findPage(Page<CInsSzdxm> page, CInsSzdxm cInsSzdxm) {
		return super.findPage(page, cInsSzdxm);
	}
	
	public List<Map<String,Object>>  findPageByhylb(String hylb) {
		List<Map<String,Object>> list = dao.findPageByhylb(hylb);
		return list;
	}
	public List<Map<String,Object>>  findListByhylb(String hylb) {
		List<Map<String,Object>> list = dao.findPageByhylb(hylb);
		List<Map<String,Object>> hylblist = new ArrayList<Map<String,Object>>();
		Map<String, Object> map1 = Maps.newHashMap();
		System.out.println(list.size());
		Float zjtatal =(float) 0.0;
		Float ttndljwc = (float) 0.0;
		Float yddyljwntz = (float) 0.0;
		Float zjxq = (float) 0.0;
		Map<String,Object> map=null;
		for(int i=0;i<list.size();i++){
			map = list.get(i);
			zjtatal += Float.parseFloat( map.get("ZTZ").toString());
			System.out.println(map.get("NDLJWC"));
			ttndljwc +=  Float.parseFloat((String) map.get("NDLJWC"));
			System.out.println(map.get("zjxq")==null? 0:map.get("zjxq"));
			zjxq += Float.parseFloat( (map.get("zjxq")==null? 0:map.get("zjxq")).toString());
			System.out.println(map.get("zyysntz_jzbbgljwcjj")==null? 0:map.get("zyysntz_jzbbgljwcjj"));
			yddyljwntz += Float.parseFloat( (map.get("zyysntz_jzbbgljwcjj")==null? 0:map.get("zyysntz_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("qtzyczxjszj_jzbbgljwcjj")==null? 0:map.get("qtzyczxjszj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("zxzqmjjszj_jzbbgljwcjj")==null? 0:map.get("zxzqmjjszj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("zysljszj_jzbbgljwcjj")==null? 0:map.get("zysljszj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("nsbdgczj_jzbbgljwcjj")==null? 0:map.get("nsbdgczj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("tljszxzj_jzbbgljwcjj")==null? 0:map.get("tljszxzj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("mhfzzj_jzbbgljwcjj")==null? 0:map.get("mhfzzj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("gjzdslgcjszj_jzbbgljwcjj")==null? 0:map.get("gjzdslgcjszj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("dzxskymhqfczj_jzbbgljwcjj")==null? 0:map.get("dzxskymhqfczj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("dzxskymhqfcjyzj_jzbbgljwcjj")==null? 0:map.get("dzxskymhqfcjyzj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("glgkjszj_jzbbgljwcjj")==null? 0:map.get("glgkjszj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("sjysntz_jzbbgljwcjj")==null? 0:map.get("sjysntz_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("cityjysntz_jzbbgljwcjj")==null? 0:map.get("cityjysntz_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("xjysntz_jzbbgljwcjj")==null? 0:map.get("xjysntz_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("sjczzj_jzbbgljwcjj")==null? 0:map.get("sjczzj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("cityjczzj_jzbbgljwcjj")==null? 0:map.get("cityjczzj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("xjczzj_jzbbgljwcjj")==null? 0:map.get("xjczzj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("dfzxjszj_jzbbgljwcjj")==null? 0:map.get("dfzxjszj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("qyzytz_jzbbgljwcjj")==null? 0:map.get("qyzytz_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("lywz_jzbbgljwcjj")==null? 0:map.get("lywz_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("yhdk_jzbbgljwcjj")==null? 0:map.get("yhdk_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("zjqddd_jzbbgljwcjj")==null? 0:map.get("zjqddd_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("qtzj_jzbbgljwcjj")==null? 0:map.get("qtzj_jzbbgljwcjj")).toString());
		}
		System.out.println(zjtatal);
		System.out.println(ttndljwc);
		System.out.println(yddyljwntz);
		map1.put("ztz", zjtatal);
		map1.put("ttndljwc", ttndljwc);
		map1.put("zjxq", zjxq);
		map1.put("yddyljwntz", yddyljwntz);
		hylblist.add(map1);
		return hylblist;
	}
	public List<Map<String,Object>>  findListByhylb2(String hylb) {
		List<Map<String,Object>> list = dao.findPageByhylb2(hylb);
		List<Map<String,Object>> hylblist = new ArrayList<Map<String,Object>>();
		Map<String, Object> map1 = Maps.newHashMap();
		Float yddyljwntz = (float) 0.0;
		Map<String,Object> map=null;
		for(int i=0;i<list.size();i++){
			map = list.get(i);
			System.out.println(map.get("zyysntz_jzbbgljwcjj")==null? 0:map.get("zyysntz_jzbbgljwcjj"));
			yddyljwntz += Float.parseFloat( (map.get("zyysntz_jzbbgljwcjj")==null? 0:map.get("zyysntz_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("qtzyczxjszj_jzbbgljwcjj")==null? 0:map.get("qtzyczxjszj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("zxzqmjjszj_jzbbgljwcjj")==null? 0:map.get("zxzqmjjszj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("zysljszj_jzbbgljwcjj")==null? 0:map.get("zysljszj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("nsbdgczj_jzbbgljwcjj")==null? 0:map.get("nsbdgczj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("tljszxzj_jzbbgljwcjj")==null? 0:map.get("tljszxzj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("mhfzzj_jzbbgljwcjj")==null? 0:map.get("mhfzzj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("gjzdslgcjszj_jzbbgljwcjj")==null? 0:map.get("gjzdslgcjszj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("dzxskymhqfczj_jzbbgljwcjj")==null? 0:map.get("dzxskymhqfczj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("dzxskymhqfcjyzj_jzbbgljwcjj")==null? 0:map.get("dzxskymhqfcjyzj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("glgkjszj_jzbbgljwcjj")==null? 0:map.get("glgkjszj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("sjysntz_jzbbgljwcjj")==null? 0:map.get("sjysntz_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("cityjysntz_jzbbgljwcjj")==null? 0:map.get("cityjysntz_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("xjysntz_jzbbgljwcjj")==null? 0:map.get("xjysntz_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("sjczzj_jzbbgljwcjj")==null? 0:map.get("sjczzj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("cityjczzj_jzbbgljwcjj")==null? 0:map.get("cityjczzj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("xjczzj_jzbbgljwcjj")==null? 0:map.get("xjczzj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("dfzxjszj_jzbbgljwcjj")==null? 0:map.get("dfzxjszj_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("qyzytz_jzbbgljwcjj")==null? 0:map.get("qyzytz_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("lywz_jzbbgljwcjj")==null? 0:map.get("lywz_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("yhdk_jzbbgljwcjj")==null? 0:map.get("yhdk_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("zjqddd_jzbbgljwcjj")==null? 0:map.get("zjqddd_jzbbgljwcjj")).toString());
			yddyljwntz += Float.parseFloat( (map.get("qtzj_jzbbgljwcjj")==null? 0:map.get("qtzj_jzbbgljwcjj")).toString());
		}
		System.out.println(yddyljwntz);
		map1.put("yddyljwntz", yddyljwntz);
		hylblist.add(map1);
		return hylblist;
	}
	
	@Transactional(readOnly = false)
	public void save(CInsSzdxm cInsSzdxm) {
		super.save(cInsSzdxm);
	}
	
	@Transactional(readOnly = false)
	public void delete(CInsSzdxm cInsSzdxm) {
		super.delete(cInsSzdxm);
	}
	
	
	
	
}