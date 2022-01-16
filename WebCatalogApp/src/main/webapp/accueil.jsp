<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <link rel="shortcut icon" href="./images/favicon.ico" type="image/x-icon">
  <!-- Box icons -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css" />
  <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
  <!-- Custom StyleSheet -->
  <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/resources/style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <title>Book Store</title>
</head>
<body>
<!-- Home -->
	<jsp:include page="template/header.jsp"></jsp:include>
	<div class="hero">
    	<div class="row">
    		<div class="content">
    			<h1><span>JUSQU'À -70%</span>
	            <br/>
	            Avantageuse
	            <br/>
	            année 2022 !
	            </h1>	              
	            <a href="<%=application.getContextPath()%>/categories">En profiter</a>
	        </div>
	      <div class="swiper books-slider">
	      	<div class="swiper-wrapper">
	      		<a href="#" class="swiper-slide"><img src="images/book-1.png" alt=""></a>
		        <a href="#" class="swiper-slide"><img src="images/book-2.png" alt=""></a>
		        <a href="#" class="swiper-slide"><img src="images/book-3.png" alt=""></a>
		        <a href="#" class="swiper-slide"><img src="images/book-4.png" alt=""></a>
		        <a href="#" class="swiper-slide"><img src="images/book-5.png" alt=""></a>
		        <a href="#" class="swiper-slide"><img src="images/book-6.png" alt=""></a>
		    </div>
		    <img src="images/stand.png" class="stand" alt="">
		  </div>
    </div>
  	</div>
   <script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
  <!-- Custom Script -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/swiper.js"></script>
  
 


</body>
</html>