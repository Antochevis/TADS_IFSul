package br.edu.ifsul.ed.pilhas.testes;

import br.edu.ifsul.ed.Peca;
import br.edu.ifsul.ed.pilhas.Pilha;

public class Teste {
	public static void main(String[] args) {
		Pilha pilha = new Pilha();
		
		Peca pecaInsere = new Peca();
		pilha.insere(pecaInsere);
		
		Peca pecaRemove = pilha.remove();
		
		if (pilha.vazia()) {
			System.out.println("A pilha está vazia");
		}
	}
}
