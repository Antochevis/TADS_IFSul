package persistencia;

import model.Cliente;
import model.ClientePessoaFisica;
import model.ClientePessoaJuridica;
import model.Venda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    private ConexaoMysql conexao;

    public VendaDAO() {
        this.conexao = new ConexaoMysql("localhost", "3306", "root", "root", "projetofinal");
    }

    // SALVAR
    public void salvar(Venda venda) {
        this.conexao.abrirConexao();
        String sql = "INSERT INTO venda (cliente_id, data, valor_total, forma_pagamento) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexao.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, venda.getCliente().getId());
            ps.setDate(2, Date.valueOf(venda.getData()));
            ps.setDouble(3, venda.getValorTotal());
            ps.setString(4, venda.getFormaPagamento());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                venda.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    // ATUALIZAR
    public void atualizar(Venda venda) {
        this.conexao.abrirConexao();
        String sql = "UPDATE venda SET data=?, valor_total=?, forma_pagamento=?, cliente_id=? WHERE id=?";

        try {
            PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
            ps.setDate(1, Date.valueOf(venda.getData()));
            ps.setDouble(2, venda.getValorTotal());
            ps.setString(3, venda.getFormaPagamento());
            ps.setInt(4, venda.getCliente().getId());
            ps.setInt(5, venda.getId());
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
        String sql = "DELETE FROM venda WHERE id=?";

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
    public Venda buscarPorId(int id) {
        Venda venda = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM venda v JOIN cliente c ON v.cliente_id = c.id WHERE v.id = ?";

        try {
            PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                venda = map(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return venda;
    }

    // BUSCAR TODOS
    public List<Venda> buscarTodos() {
        List<Venda> lista = new ArrayList<>();
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM venda v JOIN cliente c ON v.cliente_id = c.id";

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
    private Venda map(ResultSet rs) throws SQLException {
        Cliente cliente;
        String tipo = rs.getString("tipo_cliente");

        if ("PF".equals(tipo)) {
            cliente = new ClientePessoaFisica(
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("endereco"),
                rs.getString("cidade"),
                rs.getString("estado"),
                rs.getString("telefone"));
        } else {
            cliente = new ClientePessoaJuridica(
                rs.getString("razao_social"),
                rs.getString("cnpj"),
                rs.getString("endereco"),
                rs.getString("cidade"),
                rs.getString("estado"),
                rs.getString("telefone"));
        }

        cliente.setId(rs.getInt("cliente_id"));

        Venda venda = new Venda();
        venda.setId(rs.getInt("id"));
        venda.setData(rs.getDate("data").toLocalDate());
        venda.setValorTotal(rs.getDouble("valor_total"));
        venda.setFormaPagamento(rs.getString("forma_pagamento"));
        venda.setCliente(cliente);

        return venda;
    }
}
