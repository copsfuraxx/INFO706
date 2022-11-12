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
<%@ page import="java.util.ArrayList" %>
<% ArrayList<String> list = (ArrayList<String>) request.getAttribute("payementTypes"); %>

	<form action="ValiderPaiement" method="post">
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
		<input name="n_ticket" type="hidden" value="${ticket.id}">
		<input name="price" type="hidden" value="${price}">
		<input name=now type="hidden" value="${now}">
		<select name="typePayement">
			<% for(int i = 0; i < list.size(); i++) { 
				String item = list.get(i);
			%>
			<option value="<%= item %>"><%= item %></option>
			<% } %>
		</select>
		<input type="submit" value="Effectuer le paiement">
	</form>
</body>
</html>