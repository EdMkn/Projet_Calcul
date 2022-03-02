<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jeu de calcul mental</title>
</head>
<body>
	<form method="POST" action="test">
		<label for="dif"> Veuillez sélectionner la difficulté </label> 
		<select name= "dif" id="dif">
			<option>Facile</option>
			<option>Moyen</option>
			<option>difficile</option>
		</select> 
		<label for="nbquest"> Nombre de questions: </label> 
		<select name= "nbquest" id="nbquest">
			<option>5</option>
			<option>10</option>
			<option>20</option>
		</select> <input type=submit value="Envoyer">
	</form>

</body>
</html>