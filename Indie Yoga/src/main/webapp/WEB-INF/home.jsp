<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Yoga Schedule Classes</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>



<body>

	<h1 class="display-1">Namaste, <c:out value="${firstName}"></c:out>!</h1>
	
	<nav class="navbar navbar-dark navbar-expand-sm bg-dark">
	  	<div class="container-fluid">
	    	<span class="navbar-brand mb-0 h1">Indie Yoga</span>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
		      	<span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		      	<div class="navbar-nav align-items-center">
		        	<a class="nav-link" aria-current="page" href="/myClasses">My Schedule</a>
		        	<a class="nav-link" href="/classes">Browse Classes</a>
		        	<a class="nav-link" href="#">History</a>
			     	<form class="d-flex" action="/classes/new" method="GET">
						<input class="btn btn-outline-light me-4" type="submit" value="+ New Class">
					</form>
					<form class="d-flex" action="/process/logout" method="GET">
						<input class="btn btn-outline-danger" type="submit" value="Logout">
					</form>
		     	</div>


		    </div>
	  	</div>

	</nav>
	
</body>
</html>
	
