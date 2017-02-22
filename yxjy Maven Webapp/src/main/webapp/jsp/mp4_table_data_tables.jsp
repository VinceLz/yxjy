<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>H+ 后台主题UI框架 - 数据表格</title>
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

<!-- Data Tables -->
<link
	href="<%=application.getContextPath()%>/css/plugins/dataTables/dataTables.bootstrap.css"
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

					<div class="ibox-content">
						<div class="">
							<a onclick=""
								href="<%=application.getContextPath()%>/jsp/mp4_form_basic.jsp"
								class="btn btn-primary ">发布</a>
						</div>
						<table
							class="table table-striped table-bordered table-hover dataTables-example">
							<thead>
								<tr>
									<th>标题</th>
									<th>发布时间</th>
									<th>url</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="item">
									<tr class="gradeX">

										<td>${item.pname}</td>
										<td>${item.mdate}</td>
										<td>${item.url}</td>
										<td class="center"><a
											href="<%=application.getContextPath()%>/medid/deletevideo.action?mid=${item.mid}"
											class="btn btn-danger btn-sm pull-right deleteA">删除</a></td>
									</tr>
								</c:forEach>

							</tbody>

						</table>

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
	<!-- Data Tables -->
	<script
		src="<%=application.getContextPath()%>/js/plugins/dataTables/jquery.dataTables.js"></script>
	<script
		src="<%=application.getContextPath()%>/js/plugins/dataTables/dataTables.bootstrap.js"></script>

	<script type="text/javascript">
		$(function() {
			//给删除按钮添加提示
			$(".deleteA").click(function(e) {
				if (window.confirm('确定要删除吗')) {
					return true;
				} else {
					return false;
				}
			})
		});
	</script>


	<!-- Page-Level Scripts -->
	<script>
		$(document).ready(function() {
			$('.dataTables-example').dataTable();

			/* Init DataTables */
			var oTable = $('#editable').dataTable();

			/* Apply the jEditable handlers to the table */
			oTable.$('td').editable('../example_ajax.php', {
				"callback" : function(sValue, y) {
					var aPos = oTable.fnGetPosition(this);
					oTable.fnUpdate(sValue, aPos[0], aPos[1]);
				},
				"submitdata" : function(value, settings) {
					return {
						"row_id" : this.parentNode.getAttribute('id'),
						"column" : oTable.fnGetPosition(this)[2]
					};
				},

				"width" : "90%",
				"height" : "100%"
			});

		});
	</script>


</body>

</html>
