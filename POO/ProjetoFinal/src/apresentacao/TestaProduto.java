package apresentacao;

import model.Produto;
import persistencia.ProdutoDAO;

import java.sql.SQLException;
import java.util.List;

public class TestaProduto {

    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();

        try {
            // Criar um novo produto
            Produto p = new Produto(0, "IPA", "Antochevis IPA", 15.99, 50);

            // Salvar no banco (INSERT)
            dao.salvar(p);
            System.out.println("Produto salvo com ID: " + p.getId());

            // Listar todos os produtos e imprimir no console
            List<Produto> produtos = dao.listarTodos();
            System.out.println("=== Lista de produtos ===");
            for (Produto produto : produtos) {
                System.out.printf("ID: %d | Tipo: %s | Nome: %s | Preço: %.2f | Estoque: %d%n",
                        produto.getId(), produto.getTipo(), produto.getNome(),
                        produto.getPreco(), produto.getEstoque());
            }

            // Atualizar o produto
            p.setPreco(16.99);
            p.setEstoque(45);
            dao.atualizar(p);
            System.out.println("Produto atualizado.");

            // Buscar produto por ID
            Produto buscado = dao.buscarPorId(p.getId());
            System.out.println("Produto buscado por ID:");
            System.out.printf("ID: %d | Tipo: %s | Nome: %s | Preço: %.2f | Estoque: %d%n",
                    buscado.getId(), buscado.getTipo(), buscado.getNome(),
                    buscado.getPreco(), buscado.getEstoque());

            // Excluir produto
            dao.excluir(p.getId());
            System.out.println("Produto excluído.");

        } catch (SQLException e) {
            System.err.println("Erro ao acessar banco: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
