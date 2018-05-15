-- 慎重操作！清除所有项目相关数据（不包含配置相关数据，如字典、树型字典、人员等）
truncate TABLE xmjbxx; -- 项目基本信息表
truncate TABLE c_ins_business_xmgs; -- 项目公司表
truncate TABLE c_ins_business_qqgz; -- 前期情况表
truncate TABLE c_ins_business_ssqk; -- 实施情况表
truncate TABLE c_ins_business_tzqk; -- 投资情况表
truncate TABLE c_ins_business_zjlb; -- 资金类别表（暂时未启用）
truncate TABLE c_ins_business_zjlb_ntz; -- 年投资表
truncate TABLE c_ins_business_xmjbxx_dept_relation; -- 项目部门关系表
truncate TABLE c_ins_business_scheduler_task; -- 调度任务表
truncate TABLE c_ins_business_xmjbxx_task_relation; -- 项目调度任务关系表
truncate TABLE c_ins_business_log; -- 业务日志表
truncate TABLE c_ins_business_contact; -- 联系人信息表
