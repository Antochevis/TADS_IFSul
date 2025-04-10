package ex6;

public class Conteudo {
	
	protected String titulo, descricao;

	public Conteudo() {
		super();
		this.titulo = "";
		this.descricao = "";
	}

	public Conteudo(String titulo, String descricao) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void exibirDetalhes() {
		System.out.println("Título: " + titulo);
		System.out.println("Descrição: " + descricao);
	}
	
	public void exibirDetalhes(boolean comResumo) {
		
		if(comResumo) {
			System.out.println("Descrição: " + descricao);
		} else {
			exibirDetalhes();
		}
		
	}
}
