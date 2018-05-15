/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.entity;

import com.jeeplus.common.config.Global;
import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.sys.entity.Office;
import com.jeeplus.modules.sys.entity.User;
import com.jeeplus.modules.sys.utils.DictUtils;
import com.jeeplus.modules.sys.utils.UserUtils;
import com.jeeplus.modules.xmjbxx.entity.sub.CInsBusinessXmgs;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * 项目基本信息Entity
 *
 * @author yanwen
 * @version 2017-09-12
 */
public class Xmjbxx extends DataEntity<Xmjbxx> {

    private static final long serialVersionUID = 1L;
    private String createByName;    //创建人姓名
    private String zdkbmgj;        // 重大库编码
    private String spjgptdm;        // 审批监管平台代码
    private String xmmc;        // 项目名称
    private String xmlx;        // 项目类型
    private String jsxz;        // 建设性质
    private String gb;        // 国别
    private String xmfrdw;        // 项目法人单位
    private String jsdd;        // 建设地点
    private String jsddxq;        // 建设地点详情
    private String jsxxdz;        // 建设详细地址
    private String gbhy;        // 国标行业
    private String sshy;        // 所属行业
    private String ztz;        // 总投资
    private String starttimen;        // 拟开工年份
    private String starttimey;        // 拟开工月份
    private String endtime;        // 拟建成年份
    private String zyjsgm;        // 主要建设规模
    private String lhjsgm;        // 量化建设规模
    private String ndzhjsnr;        // 年度主要建设内容
    private String bz;        // 备注
    private String fhcyzc;        // 符合产业政策
    private String fhgh;        // 符合规划
    private String fhzdzn;        // 符合重大战略
    private String fhzftzfx;        // 符合政府投资方向
    private String zrname;        // 项目责任人姓名
    private String zrphone;        // 项目责任人手机
    private String zrcall;        // 项目责任人电话
    private String zremail;        // 项目责任人邮箱
    private String zrwxzh;        // 项目责任人微信账号
    private String lxnameone;        // 项目联系人姓名1
    private String lxphoneone;        // 项目联系人手机1
    private String lxcallone;        // 项目联系人电话1
    private String lxemailone;        // 项目联系人邮箱1
    private String lxwxzhone;        // 项目联系人微信账号1
    private String lxnametwo;        // 项目联系人姓名2
    private String lxphonetwo;        // 项目联系人手机2
    private String lxcalltwo;        // 项目联系人电话2
    private String lxemailtwo;        // 项目联系人邮箱2
    private String lxwxzhtwo;        // 项目联系人微信账号2
    private String shfzbsone;        // 审核辅助标识01
    private String shfzbstwo;        // 审核辅助标识02
    private String shfzbsthree;        // 审核辅助标识03
    private String xmpx;        // 项目排序
    private String stage;        // 阶段（1.项目储备 2.计划编制）
    private String cj;        // 层级（1省，2市，3县）
    private String zt;        // 状态（1.报送 2.审核区，3储备库）
    private String rcjgzjzrdw;        // 日常监管直接责任单位
    private String rcjgzrdwjgzrr;        // 日常监管直接责任单位责任人
    private String sfsqzyysnzj;        // 是否申请中央预算内资金
    private String sfppp;        // 是否ppp（ppp 0否 1是）
    private String pppzl;        // ppp种类(ppp 0否 ，1是)
    private String zfcyfs;        // 政府参与方式(ppp)
    private String ncypppczms;        // 拟采用ppp操作模式(ppp)
    private String qtdw;        // 带头单位(一带一路)
    private String yzdw;        // 业主单位(一带一路)
    private String jsdw;        // 建设单位(一带一路)
    private String tjqk;        // 推进情况(一带一路)
    private Office shbm;        // 审核部门(报送)
    private String ks;        // 科室（报送）
    private String szt;        // 锁状态（0枷锁，1解锁）
    private String rcjgzjzrdwlxdh;        // 日常监管直接责任单位联系电话
    private String xmssjgmc;        // 项目实施机构名称（ppp）
    private String ssjgxz;        // 实施机构性质（ppp）
    private String jhssnd;        // 计划实施年度（年份 ppp）
    private String jtxmnr; //实施PPP方式的具体项目内容（ppp）
    private Double xmtze; //项目投资额（万元）（ppp）
    private String ssfabzjg; //实施方案编制机构（ppp）
    private String bzjgdm; //编制机构组织机构代码证/社会信用代码（ppp）
    private String hbfs; //回报方式（ppp）
    private String nhzqx; //拟合作期限（ppp）
    private String scdw; //审查单位（ppp）
    private String scfs; //审查方式（ppp）
    private Date fapzsj; //方案批准时间（ppp）
    private String szfs; //选择方式（ppp）
    private String shzbf; //社会资本方（ppp）
    private String zfczrdb; //政府出资人代表（ppp）
    private Double xmzbj; //项目资本金（万元）（ppp）
    private Double xmzbjShzb; //项目资本金社会资本（ppp）
    private Double xmzbjZfcz; //项目资本金政府出资（ppp）
    private String sfzjxmgs; //是否组建项目公司（ppp）
    private Date xmgszjrq; //项目公司组建日期（ppp）
    private String hzqx; //合作期限（ppp）
    private String shzbyqsy; //社会资本预期收益（ppp）
    private Double shzbzhnhsyl; //社会资本综合年化收益率（%）（ppp）
    private String sfsqzxjsjj;        // 是否申请专项建设基金（投资情况）
    private String dfzbsf;        // 地方指标省份
    private String lx;        // 类型（一带一路）
    private String sfth;        // 是否退回（1.是 2.否）
    private String xmlsgx;		// 项目隶属关系（1.无、2.中央项目、3.地方项目、4.企业项目）
    private String zxlb;        //专项类别
    private String zxzqxxHbfs;      //回报方式
    private String hbl;     //回报率（%）
    private String hbzq;        //回报周期（年）
    private String ldxg;        //拉动效果（元）
    private String jyyh;        //建议银行
    private String wjbt;        //文件标题
    private String bswh;        //报送文号
    private Date jhbzDate;      //项目编制时间
    private String remarks;
    private String updatestatus;
    private String sfsjjFlag;
    private CInsBusinessSsqk ssqk;          // 实施情况
    private List<CInsBusinessXmgs> xmgss;       // 项目公司
    private List<CInsBusinessTzqk> tzqks;       // 投资情况
    private List<CInsBusinessQqgz> qqgzs;       // 前期工作
    private List<CInsBusinessZdxmk> zdxmk;       // 前期工作
    private String JKSPURL;
    private String incidtype;
    private String incid;
    private String remark;
    private String heimd;//黑名单数量
    private String hongmd;//红名单数量
    private String dkxmmc;//打捆项目表中的打捆项目名称，项目基本信息表中没有这个字段
    
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

