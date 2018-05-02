<!--  
	@Author Junmin Seong (chicolivia@gmail.com)
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Find ID&PW</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" href="/assets/css/main.css" />
	</head>
	<body>
		<!-- Wrapper -->
	<div id="wrapper">
	<!-- Header && Menu -->
	<jsp:include page="/menuPages/menuBar.jsp" flush="true" />
	
	<section class="main alt">
		<div class="inner style5" style="text-align: center;" >
			<div class="row 200%">
			<div class="12u 12u$(medium)">
			<h5 style="color:grey;"> 찾으신 비밀번호는 <span style="color:black">${param.findedPw}</span> 입니다.</h5>
			<hr>
			<h5  style="color:grey;">email 문의: koreanpremium@gmail.com</h5>
		</div>
		</div>
		</div>
		
	</section>
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
		<script src="/assets/js/findIdPw.js"></script>
	</body>
</html>