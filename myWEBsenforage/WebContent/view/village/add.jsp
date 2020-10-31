<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page d'ajout</title>
<link rel="stylesheet" href="./public/css/bootstrap.min.css">
<link rel="stylesheet" href="./public/css/bj.css">
</head>
<body>
	
	<div class="container col-md-6 col-lg-6">
		<div class="panel panel-primary">
			<div class="panel-heading">FORMULAIRE D'AJOUT VILLAGE</div>
			<div class="panel-body">
				<form method="Post" action="Village">
				<div class="form-group">
						<label class="control-label">ID</label>
						<input class="form-control" type="text" name="id" id="id"/>
					</div>
					<div class="form-group">
						<label class="control-label">nom</label>
						<input class="form-control" type="text" name="nom" id="nom"/>
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