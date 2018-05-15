/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.task.entity.CInsBusinessXmjbxxTaskRelation;

/**
 * 实施情况Entity
 * @author zcl
 * @version 2017-11-03
 */
public class CInsBusinessSsqk extends DataEntity<CInsBusinessSsqk> {
	
	private static final long serialVersionUID = 1L;
	private Xmjbxx xmjbxx;		// 项目基本信息ID
	private CInsBusinessXmjbxxTaskRelation taskRelation;		// 调度任务关联表ID

	// 实施情况类型（1.项目填报 2.调度反馈）
	// 项目填报时保存的实施情况类型为“1”，调度反馈“完成”时，最新调度反馈的数据覆盖项目填报的实施情况
	private String type;

	private String name;		// 本期调度填报人 姓名
	private String office;		// 本期调度填报人 工作单位
	private String mobile;		// 本期调度填报人 手机
	private Date sjkgsj;		// 实际开工时间
	private Date sjjgsj;		// 实际竣工时间
	private String ztbxs;		// 招投标形式
	private String ssqkjsdw;		// 建设单位
	private String ssqkxxjd;		// 形象进度
	private String ssqkndjsnr;		// 年度建设内容
	private String ssqkwtjjy;		// 问题及建议 进展情况及下一步工作安排
	private String ssqkrcjgzjzrdw;		// 日常监管直接责任单位
	private String ssqktzjhtzqk;		// 投资计划调整情况
	private String ssqkzfjcjglxr;		// 政府督查机构联系人
	private String ssqkdcjglxfs;		// 联系方式（电话）
	private String ssqkfgbmlxr;		// 发改部门联系人
	private String ssqlfgbmlxfs;		// 联系方式（电话）
	private Double zyysntzljwczj;		// 中央预算内投资 累计完成资金
	private Double zyysntzljzfqk;		// 中央预算内投资 累计支付情况
	private Double zxzqmjdzxjszjljwczj;		// 专项债券募集的专项建设资金 累计完成资金
	private Double zxzqmjdzxjszjljzfqk;		// 专项债券募集的专项建设资金 累计支付情况
	private Double qtlbhzljwczj;		// 其他类别汇总 累计完成资金
	private Double qtlbhzljwcqk;		// 其他类别汇总 累计支付情况
	private Double zyysntzLjdwzj;		// 中央预算内投资 累计到位资金
	private Double qtzyczxjszjLjdwzj;		// 其他中央财政性建设资金 累计到位资金
	private Double zxzqmjdzxjszjLjdwzj;		// 专项债券募集的专项建设资金 累计到位资金
	private Double zysljsjjLjdwzj;		// 中央水利建设基金 累计到位资金
	private Double nsbdgcjjLjdwzj;		// 南水北调工程基金 累计到位资金
	private Double tljszxjjLjdwzj;		// 铁路建设专项基金 累计到位资金
	private Double mhfzjjLjdwzj;		// 民航发展基金 累计到位资金
	private Double gjzdslgcjsjjLjdwzj;		// 国际重大水利工程建设基金 累计到位资金
	private Double dzxskymhqfcjjLjdwzj;		// 大中型水库移民后期扶持基金 累计到位资金
	private Double dzxskymhqfcjyjjLjdwzj;		// 大中型水库移民后期扶持结余基金 累计到位资金
	private Double glgkjszxjjLjdwzj;		// 公路港口建设专项基金 累计到位资金
	private Double shengjiysntzLjdwzj;		// 省级预算内投资 累计到位资金
	private Double shijiysntzLjdwzj;		// 市级预算内投资 累计到位资金
	private Double xianjiysntzLjdwzj;		// 县级预算内投资 累计到位资金
	private Double shengjiczzjLjdwzj;		// 省级财政资金 累计到位资金
	private Double shijiczzjLjdwzj;		// 市级财政资金 累计到位资金
	private Double xianjiczzjLjdwzj;		// 县级财政资金 累计到位资金
	private Double dfzxjsjjLjdwzj;		// 地方专项建设基金 累计到位资金
	private Double qyzytzLjdwzj;		// 企业自由投资 累计到位资金
	private Double yhdkLjdwzj;		// 银行贷款 累计到位资金
	private Double lywzLjdwzj;		// 利用外资 累计到位资金
	private Double zjqdddLjdwzj;		// 资金渠道待定 累计到位资金
	private Double qtzjLjdwzj;		// 其他资金 累计到位资金
	private String updatestatus;
	
	//已经完成投资(万元)
	private String zyysntzjzbbgljwcjj;
	private String qtzyczxjszjjzbbgljwcjj;
	private String zxzqmjjszjjzbbgljwcjj;
	private String zyzxjszjjzbbgljwcjj;
	private String zysljszjjzbbgljwcjj;
	private String nsbdgczjjzbbgljwcjj;
	private String tljszxzjjzbbgljwcjj;
	private String mhfzzjjzbbgljwcjj;
	private String gjzdslgcjszjjzbbgljwcjj;
	private String dzxskymhqfczjjzbbgljwcjj;
	private String dzxskymhqfcjyzjjzbbgljwcjj;
	private String glgkjszjjzbbgljwcjj;
	private String dfysntzjzbbgljwcjj;
	private String sjysntzjzbbgljwcjj;
	private String cityjysntzjzbbgljwcjj;
	private String xjysntzjzbbgljwcjj;
	private String dfczxjszjjzbbgljwcjj;
	private String sjczzjjzbbgljwcjj;
	private String cityjczzjjzbbgljwcjj;
	private String xjczzjjzbbgljwcjj;
	private String dfzxjszjjzbbgljwcjj;
	private String qyzytzjzbbgljwcjj;
	private String yhdkjzbbgljwcjj;
	private String lywzjzbbgljwcjj;
	private String zjqdddjzbbgljwcjj;
	private String qtzjjzbbgljwcjj;
	private String hjjzbbgljwcjj;
	//保存状态为
	private String exchangeflag;	
	private String xmjbxxid;
	private Date createdate;
	private Date updatedate;
	private String delflag;
	private String createby;
	private String updateby;
	
