<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>洋县嘉园</title>

<link rel="shortcut icon" href="favicon.ico">
<link
	href="<%=application.getContextPath()%>/css/bootstrap.min.css?v=3.3.6"
	rel="stylesheet">
<link
	href="<%=application.getContextPath()%>/css/font-awesome.css?v=4.4.0"
	rel="stylesheet">
<link href="<%=application.getContextPath()%>/css/animate.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=application.getContextPath()%>/css/plugins/webuploader/webuploader.css">
<link rel="stylesheet" type="text/css"
	href="<%=application.getContextPath()%>/css/demo/webuploader-demo.css">
<link href="<%=application.getContextPath()%>/css/style.css?v=4.1.0"
	rel="stylesheet">


</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeIn">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">

					<div class="ibox-content">
						<h2>${pname}</h2>
					</div>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>百度Web Uploader</h5>

					</div>

					<div class="ibox-content">
						<div class="page-container">
							<p>您可以尝试文件拖拽，使用QQ截屏工具，然后激活窗口后粘贴，或者点击添加图片按钮</p>
							<div id="uploader" class="wu-example">
								<div class="queueList">
									<div id="dndArea" class="placeholder">
										<div id="filePicker"></div>
										<p>或将照片拖到这里，单次最多可选300张</p>
									</div>
								</div>
								<div class="statusBar" style="display:none;">
									<div class="progress">
										<span class="text">0%</span> <span class="percentage"></span>
									</div>
									<div class="info"></div>
									<div class="btns">
										<div id="filePicker2"></div>
										<div class="uploadBtn">开始上传</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- 全局js -->
	<script
		src="<%=application.getContextPath()%>/js/jquery.min.js?v=2.1.4"></script>
	<script
		src="<%=application.getContextPath()%>/js/bootstrap.min.js?v=3.3.6"></script>

	<!-- Web Uploader -->
	<script type="text/javascript">
        // 添加全局站点信息
        var BASE_URL = '<%=application.getContextPath()%>'+ '/js/plugins/webuploader';
        var pname='${pname}';
        var pid='${pid}';
        var httpserver='<%=application.getContextPath()%>'+'/medid/upload.action'
	</script>
	<script
		src="<%=application.getContextPath()%>/js/plugins/webuploader/webuploader.min.js"></script>

	<script
		src="<%=application.getContextPath()%>/js/demo/webuploader-demo.js"></script>

	
</body>

</html>

