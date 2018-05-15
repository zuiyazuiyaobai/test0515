package com.jeeplus.modules.xmjbxx.vo;

import com.jeeplus.common.config.Global;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.modules.xmjbxx.entity.Xmjbxx;
import com.jeeplus.modules.xmjbxx.entity.sub.CInsBusinessXmjbxxDeptRelation;

import java.util.Calendar;
import java.util.Date;

public class CInsBusinessXmjbxxDeptRelationSearchParameter extends CInsBusinessXmjbxxDeptRelation{
    private String tbzt;//填报状态（0.全部  1.待上报  2.退回）
    private Integer ztzMin;//总金额_小
    private Integer ztzMax;//总金额_大
    private Date createDateStart;//创建时间开始查询时间
    private Date createDateEnd;//创建时间结束查询时间
    private Date bsDateStart;//创建时间开始查询时间
    private Date bsDateEnd;//创建时间结束查询时间
	private XmjbxxSearchParameter xmjbxxSearchParameter;//项目基本信息的搜索参数包装类

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

    private Xmjbxx getThisXmjbxx(){
        Xmjbxx xmjbxx = this.getXmjbxx();
        if (null == xmjbxx) {
            xmjbxx = new Xmjbxx();
            this.setXmjbxx(xmjbxx);
        }
        return xmjbxx;
    }

    public void setTbzt(String tbzt) {
        this.tbzt = tbzt;
        Xmjbxx xmjbxx = getThisXmjbxx();
        if (XmjbxxSearchParameter.TBZT_DSB.equals(tbzt)) {//待上报，项目填写完成后未上报的状态
            xmjbxx.setZt(Xmjbxx.ZT_XMCB_BS);
        } else if (XmjbxxSearchParameter.TBZT_TH.equals(tbzt)) {
            xmjbxx.setZt(Xmjbxx.ZT_XMCB_BS);
            xmjbxx.setSfth(Global.YES);
        } else {
            xmjbxx.setZt(null);
            xmjbxx.setSfth(null);
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

    public Date getBsDateStart() {
        return bsDateStart;
    }

    public void setBsDateStart(Date bsDateStart) {
        if (null != bsDateStart) {
            this.bsDateStart = DateUtils.getDateEnd(bsDateStart);
        } else {
            this.bsDateStart = bsDateStart;
        }
    }

    public Date getBsDateEnd() {
        return bsDateEnd;
    }

    public void setBsDateEnd(Date bsDateEnd) {
        if (null != bsDateEnd) {
            this.bsDateEnd = DateUtils.getDateEnd(bsDateEnd);
        } else {
            this.bsDateEnd = bsDateEnd;
        }
    }

    //获取开始时间查询的时间区间字符串，回显查询界面
    public String getBsDateBT() {
        if (null != bsDateStart && null != bsDateEnd) {
            String bsDateStartStr = DateUtils.formatDate(bsDateStart, "yyyy-MM-dd");
            String bsDateEndStr = DateUtils.formatDate(bsDateEnd, "yyyy-MM-dd");
            return bsDateStartStr + " ~ " + bsDateEndStr;
        }
        return "";
    }

    public XmjbxxSearchParameter getXmjbxxSearchParameter() {
        return xmjbxxSearchParameter;
    }

    public void setXmjbxxSearchParameter(XmjbxxSearchParameter xmjbxxSearchParameter) {
        this.xmjbxxSearchParameter = xmjbxxSearchParameter;
    }

    // 已上报、被退回、在库
    public static final String CBZT_YSB = "1";
    public static final String CBZT_BTH = "2";
    public static final String CBZT_ZK = "3";
}
