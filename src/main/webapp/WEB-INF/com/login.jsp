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

        .login-div {
            display: table;
            margin: auto;
            position: absolute;
            top: 0;
            left: 0;
            bottom: 200px;
            right: 0;
            width: 350px;
            padding: 20px;
            text-align: center;
        }

        h2 {
            font-family: dnmbxsxd;
        }

        .i-btn-group {
            width: 100%;
        }

        .i-login-btn {
            width: 50%;
        }

        .login-copyright {
            position: absolute;
            bottom: 20px;
            width: 100%;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="page">
    <div class="login-div">
        <h2>欢迎回来，我的朋友</h2>
        <br/>
        <form class="login-form" role="form" method="post" action="">
            <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"
                                                       aria-hidden="true"></i></span>
                <input class="form-control" id="username" name="username" type="text" placeholder="用户名"/>
            </div>
            <br/>
            <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                <input class="form-control" id="password" name="password" type="password" placeholder="密码"/>
            </div>
            <br/>
            <div class="btn-group i-btn-group">
                <button class="btn btn-default btn-group-lg i-login-btn">注册</button>
                <button type="submit" class="btn btn-default btn-group-lg i-login-btn">登录</button>
            </div>
        </form>
        <br>
    </div>
    <div class="login-copyright"><jk:copyright></jk:copyright></div>
</div>
</body>
</html>
