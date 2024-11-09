<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>三乐</title>

		<!-- meta -->
		<meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">

	    <!-- css -->
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/ionicons.min.css">
		<link rel="stylesheet" href="css/pace.css">
	    <link rel="stylesheet" href="css/custom.css">

	    <!-- js -->
	    <script src="js/jquery-2.1.3.min.js"></script>
	    <script src="js/bootstrap.min.js"></script>
	    <script src="js/pace.min.js"></script>
	    <script src="js/modernizr.custom.js"></script>
	</head>

	<body id="page">
		<div class="container">	
			<header id="site-header">
				<div class="row">
					<div class="col-md-4 col-sm-5 col-xs-8">
						<div class="logo">
							<h1><a href="ToIndexServlet"><b>三乐</b>の博客</a></h1>
						</div>
					</div><!-- col-md-4 -->
					<div class="col-md-8 col-sm-7 col-xs-4">
						<nav class="main-nav" role="navigation">
							<div class="navbar-header">
  								<button type="button" id="trigger-overlay" class="navbar-toggle">
    								<span class="ion-navicon"></span>
  								</button>
							</div>

							<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
								<ul class="nav navbar-nav navbar-right">
									<li class="cl-effect-11"><a href="ToIndexServlet" data-hover="Blog">Blog</a></li>
									<li class="cl-effect-11"><a href="writeblog.jsp" data-hover="Write">Write</a></li>
									<li class="cl-effect-11"><a href="about.jsp" data-hover="About">About</a></li>
									<%--<li class="cl-effect-11"><a href="contact.html" data-hover="Contact">Contact</a></li>--%>
								</ul>
							</div><!-- /.navbar-collapse -->
						</nav>
<%--						<div id="header-search-box">--%>
<%--							<a id="search-menu" href="#"><span id="search-icon" class="ion-ios-search-strong"></span></a>--%>
<%--							<div id="search-form" class="search-form">--%>
<%--								<form role="search" method="get" id="searchform" action="#">--%>
<%--									<input type="search" placeholder="Search" required>--%>
<%--									<button type="submit"><span class="ion-ios-search-strong"></span></button>--%>
<%--								</form>				--%>
<%--							</div>--%>
<%--						</div>--%>
					</div><!-- col-md-8 -->
				</div>
			</header>
		</div>

		<div class="content-body">
			<div class="container">
				<div class="row">
					<main class="col-md-12">
						<h1 class="page-title">关于我</h1>
						<article class="post">
							<div class="entry-content clearfix">
								<figure class="img-responsive-center">
									<img class="img-responsive" src="img/me.jpg" alt="Developer Image">
								</figure>
								<p>三乐原创</p>
								<p>杨乐42207636</p>
								<div class="height-40px"></div>
								<h2 class="title text-center">Social</h2>
								<ul class="social">
									<li class="facebook"><a href="#"><span class="ion-social-facebook"></span></a></li>
									<li class="twitter"><a href="#"><span class="ion-social-twitter"></span></a></li>
									<li class="google-plus"><a href="#"><span class="ion-social-googleplus"></span></a></li>
									<li class="tumblr"><a href="#"><span class="ion-social-tumblr"></span></a></li>
								</ul>
							</div>
						</article>
					</main>
				</div>
			</div>
		</div>
		<footer id="site-footer">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<p class="copyright">&copy; <a target="_blank" href="" >42207636</a></p>
					</div>
				</div>
			</div>
		</footer>

		<!-- Mobile Menu -->
		<div class="overlay overlay-hugeinc">
			<button type="button" class="overlay-close"><span class="ion-ios-close-empty"></span></button>
			<nav>
				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="writeblog.jsp">Blog</a></li>
					<li><a href="about.jsp">About</a></li>
					<li><a href="contact.html">Contact</a></li>
				</ul>
			</nav>
		</div>

		<script src="js/script.js"></script>
		
	</body>
</html>
