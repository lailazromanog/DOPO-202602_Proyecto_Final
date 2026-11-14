# Notas de interfaz — DOPOSoccer

Registro de técnicas de Java Swing usadas en la capa de presentación que
NO se habían visto en los laboratorios del curso, con su fuente.

## 1. Cargar y dibujar una imagen (la cancha)

- **Dónde:** `src/presentation/FieldPanel.java`
- **Qué se usó:**
  - `java.awt.image.BufferedImage` para guardar la imagen en memoria.
  - `javax.imageio.ImageIO.read(File)` para leer el archivo `resources/cancha.png`.
  - `java.awt.Graphics.drawImage(...)` dentro de `paintComponent` para pintarla.
- **Por qué:** la cancha se definió como una imagen de fondo en vez de dibujarse
  con figuras, para lograr el aspecto del estadio.
- **Fuente / referencia:**
  - Oracle, *The Java Tutorials – Reading/Loading an Image*:
    https://docs.oracle.com/javase/tutorial/2d/images/loadimage.html
  - Oracle, *The Java Tutorials – Drawing an Image*:
    https://docs.oracle.com/javase/tutorial/2d/images/drawimage.html
  - API: `ImageIO.read`, `Graphics.drawImage`.
- **Relación con lo ya visto:** es el mismo `paintComponent(Graphics g)` de los
  laboratorios (Snake, EcoSafari); el cambio es pintar una imagen en vez de
  `fillRect`/`drawLine`.


  ## 2. Dibujar texto y HUD (marcador, cronómetro, barras de poder)

- **Dónde:** `src/presentation/FieldPanel.java`, dentro de `paintComponent`
- **Qué se usó:**
  - `java.awt.Font` para definir tipografía, estilo y tamaño del texto.
  - `java.awt.FontMetrics` para medir el ancho de un string en píxeles
    y poder centrarlo horizontalmente en el panel.
  - `Graphics.drawString(texto, x, y)` para pintar texto en pantalla.
  - `new Color(r, g, b, alpha)` con cuatro parámetros para crear un color
    semitransparente (el fondo oscuro del HUD).
  - `String.format("%d:%02d", min, seg)` para formatear el cronómetro.
- **Por qué:** el marcador, el cronómetro y las barras de poder son información
  que el jugador necesita ver todo el tiempo encima de la cancha.
- **Fuente / referencia:**
  - Oracle, *The Java Tutorials – Drawing Text*:
    https://docs.oracle.com/javase/tutorial/2d/text/drawmulstring.html
  - Oracle, *The Java Tutorials – Measuring Text*:
    https://docs.oracle.com/javase/tutorial/2d/text/measuringtext.html
  - API: `Font`, `FontMetrics.stringWidth`, `Graphics.drawString`.
- **Relación con lo ya visto:** `fillRect` y `drawRect` ya se usaron en labs;
  lo nuevo es `Font`, `FontMetrics`, `drawString` para texto, y el cuarto
  parámetro de `Color` para transparencia.