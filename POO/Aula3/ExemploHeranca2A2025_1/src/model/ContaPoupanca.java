package model;

public class ContaPoupanca extends ContaBancaria {

	private String dataAniversario;
	private double taxaRendimento;

	public ContaPoupanca() {
		super();
		dataAniversario = "";
		taxaRendimento = 0.0035;
	}

	public ContaPoupanca(String numero, double saldo, String dataAbertura, String dataAniversario,
			double taxaRendimento) {
		super(numero, saldo, dataAbertura);
		this.dataAniversario = dataAniversario;
		this.taxaRendimento = taxaRendimento;
	}

	public String getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(String dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public double getTaxaRendimento() {
		return taxaRendimento;
	}

	public void setTaxaRendimento(double taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}
	
	@Override
	public void aplicarRendimentos() {
		System.out.println("aplicando rendimentos na conta poupanca");
	}
	
	

}
