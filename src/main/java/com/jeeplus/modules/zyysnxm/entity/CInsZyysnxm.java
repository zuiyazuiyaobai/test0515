/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.zyysnxm.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 中央预算内Entity
 * @author zgl
 * @version 2017-12-02
 */
public class CInsZyysnxm extends DataEntity<CInsZyysnxm> {
	
	private static final long serialVersionUID = 1L;
	private String ereaid;		// 区划id
	private String ereaname;		// 区划名称
	private String qyid;		// 区域id
	private String qyname;		// 区域名称
	private String zftzfx;		// 政府投资方向
	private String xmgs;		// 项目个数
	private String ztz;		// 总投资
	private String xdtzze;		// 下达投资总额
	private String xdtyys;		// 下达投资——中央预算内
	private String ykgxmgs;		// 已开工项目个数
	private String ywgxmgs;		// 已完工项目个数
	private String ztzwcqk;		// 总投资完成情况
	private String zyyswcqk;		// 中央预算完成情况
	private String tzwcl;		// 投资完成率
	private String zyyswcl;		// 中央预算完成lv
	private String ztzdwqk;		// 总投资到位情况
	private String zyysndwqk;		// 中央预算内到位情况
	private String zjdwqk;		// 资金到位情况
	private String zyysndwl;		// 中央预算内到位率
	private String ztzzfqk;		// 总投资支付情况
	private String zyyszfqk;		// 中央预算支付情况
	private String zjzfl;		// 资金支付率
	private String zyyszfl;		// 中央预算支付率
	private String kgl;		// 开工率
	private String wgl;		// 完工率
	
	public CInsZyysnxm() {
		super();
	}

	public CInsZyysnxm(String id){
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
	
	@ExcelField(title="区域id", align=2, sort=3)
	public String getQyid() {
		return qyid;
	}

	public void setQyid(String qyid) {
		this.qyid = qyid;
	}
	
	@ExcelField(title="区域名称", align=2, sort=4)
	public String getQyname() {
		return qyname;
	}

	public void setQyname(String qyname) {
		this.qyname = qyname;
	}
	
	@ExcelField(title="政府投资方向", align=2, sort=5)
	public String getZftzfx() {
		return zftzfx;
	}

	public void setZftzfx(String zftzfx) {
		this.zftzfx = zftzfx;
	}
	
	@ExcelField(title="项目个数", align=2, sort=6)
	public String getXmgs() {
		return xmgs;
	}

	public void setXmgs(String xmgs) {
		this.xmgs = xmgs;
	}
	
	@ExcelField(title="总投资", align=2, sort=7)
	public String getZtz() {
		return ztz;
	}

	public void setZtz(String ztz) {
		this.ztz = ztz;
	}
	
	@ExcelField(title="下达投资总额", align=2, sort=8)
	public String getXdtzze() {
		return xdtzze;
	}

	public void setXdtzze(String xdtzze) {
		this.xdtzze = xdtzze;
	}
	
	@ExcelField(title="下达投资——中央预算内", align=2, sort=9)
	public String getXdtyys() {
		return xdtyys;
	}

	public void setXdtyys(String xdtyys) {
		this.xdtyys = xdtyys;
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
	
	@ExcelField(title="总投资完成情况", align=2, sort=12)
	public String getZtzwcqk() {
		return ztzwcqk;
	}

	public void setZtzwcqk(String ztzwcqk) {
		this.ztzwcqk = ztzwcqk;
	}
	
	@ExcelField(title="中央预算完成情况", align=2, sort=13)
	public String getZyyswcqk() {
		return zyyswcqk;
	}

	public void setZyyswcqk(String zyyswcqk) {
		this.zyyswcqk = zyyswcqk;
	}
	
	@ExcelField(title="投资完成率", align=2, sort=14)
	public String getTzwcl() {
		return tzwcl;
	}

	public void setTzwcl(String tzwcl) {
		this.tzwcl = tzwcl;
	}
	
	@ExcelField(title="中央预算完成lv", align=2, sort=15)
	public String getZyyswcl() {
		return zyyswcl;
	}

	public void setZyyswcl(String zyyswcl) {
		this.zyyswcl = zyyswcl;
	}
	
	@ExcelField(title="总投资到位情况", align=2, sort=16)
	public String getZtzdwqk() {
		return ztzdwqk;
	}

	public void setZtzdwqk(String ztzdwqk) {
		this.ztzdwqk = ztzdwqk;
	}
	
	@ExcelField(title="中央预算内到位情况", align=2, sort=17)
	public String getZyysndwqk() {
		return zyysndwqk;
	}

	public void setZyysndwqk(String zyysndwqk) {
		this.zyysndwqk = zyysndwqk;
	}
	
	@ExcelField(title="资金到位情况", align=2, sort=18)
	public String getZjdwqk() {
		return zjdwqk;
	}

	public void setZjdwqk(String zjdwqk) {
		this.zjdwqk = zjdwqk;
	}
	
	@ExcelField(title="中央预算内到位率", align=2, sort=19)
	public String getZyysndwl() {
		return zyysndwl;
	}

	public void setZyysndwl(String zyysndwl) {
		this.zyysndwl = zyysndwl;
	}
	
	@ExcelField(title="总投资支付情况", align=2, sort=20)
	public String getZtzzfqk() {
		return ztzzfqk;
	}

	public void setZtzzfqk(String ztzzfqk) {
		this.ztzzfqk = ztzzfqk;
	}
	
	@ExcelField(title="中央预算支付情况", align=2, sort=21)
	public String getZyyszfqk() {
		return zyyszfqk;
	}

	public void setZyyszfqk(String zyyszfqk) {
		this.zyyszfqk = zyyszfqk;
	}
	
	@ExcelField(title="资金支付率", align=2, sort=22)
	public String getZjzfl() {
		return zjzfl;
	}

	public void setZjzfl(String zjzfl) {
		this.zjzfl = zjzfl;
	}
	
	@ExcelField(title="中央预算支付率", align=2, sort=23)
	public String getZyyszfl() {
		return zyyszfl;
	}

	public void setZyyszfl(String zyyszfl) {
		this.zyyszfl = zyyszfl;
	}
	
	@ExcelField(title="开工率", align=2, sort=24)
	public String getKgl() {
		return kgl;
	}

	public void setKgl(String kgl) {
		this.kgl = kgl;
	}
	
	@ExcelField(title="完工率", align=2, sort=25)
	public String getWgl() {
		return wgl;
	}

	public void setWgl(String wgl) {
		this.wgl = wgl;
	}
	
}