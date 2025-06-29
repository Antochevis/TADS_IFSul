package apresentacao;

import model.*;
import persistencia.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class TestaItemVenda {

    public static void main(String[] args) {

        ClienteDAO   clienteDAO   = new ClienteDAO();
        ProdutoDAO   produtoDAO   = new ProdutoDAO();
        VendaDAO     vendaDAO     = new VendaDAO();
        ItemVendaDAO itemDAO      = new ItemVendaDAO();

        try {
            /* ---------- 1. cria e salva cliente PJ ---------- */
            ClientePessoaJuridica cliente = new ClientePessoaJuridica(
                    "Cervejaria Exemplo Ltda",
                    "11222333000144",
                    "Rua Cerveja, 10",
                    "Florianópolis",
                    "SC",
                    "(48) 3333-4444"
            );
            clienteDAO.salvar(cliente);

            /* ---------- 2. cria e salva produto ---------- */
            Produto produto = new Produto("IPA", "IPA Cheirosa", 18.90, 200);
            produtoDAO.salvar(produto);

            /* ---------- 3. cria e salva venda ---------- */
            Venda venda = new Venda(LocalDate.now(), 0.0, "PIX", cliente);
            vendaDAO.salvar(venda);

            /* ---------- 4. insere item de venda ---------- */
            ItemVenda item = new ItemVenda(venda, produto, 3, produto.getPreco());
            itemDAO.salvar(item);

            /* atualiza total da venda */
            double total = item.getQuantidade() * item.getPrecoUnitario();
            venda.setValorTotal(total);
            vendaDAO.atualizar(venda);

            /* ---------- 5. lista itens da venda ---------- */
            List<ItemVenda> itens = itemDAO.listarPorVenda(venda.getId());
            System.out.println("\n=== Itens da venda ===");
            for (ItemVenda iv : itens) {
                System.out.printf("Item %d | Produto: %s | Qtde: %d | Preço: %.2f%n",
                        iv.getId(), iv.getProduto().getNome(),
                        iv.getQuantidade(), iv.getPrecoUnitario());
            }

            /* ---------- limpeza opcional ---------- */
            // itemDAO.excluirPorVenda(venda.getId());
            // vendaDAO.excluir(venda.getId());
            // produtoDAO.excluir(produto.getId());
            // clienteDAO.excluir(cliente.getId());

        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
