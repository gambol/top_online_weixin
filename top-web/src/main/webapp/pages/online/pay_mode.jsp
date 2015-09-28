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
    <style type="text/css">
        .list-group-item {
            padding: 8px 15px;
        }

        .my-back-btn {
        }

        .my-back-btn:active {
            opacity: 1;
        }

        .my-title {
            font-weight: bold;
            color: black;
            font-family: 楷体;
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

<body ng-app="app" ng-controller="ctl">
<jsp:include page="header.jsp"/>
<!--<div class="panel panel-info">-->
<!--<div class="panel-heading text-center">-->
<!--&lt;!&ndash;<button type="button" class="btn btn-default">&ndash;&gt;-->
<!--<a href="##" class="my-back-btn">-->
<!--<img src="resources/img/icon/ht.png" style="width: 20px;" class="pull-left"/>-->
<!--</a>-->
<!--&lt;!&ndash;</button>&ndash;&gt;-->
<!--<span class="h4 my-title">-->
<!--支 付-->
<!--</span>-->
<!--</div>-->

<div class="panel-body">

    <ul class="list-group">
        <li class="list-group-item" style="background:#e9feff">
            <div style="font-size: 24px;color: #d30a00;font-weight: bold;">
                <img src="<c:url value="/resources/img/gongxi1.png"/>" style="width: 40px;">
                恭喜您！已报名成功！
            </div>
            <div style="margin-left: 50px;color: #4F4F4F;font-size: 12px;">
                注：请于7日内携带身份证原件；毕业证原件及复印件；四张2寸蓝底彩色照片，前往学校进行现场确认。
            </div>
        </li>
    </ul>


    <ul class="list-group" style="line-height: 24px;">
        <li class="list-group-item my-active" style="background:#EBEBEB;">
                学校地址：
            </li>
        <li class="list-group-item my-active">地址：金水路1577-10号（托普科技培训学校）<br/>
           电话：0532-58973666
                <a href="tel:053258973666"><img src="<c:url value="/resources/img/icon/call.png"/>" style="width: 25px;"></a><br/>
                <%--<a onclick="window.location.href='tel:053258973666'"><img src="<c:url value="/resources/img/icon/icon_telephone.png"/>" style="width: 25px;"></a>--%>
            乘车路线112.113.115.318虎山体育场下</li>
        <li class="list-group-item my-active">地址：李村向阳路94号（李村邮电局三楼）<br/>
            电话：0532-87638855
                <a href="tel:053287638855"><img src="<c:url value="/resources/img/icon/call.png"/>" style="width: 25px;"></a><br/>
            </li>
        <li class="list-group-item my-active">地址：永年路27号<br/>
            电话：0532-84822222
                <a href="tel:053284822222"><img src="<c:url value="/resources/img/icon/call.png"/>" style="width: 25px;"></a><br/>
            </li>
        </ul>
    </div>

    <div class="well" style="text-align: center;">
        <span>应付：${model.totalPrice}元</span><span class="text-danger h4"
                                                  style="margin-left: 20px;">实付：${model.price}元</span>
    </div>
    <form id="form" class="form-horizontal" action="" method="post">
        <input id="orderNo" name="orderNo" type="hidden" value="${model.orderNumber}">
    </form>
    <div class="list-group" style="padding:8px 15px;">
        <a class="list-group-item" style="background:#EBEBEB;">
            选择支付方式
        </a>
        <a id="a_alipay" href="#" class="list-group-item pay-mode-btn">
            <input id="radio_apipay" class="pull-left" type="radio" name="zf" value="0"/>
            <img src="<c:url value="/resources/img/icon/alipayImg.png"/>">
            支付宝支付
        </a>
        <a id="a_wxpay" href="#" class="list-group-item pay-mode-btn">
            <input id="radio_wxpay" class="pull-left" type="radio" name="zf" value="1"/>
            <img src="<c:url value="/resources/img/icon/ico_weixinpay.png"/>">
            微信支付
        </a>
        <a href="#" class="list-group-item pay-mode-btn">
            <input id="radio_onsite" class="pull-left" type="radio" name="zf" value="2"/>
            <img src="<c:url value="/resources/img/icon/xianchang.png"/>">
            现场缴费
        </a>
    </div>
    <div style="height: 50px"></div>
</div>

<div>
    <a href="javascript:void(0)" onclick="submitd()">
        <div class="my-footer" style="background: darkorange;font-size: 18px !important;">确认支付</div>
    </a>
</div>


<script src="<c:url value="/resources/js/jquery-1.11.3.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

<script type="text/javascript">
    header({title: "支付", back: false});
    /**
     * 支付
     */
    function submitd() {
        var val = $('input:radio[name="zf"]:checked').val();
        if (val == null) {
            alert("请选择支付方式!");
            return false;
        }
        else {
            if (val == 0) {//支付宝支付
                var path = pageUrl('/order/payByAlipay');
                $('#form').attr("action", path).submit();
                return true;
            } else if (val == 1) {//微信支付
                var path = pageUrl('/order/payByWeChat');
                var data = $('form').serialize();
                $.ajax({
                    cache: true,
                    type: "POST",
                    url: path,
                    data: data,// 你的formid
                    async: false,
                    dataType: "json",
                    error: function (res) {
                        alert(res.err_code_des);
                        if (res.err_code == 'AUTHENTICATION_DENIED') {
                            window.location.href = pageUrl('/weChat/entrance');
                        }
                    },
                    success: function (data) {
                        wxPay(data.timeStamp, data.nonceStr, data.package_prepay_id, data.paySign);
                    }
                });
            }
            if (val == 2) {//现场支付
                $('#form').attr("action", path).submit();
                window.location.href = '<c:url value="/order/success"/> ';
                return true;
            }
            return false;
        }
    }
</script>


<script>
    var ua = navigator.userAgent.toLowerCase();
    if (ua.match(/MicroMessenger/i) == "micromessenger") {
        $("#radio_wxpay").attr("checked", "checked");
        $("#a_alipay").hide();

        /*
         * 注意：
         * 1. 所有的JS接口只能在公众号绑定的域名下调用，公众号开发者需要先登录微信公众平台进入“公众号设置”的“功能设置”里填写“JS接口安全域名”。
         * 2. 如果发现在 Android 不能分享自定义内容，请到官网下载最新的包覆盖安装，Android 自定义分享接口需升级至 6.0.2.58 版本及以上。
         * 3. 常见问题及完整 JS-SDK 文档地址：http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html
         *
         * 开发中遇到问题详见文档“附录5-常见错误及解决办法”解决，如仍未能解决可通过以下渠道反馈：
         * 邮箱地址：weixin-open@qq.com
         * 邮件主题：【微信JS-SDK反馈】具体问题
         * 邮件内容说明：用简明的语言描述问题所在，并交代清楚遇到该问题的场景，可附上截屏图片，微信团队会尽快处理你的反馈。
         */
        wx.config({
            debug: false,
            appId: '${appId}',
            timestamp: ${timestamp},
            nonceStr: '${nonceStrc}',
            signature: '${signature}',
            jsApiList: [
                'checkJsApi',
                'chooseWXPay'
            ]
        });
    } else {
        $("#radio_apipay").attr("checked", "checked");
        $("#a_wxpay").hide();
    }
</script>


<script>
    function wxPay(timeStamp, nonceStr, package_prepay_id, paySign) {
        // 注意：此 Demo 使用 2.7 版本支付接口实现，建议使用此接口时参考微信支付相关最新文档。
        var orderId = $("#orderNo").val();
        wx.chooseWXPay({
            timestamp: timeStamp,
            nonceStr: nonceStr,
            package: package_prepay_id,
            signType: 'MD5', // 注意：新版支付接口使用 MD5 加密
            paySign: paySign,
            success: function (res) {
                // 支付成功后的回调函数
                alert("支付成功");
                window.location.href = pageUrl('/order/success') + "?orderId=" + orderId;
            },
            fail: function (res) {
                alert("支付失败");

            },
            cancel: function (res) {
                alert("取消支付");
            }
        });
    }
</script>
<script type="text/javascript" src="<c:url value="/resources/js/wx/wx_js.js"/>"></script>

</body>
</html>
