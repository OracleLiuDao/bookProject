<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>

<%@include file="/pages/common/head.jsp"%>
	
	<script type="text/javascript">
		$(function () {
			//验证码的单击事件
			$("#cade_img").click(function () {
				this.src="${basePath}/kaptcha.jpg?d="+new Date();
			})




			 $("#sub_btn").click(function () {
				 //校验用户名
				 var nameValue = $("#username").val();
				 //正则/^[a-z0-9_-]{3,16}$/
				 var regular =/^[\u4e00-\u9fa5_a-zA-Z0-9]+$/;
				if(!regular.test(nameValue)){
					$("span.errorMsg").text("用户名不合法");

					return false;
				}

				//验证密码
				 var passValue = $("#password").val();
				 //正则/^[a-z0-9_-]{3,16}$/
				 var regular =/^\w{5,12}$/;
				 if(!regular.test(passValue)){
					 $("span.errorMsg").text("密码不合法");

					 return false;
				 }

				 //确认密码
				 var repValue = $("#repwd").val();
				if (passValue != repValue){
					$("span.errorMsg").text("两次密码不一致");
					return false;
				}
				//邮箱校验
				 var emailValue = $("#email").val();
				 //正则/^[a-z0-9_-]{3,16}$/
				 var regular =/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
				 if(!regular.test(emailValue)){
					 $("span.errorMsg").text("邮箱不合法");

					 return false;
				 }

				 //验证码

				 var codeValue = $("#code").val();
				 //去掉验证码的前后空格
				     codeValue =$.trim(codeValue);
				if (codeValue == null || codeValue == ""){
					$("span.errorMsg").text("验证码不能为空");

					return false;
				}






				 $("span.errorMsg").text("");
			 });
		});

	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">${empty requestScope.msg?"请填写注册信息":requestScope.msg}</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off"
										   tabindex="1" name="username" id="username" value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off"
										   tabindex="1" name="password" id="password" value="" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off"
										   tabindex="1" name="repwd" id="repwd" value=""/>
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off"
										   tabindex="1" name="email" id="email" value="${requestScope.email}"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 80px;" id="code" name="code"/>
									<img id="cade_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px" width="110px" height="40px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>