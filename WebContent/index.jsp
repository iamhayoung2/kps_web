<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>KPS</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="/assets/css/main.css" />
<link rel="stylesheet" href="/assets/css/table1.css"/>
	<script src="/assets/js/jquery-3.1.1.min.js"></script>
	<script src="/assets/chart/highcharts.js"></script>
	<script src="/assets/chart/exporting.js"></script>
	
	<script src="/assets/chart/dark-unica.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
<meta name="viewport" content="width=device-width">

</head>
<body>
   <!-- Wrapper -->
   <div id="wrapper">
      <!-- Header -->
      <header id="header" class="alt">
         <!-- Logo -->
         <div class="logo">
            <a href="/index.jsp"><strong>KPS</strong> by 바늘토</a>
         </div>

  <!-- Nav -->
         <nav id="nav">
            <ul>
               <li><a href="/index.jsp">Home</a></li>
               <li><a href="/menuPages/intro.jsp">소개</a></li>
               <li><a href="/menuPages/predict.jsp">예측</a></li>
               <li><a href="/menuPages/alarm.jsp">알람</a></li>


               <li>
                  <%
                     if (session.getAttribute("memberNo") == null) {
                  %> <a href="/loginPages/signup.jsp" class="button alt small"><font color=#bea5c6 size="3">Sign Up</font></a> <%
                      } else {
                   %> <a href="/loginPages/mypage.jsp" class="button alt small"><font color=#bea5c6 size="3">My
                        Page</font><%
                      }
                   %>
                  </a>
               </li>

               <li>
                  <%
                     if (session.getAttribute("memberNo") == null) {
                     %> <a href="/loginPages/login.jsp" class="button alt small"
                  id="lowerButton"><font color=#bea5c6 size="3">Log In</font></a><%
                         } else {
                      %> <a href="/biz/logout.jsp" class="button alt small"
                     id="lowerButton"><font color=#bea5c6 size="3">Log Out</font><%
                         }
                      %>
                  </a>
               </li>

            </ul>
         </nav>

      </header>

      <!-- Banner -->
      <section id="banner">
         <div class="content">
         <h1><font color="#f6f4f7">Korea Premium Signal</font></h1>
         </div>
         <a href="#first2" class="more scrolly">Learn More</a>
      </section>

      <!-- Section -->
      <section class="main accent2" id="first2">
         <header>
            <h2>Korea Premuim Graph</h2>
         </header>
         
      
         <div class="inner">
               <div class="content">
                
                 	<div id="container" style="min-width: 200px; height:600px; margin: 0 auto;
                 		max-width: 100%; margin: 1em auto;"></div>
                  <center><font size="3" face="vernada" color="grey"> Bitthum(국내 거래소)과 Bitfinex(해외 거래소)의 현재까지 코리아 프리미엄 그래프입니다. </font></center><br>
                
               </div>
         </div>
      </section>
      

      <!-- Section -->
      
      <section class="main alt" id="first">
         <header>
            <h2>Korea vs Foreign Market</h2>
         </header>
         <div class="inner">
            <article class="main alt">
               <div class="content">
               <!-- https://codepen.io/pixelchar/pen/rfuqK 참고. -->
                  <div class="container" >
                       <table class="responsive-table">
                         <h1 style="text-align:center"><font color="#b168d6">TOP 5</font> KP</h1>
                         <thead>
                           <tr>
                             <th scope="col"><h1>Korea</h1></th>
                             <th scope="col"><h1>Foreign</h1></th>
                             <th scope="col"><h1>Premium</h1></th>
                           </tr>
                         </thead>
                         <tbody id="top5Tbody">
                          </tbody>
                       </table>
                     </div>
               </div>
               
               <div class="content" data-position="center">                  
                  <div class="container">
                     <table class="responsive-table">
                        <h2 style="text-align:center;"><font color="#b168d6">Current </font>KP</h2>
                        <thead>
                           <tr>
                              <th id="currency"></th>
                              <th id="bitthum"></th>
                              <th id="coinone"></th>
                              <th id="upbit"></th>
                           </tr>
                        </thead>
                        <tbody  id="marketBody">
                        </tbody>
                     </table>
                  </div>
               </div>
               
            </article>
         </div>
      </section>
      <!-- Section -->
     



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
   <script type="text/javascript">
  
   $(document).ready(function(){
      $.getJSON("/GetKPJson", function(result){
         $.each(result.sortedList, function(i, field){
            $("#top5Tbody").append(
                  "<tr>"+
                     "<td data-title='Korea'>"+field.kMarket +"</td>"+        
                         "<td data-title='Foreign'>"+field.uMarket +"</td>"+       
                    "<td data-title='Premium' data-type='currency'>"+field.premium+" %</td>"+
                  "</tr>");
            if (i == 4){
               return false;
            }
           });
         $("#currency").html("<h1 style='margin:0;'>Currency</h1><font color='#FFFFFF'>&#8361;"+Number(result.currency).toLocaleString('en').split(".")[0]+"</font>");
         $("#bitthum").html("<h1 style='margin:0;'>Bitthum</h1><span style='color: white; font-size: medium;'>&#8361;"+Number(result.krwList[0]).toLocaleString('en').split(".")[0]+"</span>");
         $("#coinone").html("<h1 style='margin:0;'>Coinone</h1><span style='color: white; font-size: medium;'>&#8361;"+Number(result.krwList[1]).toLocaleString('en').split(".")[0]+"</span>");
         $("#upbit").html("<h1 style='margin:0;'>Upbit</h1><span style='color: white; font-size: medium;'>&#8361;"+Number(result.krwList[2]).toLocaleString('en').split(".")[0]+"</span>");
         var appendString ="";
         $.each(result.preList, function(j,mfield){
            if(j %3 == 0){
               appendString="<tr><td>"+mfield.uMarket+"<br><span style='color: white; font-size: small;'>$ "+
               Number(result.usdList[j/3]).toLocaleString('en').split(".")[0]
               +"</span></td><td>"+mfield.premium+" %</td>";               
            }else if(j%3==1){
               appendString = appendString+"<td>"+mfield.premium+" %</td>";   
            }else if(j%3==2){
               appendString = appendString +"<td>"+mfield.premium+" %</td></tr>";
               $("#marketBody").append(appendString);
            }
            
         });
         });
      $.getJSON(
    		   '/GetBitCoinJSON',
    		    function (data) {

    		        Highcharts.chart('container', {
    		            chart: {
    		                zoomType: 'x'
    		            },
    		            title: {
    		                text: 'KOREA PREMIUM - bithum,bitfinex'
    		            },
    		            subtitle: {
    		                text: document.ontouchstart === undefined ?
    		                        '드래그해서 확대하세요' : 'Pinch the chart to zoom in'
    		            },
    		            xAxis: {
    		                type: 'datetime',
    		                title:{
    		                	text:'시간'
    		                }
    		            },
    		            yAxis: {
    		                title: {
    		                    text: '프리미엄'
    		                },
    		            	labels:{
    		            		format:'{value:.2f} %'
    		            	}
    		            },
    		            legend: {
    		                enabled: false
    		            },
    		            plotOptions: {
    		                area: {
    		                    fillColor: {
    		                        linearGradient: {
    		                            x1: 0,
    		                            y1: 0,
    		                            x2: 0,
    		                            y2: 1
    		                        },
    		                        stops: [
    		                            [0, Highcharts.getOptions().colors[0]],
    		                            [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
    		                        ]
    		                    },
    		                    marker: {
    		                        radius: 2
    		                    },
    		                    lineWidth: 1,
    		                    states: {
    		                        hover: {
    		                            lineWidth: 1
    		                        }
    		                    },
    		                    threshold: null
    		                }
    		            },

    		            series: [{
    		                type: 'area',
    		                name: 'Premium',
    		                data: data
    		            }]
    		        });
    		    }
    		);
   });
   
   </script>
</body>
</html>