package ex5;

public class PagamentoBoleto extends Pagamento {
	
	protected String codigoBarras;

	public PagamentoBoleto() {
		super();
		this.codigoBarras = "";
	}

	public PagamentoBoleto(double valor, String descricao, String codigoBarras) {
		super(valor, descricao);
		this.codigoBarras = codigoBarras;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	public void processarPagamento(boolean comTaxa) {
		
		if(comTaxa) {
			valor = valor + 5;
			System.out.println("Código de barras: " + codigoBarras);
			System.out.println("Descrição da compra: " + descricao);
			System.out.println("Valor do pagamento: R$" + valor);
		} else {
			super.processarPagamento();
			System.out.println("Código de barras: " + codigoBarras);
		}
		
	}
	
	public void processarPagamento(boolean comDesconto, double valorDesconto) {
		
		if(comDesconto) {
			valor = valor - valorDesconto;
			System.out.println("Código de barras: " + codigoBarras);
			System.out.println("Descrição da compra: " + descricao);
			System.out.println("Valor do pagamento: R$" + valor);
		} else {
			super.processarPagamento();
			System.out.println("Código de barras: " + codigoBarras);
		}
	}
}
