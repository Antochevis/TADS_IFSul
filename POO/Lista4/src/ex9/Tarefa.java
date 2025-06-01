package ex9;

public class Tarefa {
    private String titulo;
    private String descricao;
    private int duracaoEmDias;
    private Funcionario executor;
    private Projeto projeto;

    public Tarefa() {
        super();
        this.titulo = "";
        this.descricao = "";
        this.duracaoEmDias = 0;
        this.executor = null;
        this.projeto = null;
    }

    public Tarefa(String titulo, String descricao, int duracaoEmDias, Funcionario executor) {
        super();
        this.titulo = titulo;
        this.descricao = descricao;
        this.duracaoEmDias = duracaoEmDias;
        this.executor = executor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getDuracaoEmDias() {
        return duracaoEmDias;
    }

    public Funcionario getExecutor() {
        return executor;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDuracaoEmDias(int duracaoEmDias) {
        this.duracaoEmDias = duracaoEmDias;
    }

    public void setExecutor(Funcionario executor) {
        this.executor = executor;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public String imprimirDados() {
        return titulo + " - " + descricao + " | Executor: " + executor.getNome();
    }
}
