package com.jeeplus.modules.xmjbxx.vo;

import com.jeeplus.common.config.Global;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.modules.xmjbxx.entity.Xmjbxx;

import java.util.Date;

/**
 * Created by yw on 2017/9/25.
 */
public class XmjbxxSearchParameter extends Xmjbxx {

    private String tbzt;//填报状态（0.全部  1.待上报  2.退回）
    private Integer ztzMin;//总金额_小
    private Integer ztzMax;//总金额_大
    private Date createDateStart;//创建时间开始查询时间
    private Date createDateEnd;//创建时间结束查询时间
    private Date updateDateStart;//创建时间开始查询时间
    private Date updateDateEnd;//创建时间结束查询时间
    private String startTimeNStart;//创建时间开始查询时间
    private String startTimeNEnd;//创建时间结束查询时间
    private String endTimeStart;//创建时间开始查询时间
    private String endTimeEnd;//创建时间结束查询时间
    private Date jhbzDateStart;//计划编制时间 开始查询时间
    private Date jhbzDateEnd;//计划编制时间 结束查询时间
    private String sjly; // 数据来源
    private String xmscjd;//项目所处阶段
    private String wcl;//完成 比率
    private String wyjhyf;//开工月份晚于计划开工月数
    private String bslb;//开工月份晚于计划开工月数
     
  
	private String tzwcqklb;//投资完成情况类别
    private String tzwcqkbj;//投资完成情况比较
    private String tzwcqkbl;//投资完成情况比率
    private String zjzfqklb;//资金支付情况类别
    private String zjzfqkbj;//资金支付情况比较
    private String zjzfqkbl;//资金支付情况比率
    private String zjdwqklb;//资金到位情况类别
    private String zjdwqkbj;//资金到位情况比较
    private String zjdwqkbl;//资金到位情况比率
    private String xmbslb;//项目报送类别
    private String sfkg;//是否开工
    private String bmid;//部门id
	
    public String getBmid() {
		return bmid;
	}

	public void setBmid(String bmid) {
		this.bmid = bmid;
	}

	public String getBslb() {
  		return bslb;
  	}

  	public void setBslb(String bslb) {
  		this.bslb = bslb;
  	}

    public String getSfkg() {
		return sfkg;
	}

	public void setSfkg(String sfkg) {
		this.sfkg = sfkg;
	}

	public String getXmbslb() {
		return xmbslb;
	}

	public void setXmbslb(String xmbslb) {
		this.xmbslb = xmbslb;
	}

	
   
    
    public String getWcl() {
		return wcl;
	}

	public void setWcl(String wcl) {
		this.wcl = wcl;
	}

	public String getWyjhyf() {
		return wyjhyf;
	}

	public void setWyjhyf(String wyjhyf) {
		this.wyjhyf = wyjhyf;
	}

	public String getTzwcqklb() {
		return tzwcqklb;
	}

	public void setTzwcqklb(String tzwcqklb) {
		this.tzwcqklb = tzwcqklb;
	}

	public String getTzwcqkbj() {
		return tzwcqkbj;
	}

	public void setTzwcqkbj(String tzwcqkbj) {
		this.tzwcqkbj = tzwcqkbj;
	}

	public String getTzwcqkbl() {
		return tzwcqkbl;
	}

	public void setTzwcqkbl(String tzwcqkbl) {
		this.tzwcqkbl = tzwcqkbl;
	}

	public String getZjzfqklb() {
		return zjzfqklb;
	}

	public void setZjzfqklb(String zjzfqklb) {
		this.zjzfqklb = zjzfqklb;
	}

	public String getZjzfqkbj() {
		return zjzfqkbj;
	}

	public void setZjzfqkbj(String zjzfqkbj) {
		this.zjzfqkbj = zjzfqkbj;
	}

	public String getZjzfqkbl() {
		return zjzfqkbl;
	}

	public void setZjzfqkbl(String zjzfqkbl) {
		this.zjzfqkbl = zjzfqkbl;
	}

	public String getZjdwqklb() {
		return zjdwqklb;
	}

	public void setZjdwqklb(String zjdwqklb) {
		this.zjdwqklb = zjdwqklb;
	}

	public String getZjdwqkbj() {
		return zjdwqkbj;
	}

	public void setZjdwqkbj(String zjdwqkbj) {
		this.zjdwqkbj = zjdwqkbj;
	}

	public String getZjdwqkbl() {
		return zjdwqkbl;
	}

	public void setZjdwqkbl(String zjdwqkbl) {
		this.zjdwqkbl = zjdwqkbl;
	}

	
    
    
    
    
    
    
    
    
    
    public Integer getZtzMin() {
        return ztzMin;
    }

    public void setZtzMin(Integer ztzMin) {
        this.ztzMin = ztzMin;
    }

    public Integer getZtzMax() {
        return ztzMax;
    }

    public void setZtzMax(Integer ztzMax) {
        this.ztzMax = ztzMax;
    }

    public String getTbzt() {
        return tbzt;
    }

    public void setTbzt(String tbzt) {
        this.tbzt = tbzt;
        if (TBZT_DSB.equals(tbzt)) {//待上报，项目填写完成后未上报的状态
            setZt(ZT_XMCB_BS);
        } else if (TBZT_TH.equals(tbzt)) {
            setZt(ZT_XMCB_BS);
            setSfth(Global.YES);
        } else {
            setZt(null);
            setSfth(null);
        }
    }

