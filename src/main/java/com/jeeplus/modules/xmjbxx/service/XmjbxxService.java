/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.service;

import com.haike.sms.api.beans.SmsSendBean;
import com.haike.sms.api.beans.SmsSendRespBean;
import com.haike.sms.api.test.APIClient;
import com.haike.sms.api.test.SMSUtils;
import com.haike.sms.api.util.ApiConstant;
import com.jeeplus.common.config.Global;
import com.jeeplus.common.config.GlobalParameter;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.utils.SpringContextHolder;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.modules.log.entity.CInsBusinessLog;
import com.jeeplus.modules.log.utils.BusinessLogUtils;
import com.jeeplus.modules.sys.dao.TreeDictDao;
import com.jeeplus.modules.sys.entity.Area;
import com.jeeplus.modules.sys.entity.Office;
import com.jeeplus.modules.sys.entity.TreeDict;
import com.jeeplus.modules.sys.service.AreaService;
import com.jeeplus.modules.sys.service.OfficeService;
import com.jeeplus.modules.sys.utils.DictUtils;
import com.jeeplus.modules.sys.utils.UserUtils;
import com.jeeplus.modules.syssms.entity.SysSms;
import com.jeeplus.modules.syssms.service.SysSmsService;
import com.jeeplus.modules.xmjbxx.dao.XmjbxxDao;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessQqgz;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessTzqk;
import com.jeeplus.modules.xmjbxx.entity.Xmjbxx;
import com.jeeplus.modules.xmjbxx.entity.sub.CInsBusinessXmgs;
import com.jeeplus.modules.xmjbxx.entity.sub.CInsBusinessXmjbxxDeptRelation;
import com.jeeplus.modules.xmjbxx.entity.sub.CInsBusinessZjlbNtz;
import com.jeeplus.modules.xmjbxx.service.sub.CInsBusinessXmgsService;
import com.jeeplus.modules.xmjbxx.service.sub.CInsBusinessXmjbxxDeptRelationService;
import com.jeeplus.modules.xmjbxx.service.sub.CInsBusinessZjlbNtzService;
import com.jeeplus.modules.xmjbxx.vo.CInsBusinessXmjbxxDeptRelationSearchParameter;
import com.jeeplus.modules.xmjbxx.vo.XmjbxxSearchParameter;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目基本信息Service
 * @author yanwen
 * @version 2017-09-12
 */
@Service
@Transactional(readOnly = true)
public class XmjbxxService extends CrudService<XmjbxxDao, Xmjbxx> {

	@Autowired
	private OfficeService officeService;

	@Autowired
	private AreaService areaService;

	@Autowired
	private SysSmsService sysSmsService;

	@Autowired
	private CInsBusinessTzqkService cInsBusinessTzqkService;

	@Autowired
	private CInsBusinessZjlbNtzService cInsBusinessZjlbNtzService;

	@Autowired
	private CInsBusinessQqgzService cInsBusinessQqgzService;

	@Autowired
	private CInsBusinessXmgsService cInsBusinessXmgsService;

	@Autowired
	private CInsBusinessXmjbxxDeptRelationService relationService;

	public Page<Xmjbxx> findFullPageByParameter(Page<Xmjbxx> page, XmjbxxSearchParameter param) {
		param.setPage(page);
		page.setList(dao.findFullListByParameter(param));
		return page;
	}
	
	public Page<Xmjbxx> findFullPageByParameteryj(Page<Xmjbxx> page, XmjbxxSearchParameter param) {
		param.setPage(page);
		page.setList(dao.findFullListByParameteryj(param));
		return page;
	}
	public Page<Xmjbxx> findFullPageByParameterdxfs(Page<Xmjbxx> page, XmjbxxSearchParameter param) {
		param.setPage(page);
		page.setList(dao.findFullListByParameteryj(param));
		return page;
	}
	
	public Page<Xmjbxx> findFullPageByParameterjh(Page<Xmjbxx> page, XmjbxxSearchParameter param) {
		param.setPage(page);
		page.setList(dao.findFullListByParameterjh(param));
		return page;
	}
	
	public List<Xmjbxx> findWshListByParameter(XmjbxxSearchParameter param) {		
		List<Xmjbxx> list = dao.findFullListByParameterjh(param);
		return list;
	}
	//统计图按所属行业查询
		public List<Map<String, String>> findNumberBySshy(XmjbxxSearchParameter xmjbxxSearchParameter) {	
			List<Map<String, String>> list = dao.findNumberBySshy(xmjbxxSearchParameter);
			return list;
		}
	//统计图按地区查询
	public List<Map<String, String>> findNumber(XmjbxxSearchParameter xmjbxxSearchParameter) {	
		List<Map<String, String>> list = dao.findNumber(xmjbxxSearchParameter);
		return list;
	}
	
	@Transactional(readOnly = false)
	public void addXmjbxx(Xmjbxx xmjbxx) throws Exception {
		//添加或更新项目基本信息
		if (StringUtils.isBlank(xmjbxx.getId())) {
			//初始化信息
			xmjbxx.setStage(Xmjbxx.STAGE_XMCB);
			xmjbxx.setCj(UserUtils.getUserGrade());
			xmjbxx.setShbm(UserUtils.getUser().getOffice());
			xmjbxx.setZt(Xmjbxx.ZT_XMCB_BS);
			xmjbxx.setDfzbsf("无");
			xmjbxx.setSfppp(Global.NO);//是否PPP默认为否
			xmjbxx.setSfth(Global.NO);
			xmjbxx.setSzt(Xmjbxx.SZT_WS);
			xmjbxx.setCreateByName(UserUtils.getUser().getName());
			this.save(xmjbxx);//保存

			// 保存业务日志
			BusinessLogUtils.saveLog(xmjbxx, CInsBusinessLog.OPERATE_XMJBXX_ADD, CInsBusinessLog.TYPE_CBBB);

			//添加 项目-部门-填报 关系
			CInsBusinessXmjbxxDeptRelation relation = new CInsBusinessXmjbxxDeptRelation();
			relation.setDept(UserUtils.getUser().getOffice());
			relation.setType(CInsBusinessXmjbxxDeptRelation.TYPE_TB);
			relation.setXmjbxx(xmjbxx);
			relationService.addOrUpdateRelation(relation);
		} else {
			// 判断是否允许编辑
			if (!isEditable(xmjbxx.getId())) {
				throw new RuntimeException(GlobalParameter.SZT_NOT_EDITABLE);
			}

			this.save(xmjbxx);//保存

			// 保存业务日志
			BusinessLogUtils.saveLog(xmjbxx, CInsBusinessLog.OPERATE_XMJBXX_EDITE, CInsBusinessLog.TYPE_CBBB);
		}

	}

