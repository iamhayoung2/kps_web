<!--  
	@Author Junmin Seong (chicolivia@gmail.com)
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>KPS</title>
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
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- 메뉴바 -->
		<jsp:include page="/menuPages/menuBar.jsp"></jsp:include>
		
		<!-- Section -->
		<section class="main alt special">
			<header>
				<h2>My Page</h2>
			</header>
			<div class="inner narrow">
			<form id="updateMemberForm" method="post" onkeydown="return onKeyDown()" action="/MemberUpdate">
				<div class="table-wrapper">
					<table class="alt">
						<thread>
							<tr>
								<th><h5>아이디</h5></th>
								<th colspan="2"><h5>${memberInfo.member.id}</h5></th>
							</tr>
							<tr>
								<th><h5>E-mail</h5></th>
								<th>
									<input type="text" name="email" id ="emailAddress" value="${memberInfo.contactInfo[0].address}" disabled="disabled">
								</th>
								<th>
									<div class="actions small">
										<input type="button" class="button fit button2" onclick="showEmailChangeRows()" value="변경하기">
									</div>
								</th>
							</tr>
								<tr id = "row1" hidden="true">
								<th></th>
								<th>
										<input type="email" name="changeEmail" placeholder="바꿀 이메일 주소" id="email" >
										<p id="emailresult"></p>
								</th>
								<th>
									<input type="button" class="button fit" id="sendCerBtn" value="인증번호 보내기" onclick="emailCheck()">
								</th>
							</tr>
							<tr id = "row2" hidden="true">
								<th></th>
								<th>
										<input type="text" name="cerNum" placeholder="인증번호" id="cerText" >
										<p></p>
								</th>
								<th>
									<input type="button" class="button" id="chkCerBtn" value="인증번호 확인" onclick="checkingCerNum()" >
								</th>
							</tr>
							<tr>
								<th>
									<h5>비밀번호</h5>
								</th>
								<th>
									<input type="password" placeholder="password" id="pw1" onkeyup="pwCheck()" name="pw">
									
								</th>
								<th>
								</th>
							</tr>
							<tr>
								<th></th>
								<th>
									<input type="password" placeholder="repeat password" id="pw2" onkeyup="pwCheck()">
									<span id="pwresult"></span>
								</th>
								<th>
														
								</th>
							</tr>
							<tr>
								<th><h5>알림 수신 여부</h5></th>
								<th colspan="2">
									<input type="radio" id="alarmAgreeRadio1" name="alarmAgree" onclick="alarmChecking()" value=1>
									<label for ="alarmAgreeRadio1"><p>동의함</p></label>
									<input type="radio" id="alarmAgreeRadio2" name="alarmAgree" onclick="alarmChecking()" value=0>
									<label for ="alarmAgreeRadio2">동의하지 않음</label>									
								</th>
							</tr>
							<tr>
								<th><h5>투자 성향</h5></th>
								<th>
									<input type="radio" id="riskType1" name="riskType" value=1 onclick="riskCheck()">
									<label for ="riskType1" class="alt"><span style="font-size: small;">원금 보장 추구형</span></label>
									<input type="radio" id="riskType2" name="riskType" value=2 onclick="riskCheck()">
									<label for ="riskType2"><span style="font-size: small;">균형 투자형</span></label>
									<input type="radio" id="riskType3" name="riskType" value=3 onclick="riskCheck()">
									<label for ="riskType3"><span style="font-size: small;">고위험.고수익 투자형</span></label>
								</th>
								<th>
									<a href="#" class="button button2" onclick="popupOpen()">투자 성향 테스트</a>
								</th>
							</tr>
							<tr>
								<th><h5>알림 설정</h5></th>
								<th>
									 <a href="/menuPages/alarm.jsp" class="button alt fit" style="width: "><font style="color:grey;">알림 설정 페이지</font></a> 
								</th>
								<th></th>
							</tr>
							<tr>
								<th><h5>탈퇴  하기</h5></th>
								<th>
									<!-- <input type="button" class="button" value="탈퇴 하기"  style="background-color: #111111" onclick="checkByeBye()">  -->
									<input type="button" class="button alt fit" value="탈퇴하기" style="color:#009933" onclick="checkByeBye()">
								</th>
								<th></th>
							</tr>
						</thread>
					</table>
				</div><!-- table div -->
				<input type="hidden" id="pwSame" name="pwSame" value="0">
				<input type="hidden" id="alarmAgreeHidden" name="alarmAgreeHidden" value="0">
				<input type="hidden" id="riskTypeHidden" name="riskTypeHidden" value="0">
				<input type="hidden" id="emailHidden" name="emailHidden" value="0">
				</form>
				<div>
				</div>
			<!-- 	<input type="button" class="button fit" value="저 장 하 기"  onclick="submitForm()"> -->
				<input type="button" class="button2" value="저장하기" style="background-color: #CD1F48" onclick="submitForm()">
				<br><br><p style="font-size: small; color: red;">변경을 위해 반드시 저장해주세요</p>
				<!-- <input type="button" class="button" style="background-color: #FF9999;" value="저장하기" onclick="submitForm()"> -->
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
		<script src="/assets/js/mypage.js"></script>
		<script type="text/javascript">
			if('${memberInfo.member.alarmAgree}' == 1){
				document.getElementById("alarmAgreeRadio1").checked="True";
				document.getElementById("alarmAgreeHidden").value= 1;
			}else{
				document.getElementById("alarmAgreeRadio2").checked ="True";
				document.getElementById("alarmAgreeHidden").value= 0;
			}
			if('${memberInfo.member.riskNo}'==1){
				document.getElementById("riskType1").checked ="True";
				document.getElementById("riskTypeHidden").value=1;
			}else if('${memberInfo.member.riskNo}'==2){
				document.getElementById("riskType2").checked ="True";
				document.getElementById("riskTypeHidden").value=2;
			}else if('${memberInfo.member.riskNo}'==3){
				document.getElementById("riskType3").checked ="True";
				document.getElementById("riskTypeHidden").value=3;
			}
			function submitForm(){
				document.getElementById("updateMemberForm").submit();
			}
			function checkByeBye(){
				if(confirm("정말 탈퇴하시겠습니까?")){
					location.href="/LeaveMember";
				}else{
					return;
				}
			}
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