<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.domain.AlarmBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<title>signal</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="/assets/css/main.css" />
		<style>
			.button2:hover {
			    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
			}
		
		</style>
	</head>
	<body>
<!-- 메뉴바 -->
		<jsp:include page="/menuPages/menuBar.jsp"></jsp:include>
				<!-- Section -->

	<!-- Wrapper -->
	<div id="wrapper">
	
	<%if(session.getAttribute("memberInfo") == null) {
	%>
			<section class="main alt">
			<!-- <section class="main accent2"> -->
				<header>
					<h1>alarm</h1>
				</header>
				<!-- <div class="inner style3"> -->
				<div class="inner style5">
						<div class="image main" data-position="center"></div>
						<h3 style="text-align: center; color: grey;">로그인이 필요한 서비스 입니다.</h3>
				</div>
			</section>
	<%
	}
	else{
	%>
			<section class="main alt2">
				<header>
					<h1>alarm</h1>
				</header>
				<div class="inner style3" style="border-radius: 20px;'">
						<div class="image main" data-position="center">
							<c:if test="${empty memberInfo.alarmInfo}">
								<h3 style="text-align: center; color: grey;">알람을 추가해주세요</h3>
							</c:if>
							<c:if test="${not empty memberInfo.alarmInfo}">
								<h3 style="text-align: center; color: #dbb8ed">Registered Alarms</h3>
								<!-- 알람 하나씩 -->
								<c:forEach items="${memberInfo.alarmInfo}" var="alarm">
									<div class="button2" style="border-radius: 20px;">
									<div class="box" style="border-color: grey; border-radius: 20px; border-width: medium;  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);" id="${alarm.alarmNo}">
										<div class="row uniform">
												<div class="3u 12u(xsmall)" >
													<c:if test="${alarm.coinNo == 1}">
														<h5 style="color:grey">BITCOIN</h5>
													</c:if>	
													<c:if test="${alarm.coinNo == 2}">
														<h5 style="color:grey">Etherium</h5>
													</c:if>	
												</div>
												<div class="5u 12u(xsmall))" class="box">
													<c:forEach items="${memberInfo.contactInfo}" var="contact">
														<c:if test="${alarm.contactNo == contact.contactNo}">
															<h5 style="color:grey">${contact.address }</h5> 
														</c:if>
													</c:forEach>
												</div>
												<div class="2u 12u(xsmall)">
													<h5 style="color:grey"><fmt:formatNumber value="${alarm.percent}" type="number"/> %</h5>
												</div>
												<div class="1u 12u(xsmall)" >
													<a href="#" onclick="deleteAlarm(this)" class="button alt" style="border-radius: 500px;"><p style="color:grey;">del</p></a>
												</div>
										</div>
									</div>
									</div>
								</c:forEach>
								<!-- 알람 한개 END-->
							</c:if>
						</div>
						<hr class="major" />
						<!--  입력 양식 부분 -->
						<div class="image main" data-position="center">
							<form id="addAlarmForm" method="post" onkeydown="return captureReturnKey()" class="alt" action="/UpdateAlarm">
									<div class="box" style="border-color: white; border-radius: 20px; border-width: medium;">
										<div class="row uniform">
											<div class="3u 12u(xsmall)">
												<div class="select-wrapper">
													<select name="coin-category" id="coin-category">
														<option value="1"><p>BitCoin</p></option>
													</select>
												</div>
											</div>
											<div class="3u 12u(xsmall)">
												<div class="select-wrapper">
													<select name="percent-category" id="percent-category">
														<c:forEach begin="1" end="31" step="1" var="steps" varStatus="v">
															<c:if test="${v.count-16 == 0}">
																<option value="${v.count-16}" selected><p>${v.count-16}%</p></option>
															</c:if>
															<c:if test="${v.count-16 != 0}">
																<option value="${v.count-16}"><p>${v.count-16}%</p></option>
															</c:if>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="3u 12u(xsmall)">
												<div class="select-wrapper">
													<select name="contactType-category" id="contactType-category">
														<option value="1">EMAIL</option>
													</select>
												</div>
											</div>
											<div class="3u 12u(xsmall)">
												<input type="button" class="button2" value="등록" style="background-color: #b168d6" onclick="submit()">
											</div>									
										</div>
									</div><!-- box -->
								</form>
							</div>
				</div>
			</section>
	<%
	}
	%>
	</div>
	<!--페이지 밑단  -->
	<jsp:include page="/menuPages/footer.jsp"></jsp:include>

		<!-- Scripts -->
			<script src="/assets/js/jquery.min.js"></script>
			<script src="/assets/js/jquery.dropotron.min.js"></script>
			<script src="/assets/js/jquery.scrollex.min.js"></script>
			<script src="/assets/js/jquery.scrolly.min.js"></script>
			<script src="/assets/js/skel.min.js"></script>
			<script src="/assets/js/util.js"></script>
			<script src="/assets/js/main.js"></script>
			<script type="text/javascript">
				function captureReturnKey(e) {
					if (e.keyCode == 13) {
						return false;
					}
				}
				function deleteAlarm(v){
					var parent = v.parentNode.parentNode.parentNode.id;
					location.href = "/DeleteAlarm?no="+parent;
				}
			</script>
	</body>
</html>