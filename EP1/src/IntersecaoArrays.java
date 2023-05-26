/**
 * Essa solução utiliza dois loops aninhados para percorrer os arranjos,
 * comparando cada elemento do primeiro arranjo com todos os elementos do
 * segundo arranjo. Os elementos comuns são adicionados à intersecao. Portanto,
 * a complexidade do algoritmo no pior caso é O(n * m), onde n é o tamanho de
 * arr1 e m é o tamanho de arr2. Essa abordagem possui uma complexidade quadrática.
 */

public class IntersecaoArrays {
    public static int[] encontrarIntersecao(int[] arr1, int[] arr2) {
        // Verifica o tamanho dos arranjos
        int tamanho1 = arr1.length;
        int tamanho2 = arr2.length;

        // Array para armazenar a interseção
        int[] intersecao = new int[Math.min(tamanho1, tamanho2)];

        // Índice para acompanhar a interseção
        int index = 0;

        // Percorre o primeiro arranjo
        for (int i = 0; i < tamanho1; i++) {
            // Verifica se o elemento está presente no segundo arranjo
            for (int j = 0; j < tamanho2; j++) {
                if (arr1[i] == arr2[j]) {
                    // Adiciona o elemento à interseção
                    intersecao[index++] = arr1[i];
                    break;
                }
            }
        }

        // Cria um novo array com o tamanho exato da interseção
        int[] resultado = new int[index];
        System.arraycopy(intersecao, 0, resultado, 0, index);

        return resultado;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5, 8 };
        int[] arr2 = { 4, 5, 6, 7, 8 };

        System.out.print("Arranjo 1: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }

        System.out.println("\n");

        System.out.print("Arranjo 2: ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

        int[] intersecao = encontrarIntersecao(arr1, arr2);

        System.out.print("\nInterseção: ");
        for (int i = 0; i < intersecao.length; i++) {
            System.out.print(intersecao[i] + " ");
        }
    }
}
