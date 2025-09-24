package ex2;

import java.util.LinkedList;
import java.util.List;

public class Teste {
	
	public static void main(String[] args) {
		
        List<Lista> lista = new LinkedList<>();
        lista.add(new Lista(1, 3, 0, "Verde"));
        lista.add(new Lista(2, 4, 3, "Azul"));
        lista.add(new Lista(3, 2, 1, "Amarelo"));
        lista.add(new Lista(4, 0, 2, "Vermelho"));

        Lista atual = null;
        
        for (Lista pontoInicial : lista) {
            if (pontoInicial.idDoAnterior == 0) {
                atual = pontoInicial;
                break;
            }
        }

        while (atual != null && atual.id != 0) {
            System.out.println(atual.conteudo);

            int proximoId = atual.idDoSeguinte;

            Lista proximo = null;
            for (Lista pontoSeguinte : lista) {
                if (pontoSeguinte.id == proximoId) {
                    proximo = pontoSeguinte;
                    break;
                }
            }
            atual = proximo;
        }
    }

}
