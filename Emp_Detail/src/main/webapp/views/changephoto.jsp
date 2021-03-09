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
		<h1>Change User Photo</h1>
		<form:form action="changephoto" method="post" modelAttribute="details"  enctype="multipart/form-data">
			 <label>User ID </label>
			    <input type="text"  name="id" value="${details.getId()}" required="required"/>
			  </div><br>
			  <div class="form-group">
			    <label>User Name</label>
			    <input type="text"  name="name" value="${details.getName() }" required="required"/>
			  </div><br>
			<div>
				<fieldset>
					<legend>Old User Photo</legend>
					<img src="/imagedata/${details.getUserphoto() }" alt="User Old Photo " width="300px" height="300px">
				</fieldset>
			</div>
			
			<div>
				<fieldset>
					<legend>New User Photo</legend>
					<div class="form-group">
				   		<input type="file" name="fileimage" id="fileimage" accept="image/png, image/jpeg" required="required" >
				  	</div><br>
				  	<img id="thumbnail" alt="User Photo" style="width: 300px;height: 300px;"><br><br>
				</fieldset>
			</div>
			
			<button type="submit">Submit</button>
		</form:form>
	</div>
</body>
</html>