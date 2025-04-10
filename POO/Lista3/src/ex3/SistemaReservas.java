package ex3;

public class SistemaReservas {

	public static void main(String[] args) {

		QuartoSimples quartoSimples = new QuartoSimples(1, 100.0, "Quarto imples", 2);
		quartoSimples.exibirInformacoes(true);
		System.out.println("Total para 3 noites: R$ " + quartoSimples.calcularDiaria(3));
		
		System.out.println("------------------------------");
		
		Suite suite = new Suite(2, 200.0, "Suíte", "Hidromassagem");
		suite.exibirInformacoes(false);
		System.out.println("Total para 3 noites: R$" + suite.calcularDiaria(3));
	}

}
