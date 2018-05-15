/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 其他（省基建5818重点项目）Entity
 * @author @zhu
 * @version 2017-12-02
 */
public class CInsBusinessZdxmk extends DataEntity<CInsBusinessZdxmk> {
	
	private static final long serialVersionUID = 1L;
	
	private Xmjbxx xmjbxx;		// 项目基本信息ID
	
	public static final String TYPE_XMTB = "1";
	public static final String TYPE_DDFK = "2";
	
	private String xmtjdw;		// 项目推荐单位
	private String sszt;		// 所属专题 0 无，1战略引领，2中原城市群，3转型发展，4基础能力，5环境治理，6脱贫攻坚，7民生保障，8百城提质
	private String jdlb;		// 进度类别 0竣工项目，1续建项目，2新开工项目，3前期项目
	private String sfzsdcyjjq;		// 是否在省定产业集聚区或专业园区内，0否，1是
	private String sdcyjjqmc;		// 所在省定产业集聚区或专业园区名称
	private String sfgjzdzl;		// 是否是国家重大战略项目0否，1是
	private String gjzdzlqmc;		// 所在国家重大战略区名称
	private String tzwce;		// 开工至2017年9月底累计投资完成额（万元）
	private String zyyy;		// 项目建设重要意义及效益
	private String ndljwc;		// 预计2017年底累计完成（万元）
	private String gcxxjd;		// 截至2017年9月底工程形象进度或前期工作进度
	private String gyxmxzxk;		// 规划手续办理情况已完成建设项目选址许可
	private String gyydghxk;		// 规划手续办理情况已完成建设用地规划许可
	private String gygcghxk;		// 规划手续办理情况已完成建设工程规划许可
	private String gwxmxzxk;		// 规划手续办理情况未完成建设项目选址许可
	private String gwydghxk;		// 规划手续办理情况未完成建设用地规划许可
	private String gwgcghxk;		// 规划手续办理情况未完成建设工程规划许可
	private String hytxpzh;		// 环评手续办理情况已完成的填写批准文号
	private String hwblbpjd;		// 环评手续办理情况未完成办理的报批进展情况
	private String hwzzpfjg;		// 环评手续办理情况未完成最终批复机关0环保部，1环保厅，2市环保局，3县环保局
	private String sytxpzwh;		// 审批（核准、备案）手续办理情况已完成的填写批准文号
	private String swpzjzqk;		// 审批（核准、备案）手续办理情况未完成办理的报批进展情况
	private String swzzpfjg;		// 审批（核准、备案）手续办理情况未完成最终批复机关0环保部，1环保厅，2市环保局，3县环保局
	private String gxyd;		// 共需用地（亩）
	private String yzdtdz;		// 已取得土地证土地（亩）
	private String tdzh;		// 土地证号
	private String dnjhzd;		// 其中当年计划征地(亩)
	private String sfjbnt;		// 是否占用基本农田0否，1是
	private String dnzdbpqk;		// 当年计划征地报批情况0尚未启动，1县（市，区）组卷，2已报市国土部门，3已报省国土部门，4已报国土部，5用地指标已批复
	private String pfwh;		// 批复文号
	private String zyxxjda;		// 2018年度主要建设目标第一季度末主要形象进度或前期工作进度目标（累计进度，100字以内）
	private String zyxxjdb;		// 2018年度主要建设目标第二季度末主要形象进度或前期工作进度目标（累计进度，100字以内）
	private String zyxxjdc;		// 2018年度主要建设目标第三季度末主要形象进度或前期工作进度目标（累计进度，100字以内）
	private String zyxxjdd;		// 2018年度主要建设目标年底前主要形象进度或前期工作进度目标（累计进度，100字以内）
	private String tzjdjdmba;		// 投资进度节点目标（累计进度）（万元）第一季度末
	private String tzjdjdmbb;		// 投资进度节点目标（累计进度）（万元）第2季度末
	private String tzjdjdmbc;		// 投资进度节点目标（累计进度）（万元）第3季度末
	private String tzjdjdmbd;		// 投资进度节点目标（累计进度）（万元）第4季度末
	private String jhkgrq;		// 当年开工项目计划开工日期(保存后生成)
	private String jhjgrq;		// 当年竣工项目计划竣工日期(保存后生成)
	private String zbdldw;		// 招标代理单位

