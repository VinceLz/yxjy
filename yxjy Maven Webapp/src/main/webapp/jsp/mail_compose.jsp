<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>H+ 后台主题UI框架 - 写信</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
<link rel="shortcut icon" href="favicon.ico">
<link
	href="<%=application.getContextPath()%>/css/bootstrap.min.css?v=3.3.6"
	rel="stylesheet">
<link
	href="<%=application.getContextPath()%>/css/font-awesome.css?v=4.4.0"
	rel="stylesheet">
<link href="<%=application.getContextPath()%>/css/style.css?v=4.1.0"
	rel="stylesheet">

</head>

<body class="gray-bg">

	<!-- 配置文件 -->
	<script type="text/javascript"
		src="<%=application.getContextPath()%>/ueditor/ueditor.config.js"></script>
	<!-- 编辑器源码文件 -->
	<script type="text/javascript"
		src="<%=application.getContextPath()%>/ueditor/ueditor.all.js"></script>
	<!-- 实例化编辑器 -->
	<script type="text/javascript">
		var ue = UE.getEditor('container');
	</script>

	<script type="text/javascript">
		//这段要放在文本编辑器的实例化之后
		function uptext(e) {
			if (!ue.hasContents()) {
				alert('请先填写内容!');
				return false;
			} else {
				$("#info").val(ue.getContent());
				alert($("#info").val());
				document.setweb.submit();
			}
		}
	</script>

	<div class="wrapper wrapper-content">
		<div class="row">
			<div class="col-sm-9 animated fadeInRight">
				<div class="mail-box-header">
					简介内容
					</h2>
				</div>
				<form
					action="<%=application.getContextPath()%>/article/updateJj.action"
					method="post">
					<div class="mail-box">
						<div class="mail-text h-200">
							<div id="content">
								<script id="container" name="content" type="text/plain">${content.acontent}
    			</script>
							</div>
							<input name="info" type="hidden" id="info">
							<div class="clearfix"></div>
						</div>
						<div class="mail-body text-right tooltip-demo">
							<button class="btn btn-sm btn-primary" data-toggle="tooltip"
								onClick="uptext(this);" data-placement="top" title="Send">
								<i class="fa fa-reply"></i> 保存
							</button>

						</div>
						<div class="clearfix"></div>
					</div>
			</div>
		</div>
	</div>
	<!-- 全局js -->
	<script
		src="<%=application.getContextPath()%>/js/jquery.min.js?v=2.1.4"></script>
	<script
		src="<%=application.getContextPath()%>/js/bootstrap.min.js?v=3.3.6"></script>
</body>

</html>
