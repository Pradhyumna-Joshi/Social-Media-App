<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>


<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
.card{
    padding: 1.5em .5em .5em;
    border-radius: 2em;
    text-align: center;
    box-shadow: 0 5px 10px rgba(0,0,0,.2);
}
</style>
<title>Social-Media-App</title>
</head>
<body>

	<c:if test="${not empty msg}">
		<div class="alert alert-success">
			<b><c:out value="${msg}"></c:out></b>
		</div>

	</c:if>

	<div class="col d-flex justify-content-center"">

		<div class="card mt-5">
			<div class="card-body">
				<h3 class="text-center md-5">Sign Up</h3>
				<form:form action="save" method="post" modelAttribute="user">
					<div class="form-group mt-5">
						<form:input path="username" cssClass="form-control"
							placeholder="Enter username"></form:input>
					</div>

					<div class="form-group">
						<form:input path="email" cssClass="form-control"
							placeholder="Enter Email"></form:input>
					</div>

					<div class="form-group">
						<form:input path="password" cssClass="form-control"
							placeholder="Enter Password"></form:input>
					</div>

					<div class="container text-center">
						<button class="btn btn-outline-success">Sign Up</button>
					</div>

					<br>

					<div class="container">
						<a href="<c:url value="login"></c:url>">Already have an
							account?Login</a>
					</div>

				</form:form>

			</div>
		</div>

	</div>











	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>