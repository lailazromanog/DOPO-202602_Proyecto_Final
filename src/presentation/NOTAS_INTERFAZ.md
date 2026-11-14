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