package br.edu.ifsul.ed.vetores.testes;

import br.edu.ifsul.ed.Aluno;
import br.edu.ifsul.ed.vetores.Vetor;

public class TesteAdicionaNoFim {
	
	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		
		a1.setNome("Rochet");
		a2.setNome("Thiago Maia");
		
		Vetor lista = new Vetor();
		
		lista.adiciona(a1);
		lista.adiciona(a2);
	}

}
