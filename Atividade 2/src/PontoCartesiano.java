public class PontoCartesiano {
    private int x1; // Valor da primeira coordenada X
    private int x2; // Valor da segunda coordenada X
    private int y1; // Valor da primeira coordenada Y
    private int y2; // Valor da segunda coordenada Y

    /**
     * Construtor da classe PontoCartesiano
     * 
     * @param x1 Valor da primeira coordenada X
     * @param x2 Valor da segunda coordenada X
     * @param y1 Valor da primeira coordenada Y
     * @param y2 Valor da segunda coordenada Y 
     */
    public PontoCartesiano(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    // Construtor padrão
    public PontoCartesiano() {
    }

    /**
     * Método que calcula a distância euclidiana entre dois pontos
     * 
     * @return Retorna double como a distância euclidiana entre dois pontos
     */
    public double distanciaEuclidiana() {
        return Math.sqrt(Math.pow((this.x2 - this.x1), 2) + Math.pow((this.y2 - this.y1), 2));
    }

    /**
     * @return Retorna int como o valor da primeira coordenada X
     */
    public int getX1() {
        return x1;
    }

    /**
     * @param x1 Define um int como valor da primeira coordenada X
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * @return Retorna int como o valor da segunda coordenada X
     */
    public int getX2() {
        return x2;
    }

    /**
     * @param x2 Define um int como valor da segunda coordenada X
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }

    /**
     * @return Retorna int como o valor da primeira coordenada Y
     */
    public int getY1() {
        return y1;
    }

    /**
     * @param y1 Define um int como valor da primeira coordenada Y
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }

    /**
     * @return Retorna int como o valor da segunda coordenada Y
     */
    public int getY2() {
        return y2;
    }

    /**
     * @param y2 Define um int como valor da segunda coordenada Y
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }
}
