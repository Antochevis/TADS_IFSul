package ex4;


import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private String codigo;
    private int duracao;
    private List<Disciplina> disciplinas;

    public Curso() {
    	super();
        this.nome = "";
        this.codigo = "";
        this.duracao = 0;
        this.disciplinas = new ArrayList<>();
    }

    public Curso(String nome, String codigo, int duracao) {
    	super();
        this.nome = nome;
        this.codigo = codigo;
        this.duracao = duracao;
        this.disciplinas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getDuracao() {
        return duracao;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        if (!disciplinas.contains(disciplina)) {
            disciplinas.add(disciplina);
            disciplina.setCurso(this);
        }
    }

    public String imprimirDados() {
        return nome + " (Código: " + codigo + ", Duração: " + duracao + " meses)";
    }
}

