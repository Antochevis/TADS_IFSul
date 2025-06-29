package persistencia;

import model.Produto;
import conexao.ConexaoMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    /* === CREATE === */
    public void salvar(Produto p) throws SQLException {
        String sql = "INSERT INTO produto (tipo, nome, preco, estoque) VALUES (?,?,?,?)";

        try (Connection c = ConexaoMySQL.getConexao();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, p.getTipo());
            ps.setString(2, p.getNome());
            ps.setDouble(3, p.getPreco());
            ps.setInt   (4, p.getEstoque());

            ps.executeUpdate();

            // pega o id gerado pelo AUTO_INCREMENT
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    p.setId(rs.getInt(1));
                }
            }
        }
    }

    /* === READ (listar todos) === */
    public List<Produto> listarTodos() throws SQLException {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto";

        try (Connection c = ConexaoMySQL.getConexao();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Produto p = new Produto(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("estoque")
                );
                lista.add(p);
            }
        }
        return lista;
    }

    /* === READ (buscar por ID) === */
    public Produto buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM produto WHERE id = ?";
        try (Connection c = ConexaoMySQL.getConexao();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Produto(
                            rs.getInt("id"),
                            rs.getString("tipo"),
                            rs.getString("nome"),
                            rs.getDouble("preco"),
                            rs.getInt("estoque")
                    );
                }
            }
        }
        return null; // não encontrado
    }

    /* === UPDATE === */
    public void atualizar(Produto p) throws SQLException {
        String sql = "UPDATE produto SET tipo=?, nome=?, preco=?, estoque=? WHERE id=?";

        try (Connection c = ConexaoMySQL.getConexao();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, p.getTipo());
            ps.setString(2, p.getNome());
            ps.setDouble(3, p.getPreco());
            ps.setInt   (4, p.getEstoque());
            ps.setInt   (5, p.getId());

            ps.executeUpdate();
        }
    }

    /* === DELETE === */
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM produto WHERE id = ?";

        try (Connection c = ConexaoMySQL.getConexao();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}

