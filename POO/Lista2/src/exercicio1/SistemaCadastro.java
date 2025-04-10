package exercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaCadastro {
	
	 public static void main(String[] args) {
		 
		 Scanner teclado = new Scanner(System.in);
	     ArrayList<Usuario> usuarios = new ArrayList<>();
	     
	     int opcao;
	     
	     do {
	    	 System.out.println("Escolha uma opção: ");
	    	 System.out.println("Opção 1: Cadastro de novo usuário");
	    	 System.out.println("Opção 2: Realizar Login");
	    	 System.out.println("Opção 3: Sair");
	    	 
	    	 opcao = teclado.nextInt();
	    	 teclado.nextLine();
	    	 
	    	 switch (opcao) {
	    	 case 1:
	    		 System.out.println("Insira um nome de usuário: ");
                 String nome = teclado.nextLine();
                 System.out.println("Insira um e-mail de usuário: ");
                 String email = teclado.nextLine();
                 System.out.println("Insira a senha de usuário: ");
                 String senha = teclado.nextLine();
                 
                 Usuario usuario = new Usuario(nome, email, senha);
                 usuarios.add(usuario);
                 System.out.println("Usuário cadastrado!");
                 break;
                 
	    	 case 2:
	    		 System.out.println("Digite seu e-mail: ");
                 String emailLogin = teclado.nextLine();
	    		 System.out.println("Digite sua senha: ");
	    		 String senhaLogin = teclado.nextLine();
	    		 
	    		 boolean usuarioCadastrado = false;
                 for (Usuario loginUsuario : usuarios) {
                     if (loginUsuario.getEmail().equals(emailLogin) && loginUsuario.getSenha().equals(senhaLogin)) {

                         usuarioCadastrado = true;
                         
                         int opcaoUsuarioLogado;
       
            	    	 do {
            	    		 
            	    		 System.out.println("Escolha uma opção: ");
                             System.out.println("Opção 1: Editar dados da conta");
                	    	 System.out.println("Opção 2: Visualizar dados da conta");
                	    	 System.out.println("Opção 3: Sair");
                	    	 
                	    	 opcaoUsuarioLogado = teclado.nextInt();
                	    	 teclado.nextLine();
                	    	 
                	    	 switch (opcaoUsuarioLogado) {
                	    	 case 1:
                	    		 System.out.println("Digite o novo nome: ");
                                 String novoNome = teclado.nextLine();
                                 loginUsuario.setNome(novoNome);
                                 
                                 System.out.println("Digite o novo email: ");
                                 String novoEmail = teclado.nextLine();
                                 loginUsuario.setEmail(novoEmail);
                                 
                                 System.out.println("Digite a nova senha: ");
                                 String novaSenha = teclado.nextLine();
                                 loginUsuario.setSenha(novaSenha);
                                 
                                 System.out.println("Usuário atualizado com sucesso!");
                                 
                                 break;
                	    	 
                	    	 case 2:
                	    		 System.out.println("Nome: " + loginUsuario.getNome());
                	    		 System.out.println("E-mail: " + loginUsuario.getEmail());
                	    		 System.out.println("Senha: " + loginUsuario.getSenha());
                	    		 
                	    		 break;
                	    		 
                	    	 case 3:
                	    		 System.out.println("Tchau!");
                	    		 break;
                	    		 
                	    	 default:
                	        	 System.out.println("Opção inválida. Tente novamente.");
                	    		 
                	    	 }
                	    	 
            	    	 } while (opcaoUsuarioLogado != 3);
            	    	 
            	    	 
                        // break;
                     }
                 }

                 if (!usuarioCadastrado) {
                     System.out.println("E-mail ou senha incorretos. Tente novamente.");
                 }
                 
                 break;
	    		 
	    	 case 3: 
	    		 System.out.println("Tchau!");
	    		 break;
                 
	         default:
	        	 System.out.println("Opção inválida. Tente novamente.");
	    	 }	 
	    	 
	     } while (opcao != 3);
	     
	     teclado.close();
		 
	 }
	
}
