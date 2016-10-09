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
        <div class="panel panel-primary" style="height: 2875px">
            <div class="panel-heading">
                <h3 class="panel-title">${typeName}</h3>
            </div>
            <div class="panel-body">
                <c:forEach items="${bookList}" var="arr" varStatus="vs"><div>
                    <a href="${pageContext.request.contextPath}/${arr.book_id}.html">
                    	<div style="height: 130px;" style=" float: left;">
	                        <div style="float: left; width: 100px">
	                        	<img src="${website}/novelcover/${arr.book_id}.jpg" alt="" width="90" height="120">
	                        </div>
	                        <div>
	                            <ul class="list-unstyled">
	                            	<li><strong>${arr.book_name}</strong></li>
	                                <li>${arr.book_auth}</li>
	                                <li style="font-size: 12px;text-indent: 2em;height: 70px;text-overflow: ellipsis; overflow: hidden;">${arr.book_summary}</li>
	                            </ul>
	                        </div>
                       </div>
                    </a>
                	<hr style="margin-top: 0px;margin-bottom: 10px;">
                </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <nav>
        <ul class="pager">
            <li><a href="${pageContext.request.contextPath}/category/${bookType}/${previousPageNum}.html">上一页</a></li>
            <li>
            	<select id="select_page" class="select-control" onchange="changePage()">
                <c:forEach items="${groups}" var="arr"><option value="${arr.id}" <c:if test="${currentPageNum == arr.id}">selected="selected"</c:if>>${arr.value}</option></c:forEach>
                </select>
            </li>
            <li><a href="${pageContext.request.contextPath}/category/${bookType}/${nextPageNum}.html">下一页</a></li>
        </ul>
    </nav>
</div>
<%@ include file="common/footer.jsp" %>
</body>
<script>
    function changePage() {
        var checkValue = $("#select_page").val();
        location.href = "${pageContext.request.contextPath}/category/${bookType}/" + checkValue + ".html";
    }
</script>
</html>