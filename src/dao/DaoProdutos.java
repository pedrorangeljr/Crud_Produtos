package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.SingleConnection;
import model.Fornecedor;

public class DaoProdutos {
	
	private Connection connection;
	
	public DaoProdutos() {
		
		connection = SingleConnection.getConnection();
	}

	
	/*Metodo salvar Produtos*/
	
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
}
