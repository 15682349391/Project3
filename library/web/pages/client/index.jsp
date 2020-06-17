<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Scanner" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>借书首页</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {

			$("button.addToCart").click(function () {

				var bookId = $(this).attr("bookId");

				//location.href = "<%= scheme %>cartServlet?action=addItem&id="+bookId;

				$.getJSON(

						"<%= scheme %>cartServlet",
						"action=ajaxAddItem&id="+bookId,
						function (data) {

							console.log(data);
							$("#cartTotalCount").text("您的借书单中有" + data.totalCount + "本书。") ;
							$("#lastName").html("您刚刚将<span style=\"color: #ff0000\" id=\"lastName\">" + data.lastName + "</span>加入到了书单中");

						}

				);
			})

			$("#logout").click(function () {
				return confirm("确认注销登录？");
			});


		})
	</script>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif" >
		<span class="wel_word">图书借阅系统</span>
		<div>
			<c:if test="${empty sessionScope.user}">
				<a href="pages/user/login.jsp">登录</a> |
				<a href="pages/user/regist.jsp">注册</a>
			</c:if>



			<c:if test="${not empty sessionScope.user}">
				<span>欢迎<span class="um_span">${sessionScope.user.username}<%--</span>光临尚硅谷书城</span>--%>
				<a href="pages/order/order.jsp">我的书单</a>
				<a id="logout" href="userServlet?action=logout">注销</a>&nbsp;
			</c:if>

			<a href="pages/cart/cart.jsp">书单</a>



			<c:if test="${sessionScope.user.username == 'admin'}">
				<span>当前管理员：<span class="um_span">${sessionScope.user.username}<%--</span>光临尚硅谷书城</span>--%>
			<a href="pages/manager/manager.jsp">后台管理</a>
			</c:if>


		</div>

	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="client/bookServlet" method="get">
					<input type="hidden" name="action" value="pageByName">
					查找：<input id="search" width="90px" type="text" name="search" value="">
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">

				<c:if test="${empty sessionScope.cart.items}">
					<span id="cartTotalCount"></span>
					<div id="lastName">
						<span style="color: red" >借书单空空如也。。</span>
					</div>
				</c:if>
				<c:if test="${not empty sessionScope.cart.items}">
					<span id="cartTotalCount">您的书单中有${sessionScope.cart.totalCount}本书</span>
					<div id="lastName">
						您刚刚将<span style="color: red" id="lastName">${sessionScope.lastName}</span>加入到了书单中
					</div>
				</c:if>
			</div>


			<c:forEach items="${requestScope.page.item}" var="book">
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="static/img/default.jpg" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">书名:</span>
						<span class="sp2">${book.name}</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">${book.author}</span>
					</div>
					<div class="book_price">
						<span class="sp1">出版社:</span>
						<span class="sp2">${book.publish}</span>
					</div>
					<div class="book_sales">
						<span class="sp1">书架号:</span>
						<span class="sp2">${book.num}</span>
					</div>
					<div class="book_amount">
						<span class="sp1">剩余:</span>
						<span class="sp2">${book.stock}本</span>
					</div>
					<div class="book_add">
						<button bookId="${book.id}" class="addToCart">加入借书单</button>
					</div>
				</div>
			</div>
			</c:forEach>

		</div>

		<%@include file="/pages/common/page_nav.jsp"%>

	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>