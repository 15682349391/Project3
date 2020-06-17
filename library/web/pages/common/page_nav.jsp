<%--
  Created by IntelliJ IDEA.
  User: 38272
  Date: 2020/5/5
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--分页条的开始--%>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${ requestScope.page.url }&pageNo=1">首页</a>
        <a href="${ requestScope.page.url }&pageNo=${ requestScope.page.pageNo-1 }">上一页</a>
    </c:if>
    <c:if test="${requestScope.page.pageNo == 1}">
        <span>首页</span>
        <span>上一页</span>
    </c:if>

    <%--页码输出的开始--%>
    <c:choose>
        <c:when test="${requestScope.page.pageTotal <=5 }">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.pageTotal}"/>
        </c:when>

        <c:when test="${requestScope.page.pageTotal >5 }">
            <c:choose>
                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>

                <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal-3}">
                    <c:set var="begin" value="${requestScope.page.pageTotal-4}"/>
                    <c:set var="end" value="${requestScope.page.pageTotal}"/>
                </c:when>

                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNo-2}"/>
                    <c:set var="end" value="${requestScope.page.pageNo+2}"/>
                </c:otherwise>

            </c:choose>
        </c:when>
    </c:choose>

    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i == requestScope.page.pageNo}">
            【${i}】
        </c:if>
        <c:if test="${i != requestScope.page.pageNo}">
            <a href="${ requestScope.page.url }&pageNo=${i}">-${i}-</a>
        </c:if>
    </c:forEach>

    <%--页码输出的结束--%>

    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${ requestScope.page.url }&pageNo=${ requestScope.page.pageNo+1 }">下一页</a>
        <a href="${ requestScope.page.url }&pageNo=${ requestScope.page.pageTotal}">末页</a>
    </c:if>
    <c:if test="${requestScope.page.pageNo == requestScope.page.pageTotal}">
        <span>下一页</span>
        <span>末页</span>
    </c:if>

    共${ requestScope.page.pageTotal }页，${ requestScope.page.pageTotalCount }条记录 到第<input value="<%--${requestScope.page.pageNo}--%>" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">

    <script>
        $(function () {
            $("#searchPageBtn").click(function () {
                var pageNo = $("#pn_input").val();
                if(pageNo <= ${requestScope.page.pageTotal} && pageNo>0){
                    location.href =  "${pageScope.basePath}${ requestScope.page.url }&pageNo="+pageNo;
                }else {
                    alert("超出查询范围。");
                }
            })
        })
    </script>


</div>
<%--分页条的结束--%>