	private String kcdw;		// 勘察单位

	private String sjdw;		// 设计单位
	private String jldw;		// 监理单位

	private String zysgdw;		// 主要施工单位(如桩基、土建、装修、消防、绿化等)

	private String zysbmc;		// 主要设备名称及供货厂家

	private String projectid;		// 项目id
	private String xmjbxxId;		// 项目基本信息id
	
	private String sfszdold;  //是否省重点项目
	private String sfsbsbib;		// 是否5818项目
	private String sfsjjxm;		// 是否省基建项目
	private String ndjhtzje;  //2017年年度计划投资金额
	private String ndjhtzjet; //2018年年度计划投资金额
	private String ssly;  //所属领域
	private String updatestatus;
	private String sfsfwyzdxm;      //是否省服务业重大项目0否，1是
    private String fwyssly;   //省服务业所属领域

    private String zdkhylb;   //省重点行业类别
  
	//第三次添加  攻坚产业
	private String sfzdgjcy;
	private String sfszdgjcy;
	private String sfxszdgjcy;
	private String szdgjcylx;
	private String xszdgjcylx;
	//技术改造
	private String sfjsgzcy;
	
	
	//添加以下四个属性是为了保存   这四个字段不在zdxmk中，而是在xmjbxx表中
	private String	sfjkylxm;	//是否健康养老示范项目		
    private String	jkyldwxz;	//健康养老单位性质
    private String	jkylxmfj;	//健康养老项目分级
    private String	jkylxmlx;	//健康养老项目类型
    
    
	
	public String getSfjkylxm() {
		return sfjkylxm;
	}

	public void setSfjkylxm(String sfjkylxm) {
		this.sfjkylxm = sfjkylxm;
	}

	public String getJkyldwxz() {
		return jkyldwxz;
	}

	public void setJkyldwxz(String jkyldwxz) {
		this.jkyldwxz = jkyldwxz;
	}

	public String getJkylxmfj() {
		return jkylxmfj;
	}

	public void setJkylxmfj(String jkylxmfj) {
		this.jkylxmfj = jkylxmfj;
	}

	public String getJkylxmlx() {
		return jkylxmlx;
	}

	public void setJkylxmlx(String jkylxmlx) {
		this.jkylxmlx = jkylxmlx;
	}

	public String getSfjsgzcy() {
		return sfjsgzcy;
	}

	public void setSfjsgzcy(String sfjsgzcy) {
		this.sfjsgzcy = sfjsgzcy;
	}

	public CInsBusinessZdxmk() {
		super();
	}

	public CInsBusinessZdxmk(String id){
		super(id);
	}

	public Xmjbxx getXmjbxx() {
		return xmjbxx;
	}

	public void setXmjbxx(Xmjbxx xmjbxx) {
		this.xmjbxx = xmjbxx;
	}
	
	@ExcelField(title="项目推荐单位", align=2, sort=0)
	public String getXmtjdw() {
		return xmtjdw;
	}

	public void setXmtjdw(String xmtjdw) {
		this.xmtjdw = xmtjdw;
	}
	
	@ExcelField(title="所属专题 0 无，1战略引领，2中原城市群，3转型发展，4基础能力，5环境治理，6脱贫攻坚，7民生保障，8百城提质", align=2, sort=1)
	public String getSszt() {
		return sszt;
	}

	public void setSszt(String sszt) {
		this.sszt = sszt;
	}
	
	@ExcelField(title="进度类别 0竣工项目，1续建项目，2新开工项目，3前期项目", align=2, sort=2)
	public String getJdlb() {
		return jdlb;
	}

	public void setJdlb(String jdlb) {
		this.jdlb = jdlb;
	}
	
