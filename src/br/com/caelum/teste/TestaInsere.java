package br.com.caelum.teste;

import java.util.Calendar;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class TestaInsere {
	public static void main(String[] args) {
			
		Contato c1 = new Contato();
		
		c1.setNome("Guilherme");
		c1.setEmail("guilherme.neres.henrique@gmail.com");
		c1.setEndereco("Rua 7 quandra 5 casa 9");
		c1.setDataNascimento(Calendar.getInstance());
		
		
		ContatoDao daoContato = new ContatoDao();
		daoContato.adicionaContato(c1);
		
		System.out.println("O objeto foi gravado!");
		
		
	}
}
