/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.xmjbxx.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.xmjbxx.entity.CInsBusinessZdxmk;
import com.jeeplus.modules.xmjbxx.entity.CompanyJbxx;
import com.jeeplus.modules.xmjbxx.entity.Xmjbxx;
import com.jeeplus.modules.xmjbxx.vo.XmjbxxSearchParameter;
import com.jeeplus.modules.xmjbxx.dao.CInsBusinessZdxmkDao;
import com.jeeplus.modules.xmjbxx.dao.CompanyJbxxDao;

/**
 * 其他（省基建5818重点项目）Service
 * @author @zhu
 * @version 2017-12-02
 */
@Service
@Transactional(readOnly = true)
public class CompanyJbxxService extends CrudService<CompanyJbxxDao, CompanyJbxx> {
	//企业信用连接使用
		private JaxWsDynamicClientFactory clientFactory=null;
		private Client clientSubject=null;
		private QName  nameSubject=null;
		private QName  nameSubject2=null;
		private QName  nameSubjectDetail=null;
		private QName  nameSubjectReport=null;
		
	public Map<String,Object>  getqyxyList(String incidtype,String incid,String qymc){
		//如果type为1，2，3就用代码获取信息，如果不为，就用公司名称获取
		if("0".equals(incidtype)){
			incid=incid.replaceAll("-", "");
		}
		return getCompanyJbxxs(incid,qymc);
	};
	//得到并保存
	public Map<String,Object> getCompanyJbxxs(String incid,String qymc){
		Object[] result = null;
		Object[] result2 = null;
		Document doc=null;
		Map<String,Object> companyJbxx=null;
		try {
			clientFactory=JaxWsDynamicClientFactory.newInstance();
			clientSubject= clientFactory.createClient("http://222.143.254.175:8080/subjectCenter/ws/shareDataInterfaceService?wsdl");
			nameSubject2 = new QName("http://subjectcenter.service.hncredit.hnrj.com/", "getSubjectPlus2");
			result = clientSubject.invoke(nameSubject2, "113818E78E8A4A6DA6E8C6A63F9CF49C",incid);
			String xmlStr=result[0].toString();
			doc = DocumentHelper.parseText(xmlStr);
			Element rootElt = doc.getRootElement();
			List<Attribute> listAttr=rootElt.elements();
			if(listAttr.size()!=2){
				companyJbxx=getCompanyJbxx(rootElt);
			}else{
				nameSubject = new QName("http://subjectcenter.service.hncredit.hnrj.com/", "getSubject");
				result2 = clientSubject.invoke(nameSubject, "113818E78E8A4A6DA6E8C6A63F9CF49C",qymc);
				xmlStr=result2[0].toString();
				doc = DocumentHelper.parseText(xmlStr);
				rootElt = doc.getRootElement();
				listAttr=rootElt.elements();
				if(listAttr.size()!=2){
					companyJbxx=getCompanyJbxx(rootElt);
				}else{
					//用公司名称查询也没有
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result[0]);
		return companyJbxx;		
	}
	public Map<String,Object> getCompanyJbxx(Element rootElt){
		Map<String, Object> m=new HashMap<String,Object>();
		if(null!=rootElt.element("id")){
			m.put("id", rootElt.element("id").getTextTrim());
		}
		if(null!=rootElt.element("qymc")){
			m.put("qymc", rootElt.element("qymc").getTextTrim());
		}
		if(null!=rootElt.element("tyshxydm")){
			m.put("tyshxydm", rootElt.element("tyshxydm").getTextTrim());
		}
		if(null!=rootElt.element("zzjgdm")){
			m.put("zzjgdm", rootElt.element("zzjgdm").getTextTrim());
		}
		if(null!=rootElt.element("gsdjm")){
			m.put("yyzzzch", rootElt.element("gsdjm").getTextTrim());//工商登记号存为营业执照
		}
		if(null!=rootElt.element("swdjh")){
			m.put("swdjh", rootElt.element("swdjh").getTextTrim());
		}
		if(null!=rootElt.element("lx")){
			m.put("lx", rootElt.element("lx").getTextTrim());
		}
		if(null!=rootElt.element("hongmdsl")){
			m.put("hongmdsl", rootElt.element("hongmdsl").getTextTrim());
		}
		if(null!=rootElt.element("heimdsl")){
			m.put("heimdsl", rootElt.element("heimdsl").getTextTrim());
		}
		Map<String,Object> map=getCompanyYljl(m.get("id").toString(),m);
		map.put("id", m.get("id").toString());
		map.put("qyxybg", getCompanyXybg(m.get("id").toString()));
		return map;
	}
	//得到企业的信用报告
		public String getCompanyXybg(String id){
			String resultStr=null;
			nameSubjectReport = new QName("http://subjectcenter.service.hncredit.hnrj.com/", "getSubjectReport");
			Object[] result = null;
			Document doc=null;
			try{
				result = clientSubject.invoke(nameSubjectReport, "113818E78E8A4A6DA6E8C6A63F9CF49C",id);
				String xmlStr=result[0].toString();
				doc = DocumentHelper.parseText(xmlStr);
				Element rootElt = doc.getRootElement();
				List<Element> listType=rootElt.elements("success");
				if(listType.get(0).getTextTrim().equals("true")){
					List<Element> listType2=rootElt.elements("info");
					resultStr=listType2.get(0).getTextTrim();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return resultStr;
		}
	//得到企业信誉详情
		public Map<String,Object> getCompanyYljl(String id,Map<String, Object> companyJbxx){
			Map<String, Object> resultMap=new HashMap<String,Object>();
			List<Map<String,Object>> companyYljls=new ArrayList<Map<String,Object>>();
			nameSubjectDetail = new QName("http://subjectcenter.service.hncredit.hnrj.com/", "getSubjectDetail");
			Object[] result = null;
			 Document doc=null;
			 try{
				 result = clientSubject.invoke(nameSubjectDetail, "113818E78E8A4A6DA6E8C6A63F9CF49C",id);
				 String xmlStr=result[0].toString();
				doc = DocumentHelper.parseText(xmlStr);
				Element rootElt = doc.getRootElement();
				List<Element> listType=rootElt.elements("datatype");
				if(listType.size()==2){
					return companyJbxx;
				}
				for(Element e:listType){
					if(e.attribute("name").getValue().equals("基本信息")){
						List<Element> listItem=e.element("data").elements("item");
						resultMap.put("companyJbxx",saveCompanyJbxx(listItem,companyJbxx));
					}
					if(e.attribute("name").getValue().equals("优良信息")){
						List<Element> listeleUnit =e.elements("unit");
						for(Element el:listeleUnit){
							List<Element> ListeleTab=el.elements("table");
							for(Element eleTab:ListeleTab){
								//List<Element> listRow=eleTab.elements();//其中包括一个位置的xml
								List<Element> listRow=eleTab.elements("row");
								for(Element row:listRow){
									Map<String, Object> companyYljl=new HashMap<String,Object>();
									companyYljl.put("xxlx","0");
									companyYljl.put("zlbm", el.attribute("name").getValue());
									companyYljl.put("zlyj", eleTab.attribute("name").getValue());
									String yszlnr1=row.asXML().replaceAll( "<!\\[CDATA\\[","");
									String yszlnr2=yszlnr1.replaceAll( "\\]\\]>","");
									String yszlnr4=yszlnr2.replaceAll("\\n", "");
									companyYljl.put("zlnr", yszlnr4);
									companyYljls.add(companyYljl);
								}
							}
						}
					}
					if(e.attribute("name").getValue().equals("负面信息")){
						List<Element> listeleUnit =e.elements("unit");
						for(Element el:listeleUnit){
							List<Element> ListeleTab=el.elements("table");
							for(Element eleTab:ListeleTab){
								List<Element> listRow=eleTab.elements("row");
								for(Element row:listRow){
									Map<String, Object> companyYljl=new HashMap<String,Object>();
									companyYljl.put("xxlx","1");
									companyYljl.put("zlbm", el.attribute("name").getValue());
									companyYljl.put("zlyj", eleTab.attribute("name").getValue());
									String yszlnr1=row.asXML().replaceAll( "<!\\[CDATA\\[","");
									String yszlnr2=yszlnr1.replaceAll( "\\]\\]>","");
									String yszlnr4=yszlnr2.replaceAll("\\n", "");
									companyYljl.put("zlnr", yszlnr4);
									companyYljls.add(companyYljl);
								}
							}
						}
					}
				}
			 }catch(Exception e){
				 e.printStackTrace();
			 }
			 resultMap.put("companyYljls",companyYljls);
			 return resultMap;
		}
		public Map<String, Object> saveCompanyJbxx(List<Element> listItem,Map<String, Object> companyJbxx)throws Exception{
			for(Element el:listItem){
				if(el.attribute("label").getValue().equals("营业执照注册号")){
					companyJbxx.put("yyzzzch", el.getTextTrim());
				}else
				if(el.attribute("label").getValue().equals("法定代表人")){
					companyJbxx.put("fddbr", el.getTextTrim());
				}else
				if(el.attribute("label").getValue().equals("住所")){
					companyJbxx.put("zs", el.getTextTrim());
				}else
				if(el.attribute("label").getValue().equals("成立日期")){
					SimpleDateFormat simp=new SimpleDateFormat("yyyy-MM-dd");
					if(el.getTextTrim()!=null&&(!el.getTextTrim().equals(""))){
						Date d=simp.parse(el.getTextTrim());
						companyJbxx.put("clrq", el.getTextTrim());
					}
				}else
				if(el.attribute("label").getValue().equals("登记状态")){
					companyJbxx.put("djzt", el.getTextTrim());
				}else
				if(el.attribute("label").getValue().equals("黑名单数量")){
					companyJbxx.put("heimdsl", el.getTextTrim());
				}else
				if(el.attribute("label").getValue().equals("红名单数量")){
					companyJbxx.put("hongmdsl", el.getTextTrim());
				}else
				if(el.attribute("label").getValue().equals("注册资本（万）")){
					companyJbxx.put("zczb", el.getTextTrim());
				}else
				if(el.attribute("label").getValue().equals("经营范围")){
					companyJbxx.put("jyfw", el.getTextTrim());
				}
			}
			return companyJbxx;
		}
}