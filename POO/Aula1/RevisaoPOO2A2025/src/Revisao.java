import java.util.ArrayList;

public class Revisao {

	public static void main(String[] args) {

//		// declara uma variavel inteira
//		int numero;
//		double numero2;
//		float numero3;
//		String nome;
//		char letra;
//		Revisao rev;
//		
//		Double numero4;
//		Float numero5;
//		Integer numero6;
//		
//		numero = 2;
//		numero2 = 2.0;
//		numero3 = (float)2.0;
//		
//		System.out.println("Olá");
//		
//		Scanner teclado = new Scanner(System.in);
//		teclado.nextInt();
		
//		imprimeMedia(2.0, 5.0);
//		
//		double media = calculaMedia(2.0, 5.0);
//		
//		System.out.println("Com retorno"+media);
		
//		String[] vet = new String[5];
//		
//		// atribuindo um valor para o vetor
//		vet[0] = "Lívia";
//		vet[1] = "Cristian";
//		vet[2] = "Renan";
//		
//		for(int i=0; i<vet.length;i++) {
//			System.out.println(vet[i]);
//		}
		
//		ArrayList<String> lista = new ArrayList<>();
		
		// declarando o objeto lista
		ArrayList<String> lista;
		// instanciando o objeto lista
		// chama o construtor da classe
		// aloca memoria ram
		lista = new ArrayList<>();
//		vet[0] = "Lívia";
		lista.add("Lívia");
//		vet[1] = "Cristian";
		lista.add("Cristian");
//		vet[2] = "Renan";
		lista.add("Renan");
		
//		System.out.println(lista.get(1));
//		
//		lista.set(1, "Cristian Remor");
//		
//		System.out.println(lista.get(1));
		
		for(int i = 0; i<lista.size();i++) {
			System.out.println(lista.get(i));
		}
		System.out.println("===========");
		for(String elemento:lista) {
			System.out.println(elemento);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	public static void imprimeMedia(double n1, double n2) {
		double media = (n1+n2)/2.0;
		System.out.println(media);
	}
	
	public static double calculaMedia(double n1, double n2) {
		double media = (n1+n2)/2.0;
		return media;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
