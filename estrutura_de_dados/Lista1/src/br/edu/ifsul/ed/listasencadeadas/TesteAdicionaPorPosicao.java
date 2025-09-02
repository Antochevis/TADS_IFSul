package br.edu.ifsul.ed.listasencadeadas;

public class TesteAdicionaPorPosicao {
	
	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
		
		lista.adiciona("Rafael");
		lista.adiciona(0, "Paulo");
		lista.adiciona(1, "Camimla");
		
		System.out.println(lista);
	}

}
