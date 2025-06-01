package ex10;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private String area;
    private List<Disciplina> disciplinas;

    public Curso() {
        super();
        this.nome = "";
        this.area = "";
        this.disciplinas = new ArrayList<>();
    }

    public Curso(String nome, String area) {
        super();
        this.nome = nome;
        this.area = area;
        this.disciplinas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getArea() {
        return area;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        if (!disciplinas.contains(disciplina)) {
            disciplinas.add(disciplina);
        }
    }

    public String imprimirDados() {
        return nome + " - Área: " + area;
    }
}

