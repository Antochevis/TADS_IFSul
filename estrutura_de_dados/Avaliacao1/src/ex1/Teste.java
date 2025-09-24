package ex1;

import java.util.ArrayList;
import java.util.List;

public class Teste {
	public static void main(String[] args) {
		
        List<Funcionario> funcionarios = new ArrayList<>();
        
        funcionarios.add(new Funcionario("Ismael", "PO"));
        funcionarios.add(new Funcionario("Rafa", "PO"));
        funcionarios.add(new Funcionario("Denis", "Backend"));
        funcionarios.add(new Funcionario("João", "Frontend"));
        funcionarios.add(new Funcionario("Mauricio", "Frontend"));
        funcionarios.add(new Funcionario("Luis", "Backend"));
        funcionarios.add(new Funcionario("Rochet", "Backend"));
        funcionarios.add(new Funcionario("Borré", "Frontend"));
        funcionarios.add(new Funcionario("Carbonero", "Frontend"));

        List<Funcionario> po = new ArrayList<>();
        List<Funcionario> backend = new ArrayList<>();
        List<Funcionario> frontend = new ArrayList<>();

        for (Funcionario f : funcionarios) {
            switch (f.getCargo()) {
                case "PO":
                    po.add(f);
                    break;
                case "Backend":
                    backend.add(f);
                    break;
                case "Frontend":
                	frontend.add(f);
                    break;
                default:
                    break;
            }
        }
        
        for (Funcionario f : po) {
            System.out.println(f);
        }

        for (Funcionario f : backend) {
            System.out.println(f);
        }

        for (Funcionario f : frontend) {
            System.out.println(f);
        }
	}
}
