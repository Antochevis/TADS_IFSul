package ex1;

public class Aluno {
	
	private String nome;
    private int idade;
    private String matricula;
    private Endereco endereco;
    
	public Aluno() {
		super();
		this.nome = "";
		this.idade = 0;
		this.matricula = "";
		this.endereco = new Endereco();
	}

	public Aluno(String nome, int idade, String matricula, Endereco endereco) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.matricula = matricula;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public String getMatricula() {
		return matricula;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public void imprimirDados() {
	    System.out.println("Aluno:");
	    System.out.println("Nome: " + nome);
	    System.out.println("Idade: " + idade);
	    System.out.println("Matrícula: " + matricula);
	    if (endereco != null) {
	        System.out.println("Endereço:");
	        endereco.imprimirDados();
	    }
	}



}
