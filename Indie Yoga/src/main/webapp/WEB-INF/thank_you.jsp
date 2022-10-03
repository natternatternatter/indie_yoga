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
		
		<div class="bg-light rounded p-2">
			<h3>Thank you for your payment! Click below to add the class and return to your schedule.</h3>
			
			<form action="/myClasses" method="GET">
<%-- 				<p><c:out value="${error}"></c:out></p>
				<input type="hidden" name="courseId" value="${course.id}"/> --%>
				<input class="btn btn-outline-dark mb-5" type="submit" value="Join and Return to My Schedule">
			</form>

		</div>
		
	</div>

</body>
</html>