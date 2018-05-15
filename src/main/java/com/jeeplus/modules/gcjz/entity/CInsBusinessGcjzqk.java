/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.gcjz.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 工程进度 分市汇总Entity
 * @author gl
 * @version 2017-06-12
 */
public class CInsBusinessGcjzqk extends DataEntity<CInsBusinessGcjzqk> {
	
	private static final long serialVersionUID = 1L;
	private String xmid;		// 重点工程项目编号
	private String year;		// year
	private String month;		// month
	private String gcjdjzqkFileid;		// 工程节点进展情况—附件编号
	private String gcjdjzqkFilename;		// 工程节点进展情况—附件名称
	private String gcjdjzqkFilepath;		// 工程节点进展情况—附件路径
	private String gcsjxxqkFileid;		// 工程实际形象进展情况—附件编号
	private String gcsjxxqkFilename;		// 工程实际形象进展情况—附件名称
	private String gcsjxxqkFilepath;		// 工程实际形象进展情况—附件路径
	private Date createtime;		// createtime
	private String jdpj;		// 进度评价（1超前，2顺利，3缓慢，4滞后，5停工）
	private String xmTotal;     //项目数量
	private String cqNum;     //超前数量
	private String slNum;     //顺利数量
	private String hmNum;     //缓慢数量
	private String zhNum;     //滞后数量
	private String tgNum;     //停工数量
	private String areaname;     //区域名
	private String projectname;  //项目名称
	private String incname;  //项目申报单位
	private String projectid;//项目编号
	
	public CInsBusinessGcjzqk() {
		super();
	}

	public CInsBusinessGcjzqk(String id){
		super(id);
	}

	@ExcelField(title="重点工程项目编号", align=2, sort=1)
	public String getXmid() {
		return xmid;
	}

	public void setXmid(String xmid) {
		this.xmid = xmid;
	}
	
	@ExcelField(title="year", align=2, sort=2)
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	@ExcelField(title="month", align=2, sort=3)
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	@ExcelField(title="工程节点进展情况—附件编号", align=2, sort=4)
	public String getGcjdjzqkFileid() {
		return gcjdjzqkFileid;
	}

	public void setGcjdjzqkFileid(String gcjdjzqkFileid) {
		this.gcjdjzqkFileid = gcjdjzqkFileid;
	}
	
	@ExcelField(title="工程节点进展情况—附件名称", align=2, sort=5)
	public String getGcjdjzqkFilename() {
		return gcjdjzqkFilename;
	}

	public void setGcjdjzqkFilename(String gcjdjzqkFilename) {
		this.gcjdjzqkFilename = gcjdjzqkFilename;
	}
	
	@ExcelField(title="工程节点进展情况—附件路径", align=2, sort=6)
	public String getGcjdjzqkFilepath() {
		return gcjdjzqkFilepath;
	}

	public void setGcjdjzqkFilepath(String gcjdjzqkFilepath) {
		this.gcjdjzqkFilepath = gcjdjzqkFilepath;
	}
	
	@ExcelField(title="工程实际形象进展情况—附件编号", align=2, sort=7)
	public String getGcsjxxqkFileid() {
		return gcsjxxqkFileid;
	}

	public void setGcsjxxqkFileid(String gcsjxxqkFileid) {
		this.gcsjxxqkFileid = gcsjxxqkFileid;
	}
	
	@ExcelField(title="工程实际形象进展情况—附件名称", align=2, sort=8)
	public String getGcsjxxqkFilename() {
		return gcsjxxqkFilename;
	}

	public void setGcsjxxqkFilename(String gcsjxxqkFilename) {
		this.gcsjxxqkFilename = gcsjxxqkFilename;
	}
	
	@ExcelField(title="工程实际形象进展情况—附件路径", align=2, sort=9)
	public String getGcsjxxqkFilepath() {
		return gcsjxxqkFilepath;
	}

	public void setGcsjxxqkFilepath(String gcsjxxqkFilepath) {
		this.gcsjxxqkFilepath = gcsjxxqkFilepath;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="createtime不能为空")
	@ExcelField(title="createtime", align=2, sort=10)
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@ExcelField(title="进度评价（1超前，2顺利，3缓慢，4滞后，5停工）", align=2, sort=11)
	public String getJdpj() {
		return jdpj;
	}

	public void setJdpj(String jdpj) {
		this.jdpj = jdpj;
	}

	public String getXmTotal() {
		return xmTotal;
	}

	public void setXmTotal(String xmTotal) {
		this.xmTotal = xmTotal;
	}

	public String getCqNum() {
		return cqNum;
	}

	public void setCqNum(String cqNum) {
		this.cqNum = cqNum;
	}

	public String getSlNum() {
		return slNum;
	}

	public void setSlNum(String slNum) {
		this.slNum = slNum;
	}

	public String getHmNum() {
		return hmNum;
	}

	public void setHmNum(String hmNum) {
		this.hmNum = hmNum;
	}

	public String getZhNum() {
		return zhNum;
	}

	public void setZhNum(String zhNum) {
		this.zhNum = zhNum;
	}

	public String getTgNum() {
		return tgNum;
	}

	public void setTgNum(String tgNum) {
		this.tgNum = tgNum;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getIncname() {
		return incname;
	}

	public void setIncname(String incname) {
		this.incname = incname;
	}

	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	
}