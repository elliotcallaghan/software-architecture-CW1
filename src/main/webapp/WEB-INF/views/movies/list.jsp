<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
</head>
<body>
<h2>Movie Management System</h2>
<c:forEach items="${movies}" var="movie">
	<p>Title: ${movie.getTitle()}</p>
	<p>City: ${movie.getCity()}</p>
	<a href="/actors?movie=${movie.getId()}">Actors</a>
</c:forEach>
</body>
</html>