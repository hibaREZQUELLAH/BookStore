<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="webcatalog.eilco.models.Client" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% Client client = (Client)session.getAttribute("client"); %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <link rel="shortcut icon" href="./images/favicon.ico" type="image/x-icon">
  <!-- Box icons -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css" />
  <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"/>
      <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />

    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
  
  <!-- Custom StyleSheet -->
  <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/resources/style.css">
</head>
<body>
	<!-- Navigation -->
  <nav class="nav">
    <div class="wrapper container">
      <div class="logo"><a href="">
        <img src="<%=application.getContextPath()%>/images/logo.png" alt="">
      </a>
      </div>
      <ul class="nav-list">
        <div class="top">
          <label for="" class="btnn close-btn"><i class="fas fa-times"></i></label>
        </div>
        <li><a href="<%=application.getContextPath()%>">Accueil</a></li>
        <li><a href="<%=application.getContextPath()%>/categories">Catégories</a></li>
		<c:choose>
			<c:when test="${client != null}">
		        <li>
		          <a href="#" class="desktop-item">${client.nom } ${client.prenom} <span><i class="fas fa-chevron-down"></i></span></a>
		          <input type="checkbox" id="showdrop1" />
		          <label for="showdrop1" class="mobile-item">${client.nom } ${client.prenom} <span><i class="fas fa-chevron-down"></i></span></label>
		          <ul class="drop-menu1">
		            <li><a href="<%=application.getContextPath()%>/pages/compte.jsp">Compte</a></li>
		            <li><a href="<%=application.getContextPath()%>/logout">Se déconnecter</a></li>
		          </ul>
		        </li>
			</c:when>
			<c:otherwise>
				<li><a href="<%=application.getContextPath()%>/login" >Se connecter </a></li>
			</c:otherwise>
			</c:choose>
        <!-- icons -->
        <li class="icons">
          <a href="<%=application.getContextPath()%>/panier">
            <span>
            <img src="<%=application.getContextPath()%>/images/shoppingBag.svg" alt="" />
          </span>
          </a>
        </li>
      </ul>
      <label for="" class="btnn open-btn"><i class="fas fa-bars"></i></label>
    </div>
  </nav> 
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/script.js"></script>
</body>
</html>