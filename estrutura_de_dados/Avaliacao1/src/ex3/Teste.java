package ex3;

import java.util.Scanner;

public class Teste {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a mensagem: ");
        String mensagem = scanner.nextLine();

        String criptografada = Criptografia.criptografar(mensagem);
        System.out.println("Mensagem criptografada: " + criptografada);

        System.out.println("Mensagem descriptografada: " + mensagem);

        scanner.close();
    }
}
