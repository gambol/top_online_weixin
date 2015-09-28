<%--
Created by IntelliJ IDEA.
User: wanglei
Date: 2015/3/31
Time: 16:50
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<!--[if IE 7]> <html lang="en" class="ie7"> <![endif]-->
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en"> <!--<![endif]-->
<html>

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>托普在线</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/mycss.css"/>" rel="stylesheet"/>
    <script src="<c:url value="/resources/js/jquery-1.11.3.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</head>
<body style="width:100%;background-image:url(/resources/img/logo_dw.png);background-size:100% ;">

<div class="container">
    <!--推广宣传-->
    <div class="row">
        <div class="my-span" style="margin-top:30%;">每邀请一位朋友注册，您就可以获得500积分噢！</div>
    </div>
    <!--手机登录框-->
    <div class="row">
        <div class="col-xs-1"></div>
        <div class="col-xs-10">
            <div class="input-group" style="margin-top: 27%;margin-left:10%;">
                <span class="input-group-addon"><img src="<c:url value="/resources/img/logo.png"/> "></span>
                <input type="text" class="form-control" id="inputGroupSuccess3" aria-describedby="inputGroupSuccess3Status"
                       value="请输入手机号码" style="width:87%;height:70px;margin:0 auto;color:#a0a0a0;font-size:1.5em;">
            </div>
            <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
            <span id="inputGroupSuccess3Status" class="sr-only">(success)</span>
        </div>
    </div>
    <div class="col-xs-1"></div>
    <!--登录按钮-->
    <div class="row">
        <div style="margin-left:35%;margin-top:30%;width:100%;">
            <a href="<c:url value="/home/index"/> " class="my-button">登&nbsp;&nbsp;录</a>
        </div>
    </div>

</div>

</body>

</html>