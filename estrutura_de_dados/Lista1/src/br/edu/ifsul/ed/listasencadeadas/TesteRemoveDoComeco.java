package br.edu.ifsul.ed.listasencadeadas;

public class TesteRemoveDoComeco {
	
	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
		
		lista.adiciona("Rafael");
		lista.adiciona("Paulo");
		lista.removeDoComeco();
		
		System.out.println(lista);
	}

}
