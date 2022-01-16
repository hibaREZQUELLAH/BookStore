<%@page import="webcatalog.eilco.models.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

  <% Client client = (Client)session.getAttribute("client"); %>
 
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="shortcut icon" href="./images/favicon.ico" type="image/x-icon">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/resources/style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<title>Compte</title>
</head>
<body>
<jsp:include page="../template/header.jsp"></jsp:include>

<div class="container compte">
<div class="text-center font-weight-bold mb-3">Mes informations personnelles</div>
<div class="card">
	 <div class="card-body">
	  	<div class="d-flex flex-row">
		  	<div class="col-md-3 mb-4">
		        <div class="font-weight-bold">Nom : </div>
		        <div class="font-weight-bold">Prénom : </div>
		        <div class="font-weight-bold">Email : </div>
		        <div class="font-weight-bold">Adresse : </div>
		        <div class="font-weight-bold">Téléphone : </div>
		    </div>
		    <div class="col-md-4 mb-4">
		        <div>${client.nom}</div>
		        <div>${client.prenom}</div>
		        <div>${client.email}</div>
		        <div>${client.adresse }</div>
		        <div>${client.telephone }</div>
		    </div>
	    </div>
	 </div>
</div>
</div>
</body>
</html>