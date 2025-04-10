package ex2;

public class SistemaGestaoProdutos {
	
	public static void main(String[] args) {
	       
		
		ProdutoEletronico celular = new ProdutoEletronico("Celular", "iPhone 16", 5000.0, 200, true);
		celular.exibirDetalhes(true);
		
		System.out.println("---------------------------");
		
		ProdutoEletronico celular2 = new ProdutoEletronico("Celular", "iPhone 16", 5000.0, 200, false);
		celular2.exibirDetalhes(false);
		
		System.out.println("---------------------------");
		
        ProdutoVestuario camiseta = new ProdutoVestuario("Camiseta", "Inter Home 2025", 400.0, 50, "M", true);
        camiseta.exibirDetalhes(true);
        
        System.out.println("---------------------------");
        
        ProdutoVestuario camiseta2 = new ProdutoVestuario("Camiseta", "Inter Home 2025 Manga Longa", 500.0, 50, "M", false);
        camiseta2.exibirDetalhes(false);
    }

}
