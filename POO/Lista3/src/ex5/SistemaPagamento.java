package ex5;

public class SistemaPagamento {
	
	public static void main(String[] args) {
		
		PagamentoCartao pagamentoCartao = new PagamentoCartao(500.0, "Pagamento com cartão", "0000.0000.0000");
		pagamentoCartao.processarPagamento();
		
		System.out.println("----------------");
		
		PagamentoBoleto pagamentoBoleto = new PagamentoBoleto(200.0, "Pagamento boleto com taxa", "00000000000000000000");
		pagamentoBoleto.processarPagamento(true);
		
		System.out.println("----------------");
		
		PagamentoBoleto pagamentoBoleto2 = new PagamentoBoleto(500.0, "Pagamento boleto com desconto", "00000000000000000001");
		pagamentoBoleto2.processarPagamento(true, 100.0);
	}

}
