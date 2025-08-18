package model;

public abstract class Cliente {

	private int id;
	private String endereco;
	private String cidade;
	private String estado;
	private String telefone;

	public Cliente() {
		this.endereco = "";
		this.cidade = "";
		this.estado = "";
		this.telefone = "";
	}

	public Cliente(String endereco, String cidade, String estado, String telefone) {
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String e) {
		this.endereco = e;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String c) {
		this.cidade = c;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String e) {
		this.estado = e;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String t) {
		this.telefone = t;
	}

	public abstract String getDocumento();

	public abstract String getTipoCliente();
}
