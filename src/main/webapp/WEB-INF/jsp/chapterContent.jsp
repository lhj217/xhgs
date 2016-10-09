<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
<%@ include file="common/header.jsp"%>
</head>
<body>
<div>
    <%@ include file="common/top.jsp"%>    
    <div class="container">
        <nav>
            <ul class="pager">
                <li><c:choose><c:when test="${chapterInfo.chapter_id == minChapterId}"><a href="${pageContext.request.contextPath}/chapter/${chapterInfo.book_id}/0.html">上一章</a></c:when><c:otherwise><a href="${pageContext.request.contextPath}/${chapterInfo.book_id}/${chapterInfo.previous_chapter_id}.html" >上一章</a></c:otherwise></c:choose></li>
                <li><a href="${pageContext.request.contextPath}/chapter/${chapterInfo.book_id}/0.html">目 录</a></li>
                <li><c:choose><c:when test="${chapterInfo.chapter_id == maxChapterId}"><a href="${pageContext.request.contextPath}/chapter/${chapterInfo.book_id}/0.html">下一章</a></c:when><c:otherwise><a href="${pageContext.request.contextPath}/${chapterInfo.book_id}/${chapterInfo.next_chapter_id}.html">下一章</a></c:otherwise></c:choose></li>
            </ul>
        </nav>
        <div class="row">
            <div class="col-lg-12">
                <h3 style="font-size: 22px" align='center'><a href="${pageContext.request.contextPath}/chapter/${chapterInfo.book_id}/0.html">${bookName}</a></h3>
                <h4 style="font-size: 20px" align='center'>${chapterInfo.chapter_title}</h4>
                <br>
                <div>${chapterContent}</div>
            </div>
        </div>
        <nav>
            <ul class="pager">
                <li><c:choose><c:when test="${chapterInfo.chapter_id == minChapterId}"><a href="${pageContext.request.contextPath}/chapter/${chapterInfo.book_id}/0.html">上一章</a></c:when><c:otherwise><a href="${pageContext.request.contextPath}/${chapterInfo.book_id}/${chapterInfo.previous_chapter_id}.html" >上一章</a></c:otherwise></c:choose></li>
                <li><a href="${pageContext.request.contextPath}/chapter/${chapterInfo.book_id}/0.html">目 录</a></li>
                <li><c:choose><c:when test="${chapterInfo.chapter_id == maxChapterId}"><a href="${pageContext.request.contextPath}/chapter/${chapterInfo.book_id}/0.html">下一章</a></c:when><c:otherwise><a href="${pageContext.request.contextPath}/${chapterInfo.book_id}/${chapterInfo.next_chapter_id}.html">下一章</a></c:otherwise></c:choose></li>
            </ul>
        </nav>
    </div>
</div>
<%@ include file="common/footer.jsp" %>
</body>
</html>