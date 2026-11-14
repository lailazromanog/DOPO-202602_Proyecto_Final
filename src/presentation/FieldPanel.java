package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Pantalla de la cancha
 * Carga la imagen del estadio desde la carpeta de recursos y la dibuja como fondo.
 * Primera pieza de la interfaz construida
 * 
 */
//Nuevo: cargar una imagen con ImageIO y printarla con Graphics.drawImage 
public class FieldPanel extends JPanel {
    
    // la imagen de la cancha ya cargada
    private BufferedImage cancha;
    
    public FieldPanel() {
        // cargamos la imagen; puede fallar si no existe, por eso el try/catch
        try {
            File f = new File("resources/cancha.png");
            System.out.println("Buscando imagen en: " + f.getAbsolutePath() + "  | existe? " + f.exists());
            cancha = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println("No se pudo cargar la cancha: " + e.getMessage());
        }
        // el tamaño preferido del panel = tamaño real de la imagen
        setPreferredSize(new Dimension(769, 450));
    }

    /**
     * Swing llama para dibujar el panel, aqui pintamos la imagen
     */
    @Override
    protected  void paintComponent(Graphics g){
        super.paintComponent(g); //limpiamos antes de dibujar el fondo 
        if(cancha != null){
            //dibujamos la imagen desde la esquina, estirada al tamaño actual
            //actual del panel, para que se adapta por si cambiamos de ventana 
            g.drawImage(cancha, 0, 0, getWidth(), getHeight(), this);
        }
        //jugadores, las cabezas 
        int diametro = getHeight()/5; //tamaño de cada cabeza 
        int y = (int) (getHeight()*0.70); //altura, paradas sobre el pasto de la imagen 
         
        //jugador 1, izquierda, color naranja
        int leftPlayer = (int) (getWidth() * 0.18);
        g.setColor(new Color(0xE8A033)); //color de relleno
        g.fillOval(leftPlayer, y, diametro, diametro); //ciculo relleno
        g.setColor(Color.BLACK);
        g.drawOval(leftPlayer, y, diametro, diametro); //borde negro

        //jugador 2, derecha, color rojo
        int rightPlayer = (int) (getWidth() * 0.82) - diametro; 
        g.setColor(new Color(0xDD1144));
        g.fillOval(rightPlayer, y, diametro, diametro);
        g.setColor(Color.BLACK);
        g.drawOval(rightPlayer, y, diametro, diametro);
    }

    /**
     * Main para probar solo la cancha
     */
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Cancha DOPOScoccer");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(new FieldPanel());
        ventana.pack(); //ajusta la venta al tamaño preferido del panel 
        ventana.setLocationRelativeTo(null); //Centra en la pantalla 
        ventana.setVisible(true);
    }
}
