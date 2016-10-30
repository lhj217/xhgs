<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
<%@ include file="common/header.jsp"%>
</head>
<body>
<div>
    <%@ include file="common/top.jsp"%>
    <div class="blankline"></div>
    <div class="container">
        <div class="list-group">
            <a href="#" class="list-group-item active">当日排行</a>
            <c:forEach items="${dayBooks}" var="arr" varStatus="vs"><a href="${pageContext.request.contextPath}/${arr.book_id}.html" class="list-group-item">${arr.book_name}<span class="badge">${arr.read_count}</span></a></c:forEach>
        </div>
        <div class="list-group">
            <a href="#" class="list-group-item active">本周排行</a>
            <c:forEach items="${weekBooks}" var="arr" varStatus="vs"><a href="${pageContext.request.contextPath}/${arr.book_id}.html" class="list-group-item">${arr.book_name}<span class="badge">${arr.read_count}</span></a></c:forEach>
        </div>
        <div class="list-group">
            <a href="#" class="list-group-item active">本月排行</a>
            <c:forEach items="${monthBooks}" var="arr" varStatus="vs"><a href="${pageContext.request.contextPath}/${arr.book_id}.html" class="list-group-item">${arr.book_name}<span class="badge">${arr.read_count}</span></a></c:forEach>
        </div>
        <div class="list-group">
            <a href="#" class="list-group-item active">总排行</a>
            <c:forEach items="${countBooks}" var="arr" varStatus="vs"><a href="${pageContext.request.contextPath}/${arr.book_id}.html" class="list-group-item">${arr.book_name}<span class="badge">${arr.read_count}</span></a></c:forEach>
        </div>
    </div>
</div>
<%@ include file="common/footer.jsp" %>
</body>
</html>