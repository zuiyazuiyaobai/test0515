<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <title>河南省投资项目在线管理系统</title>

	<%@ include file="/webpage/include/acehead.jsp"%>
	<script src="${ctxStatic}/common/inspinia-ace.js?v=3.2.0"></script>
	<script src="${ctxStatic}/common/contabs.js"></script> 
 	<meta name="keywords" content="管理系统">
    <meta name="description" content="管理系统">
<style>
	.t2_nav{ position: absolute;top:0;right: 0;}
</style>
</head>

<body class="no-skin">
		<!-- #section:basics/navbar.layout -->
		<div id="navbar" class="navbar navbar-default">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>
	<div style="height:244px;width:300px;padding:20px;display:none;" id='tcxx' >
		<!-- <p style="word-wrap: break-word;word-break:break-all;overflow:hidden;padding-left:30px;">111</p> -->
		<div onclick="towsh()" style="cursor:pointer;padding-left:30px;color:#FF0000" ><span id="shxm"></span></div>
		<br>
		<div onclick="towdd()" style="cursor:pointer;padding-left:30px;color:#FF0000"><span id="dbxm"></span></div>
	</div>
  	<script type="text/javascript">
  	
  	function towsh(){
  	
  		window.location.href="${ctx}/xmjbxx/xmjbxx/cbxmShqList";
  	}
  	function towdd(){
  		window.location.href="${ctx}/task/cInsBusinessXmjbxxTaskRelation/myTaskList";
  	}
  	
  	</script>

			<div class="navbar-container" id="navbar-container">
				<!-- #section:basics/sidebar.mobile.toggle -->
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>

				<!-- /section:basics/sidebar.mobile.toggle -->
				<div class="navbar-header pull-left">
					<!-- #section:basics/navbar.layout.brand -->
					<a href="#" class="navbar-brand" style="font-size: 36px;margin-top: 30px;">
						<%--<small>--%>
							<%--<i class="fa fa-leaf"></i>--%>
							管理系统
						<%--</small>--%>
					</a>

					<!-- /section:basics/navbar.layout.brand -->

					<!-- #section:basics/navbar.toggle -->

					<!-- /section:basics/navbar.toggle -->
				</div>

				<!-- #section:basics/navbar.dropdown -->
				<div class="navbar-buttons navbar-header pull-right t2_nav" role="navigation">
					<ul class="nav ace-nav">
					<%-- <!--一级菜单靠右浮动展示  -->
					<c:forEach items="${fns:getMenuListByParentId('0')}" var="menu"
						varStatus="status">
						<li class="light-blue" style="margin-top:30px;"><a
							<c:if test="${not empty menu.href}"> href="${ctx}/${menu.href}" target="_blank" </c:if>
							<c:if test="${ empty menu.href}"> href="javascript:void(0)" onclick="changemenu('${menu.id}')"</c:if>>
								<span>${menu.name}</span>
						</a></li>
						<c:if test="${!status.last}">
							<li><img src="${theme}/assets/images/line.png" align=""></li>
						</c:if>
						
					</c:forEach> --%>
						<%--<li class="grey">
							<a id="lang-switch" class="lang-selector dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="true">
								<span class="lang-selected">
										<img  class="lang-flag" src="${ctxStatic}/common/img/china.png" alt="中国">
										<span class="lang-id">中国</span>
										<span class="lang-name">中文</span>
									</span>
							</a>

							<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="ace-icon fa fa-check"></i>
									选择国家语言
								</li>

								<li class="dropdown-content">
									<ul class="dropdown-menu dropdown-navbar">
										<li>
											<a href="#" class="lang-select">
												<img class="lang-flag" src="${ctxStatic}/common/img/china.png" alt="中国">
												<span class="lang-id">中国</span>
												<span class="lang-name">中文</span>
											</a>
										</li>

										<li>
											<a href="#" class="lang-select">
												<img class="lang-flag" src="${ctxStatic}/common/img/united-kingdom.png" alt="English">
												<span class="lang-id">EN</span>
												<span class="lang-name">English</span>
											</a>
										</li>
										
										<li>
											<a href="#" class="lang-select">
												<img class="lang-flag" src="${ctxStatic}/common/img/france.png" alt="France">
												<span class="lang-id">FR</span>
												<span class="lang-name">Français</span>
											</a>
										</li>
										<li>
											<a href="#" class="lang-select">
												<img class="lang-flag" src="${ctxStatic}/common/img/germany.png" alt="Germany">
												<span class="lang-id">DE</span>
												<span class="lang-name">Deutsch</span>
											</a>
										</li>
										<li>
											<a href="#" class="lang-select">
												<img class="lang-flag" src="${ctxStatic}/common/img/italy.png" alt="Italy">
												<span class="lang-id">IT</span>
												<span class="lang-name">Italiano</span>
											</a>
										</li>
										<li>
											<a href="#" class="lang-select">
												<img class="lang-flag" src="${ctxStatic}/common/img/spain.png" alt="Spain">
												<span class="lang-id">ES</span>
												<span class="lang-name">Español</span>
											</a>
										</li>
									</ul>
								</li>

								<li class="dropdown-footer">
								</li>
							</ul>
						</li>--%>

						<%--<li class="purple">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-bell icon-animated-bell"></i>
								<span class="badge badge-important">${count }</span>
							</a>

							<ul class="dropdown-menu-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="ace-icon fa fa-exclamation-triangle"></i>
									${count } 条未读消息
								</li>

								<li class="dropdown-content">
									<ul class="dropdown-menu dropdown-navbar navbar-pink">

										  <c:forEach items="${page.list}" var="oaNotify">
										  	<li>
					                            <a class="J_menuItem" href="${ctx}/oa/oaNotify/view?id=${oaNotify.id}&">
					                                        <div class="clearfix">
					                                            <i class="fa fa-envelope fa-fw"></i> ${fns:abbr(oaNotify.title,50)}
					                                            <span class="pull-right text-muted small">${fns:getTime(oaNotify.updateDate)}前</span>
					                                        </div>
					                             </a>
					                        </li>
										</c:forEach>
									</ul>
								</li>

								<li class="dropdown-footer">
									 <a class="J_menuItem" href="${ctx }/oa/oaNotify/self ">
										查看所有
										<i class="ace-icon fa fa-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>

						<li class="green">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-envelope icon-animated-vertical"></i>
								<span class="badge badge-success">${noReadCount}</span>
							</a>

							<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="ace-icon fa fa-envelope-o"></i>
									${noReadCount} 未读邮件
								</li>

								<li class="dropdown-content">
									<ul class="dropdown-menu dropdown-navbar">
										 <c:forEach items="${mailPage.list}" var="mailBox">
			                               	<li>
											<a href="#" class="clearfix">
												<img src="${mailBox.sender.photo }" class="msg-photo" alt="${mailBox.sender.name }的邮件" />
												<span class="msg-body">
													<span class="msg-title">
														<span class="blue">${mailBox.sender.name }:</span>
														<a class="J_menuItem" href="${ctx}/iim/mailBox/detail?id=${mailBox.id}">
			                                             ${mailBox.mail.overview}
			                                            </a>
													</span>

													<span class="msg-time">
														<i class="ace-icon fa fa-clock-o"></i>
														<span><fmt:formatDate value="${mailBox.sendtime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
													</span>
												</span>
											</a>
										</li>
		                                </c:forEach>


									</ul>
								</li>


							 	<li class="dropdown-footer">
		                              <a class="J_menuItem" href="${ctx}/iim/mailBox/list?orderBy=sendtime desc">
		                                       	查看所有邮件<i class="ace-icon fa fa-arrow-right"></i>
		                              </a>
		                      	</li>
							</ul>
						</li>--%>

						<!-- #section:basics/navbar.user_menu -->
						<li class="light-blue" style="margin-top: 30px;">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="${fns:getUser().photo}" alt="photo" />
								<span class="user-info">
									<small>欢迎,</small>
									${fns:getUser().name}
								</span>

								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a class="J_menuItem" href="${ctx}/sys/user/imageEdit">
										<i class="ace-icon fa fa-cog"></i>
										修改头像
									</a>
								</li>

								<li>
									<a class="J_menuItem" href="${ctx }/sys/user/info">
										<i class="ace-icon fa fa-user"></i>
										个人资料
									</a>
								</li>

                                <%--<li>
                                	<a class="J_menuItem" href="${ctx }/iim/contact/index">
                                	<i class="ace-icon fa fa-indent"></i>
                                	我的通讯录
                                	</a>
                                </li>
                                <li>
                                	<a class="J_menuItem" href="${ctx }/iim/mailBox/list">
                                		<i class="ace-icon fa fa-inbox"></i>
                                	信箱</a>
                                </li> --%>
                                 <%--<li class="divider"></li>
                                <li><a href="#" onclick="changeStyle()">
                                	<i class="ace-icon fa  fa-mail-reply"></i>
                                	切换到经典模式</a>
                                </li>--%>


								<%-- <li class="divider"></li>

								<li>
									<a class="J_menuItem" href="${ctx}/logout">
										<i class="ace-icon fa fa-power-off"></i>
										安全退出
									</a>
								</li> --%>
							</ul>
						</li>

						<!-- /section:basics/navbar.user_menu -->
					</ul>
				</div>

				<!-- /section:basics/navbar.dropdown -->
			</div><!-- /.navbar-container -->
		</div>

		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<!-- #section:basics/sidebar -->
			<div id="sidebar" class="sidebar                  responsive">
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
				</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success">
							<i class="ace-icon fa fa-signal"></i>
						</button>

						<button class="btn btn-info">
							<i class="ace-icon fa fa-pencil"></i>
						</button>

						<!-- #section:basics/sidebar.layout.shortcuts -->
						<button class="btn btn-warning">
							<i class="ace-icon fa fa-users"></i>
						</button>

						<button class="btn btn-danger">
							<i class="ace-icon fa fa-cogs"></i>
						</button>

						<!-- /section:basics/sidebar.layout.shortcuts -->
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span>

						<span class="btn btn-info"></span>

						<span class="btn btn-warning"></span>

						<span class="btn btn-danger"></span>
					</div>
				</div><!-- /.sidebar-shortcuts -->

						 <t:aceMenu  menu="${fns:getTopMenu()}"></t:aceMenu> 
		<!--二级菜单  -->
	   <%-- <c:forEach items="${fns:getMenuListByParentId('0')}" var="menu1" varStatus="status1">
				   <span id="menuone${menu1.id}" menuone="menuone"
					<c:if test="${status1.index!=0}"> style="display:none; overflow: auto;"</c:if>
					style="overflow: auto;"> 
					<t:aceMenu menu="${menu1}"></t:aceMenu>
				</span> 
	  </c:forEach> --%>

				<!-- #section:basics/sidebar.layout.minimize -->
				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>

				<!-- /section:basics/sidebar.layout.minimize -->
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
				</script>
			</div>

			<!-- /section:basics/sidebar -->
			<div class="main-content">
				<div class="main-content-inner">
					<!-- #section:basics/content.breadcrumbs -->
					<div class="breadcrumbs" id="breadcrumbs">
				  <div class="content-tabs">
                <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
                </button>
                <nav class="page-tabs J_menuTabs">
                    <div class="page-tabs-content">
                         <a href="javascript:;" class="active J_menuTab" data-id="${ctx}/home">首页</a>
                    </div>
                </nav>
                <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
                </button>
                <div class="btn-group roll-nav roll-right">
                    <button class="dropdown J_tabClose"  data-toggle="dropdown">关闭操作<span class="caret"></span>

                    </button>
                    <ul role="menu" class="dropdown-menu dropdown-menu-right">
                        <li class="J_tabShowActive"><a>定位当前选项卡</a>
                        </li>
                        <li class="divider"></li>
                        <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                        </li>
                        <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                        </li>
                    </ul>
                </div>
                <a href="${ctx}/logout" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
            	</div>
					</div>

			<div class="J_mainContent"  id="content-main">
			
				<script type="text/javascript">
					$(document).ready(

					function() {
						//yjtsxx();
					});
					  function yjtsxx() {
					  debugger;
						var url = "${ctx}/login/getCountTsxx";
						
						$.post(url, function(data) {
							var resultStr=data;
							var results= resultStr.split(";");
						
							$("#shxm").html("需要审核的项目个数：("+results[0]+")");
							$("#dbxm").html("需要督办的调度任务个数：("+results[1]+")");
							
							 layer.open({
								title : "您有新消息",
								type : 1,
								area : [ '300px', '200px' ],
								fix : false, //不固定
								scrollbar : true,//禁用滚动条
								shadeClose : true,
								content :$("#tcxx").html(),
								shade : 0,
								offset : 'rb',
								maxmin : false
							});
						});
					}
				</script>	
			
             <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="${ctx}/home" frameborder="0" data-id="${ctx}/home" seamless></iframe>
            </div>
            </div>
            
            
            </div>
            
            <%--<div class="footer">
				<div class="footer-inner">
					<!-- #section:basics/footer -->
					<div class="footer-content">
						&lt;%&ndash;<span class="bigger-120">&ndash;%&gt;
							&lt;%&ndash;<span class="blue bolder">JeePlus</span>&ndash;%&gt;
							 &copy; 2015-2020
						&lt;%&ndash;</span>&ndash;%&gt;

						&lt;%&ndash;&nbsp; &nbsp;
						<span class="action-buttons">
							<a href="#">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
							</a>
						</span>&ndash;%&gt;
					</div>

					<!-- /section:basics/footer -->
				</div>
			</div>--%>

			<a href="#" id="btn-scroll-up" class="pull-left btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
			
            </div>
            
            
            
				

	</body>
	<!-- 语言切换插件，为国际化功能预留插件 -->
	<script type="text/javascript">
	
	$(document).ready(function(){
	
		$("a.lang-select").click(function(){
			$(".lang-selected").find(".lang-flag").attr("src",$(this).find(".lang-flag").attr("src"));
			$(".lang-selected").find(".lang-flag").attr("alt",$(this).find(".lang-flag").attr("alt"));
			$(".lang-selected").find(".lang-id").text($(this).find(".lang-id").text());
			$(".lang-selected").find(".lang-name").text($(this).find(".lang-name").text());
	
		});
	
	
	});

	
	function changeStyle(){
		   $.get('${pageContext.request.contextPath}/theme/default?url='+window.top.location.href,function(result){ window.location.reload();  });
		  

		}
	</script>
	<script type="text/javascript">

	function changeStyle() {
	}
	
	function changemenu(parentMenuId) {
		$("[menuone='menuone']").each(function() {
			// var _this = $(this);
			$(this).hide();
		});
		$("#menuone" + parentMenuId).show();
	}     
	
	function index(){
	 $("#iframe").show().siblings('.J_iframe').hide();
	 //$("#iframe",top.document.body).attr("src","${ctx}/home")
	  //alert(window.frames);
	 // alert("3333:"+window.frames.length);
	//  document.getElementById('iframe').contentWindow.location.reload(true);
	  document.getElementById('iframe').contentWindow.location.href="${ctx}/home";
	   $(".breadcrumb").html("<li><i class=\"icon-home home-icon\"></i> <a href=\"/a/home\" target=\"iframe\">首页</a></li>");
	}
   //加一个通用的请求  解决 <a href="url" target="iframe"></a> 会在新窗口打开
	function doAction(url){
	  document.getElementById('iframe').contentWindow.location.href=url;
	}
	
</script>
<!-- 即时聊天插件  开始-->
<%--<link href="${ctxStatic}/layer-v2.3/layim/layui/css/layui.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript">
var currentId = '${fns:getUser().loginName}';
var currentName = '${fns:getUser().name}';
var currentFace ='${fns:getUser().photo}';
var url="${ctx}";
var static_url="${ctxStatic}";
var wsServer = 'ws://'+window.document.domain+':8668'; 

</script>--%>
<!--webscoket接口  -->
<%--<script src="${ctxStatic}/layer-v2.3/layim/layui/layui.js"></script>--%>

<%--<script src="${ctxStatic}/layer-v2.3/layim/layim.js"></script>--%>
<!-- 即时聊天插件 结束 -->
<style>
/*签名样式*/
.layim-sign-box{
	width:95%
}
.layim-sign-hide{
  border:none;background-color:#F5F5F5;
}
</style>
</html>