<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.BitCoinDAO"%>
<!DOCTYPE html>
<html>
<head>
<title>Korean Premium Prediction</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="/assets/css/main.css" />
	<script src="/assets/js/jquery-3.1.1.min.js"></script>
	<script src="/assets/chart/highcharts.js"></script>
	<script src="/assets/chart/exporting.js"></script>
	<script src="/assets/chart/dark-unica.js"></script>
</head>
<body>

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- 메뉴바 -->
		<jsp:include page="/menuPages/menuBar.jsp"></jsp:include>

		<!-- Section -->
		<section class="main accent2">
			<header>
				<h1>Predict</h1>
			</header>
				<div class="inner">
					<div class="content">
					
						<div id="container" style="min-width: 200px; height:700px; margin: 1em auto;"></div>
					<br>
					<center><font size="4" face="vernada" color="grey"> 국내거래소인 빗썸과 해외 거래소 비트파이낵스의 데이터를 이용해 머신러닝으로 예측한 코리아 프리미엄 그래프입니다. </font></center><br>
					<hr class="major" />
					</div>
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

	

	
	<script type="text/javascript">

	$.getJSON(
	   '/GetPredictJSON',
	    function (data) {

	        Highcharts.chart('container', {
	            chart: {
	                zoomType: 'x'
	            },
	            title: {
	                text: 'KOREA PREMIUM PREDICTION - bithum,bitfinex'
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
	</script>
</body>
</html>