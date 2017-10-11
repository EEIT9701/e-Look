<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.ndiv{
	width:800px;
	margin-left:auto;
	margin-right:auto;
	text-align:center;
}
.ndiv li{
	list-style-type:none;
	float:left;
	margin:8px;
}
.svgIcon{
	width:48px;
}
.grey{
	-webkit-filter: grayscale(1);  /*沒有任何色彩的黑白影像*/
}
.original{
	 -webkit-filter: grayscale(0);  /*顏色不變*/
}
a{
	text-decoration:none;
}
</style>
<script type="text/javascript">
	document.addEventListener("DOMContentLoaded", function () {
		
//  		aNum = document.querySelectorAll(".ndiv a");
//  		console.log(".ndiv a = " + aNum)
//  		console.log("aNum.length = " + aNum.length)
//  		for(var j = 0; j < aNum.length; j++) {
//  			aNum[j].onclick = ckickA;
//  		}
		
		
		<!-- 
	    iconNum = document.querySelectorAll(".ndiv img");
	    iconLen = iconNum.length;
	    //console.log("iconNum = " + iconNum);
	    //console.log("iconLen = " + iconLen);
	     for (var i = 0; i < iconLen; i++) {
	    	 //console.log("1 - onclick");
	    	 iconNum[i].onclick = Click;
	     }
	     -->
	 });
	
	
	
	<!-- 
  	 function Click() {
          for (i = 0; i < iconLen; i++) {
         	  //console.log("2 - Click()");
        	  iconNum.className = "svgIcon grey";
        	  iconNum[i].className = "svgIcon original";
          }
      }
	-->
	
// 	function start() {
// 		//開始計時器
// 		setTimeout("ckickA()", 1000);
// 	}

// 	function ckickA() {
// 		console.log("1213")
// 		var icons = document.querySelectorAll(".ndiv img");	
// 		for(var k = 0; k < icons.length; k++) {
// 			icons[k].style = icons[k].attributes["lazy_style"].value;
// 		}
// 	}

// onmousedown="style='-webkit-filter:grayscale(1)';

</script>
</head>
<body>
<!-- 	<div style="text-align:center;"> -->
	<div class="ndiv">
		<ul>
		<!-- <a href=""></a> -->
			<li><a href=""><img lazy_style="-webkit-filter:grayscale(1)" style="" 
				class="svgIcon" src="<%=request.getContextPath() %>/alan/img/life.svg" onmousedown=""><br>生活</a>
			</li>
			<li><a href=""><img lazy_style="-webkit-filter:grayscale(1)" style="-webkit-filter:grayscale(0)" 
				class="svgIcon" src="<%=request.getContextPath() %>/alan/img/arts.svg"><br>藝術</a>
			</li>
			<li><a href=""><img lazy_style="-webkit-filter:grayscale(1)" style="-webkit-filter:grayscale(0)" 
				class="svgIcon" src="<%=request.getContextPath() %>/alan/img/athletics.svg"><br>運動</a>
			</li>
			<li><a href=""><img lazy_style="-webkit-filter:grayscale(1)" style="-webkit-filter:grayscale(0)" 
				class="svgIcon" src="<%=request.getContextPath() %>/alan/img/hand-made.svg"><br>手作</a>
			</li>
			<li><a href=""><img lazy_style="-webkit-filter:grayscale(1)" style="-webkit-filter:grayscale(0)" 
				class="svgIcon" src="<%=request.getContextPath() %>/alan/img/other.svg"><br>其他</a>
			</li>
			<li><a href=""><img lazy_style="-webkit-filter:grayscale(1)" style="-webkit-filter:grayscale(0)" 
				class="svgIcon" src="<%=request.getContextPath() %>/alan/img/design.svg"><br>設計</a>
			</li>
			<li><a href=""><img lazy_style="-webkit-filter:grayscale(1)" style="-webkit-filter:grayscale(0)" 
				class="svgIcon" src="<%=request.getContextPath() %>/alan/img/science.svg"><br>科技</a>
			</li>
			<li><a href=""><img lazy_style="-webkit-filter:grayscale(1)" style="-webkit-filter:grayscale(0)" 
				class="svgIcon" src="<%=request.getContextPath() %>/alan/img/business.svg"><br>商業</a>
			</li>
			<li><a href=""><img lazy_style="-webkit-filter:grayscale(1)" style="-webkit-filter:grayscale(0)" 
				class="svgIcon" src="<%=request.getContextPath() %>/alan/img/language.svg"><br>語言</a>
			</li>
			<li><a href=""><img lazy_style="-webkit-filter:grayscale(1)" style="-webkit-filter:grayscale(0)" 
				class="svgIcon" src="<%=request.getContextPath() %>/alan/img/cooking.svg"><br>烹飪</a>
			</li>
			<li><a href=""><img lazy_style="-webkit-filter:grayscale(1)" style="-webkit-filter:grayscale(0)" 
				class="svgIcon" src="<%=request.getContextPath() %>/alan/img/program.svg"><br>程式</a>
			</li>
		</ul>
	</div>

	<!--  
		<div><img class="svgIcon" src="<%=request.getContextPath() %>/alan/img/life.svg"><a href="#category1">生活</a></div>
		<div><img class="svgIcon" src="<%=request.getContextPath() %>/alan/img/arts.svg"><a href="#category2">藝術</a></div>
		<div><img class="svgIcon" src="<%=request.getContextPath() %>/alan/img/athletics.svg"><a href="#category3">運動</a></div>
		<div><img class="svgIcon" src="<%=request.getContextPath() %>/alan/img/video.svg"><a href="#category4">影音</a></div>
	-->
	<!--
		<ul class="menu" id="menu">
			<li><a href="#">選單1</a></li>
			<li><a href="#">選單2</a></li>
			<li><a href="#">選單3</a></li>
			<li><a href="#">選單4</a></li>
		</ul>
	-->
</alan>
</html>