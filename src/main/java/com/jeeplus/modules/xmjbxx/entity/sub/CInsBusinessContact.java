/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.entity.sub;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 联系人信息Entity
 * @author zcl
 * @version 2017-10-25
 */
public class CInsBusinessContact extends DataEntity<CInsBusinessContact> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 姓名
	private String office;		// 工作单位
	private String job;		// 职务
	private String mobile;		// 手机
	private String telephone;		// 座机
	private String email;		// 电子邮箱
	
	public CInsBusinessContact() {
		super();
	}

	public CInsBusinessContact(String id){
		super(id);
	}

	@ExcelField(title="姓名", align=2, sort=7)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ExcelField(title="工作单位", align=2, sort=8)
	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}
	
	@ExcelField(title="职务", align=2, sort=9)
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	@ExcelField(title="手机", align=2, sort=10)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@ExcelField(title="座机", align=2, sort=11)
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@ExcelField(title="电子邮箱", align=2, sort=12)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}