-- 新建项目公司表
CREATE TABLE "ZDXM_JEEPLUS"."C_INS_BUSINESS_XMGS"
(
"ID" VARCHAR2(64) NOT NULL,
"CREATE_BY" VARCHAR2(64),
"CREATE_DATE" TIMESTAMP(0),
"UPDATE_BY" VARCHAR2(64),
"UPDATE_DATE" TIMESTAMP(0),
"REMARKS" NVARCHAR2(255),
"DEL_FLAG" VARCHAR2(64),
"XMID" VARCHAR2(64),
"GDMC" VARCHAR2(64),
"XZ" VARCHAR2(64),
"CZ" NUMBER,
"BFB" NUMBER,
CONSTRAINT "PK_C_INS_BUSINESS_XMGS_ID" NOT CLUSTER PRIMARY KEY("ID")) STORAGE(ON "MAIN", CLUSTERBTR) ;


alter table "ZDXM_JEEPLUS"."XMJBXX" add column("ZXLB" VARCHAR2(128));comment on column "ZDXM_JEEPLUS"."XMJBXX"."ZXLB" is '专项类别';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("ZXZQXXHBFS" VARCHAR2(128));comment on column "ZDXM_JEEPLUS"."XMJBXX"."ZXZQXXHBFS" is '回报方式';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("HBL" NUMBER);comment on column "ZDXM_JEEPLUS"."XMJBXX"."HBL" is '回报率（%）';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("HBZQ" VARCHAR2(128));comment on column "ZDXM_JEEPLUS"."XMJBXX"."HBZQ" is '回报周期（年）';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("LDXG" VARCHAR2(128));comment on column "ZDXM_JEEPLUS"."XMJBXX"."LDXG" is '拉动效果（元）';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("JYYH" VARCHAR2(128));comment on column "ZDXM_JEEPLUS"."XMJBXX"."JYYH" is '建议银行';

CREATE TABLE "ZDXM_JEEPLUS"."C_INS_BUSINESS_CONTACT"
(
"ID" VARCHAR2(64) NOT NULL,
"CREATE_BY" VARCHAR2(64),
"CREATE_DATE" TIMESTAMP(0),
"UPDATE_BY" VARCHAR2(64),
"UPDATE_DATE" TIMESTAMP(0),
"REMARKS" NVARCHAR2(255),
"DEL_FLAG" VARCHAR2(64),
"NAME" VARCHAR2(64),
"OFFICE" VARCHAR2(128),
"JOB" VARCHAR2(128),
"MOBILE" VARCHAR2(64),
"TELEPHONE" VARCHAR2(64),
"EMAIL" VARCHAR2(128),
CONSTRAINT "PK_C_INS_BUSINESS_CONTACT_ID" NOT CLUSTER PRIMARY KEY("ID")) STORAGE(ON "MAIN", CLUSTERBTR) ;


alter table "ZDXM_JEEPLUS"."XMJBXX" add column("NAME" VARCHAR2(128));comment on column "ZDXM_JEEPLUS"."XMJBXX"."NAME" is '本期调度填报人 姓名';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("OFFICE" VARCHAR2(128));comment on column "ZDXM_JEEPLUS"."XMJBXX"."OFFICE" is '本期调度填报人 工作单位';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("MOBILE" VARCHAR2(128));comment on column "ZDXM_JEEPLUS"."XMJBXX"."MOBILE" is '本期调度填报人 手机';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("SJKGSJ" TIMESTAMP(0));comment on column "ZDXM_JEEPLUS"."XMJBXX"."SJKGSJ" is '实施情况 实际开工时间';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("SJJGSJ" TIMESTAMP(0));comment on column "ZDXM_JEEPLUS"."XMJBXX"."SJJGSJ" is '实施情况 实际竣工时间';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("ZTBXS" VARCHAR2(128));comment on column "ZDXM_JEEPLUS"."XMJBXX"."ZTBXS" is '实施情况 招投标形式';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("SSQKJSDW" VARCHAR2(128));comment on column "ZDXM_JEEPLUS"."XMJBXX"."SSQKJSDW" is '实施情况 建设单位';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("SSQKXXJD" VARCHAR2(128));comment on column "ZDXM_JEEPLUS"."XMJBXX"."SSQKXXJD" is '实施情况 形象进度';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("SSQKNDJSNR" VARCHAR2(512));comment on column "ZDXM_JEEPLUS"."XMJBXX"."SSQKNDJSNR" is '实施情况 年度建设内容';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("SSQKWTJJY" VARCHAR2(512));comment on column "ZDXM_JEEPLUS"."XMJBXX"."SSQKWTJJY" is '实施情况 问题及建议 进展情况及下一步工作安排';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("SSQKRCJGZJZRDW" VARCHAR2(128));comment on column "ZDXM_JEEPLUS"."XMJBXX"."SSQKRCJGZJZRDW" is '实施情况 日常监管直接责任单位';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("SSQKTZJHTZQK" VARCHAR2(128));comment on column "ZDXM_JEEPLUS"."XMJBXX"."SSQKTZJHTZQK" is '实施情况 投资计划调整情况';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("SSQKZFJCJGLXR" VARCHAR2(128));comment on column "ZDXM_JEEPLUS"."XMJBXX"."SSQKZFJCJGLXR" is '实施情况 政府督查机构联系人';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("SSQKDCJGLXFS" VARCHAR2(128));comment on column "ZDXM_JEEPLUS"."XMJBXX"."SSQKDCJGLXFS" is '实施情况 联系方式（电话）';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("SSQKFGBMLXR" VARCHAR2(128));comment on column "ZDXM_JEEPLUS"."XMJBXX"."SSQKFGBMLXR" is '实施情况 发改部门联系人';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("SSQLFGBMLXFS" VARCHAR2(128));comment on column "ZDXM_JEEPLUS"."XMJBXX"."SSQLFGBMLXFS" is '实施情况 联系方式（电话）';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("ZYYSNTZLJWCZJ" NUMBER);comment on column "ZDXM_JEEPLUS"."XMJBXX"."ZYYSNTZLJWCZJ" is '中央预算内投资 累计完成资金';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("ZYYSNTZLJZFQK" NUMBER);comment on column "ZDXM_JEEPLUS"."XMJBXX"."ZYYSNTZLJZFQK" is '中央预算内投资 累计支付情况';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("ZXZQMJDZXJSZJLJWCZJ" NUMBER);comment on column "ZDXM_JEEPLUS"."XMJBXX"."ZXZQMJDZXJSZJLJWCZJ" is '专项债券募集的专项建设资金 累计完成资金';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("ZXZQMJDZXJSZJLJZFQK" NUMBER);comment on column "ZDXM_JEEPLUS"."XMJBXX"."ZXZQMJDZXJSZJLJZFQK" is '专项债券募集的专项建设资金 累计支付情况';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("QTLBHZLJWCZJ" NUMBER);comment on column "ZDXM_JEEPLUS"."XMJBXX"."QTLBHZLJWCZJ" is '其他类别汇总 累计完成资金';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("QTLBHZLJWCQK" NUMBER);comment on column "ZDXM_JEEPLUS"."XMJBXX"."QTLBHZLJWCQK" is '其他类别汇总 累计支付情况';

alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_TZQK" add column("LJDWZJ" NUMBER);comment on column "ZDXM_JEEPLUS"."C_INS_BUSINESS_TZQK"."LJDWZJ" is '累计到位资金';
