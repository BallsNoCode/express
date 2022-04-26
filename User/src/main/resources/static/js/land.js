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


var Mobile_Boolean = false;

$('#mobile').blur(function () {
    if ((/^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/).test($("#mobile").val())) {
        Mobile_Boolean = true;
    } else {
        $('.mobile_hint').html("手机格式错误，请重新输入！").css("color", "red");
        Mobile_Boolean = false;
    }
});

/*手机验证*/

$('#mobile1').blur(function () {
    if ((/^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/).test($("#mobile1").val())) {
        Mobile_Boolean = true;
    } else {
        $('.mobile_hint1').html("手机格式错误，请重新输入！").css("color", "red");
        Mobile_Boolean = false;
    }
});