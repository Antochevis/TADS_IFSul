package ex10;

public abstract class Disciplina {
    private String nome;
    private int cargaHoraria;
    private Professor professor;

    public Disciplina() {
        super();
        this.nome = "";
        this.cargaHoraria = 0;
        this.professor = null;
    }

    public Disciplina(String nome, int cargaHoraria, Professor professor) {
        super();
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public abstract String imprimirDados();
}

