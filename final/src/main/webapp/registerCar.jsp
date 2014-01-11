<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file="/head.html" %>
	<title>Used Car - registerCar</title>
	<link rel="stylesheet" type="text/css" href="/stylesheets/registerCar.css" />
	<script type="text/javascript" src="/javascripts/registerCar.js"></script>
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
					
						<ul id="register" class="test">
							<form name="register" method="post" action="/register/car/submit">
								<li>
									<button type="submit">등록</button>
								</li>
							
								<li>
									<h1>제조사 선택</h1>
									<div class="table test">
										<div class="tableRow">
											<div class="tableCell">제조사 이름</div>
											<div class="tableCell">
												<select name="companyName">
													<c:forEach var="companies" items="${companies}" varStatus="status">
														<option>${companies.name}</option>
													</c:forEach>
												</select>
											</div>
											<div class="tableCell"></div>
											<div class="tableCell">
											</div>
										</div>
									</div>
								</li>
								
								
								<li>
									<h1>자동차 선택</h1>
									<div class="table test">
										<div class="tableRow">
											<div class="tableCell">자동차 이름</div>
											<div class="tableCell">
												<input type="text" name="name"></input>
											</div>
											<div class="tableCell">자동차 타입</div>
											<div class="tableCell">
												<select name="type">
													<option>경형</option>
													<option>소형</option>
													<option>준중형</option>
													<option>중형</option>
													<option>대형</option>
													<option>스포츠카</option>
													<option>승합/트럭</option>
													<option>SUV/RV</option>
												</select>
											</div>
										</div>
									</div>
								</li>							
								
								<li>
									<h1>엔진 선택</h1>
									<div class="table test">
										<div class="tableRow">
											<div class="tableCell">엔진 형식</div>
											<div class="tableCell">
												<input type="text" name="engineType"></input>
											</div>
											<div class="tableCell">배기량</div>
											<div class="tableCell">
												<input type="text" name="engineDisplacement"></input>cc
											</div>
										</div>
										
										<div class="tableRow">
											<div class="tableCell">사용 연료</div>
											<div class="tableCell">
												<select name="engineGasType">
													<option>가솔린</option>
													<option>경유</option>
													<option>LPG</option>
													<option>전기</option>
													<option>수소</option>
												</select>
											</div>
											<div class="tableCell">연비</div>
											<div class="tableCell">
												<input type="text" name="engineGasEfficiency"></input>km/l
											</div>
										</div>
										
										<div class="tableRow">
											<div class="tableCell">엔진 출력</div>
											<div class="tableCell">
												<input type="text" name="engineOutput"></input>hp
											</div>
											<div class="tableCell"></div>
											<div class="tableCell">
											</div>
										</div>
									
									</div>
								</li>
								
								<li>
									<h1>섀시 선택</h1>
									<div class="table test">
										<div class="tableRow">
											<div class="tableCell">구동 방식</div>
											<div class="tableCell">
												<input type="text" name="driveType"></input>
											</div>
											<div class="tableCell">변속기</div>
											<div class="tableCell">
												<input type="text" name="gearbox"></input>
											</div>
										</div>
										
										<div class="tableRow">
											<div class="tableCell">승차 인원</div>
											<div class="tableCell">
												<input type="text" name="passenger"></input>명
											</div>
											<div class="tableCell">연식</div>
											<div class="tableCell">
												<input type="text" name="modelYear"></input>년
											</div>
										</div>
									</div>
								</li>
								
								
							</form>
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