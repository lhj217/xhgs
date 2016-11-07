<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
<%@ include file="common/header.jsp"%>
</head>
<body>
<div>
    <%@ include file="common/top.jsp" %>
    <div class="blankline"></div>
	<div class="container">
		<ul class="nav nav-pills" style="width: 100%;text-align: left;">
			<li role="presentation" style="width: 99.5%;border:thin solid #00aeef;margin-left:-1px;margin-top:-1px"><a>男生分类</a></li>
		</ul>
		<ul class="nav nav-pills" style="width: 100%;text-align: center;">
			<li role="presentation" style="width: 33.3%;border:thin solid #00aeef;margin-left:-1px;margin-top:-1px"><a href="${pageContext.request.contextPath}/category/1/0.html">东方玄幻</a></li>
			<li role="presentation" style="width: 33.3%;border:thin solid #00aeef;margin-left:-1px;margin-top:-1px"><a href="${pageContext.request.contextPath}/category/1/0.html">古典仙侠</a></li>
			<li role="presentation" style="width: 33.3%;border:thin solid #00aeef;margin-left:-1px;margin-top:-1px"><a href="${pageContext.request.contextPath}/category/2/0.html">现代修真</a></li>
		</ul>
		<ul class="nav nav-pills" style="width: 100%;text-align: center;">
			<li role="presentation" style="width: 33.3%;border:thin solid #00aeef;margin-left:-1px;margin-top:-1px"><a href="${pageContext.request.contextPath}/category/3/0.html">都市生活</a></li>
			<li role="presentation" style="width: 33.3%;border:thin solid #00aeef;margin-left:-1px;margin-top:-1px"><a href="${pageContext.request.contextPath}/category/3/0.html">异术超能</a></li>
			<li role="presentation" style="width: 33.3%;border:thin solid #00aeef;margin-left:-1px;margin-top:-1px"><a href="${pageContext.request.contextPath}/category/4/0.html">架空历史</a></li>
		</ul>
		<ul class="nav nav-pills" style="width: 100%;text-align: center;">
			<li role="presentation" style="width: 33.3%;border:thin solid #00aeef;margin-left:-1px;margin-top:-1px"><a href="${pageContext.request.contextPath}/category/4/0.html">军事战争</a></li>
			<li role="presentation" style="width: 33.3%;border:thin solid #00aeef;margin-left:-1px;margin-top:-1px"><a href="${pageContext.request.contextPath}/category/6/0.html">虚拟网游</a></li>
			<li role="presentation" style="width: 33.3%;border:thin solid #00aeef;margin-left:-1px;margin-top:-1px"><a href="${pageContext.request.contextPath}/category/4/0.html">时空穿梭</a></li>
		</ul>
	</div>
	<div class="blankline"></div>
	<div class="container">
		<ul class="nav nav-pills" style="width: 100%;text-align: left;">
			<li role="presentation" style="width: 99.5%;border:thin solid #00aeef;margin-left:-1px;margin-top:-1px"><a>女生分类</a></li>
		</ul>
		<ul class="nav nav-pills" style="width: 100%;text-align: center;">
			<li role="presentation" style="width: 33.3%;border:thin solid #00aeef;margin-left:-1px;margin-top:-1px"><a href="${pageContext.request.contextPath}/category/3/0.html">古代言情</a></li>
			<li role="presentation" style="width: 33.3%;border:thin solid #00aeef;margin-left:-1px;margin-top:-1px"><a href="${pageContext.request.contextPath}/category/4/0.html">穿越重生</a></li>
			<li role="presentation" style="width: 33.3%;border:thin solid #00aeef;margin-left:-1px;margin-top:-1px"><a href="${pageContext.request.contextPath}/category/3/0.html">浪漫言情</a></li>
		</ul>
		<ul class="nav nav-pills" style="width: 100%;text-align: center;">
			<li role="presentation" style="width: 33.3%;border:thin solid #00aeef;margin-left:-1px;margin-top:-1px"><a href="${pageContext.request.contextPath}/category/3/0.html">高干军婚</a></li>
			<li role="presentation" style="width: 33.3%;border:thin solid #00aeef;margin-left:-1px;margin-top:-1px"><a href="${pageContext.request.contextPath}/category/3/0.html">忧伤青春</a></li>
			<li role="presentation" style="width: 33.3%;border:thin solid #00aeef;margin-left:-1px;margin-top:-1px"><a href="${pageContext.request.contextPath}/category/3/0.html">玄幻仙侠</a></li>
		</ul>
		<ul class="nav nav-pills" style="width: 100%;text-align: center;">
			<li role="presentation" style="width: 33.3%;border:thin solid #00aeef;margin-left:-1px;margin-top:-1px"><a href="${pageContext.request.contextPath}/category/3/0.html">都市幻想</a></li>
			<li role="presentation" style="width: 33.3%;border:thin solid #00aeef;margin-left:-1px;margin-top:-1px"><a href="${pageContext.request.contextPath}/category/8/0.html">悬疑灵异</a></li>
			<li role="presentation" style="width: 33.3%;border:thin solid #00aeef;margin-left:-1px;margin-top:-1px"><a href="${pageContext.request.contextPath}/category/3/0.html">校园爱情</a></li>
		</ul>
	</div>
</div>
<%@ include file="common/footer.jsp" %>
</body>
</html>