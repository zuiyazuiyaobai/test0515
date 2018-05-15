/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.task.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.sys.entity.Office;

/**
 * 调度任务Entity
 * @author zcl
 * @version 2017-10-31
 */
public class CInsBusinessSchedulerTask extends DataEntity<CInsBusinessSchedulerTask> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 任务名称
	private String type;		// 任务类型
	private Date startDate;		// 开始时间
	private Date endDate;		// 结束时间
	private String requirement;		// 调度需求
	private String origin;		// 项目来源
	private Date issueDate;		// 下发时间
	private Office dept;		// 下发部门
	private String status;		// 任务状态（1.未下发 2.已下发 3.已完成）

	private List<CInsBusinessXmjbxxTaskRelation> relations;

	public CInsBusinessSchedulerTask() {
		super();
	}

	public CInsBusinessSchedulerTask(String id){
		super(id);
	}

	@ExcelField(title="任务名称", align=2, sort=7)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ExcelField(title="任务类型", dictType="task_type", align=2, sort=8)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="开始时间不能为空")
	@ExcelField(title="开始时间", align=2, sort=9)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="结束时间不能为空")
	@ExcelField(title="结束时间", align=2, sort=10)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@ExcelField(title="调度需求", align=2, sort=11)
	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	
	@ExcelField(title="项目来源", dictType="task_origin", align=2, sort=12)
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="下发时间", align=2, sort=13)
	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusStr() {
		if(STATUS_WXF.equals(this.status)){
			return "未下发";
		} else if (STATUS_YXF.equals(this.status)) {
			return "已下发";
		}else if(STATUS_YWC.equals(this.status)){
			return "已完成";
		}
		return "";
	}

	public Office getDept() {
		return dept;
	}

	public void setDept(Office dept) {
		this.dept = dept;
	}

	public List<CInsBusinessXmjbxxTaskRelation> getRelations() {
		return relations;
	}

	public void setRelations(List<CInsBusinessXmjbxxTaskRelation> relations) {
		this.relations = relations;
	}

	public static final String ORIGIN_SNGDJH = "1";
	public static final String ORIGIN_ZXJSJJ = "2";

	public static final String STATUS_WXF = "1";
	public static final String STATUS_YXF = "2";
	public static final String STATUS_YWC = "3";

}