<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Éditeur de page</title>
  </head>
  <style>
    <%@ include file="style4.css"%>
  </style>
  <body>
    <h1>Éditeur de page</h1>
    
    <form method="post" action="PageServlet">
    
      <input type="hidden" name="action" value="modifier">
     
      <label for="nomPage">Nom de la page :</label>
      <input type="text" id="nomPage" name="nomPage" value="${page.nom}"><br><br>

      <label for="contenu">Contenu de la page :</label><br>
      <textarea id="contenu" name="contenu" rows="10" cols="50">${page.contenu}</textarea><br><br>
      
      <div>
        <c:forEach var="successeur" items="${successeurs}">
          <li><c:out value="${successeur.nom}" /></li>
        </c:forEach>
      </div>
      
      <label for="pages-successeurs">Pages successeurs :</label><br>
      <input type="text" id="pages-successeurs" name="pages-successeurs" value="${page.successeurs}"><br><br>

      <label for="imgFond">Image de fond :</label><br>
      <input type="file" id="imgFond" name="imgFond"><br><br>

      <input type="submit" value="Enregistrer">
    </form>
    
  </body>
</html>
