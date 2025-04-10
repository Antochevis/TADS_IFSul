package ex4;

public class SmsNotificacao extends Notificacao {
	
	protected String numeroTelefone;

	public SmsNotificacao() {
		super();
		this.numeroTelefone = "";
	}

	public SmsNotificacao(String mensagem, String destinatario, String numeroTelefone) {
		super(mensagem, destinatario);
		this.numeroTelefone = numeroTelefone;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}
	
	@Override
	public void enviar() {
		System.out.println("Número de telefone: " + numeroTelefone);
		super.enviar();
	}
}
