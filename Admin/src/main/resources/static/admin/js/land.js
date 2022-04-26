function option() {
    $(function () {
        $(".land_cont>.mui-row:gt(0)").hide();
        var hd = $(".land_title>div");
        hd.click(function () {
            var i_index = hd.index(this)
            $(this).addClass("addColor").siblings().removeClass("addColor");
            $(".land_cont .mui-row").eq(i_index).show().siblings().hide();
        })
    })
}

option();


var password_Boolean = false;
var Mobile_Boolean = false;

$('#phone1').blur(function () {
    if ((/^1[34578]\d{9}$/).test($("#phone1").val())) {
        Mobile_Boolean = true;
    } else {
        $('.mobile_hint').html("手机格式错误，请重新输入！").css("color", "red");
        Mobile_Boolean = false;
    }
});

/*手机验证*/

$('#phone2').blur(function () {
    if ((/^1[34578]\d{9}$/).test($("#phone2").val())) {
        $('.mobile_hint1').html("恭喜你，可以注册!").css("color", "green");
        Mobile_Boolean = true;
    } else {
        $('.mobile_hint1').html("手机格式错误，请重新输入！").css("color", "red");
        Mobile_Boolean = false;
    }
});

/*手机验证*/

$('.reg_password').blur(function () {
    if ((/^[a-z0-9_-]{6,16}$/).test($(".reg_password").val())) {
        $('.password_hint').html("恭喜你，可以使用!").css("color", "green");
        password_Boolean = true;
    } else {
        $('.password_hint').html("密码格式错误，请重新输入").css("color", "red");
        password_Boolean = false;
    }
});

/*密码验证*/

$('.reg_password1').blur(function () {
    if ((/^[a-z0-9_-]{6,16}$/).test($(".reg_password1").val())) {
        $('.password_hint1').html("恭喜你，可以使用!").css("color", "green");
        password_Boolean = true;
    } else {
        $('.password_hint1').html("密码格式错误，请重新输入").css("color", "red");
        password_Boolean = false;
    }
});



	