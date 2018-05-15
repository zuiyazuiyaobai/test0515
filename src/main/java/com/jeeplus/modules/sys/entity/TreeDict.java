/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sys.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jeeplus.common.persistence.TreeEntity;

import javax.validation.constraints.NotNull;

/**
 * 符合规划Entity
 * @author yw
 * @version 2017-09-28
 */
public class TreeDict extends TreeEntity<TreeDict> {
	
	private static final long serialVersionUID = 1L;
	private TreeDict parent;		// 父级编号
	private String parentIds;		// 所有父级编号
	private String name;		// 名称
	private Integer sort;		// 排序
	private String code;		// 唯一标识（预留）
	private String type;		// 类型
	
	public TreeDict() {
		super();
	}

	public TreeDict(String id){
		super(id);
	}

	@JsonBackReference
	@NotNull(message="父级编号不能为空")
	public TreeDict getParent() {
		return parent;
	}

	public void setParent(TreeDict parent) {
		this.parent = parent;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getParentId() {
		return parent != null && parent.getId() != null ? parent.getId() : "0";
	}
}