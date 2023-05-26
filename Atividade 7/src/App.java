import java.util.Random;

public class App {
    public static void main(String[] args) {
        LSE lista = new LSE();
        Random random = new Random();

        // Preencher a lista com 1000 números inteiros aleatórios
        for (int i = 0; i < 1000; i++) {
            int numero = random.nextInt();
            lista.insereFim(numero);
        }

        int numExecucoes = 10;
        long tempoTotalRecursivo = 0;
        long tempoTotalIterativo = 0;

        for (int i = 0; i < numExecucoes; i++) {
            // Medir o tempo de execução do método recursivo
            long inicioRecursivo = System.nanoTime();
            int maiorRecursivo = lista.encontrarMaiorRecursivo();
            long fimRecursivo = System.nanoTime();
            long tempoRecursivo = fimRecursivo - inicioRecursivo;
            tempoTotalRecursivo += tempoRecursivo;

            // Medir o tempo de execução do método iterativo
            long inicioIterativo = System.nanoTime();
            int maiorIterativo = lista.encontrarMaiorIterativo();
            long fimIterativo = System.nanoTime();
            long tempoIterativo = fimIterativo - inicioIterativo;
            tempoTotalIterativo += tempoIterativo;

            // Verificar se os resultados são consistentes
            if (maiorRecursivo != maiorIterativo) {
                System.out.println("Erro: Resultados inconsistentes");
                return;
            }
        }

        // Calcular a média dos tempos de execução
        long mediaTempoRecursivo = tempoTotalRecursivo / numExecucoes;
        long mediaTempoIterativo = tempoTotalIterativo / numExecucoes;

        System.out.println("Maior elemento (recursivo): " + lista.encontrarMaiorRecursivo());
        System.out.println("Tempo de execução médio (recursivo): " + mediaTempoRecursivo + " ns");

        System.out.println("Maior elemento (iterativo): " + lista.encontrarMaiorIterativo());
        System.out.println("Tempo de execução médio (iterativo): " + mediaTempoIterativo + " ns");
    }
}
