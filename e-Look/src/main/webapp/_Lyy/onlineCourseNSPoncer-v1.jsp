<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/HeaderCssJs/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/HeaderCssJs/bootstrap.css"
	rel="stylesheet">
<!-- <!-- jQuery -->
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>

<!-- <!-- Bootstrap Core JavaScript -->
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$(".col-md-4 a").click(function() {
			$(this).tab('show');
		});
	});
</script>

<style>
/* 影片區塊 */
video {
	width: 100%;
	height: 75%;

}

#videoArea {
	background-size: cover;
	background-position: center;
	height: 600px;
}

video::-internal-media-controls-download-button {
	display: none;
}

video::-webkit-media-controls-enclosure {
	overflow: hidden;
}

video::-webkit-media-controls-panel {
	width: calc(100% + 30px); /* Adjust as needed */
}

#videoDivListStyle {
	border: 1px solid gray;
	height: 75%;
	padding-left: -15px;
	padding-right: -15px;
	background-color: rgba(0%, 10%, 20%, 0.7);;
}

#videoDivListStyle>div>h3 {
	color: white;
	text-align: center;
	font-weight: bold;
}
#videoDivListStyle>div>div>p {
	color: white;
	font-weight: bold;
display:inline-block;
	
	
}
/* a:hover, a:focus { */
/* 	outline: none; */
/* 	text-decoration: none; */
/* } */
.tab .nav-tabs {
	position: relative;
	border-bottom: none;
}

.tab .nav-tabs li {
	text-align: center;
	margin-right: 10px;
}

.tab .nav-tabs li a {
	display: block;
	font-size: 16px;
	font-weight: 600;
	color: #444;
	padding: 10px 15px;
	background: transparent;
	margin-right: 0;
	border: none;
	border-radius: 0;
	overflow: hidden;
	position: relative;
	z-index: 1;
	transition: all 0.5s ease 0s;
}

.tab .nav-tabs li a:before {
	content: "";
	width: 100%;
	height: 3px;
	background: #de7921;
	position: absolute;
	top: 92%;
	left: 0;
	transition: all 0.3s ease 0s;
}

.tab .nav-tabs li a:hover:before, .tab .nav-tabs li.active a:before,
	.tab .nav-tabs li.active a:hover:before {
	top: 0;
}

.tab .nav-tabs li a:after {
	content: "";
	width: 100%;
	height: 100%;
	background: #fff;
	position: absolute;
	top: 100%;
	left: 0;
	z-index: -1;
	transition: all 0.3s ease 0s;
}

.tab .nav-tabs li a:hover:after, .tab .nav-tabs li.active a:after, .tab .nav-tabs li.active a:hover:after
	{
	top: 0;
}

.nav-tabs li.active a, .nav-tabs li.active a:focus, .nav-tabs li.active a:hover,
	.nav-tabs li a:hover {
	border: none;
}

.tab .tab-content {
	padding: 30px 15px 20px;
	background: #fff;
	font-size: 14px;
	color: #555;
	line-height: 26px;
}

.tab .tab-content h3 {
	font-size: 24px;
	margin-top: 0;
}

.star {
	-webkit-filter: grayscale(1);
}

