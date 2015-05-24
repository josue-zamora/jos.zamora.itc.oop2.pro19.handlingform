<%-- 
    Document   : studentAdd
    Created on : 22/05/2015, 10:25:59 AM
    Author     : jos1727
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Student Change</title>               
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">      
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script type="text/javascript">
            function formReset(frm) {
                for(var i = 0; i < frm.elements.length; i++)
                    if( !(frm.elements[i].type && frm.elements[i].type == "submit") &&
                        !(frm.elements[i].type && frm.elements[i].type == "reset"))
                        
                    frm.elements[i].value = "";
            }
        </script>
    </head>
    <body>
        
        <nav class="navbar navbar-default">
            
            <div class="container-fluid">
                
                <!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
		  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		  </button>
		  <a class="navbar-brand active" href="../index">Home</a>
		</div> 
                
                <!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		  <ul class="nav navbar-nav">
			<li><a href="<c:url value="/admin/initializeDataBase"/>">Administrator <span class="sr-only">(current)</span></a></li>			
			<li class="dropdown">
			  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Courses <span class="caret"></span></a>
			  <ul class="dropdown-menu" role="menu">
                              <li><a href="<c:url value="/course/courseAdd" />">Add</a></li>
                              <li><a href="<c:url value="/course/courseDelete" />">Remove</a></li>
                              <li><a href="<c:url value="/course/courseChange" />">Change</a></li>
                                <li><a href="<c:url value="/course/course" />">Display</a></li>				
			  </ul>
			</li>
			<li class="dropdown">
			  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Students <span class="caret"></span></a>
			  <ul class="dropdown-menu" role="menu">
				<li><a href="<c:url value="/student/studentAdd" />">Add</a></li>
                                <li><a href="<c:url value="/student/studentDelete"/>">Remove</a></li>
                                <li><a href="<c:url value="/student/studentChange" />">Change</a></li>
				<li><a href="<c:url value="/student/student"/>">Display</a></li>				
			  </ul>
			</li>
		  </ul>
		  
		</div><!-- /.navbar-collapse -->
                
            </div><!-- /.container-fluid -->
            
        </nav>    
                          
        <form action="find" method="POST" class="form-inline">
	  
	  <div class="form-group">
	    <label for="studentId">Student Id</label>
	    <input type="text" class="form-control" id="studentId" name="studentId" value="${studentId}" required />
	  </div>	  
	  	  	  
	  <input class="btn btn-primary" type="submit" value="Find" />	 

	</form>
          
        <br /> <br />
                          
        <form action="change" method="POST" onReset="formReset(this);return false;">
	  
	  <div class="form-group">
	    <label for="firstName">First Name</label>
	    <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name" value="${student.firstName}" required />
	  </div>
	  <div class="form-group">
	    <label for="lastName">Last Name</label>
	    <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name" value="${student.lastName}" required />
	  </div>
	  <div class="form-group">
	    <label for="phoneHome">Phone Home</label>
	    <input type="text" class="form-control" id="phoneHome" name="phoneHome" placeholder="Phone Home" value="${student.phoneHome}" required />
	  </div>
	  <div class="form-group">
	    <label for="phoneMobile">Phone Mobile</label>
	    <input type="text" class="form-control" id="phoneMobile" name="phoneMobile" placeholder="Phone Mobile" value="${student.phoneMobile}" required />
	  </div>
          
          <input type="hidden" name="studentId" value="${student.studentId}" />
	  	  
	  <input class="btn btn-primary" type="submit" value="Change" />
	  <input class="btn btn-warning" type="reset" value="Reset" />

	</form>
        
        <script src="<c:url value="/resources/jquery/1.11.2/jquery.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    </body>
</html>
