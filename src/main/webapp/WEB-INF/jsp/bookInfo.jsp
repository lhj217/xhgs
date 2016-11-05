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
        <div class="panel panel-primary" style="height: 215px">
            <div class="panel-heading">
                <h3 class="panel-title">作品详情</h3>
            </div>
            <div class="panel-body">
                <div style="float: left;white-space: nowrap">
                    <div style="float: left; width: 110px">
                        <img src="${website}/novelcover/${bookInfo.book_id}.jpg" alt="${bookInfo.book_id}" width="100" height="145">
                    </div>
                    <div>
                        <ul class="list-unstyled">
                            <li>小说名称：<strong>${bookInfo.book_name}</strong></li>
                            <li>小说作者：${bookInfo.book_auth}</li>
                            <li>小说类型：${bookInfo.type_name}</li>
                            <li>发布日期：${bookInfo.book_create_time}</li>
                            <li>更新时间：${bookInfo.book_update_time}</li>
                        </ul>
                        <a href="${pageContext.request.contextPath}/${bookInfo.book_id}/${bookInfo.chapter_id}.html">
                            <button type="button" class="btn btn-primary" style="background-color:#ff003b;border-color:#ff003b">开始阅读</button>
                        </a>
                        <a href="${pageContext.request.contextPath}/chapter/${bookInfo.book_id}/0.html">
                            <button type="button" class="btn btn-primary">目录</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="list-group">
			<a class="list-group-item active">${bookInfo.book_name}最新章节</a>
            <c:forEach items="${chapters}" var="arr" varStatus="vs"><a href="${pageContext.request.contextPath}/${arr.book_id}/${arr.chapter_id}.html" class="list-group-item">${arr.chapter_title}</a></c:forEach>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/chapter/${bookInfo.book_id}/0.html">
                <button type="button" class="btn btn-primary" style="width: 100%;margin-bottom: 20px;">全部章节</button>
            </a>
        </div>
        <div class="panel panel-primary" style="height: 220px">
            <div class="panel-heading">
                <h3 class="panel-title">作品简介</h3>
            </div>
            <div class="panel-body">
                <p style="text-indent: 2em;height: 160px;text-overflow: ellipsis; overflow: hidden;">${bookInfo.book_summary}</p>
            </div>
        </div>
    </div>
</div>
<!-- baidu tuijian -->
<div id="hm_t_113394"></div>
<div id="SOHUCS" class="container" sid="${bookInfo.book_id}"></div>
<script id="changyan_mobile_js" charset="utf-8" type="text/javascript" src="http://changyan.sohu.com/upload/mobile/wap-js/changyan_mobile.js?client_id=cysBUxuxo&conf=prod_a498fbc479c3602fcf956ee976fde4a8"></script>
<%@ include file="common/footer.jsp" %>
</body>
</html>
