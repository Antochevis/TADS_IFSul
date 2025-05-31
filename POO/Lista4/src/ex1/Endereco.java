package ex1;

public class Endereco {
	
	private String rua;
    private int numero;
    private String cidade;
    private Aluno aluno;
    
	public Endereco() {
		super();
		this.rua = "";
		this.numero = 0;
		this.cidade = "";
	}

	public Endereco(String rua, int numero, String cidade) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public int getNumero() {
		return numero;
	}

	public String getCidade() {
		return cidade;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public void imprimirDados() {
	    System.out.println("Endereço:");
	    System.out.println("Rua: " + rua);
	    System.out.println("Número: " + numero);
	    System.out.println("Cidade: " + cidade);
	    if (aluno != null) {
	        System.out.println("Aluno associado: " + aluno.getNome());
	    }
	}	  
}
