package controladores;

import java.util.Scanner;

import logica.entidades.Veiculo;
import logica.listas.LSEVeiculos;

public class VeiculoMenu {
    private LSEVeiculos metodoVeiculos;
    private Scanner input = new Scanner(System.in);

    public VeiculoMenu() {
        this.metodoVeiculos = new LSEVeiculos();
    }

    public void menuVeiculo() {
        int opcao = 0;
        do {
            System.out.println("\n\n");
            System.out.println("+-------------------------------------------------------+");
            System.out.println("|              Menu de Opções do Veiculo                |");
            System.out.println("+-------------------------------------------------------+");
            System.out.println("| 1 - Adicionar um veiculo                              |");
            System.out.println("| 2 - Remover um veiculo                                |");
            System.out.println("| 3 - Atualizar de um veiculo                           |");
            System.out.println("| 4 - Exibir informações de todos veiculos              |");
            System.out.println("| 0 - Voltar                                            |");
            System.out.println("+-------------------------------------------------------+");
            System.out.print("Opção: ");

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    addVeiculo();
                    break;

                case 2:
                    removeVeiculo();
                    break;

                case 3:
                    atualizaVeiculo();
                    break;

                case 4:
                    listaVeiculos();
                    break;

                default:
                    System.out.println("Opção inválida!");
                    menuVeiculo();
            }
        } while (opcao != 0);
    }

    private void addVeiculo() {
        System.out.print("Digite a placa do veiculo: ");
        String placa = input.next();

        System.out.print("Digite o modelo do veiculo: ");
        String modelo = input.next();

        System.out.print("Digite a marca do veiculo: ");
        String marca = input.next();

        System.out.print("Digite o ano do veiculo: ");
        int ano = input.nextInt();

        System.out.print("Digite a potencia do veiculo: ");
        int potencia = input.nextInt();

        System.out.print("Digite a quantidade de lugares: ");
        int lugares = input.nextInt();

        System.out.print("Digite o id da categoria: ");
        int idCategoria = input.nextInt();

        Veiculo veiculo = new Veiculo(placa, modelo, marca, ano, potencia, lugares, idCategoria);
        metodoVeiculos.adicionarVeiculo(veiculo);
        System.out.println(veiculo.toString());
    }

    private void removeVeiculo() {
        System.out.print("Digite a placa do veiculo: ");
        String placa = input.next();

        Veiculo veiculo = metodoVeiculos.getVeiculo(placa);

        if (veiculo != null) {
            System.out.println("Veiculo encontrado!");
            System.out.println(veiculo.toString());

            System.out.print("Deseja realmente remover o veiculo? (S/N): ");
            String opcao = input.next();
            if (opcao.equalsIgnoreCase("S")) {
                metodoVeiculos.removerVeiculo(veiculo);
                System.out.println("Veiculo removido com sucesso!");
            } else {
                System.out.println("Operação cancelada!");
            }
        } else {
            System.err.println("Veiculo não encontrado!");
        }
    }

    private void atualizaVeiculo() {
        System.out.print("Digite a placa do veiculo: ");
        String placa = input.next();

        Veiculo veiculo = metodoVeiculos.getVeiculo(placa);

        if (veiculo != null) {
            System.out.println("Veiculo encontrado!");
            System.out.println(veiculo.toString());

            System.out.print("Deseja realmente atualizar o veiculo? (S/N): ");
            String opcao = input.next();
            if (opcao.equalsIgnoreCase("S")) {
                System.out.print("Digite o modelo do veiculo: ");
                String modelo = input.next();

                System.out.print("Digite a marca do veiculo: ");
                String marca = input.next();

                System.out.print("Digite o ano do veiculo: ");
                int ano = input.nextInt();

                System.out.print("Digite a potencia do veiculo: ");
                int potencia = input.nextInt();

                System.out.print("Digite a quantidade de lugares: ");
                int lugares = input.nextInt();

                System.out.print("Digite o id da categoria: ");
                int idCategoria = input.nextInt();

                Veiculo veiculoAtualizado = new Veiculo(placa, modelo, marca, ano, potencia, lugares, idCategoria);
                metodoVeiculos.atualizarVeiculo(veiculoAtualizado);
                System.out.println("Veiculo atualizado com sucesso!");
            } else {
                System.out.println("Operação cancelada!");
            }
        } else {
            System.err.println("Veiculo não encontrado!");
        }
    }

    private void listaVeiculos() {
        System.out.println("Lista de veiculos: ");

        if (metodoVeiculos.listarVeiculos() == null) {
            System.err.println("Nenhum veiculo cadastrado!");
        } else {
            System.out.println(metodoVeiculos.listarVeiculos());
        }
    }
}