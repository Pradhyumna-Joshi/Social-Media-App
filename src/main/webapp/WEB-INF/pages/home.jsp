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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<title>Social-Media-App</title>

<style>
.btn-like {
	background-color:; /* Blue background */
	border: none; /* Remove borders */
	color: white; /* White text */
	padding: 12px 16px; /* Some padding */
	font-size: 16px; /* Set a font size */
	cursor: pointer; /* Mouse pointer on hover */
}

/* Darker background on mouse-over */
.btn:hover {
	background-color: red;
}

.card {
	padding: 0.5em .5em .5em;
	border-radius: 2em;
	box-shadow: 0 5px 10px rgba(0, 0, 0, .2);
}

.list-group-item-action:hover {
	border-color: blue;
}
</style>
</head>
<body>


	<div class="container mt-5">
		<h1 class="text-center">Welcome to Social-Media</h1>
		<br>

		<c:if test="${not empty msg}">
			<div class="alert alert-success">
				<b><c:out value="${msg}"></c:out></b>
			</div>

		</c:if>

		<div class="row mt-5">

			<div class="col md-2" style="padding: .1em">
				<div class="list-group list-group-horizontal">
					<button type="button"
						class="list-group-item list-group-item-action active">
						Menu</button>
					<a href='<c:url value='/add'></c:url>'
						class="list-group-item list-group-item-action ">Post</a> <a
						href='<c:url value ='/home/sortDate'></c:url>'
						class="list-group-item list-group-item-action">View</a>

				</div>
			</div>

			<div class="col-md-12">
				<c:if test="${page=='home' }">
					<h2 class="text-center mt-5">All Posts</h2>
					<div class="dropdown show">
						<a class="btn btn-secondary dropdown-toggle" href="#"
							role="button" id="dropdownMenuLink" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"> Sort By </a>

						<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							<a class="dropdown-item" href="sortDate">Date(Default)</a> <a
								class="dropdown-item" href="sortPopularity">Popularity</a>
						</div>
					</div>
					<c:forEach items="${posts}" var="p" varStatus="loop">
						<br>
						<div class="card w-50 mx-auto m-2">
							<div class="card-body">
								<h3>
									<c:out value="${p.postTitle}"></c:out>
								</h3>
								<p>
									<c:out value="${p.postContent} "></c:out>
								</p>
								<p>
									<a href='<c:url value = "/likePost/${loop.index}"></c:url>'
										class="btn"> <i class="fa fa-heart"></i>
									</a></i>
									<c:out value="${p.likes} "></c:out>
								</p>

								<a href='<c:url value = "/deletePost/${loop.index}"></c:url>'
									class="btn btn-danger">Delete</a>
							</div>
						</div>
					</c:forEach>

				</c:if>

				<c:if test="${page=='add' }">
					<h2 class="text-center mt-5">Add Post</h2>
					<br>

					<div class="mx-auto text-center">
						<h4>What do you want to post?</h4>

						<div class="card w-25 mx-auto mt-3">
							<a href='<c:url value='add/text'></c:url>'
								class="btn btn-primary m-4 p-5">Text</a> <a
								href='<c:url value='add/image'></c:url>'
								class="btn btn-primary m-4 p-5">Image</a>
						</div>

					</div>


				</c:if>



				<c:if test="${ postType=='text'}">

					<h2 class="text-center mt-5">Add Post</h2>
					<br>
					<form:form action="home/saveText" method="post" modelAttribute="post">

						<div class="form-group">
							<h4>Title</h4>
							<form:input path="postTitle" cssClass="form-control"
								placeholder="Enter Title"></form:input>

						</div>

						<div class="form -group mt-4">
							<h4>Content</h4>
							<form:textarea path="postContent" cssClass="form-control"
								placeholder="What's on your mind?" cssStyle="height:250px;"></form:textarea>
						</div>


						<br>
						<div class="container text-center m-3">
							<button class="btn btn-outline-success ">Post</button>
						</div>
					</form:form>
				</c:if>


				<c:if test="${ postType=='image'}">

					<h2 class="text-center mt-5">Add Post</h2>
					<br>
					<form:form action="home/saveImage" method="post" modelAttribute="post">

						<div class="form-group">
							<h4>Title</h4>
							<form:input path="postTitle" cssClass="form-control"
								placeholder="Enter Title"></form:input>

						</div>

						<div class="form -group mt-4">
							<h4>Content</h4>
							<form:textarea path="postContent" cssClass="form-control"
								placeholder="What's on your mind?" cssStyle="height:250px;"></form:textarea>
						</div>

						<h4><label class="form-label" for="customFile">Insert Image Here</label></h4>
						<input type="file" path = "postImageURL" class="form-control" id="customFile" />


						<br>
						<div class="container text-center m-3">
							<button class="btn btn-outline-success ">Post</button>
						</div>
					</form:form>
				</c:if>
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