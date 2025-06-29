package model;

public abstract class Cliente {

    private int id;
    private String endereco;
    private String cidade;
    private String estado;
    private String telefone;

    public Cliente() { }

    public Cliente(String endereco, String cidade, String estado, String telefone) {
        this.endereco = endereco;
        this.cidade   = cidade;
        this.estado   = estado;
        this.telefone = telefone;
    }

    /* — MÉTODOS COMUNS — */
    public int getId()                   { return id; }
    public void setId(int id)            { this.id = id; }

    public String getEndereco()          { return endereco; }
    public void setEndereco(String e)    { this.endereco = e; }

    public String getCidade()            { return cidade; }
    public void setCidade(String c)      { this.cidade = c; }

    public String getEstado()            { return estado; }
    public void setEstado(String e)      { this.estado = e; }

    public String getTelefone()          { return telefone; }
    public void setTelefone(String t)    { this.telefone = t; }

    /* — MÉTODOS ESPECÍFICOS A SEREM IMPLEMENTADOS NAS SUBCLASSES — */
    public abstract String getDocumento();     // CPF ou CNPJ
    public abstract String getTipoCliente();   // “PF” ou “PJ”
}
