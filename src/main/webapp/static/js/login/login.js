function login() {
	$("#i-login-form").validate({
		errorContainer : "#i-error-div",
		errorLabelContainer : $("#i-error-div"),
		wrapper : "li",
		rules : {
			username : {
				required : true
			},
			password : {
				required : true
			}
		},
		messages : {
			username : {
				required : "请输入用户名"
			},
			password : {
				required : "请输入密码"
			}
		},
		success : "valid"
	});
	if ($("#username").hasClass("valid") && $("password").hasClass("valid")) {
		$.ajax({
			url : "../l/login",
			contenttype : "application/x-www-form-urlencoded;charset=utf-8",
			success : function(data) {
				if (data.status == "success") {
					location.href = "../s/index";
				}
			},
			error : function(e) {

			}
		});
	} else {
		$("#i-error-div").html("登录失败！" + $("#i-error-div").html());
		$("#i-error-div").show();
	}
}

function register() {
	window.location.href = "../l/register.action";
}