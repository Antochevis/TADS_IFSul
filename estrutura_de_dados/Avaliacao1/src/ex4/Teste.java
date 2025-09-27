package ex4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Teste {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Digite a qtde de pacotes (mín 10): ");
        int qtd = sc.nextInt();

        while (qtd < 10) {
            System.out.print("Qtde tem que ser >= 10: ");
            qtd = sc.nextInt();
        }

        Queue<Pacote> fila = new LinkedList<>();

        for (int i = 0; i < qtd; ) {
            int id = random.nextInt(Integer.MAX_VALUE - 1) + 1;

            boolean existe = false;
            for (Pacote p : fila) {
                if (p.getId() == id) {
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                fila.add(new Pacote(id));
                i++;
            }
        }

        System.out.println("IDs sorteados:");
        for (Pacote p : fila) {
            System.out.println(p);
        }

        Stack<Pacote> pilhaPares = new Stack<>();
        Stack<Pacote> pilhaImpares = new Stack<>();

        while (!fila.isEmpty()) {
            Pacote p = fila.poll();
            if (p.getId() % 2 == 0) {
                pilhaPares.push(p);
            } else {
                pilhaImpares.push(p);
            }
        }
        
        System.out.println("Pares: ");
        while (!pilhaPares.isEmpty()) {
            Pacote p = pilhaPares.pop();
            System.out.println(p);
        }
        
        System.out.println("Ímpares");
        while (!pilhaImpares.isEmpty()) {
            Pacote p = pilhaImpares.pop();
            System.out.println(p);
        }

        sc.close();
    }
}
