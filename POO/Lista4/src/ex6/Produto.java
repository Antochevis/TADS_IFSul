package ex6;

public class Produto {
    private String nome;
    private double preco;
    private String codigo;

    public Produto() {
        super();
        this.nome = "";
        this.preco = 0.0;
        this.codigo = "";
    }

    public Produto(String nome, double preco, String codigo) {
        super();
        this.nome = nome;
        this.preco = preco;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String imprimirDados() {
        return nome + " (Código: " + codigo + ", Preço: R$" + preco + ")";
    }
}
