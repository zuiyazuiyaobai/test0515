/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.zdxmcs.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 重点工程基本信息表Entity
 * @author tys
 * @version 2017-05-11
 */
public class CInsBusinessInfo extends DataEntity<CInsBusinessInfo> {
	
	private static final long serialVersionUID = 1L;
	private String cbsnum;		// 并联业务流水号
	private String areaid;		// 区划ID
	private String incid;		// 项目申报组织机构代码或身份证号
	private String incname;		// 项目申报单位全称
	private String ageadds;		// 经办人联系地址
	private String inctype;		// 项目申请单位性质：1、政府机关；2、事业单位；3、社会团体；4、国有及国有控股企业；5、股份制企业；6、集体企业；7、私营企业；8、港澳台及外资企业；9、个体工商户；10、自然人；11、其他 （选择其他需要填写其他类型）
	private String inctypedesc;		// 项目申请单位性质其他性质（性质选择“其他”时候填写）
	private String increlation;		// 项目申请单位隶属关系：1、县（市、区）属企业；2、省属企业；3、市（州）属企业；4、中央在鄂企业
	private String psortparent;		// 项目所属行业父类别
	private String psort;		// 项目所属行业子类别
	private String psortparentname;		// 项目所属行业父类别名称
	private String psortname;		// 项目所属行业子类别名称
	private String areaname;		// 区划名称
	private String projectnature;		// 项目性质：1、新建；2、扩建；3、改建；4、迁建；5、其他
	private String agename;		// 经办人姓名
	private String agephone;		// 经办人固定电话（含区号）
	private String agemobile;		// 经办人手机号码
	private String ageemail;		// 经办人电子邮箱
	private String agepostcode;		// 经办人邮编
	private String grossinvestment;		// 申请项目估算总投资（单位，万元）
	private String projectname;		// 项目申报名称
	private String idtype;		// 注册使用证件类型 6.项目申报单位组织机构代码    1.身份证号
	private String projectid;		// 项目ID
	private Long userUid;		// 注册用户ID
	private String constructionscale;		// 建设规模及内容
	private String psortone;		// 项目所属行业第三级类别
	private String psortonename;		// 项目所属行业第三级类别名称
	private String psorttwo;		// 项目所属行业第四级类别
	private String psorttwoname;		// 项目所属行业第四级类别名称
	private String areaidtwo;		// 所属县区区划ID
	private String areaidtwoname;		// 所属县区区划名称
	private Date createtime;		// 申请时间
	private String zyzj;		// 自有资金（单位，万元）
	private String sqzftz;		// 申请政府投资（单位，万元）
	private String yhdk;		// 银行贷款（单位，万元）
	private String qt;		// 其他（单位，万元）=总投资-自有资金-申请政府投资-银行贷款
	private String pagename;		// 法人代表姓名
	private String pagephone;		// 法人固定电话(含区号)
	private String sxid;		// 终审部门事项ID
	private String flowid;		// 终审部门流程ID
	private String status;		// 当前基本信息状态，1为已办结的阶段信息，0为当前办理阶段信息
	private String ageidcardno;		// 经办人身份证号
	private Date starttime;		// 计划开工年限
	private Date endtime;		// 计划完工年限
	private String cjtype;		// 申报项目属于级别（0省1市2直辖市3县 ）
	private String type;		// 1sb 2bj 3sg
	private String ybsxzhid;		// 已办理事项组合ID
	private String sxzhid;		// 事项组合id
	private String zyxmid;		// 中央项目ID 
	private String zyexchange;		// 中央交换状态（0未交换，1交换）
	private String areaidstreet;		// 所属街道区划ID
	private String areaidstreetname;		// 所属街道区划名称
	private String shxydm;		// 社会信用代码,长度是18位,9-17位是组织机构代码
	private String ksqzt;		// 0跨县市区1跨市2不跨
	private String shihecode;		// 跨市的code前
	private String shihename;		// 跨市的名称前
	private String shiheshicode;		// 跨市和市的code后
	private String shiheshiname;		// 跨市和市的名称后
	private String xsqcode;		// 县市区code前
	private String xsqname;		// 县市区名称前
	private String xishiqucode;		// 县市区code后
	private String xishiquname;		// 县市区名称后
	private String sxxz;		// 审批S核准H备案B
	private String theIndustry;		// 和中央2.0版本的对接
	private String zyExchangeV2;		// 和中央2.0版本的对接
	private String blicense;		// 营业执照
	private String xmsfcz;		// 判断项目是否流转
	private String xxsfxg;		// 项目信息是否修改过
	private String incidtype;		// 证照类型
	
