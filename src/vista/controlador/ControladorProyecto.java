package vista.controlador;

import Modelo.FFTException;
import Modelo.ImageFFT;
import java.awt.event.ActionEvent;
import vista.*;
import modelo.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ControladorProyecto implements ActionListener {

    public static Principal objVentanaPrincipal;
    public static Imagen objImagenOriginal;
    public static Imagen objImagenProcesada;
    public static Imagen imagenOperacion;
    private File archivoImagen;
    private PanelQ panelQ;
    private ConvolucionPanel convolucionPanel;
    private PanelUmbralizacion panelUmbralizacion;
    private PanelFilter panelFilter;
    private PanelFilterDuo panelFilterDuo;

    public ControladorProyecto(Principal objVentana) {
        this.objVentanaPrincipal = objVentana;
        this.objVentanaPrincipal.menuItemAbrir.addActionListener(this);
        this.objVentanaPrincipal.menuItemGrises.addActionListener(this);
        this.objVentanaPrincipal.menuItem90.addActionListener(this);
        this.objVentanaPrincipal.menuItem180.addActionListener(this);
        this.objVentanaPrincipal.menuItem270.addActionListener(this);
        this.objVentanaPrincipal.menuItemInverso.addActionListener(this);
        this.objVentanaPrincipal.menuItemUmbral.addActionListener(this);
        this.objVentanaPrincipal.menuItemZoom.addActionListener(this);
        this.objVentanaPrincipal.menuItemUmbralBinario.addActionListener(this);
        this.objVentanaPrincipal.menuItemUmbralGris.addActionListener(this);
        this.objVentanaPrincipal.menuItemExtension.addActionListener(this);
        this.objVentanaPrincipal.menuItemReduccionGrises.addActionListener(this);
        this.objVentanaPrincipal.menuItemSuma.addActionListener(this);
        this.objVentanaPrincipal.menuItemResta.addActionListener(this);
        this.objVentanaPrincipal.menuItemNOT.addActionListener(this);
        this.objVentanaPrincipal.menuItemOR.addActionListener(this);
        this.objVentanaPrincipal.menuItemAND.addActionListener(this);
        this.objVentanaPrincipal.menuItemXOR.addActionListener(this);
        this.objVentanaPrincipal.menuItemMediaAritmetica.addActionListener(this);
        this.objVentanaPrincipal.menuItemMediaGeometrica.addActionListener(this);
        this.objVentanaPrincipal.menuItemMediaContraArmonica.addActionListener(this);
        this.objVentanaPrincipal.menuItemEstadisticoMediana.addActionListener(this);
        this.objVentanaPrincipal.menuItemEstadisticoMaximo.addActionListener(this);
        this.objVentanaPrincipal.menuItemEstadisticoMinimo.addActionListener(this);
        this.objVentanaPrincipal.menuItemEstadisticoPuntoAPunto.addActionListener(this);
        this.objVentanaPrincipal.menuItemMediaSeccion.addActionListener(this);
        this.objVentanaPrincipal.menuItemConvolucion.addActionListener(this);
        this.objVentanaPrincipal.menuItemEspectro.addActionListener(this);
        this.objVentanaPrincipal.menuItemIdealLowPassFilter.addActionListener(this);
        this.objVentanaPrincipal.menuItemLowPassFilter.addActionListener(this);
        this.objVentanaPrincipal.menuItemIdealHighPassFilter.addActionListener(this);
        this.objVentanaPrincipal.menuItemIdealHighPassFilterOrden.addActionListener(this);
        this.objVentanaPrincipal.menuItemCMY.addActionListener(this);
        this.objVentanaPrincipal.menuItemIntensidad.addActionListener(this);
        this.objVentanaPrincipal.menuItemMatiz.addActionListener(this);
        this.objVentanaPrincipal.menuItemSaturacion.addActionListener(this);
        this.objVentanaPrincipal.menuItemErocion.addActionListener(this);
        this.objVentanaPrincipal.menuItemDilatacion.addActionListener(this);

        this.objVentanaPrincipal.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Cierra ventana");
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Abrir")) {
            System.out.println("Diste click en el menu Abrir");
            abrirArchivoImagen();
        }
        if (e.getActionCommand().equals("Escala de Grises")) {
            System.out.println("Diste click en el menu Escala de Grises");
            convertirEscalaGrises();
        }
        if (e.getActionCommand().equals("90°")) {
            System.out.println("Diste click en rotar 90");
            girar90();
        }
        if (e.getActionCommand().equals("180°")) {
            System.out.println("Diste click en rotar 180");
            girar180();
        }
        if (e.getActionCommand().equals("270°")) {
            System.out.println("Diste click en rotar 270");
            girar270();
        }
        if (e.getActionCommand().equals("Inverso")) {
            System.out.println("Diste click en Inverso");
            inverso();
        }
        if (e.getActionCommand().equals("Interpolacion")) {
            System.out.println("Diste click en Interpolacion");
            interpolacion();
        }
        if (e.getActionCommand().equals("Umbral")) {
            System.out.println("Diste click en Umbral");
            panelUmbralizacion = new PanelUmbralizacion();
            objVentanaPrincipal.parametrosUmbralizacion.add(panelUmbralizacion);
            panelUmbralizacion.setSize(135, 150);
            panelUmbralizacion.setVisible(true);
            umbral();
        }
        if (e.getActionCommand().equals("Umbral Binario")) {
            System.out.println("Diste click en Umbral Binario");
            panelUmbralizacion = new PanelUmbralizacion();
            objVentanaPrincipal.parametrosUmbralizacion.add(panelUmbralizacion);
            panelUmbralizacion.setSize(135, 150);
            panelUmbralizacion.setVisible(true);
            umbralBinario();
        }
        if (e.getActionCommand().equals("Umbral Gris")) {
            System.out.println("Diste click en Umbral Gris");
            panelUmbralizacion = new PanelUmbralizacion();
            objVentanaPrincipal.parametrosUmbralizacion.add(panelUmbralizacion);
            panelUmbralizacion.setSize(135, 150);
            panelUmbralizacion.setVisible(true);
            umbralGris();
        }
        if (e.getActionCommand().equals("Extension")) {
            System.out.println("Diste click en Extension");
            panelUmbralizacion = new PanelUmbralizacion();
            objVentanaPrincipal.parametrosUmbralizacion.add(panelUmbralizacion);
            panelUmbralizacion.setSize(135, 150);
            panelUmbralizacion.setVisible(true);
            extension();
        }
        if (e.getActionCommand().equals("Reduccion de Grises")) {
            System.out.println("Diste click en Reduccion de Grises");
            reduccionGrises();
        }

        if (e.getActionCommand().equals("Suma")) {
            System.out.println("Diste click en Suma");
            JFileChooser fileChooser = new JFileChooser();
            File imagenDos = null;
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, BMP, PNG", "jpg", "bmp", "png");
            fileChooser.setFileFilter(filter);
            fileChooser.setAcceptAllFileFilterUsed(false);
            int respuesta = fileChooser.showOpenDialog(objVentanaPrincipal);
            if (respuesta == JFileChooser.APPROVE_OPTION && fileChooser.getSelectedFile().exists()) {
                System.out.println("Abriste el archivo: " + fileChooser.getSelectedFile().getName());
                imagenDos = fileChooser.getSelectedFile();
            } else {
                System.out.println("Archivo no valido");
            }
            imagenOperacion = new Imagen(imagenDos);
            suma();
        }

        if (e.getActionCommand().equals("Resta")) {
            System.out.println("Diste click en Resta");
            JFileChooser fileChooser = new JFileChooser();
            File imagenDos = null;
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, BMP, PNG", "jpg", "bmp", "png");
            fileChooser.setFileFilter(filter);
            fileChooser.setAcceptAllFileFilterUsed(false);
            int respuesta = fileChooser.showOpenDialog(objVentanaPrincipal);
            if (respuesta == JFileChooser.APPROVE_OPTION && fileChooser.getSelectedFile().exists()) {
                System.out.println("Abriste el archivo: " + fileChooser.getSelectedFile().getName());
                imagenDos = fileChooser.getSelectedFile();
            } else {
                System.out.println("Archivo no valido");
            }
            imagenOperacion = new Imagen(imagenDos);
            resta();
        }
        if (e.getActionCommand().equals("NOT")) {
            System.out.println("Diste click en NOT");
            not();
        }
        if (e.getActionCommand().equals("AND")) {
            System.out.println("Diste click en AND");
            JFileChooser fileChooser = new JFileChooser();
            File imagenDos = null;
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, BMP, PNG", "jpg", "bmp", "png");
            fileChooser.setFileFilter(filter);
            fileChooser.setAcceptAllFileFilterUsed(false);
            int respuesta = fileChooser.showOpenDialog(objVentanaPrincipal);
            if (respuesta == JFileChooser.APPROVE_OPTION && fileChooser.getSelectedFile().exists()) {
                System.out.println("Abriste el archivo: " + fileChooser.getSelectedFile().getName());
                imagenDos = fileChooser.getSelectedFile();
            } else {
                System.out.println("Archivo no valido");
            }
            imagenOperacion = new Imagen(imagenDos);
            and();
        }
        if (e.getActionCommand().equals("XOR")) {
            System.out.println("Diste click en XOR");
            JFileChooser fileChooser = new JFileChooser();
            File imagenDos = null;
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, BMP, PNG", "jpg", "bmp", "png");
            fileChooser.setFileFilter(filter);
            fileChooser.setAcceptAllFileFilterUsed(false);
            int respuesta = fileChooser.showOpenDialog(objVentanaPrincipal);
            if (respuesta == JFileChooser.APPROVE_OPTION && fileChooser.getSelectedFile().exists()) {
                System.out.println("Abriste el archivo: " + fileChooser.getSelectedFile().getName());
                imagenDos = fileChooser.getSelectedFile();
            } else {
                System.out.println("Archivo no valido");
            }
            imagenOperacion = new Imagen(imagenDos);
            xor();
        }

        if (e.getActionCommand().equals("OR")) {
            System.out.println("Diste click en OR");
            JFileChooser fileChooser = new JFileChooser();
            File imagenDos = null;
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, BMP, PNG", "jpg", "bmp", "png");
            fileChooser.setFileFilter(filter);
            fileChooser.setAcceptAllFileFilterUsed(false);
            int respuesta = fileChooser.showOpenDialog(objVentanaPrincipal);
            if (respuesta == JFileChooser.APPROVE_OPTION && fileChooser.getSelectedFile().exists()) {
                System.out.println("Abriste el archivo: " + fileChooser.getSelectedFile().getName());
                imagenDos = fileChooser.getSelectedFile();
            } else {
                System.out.println("Archivo no valido");
            }
            imagenOperacion = new Imagen(imagenDos);
            or();
        }
        if (e.getActionCommand().equals("Media Aritmetica")) {
            System.out.println("Diste click en Media Aritmetica");
            mediaAritmetica();
        }
        if (e.getActionCommand().equals("Media Geometrica")) {
            System.out.println("Diste click en Media Geometrica");
            mediaGeometrica();
        }
        if (e.getActionCommand().equals("Media Contra Armonica")) {
            System.out.println("Diste click en Media Contra Armonica");
            panelQ = new PanelQ();
            objVentanaPrincipal.parametrosUmbralizacion.add(panelQ);
            panelQ.setSize(135, 150);
            panelQ.setVisible(true);
            mediaContraArmonica();
        }
        if (e.getActionCommand().equals("Estadistico Mediana")) {
            System.out.println("Diste click en Estadistico Mediana");
            estadisticoMediana();
        }
        if (e.getActionCommand().equals("Estadistico Maximo")) {
            System.out.println("Diste click en Estadistico Maximo");
            estadisticoMaximo();
        }
        if (e.getActionCommand().equals("Estadistico Minimo")) {
            System.out.println("Diste click en Estadistico Minimo");
            estadisticoMinimo();
        }
        if (e.getActionCommand().equals("Estadistico Punto A Punto")) {
            System.out.println("Diste click en Estadistico Punto A Punto");
            estadisticoPuntoAPunto();
        }
        if (e.getActionCommand().equals("Media Seccion")) {
            System.out.println("Diste click en Media Seccion");
            panelQ = new PanelQ();
            objVentanaPrincipal.parametrosUmbralizacion.add(panelQ);
            panelQ.setSize(135, 150);
            panelQ.setVisible(true);
            mediaSeccion();
        }
        if (e.getActionCommand().equals("Convolucion")) {
            System.out.println("Diste click en Convolucion");
            convolucion();
        }

        if (e.getActionCommand().equals("Espectro")) {
            System.out.println("Diste click en Espectro");
            try {
                dominioFrecuencia();
            } catch (FFTException ex) {
                Logger.getLogger(ControladorProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getActionCommand().equals("Ideal Low Pass Filter")) {
            System.out.println("Diste click en Idea lLow Pass Filter");
            try {
                idealLowPassFilter();
            } catch (FFTException ex) {
                Logger.getLogger(ControladorProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getActionCommand().equals("Low Pass Filter")) {
            System.out.println("Diste click en Low Pass Filter");
            butterworthLowPassFilter();
        }
        if (e.getActionCommand().equals("Ideal High Pass Filter")) {
            System.out.println("Diste click en Ideal High Pass Filter");
            idealHighPassFilter();
        }
        if (e.getActionCommand().equals("Ideal High Pass Filter Orden")) {
            System.out.println("Diste click en Ideal High Pass Filter Orden");
            idealHighPassFilterOrden();
        }
        if (e.getActionCommand().equals("Convertir en CMY")) {
            System.out.println("Diste click en Convertir en CMY");
            convertirCMY();
        }
        if (e.getActionCommand().equals("Intensidad")) {
            System.out.println("Diste click en Intensidad");
            Intensidad();
        }
        if (e.getActionCommand().equals("Matiz")) {
            System.out.println("Diste click en Matiz");
            Matiz();
        }
        if (e.getActionCommand().equals("Saturacion")) {
            System.out.println("Diste click en Saturacion");
            Saturacion();
        }
        if (e.getActionCommand().equals("Erocion")) {
            System.out.println("Diste click en Erocion");
            erocion();
        }
        if (e.getActionCommand().equals("Dilatacion")) {
            System.out.println("Diste click en Dilatacion");
            dilatacion();
        }

    }

    private void abrirArchivoImagen() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, BMP, PNG", "jpg", "bmp", "png");
        fileChooser.setFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        int respuesta = fileChooser.showOpenDialog(objVentanaPrincipal);
        if (respuesta == JFileChooser.APPROVE_OPTION && fileChooser.getSelectedFile().exists()) {
            System.out.println("Tu elegiste abrir este archivo: "
                    + fileChooser.getSelectedFile().getName());
            archivoImagen = fileChooser.getSelectedFile();
        } else {
            System.out.println("No se selecciono un archivo de imagen");
        }
        AbreArchivoImagen();
    }

    private void AbreArchivoImagen() {
        objImagenOriginal = new Imagen(archivoImagen);
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenOriginal.getBufferImagen()));
        objImagenProcesada = objImagenOriginal.clone();
    }

    private void convertirEscalaGrises() {
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(objImagenProcesada.getMatrizGris()));
        //objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void girar90() {
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(FiltrosBasicos.girarNoventa(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void girar180() {
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(FiltrosBasicos.girarCientoOchenta(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void girar270() {
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(FiltrosBasicos.girarDoscientosSetenta(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void inverso() {
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(Umbralizacion.inverso(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void interpolacion() {
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(FiltrosBasicos.interpolacion(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void umbral() {
        PanelUmbralizacion panel = new PanelUmbralizacion();
        PanelUmbralizacion.llave = 1;
        panel.getBtnCalcular();
    }

    private void umbralBinario() {
        PanelUmbralizacion panel = new PanelUmbralizacion();
        PanelUmbralizacion.llave = 2;
        panel.getBtnCalcular();
    }

    private void umbralGris() {
        PanelUmbralizacion panel = new PanelUmbralizacion();
        PanelUmbralizacion.llave = 3;
        panel.getBtnCalcular();
    }

    private void extension() {
        PanelUmbralizacion panel = new PanelUmbralizacion();
        PanelUmbralizacion.llave = 4;
        panel.getBtnCalcular();
    }

    private void reduccionGrises() {
        objImagenProcesada.
                setBufferImagen(objImagenProcesada.
                        convierteMatrizEnBuffered(Umbralizacion.
                                reduccionGrises(objImagenProcesada.
                                        convierteBufferedEnMatriz(objImagenProcesada.
                                                getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.
                setIcon(new ImageIcon(objImagenProcesada.
                        getBufferImagen()));
    }

    private void suma() {
        objImagenProcesada.setBufferImagen(objImagenOriginal.convierteMatrizEnBuffered(Operaciones.suma(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()), imagenOperacion.convierteBufferedEnMatriz(imagenOperacion.getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void resta() {
        objImagenProcesada.setBufferImagen(objImagenOriginal.convierteMatrizEnBuffered(Operaciones.resta(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()), imagenOperacion.convierteBufferedEnMatriz(imagenOperacion.getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void not() {
        objImagenProcesada.setBufferImagen(objImagenOriginal.convierteMatrizEnBuffered(Operaciones.NOT(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void and() {
        objImagenProcesada.setBufferImagen(objImagenOriginal.convierteMatrizEnBuffered(Operaciones.AND(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()), imagenOperacion.convierteBufferedEnMatriz(imagenOperacion.getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void xor() {
        objImagenProcesada.setBufferImagen(objImagenOriginal.convierteMatrizEnBuffered(Operaciones.XOR(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()), imagenOperacion.convierteBufferedEnMatriz(imagenOperacion.getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void or() {
        objImagenProcesada.setBufferImagen(objImagenOriginal.convierteMatrizEnBuffered(Operaciones.OR(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()), imagenOperacion.convierteBufferedEnMatriz(imagenOperacion.getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void mediaAritmetica() {
        objImagenProcesada.setBufferImagen(objImagenOriginal.convierteMatrizEnBuffered(Media.mediaAritmetica(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void mediaGeometrica() {
        objImagenProcesada.setBufferImagen(objImagenOriginal.convierteMatrizEnBuffered(Media.mediaGeometrica(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void mediaContraArmonica() {
        PanelQ panel = new PanelQ();
        PanelQ.llave = 1;
        panel.getjButton1();
    }

    private void estadisticoMediana() {
        objImagenProcesada.setBufferImagen(objImagenOriginal.convierteMatrizEnBuffered(Media.EstadisticoMediana(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void estadisticoMaximo() {
        objImagenProcesada.setBufferImagen(objImagenOriginal.convierteMatrizEnBuffered(Media.EstadisticoMaximo(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void estadisticoMinimo() {
        objImagenProcesada.setBufferImagen(objImagenOriginal.convierteMatrizEnBuffered(Media.EstadisticoMinimo(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void estadisticoPuntoAPunto() {
        objImagenProcesada.setBufferImagen(objImagenOriginal.convierteMatrizEnBuffered(Media.EstadisticoPuntoAPunto(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void mediaSeccion() {
        PanelQ panel = new PanelQ();
        PanelQ.llave = 2;
        panel.getjButton1();
    }

    private void convolucion() {
        convolucionPanel = new ConvolucionPanel();
        convolucionPanel.setSize(265, 209);
        objVentanaPrincipal.parametrosUmbralizacion.add(convolucionPanel);
        convolucionPanel.jButton1.addActionListener((x) -> {

            double a = (double) Double.parseDouble(convolucionPanel.jTextField00.getText());
            double b = (double) Double.parseDouble(convolucionPanel.jTextField01.getText());
            double c = (double) Double.parseDouble(convolucionPanel.jTextField02.getText());

            double d = (double) Double.parseDouble(convolucionPanel.jTextField03.getText());
            double e = (double) Double.parseDouble(convolucionPanel.jTextField04.getText());
            double f = (double) Double.parseDouble(convolucionPanel.jTextField05.getText());

            double g = (double) Double.parseDouble(convolucionPanel.jTextField06.getText());
            double h = (double) Double.parseDouble(convolucionPanel.jTextField07.getText());
            double i = (double) Double.parseDouble(convolucionPanel.jTextField08.getText());

            short[][] guardar = new short[3][3];

            guardar[0][0] = (short) a;
            guardar[0][1] = (short) b;
            guardar[0][2] = (short) c;
            guardar[1][0] = (short) d;
            guardar[1][1] = (short) e;
            guardar[1][2] = (short) f;
            guardar[2][0] = (short) g;
            guardar[2][1] = (short) h;
            guardar[2][2] = (short) i;

            objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(Convolucion.convolucion(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()), guardar)));
            objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));

        });
    }

    private void dominioFrecuencia() throws FFTException {
        ImageFFT imagenFFT = new ImageFFT(objImagenProcesada.getBufferImagen());
        imagenFFT.transform();
        BufferedImage dominio = imagenFFT.getSpectrum();
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(dominio));
    }

    private void idealLowPassFilter() throws FFTException {

        panelFilter = new PanelFilter();
        objVentanaPrincipal.parametrosUmbralizacion.add(panelFilter);
        panelFilter.setSize(102, 74);

        panelFilter.setVisible(true);

        panelFilter.btnCalcular.addActionListener((x) -> {

            ImageFFT ftt = null;
            try {
                ftt = new ImageFFT(objImagenProcesada.getBufferImagen());
            } catch (FFTException ex) {
                Logger.getLogger(ControladorProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(ftt.toString());

            ftt.transform();

            if (ftt.isSpectral()) {

                System.out.println("El espectro ya existe");
            }

            double grados = (double) Double.parseDouble(panelFilter.textFieldGrados.getText());

            if (grados >= 0 && grados <= 360) {

                grados = grados / 360;
                try {
                    ftt.idealLowPassFilter(grados);
                    ftt.transform();
                    BufferedImage ImagenFiltro = ftt.toImage(null);

                    objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(ImagenFiltro));

                } catch (FFTException ex) {
                    Logger.getLogger(ControladorProyecto.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {

                JOptionPane.showMessageDialog(null, "El valor no esta dentro del rango");

            }

        });

    }

    private void butterworthLowPassFilter() {

        panelFilterDuo = new PanelFilterDuo();
        objVentanaPrincipal.parametrosUmbralizacion.add(panelFilterDuo);
        panelFilterDuo.setSize(102, 104);

        panelFilterDuo.setVisible(true);

        panelFilterDuo.btnCalcular.addActionListener((x) -> {

            ImageFFT ftt = null;
            try {
                ftt = new ImageFFT(objImagenProcesada.getBufferImagen());
            } catch (FFTException ex) {
                Logger.getLogger(ControladorProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(ftt.toString());

            ftt.transform();

            if (ftt.isSpectral()) {

                System.out.println("El espectro ya existe");
            }

            double grados = Double.parseDouble(panelFilterDuo.jTextFieldGrados.getText());
            int orden = Integer.parseInt(panelFilterDuo.jTextFieldOrden.getText());

            if (grados >= 0 && grados <= 360) {

                grados = grados / 360;
                try {
                    ftt.butterworthLowPassFilter(orden, grados);
                    ftt.transform();
                    BufferedImage ImagenFiltro = ftt.toImage(null);

                    objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(ImagenFiltro));

                } catch (FFTException ex) {
                    Logger.getLogger(ControladorProyecto.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {

                JOptionPane.showMessageDialog(null, "El valor no esta dentro del rango");

            }

        });

    }

    private void idealHighPassFilter() {

        panelFilter = new PanelFilter();
        objVentanaPrincipal.parametrosUmbralizacion.add(panelFilter);
        panelFilter.setSize(102, 74);

        panelFilter.setVisible(true);

        panelFilter.btnCalcular.addActionListener((x) -> {

            ImageFFT ftt = null;
            try {
                ftt = new ImageFFT(objImagenProcesada.getBufferImagen());
            } catch (FFTException ex) {
                Logger.getLogger(ControladorProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(ftt.toString());

            ftt.transform();

            if (ftt.isSpectral()) {

                System.out.println("El espectro ya existe");
            }

            double grados = (double) Double.parseDouble(panelFilter.textFieldGrados.getText());

            if (grados >= 0 && grados <= 360) {

                grados = grados / 360;
                try {
                    ftt.butterworthHighPassFilter(grados);
                    ftt.transform();
                    BufferedImage ImagenFiltro = ftt.toImage(null);

                    objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(ImagenFiltro));

                } catch (FFTException ex) {
                    Logger.getLogger(ControladorProyecto.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {

                JOptionPane.showMessageDialog(null, "El valor no esta dentro del rango");

            }

        });

    }

    private void idealHighPassFilterOrden() {

        panelFilterDuo = new PanelFilterDuo();
        objVentanaPrincipal.parametrosUmbralizacion.add(panelFilterDuo);
        panelFilterDuo.setSize(102, 104);

        panelFilterDuo.setVisible(true);

        panelFilterDuo.btnCalcular.addActionListener((x) -> {

            ImageFFT ftt = null;
            try {
                ftt = new ImageFFT(objImagenProcesada.getBufferImagen());
            } catch (FFTException ex) {
                Logger.getLogger(ControladorProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(ftt.toString());

            ftt.transform();

            if (ftt.isSpectral()) {

                System.out.println("El espectro ya existe");
            }

            double grados = Double.parseDouble(panelFilterDuo.jTextFieldGrados.getText());
            int orden = Integer.parseInt(panelFilterDuo.jTextFieldOrden.getText());

            if (grados >= 0 && grados <= 360) {

                grados = grados / 360;
                try {
                    ftt.butterworthHighPassFilter(orden, grados);
                    ftt.transform();
                    BufferedImage ImagenFiltro = ftt.toImage(null);

                    objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(ImagenFiltro));

                } catch (FFTException ex) {
                    Logger.getLogger(ControladorProyecto.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {

                JOptionPane.showMessageDialog(null, "El valor no esta dentro del rango");

            }

        });

    }

    private void convertirCMY() {
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBufferedCMY(objImagenProcesada.getMatrizCian(), objImagenProcesada.getMatrizMagenta(), objImagenProcesada.getMatrizAmarillo()));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void Intensidad() {
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(HSI.Intensidad(objImagenProcesada.getMatrizRojo(), objImagenProcesada.getMatrizVerde(), objImagenProcesada.getMatrizAzul())));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void Matiz() {
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(HSI.Matiz(objImagenProcesada.getMatrizRojo(), objImagenProcesada.getMatrizVerde(), objImagenProcesada.getMatrizAzul())));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void Saturacion() {
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(HSI.Saturacion(objImagenProcesada.getMatrizRojo(), objImagenProcesada.getMatrizVerde(), objImagenProcesada.getMatrizAzul())));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void erocion() {
        short mascara[][] = new short[3][3];
        for (int i = 0; i < mascara.length; i++) {
            for (int j = 0; j < mascara.length; j++) {
                mascara[i][j] = 1;
            }
        }
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(Morfologicas.erocion((objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen())), mascara)));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    private void dilatacion() {
        short mascara[][] = new short[3][3];
        for (int i = 0; i < mascara.length; i++) {
            for (int j = 0; j < mascara.length; j++) {
                mascara[i][j] = 1;
            }
        }
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(Morfologicas.dilatacion(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

}
