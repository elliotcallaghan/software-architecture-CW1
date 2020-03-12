<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
</head>
<body>
<h2>Movie Management System</h2>
	<form:form modelAttribute="movie" action="/addMovie">
		<form:label path="id">ID:</form:label>
		<form:input path="id" type="number"/>
		<form:errors path="id"/><br>
		
		<form:label path="title">Title:</form:label>
		<form:input path="title"/>
		<form:errors path="title"/><br>
		
		<form:label path="city">City:</form:label>
		<form:input path="city"/>
		<form:errors path="city"/><br>
		
		<input type="submit"/>
	</form:form>
</body>
</html>