/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.zdxmcs.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.iim.entity.Mail;

/**
 * 重点项目初审菜单Entity
 * @author tys
 * @version 2017-05-11
 */
public class CInsBusinessZdgcxm extends DataEntity<CInsBusinessZdgcxm> {
	
	private static final long serialVersionUID = 1L;
	private String zdgcxmbh;		// 重点工程项目编号
	private String cbsnum;        //业务编号
	private String zdxmlx;		// 重点项目类型(1,基础设施等领域重点项目,2产业转型重点项目,3传统产业升级)
	private String cylx;		// 产业类型(1高端装备制造,2节能环保产业,3新一代信息技术产业,4生物产业,5新材料产业,6新能源,7新能源汽车产业,8岸港网,9铁路,10公路,11水利,12旅游业,13科技创新,14铝工业,15现代煤化工,16特色食品,17现代农业,18现代物流,19城乡人居环境,20教育，21燃气，22转型综改示范区建设，23现代金融，24商贸会展，25文化旅游，26社会事业，27咨询业等其它服务业，28火力发电，29煤炭，30冶金，31其他工业，32机场，33电网，34城乡基础设施建设，35生态治理，36保障性住房)
	private String cylxone;		// 产业类型大类（1.战略性新兴产业,2现代服务业，3现代农业）
	private String fzrname;		// 负责人姓名
	private String fzrtel;		// 负责人手机号
	private String year;		// 年份
	private String ndjhtz;		// 年度计划投资
	private String status;		// 状态（0、待办；1、已初审；2、已复审）
	private String layer;		// 层级（1、省级；2、市级）
	private String csmsg;		// 初审意见
	private String fsmsg;		// 复审意见
	private Date creattime;		// 创建时间
	private String sfyx;		// 是否有效（1、有效；0、无效）
	private String projectname; //项目名称
	private String cstype;      //初审情况：1为同意，2为不同意；
	private String fstype;      //复审情况：1为同意，2为不同意；
	private String csuserid;    //初审处理人id；
	private String fsuserid;    //复审处理人id；
	private String currentuserid;//当前用户id；
	
	
	private CInsBusinessInfo info;   //重点工程项目通用基本信息
	
	public CInsBusinessZdgcxm(CInsBusinessInfo info){
		this.info = info;
	}
	
	public CInsBusinessZdgcxm() {
		super();
	}

	public CInsBusinessZdgcxm(String id){
		super(id);
	}
	
	
	public CInsBusinessInfo getInfo() {
		return info;
	}

	public void setInfo(CInsBusinessInfo info) {
		this.info = info;
	}

	
	@ExcelField(title="重点项目类型(1,基础设施等领域重点项目,2产业转型重点项目,3传统产业升级)", align=2, sort=2)
	public String getZdxmlx() {
		return zdxmlx;
	}

	public void setZdxmlx(String zdxmlx) {
		this.zdxmlx = zdxmlx;
	}
	
	@ExcelField(title="产业类型(1高端装备制造,2节能环保产业,3新一代信息技术产业,4生物产业,5新材料产业,6新能源,7新能源汽车产业,8岸港网,9铁路,10公路,11水利,12旅游业,13科技创新,14铝工业,15现代煤化工,16特色食品,17现代农业,18现代物流,19城乡人居环境,20教育，21燃气，22转型综改示范区建设，23现代金融，24商贸会展，25文化旅游，26社会事业，27咨询业等其它服务业，28火力发电，29煤炭，30冶金，31其他工业，32机场，33电网，34城乡基础设施建设，35生态治理，36保障性住房)", align=2, sort=3)
	public String getCylx() {
		return cylx;
	}

	public void setCylx(String cylx) {
		this.cylx = cylx;
	}
	
	@ExcelField(title="产业类型大类（1.战略性新兴产业,2现代服务业，3现代农业）", align=2, sort=4)
	public String getCylxone() {
		return cylxone;
	}

	public void setCylxone(String cylxone) {
		this.cylxone = cylxone;
	}
	
	@ExcelField(title="负责人姓名", align=2, sort=5)
	public String getFzrname() {
		return fzrname;
	}

	public void setFzrname(String fzrname) {
		this.fzrname = fzrname;
	}
	
	@ExcelField(title="负责人手机号", align=2, sort=6)
	public String getFzrtel() {
		return fzrtel;
	}

	public void setFzrtel(String fzrtel) {
		this.fzrtel = fzrtel;
	}
	
	@ExcelField(title="年份", align=2, sort=7)
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	@ExcelField(title="年度计划投资", align=2, sort=8)
	public String getNdjhtz() {
		return ndjhtz;
	}

	public void setNdjhtz(String ndjhtz) {
		this.ndjhtz = ndjhtz;
	}
	
	@ExcelField(title="状态（0、待办；1、已初审；2、已复审）", align=2, sort=9)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@ExcelField(title="层级（1、省级；2、市级）", align=2, sort=10)
	public String getLayer() {
		return layer;
	}

	public void setLayer(String layer) {
		this.layer = layer;
	}
	
	@ExcelField(title="初审意见", align=2, sort=11)
	public String getCsmsg() {
		return csmsg;
	}

	public void setCsmsg(String csmsg) {
		this.csmsg = csmsg;
	}
	
	@ExcelField(title="复审意见", align=2, sort=12)
	public String getFsmsg() {
		return fsmsg;
	}

	public void setFsmsg(String fsmsg) {
		this.fsmsg = fsmsg;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="创建时间", align=2, sort=13)
	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}
	
	@ExcelField(title="是否有效（1、有效；0、无效）", align=2, sort=14)
	public String getSfyx() {
		return sfyx;
	}

	public void setSfyx(String sfyx) {
		this.sfyx = sfyx;
	}

	public String getZdgcxmbh() {
		return zdgcxmbh;
	}

	public void setZdgcxmbh(String zdgcxmbh) {
		this.zdgcxmbh = zdgcxmbh;
	}

	public String getCbsnum() {
		return cbsnum;
	}

	public void setCbsnum(String cbsnum) {
		this.cbsnum = cbsnum;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getCstype() {
		return cstype;
	}

	public void setCstype(String cstype) {
		this.cstype = cstype;
	}

	public String getFstype() {
		return fstype;
	}

	public void setFstype(String fstype) {
		this.fstype = fstype;
	}

	public String getCsuserid() {
		return csuserid;
	}

	public void setCsuserid(String csuserid) {
		this.csuserid = csuserid;
	}

	public String getFsuserid() {
		return fsuserid;
	}

	public void setFsuserid(String fsuserid) {
		this.fsuserid = fsuserid;
	}

	public String getCurrentuserid() {
		return currentuserid;
	}

	public void setCurrentuserid(String currentuserid) {
		this.currentuserid = currentuserid;
	}
	
	
}