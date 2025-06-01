package ex5;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private String nome;
    private String endereco;
    private String cnpj;
    private List<Produto> produtos;

    public Loja() {
        super();
        this.nome = "";
        this.endereco = "";
        this.cnpj = "";
        this.produtos = new ArrayList<>();
    }

    public Loja(String nome, String endereco, String cnpj) {
        super();
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.produtos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void adicionarProduto(Produto produto) {
        if (!produtos.contains(produto)) {
            produtos.add(produto);
            produto.setLoja(this);
        }
    }

    public String imprimirDados() {
        return nome + " (CNPJ: " + cnpj + ", Endereço: " + endereco + ")";
    }
}
