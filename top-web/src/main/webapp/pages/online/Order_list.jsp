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
  <title>报名列表</title>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/css/mycss.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/css/header.css"/>">

  <style type="text/css">
      .list-group-item {
          padding: 11px 15px;
      }
      .my-footer-btn {
      height: 40px;
      font-weight: bold;
        background:#f87a13;
        border:  0px;}
  </style>

</head>

<body ng-app="app" ng-controller="ctl" style="background: #e6e6e6;">
<jsp:include page="header.jsp"/>

<div class="panel-body" style="margin-top: 8px;">

  <ul class="list-group">
    <li class="list-group-item">
                <span>
                    报名项目：(成人教育)
                </span>
                <span style="margin-left: 20px;">
                  ${mobile}
                </span>
    </li>
    <li class="list-group-item">
                <span>
                    层&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;次：(高起专)
                </span>
                <span style="margin-left: 20px;">
                  ${mobile}
                </span>
    </li>
      <li class="list-group-item">
          <div style="text-align: right;" onclick="javascript:location.href='Order_details.jsp'">
                    报名详情>>></div>
         </li>
  </ul>
    <ul class="list-group">
        <li class="list-group-item">
                <span>
                    报名项目：(会计培训)
                </span>
                <span style="margin-left: 20px;">
                    ${mobile}
                </span>
        </li>
        <li class="list-group-item">
                <span>
                    类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：(会计资格证)
                </span>
                <span style="margin-left: 20px;">
                    ${mobile}
                </span>
        </li>
        <li class="list-group-item">
            <div style="text-align: right;" onclick="javascript:location.href='Order_details.jsp'">
                    报名详情>>></div>
        </li>
    </ul>
    <ul class="list-group">
        <li class="list-group-item">
                <span>
                    报名项目：(少儿培训)
                </span>
                <span style="margin-left: 20px;">
                    ${mobile}
                </span>
        </li>
        <li class="list-group-item">
                <span>
                    类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：(少儿舞蹈)
                </span>
                <span style="margin-left: 20px;">
                    ${mobile}
                </span>
        </li>
        <li class="list-group-item">
            <div style="text-align: right;" onclick="javascript:location.href='Order_details.jsp'">
                    报名详情>>></div>
        </li>
    </ul>
</div>
  <div class=" btn-group my-footer text-center" role="group" style="width: 100%;height:
  40px;
  background-color: white;">
    <button type="button" class="btn btn-default disabled my-footer-btn" style="width: 50%;background:#9ac6c8;"
            ng-bind="finalFeeText">

    </button>
    <button type="button" class="btn btn-danger my-footer-btn" style="width: 50%;"
            ng-click="submit()">确认缴费
    </button>
  </div>

</div>

</body>
<c:import url="/pages/_contextPath.jsp"/>
<script src="<c:url value="/resources/js/jquery-1.11.3.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<script src="<c:url value="/resources/js/lib/angular.js"/>"></script>
<script type="text/javascript">

  header({title: "报名列表", back: '/home/enroll'});

  var app = angular.module('app', []);
  app.controller('ctl', function ($scope, $http, $window) {
    $scope.discount = parseFloat(0);
    $scope.total = parseFloat('${total}');
    $scope.projectId = parseInt('${projectId}');

//    $scope.finalFee = 0;
//    $scope.finalFeeText = '';

    $scope.useDiscount = false;
    $scope.fullPayment = false;

    $scope.$watch('fullPayment', function () {
      $scope.calculate();
    });

    $scope.$watch('useDiscount', function () {
      $scope.calculate();
    });

    $scope.calculate = function () {
      $scope.finalFee = $scope.total;
      if ($scope.fullPayment) {
        $scope.finalFee = $scope.finalFee * 0.9;
      }
      if ($scope.useDiscount) {
        $scope.discount = parseFloat('${discount}');
        $scope.finalFee = $scope.finalFee - $scope.discount;
      }else{
        $scope.discount = parseFloat(0);

      }

      $scope.finalFeeText = "合计: " + $scope.finalFee + "元";
    };

    $scope.calculate();

    $scope.submit = function () {

      var data = $.param({
        projectId: $scope.projectId,
        fullPayment: $scope.fullPayment,
        discount: $scope.discount,
        finalFee: $scope.finalFee
      });

      $http({
        method: 'POST',
        url: pageUrl('/order/create'),
        headers: {'Content-Type': 'application/x-www-form-urlencoded'},
        data: data
      }).success(function (result) {
        if (result.code == 1)
          $window.location.href = pageUrl("/order/pay_mode?orderNo=" + result.data);
        else alert('订单创建失败')

      }).error(function (result, status) {
        alert('通讯失败 code=' + status);
      });
    }
  })
</script>
</html>