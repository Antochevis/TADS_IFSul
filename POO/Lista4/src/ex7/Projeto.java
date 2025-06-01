package ex7;

import java.util.ArrayList;
import java.util.List;

public class Projeto {
    private String nome;
    private String codigo;
    private String descricao;
    private List<Funcionario> funcionarios;

    public Projeto() {
        super();
        this.nome = "";
        this.codigo = "";
        this.descricao = "";
        this.funcionarios = new ArrayList<>();
    }

    public Projeto(String nome, String codigo, String descricao) {
        super();
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
        this.funcionarios = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        if (!funcionarios.contains(funcionario)) {
            funcionarios.add(funcionario);
            funcionario.adicionarProjeto(this);
        }
    }

    public String imprimirDados() {
        return nome + " (Código: " + codigo + ")";
    }
}
