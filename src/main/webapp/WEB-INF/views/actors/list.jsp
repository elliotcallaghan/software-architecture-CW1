<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
</head>
<body>
<h2>Movie Management System</h2>
<c:forEach items="${actors}" var="actor">
	<p>Surname: ${actor.getSurname()}</p>
	<p>First Name: ${actor.getFirstName()}</p>
	<p>Language: ${actor.getLanguage()}</p><br>
</c:forEach>
<a href="/newActor?movie=${movie}">New Actor</a>
</body>
</html>