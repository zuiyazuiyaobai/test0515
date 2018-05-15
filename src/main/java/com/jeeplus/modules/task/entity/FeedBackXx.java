package com.jeeplus.modules.task.entity;
import java.util.Date;

import com.jeeplus.common.persistence.DataEntity;
public class FeedBackXx extends DataEntity<FeedBackXx>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String objname;
	private String objtype;
	private String creditcode;
	private Date executedt;
	private String executeunit;
	private String accordingto;
	private String measurename;
	private String matter;
	private String content;
	private String money;
	private String backtype;
	private String result;
	private String remark;
	private String flag;
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getObjname() {
		return objname;
	}
	public void setObjname(String objname) {
		this.objname = objname;
	}
	public String getObjtype() {
		return objtype;
	}
	public void setObjtype(String objtype) {
		this.objtype = objtype;
	}
	public String getCreditcode() {
		return creditcode;
	}
	public void setCreditcode(String creditcode) {
		this.creditcode = creditcode;
	}
	public Date getExecutedt() {
		return executedt;
	}
	public void setExecutedt(Date executedt) {
		this.executedt = executedt;
	}
	public String getExecuteunit() {
		return executeunit;
	}
	public void setExecuteunit(String executeunit) {
		this.executeunit = executeunit;
	}
	public String getAccordingto() {
		return accordingto;
	}
	public void setAccordingto(String accordingto) {
		this.accordingto = accordingto;
	}
	public String getMeasurename() {
		return measurename;
	}
	public void setMeasurename(String measurename) {
		this.measurename = measurename;
	}
	public String getMatter() {
		return matter;
	}
	public void setMatter(String matter) {
		this.matter = matter;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getBacktype() {
		return backtype;
	}
	public void setBacktype(String backtype) {
		this.backtype = backtype;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
