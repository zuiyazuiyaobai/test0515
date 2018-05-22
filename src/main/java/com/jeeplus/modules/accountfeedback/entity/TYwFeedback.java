/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.accountfeedback.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 反馈信息Entity
 * @author aaa
 * @version 2018-05-21
 */
public class TYwFeedback extends DataEntity<TYwFeedback> {
	
	private static final long serialVersionUID = 1L;
	private String taskId;		// 关联任务id(t_yw_task.id)
	private String parentId;		// 关联主表id(t_yw_project.id)
	private String feedContent;		// 反馈内容
	private String feedPerson;		// 反馈人
	private String feedPersonId;		// 反馈人id
	private Date feedTime;		// 反馈时间
	private String feedFile;		// 反馈附件
	private String schedule;		// 反馈进度
	private String feedStatus;		// 反馈状态（0-暂存；1-提交）
	private String feedRemark;		// 反馈备注
	private String auditResult;		// 审核认定(1-正在推进；2-进度缓慢；3-任务完全完成)
	private String isFinish;		// 是否按照节点完成（0-否；1-是）
	private String auditRemark;		// 审核备注
	private String auditPerson;		// 审核人
	private String auditPersonId;		// 审核人
	private Date auditTime;		// 审核时间
	
	public TYwFeedback() {
		super();
	}

	public TYwFeedback(String id){
		super(id);
	}

	@ExcelField(title="关联任务id(t_yw_task.id)", align=2, sort=1)
	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
	
	
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@ExcelField(title="反馈内容", align=2, sort=3)
	public String getFeedContent() {
		return feedContent;
	}

	public void setFeedContent(String feedContent) {
		this.feedContent = feedContent;
	}
	
	@ExcelField(title="反馈人", align=2, sort=4)
	public String getFeedPerson() {
		return feedPerson;
	}

	public void setFeedPerson(String feedPerson) {
		this.feedPerson = feedPerson;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="反馈时间不能为空")
	@ExcelField(title="反馈时间", align=2, sort=5)
	public Date getFeedTime() {
		return feedTime;
	}

	public void setFeedTime(Date feedTime) {
		this.feedTime = feedTime;
	}
	
	@ExcelField(title="反馈附件", align=2, sort=6)
	public String getFeedFile() {
		return feedFile;
	}

	public void setFeedFile(String feedFile) {
		this.feedFile = feedFile;
	}
	
	@ExcelField(title="反馈进度", align=2, sort=7)
	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
	@ExcelField(title="反馈状态（0-暂存；1-提交）", align=2, sort=8)
	public String getFeedStatus() {
		return feedStatus;
	}

	public void setFeedStatus(String feedStatus) {
		this.feedStatus = feedStatus;
	}
	
	@ExcelField(title="反馈备注", align=2, sort=9)
	public String getFeedRemark() {
		return feedRemark;
	}

	public void setFeedRemark(String feedRemark) {
		this.feedRemark = feedRemark;
	}
	
	@ExcelField(title="审核认定(1-正在推进；2-进度缓慢；3-任务完全完成)", align=2, sort=10)
	public String getAuditResult() {
		return auditResult;
	}

	public void setAuditResult(String auditResult) {
		this.auditResult = auditResult;
	}
	
	@ExcelField(title="是否按照节点完成（0-否；1-是）", align=2, sort=11)
	public String getIsFinish() {
		return isFinish;
	}

	public void setIsFinish(String isFinish) {
		this.isFinish = isFinish;
	}
	
	@ExcelField(title="审核备注", align=2, sort=12)
	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}
	
	@ExcelField(title="审核人", align=2, sort=13)
	public String getAuditPerson() {
		return auditPerson;
	}

	public void setAuditPerson(String auditPerson) {
		this.auditPerson = auditPerson;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="审核时间", align=2, sort=14)
	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public String getFeedPersonId() {
		return feedPersonId;
	}

	public void setFeedPersonId(String feedPersonId) {
		this.feedPersonId = feedPersonId;
	}

	public String getAuditPersonId() {
		return auditPersonId;
	}

	public void setAuditPersonId(String auditPersonId) {
		this.auditPersonId = auditPersonId;
	}
	
	
}