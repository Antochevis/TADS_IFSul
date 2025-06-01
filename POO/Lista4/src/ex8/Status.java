package ex8;

public class Status {
    private String situacao;

    public Status() {
        super();
        this.situacao = "";
    }

    public Status(String situacao) {
        super();
        this.situacao = situacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String imprimirDados() {
        return situacao;
    }
}