	public String getJKSPURL() {
		return JKSPURL;
	}

	public void setJKSPURL(String jKSPURL) {
		JKSPURL = jKSPURL;
	}

	public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public Xmjbxx() {
        super();
    }

    public Xmjbxx(String id) {
        super(id);
    }

    @ExcelField(title = "重大库编码", align = 2, sort = 7)
    public String getZdkbmgj() {
        return zdkbmgj;
    }

    public void setZdkbmgj(String zdkbmgj) {
        this.zdkbmgj = zdkbmgj;
    }

    @ExcelField(title = "审批监管平台代码", align = 2, sort = 8)
    public String getSpjgptdm() {
        return spjgptdm;
    }

    public void setSpjgptdm(String spjgptdm) {
        this.spjgptdm = spjgptdm;
    }

    @ExcelField(title = "项目名称", align = 2, sort = 9)
    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    @ExcelField(title = "项目类型", dictType = "xmlx", align = 2, sort = 10)
    public String getXmlx() {
        return xmlx;
    }

    public void setXmlx(String xmlx) {
        this.xmlx = xmlx;
    }

    @ExcelField(title = "建设性质", dictType = "jsxz", align = 2, sort = 11)
    public String getJsxz() {
        return jsxz;
    }

    public void setJsxz(String jsxz) {
        this.jsxz = jsxz;
    }

    @ExcelField(title = "国别", dictType = "gb", align = 2, sort = 12)
    public String getGb() {
        return gb;
    }

    public void setGb(String gb) {
        this.gb = gb;
    }

    @ExcelField(title = "项目法人单位", align = 2, sort = 13)
    public String getXmfrdw() {
        return xmfrdw;
    }

    public void setXmfrdw(String xmfrdw) {
        this.xmfrdw = xmfrdw;
    }

    @ExcelField(title = "建设地点", dictType = "jsdd", align = 2, sort = 14)
    public String getJsdd() {
        return jsdd;
    }

    public void setJsdd(String jsdd) {
        this.jsdd = jsdd;
    }

    @ExcelField(title = "建设地点详情", dictType = "jsddxq", align = 2, sort = 15)
    public String getJsddxq() {
        return jsddxq;
    }

    public void setJsddxq(String jsddxq) {
        this.jsddxq = jsddxq;
    }

    @ExcelField(title = "建设详细地址", align = 2, sort = 16)
    public String getJsxxdz() {
        return jsxxdz;
    }

    public void setJsxxdz(String jsxxdz) {
        this.jsxxdz = jsxxdz;
    }

    @ExcelField(title = "国标行业", dictType = "gbhy", align = 2, sort = 17)
    public String getGbhy() {
        return gbhy;
    }

