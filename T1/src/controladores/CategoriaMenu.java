package controladores;

import java.util.Scanner;
import logica.entidades.Categoria;
import logica.listas.LSECategorias;

public class CategoriaMenu {
    private LSECategorias listaCategorias;
    private Scanner input = new Scanner(System.in);

    public CategoriaMenu() {
        this.listaCategorias = new LSECategorias();
    }

    public void menuCategoria() {
        int opcao = 0;
        do {
            exibirMenu();

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    adicionarCategoria();
                    break;

                case 2:
                    removerCategoria();
                    break;

                case 3:
                    atualizarCategoria();
                    break;

                case 4:
                    listarCategorias();
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
        System.out.println("|              Menu de Opções de Categorias             |");
        System.out.println("+-------------------------------------------------------+");
        System.out.println("| 1 - Adicionar uma categoria                           |");
        System.out.println("| 2 - Remover uma categoria                             |");
        System.out.println("| 3 - Atualizar uma categoria                           |");
        System.out.println("| 4 - Exibir informações de todas as categorias         |");
        System.out.println("| 0 - Voltar                                            |");
        System.out.println("+-------------------------------------------------------+");
        System.out.print("Opção: ");
    }

    private void adicionarCategoria() {

        System.out.println("Digite o identificador da categoria: ");
        int id = input.nextInt();

        // Verifica se ID já existe
        if (listaCategorias.getCategoria(id) != null) {
            System.out.println("Identificador já cadastrado!");
            return;
        }

        System.out.print("Digite o nome da categoria: ");
        String nome = input.next();

        Categoria categoria = new Categoria(id, nome);
        listaCategorias.adicionarCategoria(categoria);

        System.out.println("Categoria adicionada com sucesso!");
        System.out.println(categoria.toString());
    }

    private void removerCategoria() {

        System.out.println("Como deseja remover a categoria?");
        System.out.println("1 - Pelo ID");
        System.out.println("2 - Pelo objeto Categoria");

        int opcao = input.nextInt();

        if (opcao == 1) {
            // Remover por ID
            System.out.println("Informe o ID da categoria:");
            int id = input.nextInt();

            Categoria categoria = listaCategorias.getCategoria(id);

            if (categoria == null) {
                listaCategorias.removerCategoria(categoria);
                System.out.println("Categoria removida!");
            } else {
                System.out.println("Categoria não encontrada!");
            }

        } else if (opcao == 2) {
            // Remover pelo objeto Categoria
            System.out.println("Informe os dados da categoria:");
            int id = input.nextInt();
            String nome = input.next();

            Categoria categoria = new Categoria(id, nome);

            listaCategorias.removerCategoria(categoria);

        } else {
            System.out.println("Opção inválida!");
        }

    }

    private Categoria atualizarCategoria() {

        System.out.println("Informe o ID da categoria para atualizar:");

        int idAtual = input.nextInt();

        Categoria categoria = listaCategorias.getCategoria(idAtual);

        if (categoria == null) {
            System.out.println("Categoria não encontrada!");
            return null;
        }

        System.out.println("Informe o novo identificador:");
        int novoId = input.nextInt();

        categoria.setIdentificador(novoId);

        System.out.println("Informe o novo nome:");

        String novoNome = input.next();

        categoria.setNome(novoNome);

        System.out.println("Categoria atualizada com sucesso!");

        return categoria;

    }

    private void listarCategorias() {
        String lista = listaCategorias.listarCategorias();
        if (lista == null) {
            System.err.println("Não há categorias cadastradas!");
        } else {
            System.out.println("Lista de categorias:\n" + lista);
        }
    }
}
