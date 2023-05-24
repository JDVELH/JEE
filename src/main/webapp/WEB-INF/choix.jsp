<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Choix</title>
<style type="text/css">
	<%@ include file="styleChoix.css"%>
</style>
</head>
<body>
	<div class="btn">
	
		<form action="ChoixServlet" method="post">
  			<input type="hidden" name="action" value="creer">
 			<button type="submit">CREER</button>
		</form>
		
		<form action="Choix" method="post">
  			<input type="hidden" name="action" value="jouer">
 			<button type="submit">JOUER</button>
		</form>
	</div>
</body>
</html>