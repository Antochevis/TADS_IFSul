package ex9;

public class Funcionario {
    private String nome;
    private int idade;
    private String cargo;

    public Funcionario() {
        super();
        this.nome = "";
        this.idade = 0;
        this.cargo = "";
    }

    public Funcionario(String nome, int idade, String cargo) {
        super();
        this.nome = nome;
        this.idade = idade;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCargo() {
        return cargo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String imprimirDados() {
        return nome + " - " + cargo;
    }
}
