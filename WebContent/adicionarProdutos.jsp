<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Produtos</title>
</head>
<body>

	<center>
		<h1>Gerenciamento de Produtos</h1>
		<h2>
			&nbsp;&nbsp;&nbsp; <a href="principal.jsp">Lista de Produtos</a>

		</h2>
	</center>

	<div align="center">

		<form action="ServletProdutos" method="post">

			<table border="1" cellpadding="5">
				<caption>
					<h2>Cadastrar Produtos</h2>
				</caption>

				<tr>
					<th>ID:</th>
					<td><input type="text" id="id" name="id" placeholder="ID"
						readonly="readonly" value=""></td>
				</tr>

				<tr>
					<th>Produto:</th>
					<td><input type="text" id="produto" name="produto" size="45"
						value="" /></td>
				</tr>
				<tr>
					<th>Categoria:</th>
					<td><input type="text" id="categoria" name="categoria"
						size="45" value="" /></td>
				</tr>
				<tr>
					<th>Valor:</th>
					<td><input type="text" onKeyUp="mascaraMoeda(this, event)"
						id="valor" name="valor" size="45" value="" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Cadastrar" /></td>
				</tr>

			</table>

		</form>
	</div>

	<script type="text/javascript">
	
	// Mascara pega em uma pesquisa na internet.
	
		String.prototype.reverse = function() {
			return this.split('').reverse().join('');
		};

		function mascaraMoeda(campo, evento) {
			var tecla = (!evento) ? window.event.keyCode : evento.which;
			var valor = campo.value.replace(/[^\d]+/gi, '').reverse();
			var resultado = "";
			var mascara = "##.###.###.##".reverse();
			for (var x = 0, y = 0; x < mascara.length && y < valor.length;) {
				if (mascara.charAt(x) != '#') {
					resultado += mascara.charAt(x);
					x++;
				} else {
					resultado += valor.charAt(y);
					y++;
					x++;
				}
			}
			campo.value = resultado.reverse();
		}
	</script>
</body>
</html>