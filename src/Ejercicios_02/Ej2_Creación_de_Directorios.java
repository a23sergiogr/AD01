package Ejercicios_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ej2_Creación_de_Directorios {

    //Escribir un programa en Java que, empleando las clases de Java NIO 2 Path y
    //File, cree un directorio (con toda la tura) y un archivo vacío dentro de ese directorio.
    public static final String RUTA_DIRECTORIO = "C:\\Users\\a23sergiogr\\Desktop\\AD\\carpetaPath";
    public static final String NOME_ARQUIVO = "creadoConPath.txt";

    public static void main(String[] args) {
        Path path = Paths.get(RUTA_DIRECTORIO);
        try {
            Files.createDirectory(path);
        } catch (Exception e) {
            System.err.println(e);
        }
        if ( Files.isDirectory(path) && Files.exists(path)){
            Path archivo = Paths.get(RUTA_DIRECTORIO+"\\"+NOME_ARQUIVO);
            try {
                Files.createFile(archivo);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
