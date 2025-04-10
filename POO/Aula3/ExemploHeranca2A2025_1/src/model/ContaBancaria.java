package model;

public class ContaBancaria extends Conta {

	public ContaBancaria() {
		super();

	}

	public ContaBancaria(String numero, double saldo, String dataAbertura) {
		super(numero, saldo, dataAbertura);
//		super.setNumero(numero);
//		super.setSaldo(saldo);
//		super.setDataAbertura(dataAbertura);
//		super.numero = numero;
//		super.saldo = saldo;
//		super.dataAbertura = dataAbertura;

	}
	
	// colocar dinheiro na conta
	public void creditar(double valor) {
		super.saldo += valor;
//		super.saldo = super.saldo + valor;
		
	}
	
	// retirar dinheiro da conta
	public boolean debitar(double valor) {
		// verificar se o valor é menor ou igual ao saldo
		if(valor<=super.saldo) {
			super.saldo -= valor;
			return true;
		}
		return false;
	}
	
	public void aplicarRendimentos() {
		System.out.println("aplicando rendimentos na conta bancaria");
	}
	
	// sobrecarga - dois metodos ou construtores com o mesmo nome, porém com parametros diferentes
	public void aplicarRendimentos(double taxa) {
		System.out.println("aplicando rendimentos na conta bancaria");
	}
	
	
	
	
	public void transfere(Conta origem, Conta destino, double valor) {
		// algoritmo
		// se eu quisesse saber se a conta de origem é uma ContaPoupanca
		if(origem instanceof ContaPoupanca) {
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
