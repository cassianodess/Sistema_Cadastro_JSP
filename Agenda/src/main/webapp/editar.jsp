<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/phone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1 class="container1">Editar Contato</h1>
	
	<div class="container1">
	<form action="update" name="frmContato">
		<table>
			<tr>
				<td><input class="caixa3" type="text" name=idcon
					readonly="readonly"
					value="<%out.print(request.getAttribute("idcon"));%>"></td>
		</tr>
			<tr>
				<td><input value="<%out.print(request.getAttribute("nome"));%>"
					class="caixa1" type="text" name="nome"></td>
		</tr>
			<tr>
				<td><input value="<%out.print(request.getAttribute("fone"));%>"
					class="caixa2" maxlength="11" type="text" name="fone"></td>
		</tr>
			<tr>
				<td><input
					value="<%out.print(request.getAttribute("email"));%>"
					class="caixa1" type="email" name="email"></td>
		</tr>
	</table> <div style="text-align: center"><input onclick="validar()" class="botao1" type="button" value="Salvar">
	<a href="main" class="botao2" style="margin-left: 5px;">Cancelar</a>
	</div>
</form>
</div>
	<script src="scripts/validador.js">
		
	</script>
</body>
</html>