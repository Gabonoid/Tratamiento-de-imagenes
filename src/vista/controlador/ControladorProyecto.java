package vista.controlador;

import java.awt.event.ActionEvent;
import vista.*;
import modelo.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author UAEMEX
 */
public class ControladorProyecto implements ActionListener {

    private Principal objVentanaPrincipal;
    private Imagen objImagenOriginal;
    private Imagen objImagenProcesada;
    private File archivoImagen;

    public ControladorProyecto(Principal objVentana) {
        this.objVentanaPrincipal = objVentana;
        this.objVentanaPrincipal.menuItemAbrir.addActionListener(this);
        this.objVentanaPrincipal.menuItemGrises.addActionListener(this);
        this.objVentanaPrincipal.menuItem90.addActionListener(this);
        this.objVentanaPrincipal.menuItem180.addActionListener(this);
        this.objVentanaPrincipal.menuItem270.addActionListener(this);
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
    
    private void convertirEscalaGrises(){
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(objImagenProcesada.getMatrizGris()));
        //objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }
    
    private void girar90(){
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(FiltrosBasicos.girarNoventa(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }
    
    private void girar180(){
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(FiltrosBasicos.girarCientoOchenta(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }
    
    private void girar270(){
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(FiltrosBasicos.girarDoscientosSetenta(objImagenProcesada.convierteBufferedEnMatriz(objImagenProcesada.getBufferImagen()))));
        objVentanaPrincipal.labelImagenMuestra.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

}
