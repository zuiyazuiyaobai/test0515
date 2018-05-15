/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.entity.sub;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.sys.entity.Office;
import com.jeeplus.modules.xmjbxx.entity.Xmjbxx;

import java.util.Date;

/**
 * 项目部门关系Entity
 * @author zcl
 * @version 2017-10-16
 */
public class CInsBusinessXmjbxxDeptRelation extends DataEntity<CInsBusinessXmjbxxDeptRelation> {
	
	private static final long serialVersionUID = 1L;
	private Xmjbxx xmjbxx;		// 项目基本信息ID
	private Office dept;		// 部门
	private String type;		// 关系类型
	private String status;		// 状态
	private String nrzt; 		// 纳入状态
	private String zt;			// 各个类型的状态
	private String zgcj;		// 储备最高层级[只在储备库的类型中设置]（1：地（州、市）级；2：自治区厅局级；3：自治区发改委处室 4：领导小组办公室（西部处）；）
	private Date bsDate;		// 年度计划报送&专项建设基金项目_报送时间
	private String bswh;
	private String remarks;
	  private String JKSPURL;

	    public String getJKSPURL() {
			return JKSPURL;
		}

		public void setJKSPURL(String jKSPURL) {
			JKSPURL = jKSPURL;
		}
	
	public CInsBusinessXmjbxxDeptRelation() {
		super();
	}

	public CInsBusinessXmjbxxDeptRelation(String id){
		super(id);
	}

	public Xmjbxx getXmjbxx() {
		return xmjbxx;
	}

	public void setXmjbxx(Xmjbxx xmjbxx) {
		this.xmjbxx = xmjbxx;
	}

	public Office getDept() {
		return dept;
	}

	public void setDept(Office dept) {
		this.dept = dept;
	}

	@ExcelField(title="关系类型（1.创建 2.储备库3.三年滚动计划4.投资计划已报送）", align=2, sort=9)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNrzt() {
		return nrzt;
	}

	public void setNrzt(String nrzt) {
		this.nrzt = nrzt;
	}

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getCbztStr(){
		if(ZT_CBK_YBS.equals(this.zt)){
			return "已上报";
		} else if (ZT_CBK_WBS.equals(this.zt)) {
			return "未上报";
		}
		return "";
	}

	public String getSfbzgdjhStr(){
		if (NRZT_CBK_WTX.equals(this.nrzt)) {
			return "否";
		} else if (NRZT_CBK_BTX.equals(this.nrzt)) {
			return "是";
		}
		return "";
	}

    public String getNrztStr() {
		if (NRZT_SNGDJH_WTX.equals(this.nrzt)) {
			return "未被挑选";
		} else if (NRZT_SNGDJH_TXW_NDJHBS.equals(this.nrzt)) {
			return "被挑选为年度计划报送";
		} else if (NRZT_SNGDJH_TXW_ZXJSJJXM.equals(this.nrzt)) {
			return "被挑选为专项建设基金项目";
		}

		return "";
	}

	/**
	 * 三年滚动计划报送状态
	 */
    public String getBsztStr() {
		if (ZT_SNGDJH_YBS.equals(this.zt)) {
			return "已报送";
		} else if (ZT_SNGDJH_WBS.equals(this.zt)) {
			return "未报送";
		} else if (ZT_SNGDJH_BTH.equals(this.zt)) {
			return "被上级单位退回";
		}
		return "";
	}

	public String getZgcj() {
		return zgcj;
	}

	public void setZgcj(String zgcj) {
		this.zgcj = zgcj;
	}

	public Date getBsDate() {
		return bsDate;
	}

	public void setBsDate(Date bsDate) {
		this.bsDate = bsDate;
	}

	public String getBswh() {
		return bswh;
	}

	public void setBswh(String bswh) {
		this.bswh = bswh;
	}

	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	// 关系类型（1.填报 2.储备库 3.三年滚动计划 4.投资计划已报送 5.年度计划报送 6.专项建设基金项目）
	public static final String TYPE_TB = "1";
	public static final String TYPE_CBK = "2";
	public static final String TYPE_SNGDJH = "3";
	public static final String TYPE_YSB = "4";
	public static final String TYPE_NDJHBS = "5";
	public static final String TYPE_ZXJSJJ = "6";

	// 状态（1.年度计划报送-编制区 2.年度计划报送-报送区 5.专项建设基金项目-编制区 6.专项建设基金项目-编制区）
	public static final String STATUS_NDJHBS_BZ = "1";
	public static final String STATUS_NDJHBS_BS = "2";
	public static final String STATUS_ZXJSJJ_BZ = "5";
	public static final String STATUS_ZXJSJJ_BS = "6";

	// 纳入状态(1.储备库未被挑选为计划编制 2.储备项目被挑选为计划编制 3.三年滚动计划未被挑选为年度计划报送或专项建设基金项目 4.三年滚动计划被挑选为年度计划报送 5.三年滚动计划被挑选为专项建设基金项目）
	public static final String NRZT_CBK_WTX = "1";
	public static final String NRZT_CBK_BTX = "2";
	public static final String NRZT_SNGDJH_WTX = "3";
	public static final String NRZT_SNGDJH_TXW_NDJHBS = "4";
	public static final String NRZT_SNGDJH_TXW_ZXJSJJXM = "5";

	// 状态（1.三年滚动计划-已报送 2.三年滚动计划-未报送 3.三年滚动计划-被退回 1.储备库-已报送[该层级的投资计划已报送] 2.储备库-未报送）
	public static final String ZT_SNGDJH_YBS = "1";
	public static final String ZT_SNGDJH_WBS = "2";
	public static final String ZT_SNGDJH_BTH = "3";
	public static final String ZT_CBK_YBS = "1";
	public static final String ZT_CBK_WBS = "2";
}