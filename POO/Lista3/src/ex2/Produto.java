package ex2;

public class Produto {
	
	protected String nome, descricao;
	protected double preco;
	protected int estoque;
	
	public Produto() {
		super();
		this.nome = "";
		this.descricao = "";
		this.preco = 0.0;
		this.estoque = 0;
	}

	public Produto(String nome, String descricao, double preco, int estoque) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.estoque = estoque;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getPreco() {
		return preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	public double calcularPrecoFinal() {
		return preco;
	}
	
	public void exibirDetalhes() {
		System.out.println("Nome do produto: " + nome);
		System.out.println("Descrição do produto: " + descricao);
		System.out.println("Preço do produto: R$" + calcularPrecoFinal());
	}
	
	public void exibirDetalhes (boolean comEstoque) {
		exibirDetalhes();
		if (comEstoque) {
			System.out.println("Estoque do produto: " + estoque);
		}
	}

}