	@Transactional(readOnly = false)
	public void saveXmjbxxTzqk(Xmjbxx xmjbxx) throws Exception {
		try {
			Xmjbxx oldXmjbxx = get(xmjbxx.getId());
			oldXmjbxx.setSfsqzxjsjj(xmjbxx.getSfsqzxjsjj());
			save(oldXmjbxx);

			CInsBusinessTzqk tzqkParam = new CInsBusinessTzqk();
			tzqkParam.setXmjbxx(xmjbxx);
			List<CInsBusinessTzqk> tzqkList = cInsBusinessTzqkService.findList(tzqkParam);
			List<CInsBusinessTzqk> tzqks = xmjbxx.getTzqks();
			if (tzqkList.isEmpty()) {
				for (CInsBusinessTzqk tzqk : tzqks) {
					tzqk.setXmjbxx(xmjbxx);
					tzqk.setSort(tzqks.indexOf(tzqk));
					cInsBusinessTzqkService.save(tzqk);

					if ((null != tzqk.getZjxqs() && tzqk.getZjxqs().size() < 3) || (null != tzqk.getNtz() && tzqk.getNtz().size() < 2)) {
						logger.error(tzqk.toString());
						logger.error(tzqk.getZjxqs().toString());
						logger.error(tzqk.getNtz().toString());
						logger.error("年投资数量不对！数据保存出错！");
						throw new RuntimeException("年投资数量不对！数据保存出错！");
					}
					saveXmjbxxTzqkZbjqk(tzqk.getNtz(), tzqk.getId(), CInsBusinessZjlbNtz.TYPE_ZBJQK);
					saveXmjbxxTzqkZbjqk(tzqk.getZjxqs(), tzqk.getId(), CInsBusinessZjlbNtz.TYPE_ZJXQ);
				}
			} else {
				for (int i = 0; i < tzqks.size(); i++) {
					CInsBusinessTzqk newTzqk = tzqks.get(i);
					CInsBusinessTzqk oldTzqk = tzqkList.get(i);
					if (!oldTzqk.getZjlb().equals(newTzqk.getZjlb())) {
						logger.error("资金类别不对应！数据保存出错！");
						throw new RuntimeException("资金类别不对应！数据保存出错！");
					}

					MyBeanUtils.copyBeanNotNull2Bean(newTzqk, oldTzqk);
					oldTzqk.setIsNewRecord(false);
					cInsBusinessTzqkService.save(oldTzqk);

					if ((null != newTzqk.getZjxqs() && newTzqk.getZjxqs().size() < 3) || (null != newTzqk.getNtz() && newTzqk.getNtz().size() < 2)) {
						logger.error(newTzqk.toString());
						logger.error(newTzqk.getZjxqs().toString());
						logger.error(newTzqk.getNtz().toString());
						logger.error("年投资数量不对！数据保存出错！");
						throw new RuntimeException("年投资数量不对！数据保存出错！");
					}

					saveXmjbxxTzqkZbjqk(newTzqk.getNtz(), oldTzqk.getId(), CInsBusinessZjlbNtz.TYPE_ZBJQK);
					saveXmjbxxTzqkZbjqk(newTzqk.getZjxqs(), oldTzqk.getId(), CInsBusinessZjlbNtz.TYPE_ZJXQ);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getStackTrace().toString());
		}
	}

	@Transactional(readOnly = false)
	public void saveXmjbxxQqgz(Xmjbxx xmjbxx) throws Exception {
		try {
			CInsBusinessQqgz qqgzParam = new CInsBusinessQqgz();
			qqgzParam.setXmjbxx(xmjbxx);
			List<CInsBusinessQqgz> qqgzList = cInsBusinessQqgzService.findList(qqgzParam);
			List<CInsBusinessQqgz> qqgzs = xmjbxx.getQqgzs();
			if (qqgzList.isEmpty()) {
				for (CInsBusinessQqgz qqgz : qqgzs) {
					qqgz.setXmjbxx(xmjbxx);
					qqgz.setSort(qqgzs.indexOf(qqgz));
					cInsBusinessQqgzService.save(qqgz);
				}
			} else {
				for (int i = 0; i < qqgzs.size(); i++) {
					CInsBusinessQqgz newQqgz = qqgzs.get(i);
					CInsBusinessQqgz oldQqgz = qqgzList.get(i);
					if (!oldQqgz.getSpsx().equals(newQqgz.getSpsx())) {
						throw new RuntimeException("审批事项不对应！数据保存出错！");
					}

					oldQqgz.setPfdw(newQqgz.getPfdw());
					oldQqgz.setPfsj(newQqgz.getPfsj());
					oldQqgz.setPfwjbt(newQqgz.getPfwjbt());
					oldQqgz.setPfwh(newQqgz.getPfwh());
					oldQqgz.setPfzt(newQqgz.getPfzt());
					cInsBusinessQqgzService.save(oldQqgz);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getStackTrace().toString());
		}
	}

	@Transactional(readOnly = false)
	public void saveSfPPP(Xmjbxx xmjbxx) throws Exception {
		try {
			Xmjbxx oldXmjbxx = get(xmjbxx.getId());
			if (null != oldXmjbxx) {
				MyBeanUtils.copyBeanNotNull2Bean(xmjbxx, oldXmjbxx);

				save(oldXmjbxx);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getStackTrace().toString());
		}
	}

	@Transactional(readOnly = false)
	public void saveXmjbxxQtxx(Xmjbxx xmjbxx) throws Exception {
		try {
			Xmjbxx oldXmjbxx = get(xmjbxx.getId());
			if (null != oldXmjbxx) {
				MyBeanUtils.copyBeanNotNull2Bean(xmjbxx, oldXmjbxx);
				save(oldXmjbxx);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getStackTrace().toString());
		}
	}

	@Transactional(readOnly = false)
	public void saveXmjbxxDfzb(Xmjbxx xmjbxx) throws Exception {
		try {
			Xmjbxx oldXmjbxx = get(xmjbxx.getId());
			if (null != oldXmjbxx) {
				MyBeanUtils.copyBeanNotNull2Bean(xmjbxx, oldXmjbxx);
				save(oldXmjbxx);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getStackTrace().toString());
		}
	}

	@Transactional(readOnly = false)
	public void saveXmjbxxTzqkZbjqk(List<CInsBusinessZjlbNtz> newNtzList, String tzqkId, String type) throws Exception {
		//如果年投资是空的，则跳过，不保存
		if (null == newNtzList || newNtzList.isEmpty()) {
			return;
		}

		CInsBusinessZjlbNtz ntzParam = new CInsBusinessZjlbNtz();
		ntzParam.setTzqk(new CInsBusinessTzqk(tzqkId));
		ntzParam.setType(type);
		List<CInsBusinessZjlbNtz> ntzList = cInsBusinessZjlbNtzService.findList(ntzParam);
		if (ntzList.isEmpty()) {
			for (CInsBusinessZjlbNtz ntz : newNtzList) {
				ntz.setTzqk(new CInsBusinessTzqk(tzqkId));
				ntz.setType(type);
				ntz.setYear(getYear(newNtzList.indexOf(ntz)));
				ntz.setSort(newNtzList.indexOf(ntz));
				cInsBusinessZjlbNtzService.save(ntz);
			}
		} else {
			for (int i = 0; i < ntzList.size(); i++) {
				CInsBusinessZjlbNtz ntz = ntzList.get(i);
				CInsBusinessZjlbNtz newNtz = newNtzList.get(i);
				if (!ntz.getYear().equals(getYear(ntzList.indexOf(ntz)))) {
					throw new RuntimeException("年份不对应！数据保存出错！");
				}
				ntz.setJe(newNtz.getJe());
				cInsBusinessZjlbNtzService.save(ntz);
			}
		}
	}

	private String getYear(Integer index) {
		switch (index) {
			case 0:
				return "2017";
			case 1:
				return "2018";
			case 2:
				return "2019";
			case 3:
				return "2010";
			default:
				return "2017";
		}
	}

	//回显投资情况
	@Transactional(readOnly = false)
	public List<CInsBusinessTzqk> huixianTzqk(Xmjbxx xmjbxx) {
		String xmjbxxId = xmjbxx.getId();
		List<CInsBusinessTzqk> tzqks = new ArrayList<CInsBusinessTzqk>();
		if (xmjbxxId != null) {
			//投资情况
			CInsBusinessTzqk tzqkParam = new CInsBusinessTzqk();
			tzqkParam.setXmjbxx(xmjbxx);
			List<CInsBusinessTzqk> tzqkList = cInsBusinessTzqkService.findList(tzqkParam);
			for (CInsBusinessTzqk tzqk : tzqkList) {
				CInsBusinessZjlbNtz ntz = new CInsBusinessZjlbNtz();
				ntz.setTzqk(tzqk);
				ntz.setType(CInsBusinessZjlbNtz.TYPE_ZBJQK);
				List<CInsBusinessZjlbNtz> ntzs = cInsBusinessZjlbNtzService.findList(ntz);
				ntz.setType(CInsBusinessZjlbNtz.TYPE_ZJXQ);
				List<CInsBusinessZjlbNtz> zjxqs = cInsBusinessZjlbNtzService.findList(ntz);
				tzqk.setNtz(ntzs);
				tzqk.setZjxqs(zjxqs);
				tzqks.add(tzqk);
			}
		}
		return tzqks;
	}

    /**
     * 批量项目加锁
     * @param ids
     */
	@Transactional(readOnly = false)
	public void jiaSuo(String ids) {
		String[] idsArr = ids.split(",");
		for (String id : idsArr) {
			Xmjbxx xmjbxx = get(id);
            jiaSuo(xmjbxx);
        }
	}

    /**
	 * 根据项目当前层级加锁
	 *
     * 需要保证 Xmjbxx 中读取到 cj 属性的信息，否则抛出异常
     * 加锁只能高级锁覆盖低级锁，否则抛出异常；
	 * 如果需要降低锁等级，需要先解锁，再加锁
     */
	@Transactional(readOnly = false)
	public void jiaSuo(Xmjbxx xmjbxx) throws RuntimeException {
        String cj = xmjbxx.getCj();
        if (StringUtils.isBlank(cj)) {
            logger.error("项目（" + xmjbxx.getXmmc() + "[" + xmjbxx.getId() + "]）无法获取层级，加锁失败！");
            throw new RuntimeException("加锁失败！");
        }

        // 加锁只能高级锁覆盖低级锁，否则报错
		String szt = xmjbxx.getSzt();
		if (StringUtils.isNotBlank(szt) && Integer.parseInt(szt) > Integer.parseInt(cj)) {
			logger.error("项目（" + xmjbxx.getXmmc() + "[" + xmjbxx.getId() + "]）锁等级高于项目层级[" + cj + "]，加锁失败！");
			throw new RuntimeException("加锁失败！");
		} else if (StringUtils.isNotBlank(szt) && szt.equals(cj)) {// 项目处于当前层级锁定状态
			return;
		}

		xmjbxx.setSzt(cj);//加项目当前层级的锁
        save(xmjbxx);

		String type = Xmjbxx.STAGE_JHBZ.equals(xmjbxx.getStage()) ? CInsBusinessLog.TYPE_JHBB : CInsBusinessLog.TYPE_CBBB;
		BusinessLogUtils.saveLog(xmjbxx, CInsBusinessLog.OPERATE_XMJBXX_JIASUO, type);
	}

    /**
     * 批量解锁
     */
	@Transactional(readOnly = false)
	public void jieSuo(String ids) {
		String[] id = ids.split(",");
		for (String id1 : id) {
			Xmjbxx xmjbxx = get(id1);
			jieSuo(xmjbxx);
		}
	}

    /**
     * 解锁
     * 需要解锁人（当前登录用户）的所属单位的层级高于或等于当前的锁等级，才能进行解锁操作
     */
	@Transactional(readOnly = false)
	public void jieSuo(Xmjbxx xmjbxx) {
        String grade = UserUtils.getUserGrade();
        if (StringUtils.isBlank(grade)) {
            logger.error("获取当前登录用户（" + UserUtils.getUser().getName() + "[" + UserUtils.getUser().getId() + "]）的层级，解锁失败！");
            throw new RuntimeException("无法获取当前登录用户的层级，解锁失败！");
        }

        String szt = xmjbxx.getSzt();
		if (StringUtils.isBlank(szt) || Xmjbxx.SZT_WS.equals(szt)) {
			return;// 未加锁，但是某些操作会出发解锁操作，所以在这里直接返回
		}

        int gradeInt = Integer.parseInt(grade);
        int sztInt = Integer.parseInt(szt);
        if (gradeInt < sztInt) {
            logger.error("当前登录用户（" + UserUtils.getUser().getName() + "[" + UserUtils.getUser().getId() + "]）" +
                    "层级低于项目[" + xmjbxx.getId() + "]szt:" + xmjbxx.getSzt() + "锁等级，无法解锁！");
            throw new RuntimeException("锁等级高于用户层级，解锁失败！");
        }

        xmjbxx.setSzt(Xmjbxx.SZT_WS);
        save(xmjbxx);

		String type = Xmjbxx.STAGE_JHBZ.equals(xmjbxx.getStage()) ? CInsBusinessLog.TYPE_CBBB : CInsBusinessLog.TYPE_JHBB;
		BusinessLogUtils.saveLog(xmjbxx, CInsBusinessLog.OPERATE_XMJBXX_JIESUO, type);
	}

	/**
	 * 更新锁状态，解锁之后根据项目层级重新加锁
	 * 项目加了当前层级锁，退回到下级，下级无法解除高层级锁的问题
	 * @param xmjbxx
	 */
	public void updateSzt(Xmjbxx xmjbxx){
		jieSuo(xmjbxx);
		jiaSuo(xmjbxx);
	}

	/**
	 * 批量同步储备项目（纳入三年滚动计划）
	 */
	@Transactional(readOnly = false)
	public void nrsngdjh(String ids,String bslb,String bswh) {
		String[] idsArr = ids.split(",");
		for (String id : idsArr) {
			Xmjbxx xmjbxx = get(id);
			nrsngdjh(xmjbxx,bslb,bswh);
		}
	}

	/**
	 * 储备库-删除
	 */
	@Transactional(readOnly = false)
	public void cbxmCbkDelete(String ids) {
		String[] idsArr = ids.split(",");
		for (String id : idsArr) {
			relationService.deleteRelation(id, UserUtils.getUser().getOffice().getId(), CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
		}
	}


	/**
	 * 同步储备项目（纳入三年滚动计划）
	 */
	@Transactional(readOnly = false)
	public void nrsngdjh(Xmjbxx xmjbxx,String bslb,String bswh) {
		// 查询当前层级是否已有三年滚动计划
		CInsBusinessXmjbxxDeptRelation param = new CInsBusinessXmjbxxDeptRelation();
		param.setType(CInsBusinessXmjbxxDeptRelation.TYPE_SNGDJH);
		param.setXmjbxx(xmjbxx);
		param.setDept(UserUtils.getUser().getOffice());
		List<CInsBusinessXmjbxxDeptRelation> relations = relationService.findList(param);
		CInsBusinessXmjbxxDeptRelation relation = new CInsBusinessXmjbxxDeptRelation();
		if (relations.isEmpty()) {
			relation.setXmjbxx(xmjbxx);
			relation.setDept(UserUtils.getUser().getOffice());
			relation.setType(CInsBusinessXmjbxxDeptRelation.TYPE_SNGDJH);
			relation.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_WTX);
			relation.setRemarks(bslb);
			if(null!=bswh){
				relation.setBswh(bswh);
			}
			relationService.addOrUpdateRelation(relation);

			// 保存业务日志
			BusinessLogUtils.saveLog(xmjbxx, CInsBusinessLog.OPERATE_XMJBXX_NRGDJH, CInsBusinessLog.TYPE_JHBB);
		}

		// 更新三年滚动计划和储备库的状态
		updateCbkAndSngdjh(xmjbxx,bslb,bswh);

		// 纳入储备库自动加锁
        //jiaSuo(xmjbxx);
    }

	/**
	 * 更新该项目的三年滚动计划和储备库的相关状态
	 * @param xmjbxx
	 */
	private void updateCbkAndSngdjh(Xmjbxx xmjbxx,String bslb,String bswh) {
		CInsBusinessXmjbxxDeptRelation parameter = new CInsBusinessXmjbxxDeptRelation();
		parameter.setXmjbxx(new Xmjbxx(xmjbxx.getId()));
		parameter.setDept(UserUtils.getUserOffice());
		parameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_SNGDJH);
		List<CInsBusinessXmjbxxDeptRelation> relationList = relationService.findList(parameter);
		if (relationList.isEmpty()) {
			throw new RuntimeException();
		}
		CInsBusinessXmjbxxDeptRelation relation = relationList.get(0);

		// 设置是否已上报
		String cj = xmjbxx.getCj();
		String grade = UserUtils.getUserGrade();
		// 是否已上报，如果层级大于当前层级，已上报
		if (Integer.parseInt(cj) > Integer.parseInt(grade)) {
			relation.setZt(CInsBusinessXmjbxxDeptRelation.ZT_SNGDJH_YBS);
		}else{
			relation.setZt(CInsBusinessXmjbxxDeptRelation.ZT_SNGDJH_WBS);
		}
		relation.setRemarks(bslb);
		relation.setBswh(bswh);
		relationService.save(relation);

		// 更新 储备库是否已上报的状态
		parameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
		List<CInsBusinessXmjbxxDeptRelation> cbkRelationList = relationService.findList(parameter);
		if (!cbkRelationList.isEmpty()) {
			CInsBusinessXmjbxxDeptRelation cbkRelation = cbkRelationList.get(0);
			cbkRelation.setZt(relation.getZt());
			cbkRelation.setRemarks(bslb);
			cbkRelation.setBswh(bswh);
			relationService.save(cbkRelation);
		}
	}

	/**
	 * 批量同步储备项目（纳入三年滚动计划）
	 */
	@Transactional(readOnly = false)
	public void sngdjhToCbk(String ids) {
		String[] idsArr = ids.split(",");
		for (String id : idsArr) {
			Xmjbxx xmjbxx = get(id);
			sngdjhToCbk(xmjbxx);
		}
	}

	/**
	 * 批量 三年滚动计划退回待报区
	 */
	@Transactional(readOnly = false)
	public void sngdjhThdbq(String ids) {
		String[] idsArr = ids.split(",");
		for (String id : idsArr) {
			Xmjbxx xmjbxx = get(id);
			xmjbxx.setZt(Xmjbxx.ZT_XMCB_CBK);
			xmjbxx.setCj(UserUtils.getUserGrade());
			xmjbxx.setStage(Xmjbxx.STAGE_XMCB);
			save(xmjbxx);

			//删除 三年滚动计划 记录
			CInsBusinessXmjbxxDeptRelation relationParam = getRelationParam(id);
			List<CInsBusinessXmjbxxDeptRelation> relations = relationService.findList(relationParam);
			for (CInsBusinessXmjbxxDeptRelation relation : relations) {
				relationService.delete(relation);
			}
		}
	}

	/**
	 * 批量 三年滚动计划 转办
	 */
	@Transactional(readOnly = false)
	public void sngdjhZb(String ids, String officeId) {
		String[] idsArr = ids.split(",");
		for (String id : idsArr) {
			//删除旧关系
			CInsBusinessXmjbxxDeptRelation relationParam = getRelationParam(id);
			List<CInsBusinessXmjbxxDeptRelation> relations = relationService.findList(relationParam);
			CInsBusinessXmjbxxDeptRelation delRelation = relations.get(0);
			relationService.delete(delRelation);

			//添加新关系
			Office office = new Office(officeId);
			relationParam.setDept(office);
			List<CInsBusinessXmjbxxDeptRelation> sngdjhRelations = relationService.findList(relationParam);
			if (sngdjhRelations.isEmpty()) {
				CInsBusinessXmjbxxDeptRelation relation = new CInsBusinessXmjbxxDeptRelation();
				relation.setDept(office);
				relation.setType(CInsBusinessXmjbxxDeptRelation.TYPE_SNGDJH);
				relation.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_WTX);
				relation.setZt(delRelation.getZt());
				relation.setXmjbxx(new Xmjbxx(id));
				relationService.save(relation);
			}

			// 添加业务日志
			BusinessLogUtils.saveLog(get(id), CInsBusinessLog.OPERATE_XMJBXX_ZHUANBAN, CInsBusinessLog.TYPE_JHBB, office);
		}
	}

