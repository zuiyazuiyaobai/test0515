/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.log.entity;

import com.jeeplus.modules.sys.entity.User;
import com.jeeplus.modules.sys.entity.Office;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 业务日志Entity
 * @author zcl
 * @version 2017-11-14
 */
public class CInsBusinessLog extends DataEntity<CInsBusinessLog> {
	
	private static final long serialVersionUID = 1L;
	private String objectId;		// 对象ID（该对象所在表的ID）
	private String objectName;		// 对象名（该类名）
	private User operateUser;		// 操作人ID
	private String operateUserName;		// 操作人名称（因为一带一路网站记录用户没有同步过来）
	private Office operateDept;		// 操作部门ID
	private String operateDeptName;		// 操作部门ID（因为一带一路网站记录部门没有同步过来）
	private User receiveUser;		// 接收人ID
	private String receiveUserName;		// 接收人ID
	private Office receiveDept;		// 接收部门ID
	private String receiveDeptName;		// 接收部门ID
	private Office receiveOffice;		// 接收处室ID
	private String receiveOfficeName; // 接收处室名称
	private String operate;		// 操作
	private String type;		// 类型（1.储备编报履历 2.计划编报履历 3.转办履历）
	
	public CInsBusinessLog() {
		super();
	}

	public CInsBusinessLog(String id){
		super(id);
	}

	@ExcelField(title="对象ID（该对象所在表的ID）", align=2, sort=7)
	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	
	@ExcelField(title="对象名（该类名）", align=2, sort=8)
	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	
	@ExcelField(title="操作人ID", align=2, sort=9)
	public User getOperateUser() {
		return operateUser;
	}

	public void setOperateUser(User operateUser) {
		this.operateUser = operateUser;
	}
	
	@ExcelField(title="操作部门ID", align=2, sort=10)
	public Office getOperateDept() {
		return operateDept;
	}

	public void setOperateDept(Office operateDept) {
		this.operateDept = operateDept;
	}
	
	@ExcelField(title="接收人ID", align=2, sort=11)
	public User getReceiveUser() {
		return receiveUser;
	}

	public void setReceiveUser(User receiveUser) {
		this.receiveUser = receiveUser;
	}

	@ExcelField(title="接收人姓名", align=2, sort=12)
	public String getReceiveUserName() {
		return receiveUserName;
	}

	public void setReceiveUserName(String receiveUserName) {
		this.receiveUserName = receiveUserName;
	}

	@ExcelField(title="接收部门ID", align=2, sort=13)
	public Office getReceiveDept() {
		return receiveDept;
	}

	public void setReceiveDept(Office receiveDept) {
		this.receiveDept = receiveDept;
	}
	
	@ExcelField(title="接收处室ID", align=2, sort=14)
	public Office getReceiveOffice() {
		return receiveOffice;
	}

	public void setReceiveOffice(Office receiveOffice) {
		this.receiveOffice = receiveOffice;
	}
	
	@ExcelField(title="操作", align=2, sort=15)
	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	@ExcelField(title="类型", align=2, sort=16)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOperateUserName() {
		return operateUserName;
	}

	public void setOperateUserName(String operateUserName) {
		this.operateUserName = operateUserName;
	}

	public String getOperateDeptName() {
		return operateDeptName;
	}

	public void setOperateDeptName(String operateDeptName) {
		this.operateDeptName = operateDeptName;
	}

	public String getReceiveDeptName() {
		return receiveDeptName;
	}

	public void setReceiveDeptName(String receiveDeptName) {
		this.receiveDeptName = receiveDeptName;
	}

	public String getReceiveOfficeName() {
		return receiveOfficeName;
	}

	public void setReceiveOfficeName(String receiveOfficeName) {
		this.receiveOfficeName = receiveOfficeName;
	}

	// 操作
	public static final String OPERATE_XMJBXX_ADD = "新增";
	public static final String OPERATE_XMJBXX_EDITE = "修改";
	public static final String OPERATE_XMJBXX_BAOSONG = "报送";
	public static final String OPERATE_XMJBXX_TSZDBQ = "推送至待报区";
	public static final String OPERATE_XMJBXX_TUIHUI = "退回";
	public static final String OPERATE_XMJBXX_THXJDW = "退回下级单位";
	public static final String OPERATE_XMJBXX_ZHUANBAN = "转办";
	public static final String OPERATE_XMJBXX_BIANZHI = "编制";
	public static final String OPERATE_XMJBXX_RBJK = "入本级库";
	public static final String OPERATE_XMJBXX_QXCB = "取消储备";
	public static final String OPERATE_XMJBXX_TBSNGDJHWCBXM = "同步三年滚动计划为储备项目";
	public static final String OPERATE_XMJBXX_NRGDJH = "纳入三年滚动计划";
	public static final String OPERATE_XMJBXX_SHANGBAO = "上报";
	public static final String OPERATE_XMJBXX_JIASUO = "加锁";
	public static final String OPERATE_XMJBXX_JIESUO = "解锁";
	public static final String OPERATE_XMJBXX_NDJHBZ = "年度计划报送编制";
	public static final String OPERATE_XMJBXX_ZXJSJJXMBZ = "专项建设基金项目编制";
	public static final String OPERATE_XMJBXX_TSZNDJHBSQ = "推送至年度计划报送区";
	public static final String OPERATE_XMJBXX_TSZZXJSJJXMBSQ = "推送至专项建设基金项目报送区";
	public static final String OPERATE_XMJBXX_SCJDJHBS = "删除年度计划报送";
	public static final String OPERATE_XMJBXX_SCZXJSJJXM = "删除专项建设基金项目";
	public static final String OPERATE_XMJBXX_JDJHBSTH = "年度计划报送退回";
	public static final String OPERATE_XMJBXX_ZXJSJJXMTH = "专项建设基金项目退回";
	public static final String OPERATE_XMJBXX_BGWH = "变更文号";
	public static final String OPERATE_XMJBXX_TASK_ISSUE = "调度任务下发";
	public static final String OPERATE_XMJBXX_TASK_FINISH = "调度任务完成";
	public static final String OPERATE_XMJBXX_TASK_FEEDBACK = "调度任务完成";

	public static final String OPERATE_TASK_ADD = "添加调度任务";
	public static final String OPERATE_TASK_EDIT = "修改调度任务";
	public static final String OPERATE_TASK_ISSUE = "调度任务下发";
	public static final String OPERATE_TASK_FINISH = "调度任务完成";

	// 操作类型（1.储备编报履历 2.计划编报履历 3.转办履历 4.调度任务履历 5.项目调度履历）
	public static final String TYPE_CBBB = "1";
	public static final String TYPE_JHBB = "2";
	public static final String TYPE_ZB = "3";
	public static final String TYPE_TASK = "4";
	public static final String TYPE_XMJBXX_TASK = "5";

}