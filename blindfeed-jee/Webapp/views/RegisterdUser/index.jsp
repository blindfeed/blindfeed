<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">
    <title>BlindFeed</title>
    <!-- Bootstrap core CSS -->
    <link href='<c:url value="/css/bootstrap.css"></c:url>' rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href='<c:url value="/css/navbar-fixed-top.css"></c:url>' rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <!-- Fixed navbar -->
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><b>BlindFeed</b></a>
          </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">නිවහන</a></li>
            <li><a href="${pageContext.request.contextPath}/RecordServlet">contribution</a></li>
            <li><a href="Nuserabout">විස්තර</a></li>
            <li><a href="Nusercontact">අපගැන</a></li>
            <li><a href="Nuserhelp">උදව්</a></li>
          </ul>
          <% 
          		//get the session which has already initialize that is why set false here
				HttpSession ses=request.getSession(false);
				String name=(String)ses.getAttribute("usr"); 
		  %>
           <form class="navbar-form navbar-right" role="form">
             <a id="user" class="btn btn-success" href="#" role="button">you have logged as <%=name %></a>
             <a id="logout" class="btn btn-success" href="${pageContext.request.contextPath}/logoutProcess" role="button">logout</a>
             <a id="rankuser" class="btn btn-success" href="rankuser" role="button">Request for trusted user</a>
          </form>
          <ul class="nav navbar-nav navbar-right"> 
            <li class="active"></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
    <div class="container">

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>BlindFeed</h1>
        <p>-Shine to their Lonely Life-</p>
        
        
        <div class="row clearfix">
        
        <div class="col-md-12 column">
        
       	<p>
				

			</p>
			<p>
          <a class="btn btn-lg btn-primary" href="Nuserabout" role="button">වැඩි  විස්තර &raquo;</a>
        </p>
			
        </div>
        
         <h3>හදුන්ව දීමේ දර්ශනය</h3>
        <div class="media">
        <video width="820" height="540" controls>
  <source src="resources/movie.mp4" type="video/mp4">
  
  Your browser does not support the video tag.
</video>
</div>
        
       
        
      </div>
      </div>

     <!-- /container -->
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
     <script src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
  </body>
</html>