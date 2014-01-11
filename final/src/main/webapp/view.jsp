<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<%@ include file="/head.html" %>
	<title>Used Car - view</title>	
	<link rel="stylesheet" type="text/css" href="/stylesheets/view.css" />
	<script type="text/javascript" src="/javascripts/view.js"></script>
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
					
						<ul class="itemList left">
							<li class="item photo test">
								<ul class="segmentList">
									
									<c:forEach var="photo" items="${photos}" varStatus="status">
										<li class="segment test" style="background-image:url('/images/${ photo.fileName }')">
											<div> ${ photo.partName }</div>
										</li>
									</c:forEach>

								</ul>
							</li>
						</ul>
						
						
						<ul class="itemList right">
							<li class="item info test">
								
								<ul class="segmentList">
									<li class="segment status test">
										<div class="table">
											<div class="tableRow">
												<div class="tableCell">조회수</div>
												<div class="tableCell">${ usedcar.hits }</div>
												<div class="tableCell">등록일: ${ usedcar.registrationDate }</div>
												<div class="tableCell">판매정보:
													<c:choose>
														<c:when test="${not empty usedcar.dealingSolddate}">
															판매완료
														</c:when>
														<c:otherwise>
															판매중
														</c:otherwise>
													</c:choose>
												</div>
											</div>
										</div>
									</li>
									
									<li class="segment dealing test">
										<div class="title">거래정보</div>
										<div class="table">
											<div class="tableRow">
												<div class="tableCell">가격</div>
												<div class="tableCell">${ usedcar.dealingPrice }</div>
												<div class="tableCell">판매방법</div>
												<div class="tableCell">${ usedcar.dealingCondition }</div>
											</div>
										</div>
									</li>
									
									<li class="segment car test">
										<div class="title">차량정보</div>
										<div class="table">
											<div class="tableRow">
												<div class="tableCell">제조사</div>
												<div class="tableCell">${ car.companyName }</div>
												<div class="tableCell">모델명</div>
												<div class="tableCell">${ car.name }</div>
											</div>
											<div class="tableRow">
												<div class="tableCell">형태</div>
												<div class="tableCell">${ car.type }</div>
												<div class="tableCell">연식</div>
												<div class="tableCell">${ car.modelYear }년</div>
											</div>
											<div class="tableRow">
												<div class="tableCell">엔진형식</div>
												<div class="tableCell">${ car.engineType }</div>
												<div class="tableCell">배기량</div>
												<div class="tableCell">${ car.engineDisplacement }cc</div>
											</div>
											<div class="tableRow">
												<div class="tableCell">연료</div>
												<div class="tableCell">${ car.engineGasType }</div>
												<div class="tableCell">연비</div>
												<div class="tableCell">${ car.engineGasEfficiency }km/l</div>
											</div>
											<div class="tableRow">
												<div class="tableCell">최대출력</div>
												<div class="tableCell">${ car.engineOutput }hp</div>
												<div class="tableCell">변속기</div>
												<div class="tableCell">${ car.gearbox }</div>
												
											</div>
											<div class="tableRow">
												<div class="tableCell">승차인원</div>
												<div class="tableCell">${ car.passenger }명</div>
												<div class="tableCell">구동방식</div>
												<div class="tableCell">${ car.driveType }</div>
											</div>
										</div>
									</li>
										
									<li class="segment accident test">
										<div class="title">사고정보</div>
										<div class="table">
											<div class="tableRow">
												<div class="tableCell">날짜</div>
												<div class="tableCell">사고내역</div>
											</div>
										
											<c:forEach var="accident" items="${accidents}" varStatus="status">
												<div class="tableRow">
													<div class="tableCell">${ accident.date }</div>
													<div class="tableCell">${ accident.detail }</div>
												</div>
											</c:forEach>
										</div>
									</li>
									
									<li class="segment dealer test">
										<div class="title">판매자정보</div>
										<div class="table">
											<div class="tableRow">
												<div class="tableCell">이름</div>
												<div class="tableCell">${ dealer.name }</div>
												<div class="tableCell">이메일</div>
												<div class="tableCell">${ dealer.email }</div>
											</div>
											<div class="tableRow">
												<div class="tableCell">전화번호</div>
												<div class="tableCell">${ dealer.phone }</div>
												<div class="tableCell">가입날짜</div>
												<div class="tableCell">${ dealer.admissionDate }</div>
											</div>
										</div>
									</li>
									
									<li class="segment detail test">
										<div class="title">${ usedcar.detail }</div>
										<div>-</div>
									</li>
									
								</ul>
								
							</li>
						</ul>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>