	public CInsBusinessInfo() {
		super();
	}

	public CInsBusinessInfo(String id){
		super(id);
	}

	@ExcelField(title="并联业务流水号", align=2, sort=0)
	public String getCbsnum() {
		return cbsnum;
	}

	public void setCbsnum(String cbsnum) {
		this.cbsnum = cbsnum;
	}
	
	@ExcelField(title="区划ID", align=2, sort=1)
	public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	
	@ExcelField(title="项目申报组织机构代码或身份证号", align=2, sort=2)
	public String getIncid() {
		return incid;
	}

	public void setIncid(String incid) {
		this.incid = incid;
	}
	
	@ExcelField(title="项目申报单位全称", align=2, sort=3)
	public String getIncname() {
		return incname;
	}

	public void setIncname(String incname) {
		this.incname = incname;
	}
	
	@ExcelField(title="经办人联系地址", align=2, sort=4)
	public String getAgeadds() {
		return ageadds;
	}

	public void setAgeadds(String ageadds) {
		this.ageadds = ageadds;
	}
	
	@ExcelField(title="项目申请单位性质：1、政府机关；2、事业单位；3、社会团体；4、国有及国有控股企业；5、股份制企业；6、集体企业；7、私营企业；8、港澳台及外资企业；9、个体工商户；10、自然人；11、其他 （选择其他需要填写其他类型）", align=2, sort=5)
	public String getInctype() {
		return inctype;
	}

	public void setInctype(String inctype) {
		this.inctype = inctype;
	}
	
	@ExcelField(title="项目申请单位性质其他性质（性质选择“其他”时候填写）", align=2, sort=6)
	public String getInctypedesc() {
		return inctypedesc;
	}

	public void setInctypedesc(String inctypedesc) {
		this.inctypedesc = inctypedesc;
	}
	
	@ExcelField(title="项目申请单位隶属关系：1、县（市、区）属企业；2、省属企业；3、市（州）属企业；4、中央在鄂企业", align=2, sort=7)
	public String getIncrelation() {
		return increlation;
	}

	public void setIncrelation(String increlation) {
		this.increlation = increlation;
	}
	
	@ExcelField(title="项目所属行业父类别", align=2, sort=8)
	public String getPsortparent() {
		return psortparent;
	}

	public void setPsortparent(String psortparent) {
		this.psortparent = psortparent;
	}
	
	@ExcelField(title="项目所属行业子类别", align=2, sort=9)
	public String getPsort() {
		return psort;
	}

	public void setPsort(String psort) {
		this.psort = psort;
	}
	
	@ExcelField(title="项目所属行业父类别名称", align=2, sort=10)
	public String getPsortparentname() {
		return psortparentname;
	}

	public void setPsortparentname(String psortparentname) {
		this.psortparentname = psortparentname;
	}
	
	@ExcelField(title="项目所属行业子类别名称", align=2, sort=11)
	public String getPsortname() {
		return psortname;
	}

	public void setPsortname(String psortname) {
		this.psortname = psortname;
	}
	
	@ExcelField(title="区划名称", align=2, sort=12)
	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	
	@ExcelField(title="项目性质：1、新建；2、扩建；3、改建；4、迁建；5、其他", align=2, sort=13)
	public String getProjectnature() {
		return projectnature;
	}

