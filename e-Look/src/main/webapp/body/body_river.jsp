<%@page import="com.e_Look.search.SearchDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="Short Icon" type="image/x-icon" href="${initParam.icon}" />
<title>${initParam.systemName}</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="HeaderCssJs/bootstrap.css" rel="stylesheet">
<!-- <link href="HeaderCssJs/bootstrap.min.css" rel="stylesheet"> -->
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="css/modern-business.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<!-- 載入課程模板css -->
<!-- <link href="css/twmplate.css" rel="stylesheet"> -->
<script src="HeaderCssJs/jquery.js"></script>
<script src="HeaderCssJs/bootstrap.min.js"></script>

<style type="text/css">
/* 課程模板 */
h5 {
	font-size: 1.28571429em;
	font-weight: 700;
	line-height: 1.2857em;
	margin: 0;
}

.card {
	font-size: 1em;
	overflow: hidden;
	padding: 0;
	border: none;
	border-radius: .28571429rem;
	box-shadow: 0 1px 3px 0 #d4d4d5, 0 0 0 1px #d4d4d5;
}

.card-block {
	font-size: 1em;
	position: relative;
	margin: 0;
	padding: 1em;
	border: none;
	border-top: 1px solid rgba(34, 36, 38, .1);
	box-shadow: none;
}

.card-img-top {
	display: block;
	width: 340px;
/* 	height:200px; */
	margin-top: 4px;
	margin-bottom: 4px;
}

.card-title {
	font-size: 1.28571429em;
	font-weight: 700;
	line-height: 1.2857em;
}

.card-text {
	clear: both;
	margin-top: .5em;
	height: 70px;
}

.card-footer {
	font-size: 15px;
	position: static;
	top: 0;
	left: 0;
	max-width: 100%;
	padding: .75em 1em;
	color: gray;
	border-top: 1px solid rgba(0, 0, 0, .05) !important;
	background: #fff;
}

.card-inverse .btn {
	border: 1px solid rgba(0, 0, 0, .05);
}

.profile {
	position: absolute;
	top: -30px;
	display: inline-block;
	overflow: hidden;
	box-sizing: border-box;
	width: 50px;
	height: 50px;
	margin: 0;
	border: 1px solid #fff;
	border-radius: 50%;
}

.profile-avatar {
	display: block;
	width: 100%;
	height: auto;
	border-radius: 50%;
}

.profile-inline {
	position: relative;
	top: 0;
	display: inline-block;
}

.profile-inline ~ .card-title {
	display: inline-block;
	margin-left: 4px;
	vertical-align: top;
}

.text-bold {
	font-weight: 700;
}

.meta {
	font-size: 2em;
}

.meta a {
	text-decoration: none;
	color: rgba(0, 0, 0, .4);
}

.meta a:hover {
	color: rgba(0, 0, 0, .87);
}

.multi_ellipsis {
	overflow: hidden;
	display: -webkit-box;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 2;
	line-height: 30px;
	height: 60px;
	font-size: 30px;
}

/* 分類按鈕 */
.ndiv {
 	height:130px;
/* 	width: 1100px; */
	width: 76%;
	margin:0 auto;
	text-align: center;
 	border-bottom: 1.5px solid black;
/* 	border:1.5px solid black; */
	padding-top:0.6%;
	padding-bottom:0.6%;
	margin-bottom:1.2%;
}

.ndiv li {
	list-style-type: none;
	float: left;
 	margin-top:1%;
 	margin-left:1%;
/*  border:2px solid red; */
 	width:5%;
}

.svgIcon {
	width: 50px;
}

.ndiv a {
	text-decoration: none;
	visited: none;
	active: none;
	font-size: 20px;
	font-family: 微軟正黑體;
}

.ndiv a:hover{
	text-decoration: none;
}

.ndiv a:link {
	color: #9F35FF;
}

.ndiv a:visited {
	color: #9F35FF;
}
#li_searchArea{
  	margin-left:4%;
  	margin-top:1.3%;
  	width:20%;
