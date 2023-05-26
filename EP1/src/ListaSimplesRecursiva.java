public class ListaSimplesRecursiva {
    private static class NodeLista {
        int valor;
        NodeLista proximo;

        public NodeLista(int valor) {
            this.valor = valor;
        }
    }

    private static class ListaEncadeada {
        private NodeLista inicio;

        public void imprime_rec() {
            imprime_rec_auxiliar(inicio);
        }

        private void imprime_rec_auxiliar(NodeLista node) {
            if (node == null) {
                return;
            }

            System.out.println(node.valor);
            imprime_rec_auxiliar(node.proximo);
        }

        public void adicionar(int valor) {
            NodeLista novoNode = new NodeLista(valor);
            if (inicio == null) {
                inicio = novoNode;
            } else {
                NodeLista atual = inicio;
                while (atual.proximo != null) {
                    atual = atual.proximo;
                }
                atual.proximo = novoNode;
            }
        }
    }

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.adicionar(4);

        lista.imprime_rec();
    }
}
