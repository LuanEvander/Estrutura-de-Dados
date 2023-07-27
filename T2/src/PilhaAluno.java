public class PilhaAluno {
    private int tamanhoMaximo;
    private int topo;
    private Aluno[] elementos; // Supondo que a classe Aluno já foi definida

    public PilhaAluno(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.topo = -1;
        this.elementos = new Aluno[tamanhoMaximo]; // Supondo que a classe Aluno já foi definida
    }

    public void push(Aluno aluno) {
        if (!isFull()) {
            topo++;
            elementos[topo] = aluno;
        } else {
            System.out.println("A pilha está cheia. Não foi possível adicionar o aluno.");
        }
    }

    public Aluno pop() {
        if (!isEmpty()) {
            Aluno alunoRemovido = elementos[topo];
            topo--;
            return alunoRemovido;
        } else {
            System.out.println("A pilha está vazia. Não foi possível remover aluno.");
            return null; // Valor nulo para indicar que a pilha está vazia.
        }
    }

    public boolean isFull() {
        return topo == tamanhoMaximo - 1;
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public int size() {
        return topo + 1;
    }

    public Aluno top() {
        if (!isEmpty()) {
            return elementos[topo];
        } else {
            System.out.println("A pilha está vazia. Não há topo para retornar.");
            return null; // Valor nulo para indicar que a pilha está vazia.
        }
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

}
