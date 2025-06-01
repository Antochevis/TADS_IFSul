package ex7;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nome;
    private String sigla;
    private String responsavel;
    private List<Funcionario> funcionarios;

    public Departamento() {
        super();
        this.nome = "";
        this.sigla = "";
        this.responsavel = "";
        this.funcionarios = new ArrayList<>();
    }

    public Departamento(String nome, String sigla, String responsavel) {
        super();
        this.nome = nome;
        this.sigla = sigla;
        this.responsavel = responsavel;
        this.funcionarios = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        if (!funcionarios.contains(funcionario)) {
            funcionarios.add(funcionario);
            funcionario.setDepartamento(this);
        }
    }

    public String imprimirDados() {
        return nome + " (" + sigla + "), responsável: " + responsavel;
    }
}