	@ExcelField(title="是否在省定产业集聚区或专业园区内，0否，1是", align=2, sort=3)
	public String getSfzsdcyjjq() {
		return sfzsdcyjjq;
	}

	public void setSfzsdcyjjq(String sfzsdcyjjq) {
		this.sfzsdcyjjq = sfzsdcyjjq;
	}
	
	@ExcelField(title="所在省定产业集聚区或专业园区名称", align=2, sort=4)
	public String getSdcyjjqmc() {
		return sdcyjjqmc;
	}

	public void setSdcyjjqmc(String sdcyjjqmc) {
		this.sdcyjjqmc = sdcyjjqmc;
	}
	
	@ExcelField(title="是否是国家重大战略项目0否，1是", align=2, sort=5)
	public String getSfgjzdzl() {
		return sfgjzdzl;
	}

	public void setSfgjzdzl(String sfgjzdzl) {
		this.sfgjzdzl = sfgjzdzl;
	}
	
	@ExcelField(title="所在国家重大战略区名称", align=2, sort=6)
	public String getGjzdzlqmc() {
		return gjzdzlqmc;
	}

	public void setGjzdzlqmc(String gjzdzlqmc) {
		this.gjzdzlqmc = gjzdzlqmc;
	}
	
	@ExcelField(title="开工至2017年9月底累计投资完成额（万元）", align=2, sort=7)
	public String getTzwce() {
		return tzwce;
	}

	public void setTzwce(String tzwce) {
		this.tzwce = tzwce;
	}
	
	@ExcelField(title="项目建设重要意义及效益", align=2, sort=8)
	public String getZyyy() {
		return zyyy;
	}

	public void setZyyy(String zyyy) {
		this.zyyy = zyyy;
	}
	
	@ExcelField(title="预计2017年底累计完成（万元）", align=2, sort=9)
	public String getNdljwc() {
		return ndljwc;
	}

	public void setNdljwc(String ndljwc) {
		this.ndljwc = ndljwc;
	}
	
	@ExcelField(title="截至2017年9月底工程形象进度或前期工作进度", align=2, sort=10)
	public String getGcxxjd() {
		return gcxxjd;
	}

	public void setGcxxjd(String gcxxjd) {
		this.gcxxjd = gcxxjd;
	}
	
	@ExcelField(title="规划手续办理情况已完成建设项目选址许可", align=2, sort=11)
	public String getGyxmxzxk() {
		return gyxmxzxk;
	}

	public void setGyxmxzxk(String gyxmxzxk) {
		this.gyxmxzxk = gyxmxzxk;
	}
	
	@ExcelField(title="规划手续办理情况已完成建设用地规划许可", align=2, sort=12)
	public String getGyydghxk() {
		return gyydghxk;
	}

	public void setGyydghxk(String gyydghxk) {
		this.gyydghxk = gyydghxk;
	}
	
	@ExcelField(title="规划手续办理情况已完成建设工程规划许可", align=2, sort=13)
	public String getGygcghxk() {
		return gygcghxk;
	}

	public void setGygcghxk(String gygcghxk) {
		this.gygcghxk = gygcghxk;
	}
	
	@ExcelField(title="规划手续办理情况未完成建设项目选址许可", align=2, sort=14)
	public String getGwxmxzxk() {
		return gwxmxzxk;
	}

	public void setGwxmxzxk(String gwxmxzxk) {
		this.gwxmxzxk = gwxmxzxk;
	}
	
	@ExcelField(title="规划手续办理情况未完成建设用地规划许可", align=2, sort=15)
	public String getGwydghxk() {
		return gwydghxk;
	}

	public void setGwydghxk(String gwydghxk) {
		this.gwydghxk = gwydghxk;
	}
	
	@ExcelField(title="规划手续办理情况未完成建设工程规划许可", align=2, sort=16)
	public String getGwgcghxk() {
		return gwgcghxk;
	}

	public void setGwgcghxk(String gwgcghxk) {
		this.gwgcghxk = gwgcghxk;
	}
	
