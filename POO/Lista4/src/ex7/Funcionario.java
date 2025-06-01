package ex7;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private String nome;
    private String cpf;
    private String cargo;
    private Departamento departamento;
    private List<Projeto> projetos;

    public Funcionario() {
        super();
        this.nome = "";
        this.cpf = "";
        this.cargo = "";
        this.departamento = null;
        this.projetos = new ArrayList<>();
    }

    public Funcionario(String nome, String cpf, String cargo) {
        super();
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.projetos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public void adicionarProjeto(Projeto projeto) {
        if (!projetos.contains(projeto)) {
            projetos.add(projeto);
            projeto.adicionarFuncionario(this);
        }
    }

    public String imprimirDados() {
        return nome + " (CPF: " + cpf + ", Cargo: " + cargo + ")";
    }
}
