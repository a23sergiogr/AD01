package Ejercicios;

import java.net.URI;
import java.io.*;
import javax.swing.*;

public class Ej01_04_04 {
    public static void main(String[] args) throws Exception {


        URI uri1 = new URI("https://i.blogs.es/0ca9a6/aa/1366_2000.jpeg");
        URI uri2 = new URI("https://manuais.pages.iessanclemente.net/plantillas/dam/ad/01accesoficheros/01javaio/0104bytestream/");
        try (InputStream is = uri1.toURL().openStream();
             InputStreamReader isr = new InputStreamReader(is);
             FileOutputStream  os = new FileOutputStream("C:\\Users\\a23sergiogr\\Desktop\\AD\\a.jpeg")
             ) {

            int i = 0;
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
