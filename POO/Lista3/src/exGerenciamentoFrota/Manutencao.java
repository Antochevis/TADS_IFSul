package exGerenciamentoFrota;

public class Manutencao {
	
	protected String data;
	protected String descricao;
	protected double kmRealizada;
	
	public Manutencao() {
		super();
		this.data = "";
		this.descricao = "";
		this.kmRealizada = 0.0;
	}

	public Manutencao(String data, String descricao, double kmRealizada) {
		super();
		this.data = data;
		this.descricao = descricao;
		this.kmRealizada = kmRealizada;
	}

	public String getData() {
		return data;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getKmRealizada() {
		return kmRealizada;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setKmRealizada(double kmRealizada) {
		this.kmRealizada = kmRealizada;
	}
	
	@Override
	public String toString() {
	    return "Data: " + data + ", Descrição: " + descricao + ", KM: " + kmRealizada;
	}

	
	/*public void exibirDetalhes() {
		System.out.println("Data da manutenção: " + data);
		System.out.println("Descrição da manutenção: " + descricao);
		System.out.println("Quilometragem no momento da manutenção: " + kmRealizada + "km");
	}*/
}
