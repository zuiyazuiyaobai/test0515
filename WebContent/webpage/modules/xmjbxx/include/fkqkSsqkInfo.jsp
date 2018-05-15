<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp" %>
<html>
<head>
    <title>调度任务管理</title>
    <meta name="decorator" content="default"/>
    <script src="${ctxStatic}/module/alert/jquery.alerts.js"></script>
    <link href="${ctxStatic}/module/alert/jquery.alerts.css" rel="stylesheet" type="text/css"/>
    <style>
    .thtd{
    	style:width:120px;
    }
    .fotd{
    	style:width:200px;
    }
    </style>
    <script type="text/javascript">
		$(function(){
			var ztbxs = ${cinsbusinessssqk.ztbxs};
			if(ztbxs == 100){
				$("#ztbxs").append("公开招标");
			}else if(ztbxs == 101){
				$("#ztbxs").append("邀请招标");
			}else if(ztbxs == 102){
				$("#ztbxs").append("不招标");
			}else if(ztbxs == 103){
				$("#ztbxs").append("公开招标及邀请招标");
			}else{}
			
			var xxjd = ${cinsbusinessssqk.ssqkxxjd};
			if(xxjd == 66){
				$("#xxjd").append("内部装修");
			}else if(xxjd == 1){
				$("#xxjd").append("设备安装");
			}else if(xxjd == 105){
				$("#xxjd").append("交付使用");
			}else if(xxjd == 106){
				$("#xxjd").append("基础开挖");
			}else if(xxjd == 107){
				$("#xxjd").append("正负零");
			}else if(xxjd == 108){
				$("#xxjd").append("主体施工");
			}else if(xxjd == 109){
				$("#xxjd").append("主体封顶");
			}else if(xxjd == 555){
				$("#xxjd").append("试运行");
			}else{}
			
		})
	</script>
</head>
<body class="hideScroll">

<div class="tz_sub" id="fen5" name="inputForm">
    <div><span style="color:#477cb3;font-size:15px;">| 本期调度填报人</span>
        <span id="selectContact" style="margin-left:12px;font-size:14px;color:#EC000A" onclick="openXzlxrDialog()">
                <u>选择联系人</u></span></div>
    <table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
        <tbody>
        <tr>
            <td class="width-20 active" style="width:120px;"><label class="pull-right">姓名：</label>
            </td>
            <td class="width-20" style="width:120px;">${cinsbusinessssqk.name}</td>
            <td class="width-20 active" style="width:120px;"><label class="pull-right">工作单位：</label>
            </td>
            <td class="width-40" style="width:120px;">${cinsbusinessssqk.office}</td>
            <td class="width-20 active" style="width:120px;"><label class="pull-right ">手机：</label>
            </td>
            <td class="width-20" style="width:120px;">${cinsbusinessssqk.mobile}</td>
        </tr>
        </tbody>
    </table>
    <span style="color:#477cb3;font-size:15px;">| 实施信息</span>
    <table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
        <tbody>
        <tr>
            <td class="width-20 active" style="width:200px;"><label class="pull-right">实际开工时间：</label></td>
            <td class="width-30" style="width:200px;">
            	<fmt:formatDate value="${cinsbusinessssqk.sjkgsj}" pattern="yyyy-MM-dd"/>
            </td>
            <td class="width-20 active" style="width:200px;"><label class="pull-right">实际竣工时间：</label>
            </td>
            <td class="width-30" style="width:200px;">
            	<fmt:formatDate value="${cinsbusinessssqk.sjjgsj}" pattern="yyyy-MM-dd"/>
            </td>
        </tr>
        <tr>
            <td class="width-20 active" style="width:200px;"><label class="pull-right"><font
                    color="red">*</font>招投标形式：</label>
            </td>
            <td class="width-30" style="width:200px;" id="ztbxs">
            	
            </td>
            <td class="width-20 active" style="width:200px;"><label class="pull-right">建设单位：</label>
            </td>
            <td class="width-30" style="width:200px;">
            	${cinsbusinessssqk.ssqkjsdw}
            </td>
        </tr>
        </tbody>
    </table>
    <span style="color:#477cb3;font-size:15px;">| 进度详细信息</span>
    <table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
        <tbody>
        <tr>
            <td class="width-20 active" style="width:200px;"><label class="pull-right">年度建设内容：</label></td>
            <td colspan="3" class="width-30" style="width:200px;">
            	${cinsbusinessssqk.ssqkndjsnr}
            </td>
        </tr>
        <tr>
            <td class="width-20 active" style="width:200px;"><label class="pull-right">问题及建议<br>进展情况及下一步工作安排：</label></td>
            <td colspan="3" class="width-30" style="width:200px;">
            	${cinsbusinessssqk.ssqkwtjjy}
            </td>
        </tr>
        <tr>
            <td class="width-20 active" style="width:200px;"><label class="pull-right">投资计划调整情况：</label></td>
            <td colspan="3" class="width-30" style="width:200px;">
            	${cinsbusinessssqk.ssqktzjhtzqk}
            </td>
        </tr>
        <tr>
            <td class="width-20 active" style="width:200px;"><label class="pull-right">形象进度：</label></td>
            <td class="width-30" style="width:200px;" id="xxjd">
            	
            </td>
            <td class="width-20 active" style="width:200px;"><label class="pull-right">日常监管直接责任单位：</label></td>
            <td class="width-30" style="width:200px;">
            	${cinsbusinessssqk.ssqkrcjgzjzrdw}
            </td>
        </tr>
        <tr>
            <td class="width-20 active" style="width:200px;"><label class="pull-right">政府督查机构联系人：</label></td>
            <td class="width-30" style="width:200px;">
            	${cinsbusinessssqk.ssqkzfjcjglxr}
            </td>
            <td class="width-20 active" style="width:200px;"><label class="pull-right">联系方式（手机）：</label></td>
            <td class="width-30" style="width:200px;">
            	${cinsbusinessssqk.ssqkdcjglxfs}
            </td>
        </tr>
        <tr>
            <td class="width-20 active" style="width:200px;"><label class="pull-right">发改部门联系人：</label></td>
            <td class="width-30" style="width:200px;">
            	${cinsbusinessssqk.ssqkfgbmlxr}
            </td>
            <td class="width-20 active" style="width:200px;"><label class="pull-right">联系方式（手机）：</label></td>
            <td class="width-30" style="width:200px;">
            	${cinsbusinessssqk.ssqlfgbmlxfs}
            </td>
        </tr>
        </tbody>
    </table>
    </div>

</body>
</html>