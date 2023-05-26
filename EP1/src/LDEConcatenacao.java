public class LDEConcatenacao {
    public static class Node {
        public int numero;
        public Node anterior;
        public Node proximo;

        public Node(int numero) {
            this.numero = numero;
            this.anterior = null;
            this.proximo = null;
        }
    }

    private Node inicio;
    private Node fim;
    
    public LDEConcatenacao() {
        this.inicio = null;
        this.fim = null;
    }
    
    public void adicionarNumero(int numero) {
        Node novoNode = new Node(numero);
        
        if (inicio == null) { // Lista vazia
            inicio = novoNode;
            fim = novoNode;
        } else {
            novoNode.anterior = fim;
            fim.proximo = novoNode;
            fim = novoNode;
        }
    }
    
    public void concat(LDEConcatenacao lista) {
        if (lista.inicio == null) {
            return; // Se a lista a ser concatenada estiver vazia, não há nada a ser feito
        }
        
        if (inicio == null) {
            inicio = lista.inicio;
            fim = lista.fim;
        } else {
            fim.proximo = lista.inicio;
            lista.inicio.anterior = fim;
            fim = lista.fim;
        }
    }
    
    public void imprimirLista() {
        Node atual = inicio;
        
        while (atual != null) {
            System.out.print(atual.numero + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        LDEConcatenacao lista1 = new LDEConcatenacao();
        lista1.adicionarNumero(1);
        lista1.adicionarNumero(2);
        lista1.adicionarNumero(3);
        lista1.adicionarNumero(4);

        lista1.imprimirLista();
        
        LDEConcatenacao lista2 = new LDEConcatenacao();
        lista2.adicionarNumero(5);
        lista2.adicionarNumero(6);
        lista2.adicionarNumero(7);
        lista2.adicionarNumero(8);
        
        lista1.concat(lista2);
        
        lista1.imprimirLista(); // Resultado: 1 2 3 4 5 6 7 8
    }
}
