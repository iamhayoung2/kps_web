<!--  
	@Author Junmin Seong (chicolivia@gmail.com)
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Log In</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="/assets/css/main.css" />
</head>
<body>
	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Header && Menu -->
		<jsp:include page="/menuPages/menuBar.jsp"></jsp:include>
		<section class="main alt">
			<header>
				<h1>Log in</h1>
			</header>

			<div class="image main" data-position="center">
				<div class="row uniform">
					<div class="4u 12u"></div>
					<div class="4u 12u(medium)">
						<form action="/LoginController" id="loginForm" method="POST"
							onkeydown="return onKeyDown()">
							<input type="text" placeholder="id" id="id1" name="id"> <br>
							<br> <input type="password" placeholder="password" id="pw1"
								name="pw"><br>
							<ul class="actions fit">
								<li><input type="button"
									onclick="location.href='/loginPages/findIdPw.jsp'"
									class="button fit" value="ID/PW 찾기"></li>
								<li><input type="button" value="Log In"
									onclick="loginChecking()" class="button fit"></li>
							</ul>
						</form>
					</div>
				</div>
			</div>
			<span><center>
					<h3 id="submitresult"></h3>
				</center></span>

		</section>
	</div>

	<!--페이지 밑단  -->
	<jsp:include page="/menuPages/footer.jsp"></jsp:include>
	</div>
	<!-- Scripts -->
	<script src="/assets/js/jquery.min.js"></script>
	<script src="/assets/js/jquery.dropotron.min.js"></script>
	<script src="/assets/js/jquery.scrollex.min.js"></script>
	<script src="/assets/js/jquery.scrolly.min.js"></script>
	<script src="/assets/js/skel.min.js"></script>
	<script src="/assets/js/util.js"></script>
	<script src="/assets/js/main.js"></script>
	<script src="/assets/js/login.js"></script>
</body>
</html>