	public void setProjectnature(String projectnature) {
		this.projectnature = projectnature;
	}
	
	@ExcelField(title="经办人姓名", align=2, sort=14)
	public String getAgename() {
		return agename;
	}

	public void setAgename(String agename) {
		this.agename = agename;
	}
	
	@ExcelField(title="经办人固定电话（含区号）", align=2, sort=15)
	public String getAgephone() {
		return agephone;
	}

	public void setAgephone(String agephone) {
		this.agephone = agephone;
	}
	
	@ExcelField(title="经办人手机号码", align=2, sort=16)
	public String getAgemobile() {
		return agemobile;
	}

	public void setAgemobile(String agemobile) {
		this.agemobile = agemobile;
	}
	
	@ExcelField(title="经办人电子邮箱", align=2, sort=17)
	public String getAgeemail() {
		return ageemail;
	}

	public void setAgeemail(String ageemail) {
		this.ageemail = ageemail;
	}
	
	@ExcelField(title="经办人邮编", align=2, sort=18)
	public String getAgepostcode() {
		return agepostcode;
	}

	public void setAgepostcode(String agepostcode) {
		this.agepostcode = agepostcode;
	}
	
	@ExcelField(title="申请项目估算总投资（单位，万元）", align=2, sort=19)
	public String getGrossinvestment() {
		return grossinvestment;
	}

	public void setGrossinvestment(String grossinvestment) {
		this.grossinvestment = grossinvestment;
	}
	
	@ExcelField(title="项目申报名称", align=2, sort=20)
	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	
	@ExcelField(title="注册使用证件类型 6.项目申报单位组织机构代码    1.身份证号", align=2, sort=21)
	public String getIdtype() {
		return idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}
	
	@ExcelField(title="项目ID", align=2, sort=22)
	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	
	@ExcelField(title="注册用户ID", align=2, sort=23)
	public Long getUserUid() {
		return userUid;
	}

	public void setUserUid(Long userUid) {
		this.userUid = userUid;
	}
	
	@ExcelField(title="建设规模及内容", align=2, sort=24)
	public String getConstructionscale() {
		return constructionscale;
	}

	public void setConstructionscale(String constructionscale) {
		this.constructionscale = constructionscale;
	}
	
	@ExcelField(title="项目所属行业第三级类别", align=2, sort=25)
	public String getPsortone() {
		return psortone;
	}

	public void setPsortone(String psortone) {
		this.psortone = psortone;
	}
	
	@ExcelField(title="项目所属行业第三级类别名称", align=2, sort=26)
	public String getPsortonename() {
		return psortonename;
	}

	public void setPsortonename(String psortonename) {
		this.psortonename = psortonename;
	}
	
	@ExcelField(title="项目所属行业第四级类别", align=2, sort=27)
	public String getPsorttwo() {
		return psorttwo;
	}

	public void setPsorttwo(String psorttwo) {
		this.psorttwo = psorttwo;
	}
	
	@ExcelField(title="项目所属行业第四级类别名称", align=2, sort=28)
	public String getPsorttwoname() {
		return psorttwoname;
	}

	public void setPsorttwoname(String psorttwoname) {
		this.psorttwoname = psorttwoname;
	}
	
	@ExcelField(title="所属县区区划ID", align=2, sort=29)
	public String getAreaidtwo() {
		return areaidtwo;
	}

	public void setAreaidtwo(String areaidtwo) {
		this.areaidtwo = areaidtwo;
	}
	
	@ExcelField(title="所属县区区划名称", align=2, sort=30)
	public String getAreaidtwoname() {
		return areaidtwoname;
	}

	public void setAreaidtwoname(String areaidtwoname) {
		this.areaidtwoname = areaidtwoname;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="申请时间", align=2, sort=31)
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@ExcelField(title="自有资金（单位，万元）", align=2, sort=32)
	public String getZyzj() {
		return zyzj;
	}

	public void setZyzj(String zyzj) {
		this.zyzj = zyzj;
	}
	
