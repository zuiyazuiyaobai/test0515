/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.qtxm.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 其他项目Entity
 * @author zgl
 * @version 2017-12-02
 */
public class CInsJbxm extends DataEntity<CInsJbxm> {
	
	private static final long serialVersionUID = 1L;
	private String ereaid;		// 区划id
	private String ereaname;		// 区划名称
	private String hyid;		// 行业id
	private String hyname;		// 行业名字
	private String xmgs;		// 项目个数
	private String ztz;		// 总投资
	private String ndjhtz;		// 年度计划投资
	private String ywctz;		// 已完成投资
	private String bndywctz;		// 本年度已完成投资
	private String ykgxmgs;		// 已开工项目个数
	private String ywgxmgs;		// 已完工项目个数
	private String tzwcl;		// 投资完成率
	private String ndtzwcl;		// 年度投资完成率
	private String ykgzykgbl;		// 已开工占应开工比例
	private String ywgzywgbl;		// 已完工站应完工比例
	
	public CInsJbxm() {
		super();
	}

	public CInsJbxm(String id){
		super(id);
	}

	@ExcelField(title="区划id", align=2, sort=1)
	public String getEreaid() {
		return ereaid;
	}

	public void setEreaid(String ereaid) {
		this.ereaid = ereaid;
	}
	
	@ExcelField(title="区划名称", align=2, sort=2)
	public String getEreaname() {
		return ereaname;
	}

	public void setEreaname(String ereaname) {
		this.ereaname = ereaname;
	}
	
	@ExcelField(title="行业id", align=2, sort=3)
	public String getHyid() {
		return hyid;
	}

	public void setHyid(String hyid) {
		this.hyid = hyid;
	}
	
	@ExcelField(title="行业名字", align=2, sort=4)
	public String getHyname() {
		return hyname;
	}

	public void setHyname(String hyname) {
		this.hyname = hyname;
	}
	
	@ExcelField(title="项目个数", align=2, sort=5)
	public String getXmgs() {
		return xmgs;
	}

	public void setXmgs(String xmgs) {
		this.xmgs = xmgs;
	}
	
	@ExcelField(title="总投资", align=2, sort=6)
	public String getZtz() {
		return ztz;
	}

	public void setZtz(String ztz) {
		this.ztz = ztz;
	}
	
	@ExcelField(title="年度计划投资", align=2, sort=7)
	public String getNdjhtz() {
		return ndjhtz;
	}

	public void setNdjhtz(String ndjhtz) {
		this.ndjhtz = ndjhtz;
	}
	
	@ExcelField(title="已完成投资", align=2, sort=8)
	public String getYwctz() {
		return ywctz;
	}

	public void setYwctz(String ywctz) {
		this.ywctz = ywctz;
	}
	
	@ExcelField(title="本年度已完成投资", align=2, sort=9)
	public String getBndywctz() {
		return bndywctz;
	}

	public void setBndywctz(String bndywctz) {
		this.bndywctz = bndywctz;
	}
	
	@ExcelField(title="已开工项目个数", align=2, sort=10)
	public String getYkgxmgs() {
		return ykgxmgs;
	}

	public void setYkgxmgs(String ykgxmgs) {
		this.ykgxmgs = ykgxmgs;
	}
	
	@ExcelField(title="已完工项目个数", align=2, sort=11)
	public String getYwgxmgs() {
		return ywgxmgs;
	}

	public void setYwgxmgs(String ywgxmgs) {
		this.ywgxmgs = ywgxmgs;
	}
	
	@ExcelField(title="投资完成率", align=2, sort=12)
	public String getTzwcl() {
		return tzwcl;
	}

	public void setTzwcl(String tzwcl) {
		this.tzwcl = tzwcl;
	}
	
	@ExcelField(title="年度投资完成率", align=2, sort=13)
	public String getNdtzwcl() {
		return ndtzwcl;
	}

	public void setNdtzwcl(String ndtzwcl) {
		this.ndtzwcl = ndtzwcl;
	}
	
	@ExcelField(title="已开工占应开工比例", align=2, sort=14)
	public String getYkgzykgbl() {
		return ykgzykgbl;
	}

	public void setYkgzykgbl(String ykgzykgbl) {
		this.ykgzykgbl = ykgzykgbl;
	}
	
	@ExcelField(title="已完工站应完工比例", align=2, sort=15)
	public String getYwgzywgbl() {
		return ywgzywgbl;
	}

	public void setYwgzywgbl(String ywgzywgbl) {
		this.ywgzywgbl = ywgzywgbl;
	}
	
}