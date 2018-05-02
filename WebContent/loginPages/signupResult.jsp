<!--  
	@Author Junmin Seong (chicolivia@gmail.com)
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
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
		<jsp:include page="/menuPages/menuBar.jsp" flush="true" />
			
			<section class="main alt">
				<div class="inner style5" style="text-align: center;">
					<div class="row 200%">
						<div class="12u 12u$(medium)">
							<font size=4><p style="font-weight: bold;  color: grey;">회원가입이 완료되었습니다.</p></font>
							<font size=4><p style="font-weight: bold; color: grey">다시 로그인해주세요.</p></font>
						</div>
					</div>
				</div>
			</section>

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