	@ExcelField(title="环评手续办理情况已完成的填写批准文号", align=2, sort=17)
	public String getHytxpzh() {
		return hytxpzh;
	}

	public void setHytxpzh(String hytxpzh) {
		this.hytxpzh = hytxpzh;
	}
	
	@ExcelField(title="环评手续办理情况未完成办理的报批进展情况", align=2, sort=18)
	public String getHwblbpjd() {
		return hwblbpjd;
	}

	public void setHwblbpjd(String hwblbpjd) {
		this.hwblbpjd = hwblbpjd;
	}
	
	@ExcelField(title="环评手续办理情况未完成最终批复机关0环保部，1环保厅，2市环保局，3县环保局", align=2, sort=19)
	public String getHwzzpfjg() {
		return hwzzpfjg;
	}

	public void setHwzzpfjg(String hwzzpfjg) {
		this.hwzzpfjg = hwzzpfjg;
	}
	
	@ExcelField(title="审批（核准、备案）手续办理情况已完成的填写批准文号", align=2, sort=20)
	public String getSytxpzwh() {
		return sytxpzwh;
	}

	public void setSytxpzwh(String sytxpzwh) {
		this.sytxpzwh = sytxpzwh;
	}
	
	@ExcelField(title="审批（核准、备案）手续办理情况未完成办理的报批进展情况", align=2, sort=21)
	public String getSwpzjzqk() {
		return swpzjzqk;
	}

	public void setSwpzjzqk(String swpzjzqk) {
		this.swpzjzqk = swpzjzqk;
	}
	
	@ExcelField(title="审批（核准、备案）手续办理情况未完成最终批复机关0县发改委，1市发改委，2省发改委，3国家发改委", align=2, sort=22)
	public String getSwzzpfjg() {
		return swzzpfjg;
	}

	public void setSwzzpfjg(String swzzpfjg) {
		this.swzzpfjg = swzzpfjg;
	}
	
	@ExcelField(title="共需用地（亩）", align=2, sort=23)
	public String getGxyd() {
		return gxyd;
	}

	public void setGxyd(String gxyd) {
		this.gxyd = gxyd;
	}
	
	@ExcelField(title="已取得土地证土地（亩）", align=2, sort=24)
	public String getYzdtdz() {
		return yzdtdz;
	}

	public void setYzdtdz(String yzdtdz) {
		this.yzdtdz = yzdtdz;
	}
	
	@ExcelField(title="土地证号", align=2, sort=25)
	public String getTdzh() {
		return tdzh;
	}

	public void setTdzh(String tdzh) {
		this.tdzh = tdzh;
	}
	
	@ExcelField(title="其中当年计划征地(亩)", align=2, sort=26)
	public String getDnjhzd() {
		return dnjhzd;
	}

	public void setDnjhzd(String dnjhzd) {
		this.dnjhzd = dnjhzd;
	}
	
	@ExcelField(title="是否占用基本农田0否，1是", align=2, sort=27)
	public String getSfjbnt() {
		return sfjbnt;
	}

	public void setSfjbnt(String sfjbnt) {
		this.sfjbnt = sfjbnt;
	}
	
	@ExcelField(title="当年计划征地报批情况0尚未启动，1县（市，区）组卷，2已报市国土部门，3已报省国土部门，4已报国土部，5用地指标已批复", align=2, sort=28)
	public String getDnzdbpqk() {
		return dnzdbpqk;
	}

	public void setDnzdbpqk(String dnzdbpqk) {
		this.dnzdbpqk = dnzdbpqk;
	}
	
	@ExcelField(title="批复文号", align=2, sort=29)
	public String getPfwh() {
		return pfwh;
	}

	public void setPfwh(String pfwh) {
		this.pfwh = pfwh;
	}
	
	@ExcelField(title="2018年度主要建设目标第一季度末主要形象进度或前期工作进度目标（累计进度，100字以内）", align=2, sort=30)
	public String getZyxxjda() {
		return zyxxjda;
	}

