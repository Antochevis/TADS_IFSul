package exGerenciamentoFrota;

public class Caminhao extends Veiculo {
	
	protected double capacidadeCarga;
	
	public Caminhao() {
		super();
		this.capacidadeCarga = 0.0;
	}
	
	public Caminhao(String placa, String marca, String modelo, int ano, double kmRodados, double capacidadeCarga) {
        super(placa, marca, modelo, ano, kmRodados);
        this.capacidadeCarga = capacidadeCarga;
    }

	public double getCapacidadeCarga() {
		return capacidadeCarga;
	}

	public void setCapacidadeCarga(double capacidadeCarga) {
		this.capacidadeCarga = capacidadeCarga;
	}
	
	@Override
	public double calcularProximaManutencao() {
	    return kmRodados + 15000;
	}
	
	public void exibirInformacoes(boolean detalhada) {
        System.out.println("Placa: " + placa);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("km Rodados: " + kmRodados);
        System.out.println("Capacidade de Carga: " + capacidadeCarga);

        if (detalhada) {
            System.out.println("Histórico de Manutenções:");
            for (Manutencao m : historicoManutencoes) {
                System.out.println(" - " + m);
            }
        }
    }
	
}
