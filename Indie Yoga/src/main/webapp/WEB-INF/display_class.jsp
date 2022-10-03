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
	<div class="container">
		<div class="row">
				<div class="col-lg-1"></div>
				<div class="col-lg-5 bg-light rounded p-4 mb-3 mt-3 mt-lg-4">
					<div>
						<h1><c:out value="${course.name} with ${course.instructor.firstName} ${course.instructor.lastName}"/></h1>
					</div>
					<div>
						<h5>Date: <fmt:formatDate pattern = "EEE, MMM d 'at' h:mm a" value = "${course.dateTime}" /></h5>
						<h5>Location: <c:out value="${course.location}"/></h5>
						<h5>Cost: $<c:out value="${course.price}"/>.00</h5>
					</div>
					<div>
						<p><c:out value="${course.description}"/></p>
					</div>
					<div>
						<form action="/classes/join" method="POST">
							<p><c:out value="${error}"></c:out></p>
							<input type="hidden" name="courseId" value="${course.id}"/>
							<input type="hidden" name="price" value="${course.price}"/>
							<input class="btn btn-outline-success mb-3" type="submit" value="Join"/>
						</form>				
					</div>
<%-- 					<div>
						<form action="/classes/join" method="POST">
							<p><c:out value="${error}"></c:out></p>
							<input type="hidden" name="courseId" value="${course.id}"/>
							<input class="btn btn-outline-success mb-5" type="submit" value="Join Class">
						</form>
					</div> --%>
					<div>
						<h5>Attendees</h5>
		
						<table class="table table-hover d-flex">
							<tr>
								<th>Name</th>
							</tr>
							<c:forEach var="instructor" items="${instructors}">
								<tr>
									<td><c:out value="${instructor.firstName} ${instructor.lastName}"></c:out></td>
								</tr>
							</c:forEach>
						</table>
					</div>
							
							
				</div>
				<div class="col-lg-5 mt-lg-4">
					<img class="img-fluid mb-4 rounded" src="/images/yoga_class.jpg" />
				</div>
				<div class="col-lg-1"></div>
		</div>
	</div>




</body>

</html>