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

<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>托普在线</title>
		<link href="/resources/css/bootstrap.min.css" rel="stylesheet" />
		<link href="/resources/css/mycss.css" rel="stylesheet" />
		<script src="/resources/js/jquery-1.11.3.min.js"></script>
		<script src="/resources/js/bootstrap.min.js"></script>
	</head>
	<style type="text/css">
		td {
			padding: 2px;
		}
	</style>

	<body>
		<!--banner开始-->
		<div class="my-header"><span class="glyphicon glyphicon-menu-left" style="color:white;line-height:55px;float:left;margin-left:15px;"></span><span style="line-height:55px;color:white;font-weight:400;font-family:'微软雅黑';">个人中心</span><span class="glyphicon glyphicon-user" style="color:white;line-height:55px;float:right;margin-right:15px;visibility: hidden;"></span>
		</div>
		<!--banner开始-->
		<div class="row">
			<div class="banner" style="background-image: url(/resources/img/person_banner.png);background-size:100%;">
				<!--<img src="img/person_banner.png" style="width: 100%;z-index: 2;" />-->
				<!--banner上面的内容开始-->
			 
				<div class="col-xs-7 phone-div" style="margin-left: 35%;margin-top:25px;">
					等级：xxxx
					<br/> 积分：xxxx
				</div>
				</div>
			<!--banner上面的内容结束-->
		</div>
		<!--banner结束-->
		<!--个人信息开始-->
		<div class="jfjs">
			<form action="" method="post">
			<table>
				<tr>
					<td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
					<td>
						<input name="userName" type="text">
					</td>
				</tr>
				<tr>
					<td>手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机：</td>
					<td>
						<input name="phone" type="text">
					</td>
				</tr>
				<tr>
					<td>身份证号：</td>
					<td>
						<input name="idCar" type="text">
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<button type="submit" class="btn btn-default" style="background: #20a1da;color:white;float: right;font-weight: 600;">确定修改</button>
					</td>

				</tr>
			</table>
			</form>
		</div>
		<!--个人信息结束-->

		<!--项目介绍开始-->
		<div class="jfjs">
			介绍朋友赢积分
			<br/>
			<img src="/resources/img/jftubiao.png">
		</div>
		<div class="col-xs-3"></div>
		<div class="col-xs-7 z">每介绍一个朋友，您将会获得X积分，集齐XX积分，可兑换XXX人民币。</div>
		<div class="col-xs-2"></div>
		</div>
		<!--项目介绍结束-->
		<!--底部-->
		<!--<div class="my-footer" style="background: #f87a13;"><a href="">退&nbsp;&nbsp;出</a>
			<div>-->
	</body>

</html>