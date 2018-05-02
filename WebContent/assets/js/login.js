/**
 * @Author Junmin Seong (chicolivia@gmail.com)
 */
var xhttp = new XMLHttpRequest();

function loginChecking(){
	var idReg = /^[A-Za-z0-9]{5,20}$/;
	idstr =document.getElementById("id1").value;
	pwstr=document.getElementById("pw1").value;
	if(idstr == "" || idstr.length == 0){
		document.getElementById("id1").focus();
		document.getElementById("submitresult").innerHTML="아이디를 입력해주세요.";
	}else if(!idReg.test(idstr)){
		document.getElementById("submitresult").innerHTML="존재하지 않는 아이디입니다.";
	}
	else if(pwstr == "" || pwstr.length == 0){
		document.getElementById("pw1").focus();
		document.getElementById("submitresult").innerHTML="비밀번호를 입력해주세요.";
	}else{
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var re = this.responseText;
				var resultString = "";
				if (re == "ok") {
					document.getElementById("loginForm").submit();
				} else if (re == "id") {
					resultString = "존재하지 않는 아이디입니다.";
				} else if(re == "pw"){
					resultString = "비밀번호가 일치하지 않습니다.";
				}else{
				}
				document.getElementById("submitresult").innerHTML = resultString;
			}
		};
		xhttp.open("POST", "/LoginChk", false);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send("id="+idstr+"&pw="+pwstr);
	}
}

function onKeyDown()
{
     if(event.keyCode == 13)
     {
    	return false;
     }
}