<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结算页面</title>
	<%--		静态包含base，css，js--%>
	<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">提交借书</span>
		<%--			静态包含登陆成功--%>
		<%@include file="/pages/common/login_sucess_menu.jsp"%>
	</div>
	
	<div id="main">


		<c:if test="${empty sessionScope.orderId}">
			<h1>服务异常，提交失败。</h1>
		</c:if>


		<c:if test="${not empty sessionScope.orderId}">
			<h1>你的借书单已提交，借书号为${sessionScope.orderId}</h1>
		</c:if>

	
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>