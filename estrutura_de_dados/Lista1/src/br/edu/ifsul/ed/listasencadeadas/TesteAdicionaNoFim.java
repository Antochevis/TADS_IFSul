package br.edu.ifsul.ed.listasencadeadas;

public class TesteAdicionaNoFim {
	
	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
		
		lista.adiciona("Rafael");
		lista.adiciona("Paulo");
		
		System.out.println(lista);
	}

}
