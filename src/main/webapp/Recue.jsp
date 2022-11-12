<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ticket</title>
</head>
<body>
	<h1>Affichage recue</h1>
	<p>numero : ${ticket.id }</p>
	<p>date entree : ${ticket.dateEntree }</p>
	<p>date dernier paiement : ${ticket.payements.get(ticket.payements.size()-1).date}</p>
	<p>total payé : ${ticket.getTotalMontant()}</p>
</body>
</html>