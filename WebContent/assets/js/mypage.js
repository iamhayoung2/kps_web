/**
 * @Author Junmin Seong (chicolivia@gmail.com)
 */
var pw = 0;
var email = 0;
var alarmCheck =-1;
var riskType = -1;
var pwequals = 0;
var cerNumber = 0;
var xhttp = new XMLHttpRequest();

function emailCheck() {
	email1= document.getElementById("email").value;
	cerNumber = 0;
	var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if (regExp.test(email1) && email1.length <= 40) {
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var resultString1 = this.responseText;
				var innerString = "";
				if (resultString1 == "exist") {
					innerString = "존재하는 EMAIL 입니다";
				} else if (resultString1 == "okay") {
					innerString = "메일을 발송했습니다. 인증번호를 입력해주세요.";
					sendingCerNum();
				}
				document.getElementById("emailresult").innerHTML = innerString;
			}
		};
		xhttp.open("GET", "/SignUpEmailCheck?email=" + email1, true);
		xhttp.send();
	} else {
		document.getElementById("emailresult").innerHTML = "EMAIL 형식을 맞춰주세요";
	}
}

function sendingCerNum(){
	cerNumber = 0;
	cerEmailAddress = document.getElementById("email").value;
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
	var cerText = document.getElementById("cerText").value;
	if(cerText == "" || cerText.length ==0){
		document.getElementById("cerText").placeholder = "입력해주세요";
	}
	else if(cerNumber == cerText){
		//인증 완료
		email = 1;
		document.getElementById("emailAddress").value= document.getElementById("email").value;
		document.getElementById("emailHidden").value = document.getElementById("email").value;
		showEmailChangeRows();
	}else{
		//일치 하지 않음.
		document.getElementById("cerText").value="";
		document.getElementById("cerText").placeholder="일치하지 않습니다.";
	}
}


function pwCheck() {
	pw2 = document.getElementById("pw2").value;
	pw1 = document.getElementById("pw1").value;
	document.getElementById("pwSame").value=0;
	var pwReg = /^[A-Za-z0-9#?!@$%^&*-_]{8,20}$/;
	resultStr = ""
	if (pw1 == "") {
		resultStr = "";
	} else if (!pwReg.test(pw1)) {
		resultStr = "영문자, 숫자, 특수 조합의 8~20자의 비밀번호를 입력해주세요";
	} else if (pw2 != "") {
		if (pw1 == pw2) {
			resultStr = "비밀번호 일치";
			document.getElementById("pwSame").value=1;
		} else {
			resultStr = "비밀번호가 일치하지 않습니다.";
		}
	} else {
		resultStr = "";
	}
	document.getElementById("pwresult").innerHTML = resultStr;
}

function onKeyDown()
{
     if(event.keyCode == 13)
     {
    	return false;
     }
}

function showEmailChangeRows(){
	document.getElementById("row1").hidden = !document.getElementById("row1").hidden;	
	document.getElementById("row2").hidden = !document.getElementById("row2").hidden;	
}

function showPwChangeRows(){
	
}

function riskCheck() {
	var radio2 = document.getElementsByName('riskType');
	if (radio2[0].checked) {
		document.getElementById("riskTypeHidden").value = 1;
	} else if (radio2[1].checked) {
		document.getElementById("riskTypeHidden").value = 2;

	} else if (radio2[2].checked) {
		document.getElementById("riskTypeHidden").value = 3;

	}
}

function alarmChecking() {
	var radio1 = document.getElementsByName('alarmAgree');
	if (radio1[0].checked) {
		document.getElementById("alarmAgreeHidden").value = 1;

	} else if (radio1[1].checked) {
		document.getElementById("alarmAgreeHidden").value = 0;
	}
}