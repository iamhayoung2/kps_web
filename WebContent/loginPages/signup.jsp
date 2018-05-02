<!--  
	@Author Junmin Seong (chicolivia@gmail.com)
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>KPS</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="/assets/css/main.css" />
</head>
<body>

	<!-- Wrapper -->
	<div id="wrapper">
		<jsp:include page="/menuPages/menuBar.jsp"></jsp:include>
		<section class="main alt">
			<header>
				<h1>회원 가입</h1>
					<!-- <hr style="border: solid 2px; color:#bfbfbf;"> -->
			</header>
			<div class="inner style3">
				<div class="image main" data-position="center">
					<div class="row uniform">
						<div class="3u 12u"></div>
						<div class="6u 12u(medium)">
							<form action="/SignUpMember" onsubmit="return submitCheck()"
								method="POST" onkeydown="return captureReturnKey(event)">
								<div>
									<div class="13u">
									<h4>ID</h4>
										<input type="text" placeholder="id" id="id1"
											onblur="idCheck()" name="id"> <span id="idresult"></span><br>
									<h4>Password</h4>
										<input type="password" placeholder="password" id="pw1"
											onkeyup="pwCheck()" name="pw"> <input type="password"
											placeholder="repeat password" id="pw2" onkeyup="pwCheck()">
										<span id="pwresult"></span><br>
										<h4>E-mail</h4>
										 <input type="email"
											placeholder="sophie@example.com" id="email1"
											onblur="emailCheck()" name="email"> <span
											id="emailresult"></span><br> <input type="text"
											name="cerText" id="cerText" disabled="disabled">
									</div>
									<div><center>
										<input type="button" disabled="disabled" id="sendCerButton"
											onclick="sendingCerNum()" value="인증 메일 보내기"> <input
											type="button" disabled="disabled" id="checkCerNumButton"
											onclick="checkingCerNum()" value="인증 번호 확인"></center>
									</div>
									<br>
									<div id="alarmAgrees">
										<h4>알람 수신 동의여부</h4>
										<input type="radio" id="alarmAgreeRadio1" name="alarmAgree"
											onclick="alarmChecking()" value=1> <label
											for="alarmAgreeRadio1"><p>동의함</p></label> <input type="radio"
											id="alarmAgreeRadio2" name="alarmAgree"
											onclick="alarmChecking()" value=0> <label
											for="alarmAgreeRadio2">동의하지 않음</label>
									</div>
									<br>
									<div>
										<h4>투자 성향 선택</h4>
										<input type="radio" id="riskType1" name="riskType" value=1
											onclick="riskCheck()"> <label for="riskType1"
											class="alt">원금 보장 추구형</label> <input type="radio"
											id="riskType2" name="riskType" value=2 onclick="riskCheck()">
										<label for="riskType2">균형 투자형</label> <input type="radio"
											id="riskType3" name="riskType" value=3 onclick="riskCheck()">
										<label for="riskType3">고위험.고수익 투자형</label> <br>
									</div>
									<div>
										<br><center>
										<ul class="actions">
											&nbsp;&nbsp;<li>자신의 성향을 잘 모르겠다면? &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="#"
												class="button flt" onclick="popupOpen()">투자 성향 테스트</a>
											</li>
										</ul>
										</center>
									</div>
									<br>
									<div>

										<il> <input type="submit" value="Sign up"
											class="button fit"> <br>
										</il>
										<span id="submitresult"></span>
									</div>
								</div>
							</form>
						</div>
					</div>
				<!-- 	<hr style="border: solid 2px; color:#bfbfbf;"> -->
				</div>
			</div>

			</header>
		</section>


	</div>
	<!-- Scripts -->
	<script src="/assets/js/jquery.min.js"></script>
	<script src="/assets/js/jquery.dropotron.min.js"></script>
	<script src="/assets/js/jquery.scrollex.min.js"></script>
	<script src="/assets/js/skel.min.js"></script>
	<script src="/assets/js/signup.js"></script>
	<script src="/assets/js/util.js"></script>
	<script src="/assets/js/main.js"></script>
	<script src="/assets/js/jquery.scrolly.min.js"></script>
	<script type="text/javascript">
	function popupOpen(){

		var popUrl = "/investment/investTest.jsp";	//팝업창에 출력될 페이지 URL
		var windowW = 800;  // 창의 가로 길이
        var windowH = 950;  // 창의 세로 길이
        var left = Math.ceil((window.screen.width - windowW)/2);
        var top = Math.ceil((window.screen.height - windowH)/2);
		window.open(popUrl,"pop_01","l top="+top+", left="+left+", height="+windowH+", width="+windowW+",resizable=yes");

		}

	</script>
</body>
</html>