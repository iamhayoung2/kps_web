/**
 * 	@Author Junmin Seong (chicolivia@gmail.com)
 */
var xhttp1 = new XMLHttpRequest();
var xhttp2 = new XMLHttpRequest();
var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

function onKeyDown()
{
     if(event.keyCode == 13)
     {
    	return false;
     }
}

function findId(){
	email1 = document.getElementById("email1").value;
	if(regExp.test(email1)){
		//get id
		xhttp1.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var re = this.responseText;
				var resultString = "";
				 if(re == "email"){
					resultString = "존재하지 않는 이메일 입니다.";
				}else {
					document.getElementById("findedId").value=re;
					document.getElementById("findIdForm").submit();
				}
				document.getElementById("findIdResult").innerHTML = resultString;
			}
		};
		xhttp1.open("POST", "/FindIdPw", false);
		xhttp1.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp1.send("id=1&email="+email1);
	}else{
		document.getElementById("findIdResult").innerText = "이메일 형식이 맞지 않습니다.";
	}
}

function findPw(){
	var idReg = /^[A-Za-z0-9]{5,20}$/;
	id2 = document.getElementById("id2").value;
	email2 = document.getElementById("email2").value;
	if(idReg.test(id2) && regExp.test(email2)){
		//get pw
		xhttp2.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var re = this.responseText;
				var resultString = "";
				if (re == "id") {
					resultString = "존재 하지 않는 아이디입니다.";
				} else if(re == "email"){
					resultString = "이메일이 일치하지 않습니다.";
				}else{
					document.getElementById("findedPw").value=re;
					document.getElementById("findPwForm").submit();
				}
				document.getElementById("findPwResult").innerHTML = resultString;
			}
		};
		xhttp2.open("POST", "/FindIdPw", false);
		xhttp2.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp2.send("id="+id2+"&email="+email2);
	}else if(!idReg.test(id2)){
		document.getElementById("findPwResult").innerText = "아이디 형식이 맞지 않습니다.";
	}else if(!regExp.test(email2)){
		document.getElementById("findPwResult").innerText = "이메일 형식이 맞지 않습니다.";
	}
}