	@ExcelField(title="申请政府投资（单位，万元）", align=2, sort=33)
	public String getSqzftz() {
		return sqzftz;
	}

	public void setSqzftz(String sqzftz) {
		this.sqzftz = sqzftz;
	}
	
	@ExcelField(title="银行贷款（单位，万元）", align=2, sort=34)
	public String getYhdk() {
		return yhdk;
	}

	public void setYhdk(String yhdk) {
		this.yhdk = yhdk;
	}
	
	@ExcelField(title="其他（单位，万元）=总投资-自有资金-申请政府投资-银行贷款", align=2, sort=35)
	public String getQt() {
		return qt;
	}

	public void setQt(String qt) {
		this.qt = qt;
	}
	
	@ExcelField(title="法人代表姓名", align=2, sort=36)
	public String getPagename() {
		return pagename;
	}

	public void setPagename(String pagename) {
		this.pagename = pagename;
	}
	
	@ExcelField(title="法人固定电话(含区号)", align=2, sort=37)
	public String getPagephone() {
		return pagephone;
	}

	public void setPagephone(String pagephone) {
		this.pagephone = pagephone;
	}
	
	@ExcelField(title="终审部门事项ID", align=2, sort=38)
	public String getSxid() {
		return sxid;
	}

	public void setSxid(String sxid) {
		this.sxid = sxid;
	}
	
	@ExcelField(title="终审部门流程ID", align=2, sort=39)
	public String getFlowid() {
		return flowid;
	}

	public void setFlowid(String flowid) {
		this.flowid = flowid;
	}
	
	@ExcelField(title="当前基本信息状态，1为已办结的阶段信息，0为当前办理阶段信息", align=2, sort=40)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@ExcelField(title="经办人身份证号", align=2, sort=41)
	public String getAgeidcardno() {
		return ageidcardno;
	}

