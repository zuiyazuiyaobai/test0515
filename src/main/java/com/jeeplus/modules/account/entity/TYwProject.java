/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.account.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 台账主业务信息Entity
 * @author aaa
 * @version 2018-05-21
 */
public class TYwProject extends DataEntity<TYwProject> {
	
	private static final long serialVersionUID = 1L;
	private String category;		// 台账类别(1-市委经济工作事项;2-政府工作报告事项;3-目标考评事项;4-民生实事事项;5-重点项目建设;6-政府月重点工作;7-领导交办事项;8-其他事项
	private String title;		// 工作名称
	private String content;		// 工作内容
	private Long sort;		// 序号
	private String timeNode;		// 时间节点
	private String mainLeader;		// 分管领导
	private String mainLeaderId;		// 分管领导id
	private Date startTime;		// 启动时间
	private Date endTime;		// 计划完成时间
	private String status;		// 台账状态（0-在办；1-办结；2-终止；3-暂停）
	private String contacts;		// 联络人
	private String contactstel;		// 联络人电话
	private Date createTime;		// 创建时间d
	private String creater;		// 创建人
	private String remark;		// 备注
	
	public TYwProject() {
		super();
	}

	public TYwProject(String id){
		super(id);
	}

	@ExcelField(title="台账类别(1-市委经济工作事项;2-政府工作报告事项;3-目标考评事项;4-民生实事事项;5-重点项目建设;6-政府月重点工作;7-领导交办事项;8-其他事项", dictType="", align=2, sort=1)
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@ExcelField(title="工作名称", align=2, sort=2)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@ExcelField(title="工作内容", align=2, sort=3)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@ExcelField(title="序号", align=2, sort=4)
	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}
	
	@ExcelField(title="时间节点", align=2, sort=5)
	public String getTimeNode() {
		return timeNode;
	}

	public void setTimeNode(String timeNode) {
		this.timeNode = timeNode;
	}
	
	
	public String getMainLeaderId() {
		return mainLeaderId;
	}

	public void setMainLeaderId(String mainLeaderId) {
		this.mainLeaderId = mainLeaderId;
	}

	@ExcelField(title="分管领导", align=2, sort=6)
	public String getMainLeader() {
		return mainLeader;
	}

	public void setMainLeader(String mainLeader) {
		this.mainLeader = mainLeader;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="启动时间", align=2, sort=7)
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="计划完成时间", align=2, sort=8)
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	@ExcelField(title="台账状态（0-在办；1-办结；2-终止；3-暂停）", dictType="", align=2, sort=9)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@ExcelField(title="联络人", align=2, sort=10)
	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	
	@ExcelField(title="联络人电话", align=2, sort=11)
	public String getContactstel() {
		return contactstel;
	}

	public void setContactstel(String contactstel) {
		this.contactstel = contactstel;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="创建时间d", align=2, sort=12)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@ExcelField(title="创建人", align=2, sort=13)
	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}
	
	@ExcelField(title="备注", align=2, sort=14)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}