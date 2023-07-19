package controladores;

import java.sql.Date;
import java.util.Scanner;

import logica.entidades.Cliente;
import logica.entidades.Locacao;
import logica.entidades.Veiculo;
import logica.listas.LSECategorias;
import logica.listas.LSEClientes;
import logica.listas.LSELocacoes;
import logica.listas.LSEVeiculos;

public class LocacaoMenu {
    private LSELocacoes metodosLocacao;
    private LSEVeiculos metodosVeiculo;
    private LSEClientes metodosCliente;
    private LSECategorias metodosCategoria;
    private Scanner input;

    public LocacaoMenu() {
        this.metodosLocacao = new LSELocacoes();
    }

    public void menuLocacao() {
        int opcao = 0;
        do {
            exibirMenu();

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    realizarLocacao();
                    break;

                case 2:
                    finalizarLocacao();
                    break;

                case 3:
                    exibirInformacoesLocacoes();
                    break;

                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private void exibirMenu() {
        System.out.println("\n\n");
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|              Menu de Opções de Locação                |");
        System.out.println("+-------------------------------------------------------+");
        System.out.println("| 1 - Realizar uma locação                              |");
        System.out.println("| 2 - Finalizar uma locação                             |");
        System.out.println("| 3 - Exibir informações de todas as locações            |");
        System.out.println("| 0 - Voltar                                            |");
        System.out.println("+-------------------------------------------------------+");
        System.out.print("Opção: ");
    }

    private void realizarLocacao() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = input.next();

        if (!cpfValido(cpf)) {
            System.err.println("CPF inválido!");
            return;
        }

        Cliente cliente = metodosCliente.getCliente(cpf);
        if (cliente == null) {
            System.err.println("Cliente não encontrado!");
            return;
        }

        // Verifica se o veículo está disponível para locação (pode usar um método da
        // classe VeiculoMenu)
        System.out.println("Digite a placa do veículo: ");
        String placaVeiculo = input.next();

        if (!placaValida(placaVeiculo)) {
            System.err.println("Placa inválida!");
            return;
        }

        Veiculo veiculo = metodosVeiculo.getVeiculo(placaVeiculo);
        if (veiculo == null) {
            System.err.println("Veículo não encontrado!");
            return;
        }
        // Verifica se o veículo está disponível para locação (lógica específica aqui)

        // Verifica se já existe uma locação em andamento para o veículo (pode usar o
        // método getLocacao da classe LSELocacoes)
        Locacao locacaoExistente = metodosLocacao.getLocacao(placaVeiculo);
        if (locacaoExistente != null) {
            System.err.println("Já existe uma locação em andamento para o veículo!");
            return;
        }
        // Verifica se já existe uma locação em andamento para o veículo (lógica
        // específica aqui)

        // Cria um objeto Locacao com os dados necessários
        System.out.println("Digite a data de término da locação: ");
        String dataTermino = input.next();

        float valorLocacao = calcularValorLocacao(dataTermino, dataLocacao);

        Locacao locacao = new Locacao(cliente, veiculo, dataLocacao, dataTermino, valorLocacao);

        // Adiciona a locação à lista de locações (usando o método adicionarLocacao da
        // classe LSELocacoes)
        listaLocacoes.adicionarLocacao(locacao);

        System.out.println("Locação realizada com sucesso!");
    }

    private boolean cpfValido(String cpf) {
        return cpf.matches("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}");
    }

    private boolean placaValida(String placa) {
        return placa.matches("[A-Z]{3}-[0-9]{4}");
    }

    private float calcularValorLocacao(Date dataTermino, Date dataLocacao) {
        return 0;
    }

    private void finalizarLocacao() {
        System.out.println("Digite a placa do veículo: ");
        String placaVeiculo = input.next();

        // Busca a locação correspondente à placa do veículo (usando o método getLocacao
        // da classe LSELocacoes)
        Locacao locacao = listaLocacoes.getLocacao(placaVeiculo);

        // Verifica se a locação foi encontrada
        if (locacao == null) {
            System.err.println("Locação não encontrada!");
            return;
        }

        // Realiza as ações necessárias para finalizar a locação (pode ser atualizar
        // atributos da locação ou até mesmo remover a locação da lista)
        System.out.println("Digite a data de término da locação: ");
        String dataDevolucao = input.next();

        locacao.setDataDevolucao(dataDevolucao);

        // Finaliza a locação (lógica específica aqui)
        listaLocacoes.finalizarLocacao(locacao);

        System.out.println("Locação finalizada com sucesso!");
    }

    private void exibirInformacoesLocacoes() {
        System.out.println("Informações de todas as locações:");

        String listaLocacoes = this.listaLocacoes.listarLocacoes();

        if (listaLocacoes == null) {
            System.err.println("Não há locações cadastradas!");
        } else {
            System.out.println(listaLocacoes);
        }
    }
}
