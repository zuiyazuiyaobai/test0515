package com.jeeplus.modules.log.utils;

import com.jeeplus.common.utils.SpringContextHolder;
import com.jeeplus.modules.log.entity.CInsBusinessLog;
import com.jeeplus.modules.log.service.CInsBusinessLogService;
import com.jeeplus.modules.sys.entity.Office;
import com.jeeplus.modules.sys.entity.User;
import com.jeeplus.modules.sys.utils.UserUtils;

import java.lang.reflect.Method;

/**
 * 业务日志类
 *
 * @author jeeplus
 * @version 2014-11-7
 */
public class BusinessLogUtils {

    private static CInsBusinessLogService logService = SpringContextHolder.getBean(CInsBusinessLogService.class);

    /**
     * 保存业务日志
     * 适用：本级无接收人和接收单位的操作记录
     *
     * @param obj 日志对象
     * @param operate 操作
     * @param type 操作类型
     */
    public static void saveLog(Object obj, String operate, String type) {
        saveLog(obj, operate, type, null);
    }

    /**
     * 保存业务日志
     * 适用：涉及接受部门的，非针对网站用户的操作
     *
     * @param obj 日志对象
     * @param operate 操作
     * @param type 操作类型
     * @param receiveDept 接收单位
     */
    public static void saveLog(Object obj, String operate, String type, Office receiveDept) {
        saveLog(obj, operate, type, null, null, receiveDept);
    }

    /**
     * 保存业务日志
     *
     * @param obj 日志对象
     * @param operate 操作
     * @param type 操作类型
     * @param receiveUser 该次操作接收人对象
     * @param receiveUserName 该次操作接收人姓名，因为只有针对网站申报单位的用户才会产生对用户的操作（receiveUser不为空），而网站的用户信息并没有对接
     *                        到重大库，所以需要吧 xmjbxx 的创建人对象 createBy 和 创建人姓名 createByName 同时写入。
     * @param receiveDept 接收单位
     *
     */
    public static void saveLog(Object obj, String operate, String type, User receiveUser, String receiveUserName, Office receiveDept) {
        User user = UserUtils.getUser();
        if (user != null && user.getId() != null) {
            CInsBusinessLog log = new CInsBusinessLog();
            log.setOperate(operate);
            log.setType(type);
            log.setReceiveUser(receiveUser);
            log.setReceiveUserName(receiveUserName);
            log.setReceiveDept(receiveDept);
            log.setReceiveDeptName(null == receiveDept ? "" : receiveDept.getName());
            // 异步保存日志
            new SaveBusinessLogThread(obj, log).start();
        }
    }

    /**
     * 保存业务日志线程
     */
    public static class SaveBusinessLogThread extends Thread {

        private CInsBusinessLog log;
        private Object obj;

        public SaveBusinessLogThread(Object obj, CInsBusinessLog log) {
            super(SaveBusinessLogThread.class.getSimpleName());
            this.log = log;
            this.obj = obj;
        }

        @Override
        public void run() {
            log.setOperateUser(UserUtils.getUser());
            log.setOperateUserName(UserUtils.getUser().getName());
            log.setOperateDept(UserUtils.getUserOffice());
            log.setOperateDeptName(UserUtils.getUserOffice().getName());
            log.setReceiveDeptName(log.getReceiveOffice() == null ? null : log.getReceiveDept().getName());

            if (null != obj) {
                String id = "";
                for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
                    try {
                        Method getId = superClass.getDeclaredMethod("getId");
                        id = (String) getId.invoke(obj);
                    } catch (Exception e) {//NOSONAR
                        // Method不在当前类定义,继续向上转型
                    }
                    if (!"".equals(id)) {
                        break;
                    }
                }

                log.setObjectName(this.obj.getClass().getSimpleName());
                log.setObjectId(id);
            }

            logService.save(log);
        }
    }
}
