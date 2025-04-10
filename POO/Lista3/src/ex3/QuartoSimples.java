package ex3;

public class QuartoSimples extends Quarto {
	
	protected int ocupacaoMaxima;
	
	
	public QuartoSimples() {
		super();
		this.ocupacaoMaxima = 0;
	}

	public QuartoSimples(int numeroQuarto, double precoPorNoite, String tipo, int ocupacaoMaxima) {
		super(numeroQuarto, precoPorNoite, tipo);
		this.ocupacaoMaxima = ocupacaoMaxima;
	}


	public int getOcupacaoMaxima() {
		return ocupacaoMaxima;
	}


	public void setOcupacaoMaxima(int ocupacaoMaxima) {
		this.ocupacaoMaxima = ocupacaoMaxima;
	}
	
	@Override
	public void exibirInformacoes() {
		super.exibirInformacoes();
		System.out.println("A ocupação máxima do quarto simples é igual a " + ocupacaoMaxima);
	}
	
}
