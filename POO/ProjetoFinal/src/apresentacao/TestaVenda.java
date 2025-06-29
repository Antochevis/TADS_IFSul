package apresentacao;

import model.*;
import persistencia.ClienteDAO;
import persistencia.VendaDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class TestaVenda {

    public static void main(String[] args) {

        ClienteDAO clienteDAO = new ClienteDAO();
        VendaDAO   vendaDAO   = new VendaDAO();

        try {
            /* --------- 1. cria e salva cliente PJ --------- */
            ClientePessoaJuridica cliente = new ClientePessoaJuridica(
                    "Cervejaria Teste Ltda",
                    "22333444000155",
                    "Av. Malte, 500",
                    "Joinville",
                    "SC",
                    "(47) 12345-6789"
            );
            clienteDAO.salvar(cliente);
            System.out.println("Cliente salvo com ID: " + cliente.getId());

            /* --------- 2. cria venda associada --------- */
            Venda venda = new Venda(
                    LocalDate.now(),
                    99.90,
                    "Cartão de Crédito",
                    cliente
            );
            vendaDAO.salvar(venda);
            System.out.println("Venda salva com ID: " + venda.getId());

            /* --------- 3. lista todas as vendas --------- */
            List<Venda> vendas = vendaDAO.listarTodos();
            System.out.println("\n=== Lista de vendas ===");
            for (Venda v : vendas) {
                Cliente c = v.getCliente();
                String nomeExibido = (c instanceof ClientePessoaFisica pf)
                        ? pf.getNome()
                        : ((ClientePessoaJuridica) c).getRazaoSocial();

                System.out.printf("ID: %d | Data: %s | Total: %.2f | Pagamento: %s | Cliente: %s%n",
                        v.getId(), v.getData(), v.getValorTotal(), v.getFormaPagamento(), nomeExibido);
            }

            /* --------- 4. busca venda por ID --------- */
            Venda buscada = vendaDAO.buscarPorId(venda.getId());
            String nomeCli = (buscada.getCliente() instanceof ClientePessoaFisica pf)
                    ? pf.getNome()
                    : ((ClientePessoaJuridica) buscada.getCliente()).getRazaoSocial();

            System.out.println("\nVenda buscada:");
            System.out.printf("ID: %d | Cliente: %s | Valor: %.2f%n",
                    buscada.getId(), nomeCli, buscada.getValorTotal());

            /* --------- 5. atualiza venda --------- */
            buscada.setFormaPagamento("PIX");
            vendaDAO.atualizar(buscada);
            System.out.println("Venda atualizada.");

            /* --------- 6. exclui venda e cliente --------- */
            vendaDAO.excluir(buscada.getId());
            System.out.println("Venda excluída.");
            clienteDAO.excluir(cliente.getId());
            System.out.println("Cliente excluído.");

        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
