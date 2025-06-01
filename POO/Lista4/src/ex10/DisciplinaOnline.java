package ex10;

public class DisciplinaOnline extends Disciplina {
    private String linkAcesso;

    public DisciplinaOnline() {
        super();
        this.linkAcesso = "";
    }

    public DisciplinaOnline(String nome, int cargaHoraria, Professor professor, String linkAcesso) {
        super(nome, cargaHoraria, professor);
        this.linkAcesso = linkAcesso;
    }

    public String getLinkAcesso() {
        return linkAcesso;
    }

    public void setLinkAcesso(String linkAcesso) {
        this.linkAcesso = linkAcesso;
    }

    @Override
    public String imprimirDados() {
        return getNome() + " - Online | Link: " + linkAcesso + " | Professor: " + getProfessor().getNome();
    }
}
