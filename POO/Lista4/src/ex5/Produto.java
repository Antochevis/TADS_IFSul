package ex5;

public class Produto {
    private String nome;
    private double preco;
    private String codigo;
    private Loja loja;

    public Produto() {
        super();
        this.nome = "";
        this.preco = 0.0;
        this.codigo = "";
        this.loja = null;
    }

    public Produto(String nome, double preco, String codigo) {
        super();
        this.nome = nome;
        this.preco = preco;
        this.codigo = codigo;
        this.loja = null;
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

    public Loja getLoja() {
        return loja;
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

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public String imprimirDados() {
        return nome + " (Código: " + codigo + ", Preço: R$" + preco + ")";
    }
}
