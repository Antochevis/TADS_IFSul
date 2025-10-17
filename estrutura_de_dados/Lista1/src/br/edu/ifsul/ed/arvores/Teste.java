package br.edu.ifsul.ed.arvores;

public class Teste {
	public static void main(String[] args) {
		BArvore arvore = new BArvore();
		
		arvore.inserirNo(new BinNo(59));
		arvore.inserirNo(new BinNo(103));
		arvore.inserirNo(new BinNo(48));
		arvore.inserirNo(new BinNo(33));
		arvore.inserirNo(new BinNo(51));
		arvore.inserirNo(new BinNo(38));
		arvore.inserirNo(new BinNo(79));
		arvore.inserirNo(new BinNo(1));
		arvore.inserirNo(new BinNo(235));
		arvore.inserirNo(new BinNo(121));
		arvore.inserirNo(new BinNo(223));
		arvore.inserirNo(new BinNo(161));
		
		arvore.preencherNiveis();
		arvore.exibir();
		
		int total = arvore.contarElementos();
        int altura = arvore.calcularAltura();

        System.out.println("Total: " + total);
        System.out.println("Altura: " + altura);
        
        System.out.println("-----------EXERCICIO 5: ------------");
        
        BArvore arvore1 = new BArvore();
		BArvore arvore2 = new BArvore();
		BArvore arvore3 = new BArvore();
		
		arvore1.inserirNo(new BinNo(27));
		arvore1.inserirNo(new BinNo(36));
		arvore1.inserirNo(new BinNo(15));
		arvore1.inserirNo(new BinNo(16));
		arvore1.inserirNo(new BinNo(7));
		arvore1.inserirNo(new BinNo(42));
		arvore1.inserirNo(new BinNo(30));
		arvore2.inserirNo(new BinNo(75));
		arvore2.inserirNo(new BinNo(17));
		arvore2.inserirNo(new BinNo(89));
		arvore2.inserirNo(new BinNo(60));
		arvore2.inserirNo(new BinNo(75));
		arvore2.inserirNo(new BinNo(39));
		arvore2.inserirNo(new BinNo(97));
		arvore2.inserirNo(new BinNo(21));
		arvore2.inserirNo(new BinNo(100));
		arvore3.inserirNo(new BinNo(14));
		arvore3.inserirNo(new BinNo(5));
		arvore3.inserirNo(new BinNo(1));
		arvore3.inserirNo(new BinNo(31));
		arvore3.inserirNo(new BinNo(9));
		arvore3.inserirNo(new BinNo(12));
		arvore3.inserirNo(new BinNo(6));
		arvore3.inserirNo(new BinNo(19));
		arvore3.inserirNo(new BinNo(45));
		arvore3.inserirNo(new BinNo(11));
		arvore3.inserirNo(new BinNo(22));
		
		System.out.println("Árvore 1:");
		arvore1.inOrdem();
		arvore1.preOrdem();
		arvore1.posOrdem();
		arvore1.emNivel();

		System.out.println("Árvore 2:");
		arvore2.inOrdem();
		arvore2.preOrdem();
		arvore2.posOrdem();
		arvore2.emNivel();

		System.out.println("Árvore 3:");
		arvore3.inOrdem();
		arvore3.preOrdem();
		arvore3.posOrdem();
		arvore3.emNivel();
	}
}
