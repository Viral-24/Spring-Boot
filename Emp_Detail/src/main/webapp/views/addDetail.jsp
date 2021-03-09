<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%--     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<link href="css/mystyle.css" rel="stylesheet">
<script src="js/myjavascript.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<style>
	
</style>

</head>
<body>
	<div class="container-fluid">
		<nav class="navbar navbar-expand-lg navbar-light bg-light" id="navbar">
				  <div class="container-fluid">
				    <a class="navbar-brand" href="#">DATABASE</a>
				    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				      <span class="navbar-toggler-icon"></span>
				    </button>
				    <div class="collapse navbar-collapse" id="navbarNav">
				      <ul class="navbar-nav">
				        <li class="nav-item">
				          <a class="nav-link active" aria-current="page" href="/">Home</a>
				        </li>
				        <li class="nav-item">
				          <a class="nav-link" href="addDetail">Add Detail</a	>
				        </li>
				      </ul>
				    </div>
				  </div>
		</nav>
	</div>
	<div class="container">
		<!--Header  -->
		
			
			<br><br>
			<h2 id="newtag" style="text-align: center;">Add New Detail</h2>
	<div class="card-body" style="width: 35rem; margin-left: 270px;">
		<form:form action="/addDetail" modelAttribute="details" method="post" enctype="multipart/form-data" >
			  <div class="form-group">
			    <label>User Name</label>
			    <input type="text" class="form-control" name="name" placeholder="Enter Name" required="required">
			  </div><br>
			  <div class="form-group">
			   <label>Phone NO</label>
			   	<input type="number" class="form-control" name="contact" placeholder="Enter Phone Number" required="required">
			  </div><br>
			  <div class="form-group">
			    <label>Job Post</label>
			    <input type="text" class="form-control" name="post" placeholder="Enter Job Post" required="required">
			  </div><br>
			  <div class="form-group">
			   <input type="file" name="fileimage" id="fileimage" accept="image/png, image/jpeg" required="required" >
			  </div><br>
			  <img id="thumbnail" alt="User Photo" style="width: 200px;height: 200px;"><br><br>
			  <button type="submit" class="btn btn-primary">Submit</button>
			</form:form>
	</div>
	<script type="text/javascript">
	
		
	</script>
	</div>
	</body>
</body>
</html>