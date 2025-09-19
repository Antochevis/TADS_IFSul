package br.edu.ifsul.ed.pilhas.testes;

import br.edu.ifsul.ed.Peca;
import br.edu.ifsul.ed.pilhas.PilhaParametrizada;

public class TestePilhaParametrizada {
	
	public static void main(String [] args) {
		
		PilhaParametrizada<Peca> pilha = new PilhaParametrizada<Peca>();
		
		Peca peca = new Peca();
		pilha.insere(peca);
		
		Peca pecaRemove = pilha.remove();
		
		if (pilha.vazia()) {
			System.out.println("A pilha está vazia");
		}
		
		PilhaParametrizada<String> pilha2 = new PilhaParametrizada<String>();
		pilha2.insere("Rafael");
		pilha2.insere("Paulo");
		
		String paulo = pilha2.remove();
		String rafael = pilha2.remove();
		System.out.println(paulo);
		System.out.println(rafael);
		
	}
}
