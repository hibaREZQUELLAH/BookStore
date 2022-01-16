<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="shortcut icon" href="./images/favicon.ico" type="image/x-icon">
	<!-- Custom StyleSheet -->
	<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/resources/style.css">
	<title>Panier</title>

</head>
<body>
	<jsp:include page="../template/header.jsp"></jsp:include>
	<div class="container cart">
      <table>
        <tr>
          <th>Produit</th>
          <th>Quantité</th>
          <th>Montant</th>
          <th>Actions</th>
        </tr>
        <c:set var="total" value="0"></c:set>
			
		<c:forEach var="item" items="${sessionScope.cart }">
				<c:set var="total" value="${total + item.produit.prix * item.quantite }"></c:set>
				<tr>
					<td>
						<div class="cart-info">
							<div>
								<p>${item.produit.nom }</p>
							</div>
						</div>
					</td>
					<td>${item.quantite }</td>
					<td>$${item.produit.prix }</td>
					<td>
						<a href="${pageContext.request.contextPath }/panier?action=remove&id=${item.produit.id }"
									onclick="return confirm('Etes vous sure de supprimer le produit?')">Supprimer
					    </a>
					</td>
					
				</tr>
			</c:forEach> 
      </table>
		<c:if test="${sessionScope.cart.size() > 0 }">
      		<div class="total-price">
		        <table>
		          <tr>
		            <td>Total</td>
		            <td>$${total }</td>
		          </tr>
		        </table>
	        	<div>
		        	<a href="${pageContext.request.contextPath }/categories" class="checkout btn">Continuer mes achats</a>
		        	<a href="${pageContext.request.contextPath }/commande" class="checkout btn">Valider ma commande</a>
	        	</div>
      		</div>
      	</c:if>
      	<c:if test="${sessionScope.cart.size() == 0 }">
      		<div class="text-center" style="margin-top: 50px;">
		        <p>Votre panier est vide</p>
      		</div>
      	</c:if>
    </div>
  </body>
</html>