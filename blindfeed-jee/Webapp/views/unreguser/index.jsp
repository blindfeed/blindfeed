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

  </head>
<body>
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
            <li><a href="${pageContext.request.contextPath}/views/unreguser/about.jsp">විස්තර</a></li>
            <li><a href="${pageContext.request.contextPath}/contact.jsp">අප ගැන</a></li>
            <li><a href="${pageContext.request.contextPath}/help.jsp">උදව්</a></li>
            
          </ul>
          
          <!-- login module which executes the loginprocess servlet -->

  <form action="${pageContext.request.contextPath}/loginProcess" class="navbar-form navbar-right" role="form" method="post">
            <div class="form-group">
              <input type="text" placeholder="Email" name="EMail" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" name="Password" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">ඇතුළු වන්න</button>
             <a class="btn btn-success" href="#" role="button">එක් වන්න අලුතෙන්</a>
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
				ලෝක ජනගහනයෙන් මිලියන 250ක් දෘශ්‍යාබාදිතයින් වේ.ඉන් මිලියන 39ක් සම්පූර්නයෙන්ම 
අන්ධ භාවයෙන් පෙළෙන අතර ඉතිරි මිලියන 246ම අඩු පෙනුම සහිත පුද්ගලයින් වේ.මින් 90%ක්ම 
ජීවත් වන්නේ ශ්‍රීලංකාව ඇතුලු සංවර්‍ධනය වෙමින් පවතින රටවල් වලය.
දෘශ්‍යාභාදිත පුද්ගලයින් බොහෝමයක්  කියවීමට අසාව ඇතෝ වූවත් අවාසනවකට මෙන් ඔවුනට 
කියවීමට ඇත්තේ බ්‍රේල් ක්‍රමයෙන්  ලියවුනු ප්‍රමාණාත්මකව ඉතාමත් අඩු පොත් ප්‍රමාණයකි . එය සංඛ්‍යාත්මකව ගවවිට 1%ටත් අඩුය.
ඔබ දායකත්වය සැප්යීමට සූදානම් වන ව්‍යාපෘතිය තුලින් දෘශ්‍යාබාදිත පුද්ගලයින්ගේ මෙමෙ කියවේමේ ගැටලුවට සාධාරණ විසදුමක් ලබාදෙයි.

මෙමෙ වෙබ් පිටුව මගින් කියවීමට කැමති එහෙත් දෘශ්‍යාබාද වලින් පෙලෙන පුද්ගලයින් හට
දායකත්වය දැක්වීමට දායකයින්ට හැකිය.දායකයින් සිදුකල යුත්තේ දෙනලද පොතක පරිච්චේදයක්
තම මයික්‍රපෝනය ට කියවා එම හඩපටය අපගේ වෙබ් අඩවියට ඇතුලත් කිරීම පමණි.
			</p>
			<p>
          <a class="btn btn-lg btn-primary" href="about.jsp" role="button">තව විස්තර බලන්න &raquo;</a>
        </p>
			
        </div>
        
         <h3>හදුන්වාදෙන දර්ශන පටය</h3>
        <div class="media">
        <video width="820" height="540" controls>
  <source src="resources/movie.mp4" type="video/mp4">
  
  	
</video>
</div>
        
       
        
      </div>
      </div>
      <div class="container">
        <center><p class="text-muted">මෙය deadlock හි නිර්මාණයකි</p></center>
      </div>
    </div> <!-- /container -->
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
  </body>
</body>
</html>