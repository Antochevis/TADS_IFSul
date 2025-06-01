package ex6;

public class Main {
    public static void main(String[] args) {
    	
        Produto p1 = new Produto("Notebook", 3500.99, "N001");
        Produto p2 = new Produto("Mouse", 100.99, "M001");

        Pedido pedido = new Pedido("001", "31/05/2025", "Remor");

        ItemPedido item1 = new ItemPedido(p1, 1);
        ItemPedido item2 = new ItemPedido(p2, 2);

        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);

        System.out.println(pedido.imprimirDados());
        System.out.println("Itens:");
        for (ItemPedido item : pedido.getItens()) {
            System.out.println(item.imprimirDados());
        }
    }
}
