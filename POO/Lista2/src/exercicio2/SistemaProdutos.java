package exercicio2;

import java.util.ArrayList;
import java.util.Scanner;


public class SistemaProdutos {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		ArrayList<Produto> produtos = new ArrayList<>();
		
		int opcao;
	     
	     do {
	    	 
	    	 System.out.println("Escolha uma opção: ");
	    	 System.out.println("Opção 1: Adicionar novo produto");
	    	 System.out.println("Opção 2: Visualizar lista de produtos");
	    	 System.out.println("Opção 3: Remover produto");
	    	 System.out.println("Opção 4: Sair");
	    	 
	    	 opcao = teclado.nextInt();
	    	 teclado.nextLine();
	    	 
	    	 switch (opcao) {
	    	 case 1:
	    		 System.out.println("Insira o código do produto: ");
                 int codigo = teclado.nextInt();
                 teclado.nextLine();
                 System.out.println("Insira o nome do produto: ");
                 String nome = teclado.nextLine();
                 System.out.println("Insira o preço do produto: ");
                 double preco= teclado.nextDouble();
                 
                 boolean produtoCadastrado = false;
                 for (Produto produto : produtos) {
                     if (produto.getCodigo() == codigo) {
                    	 produtoCadastrado = true;
                         System.out.println("Produto já cadastrado!");
                         break;
                     }
                 }
                 
                 if (!produtoCadastrado) {
                	 Produto produto = new Produto (codigo, nome, preco);
                     produtos.add(produto);
                     System.out.println("Produto cadastrado!");
                     break;
                 }
                 break;
                 
	    	 case 2:
	    		 if (produtos.isEmpty()) {
                     System.out.println("Nenhum produto cadastrado.");
                 } else {
                     for (Produto produto : produtos) {
                         System.out.println("Código: " + produto.getCodigo() + ", Nome: " + produto.getNome() + ", Preço: R$ " + produto.getPreco());
                     }
                 }
                 break;
                 
	    	 case 3:
	    		 System.out.println("Digite o código do produto que deseja remover: ");
                 int produtoRemover = teclado.nextInt();
                 boolean produtoRemovido = false;

                 for (Produto produto : produtos) {
                     if (produto.getCodigo() == produtoRemover) {
                         produtos.remove(produto);
                         produtoRemovido = true;
                         System.out.println("Produto removido com sucesso!");
                         break;
                     }
                 }

                 if (!produtoRemovido) {
                     System.out.println("Produto não encontrado.");
                 }
                 
                 break;
                 
	    	 case 4:
	    		 System.out.println("Tchau!");
                 break;

             default:
                 System.out.println("Opção inválida. Tente novamente.");
	    	 }
	    	 
	     } while (opcao != 4);
	     
	     teclado.close();
	}

}
