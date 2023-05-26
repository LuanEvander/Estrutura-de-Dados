public class Noh {
    private int info;
    private Noh proximo;

    public Noh(int info) {
        this.info = info;
        this.proximo = null;
    }
    
    public Noh getProximo() {
        return proximo;
    }

    public void setProximo(Noh n) {
        this.proximo = n;
    }

    public int getInfo() {
        return info;
    }
}