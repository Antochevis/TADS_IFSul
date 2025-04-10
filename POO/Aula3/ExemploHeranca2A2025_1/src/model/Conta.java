package model;

import java.time.LocalDate;

public class Conta {
	// atributos da classe
	protected String numero;
	protected double saldo;
	// O correto seria LocalDate
	protected String dataAbertura;

	// construtores
	public Conta() {
		this.numero = "";
		this.saldo = 0.0;
		LocalDate dt = LocalDate.now();
		this.dataAbertura = dt.getDayOfMonth() + "/" + dt.getMonthValue() + "/" + dt.getYear();
	}

	public Conta(String numero, double saldo, String dataAbertura) {
		super();
		this.numero = numero;
		this.saldo = saldo;
		this.dataAbertura = dataAbertura;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	public void obterSaldo() {
		System.out.println("O saldo é: "+saldo);
	}

}
