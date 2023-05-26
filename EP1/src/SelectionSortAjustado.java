/**
 * O problema apresentado é a implementação do algoritmo de ordenação Selection
 * Sort com uma pequena alteração. Em vez de selecionar o menor valor e
 * colocá-lo na primeira posição, o algoritmo foi modificado para selecionar o
 * maior valor e colocá-lo na última posição. Em cada iteração, o algoritmo
 * seleciona o maior valor restante e o coloca na posição correta.
 */
public class SelectionSortAjustado {

    float[] valor;

    // Método para ordenar o arranjo de trás para frente
    public void selectionSort() {
        for (int i = valor.length - 1; i >= 1; i--) {
            int maior = posMaior(i);
            if (maior != i)
                troca(i, maior);
        }
    }

    // Método auxiliar para encontrar a posição do maior valor
    private int posMaior(int fim) {
        int maior = fim;
        for (int i = fim - 1; i >= 0; i--) {
            if (valor[i] > valor[maior]) {
                maior = i;
            }
        }
        return maior;
    }

    // Método auxiliar para trocar dois valores de posição
    private void troca(int a, int b) {
        float aux;
        aux = valor[a];
        valor[a] = valor[b];
        valor[b] = aux;
    }

    public static void main(String[] args) {
        float[] valores = { 9.7f, 2.3f, 5.1f, 1.8f, 3.6f };

        SelectionSortAjustado lista = new SelectionSortAjustado();
        lista.valor = valores;

        lista.selectionSort(); 

        for (int i = 0; i < lista.valor.length; i++) {
            System.out.println(lista.valor[i]);
        }
    }
}
