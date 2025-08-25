package br.edu.ifsul.ed.vetores.testes;

import br.edu.ifsul.ed.Aluno;
import br.edu.ifsul.ed.vetores.Vetor;

public class TesteLinearVSConstante {

    public static void main(String[] args) {

        int quantidade = 100000;
        Vetor vetor = new Vetor();

        for (int i = 0; i < quantidade; i++) {
            Aluno aluno = new Aluno();
            aluno.setNome("Aluno " + i);
            vetor.adiciona(aluno);
        }
    }
}
