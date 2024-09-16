import javax.swing.*;
import java.io.File;

public class Ej2 {
    public static void main(String[] args) {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int botonPulsado = fc.showOpenDialog(null);

        if (botonPulsado == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();

            System.out.println("File: " + f.getName());
            System.out.println("Tamaño: " + f.length());

            File[] fList = f.listFiles();
            for(File fl : fList){
                System.out.println("File: " + fl.getName());
                System.out.println("Tamaño: " + fl.length());
                System.out.println(fl.isDirectory() ? "Directorio" : "Fichero");
                System.out.println("----------------------------------");
            }
        }
    }
}
