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
	<header id="header">
		  <nav id="nav">
         <ul>
            <li><a href="javascript:self.close();" >EXIT</a></li>
           </ul>
           </nav>
	</header>
		<section class="main alt">
			<header>
				<h1>투자 성향 Test</h1>
				<hr style="border: solid 2px; color: #bfbfbf;">
				<p style="color:red; size:4;">다음 테스트 항목들은 증권사나 은행 등 금융기관에서 제공하는
					테스트 문항들입니다. 테스트를 통해 자신의 투자성향을 진단해보세요!</p>
			</header>
			<div class="inner style3">
				<div class="image main" data-position="center">
					<div class="row uniform">
						<div class="2u 12u"></div>
						<div class="9u 12u(medium)">

							<div class="13u">

								<div id="investmentTest1">
									<h4>1. 당신의 연령대는 어떻게 됩니까?</h4>
									<input type="radio" id="investmentTest11" name="investment1"
										value=12.5> <label for="investmentTest11">①
										19세 이하</label><br> <input type="radio" id="investmentTest12"
										name="investment1" value=12.5> <label
										for="investmentTest12">② 20세~30세</label><br> <input
										type="radio" id="investmentTest13" name="investment1"
										value=9.3> <label for="investmentTest13">③
										31세~40세</label><br> <input type="radio" id="investmentTest14"
										name="investment1" value=6.2> <label
										for="investmentTest14">④ 41세~50세</label><br> <input
										type="radio" id="investmentTest15" name="investment1"
										value=3.1> <label for="investmentTest15">⑤ 51세
										이상</label>
								</div>
								<br>
								<div id="investmentTest2">
									<h4>2. 투자하고자 하는 자금의 투자 가능 기간은 얼마나 됩니까?</h4>
									<input type="radio" id="investmentTest21" name="investment2"
										value=3.1> <label for="investmentTest21">① 6개월
										이내</label><br> <input type="radio" id="investmentTest22"
										name="investment2" value=6.2> <label
										for="investmentTest22">② 6개월 이상~1년 이내</label><br> <input
										type="radio" id="investmentTest23" name="investment2"
										value=9.3> <label for="investmentTest23">③ 1년
										이상~2년 이내</label><br> <input type="radio" id="investmentTest24"
										name="investment2" value=12.5> <label
										for="investmentTest24">④ 2년 이상~3년 이내</label><br> <input
										type="radio" id="investmentTest25" name="investment2"
										value=15.6> <label for="investmentTest25">⑤ 3년
										이상</label>
								</div>
								<br>
								<div id="investmentTest3">
									<h4>3. 다음 중 투자경험과 가장 가가운 것은 어느 것입니까?</h4>
									<input type="radio" id="investmentTest31" name="investment3"
										value=3.1> <label for="investmentTest31">① 은행의
										예·적금, 국채, 지방채, 보증채, MMF, CMA 등</label><br> <input type="radio"
										id="investmentTest32" name="investment3" value=6.2> <label
										for="investmentTest32">② 금융채, 신용도가 높은 회사채, 채권형펀드,
										원금보존추구형ELS 등</label><br> <input type="radio"
										id="investmentTest33" name="investment3" value=9.3> <label
										for="investmentTest33">③ 신용도 중간 등급의 회사채, 원금의 일부만 보장되는
										ELS, 혼합형펀드 등</label><br> <input type="radio"
										id="investmentTest34" name="investment3" value=12.5> <label
										for="investmentTest34">④ 신용도가 낮은 회사채, 주식, 원금이 보장되지 않는
										ELS, 시장수익률 수준의 수익을 추구하는 주식형펀드 등</label><br> <input type="radio"
										id="investmentTest35" name="investment3" value=15.6> <label
										for="investmentTest35">⑤ ELW, 선물옵션, 시장수익률 이상의 수익을 추구하는
										주식형펀드, 파생상품에 투자하는 펀드, 주식 신용거래 등</label>
								</div>
								<br>
								<div id="investmentTest4">
									<h4>4. 금융상품 투자에 대한 본인의 지식수준은 어느 정도라고 생각하십니까?</h4>
									<input type="radio" id="investmentTest41" name="investment4"
										value=3.1> <label for="investmentTest41">① ［매우
										낮은 수준］투자의사 결정을 스스로 내려본 경험이 없는 정도</label><br> <input type="radio"
										id="investmentTest42" name="investment4" value=6.2> <label
										for="investmentTest42">② ［낮은 수준］주식과 채권의 차이를 구별할 수 있는
										정도</label><br> <input type="radio" id="investmentTest43"
										name="investment4" value=9.3> <label
										for="investmentTest43">③ ［높은 수준］투자할 수 있는 대부분의 금융상품의
										차이를 구별할수 있는 정도</label><br> <input type="radio"
										id="investmentTest44" name="investment4" value=12.5> <label
										for="investmentTest44">④ ［매우 높은 수준］금융상품을 비롯하여 모든 투자대상
										상품의 차이를 이해할 수 있는 정도</label><br>
								</div>
								<br>
								<div id="investmentTest5">
									<h4>5. 현재 투자하고자 하는 자금은 전체 금융자산(부동산 등을 제외) 중 어느 정도의 비중을
										차지합니까?</h4>
									<input type="radio" id="investmentTest51" name="investment5"
										value=15.6> <label for="investmentTest51">① 10%
										이내</label><br> <input type="radio" id="investmentTest52"
										name="investment5" value=12.5> <label
										for="investmentTest52">②10% 이상~20% 이내</label><br> <input
										type="radio" id="investmentTest53" name="investment5"
										value=9.3> <label for="investmentTest53">③ 20%
										이상~30% 이내</label><br> <input type="radio" id="investmentTest54"
										name="investment5" value=6.2> <label
										for="investmentTest54">④ 30% 이상~40% 이내</label><br> <input
										type="radio" id="investmentTest55" name="investment5"
										value=3.1> <label for="investmentTest55">⑤ 40%</label>
								</div>
								<br>
								<div id="investmentTest6">
									<h4>6. 다음 중 당신의 수입원을 가장 잘 나타내고 있는 것은 어느 것입니까?</h4>
									<input type="radio" id="investmentTest61" name="investment6"
										value=9.3> <label for="investmentTest61">① 현재
										일정한 수입이 발생하고 있으며, 향후 현재 수준을 유지하거나 증가할 것으로 예상된다.</label><br> <input
										type="radio" id="investmentTest62" name="investment6"
										value=6.2> <label for="investmentTest62">② 현재
										일정한 수입이 발생하고 있으나, 향후 감소하거나 불안정할 것으로 예상된다.</label><br> <input
										type="radio" id="investmentTest63" name="investment6"
										value=3.1> <label for="investmentTest63">③ 현재
										일정한 수입이 없으며, 연금이 주수입원이다.</label><br>
								</div>
								<br>
								<div id="investmentTest7">
									<h4>7. 만약 투자원금에 손실이 발생할 경우 다음 중 감수할 수 있는 손실 수준은 어느 것입니까?</h4>
									<input type="radio" id="investmentTest71" name="investment7"
										value=-6.2> <label for="investmentTest71">① 무슨
										일이 있어도 투자원금은 보전되어야 한다.</label><br> <input type="radio"
										id="investmentTest72" name="investment7" value=6.2> <label
										for="investmentTest72">② 10% 미만까지는 손실을 감수할 수 있을 것 같다.</label><br>
									<input type="radio" id="investmentTest73" name="investment7"
										value=12.5> <label for="investmentTest73">③
										20% 미만까지는 손실을 감수할 수 있을 것 같다.</label><br> <input type="radio"
										id="investmentTest74" name="investment7" value=18.7> <label
										for="investmentTest74">④ 기대수익이 높다면 위험이 높아도 상관하지 않겠다.</label><br>

								</div>
								<br>
								<br>
								<div> <input type="submit" value="Test 결과 확인하기"
									onclick="investChecking()" class="button fit"><br>
									<h3 id="inVest" style="text-align: center;"></h3></div>


							</div>
						</div>
					</div>
				</div>
			</div>


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
	
	function investChecking(){
		var investQuestions;
		var invest = 0;
		
		for(var i = 1; i < 8; i++){
			var tmp = document.getElementsByName('investment'+i);
			for(var j = 0 ; j< tmp.length; j++){
				if(tmp[j].checked){
					var tmp1 = tmp[j].value;
					tmp1 *= 1;
					invest += tmp1;
					break;
				}
			}
		}
		if(invest < 30 ){
			resultString = "원금보장 추구형";
		}else if(30 <= invest < 60){
			resultString = "균형 투자형";
		}else{
			resultString = "고위험, 고수익 투자형";
		}
		document.getElementById("inVest").innerHTML = "당신의 투자성향은  <span style='color:red;'>"+resultString+"</span>  입니다.";
		
	}
	
	
	function goback(){
		window.close();
	}
	
	
	</script>
</body>
</html>