	/**
	 * 批量 三年滚动计划 撤回
	 */
	@Transactional(readOnly = false)
	public void sngdjhCh(String ids, String chyy) {
		String[] idsArr = ids.split(",");
		for (String id : idsArr) {
			//删除旧关系
			CInsBusinessXmjbxxDeptRelation relationParam = getRelationParam(id);
			List<CInsBusinessXmjbxxDeptRelation> relations = relationService.findList(relationParam);
			for (CInsBusinessXmjbxxDeptRelation relation : relations) {
				relationService.delete(relation);
			}

			//添加新关系
			relationParam.setType(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
			List<CInsBusinessXmjbxxDeptRelation> sngdjhRelations = relationService.findList(relationParam);
			if (sngdjhRelations.isEmpty()) {
				CInsBusinessXmjbxxDeptRelation relation = new CInsBusinessXmjbxxDeptRelation();
				relation.setDept(UserUtils.getUser().getOffice());
				relation.setType(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
				relation.setXmjbxx(new Xmjbxx(id));
				setZgcj(relation);
				relationService.save(relation);
			}
		}
	}

	/**
	 * 根据传入的 deptRelation （属性 xmjbxx/dept/type不能为空） 为该relation设置最高层级；
	 * 同时设置xmjbxx/dept/type这三个参数相同的其他层级储备库记录的zgcj
	 */
	@Transactional(readOnly = false)
	public void setZgcj(CInsBusinessXmjbxxDeptRelation relation) {
		if (null == relation.getDept() || null == relation.getXmjbxx() || StringUtils.isBlank(relation.getType())) {
			throw new RuntimeException();
		}
		CInsBusinessXmjbxxDeptRelation parameter = new CInsBusinessXmjbxxDeptRelation();
		parameter.setXmjbxx(relation.getXmjbxx());
		parameter.setDept(relation.getDept());
		parameter.setType(relation.getType());
		List<CInsBusinessXmjbxxDeptRelation> relationList = relationService.findList(parameter);
		Office office;
		if (relationList.size() > 1) {
			Collections.sort(relationList, new Comparator<CInsBusinessXmjbxxDeptRelation>() {
                @Override
                public int compare(CInsBusinessXmjbxxDeptRelation o1, CInsBusinessXmjbxxDeptRelation o2) {
                    return Integer.parseInt(o2.getDept().getGrade()) - Integer.parseInt(o1.getDept().getGrade());
                }
            });
			office = relationList.get(0).getDept();
		} else if (relationList.size() == 1) {
			office = relationList.get(0).getDept();
		} else {
			office = officeService.get(relation.getDept().getId());
		}
		relation.setZgcj(office.getGrade());

		for (CInsBusinessXmjbxxDeptRelation temp : relationList) {
			temp.setZgcj(office.getGrade());
			relationService.save(temp);
		}
	}

	public CInsBusinessXmjbxxDeptRelation getRelationParam(String id) {
		CInsBusinessXmjbxxDeptRelation relationParam = new CInsBusinessXmjbxxDeptRelation();
		relationParam.setDept(UserUtils.getUser().getOffice());
		relationParam.setXmjbxx(new Xmjbxx(id));
		relationParam.setType(CInsBusinessXmjbxxDeptRelation.TYPE_SNGDJH);
		return relationParam;
	}

	/**
	 * 同步储备项目（同步三年滚动计划为储备项目）
	 */
	@Transactional(readOnly = false)
	public void sngdjhToCbk(Xmjbxx xmjbxx) {
		CInsBusinessXmjbxxDeptRelation relationParam = getRelationParam(xmjbxx.getId());
		relationParam.setType(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
		List<CInsBusinessXmjbxxDeptRelation> sngdjhRelations = relationService.findList(relationParam);
		if (sngdjhRelations.isEmpty()) {
			CInsBusinessXmjbxxDeptRelation relation = new CInsBusinessXmjbxxDeptRelation();
			relation.setDept(UserUtils.getUser().getOffice());
			relation.setType(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
			relation.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_CBK_BTX);
			relation.setXmjbxx(xmjbxx);
			setZgcj(relation); // 更新储备项目最高层级
			relationService.save(relation);
		}

		// 同步为储备项目自动加锁
		//jiaSuo(xmjbxx);

		// 业务日志
		BusinessLogUtils.saveLog(xmjbxx, CInsBusinessLog.OPERATE_XMJBXX_TBSNGDJHWCBXM, CInsBusinessLog.TYPE_JHBB);
	}

	/**
	 * 上报
	 */
	@Transactional(readOnly = false)
	public void shangBao(String ids, String officeId, String bswh,String bslb) {
		if (StringUtils.isNotBlank(ids)) {
			Office office = officeService.get(officeId);
			String[] idsArr = ids.split(",");
			for (String id : idsArr) {
				Xmjbxx xmjbxx = get(id);
				System.out.println(xmjbxx.getCj());
				if ("1".equals(xmjbxx.getCj())) {//区县报送，项目变更到市级投资计划编制区
					xmjbxx.setZt(Xmjbxx.ZT_TZJH_BZQ);
					xmjbxx.setStage(Xmjbxx.STAGE_JHBZ);
					xmjbxx.setSfth(Global.NO);
				}
				if ("2".equals(xmjbxx.getCj())) {//市级报送，项目变更到省级投资计划编制区
					xmjbxx.setZt(Xmjbxx.ZT_TZJH_BZQ);
					xmjbxx.setStage(Xmjbxx.STAGE_JHBZ);
					xmjbxx.setSfth(Global.NO);
				}
				if ("3".equals(xmjbxx.getCj()) || Office.GRADE_SHENGJIFGW.equals(xmjbxx.getCj())) {//省级报送，项目变更到省级项目储备审核区
					xmjbxx.setZt(Xmjbxx.ZT_TZJH_BZQ);
					xmjbxx.setStage(Xmjbxx.STAGE_XMCB);
				}
				xmjbxx.setShbm(office);
				xmjbxx.setCj(office.getGrade());
				xmjbxx.setBswh(String.valueOf(bswh));
				System.out.println("bslb:"+bslb);
				xmjbxx.setRemarks(bslb);
				save(xmjbxx);

				// 添加到已上报
				CInsBusinessXmjbxxDeptRelation relation = new CInsBusinessXmjbxxDeptRelation();
				relation.setType(CInsBusinessXmjbxxDeptRelation.TYPE_YSB);
				relation.setDept(UserUtils.getUser().getOffice());
				relation.setXmjbxx(xmjbxx);
				relation.setRemarks(bslb);
				System.out.println(String.valueOf(bswh)+","+bslb);
				relation.setBswh(String.valueOf(bswh));
				List<CInsBusinessXmjbxxDeptRelation> relations = relationService.findList(relation);
				if (relations.isEmpty()) {
					relationService.addOrUpdateRelation(relation);
				}

				// 纳入本级三年滚动计划
				nrsngdjh(xmjbxx,bslb,bswh);

				// 上报项目自动加锁
				//jiaSuo(xmjbxx);

				// // 保存业务日志
				BusinessLogUtils.saveLog(xmjbxx, CInsBusinessLog.OPERATE_XMJBXX_SHANGBAO, CInsBusinessLog.TYPE_JHBB, office);
			}
		}
	}

	/**
	 * 批量报送
	 */
	@Transactional(readOnly = false)
	public void baoSong(String ids) {
		String[] idArr = ids.split(",");
		for (String id : idArr) {
			baoSong(get(id));
		}
	}

	/**
	 * 报送
	 */
	@Transactional(readOnly = false)
	public void baoSong(Xmjbxx xmjbxx) {
		// 业务日志相关变量
		String type = CInsBusinessLog.TYPE_JHBB;
		String operate = CInsBusinessLog.OPERATE_XMJBXX_BAOSONG;

		// 报送
		if (Xmjbxx.ZT_XMCB_BS.equals(xmjbxx.getZt())) {//处于报送区，报送到审核区
			xmjbxx.setZt(Xmjbxx.ZT_XMCB_SHQ);
			type = CInsBusinessLog.TYPE_CBBB;
		} else if (Xmjbxx.ZT_TZJH_BZQ.equals(xmjbxx.getZt())) {//处于编制区，报送到审核区
			xmjbxx.setZt(Xmjbxx.ZT_TZJH_SHQ);
			xmjbxx.setStage(Xmjbxx.STAGE_JHBZ);
		} else if (Xmjbxx.ZT_TZJH_SHQ.equals(xmjbxx.getZt())) {//处于编制区，报送到审核区
			xmjbxx.setZt(Xmjbxx.ZT_TZJH_DBQ);
			operate = CInsBusinessLog.OPERATE_XMJBXX_TSZDBQ;
		}
		save(xmjbxx);

		// 保存业务日志
		BusinessLogUtils.saveLog(xmjbxx, operate, type);
	}

	/**
	 * 项目退回
	 */
	@Transactional(readOnly = false)
	public void xmth(String ids) {
		String[] idsArr = ids.split(",");
		for (String id : idsArr) {
			String type = CInsBusinessLog.TYPE_CBBB;
			Xmjbxx xmjbxx = get(id);
			// 如果项目处于储备项目-审核区，并且当前项目不是由当前用户填报（新增）的，那么退回到下级单位
            String xmjbxxCreateByOfficeGrade = (xmjbxx.getCreateBy() == null ? "" : xmjbxx.getCreateBy().getOffice()) == null ? "" : xmjbxx.getCreateBy().getOffice().getId();
            if(Xmjbxx.ZT_XMCB_SHQ.equals(xmjbxx.getZt()) && !UserUtils.getUserOffice().getId().equals(xmjbxxCreateByOfficeGrade)){
				tzjhShqThxjdw(xmjbxx);
				//退回下级单位在上面方法里对项目修改和保存，以及保存业务日志，所以这里进入下一循环
				continue;
			} else if (Xmjbxx.ZT_XMCB_SHQ.equals(xmjbxx.getZt())) {//审核区退回到报送区
				xmjbxx.setZt(Xmjbxx.ZT_XMCB_BS);
				xmjbxx.setSfth(Global.YES);
			} else if (Xmjbxx.ZT_TZJH_SHQ.equals(xmjbxx.getZt())) {//审核区退回到编制区
				xmjbxx.setZt(Xmjbxx.ZT_TZJH_BZQ);
				type = CInsBusinessLog.TYPE_JHBB;
			} else if (Xmjbxx.ZT_TZJH_DBQ.equals(xmjbxx.getZt())) {//待报区退回到审核区
				xmjbxx.setZt(Xmjbxx.ZT_TZJH_SHQ);
				type = CInsBusinessLog.TYPE_JHBB;
			}
			save(xmjbxx);

			BusinessLogUtils.saveLog(xmjbxx, CInsBusinessLog.OPERATE_XMJBXX_TUIHUI, type);
		}
	}

	/**
	 * 项目储备-审核区-删除
	 * 删除 项目部门关联表 中的部门项目创建关系
	 * 删除 项目基本信息及其他各项相关信息数据
	 */
	@Transactional(readOnly = false)
	public void cbxmShqDelete(String ids) {
		String[] idsArr = ids.split(",");
		for (String id : idsArr) {
			Xmjbxx xmjbxx = get(id);
			dao.deleteByLogic(xmjbxx);
			//删除项目基本信息相关联的其他表信息
			// deleteXmjbxxRefer(xmjbxx.getId());//改为软删除
		}
	}

	/**
	 * 删除项目基本信息相关联的其他表信息
	 */
	@Transactional
	public void deleteXmjbxxRefer(String xmjbxxId) {
		Xmjbxx xmjbxx = new Xmjbxx(xmjbxxId);
		//删除项目公司信息
		CInsBusinessXmgs xmgsParam = new CInsBusinessXmgs();
		xmgsParam.setXmjbxx(xmjbxx);
		List<CInsBusinessXmgs> xmgsList = cInsBusinessXmgsService.findList(xmgsParam);
		for (int index = 0; index < xmgsList.size(); index++) {
			cInsBusinessXmgsService.delete(xmgsList.get(index));
		}

		//删除部门项目关联表信息
		CInsBusinessXmjbxxDeptRelation relationParam = new CInsBusinessXmjbxxDeptRelation();
		relationParam.setXmjbxx(xmjbxx );
		List<CInsBusinessXmjbxxDeptRelation> relationList = relationService.findList(relationParam);
		for (int index = 0; index < relationList.size(); index++) {
			relationService.delete(relationList.get(index));
		}

		//删除投资情况相关信息
		CInsBusinessTzqk tzqkParam = new CInsBusinessTzqk();
		tzqkParam.setXmjbxx(xmjbxx);
		List<CInsBusinessTzqk> tzqkList = cInsBusinessTzqkService.findList(tzqkParam);
		for (int index = 0; index < tzqkList.size(); index++) {
			CInsBusinessTzqk tzqk = tzqkList.get(index);
			cInsBusinessTzqkService.delete(tzqk);

			//删除年投资表相关信息
			CInsBusinessZjlbNtz ntzParam = new CInsBusinessZjlbNtz();
			ntzParam.setTzqk(tzqk);
			List<CInsBusinessZjlbNtz> ntzList = cInsBusinessZjlbNtzService.findList(ntzParam);
			for (int num = 0; num < ntzList.size(); num++) {
				CInsBusinessZjlbNtz ntz = ntzList.get(num);
				cInsBusinessZjlbNtzService.delete(ntz);
			}
		}

		//删除前期工作相关信息
		CInsBusinessQqgz qqgzParam = new CInsBusinessQqgz();
		qqgzParam.setXmjbxx(xmjbxx);
		List<CInsBusinessQqgz> qqgzList = cInsBusinessQqgzService.findList(qqgzParam);
		for (int index = 0; index < qqgzList.size(); index++) {
			CInsBusinessQqgz qqgz = qqgzList.get(index);
			cInsBusinessQqgzService.delete(qqgz);
		}
	}

	/**
	 * 退回下级单位
	 */
	@Transactional(readOnly = false)
	public void tzjhShqThxjdw(String ids) throws RuntimeException {
		String[] idsArr = ids.split(",");
		for (String id : idsArr) {
			Xmjbxx xmjbxx = get(id);
			tzjhShqThxjdw(xmjbxx);
		}
	}

	/**
	 * 退回下级单位
	 */
	@Transactional(readOnly = false)
	public void tzjhShqThxjdw(Xmjbxx xmjbxx) {

		// 执行退回下级单位操作前先检查当前层级否有三年滚动计划、储备库记录，有的话不允许退回
		CInsBusinessXmjbxxDeptRelation parameter = new CInsBusinessXmjbxxDeptRelation();
		parameter.setXmjbxx(xmjbxx);
		parameter.setDept(UserUtils.getUserOffice());
		List<CInsBusinessXmjbxxDeptRelation> exitsRelationList = relationService.findList(parameter);
		for (CInsBusinessXmjbxxDeptRelation relation : exitsRelationList) {
			if (CInsBusinessXmjbxxDeptRelation.TYPE_TB.equals(relation.getType())) {
				logger.error("项目（" + xmjbxx.getXmmc() + "[id:" + xmjbxx.getId() + "]）由本级创建，无法退回下级！");
				throw new RuntimeException("项目由本级创建，无法退回下级！");
			} else if (CInsBusinessXmjbxxDeptRelation.TYPE_CBK.equals(relation.getType())) {
				logger.error("项目（" + xmjbxx.getXmmc() + "[id:" + xmjbxx.getId() + "]）是本级储备项目，无法退回下级！");
				throw new RuntimeException("项目（" + xmjbxx.getXmmc() + "）是本级储备项目，无法退回下级！");
			} 

			// TODO 年度基金项目 和 专项建设基金项目怎么处理？
		}


		// 获取该项目最新的已上报记录
		CInsBusinessXmjbxxDeptRelation ysbDeptRelation = null;
		CInsBusinessXmjbxxDeptRelation relationParam = new CInsBusinessXmjbxxDeptRelation();
		relationParam.setXmjbxx(xmjbxx);
		relationParam.setType(CInsBusinessXmjbxxDeptRelation.TYPE_YSB);
		Page<CInsBusinessXmjbxxDeptRelation> page = (Page<CInsBusinessXmjbxxDeptRelation>) relationParam.getPage();
		page.setOrderBy("a.create_date desc");//取创建时间最新的已上报记录
		List<CInsBusinessXmjbxxDeptRelation> deptRelationList = relationService.findList(relationParam);
		if (deptRelationList.isEmpty()) {
			// 网站申报，退回给用户
			tzjhShqThTbdw(xmjbxx);
			return;
		}
		ysbDeptRelation = deptRelationList.get(0);
		Office office = UserUtils.getUserOffice(ysbDeptRelation.getCreateBy());
		if(null == office){
			logger.error("项目（" + xmjbxx.getXmmc() + "）重大库编码[" + xmjbxx.getZdkbmgj() + "]报送人所属单位为空");
			logger.error("项目（" + xmjbxx.getXmmc() + "）重大库编码[" + xmjbxx.getZdkbmgj() + "]退回下级单位异常！");
			throw new RuntimeException("退回下级单位失败！请联系管理员！");
		}

		xmjbxx.setCj(office.getGrade());//设置层级为上报用户所属机构的层级
		xmjbxx.setShbm(office);//审核部门为用户上报的部门
		xmjbxx.setZt(Xmjbxx.ZT_TZJH_BZQ);//退回上级部门的 投资计划-审核区
		xmjbxx.setStage(Xmjbxx.STAGE_JHBZ);//项目阶段为计划编制
		xmjbxx.setSfth(Global.YES);

		// 更新下级部门的 储备库 和 三年滚动计划 的状态
		CInsBusinessXmjbxxDeptRelation param = new CInsBusinessXmjbxxDeptRelation();
		param.setDept(office);
		param.setXmjbxx(new Xmjbxx(xmjbxx.getId()));
		List<CInsBusinessXmjbxxDeptRelation> relationList = relationService.findList(param);
		for(CInsBusinessXmjbxxDeptRelation relation : relationList){
			// 更新储备库状态为未报送
			if (CInsBusinessXmjbxxDeptRelation.TYPE_CBK.equals(relation.getType())) {
				relation.setZt(CInsBusinessXmjbxxDeptRelation.ZT_CBK_WBS);
				relationService.save(relation);
			}

			// 更新三年滚动计划状态为被退回
			if (CInsBusinessXmjbxxDeptRelation.TYPE_SNGDJH.equals(relation.getType())) {
				relation.setZt(CInsBusinessXmjbxxDeptRelation.ZT_SNGDJH_BTH);
				relationService.save(relation);
			}
		}

		//从下级部门已申报列表中移除记录
		relationService.delete(ysbDeptRelation);

		//保存项目基本信息
		save(xmjbxx);

		// 更新锁状态，否则会出现项目加了当前层级锁，退回到下级，下级无法解除高层级锁的问题
		updateSzt(xmjbxx);

		// 添加业务日志
		BusinessLogUtils.saveLog(xmjbxx, CInsBusinessLog.OPERATE_XMJBXX_THXJDW, "4".equals(xmjbxx.getCj()) ? CInsBusinessLog.TYPE_CBBB : CInsBusinessLog.TYPE_JHBB, office);
	}

	/**
	 * 退回项目填报单位
	 * @param xmjbxx
	 */
	@Transactional(readOnly = false)
	public void tzjhShqThTbdw(Xmjbxx xmjbxx) {
		xmjbxx.setCj(Office.GRADE_WANGZHAN);
		xmjbxx.setStage(null);
		xmjbxx.setShbm(null);
		xmjbxx.setSzt(Xmjbxx.SZT_WS);
		xmjbxx.setSfth(Global.YES);
		xmjbxx.setZt(Xmjbxx.ZT_XMCB_BS);
		save(xmjbxx);
		// 保存业务日志
		BusinessLogUtils.saveLog(xmjbxx, CInsBusinessLog.OPERATE_XMJBXX_THXJDW, CInsBusinessLog.TYPE_CBBB, xmjbxx.getCreateBy(), xmjbxx.getCreateByName(), null);
	}
	/**
	 * 取消储备前先判断是否在编制中
	 */
	@Transactional(readOnly = false)
	public boolean qxcbCheck(String ids) {
	
		String[] idArr = ids.split(",");
		for (String id : idArr) {
			Xmjbxx xmjbxx2=get(id);
			if (xmjbxx2 == null) {
				logger.error("取消储备时传入xmjbxx为空！");
				throw new RuntimeException();
			}
			if(Integer.parseInt(xmjbxx2.getZt())>3){
				return false;
			}
			
		}
		return true;
	}
	/**
	 * 批量取消储备
	 */
	@Transactional(readOnly = false)
	public void qxcb(String ids) {
		String[] idArr = ids.split(",");
		for (String id : idArr) {
			xqcb(get(id));
		}
	}
	
	

	/**
	 * 取消储备
	 */
	@Transactional(readOnly = false)
	public void xqcb(Xmjbxx xmjbxx) {
		if (xmjbxx == null) {
			logger.error("取消储备时传入xmjbxx为空！");
			throw new RuntimeException();
		}

		// 取消储备之前检查是否有三年滚动计划（20171115-新疆重大项目储备库信息化管理平台系统需求）
		CInsBusinessXmjbxxDeptRelation parameter = new CInsBusinessXmjbxxDeptRelation();
		parameter.setDept(UserUtils.getUser().getOffice());
		parameter.setXmjbxx(new Xmjbxx(xmjbxx.getId()));
		parameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_SNGDJH);
		List<CInsBusinessXmjbxxDeptRelation> sngdjhList = relationService.findList(parameter);
		if (!sngdjhList.isEmpty()) {
			logger.error("项目（" + xmjbxx.getXmmc() + "[id:" + xmjbxx.getId() + "]）已纳入三年滚动计划，无法取消储备！");
			throw new RuntimeException("项目（" + xmjbxx.getXmmc() + "）已纳入三年滚动计划，无法取消储备！");
		}

		parameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
		List<CInsBusinessXmjbxxDeptRelation> list = relationService.findList(parameter);
		relationService.delete(list.get(0));

		// 项目如果处于当前层级 储备库 状态，将其设置为待审核
		if (Xmjbxx.ZT_XMCB_CBK.equals(xmjbxx.getZt()) && xmjbxx.getShbm().getGrade().equals(UserUtils.getUserGrade())) {
			xmjbxx.setZt(Xmjbxx.ZT_XMCB_SHQ);
			save(xmjbxx);
		}

		// 添加业务日志
		BusinessLogUtils.saveLog(xmjbxx, CInsBusinessLog.OPERATE_XMJBXX_QXCB, CInsBusinessLog.TYPE_CBBB);
	}

	/**
	 * 添加项目到编制区
	 */
	@Transactional(readOnly = false)
	public void addToBzq(String ids) {
		String[] idsArr = ids.split(",");
		for (String id : idsArr) {
			Xmjbxx xmjbxx = get(id);
			// 校验当前项目是否未被挑到投资计划编制区
			CInsBusinessXmjbxxDeptRelation parameter = new CInsBusinessXmjbxxDeptRelation();
			parameter.setDept(UserUtils.getUser().getOffice());
			parameter.setXmjbxx(xmjbxx);
			parameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
			List<CInsBusinessXmjbxxDeptRelation> relationList = relationService.findList(parameter);
//			if (relationList.size() > 0 && CInsBusinessXmjbxxDeptRelation.NRZT_CBK_BTX.equals(relationList.get(0).getNrzt())) {
//				logger.error("项目(" + xmjbxx + "[id:" + id + "])已被挑选为储备项目");
//				throw new RuntimeException("项目(" + xmjbxx + ")已被挑选为储备项目");
//			}

			xmjbxx.setStage(Xmjbxx.STAGE_JHBZ);
			xmjbxx.setZt(Xmjbxx.ZT_TZJH_BZQ);
			xmjbxx.setJhbzDate(new Date());
			xmjbxx.setShbm(UserUtils.getUser().getOffice());
			xmjbxx.setCj(UserUtils.getUser().getOffice().getGrade());
			save(xmjbxx);

			// 标记该项目已被挑选为投资计划项目
			CInsBusinessXmjbxxDeptRelation deptRelation = relationList.get(0);
			deptRelation.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_CBK_BTX);
			relationService.save(deptRelation);

			// 保存业务日志
			BusinessLogUtils.saveLog(xmjbxx, CInsBusinessLog.OPERATE_XMJBXX_BIANZHI, CInsBusinessLog.TYPE_JHBB);
		}
	}

	/**
	 * 添加到年度计划报送列表
	 */
	@Transactional(readOnly = false)
	public void selectToNdjhbs(String ids) {
		String[] idsArr = ids.split(",");
		for (String id : idsArr) {
			Xmjbxx xmjbxx = new Xmjbxx(id);
			CInsBusinessXmjbxxDeptRelation param = new CInsBusinessXmjbxxDeptRelation();
			param.setDept(UserUtils.getUser().getOffice());
			param.setXmjbxx(xmjbxx);
			param.setType(CInsBusinessXmjbxxDeptRelation.TYPE_NDJHBS);
			param.setStatus(CInsBusinessXmjbxxDeptRelation.STATUS_NDJHBS_BZ);
			List<CInsBusinessXmjbxxDeptRelation> relationList = relationService.findList(param);
			if (relationList.isEmpty()) {
				relationService.save(param);
			}

			//将三年滚动计划的报送状态设为true
			param = new CInsBusinessXmjbxxDeptRelation();
			param.setType(CInsBusinessXmjbxxDeptRelation.TYPE_SNGDJH);
			param.setDept(UserUtils.getUser().getOffice());
			param.setXmjbxx(xmjbxx);
			List<CInsBusinessXmjbxxDeptRelation> sngdjhList = relationService.findList(param);
			if (!sngdjhList.isEmpty()) {
				CInsBusinessXmjbxxDeptRelation sngdjh = sngdjhList.get(0);
				sngdjh.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_TXW_NDJHBS);
				relationService.save(sngdjh);
			}

			// 添加业务日志
			BusinessLogUtils.saveLog(xmjbxx, CInsBusinessLog.OPERATE_XMJBXX_NDJHBZ, CInsBusinessLog.TYPE_JHBB);
		}
	}

