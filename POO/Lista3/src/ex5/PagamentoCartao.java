package ex5;

public class PagamentoCartao extends Pagamento {

	protected String numeroCartao;

	public PagamentoCartao() {
		super();
		this.numeroCartao = "";
	}

	public PagamentoCartao(double valor, String descricao, String numeroCartao) {
		super(valor, descricao);
		this.numeroCartao = numeroCartao;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	
	@Override
	public void processarPagamento() {
		super.processarPagamento();
		System.out.println("Número do cartão: " + numeroCartao);
	}
	
	
}
