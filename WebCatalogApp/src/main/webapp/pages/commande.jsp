<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="shortcut icon" href="./images/favicon.ico" type="image/x-icon">
	<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/resources/style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<title>Commande</title>
</head>
<body>
<jsp:include page="../template/header.jsp"></jsp:include>
<div class='container order'>
<c:set var="total" value="0"></c:set>
  <div class='window'>
    <div class='order-info'>
      <div class='order-info-content'>
        <h2>Commande N° # ${commande.numero }</h2>
        <div class='line'></div>
        <c:forEach var="ligne" items="${sessionScope.commande.lignesCommande }">
        	<c:set var="total" value="${total + ligne.prix_unitaire * ligne.quantite }"></c:set>
	        <table class='order-table'>
	          <tbody>
	            <tr>
	              <td><span class='thin'>Produit : ${ligne.designation}</span>
	                <br><span class='thin small'>Quantité: ${ligne.quantite}</span>
	              </td>
	            </tr>
	            <tr>
	              <td>
	                <div class='price'>$ ${ligne.prix_unitaire }</div>
	              </td>
	            </tr>
	          </tbody>
	        </table>
	       </c:forEach>
        <div class='line'></div>
        <div class='total'>
          <span style='float:left;'>
            TOTAL A PAYER
          </span>
          <span style='float:right; text-align:right;'>
            $${total }
          </span>
        </div>
</div>
</div>
        <div class='credit-info'>
          <div class='credit-info-content'>
            <table class='half-input-table'>
              <tr><td>Please select your card: </td><td><div class='dropdown' id='card-dropdown'><div class='dropdown-btn' id='current-card'>Visa</div>
                <div class='dropdown-select'>
                <ul>
                  <li>Master Card</li>
                  <li>American Express</li>
                  </ul></div>
                </div>
               </td></tr>
            </table>
            <img src='https://dl.dropboxusercontent.com/s/ubamyu6mzov5c80/visa_logo%20%281%29.png' height='80' class='credit-card-image' id='credit-card-image'></img>
            Card Number
            <input class='input-field' required="required"></input>
            Card Holder
            <input class='input-field' required="required"></input>
            <table class='half-input-table'>
              <tr>
                <td> Expires
                  <input class='input-field' required="required"></input>
                </td>
                <td>CVC
                  <input class='input-field' required="required"></input>
                </td>
              </tr>
            </table>
            <button class='pay-btn'>Payer</button>

          </div>

        </div>
      </div>
</div>
<script src="${pageContext.request.contextPath}/resources/payment.js"></script>

<script type="text/javascript" language="javascript">
	$("button").click(function(e){
		e.preventDefault();
	    $.ajax({
	       url:'http://localhost:8080/WebCatalogApp/payement',
	       type:'post',
	       cache:false,
	       success:function(result){
	    	   window.location.href = "http://localhost:8080/WebCatalogApp/";
	    	   alert("payement effectué avec succès");
	           return false;
	       },
	       error:function(result){
	         alert('error');
	         return false;
	       }
       });
	       
      return false;
   });

</script>
</body>
</html>