/*  border:2px solid red; */
}
.outsideBorder{
	border:3px solid orange;
	border-radius:25px;
	height:44px;
	width:130%;
}
.betweenOutAndInner{
	padding-left:6%;
	padding-top:0.8%;
/* 	padding-bottom:0.8%; */
}
.searchInput{
	padding-left:2%;
	border-radius:25px;
	height:28px;
}
.searchSubmitIcon{
	width:36px;
	padding-right:2px;
/* 	border:1px solid blue; */
}
/* 分類下課程,拿掉後瀏覽器縮太小時,模板不會一起縮放 */
.videobox{
  	width: 80%;
  	margin:0 auto;
}
.hotkeyword{
 	padding-left:10%;
	padding-top:2%;"
/* 	text-align:center; */
/* 	color:blue; */
}

.keyword{
 	clear:both;
	color:blue;

}
</style>
<script type="text/javascript">
	//為文件的滑鼠按下事件定義回呼
	document.onmousedown = function(event) {
		//滑鼠事件：0 > 沒按鍵, 1 > 按左鍵, 2 > 按右鍵, 3 > 按左鍵&右鍵
		//4 > 按中間鍵, 5 > 按左鍵&中間鍵, 6 > 按右鍵&中間鍵, 7 > 按所有鍵
		if (event.button == 2) {
			//提示使用者禁用滑鼠右鍵
			alert("禁用滑鼠右鍵!");
		}
	}

	/*展示廣告圖片*/
	function showAdPic() {
		//獲得廣告的DOM
		var ads = document.getElementById("ads");
		//直接在DOM中增加HTML原始程式來增加一個圖片的DOM
		ads.innerHTML = "<img src='img/xmas video sale.jpg' width='650' />";
		//設定計時器,3秒以後關閉廣告圖片
		setTimeout(function() {
			var ads = document.getElementById("ads");
			//隱藏圖片
			ads.style.display = "none";
		}, 1500)
	}
	//window.onload = showAdPic;
	
 	/*瀑布流關鍵*/
	var rowValueX = 0;
	$(function() {
		//showAdPic();
		//init();
		river();
		//卷軸初載入高度為0
		var	wst = $(window).scrollTop();
		//視窗高度
		var	wh = $(window).height();
		//整份文件
		var	dh =$(document).height();
		console.log(wst+"---"+dh+"---"+wh);
		$(window).scroll(river);
	});

	function river(){
		//卷軸初再入高度為0
		var	wst = $(window).scrollTop();
		//視窗高度
		var	wh = $(window).height();
		//整份文件
		var	dh =$(document).height();
		//$('a[href="#menu1"]').text(wst+"---"+dh+"---"+wh)
		//console.log(wst+"---"+dh+"---"+wh);
		//判斷卷軸是否到底部
		if(wst==(dh-wh) ){
			rowValueX++;
			$.get("<%= request.getContextPath() %>/body/body_data.jsp",{"rowValueY":rowValueX},function(data){
				$('#river').append(data);
			});
		}
	}
	
	
	/*延遲載入圖片*/
	//初始化函數
	function init() {
		//開始計時器
		//setTimeout("checkHeight()", 1000);
	}
	//計時器函數
	function checkHeight() {
		//圖片的DOM
		var rows = document.querySelectorAll(".row");
		//console.log(pics)
		//var pic = document.getElementById("pic");
		//取得捲軸的位置
		var sTop = document.documentElement.scrollTop;
		//取得可見區域高度
		var cHeight = document.documentElement.clientHeight;

		for (i = 1; i < rows.length; i++) {
			//圖片距離最左上角的top值
			var top = rows[i].offsetTop;
			//如果捲軸還未來到可見區域
			if (sTop + cHeight < top) {
				//計時器繼續工作
				setTimeout("checkHeight()", 1500);
			} else {

				var pics = rows[i].querySelectorAll("img");
				for (var j = 0; j < pics.length; j++) {
					pics[j].src = pics[j].getAttribute("lazy_src");
				}
				//把延遲的值指定給src
				//pics[i].src = pics[i].getAttribute("lazy_src");
				//console.log(top);
			}
		}

	}
