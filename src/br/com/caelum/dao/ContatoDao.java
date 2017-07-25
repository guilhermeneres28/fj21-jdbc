package br.com.caelum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.modelo.Contato;

public class ContatoDao {
	
	// variavel que recebe a conexão
	 private Connection connection;
	 
	 // criando a conexão dentro do DAO, toda vez que o DAO for instanciado a conexao é criada
	 public ContatoDao(){
		 this.connection = new ConnectionFactory().getConnection();
	 }
	 
	 // metodo que adiciona contato
	 public void adicionaContato(Contato contato){
		 String sql = "insert into contatos " + 
				 "(nome,email,endereco,dataNascimento) " + 
				 "values(?,?,?,?)";
		 try{
			
			 PreparedStatement stmt = connection.prepareStatement(sql);
			
			 stmt.setString(1, contato.getNome());
			 stmt.setString(2, contato.getEmail());
			 stmt.setString(3, contato.getEndereco());
			 
			 
			 stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			 
			 
			 stmt.execute();
			 stmt.close();
			 
		 } catch(SQLException e) {
			 throw new RuntimeException(e);
		 }

	 }
	 	 
}
