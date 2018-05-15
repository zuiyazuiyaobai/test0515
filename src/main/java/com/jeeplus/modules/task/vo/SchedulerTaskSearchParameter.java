package com.jeeplus.modules.task.vo;

import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.modules.task.entity.CInsBusinessSchedulerTask;

import java.util.Date;

public class SchedulerTaskSearchParameter extends CInsBusinessSchedulerTask{
    private Date startDateStart;//开始时间 开始查询时间
    private Date startDateEnd;//开始时间 结束查询时间
    private Date endDateStart;//结束时间 开始查询时间
    private Date endDateEnd;//结束时间 结束查询时间

    public Date getStartDateStart() {
        return startDateStart;
    }

    public void setStartDateStart(Date startDateStart) {
        this.startDateStart = startDateStart;
    }

    public Date getStartDateEnd() {
        return startDateEnd;
    }

    public void setStartDateEnd(Date startDateEnd) {
        this.startDateEnd = startDateEnd;
    }

    public Date getEndDateStart() {
        return endDateStart;
    }

    public void setEndDateStart(Date endDateStart) {
        this.endDateStart = endDateStart;
    }

    public Date getEndDateEnd() {
        return endDateEnd;
    }

    public void setEndDateEnd(Date endDateEnd) {
        this.endDateEnd = endDateEnd;
    }

    //获取开始时间查询的时间区间字符串，回显查询界面
    public String getStartDateStr() {
        if (null != startDateStart && null != startDateEnd) {
            String startDateStartStr = DateUtils.formatDate(startDateStart, "yyyy-MM-dd");
            String startDateEndStr = DateUtils.formatDate(startDateEnd, "yyyy-MM-dd");
            return startDateStartStr + " - " + startDateEndStr;
        }
        return "";
    }

    //获取开始时间查询的时间区间字符串，回显查询界面
    public String getEndDateStr() {
        if (null != endDateStart && null != endDateEnd) {
            String endDateStartStr = DateUtils.formatDate(endDateStart, "yyyy-MM-dd");
            String endDateEndStr = DateUtils.formatDate(endDateEnd, "yyyy-MM-dd");
            return endDateStartStr + " - " + endDateEndStr;
        }
        return "";
    }

}
