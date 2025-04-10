package ex6;

public class SistemaConteudo {
	
	public static void main(String[] args) {
		
		VideoAula videoAula = new VideoAula("Vídeo Aula", "Aula 1 de Java", 15);
		videoAula.exibirDetalhes();
		System.out.println("--------------");
		videoAula.exibirDetalhes(true);
		
		System.out.println("--------------");
		
		Artigo artigo = new Artigo("Scrum", "Guia do Scrum", 10);
		artigo.exibirDetalhes();
		System.out.println("--------------");
		artigo.exibirDetalhes(true);
		
	}
}
