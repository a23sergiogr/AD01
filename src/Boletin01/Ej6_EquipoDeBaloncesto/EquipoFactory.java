package Boletin01.Ej6_EquipoDeBaloncesto;

import java.io.File;
import java.io.IOException;

//Implementar
public class EquipoFactory {
    private static String RUTA_FILE = "Equipos.txt";
    public static EquipoObjectStreamDao getEquipo(){
        File f = new File(RUTA_FILE);
        if (!f.exists()) {
            try {
                System.out.println(f.createNewFile());
            } catch (IOException e) {
                System.err.println("No se pudo crear el Archivo");
            }
        }
        return new EquipoObjectStreamDao();
    }
}
