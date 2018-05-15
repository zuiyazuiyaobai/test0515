/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.zdxmwt.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 重点项目存在问题Entity
 * @author gl
 * @version 2017-06-06
 */
public class CInsBusinessZdxmwt extends DataEntity<CInsBusinessZdxmwt> {
	
	private static final long serialVersionUID = 1L;
	private String projectid;		// 项目编码
	private String cbsnum;		// 并联业务编码
	private String wttype;		// 问题类型（1审批手续，2建设环境，3资金问题，4其他问题）
	private String stagetype;		// 类型选择（1.立项，2环评，3规划，4土地，5其他，6征地，7拆迁，8阻工扰工）
	private String wtdescribe;		// 问题描述
	private String wtdescribexml;		// 问题描述附件信息
	private Date createtime;		// 创建时间
	private String remark;		// 备注
	private String zdgcxmbh;		// 重点工程项目编号
	private String wtlevel;		// 问题层级(1、国家级,2、省级,3、市级,4、县级)多选、隔开。
	private String status;		// 办理状态(0、待处理，1、已分发，2、处理中,3、办结)
	private String bltype;		// 处理类型(1、内部处理,2、外部处理,3、推送至13710)
	private String ssgzr;		// 所剩工作日
	private Date bjtime;		// 办结时间
	private String deptid;      //问题分发部门
	private String hfid;        //回复id
	private String wtclyj;      //综合回复意见
	
	public CInsBusinessZdxmwt() {
		super();
	}

	public CInsBusinessZdxmwt(String id){
		super(id);
	}

	@ExcelField(title="项目编码", align=2, sort=1)
	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	
	@ExcelField(title="并联业务编码", align=2, sort=2)
	public String getCbsnum() {
		return cbsnum;
	}

	public void setCbsnum(String cbsnum) {
		this.cbsnum = cbsnum;
	}
	
	@ExcelField(title="问题类型（1审批手续，2建设环境，3资金问题，4其他问题）", align=2, sort=3)
	public String getWttype() {
		return wttype;
	}

	public void setWttype(String wttype) {
		this.wttype = wttype;
	}
	
	@ExcelField(title="类型选择（1.立项，2环评，3规划，4土地，5其他，6征地，7拆迁，8阻工扰工）", align=2, sort=4)
	public String getStagetype() {
		return stagetype;
	}

	public void setStagetype(String stagetype) {
		this.stagetype = stagetype;
	}
	
	@ExcelField(title="问题描述", align=2, sort=5)
	public String getWtdescribe() {
		return wtdescribe;
	}

	public void setWtdescribe(String wtdescribe) {
		this.wtdescribe = wtdescribe;
	}
	
	@ExcelField(title="问题描述附件信息", align=2, sort=6)
	public String getWtdescribexml() {
		return wtdescribexml;
	}

	public void setWtdescribexml(String wtdescribexml) {
		this.wtdescribexml = wtdescribexml;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="创建时间", align=2, sort=7)
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@ExcelField(title="备注", align=2, sort=8)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@ExcelField(title="重点工程项目编号", align=2, sort=9)
	public String getZdgcxmbh() {
		return zdgcxmbh;
	}

	public void setZdgcxmbh(String zdgcxmbh) {
		this.zdgcxmbh = zdgcxmbh;
	}
	
	@ExcelField(title="问题层级(1、国家级,2、省级,3、市级,4、县级)多选、隔开。", align=2, sort=10)
	public String getWtlevel() {
		return wtlevel;
	}

	public void setWtlevel(String wtlevel) {
		this.wtlevel = wtlevel;
	}
	
	@ExcelField(title="办理状态(0、待处理，1、已分发，2、处理中,3、办结)", align=2, sort=11)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@ExcelField(title="处理类型(1、内部处理,2、外部处理,3、推送至13710)", align=2, sort=12)
	public String getBltype() {
		return bltype;
	}

	public void setBltype(String bltype) {
		this.bltype = bltype;
	}
	
	@ExcelField(title="所剩工作日", align=2, sort=13)
	public String getSsgzr() {
		return ssgzr;
	}

	public void setSsgzr(String ssgzr) {
		this.ssgzr = ssgzr;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="办结时间", align=2, sort=14)
	public Date getBjtime() {
		return bjtime;
	}

	public void setBjtime(Date bjtime) {
		this.bjtime = bjtime;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getHfid() {
		return hfid;
	}

	public void setHfid(String hfid) {
		this.hfid = hfid;
	}

	public String getWtclyj() {
		return wtclyj;
	}

	public void setWtclyj(String wtclyj) {
		this.wtclyj = wtclyj;
	}
	
}