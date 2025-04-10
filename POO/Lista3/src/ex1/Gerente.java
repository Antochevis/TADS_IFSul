package ex1;

public class Gerente extends Funcionario {
	
	protected double bonusPercentual;

	public Gerente() {
		super();
		this.bonusPercentual = 0.2;
		// TODO Auto-generated constructor stub
	}

	public Gerente(String nome, double salarioBase, String cargo, String departamento) {
		super(nome, salarioBase, cargo, departamento);
		this.bonusPercentual = 0.2;
		// TODO Auto-generated constructor stub
	}
	
	public double getBonusPercentual() {
		return bonusPercentual;
	}

	public void setBonusPercentual(double bonusPercentual) {
		this.bonusPercentual = bonusPercentual;
	}

	@Override
    public double calcularSalario() {
        return getSalarioBase() * (1 + bonusPercentual);
    }
	
	@Override
    public void exibirInformacoes() {
        super.exibirInformacoes(); 
        System.out.println("Bônus Percentual: " + (bonusPercentual * 100) + "%");
        System.out.println("Salário com Bônus: R$ " + calcularSalario());
    }

}
