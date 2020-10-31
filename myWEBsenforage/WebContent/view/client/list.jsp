<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LISTE DES CLIENTS</title>
</head>
<link rel="stylesheet" href="./public/css/bootstrap.min.css">
<link rel="stylesheet" href="./public/css/bj.css">
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
	</ul>
</div>


<div class="container col-md-6 col-lg-6">
		<div class="panel panel-primary">
			<div class="panel-heading"> Liste des  clients</div>
			<div class="panel-body">
				<table class="table table-bordered table-striped">
					<tr>
						<th>Nom </th>
						<th>Prenom </th>
						<th>Adresse </th>
						<th>Tel</th>
						
						<th>Village </th>
						<th>User</th>
						<th>Action</th>
						<th>Action</th>
						
						
					</tr>
					
					
					
					<c:if test="${list_client!= null}">
					<c:forEach items="${list_client}" var="client">
						<tr>
							<td>${client.nom}</td>
							<td>${client.prenom}</td>
							<td>${client.adresse}</td>
							<td>${client.tel}</td>
							
							<td>${client.village.nom}</td>
							<td>${client.user.nom}</td>
						<td><a href="Client?action=edit&idEdit=${client.id}" class="btn btn-success">Edit</a></td>
							<td><a href="Client?action=delete&id=${client.id}" onclick="if(!confirm('voulez-vous supprimer?')) return false;" class="btn btn-danger">Supprimer</a></td>
							
						</tr>
					</c:forEach>
					</c:if>
				</table>
				<a href="Client?page=add" class="btn btn-primary">Ajout de client</a>
			</div>
		</div>
	</div>
	
	
	<div class="container col-md-6 col-lg-6">
		<div class="panel panel-primary">
			<div class="panel-heading">FORMULAIRE D'AJOUT</div>
			<div class="panel-body">
			<c:if test="${message!=null}">
			<div class="alert alert-success">${message}</div>
			</c:if>
				<form method="Post" action="Client">
				
					<div class="form-group">
						<label class="control-label">Nom</label>
						<input class="form-control" type="text" name="nom" id="nom"/>
					</div>
					
					<div class="form-group">
						<label class="control-label">Prenom</label>
						<input class="form-control" type="text" name="prenom" id="prenom"/>
					</div>
					
					<div class="form-group">
						<label class="control-label">Adresse</label>
						<input class="form-control" type="text" name="adresse" id="prenom"/>
					</div>
					
					<div class="form-group">
						<label class="control-label">Tel</label>
						<input class="form-control" type="text" name="tel" id="tel"/>
					</div>
					
					<div class="form-group">
						<select name="village_id" class="form-control" >
						   <option value="0">---Votre village---</option>
						   <c:if test="${list_village != null}">
								<c:forEach items="${list_village}" var="village">
									<option value="${village.id}">${village.nom}</option>

                               </c:forEach>
						  </c:if>
                    	</select>
						
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