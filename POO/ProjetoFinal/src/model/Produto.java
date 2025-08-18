package model;

public class Produto {

	private int id;
	private String tipo;
	private String nome;
	private double preco;
	private int estoque;

	public Produto() {
		super();
		this.tipo = "";
		this.nome = "";
		this.preco = 0.0;
		this.estoque = 0;
	}

	public Produto(String tipo, String nome, double preco, int estoque) {
		this.tipo = tipo;
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
	}

	public Produto(int id, String tipo, String nome, double preco, int estoque) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

}
