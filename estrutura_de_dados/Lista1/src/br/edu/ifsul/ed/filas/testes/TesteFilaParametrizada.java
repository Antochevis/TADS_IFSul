package br.edu.ifsul.ed.filas.testes;

import br.edu.ifsul.ed.Aluno;
import br.edu.ifsul.ed.filas.FilaParametrizada;

public class TesteFilaParametrizada {
	
	public static void main(String[] args) {
		FilaParametrizada<Aluno> fila = new FilaParametrizada<Aluno>();
		
		Aluno aluno = new Aluno();
		fila.insere(aluno);
		
		Aluno alunoRemovido = fila.remove();
		
		if (fila.vazia()) {
			System.out.println("A fila está vazia");
		}
		
		FilaParametrizada<String> filaDeString = new FilaParametrizada<String>();
		filaDeString.insere("Rafael");
		filaDeString.insere("Paulo");
		
		String paulo = filaDeString.remove();
		String rafael = filaDeString.remove();
		
		System.out.println(paulo);
		System.out.println(rafael);
	}

}
