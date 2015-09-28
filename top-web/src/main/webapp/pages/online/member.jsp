<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<!--[if IE 7]> <html lang="en" class="ie7"> <![endif]-->
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<head>
  <meta charset="utf-8">
  <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="description" content="">
  <meta name="author" content="byLL">
  <link rel="icon" href="<c:url value="/resources/img/logo_top.png"/> ">
  <title>用户登录</title>

  <!-- Bootstrap CSS -->
  <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" media="screen">
  <!-- Main CSS -->
  <link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet" media="screen">
  <link href="<c:url value="/resources/css/mycss.css"/>" rel="stylesheet" media="screen">
  <link href="<c:url value="/resources/css/header.css"/>" rel="stylesheet" media="screen">
  <script type="text/javascript" src="<c:url value="/resources/js/lib/jquery.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/lib/jbase64.js"/>"></script>


  <script>
    function modifyInfo(type) {
      window.location.href = pageUrl("/home/userInfoModify?type=" + type);
    }
  </script>
</head>

<body>

<jsp:include page="header.jsp"/>

<img class="member_background" src="<c:url value="/resources/img/person_banner1.png"/>"/>
<img class="member_avatar" src="<c:url value="/resources/img/person.png"/>"/>

<div class="col-md-4 member_level">
  <input class="input_transparent" value="用户积分: " readonly>
  <input class="input_transparent" value="${userInfo.availableCredits}" readonly>
</div>


<div class="gray_background">
  <div class="user-list row" onclick="modifyInfo(1)">
    <div class="user-title col-md-4 col-sm-4 col-xs-4">真实姓名</div>
    <div class="user-msg col-md-6 col-sm-6 col-xs-7">
      <p align="right">${userInfo.name}</p>
      <%--<p align="right">测试</p>--%>
    </div>
  </div>
  <div class="user-line"></div>
  <div class="row user-list">
    <div class="user-title col-md-4 col-sm-4 col-xs-4">手机号码</div>
    <div class="user-msg col-md-6 col-sm-6 col-xs-7">
      <p align="right">${userInfo.mobile}</p>
      <%--<p align="right">13687639010</p>--%>
    </div>
  </div>
  <div class="user-line"></div>
  <div class="user-list row" onclick="modifyInfo(2)">
    <div class="user-title col-md-4 col-sm-4 col-xs-4">身份证号</div>
    <div class="user-msg col-md-6 col-sm-6 col-xs-7">
      <p align="right">${userInfo.idCard}</p>
      <%--<p align="right">370282198704243613</p>--%>
    </div>
  </div>
  <div class="jfjs">
    介绍朋友赢积分
    <br/>
    <img src="<c:url value="/resources/img/jftubiao.png"/>">
  </div>
  <div class="col-xs-3"></div>
  <div class="col-xs-7 z">每介绍一个朋友，您将会获得X积分，集齐XX积分，可兑换XX人民币。</div>
  <div class="col-xs-2"></div>
</div>
</body>

<jsp:include page="../_contextPath.jsp"/>
<script src="<c:url value="/resources/js/login.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-1.11.3.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/lib/angular.js"/>"></script>
<script type="text/javascript"
        src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<script type="text/javascript"
        src="<c:url value="/resources/js/lib/cookie.js"/>"></script>

<script>
  header({title: "个人信息", back: "/home/enroll", menu: false});
</script>
