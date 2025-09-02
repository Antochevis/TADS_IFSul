package br.edu.ifsul.ed.listasencadeadas;

public class TesteContemElemento {
	
	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
		
		lista.adiciona("Rafael");
		lista.adiciona("Paulo");
		
		System.out.println(lista.contem("Rafael"));
		System.out.println(lista.contem("Camila"));
	}

}
