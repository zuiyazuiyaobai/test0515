package com.jeeplus.modules.tools.utils;

public class SwitchColumn {
	/**
	 * 单位性质转换
	 * @param str
	 * @return
	 */
	public static String switchIncType(String str){
		if("1".equals(str)){
			str="政府机关";
		}else if ("2".equals(str)) {
			str="事业单位";
		}else if ("3".equals(str)) {
			str="社会团体";
		}else if ("4".equals(str)) {
			str=("国有及国有控股企业");
		}else if ("5".equals(str)) {
			str="股份制企业";
		}else if ("6".equals(str)) {
			str="集体企业";
		}else if ("7".equals(str)) {
			str="私营企业";
		}else if ("8".equals(str)) {
			str="港澳台及外资企业";
		}else if ("9".equals(str)) {
			str="个体工商户";
		}else if ("10".equals(str)) {
			str="自然人";
		}else if ("11".equals(str)) {
			str="其他";
		}
		return str;
	}
	/**
	 * 重点项目类型(1,基础设施等领域重点项目,2产业转型重点项目,3传统产业升级)
	 * @param str
	 * @return
	 */
	public static String switchZdxmlx(String str){
		if("1".equals(str)){
			str="基础设施等领域重点项目";
		}else if ("2".equals(str)) {
			str="产业转型重点项目";
		}else if ("3".equals(str)) {
			str="传统产业升级";
		}
		return str;
	}
	/**
	 * 产业类型(1高端装备制造,2节能环保产业,3新一代信息技术产业,4生物产业,5新材料产业,6新能源,
	 * 7新能源汽车产业,8岸港网,9铁路,10公路,11水利,12旅游业,13科技创新,14铝工业,15现代煤化工,
	 * 16特色食品,17现代农业,18现代物流,19城乡人居环境,20教育，21燃气，22转型综改示范区建设，
	 * 23现代金融，24商贸会展，25文化旅游，26社会事业，27咨询业等其它服务业，28火力发电，29煤炭，
	 * 30冶金，31其他工业，32机场，33电网，34城乡基础设施建设，35生态治理，36保障性住房)
	 * @param str
	 * @return
	 */
	public static String switchCylx(String str){
		if("1".equals(str)){
			str="高端装备制造";
		}else if ("2".equals(str)) {
			str="节能环保产业";
		}else if ("3".equals(str)) {
			str="新一代信息技术产业";
		}else if ("4".equals(str)) {
			str=("生物产业");
		}else if ("5".equals(str)) {
			str="新材料产业";
		}else if ("6".equals(str)) {
			str="新能源";
		}else if ("7".equals(str)) {
			str="新能源汽车产业";
		}else if ("8".equals(str)) {
			str="岸港网";
		}else if ("9".equals(str)) {
			str="铁路";
		}else if ("10".equals(str)) {
			str="公路";
		}else if ("11".equals(str)) {
			str="水利";
		}else if ("12".equals(str)) {
			str="旅游业";
		}else if ("13".equals(str)) {
			str="科技创新";
		}else if ("14".equals(str)) {
			str="铝工业";
		}else if ("15".equals(str)) {
			str="现代煤化工";
		}else if ("16".equals(str)) {
			str="特色食品";
		}else if ("17".equals(str)) {
			str="现代农业";
		}else if ("18".equals(str)) {
			str="现代物流";
		}else if ("19".equals(str)) {
			str="城乡人居环境";
		}else if ("20".equals(str)) {
			str="教育";
		}else if ("21".equals(str)) {
			str="燃气";
		}else if ("22".equals(str)) {
			str="转型综改示范区建设";
		}else if ("23".equals(str)) {
			str="现代金融";
		}else if ("24".equals(str)) {
			str="商贸会展";
		}else if ("25".equals(str)) {
			str="文化旅游";
		}else if ("26".equals(str)) {
			str="社会事业";
		}else if ("27".equals(str)) {
			str="咨询业等其它服务业";
		}else if ("28".equals(str)) {
			str="火力发电";
		}else if ("29".equals(str)) {
			str="煤炭";
		}else if ("30".equals(str)) {
			str="冶金";
		}else if ("31".equals(str)) {
			str="其他工业";
		}else if ("32".equals(str)) {
			str="机场";
		}else if ("33".equals(str)) {
			str="电网";
		}else if ("34".equals(str)) {
			str="城乡基础设施建设";
		}else if ("35".equals(str)) {
			str="生态治理";
		}else if ("36".equals(str)) {
			str="保障性住房";
		}
		return str;
	}
	/**
	 * 产业类型大类（1.战略性新兴产业,2现代服务业，3现代农业）
	 * @param str
	 * @return
	 */
	public static String switchCylxone(String str){
		if("1".equals(str)){
			str="战略性新兴产业";
		}else if ("2".equals(str)) {
			str="现代服务业";
		}else if ("3".equals(str)) {
			str="现代农业";
		}
		return str;
	}
	/**
	 * 项目申请单位隶属关系：1、县（市、区）属企业；2、省属企业；3、市（州）属企业；4、中央在鄂企业
	 * @param str
	 * @return
	 */
	public static String switchIncrelation(String str){
		if("1".equals(str)){
			str="县（市、区）属企业";
		}else if ("2".equals(str)) {
			str="省属企业";
		}else if ("3".equals(str)) {
			str="市（州）属企业";
		}else if ("4".equals(str)) {
			str="中央在鄂企业";
		}
		return str;
	}
	/**
	 * 项目性质：1、新建；2、扩建；3、改建；4、迁建；5、其他
	 * @param str
	 * @return
	 */
	public static String switchProjectnature(String str){
		if("1".equals(str)){
			str="新建";
		}else if ("2".equals(str)) {
			str="扩建";
		}else if ("3".equals(str)) {
			str="改建";
		}else if ("4".equals(str)) {
			str="迁建";
		}else if ("5".equals(str)) {
			str="其他";
		}
		return str;
	}
	/**
	 * 问题类型（1审批手续，2建设环境，3资金问题，4其他问题）
	 * @param str
	 * @return
	 */
	public static String switchWttype(String str){
		if("1".equals(str)){
			str="审批手续";
		}else if ("2".equals(str)) {
			str="建设环境";
		}else if ("3".equals(str)) {
			str="资金问题";
		}else if ("4".equals(str)) {
			str="其他问题";
		}
		return str;
	}
	/**
	 * 类型选择（1.立项，2环评，3规划，4土地，5其他，6征地，7拆迁，8阻工扰工）
	 * @param str
	 * @return
	 */
	public static String switchStagetype(String str){
		if("1".equals(str)){
			str="立项";
		}else if ("2".equals(str)) {
			str="环评";
		}else if ("3".equals(str)) {
			str="规划";
		}else if ("4".equals(str)) {
			str="土地";
		}else if ("4".equals(str)) {
			str="其他问题";
		}else if ("5".equals(str)) {
			str="其他";
		}else if ("6".equals(str)) {
			str="征地";
		}else if ("7".equals(str)) {
			str="拆迁";
		}else if ("8".equals(str)) {
			str="阻工扰工";
		}
		return str;
	}
	/**
	 * 问题层级(1、国家级,2、省级,3、市级,4、县级)多选、隔开。
	 * @param str
	 * @return
	 */
	public static String switchWtlevel(String str){
		String[] s=str.split(",");
		String string="";
		for(int i=0;i<s.length;i++){
			if("1".equals(s[i])){
				s[i]="国家级";
			}else if ("2".equals(s[i])) {
				s[i]="省级";
			}else if ("3".equals(s[i])) {
				s[i]="市级";
			}else if ("4".equals(s[i])) {
				s[i]="县级";
			}
		}
		for(int j=0;j<s.length;j++){
			string+=s[j]+",";
		}
		return string.substring(0, string.length()-1);
	}
	
}
