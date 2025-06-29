package persistencia;

import conexao.ConexaoMySQL;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    /* === CREATE === */
    public void salvar(Cliente cli) throws SQLException {
        String sql = """
            INSERT INTO cliente
              (tipo_cliente, nome, cpf, razao_social, cnpj,
               endereco, cidade, estado, telefone)
            VALUES (?,?,?,?, ?,?,?,?,?)
        """;

        try (Connection c = ConexaoMySQL.getConexao();
             PreparedStatement ps =
                     c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            if (cli instanceof ClientePessoaFisica pf) {
                ps.setString(1, "PF");
                ps.setString(2, pf.getNome());
                ps.setString(3, pf.getCpf());
                ps.setNull  (4, Types.VARCHAR); // razao_social
                ps.setNull  (5, Types.VARCHAR); // cnpj
            } else if (cli instanceof ClientePessoaJuridica pj) {
                ps.setString(1, "PJ");
                ps.setNull  (2, Types.VARCHAR); // nome
                ps.setNull  (3, Types.VARCHAR); // cpf
                ps.setString(4, pj.getRazaoSocial());
                ps.setString(5, pj.getCnpj());
            }

            ps.setString(6, cli.getEndereco());
            ps.setString(7, cli.getCidade());
            ps.setString(8, cli.getEstado());
            ps.setString(9, cli.getTelefone());

            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) cli.setId(rs.getInt(1));
            }
        }
    }

    /* === READ — listar todos === */
    public List<Cliente> listarTodos() throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (Connection c = ConexaoMySQL.getConexao();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) lista.add(map(rs));
        }
        return lista;
    }

    /* === READ — buscar por ID === */
    public Cliente buscarPorId(int id) throws SQLException {
        try (Connection c = ConexaoMySQL.getConexao();
             PreparedStatement ps =
                     c.prepareStatement("SELECT * FROM cliente WHERE id = ?")) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? map(rs) : null;
            }
        }
    }

    /* === UPDATE === */
    public void atualizar(Cliente cli) throws SQLException {
        String sql = """
            UPDATE cliente
               SET tipo_cliente=?, nome=?, cpf=?, razao_social=?, cnpj=?,
                   endereco=?, cidade=?, estado=?, telefone=?
             WHERE id=?
        """;

        try (Connection c = ConexaoMySQL.getConexao();
             PreparedStatement ps = c.prepareStatement(sql)) {

            if (cli instanceof ClientePessoaFisica pf) {
                ps.setString(1, "PF");
                ps.setString(2, pf.getNome());
                ps.setString(3, pf.getCpf());
                ps.setNull  (4, Types.VARCHAR);
                ps.setNull  (5, Types.VARCHAR);
            } else {
                ClientePessoaJuridica pj = (ClientePessoaJuridica) cli;
                ps.setString(1, "PJ");
                ps.setNull  (2, Types.VARCHAR);
                ps.setNull  (3, Types.VARCHAR);
                ps.setString(4, pj.getRazaoSocial());
                ps.setString(5, pj.getCnpj());
            }

            ps.setString(6, cli.getEndereco());
            ps.setString(7, cli.getCidade());
            ps.setString(8, cli.getEstado());
            ps.setString(9, cli.getTelefone());
            ps.setInt   (10, cli.getId());

            ps.executeUpdate();
        }
    }

    /* === DELETE === */
    public void excluir(int id) throws SQLException {
        try (Connection c = ConexaoMySQL.getConexao();
             PreparedStatement ps =
                     c.prepareStatement("DELETE FROM cliente WHERE id = ?")) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    /* ----------- MÉTODO AUXILIAR --------------- */
    private Cliente map(ResultSet rs) throws SQLException {
        String tipo = rs.getString("tipo_cliente");
        Cliente cli;

        if ("PF".equals(tipo)) {
            cli = new ClientePessoaFisica(
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("endereco"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("telefone"));
        } else {                                     // PJ
            cli = new ClientePessoaJuridica(
                    rs.getString("razao_social"),
                    rs.getString("cnpj"),
                    rs.getString("endereco"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("telefone"));
        }
        cli.setId(rs.getInt("id"));
        return cli;
    }
}
