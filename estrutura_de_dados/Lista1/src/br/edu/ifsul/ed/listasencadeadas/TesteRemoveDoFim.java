package br.edu.ifsul.ed.listasencadeadas;

public class TesteRemoveDoFim {
	
	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
		
		lista.adiciona("Rafael");
		lista.adiciona("Paulo");
		lista.removeDoFim();
		
		System.out.println(lista);
	}

}
