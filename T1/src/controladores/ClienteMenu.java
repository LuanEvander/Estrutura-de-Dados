package controladores;

import java.util.Scanner;

import logica.entidades.Cliente;
import logica.listas.LSEClientes;

public class ClienteMenu {
    private LSEClientes metodosCliente;
    private Scanner input = new Scanner(System.in);

    public ClienteMenu() {
        this.metodosCliente = new LSEClientes();
    }

    public void menuCliente() {
        int opcao = 0;
        do {
            System.out.println("\n\n");
            System.out.println("+-------------------------------------------------------+");
            System.out.println("|              Menu de Opções do Cliente                |");
            System.out.println("+-------------------------------------------------------+");
            System.out.println("| 1 - Adicionar um cliente                              |");
            System.out.println("| 2 - Remover um cliente                                |");
            System.out.println("| 3 - Atualizar de um cliente                           |");
            System.out.println("| 4 - Exibir informações de todos clientes              |");
            System.out.println("| 0 - Voltar                                            |");
            System.out.println("+-------------------------------------------------------+");
            System.out.print("Opção: ");

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    addCliente();
                    break;

                case 2:
                    removeCliente();
                    break;

                case 3:
                    atualizaCliente();
                    break;

                case 4:
                    listaClientes();
                    break;

                default:
                    System.out.println("Opção inválida!");
                    menuCliente();
            }
        } while (opcao != 0);
    }

    private void addCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = input.next();

        System.out.print("Digite o CPF do cliente: ");
        String cpf = input.next();

        if (!isCpfValido(cpf)) {
            System.out.println("CPF inválido!");
            return;
        }

        System.out.print("Digite a carteira do cliente: ");
        String cnh = input.next();

        System.out.print("Digite o telefone do cliente: ");
        String telefone = input.next();

        // Cria o cliente passando os parâmetros como String
        Cliente novoCliente = new Cliente(nome, cpf, cnh, telefone);

        if (metodosCliente.getCliente(cpf) != null) {
            System.out.println("CPF já cadastrado!");
            return;
        }

        metodosCliente.adicionarCliente(novoCliente);
        System.out.println("Cliente adicionado com sucesso!");

        if (metodosCliente.getCliente(cpf) != null)
            System.out.println("CPF já cadastrado!");
        return;

    }

    boolean isCpfValido(String cpf) {
        // valida CPF
        return true;
    }

    private void removeCliente() {

        System.out.print("Digite o CPF do cliente: ");

        // lê CPF como String
        String cpf = input.next();

        // passa CPF como String para getCliente
        Cliente cliente = metodosCliente.getCliente(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.println("Cliente encontrado: ");
        System.out.println(cliente); // imprime dados

        System.out.print("Deseja remover este cliente? (S/N): ");
        String opcao = input.next();

        if (opcao.equalsIgnoreCase("S")) {

            metodosCliente.removerCliente(cliente);

            System.out.println("Cliente removido com sucesso!");

        } else {
            System.out.println("Operação cancelada!");
        }

    }

    private void atualizaCliente() {

        System.out.print("Digite o CPF para atualizar: ");
        String cpf = input.next();

        Cliente cliente = metodosCliente.getCliente(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.println("Cliente encontrado:");
        System.out.println(cliente);

        System.out.print("Deseja atualizar este cliente? (S/N): ");
        String opcao = input.next();

        if (opcao.equalsIgnoreCase("S")) {

            // lê novos dados
            System.out.print("Novo nome: ");
            String novoNome = input.next();

            System.out.print("Novo CPF: ");
            String novoCpf = input.next();

            // atualiza dados no cliente existente
            cliente.setNome(novoNome);
            cliente.setCpf(novoCpf);

            // atualiza o cliente
            metodosCliente.atualizarCliente(cliente);

            System.out.println("Cliente atualizado com sucesso!");

        } else {
            System.out.println("Operação cancelada.");
        }

    }

    private void listaClientes() {
        System.out.println("Lista de clientes: ");

        if (metodosCliente.listarClientes() == null) {
            System.err.println("Não há clientes cadastrados!");
        } else {
            System.out.println(metodosCliente.listarClientes());
        }
    }
}
