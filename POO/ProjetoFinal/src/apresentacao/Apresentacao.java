package apresentacao;

import model.Cliente;
import model.ClientePessoaFisica;
import model.ClientePessoaJuridica;
import model.ItemVenda;
import model.Produto;
import model.Venda;
import persistencia.ClienteDAO;
import persistencia.ItemVendaDAO;
import persistencia.ProdutoDAO;
import persistencia.VendaDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Apresentacao {

    private static Scanner sc = new Scanner(System.in);
    private static ProdutoDAO produtoDAO = new ProdutoDAO();
    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static VendaDAO vendaDAO = new VendaDAO();
    private static ItemVendaDAO itemVendaDAO = new ItemVendaDAO();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1 - Gerenciar Produtos");
            System.out.println("2 - Gerenciar Clientes");
            System.out.println("3 - Registrar Venda");
            System.out.println("4 - Listar Vendas");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = sc.nextLine();

            try {
                switch (opcao) {
                    case "1" -> gerenciarProdutos();
                    case "2" -> gerenciarClientes();
                    case "3" -> registrarVenda();
                    case "4" -> listarVendas();
                    case "5" -> {
                        System.out.println("Saindo...");
                        sc.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (SQLException e) {
                System.err.println("Erro no banco: " + e.getMessage());
            }
        }
    }

    private static void gerenciarProdutos() throws SQLException {
        while (true) {
            System.out.println("\n--- Gerenciar Produtos ---");
            System.out.println("1 - Listar Produtos");
            System.out.println("2 - Inserir Produto");
            System.out.println("3 - Atualizar Produto");
            System.out.println("4 - Excluir Produto");
            System.out.println("5 - Voltar");
            System.out.print("Opção: ");

            String op = sc.nextLine();
            switch (op) {
                case "1" -> {
                    List<Produto> produtos = produtoDAO.listarTodos();
                    System.out.println("\n=== Produtos ===");
                    for (Produto p : produtos) {
                        System.out.printf("ID: %d | Tipo: %s | Nome: %s | Preço: %.2f | Estoque: %d%n",
                                p.getId(), p.getTipo(), p.getNome(), p.getPreco(), p.getEstoque());
                    }
                }
                case "2" -> {
                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Preço: ");
                    double preco = Double.parseDouble(sc.nextLine());
                    System.out.print("Estoque: ");
                    int estoque = Integer.parseInt(sc.nextLine());

                    Produto p = new Produto(tipo, nome, preco, estoque);
                    produtoDAO.salvar(p);
                    System.out.println("Produto inserido com ID: " + p.getId());
                }
                case "3" -> {
                    System.out.print("ID do produto para atualizar: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Produto p = produtoDAO.buscarPorId(id);
                    if (p == null) {
                        System.out.println("Produto não encontrado.");
                        break;
                    }
                    System.out.print("Novo tipo (" + p.getTipo() + "): ");
                    String tipo = sc.nextLine();
                    if (!tipo.isBlank()) p.setTipo(tipo);

                    System.out.print("Novo nome (" + p.getNome() + "): ");
                    String nome = sc.nextLine();
                    if (!nome.isBlank()) p.setNome(nome);

                    System.out.print("Novo preço (" + p.getPreco() + "): ");
                    String precoStr = sc.nextLine();
                    if (!precoStr.isBlank()) p.setPreco(Double.parseDouble(precoStr));

                    System.out.print("Novo estoque (" + p.getEstoque() + "): ");
                    String estStr = sc.nextLine();
                    if (!estStr.isBlank()) p.setEstoque(Integer.parseInt(estStr));

                    produtoDAO.atualizar(p);
                    System.out.println("Produto atualizado.");
                }
                case "4" -> {
                    System.out.print("ID do produto para excluir: ");
                    int id = Integer.parseInt(sc.nextLine());
                    produtoDAO.excluir(id);
                    System.out.println("Produto excluído.");
                }
                case "5" -> { return; }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void gerenciarClientes() throws SQLException {
        while (true) {
            System.out.println("\n--- Gerenciar Clientes ---");
            System.out.println("1 - Listar Clientes");
            System.out.println("2 - Inserir Cliente");
            System.out.println("3 - Atualizar Cliente");
            System.out.println("4 - Excluir Cliente");
            System.out.println("5 - Voltar");
            System.out.print("Opção: ");

            String op = sc.nextLine();
            switch (op) {
                case "1" -> {
                    List<Cliente> clientes = clienteDAO.listarTodos();
                    System.out.println("\n=== Clientes ===");
                    for (Cliente c : clientes) {
                        if (c instanceof ClientePessoaFisica pf) {
                            System.out.printf("ID: %d | Pessoa Física | Nome: %s | CPF: %s | Endereço: %s, %s - %s | Telefone: %s%n",
                                    c.getId(), pf.getNome(), pf.getCpf(),
                                    c.getEndereco(), c.getCidade(), c.getEstado(), c.getTelefone());
                        } else if (c instanceof ClientePessoaJuridica pj) {
                            System.out.printf("ID: %d | Pessoa Jurídica | Razão Social: %s | CNPJ: %s | Endereço: %s, %s - %s | Telefone: %s%n",
                                    c.getId(), pj.getRazaoSocial(), pj.getCnpj(),
                                    c.getEndereco(), c.getCidade(), c.getEstado(), c.getTelefone());
                        }
                    }
                }
                case "2" -> {
                    System.out.println("Escolha o tipo de cliente:");
                    System.out.println("1 - Pessoa Física");
                    System.out.println("2 - Pessoa Jurídica");
                    System.out.print("Opção: ");
                    String tipoCliente = sc.nextLine();

                    if ("1".equals(tipoCliente)) {
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("CPF (somente números): ");
                        String cpf = sc.nextLine();
                        System.out.print("Endereço: ");
                        String endereco = sc.nextLine();
                        System.out.print("Cidade: ");
                        String cidade = sc.nextLine();
                        System.out.print("Estado: ");
                        String estado = sc.nextLine();
                        System.out.print("Telefone: ");
                        String telefone = sc.nextLine();

                        ClientePessoaFisica pf = new ClientePessoaFisica(nome, cpf, endereco, cidade, estado, telefone);
                        clienteDAO.salvar(pf);
                        System.out.println("Cliente Pessoa Física inserido com ID: " + pf.getId());

                    } else if ("2".equals(tipoCliente)) {
                        System.out.print("Razão Social: ");
                        String razaoSocial = sc.nextLine();
                        System.out.print("CNPJ (somente números): ");
                        String cnpj = sc.nextLine();
                        System.out.print("Endereço: ");
                        String endereco = sc.nextLine();
                        System.out.print("Cidade: ");
                        String cidade = sc.nextLine();
                        System.out.print("Estado: ");
                        String estado = sc.nextLine();
                        System.out.print("Telefone: ");
                        String telefone = sc.nextLine();

                        ClientePessoaJuridica pj = new ClientePessoaJuridica(razaoSocial, cnpj, endereco, cidade, estado, telefone);
                        clienteDAO.salvar(pj);
                        System.out.println("Cliente Pessoa Jurídica inserido com ID: " + pj.getId());

                    } else {
                        System.out.println("Opção inválida para tipo de cliente.");
                    }
                }
                case "3" -> {
                    System.out.print("ID do cliente para atualizar: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Cliente c = clienteDAO.buscarPorId(id);
                    if (c == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }

                    if (c instanceof ClientePessoaFisica pf) {
                        System.out.print("Nome (" + pf.getNome() + "): ");
                        String nome = sc.nextLine();
                        if (!nome.isBlank()) pf.setNome(nome);

                        System.out.print("CPF (" + pf.getCpf() + "): ");
                        String cpf = sc.nextLine();
                        if (!cpf.isBlank()) pf.setCpf(cpf);

                    } else if (c instanceof ClientePessoaJuridica pj) {
                        System.out.print("Razão Social (" + pj.getRazaoSocial() + "): ");
                        String rs = sc.nextLine();
                        if (!rs.isBlank()) pj.setRazaoSocial(rs);

                        System.out.print("CNPJ (" + pj.getCnpj() + "): ");
                        String cnpj = sc.nextLine();
                        if (!cnpj.isBlank()) pj.setCnpj(cnpj);
                    }

                    System.out.print("Endereço (" + c.getEndereco() + "): ");
                    String endereco = sc.nextLine();
                    if (!endereco.isBlank()) c.setEndereco(endereco);

                    System.out.print("Cidade (" + c.getCidade() + "): ");
                    String cidade = sc.nextLine();
                    if (!cidade.isBlank()) c.setCidade(cidade);

                    System.out.print("Estado (" + c.getEstado() + "): ");
                    String estado = sc.nextLine();
                    if (!estado.isBlank()) c.setEstado(estado);

                    System.out.print("Telefone (" + c.getTelefone() + "): ");
                    String telefone = sc.nextLine();
                    if (!telefone.isBlank()) c.setTelefone(telefone);

                    clienteDAO.atualizar(c);
                    System.out.println("Cliente atualizado.");
                }
                case "4" -> {
                    System.out.print("ID do cliente para excluir: ");
                    int id = Integer.parseInt(sc.nextLine());
                    clienteDAO.excluir(id);
                    System.out.println("Cliente excluído.");
                }
                case "5" -> { return; }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void registrarVenda() throws SQLException {
        System.out.println("\n--- Registrar Venda ---");

        // Escolher cliente
        List<Cliente> clientes = clienteDAO.listarTodos();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado. Cadastre um cliente antes.");
            return;
        }
        System.out.println("Clientes disponíveis:");
        for (Cliente c : clientes) {
            String nomeCliente;
            if (c instanceof ClientePessoaFisica pf) {
                nomeCliente = pf.getNome();
            } else if (c instanceof ClientePessoaJuridica pj) {
                nomeCliente = pj.getRazaoSocial();
            } else {
                nomeCliente = "Cliente";
            }
            System.out.printf("%d - %s%n", c.getId(), nomeCliente);
        }
        System.out.print("Digite o ID do cliente: ");
        int idCliente = Integer.parseInt(sc.nextLine());
        Cliente cliente = clienteDAO.buscarPorId(idCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        Venda venda = new Venda(LocalDate.now(), 0, "", cliente);
        vendaDAO.salvar(venda);

        double totalVenda = 0;

        // Adicionar produtos à venda
        while (true) {
            List<Produto> produtos = produtoDAO.listarTodos();
            if (produtos.isEmpty()) {
                System.out.println("Nenhum produto cadastrado. Cadastre produtos antes.");
                break;
            }
            System.out.println("Produtos disponíveis:");
            for (Produto p : produtos) {
                System.out.printf("%d - %s | %s | Preço: %.2f | Estoque: %d%n",
                        p.getId(), p.getNome(), p.getTipo(), p.getPreco(), p.getEstoque());
            }
            System.out.print("Digite o ID do produto para adicionar (ou 0 para finalizar): ");
            int idProduto = Integer.parseInt(sc.nextLine());
            if (idProduto == 0) break;

            Produto produto = produtoDAO.buscarPorId(idProduto);
            if (produto == null) {
                System.out.println("Produto não encontrado.");
                continue;
            }

            System.out.print("Quantidade: ");
            int quantidade = Integer.parseInt(sc.nextLine());

            if (quantidade > produto.getEstoque()) {
                System.out.println("Estoque insuficiente.");
                continue;
            }

            ItemVenda item = new ItemVenda(venda, produto, quantidade, produto.getPreco());
            itemVendaDAO.salvar(item);

            // Atualizar estoque do produto
            produto.setEstoque(produto.getEstoque() - quantidade);
            produtoDAO.atualizar(produto);

            totalVenda += quantidade * produto.getPreco();
            System.out.println("Item adicionado.");
        }

        venda.setValorTotal(totalVenda);
        venda.setFormaPagamento("Não especificado"); // Pode adicionar opção para definir
        vendaDAO.atualizar(venda);

        System.out.println("Venda registrada com sucesso! Total: " + totalVenda);
    }

    private static void listarVendas() throws SQLException {
        List<Venda> vendas = vendaDAO.listarTodos();
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
            return;
        }
        System.out.println("\n=== Vendas ===");
        for (Venda v : vendas) {
            String nomeCliente;
            if (v.getCliente() instanceof ClientePessoaFisica pf) {
                nomeCliente = pf.getNome();
            } else if (v.getCliente() instanceof ClientePessoaJuridica pj) {
                nomeCliente = pj.getRazaoSocial();
            } else {
                nomeCliente = "Cliente";
            }

            System.out.printf("ID: %d | Cliente: %s | Data: %s | Total: %.2f | Pagamento: %s%n",
                    v.getId(), nomeCliente, v.getData(), v.getValorTotal(), v.getFormaPagamento());

            List<ItemVenda> itens = itemVendaDAO.listarPorVenda(v.getId());
            for (ItemVenda iv : itens) {
                System.out.printf("   - Produto: %s | Qtde: %d | Preço unit: %.2f%n",
                        iv.getProduto().getNome(), iv.getQuantidade(), iv.getPrecoUnitario());
            }
        }
    }
}
