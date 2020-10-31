<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"/>
<title>LISTE DE LIEUX</title>
<link rel="stylesheet" href="public/css/bootstrap.min.css">
<link rel="stylesheet" href="public/css/bj.css">
</head>

<body>
<div class=" nav navbar navbar-default">
        <ul class="nav navbar-nav">
        <c:if test="${user_roles==1 }">
        	<li><a href="Welcom">Accueil</a></li>
            <li><a href="Client">Gestion des clients</a></li>
            <li><a href="Village">Gestion des villages </a></li>
        </c:if>
       <c:if test="${admin_roles==2 }">
	      <li><a href="User">Gestion des users</a></li>
	      <li><a href="Roles">Gestion des roles</a></li>
	      <li><a href="ParamUser">Administration des users</a></li>
	      <li><a href="Logout" style="color:red;font-size=22px;">Deconnexion</a></li>
       </c:if>
<li>
      <a href="#" style="color:green;font-size=22px;">
            Bienvenue
      </a>
</li>      
</ul>
</div>

</body>
</html>