-- 删除xmjbxx表中的废弃字段
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "NAME";
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "OFFICE";
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "MOBILE";
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "SJKGSJ";
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "SJJGSJ";
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "ZTBXS";
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "SSQKJSDW";
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "SSQKXXJD";
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "SSQKNDJSNR";
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "SSQKWTJJY";
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "SSQKRCJGZJZRDW";
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "SSQKTZJHTZQK";
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "SSQKZFJCJGLXR";
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "SSQKDCJGLXFS";
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "SSQKFGBMLXR";
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "SSQLFGBMLXFS";
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "ZYYSNTZLJWCZJ";
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "ZYYSNTZLJZFQK";
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "ZXZQMJDZXJSZJLJWCZJ";
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "ZXZQMJDZXJSZJLJZFQK";
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "QTLBHZLJWCZJ";
alter table "ZDXM_JEEPLUS"."XMJBXX" drop column "QTLBHZLJWCQK";

alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_XMGS" alter column "XMID" rename to "XMJBXX_ID";
alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_XMGS" modify "XMJBXX_ID" VARCHAR2(50);

alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_ZJLB_NTZ" alter column "ZJLBID" rename to "TZQK_ID";
alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_ZJLB_NTZ" modify "TZQK_ID" VARCHAR2(50);

alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_QQGZ" alter column "XMID" rename to "XMJBXX_ID";
alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_QQGZ" modify "XMJBXX_ID" VARCHAR2(50);

alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_SSQK" alter column "XMID" rename to "XMJBXX_ID";
alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_SSQK" modify "XMJBXX_ID" VARCHAR2(50);

alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_TZQK" alter column "XMID" rename to "XMJBXX_ID";
alter table "ZDXM_JEEPLUS"."C_INS_BUSINESS_TZQK" modify "XMJBXX_ID" VARCHAR2(50);

-- 修改树型字典的表名
create table SYS_TREE_DICT as select * from TREE_FHGHFX;

-- 调整菜单项
update sys_menu set parent_id = '3', parent_ids = '0,1,3,', sort = '61', href = '/sys/treeDict', permission = 'sys:treeDict:list' where id = '58f5b2a1d7aa4e369fa4b38abfc3bbc9';
update sys_menu set permission = 'sys:treeDict:add'  where id = 'cf2e8b1dde1842cc9ad885a1253a1980';
update sys_menu set permission = 'sys:treeDict:del'  where id = '8ca7d58943994ab6b2cf3f43a7dc2aab';
update sys_menu set permission = 'sys:treeDict:edit'  where id = '5ae23de5834a45c0b0f5a7296aa74baf';
update sys_menu set permission = 'sys:treeDict:view'  where id = '7c98da0b40464e1787832b9d6e752258';
update sys_menu set permission = 'sys:treeDict:import'  where id = 'e06ea67af811402c9b9f0b070b4405c2';
update sys_menu set permission = 'sys:treeDict:export'  where id = '555918d61ab24163808e9da9ca5ffbfb';
delete from sys_menu where id = '3e26eed389c54f4ca860f5966dc73e16';