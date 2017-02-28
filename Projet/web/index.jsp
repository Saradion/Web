<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>JEE Project</title>
	<link rel="stylesheet" href="styles.css" type="text/css" media="screen" />
	<link rel="stylesheet" type="text/css" href="print.css" media="print" />
</head>
<body>
<div id="wrapper"><!-- #wrapper -->

	<nav><!-- top nav -->
		<div class="menu">
			<ul>
				<li><a href="documentation.html">Documentation</a></li>
				<li><a href="challenges.html">challenges</a>
			</ul>
		</div>
	</nav><!-- end of top nav -->

	<header><!-- header -->

		<h1><img src="images/logo.png"></h1>
		<h2>The JEE Project: learning code while playing!</h2>
	</header><!-- end of header -->

	<section id="main"><!-- #main content and sidebar area -->
		  <section id="content"><!-- #content -->
		  		<p>Hello ${Joueur.identifiant} !</p>
		  <%if(request.getAttribute("documentation")!=null && (boolean)request.getAttribute("documentation")){
			  request.getRequestDispatcher( "documentation.html" ).include( request, response );
		  } else if(request.getAttribute("challenges")!=null && (boolean)request.getAttribute("challenges")){
			  request.getRequestDispatcher( "challenges.html" ).include( request, response );
		  }
		  //A continuer avec les challenges eux-mêmes, et pourquoi pas inscription et connection
		  %>
		  
			</section><!-- end of #content -->

		<aside id="sidebar"><!-- sidebar -->
					<h3>Places to go</h3>
					<ul>
						<li><a href="Serv?documentation=true">Documentation</a></li>
						<li><a href="Serv?challenges=true">challenges</a>
					</ul>

				<h3>&nbsp;</h3>
				<br />
  <br /><br />

		</aside><!-- end of sidebar -->

	</section><!-- end of #main content and sidebar-->

		<footer>
		<section id="footer-area">

			<section id="footer-outer-block">

					<aside class="footer-segment">
							<h4>&nbsp;</h4>
								<p>Projet JEE 2016  par Marie Bouette, Maxime Boulmeck, Sarah Chaouki, Matthias Bigaignon</p>
					</aside>

			</section><!-- end of footer-outer-block -->

		</section><!-- end of footer-area -->
	</footer>

</div><!-- #wrapper -->
</body>
</html>