package Ejercicios_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Ej4_Listar_y_Copiar_Archivos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Path origen = Paths.get("carpetaPath");
        Path destino = Paths.get("destino");

        try {
            Files.copy(origen,destino);
        } catch (IOException e) {
            System.err.println("IOException copy");
        }

        if (Files.isDirectory(origen)){
            try {
                Files.list(origen).forEach(file -> {
                    try {
                        String nombre = file.toString();
                        String a = nombre.substring(nombre.lastIndexOf('\\'), nombre.lastIndexOf('.'));
                        System.out.println("Extension de: " + a);
                        String extension = sc.nextLine();
                        String newDestino = destino + a + "." + extension;
                        System.out.println("Nuevo destino: " + newDestino + "\n");
                        Files.copy(file, Paths.get(newDestino));
                    } catch (IOException e) {
                        System.err.println("IOException copy2: " + e);
                    }
                });
            } catch (IOException e) {
                System.err.println("IOException list");
            }
        }
    }
}
