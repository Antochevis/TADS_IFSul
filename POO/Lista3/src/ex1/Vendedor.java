package ex1;

public class Vendedor extends Funcionario {
	
	protected double vendasMensais;
	protected double comissaoPercentual;
	
	
	public Vendedor() {
		super();
		this.vendasMensais = 0.00;
		this.comissaoPercentual = 0.05;
		// TODO Auto-generated constructor stub
	}
	public Vendedor(String nome, double salarioBase, String cargo, String departamento, double vendasMensais) {
		super(nome, salarioBase, cargo, departamento);
		this.vendasMensais = vendasMensais;
		this.comissaoPercentual = 0.05;
		// TODO Auto-generated constructor stub
	}
	
	public double getVendasMensais() {
		return vendasMensais;
	}
	public double getComissaoPercentual() {
		return comissaoPercentual;
	}
	public void setVendasMensais(double vendasMensais) {
		this.vendasMensais = vendasMensais;
	}
	public void setComissaoPercentual(double comissaoPercentual) {
		this.comissaoPercentual = comissaoPercentual;
	}
	
	@Override
    public double calcularSalario() {
        double comissao = vendasMensais * comissaoPercentual;
        return getSalarioBase() + comissao;
    }
	
	@Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Vendas Mensais: R$ " + vendasMensais);
        System.out.println("Comissão (5%): R$ " + (vendasMensais * comissaoPercentual));
        System.out.println("Salário com Comissão: R$ " + calcularSalario());
    }
	
	public void exibirInformacoes(String detalhes) {
        exibirInformacoes();
        System.out.println("Detalhes Adicionais: " + detalhes);
    }
	
	
}