	/**
	 * 添加专项基金建设项目列表
	 */
	@Transactional(readOnly = false)
	public void selectToNdzxjsjj(String ids) {
		String[] idsArr = ids.split(",");
		for (String id : idsArr) {
			Xmjbxx xmjbxx = new Xmjbxx(id);
			CInsBusinessXmjbxxDeptRelation param = new CInsBusinessXmjbxxDeptRelation();
			param.setDept(UserUtils.getUser().getOffice());
			param.setXmjbxx(xmjbxx);
			param.setType(CInsBusinessXmjbxxDeptRelation.TYPE_ZXJSJJ);
			param.setStatus(CInsBusinessXmjbxxDeptRelation.STATUS_ZXJSJJ_BZ);
			List<CInsBusinessXmjbxxDeptRelation> relationList = relationService.findList(param);
			if (relationList.isEmpty()) {
				relationService.save(param);
			}

			//将三年滚动计划的纳入状态标记为已被纳入年度专项建设基金
			param = new CInsBusinessXmjbxxDeptRelation();
			param.setType(CInsBusinessXmjbxxDeptRelation.TYPE_SNGDJH);
			param.setDept(UserUtils.getUser().getOffice());
			param.setXmjbxx(xmjbxx);
			List<CInsBusinessXmjbxxDeptRelation> sngdjhList = relationService.findList(param);
			if (!sngdjhList.isEmpty()) {
				CInsBusinessXmjbxxDeptRelation sngdjh = sngdjhList.get(0);
				sngdjh.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_TXW_ZXJSJJXM);
				relationService.save(sngdjh);
			}

			// 添加业务日志
			BusinessLogUtils.saveLog(xmjbxx, CInsBusinessLog.OPERATE_XMJBXX_ZXJSJJXMBZ, CInsBusinessLog.TYPE_JHBB);
		}
	}

	/**
	 * 发送信息
	 */
	@Transactional(readOnly = false)
	public void fsyjxx(String ids) {
		
		String[] idsArr = ids.split(",");
		   
		for (String id : idsArr) {
			Xmjbxx xmjbxx = get(id);  			
			List<Xmjbxx> lists = dao.findFullListByParameterdxfs(xmjbxx);
			if(null!=lists&&lists.size()>0){
				for(int i=0; i< lists.size(); i++){
					Xmjbxx xmjbx_sqr = lists.get(i);
					int length=xmjbx_sqr.getXmmc().length();
					if(length>8){
						length=8;
					}
					if(i==0){
						String phone = xmjbx_sqr.getLxphoneone();
						
						String content = "您好！贵单位项目"+(xmjbx_sqr.getXmmc()).substring(0,length)+"进度未达到省发改委相关节点要求，请加快实施。详情见省政务服务网注册邮箱。";
						SysSms smsParam1 = new SysSms();
						smsParam1.setTelephone(phone);
						/*phone="18625509598";*/
						smsParam1.setIsNewRecord(true); 
						smsParam1.setXxbh("10500");
						smsParam1.setMessage(content);
						smsParam1.setSendresult("0");
						
						String returnStatus = SMSUtils.preSendSms(phone, content);
						if (!"".equals(returnStatus) && returnStatus.equals("200")) {
							smsParam1.setSendresult("1");
						}			
						sysSmsService.save(smsParam1);
					}
					
					BusinessLogUtils.saveLog(xmjbxx, CInsBusinessLog.OPERATE_XMJBXX_RBJK, CInsBusinessLog.TYPE_CBBB);
				}
			}
		}
		
		String ids_fgw = "";
		for (int i=0; i< idsArr.length; i++) {
			ids_fgw += "'";
			ids_fgw += idsArr[i];
			ids_fgw += "'";
			if(i < idsArr.length-1){
				ids_fgw += ",";
			}
		}
		Xmjbxx xmjbxx_fgw = new Xmjbxx();
		xmjbxx_fgw.setJsdd(ids_fgw);
		Map map_ids = new HashMap();
		map_ids.put("jsdd", ids.split(","));
		List<Xmjbxx> listss = dao.findFullListByParameterdxtj( map_ids);
		if(null!=listss && listss.size()>0){
			for(int x=0;x<listss.size();x++){
				xmjbxx_fgw = listss.get(x);
				String phone=xmjbxx_fgw.getXmlx();
						if(!(phone==null) && !(phone.equals("")) && !("".equals(phone))){
							String content ="您好！贵市/县有"+xmjbxx_fgw.getJsxz()+"个项目进度未达到省发改委相关节点要求，请督查项目单位加快实施。详情见省政务服务网注册邮箱。";
							SysSms smsParam = new SysSms();
							smsParam.setTelephone(phone);
							smsParam.setIsNewRecord(true); 
							smsParam.setXxbh("10500");
							smsParam.setMessage(content);
							smsParam.setSendresult("0");
							String returnStatus2 = SMSUtils.preSendSms(phone, content);
							if (!"".equals(returnStatus2) && returnStatus2.equals("200")) {
								smsParam.setSendresult("1");
							}
							sysSmsService.save(smsParam);
					   }
					
					BusinessLogUtils.saveLog(xmjbxx_fgw, CInsBusinessLog.OPERATE_XMJBXX_RBJK, CInsBusinessLog.TYPE_CBBB);
			}
			
		}
		
		
		
	}

	/**
	 * 入本级库
	 */
	@Transactional(readOnly = false)
	public void rbjk(String ids) {
		String[] idsArr = ids.split(",");
		for (String id : idsArr) {
			Xmjbxx xmjbxx = get(id);
			if (!Xmjbxx.ZT_XMCB_SHQ.equals(xmjbxx.getZt())) {
				logger.error("项目（" + xmjbxx.getXmmc() + "[id:" + xmjbxx.getId() + "]）不在项目储备-审核区，无法添加为储备项目");
				throw new RuntimeException("项目（" + xmjbxx.getXmmc() + "）不在项目储备-审核区，无法添加为储备项目");
			}

			xmjbxx.setZt(Xmjbxx.ZT_XMCB_CBK);//项目储备审核区-》储备库
			CInsBusinessXmjbxxDeptRelation relation = new CInsBusinessXmjbxxDeptRelation();
			relation.setDept(UserUtils.getUser().getOffice());
			relation.setXmjbxx(xmjbxx);
			relation.setType(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
			relation.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_CBK_WTX);//储备库-未挑选
			relation.setZt(CInsBusinessXmjbxxDeptRelation.ZT_CBK_WBS);//储备库-未报送
			setZgcj(relation);
			relationService.addOrUpdateRelation(relation);
			save(xmjbxx);

			// 添加到储备库自动加锁
			//jiaSuo(xmjbxx);

			// 添加业务日志
			BusinessLogUtils.saveLog(xmjbxx, CInsBusinessLog.OPERATE_XMJBXX_RBJK, CInsBusinessLog.TYPE_CBBB);
		}
	}

	/**
	 * 批量转办
	 */
	@Transactional(readOnly = false)
	public void zhuanban(String ids, String zbOffice) {
		Office office = officeService.get(zbOffice);

		String[] idsArr = ids.split(",");
		for (String id : idsArr) {
			Xmjbxx xmjbxx = get(id);
			xmjbxx.setShbm(office);
			save(xmjbxx);

			// 保存业务日志
			BusinessLogUtils.saveLog(xmjbxx, CInsBusinessLog.OPERATE_XMJBXX_ZHUANBAN, CInsBusinessLog.TYPE_ZB, office);
		}
	}

	@Transactional(readOnly = false)
	public void ndzxjsjjBsqTh(String ids) {
		String[] idsArr = ids.split(",");
		for (String id : idsArr) {
			CInsBusinessXmjbxxDeptRelation relation = new CInsBusinessXmjbxxDeptRelation();
			relation.setXmjbxx(new Xmjbxx(id));
			relation.setDept(UserUtils.getUser().getOffice());
			relation.setType(CInsBusinessXmjbxxDeptRelation.TYPE_ZXJSJJ);
			relation.setStatus(CInsBusinessXmjbxxDeptRelation.STATUS_ZXJSJJ_BS);
			List<CInsBusinessXmjbxxDeptRelation> relationList = relationService.findList(relation);
			if (!relationList.isEmpty()) {
				CInsBusinessXmjbxxDeptRelation newRelation = relationList.get(0);
				newRelation.setStatus(CInsBusinessXmjbxxDeptRelation.STATUS_ZXJSJJ_BZ);
				relationService.save(newRelation);

				// 添加业务日志
				BusinessLogUtils.saveLog(get(id), CInsBusinessLog.OPERATE_XMJBXX_ZXJSJJXMTH, CInsBusinessLog.TYPE_JHBB);
			}
		}
	}

	@Transactional(readOnly = false)
	public void ndjhBsqTh(String ids) {
		String[] idsArr = ids.split(",");
		for (String id : idsArr) {
			CInsBusinessXmjbxxDeptRelation relation = new CInsBusinessXmjbxxDeptRelation();
			relation.setXmjbxx(new Xmjbxx(id));
			relation.setDept(UserUtils.getUser().getOffice());
			relation.setType(CInsBusinessXmjbxxDeptRelation.TYPE_NDJHBS);
			relation.setStatus(CInsBusinessXmjbxxDeptRelation.STATUS_NDJHBS_BS);
			List<CInsBusinessXmjbxxDeptRelation> relationList = relationService.findList(relation);
			if (!relationList.isEmpty()) {
				CInsBusinessXmjbxxDeptRelation newRelation = relationList.get(0);
				newRelation.setStatus(CInsBusinessXmjbxxDeptRelation.STATUS_NDJHBS_BZ);
				relationService.save(newRelation);

				// 添加业务日志
				BusinessLogUtils.saveLog(get(id), CInsBusinessLog.OPERATE_XMJBXX_JDJHBSTH, CInsBusinessLog.TYPE_JHBB);
			}
		}
	}

	@Transactional(readOnly = false)
	public void zxjsjjxmBzqDelete(String ids){
		String[] idsArr = ids.split(",");
		for (String id : idsArr) {
			CInsBusinessXmjbxxDeptRelation relationParam = new CInsBusinessXmjbxxDeptRelation();
			relationParam.setXmjbxx(new Xmjbxx(id));
			relationParam.setDept(UserUtils.getUser().getOffice());
			relationParam.setType(CInsBusinessXmjbxxDeptRelation.TYPE_ZXJSJJ);
			relationParam.setStatus(CInsBusinessXmjbxxDeptRelation.STATUS_ZXJSJJ_BZ);
			List<CInsBusinessXmjbxxDeptRelation> relationList = relationService.findList(relationParam);
			if (!relationList.isEmpty()) {
				CInsBusinessXmjbxxDeptRelation relation = relationList.get(0);
				relationService.delete(relation);
			}
			relationParam.setType(CInsBusinessXmjbxxDeptRelation.TYPE_SNGDJH);
			relationParam.setStatus(null);
			List<CInsBusinessXmjbxxDeptRelation> relations = relationService.findList(relationParam);
			for (CInsBusinessXmjbxxDeptRelation relation : relations) {
				relation.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_WTX);
				relationService.save(relation);
			}

			// 添加业务日志
			BusinessLogUtils.saveLog(get(id), CInsBusinessLog.OPERATE_XMJBXX_SCZXJSJJXM, CInsBusinessLog.TYPE_JHBB);
		}
	}

	@Transactional(readOnly = false)
	public void ndjhbsBzqDelete(String ids){
		String[] idsArr = ids.split(",");
		for (String id : idsArr) {
			CInsBusinessXmjbxxDeptRelation relationParam = new CInsBusinessXmjbxxDeptRelation();
			relationParam.setXmjbxx(new Xmjbxx(id));
			relationParam.setDept(UserUtils.getUser().getOffice());
			relationParam.setType(CInsBusinessXmjbxxDeptRelation.TYPE_NDJHBS);
			relationParam.setStatus(CInsBusinessXmjbxxDeptRelation.STATUS_NDJHBS_BZ);
			List<CInsBusinessXmjbxxDeptRelation> relationList = relationService.findList(relationParam);
			if (!relationList.isEmpty()) {
				CInsBusinessXmjbxxDeptRelation relation = relationList.get(0);
				relationService.delete(relation);
			}
			relationParam.setType(CInsBusinessXmjbxxDeptRelation.TYPE_SNGDJH);
			relationParam.setStatus(null);
			List<CInsBusinessXmjbxxDeptRelation> relations = relationService.findList(relationParam);
			for (CInsBusinessXmjbxxDeptRelation relation : relations) {
				relation.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_WTX);
				relationService.save(relation);
			}

			// 添加业务日志
			BusinessLogUtils.saveLog(get(id), CInsBusinessLog.OPERATE_XMJBXX_SCJDJHBS, CInsBusinessLog.TYPE_JHBB);
		}
	}

	@Transactional(readOnly = false)
	public void zxjsjjxmBgwh(String id, String bswh){
		Xmjbxx xmjbxx = get(id);
		if (null != xmjbxx) {
			xmjbxx.setBswh(bswh);
			save(xmjbxx);

			// 添加业务日志
			BusinessLogUtils.saveLog(xmjbxx, CInsBusinessLog.OPERATE_XMJBXX_BGWH, CInsBusinessLog.TYPE_JHBB);
		}
	}

	@Transactional(readOnly = false)
	public void pushToZxjsjjBsq(String id, String wjbt){
		CInsBusinessXmjbxxDeptRelation relation = new CInsBusinessXmjbxxDeptRelation();
		relation.setXmjbxx(new Xmjbxx(id));
		relation.setDept(UserUtils.getUser().getOffice());
		relation.setType(CInsBusinessXmjbxxDeptRelation.TYPE_ZXJSJJ);
		relation.setStatus(CInsBusinessXmjbxxDeptRelation.STATUS_ZXJSJJ_BZ);
		List<CInsBusinessXmjbxxDeptRelation> relationList = relationService.findList(relation);
		if (!relationList.isEmpty()) {
			CInsBusinessXmjbxxDeptRelation newRelation = relationList.get(0);
			newRelation.setStatus(CInsBusinessXmjbxxDeptRelation.STATUS_ZXJSJJ_BS);
			relationService.save(newRelation);
		}

		Xmjbxx xmjbxx = get(id);
		xmjbxx.setWjbt(wjbt);
		save(xmjbxx);

		// 添加业务日志
		BusinessLogUtils.saveLog(xmjbxx, CInsBusinessLog.OPERATE_XMJBXX_TSZZXJSJJXMBSQ, CInsBusinessLog.TYPE_JHBB);
	}

	@Transactional(readOnly = false)
	public void pushToNdjhBsq(String id, String wjbt){
		CInsBusinessXmjbxxDeptRelation relation = new CInsBusinessXmjbxxDeptRelation();
		relation.setXmjbxx(new Xmjbxx(id));
		relation.setDept(UserUtils.getUser().getOffice());
		relation.setType(CInsBusinessXmjbxxDeptRelation.TYPE_NDJHBS);
		relation.setStatus(CInsBusinessXmjbxxDeptRelation.STATUS_NDJHBS_BZ);
		List<CInsBusinessXmjbxxDeptRelation> relationList = relationService.findList(relation);
		if (!relationList.isEmpty()) {
			CInsBusinessXmjbxxDeptRelation newRelation = relationList.get(0);
			newRelation.setStatus(CInsBusinessXmjbxxDeptRelation.STATUS_NDJHBS_BS);
			relationService.save(newRelation);
		}
		Xmjbxx xmjbxx = get(id);
		xmjbxx.setWjbt(wjbt);
		save(xmjbxx);

		// 添加业务日志
		BusinessLogUtils.saveLog(xmjbxx, CInsBusinessLog.OPERATE_XMJBXX_TSZNDJHBSQ, CInsBusinessLog.TYPE_JHBB);
	}

	public  List<Xmjbxx> findFullListByParameter(XmjbxxSearchParameter param) {
		List<Xmjbxx> list =  dao.findFullListByParameter(param);
		return list;
	}

	public Xmjbxx getCInsBusinessInfo(String spjgptdm, String lxphoneone) {
		Xmjbxx info = dao.getCInsBusinessInfo(spjgptdm, lxphoneone);
		if (null == info) {
			return null;
		}

		logger.info("-----------------------------------------》before ...");
		logger.info("info.getXmlx(): " + info.getXmlx());
		logger.info("info.getJsxz(): " + info.getJsxz());
		logger.info("info.getGb(): " + info.getGb());
		logger.info("info.getJsdd(): " + info.getJsdd());
		logger.info("info.getGbhy(): " + info.getGbhy());
		logger.info("info.getSshy(): " + info.getSshy());
		logger.info("info.getStarttimey(): " + info.getStarttimey());
		logger.info("info.getZyjsgm(): " + info.getZyjsgm());
		logger.info("info.getNdzhjsnr(): " + info.getNdzhjsnr());

		// 切分zyjsgm，zyjsgm包含 主要建设规模 和 年度主要建设内容
		String zyjsgm = info.getZyjsgm();
		String ndzhjsnr = zyjsgm;
		if (StringUtils.isNotBlank(zyjsgm)) {
			if (zyjsgm.indexOf("建设规模:") > -1) {
				// String zyjsgms[] = zyjsgm.split("建设规模:");
				zyjsgm = zyjsgm.substring(zyjsgm.indexOf("建设规模:") + new String("建设规模:").length(), zyjsgm.indexOf("建设内容:"));
			}
			if (ndzhjsnr.indexOf("建设内容:") > -1) {
				// String ndzhjsnrs[] = ndzhjsnr.split("建设内容:");
				ndzhjsnr = ndzhjsnr.substring(ndzhjsnr.indexOf("建设内容:") + new String("建设内容:").length());
			}
		}
		info.setZyjsgm(zyjsgm == null ? "" : zyjsgm.trim());
		info.setNdzhjsnr(ndzhjsnr == null ? "" : ndzhjsnr.trim());

		// 测试，正式要我们这边全改成投资平台的
		/*if ("S".equals(info.getXmlx())) {
			info.setXmlx(Xmjbxx.XMLX_SP);
		} else if ("H".equals(info.getXmlx())) {
			info.setXmlx(Xmjbxx.XMLX_HZ);
		} else if ("B".equals(info.getXmlx())) {
			info.setXmlx(Xmjbxx.XMLX_BA);
		}
		 info.setJsxz(DictUtils.getDictValue(info.getJsxz(), "jsxz", ""));
		*/
		info.setGb((info.getGb() == null || "".equals(info.getGb())) ? "1" : info.getGb());

		info.setGbhy(DictUtils.getTreeDictIdByTypeAndCode(info.getGbhy(), "gbhy"));
		info.setSshy(DictUtils.getTreeDictIdByTypeAndCode(info.getSshy(), "sshy"));

		Area areaParameter = new Area();
		areaParameter.setCode(info.getJsdd());
		List<Area> areaList = areaService.findList(areaParameter);
		if (areaList.isEmpty()) {
			info.setJsdd("");
		} else {
			info.setJsdd(areaList.get(0).getId());
		}

		info.setStarttimey(info.getStarttimey() == null ? "" : info.getStarttimey().replaceAll("^(0+)", ""));

		logger.info("-----------------------------------------》after ...");
		logger.info("info.getXmlx(): " + info.getXmlx());
		logger.info("info.getJsxz(): " + info.getJsxz());
		logger.info("info.getGb(): " + info.getGb());
		logger.info("info.getJsdd(): " + info.getJsdd());
		logger.info("info.getGbhy(): " + info.getGbhy());
		logger.info("info.getSshy(): " + info.getSshy());
		logger.info("info.getStarttimey(): " + info.getStarttimey());
		logger.info("info.getZyjsgm(): " + info.getZyjsgm());
		logger.info("info.getNdzhjsnr(): " + info.getNdzhjsnr());

		return info;
	}

	/**
	 * 补丁：更新项目部门的状态
	 */
	@Transactional(readOnly = false)
	public void updateDate(){
		int count = 0;
		List<CInsBusinessXmjbxxDeptRelation> allRelationList = relationService.findList(new CInsBusinessXmjbxxDeptRelation());
		for (CInsBusinessXmjbxxDeptRelation relation : allRelationList) {
			Xmjbxx xmjbxx = get(relation.getXmjbxx().getId());
			CInsBusinessXmjbxxDeptRelationSearchParameter parameter = new CInsBusinessXmjbxxDeptRelationSearchParameter();
			Office dept = officeService.get(relation.getDept().getId());
			parameter.setXmjbxx(xmjbxx);
			parameter.setDept(dept);

			// 三年滚动计划状态
			if (CInsBusinessXmjbxxDeptRelation.TYPE_SNGDJH.equals(relation.getType())) {
				// 纳入状态
				parameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_NDJHBS);
				List<CInsBusinessXmjbxxDeptRelation> ndjhbsList = relationService.findFullListByParameter(parameter);
				parameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_ZXJSJJ);
				List<CInsBusinessXmjbxxDeptRelation> zxjsjjList = relationService.findFullListByParameter(parameter);
				if (!ndjhbsList.isEmpty()) {
					relation.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_TXW_NDJHBS);
				} else if (!zxjsjjList.isEmpty()) {
					relation.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_TXW_ZXJSJJXM);
				}else {
					relation.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_SNGDJH_WTX);
				}

				// 报送状态
				parameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_YSB);
				List<CInsBusinessXmjbxxDeptRelation> ybsList = relationService.findFullListByParameter(parameter);
				if(!ybsList.isEmpty()){
					relation.setZt(CInsBusinessXmjbxxDeptRelation.ZT_SNGDJH_YBS);
				} else if (Xmjbxx.ZT_TZJH_DBQ.equals(xmjbxx.getZt()) && Global.YES.equals(xmjbxx.getSfth())) {
					relation.setZt(CInsBusinessXmjbxxDeptRelation.ZT_SNGDJH_BTH);
				}else{
					relation.setZt(CInsBusinessXmjbxxDeptRelation.ZT_SNGDJH_WBS);
				}
				relationService.save(relation);
			}

			// 储备库状态
			if (CInsBusinessXmjbxxDeptRelation.TYPE_CBK.equals(relation.getType())) {
				// 纳入状态
				if (Integer.parseInt(xmjbxx.getCj()) > Integer.parseInt(dept.getGrade()) ||
						(Integer.parseInt(xmjbxx.getCj()) == Integer.parseInt(dept.getGrade()) && Xmjbxx.STAGE_JHBZ.equals(xmjbxx.getStage()))) {
					relation.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_CBK_BTX);
				} else {
					relation.setNrzt(CInsBusinessXmjbxxDeptRelation.NRZT_CBK_WTX);
				}

				// 报送状态
				parameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_YSB);
				List<CInsBusinessXmjbxxDeptRelation> ybsList = relationService.findFullListByParameter(parameter);
				if(!ybsList.isEmpty()){
					relation.setZt(CInsBusinessXmjbxxDeptRelation.ZT_CBK_YBS);
				} else{
					relation.setZt(CInsBusinessXmjbxxDeptRelation.ZT_CBK_WBS);
				}

				// 最高储备层级
				parameter.setType(CInsBusinessXmjbxxDeptRelation.TYPE_CBK);
				parameter.setDept(null);
				List<CInsBusinessXmjbxxDeptRelation> cbkList = relationService.findFullListByParameter(parameter);
				if (!cbkList.isEmpty()) {
					Collections.sort(cbkList, new Comparator<CInsBusinessXmjbxxDeptRelation>() {
						@Override
						public int compare(CInsBusinessXmjbxxDeptRelation o1, CInsBusinessXmjbxxDeptRelation o2) {
							return Integer.parseInt(o2.getDept().getGrade()) - Integer.parseInt(o1.getDept().getGrade());
						}
					});
					relation.setZgcj(cbkList.get(0).getDept().getGrade());
				}
				relationService.save(relation);
			}

			logger.info("--------------- >>> 更新 " + ++count + "/" + allRelationList.size() + " 项目部门关系...");
		}
	}

    /**
     * 判断当前项目是否可编辑
     */
	public boolean isEditable(String xmjbxxId){
		Xmjbxx xmjbxx = get(xmjbxxId);
		if (Xmjbxx.SZT_WS.equals(xmjbxx.getSzt())) {
            return true;
        }else if(Xmjbxx.SZT_SD.equals(xmjbxx.getSzt())
                || Xmjbxx.SZT_TJ.equals(xmjbxx.getSzt())
                || Xmjbxx.SZT_CS.equals(xmjbxx.getSzt())
                || Xmjbxx.SZT_XBC.equals(xmjbxx.getSzt())){
			logger.info("项目【" + xmjbxx.getXmmc() + "】[id:" + xmjbxx.getId() + "]锁为锁定状态，不可编辑！");
            return false;
        }

        // 为空的话，允许编辑（但是正常情况下这个字段不为空，所以要排查）
		logger.error("项目【" + xmjbxx.getXmmc() + "】[id:" + xmjbxx.getId() + "]锁状态为空！");
		return true;
    }

    /**
     * 将投资平台的国别行业code搬到重大库。
	 * 现场同事已将国别行业配置到树型字典，但是没有配置 code，这里需要将投资平台国别行业的 sortcode 搬到对应数据行的 code
     */
    @Transactional(readOnly = false)
	public void moveTzptGbhyCode(){
		int count = 0;
		List<Map<String, String>> gbhyList = dao.findTzptGbhyList();
		for (Map<String, String> gbhy : gbhyList) {
			String sortCode = gbhy.get("sortCode");
			String sortName = gbhy.get("sortName");
			String parentId = gbhy.get("parentId");
			String layer = gbhy.get("layer");

			// 获取父节点，如果 parentId = 0000 则是根节点
			String parentSortCode = "";
			String parentSortName = "";
			Map<String, String> parentGbhy = dao.getTzptGbhy(parentId);
			if (null != parentGbhy) {
				parentSortCode = parentGbhy.get("sortCode");
				parentSortName = parentGbhy.get("sortName");
			}

			TreeDict parameter = new TreeDict();
			parameter.setType("gbhy");// 类型为国别行业
			parameter.setName(sortName);// 名称要相对应
			TreeDict parentParameter = new TreeDict();
			parentParameter.setCode(parentSortCode);// 父节点的code也要相对应
			parentParameter.setName(parentSortName);// 父节点的名称也要相对应
			parameter.setParent(parentParameter);
			Page<? extends TreeDict> page = parameter.getPage();
			page.setOrderBy("length(a.parent_ids) asc"); // 按层级排序，这里使用所有父节点id组成的字符串的长度的正序
			TreeDictDao treeDictDao = SpringContextHolder.getBean(TreeDictDao.class);
			List<TreeDict> treeDictList = treeDictDao.findListByNameAndParentName(parameter);
			if (!treeDictList.isEmpty()) {
				TreeDict treeDict = treeDictList.get(0);
				treeDict.setCode(sortCode);
				treeDictDao.update(treeDict);

				logger.info("更新国标行业code，获取数据：[" + count++ + "/" + gbhyList.size() + "]sortCode:" + sortCode + "\tsortName:" + sortName
						+ "\tlayer:" + layer + "\t parentSortCode:" + parentSortCode + "\tparentSortName:" + parentSortName);
				logger.info("更新国标行业code，设置数据[1/" + treeDictList.size() + "]name:" + treeDict.getName() + "\tcode:" + treeDict.getCode());
			}else{
				logger.error("更新国标行业code，数据：[" + count++ + "/" + gbhyList.size() + "]sortCode:" + sortCode + "\tsortName:" + sortName
						+ "\tlayer:" + layer + "\t parentSortCode:" + parentSortCode + "\tparentSortName：" + parentSortName + "在重大库无匹配数据！");
				throw new RuntimeException("更新国标行业code，数据：[" + count++ + "/" + gbhyList.size() + "]sortCode:" + sortCode + "\tsortName:"
						+ sortName + "\tlayer:" + layer + "\t parentSortCode:" + parentSortCode + "\tparentSortName：" + parentSortName + "在重大库无匹配数据！");
			}

		}
		logger.info("国标行业code更新完成！");
	}

    /**
     * 将投资平台的国别行业code搬到重大库。
	 * 现场同事已将国别行业配置到树型字典，但是没有配置 code，这里需要将投资平台国别行业的 sortcode 搬到对应数据行的 code
     */
    @Transactional(readOnly = false)
	public void moveTzptSshyCode(){
		int count = 0;
		List<Map<String, String>> gbhyList = dao.findTzptSshyList();
		for (Map<String, String> gbhy : gbhyList) {
			String sortCode = gbhy.get("sortCode");
			String sortName = gbhy.get("sortName");

			// 获取父节点，如果 parentId = 0000 则是根节点
			String parentSortCode = "";
			String parentSortName = "";
			Map<String, String> parentGbhy = dao.getTzptSshy(sortCode.subSequence(0,6).toString());
			if (null != parentGbhy && sortCode.length() > 6) {
				parentSortCode = parentGbhy.get("sortCode");
				parentSortName = parentGbhy.get("sortName");
			}

			TreeDict parameter = new TreeDict();
			parameter.setType("shhy");// 类型为国别行业
			parameter.setName(sortName);// 名称要相对应
			TreeDict parentParameter = new TreeDict();
			parentParameter.setName(parentSortName);// 父节点的名称也要相对应
			parameter.setParent(parentParameter);
			Page<? extends TreeDict> page = parameter.getPage();
			page.setOrderBy("length(a.parent_ids) asc"); // 按层级排序，这里使用所有父节点id组成的字符串的长度的正序
			TreeDictDao treeDictDao = SpringContextHolder.getBean(TreeDictDao.class);
			List<TreeDict> treeDictList = treeDictDao.findListByNameAndParentName(parameter);
			if (!treeDictList.isEmpty()) {
				TreeDict treeDict = treeDictList.get(0);
				treeDict.setCode(sortCode);
				treeDictDao.update(treeDict);

				logger.info("更新所属行业code，获取数据：[" + count++ + "/" + gbhyList.size() + "]sortCode:" + sortCode + "\tsortName:" + sortName
						+ "\t parentSortCode:" + parentSortCode + "\tparentSortName:" + parentSortName);
				logger.info("更新所属行业code，设置数据[1/" + treeDictList.size() + "]name:" + treeDict.getName() + "\tcode:" + treeDict.getCode());
			}else{
				logger.error("更新所属行业code，数据：[" + count++ + "/" + gbhyList.size() + "]sortCode:" + sortCode + "\tsortName:" + sortName
						+ "\t parentSortCode:" + parentSortCode + "\tparentSortName：" + parentSortName + "在重大库无匹配数据！");
				throw new RuntimeException("更新所属行业code，数据：[" + count++ + "/" + gbhyList.size() + "]sortCode:" + sortCode + "\tsortName:"
						+ sortName + "\t parentSortCode:" + parentSortCode + "\tparentSortName：" + parentSortName + "在重大库无匹配数据！");
			}

		}
		logger.info("所属行业code更新完成！");
	}
    
	
	public  String  getSbbmByXmjbxx(String xmjbxxid) {
		List  list =  dao.getSbbmByXmjbxx(xmjbxxid);
		Map<String, String>  namett = (Map<String, String>) list.get(0);
		String name = namett.get("NAME");
		
		return name;
	}
	public  String  getnamebyuserid(String userid) {
		List  list = dao.getnamebyuserid(userid);
		Map<String, String>  namett = (Map<String, String>) list.get(0);
		String name = namett.get("NAME");
		return name;
	}


}