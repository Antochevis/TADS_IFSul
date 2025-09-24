package ex1;

public class Funcionario {
	private String nome;
    private String cargo;
    
	public Funcionario(String nome, String cargo) {
		super();
		this.nome = nome;
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
    
	@Override
	public String toString() {
	    return  nome + ", " + cargo;
	}

  
}
