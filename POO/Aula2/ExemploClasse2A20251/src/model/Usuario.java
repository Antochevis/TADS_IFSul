package model;

public class Usuario {
	// Encapsulamento - é um conceito que orienta que os atributos da classe
	// sejam o mais restritos possível, de preferencia visiveis apenas dentro da
	// classe

	// Modificadores de acesso
	// default: quando nao possui nenhum modificador
	// dá visibilidade apenas dentro do mesmo pacote

	// public: dá visibilidade em todo o projeto
	// private: dá visibilidade apenas dentro da própria classe
	// protected: dá visibilidade dentro do mesmo pacote e também em subclasses

	// atributos (caracteristicas)
	private String nome;
	private String email;
	private String senha;

	// construtores (servem para inicializar os atributos da classe)
	// o mesmo nome da classe
	public Usuario() {
		this.nome = "";
		this.email = "";
		this.senha = "123";
	}

	public Usuario(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	// metodos (ações)
	public void imprimeAtributos() {
		System.out.println("nome: " + nome);
		System.out.println("email: " + email);
		System.out.println("senha: " + senha);
	}

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