    public void setGbhy(String gbhy) {
        this.gbhy = gbhy;
    }

    @ExcelField(title = "所属行业", dictType = "sshy", align = 2, sort = 18)
    public String getSshy() {
        return sshy;
    }

    public void setSshy(String sshy) {
        this.sshy = sshy;
    }

    @ExcelField(title = "总投资", align = 2, sort = 19)
    public String getZtz() {
        return ztz;
    }

    public void setZtz(String ztz) {
        this.ztz = ztz;
    }

    @NotNull(message = "拟开工年份不能为空")
    @ExcelField(title = "拟开工年份", dictType = "nkgyf", align = 2, sort = 20)
    public String getStarttimen() {
        return starttimen;
    }

    public void setStarttimen(String starttimen) {
        this.starttimen = starttimen;
    }

    /*	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @NotNull(message="拟开工月份不能为空")*/
    @ExcelField(title = "拟开工月份", align = 2, sort = 21)
    public String getStarttimey() {
        return starttimey;
    }

    public void setStarttimey(String starttimey) {
        this.starttimey = starttimey;
    }

    @NotNull(message = "拟建成年份不能为空")
    @ExcelField(title = "拟建成年份", align = 2, sort = 22)
    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    @ExcelField(title = "主要建设规模", align = 2, sort = 23)
    public String getZyjsgm() {
        return zyjsgm;
    }

    public void setZyjsgm(String zyjsgm) {
        this.zyjsgm = zyjsgm;
    }

    @ExcelField(title = "量化建设规模", align = 2, sort = 24)
    public String getLhjsgm() {
        return lhjsgm;
    }

    public void setLhjsgm(String lhjsgm) {
        this.lhjsgm = lhjsgm;
    }

    public List<Map> getLhjsgmMapList() {
        if (null == this.lhjsgm || "".equals(this.lhjsgm)) {
            return new ArrayList<Map>();
        }

        Map<String,String> typeValue = new HashMap<String, String>();
        String[] strArr = this.lhjsgm.split(",");
        List<Map> result = new ArrayList<Map>();
        for (String str : strArr) {
            String[] value = str.split(":");
            if (value.length > 1) {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("type", value[0]);
                map.put("value", value[1]);
                result.add(map);
            }

        }
        return result;
    }

    @ExcelField(title = "年度主要建设内容", align = 2, sort = 25)
    public String getNdzhjsnr() {
        return ndzhjsnr;
    }

    public void setNdzhjsnr(String ndzhjsnr) {
        this.ndzhjsnr = ndzhjsnr;
    }

    @ExcelField(title = "备注", align = 2, sort = 26)
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @ExcelField(title = "符合产业政策", align = 2, sort = 27)
    public String getFhcyzc() {
        return fhcyzc;
    }

    public void setFhcyzc(String fhcyzc) {
        this.fhcyzc = fhcyzc;
    }

    @ExcelField(title = "符合规划", align = 2, sort = 28)
    public String getFhgh() {
        return fhgh;
    }

    public void setFhgh(String fhgh) {
        this.fhgh = fhgh;
    }

    @ExcelField(title = "符合重大战略", dictType = "fhzdzn", align = 2, sort = 29)
    public String getFhzdzn() {
        return fhzdzn;
    }

    public void setFhzdzn(String fhzdzn) {
        this.fhzdzn = fhzdzn;
    }

    @ExcelField(title = "符合政府投资方向", dictType = "fhzftzfx", align = 2, sort = 30)
    public String getFhzftzfx() {
        return fhzftzfx;
    }

    public void setFhzftzfx(String fhzftzfx) {
        this.fhzftzfx = fhzftzfx;
    }

    @ExcelField(title = "项目责任人姓名", align = 2, sort = 31)
    public String getZrname() {
        return zrname;
    }

    public void setZrname(String zrname) {
        this.zrname = zrname;
    }

    @ExcelField(title = "项目责任人手机", align = 2, sort = 32)
    public String getZrphone() {
        return zrphone;
    }

    public void setZrphone(String zrphone) {
        this.zrphone = zrphone;
    }

    @ExcelField(title = "项目责任人电话", align = 2, sort = 33)
    public String getZrcall() {
        return zrcall;
    }

    public void setZrcall(String zrcall) {
        this.zrcall = zrcall;
    }

    @Email(message = "项目责任人邮箱必须为合法邮箱")
    @ExcelField(title = "项目责任人邮箱", align = 2, sort = 34)
    public String getZremail() {
        return zremail;
    }

    public void setZremail(String zremail) {
        this.zremail = zremail;
    }

    @ExcelField(title = "项目责任人微信账号", align = 2, sort = 35)
    public String getZrwxzh() {
        return zrwxzh;
    }

    public void setZrwxzh(String zrwxzh) {
        this.zrwxzh = zrwxzh;
    }

