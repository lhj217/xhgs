<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
<%@ include file="common/header.jsp" %>
</head>
<body>
<div>
    <%@ include file="common/top.jsp" %>
    <div class="blankline"></div>
    <div class="container">
        <div class="list-group">
            <a href="${pageContext.request.contextPath}/${bookInfo.book_id}.html" class="list-group-item active">${bookInfo.book_name}全部章节</a>
            <c:forEach items="${chapters}" var="arr" varStatus="vs"><a href="${pageContext.request.contextPath}/${arr.book_id}/${arr.chapter_id}.html" class="list-group-item">${arr.chapter_title}</a></c:forEach>
        </div>
        <nav>
            <ul class="pager">
                <li><a href="${pageContext.request.contextPath}/chapter/${bookInfo.book_id}/${previousPageNum}.html">上一页</a></li>
                <li>
                    <select id="select_page" class="select-control" onchange="changePage()">
                    <c:forEach items="${groups}" var="arr"><option value="${arr.id}" <c:if test="${currentPageNum == arr.id}">selected="selected"</c:if>>${arr.value}</option></c:forEach>
                    </select>
                </li>
                <li><a href="${pageContext.request.contextPath}/chapter/${bookInfo.book_id}/${nextPageNum}.html">下一页</a></li>
            </ul>
        </nav>
    </div>
</div>
<%@ include file="common/footer.jsp" %>
</body>
<script>
    function changePage() {
        var checkValue = $("#select_page").val();
        location.href = "${pageContext.request.contextPath}/chapter/${bookInfo.book_id}/" + checkValue + ".html";
    }
</script>
</html>