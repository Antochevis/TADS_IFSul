package ex9;

import java.util.ArrayList;
import java.util.List;

public class Projeto {
    private String nome;
    private String objetivo;
    private Funcionario responsavel;
    private List<Tarefa> tarefas;

    public Projeto() {
        super();
        this.nome = "";
        this.objetivo = "";
        this.responsavel = null;
        this.tarefas = new ArrayList<>();
    }

    public Projeto(String nome, String objetivo, Funcionario responsavel) {
        super();
        this.nome = nome;
        this.objetivo = objetivo;
        this.responsavel = responsavel;
        this.tarefas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public void adicionarTarefa(Tarefa tarefa) {
        if (!tarefas.contains(tarefa)) {
            tarefas.add(tarefa);
            tarefa.setProjeto(this);
        }
    }

    public String imprimirDados() {
        return nome + " - " + objetivo + " | Responsável: " + responsavel.getNome();
    }
}