    public Date getCreateDateStart() {
        return createDateStart;
    }

    public void setCreateDateStart(Date createDateStart) {
        if (null != createDateStart) {
            this.createDateStart = DateUtils.getDateStart(createDateStart);
        } else {
            this.createDateStart = createDateStart;
        }
    }

    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(Date createDateEnd) {
        if (null != createDateEnd) {
            this.createDateEnd = DateUtils.getDateEnd(createDateEnd);
        } else {
            this.createDateEnd = createDateEnd;
        }
    }

    //获取开始时间查询的时间区间字符串，回显查询界面
    public String getCreateDateBT() {
        if (null != createDateStart && null != createDateEnd) {
            String createDateStartStr = DateUtils.formatDate(createDateStart, "yyyy-MM-dd");
            String createDateEndStr = DateUtils.formatDate(createDateEnd, "yyyy-MM-dd");
            return createDateStartStr + " ~ " + createDateEndStr;
        }
        return "";
    }

    public Date getUpdateDateStart() {
        return updateDateStart;
    }

    public void setUpdateDateStart(Date updateDateStart) {
        if (null != updateDateStart) {
            this.updateDateStart = DateUtils.getDateStart(updateDateStart);
        } else {
            this.updateDateStart = updateDateStart;
        }
    }

    public Date getUpdateDateEnd() {
        return updateDateEnd;
    }

    public void setUpdateDateEnd(Date updateDateEnd) {
        if (null != createDateStart) {
            this.updateDateEnd = DateUtils.getDateEnd(updateDateEnd);
        } else {
            this.updateDateEnd = updateDateEnd;
        }
    }

    //获取开始时间查询的时间区间字符串，回显查询界面
    public String getUpdateDateBT() {
        if (null != updateDateStart && null != updateDateEnd) {
            String updateDateStartStr = DateUtils.formatDate(updateDateStart, "yyyy-MM-dd");
            String updateDateEndStr = DateUtils.formatDate(updateDateEnd, "yyyy-MM-dd");
            return updateDateStartStr + " ~ " + updateDateEndStr;
        }
        return "";
    }

    public String getStartTimeNStart() {
        return startTimeNStart;
    }

    public void setStartTimeNStart(String startTimeNStart) {
        this.startTimeNStart = startTimeNStart;
    }

    public String getStartTimeNEnd() {
        return startTimeNEnd;
    }

    public void setStartTimeNEnd(String startTimeNEnd) {
        this.startTimeNEnd = startTimeNEnd;
    }

    //获取开始时间查询的时间区间字符串，回显查询界面
    public String getStartTimeNBT() {
        if (StringUtils.isNotBlank(startTimeNStart) && StringUtils.isNotBlank(startTimeNEnd)) {
            return startTimeNStart + " ~ " + startTimeNEnd;
        }
        return "";
    }

    public String getEndTimeStart() {
        return endTimeStart;
    }

    public void setEndTimeStart(String endTimeStart) {
        this.endTimeStart = endTimeStart;
    }

    public String getEndTimeEnd() {
        return endTimeEnd;
    }

    public void setEndTimeEnd(String endTimeEnd) {
        this.endTimeEnd = endTimeEnd;
    }

    //获取开始时间查询的时间区间字符串，回显查询界面
    public String getEndTimeBT() {
        if (StringUtils.isNotBlank(endTimeStart) && StringUtils.isNotBlank(endTimeEnd)) {
            return endTimeStart + " ~ " + endTimeEnd;
        }
        return "";
    }

    public Date getJhbzDateStart() {
        return jhbzDateStart;
    }

    public void setJhbzDateStart(Date jhbzDateStart) {
        if (null != jhbzDateStart) {
            this.jhbzDateStart = DateUtils.getDateStart(jhbzDateStart);
        } else {
            this.jhbzDateStart = jhbzDateStart;
        }
    }

    public Date getJhbzDateEnd() {
        return jhbzDateEnd;
    }

    public void setJhbzDateEnd(Date jhbzDateEnd) {
        if (null != jhbzDateEnd) {
            this.jhbzDateEnd = DateUtils.getDateStart(jhbzDateEnd);
        } else {
            this.jhbzDateEnd = jhbzDateEnd;
        }
    }

    //获取开始时间查询的时间区间字符串，回显查询界面
    public String getJhbzDateBT() {
        if (null != jhbzDateStart && null != jhbzDateEnd) {
            String jhbzDateStartStr = DateUtils.formatDate(jhbzDateStart, "yyyy-MM-dd");
            String jhbzDateEndStr = DateUtils.formatDate(jhbzDateEnd, "yyyy-MM-dd");
            return jhbzDateStartStr + " ~ " + jhbzDateEndStr;
        }
        return "";
    }

    public String getSjly() {
        return sjly;
    }

    public void setSjly(String sjly) {
        this.sjly = sjly;
    }

    public String getXmscjd() {
		return xmscjd;
	}

	public void setXmscjd(String xmscjd) {
		this.xmscjd = xmscjd;
	}

	//填报状态（1.待上报  2.退回）
    public static final String TBZT_DSB = "1";//待上报，项目填写完成后未上报的状态
    public static final String TBZT_TH = "2";//退回，项目填写完成后上报被退回的状态

    // 数据来源
    public static final String SJLY_BJDWBZ = "1";//数据来源，本级单位编制
    public static final String SJLY_XJDWBS = "2";//数据来源，下级单位报送
}
