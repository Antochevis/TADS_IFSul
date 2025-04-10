package ex2;

public class ProdutoVestuario extends Produto {
	
	protected String tamanho;
	protected boolean emPromocao;
	
	public ProdutoVestuario() {
		super();
		this.tamanho = "";
		this.emPromocao = false;
	}
	
	public ProdutoVestuario(String nome, String descricao, double preco, int estoque, String tamanho, boolean emPromocao) {
		super(nome, descricao, preco, estoque);
		this.tamanho = tamanho;
		this.emPromocao = emPromocao;
	}

	public String getTamanho() {
		return tamanho;
	}

	public boolean isEmPromocao() {
		return emPromocao;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public void setEmPromocao(boolean emPromocao) {
		this.emPromocao = emPromocao;
	}
	
	@Override
	public double calcularPrecoFinal() {
		
		if (emPromocao) {
			preco = preco * 0.9;
		}
		
		return preco;
	}
	
	@Override
	public void exibirDetalhes() {
		super.exibirDetalhes();
		System.out.println("Tamanho do produto: " + tamanho);
		
		if (emPromocao) {
			System.out.println("Produto está em promoção 10% off.");
		} else {
			System.out.println("O produto não está em promoção.");
		}
	}
	
	
}
