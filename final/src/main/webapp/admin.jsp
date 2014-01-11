<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file="/head.html" %>
	<title>Used Car - admin</title>
	<link rel="stylesheet" type="text/css" href="/stylesheets/admin.css">
	<script type="text/javascript" src="/javascripts/admin.js"></script>
</head>

<body>
	<div id="wrap">
		<header>
			<div id="statusBar">
				<h1 id="logo"><a href="/">Used Car</a></h1>
				<h2 id="registerCar" class="subMenu"><a href="/register/car">자동차 등록</a></h2>
				<h2 id="registerCompany" class="subMenu"><a href="/register/company">제조사 등록</a></h2>				
			</div>
		</header>
		
		<div id="container">
			<div id="local" class="boards">
				<div class="boardForm">
					<div>
					
						<div id="queryPlan">
							<form name="queryPlan" action="createSchema" method="post">
								<div class="buttons">
									<button type="submit">schema 생성</button>
									<button type="reset">초기화</button>
									<button type="button" class="addQuery">query 추가</button>
								</div>
								<div class="title">input queries</div>
								<div class="forms"></div>
							</form>
						</div>
						
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