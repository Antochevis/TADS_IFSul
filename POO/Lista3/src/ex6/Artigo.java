package ex6;

public class Artigo extends Conteudo {
	
	protected int numeroPalavras;

	public Artigo() {
		super();
		this.numeroPalavras = 0;
	}

	public Artigo(String titulo, String descricao, int numeroPalavras) {
		super(titulo, descricao);
		this.numeroPalavras = numeroPalavras;
	}

	public int getNumeroPalavras() {
		return numeroPalavras;
	}

	public void setNumeroPalavras(int numeroPalavras) {
		this.numeroPalavras = numeroPalavras;
	}
	
	@Override
	public void exibirDetalhes() {
		super.exibirDetalhes();
		System.out.println("Número de palavras: " + numeroPalavras);
	}
	
}
