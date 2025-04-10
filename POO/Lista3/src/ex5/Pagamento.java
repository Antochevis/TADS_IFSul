package ex5;

public class Pagamento {
	
	protected double valor;
	protected String descricao;

	public Pagamento() {
		super();
		this.valor = 0.0;
		this.descricao = "";
	}

	public Pagamento(double valor, String descricao) {
		super();
		this.valor = valor;
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void processarPagamento() {
		System.out.println("Descrição da compra: " + descricao);
		System.out.println("Valor do pagamento: R$" + valor);
	}
	
//	public void processarPagamento(boolean comTaxa , double taxa) {
//		
//        if (comTaxa) {
//            double valorComTaxa = valor + taxa;
//            System.out.println("Processando pagamento com taxa adicional:");
//            System.out.println("Valor original: R$" + valor);
//            System.out.println("Valor com taxa: R$" + valorComTaxa);
//        } else {
//            processarPagamento();
//        }
//    }
	
}
