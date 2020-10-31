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
<li><a href="#">Accueil</a></li>
<li><a href="Lieu">Gestion des lieux</a></li>
<li><a href="Formation">Gestion desFormatiom </a></li>
<li><a href="PramFormation">Prametrage de Formatiom </a></li>

<li><a href="User">Gestion des users</a></li>
<li><a href="Roles">Gestion des roles</a></li>
<li><a href="ParamUser">Administration des roles</a></li>
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