package exGerenciamentoFrota;

import java.util.ArrayList;

public class Veiculo {
	
	protected String placa;
	protected String marca;
	protected String modelo;
	protected int ano;
	protected double kmRodados;
	protected ArrayList<Manutencao> historicoManutencoes;
	
	public Veiculo() {
		this.placa = "";
		this.marca = "";
		this.modelo = "";
		this.ano = 0;
		this.kmRodados = 0.0;
		this.historicoManutencoes = new ArrayList<>();
	}

	public Veiculo(String placa, String marca, String modelo, int ano, double kmRodados) {
	    this.placa = placa;
	    this.marca = marca;
	    this.modelo = modelo;
	    this.ano = ano;
	    this.kmRodados = kmRodados;
	    this.historicoManutencoes = new ArrayList<>();
	}


	public String getPlaca() {
		return placa;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public int getAno() {
		return ano;
	}

	public double getKmRodados() {
		return kmRodados;
	}

	public ArrayList<Manutencao> getHistoricoManutencoes() {
		return historicoManutencoes;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public void setKmRodados(double kmRodados) {
		this.kmRodados = kmRodados;
	}

	public void setHistoricoManutencoes(ArrayList<Manutencao> historicoManutencoes) {
		this.historicoManutencoes = historicoManutencoes;
	}

	public void adicionarManutencao(Manutencao manutencao) {
		historicoManutencoes.add(manutencao);
	}
	
	public void exibirInformacoes() {
        System.out.println("Placa: " + placa);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("km Rodados: " + kmRodados);
        System.out.println("Histórico de Manutenções:");
        for (Manutencao m : historicoManutencoes) {
            System.out.println(" - " + m);
        }
    }
	
	public double calcularProximaManutencao() {
        return kmRodados;
    }
}
