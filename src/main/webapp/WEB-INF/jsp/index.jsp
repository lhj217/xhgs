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
        <form  role="search" action="${pageContext.request.contextPath}/search/pageNum/0/detail.html">
            <div class="col-lg-13">
                <div class="input-group">
                    <input type="text" id="searchContent" name="searchContent" class="form-control" placeholder="搜索书名、作者">
                    <span class="input-group-btn">
					    <button class="btn btn-default" type="submit">搜 索</button>
				    </span>
                </div>
            </div>
        </form>
    </div>
    <div class="blankline"></div>
    <div class="container">
        <div class="panel panel-primary" style="height: 450px">
            <div class="panel-heading">
                <h3 class="panel-title">热门小说</h3>
            </div>
            <div class="panel-body">
                <c:forEach items="${homeBooks}" var="arr" varStatus="vs"><div style="height: 130px;" style=" float: left;">
					<a href="${pageContext.request.contextPath}/${arr.book_id}.html">
                        <div style="float: left; width: 100px">
                        	<img src="${website}/novelcover/${arr.book_id}.jpg" alt="${arr.book_name}" width="90" height="120">
                        </div>
                        <div>
                            <ul class="list-unstyled">
                            	<li>${arr.book_name}</li>
                                <li>${arr.book_auth}</li>
                                <li style="font-size: 12px;text-indent: 2em;height: 70px;text-overflow: ellipsis; overflow: hidden;">
                                	${arr.book_summary}
                                </li>
                        	</ul>
                    	</div>
					</a>
                </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <div class="container">
    	<c:forEach items="${hotBooks}" var="arr" varStatus="vs"><div class="col-xs-4 portfolio-item" style="padding-right:0px;padding-left:0px">
        	<a class="thumbnail" href="${pageContext.request.contextPath}/${arr.book_id}.html"><img class="img-responsive" src="${website}/novelcover/${arr.book_id}.jpg" alt="${arr.book_name}"></a>
        	<h5 align="center"><a href="${pageContext.request.contextPath}/${arr.book_id}.html">${arr.book_name}</a></h5>
        </div></c:forEach>
    </div>
    <div class="container">
        <div style="margin: 0 auto;">
            <div class="list-group">
                <a class="list-group-item active">最近更新</a>
                <c:forEach items="${updateBooks}" var="arr" varStatus="vs"><a href="${pageContext.request.contextPath}/${arr.book_id}.html" class="list-group-item">${arr.book_name}<span class="badge">${arr.book_update_time}</span></a></c:forEach>
            </div>
        </div>
    </div>
</div>
<%@ include file="common/footer.jsp" %>
</body>
</html>