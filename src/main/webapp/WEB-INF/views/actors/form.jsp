<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
</head>
<body>
<h2>Movie Management System</h2>
	<form:form modelAttribute="actor" action="/addActor?movie=${movie}">
		<form:label path="surname">Surname:</form:label>
		<form:input path="surname"/>
		<form:errors path="surname"/><br>
		
		<form:label path="firstName">First Name:</form:label>
		<form:input path="firstName"/>
		<form:errors path="firstName"/><br>
		
		<form:label path="language">Language:</form:label>
		<form:input path="language"/>
		<form:errors path="language"/><br>
		
		<form:label path="age">Age:</form:label>
		<form:input path="age" type="number"/>
		<form:errors path="age"/><br>
		
		<input type="submit"/>
	</form:form>
</body>
</html>