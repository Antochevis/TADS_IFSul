package br.edu.ifsul.ed.conjuntos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConjuntoEspalhamentoGenerico {
	
	private List<List<Object>> tabela = new ArrayList<List<Object>>();
	
	private int tamanho = 0;
	public ConjuntoEspalhamentoGenerico() {
		for(int i = 0; i < 26; i++) {
			LinkedList<Object> lista = new LinkedList<Object>();
			tabela.add(lista);
		}
	}
	
	public void adiciona(Object objeto) {
		if(!this.contem(objeto)) {
			this.verificaCarga();
			int indice = this.calculaIndiceDaTabela(objeto);
			List<Object> lista = this.tabela.get(indice);
			lista.add(objeto);
			this.tamanho++;
		}
	}
	
	public void remove(Object objeto) {
		if(this.contem(objeto)) {
			int indice = this.calculaIndiceDaTabela(objeto);
			List<Object> lista = this.tabela.get(indice);
			lista.remove(objeto);
			this.tamanho-;
			this.verificaCarga();
		}
	}
	
	//classe incompleta
	
	
	private int calculaIndiceDaTabela(Object objeto) {
		int codigoDeEspalhamento = objeto.hashCode();
		codigoDeEspalhamento = Math.abs(codigoDeEspalhamento);
		return codigoDeEspalhamento % this.tabela.size();
	}
}
