package ex2;

public class Funcionario {
	
	private String nome;
    private String cargo;
    private double salario;
    private Empresa empresa;
    
    
	public Funcionario() {
		super();
		this.nome = "";
		this.cargo = "";
		this.salario = 0.0;
		this.empresa = new Empresa();
	}


	public Funcionario(String nome, String cargo, double salario, Empresa empresa) {
		super();
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
		this.empresa = empresa;
	}


	public String getNome() {
		return nome;
	}


	public String getCargo() {
		return cargo;
	}


	public double getSalario() {
		return salario;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public void imprimirDados() {
        System.out.println("Funcionário:");
        System.out.println("  Nome: " + nome);
        System.out.println("  Cargo: " + cargo);
        System.out.println("  Salário: R$ " + salario);
        if (empresa != null) {
            System.out.println("  Empresa: " + empresa.getNome());
        }
    }
}
