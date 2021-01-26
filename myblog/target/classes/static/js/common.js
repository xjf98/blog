
/**
 * 登录页面开始
 */
 $(".globalLoginBtn").on("click", login_popup), 
 
 $(".globalLogin").on("click", function() {
		login_form_submit();
	})

function login_popup() {
	$("#id_account_l").val(""),
	$("#id_password_l").val(""), 
	$("#login-form-tips").hide(),
	$("#loginModal").modal("show")
}

function login_form_submit() {
	
//	$.ajax({
//		type: "POST",
//		url: "/login",
//		data: $("#login_form").serialize(),
//		beforeSend: function() {
//			$("#login_btn").html("登录中..."), $("#login_btn").attr("disabled", "disabled")
//		},
//		success: function(e) {	
////		$("#loginModal").modal("hide");
////		window.location.reload();
//		},
//		complete: function() {
//			$("#login_btn").html("登录"), $("#login_btn").removeAttr("disabled")
//		}
//	})
	 $("#login_form").submit();
}


/**
 * 登录页面结束
 */
	



/**
 * 注册页面开始
 */

$(".globalRegistBtn").on("click", regist_popup), 

$(".globalRegist").on("click", function() {
  	regist_form_submit();
	}),
	
$("#getphonecode").on("click",getPhoneCode)
	
function regist_popup() {
	$("#email").val(""),
	$("#password").val(""), 
	$("#id_phone_l").val(""), 
	$("#regist-form-tips").hide(),
	$("#registModal").modal("show"),
	$("#phonecode").hide()
}

/**
 * 注册ajax
 * @returns
 */
function regist_form_submit() {
	var email = document.getElementById("email").value;
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var passreg= /^[\w]{6,12}$/;
	var emailreg=/^\w+@[a-z0-9]+\.[a-z]+$/i;
	
	if(email != " " && email && emailreg.test(email) && username != " " && username && password != " " && password && passreg.test(password)){
		$.ajax({
		cache: !1,
		type: "POST",
		url: "/regist/registUser",
		data: $("#regist_form").serialize(),
		beforeSend: function() {
			$("#regist_btn").html("注册中..."), $("#regist_btn").attr("disabled", "disabled")
		},
		success: function(val) {	
			console.log(val);
			if(val.status == 0){
				$("#registModl").modal("hide");
				window.location.reload();
			}
		},
		complete: function() {
			$("#regist_btn").html("注册"), $("#regist_btn").removeAttr("disabled")
		}
	})
	}
	else{
		alert("格式有误");
	}

}

/**
 * 获取手机验证码以及弹出底部层
 * @returns
 */
function getPhoneCode(){
	$("#phonecode").show();
}

/**
 * 检查用户名格式
 * @returns
 */
function checkUsername(){
	var username = document.getElementById("username").value;
	if(typeof(username) == "undefined"){
		alert("ff");
		return;
	}
	else if(username == " "){
		alert("用户名不能为空格");
		return;
	}
	else if(!username){
		alert("用户名不能为空");
		return;
	}
   
}

/**
 * 校验邮箱格式
 */
function checkEmail(){
	
	var email = document.getElementById("email").value;
	if(typeof(email) == "undefined"){
		alert("ff");
		return;
	}
	else if(email == " "){
		alert("邮箱不能为空格");
		return;
	}
	else if(!email){
		alert("邮箱不能为空");
		return;
	}
	//正则匹配邮箱格式
	var rex=/^\w+@[a-z0-9]+\.[a-z]+$/i;
	if(rex.test(email)){
	
	}
	else{
		alert("邮箱格式输入有误");
	}
	
}

/**
 * 校验密码格式
 */
function checkPassword(){
	var password = document.getElementById("password").value;
	if(typeof(password) == "undefined"){
		alert("ff");
		return;
	}
	else if(password == " "){
		alert("密码不能为空格");
		return;
	}
	else if(!password){
		alert("密码不能为空");
		return;
	}
	//正则匹配密码格式
	var rex= /^[\w]{6,12}$/;
	if(rex.test(password)){
		
	}
	else{
		alert("密码格式为6到12位的字母，数字，下划线");
	}
	
}
