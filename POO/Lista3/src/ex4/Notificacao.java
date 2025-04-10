package ex4;

public class Notificacao {
	
	protected String mensagem, destinatario;

	public Notificacao() {
		super();
		this.mensagem = "";
		this.destinatario = "";
	}

	public Notificacao(String mensagem, String destinatario) {
		super();
		this.mensagem = mensagem;
		this.destinatario = destinatario;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	
	public void enviar() {
		System.out.println("Destinatário: " + destinatario);
		System.out.println("Mensagem: " + mensagem);
	}
	
	public void enviar(String assunto) {
		System.out.println("Assunto: " + assunto);
		enviar();
	}
}
