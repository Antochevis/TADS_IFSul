package ex6;

public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private Pedido pedido;

    public ItemPedido() {
        super();
        this.produto = null;
        this.quantidade = 0;
        this.pedido = null;
    }

    public ItemPedido(Produto produto, int quantidade) {
        super();
        this.produto = produto;
        this.quantidade = quantidade;
        this.pedido = null;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public double calcularTotal() {
        return produto.getPreco() * quantidade;
    }

    public String imprimirDados() {
        return produto.getNome() + " - Quantidade: " + quantidade + " - Total: R$" + calcularTotal();
    }
}
