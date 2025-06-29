package persistencia;

import conexao.ConexaoMySQL;
import model.ItemVenda;
import model.Produto;
import model.Venda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemVendaDAO {

    /* === CREATE === */
    public void salvar(ItemVenda item) throws SQLException {
        String sql = """
            INSERT INTO item_venda
                (venda_id, produto_id, quantidade, preco_unitario)
            VALUES (?,?,?,?)
        """;

        try (Connection c = ConexaoMySQL.getConexao();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt   (1, item.getVenda().getId());
            ps.setInt   (2, item.getProduto().getId());
            ps.setInt   (3, item.getQuantidade());
            ps.setDouble(4, item.getPrecoUnitario());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    item.setId(rs.getInt(1));
                }
            }
        }
    }

    /* === READ – listar itens de uma venda === */
    public List<ItemVenda> listarPorVenda(int idVenda) throws SQLException {
        List<ItemVenda> itens = new ArrayList<>();

        String sql = """
            SELECT iv.*, p.nome, p.tipo
            FROM item_venda iv
            JOIN produto p ON iv.produto_id = p.id
            WHERE iv.venda_id = ?
        """;

        try (Connection c = ConexaoMySQL.getConexao();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, idVenda);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // Monta objetos “placeholder” de Venda e Produto
                    Venda   venda   = new Venda();
                    venda.setId(idVenda);

                    Produto produto = new Produto();
                    produto.setId(rs.getInt("produto_id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setTipo(rs.getString("tipo"));

                    ItemVenda item = new ItemVenda(
                        rs.getInt("id"),
                        venda,
                        produto,
                        rs.getInt("quantidade"),
                        rs.getDouble("preco_unitario")
                    );
                    itens.add(item);
                }
            }
        }
        return itens;
    }

    /* === DELETE – remove todos os itens de uma venda (útil para rollback/atualização) === */
    public void excluirPorVenda(int idVenda) throws SQLException {
        String sql = "DELETE FROM item_venda WHERE venda_id = ?";

        try (Connection c = ConexaoMySQL.getConexao();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, idVenda);
            ps.executeUpdate();
        }
    }
}
