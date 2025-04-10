package ex1;

public class Funcionario {
	
	protected String nome;
	protected double salarioBase;
	protected String cargo;
	protected String departamento;
	
	public Funcionario() {
		super();
		this.nome = "";
		this.salarioBase = 0.0;
		this.cargo = "";
		this.departamento = "";
	}
	
	public Funcionario(String nome, double salarioBase, String cargo, String departamento) {
		super();
		this.nome = nome;
		this.salarioBase = salarioBase;
		this.cargo = cargo;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public String getCargo() {
		return cargo;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double calcularSalario() {
		return salarioBase;
	}

	public void exibirInformacoes() {
		System.out.println("Nome do funcionário: " + nome);
		System.out.println("Salário do funcionário: " + salarioBase);
		System.out.println("Cargo do funcionário: " + cargo);
		System.out.println("Departamento do funcionário: " + departamento);
	}
	
	public void exibirInformacoes(String adicional) {
		exibirInformacoes();
		System.out.println("Informações adicionais: " + adicional);
	}
	
	

}
