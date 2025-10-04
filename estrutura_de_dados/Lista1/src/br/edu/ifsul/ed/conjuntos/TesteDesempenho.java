package br.edu.ifsul.ed.conjuntos;

public class TesteDesempenho {
	
	public static void main(String[] args) {
		
		long inicio = System.currentTimeMillis();
		ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();
		
		for(int i = 0; i < 50000; i++) {
			conjunto.adiciona("palavra" + i);
		}
		for(int i = 0; i < 50000; i++) {
			conjunto.contem("palavra" + i);
		}
		
	}

}