    @ExcelField(title = "项目联系人姓名1", align = 2, sort = 36)
    public String getLxnameone() {
        return lxnameone;
    }

    public void setLxnameone(String lxnameone) {
        this.lxnameone = lxnameone;
    }

    @ExcelField(title = "项目联系人手机1", align = 2, sort = 37)
    public String getLxphoneone() {
        return lxphoneone;
    }

    public void setLxphoneone(String lxphoneone) {
        this.lxphoneone = lxphoneone;
    }

    @ExcelField(title = "项目联系人电话1", align = 2, sort = 38)
    public String getLxcallone() {
        return lxcallone;
    }

    public void setLxcallone(String lxcallone) {
        this.lxcallone = lxcallone;
    }

    @Email(message = "项目联系人邮箱1必须为合法邮箱")
    @ExcelField(title = "项目联系人邮箱1", align = 2, sort = 39)
    public String getLxemailone() {
        return lxemailone;
    }

    public void setLxemailone(String lxemailone) {
        this.lxemailone = lxemailone;
    }

    @ExcelField(title = "项目联系人微信账号1", align = 2, sort = 40)
    public String getLxwxzhone() {
        return lxwxzhone;
    }

    public void setLxwxzhone(String lxwxzhone) {
        this.lxwxzhone = lxwxzhone;
    }

    @ExcelField(title = "项目联系人姓名2", align = 2, sort = 41)
    public String getLxnametwo() {
        return lxnametwo;
    }

    public void setLxnametwo(String lxnametwo) {
        this.lxnametwo = lxnametwo;
    }

    @ExcelField(title = "项目联系人手机2", align = 2, sort = 42)
    public String getLxphonetwo() {
        return lxphonetwo;
    }

    public void setLxphonetwo(String lxphonetwo) {
        this.lxphonetwo = lxphonetwo;
    }

    @ExcelField(title = "项目联系人电话2", align = 2, sort = 43)
    public String getLxcalltwo() {
        return lxcalltwo;
    }

    public void setLxcalltwo(String lxcalltwo) {
        this.lxcalltwo = lxcalltwo;
    }

    @Email(message = "项目联系人邮箱2必须为合法邮箱")
    @ExcelField(title = "项目联系人邮箱2", align = 2, sort = 44)
    public String getLxemailtwo() {
        return lxemailtwo;
    }

    public void setLxemailtwo(String lxemailtwo) {
        this.lxemailtwo = lxemailtwo;
    }

    @ExcelField(title = "项目联系人微信账号2", align = 2, sort = 45)
    public String getLxwxzhtwo() {
        return lxwxzhtwo;
    }

    public void setLxwxzhtwo(String lxwxzhtwo) {
        this.lxwxzhtwo = lxwxzhtwo;
    }

    @ExcelField(title = "审核辅助标识01", align = 2, sort = 46)
    public String getShfzbsone() {
        return shfzbsone;
    }

    public void setShfzbsone(String shfzbsone) {
        this.shfzbsone = shfzbsone;
    }

    @ExcelField(title = "审核辅助标识02", align = 2, sort = 47)
    public String getShfzbstwo() {
        return shfzbstwo;
    }

    public void setShfzbstwo(String shfzbstwo) {
        this.shfzbstwo = shfzbstwo;
    }

    @ExcelField(title = "审核辅助标识03", align = 2, sort = 48)
    public String getShfzbsthree() {
        return shfzbsthree;
    }

    public void setShfzbsthree(String shfzbsthree) {
        this.shfzbsthree = shfzbsthree;
    }

    @ExcelField(title = "项目排序", align = 2, sort = 49)
    public String getXmpx() {
        return xmpx;
    }

    public void setXmpx(String xmpx) {
        this.xmpx = xmpx;
    }

    @ExcelField(title = "阶段（1.项目储备 2.计划编制）", align = 2, sort = 50)
    public String getStage() {
        return stage;
    }

