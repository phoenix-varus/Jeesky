function login() {
	$.ajax({
		url : "../l/login",
		contenttype : "application/x-www-form-urlencoded;charset=utf-8",
		success : function(data) {
			var xx = data;
		},
		error : function(e) {

		}
	});
}

function register() {
	window.location.href = "../l/register.action";
}