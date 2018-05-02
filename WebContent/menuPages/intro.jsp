<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>Untitled</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="/assets/css/main.css" />
</head>
<body>

   <!-- Wrapper -->
   <div id="wrapper">
      <!-- 메뉴바 -->
      <jsp:include page="/menuPages/menuBar.jsp"></jsp:include>

      <!-- Section -->
      <section class="main accent2">
         <header>
            <h1>intro</h1>
            <p>
            <h4>코리아 프리미엄 / 서비스 소개</h4>
            </p>
         </header>
         <div class="inner">
            <br>
            <article class="post alt">
               <div class="content">
                  <header>
                     <span class="category"><font size="7" color="#b06de8"
                        face="vernada">KPS</font></span>
                     <h3>Korea Premium Signal</h3>
                  </header>
                  <p>
                     <font size="4" face="vernada"><strong>KPS(Korea
                           Premium Signal)</strong></font><font size="3" face="vernada"> 는 암호 화폐를
                        거래하는 국내 고객들의 수익창출을 위한 정보 제공 사이트입니다. 우리의 서비스는 축적된 방대한 과거 데이터를
                        바탕으로 향후 코리아 프리미엄 예측합니다. 또한, 코리아 프리미엄이 일정한 시점에 도착했을 때 알람을 제공함으로써
                        고객님의 편의를 도모합니다. </font><br>
                  <center>
                     <font size="2" color="grey" face="vernada">＊코리아 프리미엄 :
                        한국에서 거래되는 암호화폐의 시세가 해외 거래소 시세와 비교해 얼마나 높은지를 나타내는 지표 (≒김치 프리미엄) 
                  </center>
                  </font>
                  </p>
                  <ul class="actions">
                     <br>
                     <!--    <li><a href="#" class="button next">Learn More</a></li> -->
                  </ul>
               </div>
               <div class="6u">
                  <span class="image fit"><img src="/images/lionlion.png"
                     alt="" /></span>
               </div>
            </article>
            <br>
            <br>
            <article class="post">
               <div class="content">
                  <header>
                     <span class="category"><font size="7" color="#b06de8"
                        face="vernada">SERVICE 1</font></span>
                     <h3>프리미엄 예측 서비스</h3>
                  </header>
                  <br>
                  <p>
                     <font size="3" face="vernada">2014년 1월부터 현재까지 축적한 수백만 건의
                        비트코인 가격 및 거래량의 데이터를 분석하고 예측합니다. 국내외 거래소 데이터를 실시간으로 수집하고 이를 머신러닝
                        기법인 LSTM 모형을 적용해 프리미엄을 예측하고 시각화해서 제공합니다.</font>
                  </p>
                  <ul class="actions">
                     <!-- <li><a href="#" class="button next">Learn More</a></li> -->
                  </ul>
               </div>
               <div class="6u">
                  <span class="image fit"><img src="/images/eye.jpg" alt="" /></span>
               </div>
            </article>
            <br>
            <br>
            <article class="post alt">
               <div class="content">
                  <header>
                     <span class="category"><font size="7" color="#b06de8"
                        face="vernada">SERVICE 2</font></span>
                     <h3>실시간 알림 서비스</h3>
                  </header>
                  <p>
                     <br> <font size="3" face="vernada">우리는 고객이 설정한 코리아
                        프리미엄 퍼센티지(%)에 맞게 실시간 알림 서비스를 제공합니다. 고객 개개인의 투자 성향에 따라 적절한
                        퍼센티지(%)와 매수, 매도 시기를 추천해주고 있습니다.</font>
                  </p>
                  <ul class="actions">
                     <!-- <li><a href="#" class="button next">Learn More</a></li> -->
                  </ul>
               </div>
               <div class="6u">
                  <span class="image fit"><img src="/images/flower.png"
                     alt="" /></span>
               </div>
            </article>
         </div>
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



</body>
</html>