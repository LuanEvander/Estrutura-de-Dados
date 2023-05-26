public class SomatoriaRecursiva {
    public static int somatoria(int n, int m) {
        if (n == m) {
            return m; // Caso base: quando n é igual a m, retorna m.
        } else if (n > m) {
            return m + somatoria(n, m + 1); // Caso recursivo: soma m com a somatória dos números de m+1 até n.
        } else {
            throw new IllegalArgumentException("n deve ser maior ou igual a m"); // Validação de entrada inválida.
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 2;
        int result = somatoria(n, m);
        System.out.println("A somatória de k de " + m + " a " + n + " é: " + result);
    }
}
