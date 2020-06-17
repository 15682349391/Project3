<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书借阅登录页面</title>
	<%--		静态包含base，css，js--%>
	<%@include file="/pages/common/head.jsp"%>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.png" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">图书借阅系统</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>欢迎登陆</h1>
								<a href="pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
<%--								<span class="errorMsg">请输入用户名和密码</span>--%>
								<span class="errorMsg">
<%--									<%=request.getAttribute("msg")==null ? "请输入用户名和密码": request.getAttribute("msg")%>--%>
									${ empty requestScope.username ? "请输入用户名和密码": requestScope.username}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="login"/>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username"
<%--									value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"--%>
									value="${requestScope.username}"
									/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="login_btn" />
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>