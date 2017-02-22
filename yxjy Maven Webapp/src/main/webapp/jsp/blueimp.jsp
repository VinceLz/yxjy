<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>H+ 后台主题UI框架 - Blueimp相册</title>
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
<link
	href="<%=application.getContextPath()%>/css/plugins/blueimp/css/blueimp-gallery.min.css"
	rel="stylesheet">

<link href="<%=application.getContextPath()%>/css/animate.css"
	rel="stylesheet">
<link href="<%=application.getContextPath()%>/css/style.css?v=4.1.0"
	rel="stylesheet">

<style>
.lightBoxGallery img {
	margin: 5px;
	width: 160px;
	height: 160px;
}

.lightBoxGallery div {
	float: left;
}

.a {
	display: block;
}

.b {
	margin-left: 5px;
	text-align: center;
}
</style>

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content">
		<div class="row">
			<div class="col-lg-12">
				<div class="ibox float-e-margins">

					<div class="ibox-content">

						<h2>${pname}</h2>
						<div class="">
							<a onclick=""
								href="<%=application.getContextPath()%>/medid/upPre.action?pname=${pname}&pid=${pid}"
								class="btn btn-primary ">上传新图片</a>
						</div>


						<div class="lightBoxGallery">

							<c:forEach items="${list}" var="item">
								<div>
									<a href="<%=application.getContextPath()%>${item.url}"
										title="图片" data-gallery="" class="a"> <img
										src="<%=application.getContextPath()%>${item.url}"> <a
										class="b btn btn-danger btn-xs "
										href="<%=application.getContextPath()%>/medid/delete.action?mid=${item.mid}">删除</a>
									</a>
								</div>
							</c:forEach>



							<div id="blueimp-gallery" class="blueimp-gallery">
								<div class="slides"></div>
								<h3 class="title"></h3>
								<a class="prev">‹</a> <a class="next">›</a> <a class="close">×</a>
								<a class="play-pause"></a>
								<ol class="indicator"></ol>
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



	<!-- blueimp gallery -->
	<script
		src="<%=application.getContextPath()%>/js/plugins/blueimp/jquery.blueimp-gallery.min.js"></script>
</body>

</html>
