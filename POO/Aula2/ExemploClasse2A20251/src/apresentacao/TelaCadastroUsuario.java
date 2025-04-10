package apresentacao;
import model.Usuario;

public class TelaCadastroUsuario {

	public static void main(String[] args) {

		// declaramos uma variavel u do tipo Usuario
		Usuario u;

		// instanciar o objeto
		// charmar o construtor da classe
		// alocar memoria RAM pro objeto
		u = new Usuario();
		
//		u.nome = "Rodrigo";
		u.setNome("Rodrigo Remor Oliveira");
//		u.email = "remor@gmail.com";
		u.setEmail("remor@gmail.com");
		
//		u.senha = "321";
		u.setSenha("321");
		
		
		
		System.out.println(u.getNome()+" , "+u.getEmail()+" , "+u.getSenha());
		
		
		
		
		
		// declarando e instanciando um objeto u2 do tipo Usuario
		Usuario u2 = new Usuario("Renan", "renan@gmail.com", "54321");
		
		u.imprimeAtributos();
		u2.imprimeAtributos();
		
		
		
		

	}

}
