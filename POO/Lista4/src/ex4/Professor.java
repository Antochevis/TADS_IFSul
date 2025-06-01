package ex4;

public class Professor {
    private String nome;
    private String matricula;
    private String area;
    private Disciplina disciplina;

    public Professor() {
    	super();
        this.nome = "";
        this.matricula = "";
        this.area = "";
        this.disciplina = null;
    }

    public Professor(String nome, String matricula, String area) {
    	super();
        this.nome = nome;
        this.matricula = matricula;
        this.area = area;
        this.disciplina = null;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getArea() {
        return area;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String imprimirDados() {
        return nome + " (Matrícula: " + matricula + ", Área: " + area + ")";
    }
}

