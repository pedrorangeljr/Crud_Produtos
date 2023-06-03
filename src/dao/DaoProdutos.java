package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.SingleConnection;
import model.Fornecedor;

public class DaoProdutos {

	private Connection connection;

	public DaoProdutos() {

		connection = SingleConnection.getConnection();
	}

	/* Metodo salvar Produtos */

	public void salvarProdutos(Fornecedor fornecedor) {

		try {

			String sql = "insert into fornecedor(produto,categoria,valor)values(?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);

			insert.setString(1, fornecedor.getProduto());
			insert.setString(2, fornecedor.getCategoria());
			insert.setFloat(3, fornecedor.getValor());

			insert.execute();

			connection.commit();

		} catch (Exception e) {

			try {

				connection.rollback();

			} catch (SQLException e1) {

				e1.printStackTrace();
			}

			e.printStackTrace();
		}
	}

	/* Metodo listar todos na home */

	public List<Fornecedor> listar() throws Exception {

		List<Fornecedor> listar = new ArrayList<Fornecedor>();

		String sql = "select * from fornecedor";
		PreparedStatement select = connection.prepareStatement(sql);
		ResultSet resultado = select.executeQuery();

		while (resultado.next()) {

			Fornecedor fornecedor = new Fornecedor();

			fornecedor.setId(resultado.getLong("id"));
			fornecedor.setProduto(resultado.getString("produto"));
			fornecedor.setCategoria(resultado.getString("categoria"));
			fornecedor.setValor(resultado.getFloat("valor"));

			listar.add(fornecedor);
		}

		return listar;
	}

	/* Metodo deletar */

	public void deletar(String id) {

		try {

			String sql = "delete from fornecedor where id = '" + id + "'";
			PreparedStatement delete = connection.prepareStatement(sql);
			delete.execute();

			connection.commit();

		} catch (Exception e) {

			try {

				connection.rollback();

			} catch (SQLException e1) {

				e1.printStackTrace();
			}

			e.printStackTrace();
		}
	}
}
