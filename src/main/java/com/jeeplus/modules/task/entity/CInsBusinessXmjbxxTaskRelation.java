/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.task.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.xmjbxx.entity.Xmjbxx;

/**
 * 项目基本信息和调度任务关联表Entity
 * @author zcl
 * @version 2017-10-31
 */
public class CInsBusinessXmjbxxTaskRelation extends DataEntity<CInsBusinessXmjbxxTaskRelation> {
	
	private static final long serialVersionUID = 1L;
	private Xmjbxx xmjbxx;		// 项目基本信息ID
	private CInsBusinessSchedulerTask task;		// 任务调度ID
	private String status;		// 任务状态
	private Date finishDate;		// 完成时间
	private String feedback;		// 调度反馈
	private String destDeptId;		// 调度项目接收人部门ID
	private String task_id;
	
	public CInsBusinessXmjbxxTaskRelation() {
		super();
	}

	public CInsBusinessXmjbxxTaskRelation(String id){
		super(id);
	}

	public Xmjbxx getXmjbxx() {
		return xmjbxx;
	}

	public void setXmjbxx(Xmjbxx xmjbxx) {
		this.xmjbxx = xmjbxx;
	}

	public CInsBusinessSchedulerTask getTask() {
		return task;
	}

	public void setTask(CInsBusinessSchedulerTask task) {
		this.task = task;
	}

	@ExcelField(title="任务状态", align=2, sort=9)
	public String getStatus() {
		return status;
	}

	public String getStatusStr() {
		if (STATUS_WWC.equals(this.status)) {
			return "未完成";
		} else if (STATUS_YWC.equals(this.status)) {
			return "已完成";
		}
		return "";
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="完成时间", align=2, sort=10)
	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	
	@ExcelField(title="调度反馈", align=2, sort=11)
	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	@ExcelField(title="调度项目接收人部门ID", align=2, sort=12)
	public String getDestDeptId() {
		return destDeptId;
	}

	public void setDestDeptId(String destDeptId) {
		this.destDeptId = destDeptId;
	}
	
	public String getTask_id() {
		return task_id;
	}

	public void setTask_id(String taskId) {
		task_id = taskId;
	}



	public static final String STATUS_WWC = "1";		// 未完成
	public static final String STATUS_YWC = "2";		// 已完成

}