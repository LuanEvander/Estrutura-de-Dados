public class LDE implements ILista {
    private Noh inicio;
    private Noh fim;

    public LDE() {
        this.inicio = null;
        this.fim = null;
    }

    @Override
    public void insereInicio(int info) {
        Noh novo = new Noh(info);
        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            novo.setProximo(inicio);
            inicio.setAnterior(novo);
            inicio = novo;
        }
    }

    @Override
    public void insereFim(int info) {
        Noh novo = new Noh(info);
        if (fim == null) {
            inicio = novo;
            fim = novo;
        } else {
            novo.setAnterior(fim);
            fim.setProximo(novo);
            fim = novo;
        }
    }

    public boolean existe(int info) {
        Noh p = inicio;
        while (p != null && p.getInfo() != info) {
            p = p.getProximo();
        }
        if (p == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean estahVazia() {
        return inicio == null;
    }

    @Override
    public boolean remove(int info) {
        if (estahVazia() || !existe(info)) {
            return false;
        }
        Noh p = inicio;
        while (p != null && p.getInfo() != info) {
            p = p.getProximo();
        }
        if (p == null) {
            return false;
        }
        if (p == inicio) {
            inicio = inicio.getProximo();
            if (inicio != null) {
                inicio.setAnterior(null);
            } else {
                fim = null;
            }
        } else if (p == fim) {
            fim = fim.getAnterior();
            fim.setProximo(null);
        } else {
            p.getAnterior().setProximo(p.getProximo());
            p.getProximo().setAnterior(p.getAnterior());
        }
        return true;
    }

    @Override
    public int tamanho() {
        int cont = 0;
        Noh p = inicio;
        while (p != null) {
            cont++;
            p = p.getProximo();
        }
        return cont;
    }

    public void listarDoInicio() {
        Noh atual = inicio;

        while (atual != null) {
            System.out.print(atual.getInfo());
            System.out.print(" ");
            atual = atual.getProximo();
        }
        
    }

    public void listarDoFim() {
        Noh atual = fim;
    
        while (atual != null) {
            System.out.print(atual.getInfo());
            System.out.print(" ");
            atual = atual.getAnterior();
        }
    }
    
}
