package model;

public class ItemVenda {

	private int id;
	private Venda venda;
	private Produto produto;
	private int quantidade;
	private double precoUnitario;

	public ItemVenda() {
		super();
		this.venda = new Venda();
		this.produto = new Produto();
		this.quantidade = 0;
		this.precoUnitario = 0.0;
	}

	public ItemVenda(int id, Venda venda, Produto produto, int quantidade, double precoUnitario) {
		this.id = id;
		this.venda = venda;
		this.produto = produto;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
	}

	public ItemVenda(Venda venda, Produto produto, int quantidade, double precoUnitario) {
		this.venda = venda;
		this.produto = produto;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double preco) {
		this.precoUnitario = preco;
	}
}
