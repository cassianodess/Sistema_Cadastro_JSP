<%@page import="model.Contato"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- Recebe a listas de contatos --%>
<%
@SuppressWarnings("unchecked")
ArrayList<Contato> lista = (ArrayList<Contato>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos</title>
<link rel="icon" href="imagens/phone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1 class="container1">Agenda de Contatos</h1>
	<div class="container1"><a class="botao1" href="novo.html">Novo
			Contato</a></div>
	<div class="container1">
		<table class="tabela">
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>Email</th>
				<th>Opções</th>
		</tr>
			<thead>
		</thead>
			<tbody>
				<%
				for (int i = 0; i < lista.size(); i++) {
				%>
				<tr>
					<td><%=lista.get(i).getIdcon()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getFone()%></td>
					<td><%=lista.get(i).getEmail()%></td>
					<%-- '?' -> indicada que passará um argumento --%>
					<td><a href="select?idcon=<%=lista.get(i).getIdcon()%>"
						class="botao1">Editar</a> <%--links com jsf referem-se aos arquivos locais, no caso o arquivo javascript chamando a função confirmar --%>
						<a href="javascript: confirmar(<%=lista.get(i).getIdcon()%>)"
						class="botao2">Excluir</a></td>
			</tr>
				<%
				}
				%>
		</tbody>
			<script src="scripts/confirmador.js"></script>
	</table>
</div>
</body>
</html>