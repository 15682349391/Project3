<%--
  Created by IntelliJ IDEA.
  User: 38272
  Date: 2020/5/2
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <span>欢迎<span class="um_span"></span>到图书借阅系统</span>${sessionScope.user.username}
    <a href="pages/order/order.jsp">我的借阅</a>
    <a href="userServlet?action=logout" id="logout">注销</a>
    <a href="index.jsp">返回</a>
</div>

<script type="text/javascript">
    $("#logout").click(function () {
        return confirm("确认注销登录？");
    })
</script>