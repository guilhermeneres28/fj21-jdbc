package br.com.caelum.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;

public class TestaConexao {
	public static void main(String [] args) throws SQLException{
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Abrindo a conexão com o banco de dados");
		connection.close();
		System.out.println("Fechando a conexao com o banco");
		
	}
}
