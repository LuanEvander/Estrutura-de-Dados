import javax.swing.*;
import java.awt.*;

public class PlanoCartesiano extends JPanel {
    private final PontoCartesiano ponto;
    private int escala;

    public PlanoCartesiano(PontoCartesiano ponto, int escala) {
        this.ponto = ponto;
        this.escala = escala;
        setPreferredSize(new Dimension(650, 650)); // Define o tamanho do painel
    }

    /**
     * Método que desenha o plano cartesiano e os pontos X e Y
     * 
     * @param g Objeto Graphics para desenhar o plano cartesiano e os pontos X e Y
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int centroX = getWidth() / 2;
        int centroY = getHeight() / 2;

        // Desenha os eixos do plano cartesiano
        g.drawLine(0, centroY, getWidth(), centroY);
        g.drawLine(centroX, 0, centroX, getHeight());

        // Desenha as marcas dos eixos X e Y
        for (int i = -10; i <= 10; i++) {
            int x = centroX + i * escala;
            int y = centroY + i * escala;
            g.drawLine(x, centroY - 5, x, centroY + 5);
            g.drawLine(centroX - 5, y, centroX + 5, y);
            g.setColor(Color.BLUE);
            g.drawString(Integer.toString(i), x - 5, centroY - 15);
            g.drawString(Integer.toString(-i), centroX + 5, y + 5);
        }

        // Calcula as coordenadas dos pontos X e Y no plano cartesiano
        int x1 = centroX + ponto.getX1() * escala;
        int x2 = centroX + ponto.getX2() * escala;
        int y1 = centroY - ponto.getY1() * escala;
        int y2 = centroY - ponto.getY2() * escala;

        // Desenha os pontos X e Y no plano cartesiano
        g.setColor(Color.RED);
        g.fillOval(x1 - 4, y1 - 4, 8, 8);
        g.fillOval(x2 - 4, y2 - 4, 8, 8);

        // Desenha o segmento de reta da hipotenusa
        g.setColor(Color.BLUE);
        g.drawLine(x1, y1, x2, y2);

        // Desenha os pontilhados dos catetos
        g.setColor(Color.BLACK);
        float[] dash = {5.0f};
        BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
                5.0f, dash, 0.0f);
        ((Graphics2D) g).setStroke(dashed);
        g.drawLine(x1, y1, x2, y1);
        g.drawLine(x2, y1, x2, y2);

        // Desenha o valor da distância euclidiana entre os pontos X e Y
        g.setColor(Color.BLACK);
        double distancia = ponto.distanciaEuclidiana();
        g.drawString("d = " + String.format("%.2f", distancia), centroX + 270, centroY - 300);
    }

}
