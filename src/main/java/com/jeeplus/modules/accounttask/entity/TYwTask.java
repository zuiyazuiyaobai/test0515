/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.accounttask.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 任务信息Entity
 * @author aaa
 * @version 2018-05-21
 */
public class TYwTask extends DataEntity<TYwTask> {
	
	private static final long serialVersionUID = 1L;
	private String parentId;		// 关联主表id(t_yw_project.id)
	private String taskTitle;		// 任务名称
	private String taskContent;		// 任务内容
	private String timeNode;		// 时间节点
	private String responseUnit;		// 责任单位
	private String responsePerson;		// 责任人
	private String responseUnitId;		// 责任单位Id
	private String responsePersonId;		// 责任人Id
	private String isMain;		// 是否为牵头单位（0-否；1-是）
	private String frequency;		// 反馈频率（0-不用报；1-每月报；2-双月报；3-季度报；4-每周报；5-定期报）
	private Date startTime;		// 开始时间
	private Date endTime;		// 完成时间
	private Date createTime;		// 创建时间
	private String creater;		// 创建人
	private String taskStatus;		// 任务状态(1-按照节点完成；2-进度缓慢；3-任务完全完成)
	private String remark;		// 备注
	
	public TYwTask() {
		super();
	}

	public TYwTask(String id){
		super(id);
	}

//	@JsonBackReference
//	@ExcelField(title="关联主表id(t_yw_project.id)", align=2, sort=1)
//	public TYwTask getParent() {
//		return parent;
//	}
//
//	public void setParent(TYwTask parent) {
//		this.parent = parent;
//	}
	
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	
	@ExcelField(title="任务名称", align=2, sort=2)
	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	
	@ExcelField(title="任务内容", align=2, sort=3)
	public String getTaskContent() {
		return taskContent;
	}

	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}
	
	@ExcelField(title="时间节点", align=2, sort=4)
	public String getTimeNode() {
		return timeNode;
	}

	public void setTimeNode(String timeNode) {
		this.timeNode = timeNode;
	}
	
	@ExcelField(title="责任单位", fieldType=String.class, value="", align=2, sort=5)
	public String getResponseUnit() {
		return responseUnit;
	}

	public void setResponseUnit(String responseUnit) {
		this.responseUnit = responseUnit;
	}
	
	
	
	public String getResponseUnitId() {
		return responseUnitId;
	}

	public void setResponseUnitId(String responseUnitId) {
		this.responseUnitId = responseUnitId;
	}

	public String getResponsePersonId() {
		return responsePersonId;
	}

	public void setResponsePersonId(String responsePersonId) {
		this.responsePersonId = responsePersonId;
	}

	@ExcelField(title="责任人", fieldType=String.class, value="", align=2, sort=6)
	public String getResponsePerson() {
		return responsePerson;
	}

	public void setResponsePerson(String responsePerson) {
		this.responsePerson = responsePerson;
	}
	
	@ExcelField(title="是否为牵头单位（0-否；1-是）", align=2, sort=7)
	public String getIsMain() {
		return isMain;
	}

	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}
	
	@ExcelField(title="反馈频率（0-不用报；1-每月报；2-双月报；3-季度报；4-每周报；5-定期报）", align=2, sort=8)
	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="开始时间", align=2, sort=9)
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="完成时间", align=2, sort=10)
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="创建时间", align=2, sort=11)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@ExcelField(title="创建人", align=2, sort=12)
	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}
	
	@ExcelField(title="任务状态(1-按照节点完成；2-进度缓慢；3-任务完全完成)", align=2, sort=13)
	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	
	@ExcelField(title="备注", align=2, sort=14)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}