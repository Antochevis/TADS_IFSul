package ex7;

public class Main {
    public static void main(String[] args) {
    	
        Departamento d1 = new Departamento("Tecnologia da Informação", "TI", "Andrés D'Alessandro");

        Funcionario f1 = new Funcionario("Alan Patrick", "111.111.111-11", "Analista de Sistemas");
        Funcionario f2 = new Funcionario("Enner Valência", "222.222.222-22", "Desenvolvedor");

        d1.adicionarFuncionario(f1);
        d1.adicionarFuncionario(f2);

        Projeto p1 = new Projeto("Sistema Web", "SW001", "Desenvolvimento de sistema web.");
        Projeto p2 = new Projeto("App Mobile", "AM001", "Aplicativo para smartphones.");
        Projeto p3 = new Projeto("Site Institucional", "SW002", "Desenvolvimento de sistema web.");

        f1.adicionarProjeto(p1);
        f1.adicionarProjeto(p2);
        f2.adicionarProjeto(p2);
        f2.adicionarProjeto(p3);

        System.out.println("Departamento: " + d1.imprimirDados());

        System.out.println("\nFuncionários do departamento:");
        for (Funcionario f : d1.getFuncionarios()) {
        	System.out.println();
        	System.out.println(f.imprimirDados());
            System.out.println("Projetos:");
            for (Projeto p : f.getProjetos()) {
                System.out.println(" - " + p.imprimirDados());
            }
        }

        System.out.println("\nFuncionários por projeto:");
        for (Projeto p : new Projeto[]{p1, p2, p3}) {
            System.out.println(p.imprimirDados());
            for (Funcionario f : p.getFuncionarios()) {
                System.out.println("- " + f.getNome());
            }
        }
    }
}
