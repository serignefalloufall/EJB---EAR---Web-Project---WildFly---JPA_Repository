<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LISTE DE FORMATION</title>
</head>
<link rel="stylesheet" href="./public/css/bootstrap.min.css">
<link rel="stylesheet" href="./public/css/bj.css">
<body>

<div class=" nav navbar navbar-default">
        <ul class="nav navbar-nav">
<li><a href="Welcom">Accueil</a></li>
<li><a href="User">Gestion des user</a></li>
<li><a href="Village">Gestion des villages </a></li>
<li><a href=Client>Gestion des clients</a></li>

<li><a href="Logout" style="color:red;font-size=22px;">Deconnexion</a></li>
<li>
      <a href="#" style="color:green;font-size=22px;">
            Bienvenue
      </a>
</li>      
</ul>
</div>
<div class="container col-md-6 col-lg-6">
		<div class="panel panel-primary">
			<div class="panel-heading"> Liste des  User</div>
			<div class="panel-body">
				<table class="table table-bordered table-striped">
					<tr>
						<th>Email </th>
						<th>Nom</th>
						<th>Passeword</th>
						<th>Prenom</th>
						<th>Action</th>
						<th>Action</th>
						
						
					</tr>
					
					
					
					<c:if test="${list_user!= null}">
					<c:forEach items="${list_user}" var="user">
						<tr>
						   <td>${user.email}</td>
							<td>${user.nom}</td>
							<td>${user.password}</td>
							<td>${user.prenom}</td>
							<td><a href="User?action=edit&idEdit=${user.id}" class="btn btn-success">Edit</a></td>
							<td><a href="User?action=delete&id=${user.id}" onclick="if(!confirm('voulez-vous supprimer?')) return false;" class="btn btn-danger">Supprimer</a></td>
							
						
							
						</tr>
					</c:forEach>
					</c:if>
				</table>
				<a href="user?page=add" class="btn btn-primary">Ajout user</a>
			</div>
		</div>
	</div>
	
	
	
	<div class="container col-md-6 col-lg-6">
		<div class="panel panel-primary">
			<div class="panel-heading"> formulaire de gestion des uSER</div>
			<div class="panel-body">
				<form method="Post" action="User">
					<div class="form-group">
						<label class="control-label">Email </label>
						<input class="form-control" type="text" name="email" id="email"/>
					</div>
					<div class="form-group">
						<label class="control-label">Nom </label>
						<input class="form-control" type="text" name="nom" id="nom"/>
					</div>
					<div class="form-group">
						<label class="control-label">password </label>
						<input class="form-control" type="text" name="password" id="password"/>
					</div>
					<div class="form-group">
						<label class="control-label">Prenom </label>
						<input class="form-control" type="text" name="prenom" id="prenom"/>
					</div>
					
					
					<div class="form-group">
						<input class="btn btn-success" type="submit" name="valider" value="Envoyer"/>
						<input class="btn btn-danger" type="reset" name="annuler" value="Annuler"/>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>