package ex1;

public class Main {
	
    public static void main(String[] args) {
    	
        Aluno aluno = new Aluno("Julia", 19, "A004", null);
        Endereco endereco = new Endereco("Av. Brasil", 123, "Rio de Janeiro");
        
        aluno.setEndereco(endereco);
        endereco.setAluno(aluno);

        aluno.imprimirDados();
        endereco.imprimirDados();
    }
}
