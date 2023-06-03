<%@ page import="java.sql.*" %>
<%Class.forName("org.postgresql.Driver"); %>
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
		<h1>Gerenciamentos de Produtos</h1>
		<h2>
			<a href="adicionarProdutos.jsp">Adicionar Protudos</a> &nbsp;&nbsp;&nbsp;

		</h2>
	</center>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>Lista de Produtos</h2>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<h2>Total em estoque: <%
				  
				Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/crud3?autoReconnect=true", "postgres", "admin");
				Statement statement = connection.createStatement();
				
				ResultSet resultset = statement.executeQuery("select sum(valor) from fornecedor") ;
				
				while(resultset.next()) {
					
					out.println(resultset.getFloat(1));
				}
				
				%></h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Produto</th>
				<th>Categoria</th>
				<th>Valor</th>
				<th>Ações</th>
			</tr>
			<c:forEach items="${fornecedores}" var="fornecedor">
				<tr>
					<td><c:out value="${fornecedor.id }"></c:out></td>
					<td><c:out value="${fornecedor.produto }"></c:out></td>
					<td><c:out value="${fornecedor.categoria }"></c:out></td>
					<td><c:out value="${fornecedor.valor }"></c:out></td>
					<td><a href="ServletProdutos?acao=editar&fornecedor=${fornecedor.id }" />Editar</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="ServletProdutos?acao=delete&fornecedor=${fornecedor.id }"
						onclick="return confirm('Tem certeza que deseja excluir ?')">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>

		<h3 style="text-align: center">${mensagem }</h3>
	</div>

</body>
</html>