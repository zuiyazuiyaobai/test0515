-- 创建校验项目 审批监管平台代码 的视图，同步查询部分数据
CREATE OR REPLACE VIEW v_c_ins_business_info
AS
        select
                projectid                  as spjgptdm  ,
                projectname                as xmmc      ,
                sxxz                       as xmlx      ,
                PROJECTNATURE              as jsxz      ,
                reg_country                as gb        ,
                AREAIDTWO                  as jsdd      ,
                PSORTTWO                   as gbhy      ,
                b.THE_INDUSTRY             as sshy      ,
                GROSSINVESTMENT            as ztz       ,
                to_char(STARTTIME, 'yyyy') as starttimen,
                to_char(STARTTIME, 'mm')   as starttimey,
                to_char(ENDTIME, 'yyyy')     as endtime ,
                CONSTRUCTIONSCALE          as zyjsgm    ,
                ''                         as ndzhjsnr  ,
                INCNAME                    as xmfrdw    ,
                PAGENAME                   as zrname    ,
                PAGEPHONE                  as zrcall    ,
                AGENAME                    as lxnameone ,
                AGEMOBILE                  as lxphoneone,
                AGEPHONE                   as lxcallone ,
                AGEEMAIL                   as lxemailone
        from
                FGW.c_ins_business_info a
        left join FGW.C_INS_BUSINESS_TZXX b on b.cbsnum = a.cbsnum
        left join FGW.ZYRG212_CONTRIBUTION_INFO c on c.cbsnum = a.cbsnum;