	public void setZyxxjda(String zyxxjda) {
		this.zyxxjda = zyxxjda;
	}
	
	@ExcelField(title="2018年度主要建设目标第二季度末主要形象进度或前期工作进度目标（累计进度，100字以内）", align=2, sort=31)
	public String getZyxxjdb() {
		return zyxxjdb;
	}

	public void setZyxxjdb(String zyxxjdb) {
		this.zyxxjdb = zyxxjdb;
	}
	
	@ExcelField(title="2018年度主要建设目标第三季度末主要形象进度或前期工作进度目标（累计进度，100字以内）", align=2, sort=32)
	public String getZyxxjdc() {
		return zyxxjdc;
	}

	public void setZyxxjdc(String zyxxjdc) {
		this.zyxxjdc = zyxxjdc;
	}
	
	@ExcelField(title="2018年度主要建设目标年底前主要形象进度或前期工作进度目标（累计进度，100字以内）", align=2, sort=33)
	public String getZyxxjdd() {
		return zyxxjdd;
	}

	public void setZyxxjdd(String zyxxjdd) {
		this.zyxxjdd = zyxxjdd;
	}
	
	@ExcelField(title="投资进度节点目标（累计进度）（万元）第一季度末", align=2, sort=34)
	public String getTzjdjdmba() {
		return tzjdjdmba;
	}

	public void setTzjdjdmba(String tzjdjdmba) {
		this.tzjdjdmba = tzjdjdmba;
	}
	
	@ExcelField(title="投资进度节点目标（累计进度）（万元）第2季度末", align=2, sort=35)
	public String getTzjdjdmbb() {
		return tzjdjdmbb;
	}

	public void setTzjdjdmbb(String tzjdjdmbb) {
		this.tzjdjdmbb = tzjdjdmbb;
	}
	
	@ExcelField(title="投资进度节点目标（累计进度）（万元）第3季度末", align=2, sort=36)
	public String getTzjdjdmbc() {
		return tzjdjdmbc;
	}

	public void setTzjdjdmbc(String tzjdjdmbc) {
		this.tzjdjdmbc = tzjdjdmbc;
	}
	
	@ExcelField(title="投资进度节点目标（累计进度）（万元）第4季度末", align=2, sort=37)
	public String getTzjdjdmbd() {
		return tzjdjdmbd;
	}

	public void setTzjdjdmbd(String tzjdjdmbd) {
		this.tzjdjdmbd = tzjdjdmbd;
	}
	
	@ExcelField(title="当年开工项目计划开工日期(保存后生成)", align=2, sort=38)
	public String getJhkgrq() {
		return jhkgrq;
	}

	public void setJhkgrq(String jhkgrq) {
		this.jhkgrq = jhkgrq;
	}
	
	@ExcelField(title="当年竣工项目计划竣工日期(保存后生成)", align=2, sort=39)
	public String getJhjgrq() {
		return jhjgrq;
	}

	public void setJhjgrq(String jhjgrq) {
		this.jhjgrq = jhjgrq;
	}
	
	@ExcelField(title="招标代理单位", align=2, sort=40)
	public String getZbdldw() {
		return zbdldw;
	}

	public void setZbdldw(String zbdldw) {
		this.zbdldw = zbdldw;
	}
	
	@ExcelField(title="勘察单位", align=2, sort=41)
	public String getKcdw() {
		return kcdw;
	}

	public void setKcdw(String kcdw) {
		this.kcdw = kcdw;
	}
	
	@ExcelField(title="设计单位", align=2, sort=42)
	public String getSjdw() {
		return sjdw;
	}

	public void setSjdw(String sjdw) {
		this.sjdw = sjdw;
	}
	
	@ExcelField(title="监理单位", align=2, sort=43)
	public String getJldw() {
		return jldw;
	}

	public void setJldw(String jldw) {
		this.jldw = jldw;
	}
	
	@ExcelField(title="主要施工单位(如桩基、土建、装修、消防、绿化等)", align=2, sort=44)
	public String getZysgdw() {
		return zysgdw;
	}

