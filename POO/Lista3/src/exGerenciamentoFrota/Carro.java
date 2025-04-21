package exGerenciamentoFrota;

public class Carro extends Veiculo {
	
	protected int quantidadePortas;

	public Carro() {
		super();
		this.quantidadePortas = 0;
	}

	public Carro(String placa, String marca, String modelo, int ano, double kmRodados, int quantidadePortas) {
        super(placa, marca, modelo, ano, kmRodados);
        this.quantidadePortas = quantidadePortas;
    }

	public int getQuantidadePortas() {
		return quantidadePortas;
	}

	public void setQuantidadePortas(int quantidadePortas) {
		this.quantidadePortas = quantidadePortas;
	}
	
	@Override
	public double calcularProximaManutencao() {
	    return kmRodados + 10000;
	}


	
	public void exibirInformacoes(boolean detalhada) {
        System.out.println("Placa: " + placa);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("km Rodados: " + kmRodados);
        System.out.println("Quantidade de portas: " + quantidadePortas);

        if (detalhada) {
            System.out.println("Histórico de Manutenções:");
            for (Manutencao m : historicoManutencoes) {
                System.out.println(" - " + m);
            }
        }
    }
}
