<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="io.github.robson.model.ContatoEntities"%>
<%@ page import="io.github.robson.connection.ContatoDAO"%>
<%
	ContatoEntities contato = new ContatoEntities();
	contato.setIdcon(request.getParameter("Idcon"));
	ContatoDAO dao = new ContatoDAO();
	dao.select(contato);
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Editar</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css">
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
<body>
	<main style="margin: 1%">
		<h4>Editar usuário</h4>
		<div class="row">
			<div class="col col s12 m8 l6 z-depth-6 card-panel">
				<form class="login-form" name="frmContato" method="POST" action="home?page=Editar">
					<div class="input-field col s12">
						<i class="mdi-action-info prefix"></i> <input name="Idcon"
							value="<%out.print(contato.getIdcon());%>"
							type="text" autocomplete="off" readonly> <label
							for="nome" data-error="wrong" data-success="right"
							class="center-align">ID</label>
					</div>
					<div class="input-field col s12">
						<i class="mdi-action-assignment-ind prefix"></i> <input
							name="nome" value="<%out.print(contato.getNome());%>"
							type="text" autocomplete="off"> <label for="nome"
							data-error="wrong" data-success="right" class="center-align">Nome</label>
					</div>
					<div class="input-field col s12">
						<i class="mdi-communication-quick-contacts-dialer prefix"></i> <input
							name="fone"
							value="<%out.print(contato.getFone());%>"
							type="text" autocomplete="off"> <label for="telefone"
							data-error="wrong" data-success="right" class="center-align">Telefone</label>
					</div>
					<div class="input-field col s12">
						<i class="mdi-communication-quick-contacts-mail prefix"></i> <input
							name="email"
							value="<%out.print(contato.getEmail());%>"
							type="text" autocomplete="off"> <label for="email"
							data-error="wrong" data-success="right" class="center-align">Email</label>
					</div>
				</form>
				<div class="row">
					<div class="input-field col s12">
						<a href="javascript:validar()"
							class="btn waves-effect waves-light col s12">Atualizar</a>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6 m6 l6">
						<p class="margin medium-small">
							<a href="home?page=TelaIndex">Voltar</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</main>
	<script type="text/javascript" src="scripts/validarCadastro.js"></script>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js">	
	</script>
</body>
</html>