public class Noh {
    private int info;
    private Noh ant;
    private Noh prox;

    public Noh(int info) {
        this.info = info;
        this.ant = null;
        this.prox = null;
    }

    public int getInfo() {
        return this.info;
    }

    public Noh getProximo() {
        return this.prox;
    }

    public void setProximo(Noh n) {
        this.prox = n;
    }

    public Noh getAnterior() {
        return this.ant;
    }

    public void setAnterior(Noh n) {
        this.ant = n;
    }
}