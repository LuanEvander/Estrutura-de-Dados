package controladores;

import java.util.Scanner;

public class MenuPrincipal {
    private Scanner input = new Scanner(System.in);
    private VeiculoMenu veiculoMenu;
    private CategoriaMenu categoriaMenu;
    private LocacaoMenu locacaoMenu;

    public MenuPrincipal() {
        this.veiculoMenu = new VeiculoMenu();
        this.categoriaMenu = new CategoriaMenu();
        this.locacaoMenu = new LocacaoMenu();
    }

    public void exibirMenuPrincipal() {
        int opcao = 0;
        do {
            exibirMenu();

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    veiculoMenu.menuVeiculo();
                    break;

                case 2:
                    categoriaMenu.menuCategoria();
                    break;

                case 3:
                    locacaoMenu.menuLocacao();
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
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
        System.out.println("|                Menu Principal                         |");
        System.out.println("+-------------------------------------------------------+");
        System.out.println("| 1 - Menu de Veículos                                  |");
        System.out.println("| 2 - Menu de Categorias                                |");
        System.out.println("| 3 - Menu de Locação                                   |");
        System.out.println("| 0 - Sair                                              |");
        System.out.println("+-------------------------------------------------------+");
        System.out.print("Opção: ");
    }
}
