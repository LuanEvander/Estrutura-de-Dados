import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        // Cria um objeto PontoCartesiano com as coordenadas X(2,3) e Y(5,7)
        PontoCartesiano ponto = new PontoCartesiano(2, 5, 3, 8); 
        
        // Cria um objeto PlanoCartesiano com o objeto PontoCartesiano
        PlanoCartesiano plano = new PlanoCartesiano(ponto, 30); 
        
        // Cria um objeto JFrame com o título "Plano Cartesiano"
        JFrame frame = new JFrame("Plano Cartesiano"); 
        
        // Define a ação padrão de fechar o JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        frame.getContentPane().add(plano); // Adiciona o objeto PlanoCartesiano ao JFrame
        frame.pack(); // Ajusta o tamanho do JFrame
        frame.setLocationRelativeTo(null); // Centraliza o JFrame na tela
        frame.setVisible(true); // Exibe o JFrame
    }
}
