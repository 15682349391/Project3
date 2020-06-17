<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书单管理</title>
	<%--		静态包含base，css，js--%>
	<%@include file="/pages/common/head.jsp"%>
</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">借书管理系统</span>
		<%--管理菜单--%>
		<%@include file="/pages/common/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>日期</td>
				<td>用户名</td>
				<td>详情</td>
				<td>操作</td>
				
			</tr>		
			<tr>
				<td>2020.06.17</td>
				<td>张三</td>
				<td><a href="#">查看详情</a></td>
				<td><a href="#">确认还书</a></td>
			</tr>	
			
			<tr>
				<td>2020.06.10</td>
				<td>李四</td>
				<td><a href="#">查看详情</a></td>
				<td>已还</td>
			</tr>	
			
			<tr>
				<td>2020.06.11</td>
				<td>小王</td>
				<td><a href="#">查看详情</a></td>
				<td>已还</td>
			</tr>		
		</table>
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>