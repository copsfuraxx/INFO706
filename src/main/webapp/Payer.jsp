<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ValiderPaiement" type="post">
		<h1>Affichage ticket</h1>
		<p>numero : ${ticket.id}</p>
		<p>date entree : ${ticket.dateEntree}</p>
		<p>date de paiement : ${now}</p>
		<p>Prix : <fmt:formatNumber type="currency" currencySymbol="&euro;"
		   value="${price}"></fmt:formatNumber>
		</p>
		<p>
			<label>Recue</label>
			<input type="checkbox" name="recue">
		</p>
		<input name="id" type="hidden" value="${ticket.id}">
		<input name="price" type="hidden" value="${price}">
		<input name=now type="hidden" value="${now}">
		<input type="submit" value="Effectuer le paiement">
	</form>
</body>
</html>