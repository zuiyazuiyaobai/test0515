/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.szdxm.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 重点项目Entity
 * @author zgl
 * @version 2017-12-01
 */
public class CInsSzdxm extends DataEntity<CInsSzdxm> {
	
	private static final long serialVersionUID = 1L;
	private String hyid;		// hyid
	private String hyname;		// hyname
	private String xmgs;		// xmgs
	private String ztz;		// ztz
	private String ndjhtz;		// ndjhtz
	private String ywctz;		// ywctz
	private String bndywctz;		// bndywctz
	private String ykgxmgs;		// ykgxmgs
	private String ywgxmgs;		// ywgxmgs
	private String tzwcl;		// tzwcl
	private String ndtzwcl;		// ndtzwcl
	private String ykgzykgbl;		// ykgzykgbl
	private String ywgzywgbl;		// ywgzywgbl
	
	public CInsSzdxm() {
		super();
	}

	public CInsSzdxm(String id){
		super(id);
	}

	@ExcelField(title="hyid", align=2, sort=1)
	public String getHyid() {
		return hyid;
	}

	public void setHyid(String hyid) {
		this.hyid = hyid;
	}
	
	@ExcelField(title="hyname", align=2, sort=2)
	public String getHyname() {
		return hyname;
	}

	public void setHyname(String hyname) {
		this.hyname = hyname;
	}
	
	@ExcelField(title="xmgs", align=2, sort=3)
	public String getXmgs() {
		return xmgs;
	}

	public void setXmgs(String xmgs) {
		this.xmgs = xmgs;
	}
	
	@ExcelField(title="ztz", align=2, sort=4)
	public String getZtz() {
		return ztz;
	}

	public void setZtz(String ztz) {
		this.ztz = ztz;
	}
	
	@ExcelField(title="ndjhtz", align=2, sort=5)
	public String getNdjhtz() {
		return ndjhtz;
	}

	public void setNdjhtz(String ndjhtz) {
		this.ndjhtz = ndjhtz;
	}
	
	@ExcelField(title="ywctz", align=2, sort=6)
	public String getYwctz() {
		return ywctz;
	}

	public void setYwctz(String ywctz) {
		this.ywctz = ywctz;
	}
	
	@ExcelField(title="bndywctz", align=2, sort=7)
	public String getBndywctz() {
		return bndywctz;
	}

	public void setBndywctz(String bndywctz) {
		this.bndywctz = bndywctz;
	}
	
	@ExcelField(title="ykgxmgs", align=2, sort=8)
	public String getYkgxmgs() {
		return ykgxmgs;
	}

	public void setYkgxmgs(String ykgxmgs) {
		this.ykgxmgs = ykgxmgs;
	}
	
	@ExcelField(title="ywgxmgs", align=2, sort=9)
	public String getYwgxmgs() {
		return ywgxmgs;
	}

	public void setYwgxmgs(String ywgxmgs) {
		this.ywgxmgs = ywgxmgs;
	}
	
	@ExcelField(title="tzwcl", align=2, sort=10)
	public String getTzwcl() {
		return tzwcl;
	}

	public void setTzwcl(String tzwcl) {
		this.tzwcl = tzwcl;
	}
	
	@ExcelField(title="ndtzwcl", align=2, sort=11)
	public String getNdtzwcl() {
		return ndtzwcl;
	}

	public void setNdtzwcl(String ndtzwcl) {
		this.ndtzwcl = ndtzwcl;
	}
	
	@ExcelField(title="ykgzykgbl", align=2, sort=12)
	public String getYkgzykgbl() {
		return ykgzykgbl;
	}

	public void setYkgzykgbl(String ykgzykgbl) {
		this.ykgzykgbl = ykgzykgbl;
	}
	
	@ExcelField(title="ywgzywgbl", align=2, sort=13)
	public String getYwgzywgbl() {
		return ywgzywgbl;
	}

	public void setYwgzywgbl(String ywgzywgbl) {
		this.ywgzywgbl = ywgzywgbl;
	}
	
}