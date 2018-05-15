-- 更新锁状态字段初始值
update xmjbxx set szt = '0' where szt is null;commit;

alter table "ZDXM_JEEPLUS"."XMJBXX" add column("CREATE_BY_NAME" VARCHAR2(64));comment on column "ZDXM_JEEPLUS"."XMJBXX"."CREATE_BY_NAME" is '填报人姓名';
alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_LOG" add column("RECEIVE_USER_NAME" VARCHAR2(64));comment on column "ZDXM_JEEPLUS"."C_INS_BUSINESS_LOG"."RECEIVE_USER_NAME" is '接收人人姓名';