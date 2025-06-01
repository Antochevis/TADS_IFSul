package ex6;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String numero;
    private String data;
    private String cliente;
    private List<ItemPedido> itens;

    public Pedido() {
        super();
        this.numero = "";
        this.data = "";
        this.cliente = "";
        this.itens = new ArrayList<>();
    }

    public Pedido(String numero, String data, String cliente) {
        super();
        this.numero = numero;
        this.data = data;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public String getData() {
        return data;
    }

    public String getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public void adicionarItem(ItemPedido item) {
        if (!itens.contains(item)) {
            itens.add(item);
            item.setPedido(this); // associação bidirecional
        }
    }

    public String imprimirDados() {
        return "Pedido " + numero + " - Data: " + data + " - Cliente: " + cliente;
    }
}
