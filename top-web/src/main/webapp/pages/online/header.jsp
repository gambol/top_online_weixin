<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="my-header">

  <span id="header-back-btn" class="glyphicon glyphicon-menu-left"
        style="color:white;line-height:55px;float:left;margin-left:15px;"></span>

  <span id="header-title" style="line-height:55px;color:white;width: 50px"></span>

  <div class="dropdown pull-right">
      <span id="header-menu-btn" class="glyphicon glyphicon-menu-hamburger" data-toggle="dropdown"
            style="color:white;line-height:55px;float:right;margin-right:15px;">
      </span>

    <ul class="dropdown-menu dropdown-menu-right" style="top:40px">
      <li><a tabindex="-1" href="<c:url value='/user/userInfo'/>">个人信息</a></li>
      <li><a tabindex="-1" href="#">积分商城 (敬请期待)</a></li>
      <li><a tabindex="-1" href="#">二维码 (敬请期待)</a></li>
      <li><a tabindex="-1" href="<c:url value='/auth/logout'/>">退出</a></li>
    </ul>
  </div>

</div>
