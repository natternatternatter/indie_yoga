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

		
	<div class="text-center container">
		<h1 class="display-1">Indie Yoga</h1>
		<h5 class="fs-3 mb-4">An Online Space to Market and Schedule Independent Yoga Classes</h5>
		
		<div class="container text-center row align-items-center">
		
			<div class="text-center col-xl-8 col-lg-7 col-12 align-self-start">
			 	<img class="img-fluid mb-4 rounded" src="/images/yoga_class.jpg" />
			</div> 
				 
			<div class="text-center col-xl-4 col-lg-5 col-12">
			
				<div class="bg-light rounded p-2">
					<form:form action="/process/registration" method="POST" modelAttribute="newInstructor">
					
						<div class="form-floating mb-3">
							<form:input path="firstName" type="text" class="form-control" id="floatingInput" placeholder="First Name"/>
							<form:errors class="d-block alert-danger p-2" path="firstName"/>
							<form:label path="firstName" for="floatingInput">First Name</form:label>
						</div>
						<div class="form-floating mb-3">
							<form:input path="lastName" type="text" class="form-control" id="floatingInput" placeholder="Last Name"/>
							<form:errors class="d-block alert-danger p-2" path="lastName"/>
							<form:label path="lastName" for="floatingInput">Last Name</form:label>
						</div>					
						<div class="form-floating mb-3">
							<form:input path="email" type="email" class="form-control" id="floatingInput" placeholder="name@example.com"/>
							<form:errors class="d-block alert-danger p-2" path="email"/>
							<form:label path="email" for="floatingInput">Email address</form:label>
						</div>
						<div class="form-floating mb-3">
		  					<form:input path="password" type="password" class="form-control" id="floatingPassword" placeholder="Password"/>
		  					<form:errors class="d-block alert-danger p-2" path="password"/>
		  					<form:label path="password" for="floatingPassword">Password</form:label>
						</div>
						<div class="form-floating mb-3">
		  					<form:input path="confirm" type="password" class="form-control" id="floatingPassword" placeholder="Password"/>
		  					<form:errors class="d-block alert-danger p-2" path="confirm"/>
		  					<form:label path="confirm" for="floatingPassword">Confirm Password</form:label>
		  				</div>
						
						<div class="d-grid gap-2 mt-4 mb-4">
							<input class="btn btn-outline-dark" type="submit" value="Register"/>
						</div>
						
					</form:form>
					
				</div>
				
				<div class="text-center">
					<hr class="my-4">
					<p class="mt-4 text-muted">Already registered? Sign in <a href="/">here!</a></p>
				</div>
				
			</div>
			
		</div>
		
	</div>	
	
</body>

</html>