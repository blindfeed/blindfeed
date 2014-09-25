<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<html>
<head>

	  <link href='<c:url value="/css/navbar-fixed-top.css"></c:url>' rel="stylesheet">
	  <link href='<c:url value="/css/bootstrap.css"></c:url>' rel="stylesheet">
	  <script src='<c:url value="/js/jquery.min.js"></c:url>'> </script>
	  <script src='<c:url value="/js/jRecorder.js"></c:url>'> </script>
  
		<title>පටිගත කිරීම</title>  

		<style>
		li {display:inline; margin-right:10px;}
		</style>

<script>
function myFunction() {
    alert("Thank You for your contribution");
}
</script>

</head>
<body> 
	<%HttpSession ses=request.getSession(false); %>
   <script>

    $.jRecorder({ 
        host : 'http://localhost:8080/blindfeed-jee/record?filename=hello' ,  //replace with your server path please
        callback_started_recording:     function(){callback_started(); },
        callback_stopped_recording:     function(){callback_stopped(); },
        callback_activityLevel:         function(level){callback_activityLevel(level); },
        callback_activityTime:        function(time){   callback_activityTime(time); },
        callback_finished_sending: function(){ callback_finished_sending();},
        swf_path : '<c:url value="/js/AudioRecorderCS4-1.0.swf"></c:url>'
     }
   );
    
   </script>
	<div  style="position: relative; top: -70px;">
		<div class="navbar navbar-default">
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
            <li><a href="Nuserindex">Home</a></li>
            <li class="active"><a href="#">Contribution</a></li>
            <li><a href="Nuserabout">Detail</a></li>
            <li><a href="Nusercontact">aboutUs</a></li>
            <li><a href="Nuserhelp">Help</a></li>
          </ul>
          <% String user=(String)request.getAttribute("user"); %>
          <form class="navbar-form navbar-right">
             <a id="user" class="btn btn-success" href="#">you logged as <%=user %></a>
             <a id="logout" class="btn btn-success" href="${pageContext.request.contextPath}/logoutProcess">Logout</a>
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
        <h1>දායකත්වය</h1>
        
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Read the Paragraph</h3>
                    </div>
                    <div class="panel-body">
                        <p style="font-size: 15px;">
									<%String name = (String) ses.getAttribute("text");%>
									<%=name %>
								</p>
                        
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Recorder</h3>
                    </div>
                    <div class="panel-body">
                    
                    <div class="well-sm" style="background-color: #eeeeee;border:1px solid #cccccc">
		 Timme: <span id="time">00:00</span>  
		</div>
		
		
		<div >
		  Level: <span class="well-sm" id="level"></span>
		</div>  
	
		<div id="levelbase" style="width:200px;height:20px;background-color:#ffff00">
		  <div id="levelbar" style="height:19px; width:2px;background-color:red"></div>  
		</div>
	
		<div>
		  status: <span id="status"></span>
		</div> 
	
                        <h4 class="text-info">Record Player</h4>
                        <button class="glyphicon glyphicon-play" id="record">Start </button>
                        <button class="glyphicon glyphicon-stop" id="stop">Stop</button>
                        <button class="glyphicon glyphicon-folder-open" id="send">Send  </button>

                    </div>
                </div>
            </div>
        </div>
        
      </div>
      <div class="container">
        <p class="text-muted">මෙය  deadlock හි නිර්මාණයකි</p>
      </div>
    </div> <!-- /container -->
    
		</div>

	
		
		<script type="text/javascript">
                  $('#record').click(function(){
                      $.jRecorder.record(150);
                      //alert('this is record');
                  });
               
                  $('#stop').click(function(){     
                     $.jRecorder.stop();
                	  //alert('this is stop');
                  });
               
                   $('#send').click(function(){
                     $.jRecorder.sendData();
                	   //alert('this is send to server function');
                  });
                  
                  function callback_finished()
                  {
                      $('#status').html('finished recording');                  
                  }
                  
                  function callback_started()
                  {      
                      $('#status').html('start recording');                   
                  }

                  function callback_error(code)
                  {
                      $('#status').html('Error, code:' + code);
                  }
                                    
                  function callback_stopped()
                  {
                      $('#status').html('stop the recoding');
                  }

                  function callback_finished_recording()
                  {                    
                      $('#status').html('finished recording');                                       
                  }
                  
                  function callback_finished_sending()
                  {                   
                      $('#status').html('save file');                                           
                  }
                  
                  function callback_activityLevel(level)
                  {                    
                    $('#level').html(level);
                    
                    if(level == -1)
                    {
                      $('#levelbar').css("width",  "2px");
                    }
                    else
                    {
                      $('#levelbar').css("width", (level * 2)+ "px");
                    }                                       
                  }
                  
                  function callback_activityTime(time)
                  { 
                   //$('.flrecorder').css("width", "1px"); 
                   //$('.flrecorder').css("height", "1px"); 
                    $('#time').html(time);         
                  }
        </script>
</body>
</html>


 
		
		
    