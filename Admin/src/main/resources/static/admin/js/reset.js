var Mobile_Boolean = false;
var password_Boolean = false;
var varconfirm_Boolean = false;

$('#mobile').blur(function() {
	if((/^1[34578]\d{9}$/).test($("#mobile").val())) {
		$('.mobile_hint').html("恭喜你，可以注册").css("color", "green");
		Mobile_Boolean = true;
	} else {
		$('.mobile_hint').html("手机格式错误，请重新输入！").css("color", "red");
		Mobile_Boolean = false;
	}
});

/*手机验证*/
// password
$('.reg_password').blur(function() {
	if((/^[a-z0-9_-]{6,16}$/).test($(".reg_password").val())) {
		$('.password_hint').html("恭喜你，可以使用！").css("color", "green");
		password_Boolean = true;
	} else {
		$('.password_hint').html("密码格式错误，请重新输入").css("color", "red");
		password_Boolean = false;
	}
});

// password_confirm
$('.reg_confirm').blur(function() {
	if(($(".reg_password").val()) == ($(".reg_confirm").val())) {
		$('.confirm_hint').html("密码正确！").css("color", "green");
		varconfirm_Boolean = true;
	} else {
		$('.confirm_hint').html("两次密码输入不一致，请重新输入").css("color", "red");
		varconfirm_Boolean = false;
	}
});
$('.red_button2').click(function() {
	if(password_Boolean && Mobile_Boolean == true) {
		alert("重置成功");
	} else {
		alert("请完善信息");
	}
});