/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.tj_sszdgjxmxx.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * tj_sszdgjxmxxEntity
 * @author zgl
 * @version 2018-03-17
 */
public class Tj_sszdgjxmxx extends DataEntity<Tj_sszdgjxmxx> {
	
	private static final long serialVersionUID = 1L;
	private String sszdgjxmsl;		// 分类
	private String jhztz;		// 计划总投资
	private String ndjhtz;		// 年度计划投资
	private String ndywctz;		// 年度已完成投资
	private String tzwcl;		// 投资完成率
	private String dywctz;		// 当月完成投资
	private String ykgxmsl;		// 已开工项目数量
	private String ytcxmsl;		// 已投产项目数量
	private String xtcxmsl;		// 新投产项目数量
	private String xdrxmsl;		// 新调入项目数量
	private String xdcxmsl;		// 新调出项目数量
	private String sign;		// 分类标记（1.入库项目数量 2.省（市）重点攻坚产业项目数量 3.各产业项目数量 4.技术改造项目数量 5.本年度计划新开工项目数量 6.年度计划新投产项目数量 7.本年度计划续建项目数量8.当月新开工项目数量 9.新调出项目数量）
	private String region;    //区划代码
	
	

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Tj_sszdgjxmxx() {
		super();
	}

	public Tj_sszdgjxmxx(String id){
		super(id);
	}

	@ExcelField(title="分类", align=2, sort=7)
	public String getSszdgjxmsl() {
		return sszdgjxmsl;
	}

	public void setSszdgjxmsl(String sszdgjxmsl) {
		this.sszdgjxmsl = sszdgjxmsl;
	}
	
	
	@ExcelField(title="计划总投资", align=2, sort=9)
	public String getJhztz() {
		return jhztz;
	}

	public void setJhztz(String jhztz) {
		this.jhztz = jhztz;
	}
	
	@ExcelField(title="年度计划投资", align=2, sort=10)
	public String getNdjhtz() {
		return ndjhtz;
	}

	public void setNdjhtz(String ndjhtz) {
		this.ndjhtz = ndjhtz;
	}
	
	@ExcelField(title="年度已完成投资", align=2, sort=11)
	public String getNdywctz() {
		return ndywctz;
	}

	public void setNdywctz(String ndywctz) {
		this.ndywctz = ndywctz;
	}
	
	@ExcelField(title="投资完成率", align=2, sort=12)
	public String getTzwcl() {
		return tzwcl;
	}

	public void setTzwcl(String tzwcl) {
		this.tzwcl = tzwcl;
	}
	
	@ExcelField(title="当月完成投资", align=2, sort=13)
	public String getDywctz() {
		return dywctz;
	}

	public void setDywctz(String dywctz) {
		this.dywctz = dywctz;
	}
	
	@ExcelField(title="已开工项目数量", align=2, sort=14)
	public String getYkgxmsl() {
		return ykgxmsl;
	}

	public void setYkgxmsl(String ykgxmsl) {
		this.ykgxmsl = ykgxmsl;
	}
	
	@ExcelField(title="已投产项目数量", align=2, sort=15)
	public String getYtcxmsl() {
		return ytcxmsl;
	}

	public void setYtcxmsl(String ytcxmsl) {
		this.ytcxmsl = ytcxmsl;
	}
	
	@ExcelField(title="新投产项目数量", align=2, sort=16)
	public String getXtcxmsl() {
		return xtcxmsl;
	}

	public void setXtcxmsl(String xtcxmsl) {
		this.xtcxmsl = xtcxmsl;
	}
	
	@ExcelField(title="新调入项目数量", align=2, sort=17)
	public String getXdrxmsl() {
		return xdrxmsl;
	}

	public void setXdrxmsl(String xdrxmsl) {
		this.xdrxmsl = xdrxmsl;
	}
	
	@ExcelField(title="新调出项目数量", align=2, sort=18)
	public String getXdcxmsl() {
		return xdcxmsl;
	}

	public void setXdcxmsl(String xdcxmsl) {
		this.xdcxmsl = xdcxmsl;
	}
	
	@ExcelField(title="分类标记（1.入库项目数量 2.省（市）重点攻坚产业项目数量 3.各产业项目数量 4.技术改造项目数量 5.本年度计划新开工项目数量 6.年度计划新投产项目数量 7.本年度计划续建项目数量8.当月新开工项目数量 9.新调出项目数量）", align=2, sort=19)
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
}