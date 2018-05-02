/**
 * @Author Junmin Seong (chicolivia@gmail.com)
 */
var id = 0;
var pw = 0;
var email = 0;
var cerEmail = 0;
var alarmCheck = -1;
var riskType = -1;
var cerNumber = 0;
var xhttp = new XMLHttpRequest();

function idCheck() {
	var idReg = /^[A-Za-z0-9]{5,20}$/;
	id1 = document.getElementById("id1").value;
	id = 0;
	if (idReg.test(id1)) {
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var xml = this.responseXML;
				var re = xml.getElementsByTagName("result")[0].firstChild.nodeValue;
				var resultString = "";
				if (re == "exist") {
					resultString = "이미 있는 아이디 입니다";
				} else if (re == "okay") {
					resultString = "사용가능";
					id = 1;
				} else {
					resultString = "아이디를 입력해주세요";
				}
				document.getElementById("idresult").innerHTML = resultString;
			}
		};
		xhttp.open("GET", "/SignUpIdCheck?id=" + id1, true);
		xhttp.send();
	} else {
		document.getElementById("idresult").innerHTML = "영문자,숫자 조합의 5~20 자리의 아이디를 입력해주세요";
	}
}

function pwCheck() {
	pw2 = document.getElementById("pw2").value;
	pw1 = document.getElementById("pw1").value;
	pw = 0;
	var pwReg = /^[A-Za-z0-9#?!@$%^&*-_]{8,20}$/;
	resultStr = ""
	if (pw1 == "") {
		resultStr = "";
	} else if (!pwReg.test(pw1)) {
		resultStr = "영문자, 숫자, 특수 조합의 8~20자의 비밀번호를 입력해주세요";
	} else if (pw2 != "") {
		if (pw1 == pw2) {
			resultStr = "비밀번호 일치";
			pw = 1;
		} else {
			resultStr = "비밀번호가 일치하지 않습니다.";
		}
	} else {
		resultStr = "";
	}
	document.getElementById("pwresult").innerHTML = resultStr;
}
function emailCheck() {
	email1 = document.getElementById("email1").value;
	cerNumber = 0;
	email = 0;
	cerEmail = 0;
	var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if (regExp.test(email1) && email1.length <= 40) {
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var resultString1 = this.responseText;
				var innerString = "";
				if (resultString1 == "exist") {
					innerString = "존재하는 EMAIL 입니다";
					disableBoxes();
				} else if (resultString1 == "okay") {
					innerString = "사용가능한 EMAIL 입니다. 인증해주세요.";
					email = 1;
					ableBoxes();
				}
				document.getElementById("emailresult").innerHTML = innerString;
			}
		};
		xhttp.open("GET", "/SignUpEmailCheck?email=" + email1, true);
		xhttp.send();
	} else {
		document.getElementById("emailresult").innerHTML = "EMAIL 형식을 맞춰주세요";
		disableBoxes();
	}
}
function submitCheck() {
	if (id == 1 && pw == 1 && email == 1 && cerEmail == 1 && alarmCheck != -1 && riskType != -1) {
		return true;
	} else {
		if (id == 0) {
			document.getElementById("id1").focus();
		} else if (pw == 0) {
			document.getElementById("pw1").focus();
		} else if (email == 0) {
			document.getElementById("email1").focus();
		} else if (cerEmail = 0){
			document.getElementById("cerText").focus();
		} else if (alarmCheck == -1) {
			document.getElementById("alarmAgrees").focus();
			document.getElementById("submitresult").innerHTML = "알림 수신 동의 여부를 선택해주세요";
		} else if (riskType == -1) {
			document.getElementById("riskTypes").focus();
			document.getElementById("submitresult").innerHTML = "투자 성향을 선택해주세요";
		}
		return false;
	}
}
function alarmChecking() {
	var radio1 = document.getElementsByName('alarmAgree');
	if (radio1[0].checked) {
		alarmCheck = 1;
	} else if (radio1[1].checked) {
		alarmCheck = 0;
	}
}
function riskCheck() {
	var radio2 = document.getElementsByName('riskType');
	if (radio2[0].checked) {
		riskType = 1;
	} else if (radio2[1].checked) {
		riskType = 2;
	} else if (radio2[2].checked) {
		riskType = 3;
	}
}

function captureReturnKey(e) {
	if (e.keyCode == 13) {
		return false;
	}
}

function sendingCerNum(){
	cerNumber = 0;
	cerEmail = 0;
	cerEmailAddress = document.getElementById("email1").value;
	document.getElementById("cerText").focus();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var res = this.responseText;
			if(res == "fail"){
				document.getElementById("cerText").placeholder="이메일이 발송되지 못했습니다.";
			}else {
				document.getElementById("cerText").placeholder="인증번호";
				cerNumber = res;
			}
		}
	};
	xhttp.open("GET", "/ValidateEmail?email=" + cerEmailAddress, true);
	xhttp.send();
}

function checkingCerNum(){
	cerEmail = 0;
	var cerText = document.getElementById("cerText").value;
	if(cerText == "" || cerText.length ==0){
		document.getElementById("cerText").placeholder = "입력해주세요";
	}
	else if(cerNumber == cerText){
		//인증 완료
		cerEmail = 1;
		disableBoxes();
		document.getElementById("emailresult").innerText = "인증이 완료되었습니다.";
	}else{
		//일치 하지 않음.
		document.getElementById("cerText").value="";
		document.getElementById("cerText").placeholder="일치하지 않습니다.";
	}
}

function ableBoxes(){
	var boxText = document.getElementById("cerText");
	var sendCerButton = document.getElementById("sendCerButton");
	var checkCerNumButton = document.getElementById("checkCerNumButton");
	boxText.disabled=false;
	sendCerButton.disabled=false;
	checkCerNumButton.disabled=false;
}
function disableBoxes(){
	var boxText = document.getElementById("cerText");
	var sendCerButton = document.getElementById("sendCerButton");
	var checkCerNumButton = document.getElementById("checkCerNumButton");
	boxText.disabled=true;
	sendCerButton.disabled=true;
	checkCerNumButton.disabled=true;
}