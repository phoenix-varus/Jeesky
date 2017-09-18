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
			data : {
				username : $("username").val(),
				password : $("password").val()
			},
			url : "../l/login",
			contenttype : "application/x-www-form-urlencoded;charset=utf-8",
			success : function(data) {
				if (data.status == "success") {
					location.href = "../s/index";
				}
			},
			error : function(e) {
				$("#i-error-div").html("登录失败！" + $("#i-error-div").html());
				$("#i-error-div").show();
			}
		});
	} else {
		$("#i-error-div").html("登录失败！" + $("#i-error-div").html());
		$("#i-error-div").show();
	}
}

function toregister() {
	window.location.href = "../l/register.action";
}

function register() {
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
			},
			cpassword : {
				required : true,
				equalTo : "#password"
			}
		},
		messages : {
			username : {
				required : "请输入用户名"
			},
			password : {
				required : "请输入密码"
			},
			cpassword : {
				required : "请再次输入密码",
				equalTo : "两次密码输入不一致"
			}
		},
		success : "valid"
	});
	if ($("#username").hasClass("valid") && $("password").hasClass("valid")
			&& $("cpassword").hasClass("valid")) {
		$.ajax({
			data : {
				username : $("username").val(),
				password : $("password").val()
			},
			url : "../l/register.action",
			contenttype : "application/x-www-form-urlencoded;charset=utf-8",
			success : function(data) {
				if (data.status == "success") {
					location.href = "../s/index";
				}
			},
			error : function(e) {
				$("#i-error-div").html("注册失败！" + $("#i-error-div").html());
				$("#i-error-div").show();
			}
		});
	} else {
		$("#i-error-div").html("注册失败！" + $("#i-error-div").html());
		$("#i-error-div").show();
	}
}