package br.edu.ifsul.ed.arvoresAVL;

public class TesteAVL {

    public static void main(String[] args) {
        ArvoresAVL.ARVORE raiz = null;

        int[] elementosInserir = {50, 1, 64, 12, 18, 66, 38, 95, 58, 59, 70, 68, 39, 62, 7, 60, 43, 16, 67, 34, 35};
        int[] elementosRemover = {50, 95, 70, 60, 35};

        System.out.println("PARTE A - INSERÇÕES");
        for (int num : elementosInserir) {
            raiz = ArvoresAVL.inserir(raiz, num);
        }

        ArvoresAVL.mostraremordem(raiz);

        System.out.println("PARTE B - REMOÇÕES");
        for (int num : elementosRemover) {
            raiz = ArvoresAVL.remover(raiz, num);
        }
        ArvoresAVL.mostraremordem(raiz);

        System.out.println("Pré-Ordem:");
        ArvoresAVL.mostrarpreordem(raiz);

        System.out.println("\n\nPós-Ordem:");
        ArvoresAVL.mostrarposordem(raiz);
    }
}
