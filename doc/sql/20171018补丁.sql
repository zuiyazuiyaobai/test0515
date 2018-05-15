alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_TZQK" add column("qt" VARCHAR2(64));
comment on column "ZDXM_JEEPLUS"."C_INS_BUSINESS_TZQK"."QT" is '其他';
alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_TZQK" add column("SORT" INTEGER);
comment on column "ZDXM_JEEPLUS"."C_INS_BUSINESS_TZQK"."SORT" is '排序';

alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_ZJLB_NTZ" add column("TYPE" VARCHAR2(64));
comment on column "ZDXM_JEEPLUS"."C_INS_BUSINESS_ZJLB_NTZ"."TYPE" is '类型（1.资本金缺口2.资本需求）';
alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_ZJLB_NTZ" add column("SORT" INTEGER);
comment on column "ZDXM_JEEPLUS"."C_INS_BUSINESS_ZJLB_NTZ"."SORT" is '排序';

alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_QQGZ" add column("SORT" INTEGER);
comment on column "ZDXM_JEEPLUS"."C_INS_BUSINESS_QQGZ"."SORT" is '排序';
