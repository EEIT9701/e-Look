<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.ndiv{
	height:120px;
	width:1200px;
	margin-left:auto;
	margin-right:auto;
	text-align:center;
	border:1px solid black;
}
.ndiv li{
	list-style-type:none;
	float:left;
	margin:8px;
}
.svgIcon{
	width:48px;
}

a{
	text-decoration:none;
}


/* -webkit-filter: grayscale(1);  /*沒有任何色彩的黑白影像*/ */
/* -webkit-filter: grayscale(0);  /*顏色不變*/ */


</style>
<script type="text/javascript">
// 	document.addEventListener("DOMContentLoaded", function () {

// 	 });

</script>
</head>
<body>
<!-- 	<div class="ndiv" id="categoryBar"> -->
	<div class="ndiv">
		<ul style="">
			<li><a href="?courseClassID=1"><img style="<c:choose><c:when test='${param.courseClassID == 1 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>" class="svgIcon" src="<%=request.getContextPath() %>/alan/img/life.svg"><br>生活</a></li>
			<li><a href="?courseClassID=2"><img style="<c:choose><c:when test='${param.courseClassID == 2 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>" class="svgIcon" src="<%=request.getContextPath() %>/alan/img/arts.svg"><br>藝術</a></li>
			<li><a href="?courseClassID=3"><img style="<c:choose><c:when test='${param.courseClassID == 3 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>" class="svgIcon" src="<%=request.getContextPath() %>/alan/img/athletics.svg"><br>運動</a></li>
			<li><a href="?courseClassID=4"><img style="<c:choose><c:when test='${param.courseClassID == 4 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>" class="svgIcon" src="<%=request.getContextPath() %>/alan/img/hand-made.svg"><br>手作</a></li>
			<li><a href="?courseClassID=5"><img style="<c:choose><c:when test='${param.courseClassID == 5 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>" class="svgIcon" src="<%=request.getContextPath() %>/alan/img/other.svg"><br>其他</a></li>
			<li><a href="?courseClassID=6"><img style="<c:choose><c:when test='${param.courseClassID == 6 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>" class="svgIcon" src="<%=request.getContextPath() %>/alan/img/design.svg"><br>設計</a></li>
			<li><a href="?courseClassID=7"><img style="<c:choose><c:when test='${param.courseClassID == 7 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>" class="svgIcon" src="<%=request.getContextPath() %>/alan/img/science.svg"><br>科技</a></li>
			<li><a href="?courseClassID=8"><img style="<c:choose><c:when test='${param.courseClassID == 8 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>" class="svgIcon" src="<%=request.getContextPath() %>/alan/img/business.svg"><br>商業</a></li>
			<li><a href="?courseClassID=9"><img style="<c:choose><c:when test='${param.courseClassID == 9 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>" class="svgIcon" src="<%=request.getContextPath() %>/alan/img/language.svg"><br>語言</a></li>
			<li><a href="?courseClassID=10"><img style="<c:choose><c:when test='${param.courseClassID == 10 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>" class="svgIcon" src="<%=request.getContextPath() %>/alan/img/cooking.svg"><br>烹飪</a></li>
			<li><a href="?courseClassID=11"><img style="<c:choose><c:when test='${param.courseClassID == 11 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>" class="svgIcon" src="<%=request.getContextPath() %>/alan/img/program.svg"><br>程式</a></li>
<!-- 			<li style="border:1px solid red;"> -->
<!-- 				<form style="" id="Search" name="Search"  method="post"  action="" > -->
<!-- 					<input style="border:1px solid green" type="text" id="" size="30" name="search" placeholder="Search" /> -->
<%-- 									<input type="image" id="search-submit" name="search-submit" img src="<%=request.getContextPath() %>/alan/img/search.svg" onclick="document.Search.submit()" style="width:30px;border:1px solid gold"/> --%>
<!-- 				</form> -->
<!-- 			</li> -->


<!-- 			<li><input type="text" id="" size="20" name="search" placeholder="Search" /></li> -->
<%-- 			<li><button style="background-image:url(<%=request.getContextPath() %>/alan/img/search.svg);width:25px;height:25px;" type="submit" class=""></button></li> --%>
		</ul>
<%-- 		${param.courseClassID} --%>
		<div style="margin-top:35x;border:1px solid blues;">
	      <form class="navbar-form navbar-left" id="searchKey" method="get" action="" >
		      <div class="input-group">
		      <div style="border:1px solid orange;">
		        <input type="text" class="form-control" placeholder="Search" style="margin-left:230px;border-radius:30px;height:30px;">
		        <div style="float:right" class="input-group-btn">
		          <input type="image" id="search-submit" name="search-submit" img src="<%=request.getContextPath() %>/alan/img/search.svg" onclick="document.Search.submit()" style="width:30px;border:1px solid gold"/>
			 </div>
<!-- 		          <button class="btn btn-default" type="submit" style="height:35px;width:35px;"> -->
<%-- 		          	<img src="<%=request.getContextPath() %>/alan/img/search.svg" /> --%>

<!-- 		          </button> -->
	        </div>
		      </div>
	      </form>
		</div>
		</div>


</html>