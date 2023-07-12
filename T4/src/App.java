import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        VetorMap mapa = new VetorMap();

        // Inserir 100.000 veículos
        System.out.println("+----\nInserindo 100.000 veículos...");

        long startInsertionTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            Veiculo veiculo = new Veiculo();
            mapa.put(veiculo.getChassi(), veiculo);
        }
        long endInsertionTime = System.nanoTime();
        long insertionTime = endInsertionTime - startInsertionTime;

        System.out.println(mapa.size() + " veículos inseridos!");
        System.out.println("Tempo de inserção: " + insertionTime + " nanossegundos");
        System.out.println("----------------------------------------\n");

        // Apresentar todos os veículos em ordem crescente de número de chassi
        System.out.println("+----\nVeículos em ordem crescente de número de chassi:");

        System.out.println("- Ordenando veículos...");
        List<Veiculo> veiculosOrdenados = new ArrayList<>(mapa.values());
        long startSortingTime = System.nanoTime();
        insertionSort(veiculosOrdenados);
        long endSortingTime = System.nanoTime();
        long sortingTime = endSortingTime - startSortingTime;
        System.out.println("- Tempo de ordenação: " + sortingTime + " nanossegundos\n");

        System.out.println("Apresentando veículos...");
        for (Veiculo veiculo : veiculosOrdenados) {
            System.out.println(veiculo);
        }
        System.out.println("----------------------------------------\n");

        // Verificar quantos veículos são da marca Ford
        System.out.println("+----\nVerificando quantos veículos são da marca Ford...");
        int countFord = 0;
        for (Veiculo veiculo : mapa.values()) {
            if (veiculo.getMarca().equalsIgnoreCase("Ford")) {
                countFord++;
            }
        }
        System.out.println("Quantidade de veículos da marca Ford: " + countFord);
        System.out.println("----------------------------------------\n");

        // Remover todos os veículos com número de chassi igual ou inferior a 202050000
        System.out.println("+----\nRemovendo todos os veículos com número de chassi igual ou inferior a 202050000...");
        long startRemovalTime = System.nanoTime();
        for (Integer chassi : mapa.keySet()) {
            if (chassi <= 202050000) {
                mapa.remove(chassi);
            }
        }
        long endRemovalTime = System.nanoTime();
        long removalTime = endRemovalTime - startRemovalTime;
        System.out.println("Tempo de remoção: " + removalTime + " nanossegundos");
        System.out.println("----------------------------------------\n");
    }

    private static void insertionSort(List<Veiculo> veiculos) {
        int n = veiculos.size();
        for (int i = 1; i < n; i++) {
            Veiculo chave = veiculos.get(i);
            int j = i - 1;

            while (j >= 0 && veiculos.get(j).getChassi() > chave.getChassi()) {
                veiculos.set(j + 1, veiculos.get(j));
                j--;
            }

            veiculos.set(j + 1, chave);
        }
    }
}
