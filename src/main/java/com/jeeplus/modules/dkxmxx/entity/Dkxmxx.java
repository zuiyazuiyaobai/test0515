/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.dkxmxx.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 打捆项目Entity
 * @author gyf
 * @version 2018-03-22
 */
public class Dkxmxx extends DataEntity<Dkxmxx> {
	
	private static final long serialVersionUID = 1L;
	private String dkxmh;		// 打捆项目号
	private String dkxmmc;		// 打捆项目名称
	private String project_id;		// 项目id
	private String project_name;		// 项目名称
	private String dkzje;		// 打捆总金额
	private String project_je;		// 项目金额
	private String dkxmjsnr;		// 打捆项目建设内容
	
	public Dkxmxx() {
		super();
	}

	public Dkxmxx(String id){
		super(id);
	}

	@ExcelField(title="打捆项目号", align=2, sort=7)
	public String getDkxmh() {
		return dkxmh;
	}

	public void setDkxmh(String dkxmh) {
		this.dkxmh = dkxmh;
	}
	
	@ExcelField(title="打捆项目名称", align=2, sort=8)
	public String getDkxmmc() {
		return dkxmmc;
	}

	public void setDkxmmc(String dkxmmc) {
		this.dkxmmc = dkxmmc;
	}
	
	@ExcelField(title="项目id", align=2, sort=9)
	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	
	@ExcelField(title="项目名称", align=2, sort=10)
	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	
	@ExcelField(title="打捆总金额", align=2, sort=11)
	public String getDkzje() {
		return dkzje;
	}

	public void setDkzje(String dkzje) {
		this.dkzje = dkzje;
	}
	
	@ExcelField(title="项目金额", align=2, sort=12)
	public String getProject_je() {
		return project_je;
	}

	public void setProject_je(String project_je) {
		this.project_je = project_je;
	}
	
	@ExcelField(title="打捆项目建设内容", align=2, sort=13)
	public String getDkxmjsnr() {
		return dkxmjsnr;
	}

	public void setDkxmjsnr(String dkxmjsnr) {
		this.dkxmjsnr = dkxmjsnr;
	}
	
}