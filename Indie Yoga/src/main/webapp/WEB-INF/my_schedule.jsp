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
		        	<a class="nav-link active" aria-current="page" href="/myClasses">My Schedule</a>
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
	
	<h4>Your Upcoming Classes</h4>
	
	<table class="table table-hover d-flex">
		<tr>
			<th>Class Name</th>
			<th></th>
			<th>Instructor</th>
			<th></th>
			<th>When</th>
			<th>Where</th>
			<th>Price</th>
			<th></th>
		</tr>
		<c:forEach var="course" items="${courses}">
		<tr>
			<td><c:out value="${course.name}"></c:out></td>
			<td>
				<form action="/classes/${course.id}" method="GET">
					<input class="btn btn-outline-secondary" type="submit" value="View Class">
				</form>
			</td>
			<td><c:out value="${course.instructor.firstName} ${course.instructor.lastName}"></c:out></td>
			<td>
				<c:if test = "${firstName == course.instructor.firstName}">
					<form action="/classes/${course.id}/edit" method="GET">
						<input class="btn btn-outline-warning" type="submit" value="Edit"/>
					</form>
				</c:if>
			</td>
			<td><fmt:formatDate pattern = "EEE, MMM d 'at' h:mm a" value = "${course.dateTime}"/></td>
			<td><c:out value="${course.location}"></c:out></td>
			<td>$<c:out value="${course.price}"></c:out>.00</td>

		</tr>
		</c:forEach>
	</table>
	
</body>

</html>
	