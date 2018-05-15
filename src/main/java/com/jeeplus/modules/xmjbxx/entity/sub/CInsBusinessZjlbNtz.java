/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.entity.sub;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessTzqk;

/**
 * 资金需求Entity
 * @author yw
 * @version 2017-09-25
 */
public class CInsBusinessZjlbNtz extends DataEntity<CInsBusinessZjlbNtz> {
	
	private static final long serialVersionUID = 1L;
	private CInsBusinessTzqk tzqk;		// 所属投资情况
	private String year;		// 年份
	private Double je;		// 金额
	private String type;  //类型（1.资本金缺口2.资本需求）
	private Integer sort;  //排序

	public CInsBusinessZjlbNtz() {
		super();
	}
	
	public CInsBusinessZjlbNtz(String id){
		super(id);
	}

	@ExcelField(title="年份", align=2, sort=7)
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public CInsBusinessTzqk getTzqk() {
		return tzqk;
	}

	public void setTzqk(CInsBusinessTzqk tzqk) {
		this.tzqk = tzqk;
	}

	@ExcelField(title="金额", align=2, sort=9)
	public Double getJe() {
		return je;
	}

	public void setJe(Double je) {
		this.je = je;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public static final String TYPE_ZBJQK = "1";//资本金缺口
	public static final String TYPE_ZJXQ = "2";//资本需求
}