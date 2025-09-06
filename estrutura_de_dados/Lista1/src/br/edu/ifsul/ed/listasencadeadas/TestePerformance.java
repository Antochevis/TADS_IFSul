package br.edu.ifsul.ed.listasencadeadas;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestePerformance {
	public static void main(String[] args) {

		ArrayList<String> vetor = new ArrayList<String>();
		LinkedList<String> lista = new LinkedList<String>();
		int numeroDeElementos = 40000;

		// Adicionando no começo
		for (int i = 0; i < numeroDeElementos; i++) {
			vetor.add(0, "Elemento " + i);
		}

		for (int i = 0; i < numeroDeElementos; i++) {
			lista.addFirst("Elemento " + i);
		}

		// Percorrendo
		for (int i = 0; i < vetor.size(); i++) {
			vetor.get(i);
		}

		for (int i = 0; i < lista.size(); i++) {
			lista.get(i);
		}

		// Removendo do começo
		while (!vetor.isEmpty()) {
			vetor.remove(0);
		}

		while (!lista.isEmpty()) {
			lista.removeFirst();
		}

	}
}
