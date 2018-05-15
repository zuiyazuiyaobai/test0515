package com.jeeplus.modules.xmjbxx.aop;

import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.modules.sys.entity.Office;
import com.jeeplus.modules.sys.service.OfficeService;
import com.jeeplus.modules.xmjbxx.entity.sub.CInsBusinessXmjbxxDeptRelation;
import com.jeeplus.modules.xmjbxx.service.sub.CInsBusinessXmjbxxDeptRelationService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Aspect
@Component
public class XmjbxxDeptRelationAop {

    @Autowired
    CInsBusinessXmjbxxDeptRelationService relationService;

    @Autowired
    OfficeService officeService;

    // @After("execution(* com.jeeplus.modules.xmjbxx.service.sub.CInsBusinessXmjbxxDeptRelationService.save(..))")
    public void doAfterSaveOrUpate(JoinPoint point){
        CInsBusinessXmjbxxDeptRelation relation = (CInsBusinessXmjbxxDeptRelation) point.getArgs()[0];
        setZgcj(relation);
    }

    public void setZgcj(CInsBusinessXmjbxxDeptRelation relation) {
        if (null == relation.getDept() || null == relation.getXmjbxx() || StringUtils.isBlank(relation.getType())) {
            return;
        }
        CInsBusinessXmjbxxDeptRelation parameter = new CInsBusinessXmjbxxDeptRelation();
        parameter.setXmjbxx(relation.getXmjbxx());
        parameter.setDept(relation.getDept());
        parameter.setType(relation.getType());
        List<CInsBusinessXmjbxxDeptRelation> relationList = relationService.findList(parameter);
        Office office;
        if (relationList.size() > 1) {
            Collections.sort(relationList, new Comparator<CInsBusinessXmjbxxDeptRelation>() {
                @Override
                public int compare(CInsBusinessXmjbxxDeptRelation o1, CInsBusinessXmjbxxDeptRelation o2) {
                    return Integer.parseInt(o2.getDept().getGrade()) - Integer.parseInt(o1.getDept().getGrade());
                }
            });
            office = relationList.get(0).getDept();
        } else if (relationList.size() == 1) {
            office = relationList.get(0).getDept();
        } else {
            office = officeService.get(relation.getDept().getId());
        }
        relation.setZgcj(office.getGrade());
    }
}
