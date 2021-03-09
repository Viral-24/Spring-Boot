<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h3>Upload Multiple Files</h3>
		<form:form id="uploadfiles" name="uploadfiles" action="/uploadfiles" method="post" encType="multipart/form-data">
			  <input type="file" name="files"  accept="pdf" multiple required />
      		 <button type="submit">Submit</button>
		</form:form>
	</div>
	
	<div>
		<h3>List of Documents</h3>
		<table>
			<thead>
			
			</thead>
			<tbody>
				<tr>
					<c:forEach items="${data }" var="data">
						<td> <c:out value="${data.id }"></c:out></td>
						<td> <c:out value="${data.filename }"></c:out></td>
						<td> <a href="/download/${data.id}">Download</a></td>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>