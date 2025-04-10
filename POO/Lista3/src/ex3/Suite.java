package ex3;

public class Suite extends Quarto {
	
	protected String servicoExtra;

	public Suite() {
		super();
		this.servicoExtra = "";
	}

	public Suite(int numeroQuarto, double precoPorNoite, String tipo, String servicoExtra) {
		super(numeroQuarto, precoPorNoite, tipo);
		this.servicoExtra = servicoExtra;
	}

	public String getServicoExtra() {
		return servicoExtra;
	}

	public void setServicoExtra(String servicoExtra) {
		this.servicoExtra = servicoExtra;
	}
	
	@Override
	public double calcularDiaria(int noites) {
		double precoTotal = super.calcularDiaria(noites) * 1.5;
		return precoTotal;
	}
	
	@Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Serviço extra: " + servicoExtra);
    }
	

}