	public void setAgeidcardno(String ageidcardno) {
		this.ageidcardno = ageidcardno;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="计划开工年限", align=2, sort=42)
	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="计划完工年限", align=2, sort=43)
	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	
	@ExcelField(title="申报项目属于级别（0省1市2直辖市3县 ）", align=2, sort=44)
	public String getCjtype() {
		return cjtype;
	}

	public void setCjtype(String cjtype) {
		this.cjtype = cjtype;
	}
	
	@ExcelField(title="1sb 2bj 3sg", align=2, sort=45)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@ExcelField(title="已办理事项组合ID", align=2, sort=46)
	public String getYbsxzhid() {
		return ybsxzhid;
	}

	public void setYbsxzhid(String ybsxzhid) {
		this.ybsxzhid = ybsxzhid;
	}
	
	@ExcelField(title="事项组合id", align=2, sort=47)
	public String getSxzhid() {
		return sxzhid;
	}

	public void setSxzhid(String sxzhid) {
		this.sxzhid = sxzhid;
	}
	
	@ExcelField(title="中央项目ID ", align=2, sort=48)
	public String getZyxmid() {
		return zyxmid;
	}

	public void setZyxmid(String zyxmid) {
		this.zyxmid = zyxmid;
	}
	
	@ExcelField(title="中央交换状态（0未交换，1交换）", align=2, sort=49)
	public String getZyexchange() {
		return zyexchange;
	}

	public void setZyexchange(String zyexchange) {
		this.zyexchange = zyexchange;
	}
	
	@ExcelField(title="所属街道区划ID", align=2, sort=50)
	public String getAreaidstreet() {
		return areaidstreet;
	}

	public void setAreaidstreet(String areaidstreet) {
		this.areaidstreet = areaidstreet;
	}
	
	@ExcelField(title="所属街道区划名称", align=2, sort=51)
	public String getAreaidstreetname() {
		return areaidstreetname;
	}

	public void setAreaidstreetname(String areaidstreetname) {
		this.areaidstreetname = areaidstreetname;
	}
	
	@ExcelField(title="社会信用代码,长度是18位,9-17位是组织机构代码", align=2, sort=52)
	public String getShxydm() {
		return shxydm;
	}

	public void setShxydm(String shxydm) {
		this.shxydm = shxydm;
	}
	
	@ExcelField(title="0跨县市区1跨市2不跨", align=2, sort=53)
	public String getKsqzt() {
		return ksqzt;
	}

	public void setKsqzt(String ksqzt) {
		this.ksqzt = ksqzt;
	}
	
	@ExcelField(title="跨市的code前", align=2, sort=54)
	public String getShihecode() {
		return shihecode;
	}

	public void setShihecode(String shihecode) {
		this.shihecode = shihecode;
	}
	
	@ExcelField(title="跨市的名称前", align=2, sort=55)
	public String getShihename() {
		return shihename;
	}

	public void setShihename(String shihename) {
		this.shihename = shihename;
	}
	
	@ExcelField(title="跨市和市的code后", align=2, sort=56)
	public String getShiheshicode() {
		return shiheshicode;
	}

	public void setShiheshicode(String shiheshicode) {
		this.shiheshicode = shiheshicode;
	}
	
	@ExcelField(title="跨市和市的名称后", align=2, sort=57)
	public String getShiheshiname() {
		return shiheshiname;
	}

	public void setShiheshiname(String shiheshiname) {
		this.shiheshiname = shiheshiname;
	}
	
	@ExcelField(title="县市区code前", align=2, sort=58)
	public String getXsqcode() {
		return xsqcode;
	}

	public void setXsqcode(String xsqcode) {
		this.xsqcode = xsqcode;
	}
	
	@ExcelField(title="县市区名称前", align=2, sort=59)
	public String getXsqname() {
		return xsqname;
	}

	public void setXsqname(String xsqname) {
		this.xsqname = xsqname;
	}
	
	@ExcelField(title="县市区code后", align=2, sort=60)
	public String getXishiqucode() {
		return xishiqucode;
	}

	public void setXishiqucode(String xishiqucode) {
		this.xishiqucode = xishiqucode;
	}
	
	@ExcelField(title="县市区名称后", align=2, sort=61)
	public String getXishiquname() {
		return xishiquname;
	}

	public void setXishiquname(String xishiquname) {
		this.xishiquname = xishiquname;
	}
	
	@ExcelField(title="审批S核准H备案B", align=2, sort=62)
	public String getSxxz() {
		return sxxz;
	}

	public void setSxxz(String sxxz) {
		this.sxxz = sxxz;
	}
	
	@ExcelField(title="和中央2.0版本的对接", align=2, sort=63)
	public String getTheIndustry() {
		return theIndustry;
	}

	public void setTheIndustry(String theIndustry) {
		this.theIndustry = theIndustry;
	}
	
	@ExcelField(title="和中央2.0版本的对接", align=2, sort=64)
	public String getZyExchangeV2() {
		return zyExchangeV2;
	}

	public void setZyExchangeV2(String zyExchangeV2) {
		this.zyExchangeV2 = zyExchangeV2;
	}
	
	@ExcelField(title="营业执照", align=2, sort=65)
	public String getBlicense() {
		return blicense;
	}

	public void setBlicense(String blicense) {
		this.blicense = blicense;
	}
	
	@ExcelField(title="判断项目是否流转", align=2, sort=66)
	public String getXmsfcz() {
		return xmsfcz;
	}

	public void setXmsfcz(String xmsfcz) {
		this.xmsfcz = xmsfcz;
	}
	
	@ExcelField(title="项目信息是否修改过", align=2, sort=67)
	public String getXxsfxg() {
		return xxsfxg;
	}

	public void setXxsfxg(String xxsfxg) {
		this.xxsfxg = xxsfxg;
	}
	
	@ExcelField(title="证照类型", align=2, sort=68)
	public String getIncidtype() {
		return incidtype;
	}

	public void setIncidtype(String incidtype) {
		this.incidtype = incidtype;
	}
	
}