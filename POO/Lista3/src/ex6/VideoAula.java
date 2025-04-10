package ex6;

public class VideoAula extends Conteudo {
	
	protected int duracao;

	public VideoAula() {
		super();
		this.duracao = 0;
	}

	public VideoAula(String titulo, String descricao, int duracao) {
		super(titulo, descricao);
		this.duracao = duracao;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	@Override
	public void exibirDetalhes() {
		super.exibirDetalhes();
		System.out.println("Duração: " + duracao + " minutos.");
	}
}