	public void setZysgdw(String zysgdw) {
		this.zysgdw = zysgdw;
	}
	
	@ExcelField(title="主要设备名称及供货厂家", align=2, sort=45)
	public String getZysbmc() {
		return zysbmc;
	}

	public void setZysbmc(String zysbmc) {
		this.zysbmc = zysbmc;
	}
	
	@ExcelField(title="项目id", align=2, sort=47)
	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	
	@ExcelField(title="项目基本信息id", align=2, sort=48)
	public String getXmjbxxId() {
		return xmjbxxId;
	}

	public void setXmjbxxId(String xmjbxxId) {
		this.xmjbxxId = xmjbxxId;
	}

	@ExcelField(title="是否申报5818", align=2, sort=49)
	public String getSfsbsbib() {
		return sfsbsbib;
	}

	public void setSfsbsbib(String sfsbsbib) {
		this.sfsbsbib = sfsbsbib;
	}
	
	@ExcelField(title="是否省基建项目", align=2, sort=50)
	public String getSfsjjxm() {
		return sfsjjxm;
	}

	public void setSfsjjxm(String sfsjjxm) {
		this.sfsjjxm = sfsjjxm;
	}
	
	@ExcelField(title="2017年年度计划投资金额", align=2, sort=51)
	public String getNdjhtzje() {
		return ndjhtzje;
	}

	public void setNdjhtzje(String ndjhtzje) {
		this.ndjhtzje = ndjhtzje;
	}

	@ExcelField(title="2018年年度计划投资金额", align=2, sort=52)
	public String getNdjhtzjet() {
		return ndjhtzjet;
	}

	public void setNdjhtzjet(String ndjhtzjet) {
		this.ndjhtzjet = ndjhtzjet;
	}

	@ExcelField(title="所属领域", align=2, sort=53)
	public String getSsly() {
		return ssly;
	}

	public void setSsly(String ssly) {
		this.ssly = ssly;
	}
	
	@ExcelField(title="是否省重点项目", align=2, sort=54)
	public String getSfszdold() {
		return sfszdold;
	}

	public void setSfszdold(String sfszdold) {
		this.sfszdold = sfszdold;
	}
	
	@ExcelField(title="行业类别", align=2, sort=55)
	public String getZdkhylb() {
		return zdkhylb;
	}

	public void setZdkhylb(String zdkhylb) {
		this.zdkhylb = zdkhylb;
	}
	public String getUpdatestatus() {
		return updatestatus;
	}

	public void setUpdatestatus(String updatestatus) {
		this.updatestatus = updatestatus;
	}

	public String getSfsfwyzdxm() {
		return sfsfwyzdxm;
	}

	public void setSfsfwyzdxm(String sfsfwyzdxm) {
		this.sfsfwyzdxm = sfsfwyzdxm;
	}

	public String getFwyssly() {
		return fwyssly;
	}

	public void setFwyssly(String fwyssly) {
		this.fwyssly = fwyssly;
	}

	public String getSfzdgjcy() {
		return sfzdgjcy;
	}

	public void setSfzdgjcy(String sfzdgjcy) {
		this.sfzdgjcy = sfzdgjcy;
	}

	public String getSfszdgjcy() {
		return sfszdgjcy;
	}

	public void setSfszdgjcy(String sfszdgjcy) {
		this.sfszdgjcy = sfszdgjcy;
	}

	public String getSfxszdgjcy() {
		return sfxszdgjcy;
	}

	public void setSfxszdgjcy(String sfxszdgjcy) {
		this.sfxszdgjcy = sfxszdgjcy;
	}

	public String getSzdgjcylx() {
		return szdgjcylx;
	}

	public void setSzdgjcylx(String szdgjcylx) {
		this.szdgjcylx = szdgjcylx;
	}

	public String getXszdgjcylx() {
		return xszdgjcylx;
	}

	public void setXszdgjcylx(String xszdgjcylx) {
		this.xszdgjcylx = xszdgjcylx;
	}
	
	
}