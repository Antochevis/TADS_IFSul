package ex2;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("Tech Solutions", "12.345.678/0001-99", "Rua da Inovação, 100", null);

        Funcionario f1 = new Funcionario("Ana", "Desenvolvedora", 6000.0, null);
        Funcionario f2 = new Funcionario("Bruno", "Analista", 5000.0, null);
        Funcionario f3 = new Funcionario("Carla", "Gerente de Projetos", 8000.0, null);

        empresa.adicionarFuncionario(f1);
        empresa.adicionarFuncionario(f2);
        empresa.adicionarFuncionario(f3);

        empresa.imprimirDados();

        System.out.println("\n--- Detalhes dos Funcionários ---");
        f1.imprimirDados();
        f2.imprimirDados();
        f3.imprimirDados();
    }
}