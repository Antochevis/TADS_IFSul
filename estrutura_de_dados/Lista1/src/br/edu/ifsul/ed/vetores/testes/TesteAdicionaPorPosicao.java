package br.edu.ifsul.ed.vetores.testes;

import br.edu.ifsul.ed.Aluno;
import br.edu.ifsul.ed.vetores.Vetor;

public class TesteAdicionaPorPosicao {
	
	public static void main (String[] args) {
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		Aluno a3 = new Aluno();
		
		a1.setNome("Alan Patrick");
		a2.setNome("Ricardo Mathias");
		a3.setNome("Bernabei");
		
		Vetor lista = new Vetor();
		
		lista.adiciona(a1);
		lista.adiciona(0, a2);
		lista.adiciona(1, a3);
		
		System.out.println(lista);
	}

}
