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
    <title>Save Travels Index</title>
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

	<h1>Edit Class</h1>
	
	<div class="container">
		<div class="row">
				<div class="col-lg-1"></div>
						<div class="col-lg-5 bg-light rounded p-4 mb-3 mt-3 mt-lg-4">
							<form:form action="/classes/${course.id}/edit/process" method="post" modelAttribute="course">
								<input type="hidden" name="_method" value="put">
								<form:input type="hidden" path="instructor" value="${instructorId}"/>
							    <div class="form-group">
							        <form:label path="name">Name</form:label>
							        <form:errors class="d-block alert-danger p-2" path="name"/>
							        <form:input class="form-control" path="name"/>
							    </div>
							    <div class="form-group">
							        <form:label path="dateTime">Date</form:label>
							        <form:errors class="d-block alert-danger p-2" path="dateTime"/>
							        <form:input type="datetime-local" class="form-control" path="dateTime"/>
							    </div>
							    <div class="form-group">
							        <form:label path="location">Location</form:label>
							        <form:errors class="d-block alert-danger p-2" path="location"/>
							        <form:input class="form-control" path="location"/>
							    </div>
							    <div class="form-group">
							        <form:label path="price">Drop-in Price</form:label>
							        <form:errors class="d-block alert-danger p-2" path="price"/>
							        <form:input class="form-control" type="number" path="price"/>
							    </div>
							    <div class="form-group">
							        <form:label path="description">Description</form:label>
							        <form:errors class="d-block alert-danger p-2" path="description"/>     
							        <form:input class="form-control" path="description"/>
							    </div>
							    <input class="btn btn-outline-success mt-3" type="submit" value="Submit"/>

							</form:form>
							<form action="/classes/delete/${course.id}" method="post">
								<input type="hidden" name="_method" value="delete">
								<input class="btn btn-outline-danger mt-3" type="submit" value="Delete"/>
							</form>
						</div>
				<div class="col-lg-5 mt-lg-4">
					<img class="img-fluid mb-4 rounded" src="/images/yoga_class.jpg" />
				</div>
				<div class="col-lg-1"></div>
			</div>
	</div>

</body>



</html>