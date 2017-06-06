<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>洋县嘉园后台 - 登录</title>
<meta name="keywords" content="洋县嘉园">
<meta name="description" content="洋县嘉园">

<link rel="shortcut icon" href="favicon.ico">
<link
	href="<%=application.getContextPath()%>/css/bootstrap.min.css?v=3.3.6"
	rel="stylesheet">
<link
	href="<%=application.getContextPath()%>/css/font-awesome.css?v=4.4.0"
	rel="stylesheet">

<link href="<%=application.getContextPath()%>/css/animate.css"
	rel="stylesheet">
<link href="<%=application.getContextPath()%>/css/style.css?v=4.1.0"
	rel="stylesheet">
<!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
<script>
	if (window.top !== window.self) {
		window.top.location = window.location;
	}
</script>
</head>

<body class="gray-bg">

	<div class="middle-box text-center loginscreen  animated fadeInDown">
		<div>

			<h3>欢迎登录洋县嘉园后台</h3>
			<h4 style="color:red">${msg}</h4>
			<form class="m-t " style="margin-top:40%" role="form" method="post"
				action="<%=application.getContextPath()%>/login.action">
				<div class="form-group">
					<input type="text" class="form-control" name="uname" placeholder="用户名"
						required="">
				</div>
				<div class="form-group">
					<input type="password" name="pswd" class="form-control" placeholder="密码"
						required="">
				</div>
				<button type="submit" class="btn btn-primary block full-width m-b">登
					录</button>



			</form>
		</div>
	</div>

	<!-- 全局js -->
	<script
		src="<%=application.getContextPath()%>/js/jquery.min.js?v=2.1.4"></script>
	<script
		src="<%=application.getContextPath()%>/js/bootstrap.min.js?v=3.3.6"></script>


</body>

</html>
