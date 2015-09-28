<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 2014/11/18 0018
  Time: 10:28
  用户注册页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="description" content="">
  <meta name="author" content="byLL">
  <link rel="icon" href="<c:url value="/resources/img/logo_top.png"/> ">
  <title>用户注册</title>

  <!-- Bootstrap CSS -->
  <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" media="screen">
  <!-- Main CSS -->
  <link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet" media="screen">
  <link href="<c:url value="/resources/css/mycss.css"/>" rel="stylesheet" media="screen">
  <link href="<c:url value="/resources/css/header.css"/>" rel="stylesheet" media="screen">


</head>
<body>


<jsp:include page="header.jsp"/>

<form id="register-form" action="" method="post" class="form">
  <div id="register-container">
    <p>

    <div class="input-group" id="mobileDiv">
                <span class="input-group-addon color-blue span-type">
                    <img class="my-img-tel" src="<c:url value="/resources/img/userHeadImg.png"/>">
                </span>
      <input id="mobile" name="mobile" type="tel" class="form-control" placeholder="请输入手机号"
             maxlength="11">
    </div>
    </p>
    <p style="text-align: right">
      <input id="captcha-btn" class="btn btn-info btn-success btn-block button-verify-code"
             value="获取验证码" readonly/>
    </p>

    <p>

    <div class="input-group" style="margin-top: 10px" id="captchaDiv">
            <span class="input-group-addon color-blue span-type">
                <img class="my-img-code" src="<c:url value="/resources/img/yanzheng.png"/>">
            </span>
      <input id="captcha" type="text" class="form-control" placeholder="请输入验证码" maxlength="11"
             required>
    </div>
    </p>

    <p>

    <div class="input-group" id="refereeMobileDiv">
                <span class="input-group-addon color-blue span-type">
                    <img class="my-img-referee" src="<c:url value="/resources/img/jieshaoren.png"/>">
                </span>
      <input id="refereeMobile" name="refereeMobile" type="text" class="form-control"
             placeholder="请输入推荐人手机号" maxlength="11">
    </div>
    </p>

    <p>

    <div class="input-group" style="margin-top: 10%" id="passwordDiv">
            <span class="input-group-addon color-blue span-type">
                <img class="my-img-pwd" src="<c:url value="/resources/img/passwordImg.png"/>">
            </span>
      <input id="password" name="password" type="password" class="form-control" placeholder="请输入密码">
    </div>
    </p>

    <p>

    <div class="input-group">
            <span class="input-group-addon color-blue span-type" id="rePasswordDiv">
                <img class="my-img-pwd" src="<c:url value="/resources/img/passwordImg.png"/>">
            </span>
      <input id="rePassword" type="password" class="form-control" placeholder="请再次输入密码">
    </div>
    </p>

  </div>
</form>
<div id="alertTip" class="alert alert-danger" role="alert" style="text-align: center;display: none">
  <c:out value="${failMsg}"/>
</div>


<div id="button_container">
  <p style="text-align: center">
    <button type="button" id="register_button" class="btn btn-info button-bottom"
            onclick="submitted()">
      注册
    </button>
  </p>
</div>
<!-- JS Implementing Plugins -->

</body>

<script type="text/javascript"
        src="<c:url value="/resources/js/lib/jquery.js"/>"></script>
<c:import url="/pages/_contextPath.jsp"/>
<script src="<c:url value="/resources/js/register.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-1.11.3.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/lib/angular.js"/>"></script>
<script type="text/javascript"
        src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<script type="text/javascript"
        src="<c:url value="/resources/js/lib/cookie.js"/>"></script>

<script>
  header({title: "注册", back: '/home/login', menu: false});
</script>
</html>