.nstar {
	-webkit-filter: grayscale(0);
}
</style>
</head>
<!-- 影片區 -->
<body oncontextmenu="window.event.returnValue=false">
	<jsp:include page="/login.jsp" flush="true" />
	<div class="container-fluid">
		<div class="container">
			<div class="row">

				<div class="col-md-12 " id="videoArea"
					style="background-image: url('<%=request.getContextPath()%>/_Lyy/o.jpg')">
					<h1 align="center" style="color: white">videoname</h1>
					<div class="col-md-12">
						<div class="col-md-8 col-xs-12">
							<video poster="<%=request.getContextPath()%>/_Lyy/poster.png">
								<source src="<%=request.getContextPath()%>/_Lyy/tri.mp4"
									type="video/mp4">
							</video>
						</div>
						<div class="col-md-4 col-xs-12" id="videoDivListStyle">
							<div>
								<h3>募資進行中</h3>
								<div class="pull-left"><p >目標人數100人</p></div>
								<div class="pull-right"><p >達成30%</p></div>
								<div class="clearfix" ></div>
								<div class="progress progress-striped active">
									<div class="progress-bar progress-bar-info" role="progressbar"
										aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
										style="width: 30%;">
									</div>
								</div>
								
							</div>



						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 人數、時間 等等-->
	<div class="container">
		<div class="row">
			<div class="col-md-12">


				<div class="col-md-2 col-xs-3">
					<%-- 					<img src="<%=request.getContextPath()%>/_Lyy/004-people.png" --%>
					<!-- 						class="img-responsive center-block "> -->
					<!-- 					<h5 class="text-center">課程人數</h5> -->
				</div>
				<div class="col-md-2 col-xs-3">
					<%-- 					<img src="<%=request.getContextPath()%>/_Lyy/clock.png" --%>
					<!-- 						class="img-responsive center-block"> -->
					<!-- 					<h5 class="text-center">課程時間</h5> -->
				</div>
				<div class="col-md-2 col-xs-3 ">
					<img src="<%=request.getContextPath()%>/_Lyy/share.png"
						class="img-responsive center-block">
					<div class="dropdown text-center" style="margin: 6px">
						<a data-toggle="dropdown">分享連結 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">FaceBook</a></li>
							<li><a href="#">Google</a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-2 col-xs-3 ">
					<%-- 					<img src="<%=request.getContextPath()%>/_Lyy/001-download.png" --%>
					<!-- 						class="img-responsive center-block"> -->
					<!-- 					<h5 class="text-center"> -->
					<!-- 						<a href="#">講義下載</a> -->
					<!-- 					</h5> -->
				</div>
				<div class="col-md-2 col-xs-6 ">
					<!-- 					<h5>課程售價</h5> -->
					<!-- 					<h2 style="text-align: center; font-weight: bold;">NT1230</h2> -->
				</div>
				<div class="col-md-2 col-xs-6 center-block">
					<!-- 					<div style="width:70px;margin:0 auto"> -->
					<%-- 						<img id="idstar1" class="star" src="<%=request.getContextPath()%>/star/ystar.png" />  --%>
					<%-- 						<img id="idstar2" class="star" src="<%=request.getContextPath()%>/star/ystar.png" />  --%>
					<%-- 						<img id="idstar3" class="star " src="<%=request.getContextPath()%>/star/ystar.png" />  --%>
					<%-- 						<img id="idstar4" class="star " src="<%=request.getContextPath()%>/star/ystar.png" />  --%>
					<%-- 						<img id="idstar5" class="star " src="<%=request.getContextPath()%>/star/ystar.png" /> --%>
					<!-- 					</div> -->
					<!-- 					<button type="button" class="btn btn-success center-block" -->
					<!-- 						style="width: 160px">加入購物車</button> -->
				</div>
			</div>
		</div>
	</div>
	<!--內容 -->

	<div class="demo">
		<div class="container" style="background: #efd391">
			<div class="row">
				<div class="col-md-12">
					<div class="tab" role="tabpanel">

						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a href="#Section1"
								aria-controls="home" role="tab" data-toggle="tab">課程簡介</a></li>
							<li role="presentation"><a href="#Section2"
								aria-controls="home" role="tab" data-toggle="tab">講師簡介</a></li>
							<li role="presentation"><a href="#Section3"
								aria-controls="profile" role="tab" data-toggle="tab">課程討論</a></li>
							<li role="presentation"><a href="#Section4"
								aria-controls="messages" role="tab" data-toggle="tab">點評收藏</a></li>
						</ul>

						<div class="tab-content tabs">
							<div role="tabpanel" class="tab-pane fade in active"
								id="Section1">

								<p>黑松企業是1925年由張氏家族所創立，創辦人張文杞先生受家庭環境影響，自小即有做生意的願望。
									1924年末於台北後火車站，鄭州路附近一家生產彈珠汽水的「尼可尼可」（ニコニコラムネ）商會有意出
									讓，文杞先生遂興起作汽水的念頭。於是文杞先生籌措大部分資金，買下「尼可尼可」商會設備，七位堂兄
									弟合股於1925年組成「進馨商會」，首創以「山型」為商標的「富士牌」汽水、及以三兄弟聯手創業圖案
									為商標的「三手牌」彈珠汽水，種下黑松企業的幼苗，當時由張文杞先生從事開發生產，其弟張有盛先生負
									責推銷業務，兄弟分工為汽水事業打拼，奠定黑松企業發展的基石。時序至今，黑松公司屹立台灣飲料市場
									近百年，始終秉持著創業第一代的經營理念，即為「誠實服務」，以核心的研發生產能力及良好的企業文化
									，在飲料的專業領域不斷創新及提升品質，並致力於經銷通路的經營，同時長期投入環保綠色行動，成為善
									盡社會責任、對環境友善的績優企業。</p>
							</div>

							<div role="tabpanel" class="tab-pane fade" id="Section2">

								<p>本校為研究型大學，向以理工著稱，尤在電子、資通訊及光電等領域已佔世界頂尖領導之地位，另於優勢基礎
									之上，發展管理與科技領域之結合、開拓人文社會新興領域及開展國際客家文化。近年更結合既有優勢領域進入新
									興生醫電子領域並發展問題解決為取向之科技應用工程領域。.</p>
							</div>
							<div role="tabpanel" class="tab-pane fade" id="Section3">

								<p>本校為研究型大學，向以理工著稱，尤在電子、資通訊及光電等領域已佔世界頂尖領導之地位，另於優勢基礎
									之上，發展管理與科技領域之結合、開拓人文社會新興領域及開展國際客家文化。近年更結合既有優勢領域進入新
									興生醫電子領域並發展問題解決為取向之科技應用工程領域。.</p>
							</div>
							<div role="tabpanel" class="tab-pane fade" id="Section4">

								<p>喜歡的話記得幫我們評分還有收藏唷</p>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/footer.jsp" />
</body>
</html>