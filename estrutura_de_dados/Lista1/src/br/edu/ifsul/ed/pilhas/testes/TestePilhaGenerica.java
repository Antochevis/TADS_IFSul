package br.edu.ifsul.ed.pilhas.testes;

import br.edu.ifsul.ed.Peca;
import br.edu.ifsul.ed.pilhas.PilhaGenerica;

public class TestePilhaGenerica {

    public static void main(String[] args) {
        
        PilhaGenerica pilha = new PilhaGenerica();
        
        Peca peca = new Peca();
        pilha.insere(peca);
        
        Peca pecaRemove = (Peca) pilha.remove();
        
        if (pilha.vazia()) {
            System.out.println("A pilha está vazia");
        }
        
        PilhaGenerica pilha2 = new PilhaGenerica();
        pilha2.insere("Rafael");
        pilha2.insere("Paulo");
        
        String paulo = (String) pilha2.remove();
        String rafael = (String) pilha2.remove();
        
        System.out.println(paulo);
        System.out.println(rafael);
    }
}
