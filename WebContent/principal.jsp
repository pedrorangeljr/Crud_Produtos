<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<br />

	<center>
		<h1>Gerenciamentos de Contatos</h1>
		<h2>
			<a href="adicionarProdutos.jsp">Adicionar Protudos</a> &nbsp;&nbsp;&nbsp;

		</h2>
	</center>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>Lista de Produtos</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Produto</th>
				<th>Categoria</th>
				<th>Data</th>
				<th>Valor</th>
				<th>Ações</th>
			</tr>
			<c:forEach items="${contatos}" var="contato">
				<tr>
					<td><c:out value=""></c:out></td>
					<td><c:out value=""></c:out></td>
					<td><c:out value=""></c:out></td>
					<td><c:out value=""></c:out></td>
					<td><a href="ServletsContatos?acao=editar&contato=" />Editar</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="ServletsContatos?acao=delete&contato="
						onclick="return confirm('Tem certeza que deseja excluir ?')">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>

		<h3 style="text-align: center">${mensagem }</h3>
	</div>

</body>
</html>