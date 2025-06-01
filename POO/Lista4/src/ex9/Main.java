package ex9;

public class Main {
    public static void main(String[] args) {
        Funcionario responsavel = new Funcionario("Carbonero", 25, "Gerente de Projetos");

        Projeto projeto = new Projeto("Sistema Web", "Desenvolver plataforma online", responsavel);

        Funcionario f1 = new Funcionario("Wesley", 24, "Desenvolvedor");
        Funcionario f2 = new Funcionario("Rafael Borré", 32, "Analista de Testes");
        Funcionario f3 = new Funcionario("Rodrigo Mathias", 19, "Designer");

        Tarefa t1 = new Tarefa("Backend", "Construir API", 5, f1);
        Tarefa t2 = new Tarefa("Testes", "Testar API", 3, f2);
        Tarefa t3 = new Tarefa("UI/UX", "Criar interface", 2, f3);

        projeto.adicionarTarefa(t1);
        projeto.adicionarTarefa(t2);
        projeto.adicionarTarefa(t3);

        System.out.println("Projeto:");
        System.out.println(projeto.imprimirDados());

        System.out.println("\nTarefas:");
        for (Tarefa t : projeto.getTarefas()) {
            System.out.println(t.imprimirDados());
        }
    }
}
