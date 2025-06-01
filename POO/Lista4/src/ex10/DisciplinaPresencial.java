package ex10;

public class DisciplinaPresencial extends Disciplina {
    private String sala;

    public DisciplinaPresencial() {
        super();
        this.sala = "";
    }

    public DisciplinaPresencial(String nome, int cargaHoraria, Professor professor, String sala) {
        super(nome, cargaHoraria, professor);
        this.sala = sala;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public String imprimirDados() {
        return getNome() + " - Presencial | Sala: " + sala + " | Professor: " + getProfessor().getNome();
    }
}
