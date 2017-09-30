<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="HeaderCssJs/bootstrap.css" rel="stylesheet">
<link href="HeaderCssJs/bootstrap.min.css" rel="stylesheet">
<script src="HeaderCssJs/jquery.js"></script>
<script src="HeaderCssJs/bootstrap.min.js"></script>

<style>
li a:hover {  
color:#fc3a63; /* 當滑鼠經過時，超連結文字顏色變成桃紅色     ps.被bootstrap.css4518行複寫，所以顏色沒變更 */  
position: relative; /* 當滑鼠經過超連結時，超連結往右下位移2像素 */  
top: 2px;  
left: 2px; 
}  


/*根據bootstrap.css內容加以覆寫的方式*/
.navbar-default .navbar-nav li a:hover{
color:#fc3a63;
}

.navbar-default .navbar-nav > li > a:active{
color:	#000000;
}
.navbar-default .navbar-nav {
padding-left:300px;
}
body{font-size:20px;
font-family: Microsoft JhengHei;}


</style>
<nav class="nav navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header ">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span> 
                </button>
                <a href="#" ><img src="HeaderCssJs/eLook_LOGO.png"  height="60" border="0" alt="e-Look"></a>			
			</div>
			
			<div class="collapse navbar-collapse" id="myNavbar"><!--底下放要縮放的內容-->
				<ul class="nav navbar-nav ">

					<li><a  href="#menu1"><img src="HeaderCssJs/004-group.png"   >募資</a></li>
					<li><a  href="#menu2"><img src="HeaderCssJs/003-mortarboard.png"   >線上課程</a></li>
					<li><a  href="#menu2"><img src="HeaderCssJs/001-gift.png"   >免費課程</a></li>
					<li><a  href="#menu2"><img src="HeaderCssJs/002-notification.png"   >我要開課</a></li>

				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><img src="HeaderCssJs/001-login.png"/>Login</a></li>
<!-- 					<li><a data-toggle="tab" href="#">Log out</a></li> -->
<!-- 					<li><a data-toggle="tab" href="#"><span -->
<!-- 							class="glyphicon glyphicon-user"></span> Admin</a></li> -->
				</ul>
			</div>
		</div>
	</nav>	
</head>
<body>
	
</body>
</html>