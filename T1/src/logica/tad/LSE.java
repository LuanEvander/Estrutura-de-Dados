package logica.tad;

import java.util.Iterator;

public class LSE implements ILista, Iterable<Object> {
    private Noh<Object> inicio;

    public LSE() {
        this.inicio = null;
    }

    @Override
    public void insereInicio(Object info) {
        Noh<Object> novo = new Noh<Object>(info);
        if (inicio == null) {
            inicio = novo;
        } else {
            novo.setProximo(inicio);
            inicio = novo;
        }
    }

    @Override
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

    @Override
    public boolean estahVazia() {
        return inicio == null;
    }

    @Override
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

    @Override
    public int tamanho() {
        int cont = 0;
        for (Noh<Object> i = inicio; i != null; i = i.getProximo()) {
            cont++;
        }
        return cont;
    }

    @Override
    public Iterator<Object> iterator() {
        return new LSEIterator();
    }

    private class LSEIterator implements Iterator<Object> {
        private Noh<Object> current;

        public LSEIterator() {
            this.current = inicio;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            Object info = current.getObject();
            current = current.getProximo();
            return info;
        }
    }

}
