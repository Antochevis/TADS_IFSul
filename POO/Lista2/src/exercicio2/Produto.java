package exercicio2;

public class Produto {
	
	private int codigo;
	private String nome;
	private double preco;

	public Produto() {
		this.codigo = 0;
		this.nome = "";
		this.preco = 0;
	}

	public Produto (int codigo, String nome, double preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}

	public void imprimeAtributos() {
		System.out.println("Codigo: " + codigo);
		System.out.println("Nome: " + nome);
		System.out.println("Preço: " + preco);
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

}
