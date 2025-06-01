package ex8;

public class Main {
    public static void main(String[] args) {
        OrdemDeServico os = new OrdemDeServico("OS001", "Roger Machado", "Manutenção residencial");

        Status status1 = new Status("Em andamento");
        Status status2 = new Status("Concluído");

        Servico servico1 = new Servico("Reparo Elétrico", 299.99, "Bernabei", status1);
        Servico servico2 = new Servico("Pintura", 999.99, "Aguirre", status2);

        os.adicionarServico(servico1);
        os.adicionarServico(servico2);

        System.out.println("Serviços da Ordem de Serviço:");
        for (Servico s : os.getServicos()) {
            System.out.println("- " + s.imprimirDados() + " | Status: " + s.getStatus().imprimirDados());
        }

        System.out.println("\nOrdem de Serviço a partir do serviço:");
        System.out.println(servico1.getOrdemDeServico().imprimirDados());
    }
}

