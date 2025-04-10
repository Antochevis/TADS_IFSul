package apresentacao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.ContaBancaria;
import model.ContaPoupanca;

public class Teste {

	public static void main(String[] args) {
		ContaBancaria cb = new ContaBancaria();
		
		cb.setNumero("123123");
		cb.setSaldo(1000.0);
		
		System.out.println(cb.getNumero());
		System.out.println(cb.getSaldo());
		System.out.println(cb.getDataAbertura());
		
		ContaPoupanca cp = new ContaPoupanca("5464564", 5000.0, "25/02/2024", "", 0.0056);
		
		cb.aplicarRendimentos();
		
		cp.aplicarRendimentos();
		
		
		ContaBancaria c = new ContaPoupanca();
		
		
		c.transfere(new ContaPoupanca(), new ContaBancaria(), 1000.00);
		
		
		
		List<String> lista = new ArrayList<>();
		
		
		
		
		lista = new LinkedList<>();
 		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
