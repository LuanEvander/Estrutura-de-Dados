public class LDEaddOrdenado {
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
    
    public LDEaddOrdenado() {
        this.inicio = null;
        this.fim = null;
    }
    
    public void add_ordenado(int dado) {
        Node novoNode = new Node(dado);
        
        if (inicio == null) { // Lista vazia
            inicio = novoNode;
            fim = novoNode;
        } else if (dado < inicio.dado) { // Inserir no início
            novoNode.proximo = inicio;
            inicio.anterior = novoNode;
            inicio = novoNode;
        } else if (dado > fim.dado) { // Inserir no final
            novoNode.anterior = fim;
            fim.proximo = novoNode;
            fim = novoNode;
        } else { // Inserir no meio
            Node atual = inicio;
            
            while (dado > atual.dado) {
                atual = atual.proximo;
            }
            
            Node anterior = atual.anterior;
            
            anterior.proximo = novoNode;
            novoNode.anterior = anterior;
            
            novoNode.proximo = atual;
            atual.anterior = novoNode;
        }
    }
    
    public void imprimirLista() {
        Node atual = inicio;
        
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println(); // Nova linha
    }
    
    public static void main(String[] args) {
        LDEaddOrdenado lista = new LDEaddOrdenado();
        
        lista.add_ordenado(7);
        lista.add_ordenado(5);
        lista.add_ordenado(2);
        lista.add_ordenado(10);
        
        lista.imprimirLista();

        lista.add_ordenado(6);
        
        lista.imprimirLista();
    }
}
