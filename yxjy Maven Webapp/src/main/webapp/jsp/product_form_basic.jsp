<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>H+ 后台主题UI框架 - 基本表单</title>
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
	href="<%=application.getContextPath()%>/css/plugins/iCheck/custom.css"
	rel="stylesheet">
<link href="<%=application.getContextPath()%>/css/animate.css"
	rel="stylesheet">
<link href="<%=application.getContextPath()%>/css/style.css?v=4.1.0"
	rel="stylesheet">

</head>

<body class="gray-bg">


	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>发布新文章</h5>
					</div>
					<div class="ibox-content">
						<form method="post" class="form-horizontal" enctype="multipart/form-data"
							action="<%=application.getContextPath()%>/product/add.action">
							<div class="form-group">
								<label class="col-sm-1 control-label">产品名</label>

								<div class="col-sm-10">
									<input type="text" class="form-control" name="pname">
								</div>
							</div>
							<div class="hr-line-dashed"></div>

							<div class="form-group">
								<label class="col-sm-1 control-label">产品说明</label>

								<div class="col-sm-10">
									<input type="text"  value=""
										class="form-control" name="pdesc">
								</div>
							</div>
							<div class="hr-line-dashed"></div>
							
							
							<div class="form-group">
								<label class="col-sm-1 control-label">购买链接</label>

								<div class="col-sm-10">
									<input type="text"  value=""
										class="form-control" name="ppay">
								</div>
							</div>
							<div class="hr-line-dashed"></div>
							
							
							<div class="form-group">
								<label class="col-sm-1 control-label">产品图片</label>

								<div class="col-sm-10">
									<input type="file"  value=""
										class="form-control" name="file">
								</div>
							</div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<div class="col-sm-3 col-sm-offset-10">
									<button onclick="uptext(this);" class="btn btn-primary"
										type="submit" id="sumbit">保存内容</button>
									<button class="btn btn-white" type="submit">取消</button>
								</div>
							</div>
						</form>
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
	
</body>

</html>
