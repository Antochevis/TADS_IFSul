package exercicio1;

public class Usuario {
	
	private String nome;
	private String email;
	private String senha;

	public Usuario() {
		this.nome = "";
		this.email = "";
		this.senha = "";
	}

	public Usuario(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

//	public void imprimeAtributos() {
//		System.out.println("Nome: " + nome);
//		System.out.println("E-mail: " + email);
//		System.out.println("Senha: " + senha);
//	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

}
