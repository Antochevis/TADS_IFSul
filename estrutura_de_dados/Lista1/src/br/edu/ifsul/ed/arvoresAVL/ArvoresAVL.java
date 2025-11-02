package br.edu.ifsul.ed.arvoresAVL;

public class ArvoresAVL {
	
	public static class ARVORE {
		public int num;
		public int alte, altd;
		public ARVORE esq, dir;
	}
	
	public static void atualizarAlturas(ARVORE node) {
		if(node != null) {
			node.alte = (node.esq == null) ? 0 : Math.max(node.esq.alte, node.esq.altd) + 1;
			node.altd = (node.dir == null) ? 0 : Math.max(node.dir.alte, node.dir.altd) + 1;
		}
	}
	
	public static ARVORE inserir(ARVORE aux, int num) {
		if(aux == null) {
			ARVORE novo = new ARVORE();
			novo.num = num;
			novo.alte = 0;
			novo.altd = 0;
			novo.esq = null;
			novo.dir = null;
			return novo;
		}
		
		if(num < aux.num) {
			aux.esq = inserir(aux.esq, num);
		} else {
			aux.dir = inserir(aux.dir, num);
		}
		
		atualizarAlturas(aux);
		return balanceamento(aux);
	}
	
	public static ARVORE remover(ARVORE aux, int num) {
	    if (aux == null) return null;

	    if (num < aux.num) {
	        aux.esq = remover(aux.esq, num);
	    } else if (num > aux.num) {
	        aux.dir = remover(aux.dir, num);
	    } else {
	        if (aux.esq == null && aux.dir == null) {
	            return null;
	        } else if (aux.esq == null) {
	            return aux.dir;
	        } else if (aux.dir == null) {
	            return aux.esq;
	        } else {
	            ARVORE temp = minValueNode(aux.dir);
	            aux.num = temp.num;
	            aux.dir = remover(aux.dir, temp.num);
	        }
	    }

	    atualizarAlturas(aux);
	    return balanceamento(aux);
	}

	
	public static ARVORE minValueNode(ARVORE node) {
		while (node.esq != null) {
			node = node.esq;
		}
		return node;
	}
	
	public static boolean consultar(ARVORE aux, int num) {
		if (aux == null) return false;
		if (aux.num == num) return true;
		return (num < aux.num) ? consultar(aux.esq, num) : consultar(aux.dir, num);
	}
	
	public static void mostrarpreordem(ARVORE aux) {
		if (aux != null) {
			System.out.println(aux.num + " ");
			mostrarpreordem(aux.esq);
			mostrarpreordem(aux.dir);
		}
	}
	
	public static void mostraremordem(ARVORE aux) {
		if (aux != null) {
			mostraremordem(aux.esq);
			System.out.println(aux.num + " ");
			mostraremordem(aux.dir);
		}
	}
	
	public static void mostrarposordem(ARVORE aux) {
		if (aux != null) {
			mostrarposordem(aux.esq);
			mostrarposordem(aux.dir);
			System.out.println(aux.num + " ");
		}
	}
	
	public static ARVORE rotacao_esquerda(ARVORE aux) {
		ARVORE aux1 = aux.dir;
		aux.dir = aux1.esq;
		aux1.esq = aux;
		
		atualizarAlturas(aux);
		atualizarAlturas(aux1);
		return aux1;
	}
	
	public static ARVORE rotacao_direita(ARVORE aux) {
		ARVORE aux1 = aux.esq;
		aux.esq = aux1.dir;
		aux1.dir = aux;
		
		atualizarAlturas(aux);
		atualizarAlturas(aux1);
		return aux1;
	}
	
	public static ARVORE balanceamento(ARVORE aux) {
		int fator = aux.altd - aux.alte;
		
		if(fator == 2) {
			int df = (aux.dir != null) ? aux.dir.altd - aux.dir.alte : 0;
			if(df >= 0) {
				aux = rotacao_esquerda(aux);
			} else {
				aux.dir = rotacao_direita(aux.dir);
				aux = rotacao_esquerda(aux);
			}
		} else if (fator == -2) {
			int df = (aux.esq != null) ? aux.esq.altd - aux.esq.alte : 0;
			if(df <= 0) {
				aux = rotacao_direita(aux);
			} else {
				aux.esq = rotacao_esquerda(aux.esq);
				aux = rotacao_direita(aux);
			}
		}
		return aux;
	}
}
