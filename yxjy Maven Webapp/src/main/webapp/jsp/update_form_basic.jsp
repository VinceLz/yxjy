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


	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>发布新文章</h5>
					</div>
					<div class="ibox-content">
						<form method="post" class="form-horizontal"
							action="<%=application.getContextPath()%>/article/update.action">
							<div class="form-group">
								<label class="col-sm-1 control-label">标题</label>

								<div class="col-sm-10">
									<input type="text" class="form-control" name="atitle"
										value="${article.atitle}">
								</div>
							</div>
							<div class="hr-line-dashed"></div>

							<div class="form-group">
								<label class="col-sm-1 control-label">发布者</label>

								<div class="col-sm-10">
									<input type="text" placeholder="默认是管理员"
										value="${article.author}" class="form-control" name="author">
								</div>
							</div>
							<input type="hidden" name="aid" value="${article.aid}">

							
							<c:if test="${article.type eq 0 }">
							<div class="hr-line-dashed"></div>
								<div class="form-group">
									<label class="col-sm-1 control-label">所属产品</label>

									<div class="col-sm-10">
										<select class="form-control m-b" name="product">
											<c:forEach items="${list}" var="item">
												<option
													<c:if test="${article.pid eq item.pid}">checked</c:if>
													value="${item.pid},${item.pname}">${item.pname}</option>
											</c:forEach>
										</select>

									</div>
								</div>
							</c:if>
							<input type="hidden" name="acontent" id="acontent">
							<input type="hidden" name="type" id="type" value="${article.type}">
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<label class="col-sm-1 control-label">文章内容</label>
								<div class="col-sm-10">
									<div id="content">
										<script id="container" name="content" type="text/plain">${article.acontent}
    									</script>
									</div>
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
	<script type="text/javascript">
		//这段要放在文本编辑器的实例化之后
		$(function() {
			$("#sumbit").click(function(e) {
				if (!ue.hasContents()) {
					alert('请先填写内容!');
					e.preventDefault();
					return false;
				} else {
					$("#acontent").val(ue.getContent());
					return true;
				}
			})

		})
	</script>
</body>

</html>
