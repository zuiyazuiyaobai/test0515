CREATE TABLE "ZDXM_JEEPLUS"."C_INS_BUSINESS_SNGDJH"
(
"ID" VARCHAR2(64) NOT NULL,
"CREATE_BY" VARCHAR2(64),
"CREATE_DATE" TIMESTAMP(0),
"UPDATE_BY" VARCHAR2(64),
"UPDATE_DATE" TIMESTAMP(0),
"REMARKS" NVARCHAR2(255),
"DEL_FLAG" VARCHAR2(64),
"XMJBXX_ID" VARCHAR2(64),
"DEPT_ID" VARCHAR2(64),
"JHLY" VARCHAR2(64),
CONSTRAINT "PK_C_INS_BUSINESS_SNGDJH_ID" NOT CLUSTER PRIMARY KEY("ID"));
COMMENT ON TABLE "ZDXM_JEEPLUS"."C_INS_BUSINESS_SNGDJH" IS '三年滚动计划';
COMMENT ON COLUMN "ZDXM_JEEPLUS"."C_INS_BUSINESS_SNGDJH"."ID" IS '主键';
COMMENT ON COLUMN "ZDXM_JEEPLUS"."C_INS_BUSINESS_SNGDJH"."CREATE_BY" IS '创建者';
COMMENT ON COLUMN "ZDXM_JEEPLUS"."C_INS_BUSINESS_SNGDJH"."CREATE_DATE" IS '创建时间';
COMMENT ON COLUMN "ZDXM_JEEPLUS"."C_INS_BUSINESS_SNGDJH"."UPDATE_BY" IS '更新者';
COMMENT ON COLUMN "ZDXM_JEEPLUS"."C_INS_BUSINESS_SNGDJH"."UPDATE_DATE" IS '更新时间';
COMMENT ON COLUMN "ZDXM_JEEPLUS"."C_INS_BUSINESS_SNGDJH"."REMARKS" IS '备注信息';
COMMENT ON COLUMN "ZDXM_JEEPLUS"."C_INS_BUSINESS_SNGDJH"."DEL_FLAG" IS '逻辑删除标记（0：显示；1：隐藏）';
COMMENT ON COLUMN "ZDXM_JEEPLUS"."C_INS_BUSINESS_SNGDJH"."XMJBXX_ID" IS '项目基本信息ID';
COMMENT ON COLUMN "ZDXM_JEEPLUS"."C_INS_BUSINESS_SNGDJH"."DEPT_ID" IS '部门ID';
COMMENT ON COLUMN "ZDXM_JEEPLUS"."C_INS_BUSINESS_SNGDJH"."JHLY" IS '计划来源（1.投资计划报送 2.储备库挑选）';
;

