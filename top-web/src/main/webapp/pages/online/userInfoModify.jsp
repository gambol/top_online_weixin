<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 2015/6/13
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
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
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="description" content="">
  <meta name="author" content="byLL">
  <link rel="icon" href="<c:url value="/resources/img/logo_top.png"/> ">
  <title>用户登录</title>

  <!-- Bootstrap CSS -->
  <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" media="screen">
  <!-- Main CSS -->
  <link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet" media="screen" />
  <link href="<c:url value="/resources/css/mycss.css"/>" rel="stylesheet" media="screen"/>
  <link href="<c:url value="/resources/css/header.css"/>" rel="stylesheet"/>
  <script>
      function submitModify(type) {
          <%--var type = '${type}';--%>
          if ($("#modify-content").val().length == 0) {
              window.location.href = pageUrl("/user/userInfo");
          } else {
              // 身份证号修改
              if (type == 2 && $("#modify-content").val().length != 18) {
                  alert("身份证号不合法");
              } else {
                  switch (parseInt(type)) {
                      case 1:   // 修改真实姓名
                          window.location.href = pageUrl("/user/modifyName?name=" + $("#modify-content").val());
                          break;
                      case 2:   // 修改身份证号码
                          window.location.href = pageUrl("/user/modifyIdCardNum?idCardNum=" + $("#modify-content").val());
                          break;
                      default:
                          break;
                  }
              }
          }
      }
  </script>
</head>
<body>
<jsp:include page="header.jsp"/>
  <div class="input-group input-content">
      <span class="input-group-addon" id="type-name"></span>
      <input id="modify-content" type="text" maxlength="18" class="form-control" placeholder="请在此输入" aria-describedby="basic-addon1">
  </div>
  <button class="btn btn-info button-modify" onclick="submitModify('${type}')">提交修改</button>
</body>

<c:import url="/pages/_contextPath.jsp"/>
<script src="<c:url value="/resources/js/jquery-1.11.3.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/lib/angular.js"/>"></script>
<link href="<c:url value="/resources/css/header.css"/>" rel="stylesheet"/>
<script type="text/javascript"
        src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<script>
    var type = 1;
    $(function() {
        type = '${type}';
        if (type == 1) {
            var name = '${name}';
            header({title: "真实姓名", back: "/user/userInfo", menu: false});
            $("#type-name").html("真实姓名");
            $("#modify-content").val(name);
        } else {
            var idCardNum = '${idCardNum}'
            header({title: "身份证号", back: "/user/userInfo", menu: false});
            $("#type-name").html("身份证号");
            $("#modify-content").val(idCardNum);
        }
    })
</script>
</html>