	private String zyysntzljzfzj;
	private String qtzyczxjszjljzfzj;
	private String zxzqmjdzxjszjljzfzj;
	private String zysljsjjljzfzj;
	private String nsbdgcjjljzfzj;
	private String tljszxjjljzfzj;
	private String mhfzjjljzfzj;
	private String gjzdslgcjsjjljzfzj;
	private String dzxskymhqfcjjljzfzj;
	private String dzxskymhqfcjyjjljzfzj;
	private String glgkjszxjjljzfzj;
	private String shengjiysntzljzfzj;
	private String shijiysntzljzfzj;
	private String xianjiysntzljzfzj;
	private String shengjiczzjljzfzj;
	private String shijiczzjljzfzj;
	private String xianjiczzjljzfzj;
	private String dfzxjsjjljzfzj;
	private String qyzytzljzfzj;
	private String yhdkljzfzj;
	private String lywzljzfzj;
	private String zjqdddljzfzj;
	private String qtzjljzfzj;
		
	private String zyysntzljdwzjtwo;
	private String qtzyczxjszjljdwzjtwo;
	private String zxzqmjdzxjszjljdwzjtwo;
	private String zysljsjjljdwzjtwo;
	private String nsbdgcjjljdwzjtwo;
	private String tljszxjjljdwzjtwo;
	private String mhfzjjljdwzjtwo;
	private String gjzdslgcjsjjljdwzjtwo;
	private String dzxskymhqfcjjljdwzjtwo;
	private String dzxskymhqfcjyjjljdwzjtwo;
	private String glgkjszxjjljdwzjtwo;
	private String shengjiysntzljdwzjtwo;
	private String shijiysntzljdwzjtwo;
	private String xianjiysntzljdwzjtwo;
	private String shengjiczzjljdwzjtwo;
	private String shijiczzjljdwzjtwo;
	private String xianjiczzjljdwzjtwo;
	private String dfzxjsjjljdwzjtwo;
	private String qyzytzljdwzjtwo;
	private String yhdkljdwzjtwo;
	private String lywzljdwzjtwo;
	private String zjqdddljdwzjtwo;
	private String qtzjljdwzjtwo;
	
	private String sfkg;
	public String getSfkg() {
		return sfkg;
	}

	public void setSfkg(String sfkg) {
		this.sfkg = sfkg;
	}

	public CInsBusinessSsqk() {
		super();
	}

	public CInsBusinessSsqk(String id){
		super(id);
	}

	public Xmjbxx getXmjbxx() {
		return xmjbxx;
	}

	public void setXmjbxx(Xmjbxx xmjbxx) {
		this.xmjbxx = xmjbxx;
	}

	public CInsBusinessXmjbxxTaskRelation getTaskRelation() {
		return taskRelation;
	}

	public void setTaskRelation(CInsBusinessXmjbxxTaskRelation taskRelation) {
		this.taskRelation = taskRelation;
	}

