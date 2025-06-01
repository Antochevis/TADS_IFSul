package ex5;

public class Main {
    public static void main(String[] args) {
    	
        Loja loja = new Loja("Loja do Inter", "AV. Padre Cacique 891", "00.000.000/0001-00");

        Produto p1 = new Produto("Camisa 1 2025", 399.99, "C12025");
        Produto p2 = new Produto("Camisa de Goleiro 2025", 499.99, "CG2025");

        loja.adicionarProduto(p1);
        loja.adicionarProduto(p2);

        System.out.println(loja.imprimirDados());
        System.out.println("Produtos:");
        for (Produto p : loja.getProdutos()) {
            System.out.println(p.imprimirDados());
        }

        System.out.println();

        System.out.println("Loja de cada produto:");
        System.out.println(p1.getNome() + " encontra na loja: " + p1.getLoja().getNome());
        System.out.println(p2.getNome() + " encontra na loja: " + p2.getLoja().getNome());
    }
}
