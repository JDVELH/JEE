<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livre</title>
</head>
<style>
     <%@ include file="style2.css"%>
</style>
<body>
<h1>Création de livres</h1>
	<form method="post" action="Livre">
	<input type="hidden" name="action" value="ajouter">
	<p>
		<label for="titreLivre">Titre : </label>
		<input type="text" name="titreLivre" id="titreLivre" required="required"/>
	</p>
	<p><input type="submit" name="submit" value="Créer livre"/></p>
	</form>
	<ul>
		<c:forEach var="livre" items="${ livres }">
			<li>
				<form method="get" action="PageServlet">
				<input type="hidden" name="titreLivre" value="${ livre.titreLivre }">
				<input type="submit" name="titreLivre" value="${ livre.titreLivre }">				
				</form>
			</li>
		</c:forEach>
</ul>			
<form method="post" action="Livre">
	<input type="hidden" name="action" value="supprimer">
	<input type="text" name="titreLivre" id="titreLivre" required="required"/>
	<input type="submit" name="action" value="supprimer">
</form>	
</body>
</html>