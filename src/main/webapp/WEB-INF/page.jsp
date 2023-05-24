<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Page</title>
	<meta http-equiv="reload" content="3">
<style>
     <%@ include file="style3.css"%>
 </style>
</head>
<body>

<h1>Création de pages</h1>

<h2><c:out value="${titreLivre}"></c:out></h2>

<form method="post" action="PageServlet">
	<input type="hidden" name="action" value="ajouter">
	<button>Ajouter une page</button>
</form>
	<ul>
		<c:forEach var="page" items="${ pages }">
			<li>
				<form method="post" action="PageServlet">
				<input type="hidden" name="nomPage" value="${ page.nom }">
				<input type="hidden" name="action" value='editer'>
					<button value="${ page.nom }">
						<c:out value="${ page.nom }"/>
					</button>
				</form>
			</li>
		</c:forEach> 
	</ul>
	<form method="post" action="PageServlet">
	<label for="nomPage">Nom de la page :</label>
	<input type="text" name='nomPage' id="nomPage">
	<input type="hidden" name="action" value="supprimer">
		<input type="submit" value="supprimer">
	</form>
</body>
</html>