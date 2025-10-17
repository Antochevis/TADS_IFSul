package br.edu.ifsul.ed.mapas;

public class TesteTempoMapaEspelhamento {

	public static void main(String[] args) {

		MapaEspalhamento mapaEspalhamento = new MapaEspalhamento();
		int numeroDeElementos = 15000;

		long inicio = System.currentTimeMillis();

		for (int i = 0; i < numeroDeElementos; i++) {
			mapaEspalhamento.adiciona("" + i, new Carro("c" + i));
		}

		for (int i = 0; i < numeroDeElementos; i++) {
			mapaEspalhamento.pega("" + i);
		}

		for (int i = 0; i < numeroDeElementos; i++) {
			mapaEspalhamento.contemChave("" + i);
		}

		for (int i = 0; i < numeroDeElementos; i++) {
			mapaEspalhamento.remove("" + i);
		}

		long fim = System.currentTimeMillis();

		System.out.println("Tempo: " + (fim - inicio) / 1000.0);
	}
}
