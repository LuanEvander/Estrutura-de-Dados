public class LSE implements ILista {
    private Noh inicio;

    public LSE() {
        this.inicio = null;
    }

    @Override
    public void insereInicio(int info) {
        Noh novo = new Noh(info);
        if (inicio == null) {
            inicio = novo;
        } else {
            novo.setProximo(inicio);
            inicio = novo;
        }
    }

    @Override
    public void insereFim(int info) {
        Noh novo = new Noh(info);
        if (inicio == null) {
            inicio = novo;
        } else {
            Noh ultimo = null;
            for (Noh i = inicio; i != null; i = i.getProximo()) {
                ultimo = i;
            }
            ultimo.setProximo(novo);
        }
    }

    @Override
    public boolean estahVazia() {
        return inicio == null;
    }

    @Override
    public boolean remove(int info) {
        Noh anterior = null;
        Noh p = inicio;

        while (p != null && p.getInfo() != info) {
            anterior = p;
            p = p.getProximo();
        }
        if (p == null) {
            return false;
        }
        if (anterior == null) {
            inicio = p.getProximo();
        } else {
            anterior.setProximo(p.getProximo());
        }
        return true;
    }

    @Override
    public int tamanho() {
        int cont = 0;
        for (Noh i = inicio; i != null; i = i.getProximo()) {
            cont++;
        }
        return cont;
    }

    public int encontrarMaiorRecursivo() {
        if (estahVazia()) {
            throw new IllegalStateException("A lista está vazia");
        }

        return encontrarMaiorRecursivo(inicio, Integer.MIN_VALUE);
    }

    private int encontrarMaiorRecursivo(Noh atual, int max) {
        if (atual == null) {
            return max;
        }

        if (atual.getInfo() > max) {
            max = atual.getInfo();
        }

        return encontrarMaiorRecursivo(atual.getProximo(), max);
    }

    public int encontrarMaiorIterativo() {
        if (estahVazia()) {
            throw new IllegalStateException("A lista está vazia");
        }

        int max = Integer.MIN_VALUE;
        Noh atual = inicio;

        while (atual != null) {
            if (atual.getInfo() > max) {
                max = atual.getInfo();
            }
            atual = atual.getProximo();
        }
        return max;
    }
}
