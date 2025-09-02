package br.edu.ifsul.ed.listasencadeadas;

public class TesteRemovePorPosicao {
	
	public static void main(String[] arg) {
		ListaEncadeada lista = new ListaEncadeada();
		
		lista.adiciona("Rafael");
		lista.adiciona("Paulo");
		lista.adiciona("Camimla");
		lista.remove(1);
		
		System.out.println(lista);
	}
	
}
