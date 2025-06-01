package ex4;

public class Disciplina {
    private String nome;
    private String codigo;
    private int cargaHoraria;
    private Curso curso;
    private Professor professor;

    public Disciplina() {
    	super();
        this.nome = "";
        this.codigo = "";
        this.cargaHoraria = 0;
        this.curso = null;
        this.professor = null;
    }

    public Disciplina(String nome, String codigo, int cargaHoraria) {
    	super();
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.curso = null;
        this.professor = null;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public Curso getCurso() {
        return curso;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
        professor.setDisciplina(this); // associação bidirecional
    }

    public String imprimirDados() {
        return nome + " (Código: " + codigo + ", Carga Horária: " + cargaHoraria + "h)";
    }
}

