/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.xmjbxx.entity.sub.CInsBusinessZjlbNtz;

import java.util.List;

/**
 * 基本信息中的投资情况Entity
 * @author yw
 * @version 2017-09-25
 */
public class CInsBusinessTzqk extends DataEntity<CInsBusinessTzqk> {
	
	private static final long serialVersionUID = 1L;
	private Xmjbxx xmjbxx;		// 项目id
	private String zjlb;		// 资金类别
	private Double ztz;		// 总投资（万元）
	private Double ljxdtz;		// 累计下达投资（万元）
	private Double ljwctz;		// 累计完成投资
	private Double zjxq;		// 资金需求
	private String year;		// 年份  (以后删除，与关联表重复)
	private Double zbj;			//资本金（万元）
	private Double bcsqzxjszj; //	本次申请专项建设资金（万元）
	private String qt;
	private Integer sort;
	private String updatestatus;
	
	@Deprecated
	private String ljdwzj;		//累计到位资金

	private List<CInsBusinessZjlbNtz> ntz;//资本金缺口
	private List<CInsBusinessZjlbNtz> zjxqs;//资金需求

	public CInsBusinessTzqk() {
		super();
	}

	public CInsBusinessTzqk(String id){
		super(id);
	}

	@ExcelField(title="项目", align=2, sort=7)
	public Xmjbxx getXmjbxx() {
		return this.xmjbxx;
	}

	public void setXmjbxx(Xmjbxx xmjbxx) {
		this.xmjbxx = xmjbxx;
	}
	
	@ExcelField(title="资金类别", align=2, sort=8)
	public String getZjlb() {
		return zjlb;
	}

	public void setZjlb(String zjlb) {
		this.zjlb = zjlb;
	}
	
	@ExcelField(title="总投资（万元）", align=2, sort=9)
	public Double getZtz() {
		return ztz;
	}

	public void setZtz(Double ztz) {
		this.ztz = ztz;
	}
	
	@ExcelField(title="累计下达投资（万元）", align=2, sort=10)
	public Double getLjxdtz() {
		return ljxdtz;
	}

	public void setLjxdtz(Double ljxdtz) {
		this.ljxdtz = ljxdtz;
	}
	
	@ExcelField(title="累计完成投资", align=2, sort=11)
	public Double getLjwctz() {
		return ljwctz;
	}

	public void setLjwctz(Double ljwctz) {
		this.ljwctz = ljwctz;
	}
	
	@ExcelField(title="资金需求", align=2, sort=12)
	public Double getZjxq() {
		return zjxq;
	}

	public void setZjxq(Double zjxq) {
		this.zjxq = zjxq;
	}
	
	@ExcelField(title="年份", align=2, sort=13)
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Double getZbj() {
		return zbj;
	}

	public void setZbj(Double zbj) {
		this.zbj = zbj;
	}

	public Double getBcsqzxjszj() {
		return bcsqzxjszj;
	}

	public void setBcsqzxjszj(Double bcsqzxjszj) {
		this.bcsqzxjszj = bcsqzxjszj;
	}

	public String getQt() {
		return qt;
	}

	public void setQt(String qt) {
		this.qt = qt;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getLjdwzj() {
		return ljdwzj;
	}

	public void setLjdwzj(String ljdwzj) {
		this.ljdwzj = ljdwzj;
	}

	public List<CInsBusinessZjlbNtz> getNtz() {
		return ntz;
	}

	public void setNtz(List<CInsBusinessZjlbNtz> ntz) {
		this.ntz = ntz;
	}

	public List<CInsBusinessZjlbNtz> getZjxqs() {
		return zjxqs;
	}

	public void setZjxqs(List<CInsBusinessZjlbNtz> zjxqs) {
		this.zjxqs = zjxqs;
	}

	public String getUpdatestatus() {
		return updatestatus;
	}

	public void setUpdatestatus(String updatestatus) {
		this.updatestatus = updatestatus;
	}
}