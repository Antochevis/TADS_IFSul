package ex10;

public class Professor {
    private String nome;
    private String especialidade;
    private int idade;

    public Professor() {
        super();
        this.nome = "";
        this.especialidade = "";
        this.idade = 0;
    }

    public Professor(String nome, String especialidade, int idade) {
        super();
        this.nome = nome;
        this.especialidade = especialidade;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String imprimirDados() {
        return nome + " - " + especialidade;
    }
}
