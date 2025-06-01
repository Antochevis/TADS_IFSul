package ex8;

import java.util.ArrayList;
import java.util.List;

public class OrdemDeServico {
    private String codigo;
    private String cliente;
    private String descricao;
    private List<Servico> servicos;

    public OrdemDeServico() {
        super();
        this.codigo = "";
        this.cliente = "";
        this.descricao = "";
        this.servicos = new ArrayList<>();
    }

    public OrdemDeServico(String codigo, String cliente, String descricao) {
        super();
        this.codigo = codigo;
        this.cliente = cliente;
        this.descricao = descricao;
        this.servicos = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public void adicionarServico(Servico servico) {
        if (!servicos.contains(servico)) {
            servicos.add(servico);
            servico.setOrdemDeServico(this);
        }
    }

    public String imprimirDados() {
        return "Ordem " + codigo + " para cliente " + cliente + " - " + descricao;
    }
}
