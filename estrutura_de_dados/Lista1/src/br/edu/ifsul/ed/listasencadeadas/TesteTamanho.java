package br.edu.ifsul.ed.listasencadeadas;

public class TesteTamanho {
	
	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
		
		lista.adiciona("Rafael");
		lista.adiciona("Paulo");
		
		System.out.println(lista.tamanho());
		
		lista.adiciona("Camila");
		
		System.out.println(lista.tamanho());
	}

}
