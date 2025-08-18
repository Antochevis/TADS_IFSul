package persistencia;

import model.Cliente;
import model.ClientePessoaFisica;
import model.ClientePessoaJuridica;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private ConexaoMysql conexao;

    public ClienteDAO() {
        this.conexao = new ConexaoMysql("localhost", "3306", "root", "root", "projetofinal");
    }

    // SALVAR
    public void salvar(Cliente cliente) {
        conexao.abrirConexao();
        String sql = "INSERT INTO cliente (tipo_cliente, nome, cpf, razao_social, cnpj, endereco, cidade, estado, telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexao.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            if (cliente instanceof ClientePessoaFisica pf) {
                ps.setString(1, "PF");
                ps.setString(2, pf.getNome());
                ps.setString(3, pf.getCpf());
                ps.setNull(4, Types.VARCHAR);
                ps.setNull(5, Types.VARCHAR);
            } else if (cliente instanceof ClientePessoaJuridica pj) {
                ps.setString(1, "PJ");
                ps.setNull(2, Types.VARCHAR);
                ps.setNull(3, Types.VARCHAR);
                ps.setString(4, pj.getRazaoSocial());
                ps.setString(5, pj.getCnpj());
            }

            ps.setString(6, cliente.getEndereco());
            ps.setString(7, cliente.getCidade());
            ps.setString(8, cliente.getEstado());
            ps.setString(9, cliente.getTelefone());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cliente.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    // EDITAR
    public void editar(Cliente cliente) {
        conexao.abrirConexao();
        String sql = "UPDATE cliente SET tipo_cliente = ?, nome = ?, cpf = ?, razao_social = ?, cnpj = ?, endereco = ?, cidade = ?, estado = ?, telefone = ? WHERE id = ?";

        try {
            PreparedStatement ps = conexao.getConexao().prepareStatement(sql);

            if (cliente instanceof ClientePessoaFisica pf) {
                ps.setString(1, "PF");
                ps.setString(2, pf.getNome());
                ps.setString(3, pf.getCpf());
                ps.setNull(4, Types.VARCHAR);
                ps.setNull(5, Types.VARCHAR);
            } else if (cliente instanceof ClientePessoaJuridica pj) {
                ps.setString(1, "PJ");
                ps.setNull(2, Types.VARCHAR);
                ps.setNull(3, Types.VARCHAR);
                ps.setString(4, pj.getRazaoSocial());
                ps.setString(5, pj.getCnpj());
            }

            ps.setString(6, cliente.getEndereco());
            ps.setString(7, cliente.getCidade());
            ps.setString(8, cliente.getEstado());
            ps.setString(9, cliente.getTelefone());
            ps.setInt(10, cliente.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    // EXCLUIR
    public void excluir(int id) {
        conexao.abrirConexao();
        String sql = "DELETE FROM cliente WHERE id = ?";

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
    public Cliente buscarPorId(int id) {
        Cliente cliente = null;
        conexao.abrirConexao();
        String sql = "SELECT * FROM cliente WHERE id = ?";

        try {
            PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cliente = map(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return cliente;
    }

    // BUSCAR TODOS
    public List<Cliente> buscarTodos() {
        List<Cliente> lista = new ArrayList<>();
        conexao.abrirConexao();
        String sql = "SELECT * FROM cliente";

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
    private Cliente map(ResultSet rs) throws SQLException {
        String tipo = rs.getString("tipo_cliente");
        Cliente c;

        if ("PF".equalsIgnoreCase(tipo)) {
            c = new ClientePessoaFisica(
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("endereco"),
                rs.getString("cidade"),
                rs.getString("estado"),
                rs.getString("telefone")
            );
        } else {
            c = new ClientePessoaJuridica(
                rs.getString("razao_social"),
                rs.getString("cnpj"),
                rs.getString("endereco"),
                rs.getString("cidade"),
                rs.getString("estado"),
                rs.getString("telefone")
            );
        }

        c.setId(rs.getInt("id"));
        return c;
    }
}
