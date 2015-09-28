<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

  <title>托普在线</title>
  <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
  <link href="<c:url value="/resources/css/mycss.css"/>" rel="stylesheet"/>
  <link href="<c:url value="/resources/css/header.css"/>" rel="stylesheet"/>

</head>

<body  style="background-color:#E6E6E6;">

<jsp:include page="header.jsp"/>

<div class="row">
  <div class="col-xs-1"></div>
  <div class="col-xs-10 hy">
    <img src="<c:url value="/resources/img/gongxi1.png"/>"><span>恭喜您成为托普会员!</span>
  </div>
  <div class="col-xs-1"></div>
</div>
<div class="row">
  <div class="col-xs-1"></div>
  <div class="col-xs-10 hydy">
    <img src="<c:url value="/resources/img/hy.png"/>">
    <div class="hyz">会员待遇，推荐好友下载客户端，介绍人栏填写会员手机号，并报名缴费，可享有积分待遇。</div>
  </div>
  <div class="col-xs-1"></div>
</div>
<div class="my-button fhan"><a href="<c:url value="/home/enroll"/> ">立即返回首页</a></div>

</body>
<c:import url="/pages/_contextPath.jsp"/>
<script src="<c:url value="/resources/js/jquery-1.11.3.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script type="text/javascript">
  header({title: "缴费成功", back: false});
</script>
</html>
