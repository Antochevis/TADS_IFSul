package model;

public class ClientePessoaJuridica extends Cliente {
	
	private String razaoSocial;
	private String cnpj;

	public ClientePessoaJuridica() {
		super();
		this.razaoSocial = "";
		this.cnpj = "";
	}

	public ClientePessoaJuridica(String razaoSocial, String cnpj, String endereco, String cidade, String estado,
			String telefone) {
		super(endereco, cidade, estado, telefone);
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}

	@Override
	public String getDocumento() {
		return cnpj;
	}

	@Override
	public String getTipoCliente() {
		return "PJ";
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
