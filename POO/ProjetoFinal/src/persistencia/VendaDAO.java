package persistencia;

import conexao.ConexaoMySQL;
import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    /* === CREATE === */
    public void salvar(Venda venda) throws SQLException {
        String sql = """
            INSERT INTO venda (data, valor_total, forma_pagamento, cliente_id)
            VALUES (?,?,?,?)
        """;

        try (Connection c = ConexaoMySQL.getConexao();
             PreparedStatement ps =
                     c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setDate  (1, Date.valueOf(venda.getData()));
            ps.setDouble(2, venda.getValorTotal());
            ps.setString(3, venda.getFormaPagamento());
            ps.setInt   (4, venda.getCliente().getId());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) venda.setId(rs.getInt(1));
            }
        }
    }

    /* === READ — listar todas as vendas === */
    public List<Venda> listarTodos() throws SQLException {
        String sql = """
            SELECT v.*, c.*
            FROM venda v
            JOIN cliente c ON v.cliente_id = c.id
        """;

        List<Venda> lista = new ArrayList<>();

        try (Connection c = ConexaoMySQL.getConexao();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente cli = mapCliente(rs);
                Venda   ven = mapVenda(rs, cli);
                lista.add(ven);
            }
        }
        return lista;
    }

    /* === READ — buscar 1 venda por ID === */
    public Venda buscarPorId(int id) throws SQLException {
        String sql = """
            SELECT v.*, c.*
            FROM venda v
            JOIN cliente c ON v.cliente_id = c.id
            WHERE v.id = ?
        """;

        try (Connection c = ConexaoMySQL.getConexao();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cliente cli = mapCliente(rs);
                    return mapVenda(rs, cli);
                }
            }
        }
        return null;
    }

    /* === UPDATE === */
    public void atualizar(Venda venda) throws SQLException {
        String sql = """
            UPDATE venda
            SET data = ?, valor_total = ?, forma_pagamento = ?, cliente_id = ?
            WHERE id = ?
        """;

        try (Connection c = ConexaoMySQL.getConexao();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setDate  (1, Date.valueOf(venda.getData()));
            ps.setDouble(2, venda.getValorTotal());
            ps.setString(3, venda.getFormaPagamento());
            ps.setInt   (4, venda.getCliente().getId());
            ps.setInt   (5, venda.getId());
            ps.executeUpdate();
        }
    }

    /* === DELETE === */
    public void excluir(int id) throws SQLException {
        try (Connection c = ConexaoMySQL.getConexao();
             PreparedStatement ps =
                     c.prepareStatement("DELETE FROM venda WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    /* ------------------------------------------------------------------ */
    /* ------------------- MÉTODOS AUXILIARES PRIVADOS ------------------ */
    /* ------------------------------------------------------------------ */

    /** Constrói o objeto Cliente correto (PF ou PJ) a partir do ResultSet */
    private Cliente mapCliente(ResultSet rs) throws SQLException {
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
        } else {                                    // PJ
            cli = new ClientePessoaJuridica(
                    rs.getString("razao_social"),
                    rs.getString("cnpj"),
                    rs.getString("endereco"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("telefone"));
        }
        cli.setId(rs.getInt("cliente_id"));
        return cli;
    }

    /** Constrói o objeto Venda usando as colunas do ResultSet */
    private Venda mapVenda(ResultSet rs, Cliente cli) throws SQLException {
        return new Venda(
                rs.getInt("id"),
                rs.getDate("data").toLocalDate(),
                rs.getDouble("valor_total"),
                rs.getString("forma_pagamento"),
                cli
        );
    }
}
