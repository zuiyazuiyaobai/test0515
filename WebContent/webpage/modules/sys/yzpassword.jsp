<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>个人信息</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			if(navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)){//如果是移动端，就使用自适应大小弹窗
				width='auto';
				height='auto';
			}else{//如果是PC端，根据用户设置的width和height显示。
				width='700px';
				height='500px';
			}

			
				top.layer.open({
				    type: 2, 
				    area: [width, height],
				    title:"密码验证",
				    content: "${ctx}/sys/user/yzmm" ,
				    btn: ['确定', '关闭'],
				    yes: function(index, layero){
				    	 var body = top.layer.getChildFrame('body', index);
				         var yzpassword = $(body).find('#yzpassword');
				        
				      //	inputForm.submit();
					$.post("${ctx}/sys/user/yzmm2",{yzpassword:$(yzpassword).val()},function(result){
					    if(result==1){
					    	//window.location.href=":http://lsxt.hazw.gov.cn";
					    	window.location.href="http://localhost:8090";
					    }else{
					    	alert("密码错误请重新输入！");
					    }
					});
					},
					  cancel: function(index){ 
		    	       }
				}); 
			});
			
			

		
			
		
	</script>
</head>
<body>

	<body class="gray-bg">
		<div class="wrapper wrapper-content">
	
		</div>
</body>
</html>