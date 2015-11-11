package br.com.caelum.testa;

import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) {
		ContatoDAO dao = new ContatoDAO();
		
		List<Contato> contatos = dao.getLista();
		
		for (Contato contato : contatos) {
			System.out.println("Id................: " + contato.getId());
			System.out.println("Nome..............: " + contato.getNome());
			System.out.println("E-mail............: " + contato.getEmail());
			System.out.println("Endereço..........: " + contato.getEndereco());
			System.out.println("Data de nascimento: " + contato.getDataNascimentoFormatada() + "\n");
		}
		
		 Contato contato = new Contato();
		 contato.setId((long) 1);
		 dao.remove(contato);
	}
}
