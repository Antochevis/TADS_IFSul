package apresentacao;

import model.ClientePessoaJuridica;
import model.Cliente;
import persistencia.ClienteDAO;

import java.sql.SQLException;
import java.util.List;

public class TestaClientePessoaJuridica {

    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();

        try {
            // Criar novo cliente pessoa jurídica
            Cliente cliente = new ClientePessoaJuridica(
                "Cervejaria Antochevis Ltda",
                "12345678000199",
                "Rua das Cervejas, 100",
                "Blumenau",
                "SC",
                "(47) 99999-9999"
            );

            // Inserir cliente no banco
            dao.salvar(cliente);
            System.out.println("Cliente salvo com ID: " + cliente.getId());

            // Listar todos os clientes
            List<Cliente> clientes = dao.listarTodos();
            System.out.println("=== Lista de clientes ===");
            for (Cliente cli : clientes) {
                String nomeExibido;
                if (cli instanceof ClientePessoaJuridica pj) {
                    nomeExibido = pj.getRazaoSocial() + " (CNPJ: " + pj.getCnpj() + ")";
                } else if (cli instanceof model.ClientePessoaFisica pf) {
                    nomeExibido = pf.getNome() + " (CPF: " + pf.getCpf() + ")";
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
            if (buscado instanceof ClientePessoaJuridica pjBuscado) {
                System.out.printf("ID: %d | Razão Social: %s | CNPJ: %s%n",
                        pjBuscado.getId(), pjBuscado.getRazaoSocial(), pjBuscado.getCnpj());
            } else if (buscado instanceof model.ClientePessoaFisica pfBuscado) {
                System.out.printf("ID: %d | Nome: %s | CPF: %s%n",
                        pfBuscado.getId(), pfBuscado.getNome(), pfBuscado.getCpf());
            }

            // Atualizar cliente
            buscado.setTelefone("(47) 98888-8888");
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
