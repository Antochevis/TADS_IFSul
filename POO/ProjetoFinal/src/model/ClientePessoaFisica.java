package model;

public class ClientePessoaFisica extends Cliente {
	
	private String nome;
	private String cpf;

	public ClientePessoaFisica() {
		super();
		this.nome = "";
		this.cpf = "";
	}

	public ClientePessoaFisica(String nome, String cpf, String endereco, String cidade, String estado,
			String telefone) {
		super(endereco, cidade, estado, telefone);
		this.nome = nome;
		this.cpf = cpf;
	}

	@Override
	public String getDocumento() {
		return cpf;
	}

	@Override
	public String getTipoCliente() {
		return "PF";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
