<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%--		静态包含base，css，js--%>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			$(".delItem").click(function () {
				return confirm("确定要删除《"+$(this).parent().parent().find("td:first").text()+"》吗？");
			})

			$("#clear").click(function () {
				return confirm("确定要清空购物车吗？");
			})

			$(".updateCount").change(function () {

				var id = $(this).attr('bookId');
				var name = $(this).parent().parent().find("td:first").text();
				var countConfirm = confirm("确定修改《"+name+"》数量为:"+this.value);

				if (countConfirm) {
					location.href = "<%= scheme %>cartServlet?action=updateCount&count="+this.value+"&id="+id;
				} else {
					this.value = this.defaultValue;
				}

			})
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%--			静态包含登陆成功--%>
		<%@include file="/pages/common/login_sucess_menu.jsp"%>
	</div>
	
	<div id="main">

		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${sessionScope.cart.items}" var="items">
				<tr>
					<td>${items.value.name}</td>
					<td>
							<input bookId="${items.value.id}" class="updateCount" style="width: 60px" type="text" value="${items.value.count}"/>
					</td>
					<td>${items.value.price}</td>
					<td>${items.value.totalPrice}</td>
					<td><a class="delItem" href="<%= scheme %>cartServlet?action=deleteItem&id=${items.value.id}">删除</a></td>
				</tr>
			</c:forEach>
			<c:if test="${empty sessionScope.cart.items}">
				<tr>
					<td colspan="5">购物车空空如也。。。</td>
				</tr>
			</c:if>
		</table>
		<c:if test="${not empty sessionScope.cart.items}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a id="clear" href="<%= scheme %>cartServlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>


	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>