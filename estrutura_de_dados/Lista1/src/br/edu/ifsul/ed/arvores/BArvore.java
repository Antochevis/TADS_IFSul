package br.edu.ifsul.ed.arvores;

public class BArvore {
	private BinNo raiz;
	
	private BinNo inserir(BinNo atual, BinNo novoNo) {
		if (atual == null) {
			return novoNo;
		} else if (novoNo.valor < atual.valor) {
			atual.esq = inserir(atual.esq, novoNo);
		} else {
			atual.dir = inserir(atual.dir, novoNo);
		}
		return atual;
	}
	
	public void inserirNo(BinNo novoNo) {
		raiz = inserir(raiz, novoNo);
	}
	
	public void exibir() {
		System.out.println("Exibindo elementos da árvore");
		exibirArvore(raiz);
	}
	
	private void exibirArvore(BinNo atual) {
		if(atual != null) {
			exibirArvore(atual.esq);
			System.out.println("Valor: " + atual.valor + " - Nível: " + atual.nivel);
			exibirArvore(atual.dir);
		}
	}
	
	public void preencherNiveis() {
	    preencherNiveisRecursivo(raiz, 0);
	}

	private void preencherNiveisRecursivo(BinNo atual, int nivel) {
	    if (atual != null) {
	        atual.nivel = nivel;
	        preencherNiveisRecursivo(atual.esq, nivel + 1);
	        preencherNiveisRecursivo(atual.dir, nivel + 1);
	    }
	}
	
	public int contarElementos() {
	    return contarElementosRec(raiz);
	}

	private int contarElementosRec(BinNo atual) {
	    if (atual == null) {
	        return 0;
	    }
	    return 1 + contarElementosRec(atual.esq) + contarElementosRec(atual.dir);
	}

	public int calcularAltura() {
	    return calcularAlturaRec(raiz);
	}

	private int calcularAlturaRec(BinNo atual) {
	    if (atual == null) {
	        return -1;
	    }
	    int alturaEsq = calcularAlturaRec(atual.esq);
	    int alturaDir = calcularAlturaRec(atual.dir);
	    return 1 + Math.max(alturaEsq, alturaDir);
	}
	
	public void preOrdem() { preOrdemRec(raiz); System.out.println(); }
	private void preOrdemRec(BinNo atual) {
	    if (atual != null) {
	        System.out.print(atual.valor + " ");
	        preOrdemRec(atual.esq);
	        preOrdemRec(atual.dir);
	    }
	}

	public void inOrdem() { inOrdemRec(raiz); System.out.println(); }
	private void inOrdemRec(BinNo atual) {
	    if (atual != null) {
	        inOrdemRec(atual.esq);
	        System.out.print(atual.valor + " ");
	        inOrdemRec(atual.dir);
	    }
	}

	public void posOrdem() { posOrdemRec(raiz); System.out.println(); }
	private void posOrdemRec(BinNo atual) {
	    if (atual != null) {
	        posOrdemRec(atual.esq);
	        posOrdemRec(atual.dir);
	        System.out.print(atual.valor + " ");
	    }
	}

	public void emNivel() {
	    if (raiz == null) return;
	    java.util.Queue<BinNo> fila = new java.util.LinkedList<>();
	    fila.add(raiz);
	    while (!fila.isEmpty()) {
	        BinNo atual = fila.poll();
	        System.out.print(atual.valor + " ");
	        if (atual.esq != null) fila.add(atual.esq);
	        if (atual.dir != null) fila.add(atual.dir);
	    }
	    System.out.println();
	}


}
