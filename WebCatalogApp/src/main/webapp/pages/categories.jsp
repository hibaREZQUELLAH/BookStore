<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="shortcut icon" href="./images/favicon.ico" type="image/x-icon">
<!-- Box icons -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>
<!-- Custom StyleSheet -->
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/resources/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<title>Categories</title>
</head>
<body>

	<jsp:include page="../template/header.jsp"></jsp:include>
   <section class="dishes">
      <div class="row container">
        <div class="title">
          <h1>
            <br />
            Catégories
          </h1>
          <p>
            Sélectionnez une catégorie de produits
          </p>
        </div>

        <div class="products-container">
          <div class="filters">
          	<c:forEach var="cat" items="${categories}">
				<div data-filter="${cat.nom}" class="linkGet"  catid = "${cat.id }"><img src="./images/${cat.nom}.png" alt="" />${cat.nom}</div>
			</c:forEach>
          </div>
          <div class="products">
           <div class="box-container">

    </div>
           
          </div>
        </div>
      </div>
    </section>

<script type="text/javascript" language="javascript">
	      $(".linkGet").click(function(){
	    	  const target = document.querySelector(".linkGet");
	    	  target.classList.add("active");
	    	  var catid = $(this).attr("catid");
	    	  var row = document.getElementsByClassName("title")[0];
	    	  var box_container = document.getElementsByClassName("box-container")[0];
          	  var p = row.getElementsByTagName('p')[0];
          	  if(p != null) p.remove();
	    	  var cols = document.getElementsByClassName("box-product");
	    	    while(cols.length > 0){
	    	        cols[0].parentNode.removeChild(cols[0]);
	    	    }
	          
	          $.ajax({
	             url:'http://localhost:8080/WebCatalogApp/produits/'+catid,
	             type:'post',
	             cache:false,
	             success:function(data){
	            	 var response = $.parseJSON(data);         
	            	 for(i = 0; i< response.length ; i++){
	            		 var card = document.createElement("div");  card.className = "box-product";
		                 var cardtitle = document.createElement('h3'); 
		             	 var cardprice = document.createElement('p');
		             	 var createA = document.createElement("a");	 createA.className = "btn";	             	 
		             	 var createAText = document.createTextNode("Ajouter");
		             	 createA.setAttribute('href', "http://localhost:8080/WebCatalogApp/panier?action=buy&id="+response[i].id);
		             	 createA.appendChild(createAText);
		             	 var title = document.createTextNode(response[i].nom);
	            		 cardtitle.appendChild(title);
	            		 var price = document.createTextNode("$" +response[i].prix);
	            		 cardprice.appendChild(price);
	            		 card.appendChild(cardtitle);
	            		 card.appendChild(cardprice);
	            		 card.appendChild(createA);
	            		 box_container.appendChild(card);      		
		             }
		             return false;
	             },
	             error:function(){
	               alert('error');
	               return false;
	             }
	          });

	          return false;
	 	  });

      </script>
  <!--=============== Swiper JS ===============-->
    <script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
    <!--=============== Custom JS ===============-->
    <script src="${pageContext.request.contextPath}/resources/products.js"></script>

    </body>

</html>