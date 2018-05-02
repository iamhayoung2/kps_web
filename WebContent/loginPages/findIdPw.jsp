<!--  
	@Author Junmin Seong (chicolivia@gmail.com)
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Find ID&PW</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="/assets/css/main.css" />
</head>
<body>
	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Header && Menu -->
		<jsp:include page="/menuPages/menuBar.jsp" flush="true" />

		<!-- Section -->
		<section class="main alt">
			<header>
				<h1>FIND ID/PW</h1>
			</header>
			<div class="image main" data-position="center">
				<div class="row uniform">
					<div class="4u 12u"></div>
					<div class="4u 12u(medium)">
						<center>
							<h4>아이디 찾기</h4>
						</center>
						<hr>
						<form action="/loginPages/findedId.jsp" id="findIdForm"
							method="POST" onkeydown="return onKeyDown()">
							<input type="email" placeholder="email" name="emailAddress"
								id="email1"><br> <input type="button"
								class="button fit" value="아이디 찾기" onclick="findId()"> <input
								type="hidden" id="findedId" value="" name="findedId">
						</form>
						<p style="color: red" id="findIdResult"></p>

						<center>
							<h4>비밀번호 찾기</h4>
						</center>
						<hr>
						<form action="/loginPages/findedPw.jsp" id="findPwForm"
							method="POST" onkeydown="return onKeyDown()">
							<input type="text" placeholder="id" name="id" id="id2"> <input
								type="email" placeholder="email" name="emailAddress" id="email2"><br>
							<input type="button" class="button fit" value="비밀번호 찾기"
								onclick="findPw()"> <input type="hidden" id="findedPw"
								name="findedPw">
						</form>
						<p style="color: red" id="findPwResult"></p>
					</div>
					
				</div>
			</div>
	
			<br><br><br>
			<p  style="color:grey; text-align: center;">email 문의: koreanpremium@gmail.com</p>
</section>
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
	<script src="/assets/js/findIdPw.js"></script>
</body>
</html>