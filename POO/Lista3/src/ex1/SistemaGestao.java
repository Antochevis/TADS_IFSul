package ex1;

public class SistemaGestao {
	
	public static void main(String[] args) {
		
		Funcionario funcionarioA = new Gerente("João Gerente", 10000.0, "Gerente de TI", "Tecnologia");
		funcionarioA.exibirInformacoes();
        
        System.out.println("--------------------------------------------------------");
        
        Funcionario funcionarioB = new Vendedor ("João Vendedor", 3000.0, "Vendedor", "CRM", 30000.0);
        funcionarioB.exibirInformacoes();        
    }

}
