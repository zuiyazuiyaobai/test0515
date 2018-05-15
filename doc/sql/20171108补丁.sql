insert into "ZDXM_JEEPLUS"."SYS_DICT" ("ID","VALUE","LABEL","TYPE","DESCRIPTION","SORT","PARENT_ID","CREATE_BY","CREATE_DATE","UPDATE_BY","UPDATE_DATE","REMARKS","DEL_FLAG")
    values ('bdcd52b2f72b428a85b1e88d0b3bb502', '0', '锁定', 'szt', '锁状态', 10, '0', '1', '2016-02-19 17:05:35', '1', '2016-02-19 17:05:35', null, '0');
insert into "ZDXM_JEEPLUS"."SYS_DICT" ("ID","VALUE","LABEL","TYPE","DESCRIPTION","SORT","PARENT_ID","CREATE_BY","CREATE_DATE","UPDATE_BY","UPDATE_DATE","REMARKS","DEL_FLAG")
    values ('e00aeddfff014e6992edabff420310e5', '1', '未锁定', 'szt', '锁状态', 20, '0', '1', '2016-02-19 17:05:35', '1', '2016-02-19 17:05:35', null, '0');

insert into "ZDXM_JEEPLUS"."SYS_DICT" ("ID","VALUE","LABEL","TYPE","DESCRIPTION","SORT","PARENT_ID","CREATE_BY","CREATE_DATE","UPDATE_BY","UPDATE_DATE","REMARKS","DEL_FLAG")
    values ('f1e3795fd9fa4dfba4cbeba1705c90f8', '1', '已报送', 'nrzt', '报送状态', 10, '0', '1', '2016-02-19 17:05:35', '1', '2016-02-19 17:05:35', null, '0');
insert into "ZDXM_JEEPLUS"."SYS_DICT" ("ID","VALUE","LABEL","TYPE","DESCRIPTION","SORT","PARENT_ID","CREATE_BY","CREATE_DATE","UPDATE_BY","UPDATE_DATE","REMARKS","DEL_FLAG")
    values ('366879e2e8b9484c9a241fdc0cab64af', '2', '未报送', 'nrzt', '报送状态', 20, '0', '1', '2016-02-19 17:05:35', '1', '2016-02-19 17:05:35', null, '0');

-- 更新所有项目的锁状态为未锁定
update xmjbxx set szt = '1' where szt is null;

-- 更新所有项目的是否退回为否
update xmjbxx set sfth = '0' where szt is null;

alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_XMJBXX_DEPT_RELATION" alter column "BSZT" rename to "NRZT";
alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_XMJBXX_DEPT_RELATION" modify "BSZT" VARCHAR2(50);

alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_XMJBXX_DEPT_RELATION" add column("ZT" VARCHAR2(64));
comment on column "ZDXM_JEEPLUS"."C_INS_BUSINESS_XMJBXX_DEPT_RELATION"."ZT" is '状态（1.储备库-已报送 2.储备库-被退回 3.三年滚动计划-已报送 4.三年滚动计划-未报送 5.三年滚动计划-被退回）';

alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_XMJBXX_DEPT_RELATION" add column("ZGCJ" VARCHAR2(64));
comment on column "ZDXM_JEEPLUS"."C_INS_BUSINESS_XMJBXX_DEPT_RELATION"."ZGCJ" is '最高层级（1：地（州、市）级；2：自治区厅局级；3：自治区发改委处室 4：领导小组办公室（西部处）；）';

alter table "ZDXM_JEEPLUS"."XMJBXX" add column("JHBZ_DATE" TIMESTAMP(0));
comment on column "ZDXM_JEEPLUS"."XMJBXX"."JHBZ_DATE" is '计划编制时间';

alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_XMJBXX_DEPT_RELATION" add column("BS_DATE" TIMESTAMP(0));
comment on column "ZDXM_JEEPLUS"."C_INS_BUSINESS_XMJBXX_DEPT_RELATION"."BS_DATE" is '年度计划报送&专项建设基金项目_报送时间';
