package br.edu.ifsul.ed.filas.testes;

import br.edu.ifsul.ed.Aluno;
import br.edu.ifsul.ed.filas.FilaGenerica;

public class TesteFilaGenerica {

    public static void main(String[] args) {
        
        FilaGenerica fila = new FilaGenerica();

        Aluno aluno1 = new Aluno();

        fila.insere(aluno1);

        Aluno alunoRemovido = (Aluno) fila.remove();

        System.out.println(alunoRemovido);

        if (fila.vazia()) {
            System.out.println("A fila está vazia");
        }

        FilaGenerica fila2 = new FilaGenerica();
        fila2.insere("Rafael");
        fila2.insere("Paulo");

        String paulo = (String) fila2.remove();
        String rafael = (String) fila2.remove();

        System.out.println(paulo);
        System.out.println(rafael);
    }
}
