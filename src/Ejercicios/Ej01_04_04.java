package Ejercicios;

import java.net.HttpURLConnection;
import java.net.URI;
import java.io.*;
import java.net.URLConnection;
import javax.swing.*;

public class Ej01_04_04 {
    private static final String enlace = "https://i.blogs.es/0ca9a6/aa/1366_2000.jpeg";
    private static final String enlace2 = "https://manuais.pages.iessanclemente.net/plantillas/dam/ad/01accesoficheros/01javaio/0104bytestream/";

    public static void main(String[] args) throws Exception {

        URI uri = new URI(enlace);

        var connection = (HttpURLConnection)  uri.toURL().openConnection();
        connection.setRequestMethod("HEAD");
        connection.connect();
        String type = connection.getContentType().split("/")[1].split(";")[0];

        System.out.println(type);

        try (var bis = new BufferedInputStream(uri.toURL().openStream());
             var  bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\a23sergiogr\\Desktop\\AD\\a." + type))
             ) {

            int i = 0;
            while( (i = bis.read())!= -1){
                bos.write(i);
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
