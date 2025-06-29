package apresentacao;

import model.ClientePessoaFisica;
import model.Cliente;
import persistencia.ClienteDAO;

import java.sql.SQLException;
import java.util.List;

public class TestaClientePessoaFisica {

    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();

        try {
            // Criar novo cliente pessoa física
            Cliente cliente = new ClientePessoaFisica(
                "João Silva",
                "12345678901",  // CPF sem pontuação
                "Rua das Flores, 123",
                "Joinville",
                "SC",
                "(47) 98888-7777"
            );

            // Inserir cliente no banco
            dao.salvar(cliente);
            System.out.println("Cliente salvo com ID: " + cliente.getId());

            // Listar todos os clientes
            List<Cliente> clientes = dao.listarTodos();
            System.out.println("=== Lista de clientes ===");
            for (Cliente cli : clientes) {
                String nomeExibido;
                if (cli instanceof ClientePessoaFisica pf) {
                    nomeExibido = pf.getNome() + " (CPF: " + pf.getCpf() + ")";
                } else if (cli instanceof model.ClientePessoaJuridica pj) {
                    nomeExibido = pj.getRazaoSocial() + " (CNPJ: " + pj.getCnpj() + ")";
                } else {
                    nomeExibido = "Cliente desconhecido";
                }

                System.out.printf("ID: %d | Nome: %s | Endereço: %s | Cidade: %s | Estado: %s | Telefone: %s%n",
                        cli.getId(), nomeExibido,
                        cli.getEndereco(), cli.getCidade(), cli.getEstado(), cli.getTelefone());
            }

            // Buscar cliente por ID
            Cliente buscado = dao.buscarPorId(cliente.getId());
            System.out.println("Cliente buscado por ID:");
            if (buscado instanceof ClientePessoaFisica pfBuscado) {
                System.out.printf("ID: %d | Nome: %s | CPF: %s%n",
                        pfBuscado.getId(), pfBuscado.getNome(), pfBuscado.getCpf());
            } else if (buscado instanceof model.ClientePessoaJuridica pjBuscado) {
                System.out.printf("ID: %d | Razão Social: %s | CNPJ: %s%n",
                        pjBuscado.getId(), pjBuscado.getRazaoSocial(), pjBuscado.getCnpj());
            }

            // Atualizar cliente
            buscado.setTelefone("(47) 97777-6666");
            dao.atualizar(buscado);
            System.out.println("Cliente atualizado.");

            // Excluir cliente
            dao.excluir(buscado.getId());
            System.out.println("Cliente excluído.");

        } catch (SQLException e) {
            System.err.println("Erro ao acessar banco: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
