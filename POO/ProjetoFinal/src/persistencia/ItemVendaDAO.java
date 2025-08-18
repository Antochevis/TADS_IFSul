package persistencia;

import model.ItemVenda;
import model.Produto;
import model.Venda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemVendaDAO {

    private ConexaoMysql conexao;

    public ItemVendaDAO() {
        this.conexao = new ConexaoMysql("localhost", "3306", "root", "root", "projetofinal");
    }

    // SALVAR
    public void salvar(ItemVenda item) {
        this.conexao.abrirConexao();
        String sql = "INSERT INTO item_venda VALUES (null, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexao.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, item.getVenda().getId());
            ps.setInt(2, item.getProduto().getId());
            ps.setInt(3, item.getQuantidade());
            ps.setDouble(4, item.getPrecoUnitario());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                item.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    // EXCLUIR POR VENDA
    public void excluirPorVenda(int idVenda) {
        this.conexao.abrirConexao();
        String sql = "DELETE FROM item_venda WHERE venda_id=?";

        try {
            PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idVenda);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    // BUSCAR
    public List<ItemVenda> buscarPorVenda(int idVenda) {
        List<ItemVenda> lista = new ArrayList<>();
        this.conexao.abrirConexao();
        String sql = "SELECT iv.*, p.nome, p.tipo, p.preco, p.estoque FROM item_venda iv JOIN produto p ON iv.produto_id = p.id WHERE iv.venda_id = ?";

        try {
            PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idVenda);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(map(rs, idVenda));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return lista;
    }

    // MAP
    private ItemVenda map(ResultSet rs, int idVenda) throws SQLException {
        Produto produto = new Produto();
        produto.setId(rs.getInt("produto_id"));
        produto.setNome(rs.getString("nome"));
        produto.setTipo(rs.getString("tipo"));
        produto.setPreco(rs.getDouble("preco"));
        produto.setEstoque(rs.getInt("estoque"));

        Venda venda = new Venda();
        venda.setId(idVenda);

        ItemVenda item = new ItemVenda();
        item.setId(rs.getInt("id"));
        item.setVenda(venda);
        item.setProduto(produto);
        item.setQuantidade(rs.getInt("quantidade"));
        item.setPrecoUnitario(rs.getDouble("preco_unitario"));

        return item;
    }
}
