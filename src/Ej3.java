import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.err;
import static java.lang.System.out;

public class Ej3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        JFileChooser fc;

        int botonPulsado = 0;
        int opc = 4;
        boolean salir = false;
        while(!salir) {
            opc = sc.nextInt();
            switch (opc) {
                case 0: //Crear Directorio ¿o Arquivo?
                    fc = new JFileChooser();

                    break;
                case 1: //Listar Arquivos y Subdirectorios con *Recursividade*
                    fc = new JFileChooser();
                    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    botonPulsado = fc.showOpenDialog(null);

                    if (botonPulsado == JFileChooser.APPROVE_OPTION) {
                        File[] fList = fc.getSelectedFile().listFiles();
                        Stack<File> pila.addAll(flist);
                        out.println(listarArchivos(new StringBuilder(),fc.getSelectedFile()));
                    }
                    break;
                case 2: //Eliminar Arquivo o Directorio
                    fc = new JFileChooser();
                    botonPulsado = fc.showOpenDialog(null);

                    if (botonPulsado == JFileChooser.APPROVE_OPTION) {
                        out.println(eliminar(fc.getSelectedFile()) ? "Eliminación Completada" : "ERROR");
                    }
                    break;
                case 3: //Mover o Renombrar Arquivo o Directorio

                    break;
                case 4: //Salir bucle
                    salir = true;
                    break;
                default: //Default
                    err.println("Numero equivocado");
                    break;
            }
        }
    }

    public static  boolean crearDirectorio(File f) {
        return f.mkdir();
    }

    public static String listarArchivos(StringBuilder sb, File f){
        File[] fList = f.listFiles();
        for(File fl : fList){
            sb.append("\nFile: ").append(fl.getName())
                    .append("\nTamaño: ").append(fl.length())
                    .append(fl.isDirectory() ? "\nDirectorio" : "\nFichero")
                    .append("\n----------------------------------\n");
        }
        return sb.toString();
    }

    public static String listarArchivosRecursivo(StringBuilder sb, Stack<File> pila){
        if (!pila.isEmpty()){
            File f = pila.pop();
            sb.append("\nFile: ").append(f.getName())
                    .append("\nTamaño: ").append(f.length())
                    .append(f.isDirectory() ? "\nDirectorio" : "\nFichero")
                    .append("\n----------------------------------\n");
            return listarArchivosRecursivo(sb,pila);
        }
        return "";
    }

    public static boolean eliminar(File f){
        return f.delete();
    }
}
