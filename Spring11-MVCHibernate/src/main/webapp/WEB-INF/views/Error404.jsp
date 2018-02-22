<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error 404 (por ejemplo)</title>
<meta name="description" content="Free Bootstrap Theme by BootstrapMade.com">
<meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">
<link href='https://fonts.googleapis.com/css?family=Lobster|Open+Sans:400,400italic,300italic,300|Raleway:300,400,600' rel='stylesheet' type='text/css'>
<spring:url value="static/css/font-awesome.min.css" var="font"/> 
<link href="${font}" rel="stylesheet" />

<spring:url value="static/css/bootstrap.min.css" var="bootstrap"/> 
<link href="${bootstrap}" rel="stylesheet" />

<spring:url value="static/css/animate.css" var="animate"/> 
<link href="${animate}" rel="stylesheet" />

<spring:url value="static/css/error.css" var="error"/> 
<link href="${error}" rel="stylesheet" />

</head>
<body>
<br><br><br><br>
<div class="logo text-center">
  <h2 class="subs-title text-center">Error 404</h2>
   <img src="static/img/peineta.jpg" alt="logo">
      <h2>¿Que carajo estabas buscando?</h2>
</div>
<br><br><br><br><br>
 <footer class="footer">
    <div class="container">
      <div class="subs-title text-center">

        <div class="copyright">
          © Copyright Grupo1 - Xorbagenda Company.
          <div class="credits">
            <!--
              All the links in the footer should remain intact. 
              You can delete the links only if you purchased the pro version.
              Licensing information: https://bootstrapmade.com/license/
              Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Maundy
            -->
            Bootstrap theme designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
          </div>
        </div>

      </div>
    </div>
  </footer>
</body>
</html>