/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.entity.sub;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.xmjbxx.entity.Xmjbxx;

/**
 * 项目公司Entity
 * @author zcl
 * @version 2017-10-25
 */
public class CInsBusinessXmgs extends DataEntity<CInsBusinessXmgs> {
	
	private static final long serialVersionUID = 1L;
	private Xmjbxx xmjbxx;		// 项目ID
	private String gdmc;		// 股东名称
	private String xz;		// 性质（国有、民营...）
	private Double cz;		// 出资（万元）
	private Double bfb;		// 百分比（%）
	
	public CInsBusinessXmgs() {
		super();
	}

	public CInsBusinessXmgs(String id){
		super(id);
	}

	public Xmjbxx getXmjbxx() {
		return xmjbxx;
	}

	public void setXmjbxx(Xmjbxx xmjbxx) {
		this.xmjbxx = xmjbxx;
	}
	
	@ExcelField(title="股东名称", align=2, sort=8)
	public String getGdmc() {
		return gdmc;
	}

	public void setGdmc(String gdmc) {
		this.gdmc = gdmc;
	}
	
	@ExcelField(title="性质（国有、民营...）", align=2, sort=9)
	public String getXz() {
		return xz;
	}

	public void setXz(String xz) {
		this.xz = xz;
	}
	
	@ExcelField(title="出资（万元）", align=2, sort=10)
	public Double getCz() {
		return cz;
	}

	public void setCz(Double cz) {
		this.cz = cz;
	}
	
	@ExcelField(title="百分比（%）", align=2, sort=11)
	public Double getBfb() {
		return bfb;
	}

	public void setBfb(Double bfb) {
		this.bfb = bfb;
	}
	
}