

//Modifica el programa CopiaArchivos para que copie el archivo otto.txt en un archivo nohaycole.txt
// en la carpeta src/main/resources de tu proyecto.
//
//Además, haz que el cierre de archivos se realice por medio de try-with-resources.

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ej01_04_01 {
    public static void main(String[] args){


        try ( FileInputStream in = new FileInputStream("prueba.txt");
              FileOutputStream out = new FileOutputStream("prueba2.txt")) {

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
