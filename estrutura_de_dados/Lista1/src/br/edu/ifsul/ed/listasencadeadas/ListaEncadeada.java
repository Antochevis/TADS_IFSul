package br.edu.ifsul.ed.listasencadeadas;

public class ListaEncadeada {
	
	private Celula primeira;
	private Celula ultima;
	
	private int totalDeElementos;
	
	public void adiciona(Object elemento) {
		if (this.totalDeElementos == 0) {
			this.adicionaNoComeco(elemento);
		} else {
			Celula nova = new Celula(elemento);
			this.ultima.setProxima(nova);
			this.ultima = nova;
			this.totalDeElementos++;
		}
		
	}
	
	public void adiciona(int posicao, Object elemento) {
		
	}
	
	public Object pega(int posicao) {
		return null;
	}
	
	public void remove(int posicao) {
		
	}
	
	public int tamanho() {
		return 0;
	}
	
	public boolean contem(Object o) {
		return false;
	}
	
	public void adicionaNoComeco(Object elemento) {
		Celula nova = new Celula(this.primeira, elemento);
		this.primeira = nova;
		
		if(this.totalDeElementos == 0) {
			//caso especial da lista vazia
			this.ultima = this.primeira;
		}
		this.totalDeElementos++;
		
	}
	
	public void removeDoComeco() {
		
	}
	
	public void removeDoFim() {
		
	}

	
	public String toString() {
	   if(this.totalDeElementos == 0) {
		   return "[]";
	   }
	   
	   StringBuilder builder = new StringBuilder("[");
	   Celula atual = primeira;
	   
	   //percorrendo até o penúltimo elemento.
	   for (int i = 0; i < this.totalDeElementos - 1; i++) {
		   builder.append(atual.getElemento());
		   builder.append(", ");
		   atual = atual.getProxima();
	   }
	   //ultimo elemento
	   builder.append(atual.getElemento());
	   builder.append("]");
	   
	   return builder.toString();
	}
	
	

}
