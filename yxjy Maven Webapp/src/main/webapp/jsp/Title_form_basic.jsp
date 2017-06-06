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
<link
	href="<%=application.getContextPath()%>/css/plugins/iCheck/custom.css"
	rel="stylesheet">
<link href="<%=application.getContextPath()%>/css/animate.css"
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
		$(function(){
        var ue = UE.getEditor('container');
    });
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
							action="<%=application.getContextPath()%>/home/addTitle.action">
							<div class="form-group">
								<label class="col-sm-1 control-label">标题</label>

								<div class="col-sm-10">
									<input type="text" class="form-control" name="title">
								</div>
							</div>
							<div class="hr-line-dashed"></div>

							<div class="form-group">
								<label class="col-sm-1 control-label">内容</label>

								<div class="col-sm-10">
									<input type="text" placeholder="内容" value=""
										class="form-control" name="content">
								</div>
							</div>
							
							<input type="hidden" name="type" id="type" value="0">
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
	s
	<script
		src="<%=application.getContextPath()%>/js/bootstrap.min.js?v=3.3.6"></script>
	<script type="text/javascript">
		//这段要放在文本编辑器的实例化之后
		$(function() {
			$("#sumbit").click(function(e) {
				if (!um.hasContents()) {
					alert('请先填写内容!');
					e.preventDefault();
					return false;
				} else {
					$("#acontent").val(um.getContent());
					return true;
				}
			})

		})
	</script>
</body>

</html>
