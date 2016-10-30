<header>
	<div class="login_top">
		<div class="logon-logo" onclick="location.href='${pageContext.request.contextPath}/';">
			<img src="http://m.xdhtxt.com/assets/imgs/logo.png" class="login-img" alt="免费小说在线阅读" title="免费小说在线阅读"><span>哨兵小说网</span>
		</div>
	</div>
	<ul class="nav nav-pills" style="width: 100%;text-align: center;border:thin solid #00aeef">
		<li role="presentation" <c:if test="${active == 0}">class="active"</c:if> style="width: 25%"><a href="${pageContext.request.contextPath}/">首页</a></li>
		<li role="presentation" <c:if test="${active == 1}">class="active"</c:if> style="width: 25%"><a href="${pageContext.request.contextPath}/category/88/0.html">分类</a></li>
		<li role="presentation" <c:if test="${active == 2}">class="active"</c:if> style="width: 25%"><a href="${pageContext.request.contextPath}/ranking.html">排行</a></li>
		<li role="presentation" <c:if test="${active == 3}">class="active"</c:if> style="width: 25%"><a href="${pageContext.request.contextPath}/category/99/0.html">完本</a></li>
	</ul>
	</header>
	<div class="carousel-inner" role="listbox"><div class="item active"></div></div>