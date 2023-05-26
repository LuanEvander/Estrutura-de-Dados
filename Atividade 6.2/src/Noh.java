public class Noh<T> {
    private Object info;
    private Noh<Object> ant;
    private Noh<Object> prox;

    public Noh(Object info) {
        this.info = info;
        this.ant = null;
        this.prox = null;
    }

    public Object getInfo() {
        return this.info;
    }

    public Noh<Object> getProximo() {
        return this.prox;
    }

    public void setProximo(Noh<Object> info) {
        this.prox = info;
    }

    public Noh<Object> getAnterior() {
        return this.ant;
    }

    public void setAnterior(Noh<Object> n) {
        this.ant = n;
    }
}