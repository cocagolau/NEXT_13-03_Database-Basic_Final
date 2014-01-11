<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<%@ include file="/head.html" %>
	<title>Used Car - view</title>	
	<link rel="stylesheet" type="text/css" href="/stylesheets/registerUsedCar.css" />
	<script type="text/javascript" src="/javascripts/registerUsedCar.js"></script>
</head>

<body>
	<div id="wrap">
		<header>
			<div id="statusBar">
				<h1 id="logo"><a href="/">Used Car</a></h1>
			</div>
		</header>
		<div id="container">		
			<div id="local" class="boards">
				<div class="boardForm middle">
					<div>
						
						<ul id="register">
							<form name="register" method="post" action="/register/usedcar/submit"  enctype="multipart/form-data">
								<li>
									<button type="button" data-click="register">등록</button>
								</li>
							
								<li id="carModel" >
									<h1>모델선택</h1>
									<div class="table test">
										<div class="tableRow">
											<div class="tableCell">제조사</div>
											<div class="tableCell">
												<select id="selectCompany" name="companyName">
													<c:forEach var="companies" items="${companies}" varStatus="status">
														<option>${companies.name}</option>
													</c:forEach>
												</select>
												<button type="button" data-click="selectCar">선택</button>
											</div>
											<div class="tableCell">모델선택</div>
											<div id="selectCar" class="tableCell">
												<select id="carId" name="carId">
												</select>
											</div>
										</div>
									</div>
								</li>
								
								
								<li id="priceInfo">
									<h1>가격정보</h1>
									<div class="table test">
										<div class="tableRow">
											<div class="tableCell">가격</div>
											<div class="tableCell">
												<input type="text" name="dealingPrice"></input>만원
											</div>
											<div class="tableCell">판매방법</div>
											<div class="tableCell">
												<input type="radio" name="dealingCondition" value="할부">할부</input>
												<input type="radio" name="dealingCondition" value="리스">리스</input>
											</div>
										</div>
									</div>
								</li>
								
								
								<li id="carInfo">
									<h1>차량정보</h1>
									<div class="table test">
										<div class="tableRow">
											<div class="tableCell">주행거리</div>
											<div class="tableCell">
												<input type="text" name="mileage"></input>km
											</div>
											<div class="tableCell">색상</div>
											<div class="tableCell">
												<input type="text" name="color"></input>
											</div>
										</div>
									</div>
								</li>
								
								
								<li id="accidentInfo">
									<h1>사고정보</h1>
									<button type="button" class="add" data-click="accidentInfo">추가</button>
									<div class="table test">
										<div class="tableRow">
											<div class="tableCell">날짜</div>
											<div class="tableCell">사고내역</div>
										</div>
										<div class="tableRow">
											<div class="tableCell">
												<input type="month" name="accidentDate"></input>
											</div>
											<div class="tableCell">
												<input type="text" name="accidentDetail" placeholder="사고내용을 적어주세요"></input>
											</div>
										</div>
									</div>
								</li>
								
								
								<li id="photoUpload">
									<h1>사진업로드</h1>
									<button type="button" class="add" data-click="photoUpload">추가</button>
									<div class="table test">
										<div class="tableRow">
											<div class="tableCell">위치</div>
											<div class="tableCell">사진지정</div>
										</div>
										<div class="tableRow">
											<div class="tableCell">
												<input type="text" name="photoPart" placeholder="부분이름"></input>
											</div>
											<div class="tableCell">
												<input type="file" name="files[0]"></input> 
											</div>
										</div>
									</div>
								</li>
								
								
								<li id="detail">
									<h1>세부정보</h1>
									<div class="table test">
										<div class="tableRow">
											<div class="tableCell">
												<textarea name="detail" rows="10" cols="110" placeholder="세부내용을 적어주세요"></textarea>
											
											</div>
										</div>
									</div>
								</li>
								
								<li id="hiddenInfo">
									<input type="hidden" name="dealerEmail" value="${ sessionScope.userEmail }" />
									<input type="hidden" name="registrationDate" />
								</li>
								
							</form>
						</ul>
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>