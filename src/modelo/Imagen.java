package modelo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Esta es la definicion de la clase Imagen.
 *
 */
public class Imagen implements Cloneable {

    //Atributos de clase
    private File archivoImagen;
    private String nombre;
    private String formato;
    private short filas;
    private short columnas;
    private short matrizRojo[][];
    private short matrizVerde[][];
    private short matrizAzul[][];
    private short matrizGris[][];
    private BufferedImage bufferImagen;
    //factores de conversión a escala de grises
    private final float Alfa = 0.299f;
    private final float Beta = 0.587f;
    private final float Gama = 0.114f;

    /**
     * Metodo constructor por defecto, crea un objeto de la clase Imagen con
     * todos sus atributos a valores nulos.
     */
    public Imagen() {
    }

    /**
     * Metodo constructor que tiene como parametro la imagen en un objeto tipo
     * File y lo va a pasar a un objeto tipo BufferedImage
     *
     * @param rutaImagen
     */
    public Imagen(File rutaImagen) {
        bufferImagen = null;
        try {
            bufferImagen = ImageIO.read(rutaImagen);

            inicializaMatrices(bufferImagen);
        } catch (IOException ex) {
            Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        archivoImagen = rutaImagen;
        filas = (short) bufferImagen.getHeight();
        columnas = (short) bufferImagen.getWidth();
        nombre = rutaImagen.getName();

    }

    /**
     * Metodo que inicializa las matrices de los 3 canales de color de la
     * imagen. Inicializa la matriz que representa los pixeles en escala de
     * grises.
     *
     * @param BufferedImage
     */
    private void inicializaMatrices(BufferedImage imagenOriginal) {
        short[][] nuevaMatrizRojo = new short[imagenOriginal.getHeight()][imagenOriginal.getWidth()];
        short[][] nuevaMatrizVerde = new short[imagenOriginal.getHeight()][imagenOriginal.getWidth()];
        short[][] nuevaMatrizAzul = new short[imagenOriginal.getHeight()][imagenOriginal.getWidth()];
        short[][] nuevaMatrizGris = new short[imagenOriginal.getHeight()][imagenOriginal.getWidth()];

        Color colorPixel;

        for (int filas = 0; filas < imagenOriginal.getHeight(); filas++) {
            for (int columnas = 0; columnas < imagenOriginal.getWidth(); columnas++) {
                colorPixel = new Color(imagenOriginal.getRGB(columnas, filas));
                nuevaMatrizRojo[filas][columnas] = (short) colorPixel.getRed();
                nuevaMatrizVerde[filas][columnas] = (short) colorPixel.getGreen();
                nuevaMatrizAzul[filas][columnas] = (short) colorPixel.getBlue();
                //Aqui va la transformacion a gris
                nuevaMatrizGris[filas][columnas] = (short) Math.ceil((Alfa * (colorPixel.getRed())) + (Beta * (colorPixel.getGreen())) + (Gama * (colorPixel.getBlue())));
            }
        }
        setFormato("Imagen a color");
        //Inicializan las matrices Rojo, Verde y Azul.
        setMatrizRojo(nuevaMatrizRojo);
        setMatrizVerde(nuevaMatrizVerde);
        setMatrizAzul(nuevaMatrizAzul);
        setMatrizGris(nuevaMatrizGris);
    }

    public BufferedImage convierteMatrizEnBuffered(short[][] matrizModificada) {
        short pixelModificado;
        int pixelSRGB;
        BufferedImage imagenBuffered = new BufferedImage(matrizModificada[0].length, matrizModificada.length, 5);
        for (int filas = 0; filas < matrizModificada.length; filas++) {
            for (int columnas = 0; columnas < matrizModificada[0].length; columnas++) {
                pixelModificado = matrizModificada[filas][columnas];
                pixelSRGB = pixelModificado << 16 | pixelModificado << 8 | pixelModificado;
                imagenBuffered.setRGB(columnas, filas, pixelSRGB);
            }
        }
        return imagenBuffered;
    }

    public short[][] convierteBufferedEnMatriz(BufferedImage bufferedImage) {
        short[][] nuevaMatriz = new short[bufferedImage.getHeight()][bufferedImage.getWidth()];

        Color colorPixel;

        for (int filas = 0; filas < nuevaMatriz.length; filas++) {
            for (int columnas = 0; columnas < nuevaMatriz[0].length; columnas++) {
                colorPixel = new Color(bufferedImage.getRGB(columnas, filas));
                nuevaMatriz[filas][columnas] = (short) colorPixel.getRed();
            }
        }
        return nuevaMatriz;
    }

    /**
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public short getFilas() {
        return filas;
    }

    public void setFilas(short filas) {
        this.filas = filas;
    }

    public short getColumnas() {
        return columnas;
    }

    public void setColumnas(short columnas) {
        this.columnas = columnas;
    }

    public short[][] getMatrizRojo() {
        return matrizRojo;
    }

    public void setMatrizRojo(short[][] matrizRojo) {
        this.matrizRojo = matrizRojo;
    }

    public short[][] getMatrizVerde() {
        return matrizVerde;
    }

    public void setMatrizVerde(short[][] matrizVerde) {
        this.matrizVerde = matrizVerde;
    }

    public short[][] getMatrizAzul() {
        return matrizAzul;
    }

    public void setMatrizAzul(short[][] matrizAzul) {
        this.matrizAzul = matrizAzul;
    }

    public short[][] getMatrizGris() {
        return matrizGris;
    }

    public void setMatrizGris(short[][] matrizGris) {
        this.matrizGris = matrizGris;
    }

    public File getArchivoImagen() {
        return archivoImagen;
    }

    public void setArchivoImagen(File archivoImagen) {
        this.archivoImagen = archivoImagen;
    }

    public BufferedImage getBufferImagen() {
        return bufferImagen;
    }

    public void setBufferImagen(BufferedImage bufferImagen) {
        this.bufferImagen = bufferImagen;
    }

    @Override
    public Imagen clone() {
        Imagen copia = null;
        try {
            copia = (Imagen) super.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println("No se pudo clonar la imagen");
        }
        return copia;
    }

}