	@ExcelField(title="本期调度填报人 姓名", align=2, sort=9)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ExcelField(title="本期调度填报人 工作单位", align=2, sort=10)
	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}
	
	@ExcelField(title="本期调度填报人 手机", align=2, sort=11)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="实际开工时间", align=2, sort=12)
	public Date getSjkgsj() {
		return sjkgsj;
	}

	public void setSjkgsj(Date sjkgsj) {
		this.sjkgsj = sjkgsj;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="实际竣工时间", align=2, sort=13)
	public Date getSjjgsj() {
		return sjjgsj;
	}

	public void setSjjgsj(Date sjjgsj) {
		this.sjjgsj = sjjgsj;
	}
	
	@ExcelField(title="招投标形式", align=2, sort=14)
	public String getZtbxs() {
		return ztbxs;
	}

	public void setZtbxs(String ztbxs) {
		this.ztbxs = ztbxs;
	}
	
	@ExcelField(title="建设单位", align=2, sort=15)
	public String getSsqkjsdw() {
		return ssqkjsdw;
	}

	public void setSsqkjsdw(String ssqkjsdw) {
		this.ssqkjsdw = ssqkjsdw;
	}
	
	@ExcelField(title="形象进度", align=2, sort=16)
	public String getSsqkxxjd() {
		return ssqkxxjd;
	}

	public void setSsqkxxjd(String ssqkxxjd) {
		this.ssqkxxjd = ssqkxxjd;
	}
	
	@ExcelField(title="年度建设内容", align=2, sort=17)
	public String getSsqkndjsnr() {
		return ssqkndjsnr;
	}

	public void setSsqkndjsnr(String ssqkndjsnr) {
		this.ssqkndjsnr = ssqkndjsnr;
	}
	
	@ExcelField(title="问题及建议 进展情况及下一步工作安排", align=2, sort=18)
	public String getSsqkwtjjy() {
		return ssqkwtjjy;
	}

	public void setSsqkwtjjy(String ssqkwtjjy) {
		this.ssqkwtjjy = ssqkwtjjy;
	}
	
	@ExcelField(title="日常监管直接责任单位", align=2, sort=19)
	public String getSsqkrcjgzjzrdw() {
		return ssqkrcjgzjzrdw;
	}

	public void setSsqkrcjgzjzrdw(String ssqkrcjgzjzrdw) {
		this.ssqkrcjgzjzrdw = ssqkrcjgzjzrdw;
	}
	
	@ExcelField(title="投资计划调整情况", align=2, sort=20)
	public String getSsqktzjhtzqk() {
		return ssqktzjhtzqk;
	}

	public void setSsqktzjhtzqk(String ssqktzjhtzqk) {
		this.ssqktzjhtzqk = ssqktzjhtzqk;
	}
	
	@ExcelField(title="政府督查机构联系人", align=2, sort=21)
	public String getSsqkzfjcjglxr() {
		return ssqkzfjcjglxr;
	}

	public void setSsqkzfjcjglxr(String ssqkzfjcjglxr) {
		this.ssqkzfjcjglxr = ssqkzfjcjglxr;
	}
	
	@ExcelField(title="联系方式（电话）", align=2, sort=22)
	public String getSsqkdcjglxfs() {
		return ssqkdcjglxfs;
	}

	public void setSsqkdcjglxfs(String ssqkdcjglxfs) {
		this.ssqkdcjglxfs = ssqkdcjglxfs;
	}
	
	@ExcelField(title="发改部门联系人", align=2, sort=23)
	public String getSsqkfgbmlxr() {
		return ssqkfgbmlxr;
	}

	public void setSsqkfgbmlxr(String ssqkfgbmlxr) {
		this.ssqkfgbmlxr = ssqkfgbmlxr;
	}
	
	@ExcelField(title="联系方式（电话）", align=2, sort=24)
	public String getSsqlfgbmlxfs() {
		return ssqlfgbmlxfs;
	}

	public void setSsqlfgbmlxfs(String ssqlfgbmlxfs) {
		this.ssqlfgbmlxfs = ssqlfgbmlxfs;
	}
	
	@ExcelField(title="实施情况类型（1.项目填报 2.调度反馈）", align=2, sort=25)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@ExcelField(title="中央预算内投资 累计完成资金", align=2, sort=26)
	public Double getZyysntzljwczj() {
		return zyysntzljwczj;
	}

	public void setZyysntzljwczj(Double zyysntzljwczj) {
		this.zyysntzljwczj = zyysntzljwczj;
	}
	
	@ExcelField(title="中央预算内投资 累计支付情况", align=2, sort=27)
	public Double getZyysntzljzfqk() {
		return zyysntzljzfqk;
	}

	public void setZyysntzljzfqk(Double zyysntzljzfqk) {
		this.zyysntzljzfqk = zyysntzljzfqk;
	}
	
	@ExcelField(title="专项债券募集的专项建设资金 累计完成资金", align=2, sort=28)
	public Double getZxzqmjdzxjszjljwczj() {
		return zxzqmjdzxjszjljwczj;
	}

	public void setZxzqmjdzxjszjljwczj(Double zxzqmjdzxjszjljwczj) {
		this.zxzqmjdzxjszjljwczj = zxzqmjdzxjszjljwczj;
	}
	
	@ExcelField(title="专项债券募集的专项建设资金 累计支付情况", align=2, sort=29)
	public Double getZxzqmjdzxjszjljzfqk() {
		return zxzqmjdzxjszjljzfqk;
	}

	public void setZxzqmjdzxjszjljzfqk(Double zxzqmjdzxjszjljzfqk) {
		this.zxzqmjdzxjszjljzfqk = zxzqmjdzxjszjljzfqk;
	}
	
	@ExcelField(title="其他类别汇总 累计完成资金", align=2, sort=30)
	public Double getQtlbhzljwczj() {
		return qtlbhzljwczj;
	}

	public void setQtlbhzljwczj(Double qtlbhzljwczj) {
		this.qtlbhzljwczj = qtlbhzljwczj;
	}
	
	@ExcelField(title="其他类别汇总 累计支付情况", align=2, sort=31)
	public Double getQtlbhzljwcqk() {
		return qtlbhzljwcqk;
	}

	public void setQtlbhzljwcqk(Double qtlbhzljwcqk) {
		this.qtlbhzljwcqk = qtlbhzljwcqk;
	}
	
	@ExcelField(title="中央预算内投资 累计到位资金", align=2, sort=32)
	public Double getZyysntzLjdwzj() {
		return zyysntzLjdwzj;
	}

	public void setZyysntzLjdwzj(Double zyysntzLjdwzj) {
		this.zyysntzLjdwzj = zyysntzLjdwzj;
	}
	
	@ExcelField(title="其他中央财政性建设资金 累计到位资金", align=2, sort=33)
	public Double getQtzyczxjszjLjdwzj() {
		return qtzyczxjszjLjdwzj;
	}

	public void setQtzyczxjszjLjdwzj(Double qtzyczxjszjLjdwzj) {
		this.qtzyczxjszjLjdwzj = qtzyczxjszjLjdwzj;
	}
	
	@ExcelField(title="专项债券募集的专项建设资金 累计到位资金", align=2, sort=34)
	public Double getZxzqmjdzxjszjLjdwzj() {
		return zxzqmjdzxjszjLjdwzj;
	}

	public void setZxzqmjdzxjszjLjdwzj(Double zxzqmjdzxjszjLjdwzj) {
		this.zxzqmjdzxjszjLjdwzj = zxzqmjdzxjszjLjdwzj;
	}
	
	@ExcelField(title="中央水利建设基金 累计到位资金", align=2, sort=35)
	public Double getZysljsjjLjdwzj() {
		return zysljsjjLjdwzj;
	}

	public void setZysljsjjLjdwzj(Double zysljsjjLjdwzj) {
		this.zysljsjjLjdwzj = zysljsjjLjdwzj;
	}
	
	@ExcelField(title="南水北调工程基金 累计到位资金", align=2, sort=36)
	public Double getNsbdgcjjLjdwzj() {
		return nsbdgcjjLjdwzj;
	}

	public void setNsbdgcjjLjdwzj(Double nsbdgcjjLjdwzj) {
		this.nsbdgcjjLjdwzj = nsbdgcjjLjdwzj;
	}
	
	@ExcelField(title="铁路建设专项基金 累计到位资金", align=2, sort=37)
	public Double getTljszxjjLjdwzj() {
		return tljszxjjLjdwzj;
	}

	public void setTljszxjjLjdwzj(Double tljszxjjLjdwzj) {
		this.tljszxjjLjdwzj = tljszxjjLjdwzj;
	}
	
	@ExcelField(title="民航发展基金 累计到位资金", align=2, sort=38)
	public Double getMhfzjjLjdwzj() {
		return mhfzjjLjdwzj;
	}

	public void setMhfzjjLjdwzj(Double mhfzjjLjdwzj) {
		this.mhfzjjLjdwzj = mhfzjjLjdwzj;
	}
	
	@ExcelField(title="国际重大水利工程建设基金 累计到位资金", align=2, sort=39)
	public Double getGjzdslgcjsjjLjdwzj() {
		return gjzdslgcjsjjLjdwzj;
	}

	public void setGjzdslgcjsjjLjdwzj(Double gjzdslgcjsjjLjdwzj) {
		this.gjzdslgcjsjjLjdwzj = gjzdslgcjsjjLjdwzj;
	}
	
	@ExcelField(title="大中型水库移民后期扶持基金 累计到位资金", align=2, sort=40)
	public Double getDzxskymhqfcjjLjdwzj() {
		return dzxskymhqfcjjLjdwzj;
	}

	public void setDzxskymhqfcjjLjdwzj(Double dzxskymhqfcjjLjdwzj) {
		this.dzxskymhqfcjjLjdwzj = dzxskymhqfcjjLjdwzj;
	}
	
	@ExcelField(title="大中型水库移民后期扶持结余基金 累计到位资金", align=2, sort=41)
	public Double getDzxskymhqfcjyjjLjdwzj() {
		return dzxskymhqfcjyjjLjdwzj;
	}

	public void setDzxskymhqfcjyjjLjdwzj(Double dzxskymhqfcjyjjLjdwzj) {
		this.dzxskymhqfcjyjjLjdwzj = dzxskymhqfcjyjjLjdwzj;
	}
	
	@ExcelField(title="公路港口建设专项基金 累计到位资金", align=2, sort=42)
	public Double getGlgkjszxjjLjdwzj() {
		return glgkjszxjjLjdwzj;
	}

	public void setGlgkjszxjjLjdwzj(Double glgkjszxjjLjdwzj) {
		this.glgkjszxjjLjdwzj = glgkjszxjjLjdwzj;
	}
	
	@ExcelField(title="省级预算内投资 累计到位资金", align=2, sort=43)
	public Double getShengjiysntzLjdwzj() {
		return shengjiysntzLjdwzj;
	}

	public void setShengjiysntzLjdwzj(Double shengjiysntzLjdwzj) {
		this.shengjiysntzLjdwzj = shengjiysntzLjdwzj;
	}
	
	@ExcelField(title="市级预算内投资 累计到位资金", align=2, sort=44)
	public Double getShijiysntzLjdwzj() {
		return shijiysntzLjdwzj;
	}

	public void setShijiysntzLjdwzj(Double shijiysntzLjdwzj) {
		this.shijiysntzLjdwzj = shijiysntzLjdwzj;
	}
	
	@ExcelField(title="县级预算内投资 累计到位资金", align=2, sort=45)
	public Double getXianjiysntzLjdwzj() {
		return xianjiysntzLjdwzj;
	}

	public void setXianjiysntzLjdwzj(Double xianjiysntzLjdwzj) {
		this.xianjiysntzLjdwzj = xianjiysntzLjdwzj;
	}
	
	@ExcelField(title="省级财政资金 累计到位资金", align=2, sort=46)
	public Double getShengjiczzjLjdwzj() {
		return shengjiczzjLjdwzj;
	}

	public void setShengjiczzjLjdwzj(Double shengjiczzjLjdwzj) {
		this.shengjiczzjLjdwzj = shengjiczzjLjdwzj;
	}
	
	@ExcelField(title="市级财政资金 累计到位资金", align=2, sort=47)
	public Double getShijiczzjLjdwzj() {
		return shijiczzjLjdwzj;
	}

	public void setShijiczzjLjdwzj(Double shijiczzjLjdwzj) {
		this.shijiczzjLjdwzj = shijiczzjLjdwzj;
	}
	
	@ExcelField(title="县级财政资金 累计到位资金", align=2, sort=48)
	public Double getXianjiczzjLjdwzj() {
		return xianjiczzjLjdwzj;
	}

	public void setXianjiczzjLjdwzj(Double xianjiczzjLjdwzj) {
		this.xianjiczzjLjdwzj = xianjiczzjLjdwzj;
	}
	
	@ExcelField(title="地方专项建设基金 累计到位资金", align=2, sort=49)
	public Double getDfzxjsjjLjdwzj() {
		return dfzxjsjjLjdwzj;
	}

	public void setDfzxjsjjLjdwzj(Double dfzxjsjjLjdwzj) {
		this.dfzxjsjjLjdwzj = dfzxjsjjLjdwzj;
	}
	
	@ExcelField(title="企业自由投资 累计到位资金", align=2, sort=50)
	public Double getQyzytzLjdwzj() {
		return qyzytzLjdwzj;
	}

	public void setQyzytzLjdwzj(Double qyzytzLjdwzj) {
		this.qyzytzLjdwzj = qyzytzLjdwzj;
	}
	
	@ExcelField(title="银行贷款 累计到位资金", align=2, sort=51)
	public Double getYhdkLjdwzj() {
		return yhdkLjdwzj;
	}

	public void setYhdkLjdwzj(Double yhdkLjdwzj) {
		this.yhdkLjdwzj = yhdkLjdwzj;
	}
	
	@ExcelField(title="利用外资 累计到位资金", align=2, sort=52)
	public Double getLywzLjdwzj() {
		return lywzLjdwzj;
	}

	public void setLywzLjdwzj(Double lywzLjdwzj) {
		this.lywzLjdwzj = lywzLjdwzj;
	}
	
	@ExcelField(title="资金渠道待定 累计到位资金", align=2, sort=53)
	public Double getZjqdddLjdwzj() {
		return zjqdddLjdwzj;
	}

	public void setZjqdddLjdwzj(Double zjqdddLjdwzj) {
		this.zjqdddLjdwzj = zjqdddLjdwzj;
	}
	
	@ExcelField(title="其他资金 累计到位资金", align=2, sort=54)
	public Double getQtzjLjdwzj() {
		return qtzjLjdwzj;
	}

	public void setQtzjLjdwzj(Double qtzjLjdwzj) {
		this.qtzjLjdwzj = qtzjLjdwzj;
	}
	
	public String getUpdatestatus() {
		return updatestatus;
	}

	public void setUpdatestatus(String updatestatus) {
		this.updatestatus = updatestatus;
	}
	
	

	public String getZyysntzjzbbgljwcjj() {
		return zyysntzjzbbgljwcjj;
	}

	public void setZyysntzjzbbgljwcjj(String zyysntzjzbbgljwcjj) {
		this.zyysntzjzbbgljwcjj = zyysntzjzbbgljwcjj;
	}

	public String getQtzyczxjszjjzbbgljwcjj() {
		return qtzyczxjszjjzbbgljwcjj;
	}

	public void setQtzyczxjszjjzbbgljwcjj(String qtzyczxjszjjzbbgljwcjj) {
		this.qtzyczxjszjjzbbgljwcjj = qtzyczxjszjjzbbgljwcjj;
	}

	public String getZxzqmjjszjjzbbgljwcjj() {
		return zxzqmjjszjjzbbgljwcjj;
	}

	public void setZxzqmjjszjjzbbgljwcjj(String zxzqmjjszjjzbbgljwcjj) {
		this.zxzqmjjszjjzbbgljwcjj = zxzqmjjszjjzbbgljwcjj;
	}

	public String getZyzxjszjjzbbgljwcjj() {
		return zyzxjszjjzbbgljwcjj;
	}

	public void setZyzxjszjjzbbgljwcjj(String zyzxjszjjzbbgljwcjj) {
		this.zyzxjszjjzbbgljwcjj = zyzxjszjjzbbgljwcjj;
	}

	public String getZysljszjjzbbgljwcjj() {
		return zysljszjjzbbgljwcjj;
	}

	public void setZysljszjjzbbgljwcjj(String zysljszjjzbbgljwcjj) {
		this.zysljszjjzbbgljwcjj = zysljszjjzbbgljwcjj;
	}

	public String getNsbdgczjjzbbgljwcjj() {
		return nsbdgczjjzbbgljwcjj;
	}

	public void setNsbdgczjjzbbgljwcjj(String nsbdgczjjzbbgljwcjj) {
		this.nsbdgczjjzbbgljwcjj = nsbdgczjjzbbgljwcjj;
	}

	public String getTljszxzjjzbbgljwcjj() {
		return tljszxzjjzbbgljwcjj;
	}

	public void setTljszxzjjzbbgljwcjj(String tljszxzjjzbbgljwcjj) {
		this.tljszxzjjzbbgljwcjj = tljszxzjjzbbgljwcjj;
	}

	public String getMhfzzjjzbbgljwcjj() {
		return mhfzzjjzbbgljwcjj;
	}

	public void setMhfzzjjzbbgljwcjj(String mhfzzjjzbbgljwcjj) {
		this.mhfzzjjzbbgljwcjj = mhfzzjjzbbgljwcjj;
	}

	public String getGjzdslgcjszjjzbbgljwcjj() {
		return gjzdslgcjszjjzbbgljwcjj;
	}

	public void setGjzdslgcjszjjzbbgljwcjj(String gjzdslgcjszjjzbbgljwcjj) {
		this.gjzdslgcjszjjzbbgljwcjj = gjzdslgcjszjjzbbgljwcjj;
	}

	public String getDzxskymhqfczjjzbbgljwcjj() {
		return dzxskymhqfczjjzbbgljwcjj;
	}

	public void setDzxskymhqfczjjzbbgljwcjj(String dzxskymhqfczjjzbbgljwcjj) {
		this.dzxskymhqfczjjzbbgljwcjj = dzxskymhqfczjjzbbgljwcjj;
	}

	public String getDzxskymhqfcjyzjjzbbgljwcjj() {
		return dzxskymhqfcjyzjjzbbgljwcjj;
	}

	public void setDzxskymhqfcjyzjjzbbgljwcjj(String dzxskymhqfcjyzjjzbbgljwcjj) {
		this.dzxskymhqfcjyzjjzbbgljwcjj = dzxskymhqfcjyzjjzbbgljwcjj;
	}

	public String getGlgkjszjjzbbgljwcjj() {
		return glgkjszjjzbbgljwcjj;
	}

	public void setGlgkjszjjzbbgljwcjj(String glgkjszjjzbbgljwcjj) {
		this.glgkjszjjzbbgljwcjj = glgkjszjjzbbgljwcjj;
	}

	public String getDfysntzjzbbgljwcjj() {
		return dfysntzjzbbgljwcjj;
	}

	public void setDfysntzjzbbgljwcjj(String dfysntzjzbbgljwcjj) {
		this.dfysntzjzbbgljwcjj = dfysntzjzbbgljwcjj;
	}

	public String getSjysntzjzbbgljwcjj() {
		return sjysntzjzbbgljwcjj;
	}

	public void setSjysntzjzbbgljwcjj(String sjysntzjzbbgljwcjj) {
		this.sjysntzjzbbgljwcjj = sjysntzjzbbgljwcjj;
	}

	public String getCityjysntzjzbbgljwcjj() {
		return cityjysntzjzbbgljwcjj;
	}

	public void setCityjysntzjzbbgljwcjj(String cityjysntzjzbbgljwcjj) {
		this.cityjysntzjzbbgljwcjj = cityjysntzjzbbgljwcjj;
	}

	public String getXjysntzjzbbgljwcjj() {
		return xjysntzjzbbgljwcjj;
	}

	public void setXjysntzjzbbgljwcjj(String xjysntzjzbbgljwcjj) {
		this.xjysntzjzbbgljwcjj = xjysntzjzbbgljwcjj;
	}

	public String getDfczxjszjjzbbgljwcjj() {
		return dfczxjszjjzbbgljwcjj;
	}

	public void setDfczxjszjjzbbgljwcjj(String dfczxjszjjzbbgljwcjj) {
		this.dfczxjszjjzbbgljwcjj = dfczxjszjjzbbgljwcjj;
	}

	public String getSjczzjjzbbgljwcjj() {
		return sjczzjjzbbgljwcjj;
	}

	public void setSjczzjjzbbgljwcjj(String sjczzjjzbbgljwcjj) {
		this.sjczzjjzbbgljwcjj = sjczzjjzbbgljwcjj;
	}

	public String getCityjczzjjzbbgljwcjj() {
		return cityjczzjjzbbgljwcjj;
	}

	public void setCityjczzjjzbbgljwcjj(String cityjczzjjzbbgljwcjj) {
		this.cityjczzjjzbbgljwcjj = cityjczzjjzbbgljwcjj;
	}

	public String getXjczzjjzbbgljwcjj() {
		return xjczzjjzbbgljwcjj;
	}

	public void setXjczzjjzbbgljwcjj(String xjczzjjzbbgljwcjj) {
		this.xjczzjjzbbgljwcjj = xjczzjjzbbgljwcjj;
	}

	public String getDfzxjszjjzbbgljwcjj() {
		return dfzxjszjjzbbgljwcjj;
	}

	public void setDfzxjszjjzbbgljwcjj(String dfzxjszjjzbbgljwcjj) {
		this.dfzxjszjjzbbgljwcjj = dfzxjszjjzbbgljwcjj;
	}

	public String getQyzytzjzbbgljwcjj() {
		return qyzytzjzbbgljwcjj;
	}

	public void setQyzytzjzbbgljwcjj(String qyzytzjzbbgljwcjj) {
		this.qyzytzjzbbgljwcjj = qyzytzjzbbgljwcjj;
	}

	public String getYhdkjzbbgljwcjj() {
		return yhdkjzbbgljwcjj;
	}

	public void setYhdkjzbbgljwcjj(String yhdkjzbbgljwcjj) {
		this.yhdkjzbbgljwcjj = yhdkjzbbgljwcjj;
	}

	public String getLywzjzbbgljwcjj() {
		return lywzjzbbgljwcjj;
	}

	public void setLywzjzbbgljwcjj(String lywzjzbbgljwcjj) {
		this.lywzjzbbgljwcjj = lywzjzbbgljwcjj;
	}

	public String getZjqdddjzbbgljwcjj() {
		return zjqdddjzbbgljwcjj;
	}

	public void setZjqdddjzbbgljwcjj(String zjqdddjzbbgljwcjj) {
		this.zjqdddjzbbgljwcjj = zjqdddjzbbgljwcjj;
	}

	public String getQtzjjzbbgljwcjj() {
		return qtzjjzbbgljwcjj;
	}

	public void setQtzjjzbbgljwcjj(String qtzjjzbbgljwcjj) {
		this.qtzjjzbbgljwcjj = qtzjjzbbgljwcjj;
	}

	public String getHjjzbbgljwcjj() {
		return hjjzbbgljwcjj;
	}

	public void setHjjzbbgljwcjj(String hjjzbbgljwcjj) {
		this.hjjzbbgljwcjj = hjjzbbgljwcjj;
	}

	public String getExchangeflag() {
		return exchangeflag;
	}

	public void setExchangeflag(String exchangeflag) {
		this.exchangeflag = exchangeflag;
	}

	public String getXmjbxxid() {
		return xmjbxxid;
	}

	public void setXmjbxxid(String xmjbxxid) {
		this.xmjbxxid = xmjbxxid;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public String getUpdateby() {
		return updateby;
	}

	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}

	public String getZyysntzljzfzj() {
		return zyysntzljzfzj;
	}

	public void setZyysntzljzfzj(String zyysntzljzfzj) {
		this.zyysntzljzfzj = zyysntzljzfzj;
	}

	public String getQtzyczxjszjljzfzj() {
		return qtzyczxjszjljzfzj;
	}

	public void setQtzyczxjszjljzfzj(String qtzyczxjszjljzfzj) {
		this.qtzyczxjszjljzfzj = qtzyczxjszjljzfzj;
	}

	public String getZxzqmjdzxjszjljzfzj() {
		return zxzqmjdzxjszjljzfzj;
	}

	public void setZxzqmjdzxjszjljzfzj(String zxzqmjdzxjszjljzfzj) {
		this.zxzqmjdzxjszjljzfzj = zxzqmjdzxjszjljzfzj;
	}

	public String getZysljsjjljzfzj() {
		return zysljsjjljzfzj;
	}

	public void setZysljsjjljzfzj(String zysljsjjljzfzj) {
		this.zysljsjjljzfzj = zysljsjjljzfzj;
	}

	public String getNsbdgcjjljzfzj() {
		return nsbdgcjjljzfzj;
	}

	public void setNsbdgcjjljzfzj(String nsbdgcjjljzfzj) {
		this.nsbdgcjjljzfzj = nsbdgcjjljzfzj;
	}

	public String getTljszxjjljzfzj() {
		return tljszxjjljzfzj;
	}

	public void setTljszxjjljzfzj(String tljszxjjljzfzj) {
		this.tljszxjjljzfzj = tljszxjjljzfzj;
	}

	public String getMhfzjjljzfzj() {
		return mhfzjjljzfzj;
	}

	public void setMhfzjjljzfzj(String mhfzjjljzfzj) {
		this.mhfzjjljzfzj = mhfzjjljzfzj;
	}

	public String getGjzdslgcjsjjljzfzj() {
		return gjzdslgcjsjjljzfzj;
	}

	public void setGjzdslgcjsjjljzfzj(String gjzdslgcjsjjljzfzj) {
		this.gjzdslgcjsjjljzfzj = gjzdslgcjsjjljzfzj;
	}

	public String getDzxskymhqfcjjljzfzj() {
		return dzxskymhqfcjjljzfzj;
	}

	public void setDzxskymhqfcjjljzfzj(String dzxskymhqfcjjljzfzj) {
		this.dzxskymhqfcjjljzfzj = dzxskymhqfcjjljzfzj;
	}

	public String getDzxskymhqfcjyjjljzfzj() {
		return dzxskymhqfcjyjjljzfzj;
	}

	public void setDzxskymhqfcjyjjljzfzj(String dzxskymhqfcjyjjljzfzj) {
		this.dzxskymhqfcjyjjljzfzj = dzxskymhqfcjyjjljzfzj;
	}

	public String getGlgkjszxjjljzfzj() {
		return glgkjszxjjljzfzj;
	}

	public void setGlgkjszxjjljzfzj(String glgkjszxjjljzfzj) {
		this.glgkjszxjjljzfzj = glgkjszxjjljzfzj;
	}

	public String getShengjiysntzljzfzj() {
		return shengjiysntzljzfzj;
	}

	public void setShengjiysntzljzfzj(String shengjiysntzljzfzj) {
		this.shengjiysntzljzfzj = shengjiysntzljzfzj;
	}

	public String getShijiysntzljzfzj() {
		return shijiysntzljzfzj;
	}

	public void setShijiysntzljzfzj(String shijiysntzljzfzj) {
		this.shijiysntzljzfzj = shijiysntzljzfzj;
	}

	public String getXianjiysntzljzfzj() {
		return xianjiysntzljzfzj;
	}

	public void setXianjiysntzljzfzj(String xianjiysntzljzfzj) {
		this.xianjiysntzljzfzj = xianjiysntzljzfzj;
	}

	public String getShengjiczzjljzfzj() {
		return shengjiczzjljzfzj;
	}

	public void setShengjiczzjljzfzj(String shengjiczzjljzfzj) {
		this.shengjiczzjljzfzj = shengjiczzjljzfzj;
	}

	public String getShijiczzjljzfzj() {
		return shijiczzjljzfzj;
	}

	public void setShijiczzjljzfzj(String shijiczzjljzfzj) {
		this.shijiczzjljzfzj = shijiczzjljzfzj;
	}

	public String getXianjiczzjljzfzj() {
		return xianjiczzjljzfzj;
	}

	public void setXianjiczzjljzfzj(String xianjiczzjljzfzj) {
		this.xianjiczzjljzfzj = xianjiczzjljzfzj;
	}

	public String getDfzxjsjjljzfzj() {
		return dfzxjsjjljzfzj;
	}

	public void setDfzxjsjjljzfzj(String dfzxjsjjljzfzj) {
		this.dfzxjsjjljzfzj = dfzxjsjjljzfzj;
	}

	public String getQyzytzljzfzj() {
		return qyzytzljzfzj;
	}

	public void setQyzytzljzfzj(String qyzytzljzfzj) {
		this.qyzytzljzfzj = qyzytzljzfzj;
	}

	public String getYhdkljzfzj() {
		return yhdkljzfzj;
	}

	public void setYhdkljzfzj(String yhdkljzfzj) {
		this.yhdkljzfzj = yhdkljzfzj;
	}

	public String getLywzljzfzj() {
		return lywzljzfzj;
	}

	public void setLywzljzfzj(String lywzljzfzj) {
		this.lywzljzfzj = lywzljzfzj;
	}

	public String getZjqdddljzfzj() {
		return zjqdddljzfzj;
	}

	public void setZjqdddljzfzj(String zjqdddljzfzj) {
		this.zjqdddljzfzj = zjqdddljzfzj;
	}

	public String getQtzjljzfzj() {
		return qtzjljzfzj;
	}

	public void setQtzjljzfzj(String qtzjljzfzj) {
		this.qtzjljzfzj = qtzjljzfzj;
	}

	public String getZyysntzljdwzjtwo() {
		return zyysntzljdwzjtwo;
	}

	public void setZyysntzljdwzjtwo(String zyysntzljdwzjtwo) {
		this.zyysntzljdwzjtwo = zyysntzljdwzjtwo;
	}

	public String getQtzyczxjszjljdwzjtwo() {
		return qtzyczxjszjljdwzjtwo;
	}

	public void setQtzyczxjszjljdwzjtwo(String qtzyczxjszjljdwzjtwo) {
		this.qtzyczxjszjljdwzjtwo = qtzyczxjszjljdwzjtwo;
	}

	public String getZxzqmjdzxjszjljdwzjtwo() {
		return zxzqmjdzxjszjljdwzjtwo;
	}

	public void setZxzqmjdzxjszjljdwzjtwo(String zxzqmjdzxjszjljdwzjtwo) {
		this.zxzqmjdzxjszjljdwzjtwo = zxzqmjdzxjszjljdwzjtwo;
	}

	public String getZysljsjjljdwzjtwo() {
		return zysljsjjljdwzjtwo;
	}

	public void setZysljsjjljdwzjtwo(String zysljsjjljdwzjtwo) {
		this.zysljsjjljdwzjtwo = zysljsjjljdwzjtwo;
	}

	public String getNsbdgcjjljdwzjtwo() {
		return nsbdgcjjljdwzjtwo;
	}

	public void setNsbdgcjjljdwzjtwo(String nsbdgcjjljdwzjtwo) {
		this.nsbdgcjjljdwzjtwo = nsbdgcjjljdwzjtwo;
	}

	public String getTljszxjjljdwzjtwo() {
		return tljszxjjljdwzjtwo;
	}

	public void setTljszxjjljdwzjtwo(String tljszxjjljdwzjtwo) {
		this.tljszxjjljdwzjtwo = tljszxjjljdwzjtwo;
	}

	public String getMhfzjjljdwzjtwo() {
		return mhfzjjljdwzjtwo;
	}

	public void setMhfzjjljdwzjtwo(String mhfzjjljdwzjtwo) {
		this.mhfzjjljdwzjtwo = mhfzjjljdwzjtwo;
	}

	public String getGjzdslgcjsjjljdwzjtwo() {
		return gjzdslgcjsjjljdwzjtwo;
	}

	public void setGjzdslgcjsjjljdwzjtwo(String gjzdslgcjsjjljdwzjtwo) {
		this.gjzdslgcjsjjljdwzjtwo = gjzdslgcjsjjljdwzjtwo;
	}

	public String getDzxskymhqfcjjljdwzjtwo() {
		return dzxskymhqfcjjljdwzjtwo;
	}

	public void setDzxskymhqfcjjljdwzjtwo(String dzxskymhqfcjjljdwzjtwo) {
		this.dzxskymhqfcjjljdwzjtwo = dzxskymhqfcjjljdwzjtwo;
	}

	public String getDzxskymhqfcjyjjljdwzjtwo() {
		return dzxskymhqfcjyjjljdwzjtwo;
	}

	public void setDzxskymhqfcjyjjljdwzjtwo(String dzxskymhqfcjyjjljdwzjtwo) {
		this.dzxskymhqfcjyjjljdwzjtwo = dzxskymhqfcjyjjljdwzjtwo;
	}

	public String getGlgkjszxjjljdwzjtwo() {
		return glgkjszxjjljdwzjtwo;
	}

	public void setGlgkjszxjjljdwzjtwo(String glgkjszxjjljdwzjtwo) {
		this.glgkjszxjjljdwzjtwo = glgkjszxjjljdwzjtwo;
	}

	public String getShengjiysntzljdwzjtwo() {
		return shengjiysntzljdwzjtwo;
	}

	public void setShengjiysntzljdwzjtwo(String shengjiysntzljdwzjtwo) {
		this.shengjiysntzljdwzjtwo = shengjiysntzljdwzjtwo;
	}

	public String getShijiysntzljdwzjtwo() {
		return shijiysntzljdwzjtwo;
	}

	public void setShijiysntzljdwzjtwo(String shijiysntzljdwzjtwo) {
		this.shijiysntzljdwzjtwo = shijiysntzljdwzjtwo;
	}

	public String getXianjiysntzljdwzjtwo() {
		return xianjiysntzljdwzjtwo;
	}

	public void setXianjiysntzljdwzjtwo(String xianjiysntzljdwzjtwo) {
		this.xianjiysntzljdwzjtwo = xianjiysntzljdwzjtwo;
	}

	public String getShengjiczzjljdwzjtwo() {
		return shengjiczzjljdwzjtwo;
	}

	public void setShengjiczzjljdwzjtwo(String shengjiczzjljdwzjtwo) {
		this.shengjiczzjljdwzjtwo = shengjiczzjljdwzjtwo;
	}

	public String getShijiczzjljdwzjtwo() {
		return shijiczzjljdwzjtwo;
	}

	public void setShijiczzjljdwzjtwo(String shijiczzjljdwzjtwo) {
		this.shijiczzjljdwzjtwo = shijiczzjljdwzjtwo;
	}

	public String getXianjiczzjljdwzjtwo() {
		return xianjiczzjljdwzjtwo;
	}

	public void setXianjiczzjljdwzjtwo(String xianjiczzjljdwzjtwo) {
		this.xianjiczzjljdwzjtwo = xianjiczzjljdwzjtwo;
	}

	public String getDfzxjsjjljdwzjtwo() {
		return dfzxjsjjljdwzjtwo;
	}

	public void setDfzxjsjjljdwzjtwo(String dfzxjsjjljdwzjtwo) {
		this.dfzxjsjjljdwzjtwo = dfzxjsjjljdwzjtwo;
	}

	public String getQyzytzljdwzjtwo() {
		return qyzytzljdwzjtwo;
	}

	public void setQyzytzljdwzjtwo(String qyzytzljdwzjtwo) {
		this.qyzytzljdwzjtwo = qyzytzljdwzjtwo;
	}

	public String getYhdkljdwzjtwo() {
		return yhdkljdwzjtwo;
	}

	public void setYhdkljdwzjtwo(String yhdkljdwzjtwo) {
		this.yhdkljdwzjtwo = yhdkljdwzjtwo;
	}

	public String getLywzljdwzjtwo() {
		return lywzljdwzjtwo;
	}

	public void setLywzljdwzjtwo(String lywzljdwzjtwo) {
		this.lywzljdwzjtwo = lywzljdwzjtwo;
	}

	public String getZjqdddljdwzjtwo() {
		return zjqdddljdwzjtwo;
	}

	public void setZjqdddljdwzjtwo(String zjqdddljdwzjtwo) {
		this.zjqdddljdwzjtwo = zjqdddljdwzjtwo;
	}

	public String getQtzjljdwzjtwo() {
		return qtzjljdwzjtwo;
	}

	public void setQtzjljdwzjtwo(String qtzjljdwzjtwo) {
		this.qtzjljdwzjtwo = qtzjljdwzjtwo;
	}



	public static final String TYPE_XMTB = "1";
	public static final String TYPE_DDFK = "2";
}