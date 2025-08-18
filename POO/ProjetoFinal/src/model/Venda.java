package model;

import java.time.LocalDate;

public class Venda {

	private int id;
	private LocalDate data;
	private double valorTotal;
	private String formaPagamento;
	private Cliente cliente;

	public Venda() {
		super();
		this.valorTotal = 0.0;
		this.formaPagamento = "";

	}

	public Venda(int id, LocalDate data, double valorTotal, String formaPagamento, Cliente cliente) {
		this.id = id;
		this.data = data;
		this.valorTotal = valorTotal;
		this.formaPagamento = formaPagamento;
		this.cliente = cliente;
	}

	public Venda(LocalDate data, double valorTotal, String formaPagamento, Cliente cliente) {
		this.data = data;
		this.valorTotal = valorTotal;
		this.formaPagamento = formaPagamento;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String forma) {
		this.formaPagamento = forma;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
