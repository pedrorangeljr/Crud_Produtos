package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexao.SingleConnection;

public class DaoLogin {

	private Connection connection;
	
	public DaoLogin() {
		
		connection = SingleConnection.getConnection();
	}
	
	/*Metodo Verifica Login*/
	
	public boolean validarLogin(String login, String senha) throws Exception {
		
		String sql = "select * from fornecedor where login = '"+login+"' and senha = '"+senha+"'";
		PreparedStatement select = connection.prepareStatement(sql);
		ResultSet resultSet = select.executeQuery();
		
		if(resultSet.next()) {
			
			return true;
		}
		else {
			
			return false;
		}
	}
}
