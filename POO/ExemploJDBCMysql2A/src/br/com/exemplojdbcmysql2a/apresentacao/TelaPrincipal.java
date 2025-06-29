package br.com.exemplojdbcmysql2a.apresentacao;

import java.util.List;
import java.util.Scanner;

import br.com.exemplojdbcmysql2a.model.Usuario;
import br.com.exemplojdbcmysql2a.persistencia.UsuarioDAO;

public class TelaPrincipal {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("1) Cadastrar Usuario");
		int opcao = teclado.nextInt();
		switch (opcao) {
		case 1: 
			TelaUsuario tela = new TelaUsuario();
			tela.cadastrar();
			
			break;
		case 2:
			
			break;
		}
		
		
		// TESTE SALVAR
//		Usuario u = new Usuario();
//		u.setNome("Rodrigo");
//		u.setEmail("remor@gmail.com");
//		u.setSenha("123");
//		
//		UsuarioDAO uDAO = new UsuarioDAO();
//		uDAO.salvar(u);

		// TESTE DO EDITAR
//		Usuario u = new Usuario();
//		u.setNome("Rodrigo Remor");
//		u.setEmail("rodrigo.remor@gmail.com");
//		u.setSenha("321");
//		u.setId(2);
//
//		UsuarioDAO uDAO = new UsuarioDAO();
//		uDAO.editar(u);
		
		// TESTE DO EXCLUIR
//		UsuarioDAO uDAO = new UsuarioDAO();
//		uDAO.excluir(2);
		
		// TESTE DO BUSCAR POR ID
//		UsuarioDAO uDAO = new UsuarioDAO();
//		Usuario u = uDAO.buscarPorId(3);
//		System.out.println(u.toString());

		// TESTE DO BUSCAR TODOS
		UsuarioDAO uDAO = new UsuarioDAO();
		List<Usuario> listaUsuarios = uDAO.buscarTodos();
//		System.out.println(listaUsuarios.size());
		
		for(Usuario u:listaUsuarios) {
			System.out.println(u.toString());
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
