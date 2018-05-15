package com.haike.sms.api.test;

import com.haike.sms.api.beans.SmsActiveBean;
import com.haike.sms.api.beans.SmsActiveRespBean;
import com.haike.sms.api.beans.SmsRecvBean;
import com.haike.sms.api.beans.SmsRecvRespBean;
import com.haike.sms.api.beans.SmsRptBean;
import com.haike.sms.api.beans.SmsRptRespBean;
import com.haike.sms.api.beans.SmsSendBean;
import com.haike.sms.api.beans.SmsSendRespBean;
import com.haike.sms.api.util.ApiConstant;
import com.haike.sms.api.util.ApiXmlHelper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;

public class APIClient
{
  private String targetEndpoint = "";

  private String mt = "sms/api/misc.do?mt";
  private String mo = "sms/api/misc.do?mo";
  private String rpt = "sms/api/misc.do?rpt";
  private String active = "sms/api/misc.do?active";

  private boolean debug = false;

  public SmsSendRespBean sendSms(SmsSendBean bean)
  {
    String actionUrl = this.targetEndpoint + this.mt;

    String xml = ApiXmlHelper.toXml(bean);
    if (isDebug())
    {
      System.out.println("Request  Xml:" + xml);
    }

    String respXml = sendPostXml(actionUrl, xml);
    if (isDebug())
    {
      System.out.println("Response Xml:" + respXml);
    }

    SmsSendRespBean respBean = ApiXmlHelper.xmlToSmsSendRespBean(respXml);

    return respBean;
  }

  public SmsRptRespBean recvRpt(SmsRptBean bean)
  {
    String actionUrl = this.targetEndpoint + this.rpt;

    String xml = ApiXmlHelper.toXml(bean);
    if (isDebug())
    {
      System.out.println("Request  Xml:" + xml);
    }

    String respXml = sendPostXml(actionUrl, xml);
    if (isDebug())
    {
      System.out.println("Response Xml:" + respXml);
    }

    SmsRptRespBean respBean = ApiXmlHelper.xmlToSmsRptRespBean(respXml);

    return respBean;
  }

  public SmsRecvRespBean recvSms(SmsRecvBean bean)
  {
    String actionUrl = this.targetEndpoint + this.mo;

    String xml = ApiXmlHelper.toXml(bean);
    if (isDebug())
    {
      System.out.println("Request  Xml:" + xml);
    }

    String respXml = sendPostXml(actionUrl, xml);
    if (isDebug())
    {
      System.out.println("Response Xml:" + respXml);
    }

    SmsRecvRespBean respBean = ApiXmlHelper.xmlToSmsRecvRespBean(respXml);

    return respBean;
  }

  public SmsActiveRespBean sendActive(SmsActiveBean bean)
  {
    String actionUrl = this.targetEndpoint + this.active;

    String xml = ApiXmlHelper.toXml(bean);
    if (isDebug())
    {
      System.out.println("Request  Xml:" + xml);
    }

    String respXml = sendPostXml(actionUrl, xml);
    if (isDebug())
    {
      System.out.println("Response Xml:" + respXml);
    }

    SmsActiveRespBean respBean = ApiXmlHelper.xmlToSmsActiveRespBean(respXml);

    return respBean;
  }

  private String sendPostXml(String urlStr, String params)
  {
    OutputStream out = null;
    BufferedReader in = null;
    StringBuffer result = new StringBuffer();
    try
    {
      URL realUrl = new URL(urlStr);

      URLConnection conn = realUrl.openConnection();

      conn.setConnectTimeout(15000);
      conn.setReadTimeout(20000);

      conn.setRequestProperty("Accept", "*/*");
      conn.setRequestProperty("Content-Type", "text/xml");
      conn.setRequestProperty("Connection", "Keep-Alive");
      conn.setRequestProperty("User-Agent", "HaikeSoft/API MISC/V" + ApiConstant.ApiVersion + " (KHTML, like Gecko)");

      conn.setDoOutput(true);
      conn.setDoInput(true);

      out = conn.getOutputStream();

      out.write(params.getBytes("UTF-8"));

      out.flush();

      in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
      String line = "";
      while ((line = in.readLine()) != null)
      {
        result.append(line);
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    finally
    {
      try
      {
        if (out != null)
        {
          out.close();
          out = null;
        }
        if (in != null)
        {
          in.close();
          in = null;
        }
      }
      catch (Exception ex)
      {
        System.out.println(ex);
      }
    }

    return result.toString();
  }

  public boolean isDebug()
  {
    return this.debug;
  }

  public void setDebug(boolean debug)
  {
    this.debug = debug;
  }

  public String getTargetEndpoint()
  {
    return this.targetEndpoint;
  }

  public void setTargetEndpoint(String targetEndpoint)
  {
    this.targetEndpoint = targetEndpoint;
  }
}