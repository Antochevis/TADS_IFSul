package exGerenciamentoFrota;

import java.util.ArrayList;
import java.util.Scanner;

public class GestaoFrota {
	
	private static ArrayList<Veiculo> veiculos = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int opcao;
		
		do {
            System.out.println("--- GESTÃO DE FROTA ---");
            System.out.println("1. Cadastrar Novo Veículo");
            System.out.println("2. Listar Veículos");
            System.out.println("3. Registrar Manutenção");
            System.out.println("4. Consultar Histórico de Manutenção");
            System.out.println("5. Exibir Próxima Manutenção");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = Integer.parseInt(scanner.nextLine());
           
            switch (opcao) {
                case 1:
                    cadastrarVeiculo();
                    break;
                case 2:
                    listarVeiculos();
                    break;
                case 3:
                    registrarManutencao();
                    break;
                case 4:
                    consultarHistorico();
                    break;
                case 5:
                    exibirProximaManutencao();
                    break;
                case 6:
                    System.out.println("Tchau!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 6);
    }
	
	
	
	private static void cadastrarVeiculo() {
        System.out.print("Digite o tipo de veículo (1 para carro e 2 para caminhão): ");
        int tipo = Integer.parseInt(scanner.nextLine());

        System.out.print("Placa: ");
        String placa = scanner.nextLine();

        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        System.out.print("Ano: ");
        int ano = Integer.parseInt(scanner.nextLine());

        System.out.print("KM Rodados: ");
        double kmRodados = Double.parseDouble(scanner.nextLine());

        if (tipo == 1) {
            System.out.print("Quantidade de portas: ");
            int quantidadePortas = Integer.parseInt(scanner.nextLine());

            Carro carro = new Carro(placa, marca, modelo, ano, kmRodados, quantidadePortas);
            veiculos.add(carro);
            System.out.println("Carro cadastrado com sucesso!");

        } else if (tipo == 2) {
            System.out.print("Capacidade de carga: ");
            double capacidade = Double.parseDouble(scanner.nextLine());

            Caminhao caminhao = new Caminhao(placa, marca, modelo, ano, kmRodados, capacidade);
            veiculos.add(caminhao);
            System.out.println("Caminhão cadastrado com sucesso!");
        } else {
            System.out.println("Tipo de veículo não reconhecido.");
        }
    }
	
	private static void listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

        for (Veiculo v : veiculos) {
            if (v instanceof Carro) {
                ((Carro) v).exibirInformacoes(false);
            } else if (v instanceof Caminhao) {
                ((Caminhao) v).exibirInformacoes(false);
            } else {
                v.exibirInformacoes();
            }
            System.out.println("-----------------------");
        }
    }
	
	private static void registrarManutencao() {
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();

        Veiculo veiculo = buscarVeiculoPorPlaca(placa);

        if (veiculo != null) {
            System.out.print("Data da manutenção: ");
            String data = scanner.nextLine();

            System.out.print("Descrição da manutenção: ");
            String descricao = scanner.nextLine();

            System.out.print("km da manutenção: ");
            double km = Double.parseDouble(scanner.nextLine());

            Manutencao m = new Manutencao(data, descricao, km);
            veiculo.adicionarManutencao(m);
            System.out.println("Manutenção registrada com sucesso!");
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    private static void consultarHistorico() {
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();

        Veiculo veiculo = buscarVeiculoPorPlaca(placa);

        if (veiculo != null) {
            if (veiculo instanceof Carro) {
                ((Carro) veiculo).exibirInformacoes(true);
            } else if (veiculo instanceof Caminhao) {
                ((Caminhao) veiculo).exibirInformacoes(true);
            } else {
                veiculo.exibirInformacoes();
            }
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    private static void exibirProximaManutencao() {
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();

        Veiculo veiculo = buscarVeiculoPorPlaca(placa);

        if (veiculo != null) {
            System.out.println("Próxima manutenção sugerida em: " + veiculo.calcularProximaManutencao() + " km");
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    private static Veiculo buscarVeiculoPorPlaca(String placa) {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }
}
