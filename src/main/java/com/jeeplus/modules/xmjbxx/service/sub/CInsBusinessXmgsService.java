/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.service.sub;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.modules.xmjbxx.dao.sub.CInsBusinessXmgsDao;
import com.jeeplus.modules.xmjbxx.entity.Xmjbxx;
import com.jeeplus.modules.xmjbxx.entity.sub.CInsBusinessXmgs;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 项目公司Service
 *
 * @author zcl
 * @version 2017-10-25
 */
@Service
@Transactional(readOnly = true)
public class CInsBusinessXmgsService extends CrudService<CInsBusinessXmgsDao, CInsBusinessXmgs> {

    public CInsBusinessXmgs get(String id) {
        return super.get(id);
    }

    public List<CInsBusinessXmgs> findList(CInsBusinessXmgs cInsBusinessXmgs) {
        return super.findList(cInsBusinessXmgs);
    }

    public Page<CInsBusinessXmgs> findPage(Page<CInsBusinessXmgs> page, CInsBusinessXmgs cInsBusinessXmgs) {
        return super.findPage(page, cInsBusinessXmgs);
    }

    @Transactional(readOnly = false)
    public void save(CInsBusinessXmgs cInsBusinessXmgs) {
        super.save(cInsBusinessXmgs);
    }

    @Transactional(readOnly = false)
    public void delete(CInsBusinessXmgs cInsBusinessXmgs) {
        super.delete(cInsBusinessXmgs);
    }

    @Transactional(readOnly = false)
    public void saveXmgs(Xmjbxx xmjbxx) {
        CInsBusinessXmgs searchParam = new CInsBusinessXmgs();
        searchParam.setXmjbxx(xmjbxx);
        List<CInsBusinessXmgs> oldList = findList(searchParam);
        for (CInsBusinessXmgs xmgs : xmjbxx.getXmgss()) {
            if (StringUtils.isBlank(xmgs.getXmjbxx().getId())
                    && StringUtils.isBlank(xmgs.getGdmc())
                    && StringUtils.isBlank(xmgs.getXz())
                    && null == xmgs.getCz()
                    && null == xmgs.getBfb()) {
                continue;
            }
            if (StringUtils.isBlank(xmgs.getXmjbxx().getId())
                    || StringUtils.isBlank(xmgs.getGdmc())
                    || StringUtils.isBlank(xmgs.getXz())
                    || null == xmgs.getCz()
                    || null == xmgs.getBfb()) {
                throw new RuntimeException("数据有误！");
            }

            //剔除已保存的对象，剩下来的就是编辑时删除了的
            for (int index = oldList.size() - 1; index >= 0; index--) {
                CInsBusinessXmgs temp = oldList.get(index);
                if (StringUtils.isNoneBlank(xmgs.getId()) && temp.getId().equals(xmgs.getId())) {
                    oldList.remove(temp);
                    break;
                }
            }

            save(xmgs);
        }

        for (CInsBusinessXmgs toRemove : oldList) {
            delete(toRemove);
        }
    }


}