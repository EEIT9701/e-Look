<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<script src="<%=request.getContextPath()%>/HeaderCssJs/jquery.js"></script>
<script src="<%=request.getContextPath()%>/HeaderCssJs/bootstrap.min.js"></script>
<script type="text/javascript" src="css/jquery.mmenu.js"></script>
		<script type="text/javascript">
			$(function() {
				$('nav#menu').mmenu();
			});
		</script>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/demo.css" />
<link type="text/css" rel="stylesheet" href="css/jquery.mmenu.css" />
</head>
<body>
		<div id="page">
			<div class="header">
				<a href="#menu"><span></span></a>
				管理者介面
			</div>
			<div class="content">
				<p><strong>管理者介面</strong><br />
					管理人員須知：<br>
					確認網站的重要資訊。再次確認一下網站標題和網站描述是否<br>
					正確，不枉費你辛辛苦苦建立一個網站。網站描述不需要風花<br>
					雪月假文青去寫網站創立目標之類的文字，只需要簡單說明貴<br>
					公司所提供的產品或服務是哪些，通常這些文字也是主要的關<br>
					關鍵字，認真寫好這些關鍵字有很大的幫助。<br>
					</p>
			</div>
			<nav id="menu">
				<ul>
					<li><a href="#">Home</a></li>
					<li><span>About us</span>
						<ul>
							<li><a href="#about/history">History</a></li>
							<li><span>The team</span>
								<ul>
									<li><a href="#about/team/management">Management</a></li>
									<li><a href="#about/team/sales">Sales</a></li>
									<li><a href="#about/team/development">Development</a></li>
								</ul>
							</li>
							<li><a href="#about/address">Our address</a></li>
						</ul>
					</li>
					<li><a href="#contact">Contact</a></li>
				</ul>
			</nav>
		</div>
</body>
</html>