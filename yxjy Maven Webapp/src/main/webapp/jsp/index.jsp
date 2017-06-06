<%@page import="pojo.Product"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>洋县嘉园</title>


<!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

<link rel="shortcut icon" href="favicon.ico">
<link
	href="<%=application.getContextPath()%>/css/bootstrap.min.css?v=3.3.6"
	rel="stylesheet">
<link
	href="<%=application.getContextPath()%>/css/font-awesome.min.css?v=4.4.0"
	rel="stylesheet">
<link href="<%=application.getContextPath()%>/css/animate.css"
	rel="stylesheet">
<link href="<%=application.getContextPath()%>/css/style.css?v=4.1.0"
	rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg"
	style="overflow:hidden">
	<div id="wrapper">
		<!--左侧导航开始-->
		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="nav-close">
				<i class="fa fa-times-circle"></i>
			</div>
			<div class="sidebar-collapse">
				<ul class="nav" id="side-menu">
					<li class="nav-header">
						<div class="dropdown profile-element">
							<span><img alt="image" width="64" height="64"
								class="img-circle"
								src="<%=application.getContextPath()%>/img/logo.png" /> </span> <a
								data-toggle="dropdown" class="dropdown-toggle" href="#"> <span
								class="clear"> <span class="block m-t-xs"> </span><strong
									class="font-bold">超级管理员</strong> <span
									class="text-muted text-xs block">洋县嘉园<b class="caret"></b>
								</span> </span> </a>
							<ul class="dropdown-menu animated fadeInRight m-t-xs">

								<li class="divider"></li>
								<li><a
									href="<%=application.getContextPath()%>/logout.action">安全退出</a>
								</li>
							</ul>
						</div>
						<div class="logo-element">H+</div></li>



					<!--实际菜单-->
					<li><a href="mailbox.html"><i class="fa fa-envelope"></i>
							<span class="nav-label">简介</span> </a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem"
								href="<%=application.getContextPath()%>/article/getJj.action">内容编辑</a>
							</li>
						</ul></li>

					<li><a href="mailbox.html"><i class="fa fa-envelope"></i>
							<span class="nav-label">产品管理</span> </a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem"
								href="<%=application.getContextPath()%>/product/get.action">产品</a>
							</li>

						</ul></li>
					<li><a href="mailbox.html"><i class="fa fa-envelope"></i>
							<span class="nav-label">产品文章</span> </a>
						<ul class="nav nav-second-level">
							<c:forEach items="${product}" var="item">
								<li><a class="J_menuItem"
									href="<%=application.getContextPath()%>/article/getProduct.action?pid=${item.pid}">${item.pname}</a>
								</li>
							</c:forEach>
						</ul></li>


					<li><a href="mailbox.html"><i class="fa fa-envelope"></i>
							<span class="nav-label">农业科普</span> </a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem"
								href="<%=application.getContextPath()%>/article/getKp.action">文章列表</a>
							</li>

						</ul></li>

					<li><a href="mailbox.html"><i class="fa fa-envelope"></i>
							<span class="nav-label">视频</span> </a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem"
								href="<%=application.getContextPath()%>/medid/video.action">视频列表</a>
							</li>

						</ul></li>

					<li><a href="mailbox.html"><i class="fa fa-envelope"></i>
							<span class="nav-label">图库</span> </a>

						<ul class="nav nav-second-level">
							<c:forEach items="${product}" var="item">
								<li><a class="J_menuItem"
									href="<%=application.getContextPath()%>/medid/find.action?pid=${item.pid}&pname=${item.pname}">${item.pname}</a>
								</li>
							</c:forEach>
							<li><a class="J_menuItem"
								href="<%=application.getContextPath()%>/medid/find.action?pid=9999&pname=基地展示">基地展示</a>
							</li>
						</ul></li>


					<li><a href="mailbox.html"><i class="fa fa-envelope"></i>
							<span class="nav-label">首页管理</span> </a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem"
								href="<%=application.getContextPath()%>/home/imgPre.action">图片编辑</a>
							</li>
							<li><a class="J_menuItem"
								href="<%=application.getContextPath()%>/home/titlePre.action">小文章编辑</a>
							</li>
					</li>
					<li><a class="J_menuItem"
						href="<%=application.getContextPath()%>/address/get.action">个人信息编辑</a>
					</li>
				</ul>
				</li>





				</ul>
			</div>
		</nav>
		<!--左侧导航结束-->
		<!--右侧部分开始-->
		<div id="page-wrapper" class="gray-bg dashbard-1">
			<div class="row J_mainContent" id="content-main">
				<iframe class="J_iframe" name="iframe0" width="100%" height="100%"
					src="<%=application.getContextPath()%>/jsp/index_v1.jsp"
					frameborder="0" data-id="index_v1.jsp" seamless></iframe>
			</div>
		</div>
	</div>

	<!-- 全局js -->
	<script
		src="<%=application.getContextPath()%>/js/jquery.min.js?v=2.1.4"></script>
	<script
		src="<%=application.getContextPath()%>/js/bootstrap.min.js?v=3.3.6"></script>
	<script
		src="<%=application.getContextPath()%>/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script
		src="<%=application.getContextPath()%>/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script
		src="<%=application.getContextPath()%>/js/plugins/layer/layer.min.js"></script>

	<!-- 自定义js -->
	<script src="<%=application.getContextPath()%>/js/hplus.js?v=4.1.0"></script>
	<script type="text/javascript"
		src="<%=application.getContextPath()%>/js/contabs.js"></script>

	<!-- 第三方插件 -->
	<script
		src="<%=application.getContextPath()%>/js/plugins/pace/pace.min.js"></script>

</body>

</html>
