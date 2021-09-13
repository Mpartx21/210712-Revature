<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="navbar.jsp"/>
    <jsp:include page="all_css_js.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<h1>Please fill you note details</h1>
	
	<form action="/AddNoteServlet" method="post">
		<div class="form-group">
			<label>Note title</label>
			<input type="text" name="title" id= "title" class="form-control" placeholder="Enter Note title" required>
		</div>
		<div class="form-group">
			<label>Note Content</label>
			<input type="text" name="Content" id= "Content" class="form-control" placeholder="Enter Note Content" required>
		</div>
		<input type="submit" class="btn btn-dark" >
	</form>
	
	</div>


</body>
</html>