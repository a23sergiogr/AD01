package Ejercicios_02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/*
    Escribid un programa en Java que, empleando las clases de Java NIO 2, liste los
    archivos de un directorio por medio del método list(). Debe mostrar sólo los
    archivos fuente Java, no los directorios que contiene. Recuerda el uso de filtros en
    Stream y de forEach.

    Haz el mismo ejercicio con el método list() de File y compara el tiempo de
    ejecución en cada caso.
*/
public class Ej3_Contenido_de_un_Directorio_con_List {
    public static final String RUTA = "C:\\Users\\a23sergiogr\\Desktop\\AD";
    public static void main(String[] args) throws IOException {
        long startTimePath = System.nanoTime();
        listaA();
        long endTimePath = System.nanoTime() - startTimePath;
        System.out.println("------------------------------");
        long startTimeFile = System.nanoTime();
        listaB();
        long endTimeFile = System.nanoTime() - startTimePath;

        System.out.println("------------------------------");
        System.out.println("Path Time: " + endTimePath);
        System.out.println("File Time: " + endTimeFile);
        System.out.println("Path Duración: " + (endTimePath)/1e6 + " ms");
        System.out.println("File Duración: " + (endTimeFile)/1e6 + " ms");
    }

    public static void listaA() throws IOException {
        Path p = Paths.get(RUTA);
        System.out.println(p.toString());
        Files.list(p).filter(file -> !Files.isDirectory(file));//.forEach(file -> System.out.println(file.getFileName()));
    }

    public static void listaB() throws IOException {
        File f = new File(RUTA);
        File[] files = f.listFiles();
//        for (File fl : files){
//            if (!fl.isDirectory())
//                System.out.println(fl.getName());
//        }
    }
}
