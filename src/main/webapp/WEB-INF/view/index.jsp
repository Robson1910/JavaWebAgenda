<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="io.github.robson.model.ContatoEntities"%>
<%@ page import="io.github.robson.connection.ContatoDAO"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.Set"%>
<%
ContatoDAO dao = new ContatoDAO();
Set<ContatoEntities> contatos = new HashSet<>();
contatos = dao.List();
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="icon" href="imagens/favicon.png">
<meta name="viewport" content="width = device-width, initial-scale = 1">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
<style>
body {
	background: #74ebd5;
	background: -webkit-linear-gradient(to right, #74ebd5, #ACB6E5);
	background: linear-gradient(to right, #74ebd5, #ACB6E5);
	min-height: 100vh;
}
</style>
</head>
<body class="container">
	<br></br>
	<main style="background: #fff; padding: 2%; border: 1px solid #000;">
		<div class="row">
			<div class="col s12">
				<div class="col s6">
					<h4>Agenda</h4>
				</div>
				<div class="col s2">
					<a href="home?page=TelaCadastro"> <img src="img/save.png"
						alt="Adicionar">
					</a>
				</div>
				<div class="col s2">
					<a href="login.html"> <img src="img/exit.png" alt="exit">
					</a>
				</div>
			</div>
		</div>
		<table class="responsive-table centered striped bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Telefone</th>
					<th>Email</th>
					<th>Atualizar</th>
					<th>Apagar</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (ContatoEntities x : contatos) {
				%>
				<tr class="linhaTr">
					<td><%=x.getIdcon()%></td>
					<td><%=x.getNome()%></td>
					<td><%=x.getFone()%></td>
					<td><%=x.getEmail()%></td>
					<td><a href="home?page=TelaAtualizar&Idcon=<%=x.getIdcon()%>">
							<img src="img/update.png" alt="update">
					</a></td>
					<td><a href="javascript: confirmar(<%=x.getIdcon()%>)"> <img
							src="img/delete.png" alt="delete">
					</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</main>
	<script type="text/javascript" src="scripts/confirmarDelete.js"></script>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js">
		
	</script>
</body>
</html>