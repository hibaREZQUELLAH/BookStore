<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="shortcut icon" href="./images/favicon.ico" type="image/x-icon">
	<link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/resources/style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<title>Login</title>
</head>
<body>
	<!-- login form  -->
<jsp:include page="../template/header.jsp"></jsp:include>

<div class="login-form-container">

    <form action="<%=application.getContextPath()%>/login" method="post">
        <h3>Connexion</h3>
        <span>Email</span>
        <input type="email" name="email" class="box" placeholder="" id="" required>
        <span>Mot de passe</span>
        <input type="password" name="password" class="box" placeholder="" id="" required>

        <p style="color:red;">${message}</p>
          <div class="col-lg-12">
	          <button class="btn btn-primary" type="submit">Se connecter</button>
	      </div>
        <p>Vous n'avez pas de compte ? <a href="<%=application.getContextPath()%>/register">Créer un compte</a></p>
    </form>
</div>
  
</body>
</html>