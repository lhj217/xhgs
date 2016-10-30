<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
<%@ include file="common/header.jsp"%>
</head>
<body>
<div>
    <%@ include file="common/top.jsp" %>
    <div class="blankline"></div>
    <div class="container" style="text-align:center">
        <div>
            <a href="${pageContext.request.contextPath}/category/1/0.html" class="btn btn-primary" role="button">玄幻魔法</a>
            <a href="${pageContext.request.contextPath}/category/2/0.html" class="btn btn-primary" role="button">武侠修真</a>
            <a href="${pageContext.request.contextPath}/category/3/0.html" class="btn btn-primary" role="button">都市言情</a>
        </div>
        <br>
        <div>
            <a href="${pageContext.request.contextPath}/category/4/0.html" class="btn btn-primary" role="button">历史军事</a>
            <a href="${pageContext.request.contextPath}/category/5/0.html" class="btn btn-primary" role="button">侦探推理</a>
            <a href="${pageContext.request.contextPath}/category/6/0.html" class="btn btn-primary" role="button">网游动漫</a>
        </div>
        <br>
        <div>
            <a href="${pageContext.request.contextPath}/category/7/0.html" class="btn btn-primary" role="button">科幻小说</a>
            <a href="${pageContext.request.contextPath}/category/8/0.html" class="btn btn-primary" role="button">恐怖灵异</a>
            <a href="${pageContext.request.contextPath}/category/9/0.html" class="btn btn-primary" role="button">散文诗词</a>
        </div>
    </div>
    <br>
</div>
<%@ include file="common/footer.jsp" %>
</body>
</html>