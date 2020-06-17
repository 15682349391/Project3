<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>尚硅谷会员注册页面</title>
<%--		静态包含base，css，js--%>
		<%@include file="/pages/common/head.jsp"%>
		<script type="text/javascript">

			$(function () {

				$("#username").blur(function () {

					var username = this.value;

					var url = "<%= scheme %>" + "userServlet";

					$.getJSON(

							url,
							"action=ajaxExistUsername&username=" + username,
							function (data) {

								console.log(data);

								if (data.existUsername) {
									$(".errorMsg").text("用户名已存在!");
								} else {
									$(".errorMsg").text("用户名可用!");
									$(".errorMsg").css("color","green");
								}
							}
					);
				})



				$("#code_img").click(function () {
					/*alert("<%= scheme %>");
					alert("${pageContext.getAttribute("basePath")}");*/
					this.src = "<%= scheme %>kaptchaServlet.jpg?" + new Date();
				})


				$("#sub_btn").click(function () {
					var userName = $("#username").val();
					var usernamepatt = /^\w{5,12}$/;
					if(!usernamepatt.test(userName)){
						$(".errorMsg").text("用户名不合法。");
						return false;
					}

					var passwordText = $("#password").val();
					var repwdText = $("#repwd").val();
					var passwordpatt = /^\w{5,12}$/;
					if(!passwordpatt.test(passwordText)){
						$(".errorMsg").text("密码不合法。");
						return false;
					}if(passwordText != repwdText){
						$(".errorMsg").text("两次密码输入不一致");
						return false;
					}

					var emailText = $("#email").val();
					var emailpatt = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
					if(!emailpatt.test(emailText)){
						$(".errorMsg").text("请输入正确的邮箱格式。");
						return false;
					}

					var codeText = $("#code").val();
					var codeText = $.trim(codeText);
					if(codeText == ""){
						$(".errorMsg").text("验证码不能为空。");
						return false;
					}


					$(".errorMsg").text("");

				})

				$("#login").click(function () {

					alert("<%= scheme %>index.jsp");
					location.href = "<%= scheme %>index.jsp";

				})
			})
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
			<img class="logo_img" alt="" src="static/img/logo.png" >
		</div>

			<div class="login_banner">

				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>

				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册会员</h1>
								<span class="errorMsg"><%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%></span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist"/>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username"
<%--											value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"--%>
											value="${requestScope.username}"
									/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password"/>
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   autocomplete="off" tabindex="1" name="email" id="email"
<%--										   value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"--%>
										   value="${requestScope.email}"
									/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" name="code" style="width: 100px;" id="code"/>
									<img alt="" src="kaptchaServlet.jpg" style="float: right; margin-right: 40px" width="140px" id="code_img">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									<a href="pages/user/login.jsp">登录</a>
								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/footer.jsp"%>
	</body>
</html>