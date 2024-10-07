package Ejercicios_02;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Ej1_Path_Paths_Files {
    public static void main(String[] args) throws IOException {
        //exiteRuta("src");
        //copiar("prueba.txt", "pruebaFiles.txt");
        extension();
    }

    //Escribe un programa Java que compruebe si una ruta de archivo es absoluta o
    //relativa y si existe.
    public static void exiteRuta(String ruta){
        Path path = Paths.get(ruta);
        System.out.println("Absoluta: " + path.isAbsolute());
        System.out.println("Relativa: " + !path.isAbsolute());
        System.out.println("Existe: " + Files.exists(path));
    }

    //Escribe un programa Java que copie un archivo en otro, sustituyéndolo si existe, y
    //lo mueva un archivo de una ubicación en otra, empleando Files.
    public static void copiar(String archivo, String copia) throws IOException {
        Path origen = Paths.get(archivo);
        Path destino = Paths.get(copia);
        Files.copy(origen,destino, StandardCopyOption.REPLACE_EXISTING);
    }

    //Crea un programa Java que recoja una ruta de archivo como entrada del usuario
    //(con JFileChooser) y muestre el nombre del archivo y su extensión en una ventana
    //emergente (JOptionPane). Crea un Path y recupera la posición a partir del nombre
    //del archivo (emplea el método lastIndexOf).
    public static void extension(){
        String ruta = JOptionPane.showInputDialog("Ruta del archivo:");
        Path path = Paths.get(ruta);
        String fileName = String.valueOf(path.getFileName());
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1);
        if (extension.equals(fileName))
            extension = "null";
        JOptionPane.showMessageDialog(null, "Archivo: " + fileName + "\nExtensión: " + extension);
    }
}
