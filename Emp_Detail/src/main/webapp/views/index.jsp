<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
	<!--Header  -->		
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
				          <a class="nav-link" href="addDetail">Add Detail</a>
				        </li>
				      </ul>
				    </div>
				  </div>
		</nav>
	</div>
		<div class="container">
		<!-- List of Detail -->
			<div class="row">
				<c:forEach items="${details}" var="current">
			        <tr>
			        <div class="col-4">
				        <div class="card" style="width: 20rem; margin-top: 20px;">
							 <div class="card-body">
							    <h5 class="card-title" style="text-align: center;"> UserID:<td><c:out value="${current.id}" /><td></h5><hr>
							  <div class="userphoto" style="float: right; margin-top: -5px; ">
							   	<fieldset>
							    <legend style="font-size: 15px; ">User Photo</legend><hr>
					         	<img src="/imagedata/${current.userphoto }" style="width: 100px; height:100px;float: right; margin-top: -12px; " /><br>
					         	<a style="float: right; font-size: 10px;"href="changephoto${current.id}">Change Photo</a>
					         	</fieldset>
					         	</div> 
							   	<h6 style="clear: left; top:0">User Name: <td><c:out value="${current.name}" /><td></h6>
							   	<h6 style="clear: left; top:0">User Post: <td><c:out value="${current.post}" /><td></h6>
							   	
							    <a class="cartbutton" href="editbyid${current.id }"><button>Edit</button></a>
							    <a class="cartbutton"   onclick="askConfirm('${current.id }','${current.name}')"><button>Delete</button></a>
							   
						  	</div>
						 </div>
					</div>  
			        </tr>
			      </c:forEach>	
			 </div>
			 <script type="text/javascript">
			 function askConfirm(userId,userNm){
					var response=confirm("DO YOU WANT TO DELETE RECORD OF "+userNm+"!!!!");
						if(response){
								window.location="deletebyid"+userId;
									}
						}
			 </script>
			 <!-- <div class="row">
			 	<div class="col-4">
			 	</div>
			 </div> -->
		</div>
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
	</body>
</html>