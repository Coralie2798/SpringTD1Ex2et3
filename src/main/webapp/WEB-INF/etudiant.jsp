<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Etudiant</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</head>
<body>
<table class="table">
		<thead class="table">
			<tr>
				<th scope="col">#</th>
				<th scope="col">Nom</th>
				<th scope="col">Prenom</th>
				<th scope="col">telephone</th>
				<th scope="col">mail</th>
			</tr>
		</thead>
		<tbody>
			
				<tr>
					<th scope="row">${ e.getId() }</th>
					<td>${e.getNom()}</td>
					<td>${e.getPrenom()}</td>
					<td>${e.getTel()}</td>
					<td>${e.getMail()}</td>
				</tr>
			
		</tbody>
	</table>
</body>
</html>