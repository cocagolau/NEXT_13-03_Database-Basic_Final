<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file="/head.html" %>
	<title>Used Car</title>
	<link rel="stylesheet" type="text/css" href="/stylesheets/home.css" />
	<script type="text/javascript" src="/javascripts/home.js"></script>
</head>

<body>
	<div id="wrap">
		<header>
			<div id="statusBar">
				<h1 id="logo"><a href="/">Used Car</a></h1>
				
				<c:choose>
					<c:when test= "${not empty sessionScope.userEmail}">
						<div class="signForm">
							<div>${sessionScope.userName} 님</div>
							<div><a href="/sign/out">로그아웃</a></div>
						</div>
						<c:if test= "${sessionScope.userEmail == 'admin'}">
							<h2 id="admin" class="subMenu"><a href="/admin/main">관리자</a></h2>	
						</c:if>
					
					
						<h2 id="registerUsedCar" class="subMenu"><a href="/register/usedcar">매물 등록</a></h2>	
					</c:when>
					
					<c:otherwise>
						<div class="signForm">
							<form name="loginForm" method="post" action="/sign/in">
								<input type="text" name="email" placeholder="email"></input>
								<input type="password" name="password" placeholder="password"></input>
								<button type="submit">로그인</button>
							</form>
						</div>
						
						<h2 id="registerDealer" class="subMenu"><a href="/register/dealer">판매자 등록</a></h2>	
					</c:otherwise>
				</c:choose>
				
			</div>
		</header>
		
		<div id="container">
			<div id="local" class="boards">
				<div class="boardForm">
					<div>
						<h1>국산차</h1>
						<ul class="itemList">
							
							<c:forEach var="local" items="${locals}" varStatus="status">
								<li class="item test" data-id="${ local.id }">
									<ul class="segmentList">
										<li class="segment hits">조회수: ${ local.hits }</li>
										<li class="segment photo" style="background-image:url('/images/${local.fileName}')"></li>
										<li class="segment model">${ local.carName } / ${local.companyName }</li>
										<li class="segment price">${ local.price } 만원</li>
									</ul>
								</li>
							</c:forEach>
								
						</ul>
					</div>
				</div>
			</div>
			<div id="global" class="boards">
				<div class="boardForm middle">
					<div>
						<h1>수입차</h1>
						<ul class="itemList">
							
							<c:forEach var="global" items="${globals}" varStatus="status">
								<li class="item test" data-id="${ global.id }">
									<ul class="segmentList">
										<li class="segment hits">조회수: ${ global.hits }</li>
										<li class="segment photo" style="background-image:url('/images/${global.fileName}')"></li>
										<li class="segment model">${ global.carName } / ${global.companyName }</li>
										<li class="segment price">${ global.price } 만원</li>
									</ul>
								</li>
							</c:forEach>
							
							
						</ul>
					</div>
				</div>
			</div>
			
			<button data-direction="left" data-position="outer"></button>
			<button data-direction="right" data-position="outer"></button>

			<div id="direction">
				<div class="left"><a href="#"></a></div>
				<div class="right"><a href="#"></a></div>
			</div>
			<!-- ◀▶ -->
		</div>
	</div>
</body>
</html>