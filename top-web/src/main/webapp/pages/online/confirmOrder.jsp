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
            padding: 8px 15px;
        }

        .my-active {
            background: #f8f8f8;
        }

        .my-footer-btn {
            height: 40px;
            font-weight: bold;
            background:#f87a13;
            border:  0px;}
    </style>

</head>

<body ng-app="app" ng-controller="ctl">
<jsp:include page="header.jsp"/>

<div class="panel-body">

    <ul class="list-group">
        <li class="list-group-item">
                <span>
                    姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名
                </span>
                <span style="margin-left: 20px;">
                    ${realname}
                </span>
        </li>
        <li class="list-group-item">
                <span>
                    联系方式
                </span>
                <span style="margin-left: 20px;">
                    ${mobile}
                </span>
        </li>
    </ul>
    <ul class="list-group" style="line-height: 24px;">
        <li class="list-group-item my-active" style="background:#EBEBEB;">
            专业介绍
        </li>
        <li class="list-group-item"><strong>专业名称：</strong>${name}</li>
        <li
                class="list-group-item">
            <strong>学&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp制：</strong>${duration}</li>
    </ul>
    <ul class="list-group" style="line-height: 24px;">
        <li class="list-group-item my-active" style="background:#EBEBEB;">
            详细费用
        </li>
        <li class="list-group-item"><strong style="letter-spacing: 0.8px;">考试费：</strong> ${examFee}</li>
        <li class="list-group-item"><strong>学&nbsp&nbsp&nbsp&nbsp费：</strong> ${tuitionFee}</li>
        <li class="list-group-item"><strong style="letter-spacing: 0.8px;">书本费：</strong>
            ${bookFee}</li>
        <li class="list-group-item"><strong>合&nbsp&nbsp&nbsp计：</strong>${totalFee}</li>
    </ul>
    <div class="list-group" style="line-height: 24px;">
        <div class="list-group-item">
            全额缴费（9折优惠）
            <input class="pull-right" type="checkbox" style="width: 20px;height: 20px;"
                   ng-model="fullPayment"/>
        </div>

        <div class="list-group-item">
            可用${point}积分抵用${discount}元
            <input class="pull-right" type="checkbox" style="width: 20px;height: 20px;"
                   ng-model="useDiscount"/>
        </div>

    </div>
</div>

<div style="height: 40px"></div>

<div>
    <div class=" btn-group my-footer text-center" role="group" style="width: 100%;height:
  40px;
  background-color: white;">
        <button type="button" class="btn btn-default disabled my-footer-btn" style="width: 50%;"
                ng-bind="finalFeeText">
            <a href="/pages/online/Order_list.jsp">报名列表</a>

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

    header({title: "确认缴费", back: '/home/enroll'});

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
