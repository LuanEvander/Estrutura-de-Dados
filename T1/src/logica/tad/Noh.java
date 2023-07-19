package logica.tad;

public class Noh<T> {
    private Object obj;
    private Noh<Object> proximo;

    public Noh(Object objt) {
        this.obj = objt;
        this.proximo = null;
    }
    
    public Noh<Object> getProximo() {
        return proximo;
    }

    public void setProximo(Noh<Object> n) {
        this.proximo = n;
    }

    public Object getObject() {
        return obj;
    }
}
