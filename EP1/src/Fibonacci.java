/**
 * A solução envolve a implementação de um método em Java chamado fibonacci, que
 * recebe um número n como entrada e retorna o enésimo termo da série de
 * Fibonacci.
 */
public class Fibonacci {
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        int n = 10; // Altere o valor de n para obter o enésimo termo desejado
        System.out.println("Fibonacci de " + n + " = ");
        System.out.println(fibonacci(n));
    }
}
