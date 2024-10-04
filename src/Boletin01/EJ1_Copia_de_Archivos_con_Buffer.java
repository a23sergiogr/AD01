package Boletin01;

import javax.swing.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * <h6>Se realice un programa para copiar archivos. El programa debe recoger el
 * nombre del archivo origen y destino. Se existe debe solicitar confirmación sobrescribir.
 * Úsese I/O con buffer y métodos estáticos (tenga en cuenta que los archivos pueden ser
 * binarios).
 * <p>a) Para la lectura desde teclado puede emplearse la clase Scanner.
 * <p>b) Realiza el mismo ejercicio, pero empleando entradas desde ventana con JFileChooser y mensajes de error en JOptionPane, si los hay.
 * <p>c) Realiza un programa que lea con un JOptionPane pida una URL y para
 * posteriormente abrir un JFileChooser para guardarlo en el disco local.
 * Ayuda: para abrir un flujo de entrada a una URL puede hacerse con el
 * método openStream() de URL. Ten en cuenta que puede lanzar excepciones.
 * <b>InputStream in = new URL(FILE_URL).openStream();
 * <p>d) Mejora el aparado a) para que la lectura de los datos lo haga en bloques
 * (buffer) y no byte a byte.
 */
public class EJ1_Copia_de_Archivos_con_Buffer {
    public static void main(String[] args) {
        if (urlOrFile()==0)
            archivoEnDisco();
        else
            archivoEnUrl();
    }

    public static void archivoEnDisco() {
        JFileChooser copy = new JFileChooser("C:\\Users\\a23sergiogr\\Desktop\\AD");
        copy.showOpenDialog(null);
        JFileChooser save = new JFileChooser(copy.getSelectedFile());
        save.showSaveDialog(copy);

        try (var bis = new BufferedInputStream(new FileInputStream(copy.getSelectedFile()));
             var bos = new BufferedOutputStream(new FileOutputStream(save.getSelectedFile()))) {


            bos.write(bis.readAllBytes());

        } catch (IOException e) {
            exceptionMessage(e, null);
        } catch (NullPointerException e) {
            exceptionMessage(e, "Se debe introducir un archivo de origen y destino");
        }
    }

    public static void archivoEnUrl() {

        URI uri = null;
        try {
            uri = new URI(insertarURL());
        } catch (URISyntaxException e) {
            exceptionMessage(e, null);
        }

        JFileChooser save = new JFileChooser("C:\\Users\\a23sergiogr\\Desktop\\AD");
        save.showSaveDialog(null);

        File saveFile = save.getSelectedFile();
        if (saveFile.isFile()) {
            int s = sobreescribir();
            if (s != 0) {
                return;
            }
        }
        try (var bis = new BufferedInputStream(uri.toURL().openStream());
             var bos = new BufferedOutputStream(new FileOutputStream(saveFile))) {
            bos.write(bis.readAllBytes());

        } catch (IOException e) {
            exceptionMessage(e, null);
        } catch (NullPointerException e) {
            exceptionMessage(e, "Se debe introducir un archivo de origen y destino");
        }
    }

    public static String insertarURL() {
        return JOptionPane.showInputDialog(
                null,
                "URI",
                "Inserta URL Válida",
                JOptionPane.PLAIN_MESSAGE);
    }

    public static int urlOrFile() {
        Object[] o = {"Archivo Local", "URL"};
        return JOptionPane
                .showOptionDialog(null,
                        "Desea copiar un archivo local o de una url",
                        "Copiar",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        o,
                        o[0]);
    }

    public static int sobreescribir() {
        Object[] o = {"Yes", "No"};
        return JOptionPane
                .showOptionDialog(null,
                        "\nDeseas sobreescribir el archivo?",
                        "Sobreescribir?",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        o,
                        o[0]);
    }


    public static void exceptionMessage(Exception e, String opcMessage) {
        JOptionPane
                .showMessageDialog(null,
                        opcMessage + "\nERROR: " + e,
                        "Excepción",
                        JOptionPane.ERROR_MESSAGE);
    }
}
