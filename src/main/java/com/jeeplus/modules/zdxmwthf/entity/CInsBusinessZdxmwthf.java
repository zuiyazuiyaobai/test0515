/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.zdxmwthf.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.zdxmwt.entity.CInsBusinessZdxmwt;

/**
 * 重点项目问题回复Entity
 * @author gl
 * @version 2017-06-06
 */
public class CInsBusinessZdxmwthf extends DataEntity<CInsBusinessZdxmwthf> {
	
	private static final long serialVersionUID = 1L;
	private String wtid;		// 问题id
	private String deptid;		// 回复部门
	private String userid;		// 回复人
	private String hfnr;		// 回复内容
	private String hfnrxml;		// 回复内容附件信息
	private String sfhf;		// 是否回复（0未回复，1已回复）
	private Date hftime;		// 回复时间
	private String remark;		// 备注
	private Date createtime;		// 创建时间
	private String ssgzr;		// 所剩工作日
	private String hzid;		// 督办通知回执id(对应表t_ins_slhz表的id)
	private String ffidea;		// 分发意见
	private CInsBusinessZdxmwt cInsBusinessZdxmwt;//问题信息
	private String wtclyj;      //办结处理意见
	public CInsBusinessZdxmwthf() {
		super();
	}

	public CInsBusinessZdxmwthf(String id){
		super(id);
	}

	@ExcelField(title="问题id", align=2, sort=1)
	public String getWtid() {
		return wtid;
	}

	public void setWtid(String wtid) {
		this.wtid = wtid;
	}
	
	@ExcelField(title="回复部门", align=2, sort=2)
	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	
	@ExcelField(title="回复人", align=2, sort=3)
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@ExcelField(title="回复内容", align=2, sort=4)
	public String getHfnr() {
		return hfnr;
	}

	public void setHfnr(String hfnr) {
		this.hfnr = hfnr;
	}
	
	@ExcelField(title="回复内容附件信息", align=2, sort=5)
	public String getHfnrxml() {
		return hfnrxml;
	}

	public void setHfnrxml(String hfnrxml) {
		this.hfnrxml = hfnrxml;
	}
	
	@ExcelField(title="是否回复（0未回复，1已回复）", align=2, sort=6)
	public String getSfhf() {
		return sfhf;
	}

	public void setSfhf(String sfhf) {
		this.sfhf = sfhf;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="回复时间", align=2, sort=7)
	public Date getHftime() {
		return hftime;
	}

	public void setHftime(Date hftime) {
		this.hftime = hftime;
	}
	
	@ExcelField(title="备注", align=2, sort=8)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="创建时间", align=2, sort=9)
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@ExcelField(title="所剩工作日", align=2, sort=10)
	public String getSsgzr() {
		return ssgzr;
	}

	public void setSsgzr(String ssgzr) {
		this.ssgzr = ssgzr;
	}
	
	@ExcelField(title="督办通知回执id(对应表t_ins_slhz表的id)", align=2, sort=11)
	public String getHzid() {
		return hzid;
	}

	public void setHzid(String hzid) {
		this.hzid = hzid;
	}
	
	@ExcelField(title="分发意见", align=2, sort=12)
	public String getFfidea() {
		return ffidea;
	}

	public void setFfidea(String ffidea) {
		this.ffidea = ffidea;
	}

	public CInsBusinessZdxmwt getcInsBusinessZdxmwt() {
		return cInsBusinessZdxmwt;
	}

	public void setcInsBusinessZdxmwt(CInsBusinessZdxmwt cInsBusinessZdxmwt) {
		this.cInsBusinessZdxmwt = cInsBusinessZdxmwt;
	}

	public String getWtclyj() {
		return wtclyj;
	}

	public void setWtclyj(String wtclyj) {
		this.wtclyj = wtclyj;
	}
	
}