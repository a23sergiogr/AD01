package Ejercicios;

import javax.swing.*;
import java.io.File;
import java.util.Date;

public class Ej01_01_01 {
    public static void main(String[] args) {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int botonPulsado = fc.showOpenDialog(null);

        if (botonPulsado == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            if (f.exists()){
                StringBuilder sb = new StringBuilder();
                sb.append("Absolute Path:").append(f.getAbsoluteFile())
                        .append("\nNome: ").append(f.getName())
                        .append("\nTamaño: ").append(f.length()).append("bytes")
                        .append("\nUltima modificación: ").append(new Date(f.lastModified()))
                        .append(f.isDirectory() ? "Directorio" : "Archivo");

                JOptionPane.showMessageDialog(null, sb.toString());
            }
        }
    }
}
