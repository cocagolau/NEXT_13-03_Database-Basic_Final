<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<%@ include file="/head.html" %>
	<title>Used Car - join</title>
	
	<link rel="stylesheet" type="text/css" href="/stylesheets/registerDealer.css" />
	<script type="text/javascript" src="/javascripts/registerDealer.js"></script>

</head>

<body>
	<div id="wrap">
		<header>
			<div id="statusBar">
				<h1 id="logo"><a href="/">Used Car</a></h1>
				<h2 class="subMenu btn" data-click="registration">딜러 등록</h2>				
			</div>
		</header>
		<div id="container">
			<div id="local" class="boards">
				<div class="boardForm middle">
					<div>
						<form id="registration" name="registration" method="post" action="/register/dealer/submit">
							<div class="table">
								<h1>환영합니다 :)</h1>
								<div class="tableRow">
									<div class="tableCell">email</div>
									<div class="tableCell"><input type="email" name="email"></input></div>
								</div>
								<div class="tableRow">
									<div class="tableCell">password</div>
									<div class="tableCell"><input type="password" name="password"></input></div>
								</div>
								<div class="tableRow">
									<div class="tableCell">이름</div>
									<div class="tableCell"><input type="text" name="name"></input></div>
								</div>
								<div class="tableRow">
									<div class="tableCell">전화번호</div>
									<div class="tableCell"><input type="tel" name="phone"></input></div>
								</div>
								<div class="invisible">
									<input id="admissionDate" name="date" type="hidden"></input>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>