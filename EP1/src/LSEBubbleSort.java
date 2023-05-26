public class LSEBubbleSort {
    private class Node {
        int dado;
        Node proximo;

        Node(int dado) {
            this.dado = dado;
            proximo = null;
        }
    }

    class ListaEncadeada {
        Node inicio;

        void adicionar(int dado) {
            Node novoNode = new Node(dado);
            if (inicio == null) {
                inicio = novoNode;
            } else {
                Node atual = inicio;
                while (atual.proximo != null) {
                    atual = atual.proximo;
                }
                atual.proximo = novoNode;
            }
        }

        void bubbleSort() {
            if (inicio == null)
                return;

            boolean trocou;
            do {
                trocou = false;
                Node atual = inicio;
                Node anterior = null;

                while (atual.proximo != null) {
                    if (atual.dado > atual.proximo.dado) {
                        // Troca de nós
                        Node proximoNo = atual.proximo;
                        atual.proximo = proximoNo.proximo;
                        proximoNo.proximo = atual;

                        if (anterior == null) {
                            inicio = proximoNo;
                        } else {
                            anterior.proximo = proximoNo;
                        }

                        anterior = proximoNo;
                        trocou = true;
                    } else {
                        anterior = atual;
                        atual = atual.proximo;
                    }
                }
            } while (trocou);
        }

        void exibir() {
            Node atual = inicio;
            while (atual != null) {
                System.out.print(atual.dado + " ");
                atual = atual.proximo;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LSEBubbleSort bubbleSort = new LSEBubbleSort();
        ListaEncadeada lista = bubbleSort.new ListaEncadeada();
        lista.adicionar(5);
        lista.adicionar(3);
        lista.adicionar(8);
        lista.adicionar(1);
        lista.adicionar(6);

        System.out.println("Lista original:");
        lista.exibir();

        lista.bubbleSort();

        System.out.println("Lista ordenada:");
        lista.exibir();
    }
}
