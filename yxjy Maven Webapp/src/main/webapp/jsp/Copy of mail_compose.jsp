<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>洋县嘉园</title>

    <link rel="shortcut icon" href="favicon.ico"> <link href="<%=application.getContextPath()%>/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=application.getContextPath()%>/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="<%=application.getContextPath()%>/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="<%=application.getContextPath()%>/css/plugins/summernote/summernote.css" rel="stylesheet">
    <link href="<%=application.getContextPath()%>/css/plugins/summernote/summernote-bs3.css" rel="stylesheet">
    <link href="<%=application.getContextPath()%>/css/animate.css" rel="stylesheet">
    <link href="<%=application.getContextPath()%>/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row">
        
        
        
        
            <div class="col-sm-9 animated fadeInRight">
                <div class="mail-box-header">
                <h2>
                    简介内容
                </h2>
                </div>
                <div class="mail-box">
                    <div class="mail-text h-200">
                        <div class="summernote">
                            文章编辑

                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="mail-body text-right tooltip-demo">
                        <a href="mailbox.html" class="btn btn-sm btn-primary" data-toggle="tooltip" data-placement="top" title="Send"><i class="fa fa-reply"></i> 保存</a>
                      
                    </div>
                    <div class="clearfix"></div>



                </div>
            </div>
        </div>
    </div>

    <!-- 全局js -->
    <script src="<%=application.getContextPath()%>/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=application.getContextPath()%>/js/bootstrap.min.js?v=3.3.6"></script>



    <!-- 自定义js -->
    <script src="<%=application.getContextPath()%>/js/content.js?v=1.0.0"></script>


    <!-- iCheck -->
    <script src="<%=application.getContextPath()%>/js/plugins/iCheck/icheck.min.js"></script>

    <!-- SUMMERNOTE -->
    <script src="<%=application.getContextPath()%>/js/plugins/summernote/summernote.min.js"></script>
    <script src="<%=application.getContextPath()%>/js/plugins/summernote/summernote-zh-CN.js"></script>
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });


            $('.summernote').summernote({
                lang: 'zh-CN'
            });

        });
        var edit = function () {
            $('.click2edit').summernote({
                focus: true
            });
        };
        var save = function () {
            var aHTML = $('.click2edit').code(); //save HTML If you need(aHTML: array).
            $('.click2edit').destroy();
        };
    </script>


    
</body>

</html>
