/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sjjxm.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 省基建项目Entity
 * @author zgl
 * @version 2017-12-02
 */
public class CInsSjjxm extends DataEntity<CInsSjjxm> {
	
	private static final long serialVersionUID = 1L;
	private String ereaid;		// 区划id
	private String ereaname;		// 区划名称
	private String hyid;		// 行业id
	private String hnname;		// 行业名称
	private String xmgs;		// 项目个数
	private String ztz;		// 总投资
	private String xdtzze;		// 下达投资总额
	private String xdtzSjjtz;		// 下达投资-省基建投资
	private String ykgxmgs;		// 已开工项目个数
	private String ywgxmgs;		// 已完工项目个数
	private String ztzwcqk;		// 总投资完成情况
	private String sjjtzwcqk;		// 省基建投资完成情况
	private String tzwcl;		// 投资完成率
	private String sjjtzwcl;		// 省基建投资完成率
	private String ztzdwqk;		// 总投资到位情况
	private String sjjtzdwqk;		// 省基建投资到位情况
	private String zjdwl;		// 资金到位率
	private String sjjtzdwl;		// 省基建投资到位率
	private String ztzzfqk;		// 总投资字符情况
	private String sjjtzzfqk;		// 省基建投资支付情况
	private String zjzfl;		// 资金支付率
	private String sjjtzzfl;		// 省级基建投资支付率
	private String kgl;		// 开工率
	private String wgl;		// 完工率
	
	public CInsSjjxm() {
		super();
	}

	public CInsSjjxm(String id){
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
	
	@ExcelField(title="行业名称", align=2, sort=4)
	public String getHnname() {
		return hnname;
	}

	public void setHnname(String hnname) {
		this.hnname = hnname;
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
	
	@ExcelField(title="下达投资总额", align=2, sort=7)
	public String getXdtzze() {
		return xdtzze;
	}

	public void setXdtzze(String xdtzze) {
		this.xdtzze = xdtzze;
	}
	
	@ExcelField(title="下达投资-省基建投资", align=2, sort=8)
	public String getXdtzSjjtz() {
		return xdtzSjjtz;
	}

	public void setXdtzSjjtz(String xdtzSjjtz) {
		this.xdtzSjjtz = xdtzSjjtz;
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
	
	@ExcelField(title="总投资完成情况", align=2, sort=11)
	public String getZtzwcqk() {
		return ztzwcqk;
	}

	public void setZtzwcqk(String ztzwcqk) {
		this.ztzwcqk = ztzwcqk;
	}
	
	@ExcelField(title="省基建投资完成情况", align=2, sort=12)
	public String getSjjtzwcqk() {
		return sjjtzwcqk;
	}

	public void setSjjtzwcqk(String sjjtzwcqk) {
		this.sjjtzwcqk = sjjtzwcqk;
	}
	
	@ExcelField(title="投资完成率", align=2, sort=13)
	public String getTzwcl() {
		return tzwcl;
	}

	public void setTzwcl(String tzwcl) {
		this.tzwcl = tzwcl;
	}
	
	@ExcelField(title="省基建投资完成率", align=2, sort=14)
	public String getSjjtzwcl() {
		return sjjtzwcl;
	}

	public void setSjjtzwcl(String sjjtzwcl) {
		this.sjjtzwcl = sjjtzwcl;
	}
	
	@ExcelField(title="总投资到位情况", align=2, sort=15)
	public String getZtzdwqk() {
		return ztzdwqk;
	}

	public void setZtzdwqk(String ztzdwqk) {
		this.ztzdwqk = ztzdwqk;
	}
	
	@ExcelField(title="省基建投资到位情况", align=2, sort=16)
	public String getSjjtzdwqk() {
		return sjjtzdwqk;
	}

	public void setSjjtzdwqk(String sjjtzdwqk) {
		this.sjjtzdwqk = sjjtzdwqk;
	}
	
	@ExcelField(title="资金到位率", align=2, sort=17)
	public String getZjdwl() {
		return zjdwl;
	}

	public void setZjdwl(String zjdwl) {
		this.zjdwl = zjdwl;
	}
	
	@ExcelField(title="省基建投资到位率", align=2, sort=18)
	public String getSjjtzdwl() {
		return sjjtzdwl;
	}

	public void setSjjtzdwl(String sjjtzdwl) {
		this.sjjtzdwl = sjjtzdwl;
	}
	
	@ExcelField(title="总投资字符情况", align=2, sort=19)
	public String getZtzzfqk() {
		return ztzzfqk;
	}

	public void setZtzzfqk(String ztzzfqk) {
		this.ztzzfqk = ztzzfqk;
	}
	
	@ExcelField(title="省基建投资支付情况", align=2, sort=20)
	public String getSjjtzzfqk() {
		return sjjtzzfqk;
	}

	public void setSjjtzzfqk(String sjjtzzfqk) {
		this.sjjtzzfqk = sjjtzzfqk;
	}
	
	@ExcelField(title="资金支付率", align=2, sort=21)
	public String getZjzfl() {
		return zjzfl;
	}

	public void setZjzfl(String zjzfl) {
		this.zjzfl = zjzfl;
	}
	
	@ExcelField(title="省级基建投资支付率", align=2, sort=22)
	public String getSjjtzzfl() {
		return sjjtzzfl;
	}

	public void setSjjtzzfl(String sjjtzzfl) {
		this.sjjtzzfl = sjjtzzfl;
	}
	
	@ExcelField(title="开工率", align=2, sort=23)
	public String getKgl() {
		return kgl;
	}

	public void setKgl(String kgl) {
		this.kgl = kgl;
	}
	
	@ExcelField(title="完工率", align=2, sort=24)
	public String getWgl() {
		return wgl;
	}

	public void setWgl(String wgl) {
		this.wgl = wgl;
	}
	
}