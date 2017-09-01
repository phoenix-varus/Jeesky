<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <%--Taglib--%>
    <%@include file="../sys/taglib.jsp" %>

    <style type="text/css">
        html, body, .page {
            margin: 0px;
            height: 100%;
        }

    </style>
</head>
<body>
<div class="page">
    <div class="i-navbar-div">
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">菜鸟教程</a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">iOS</a></li>
                        <li><a href="#">SVN</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                Java
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">jmeter</a></li>
                                <li><a href="#">EJB</a></li>
                                <li><a href="#">Jasper Report</a></li>
                                <li class="divider"></li>
                                <li><a href="#">分离的链接</a></li>
                                <li class="divider"></li>
                                <li><a href="#">另一个分离的链接</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <div class="navbar-right">
                    <span class="fa fa-user-circle-o" style="font-size: 30px;margin: 10px;"></span>
                </div>
            </div>
        </nav>
    </div>
</div>
</body>
</html>
