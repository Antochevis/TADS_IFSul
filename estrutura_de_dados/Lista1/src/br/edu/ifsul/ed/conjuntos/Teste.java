package br.edu.ifsul.ed.conjuntos;

public class Teste {
	public static void main(String[] args) {
		
		ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();
		
		conjunto.adiciona("palavrar");
		conjunto.adiciona("computador");
		conjunto.adiciona("apostila");
		conjunto.adiciona("instrutor");
		conjunto.adiciona("mesa");
		conjunto.adiciona("telefone");
		
		if(!conjunto.contem("palavrar")) {
			System.out.println("Erro: não tem a palavra: apostila");
		}
		
		conjunto.remove("apostila");
		
		if(conjunto.contem("Apostila")) {
			System.out.println("Erro: tem a palavra: apostila");
		}
		
		if(conjunto.tamanho() != 5) {
			System.out.println("Erro: o tamanho do conjunto deveria ser 5");
		}
		
	}
}
