package ex8;

public class Servico {
    private String nome;
    private double preco;
    private String responsavel;
    private OrdemDeServico ordemDeServico;
    private Status status;

    public Servico() {
        super();
        this.nome = "";
        this.preco = 0.0;
        this.responsavel = "";
        this.ordemDeServico = null;
        this.status = null;
    }

    public Servico(String nome, double preco, String responsavel, Status status) {
        super();
        this.nome = nome;
        this.preco = preco;
        this.responsavel = responsavel;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public OrdemDeServico getOrdemDeServico() {
        return ordemDeServico;
    }

    public Status getStatus() {
        return status;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public void setOrdemDeServico(OrdemDeServico ordemDeServico) {
        this.ordemDeServico = ordemDeServico;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String imprimirDados() {
        return nome + " (Preço: R$" + preco + ", Responsável: " + responsavel + ")";
    }
}
