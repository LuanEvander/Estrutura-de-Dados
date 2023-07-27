public class Pilha {
    private int tamanhoMaximo;
    private int topo;
    private char[] elementos;

    public Pilha(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.topo = -1;
        this.elementos = new char[tamanhoMaximo];
    }

    public void push(char elemento) {
        if (!isFull()) {
            topo++;
            elementos[topo] = elemento;
        } else {
            System.out.println("A pilha está cheia. Não foi possível adicionar o elemento.");
        }
    }

    public char pop() {
        if (!isEmpty()) {
            char elementoRemovido = elementos[topo];
            topo--;
            return elementoRemovido;
        } else {
            System.out.println("A pilha está vazia. Não foi possível remover elemento.");
            return '\0'; // Valor nulo de char para indicar que a pilha está vazia.
        }
    }

    public boolean isFull() {
        return topo == tamanhoMaximo - 1;
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public void imprimirPilha() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia.");
        } else {
            System.out.print("Estado da pilha: ");
            for (int i = 0; i <= topo; i++) {
                System.out.print(elementos[i] + " ");
            }
            System.out.println();
        }
    }

    public boolean palindromo(String palavra) {
        // Remover espaços e converter todas as letras para minúsculas
        String palavraFormatada = palavra;

        // Empilhar cada letra na pilha
        for (int i = 0; i < palavraFormatada.length(); i++) {
            push(palavraFormatada.charAt(i));
        }

        // Comparar cada letra com o elemento no topo da pilha
        for (int i = 0; i < palavraFormatada.length(); i++) {
            char letra = palavraFormatada.charAt(i);
            if (letra != pop()) {
                return false;
            }
        }

        return isEmpty();
    }
}
