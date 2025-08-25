package br.edu.ifsul.ed.vetores.testes;

import br.edu.ifsul.ed.Aluno;
import br.edu.ifsul.ed.vetores.Vetor;

public class TestePegaPorPosicao {
	
	public static void main (String[] args) {
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		
		a1.setNome("Alan Rodríguez");
		a2.setNome("Wesley");
		
		Vetor lista = new Vetor();
		
		lista.adiciona(a1);
		lista.adiciona(a2);
		
		Aluno aluno1 = lista.pega(0);
		Aluno aluno2 = lista.pega(1);
		
		System.out.println(aluno1);
		System.out.println(aluno2);
		
		
		// 1. posição ocupada
        Aluno alunoValido = lista.pega(0);
        System.out.println("Posição 0 (ocupada): " + alunoValido);

        // 2. posição vazia
        Aluno alunoVazio = lista.pega(5);
        System.out.println("Posição 5 (vazia): " + alunoVazio);

        // 3. posição que não existe
        Aluno alunoInvalido = lista.pega(1000000); 
        System.out.println("Posição inválida: " + alunoInvalido);
		
		
	}

}
