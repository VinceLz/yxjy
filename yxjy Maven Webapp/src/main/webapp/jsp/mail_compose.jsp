一<%@ page language="java" pageEncoding="UTF-8"%>
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
<link href="<%=application.getContextPath()%>/css/style.css?v=4.1.0"
	rel="stylesheet">

</head>

<body class="gray-bg">
	<link rel="stylesheet" href="<%=application.getContextPath()%>/ueditor/themes/default/css/ueditor.css">
<!-- 引用jquery -->
<script src="<%=application.getContextPath()%>/ueditor/third-party/jquery-1.10.2.min.js"></script>
<!-- 引入 etpl -->
<!-- 配置文件 -->
<script type="text/javascript" src="<%=application.getContextPath()%>/ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="<%=application.getContextPath()%>/ueditor/ueditor.all.js"></script>
<!-- 语言包文件 -->
<script type="text/javascript" src="<%=application.getContextPath()%>/ueditor/lang/zh-cn/zh-cn.js"></script>

	<!-- 实例化编辑器 -->
	<script type="text/javascript">
		$(function() {
		  var ue = UE.getEditor('container');
		});
	</script>

	<script type="text/javascript">
		//这段要放在文本编辑器的实例化之后
		function uptext(e) {
			if (!um.hasContents()) {
				alert('请先填写内容!');
				return false;
			} else {
				$("#info").val(um.getContent());

				document.setweb.submit();
			}
		}
	</script>
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>首页简介</h5>
					</div>
					<div class="ibox-content">
						<form method="post" class="form-horizontal"
							action="<%=application.getContextPath()%>/article/updateJj.action">

							<div class="form-group">
								<label class="col-sm-1 control-label">合作</label>

								<div class="col-sm-10">
									<textarea rows="4" cols="5" class="form-control" name="tx1">${content.tx1}</textarea>
								</div>
							</div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<label class="col-sm-1 control-label">规模</label>

								<div class="col-sm-10">
									<textarea rows="4" cols="5" class="form-control" name="tx2">${content.tx2}</textarea>
								</div>
							</div>

							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<label class="col-sm-1 control-label">目标</label>

								<div class="col-sm-10">
									<textarea rows="4" cols="5" name="tx3" class="form-control">${content.tx3}</textarea>
								</div>
							</div>

							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<label class="col-sm-1 control-label">文章内容</label>
								<div class="col-sm-10">
									<div id="content">
										<script id="container" name="info" type="text/plain">${content.acontent}
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
	<script
		src="<%=application.getContextPath()%>/js/bootstrap.min.js?v=3.3.6"></script>
</body>

</html>