    public String getStageStr() {
        if (STAGE_XMCB.equals(this.stage)) {
            return "项目储备";
        } else if (STAGE_JHBZ.equals(this.stage)) {
            return "计划编制";
        }
        return this.stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    @ExcelField(title = "层级（1省，2市，3县）", align = 2, sort = 51)
    public String getCj() {
        return cj;
    }

    public String getCjStr() {
        if (Office.GRADE_SHIJI.equals(this.cj)) {
            return "地市级";
        } else if (Office.GRADE_SHENGJICS.equals(this.cj)) {
            return "省厅局级";
        } else if (Office.GRADE_SHENGJIFGW.equals(this.cj)) {
            return "省发改委";
        } else if (Office.GRADE_XIBUCHU.equals(this.cj)) {
            return "领导小组办公室";
        } else if (Office.GRADE_WANGZHAN.equals(this.cj)) {
            return "网站申报单位";
        }
        return this.cj;
    }

    public void setCj(String cj) {
        this.cj = cj;
    }

    @ExcelField(title = "状态（1.报送 2.审核区，3储备库）", align = 2, sort = 52)
    public String getZt() {
        return zt;
    }

    public String getZtStr() {
        if (ZT_XMCB_BS.equals(this.zt)) {
            return "项目储备-填报区";
        } else if (ZT_XMCB_SHQ.equals(this.zt)) {
            return "项目储备-审核区";
        } else if (ZT_XMCB_CBK.equals(this.zt)) {
            return "项目储备-储备库";
        } else if (ZT_TZJH_BZQ.equals(this.zt)) {
            return "计划编制-编制区";
        } else if (ZT_TZJH_SHQ.equals(this.zt)) {
            return "计划编制-审核区";
        } else if (ZT_TZJH_DBQ.equals(this.zt)) {
            return "计划编制-待报去";
        }
        return this.zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    @ExcelField(title = "日常监管直接责任单位", align = 2, sort = 53)
    public String getRcjgzjzrdw() {
        return rcjgzjzrdw;
    }

    public void setRcjgzjzrdw(String rcjgzjzrdw) {
        this.rcjgzjzrdw = rcjgzjzrdw;
    }

    @ExcelField(title = "日常监管直接责任单位责任人", align = 2, sort = 54)
    public String getRcjgzrdwjgzrr() {
        return rcjgzrdwjgzrr;
    }

    public void setRcjgzrdwjgzrr(String rcjgzrdwjgzrr) {
        this.rcjgzrdwjgzrr = rcjgzrdwjgzrr;
    }

    @ExcelField(title = "是否申请中央预算内资金", dictType = "", align = 2, sort = 55)
    public String getSfsqzyysnzj() {
        return sfsqzyysnzj;
    }

    public void setSfsqzyysnzj(String sfsqzyysnzj) {
        this.sfsqzyysnzj = sfsqzyysnzj;
    }

    @ExcelField(title = "是否ppp（ppp 0否 1是）", dictType = "", align = 2, sort = 56)
    public String getSfppp() {
        return sfppp;
    }

    public void setSfppp(String sfppp) {
        this.sfppp = sfppp;
    }

    @ExcelField(title = "ppp种类(ppp 0否 ，1是)", dictType = "", align = 2, sort = 57)
    public String getPppzl() {
        return pppzl;
    }

    public void setPppzl(String pppzl) {
        this.pppzl = pppzl;
    }

    @ExcelField(title = "政府参与方式(ppp)", dictType = "", align = 2, sort = 58)
    public String getZfcyfs() {
        return zfcyfs;
    }

    public void setZfcyfs(String zfcyfs) {
        this.zfcyfs = zfcyfs;
    }

    @ExcelField(title = "拟采用ppp操作模式(ppp)", dictType = "", align = 2, sort = 59)
    public String getNcypppczms() {
        return ncypppczms;
    }

    public void setNcypppczms(String ncypppczms) {
        this.ncypppczms = ncypppczms;
    }

    @ExcelField(title = "带头单位(一带一路)", align = 2, sort = 60)
    public String getQtdw() {
        return qtdw;
    }

    public void setQtdw(String qtdw) {
        this.qtdw = qtdw;
    }

    @ExcelField(title = "业主单位(一带一路)", align = 2, sort = 61)
    public String getYzdw() {
        return yzdw;
    }

    public void setYzdw(String yzdw) {
        this.yzdw = yzdw;
    }

    @ExcelField(title = "建设单位(一带一路)", align = 2, sort = 62)
    public String getJsdw() {
        return jsdw;
    }

    public void setJsdw(String jsdw) {
        this.jsdw = jsdw;
    }

    @ExcelField(title = "推进情况(一带一路)", align = 2, sort = 63)
    public String getTjqk() {
        return tjqk;
    }

    public void setTjqk(String tjqk) {
        this.tjqk = tjqk;
    }

    @ExcelField(title = "审核部门(报送)", dictType = "", align = 2, sort = 64)
    public Office getShbm() {
        return shbm;
    }

    public void setShbm(Office shbm) {
        this.shbm = shbm;
    }

    @ExcelField(title = "科室（报送）", dictType = "", align = 2, sort = 65)
    public String getKs() {
        return ks;
    }

    public void setKs(String ks) {
        this.ks = ks;
    }

    @ExcelField(title = "锁状态（0枷锁，1解锁）", align = 2, sort = 66)
    public String getSzt() {
        return szt;
    }

    public String getSztStr() {
        if (SZT_SD.equals(this.szt)){
            return "地市级锁";
        } else if (SZT_TJ.equals(this.szt)){
            return "省厅局级锁";
        } else if (SZT_CS.equals(this.szt)){
            return "省发改委锁";
        } else if (SZT_XBC.equals(this.szt)){
            return "领导小组办公室锁";
        }
        return "未锁定";
    }

    public void setSzt(String szt) {
        this.szt = szt;
    }

    @ExcelField(title = "日常监管直接责任单位联系电话", align = 2, sort = 67)
    public String getRcjgzjzrdwlxdh() {
        return rcjgzjzrdwlxdh;
    }

    public void setRcjgzjzrdwlxdh(String rcjgzjzrdwlxdh) {
        this.rcjgzjzrdwlxdh = rcjgzjzrdwlxdh;
    }

    /**
     * @param stage 阶段
     * @param cj    层级
     * @param zt    状态
     */
    public void setListParam(String stage, String cj, String zt) {
        this.stage = stage;
        this.cj = cj;
        this.zt = zt;
    }

    @ExcelField(title = "项目实施机构名称（ppp）", align = 2, sort = 68)
    public String getXmssjgmc() {
        return xmssjgmc;
    }

    public void setXmssjgmc(String xmssjgmc) {
        this.xmssjgmc = xmssjgmc;
    }

    @ExcelField(title = "实施机构性质（ppp）", align = 2, sort = 69)
    public String getSsjgxz() {
        return ssjgxz;
    }

    public void setSsjgxz(String ssjgxz) {
        this.ssjgxz = ssjgxz;
    }

    @ExcelField(title = "计划实施年度（年份 ppp）", align = 2, sort = 70)
    public String getJhssnd() {
        return jhssnd;
    }

    public void setJhssnd(String jhssnd) {
        this.jhssnd = jhssnd;
    }

    @ExcelField(title = "是否申请专项建设基金（投资情况）", align = 2, sort = 71)
    public String getSfsqzxjsjj() {
        return sfsqzxjsjj;
    }

    public void setSfsqzxjsjj(String sfsqzxjsjj) {
        this.sfsqzxjsjj = sfsqzxjsjj;
    }

    @ExcelField(title = "地方指标省份", align = 2, sort = 72)
    public String getDfzbsf() {
        return dfzbsf;
    }

    public void setDfzbsf(String dfzbsf) {
        this.dfzbsf = dfzbsf;
    }

    @ExcelField(title = "类型", align = 2, sort = 73)
    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx;
    }

    @ExcelField(title = "是否退回", align = 2, sort = 74)
    public String getSfth() {
        return sfth;
    }

    public void setSfth(String sfth) {
        this.sfth = sfth;
    }

    @ExcelField(title="项目隶属关系", dictType="xmlsgx", align=2, sort=75)
    public String getXmlsgx() {
        return xmlsgx;
    }

    public void setXmlsgx(String xmlsgx) {
        this.xmlsgx = xmlsgx;
    }

    public String getJtxmnr() {
        return jtxmnr;
    }

    public void setJtxmnr(String jtxmnr) {
        this.jtxmnr = jtxmnr;
    }

    public Double getXmtze() {
        return xmtze;
    }

    public void setXmtze(Double xmtze) {
        this.xmtze = xmtze;
    }

    public String getSsfabzjg() {
        return ssfabzjg;
    }

    public void setSsfabzjg(String ssfabzjg) {
        this.ssfabzjg = ssfabzjg;
    }

    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    public String getHbfs() {
        return hbfs;
    }

    public void setHbfs(String hbfs) {
        this.hbfs = hbfs;
    }

    public String getNhzqx() {
        return nhzqx;
    }

    public void setNhzqx(String nhzqx) {
        this.nhzqx = nhzqx;
    }

    public String getScdw() {
        return scdw;
    }

    public void setScdw(String scdw) {
        this.scdw = scdw;
    }

    public String getScfs() {
        return scfs;
    }

    public void setScfs(String scfs) {
        this.scfs = scfs;
    }

    public Date getFapzsj() {
        return fapzsj;
    }

    public void setFapzsj(Date fapzsj) {
        this.fapzsj = fapzsj;
    }

    public String getSzfs() {
        return szfs;
    }

    public void setSzfs(String szfs) {
        this.szfs = szfs;
    }

    public String getShzbf() {
        return shzbf;
    }

    public void setShzbf(String shzbf) {
        this.shzbf = shzbf;
    }

    public String getZfczrdb() {
        return zfczrdb;
    }

    public void setZfczrdb(String zfczrdb) {
        this.zfczrdb = zfczrdb;
    }

    public Double getXmzbj() {
        return xmzbj;
    }

    public void setXmzbj(Double xmzbj) {
        this.xmzbj = xmzbj;
    }

    public Double getXmzbjShzb() {
        return xmzbjShzb;
    }

    public void setXmzbjShzb(Double xmzbjShzb) {
        this.xmzbjShzb = xmzbjShzb;
    }

    public Double getXmzbjZfcz() {
        return xmzbjZfcz;
    }

    public void setXmzbjZfcz(Double xmzbjZfcz) {
        this.xmzbjZfcz = xmzbjZfcz;
    }

    public String getSfzjxmgs() {
        return sfzjxmgs;
    }

    public void setSfzjxmgs(String sfzjxmgs) {
        this.sfzjxmgs = sfzjxmgs;
    }

    public Date getXmgszjrq() {
        return xmgszjrq;
    }

    public void setXmgszjrq(Date xmgszjrq) {
        this.xmgszjrq = xmgszjrq;
    }

    public String getHzqx() {
        return hzqx;
    }

    public void setHzqx(String hzqx) {
        this.hzqx = hzqx;
    }

    public String getShzbyqsy() {
        return shzbyqsy;
    }

    public void setShzbyqsy(String shzbyqsy) {
        this.shzbyqsy = shzbyqsy;
    }

    public Double getShzbzhnhsyl() {
        return shzbzhnhsyl;
    }

    public void setShzbzhnhsyl(Double shzbzhnhsyl) {
        this.shzbzhnhsyl = shzbzhnhsyl;
    }

    public String getZxlb() {
        return zxlb;
    }

    public void setZxlb(String zxlb) {
        this.zxlb = zxlb;
    }

    public String getZxzqxxHbfs() {
        return zxzqxxHbfs;
    }

    public void setZxzqxxHbfs(String zxzqxxHbfs) {
        this.zxzqxxHbfs = zxzqxxHbfs;
    }

    public String getHbl() {
        return hbl;
    }

    public void setHbl(String hbl) {
        this.hbl = hbl;
    }

    public String getHbzq() {
        return hbzq;
    }

    public void setHbzq(String hbzq) {
        this.hbzq = hbzq;
    }

    public String getLdxg() {
        return ldxg;
    }

    public void setLdxg(String ldxg) {
        this.ldxg = ldxg;
    }

    public String getJyyh() {
        return jyyh;
    }

    public void setJyyh(String jyyh) {
        this.jyyh = jyyh;
    }

    public String getWjbt() {
        return wjbt;
    }

    public void setWjbt(String wjbt) {
        this.wjbt = wjbt;
    }

    public String getBswh() {
        return bswh;
    }

    public void setBswh(String bswh) {
        this.bswh = bswh;
    }
    
    public String getUpdatestatus() {
		return updatestatus;
	}

	public void setUpdatestatus(String updatestatus) {
		this.updatestatus = updatestatus;
	}

	public CInsBusinessSsqk getSsqk() {
        return ssqk;
    }

    public void setSsqk(CInsBusinessSsqk ssqk) {
        this.ssqk = ssqk;
    }

    public List<CInsBusinessTzqk> getTzqks() {
        return tzqks;
    }

    public void setTzqks(List<CInsBusinessTzqk> tzqks) {
        this.tzqks = tzqks;
    }

    public List<CInsBusinessQqgz> getQqgzs() {
        return qqgzs;
    }

    public void setQqgzs(List<CInsBusinessQqgz> qqgzs) {
        this.qqgzs = qqgzs;
    }
    
    public List<CInsBusinessZdxmk> getZdxmk() {
		return zdxmk;
	}

	public void setZdxmk(List<CInsBusinessZdxmk> zdxmk) {
		this.zdxmk = zdxmk;
	}

	public List<CInsBusinessXmgs> getXmgss() {
        return xmgss;
    }

    public void setXmgss(List<CInsBusinessXmgs> xmgss) {
        this.xmgss = xmgss;
    }

    public Date getJhbzDate() {
        return jhbzDate;
    }

    public void setJhbzDate(Date jhbzDate) {
        this.jhbzDate = jhbzDate;
    }
    
    public String getIncidtype() {
		return incidtype;
	}

	public void setIncidtype(String incidtype) {
		this.incidtype = incidtype;
	}

	public String getIncid() {
		return incid;
	}

	public void setIncid(String incid) {
		this.incid = incid;
	}

	public String getRemarks() {
		if ("1".equals(this.remarks)) {
            return "2017年省重点项目";
        } else if ("2".equals(this.remarks)) {
            return "2018年省重点项目";
        }else if ("3".equals(this.remarks)) {
            return "2017年省基建项目";
        }else if ("4".equals(this.remarks)) {
            return "2018年省基建项目";
        }else if ("5".equals(this.remarks)) {
            return "5818项目";
        }else if ("6".equals(this.remarks)) {
            return "其他项目";
        }else if ("7".equals(this.remarks)) {
            return "省节能减排专项资金项目";
        }else if ("8".equals(this.remarks)) {
            return "京豫南北水调对口协作项目";
        }else if ("9".equals(this.remarks)) {
            return "现代服务业重点项目";
        } else if ("10".equals(this.remarks)) {
            return "省转型发展攻坚项目";
        } else if ("11".equals(this.remarks)) {
            return "省先进制造重大项目";
        }
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getHeimd() {
		return heimd;
	}

	public void setHeimd(String heimd) {
		this.heimd = heimd;
	}

	public String getHongmd() {
		return hongmd;
	}

	public void setHongmd(String hongmd) {
		this.hongmd = hongmd;
	}
	
	
    public String getDkxmmc() {
		return dkxmmc;
	}

	public void setDkxmmc(String dkxmmc) {
		this.dkxmmc = dkxmmc;
	}

	/****************
     * 额外的输出项 start
     ****************/

    //填报状态
    public String getTbzt() {
        if (ZT_XMCB_BS.equals(this.zt) && Global.YES.equals(this.sfth)) {
            return "退回";
        } else if (ZT_XMCB_BS.equals(this.zt)) {
            return "待上报";
        } else {
            return "已报送";
        }
    }

    /**
     * 判断当前登录用户的所属部门是否是创建本项目的部门
     * @return
     */
    public String getIsCreator(){
        User createBy = this.getCreateBy();
        if (null != createBy && !"null".equals(createBy)) {
            String xmjbxxDeptId = UserUtils.getOfficeIdByUserId(createBy.getId());
            String userDeptId = UserUtils.getUser().getOffice().getId();
            if (xmjbxxDeptId.equals(userDeptId)) {
                return Global.YES;
            }
            return Global.NO;
        }
        return Global.NO;
    }

    public String getSjlyStr() {
        if (this.createBy == null || this.createBy.getId() == null || "".equals(this.createBy.getId())) {
            return "下级单位报送";
        }

        String grade = "";
        try {
            Office office= UserUtils.getUserOffice(this.createBy);
            grade = office.getGrade();
        } catch (Exception e) {
            return "下级单位报送";
        }

        if (UserUtils.getUserGrade().equals(grade)) {
            return "本级单位编制";
        } else if (Integer.parseInt(UserUtils.getUserGrade()) > Integer.parseInt(grade)) {
            return "下级单位报送";
        }
        return "";
    }

    /**
     * 获取项目所处阶段
     * 开工时间在本年的为开工阶段
     * 开工时间在明年的为储备阶段
     * 开工时间在后年及后年以后的为谋划阶段
     */
    public String getXmscjdStr(){
        if (null == this.starttimen || "".equals(this.starttimen.trim())) {
            return "";
        }
        Integer startTimeYear = null;
        try {
            startTimeYear = Integer.parseInt(this.starttimen);
        } catch (NumberFormatException e) {
            return "";
        }

        Integer curYear = Integer.parseInt(DateUtils.getYear());
        if (curYear.equals(startTimeYear)) {
            return "开工阶段";
        } else if (startTimeYear - curYear == 1) {
            return "储备阶段";
        } else if (startTimeYear - curYear > 1) {
            return "谋划阶段";
        }
        return "";
    }

    public String getJsddStr(){
        return DictUtils.getTreeName(this.jsdd, "area");
    }

    public String getGbhyStr(){
        return DictUtils.getTreeDictValue(this.gbhy);
    }

    public String getSshyStr(){
        return DictUtils.getTreeDictValue(this.sshy);
    }
    
    public String getSfsjjFlag() {
		return sfsjjFlag;
	}

	public void setSfsjjFlag(String sfsjjFlag) {
		this.sfsjjFlag = sfsjjFlag;
	}
	

	


	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}





	/****************
     * 额外的输出项 end
     ****************/

    //阶段（1.项目储备 2.计划编制）
    public static final String STAGE_XMCB = "1";
    public static final String STAGE_JHBZ = "2";

    //状态（1.报送 2.审核区，3储备库）
    public static final String ZT_XMCB_BS = "1";  //项目储备-报送/填报区
    public static final String ZT_XMCB_SHQ = "2"; //项目储备-审核区
    public static final String ZT_XMCB_CBK = "3"; //项目储备-储备库
    public static final String ZT_TZJH_BZQ = "4"; //计划编制-编制区
    public static final String ZT_TZJH_SHQ = "5"; //计划编制-审核区
    public static final String ZT_TZJH_DBQ = "6"; //计划编制-待报去

    //锁状态（0锁定，1未锁）
    public static final String SZT_WS = "0"; // 未锁
    public static final String SZT_SD = "1"; // 地州级锁
    public static final String SZT_TJ = "2"; // 自治区厅局级锁
    public static final String SZT_CS = "3"; // 自治区发改委锁
    public static final String SZT_XBC = "4"; // 领导小组办公室锁

    // 项目类型
    public static final String XMLX_SP = "1";
    public static final String XMLX_HZ = "2";
    public static final String XMLX_BA = "3";
}