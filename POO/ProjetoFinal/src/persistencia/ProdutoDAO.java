package persistencia;

import model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private ConexaoMysql conexao;

    public ProdutoDAO() {
        this.conexao = new ConexaoMysql("localhost", "3306", "root", "root", "projetofinal");
    }

    // SALVAR
    public void salvar(Produto produto) {
        this.conexao.abrirConexao();
        String sql = "INSERT INTO produto VALUES (null, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexao.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, produto.getTipo());
            ps.setString(2, produto.getNome());
            ps.setDouble(3, produto.getPreco());
            ps.setInt(4, produto.getEstoque());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                produto.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    // ATUALIZAR
    public void atualizar(Produto produto) {
        this.conexao.abrirConexao();
        String sql = "UPDATE produto SET tipo=?, nome=?, preco=?, estoque=? WHERE id=?";

        try {
            PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
            ps.setString(1, produto.getTipo());
            ps.setString(2, produto.getNome());
            ps.setDouble(3, produto.getPreco());
            ps.setInt(4, produto.getEstoque());
            ps.setInt(5, produto.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    // EXCLUIR
    public void excluir(int id) {
        this.conexao.abrirConexao();
        String sql = "DELETE FROM produto WHERE id=?";

        try {
            PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    // BUSCAR POR ID
    public Produto buscarPorId(int id) {
        Produto produto = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM produto WHERE id=?";

        try {
            PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                produto = map(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return produto;
    }

    // BUSCAR TODOS
    public List<Produto> buscarTodos() {
        List<Produto> lista = new ArrayList<>();
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM produto";

        try {
            PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(map(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return lista;
    }

    // MAP
    private Produto map(ResultSet rs) throws SQLException {
        Produto p = new Produto();
        p.setId(rs.getInt("id"));
        p.setTipo(rs.getString("tipo"));
        p.setNome(rs.getString("nome"));
        p.setPreco(rs.getDouble("preco"));
        p.setEstoque(rs.getInt("estoque"));
        return p;
    }
}
