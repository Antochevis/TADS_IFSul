package ex4;

public class EmailNotificacao extends Notificacao {
	
	protected String enderecoEmail;

	public EmailNotificacao() {
		super();
		this.enderecoEmail = "";
	}

	public EmailNotificacao(String mensagem, String destinatario, String enderecoEmail) {
		super(mensagem, destinatario);
		this.enderecoEmail = enderecoEmail;
	}

	public String getEnderecoEmail() {
		return enderecoEmail;
	}

	public void setEnderecoEmail(String enderecoEmail) {
		this.enderecoEmail = enderecoEmail;
	}
	
	@Override
	public void enviar() {
		System.out.println("Endereço de e-mail: " + enderecoEmail);
		super.enviar();
	}
	
	public void enviar(String assunto) {
		System.out.println("Assunto: " + assunto);
		enviar();
	}
	
}
