import jdk.jfr.ContentType;

import java.net.URI;
import java.net.URL;
import java.io.*;
import javax.swing.*;

import static java.lang.System.out;

public class Ej01_04_04 {
    public static void main(String[] args) throws Exception {


        URI uri = new URI(insertarURL());
        try (InputStream is = uri.toURL().openStream();
             InputStreamReader isr = new InputStreamReader(is);
             FileOutputStream  os = new FileOutputStream((guardarResultado()))
             ) {

            ContentType contentType;

            int i = isr.read();
            while(i != -1){
                i = isr.read();
                os.write(i);
            }
        }
    }

    public static String insertarURL(){
        return JOptionPane.showInputDialog("Inserta URL Válida");
    }

    public static File guardarResultado(){
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int botonPulsado = fc.showSaveDialog(null);
        if (botonPulsado == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile();
        }
        return null;
    }
}
