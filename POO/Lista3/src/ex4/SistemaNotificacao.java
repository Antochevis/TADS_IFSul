package ex4;

import java.util.ArrayList;

public class SistemaNotificacao {
	
	public static void main(String[] args) {
		
		ArrayList<Notificacao> notificacoes = new ArrayList<>();

        
        notificacoes.add(new EmailNotificacao("FYI", "Andrey", "andrey@teste.com"));
        notificacoes.add(new SmsNotificacao("Fut sexta?", "Lucas", "99999-9999"));

        
        for (Notificacao n : notificacoes) {
            n.enviar();
            System.out.println("---------");
        }

        //com assunto
        for (Notificacao n : notificacoes) {
            n.enviar("Nova notificação!");
            System.out.println("---------");
        }
		
	}
}
