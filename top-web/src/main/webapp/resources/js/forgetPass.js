/**
 * Created by david on 2015/6/11.
 */

/* 实时监测验证码填写 */
$(function() {
    $("#inputVerifyCode").bind('input propertychange', function () {
       $("#captcha-btn").removeClass('has-error');
    });

    /**
     *发送验证码
     * */
    $("#captcha-btn").click(function () {
        if (!(/^0?1[3|4|5|7|8][0-9]\d{8}$/.test($("#mobile").val()))) {
            $("#register-btn").attr('disabled', true);
            $("#captcha-btn").attr('disabled', true);
            $("#alertTip").show();
            $("#alertTip").html('请输入正确的手机号');
            $("#mobile").focus();
            $("#mobile").attr('placeholder', '请输入正确的手机号');
        } else {
            var data = $("#mobile").val();
            $.ajax({
                cache: true,
                type: "GET",
                url: pageUrl('/user/sendVerifyCodeForForget'),
                data: {mobile: data, check: true},
                async: false,
                error: function (request) {
                    console.log(data);
                    alert('出错了');
                },
                success: function (data) {
//                    console.log(data);
                    if (data.code == "1") {
                        if (data.data.length == 6) {
                            setCookie("captchaCode", data.data, 5);
                            $("#mobile").attr('readonly', true);
                            time(this);
                        } else {
                            $("#alertTip").show();
                            $("#alertTip").html('获取验证码失败');
                        }
                    } else {
                        if (data.msg == "USER_NOT_FOUND") {
                            $("#alertTip").show();
                            $("#alertTip").html('用户尚未注册');
                        } else {
                            $("#alertTip").show();
                            $("#alertTip").html('获取验证码失败');
                        }
                    }
                }
            })
        }
    });
})

/*倒计时*/
var step = 59;
function time(o) {
    $("#captcha-btn").attr("disabled", true);//设置disabled属性
    $('#captcha-btn').val('重新发送(60)');
    var _res = setInterval(function () {
        $('#captcha-btn').val('重新发送(' + step + ')');
        step -= 1;
        if (step <= 0) {
            $("#captcha-btn").removeAttr("disabled"); //移除disabled属性
            $('#captcha-btn').val('发送验证码');
            clearInterval(_res);//清除setInterval
        }
    }, 1000);
}


function submitted() {
//        $("#register-btn").attr('disabled', true);
    if (checkDetails()) {
        var data = $('#register-form').serialize();
        $.ajax({
            cache: true,
            type: "POST",
            url: pageUrl('/user/forgetPassword'),
            data: data,
            async: false,
            error: function (request) {
                console.log(data);
                alert('新密码设置失败');
            },
            success: function (data) {
                console.log(data);
                $("#register-btn").attr('disabled', false);
                if (data == "SUCCESS") {
                    $("#alertTip").show();
                    $("#alertTip").html('新密码设置成功');
                    window.location.href = pageUrl('/home/login');
                } else {
                    $("#alertTip").show();
                    $("#alertTip").html('新密码设置失败');
                }
            }
        });
    }
}


/* 检查输入的信息有效性 */
function checkDetails() {
    $("#alertTip").hide();
    $("#mobileDiv").removeClass('has-error');
    $("#captchaDiv").removeClass('has-error');
    $("#passwordDiv").removeClass('has-error');
    $("#rePasswordDiv").removeClass('has-error');

    if ($("#mobile").val() != null && $("#mobile").val() != '') {
        if (!(/^0?1[3|4|5|7|8][0-9]\d{8}$/.test($("#mobile").val()))) {
            $("#alertTip").show();
            $("#alertTip").html('请输入正确的手机号');
            $("#mobile").focus();
            $("#mobile").attr('placeholder', '请输入正确的手机号');
            $("#mobileDiv").addClass('has-error');
            return false;
        }
    } else {
        $("#alertTip").show();
        $("#alertTip").html('请输入正确的手机号');
        $("#mobile").focus();
        $("#mobile").attr('placeholder', '请输入正确的手机号');
        $("#mobileDiv").addClass('has-error');
        return false;
    }

    var captchaCode = getCookie("captchaCode");
    var tmpCode = $("#captcha").val();
    if ($("#captcha").val() == '' || $("#captcha").val() == null || $("#captcha").val() != getCookie("captchaCode")) {
        $("#alertTip").show();
        $("#alertTip").html('验证码不正确');
        $("#captcha").focus();
        $("#captcha").attr('placeholder', '验证码不正确');
        $("#captchaDiv").addClass('has-error');
        return false;
    }
    if ($("#password").val() == '' || $("#password").val() == null) {
        $("#alertTip").show();
        $("#alertTip").html('请输入新密码');
        $("#password").focus();
        $("#password").attr('placeholder', '请输入新密码');
        $("#passwordDiv").addClass('has-error');
        return false;
    } else if ($("#password").val().length < 6) {
        $("#alertTip").show();
        $("#alertTip").html('请输入6-20位密码');
        $("#password").focus();
        $("#password").attr('placeholder', '请输入新密码');
        $("#passwordDiv").addClass('has-error');
        return false;
    }
    if ($("#rePassword").val() != $("#password").val()) {
        $("#alertTip").show();
        $("#alertTip").html('两次输入的密码不匹配');
        $("#rePassword").focus();
        $("#rePassword").attr('placeholder', '两次输入的密码不匹配');
        $("#rePasswordDiv").addClass('has-error');
        return false;
    }
    $("#register-button").attr('disabled', false);
    return true;
}


/**/
