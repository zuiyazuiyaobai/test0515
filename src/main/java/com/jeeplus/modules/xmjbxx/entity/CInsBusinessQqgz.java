/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * qqgzEntity
 * @author yw
 * @version 2017-09-26
 */
public class CInsBusinessQqgz extends DataEntity<CInsBusinessQqgz> {
	
	private static final long serialVersionUID = 1L;
	private Xmjbxx xmjbxx;		// 项目id
	private String spsx;		// 审批事项
	private String pfdw;		// 批复单位
	private Date pfsj;		// 批复时间
	private String pfwjbt;		// 批复文件标题
	private String pfwh;		// 批复文号
	private String pfzt;		// 批复状态
	private String pfwj;		// 批复文件
	private Integer sort;		//排序
	private String updatestatus;
	private String filePath;
	private String fileId;
	public CInsBusinessQqgz() {
		super();
	}

	public CInsBusinessQqgz(String id){
		super(id);
	}

	public Xmjbxx getXmjbxx() {
		return xmjbxx;
	}

	public void setXmjbxx(Xmjbxx xmjbxx) {
		this.xmjbxx = xmjbxx;
	}

	@ExcelField(title="审批事项", align=2, sort=8)
	public String getSpsx() {
		return spsx;
	}

	public void setSpsx(String spsx) {
		this.spsx = spsx;
	}
	
	@ExcelField(title="批复单位", align=2, sort=9)
	public String getPfdw() {
		return pfdw;
	}

	public void setPfdw(String pfdw) {
		this.pfdw = pfdw;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="批复时间", align=2, sort=10)
	public Date getPfsj() {
		return pfsj;
	}

	public void setPfsj(Date pfsj) {
		this.pfsj = pfsj;
	}
	
	@ExcelField(title="批复文件标题", align=2, sort=11)
	public String getPfwjbt() {
		return pfwjbt;
	}

	public void setPfwjbt(String pfwjbt) {
		this.pfwjbt = pfwjbt;
	}
	
	@ExcelField(title="批复文号", align=2, sort=12)
	public String getPfwh() {
		return pfwh;
	}

	public void setPfwh(String pfwh) {
		this.pfwh = pfwh;
	}
	
	@ExcelField(title="批复状态", align=2, sort=13)
	public String getPfzt() {
		return pfzt;
	}

	public void setPfzt(String pfzt) {
		this.pfzt = pfzt;
	}
	
	@ExcelField(title="批复文件", align=2, sort=14)
	public String getPfwj() {
		return pfwj;
	}

	public void setPfwj(String pfwj) {
		this.pfwj = pfwj;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getUpdatestatus() {
		return updatestatus;
	}

	public void setUpdatestatus(String updatestatus) {
		this.updatestatus = updatestatus;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	
}