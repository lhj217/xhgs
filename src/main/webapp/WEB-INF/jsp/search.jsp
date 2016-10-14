<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
<%@ include file="common/header.jsp"%>
</head>
<body>
<div>
    <%@ include file="common/top.jsp"%>
    <br>
    <div class="container">
        <form role="search" action="${pageContext.request.contextPath}/search/pageNum/0/detail.html" + $('#searchContent').val()>
        <div class="col-lg-13">
            <div class="input-group">
                <input type="text" id="searchContent" name="searchContent" class="form-control" placeholder="搜索书名、作者" value="${searchText}">
                <span class="input-group-btn">
					<button class="btn btn-default" type="submit">搜 索</button>
                </span>
            </div>
        </div>
        </form>
    </div>
    <br>
    <div class="container">
        <div class="panel panel-primary" style="height: ${height}px">
            <div class="panel-heading">
                <h3 class="panel-title">搜索结果</h3>
            </div>
            <div class="panel-body">
            	<c:choose><c:when test="${bookSize > 0}"><c:forEach items="${bookList}" var="arr" varStatus="vs"><a href="${pageContext.request.contextPath}/${arr.book_id}.html">
		        	<div style="height: 130px;" style=" float: left;">
		            	<div style="float: left; width: 100px">
		                	<img src="${website}/novelcover/${arr.book_id}.jpg" alt="" width="90" height="120">
		                </div>
		                <div>
		                	<ul class="list-unstyled">
		                    	<li><strong>${arr.book_name}</strong></li>
		                        <li>${arr.book_auth}</li>
		                        <li style="font-size: 12px;text-indent: 2em;height: 70px;text-overflow: ellipsis; overflow: hidden;">
		                        	${arr.book_summary}
		                        </li>
		                    </ul>
		                </div>
		             </div>
		         </a>
		         <hr style="margin-top: 0px;margin-bottom: 10px;"></c:forEach></c:when><c:otherwise><div style="text-align:center">没有搜到找到相关内容！</div></c:otherwise></c:choose>
            </div>
        </div>
    </div>
	<c:if test="${bookSize > 20}">
	    <nav>
	        <ul class="pager">
	            <li><a href="${pageContext.request.contextPath}/search/pageNum/${previousPageNum}/detail.html?searchContent=${searchText}">上一页</a></li>
	            <li><a href="${pageContext.request.contextPath}/search/pageNum/${nextPageNum}/detail.html?searchContent=${searchText}">下一页</a></li>
	        </ul>
	    </nav>
    </c:if>
</div>
<%@ include file="common/footer.jsp" %>
</body>
</html>