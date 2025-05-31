package ex2;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

	private String nome;
	private String cnpj;
	private String endereco;
	private List<Funcionario> funcionarios;
	
	public Empresa() {
		super();
		this.nome = "";
		this.cnpj  = "";
		this.endereco = "";
		funcionarios = new ArrayList<>();
	}

	public Empresa(String nome, String cnpj, String endereco, List<Funcionario> funcionarios) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.funcionarios = funcionarios;
	}

	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public void adicionarFuncionario(Funcionario f) {
        funcionarios.add(f);
        f.setEmpresa(this);
    }
	
	 public void imprimirDados() {
	        System.out.println("Empresa:");
	        System.out.println("  Nome: " + nome);
	        System.out.println("  CNPJ: " + cnpj);
	        System.out.println("  Endereço: " + endereco);
	        System.out.println("  Funcionários:");
	        for (Funcionario f : funcionarios) {
	            System.out.println("    - " + f.getNome());
	        }
	    }
}
