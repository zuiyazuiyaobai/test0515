package com.jeeplus.modules.xmjbxx.entity;
import com.jeeplus.common.persistence.DataEntity;
public class CompanyYljl extends DataEntity<CompanyYljl>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String xxlx;
	private String parentid;
	private String zlbm;
	private String zlyj;
	private String zlnr;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXxlx() {
		return xxlx;
	}
	public void setXxlx(String xxlx) {
		this.xxlx = xxlx;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getZlbm() {
		return zlbm;
	}
	public void setZlbm(String zlbm) {
		this.zlbm = zlbm;
	}
	public String getZlyj() {
		return zlyj;
	}
	public void setZlyj(String zlyj) {
		this.zlyj = zlyj;
	}
	public String getZlnr() {
		return zlnr;
	}
	public void setZlnr(String zlnr) {
		this.zlnr = zlnr;
	}
}
