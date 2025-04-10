package ex3;

public class Quarto {
	
	protected int numeroQuarto;
	protected double precoPorNoite;
	protected String tipo;
	
	
	
	
	
	public Quarto() {
		super();
		this.numeroQuarto = 0;
		this.precoPorNoite = 0.0;
		this.tipo = "";
	}

	public Quarto(int numeroQuarto, double precoPorNoite, String tipo) {
		super();
		this.numeroQuarto = numeroQuarto;
		this.precoPorNoite = precoPorNoite;
		this.tipo = tipo;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public double getPrecoPorNoite() {
		return precoPorNoite;
	}

	public String getTipo() {
		return tipo;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public void setPrecoPorNoite(double precoPorNoite) {
		this.precoPorNoite = precoPorNoite;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public double calcularDiaria(int noites) {
		return precoPorNoite * noites;
	}
	
	public void exibirInformacoes() {
		System.out.println("Quarto número: " + numeroQuarto);
        System.out.println("Tipo: " + tipo);
	}
	
	public void exibirInformacoes(boolean comPreco) {
        exibirInformacoes();
        if (comPreco) {
            System.out.println("Preço por noite: R$" + precoPorNoite);
        }
    }
	

}
