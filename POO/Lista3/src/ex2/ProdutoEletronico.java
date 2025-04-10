package ex2;

public class ProdutoEletronico extends Produto {
	
	protected boolean garantiaEstendida;

	public ProdutoEletronico() {
		super();
		garantiaEstendida = false;
	}

	public ProdutoEletronico(String nome, String descricao, double preco, int estoque, boolean garantiaEstendida) {
		super(nome, descricao, preco, estoque);
		this.garantiaEstendida = garantiaEstendida;
	}

	public boolean isGarantiaEstendida() {
		return garantiaEstendida;
	}

	public void setGarantiaEstendida(boolean garantiaEstendida) {
		this.garantiaEstendida = garantiaEstendida;
	}
	
	@Override
	public double calcularPrecoFinal() {
		
		if (garantiaEstendida) {
			preco = preco * 1.15;
		}
		
		return preco;
	}
	
	@Override
	public void exibirDetalhes() {
		super.exibirDetalhes();
		
		if (garantiaEstendida) {
			System.out.println("Produto possui garantia estendida");
		}
	}
}
