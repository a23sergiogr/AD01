import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.err;
import static java.lang.System.out;

public class Ej01_01_03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        JFileChooser fc = new JFileChooser();
        JFileChooser creator;

        int botonPulsado = 0;
        int opc = 4;
        boolean salir = false;
        while(!salir) {
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 0: //Crear Directorio ¿o Arquivo?
                    //fc = new JFileChooser();
                    fc.showSaveDialog(null);
                    out.println(crearDirectorio(fc.getSelectedFile())? "Carpeta Creada" : "ERROR");
                    break;

                case 1: //Listar Arquivos y Subdirectorios con *Recursividade*
                    //fc = new JFileChooser();
                    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    botonPulsado = fc.showOpenDialog(null);

                    if (botonPulsado == JFileChooser.APPROVE_OPTION) {
                        File[] fList = fc.getSelectedFile().listFiles();
                        Stack<File> stack = new Stack<>();
                        if (fList != null) {
                            for (File f : fList)
                                stack.push(f);
                        }

                        System.out.println(listarArchivosRecursivo(new StringBuilder(),stack));
                    }
                    break;

                case 2: //Eliminar Arquivo o Directorio
                    //fc = new JFileChooser();
                    boolean arquivo = sc.nextBoolean();
                    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    if (!arquivo){
                        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    }
                    botonPulsado = fc.showOpenDialog(null);
                    if (botonPulsado == JFileChooser.APPROVE_OPTION) {
                        out.println(eliminar(fc.getSelectedFile()) ? "Eliminación Completada" : "ERROR");
                    }
                    break;

                case 3: //Mover o Renombrar Arquivo o Directorio
                    //fc = new JFileChooser();
                    botonPulsado = fc.showOpenDialog(null);
                    if (botonPulsado == JFileChooser.APPROVE_OPTION) {
                        File archivoOriginal = fc.getSelectedFile();
                        out.println("Selecciona el nuevo nombre y ubicación del archivo o directorio:");

                        creator = new JFileChooser();
                        creator.setSelectedFile(new File(archivoOriginal.getParent(), "nuevoNombre")); // Sugerir nuevo nombre en el mismo directorio
                        botonPulsado = creator.showSaveDialog(null);

                        if (botonPulsado == JFileChooser.APPROVE_OPTION) {
                            File archivoRenombrado = creator.getSelectedFile();

                            if (archivoOriginal.renameTo(archivoRenombrado)) {
                                out.println("Renombrado exitoso a: " + archivoRenombrado.getName());
                            } else {
                                out.println("ERROR al renombrar el archivo o directorio");
                            }
                        }
                    }

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

    public static  boolean crearArchivo(File f) {
        try {
            return f.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String listarArchivos(StringBuilder sb, File f){
        File[] fList = f.listFiles();
        if (fList != null) {
            for(File fl : fList){
                sb.append("\nFile: ").append(fl.getName())
                        .append("\nTamaño: ").append(fl.length())
                        .append(fl.isDirectory() ? "\nDirectorio" : "\nFichero")
                        .append("\n----------------------------------\n");
            }
        }
        return sb.toString();
    }

    public static String listarArchivosRecursivo(StringBuilder sb, Stack<File> pila){
        if (!pila.isEmpty()){
            out.println(pila.peek());
            File f = pila.pop();
            sb.append("\nFile: ").append(f.getName())
                    .append("\nTamaño: ").append(f.length())
                    .append(f.isDirectory() ? "\nDirectorio" : "\nFichero")
                    .append("\n----------------------------------\n");

            if (f.isDirectory()){
                File[] fList = f.listFiles();
                assert fList != null;
                for (File sf : fList)
                    pila.push(sf);
            }
            return listarArchivosRecursivo(sb,pila);
        }
        return sb.toString();
    }

    public static boolean eliminar(File f){
        return f.delete();
    }
}
