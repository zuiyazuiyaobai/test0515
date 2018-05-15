/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.syssms.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 短信发送Entity
 * @author zgl
 * @version 2017-12-12
 */
public class SysSms extends DataEntity<SysSms> {
	
	private static final long serialVersionUID = 1L;
	private String telephone;		// 手机号码
	private String message;		// 发送信息
	private String receiver;		// 接收者
	private String sendstate;		// 有效状态：1：已发送 2：未发送
	private String sender;		// 发送者
	private Date createtime;		// 创建时间
	private Date starttime;		// 开始发送时间
	private Date endtime;		// 结束发送时间
	private String sendresult;		// 发送结果
	private String systemid;		// 短信所属系统ID
	private String remark;		// 备注
	private String bsnum;		// 业务流水号
	private String type;		// 类型，1申请人短信，2下一环节短信，3催办督办短信
	private String xxbh;		// 所属系统号
	
	public SysSms() {
		super();
	}

	public SysSms(String id){
		super(id);
	}

	@ExcelField(title="手机号码", align=2, sort=1)
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@ExcelField(title="发送信息", align=2, sort=2)
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@ExcelField(title="接收者", align=2, sort=3)
	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	@ExcelField(title="有效状态：1：已发送 2：未发送", align=2, sort=4)
	public String getSendstate() {
		return sendstate;
	}

	public void setSendstate(String sendstate) {
		this.sendstate = sendstate;
	}
	
	@ExcelField(title="发送者", align=2, sort=5)
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="创建时间", align=2, sort=6)
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="开始发送时间", align=2, sort=7)
	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="结束发送时间", align=2, sort=8)
	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	
	@ExcelField(title="发送结果", align=2, sort=9)
	public String getSendresult() {
		return sendresult;
	}

	public void setSendresult(String sendresult) {
		this.sendresult = sendresult;
	}
	
	@ExcelField(title="短信所属系统ID", align=2, sort=10)
	public String getSystemid() {
		return systemid;
	}

	public void setSystemid(String systemid) {
		this.systemid = systemid;
	}
	
	@ExcelField(title="备注", align=2, sort=11)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@ExcelField(title="业务流水号", align=2, sort=12)
	public String getBsnum() {
		return bsnum;
	}

	public void setBsnum(String bsnum) {
		this.bsnum = bsnum;
	}
	
	@ExcelField(title="类型，1申请人短信，2下一环节短信，3催办督办短信", align=2, sort=13)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@ExcelField(title="所属系统号", align=2, sort=14)
	public String getXxbh() {
		return xxbh;
	}

	public void setXxbh(String xxbh) {
		this.xxbh = xxbh;
	}
	
}