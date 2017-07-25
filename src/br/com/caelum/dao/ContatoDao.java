package br.com.caelum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
	 
	 
	 public List<Contato> getLista(){
		 String sql = "select * from contatos";
		 
		 try {
			
			 List <Contato> contatos = new ArrayList<>();
			 
			 PreparedStatement stmt = this.connection.prepareStatement(sql);
			 
			 ResultSet rs = stmt.executeQuery();
			 
			 while(rs.next()){
				 
				 Contato c1 = new Contato();
				 c1.setId(rs.getLong("id"));
				 c1.setNome(rs.getString("nome"));
				 c1.setEmail(rs.getString("email"));
				 c1.setEndereco(rs.getString("endereco"));
				 
				 Calendar data =  Calendar.getInstance();
				 data.setTime(rs.getDate("dataNascimento"));
				 c1.setDataNascimento(data);
				 
				 contatos.add(c1);
				 
			 }
			 
			 rs.close();
			 stmt.close();
			 return contatos;
			 
		 } catch(SQLException e ){
			 throw new RuntimeException(e);
		 }
	 }
 	 	 
}
