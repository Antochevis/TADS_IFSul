package ex2;

public class Lista {
	int id;
    int idDoAnterior;
    int idDoSeguinte;
    String conteudo;
    
	public Lista(int id, int idDoAnterior, int idDoSeguinte, String conteudo) {
		super();
		this.id = id;
		this.idDoAnterior = idDoAnterior;
		this.idDoSeguinte = idDoSeguinte;
		this.conteudo = conteudo;
	}

	public int getId() {
		return id;
	}

	public int getIdDoAnterior() {
		return idDoAnterior;
	}

	public int getIdDoSeguinte() {
		return idDoSeguinte;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdDoAnterior(int idDoAnterior) {
		this.idDoAnterior = idDoAnterior;
	}

	public void setIdDoSeguinte(int idDoSeguinte) {
		this.idDoSeguinte = idDoSeguinte;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	@Override
    public String toString() {
        return conteudo;
    }
   
}
