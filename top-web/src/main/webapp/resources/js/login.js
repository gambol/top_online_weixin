/**
 * Created by david on 2015/6/11.
 */
function login() {
    if (checkDetails()) {
        var data = $('#login-form').serialize();
        var mobile = $('#mobile').val();
        var password = $('#password').val();
        $.ajax({
            cache: true,
            type: "POST",
            beforeSend: function (XMLHttpRequest) {
                XMLHttpRequest.setRequestHeader("Authorization", "Basic " + BASE64.encoder(mobile + ":" + password));
            },
            url: pageUrl('/auth/login'),
            data: data,
            async: false,
            error: function (request) {
                console.log(data);
                alert('网络异常');
            },
            success: function (data) {
//                    console.log(data);
//                if (data.success == "true") {
                if (data.success) {
                    window.location.href = pageUrl('/home/enroll');
                } else {
                    alert("用户名密码错误");
                }
            }
        })
    }
}

/* 检验登陆信息输入合法性 */
function checkDetails() {
    if ($("#mobile").val() != null && $("#mobile").val() != '') {
        if (!(/^0?1[3|4|5|7|8][0-9]\d{8}$/.test($("#mobile").val()))) {
            $("#mobile").focus();
            $("#mobile").attr('placeholder', '请输入正确的手机号');
            $("#mobileDiv").addClass('has-error');
            return false;
        }
    } else {
        $("#mobile").focus();
        $("#mobile").attr('placeholder', '请输入正确的手机号');
        $("#mobileDiv").addClass('has-error');
        return false;
    }

    if ($("#password").val() == '' || $("#password").val() == null) {
        $("#password").focus();
        $("#password").attr('placeholder', '请输入密码');
        $("#passwordDiv").addClass('has-error');
        return false;
    }

    return true;
}