</script>
</head>
<body>
<%-- 	<jsp:include page="${contextPath}/header.jsp" /> --%>
	<jsp:include page="${contextPath}/login.jsp" />
	

	<!-- 分類按鈕和搜索star -->
	<div class="ndiv">
		<ul>
			<li><a href="?courseClassID=1"><img
					style="<c:choose><c:when test='${param.courseClassID == 1 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/life.svg"><br>生活</a></li>
			<li><a href="?courseClassID=2"><img
					style="<c:choose><c:when test='${param.courseClassID == 2 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/arts.svg"><br>藝術</a></li>
			<li><a href="?courseClassID=3"><img
					style="<c:choose><c:when test='${param.courseClassID == 3 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/athletics.svg"><br>運動</a></li>
			<li><a href="?courseClassID=4"><img
					style="<c:choose><c:when test='${param.courseClassID == 4 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/video.svg"><br>影音</a></li>
			<li><a href="?courseClassID=5"><img
					style="<c:choose><c:when test='${param.courseClassID == 5 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/hand-made.svg"><br>手作</a></li>
			<li><a href="?courseClassID=6"><img
					style="<c:choose><c:when test='${param.courseClassID == 6 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/other.svg"><br>其他</a></li>
			<li><a href="?courseClassID=7"><img
					style="<c:choose><c:when test='${param.courseClassID == 7 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/design.svg"><br>設計</a></li>
			<li><a href="?courseClassID=8"><img
					style="<c:choose><c:when test='${param.courseClassID == 8 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/science.svg"><br>科技</a></li>
			<li><a href="?courseClassID=9"><img
					style="<c:choose><c:when test='${param.courseClassID == 9 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/business.svg"><br>商業</a></li>
			<li><a href="?courseClassID=10"><img
					style="<c:choose><c:when test='${param.courseClassID == 10 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/language.svg"><br>語言</a></li>
			<li><a href="?courseClassID=11"><img
					style="<c:choose><c:when test='${param.courseClassID == 11 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/cooking.svg"><br>烹飪</a></li>
			<li><a href="?courseClassID=12"><img
					style="<c:choose><c:when test='${param.courseClassID == 12 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/program.svg"><br>程式</a></li>
			<li id="li_searchArea">
				<form class="navbar-form navbar-left" id="searchKey" method="POST"
					action="<%=request.getContextPath() %>/SearchController">
					<div class="input-group">
						<div class="outsideBorder">
							<div class="betweenOutAndInner">

								<input name="keyWord" type="text" class="form-control" placeholder="Search"
									class="searchInput">

								<div style="float:right" class="input-group-btn">
									<input type="image" img
										src="<%=request.getContextPath()%>/alan/img/search.svg"
										onclick="document.Search.submit()"
										class="searchSubmitIcon"/>
								</div>
							</div>
						</div>
						<p class="hotkeyword text-left">熱門：
						<span class="keyword">
							<c:forEach var="searchVO" items="<%= new SearchDAO().getKeywordRank(3) %>" >
							<%-- <a href="<%= request.getRequestURI() + request.getQueryString() %>keyWord=">${searchVO.keyWord }</a> --%>
									${searchVO.keyWord}

							</c:forEach>
						</span>
<!-- 						<span class="keyword" id="keyword1">學英文</span>&nbsp; -->
<!-- 						<span class="keyword" id="keyword2">簡單料理</span>&nbsp; -->
<!-- 						<span class="keyword" id="keyword3">健身</span>&nbsp; -->
						</p>
					</div>
				</form>
			</li>
		</ul>

	</div>
	<!-- 分類按鈕和搜索end -->

	<!-- 3秒消失廣告star -->
	<div style="text-align:center">
		<a href=""><span id="ads"></span></a>
	</div>
	<!-- 3秒消失廣告end -->

	<div class="videobox container">
		<div class="row" id="river">
		
		<!-- end of class="container" -->
		</div>
	</div>

<jsp:include page="${contextPath}/footer.jsp" />
</body>
</html>