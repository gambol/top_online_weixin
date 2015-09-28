<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 2015/6/11 0018
  Time: 10:28
  用户登陆页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="description" content="">
    <meta name="author" content="byLL">
    <link rel="icon" href="<c:url value="/resources/img/logo_top.png"/> ">
    <title>用户登录</title>

    <!-- Bootstrap CSS -->
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" media="screen">
    <!-- Main CSS -->
    <link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet" media="screen">
    <script type="text/javascript" src="<c:url value="/resources/js/lib/jquery.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/lib/jbase64.js"/>"></script>
    <jsp:include page="../_contextPath.jsp"/>
    <script src="<c:url value="/resources/js/login.js"/>"></script>
    <script src="<c:url value="/resources/js/jquery-1.11.3.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/js/lib/angular.js"/>"></script>
    <script type="text/javascript"
            src="<c:url value="/resources/js/bootstrap.js"/>"></script>
    <script type="text/javascript"
            src="<c:url value="/resources/js/lib/cookie.js"/>"></script>

</head>
<body>
    <script type="text/javascript"
            src="<c:url value="/resources/js/lib/jquery.js"/>"></script>

    <img id="background" src="<c:url value="/resources/img/loginBgImg.png"/>">

    <div id="top-logo-container">
        <p style="text-align: center;"><img id="logo-img" src="<c:url value="/resources/img/logo_top.png"/>"/></p>
    </div>
    <form id="login-form" action="" method="post" class="form">
    <div id="login-container">
        <p>

        <div class="input-group" id="mobileDiv">
            <span class="input-group-addon color-blue span-type">
                <img class="my-img-tel" src="<c:url value="/resources/img/userHeadImg.png"/>">
            </span>
            <input id="mobile" name="username" type="tel" class="form-control" placeholder="请输入手机号">
        </div>
        </p>
        <p>

        <div class="input-group" id="passwordDiv">
                <span class="input-group-addon color-blue span-type">
                    <img class="my-img-pwd" src="<c:url value="/resources/img/passwordImg.png"/>">
                </span>
            <input id="password" name="password" type="password" class="form-control"
                   placeholder="请输入密码">
        </div>
        </p>
        <p style="text-align: right">
            <%--<button class="forget-button" >忘记密码？</button>--%>
            <a href="<c:url value="/home/forgetPass"/>" id="forget_button" class="forget-button">
                忘记密码？
            </a>
        </p>

    </div>
    </form>
    <div id="button_container">
        <p style="text-align: center">
            <button id="login_button" type="button" class="btn btn-info button-login" onclick="login()">登录</button>
            <a href="<c:url value="/home/register"/>" id="register_button" class="btn btn-info button-register">
                注册
            </a>
        </p>
    </div>

    <!-- JS Implementing Plugins -->
    <%--<script>--%>
        <%--function login() {--%>
            <%--var name = $("inputTel").val();--%>
            <%--var pass = $("inputPwd").val();--%>
            <%--if (name == null || name == '') {--%>
                <%--$("inputTel").css({border: "red"});--%>
            <%--} else if (pass == null || pass == '') {--%>
                <%--$("inputPwd").css({border: "red"});--%>
            <%--}--%>
        <%--}--%>
    <%--</script>--%>
</body>
</html>
