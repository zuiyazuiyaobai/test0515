/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 基本信息中的投资情况资金类别关联表Entity
 * @author yw
 * @version 2017-09-25
 */
@Deprecated //暂时没用到这个表
public class CInsBusinessZjlb extends DataEntity<CInsBusinessZjlb> {
	
	private static final long serialVersionUID = 1L;
	private String xmid;		// 项目id
	private String zjlb;		// 资金类别
	
	public CInsBusinessZjlb() {
		super();
	}

	public CInsBusinessZjlb(String id){
		super(id);
	}

	@ExcelField(title="项目id", align=2, sort=7)
	public String getXmid() {
		return xmid;
	}

	public void setXmid(String xmid) {
		this.xmid = xmid;
	}
	
	@ExcelField(title="资金类别", align=2, sort=8)
	public String getZjlb() {
		return zjlb;
	}

	public void setZjlb(String zjlb) {
		this.zjlb = zjlb;
	}
	
}