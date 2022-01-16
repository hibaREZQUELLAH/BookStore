<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="shortcut icon" href="./images/favicon.ico" type="image/x-icon">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/resources/style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<title>Inscription</title>
</head>
<body>
	<!-- register form  -->
<jsp:include page="../template/header.jsp"></jsp:include>
<div class="register-form-container">


    <form action="<%=application.getContextPath()%>/register" method="post">
    <h3>Inscription</h3>
    	<div class="field">
	        <div class="control">
		        <span>Prénom</span>
		        <input type="text" name="prenom" class="box" placeholder="" id="" required>
	        </div>
	        <div class="control">
		        <span>Nom</span>
		        <input type="text" name="nom" class="box" placeholder="" id="" required>
	        </div>
	    </div>
	    <div class="field">
	        <div class="control">
		       	<span>Email</span>
		        <input type="email" name="email" class="box" placeholder="" id="" required>
		    </div>
		    <div class="control">
		        <span>Téléphone</span>
		        <input type="tel" name="tel" class="box" placeholder="" id="" pattern="[0-9]{10}" required>
		    </div>
		</div>
	    <div class="field">
	        <div class="control">
		       	<span>Pays</span>
		        <input type="text" name="pays" class="box" placeholder="" id="" required>
		    </div>
		    <div class="control">
		        <span>Adresse</span>
		        <input type="text" name="adresse" class="box" placeholder="" id="" required>
		    </div>
		</div>
        <span>Mot de passe</span>
        <input type="password" name="password" class="box" placeholder="" id="" required>
       
        <input type="submit" value="Créer compte" class="btn">
        
        <p style="color:red;">${message }</p>
        
        <p>Déjà un compte ? <a href="<%=application.getContextPath()%>/login" >Connectez-vous</a></p>
    </form>

</div>
	
</body>
</html>