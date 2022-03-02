<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quizz</title>
</head>
<body>
<p>
Niveau ${dif}
</p>
<c:forEach var="question" items="${questions }">
	<p> Question </p>
	<p><c:out value="${ question.enonce }"/></p>
	
	<c:forEach var="propo" items="${question.propos }"> 
		<input type = "radio" name="prop${ i}" id = "i${ propo}"value="${propo }"> 
		<label for="i${propo }"> "${propo}"</label>
	</c:forEach>
 </c:forEach>
</body>
</html>