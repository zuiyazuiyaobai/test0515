package com.haike.sms.api.test;

import com.haike.sms.api.beans.SmsActiveBean;
import com.haike.sms.api.beans.SmsRecvBean;
import com.haike.sms.api.beans.SmsRptBean;
import com.haike.sms.api.beans.SmsSendBean;
import com.haike.sms.api.beans.SmsSendRespBean;
import com.haike.sms.api.beans.vo.IdDayBean;
import com.haike.sms.api.beans.vo.MtItemBean;
import com.haike.sms.api.util.ApiConstant;
import com.haike.sms.api.util.StringUtils;
import com.haike.sms.api.util.TokenUtils;
import java.util.ArrayList;
import java.util.List;

public class SMSUtils {
  /*private static String account = "tjtest";

  private static String password = "hhxxttxs";

  private static String apiCode = "tjtest";*/
  private static String account = "yzyh19";

  private static String password = "hhxxttxs";

  private static String apiCode = "yzyh19";
  private static String endpoint = "http://222.143.21.31:8080/web/";

  private static boolean debug = true;

  
  public static String preSendSms(String mobile, String content)
  {
    TokenUtils.getInstance();

    APIClient api = new APIClient();

    api.setTargetEndpoint(endpoint);

    api.setDebug(debug);

    SmsSendBean bean = getSmsSendBean(ApiConstant.OperType_SmsSend, mobile, content);

    SmsSendRespBean respBean = api.sendSms(bean);

    if (!StringUtils.isNotEmpty(respBean.getToken()))
      return "";
    TokenUtils.getInstance().updateToken(respBean.getToken());
    return "200";
  }
  
  public static SmsSendBean getSmsSendBean(String OperType, String tel, String content){
    SmsSendBean bean = new SmsSendBean();

    bean.setToken(TokenUtils.getInstance().getToken());

    bean.setAccount(account);
    bean.setPassword(password);
    bean.setApiCode(apiCode);
    bean.setSnapTime(StringUtils.getSnapTime());

  /* bean.setSendChannel(ApiConstant.SendChannel_ALL);*/

    if (OperType.equalsIgnoreCase(ApiConstant.OperType_SmsSend))
    {
      bean.setOperType(ApiConstant.OperType_SmsSend);

      bean.setMobiles(tel);
      bean.setContent(content);
    }
  /*  else if (OperType.equalsIgnoreCase(ApiConstant.OperType_SmsSendMuli))
    {
      bean.setOperType(ApiConstant.OperType_SmsSendMuli);

      MtItemBean mt1 = new MtItemBean("2345690", "15893731101", "测试短信111");
      MtItemBean mt2 = new MtItemBean("2345691", "13937141818", "测试短信222");

      List smsList = new ArrayList();
      smsList.add(mt1);
      smsList.add(mt2);

      bean.setSmsList(smsList);
    }
*/
    return bean;
  }

  private static SmsRptBean getSmsRptBean()
  {
    SmsRptBean bean = new SmsRptBean();

    bean.setToken(TokenUtils.getInstance().getToken());

    bean.setAccount(account);
    bean.setPassword(password);
    bean.setApiCode(apiCode);
    bean.setSnapTime(StringUtils.getSnapTime());

    bean.setOperType(ApiConstant.OperType_SmsReport);

    IdDayBean id1 = new IdDayBean("2345690", "20150928");
    IdDayBean id2 = new IdDayBean("2345691", "20150928");

    List idList = new ArrayList();
    idList.add(id1);
    idList.add(id2);

    bean.setIdList(idList);

    return bean;
  }

  private static SmsRecvBean getSmsRecvBean()
  {
    SmsRecvBean bean = new SmsRecvBean();

    bean.setToken(TokenUtils.getInstance().getToken());

    bean.setAccount(account);
    bean.setPassword(password);
    bean.setApiCode(apiCode);
    bean.setSnapTime(StringUtils.getSnapTime());

    bean.setOperType(ApiConstant.OperType_SmsReceive);

    bean.setAmount(20);

    return bean;
  }

  private static SmsActiveBean getSmsActiveBean()
  {
    SmsActiveBean bean = new SmsActiveBean();

    bean.setToken(TokenUtils.getInstance().getToken());
    bean.setSnapTime(StringUtils.getSnapTime());

    bean.setOperType(ApiConstant.OperType_SmsActive);

    return bean;
  }
}