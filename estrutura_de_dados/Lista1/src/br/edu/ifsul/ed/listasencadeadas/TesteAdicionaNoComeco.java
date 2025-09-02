package br.edu.ifsul.ed.listasencadeadas;

public class TesteAdicionaNoComeco {
	
	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
		
		lista.adicionaNoComeco("Rafael");
		lista.adicionaNoComeco("Pualo");
		
		System.out.println(lista);
	}

}
