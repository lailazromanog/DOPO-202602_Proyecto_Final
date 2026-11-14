package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
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
    
    // valores temporales para las barra de poder, luego meto dominio 
    private int golesJ1 = 0;
    private int golesJ2 = 0;
    private int tiempoSegundos = 180; 
    private double poderJ1 = 0.0;
    private double poderJ2 = 0.0;
    
    public FieldPanel() {
        // cargamos la imagen; puede fallar si no existe, por eso el try/catch
        try {
            File f = new File("resources/cancha.png");
            //System.out.println("Buscando imagen en: " + f.getAbsolutePath() + " existe? " + f.exists());
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

        //balon 
        int diametroBalon = getHeight()/9; 
        int xBalon = getWidth() / 2 - diametroBalon/2; 
        int yBalon = (int) (getHeight() * 0.78); //apoyado en el pasto 
        g.setColor(Color.WHITE);
        g.fillOval(xBalon, yBalon, diametroBalon, diametroBalon);
        g.setColor(Color.BLACK);
        g.drawOval(xBalon, yBalon, diametroBalon, diametroBalon);

        //marcador y cronometro 
        g.setColor(new Color(0, 0, 0, 150)); //negro con 150/255 de opacidad
        g.fillRect(0, 0, getWidth(), 40);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.setColor(Color.WHITE);
        FontMetrics fm = g.getFontMetrics();

        //marcador centrado 
        String marcador = golesJ1 + "-" + golesJ2; //despeus lo uno con el dominio, metodo Score
        int anchoMarcador = fm.stringWidth(marcador);
        g.drawString(marcador, (getWidth() - anchoMarcador)/2, 28);
        
        //etiquetas del jugador 1, el leftplayer y el 2, el rightplayer
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        FontMetrics fmSmall = g.getFontMetrics();
        g.drawString("J1", getWidth()/2 - anchoMarcador/2 - fmSmall.stringWidth("J1") - 8,28);
        g.drawString("J2", getWidth()/2 + anchoMarcador/2 + 8,28);

        //cronometro a la derecha
        int minutos = tiempoSegundos/ 60; 
        int segundos = tiempoSegundos % 60;
        String tiempo = String.format("%d:%02d",minutos, segundos);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        FontMetrics fmTime = g.getFontMetrics();
        g.drawString(tiempo, getWidth() - fmTime.stringWidth(tiempo)- 15, 28);
        

        //barras de poder
        int barW = 100; 
        int barH = 10;
        int barY = 20; 

        //barra leftplayer
        int barX1 = 15;
        g.setColor(Color.DARK_GRAY);
        g.fillRect(barX1, barY, barW, barH);
        g.setColor(new Color(0xE8A033));
        g.fillRect(barX1, barY, (int) (barW * poderJ1), barH);
        g.setColor(Color.WHITE);
        g.drawRect(barX1, barY, barW, barH);

        //barra rightplayer
        int barX2 =getWidth() - barW - 15;
        g.setColor(Color.DARK_GRAY);
        g.fillRect(barX2, barY, barW, barH);
        g.setColor(new Color(0xE8A033));
        g.fillRect(barX1, barY, (int) (barW * poderJ2), barH);
        g.setColor(Color.WHITE);
        g.drawRect(barX1, barY, barW, barH);


    }

    /**
     * Main para probar solo la cancha
     */
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Cancha DOPOSoccer");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(new FieldPanel());
        ventana.pack(); //ajusta la venta al tamaño preferido del panel 
        ventana.setLocationRelativeTo(null); //Centra en la pantalla 
        ventana.setVisible(true);
    }
}
