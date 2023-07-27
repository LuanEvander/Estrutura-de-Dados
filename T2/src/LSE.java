public class LSE{
    private Noh<Object> inicio;

    public LSE() {
        this.inicio = null;
    }

    public void insereInicio(Object info) {
        Noh<Object> novo = new Noh<Object>(info);
        if (inicio == null) {
            inicio = novo;
        } else {
            novo.setProximo(inicio);
            inicio = novo;
        }
    }

    public void insereFim(Object info) {
        Noh<Object> novo = new Noh<Object>(info);
        if (inicio == null) {
            inicio = novo;
        } else {
            Noh<Object> ultimo = null;
            for (Noh<Object> i = inicio; i != null; i = i.getProximo()) {
                ultimo = i;
            }
            ultimo.setProximo(novo);
        }
    }

    public boolean estahVazia() {
        return inicio == null;
    }

    public boolean remove(Object info) {
        Noh<Object> anterior = null;
        Noh<Object> p = inicio;

        while (p != null && !p.getObject().equals(info)) {
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

    public int tamanho() {
        int cont = 0;
        for (Noh<Object> i = inicio; i != null; i = i.getProximo()) {
            cont++;
        }
        return cont;
    }

    public Noh<Object> getInicio() {
        return inicio;
    }
}