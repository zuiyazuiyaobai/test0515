alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_XMJBXX_DEPT_RELATION" add column("STATUS" VARCHAR2(64));comment on column "ZDXM_JEEPLUS"."C_INS_BUSINESS_XMJBXX_DEPT_RELATION"."STATUS" is '状态（1.年度计划报送-编制区 2.年度计划报送-报送区 5.年度计划报送-编制 6.年度计划报送-编制）';
alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_XMJBXX_DEPT_RELATION" add column("BSZT" VARCHAR2(64));comment on column "ZDXM_JEEPLUS"."C_INS_BUSINESS_XMJBXX_DEPT_RELATION"."BSZT" is '报送状态（1.已报送 2.未报送）';
alter table "ZDXM_JEEPLUS"."XMJBXX" add column("WJBT" VARCHAR2(64));comment on column "ZDXM_JEEPLUS"."XMJBXX"."WJBT" is '文件标题';
