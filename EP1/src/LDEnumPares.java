public class LDEnumPares {
    public static class Node {
        public int dado;
        public Node anterior;
        public Node proximo;

        public Node(int dado) {
            this.dado = dado;
            this.anterior = null;
            this.proximo = null;
        }
    }

    private Node inicio;
    private Node fim;

    public LDEnumPares() {
        this.inicio = null;
        this.fim = null;
    }

    public void adicionarNode(int dado) {
        Node novoNode = new Node(dado);

        if (inicio == null) {
            inicio = novoNode;
            fim = novoNode;
        } else {
            if (dado % 2 == 0) { // Inserir no final apenas se o número for par
                novoNode.anterior = fim;
                fim.proximo = novoNode;
                fim = novoNode;
            }
        }
    }

    public int nroPares() {
        int contador = 0;

        Node atual = inicio;
        while (atual != null) {
            if (atual.dado % 2 == 0) {
                contador++;
            }

            atual = atual.proximo;
        }

        return contador;
    }

    public static void main(String[] args) {
        LDEnumPares lista = new LDEnumPares();
        lista.adicionarNode(1);
        lista.adicionarNode(2);
        lista.adicionarNode(3);
        lista.adicionarNode(4);
        lista.adicionarNode(5);
        lista.adicionarNode(6);

        int nroPares = lista.nroPares();
        System.out.println("Número de elementos pares: " + nroPares);
    }    
}
