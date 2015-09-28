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
  <style type="text/css">
    .list-group-item {
      padding: 8px 15px;
    }

    .pay-mode-btn {

    }

    .pay-mode-btn > input {
      width: 18px;
      height: 18px;
      margin-right: 15px;
    }

    .pay-mode-btn > img {
      width: 30px;
      height: 30px;
    }
  </style>

  <jsp:include page="../_contextPath.jsp"/>
  <script src="<c:url value="/resources/js/wx/jweixin-1.0.0.js"/> "></script>

</head>

<body>
<div class="my-header">
    <span class="glyphicon glyphicon-menu-left"
          style="color:white;line-height:55px;float:left;margin-left:15px;">
    </span>
    <span style="line-height:55px;color:white;font-weight:400;font-family:'微软雅黑';">提&nbsp;&nbsp;示
    </span>
    <span class="glyphicon glyphicon-user"
          style="color:white;line-height:55px;float:right;margin-right:15px;">
    </span>
</div>

<div class="panel-body">

  <ul class="list-group">
    <li class="list-group-item" style="background:#FFFADF;">
      <div style="font-size: 24px;color: #b92c28;font-weight: bold;">
        ${message}
      </div>
      <br>

      <div style="margin-left: 5px;color: #4F4F4F;font-size: 12px;">
        ${detail}
      </div>
      <br>

      <div style="margin-left: 5px;color: #4F4F4F;font-size: 12px;">
        <span id="timer"></span>秒后自动跳转...
      </div>
    </li>
  </ul>
</div>


<script src="<c:url value="/resources/js/jquery-1.11.3.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/wx/wx_js.js"/>"></script>

<script type="text/javascript">
  var redirect = '${redirect}';

  var timer = 5;
  $("#timer").html(timer);

  setInterval(function () {
    $("#timer").html(--timer);
  }, 1000);

  setTimeout(function () {
    window.location.href = pageUrl(redirect);
  }, 5000);
</script>
</body>
</html>
