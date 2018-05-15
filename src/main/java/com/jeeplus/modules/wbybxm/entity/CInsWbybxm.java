/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.wbybxm.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 5818项目Entity
 * @author zgl
 * @version 2017-12-02
 */
public class CInsWbybxm extends DataEntity<CInsWbybxm> {
	
	private static final long serialVersionUID = 1L;
	private String areaid;		// 区划id
	private String qhtype;		// 区划分类
	private String qhname;		// 区划名称
	private String sshy;		// 所属行业
	private String xmgs;		// 项目个数
	private String ztz;		// 总投资
	private String bndjhtz;		// 本年度计划投资
	private String bndywctz;		// 本年度已完成投资
	private String ykgxmgs;		// 已开工项目个数
	private String ywgxmgs;		// 已完工项目个数
	private String ndtzwcl;		// 年度投资完成率
	private String kgl;		// 开工率
	private String wgl;		// 完工率
	private String sslyid;		// 所属领域id
	private String sslyname;		// 所属领域名称
	
	public CInsWbybxm() {
		super();
	}

	public CInsWbybxm(String id){
		super(id);
	}

	@ExcelField(title="区划id", align=2, sort=1)
	public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	
	@ExcelField(title="区划分类", align=2, sort=2)
	public String getQhtype() {
		return qhtype;
	}

	public void setQhtype(String qhtype) {
		this.qhtype = qhtype;
	}
	
	@ExcelField(title="区划名称", align=2, sort=3)
	public String getQhname() {
		return qhname;
	}

	public void setQhname(String qhname) {
		this.qhname = qhname;
	}
	
	@ExcelField(title="所属行业", align=2, sort=4)
	public String getSshy() {
		return sshy;
	}

	public void setSshy(String sshy) {
		this.sshy = sshy;
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
	
	@ExcelField(title="本年度计划投资", align=2, sort=7)
	public String getBndjhtz() {
		return bndjhtz;
	}

	public void setBndjhtz(String bndjhtz) {
		this.bndjhtz = bndjhtz;
	}
	
	@ExcelField(title="本年度已完成投资", align=2, sort=8)
	public String getBndywctz() {
		return bndywctz;
	}

	public void setBndywctz(String bndywctz) {
		this.bndywctz = bndywctz;
	}
	
	@ExcelField(title="已开工项目个数", align=2, sort=9)
	public String getYkgxmgs() {
		return ykgxmgs;
	}

	public void setYkgxmgs(String ykgxmgs) {
		this.ykgxmgs = ykgxmgs;
	}
	
	@ExcelField(title="已完工项目个数", align=2, sort=10)
	public String getYwgxmgs() {
		return ywgxmgs;
	}

	public void setYwgxmgs(String ywgxmgs) {
		this.ywgxmgs = ywgxmgs;
	}
	
	@ExcelField(title="年度投资完成率", align=2, sort=11)
	public String getNdtzwcl() {
		return ndtzwcl;
	}

	public void setNdtzwcl(String ndtzwcl) {
		this.ndtzwcl = ndtzwcl;
	}
	
	@ExcelField(title="开工率", align=2, sort=12)
	public String getKgl() {
		return kgl;
	}

	public void setKgl(String kgl) {
		this.kgl = kgl;
	}
	
	@ExcelField(title="完工率", align=2, sort=13)
	public String getWgl() {
		return wgl;
	}

	public void setWgl(String wgl) {
		this.wgl = wgl;
	}
	
	@ExcelField(title="所属领域id", align=2, sort=14)
	public String getSslyid() {
		return sslyid;
	}

	public void setSslyid(String sslyid) {
		this.sslyid = sslyid;
	}
	
	@ExcelField(title="所属领域名称", align=2, sort=15)
	public String getSslyname() {
		return sslyname;
	}

	public void setSslyname(String sslyname) {
		this.sslyname = sslyname;
	}
	
}